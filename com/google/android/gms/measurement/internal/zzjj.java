package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzjj implements Runnable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjj(zzjp zzjpVar, zzbh zzbhVar, zzr zzrVar) {
        this.zza = zzbhVar;
        this.zzb = zzrVar;
        this.zzc = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbh zzbhVar = this.zza;
        zzr zzrVar = this.zzb;
        zzjp zzjpVar = this.zzc;
        zzjpVar.zzJ(zzjpVar.zzb(zzbhVar, zzrVar), zzrVar);
    }
}
