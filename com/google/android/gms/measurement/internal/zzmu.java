package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzmu implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcy zze;
    final /* synthetic */ zzny zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmu(zzny zznyVar, String str, String str2, zzr zzrVar, boolean z, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzrVar;
        this.zzd = z;
        this.zze = zzcyVar;
        this.zzf = zznyVar;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b2: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:44:0x00b1 */
    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e;
        Bundle bundle2;
        zzgl zzglVar;
        Bundle bundle3 = new Bundle();
        try {
            try {
                zzny zznyVar = this.zzf;
                zzglVar = zznyVar.zzb;
                if (zzglVar == null) {
                    zzio zzioVar = zznyVar.zzu;
                    zzioVar.zzaW().zze().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                    zzioVar.zzw().zzV(this.zze, bundle3);
                    return;
                }
                zzr zzrVar = this.zzc;
                Preconditions.checkNotNull(zzrVar);
                List<zzqb> zzk = zzglVar.zzk(this.zza, this.zzb, this.zzd, zzrVar);
                int i = zzqf.zza;
                bundle = new Bundle();
                if (zzk != null) {
                    for (zzqb zzqbVar : zzk) {
                        String str = zzqbVar.zze;
                        if (str != null) {
                            bundle.putString(zzqbVar.zzb, str);
                        } else {
                            Long l = zzqbVar.zzd;
                            if (l != null) {
                                bundle.putLong(zzqbVar.zzb, l.longValue());
                            } else {
                                Double d = zzqbVar.zzg;
                                if (d != null) {
                                    bundle.putDouble(zzqbVar.zzb, d.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    zznyVar.zzag();
                    zzio zzioVar2 = zznyVar.zzu;
                    zzioVar2.zzw().zzV(this.zze, bundle);
                } catch (RemoteException e2) {
                    e = e2;
                    this.zzf.zzu.zzaW().zze().zzc("Failed to get user properties; remote exception", this.zza, e);
                    zzny zznyVar2 = this.zzf;
                    zznyVar2.zzu.zzw().zzV(this.zze, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle3 = bundle2;
                zzny zznyVar3 = this.zzf;
                zznyVar3.zzu.zzw().zzV(this.zze, bundle3);
                throw th;
            }
        } catch (RemoteException e3) {
            bundle = bundle3;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            zzny zznyVar32 = this.zzf;
            zznyVar32.zzu.zzw().zzV(this.zze, bundle3);
            throw th;
        }
    }
}
