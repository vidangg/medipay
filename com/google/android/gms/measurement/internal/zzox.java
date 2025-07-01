package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzox extends zzaz {
    final /* synthetic */ zzoy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzox(zzoy zzoyVar, zzjs zzjsVar) {
        super(zzjsVar);
        this.zza = zzoyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zzc() {
        zzoy zzoyVar = this.zza;
        zzoyVar.zza();
        zzoyVar.zzu.zzaW().zzj().zza("Starting upload from DelayedRunnable");
        zzoyVar.zzg.zzat();
    }
}
