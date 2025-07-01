package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznf implements Runnable {
    final /* synthetic */ zzmh zza;
    final /* synthetic */ zzny zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznf(zzny zznyVar, zzmh zzmhVar) {
        this.zza = zzmhVar;
        this.zzb = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgl zzglVar;
        zzny zznyVar = this.zzb;
        zzglVar = zznyVar.zzb;
        if (zzglVar == null) {
            zznyVar.zzu.zzaW().zze().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzmh zzmhVar = this.zza;
            if (zzmhVar == null) {
                zzglVar.zzw(0L, null, null, zznyVar.zzu.zzaT().getPackageName());
            } else {
                zzglVar.zzw(zzmhVar.zzc, zzmhVar.zza, zzmhVar.zzb, zznyVar.zzu.zzaT().getPackageName());
            }
            zznyVar.zzag();
        } catch (RemoteException e) {
            this.zzb.zzu.zzaW().zze().zzb("Failed to send current screen to the service", e);
        }
    }
}
