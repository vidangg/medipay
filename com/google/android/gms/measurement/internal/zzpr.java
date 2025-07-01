package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpr {
    com.google.android.gms.internal.measurement.zzhx zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzpv zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpr(zzpv zzpvVar, zzpu zzpuVar) {
        this.zze = zzpvVar;
    }

    private static final long zzb(com.google.android.gms.internal.measurement.zzhm zzhmVar) {
        return ((zzhmVar.zzd() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, com.google.android.gms.internal.measurement.zzhm zzhmVar) {
        Preconditions.checkNotNull(zzhmVar);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (!this.zzc.isEmpty() && zzb((com.google.android.gms.internal.measurement.zzhm) this.zzc.get(0)) != zzb(zzhmVar)) {
            return false;
        }
        long zzcf = this.zzd + zzhmVar.zzcf();
        zzpv zzpvVar = this.zze;
        if (zzpvVar.zzi().zzx(null, zzgi.zzbq)) {
            if (!this.zzc.isEmpty()) {
                zzpvVar.zzi();
                if (zzcf >= zzam.zzG()) {
                    return false;
                }
            }
        } else {
            zzpvVar.zzi();
            if (zzcf >= zzam.zzG()) {
                return false;
            }
        }
        this.zzd = zzcf;
        this.zzc.add(zzhmVar);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        zzpvVar.zzi();
        return size < Math.max(1, ((Integer) zzgi.zzj.zza(null)).intValue());
    }
}
