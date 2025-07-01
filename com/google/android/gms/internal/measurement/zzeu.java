package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzeu implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzff zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeu(zzff zzffVar, boolean z) {
        this.zzk = zzffVar;
        this.zzh = zzffVar.zza.currentTimeMillis();
        this.zzi = zzffVar.zza.elapsedRealtime();
        this.zzj = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        z = this.zzk.zzh;
        if (z) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e) {
            this.zzk.zzU(e, false, this.zzj);
            zzb();
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
