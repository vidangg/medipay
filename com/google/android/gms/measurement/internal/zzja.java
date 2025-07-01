package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzja implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ zzjp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(zzjp zzjpVar, zzai zzaiVar) {
        this.zza = zzaiVar;
        this.zzb = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        zzpv zzpvVar3;
        zzjp zzjpVar = this.zzb;
        zzpvVar = zzjpVar.zza;
        zzpvVar.zzL();
        zzai zzaiVar = this.zza;
        if (zzaiVar.zzc.zza() == null) {
            zzpvVar3 = zzjpVar.zza;
            zzpvVar3.zzae(zzaiVar);
        } else {
            zzpvVar2 = zzjpVar.zza;
            zzpvVar2.zzan(zzaiVar);
        }
    }
}
