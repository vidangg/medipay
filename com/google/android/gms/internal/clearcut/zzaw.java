package com.google.android.gms.internal.clearcut;

/* loaded from: classes3.dex */
final class zzaw {
    private static final Class<?> zzfb = zze("libcore.io.Memory");
    private static final boolean zzfc;

    static {
        zzfc = zze("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> zze(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzx() {
        return (zzfb == null || zzfc) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> zzy() {
        return zzfb;
    }
}
