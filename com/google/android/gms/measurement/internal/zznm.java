package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznm implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzai zzc;
    final /* synthetic */ zzny zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznm(zzny zznyVar, boolean z, zzr zzrVar, boolean z2, zzai zzaiVar, zzai zzaiVar2) {
        this.zza = zzrVar;
        this.zzb = z2;
        this.zzc = zzaiVar;
        this.zzd = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgl zzglVar;
        zzny zznyVar = this.zzd;
        zzglVar = zznyVar.zzb;
        if (zzglVar == null) {
            zznyVar.zzu.zzaW().zze().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        zzr zzrVar = this.zza;
        Preconditions.checkNotNull(zzrVar);
        zznyVar.zzP(zzglVar, this.zzb ? null : this.zzc, zzrVar);
        zznyVar.zzag();
    }
}
