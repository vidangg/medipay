package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzid implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzif zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzid(zzif zzifVar) {
        this.zza = zzifVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzhc zzd;
        int i2 = i - 1;
        if (i2 == 0) {
            zzd = this.zza.zzu.zzaW().zzd();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzd = this.zza.zzu.zzaW().zzj();
            } else if (i2 != 4) {
                zzd = this.zza.zzu.zzaW().zzi();
            } else if (z) {
                zzd = this.zza.zzu.zzaW().zzm();
            } else if (!z2) {
                zzd = this.zza.zzu.zzaW().zzl();
            } else {
                zzd = this.zza.zzu.zzaW().zzk();
            }
        } else if (z) {
            zzd = this.zza.zzu.zzaW().zzh();
        } else if (!z2) {
            zzd = this.zza.zzu.zzaW().zzf();
        } else {
            zzd = this.zza.zzu.zzaW().zze();
        }
        int size = list.size();
        if (size == 1) {
            zzd.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzd.zzc(str, list.get(0), list.get(1));
        } else if (size == 3) {
            zzd.zzd(str, list.get(0), list.get(1), list.get(2));
        } else {
            zzd.zza(str);
        }
    }
}
