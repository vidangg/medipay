package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public final class zzdo {
    public static zzdj zza(zzdj zzdjVar) {
        if ((zzdjVar instanceof zzdm) || (zzdjVar instanceof zzdk)) {
            return zzdjVar;
        }
        if (zzdjVar instanceof Serializable) {
            return new zzdk(zzdjVar);
        }
        return new zzdm(zzdjVar);
    }

    public static zzdj zzb(Object obj) {
        return new zzdn(obj);
    }
}
