package io.flutter.plugins.camera;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.view.Surface;
import java.util.List;

/* loaded from: classes4.dex */
interface CameraDeviceWrapper {
    void close();

    CaptureRequest.Builder createCaptureRequest(int i) throws CameraAccessException;

    void createCaptureSession(SessionConfiguration sessionConfiguration) throws CameraAccessException;

    void createCaptureSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) throws CameraAccessException;
}
