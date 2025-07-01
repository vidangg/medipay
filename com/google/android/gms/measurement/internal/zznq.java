package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
final class zznq implements Runnable {
    final /* synthetic */ zzgl zza;
    final /* synthetic */ zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznq(zznx zznxVar, zzgl zzglVar) {
        this.zza = zzglVar;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznx zznxVar = this.zzb;
        synchronized (zznxVar) {
            zznxVar.zzb = false;
            zzny zznyVar = zznxVar.zza;
            if (!zznyVar.zzaa()) {
                zznyVar.zzu.zzaW().zzj().zza("Connected to service");
                zznyVar.zzW(this.zza);
            }
        }
    }
}
