package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzhl implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzhm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(zzhm zzhmVar, boolean z) {
        this.zza = z;
        this.zzb = zzhmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar;
        zzpvVar = this.zzb.zza;
        zzpvVar.zzX(this.zza);
    }
}
