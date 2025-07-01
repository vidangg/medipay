package io.flutter.plugins.camera.features.exposurepoint;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Size;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.CameraRegionUtils;
import io.flutter.plugins.camera.features.CameraFeature;
import io.flutter.plugins.camera.features.Point;
import io.flutter.plugins.camera.features.sensororientation.SensorOrientationFeature;

/* loaded from: classes4.dex */
public class ExposurePointFeature extends CameraFeature<Point> {
    private Size cameraBoundaries;
    public MeteringRectangle[] defaultRegions;
    private boolean defaultRegionsHasBeenSet;
    private Point exposurePoint;
    private MeteringRectangle exposureRectangle;
    private final SensorOrientationFeature sensorOrientationFeature;

    public ExposurePointFeature(CameraProperties cameraProperties, SensorOrientationFeature sensorOrientationFeature) {
        super(cameraProperties);
        this.defaultRegionsHasBeenSet = false;
        this.sensorOrientationFeature = sensorOrientationFeature;
    }

    public void setCameraBoundaries(Size size) {
        this.cameraBoundaries = size;
        buildExposureRectangle();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "ExposurePointFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public Point getValue() {
        return this.exposurePoint;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(Point point) {
        if (point == null || point.x == null || point.y == null) {
            point = null;
        }
        this.exposurePoint = point;
        buildExposureRectangle();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        Integer controlMaxRegionsAutoExposure = this.cameraProperties.getControlMaxRegionsAutoExposure();
        return controlMaxRegionsAutoExposure != null && controlMaxRegionsAutoExposure.intValue() > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            if (!this.defaultRegionsHasBeenSet) {
                this.defaultRegions = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AE_REGIONS);
                this.defaultRegionsHasBeenSet = true;
            }
            if (this.exposureRectangle != null) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{this.exposureRectangle});
            } else {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, this.defaultRegions);
            }
        }
    }

    private void buildExposureRectangle() {
        if (this.cameraBoundaries == null) {
            throw new AssertionError("The cameraBoundaries should be set (using `ExposurePointFeature.setCameraBoundaries(Size)`) before updating the exposure point.");
        }
        if (this.exposurePoint == null) {
            this.exposureRectangle = null;
            return;
        }
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.sensorOrientationFeature.getLockedCaptureOrientation();
        if (lockedCaptureOrientation == null) {
            lockedCaptureOrientation = this.sensorOrientationFeature.getDeviceOrientationManager().getLastUIOrientation();
        }
        this.exposureRectangle = CameraRegionUtils.convertPointToMeteringRectangle(this.cameraBoundaries, this.exposurePoint.x.doubleValue(), this.exposurePoint.y.doubleValue(), lockedCaptureOrientation);
    }
}
