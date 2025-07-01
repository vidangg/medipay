package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzjg implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzjp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjg(zzjp zzjpVar, zzr zzrVar) {
        this.zza = zzrVar;
        this.zzb = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        zzjp zzjpVar = this.zzb;
        zzpvVar = zzjpVar.zza;
        zzpvVar.zzL();
        zzpvVar2 = zzjpVar.zza;
        zzpvVar2.zzah(this.zza);
    }
}
