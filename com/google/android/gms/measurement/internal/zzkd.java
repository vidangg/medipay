package com.google.android.gms.measurement.internal;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzkd implements zzgw {
    final /* synthetic */ zzio zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkd(zzke zzkeVar, zzio zzioVar) {
        this.zza = zzioVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final boolean zza() {
        zzio zzioVar = this.zza;
        return zzioVar.zzL() && Log.isLoggable(zzioVar.zzaW().zzr(), 3);
    }
}
