package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzoo {
    final /* synthetic */ zzop zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoo(zzop zzopVar) {
        this.zza = zzopVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzop zzopVar = this.zza;
        zzopVar.zzg();
        zzio zzioVar = zzopVar.zzu;
        if (zzioVar.zzm().zzp(zzioVar.zzaU().currentTimeMillis())) {
            zzioVar.zzm().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzioVar.zzaW().zzj().zza("Detected application was in foreground");
                zzc(zzioVar.zzaU().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j, boolean z) {
        zzop zzopVar = this.zza;
        zzopVar.zzg();
        zzopVar.zzq();
        zzio zzioVar = zzopVar.zzu;
        if (zzioVar.zzm().zzp(j)) {
            zzioVar.zzm().zzg.zza(true);
            zzopVar.zzu.zzh().zzq();
        }
        zzioVar.zzm().zzk.zzb(j);
        if (zzioVar.zzm().zzg.zzb()) {
            zzc(j, z);
        }
    }

    final void zzc(long j, boolean z) {
        zzop zzopVar = this.zza;
        zzopVar.zzg();
        if (zzopVar.zzu.zzJ()) {
            zzio zzioVar = zzopVar.zzu;
            zzioVar.zzm().zzk.zzb(j);
            zzioVar.zzaW().zzj().zzb("Session started, time", Long.valueOf(zzioVar.zzaU().elapsedRealtime()));
            long j2 = j / 1000;
            zzio zzioVar2 = zzopVar.zzu;
            Long valueOf = Long.valueOf(j2);
            zzioVar2.zzq().zzan("auto", "_sid", valueOf, j);
            zzhp zzhpVar = zzioVar.zzm().zzl;
            valueOf.getClass();
            zzhpVar.zzb(j2);
            zzioVar.zzm().zzg.zza(false);
            Bundle bundle = new Bundle();
            valueOf.getClass();
            bundle.putLong("_sid", j2);
            zzioVar2.zzq().zzS("auto", "_s", j, bundle);
            String zza = zzioVar.zzm().zzq.zza();
            if (TextUtils.isEmpty(zza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", zza);
            zzioVar2.zzq().zzS("auto", "_ssr", j, bundle2);
        }
    }
}
