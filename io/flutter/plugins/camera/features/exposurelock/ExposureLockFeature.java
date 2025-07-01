package io.flutter.plugins.camera.features.exposurelock;

import android.hardware.camera2.CaptureRequest;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;

/* loaded from: classes4.dex */
public class ExposureLockFeature extends CameraFeature<ExposureMode> {
    private ExposureMode currentSetting;

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return true;
    }

    public ExposureLockFeature(CameraProperties cameraProperties) {
        super(cameraProperties);
        this.currentSetting = ExposureMode.auto;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "ExposureLockFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public ExposureMode getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(ExposureMode exposureMode) {
        this.currentSetting = exposureMode;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            builder.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(this.currentSetting == ExposureMode.locked));
        }
    }
}
