package io.flutter.plugins.camera;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import io.flutter.plugin.common.PluginRegistry;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class CameraPermissions {
    private static final String AUDIO_ACCESS_DENIED = "AudioAccessDenied";
    private static final String AUDIO_ACCESS_DENIED_MESSAGE = "Audio access permission was denied.";
    private static final String CAMERA_ACCESS_DENIED = "CameraAccessDenied";
    private static final String CAMERA_ACCESS_DENIED_MESSAGE = "Camera access permission was denied.";
    private static final String CAMERA_PERMISSIONS_REQUEST_ONGOING = "CameraPermissionsRequestOngoing";
    private static final String CAMERA_PERMISSIONS_REQUEST_ONGOING_MESSAGE = "Another request is ongoing and multiple requests cannot be handled at once.";
    private static final int CAMERA_REQUEST_ID = 9796;
    boolean ongoing = false;

    /* loaded from: classes4.dex */
    interface PermissionsRegistry {
        void addListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface ResultCallback {
        void onResult(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestPermissions(Activity activity, PermissionsRegistry permissionsRegistry, boolean z, final ResultCallback resultCallback) {
        String[] strArr;
        if (this.ongoing) {
            resultCallback.onResult(CAMERA_PERMISSIONS_REQUEST_ONGOING, CAMERA_PERMISSIONS_REQUEST_ONGOING_MESSAGE);
            return;
        }
        if (!hasCameraPermission(activity) || (z && !hasAudioPermission(activity))) {
            permissionsRegistry.addListener(new CameraRequestPermissionsListener(new ResultCallback() { // from class: io.flutter.plugins.camera.CameraPermissions$$ExternalSyntheticLambda0
                @Override // io.flutter.plugins.camera.CameraPermissions.ResultCallback
                public final void onResult(String str, String str2) {
                    CameraPermissions.this.m778xd34cec16(resultCallback, str, str2);
                }
            }));
            this.ongoing = true;
            if (z) {
                strArr = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
            } else {
                strArr = new String[]{"android.permission.CAMERA"};
            }
            ActivityCompat.requestPermissions(activity, strArr, CAMERA_REQUEST_ID);
            return;
        }
        resultCallback.onResult(null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$requestPermissions$0$io-flutter-plugins-camera-CameraPermissions, reason: not valid java name */
    public /* synthetic */ void m778xd34cec16(ResultCallback resultCallback, String str, String str2) {
        this.ongoing = false;
        resultCallback.onResult(str, str2);
    }

    private boolean hasCameraPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0;
    }

    private boolean hasAudioPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.RECORD_AUDIO") == 0;
    }

    /* loaded from: classes4.dex */
    static final class CameraRequestPermissionsListener implements PluginRegistry.RequestPermissionsResultListener {
        boolean alreadyCalled = false;
        final ResultCallback callback;

        CameraRequestPermissionsListener(ResultCallback resultCallback) {
            this.callback = resultCallback;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
        public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            if (this.alreadyCalled || i != CameraPermissions.CAMERA_REQUEST_ID) {
                return false;
            }
            this.alreadyCalled = true;
            if (iArr.length == 0 || iArr[0] != 0) {
                this.callback.onResult(CameraPermissions.CAMERA_ACCESS_DENIED, CameraPermissions.CAMERA_ACCESS_DENIED_MESSAGE);
            } else if (iArr.length > 1 && iArr[1] != 0) {
                this.callback.onResult(CameraPermissions.AUDIO_ACCESS_DENIED, CameraPermissions.AUDIO_ACCESS_DENIED_MESSAGE);
            } else {
                this.callback.onResult(null, null);
            }
            return true;
        }
    }
}
