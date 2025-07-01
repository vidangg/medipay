package io.flutter.plugins.camera;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import io.flutter.plugins.camera.types.CameraCaptureProperties;
import io.flutter.plugins.camera.types.CaptureTimeoutsWrapper;

/* loaded from: classes4.dex */
class CameraCaptureCallback extends CameraCaptureSession.CaptureCallback {
    private static final String TAG = "CameraCaptureCallback";
    CaptureResult.Key<Integer> aeStateKey = CaptureResult.CONTROL_AE_STATE;
    CaptureResult.Key<Integer> afStateKey = CaptureResult.CONTROL_AF_STATE;
    private CameraState cameraState = CameraState.STATE_PREVIEW;
    private final CameraCaptureStateListener cameraStateListener;
    private final CameraCaptureProperties captureProps;
    private final CaptureTimeoutsWrapper captureTimeouts;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface CameraCaptureStateListener {
        void onConverged();

        void onPrecapture();
    }

    private CameraCaptureCallback(CameraCaptureStateListener cameraCaptureStateListener, CaptureTimeoutsWrapper captureTimeoutsWrapper, CameraCaptureProperties cameraCaptureProperties) {
        this.cameraStateListener = cameraCaptureStateListener;
        this.captureTimeouts = captureTimeoutsWrapper;
        this.captureProps = cameraCaptureProperties;
    }

    public static CameraCaptureCallback create(CameraCaptureStateListener cameraCaptureStateListener, CaptureTimeoutsWrapper captureTimeoutsWrapper, CameraCaptureProperties cameraCaptureProperties) {
        return new CameraCaptureCallback(cameraCaptureStateListener, captureTimeoutsWrapper, cameraCaptureProperties);
    }

    public CameraState getCameraState() {
        return this.cameraState;
    }

    public void setCameraState(CameraState cameraState) {
        this.cameraState = cameraState;
    }

    private void process(CaptureResult captureResult) {
        Integer num = (Integer) captureResult.get(this.aeStateKey);
        Integer num2 = (Integer) captureResult.get(this.afStateKey);
        if (captureResult instanceof TotalCaptureResult) {
            Float f = (Float) captureResult.get(CaptureResult.LENS_APERTURE);
            Long l = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Integer num3 = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            this.captureProps.setLastLensAperture(f);
            this.captureProps.setLastSensorExposureTime(l);
            this.captureProps.setLastSensorSensitivity(num3);
        }
        if (this.cameraState != CameraState.STATE_PREVIEW) {
            Log.d(TAG, "CameraCaptureCallback | state: " + this.cameraState + " | afState: " + num2 + " | aeState: " + num);
        }
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$CameraState[this.cameraState.ordinal()];
        if (i == 2) {
            if (num2 == null) {
                return;
            }
            if (num2.intValue() == 4 || num2.intValue() == 5) {
                handleWaitingFocusState(num);
                return;
            } else {
                if (this.captureTimeouts.getPreCaptureFocusing().getIsExpired()) {
                    Log.w(TAG, "Focus timeout, moving on with capture");
                    handleWaitingFocusState(num);
                    return;
                }
                return;
            }
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            if (num == null || num.intValue() != 5) {
                this.cameraStateListener.onConverged();
                return;
            } else {
                if (this.captureTimeouts.getPreCaptureMetering().getIsExpired()) {
                    Log.w(TAG, "Metering timeout waiting for pre-capture to finish, moving on with capture");
                    this.cameraStateListener.onConverged();
                    return;
                }
                return;
            }
        }
        if (num == null || num.intValue() == 2 || num.intValue() == 5 || num.intValue() == 4) {
            setCameraState(CameraState.STATE_WAITING_PRECAPTURE_DONE);
        } else if (this.captureTimeouts.getPreCaptureMetering().getIsExpired()) {
            Log.w(TAG, "Metering timeout waiting for pre-capture to start, moving on with capture");
            setCameraState(CameraState.STATE_WAITING_PRECAPTURE_DONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.camera.CameraCaptureCallback$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$CameraState;

        static {
            int[] iArr = new int[CameraState.values().length];
            $SwitchMap$io$flutter$plugins$camera$CameraState = iArr;
            try {
                iArr[CameraState.STATE_PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$CameraState[CameraState.STATE_WAITING_FOCUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$CameraState[CameraState.STATE_WAITING_PRECAPTURE_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$CameraState[CameraState.STATE_WAITING_PRECAPTURE_DONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void handleWaitingFocusState(Integer num) {
        if (num == null || num.intValue() == 2) {
            this.cameraStateListener.onConverged();
        } else {
            this.cameraStateListener.onPrecapture();
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        process(captureResult);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        process(totalCaptureResult);
    }
}
