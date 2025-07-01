package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlq implements Runnable {
    final /* synthetic */ zzba zza;
    final /* synthetic */ zzlw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlq(zzlw zzlwVar, zzba zzbaVar) {
        this.zza = zzbaVar;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlw zzlwVar = this.zzb;
        zzio zzioVar = zzlwVar.zzu;
        zzht zzm = zzioVar.zzm();
        zzio zzioVar2 = zzm.zzu;
        zzm.zzg();
        zzba zzf = zzm.zzf();
        zzba zzbaVar = this.zza;
        if (zzjx.zzs(zzbaVar.zza(), zzf.zza())) {
            SharedPreferences.Editor edit = zzm.zzb().edit();
            edit.putString("dma_consent_settings", zzbaVar.zzj());
            edit.apply();
            zzioVar.zzaW().zzj().zzb("Setting DMA consent(FE)", zzbaVar);
            zzio zzioVar3 = zzlwVar.zzu;
            if (zzioVar3.zzu().zzac()) {
                zzioVar3.zzu().zzU();
                return;
            } else {
                zzioVar3.zzu().zzR(false);
                return;
            }
        }
        zzioVar.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzbaVar.zza()));
    }
}
