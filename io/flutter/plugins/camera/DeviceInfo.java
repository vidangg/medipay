package io.flutter.plugins.camera;

import android.os.Build;

/* loaded from: classes4.dex */
public class DeviceInfo {
    public static String BRAND = Build.BRAND;
    public static String MODEL = Build.MODEL;

    public static String getBrand() {
        return BRAND;
    }

    public static String getModel() {
        return MODEL;
    }
}
