package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzoe implements Runnable {
    final /* synthetic */ zzpv zza;
    final /* synthetic */ Runnable zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoe(zzog zzogVar, zzpv zzpvVar, Runnable runnable) {
        this.zza = zzpvVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzL();
        zzpvVar.zzK(this.zzb);
        zzpvVar.zzat();
    }
}
