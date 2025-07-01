package com.google.android.gms.measurement.internal;

import androidx.media3.exoplayer.ExoPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzld extends zzaz {
    final /* synthetic */ zzlw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzld(zzlw zzlwVar, zzjs zzjsVar) {
        super(zzjsVar);
        this.zza = zzlwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zzc() {
        zzaz zzazVar;
        zzlw zzlwVar = this.zza;
        if (zzlwVar.zzu.zzO()) {
            zzazVar = zzlwVar.zzr;
            zzazVar.zzd(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }
}
