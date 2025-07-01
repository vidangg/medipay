package io.flutter.plugins.camera.features.focuspoint;

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
public class FocusPointFeature extends CameraFeature<Point> {
    private Size cameraBoundaries;
    private Point focusPoint;
    private MeteringRectangle focusRectangle;
    private final SensorOrientationFeature sensorOrientationFeature;

    public FocusPointFeature(CameraProperties cameraProperties, SensorOrientationFeature sensorOrientationFeature) {
        super(cameraProperties);
        this.sensorOrientationFeature = sensorOrientationFeature;
    }

    public void setCameraBoundaries(Size size) {
        this.cameraBoundaries = size;
        buildFocusRectangle();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "FocusPointFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public Point getValue() {
        return this.focusPoint;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(Point point) {
        if (point == null || point.x == null || point.y == null) {
            point = null;
        }
        this.focusPoint = point;
        buildFocusRectangle();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        Integer controlMaxRegionsAutoFocus = this.cameraProperties.getControlMaxRegionsAutoFocus();
        return controlMaxRegionsAutoFocus != null && controlMaxRegionsAutoFocus.intValue() > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            MeteringRectangle meteringRectangle = this.focusRectangle;
            builder.set(key, meteringRectangle == null ? null : new MeteringRectangle[]{meteringRectangle});
        }
    }

    private void buildFocusRectangle() {
        if (this.cameraBoundaries == null) {
            throw new AssertionError("The cameraBoundaries should be set (using `FocusPointFeature.setCameraBoundaries(Size)`) before updating the focus point.");
        }
        if (this.focusPoint == null) {
            this.focusRectangle = null;
            return;
        }
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.sensorOrientationFeature.getLockedCaptureOrientation();
        if (lockedCaptureOrientation == null) {
            lockedCaptureOrientation = this.sensorOrientationFeature.getDeviceOrientationManager().getLastUIOrientation();
        }
        this.focusRectangle = CameraRegionUtils.convertPointToMeteringRectangle(this.cameraBoundaries, this.focusPoint.x.doubleValue(), this.focusPoint.y.doubleValue(), lockedCaptureOrientation);
    }
}
