package io.flutter.plugins.camera;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.Messages;
import io.flutter.plugins.camera.features.autofocus.FocusMode;
import io.flutter.plugins.camera.features.exposurelock.ExposureMode;
import io.flutter.plugins.camera.features.flash.FlashMode;
import io.flutter.plugins.camera.features.resolution.ResolutionPreset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class CameraUtils {
    private CameraUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraManager getCameraManager(Context context) {
        return (CameraManager) context.getSystemService("camera");
    }

    static Messages.PlatformCameraLensDirection lensDirectionFromInteger(int i) {
        if (i == 0) {
            return Messages.PlatformCameraLensDirection.FRONT;
        }
        if (i == 1) {
            return Messages.PlatformCameraLensDirection.BACK;
        }
        if (i == 2) {
            return Messages.PlatformCameraLensDirection.EXTERNAL;
        }
        return Messages.PlatformCameraLensDirection.FRONT;
    }

    public static List<Messages.PlatformCameraDescription> getAvailableCameras(Activity activity) throws CameraAccessException {
        int i;
        CameraManager cameraManager = (CameraManager) activity.getSystemService("camera");
        String[] cameraIdList = cameraManager.getCameraIdList();
        ArrayList arrayList = new ArrayList();
        for (String str : cameraIdList) {
            try {
                i = Integer.parseInt(str, 10);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i >= 0) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                arrayList.add(new Messages.PlatformCameraDescription.Builder().setName(str).setSensorOrientation(Long.valueOf(((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue())).setLensDirection(lensDirectionFromInteger(((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue())).build());
            }
        }
        return arrayList;
    }

    public static Messages.PlatformDeviceOrientation orientationToPigeon(PlatformChannel.DeviceOrientation deviceOrientation) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[deviceOrientation.ordinal()];
        if (i == 1) {
            return Messages.PlatformDeviceOrientation.PORTRAIT_UP;
        }
        if (i == 2) {
            return Messages.PlatformDeviceOrientation.PORTRAIT_DOWN;
        }
        if (i == 3) {
            return Messages.PlatformDeviceOrientation.LANDSCAPE_LEFT;
        }
        if (i == 4) {
            return Messages.PlatformDeviceOrientation.LANDSCAPE_RIGHT;
        }
        return Messages.PlatformDeviceOrientation.PORTRAIT_UP;
    }

    public static PlatformChannel.DeviceOrientation orientationFromPigeon(Messages.PlatformDeviceOrientation platformDeviceOrientation) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$Messages$PlatformDeviceOrientation[platformDeviceOrientation.ordinal()];
        if (i == 1) {
            return PlatformChannel.DeviceOrientation.PORTRAIT_UP;
        }
        if (i == 2) {
            return PlatformChannel.DeviceOrientation.PORTRAIT_DOWN;
        }
        if (i == 3) {
            return PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT;
        }
        if (i == 4) {
            return PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static Messages.PlatformFocusMode focusModeToPigeon(FocusMode focusMode) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[focusMode.ordinal()];
        if (i == 1) {
            return Messages.PlatformFocusMode.AUTO;
        }
        if (i == 2) {
            return Messages.PlatformFocusMode.LOCKED;
        }
        return Messages.PlatformFocusMode.AUTO;
    }

    public static FocusMode focusModeFromPigeon(Messages.PlatformFocusMode platformFocusMode) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$Messages$PlatformFocusMode[platformFocusMode.ordinal()];
        if (i == 1) {
            return FocusMode.auto;
        }
        if (i == 2) {
            return FocusMode.locked;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static Messages.PlatformExposureMode exposureModeToPigeon(ExposureMode exposureMode) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$exposurelock$ExposureMode[exposureMode.ordinal()];
        if (i == 1) {
            return Messages.PlatformExposureMode.AUTO;
        }
        if (i == 2) {
            return Messages.PlatformExposureMode.LOCKED;
        }
        return Messages.PlatformExposureMode.AUTO;
    }

    public static ExposureMode exposureModeFromPigeon(Messages.PlatformExposureMode platformExposureMode) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$Messages$PlatformExposureMode[platformExposureMode.ordinal()];
        if (i == 1) {
            return ExposureMode.auto;
        }
        if (i == 2) {
            return ExposureMode.locked;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static ResolutionPreset resolutionPresetFromPigeon(Messages.PlatformResolutionPreset platformResolutionPreset) {
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset[platformResolutionPreset.ordinal()]) {
            case 1:
                return ResolutionPreset.low;
            case 2:
                return ResolutionPreset.medium;
            case 3:
                return ResolutionPreset.high;
            case 4:
                return ResolutionPreset.veryHigh;
            case 5:
                return ResolutionPreset.ultraHigh;
            case 6:
                return ResolutionPreset.max;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }

    public static Integer imageFormatGroupFromPigeon(Messages.PlatformImageFormatGroup platformImageFormatGroup) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$Messages$PlatformImageFormatGroup[platformImageFormatGroup.ordinal()];
        if (i == 1) {
            return 35;
        }
        if (i == 2) {
            return 256;
        }
        if (i == 3) {
            return 17;
        }
        throw new IllegalStateException("Unreachable code");
    }

    /* renamed from: io.flutter.plugins.camera.CameraUtils$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$Messages$PlatformDeviceOrientation;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$Messages$PlatformExposureMode;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFlashMode;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFocusMode;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$Messages$PlatformImageFormatGroup;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$exposurelock$ExposureMode;

        static {
            int[] iArr = new int[Messages.PlatformFlashMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFlashMode = iArr;
            try {
                iArr[Messages.PlatformFlashMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFlashMode[Messages.PlatformFlashMode.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFlashMode[Messages.PlatformFlashMode.ALWAYS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFlashMode[Messages.PlatformFlashMode.TORCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Messages.PlatformImageFormatGroup.values().length];
            $SwitchMap$io$flutter$plugins$camera$Messages$PlatformImageFormatGroup = iArr2;
            try {
                iArr2[Messages.PlatformImageFormatGroup.YUV420.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformImageFormatGroup[Messages.PlatformImageFormatGroup.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformImageFormatGroup[Messages.PlatformImageFormatGroup.NV21.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[Messages.PlatformResolutionPreset.values().length];
            $SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset = iArr3;
            try {
                iArr3[Messages.PlatformResolutionPreset.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset[Messages.PlatformResolutionPreset.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset[Messages.PlatformResolutionPreset.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset[Messages.PlatformResolutionPreset.VERY_HIGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset[Messages.PlatformResolutionPreset.ULTRA_HIGH.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformResolutionPreset[Messages.PlatformResolutionPreset.MAX.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr4 = new int[Messages.PlatformExposureMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$Messages$PlatformExposureMode = iArr4;
            try {
                iArr4[Messages.PlatformExposureMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformExposureMode[Messages.PlatformExposureMode.LOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr5 = new int[ExposureMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$exposurelock$ExposureMode = iArr5;
            try {
                iArr5[ExposureMode.auto.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$exposurelock$ExposureMode[ExposureMode.locked.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            int[] iArr6 = new int[Messages.PlatformFocusMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFocusMode = iArr6;
            try {
                iArr6[Messages.PlatformFocusMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformFocusMode[Messages.PlatformFocusMode.LOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            int[] iArr7 = new int[FocusMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode = iArr7;
            try {
                iArr7[FocusMode.auto.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[FocusMode.locked.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            int[] iArr8 = new int[Messages.PlatformDeviceOrientation.values().length];
            $SwitchMap$io$flutter$plugins$camera$Messages$PlatformDeviceOrientation = iArr8;
            try {
                iArr8[Messages.PlatformDeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformDeviceOrientation[Messages.PlatformDeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformDeviceOrientation[Messages.PlatformDeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$Messages$PlatformDeviceOrientation[Messages.PlatformDeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
            int[] iArr9 = new int[PlatformChannel.DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr9;
            try {
                iArr9[PlatformChannel.DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    public static FlashMode flashModeFromPigeon(Messages.PlatformFlashMode platformFlashMode) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$Messages$PlatformFlashMode[platformFlashMode.ordinal()];
        if (i == 1) {
            return FlashMode.auto;
        }
        if (i == 2) {
            return FlashMode.off;
        }
        if (i == 3) {
            return FlashMode.always;
        }
        if (i == 4) {
            return FlashMode.torch;
        }
        throw new IllegalStateException("Unreachable code");
    }
}
