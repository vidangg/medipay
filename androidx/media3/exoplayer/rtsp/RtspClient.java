package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.rtsp.RtspClient;
import androidx.media3.exoplayer.rtsp.RtspHeaders;
import androidx.media3.exoplayer.rtsp.RtspMediaPeriod;
import androidx.media3.exoplayer.rtsp.RtspMediaSource;
import androidx.media3.exoplayer.rtsp.RtspMessageChannel;
import androidx.media3.exoplayer.rtsp.RtspMessageUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RtspClient implements Closeable {
    private static final int DEFAULT_RTSP_KEEP_ALIVE_INTERVAL_DIVISOR = 2;
    public static final int RTSP_STATE_INIT = 0;
    public static final int RTSP_STATE_PLAYING = 2;
    public static final int RTSP_STATE_READY = 1;
    public static final int RTSP_STATE_UNINITIALIZED = -1;
    private static final String TAG = "RtspClient";
    private final boolean debugLoggingEnabled;
    private boolean hasPendingPauseRequest;
    private boolean hasUpdatedTimelineAndTracks;
    private KeepAliveMonitor keepAliveMonitor;
    private final PlaybackEventListener playbackEventListener;
    private boolean receivedAuthorizationRequest;
    private RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo;
    private RtspAuthenticationInfo rtspAuthenticationInfo;
    private String sessionId;
    private final SessionInfoListener sessionInfoListener;
    private final SocketFactory socketFactory;
    private Uri uri;
    private final String userAgent;
    private final ArrayDeque<RtspMediaPeriod.RtpLoadInfo> pendingSetupRtpLoadInfos = new ArrayDeque<>();
    private final SparseArray<RtspRequest> pendingRequests = new SparseArray<>();
    private final MessageSender messageSender = new MessageSender();
    private RtspMessageChannel messageChannel = new RtspMessageChannel(new MessageListener());
    private long sessionTimeoutMs = 60000;
    private long pendingSeekPositionUs = C.TIME_UNSET;
    private int rtspState = -1;

    /* loaded from: classes.dex */
    public interface PlaybackEventListener {
        void onPlaybackError(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void onPlaybackStarted(long j, ImmutableList<RtspTrackTiming> immutableList);

        void onRtspSetupCompleted();
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RtspState {
    }

    /* loaded from: classes.dex */
    public interface SessionInfoListener {
        void onSessionTimelineRequestFailed(String str, Throwable th);

        void onSessionTimelineUpdated(RtspSessionTiming rtspSessionTiming, ImmutableList<RtspMediaTrack> immutableList);
    }

    public RtspClient(SessionInfoListener sessionInfoListener, PlaybackEventListener playbackEventListener, String str, Uri uri, SocketFactory socketFactory, boolean z) {
        this.sessionInfoListener = sessionInfoListener;
        this.playbackEventListener = playbackEventListener;
        this.userAgent = str;
        this.socketFactory = socketFactory;
        this.debugLoggingEnabled = z;
        this.uri = RtspMessageUtil.removeUserInfo(uri);
        this.rtspAuthUserInfo = RtspMessageUtil.parseUserInfo(uri);
    }

    public void start() throws IOException {
        try {
            this.messageChannel.open(getSocket(this.uri));
            this.messageSender.sendOptionsRequest(this.uri, this.sessionId);
        } catch (IOException e) {
            Util.closeQuietly(this.messageChannel);
            throw e;
        }
    }

    public int getState() {
        return this.rtspState;
    }

    public void setupSelectedTracks(List<RtspMediaPeriod.RtpLoadInfo> list) {
        this.pendingSetupRtpLoadInfos.addAll(list);
        continueSetupRtspTrack();
    }

    public void startPlayback(long j) {
        this.messageSender.sendPlayRequest(this.uri, j, (String) Assertions.checkNotNull(this.sessionId));
    }

    public void signalPlaybackEnded() {
        this.rtspState = 1;
    }

    public void seekToUs(long j) {
        if (this.rtspState == 2 && !this.hasPendingPauseRequest) {
            this.messageSender.sendPauseRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        }
        this.pendingSeekPositionUs = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        KeepAliveMonitor keepAliveMonitor = this.keepAliveMonitor;
        if (keepAliveMonitor != null) {
            keepAliveMonitor.close();
            this.keepAliveMonitor = null;
            this.messageSender.sendTeardownRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        }
        this.messageChannel.close();
    }

    public void retryWithRtpTcp() {
        try {
            close();
            RtspMessageChannel rtspMessageChannel = new RtspMessageChannel(new MessageListener());
            this.messageChannel = rtspMessageChannel;
            rtspMessageChannel.open(getSocket(this.uri));
            this.sessionId = null;
            this.receivedAuthorizationRequest = false;
            this.rtspAuthenticationInfo = null;
        } catch (IOException e) {
            this.playbackEventListener.onPlaybackError(new RtspMediaSource.RtspPlaybackException(e));
        }
    }

    public void registerInterleavedDataChannel(int i, RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.messageChannel.registerInterleavedBinaryDataListener(i, interleavedBinaryDataListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueSetupRtspTrack() {
        RtspMediaPeriod.RtpLoadInfo pollFirst = this.pendingSetupRtpLoadInfos.pollFirst();
        if (pollFirst == null) {
            this.playbackEventListener.onRtspSetupCompleted();
        } else {
            this.messageSender.sendSetupRequest(pollFirst.getTrackUri(), pollFirst.getTransport(), this.sessionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeLogMessage(List<String> list) {
        if (this.debugLoggingEnabled) {
            Log.d(TAG, Joiner.on(IOUtils.LINE_SEPARATOR_UNIX).join(list));
        }
    }

    private Socket getSocket(Uri uri) throws IOException {
        Assertions.checkArgument(uri.getHost() != null);
        return this.socketFactory.createSocket((String) Assertions.checkNotNull(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : RtspMessageChannel.DEFAULT_RTSP_PORT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRtspError(Throwable th) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException;
        if (th instanceof RtspMediaSource.RtspPlaybackException) {
            rtspPlaybackException = (RtspMediaSource.RtspPlaybackException) th;
        } else {
            rtspPlaybackException = new RtspMediaSource.RtspPlaybackException(th);
        }
        if (this.hasUpdatedTimelineAndTracks) {
            this.playbackEventListener.onPlaybackError(rtspPlaybackException);
        } else {
            this.sessionInfoListener.onSessionTimelineRequestFailed(Strings.nullToEmpty(th.getMessage()), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean serverSupportsDescribe(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList<RtspMediaTrack> buildTrackList(RtspDescribeResponse rtspDescribeResponse, Uri uri) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < rtspDescribeResponse.sessionDescription.mediaDescriptionList.size(); i++) {
            MediaDescription mediaDescription = rtspDescribeResponse.sessionDescription.mediaDescriptionList.get(i);
            if (RtpPayloadFormat.isFormatSupported(mediaDescription)) {
                builder.add((ImmutableList.Builder) new RtspMediaTrack(rtspDescribeResponse.headers, mediaDescription, uri));
            }
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class MessageSender {
        private int cSeq;
        private RtspRequest lastRequest;

        private MessageSender() {
        }

        public void sendOptionsRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(4, str, ImmutableMap.of(), uri));
        }

        public void sendDescribeRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(2, str, ImmutableMap.of(), uri));
        }

        public void sendSetupRequest(Uri uri, String str, String str2) {
            RtspClient.this.rtspState = 0;
            sendRequest(getRequestWithCommonHeaders(10, str2, ImmutableMap.of(RtspHeaders.TRANSPORT, str), uri));
        }

        public void sendPlayRequest(Uri uri, long j, String str) {
            boolean z = true;
            if (RtspClient.this.rtspState != 1 && RtspClient.this.rtspState != 2) {
                z = false;
            }
            Assertions.checkState(z);
            sendRequest(getRequestWithCommonHeaders(6, str, ImmutableMap.of("Range", RtspSessionTiming.getOffsetStartTimeTiming(j)), uri));
        }

        public void sendTeardownRequest(Uri uri, String str) {
            if (RtspClient.this.rtspState == -1 || RtspClient.this.rtspState == 0) {
                return;
            }
            RtspClient.this.rtspState = 0;
            sendRequest(getRequestWithCommonHeaders(12, str, ImmutableMap.of(), uri));
        }

        public void sendPauseRequest(Uri uri, String str) {
            Assertions.checkState(RtspClient.this.rtspState == 2);
            sendRequest(getRequestWithCommonHeaders(5, str, ImmutableMap.of(), uri));
            RtspClient.this.hasPendingPauseRequest = true;
        }

        public void retryLastRequest() {
            Assertions.checkStateNotNull(this.lastRequest);
            ImmutableListMultimap<String, String> asMultiMap = this.lastRequest.headers.asMultiMap();
            HashMap hashMap = new HashMap();
            for (String str : asMultiMap.keySet()) {
                if (!str.equals(RtspHeaders.CSEQ) && !str.equals("User-Agent") && !str.equals(RtspHeaders.SESSION) && !str.equals("Authorization")) {
                    hashMap.put(str, (String) Iterables.getLast(asMultiMap.get((ImmutableListMultimap<String, String>) str)));
                }
            }
            sendRequest(getRequestWithCommonHeaders(this.lastRequest.method, RtspClient.this.sessionId, hashMap, this.lastRequest.uri));
        }

        public void sendMethodNotAllowedResponse(int i) {
            sendResponse(new RtspResponse(405, new RtspHeaders.Builder(RtspClient.this.userAgent, RtspClient.this.sessionId, i).build()));
            this.cSeq = Math.max(this.cSeq, i + 1);
        }

        private RtspRequest getRequestWithCommonHeaders(int i, String str, Map<String, String> map, Uri uri) {
            String str2 = RtspClient.this.userAgent;
            int i2 = this.cSeq;
            this.cSeq = i2 + 1;
            RtspHeaders.Builder builder = new RtspHeaders.Builder(str2, str, i2);
            if (RtspClient.this.rtspAuthenticationInfo != null) {
                Assertions.checkStateNotNull(RtspClient.this.rtspAuthUserInfo);
                try {
                    builder.add("Authorization", RtspClient.this.rtspAuthenticationInfo.getAuthorizationHeaderValue(RtspClient.this.rtspAuthUserInfo, uri, i));
                } catch (ParserException e) {
                    RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(e));
                }
            }
            builder.addAll(map);
            return new RtspRequest(uri, i, builder.build(), "");
        }

        private void sendRequest(RtspRequest rtspRequest) {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(rtspRequest.headers.get(RtspHeaders.CSEQ)));
            Assertions.checkState(RtspClient.this.pendingRequests.get(parseInt) == null);
            RtspClient.this.pendingRequests.append(parseInt, rtspRequest);
            ImmutableList<String> serializeRequest = RtspMessageUtil.serializeRequest(rtspRequest);
            RtspClient.this.maybeLogMessage(serializeRequest);
            RtspClient.this.messageChannel.send(serializeRequest);
            this.lastRequest = rtspRequest;
        }

        private void sendResponse(RtspResponse rtspResponse) {
            ImmutableList<String> serializeResponse = RtspMessageUtil.serializeResponse(rtspResponse);
            RtspClient.this.maybeLogMessage(serializeResponse);
            RtspClient.this.messageChannel.send(serializeResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class MessageListener implements RtspMessageChannel.MessageListener {
        private final Handler messageHandler = Util.createHandlerForCurrentLooper();

        public MessageListener() {
        }

        @Override // androidx.media3.exoplayer.rtsp.RtspMessageChannel.MessageListener
        public void onRtspMessageReceived(final List<String> list) {
            this.messageHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.rtsp.RtspClient$MessageListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RtspClient.MessageListener.this.m493x5ebb245a(list);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: handleRtspMessage, reason: merged with bridge method [inline-methods] */
        public void m493x5ebb245a(List<String> list) {
            RtspClient.this.maybeLogMessage(list);
            if (RtspMessageUtil.isRtspResponse(list)) {
                handleRtspResponse(list);
            } else {
                handleRtspRequest(list);
            }
        }

        private void handleRtspRequest(List<String> list) {
            RtspClient.this.messageSender.sendMethodNotAllowedResponse(Integer.parseInt((String) Assertions.checkNotNull(RtspMessageUtil.parseRequest(list).headers.get(RtspHeaders.CSEQ))));
        }

        private void handleRtspResponse(List<String> list) {
            RtspSessionTiming parseTiming;
            ImmutableList<RtspTrackTiming> of;
            Throwable rtspPlaybackException;
            RtspResponse parseResponse = RtspMessageUtil.parseResponse(list);
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(parseResponse.headers.get(RtspHeaders.CSEQ)));
            RtspRequest rtspRequest = (RtspRequest) RtspClient.this.pendingRequests.get(parseInt);
            if (rtspRequest == null) {
                return;
            }
            RtspClient.this.pendingRequests.remove(parseInt);
            int i = rtspRequest.method;
            try {
                try {
                    int i2 = parseResponse.status;
                    if (i2 == 200) {
                        switch (i) {
                            case 1:
                            case 3:
                            case 7:
                            case 8:
                            case 9:
                            case 11:
                            case 12:
                                return;
                            case 2:
                                onDescribeResponseReceived(new RtspDescribeResponse(parseResponse.headers, parseResponse.status, SessionDescriptionParser.parse(parseResponse.messageBody)));
                                return;
                            case 4:
                                onOptionsResponseReceived(new RtspOptionsResponse(parseResponse.status, RtspMessageUtil.parsePublicHeader(parseResponse.headers.get(RtspHeaders.PUBLIC))));
                                return;
                            case 5:
                                onPauseResponseReceived();
                                return;
                            case 6:
                                String str = parseResponse.headers.get("Range");
                                if (str == null) {
                                    parseTiming = RtspSessionTiming.DEFAULT;
                                } else {
                                    parseTiming = RtspSessionTiming.parseTiming(str);
                                }
                                try {
                                    String str2 = parseResponse.headers.get(RtspHeaders.RTP_INFO);
                                    if (str2 != null) {
                                        of = RtspTrackTiming.parseTrackTiming(str2, RtspClient.this.uri);
                                    } else {
                                        of = ImmutableList.of();
                                    }
                                } catch (ParserException unused) {
                                    of = ImmutableList.of();
                                }
                                onPlayResponseReceived(new RtspPlayResponse(parseResponse.status, parseTiming, of));
                                return;
                            case 10:
                                String str3 = parseResponse.headers.get(RtspHeaders.SESSION);
                                String str4 = parseResponse.headers.get(RtspHeaders.TRANSPORT);
                                if (str3 == null || str4 == null) {
                                    throw ParserException.createForMalformedManifest("Missing mandatory session or transport header", null);
                                }
                                onSetupResponseReceived(new RtspSetupResponse(parseResponse.status, RtspMessageUtil.parseSessionHeader(str3), str4));
                                return;
                            default:
                                throw new IllegalStateException();
                        }
                    }
                    if (i2 == 401) {
                        if (RtspClient.this.rtspAuthUserInfo != null && !RtspClient.this.receivedAuthorizationRequest) {
                            ImmutableList<String> values = parseResponse.headers.values("WWW-Authenticate");
                            if (values.isEmpty()) {
                                throw ParserException.createForMalformedManifest("Missing WWW-Authenticate header in a 401 response.", null);
                            }
                            for (int i3 = 0; i3 < values.size(); i3++) {
                                RtspClient.this.rtspAuthenticationInfo = RtspMessageUtil.parseWwwAuthenticateHeader(values.get(i3));
                                if (RtspClient.this.rtspAuthenticationInfo.authenticationMechanism == 2) {
                                    break;
                                }
                            }
                            RtspClient.this.messageSender.retryLastRequest();
                            RtspClient.this.receivedAuthorizationRequest = true;
                            return;
                        }
                        RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(RtspMessageUtil.toMethodString(i) + " " + parseResponse.status));
                        return;
                    }
                    if (i2 == 461) {
                        String str5 = RtspMessageUtil.toMethodString(i) + " " + parseResponse.status;
                        String str6 = (String) Assertions.checkNotNull(rtspRequest.headers.get(RtspHeaders.TRANSPORT));
                        RtspClient rtspClient = RtspClient.this;
                        if (i == 10 && !str6.contains("TCP")) {
                            rtspPlaybackException = new RtspMediaSource.RtspUdpUnsupportedTransportException(str5);
                        } else {
                            rtspPlaybackException = new RtspMediaSource.RtspPlaybackException(str5);
                        }
                        rtspClient.dispatchRtspError(rtspPlaybackException);
                        return;
                    }
                    if (i2 == 301 || i2 == 302) {
                        if (RtspClient.this.rtspState != -1) {
                            RtspClient.this.rtspState = 0;
                        }
                        String str7 = parseResponse.headers.get("Location");
                        if (str7 == null) {
                            RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("Redirection without new location.", null);
                            return;
                        }
                        Uri parse = Uri.parse(str7);
                        RtspClient.this.uri = RtspMessageUtil.removeUserInfo(parse);
                        RtspClient.this.rtspAuthUserInfo = RtspMessageUtil.parseUserInfo(parse);
                        RtspClient.this.messageSender.sendDescribeRequest(RtspClient.this.uri, RtspClient.this.sessionId);
                        return;
                    }
                    RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(RtspMessageUtil.toMethodString(i) + " " + parseResponse.status));
                } catch (ParserException e) {
                    e = e;
                    RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(e));
                }
            } catch (IllegalArgumentException e2) {
                e = e2;
                RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(e));
            }
        }

        private void onOptionsResponseReceived(RtspOptionsResponse rtspOptionsResponse) {
            if (RtspClient.this.keepAliveMonitor != null) {
                return;
            }
            if (RtspClient.serverSupportsDescribe(rtspOptionsResponse.supportedMethods)) {
                RtspClient.this.messageSender.sendDescribeRequest(RtspClient.this.uri, RtspClient.this.sessionId);
            } else {
                RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("DESCRIBE not supported.", null);
            }
        }

        private void onDescribeResponseReceived(RtspDescribeResponse rtspDescribeResponse) {
            RtspSessionTiming rtspSessionTiming = RtspSessionTiming.DEFAULT;
            String str = rtspDescribeResponse.sessionDescription.attributes.get(SessionDescription.ATTR_RANGE);
            if (str != null) {
                try {
                    rtspSessionTiming = RtspSessionTiming.parseTiming(str);
                } catch (ParserException e) {
                    RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("SDP format error.", e);
                    return;
                }
            }
            ImmutableList<RtspMediaTrack> buildTrackList = RtspClient.buildTrackList(rtspDescribeResponse, RtspClient.this.uri);
            if (buildTrackList.isEmpty()) {
                RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("No playable track.", null);
            } else {
                RtspClient.this.sessionInfoListener.onSessionTimelineUpdated(rtspSessionTiming, buildTrackList);
                RtspClient.this.hasUpdatedTimelineAndTracks = true;
            }
        }

        private void onSetupResponseReceived(RtspSetupResponse rtspSetupResponse) {
            Assertions.checkState(RtspClient.this.rtspState != -1);
            RtspClient.this.rtspState = 1;
            RtspClient.this.sessionId = rtspSetupResponse.sessionHeader.sessionId;
            RtspClient.this.sessionTimeoutMs = rtspSetupResponse.sessionHeader.timeoutMs;
            RtspClient.this.continueSetupRtspTrack();
        }

        private void onPlayResponseReceived(RtspPlayResponse rtspPlayResponse) {
            boolean z = true;
            if (RtspClient.this.rtspState != 1 && RtspClient.this.rtspState != 2) {
                z = false;
            }
            Assertions.checkState(z);
            RtspClient.this.rtspState = 2;
            if (RtspClient.this.keepAliveMonitor == null) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.keepAliveMonitor = new KeepAliveMonitor(rtspClient.sessionTimeoutMs / 2);
                RtspClient.this.keepAliveMonitor.start();
            }
            RtspClient.this.pendingSeekPositionUs = C.TIME_UNSET;
            RtspClient.this.playbackEventListener.onPlaybackStarted(Util.msToUs(rtspPlayResponse.sessionTiming.startTimeMs), rtspPlayResponse.trackTimingList);
        }

        private void onPauseResponseReceived() {
            Assertions.checkState(RtspClient.this.rtspState == 2);
            RtspClient.this.rtspState = 1;
            RtspClient.this.hasPendingPauseRequest = false;
            if (RtspClient.this.pendingSeekPositionUs != C.TIME_UNSET) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.startPlayback(Util.usToMs(rtspClient.pendingSeekPositionUs));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class KeepAliveMonitor implements Runnable, Closeable {
        private final long intervalMs;
        private boolean isStarted;
        private final Handler keepAliveHandler = Util.createHandlerForCurrentLooper();

        public KeepAliveMonitor(long j) {
            this.intervalMs = j;
        }

        public void start() {
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        @Override // java.lang.Runnable
        public void run() {
            RtspClient.this.messageSender.sendOptionsRequest(RtspClient.this.uri, RtspClient.this.sessionId);
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.isStarted = false;
            this.keepAliveHandler.removeCallbacks(this);
        }
    }
}
