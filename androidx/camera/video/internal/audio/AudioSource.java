package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.AudioStats;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.encoder.InputBuffer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class AudioSource {
    static final long DEFAULT_START_RETRY_INTERVAL_MS = 3000;
    private static final String TAG = "AudioSource";
    private FutureCallback<InputBuffer> mAcquireBufferCallback;
    long mAmplitudeTimestamp;
    double mAudioAmplitude;
    private final int mAudioFormat;
    AudioSourceCallback mAudioSourceCallback;
    final AudioStream mAudioStream;
    boolean mAudioStreamSilenced;
    BufferProvider<? extends InputBuffer> mBufferProvider;
    BufferProvider.State mBufferProviderState;
    Executor mCallbackExecutor;
    final Executor mExecutor;
    boolean mInSilentStartState;
    boolean mIsSendingAudio;
    private long mLatestFailedStartTimeNs;
    boolean mMuted;
    final AtomicReference<Boolean> mNotifiedSilenceState;
    final AtomicBoolean mNotifiedSuspendState;
    final SilentAudioStream mSilentAudioStream;
    private final long mStartRetryIntervalNs;
    InternalState mState;
    private Observable.Observer<BufferProvider.State> mStateObserver;
    private byte[] mZeroBytes;

    /* loaded from: classes.dex */
    public interface AudioSourceCallback {
        void onAmplitudeValue(double d);

        void onError(Throwable th);

        void onSilenceStateChanged(boolean z);

        default void onSuspendStateChanged(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    public AudioSource(AudioSettings audioSettings, Executor executor, Context context) throws AudioSourceAccessException {
        this(audioSettings, executor, context, new AudioStreamFactory() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda3
            @Override // androidx.camera.video.internal.audio.AudioStreamFactory
            public final AudioStream create(AudioSettings audioSettings2, Context context2) {
                return new AudioStreamImpl(audioSettings2, context2);
            }
        }, 3000L);
    }

    AudioSource(AudioSettings audioSettings, Executor executor, Context context, AudioStreamFactory audioStreamFactory, long j) throws AudioSourceAccessException {
        this.mNotifiedSilenceState = new AtomicReference<>(null);
        this.mNotifiedSuspendState = new AtomicBoolean(false);
        this.mState = InternalState.CONFIGURED;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        this.mAmplitudeTimestamp = 0L;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = newSequentialExecutor;
        this.mStartRetryIntervalNs = TimeUnit.MILLISECONDS.toNanos(j);
        try {
            BufferedAudioStream bufferedAudioStream = new BufferedAudioStream(audioStreamFactory.create(audioSettings, context), audioSettings);
            this.mAudioStream = bufferedAudioStream;
            bufferedAudioStream.setCallback(new AudioStreamCallback(), newSequentialExecutor);
            this.mSilentAudioStream = new SilentAudioStream(audioSettings);
            this.mAudioFormat = audioSettings.getAudioFormat();
        } catch (AudioStream.AudioStreamException | IllegalArgumentException e) {
            throw new AudioSourceAccessException("Unable to create AudioStream", e);
        }
    }

    /* loaded from: classes.dex */
    class AudioStreamCallback implements AudioStream.AudioStreamCallback {
        AudioStreamCallback() {
        }

        @Override // androidx.camera.video.internal.audio.AudioStream.AudioStreamCallback
        public void onSilenceStateChanged(boolean z) {
            AudioSource.this.mAudioStreamSilenced = z;
            if (AudioSource.this.mState == InternalState.STARTED) {
                AudioSource.this.notifySilenced();
            }
        }
    }

    public void setBufferProvider(final BufferProvider<? extends InputBuffer> bufferProvider) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.this.m257x885db6e2(bufferProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setBufferProvider$0$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m257x885db6e2(BufferProvider bufferProvider) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                throw new AssertionError("AudioSource is released");
            }
        } else if (this.mBufferProvider != bufferProvider) {
            resetBufferProvider(bufferProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$1$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m258lambda$start$1$androidxcameravideointernalaudioAudioSource() {
        start(this.mMuted);
    }

    public void start() {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.this.m258lambda$start$1$androidxcameravideointernalaudioAudioSource();
            }
        });
    }

    public void start(final boolean z) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.this.m259lambda$start$2$androidxcameravideointernalaudioAudioSource(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$2$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m259lambda$start$2$androidxcameravideointernalaudioAudioSource(boolean z) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i != 1) {
            if (i == 3) {
                throw new AssertionError("AudioSource is released");
            }
            return;
        }
        this.mNotifiedSilenceState.set(null);
        this.mNotifiedSuspendState.set(false);
        setState(InternalState.STARTED);
        mute(z);
        updateSendingAudio();
    }

    public void stop() {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.this.m260lambda$stop$3$androidxcameravideointernalaudioAudioSource();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$stop$3$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m260lambda$stop$3$androidxcameravideointernalaudioAudioSource() {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i == 2) {
            setState(InternalState.CONFIGURED);
            updateSendingAudio();
        } else {
            if (i != 3) {
                return;
            }
            Logger.w(TAG, "AudioSource is released. Calling stop() is a no-op.");
        }
    }

    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda5
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return AudioSource.this.m255xa561a489(completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$5$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ Object m255xa561a489(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.this.m254xb3b7fe6a(completer);
            }
        });
        return "AudioSource-release";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$4$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m254xb3b7fe6a(CallbackToFutureAdapter.Completer completer) {
        try {
            int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
            if (i == 1 || i == 2) {
                resetBufferProvider(null);
                this.mSilentAudioStream.release();
                this.mAudioStream.release();
                stopSendingAudio();
                setState(InternalState.RELEASED);
            }
            completer.set(null);
        } catch (Throwable th) {
            completer.setException(th);
        }
    }

    public void setAudioSourceCallback(final Executor executor, final AudioSourceCallback audioSourceCallback) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.this.m256xcbe526c1(executor, audioSourceCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setAudioSourceCallback$6$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m256xcbe526c1(Executor executor, AudioSourceCallback audioSourceCallback) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i == 1) {
            this.mCallbackExecutor = executor;
            this.mAudioSourceCallback = audioSourceCallback;
        } else if (i == 2 || i == 3) {
            throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
        }
    }

    /* renamed from: androidx.camera.video.internal.audio.AudioSource$3, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState;

        static {
            int[] iArr = new int[InternalState.values().length];
            $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState = iArr;
            try {
                iArr[InternalState.CONFIGURED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[InternalState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[InternalState.RELEASED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void mute(final boolean z) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.this.m252lambda$mute$7$androidxcameravideointernalaudioAudioSource(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$mute$7$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m252lambda$mute$7$androidxcameravideointernalaudioAudioSource(boolean z) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                throw new AssertionError("AudioSource is released");
            }
        } else {
            if (this.mMuted == z) {
                return;
            }
            this.mMuted = z;
            if (this.mState == InternalState.STARTED) {
                notifySilenced();
            }
        }
    }

    private void resetBufferProvider(final BufferProvider<? extends InputBuffer> bufferProvider) {
        BufferProvider<? extends InputBuffer> bufferProvider2 = this.mBufferProvider;
        if (bufferProvider2 != null) {
            bufferProvider2.removeObserver((Observable.Observer) Objects.requireNonNull(this.mStateObserver));
            this.mBufferProvider = null;
            this.mStateObserver = null;
            this.mAcquireBufferCallback = null;
            this.mBufferProviderState = BufferProvider.State.INACTIVE;
            updateSendingAudio();
        }
        if (bufferProvider != null) {
            this.mBufferProvider = bufferProvider;
            this.mStateObserver = new Observable.Observer<BufferProvider.State>() { // from class: androidx.camera.video.internal.audio.AudioSource.1
                @Override // androidx.camera.core.impl.Observable.Observer
                public void onNewData(BufferProvider.State state) {
                    Objects.requireNonNull(state);
                    if (AudioSource.this.mBufferProvider == bufferProvider) {
                        Logger.d(AudioSource.TAG, "Receive BufferProvider state change: " + AudioSource.this.mBufferProviderState + " to " + state);
                        if (AudioSource.this.mBufferProviderState != state) {
                            AudioSource.this.mBufferProviderState = state;
                            AudioSource.this.updateSendingAudio();
                        }
                    }
                }

                @Override // androidx.camera.core.impl.Observable.Observer
                public void onError(Throwable th) {
                    if (AudioSource.this.mBufferProvider == bufferProvider) {
                        AudioSource.this.notifyError(th);
                    }
                }
            };
            this.mAcquireBufferCallback = new FutureCallback<InputBuffer>() { // from class: androidx.camera.video.internal.audio.AudioSource.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(InputBuffer inputBuffer) {
                    if (!AudioSource.this.mIsSendingAudio || AudioSource.this.mBufferProvider != bufferProvider) {
                        inputBuffer.cancel();
                        return;
                    }
                    if (AudioSource.this.mInSilentStartState && AudioSource.this.isStartRetryIntervalReached()) {
                        AudioSource.this.retryStartAudioStream();
                    }
                    AudioStream currentAudioStream = AudioSource.this.getCurrentAudioStream();
                    ByteBuffer byteBuffer = inputBuffer.getByteBuffer();
                    AudioStream.PacketInfo read = currentAudioStream.read(byteBuffer);
                    if (read.getSizeInBytes() > 0) {
                        if (AudioSource.this.mMuted) {
                            AudioSource.this.overrideBySilence(byteBuffer, read.getSizeInBytes());
                        }
                        if (AudioSource.this.mCallbackExecutor != null && read.getTimestampNs() - AudioSource.this.mAmplitudeTimestamp >= 200) {
                            AudioSource.this.mAmplitudeTimestamp = read.getTimestampNs();
                            AudioSource.this.postMaxAmplitude(byteBuffer);
                        }
                        byteBuffer.limit(byteBuffer.position() + read.getSizeInBytes());
                        inputBuffer.setPresentationTimeUs(TimeUnit.NANOSECONDS.toMicros(read.getTimestampNs()));
                        inputBuffer.submit();
                    } else {
                        Logger.w(AudioSource.TAG, "Unable to read data from AudioStream.");
                        inputBuffer.cancel();
                    }
                    AudioSource.this.sendNextAudio();
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    if (AudioSource.this.mBufferProvider != bufferProvider) {
                        return;
                    }
                    Logger.d(AudioSource.TAG, "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
                    if (th instanceof IllegalStateException) {
                        return;
                    }
                    AudioSource.this.notifyError(th);
                }
            };
            BufferProvider.State fetchBufferProviderState = fetchBufferProviderState(bufferProvider);
            if (fetchBufferProviderState != null) {
                this.mBufferProviderState = fetchBufferProviderState;
                updateSendingAudio();
            }
            this.mBufferProvider.addObserver(this.mExecutor, this.mStateObserver);
        }
    }

    AudioStream getCurrentAudioStream() {
        return this.mInSilentStartState ? this.mSilentAudioStream : this.mAudioStream;
    }

    void retryStartAudioStream() {
        Preconditions.checkState(this.mInSilentStartState);
        try {
            this.mAudioStream.start();
            Logger.d(TAG, "Retry start AudioStream succeed");
            this.mSilentAudioStream.stop();
            this.mInSilentStartState = false;
        } catch (AudioStream.AudioStreamException e) {
            Logger.w(TAG, "Retry start AudioStream failed", e);
            this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
        }
    }

    boolean isStartRetryIntervalReached() {
        Preconditions.checkState(this.mLatestFailedStartTimeNs > 0);
        return getCurrentSystemTimeNs() - this.mLatestFailedStartTimeNs >= this.mStartRetryIntervalNs;
    }

    void notifyError(final Throwable th) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.AudioSourceCallback.this.onError(th);
            }
        });
    }

    void notifySilenced() {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null) {
            return;
        }
        final boolean z = this.mMuted || this.mInSilentStartState || this.mAudioStreamSilenced;
        if (Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(z)), Boolean.valueOf(z))) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.AudioSourceCallback.this.onSilenceStateChanged(z);
            }
        });
    }

    void notifySuspended(final boolean z) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null || this.mNotifiedSuspendState.getAndSet(z) == z) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.AudioSourceCallback.this.onSuspendStateChanged(z);
            }
        });
    }

    void overrideBySilence(ByteBuffer byteBuffer, int i) {
        byte[] bArr = this.mZeroBytes;
        if (bArr == null || bArr.length < i) {
            this.mZeroBytes = new byte[i];
        }
        int position = byteBuffer.position();
        byteBuffer.put(this.mZeroBytes, 0, i);
        byteBuffer.limit(byteBuffer.position()).position(position);
    }

    void updateSendingAudio() {
        if (this.mState == InternalState.STARTED) {
            boolean z = this.mBufferProviderState == BufferProvider.State.ACTIVE;
            notifySuspended(!z);
            if (z) {
                startSendingAudio();
                return;
            } else {
                stopSendingAudio();
                return;
            }
        }
        stopSendingAudio();
    }

    private void startSendingAudio() {
        if (this.mIsSendingAudio) {
            return;
        }
        try {
            Logger.d(TAG, "startSendingAudio");
            this.mAudioStream.start();
            this.mInSilentStartState = false;
        } catch (AudioStream.AudioStreamException e) {
            Logger.w(TAG, "Failed to start AudioStream", e);
            this.mInSilentStartState = true;
            this.mSilentAudioStream.start();
            this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
            notifySilenced();
        }
        this.mIsSendingAudio = true;
        sendNextAudio();
    }

    private void stopSendingAudio() {
        if (this.mIsSendingAudio) {
            this.mIsSendingAudio = false;
            Logger.d(TAG, "stopSendingAudio");
            this.mAudioStream.stop();
        }
    }

    void sendNextAudio() {
        Futures.addCallback(((BufferProvider) Objects.requireNonNull(this.mBufferProvider)).acquireBuffer(), (FutureCallback) Objects.requireNonNull(this.mAcquireBufferCallback), this.mExecutor);
    }

    void setState(InternalState internalState) {
        Logger.d(TAG, "Transitioning internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    void postMaxAmplitude(ByteBuffer byteBuffer) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (this.mAudioFormat == 2) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (asShortBuffer.hasRemaining()) {
                d = Math.max(d, Math.abs((int) asShortBuffer.get()));
            }
            this.mAudioAmplitude = d / 32767.0d;
            if (executor == null || audioSourceCallback == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioSource$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    AudioSource.this.m253xdf9dee1c(audioSourceCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$postMaxAmplitude$11$androidx-camera-video-internal-audio-AudioSource, reason: not valid java name */
    public /* synthetic */ void m253xdf9dee1c(AudioSourceCallback audioSourceCallback) {
        audioSourceCallback.onAmplitudeValue(this.mAudioAmplitude);
    }

    private static BufferProvider.State fetchBufferProviderState(BufferProvider<? extends InputBuffer> bufferProvider) {
        try {
            ListenableFuture<? extends InputBuffer> fetchData = bufferProvider.fetchData();
            if (fetchData.isDone()) {
                return (BufferProvider.State) fetchData.get();
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public static boolean isSettingsSupported(int i, int i2, int i3) {
        return AudioStreamImpl.isSettingsSupported(i, i2, i3);
    }

    private static long getCurrentSystemTimeNs() {
        return System.nanoTime();
    }
}
