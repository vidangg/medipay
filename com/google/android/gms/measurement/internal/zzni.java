package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzni extends zzaz {
    final /* synthetic */ zzny zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzni(zzny zznyVar, zzjs zzjsVar) {
        super(zzjsVar);
        this.zza = zznyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zzc() {
        this.zza.zzu.zzaW().zzk().zza("Tasks have been queued for a long time");
    }
}
