package io.flutter.plugins.camera.features.flash;

import android.hardware.camera2.CaptureRequest;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;

/* loaded from: classes4.dex */
public class FlashFeature extends CameraFeature<FlashMode> {
    private FlashMode currentSetting;

    public FlashFeature(CameraProperties cameraProperties) {
        super(cameraProperties);
        this.currentSetting = FlashMode.auto;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public String getDebugName() {
        return "FlashFeature";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    public FlashMode getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(FlashMode flashMode) {
        this.currentSetting = flashMode;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        Boolean flashInfoAvailable = this.cameraProperties.getFlashInfoAvailable();
        return flashInfoAvailable != null && flashInfoAvailable.booleanValue();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[this.currentSetting.ordinal()];
            if (i == 1) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 0);
                return;
            }
            if (i == 2) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 3);
                builder.set(CaptureRequest.FLASH_MODE, 0);
            } else if (i == 3) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 2);
            } else {
                if (i != 4) {
                    return;
                }
                builder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                builder.set(CaptureRequest.FLASH_MODE, 0);
            }
        }
    }

    /* renamed from: io.flutter.plugins.camera.features.flash.FlashFeature$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode;

        static {
            int[] iArr = new int[FlashMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode = iArr;
            try {
                iArr[FlashMode.off.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[FlashMode.always.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[FlashMode.torch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[FlashMode.auto.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
