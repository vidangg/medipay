package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzin implements Runnable {
    final /* synthetic */ zzke zza;
    final /* synthetic */ zzio zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzin(zzio zzioVar, zzke zzkeVar) {
        this.zza = zzkeVar;
        this.zzb = zzioVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzio zzioVar = this.zzb;
        zzke zzkeVar = this.zza;
        zzio.zzC(zzioVar, zzkeVar);
        zzioVar.zzH(zzkeVar.zzg);
    }
}
