package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzom extends zzaz {
    final /* synthetic */ zzon zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzom(zzon zzonVar, zzjs zzjsVar) {
        super(zzjsVar);
        this.zza = zzonVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zzc() {
        zzon zzonVar = this.zza;
        zzop zzopVar = zzonVar.zzc;
        zzopVar.zzg();
        zzio zzioVar = zzopVar.zzu;
        zzonVar.zzd(false, false, zzioVar.zzaU().elapsedRealtime());
        zzopVar.zzu.zzd().zzf(zzioVar.zzaU().elapsedRealtime());
    }
}
