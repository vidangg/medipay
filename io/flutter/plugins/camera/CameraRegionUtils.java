package io.flutter.plugins.camera;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Size;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.Arrays;
import java.util.function.IntPredicate;

/* loaded from: classes4.dex */
public final class CameraRegionUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$supportsDistortionCorrection$0(int i) {
        return i != 0;
    }

    public static Size getCameraBoundaries(CameraProperties cameraProperties, CaptureRequest.Builder builder) {
        Rect sensorInfoPreCorrectionActiveArraySize;
        if (SdkCapabilityChecker.supportsDistortionCorrection() && supportsDistortionCorrection(cameraProperties)) {
            Integer num = (Integer) builder.get(CaptureRequest.DISTORTION_CORRECTION_MODE);
            if (num == null || num.intValue() == 0) {
                sensorInfoPreCorrectionActiveArraySize = cameraProperties.getSensorInfoPreCorrectionActiveArraySize();
            } else {
                sensorInfoPreCorrectionActiveArraySize = cameraProperties.getSensorInfoActiveArraySize();
            }
            return SizeFactory.create(sensorInfoPreCorrectionActiveArraySize.width(), sensorInfoPreCorrectionActiveArraySize.height());
        }
        return cameraProperties.getSensorInfoPixelArraySize();
    }

    /* renamed from: io.flutter.plugins.camera.CameraRegionUtils$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;

        static {
            int[] iArr = new int[PlatformChannel.DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr;
            try {
                iArr[PlatformChannel.DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static MeteringRectangle convertPointToMeteringRectangle(Size size, double d, double d2, PlatformChannel.DeviceOrientation deviceOrientation) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[deviceOrientation.ordinal()];
        if (i == 1) {
            double d3 = 1.0d - d;
            d = d2;
            d2 = d3;
        } else if (i == 2) {
            double d4 = 1.0d - d2;
            d2 = d;
            d = d4;
        } else if (i == 4) {
            d = 1.0d - d;
            d2 = 1.0d - d2;
        }
        int round = (int) Math.round(d * (size.getWidth() - 1));
        int round2 = (int) Math.round(d2 * (size.getHeight() - 1));
        int round3 = (int) Math.round(size.getWidth() / 10.0d);
        int round4 = (int) Math.round(size.getHeight() / 10.0d);
        int i2 = round - (round3 / 2);
        int i3 = round2 - (round4 / 2);
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int width = (size.getWidth() - 1) - round3;
        int height = (size.getHeight() - 1) - round4;
        if (i2 > width) {
            i2 = width;
        }
        if (i3 > height) {
            i3 = height;
        }
        return MeteringRectangleFactory.create(i2, i3, round3, round4, 1);
    }

    private static boolean supportsDistortionCorrection(CameraProperties cameraProperties) {
        int[] distortionCorrectionAvailableModes = cameraProperties.getDistortionCorrectionAvailableModes();
        if (distortionCorrectionAvailableModes == null) {
            distortionCorrectionAvailableModes = new int[0];
        }
        return Arrays.stream(distortionCorrectionAvailableModes).filter(new IntPredicate() { // from class: io.flutter.plugins.camera.CameraRegionUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return CameraRegionUtils.lambda$supportsDistortionCorrection$0(i);
            }
        }).count() > 0;
    }

    /* loaded from: classes4.dex */
    static class MeteringRectangleFactory {
        MeteringRectangleFactory() {
        }

        public static MeteringRectangle create(int i, int i2, int i3, int i4, int i5) {
            return new MeteringRectangle(i, i2, i3, i4, i5);
        }
    }

    /* loaded from: classes4.dex */
    static class SizeFactory {
        SizeFactory() {
        }

        public static Size create(int i, int i2) {
            return new Size(i, i2);
        }
    }
}
