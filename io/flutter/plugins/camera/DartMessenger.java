package io.flutter.plugins.camera;

import android.os.Handler;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.Messages;
import io.flutter.plugins.camera.features.autofocus.FocusMode;
import io.flutter.plugins.camera.features.exposurelock.ExposureMode;

/* loaded from: classes4.dex */
public class DartMessenger {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Messages.CameraEventApi eventApi;
    Messages.CameraGlobalEventApi globalEventApi;
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DartMessenger(Handler handler, Messages.CameraGlobalEventApi cameraGlobalEventApi, Messages.CameraEventApi cameraEventApi) {
        this.handler = handler;
        this.globalEventApi = cameraGlobalEventApi;
        this.eventApi = cameraEventApi;
    }

    public void sendDeviceOrientationChangeEvent(final PlatformChannel.DeviceOrientation deviceOrientation) {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.DartMessenger$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DartMessenger.this.m782xf587f74e(deviceOrientation);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendDeviceOrientationChangeEvent$0$io-flutter-plugins-camera-DartMessenger, reason: not valid java name */
    public /* synthetic */ void m782xf587f74e(PlatformChannel.DeviceOrientation deviceOrientation) {
        this.globalEventApi.deviceOrientationChanged(CameraUtils.orientationToPigeon(deviceOrientation), new NoOpVoidResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendCameraInitializedEvent(final Integer num, final Integer num2, final ExposureMode exposureMode, final FocusMode focusMode, final Boolean bool, final Boolean bool2) {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.DartMessenger$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DartMessenger.this.m781x718ffaea(num, num2, bool, bool2, exposureMode, focusMode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendCameraInitializedEvent$1$io-flutter-plugins-camera-DartMessenger, reason: not valid java name */
    public /* synthetic */ void m781x718ffaea(Integer num, Integer num2, Boolean bool, Boolean bool2, ExposureMode exposureMode, FocusMode focusMode) {
        this.eventApi.initialized(new Messages.PlatformCameraState.Builder().setPreviewSize(new Messages.PlatformSize.Builder().setWidth(Double.valueOf(num.doubleValue())).setHeight(Double.valueOf(num2.doubleValue())).build()).setExposurePointSupported(bool).setFocusPointSupported(bool2).setExposureMode(CameraUtils.exposureModeToPigeon(exposureMode)).setFocusMode(CameraUtils.focusModeToPigeon(focusMode)).build(), new NoOpVoidResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendCameraClosingEvent$2$io-flutter-plugins-camera-DartMessenger, reason: not valid java name */
    public /* synthetic */ void m779x15305aea() {
        this.eventApi.closed(new NoOpVoidResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendCameraClosingEvent() {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.DartMessenger$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DartMessenger.this.m779x15305aea();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendCameraErrorEvent$3$io-flutter-plugins-camera-DartMessenger, reason: not valid java name */
    public /* synthetic */ void m780x335a7eb8(String str) {
        this.eventApi.error(str, new NoOpVoidResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendCameraErrorEvent(final String str) {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.DartMessenger$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                DartMessenger.this.m780x335a7eb8(str);
            }
        });
    }

    public <T> void finish(final Messages.Result<T> result, final T t) {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.DartMessenger$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Messages.Result.this.success(t);
            }
        });
    }

    public <T> void error(final Messages.Result<T> result, final String str, final String str2, final Object obj) {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.DartMessenger$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Messages.Result.this.error(new Messages.FlutterError(str, str2, obj));
            }
        });
    }
}
