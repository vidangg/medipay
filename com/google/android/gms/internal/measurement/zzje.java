package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzje {
    private static zzjd zza;

    public static synchronized zzjd zza() {
        zzjd zzjdVar;
        synchronized (zzje.class) {
            if (zza == null) {
                zzb(new zzjh());
            }
            zzjdVar = zza;
        }
        return zzjdVar;
    }

    public static synchronized void zzb(zzjd zzjdVar) {
        synchronized (zzje.class) {
            if (zza != null) {
                throw new IllegalStateException("init() already called");
            }
            zza = zzjdVar;
        }
    }
}
