package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznw implements Runnable {
    final /* synthetic */ ConnectionResult zza;
    final /* synthetic */ zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznw(zznx zznxVar, ConnectionResult connectionResult) {
        this.zza = connectionResult;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2;
        zzny zznyVar = this.zzb.zza;
        zznyVar.zzb = null;
        if (!zznyVar.zzu.zzf().zzx(null, zzgi.zzbo) || this.zza.getErrorCode() != 7777) {
            zznyVar.zzaf();
            return;
        }
        scheduledExecutorService = zznyVar.zze;
        if (scheduledExecutorService == null) {
            zznyVar.zze = Executors.newScheduledThreadPool(1);
        }
        scheduledExecutorService2 = zznyVar.zze;
        scheduledExecutorService2.schedule(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznv
            @Override // java.lang.Runnable
            public final void run() {
                final zzny zznyVar2 = zznw.this.zzb.zza;
                zzil zzaX = zznyVar2.zzu.zzaX();
                Objects.requireNonNull(zznyVar2);
                zzaX.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznu
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzny.this.zzB();
                    }
                });
            }
        }, ((Long) zzgi.zzY.zza(null)).longValue(), TimeUnit.MILLISECONDS);
    }
}
