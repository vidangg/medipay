package com.google.android.gms.measurement.internal;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
final class zzns implements Runnable {
    final /* synthetic */ zzgl zza;
    final /* synthetic */ zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzns(zznx zznxVar, zzgl zzglVar) {
        this.zza = zzglVar;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2;
        zznx zznxVar = this.zzb;
        synchronized (zznxVar) {
            zznxVar.zzb = false;
            zzny zznyVar = zznxVar.zza;
            if (!zznyVar.zzaa()) {
                zznyVar.zzu.zzaW().zzd().zza("Connected to remote service");
                zznyVar.zzW(this.zza);
            }
        }
        zzny zznyVar2 = this.zzb.zza;
        if (zznyVar2.zzu.zzf().zzx(null, zzgi.zzbo)) {
            scheduledExecutorService = zznyVar2.zze;
            if (scheduledExecutorService != null) {
                scheduledExecutorService2 = zznyVar2.zze;
                scheduledExecutorService2.shutdownNow();
                zznyVar2.zze = null;
            }
        }
    }
}
