package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zziz implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziz(zzjp zzjpVar, zzai zzaiVar, zzr zzrVar) {
        this.zza = zzaiVar;
        this.zzb = zzrVar;
        this.zzc = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        zzpv zzpvVar3;
        zzjp zzjpVar = this.zzc;
        zzpvVar = zzjpVar.zza;
        zzpvVar.zzL();
        zzai zzaiVar = this.zza;
        if (zzaiVar.zzc.zza() == null) {
            zzr zzrVar = this.zzb;
            zzpvVar3 = zzjpVar.zza;
            zzpvVar3.zzaf(zzaiVar, zzrVar);
        } else {
            zzr zzrVar2 = this.zzb;
            zzpvVar2 = zzjpVar.zza;
            zzpvVar2.zzao(zzaiVar, zzrVar2);
        }
    }
}
