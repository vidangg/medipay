package com.google.android.gms.measurement.internal;

import android.os.Handler;
import androidx.media3.exoplayer.ExoPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzol {
    final /* synthetic */ zzop zza;
    private zzok zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzol(zzop zzopVar) {
        this.zza = zzopVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j) {
        Handler handler;
        zzop zzopVar = this.zza;
        this.zzb = new zzok(this, zzopVar.zzu.zzaU().currentTimeMillis(), j);
        handler = zzopVar.zzd;
        handler.postDelayed(this.zzb, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        Handler handler;
        zzop zzopVar = this.zza;
        zzopVar.zzg();
        zzok zzokVar = this.zzb;
        if (zzokVar != null) {
            handler = zzopVar.zzd;
            handler.removeCallbacks(zzokVar);
        }
        zzio zzioVar = zzopVar.zzu;
        zzioVar.zzm().zzn.zza(false);
        zzopVar.zzm(false);
        if (zzioVar.zzf().zzx(null, zzgi.zzaZ)) {
            zzio zzioVar2 = zzopVar.zzu;
            if (zzioVar2.zzq().zzap()) {
                zzioVar.zzaW().zzj().zza("Retrying trigger URI registration in foreground");
                zzioVar2.zzq().zzU();
            }
        }
    }
}
