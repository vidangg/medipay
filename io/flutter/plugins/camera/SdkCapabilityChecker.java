package io.flutter.plugins.camera;

import android.os.Build;

/* loaded from: classes4.dex */
public class SdkCapabilityChecker {
    public static int SDK_VERSION = Build.VERSION.SDK_INT;

    public static boolean supportsDistortionCorrection() {
        return SDK_VERSION >= 28;
    }

    public static boolean supportsEglRecordableAndroid() {
        return SDK_VERSION >= 26;
    }

    public static boolean supportsEncoderProfiles() {
        return SDK_VERSION >= 31;
    }

    public static boolean supportsMarshmallowNoiseReductionModes() {
        return SDK_VERSION >= 23;
    }

    public static boolean supportsSessionConfiguration() {
        return SDK_VERSION >= 28;
    }

    public static boolean supportsVideoPause() {
        return SDK_VERSION >= 24;
    }

    public static boolean supportsZoomRatio() {
        return SDK_VERSION >= 30;
    }
}
