package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbkj {
    public static int zba(int i, int i2, String str) {
        String zba;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            zba = zbkp.zba("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            zba = zbkp.zba("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(zba);
    }

    public static int zbb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zbe(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static void zbc(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zbd(int i, int i2, int i3) {
        String zbe;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                zbe = zbe(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                zbe = zbe(i2, i3, "end index");
            } else {
                zbe = zbkp.zba("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(zbe);
        }
    }

    private static String zbe(int i, int i2, String str) {
        if (i < 0) {
            return zbkp.zba("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return zbkp.zba("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }
}
