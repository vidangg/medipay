package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public final class zzak {
    public static int zza(int i, int i2, String str) {
        String zza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            zza = zzal.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            zza = zzal.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzd(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static void zzc(int i, int i2, int i3) {
        String zzd;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                zzd = zzd(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                zzd = zzd(i2, i3, "end index");
            } else {
                zzd = zzal.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(zzd);
        }
    }

    private static String zzd(int i, int i2, String str) {
        if (i < 0) {
            return zzal.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return zzal.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }
}
