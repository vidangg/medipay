package io.flutter.plugins.camera.features.fpsrange;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.DeviceInfo;
import io.flutter.plugins.camera.features.CameraFeature;

/* loaded from: classes4.dex */
public class FpsRangeFeature extends CameraFeature<Range<Integer>> {
    private static final Range<Integer> MAX_PIXEL4A_RANGE = new Range<>(30, 30);
    private Range<Integer> currentSetting;

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return true;
    }

    public FpsRangeFeature(CameraProperties cameraProperties) {
        super(cameraProperties);
        Range<Integer> range;
        if (isPixel4A()) {
            this.currentSetting = MAX_PIXEL4A_RANGE;
            return;
        }
        Range<Integer>[] controlAutoExposureAvailableTargetFpsRanges = cameraProperties.getControlAutoExposureAvailableTargetFpsRanges();
        if (controlAutoExposureAvailableTargetFpsRanges != null) {
            for (Range<Integer> range2 : controlAutoExposureAvailableTargetFpsRanges) {
                int intValue = range2.getUpper().intValue();
                if (intValue >= 10 && ((range = this.currentSetting) == null || intValue > range.getUpper().intValue())) {
                    this.currentSetting = range2;
                }
            }
        }
    }

    private boolean isPixel4A() {
        String brand = DeviceInfo.getBrand();
        String model = DeviceInfo.getModel();
        return brand != null && brand.equals("google") && model != null && model.equals("Pixel 4a");
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "FpsRangeFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public Range<Integer> getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(Range<Integer> range) {
        this.currentSetting = range;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.currentSetting);
        }
    }
}
