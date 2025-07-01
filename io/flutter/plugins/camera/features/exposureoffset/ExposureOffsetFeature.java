package io.flutter.plugins.camera.features.exposureoffset;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.video.AudioStats;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;

/* loaded from: classes4.dex */
public class ExposureOffsetFeature extends CameraFeature<Double> {
    private double currentSetting;

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return true;
    }

    public ExposureOffsetFeature(CameraProperties cameraProperties) {
        super(cameraProperties);
        this.currentSetting = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "ExposureOffsetFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public Double getValue() {
        return Double.valueOf(this.currentSetting);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(Double d) {
        this.currentSetting = d.doubleValue() / getExposureOffsetStepSize();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf((int) this.currentSetting));
        }
    }

    public double getMinExposureOffset() {
        return (this.cameraProperties.getControlAutoExposureCompensationRange() == null ? AudioStats.AUDIO_AMPLITUDE_NONE : r0.getLower().intValue()) * getExposureOffsetStepSize();
    }

    public double getMaxExposureOffset() {
        return (this.cameraProperties.getControlAutoExposureCompensationRange() == null ? AudioStats.AUDIO_AMPLITUDE_NONE : r0.getUpper().intValue()) * getExposureOffsetStepSize();
    }

    public double getExposureOffsetStepSize() {
        return this.cameraProperties.getControlAutoExposureCompensationStep();
    }
}
