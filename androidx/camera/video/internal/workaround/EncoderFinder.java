package androidx.camera.video.internal.workaround;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.compat.quirk.MediaFormatMustNotUseFrameRateToFindEncoderQuirk;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.core.util.Preconditions;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

/* loaded from: classes.dex */
public class EncoderFinder {
    private static final String TAG = "EncoderFinder";
    private final boolean mShouldRemoveKeyFrameRate;

    public EncoderFinder() {
        this.mShouldRemoveKeyFrameRate = ((MediaFormatMustNotUseFrameRateToFindEncoderQuirk) DeviceQuirks.get(MediaFormatMustNotUseFrameRateToFindEncoderQuirk.class)) != null;
    }

    public MediaCodec findEncoder(MediaFormat mediaFormat) throws InvalidConfigException {
        MediaCodecList mediaCodecList = new MediaCodecList(1);
        String findEncoderForFormat = findEncoderForFormat(mediaFormat, mediaCodecList);
        try {
            if (TextUtils.isEmpty(findEncoderForFormat)) {
                String string = mediaFormat.getString("mime");
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(string);
                Logger.w(TAG, String.format("No encoder found that supports requested MediaFormat %s. Create encoder by MIME type. Dump codec info:\n%s", mediaFormat, DebugUtils.dumpCodecCapabilities(string, createEncoderByType, mediaFormat)));
                return createEncoderByType;
            }
            return MediaCodec.createByCodecName(findEncoderForFormat);
        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            throw new InvalidConfigException("Encoder cannot created: " + findEncoderForFormat + ", isMediaFormatInQuirk: " + shouldCreateCodecByType(mediaFormat) + IOUtils.LINE_SEPARATOR_UNIX + DebugUtils.dumpMediaCodecListForFormat(mediaCodecList, mediaFormat), e);
        }
    }

    String findEncoderForFormat(MediaFormat mediaFormat, MediaCodecList mediaCodecList) {
        Integer num = null;
        try {
            if (this.mShouldRemoveKeyFrameRate && mediaFormat.containsKey("frame-rate")) {
                Integer valueOf = Integer.valueOf(mediaFormat.getInteger("frame-rate"));
                try {
                    mediaFormat.setString("frame-rate", null);
                    num = valueOf;
                } catch (Throwable th) {
                    th = th;
                    num = valueOf;
                    if (num != null) {
                        mediaFormat.setInteger("frame-rate", num.intValue());
                    }
                    throw th;
                }
            }
            String findEncoderForFormat = mediaCodecList.findEncoderForFormat(mediaFormat);
            if (findEncoderForFormat == null) {
                findEncoderForFormat = findEncoderWithNearestCompatibleBitrate(mediaFormat, mediaCodecList.getCodecInfos());
            }
            if (num != null) {
                mediaFormat.setInteger("frame-rate", num.intValue());
            }
            return findEncoderForFormat;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String findEncoderWithNearestCompatibleBitrate(MediaFormat mediaFormat, MediaCodecInfo[] mediaCodecInfoArr) {
        int i;
        Integer num;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        int i2;
        String string = mediaFormat.getString("mime");
        Integer num2 = null;
        if (string == null) {
            Logger.w(TAG, "MediaFormat does not contain mime info.");
            return null;
        }
        int length = mediaCodecInfoArr.length;
        for (0; i < length; i + 1) {
            MediaCodecInfo mediaCodecInfo = mediaCodecInfoArr[i];
            if (mediaCodecInfo.isEncoder()) {
                try {
                    capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    boolean z = true;
                    Preconditions.checkArgument(capabilitiesForType != null, "MIME type is not supported");
                    if (mediaFormat.containsKey("bitrate")) {
                        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                        if (videoCapabilities == null) {
                            z = false;
                        }
                        Preconditions.checkArgument(z, "Not video codec");
                        num = Integer.valueOf(mediaFormat.getInteger("bitrate"));
                        try {
                            i2 = videoCapabilities.getBitrateRange().clamp(num).intValue();
                            mediaFormat.setInteger("bitrate", i2);
                        } catch (IllegalArgumentException unused) {
                            i = num == null ? i + 1 : 0;
                            mediaFormat.setInteger("bitrate", num.intValue());
                        } catch (Throwable th) {
                            th = th;
                            num2 = num;
                            if (num2 != null) {
                                mediaFormat.setInteger("bitrate", num2.intValue());
                            }
                            throw th;
                        }
                    } else {
                        i2 = -1;
                        num = null;
                    }
                } catch (IllegalArgumentException unused2) {
                    num = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (!capabilitiesForType.isFormatSupported(mediaFormat)) {
                    if (num == null) {
                    }
                    mediaFormat.setInteger("bitrate", num.intValue());
                } else {
                    Logger.w(TAG, String.format("No encoder found that supports requested bitrate. Adjusting bitrate to nearest supported bitrate [requested: %dbps, nearest: %dbps]", num, Integer.valueOf(i2)));
                    String name = mediaCodecInfo.getName();
                    if (num != null) {
                        mediaFormat.setInteger("bitrate", num.intValue());
                    }
                    return name;
                }
            }
        }
        return null;
    }

    private boolean shouldCreateCodecByType(MediaFormat mediaFormat) {
        MediaCodecInfoReportIncorrectInfoQuirk mediaCodecInfoReportIncorrectInfoQuirk = (MediaCodecInfoReportIncorrectInfoQuirk) DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class);
        if (mediaCodecInfoReportIncorrectInfoQuirk == null) {
            return false;
        }
        return mediaCodecInfoReportIncorrectInfoQuirk.isUnSupportMediaCodecInfo(mediaFormat);
    }
}
