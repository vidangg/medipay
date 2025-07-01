package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzno implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcy zzd;
    final /* synthetic */ zzny zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzno(zzny zznyVar, String str, String str2, zzr zzrVar, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzrVar;
        this.zzd = zzcyVar;
        this.zze = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcy zzcyVar;
        zzqf zzw;
        zzny zznyVar;
        zzgl zzglVar;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zznyVar = this.zze;
                zzglVar = zznyVar.zzb;
            } catch (RemoteException e) {
                this.zze.zzu.zzaW().zze().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
            }
            if (zzglVar == null) {
                zzio zzioVar = zznyVar.zzu;
                zzioVar.zzaW().zze().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzw = zzioVar.zzw();
                zzcyVar = this.zzd;
                zzw.zzU(zzcyVar, arrayList);
            }
            zzr zzrVar = this.zzc;
            Preconditions.checkNotNull(zzrVar);
            arrayList = zzqf.zzK(zzglVar.zzi(this.zza, this.zzb, zzrVar));
            zznyVar.zzag();
            zzny zznyVar2 = this.zze;
            zzcyVar = this.zzd;
            zzw = zznyVar2.zzu.zzw();
            zzw.zzU(zzcyVar, arrayList);
        } catch (Throwable th) {
            zzny zznyVar3 = this.zze;
            zznyVar3.zzu.zzw().zzU(this.zzd, arrayList);
            throw th;
        }
    }
}
