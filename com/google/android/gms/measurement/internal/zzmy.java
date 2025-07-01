package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzmy implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzqb zzc;
    final /* synthetic */ zzny zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmy(zzny zznyVar, zzr zzrVar, boolean z, zzqb zzqbVar) {
        this.zza = zzrVar;
        this.zzb = z;
        this.zzc = zzqbVar;
        this.zzd = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgl zzglVar;
        zzny zznyVar = this.zzd;
        zzglVar = zznyVar.zzb;
        if (zzglVar == null) {
            zznyVar.zzu.zzaW().zze().zza("Discarding data. Failed to set user property");
            return;
        }
        zzr zzrVar = this.zza;
        Preconditions.checkNotNull(zzrVar);
        zznyVar.zzP(zzglVar, this.zzb ? null : this.zzc, zzrVar);
        zznyVar.zzag();
    }
}
