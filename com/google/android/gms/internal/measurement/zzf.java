package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzf {
    final zzax zza;
    final zzg zzb;
    final zzg zzc;
    final zzj zzd;

    public zzf() {
        zzax zzaxVar = new zzax();
        this.zza = zzaxVar;
        zzg zzgVar = new zzg(null, zzaxVar);
        this.zzc = zzgVar;
        this.zzb = zzgVar.zza();
        zzj zzjVar = new zzj();
        this.zzd = zzjVar;
        zzgVar.zzg("require", new zzw(zzjVar));
        zzjVar.zza("internal.platform", new Callable() { // from class: com.google.android.gms.internal.measurement.zze
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzy();
            }
        });
        zzgVar.zzg("runtime.counter", new zzah(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)));
    }

    public final zzap zza(zzg zzgVar, zziz... zzizVarArr) {
        zzap zzapVar = zzap.zzf;
        for (zziz zzizVar : zzizVarArr) {
            zzapVar = zzi.zza(zzizVar);
            zzh.zzc(this.zzc);
            if ((zzapVar instanceof zzaq) || (zzapVar instanceof zzao)) {
                zzapVar = this.zza.zza(zzgVar, zzapVar);
            }
        }
        return zzapVar;
    }
}
