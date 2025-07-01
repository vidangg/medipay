package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznb implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcy zzb;
    final /* synthetic */ zzny zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznb(zzny zznyVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.zza = zzrVar;
        this.zzb = zzcyVar;
        this.zzc = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcy zzcyVar;
        zzqf zzw;
        zzny zznyVar;
        zzio zzioVar;
        zzgl zzglVar;
        String str = null;
        try {
            try {
                zznyVar = this.zzc;
                zzioVar = zznyVar.zzu;
            } catch (RemoteException e) {
                this.zzc.zzu.zzaW().zze().zzb("Failed to get app instance id", e);
            }
            if (zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
                zzglVar = zznyVar.zzb;
                if (zzglVar != null) {
                    zzr zzrVar = this.zza;
                    Preconditions.checkNotNull(zzrVar);
                    str = zzglVar.zzf(zzrVar);
                    if (str != null) {
                        zznyVar.zzu.zzq().zzac(str);
                        zzioVar.zzm().zze.zzb(str);
                    }
                    zznyVar.zzag();
                    zzny zznyVar2 = this.zzc;
                    zzcyVar = this.zzb;
                    zzw = zznyVar2.zzu.zzw();
                    zzw.zzZ(zzcyVar, str);
                }
                zzioVar.zzaW().zze().zza("Failed to get app instance id");
            } else {
                zzioVar.zzaW().zzl().zza("Analytics storage consent denied; will not get app instance id");
                zznyVar.zzu.zzq().zzac(null);
                zzioVar.zzm().zze.zzb(null);
            }
            zzw = zzioVar.zzw();
            zzcyVar = this.zzb;
            zzw.zzZ(zzcyVar, str);
        } catch (Throwable th) {
            zzny zznyVar3 = this.zzc;
            zznyVar3.zzu.zzw().zzZ(this.zzb, null);
            throw th;
        }
    }
}
