package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbcq {
    public static final zbcq zba = new zbcq("VisionKit", 2);
    private final String zbb = "VisionKit";

    public zbcq(String str, int i) {
    }

    private final boolean zbd(int i) {
        return Log.isLoggable(this.zbb, i);
    }

    private static final String zbe(Object obj, String str, Object... objArr) {
        String str2;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            String name = obj.getClass().getName();
            if (obj instanceof Class) {
                name = ((Class) obj).getName();
            }
            String[] split = name.split("\\.");
            int length = split.length;
            str2 = length == 0 ? "" : split[length - 1];
        }
        return "[" + str2 + "] " + str;
    }

    public final void zba(Throwable th, String str, Object... objArr) {
        if (zbd(6)) {
            Log.e(this.zbb, "Error in result from JNI layer", th);
        }
    }

    public final void zbb(@Nullable Object obj, String str, Object... objArr) {
        if (zbd(4)) {
            Log.i(this.zbb, zbe(obj, str, objArr));
        }
    }

    public final void zbc(@Nullable Object obj, String str, Object... objArr) {
        if (zbd(5)) {
            Log.w(this.zbb, zbe(obj, str, objArr));
        }
    }
}
