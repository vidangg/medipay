package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpk implements Runnable {
    final /* synthetic */ zzpw zza;
    final /* synthetic */ zzpv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpk(zzpv zzpvVar, zzpw zzpwVar) {
        this.zza = zzpwVar;
        this.zzb = zzpvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar = this.zzb;
        zzpv.zzH(zzpvVar, this.zza);
        zzpvVar.zzam();
    }
}
