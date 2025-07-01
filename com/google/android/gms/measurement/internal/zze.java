package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
final class zze {
    private final zzju zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zze zza(String str) {
        zzju zzjuVar;
        if (TextUtils.isEmpty(str) || str.length() > 1) {
            zzjuVar = zzju.UNINITIALIZED;
        } else {
            zzjuVar = zzjx.zzg(str.charAt(0));
        }
        return new zze(zzjuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzju zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzc() {
        return String.valueOf(zzjx.zza(this.zza));
    }
}
