package io.flutter.plugins.camera.features.zoomlevel;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.SdkCapabilityChecker;
import io.flutter.plugins.camera.features.CameraFeature;

/* loaded from: classes4.dex */
public class ZoomLevelFeature extends CameraFeature<Float> {
    private static final Float DEFAULT_ZOOM_LEVEL = Float.valueOf(1.0f);
    private Float currentSetting;
    private final boolean hasSupport;
    private final Float maximumZoomLevel;
    private Float minimumZoomLevel;
    private final Rect sensorArraySize;

    public ZoomLevelFeature(CameraProperties cameraProperties) {
        super(cameraProperties);
        Float f = DEFAULT_ZOOM_LEVEL;
        this.currentSetting = f;
        this.minimumZoomLevel = f;
        Rect sensorInfoActiveArraySize = cameraProperties.getSensorInfoActiveArraySize();
        this.sensorArraySize = sensorInfoActiveArraySize;
        if (sensorInfoActiveArraySize == null) {
            this.maximumZoomLevel = this.minimumZoomLevel;
            this.hasSupport = false;
            return;
        }
        if (SdkCapabilityChecker.supportsZoomRatio()) {
            this.minimumZoomLevel = cameraProperties.getScalerMinZoomRatio();
            this.maximumZoomLevel = cameraProperties.getScalerMaxZoomRatio();
        } else {
            this.minimumZoomLevel = f;
            Float scalerAvailableMaxDigitalZoom = cameraProperties.getScalerAvailableMaxDigitalZoom();
            this.maximumZoomLevel = (scalerAvailableMaxDigitalZoom == null || scalerAvailableMaxDigitalZoom.floatValue() < this.minimumZoomLevel.floatValue()) ? this.minimumZoomLevel : scalerAvailableMaxDigitalZoom;
        }
        this.hasSupport = Float.compare(this.maximumZoomLevel.floatValue(), this.minimumZoomLevel.floatValue()) > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "ZoomLevelFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public Float getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(Float f) {
        this.currentSetting = f;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return this.hasSupport;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        CaptureRequest.Key key;
        if (checkIsSupported()) {
            if (SdkCapabilityChecker.supportsZoomRatio()) {
                key = CaptureRequest.CONTROL_ZOOM_RATIO;
                builder.set(key, ZoomUtils.computeZoomRatio(this.currentSetting.floatValue(), this.minimumZoomLevel.floatValue(), this.maximumZoomLevel.floatValue()));
            } else {
                builder.set(CaptureRequest.SCALER_CROP_REGION, ZoomUtils.computeZoomRect(this.currentSetting.floatValue(), this.sensorArraySize, this.minimumZoomLevel.floatValue(), this.maximumZoomLevel.floatValue()));
            }
        }
    }

    public float getMinimumZoomLevel() {
        return this.minimumZoomLevel.floatValue();
    }

    public float getMaximumZoomLevel() {
        return this.maximumZoomLevel.floatValue();
    }
}
