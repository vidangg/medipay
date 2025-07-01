package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.collect.ImmutableList;

/* loaded from: classes.dex */
final class RtspTrackTiming {
    public final long rtpTimestamp;
    public final int sequenceNumber;
    public final Uri uri;

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #0 {Exception -> 0x008d, blocks: (B:7:0x0027, B:19:0x006f, B:24:0x0074, B:25:0x0079, B:28:0x007a, B:29:0x0081, B:31:0x0049, B:34:0x0053, B:37:0x005d), top: B:6:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImmutableList<RtspTrackTiming> parseTrackTiming(String str, Uri uri) throws ParserException {
        char c;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        String[] split = Util.split(str, ",");
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            String str2 = split[i2];
            String[] split2 = Util.split(str2, ";");
            int length2 = split2.length;
            int i3 = i;
            Uri uri2 = null;
            int i4 = -1;
            long j = C.TIME_UNSET;
            while (i3 < length2) {
                String str3 = split2[i3];
                try {
                    String[] splitAtFirst = Util.splitAtFirst(str3, "=");
                    String str4 = splitAtFirst[i];
                    String str5 = splitAtFirst[1];
                    int hashCode = str4.hashCode();
                    String[] strArr = split;
                    if (hashCode == 113759) {
                        if (str4.equals("seq")) {
                            c = 1;
                            if (c != 0) {
                            }
                            i3++;
                            split = strArr;
                            i = 0;
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        i3++;
                        split = strArr;
                        i = 0;
                    } else if (hashCode != 116079) {
                        if (hashCode == 1524180539 && str4.equals("rtptime")) {
                            c = 2;
                            if (c != 0) {
                                uri2 = resolveUri(str5, uri);
                            } else if (c == 1) {
                                i4 = Integer.parseInt(str5);
                            } else if (c == 2) {
                                j = Long.parseLong(str5);
                            } else {
                                throw ParserException.createForMalformedManifest(str4, null);
                            }
                            i3++;
                            split = strArr;
                            i = 0;
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        i3++;
                        split = strArr;
                        i = 0;
                    } else {
                        if (str4.equals(ImagesContract.URL)) {
                            c = 0;
                            if (c != 0) {
                            }
                            i3++;
                            split = strArr;
                            i = 0;
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        i3++;
                        split = strArr;
                        i = 0;
                    }
                } catch (Exception e) {
                    throw ParserException.createForMalformedManifest(str3, e);
                }
                throw ParserException.createForMalformedManifest(str3, e);
            }
            String[] strArr2 = split;
            if (uri2 != null && uri2.getScheme() != null) {
                long j2 = j;
                if (i4 != -1 || j2 != C.TIME_UNSET) {
                    builder.add((ImmutableList.Builder) new RtspTrackTiming(j2, i4, uri2));
                    i2++;
                    split = strArr2;
                    i = 0;
                }
            }
            throw ParserException.createForMalformedManifest(str2, null);
        }
        return builder.build();
    }

    static Uri resolveUri(String str, Uri uri) {
        Assertions.checkArgument(((String) Assertions.checkNotNull(uri.getScheme())).equals("rtsp"));
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        Uri parse2 = Uri.parse("rtsp://" + str);
        String uri2 = uri.toString();
        if (((String) Assertions.checkNotNull(parse2.getHost())).equals(uri.getHost())) {
            return parse2;
        }
        if (uri2.endsWith("/")) {
            return UriUtil.resolveToUri(uri2, str);
        }
        return UriUtil.resolveToUri(uri2 + "/", str);
    }

    private RtspTrackTiming(long j, int i, Uri uri) {
        this.rtpTimestamp = j;
        this.sequenceNumber = i;
        this.uri = uri;
    }
}
