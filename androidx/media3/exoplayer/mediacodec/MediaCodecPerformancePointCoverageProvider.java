package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MediaCodecPerformancePointCoverageProvider {
    static final int COVERAGE_RESULT_NO = 1;
    static final int COVERAGE_RESULT_NO_PERFORMANCE_POINTS_UNSUPPORTED = 0;
    static final int COVERAGE_RESULT_YES = 2;
    private static Boolean shouldIgnorePerformancePoints;

    private MediaCodecPerformancePointCoverageProvider() {
    }

    public static int areResolutionAndFrameRateCovered(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (Util.SDK_INT < 29) {
            return 0;
        }
        Boolean bool = shouldIgnorePerformancePoints;
        if (bool == null || !bool.booleanValue()) {
            return Api29.areResolutionAndFrameRateCovered(videoCapabilities, i, i2, d);
        }
        return 0;
    }

    /* loaded from: classes.dex */
    private static final class Api29 {
        private Api29() {
        }

        public static int areResolutionAndFrameRateCovered(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
            List supportedPerformancePoints;
            supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m467m();
            int evaluatePerformancePointCoverage = evaluatePerformancePointCoverage(supportedPerformancePoints, FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(i, i2, (int) d));
            if (evaluatePerformancePointCoverage == 1 && MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints == null) {
                Boolean unused = MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints = Boolean.valueOf(shouldIgnorePerformancePoints());
                if (MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints.booleanValue()) {
                    return 0;
                }
            }
            return evaluatePerformancePointCoverage;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
        
            r4 = r1.get(r3).capabilities.getVideoCapabilities().getSupportedPerformancePoints();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static boolean shouldIgnorePerformancePoints() {
            List supportedPerformancePoints;
            if (Util.SDK_INT >= 35) {
                return false;
            }
            try {
                Format build = new Format.Builder().setSampleMimeType(MimeTypes.VIDEO_H264).build();
                if (build.sampleMimeType != null) {
                    List<MediaCodecInfo> decoderInfosSoftMatch = MediaCodecUtil.getDecoderInfosSoftMatch(MediaCodecSelector.DEFAULT, build, false, false);
                    int i = 0;
                    while (i < decoderInfosSoftMatch.size()) {
                        if (decoderInfosSoftMatch.get(i).capabilities != null && decoderInfosSoftMatch.get(i).capabilities.getVideoCapabilities() != null && supportedPerformancePoints != null && !supportedPerformancePoints.isEmpty()) {
                            FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m467m();
                            return evaluatePerformancePointCoverage(supportedPerformancePoints, FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(PlatformPlugin.DEFAULT_SYSTEM_UI, 720, 60)) == 1;
                        }
                        i++;
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return true;
        }

        private static int evaluatePerformancePointCoverage(List<MediaCodecInfo.VideoCapabilities.PerformancePoint> list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            boolean covers;
            for (int i = 0; i < list.size(); i++) {
                covers = FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m459m((Object) list.get(i)).covers(performancePoint);
                if (covers) {
                    return 2;
                }
            }
            return 1;
        }
    }
}
