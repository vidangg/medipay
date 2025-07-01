package io.flutter.plugins.camera.features.autofocus;

import android.hardware.camera2.CaptureRequest;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;

/* loaded from: classes4.dex */
public class AutoFocusFeature extends CameraFeature<FocusMode> {
    private FocusMode currentSetting;
    private final boolean recordingVideo;

    public AutoFocusFeature(CameraProperties cameraProperties, boolean z) {
        super(cameraProperties);
        this.currentSetting = FocusMode.auto;
        this.recordingVideo = z;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "AutoFocusFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public FocusMode getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(FocusMode focusMode) {
        this.currentSetting = focusMode;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        int[] controlAutoFocusAvailableModes = this.cameraProperties.getControlAutoFocusAvailableModes();
        Float lensInfoMinimumFocusDistance = this.cameraProperties.getLensInfoMinimumFocusDistance();
        if (lensInfoMinimumFocusDistance == null || lensInfoMinimumFocusDistance.floatValue() == 0.0f || controlAutoFocusAvailableModes.length == 0) {
            return false;
        }
        return (controlAutoFocusAvailableModes.length == 1 && controlAutoFocusAvailableModes[0] == 0) ? false : true;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[this.currentSetting.ordinal()];
            if (i == 1) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
            } else {
                if (i != 2) {
                    return;
                }
                builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.recordingVideo ? 3 : 4));
            }
        }
    }

    /* renamed from: io.flutter.plugins.camera.features.autofocus.AutoFocusFeature$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode;

        static {
            int[] iArr = new int[FocusMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode = iArr;
            try {
                iArr[FocusMode.locked.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[FocusMode.auto.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
