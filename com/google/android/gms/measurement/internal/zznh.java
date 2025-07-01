package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznh implements Runnable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcy zzc;
    final /* synthetic */ zzny zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznh(zzny zznyVar, zzbh zzbhVar, String str, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.zza = zzbhVar;
        this.zzb = str;
        this.zzc = zzcyVar;
        this.zzd = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcy zzcyVar;
        zzqf zzw;
        zzny zznyVar;
        zzgl zzglVar;
        byte[] bArr = null;
        try {
            try {
                zznyVar = this.zzd;
                zzglVar = zznyVar.zzb;
            } catch (RemoteException e) {
                this.zzd.zzu.zzaW().zze().zzb("Failed to send event to the service to bundle", e);
            }
            if (zzglVar == null) {
                zzio zzioVar = zznyVar.zzu;
                zzioVar.zzaW().zze().zza("Discarding data. Failed to send event to service to bundle");
                zzw = zzioVar.zzw();
                zzcyVar = this.zzc;
                zzw.zzW(zzcyVar, bArr);
            }
            bArr = zzglVar.zzD(this.zza, this.zzb);
            zznyVar.zzag();
            zzny zznyVar2 = this.zzd;
            zzcyVar = this.zzc;
            zzw = zznyVar2.zzu.zzw();
            zzw.zzW(zzcyVar, bArr);
        } catch (Throwable th) {
            zzny zznyVar3 = this.zzd;
            zznyVar3.zzu.zzw().zzW(this.zzc, null);
            throw th;
        }
    }
}
