package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzjm implements Runnable {
    final /* synthetic */ zzqb zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjm(zzjp zzjpVar, zzqb zzqbVar, zzr zzrVar) {
        this.zza = zzqbVar;
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
        zzqb zzqbVar = this.zza;
        if (zzqbVar.zza() == null) {
            zzr zzrVar = this.zzb;
            zzpvVar3 = zzjpVar.zza;
            zzpvVar3.zzag(zzqbVar.zzb, zzrVar);
        } else {
            zzr zzrVar2 = this.zzb;
            zzpvVar2 = zzjpVar.zza;
            zzpvVar2.zzas(zzqbVar, zzrVar2);
        }
    }
}
