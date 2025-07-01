package io.flutter.plugins.camera.features;

import android.hardware.camera2.CaptureRequest;
import io.flutter.plugins.camera.CameraProperties;

/* loaded from: classes4.dex */
public abstract class CameraFeature<T> {
    protected final CameraProperties cameraProperties;

    public abstract boolean checkIsSupported();

    public abstract String getDebugName();

    public abstract T getValue();

    public abstract void setValue(T t);

    public abstract void updateBuilder(CaptureRequest.Builder builder);

    /* JADX INFO: Access modifiers changed from: protected */
    public CameraFeature(CameraProperties cameraProperties) {
        this.cameraProperties = cameraProperties;
    }
}
