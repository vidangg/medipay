package io.flutter.plugins.camera.features.noisereduction;

import android.hardware.camera2.CaptureRequest;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.SdkCapabilityChecker;
import io.flutter.plugins.camera.features.CameraFeature;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class NoiseReductionFeature extends CameraFeature<NoiseReductionMode> {
    private final HashMap<NoiseReductionMode, Integer> NOISE_REDUCTION_MODES;
    private NoiseReductionMode currentSetting;

    public NoiseReductionFeature(CameraProperties cameraProperties) {
        super(cameraProperties);
        this.currentSetting = NoiseReductionMode.fast;
        HashMap<NoiseReductionMode, Integer> hashMap = new HashMap<>();
        this.NOISE_REDUCTION_MODES = hashMap;
        hashMap.put(NoiseReductionMode.off, 0);
        hashMap.put(NoiseReductionMode.fast, 1);
        hashMap.put(NoiseReductionMode.highQuality, 2);
        if (SdkCapabilityChecker.supportsMarshmallowNoiseReductionModes()) {
            hashMap.put(NoiseReductionMode.minimal, 3);
            hashMap.put(NoiseReductionMode.zeroShutterLag, 4);
        }
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "NoiseReductionFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public NoiseReductionMode getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(NoiseReductionMode noiseReductionMode) {
        this.currentSetting = noiseReductionMode;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        int[] availableNoiseReductionModes = this.cameraProperties.getAvailableNoiseReductionModes();
        return availableNoiseReductionModes != null && availableNoiseReductionModes.length > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            builder.set(CaptureRequest.NOISE_REDUCTION_MODE, this.NOISE_REDUCTION_MODES.get(this.currentSetting));
        }
    }
}
