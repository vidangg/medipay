package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzun {
    private static zzum zza;

    public static synchronized zzuc zza(zztu zztuVar) {
        zzuc zzucVar;
        synchronized (zzun.class) {
            if (zza == null) {
                zza = new zzum(null);
            }
            zzucVar = (zzuc) zza.get(zztuVar);
        }
        return zzucVar;
    }

    public static synchronized zzuc zzb(String str) {
        zzuc zza2;
        synchronized (zzun.class) {
            zza2 = zza(zztu.zzd(str).zzd());
        }
        return zza2;
    }
}
