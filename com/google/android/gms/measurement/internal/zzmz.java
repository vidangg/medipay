package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzmz implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzny zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmz(zzny zznyVar, zzr zzrVar) {
        this.zza = zzrVar;
        this.zzb = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgl zzglVar;
        zzny zznyVar = this.zzb;
        zzglVar = zznyVar.zzb;
        if (zzglVar == null) {
            zznyVar.zzu.zzaW().zze().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzr zzrVar = this.zza;
            Preconditions.checkNotNull(zzrVar);
            zzglVar.zzs(zzrVar);
        } catch (RemoteException e) {
            this.zzb.zzu.zzaW().zze().zzb("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzag();
    }
}
