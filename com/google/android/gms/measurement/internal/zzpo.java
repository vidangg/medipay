package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpo implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzpv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpo(zzpv zzpvVar, zzr zzrVar) {
        this.zza = zzrVar;
        this.zzb = zzpvVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzr zzrVar = this.zza;
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        zzpv zzpvVar = this.zzb;
        zzjx zzu = zzpvVar.zzu(str);
        zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
        if (!zzu.zzr(zzjwVar) || !zzjx.zzk(zzrVar.zzu, 100).zzr(zzjwVar)) {
            zzpvVar.zzaW().zzj().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        return zzpvVar.zzg(zzrVar).zzD();
    }
}
