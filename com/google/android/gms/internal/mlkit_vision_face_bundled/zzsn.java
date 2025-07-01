package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public final class zzsn {
    private static zzsn zza;

    private zzsn() {
    }

    public static synchronized zzsn zza() {
        zzsn zzsnVar;
        synchronized (zzsn.class) {
            if (zza == null) {
                zza = new zzsn();
            }
            zzsnVar = zza;
        }
        return zzsnVar;
    }
}
