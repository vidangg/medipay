package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
final class zzkv implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzlw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkv(zzlw zzlwVar, boolean z) {
        this.zza = z;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlw zzlwVar = this.zzb;
        zzio zzioVar = zzlwVar.zzu;
        boolean zzJ = zzioVar.zzJ();
        boolean zzI = zzioVar.zzI();
        boolean z = this.zza;
        zzioVar.zzF(z);
        if (zzI == z) {
            zzioVar.zzaW().zzj().zzb("Default data collection state already set to", Boolean.valueOf(z));
        }
        if (zzioVar.zzJ() == zzJ || zzioVar.zzJ() != zzioVar.zzI()) {
            zzioVar.zzaW().zzl().zzc("Default data collection is different than actual status", Boolean.valueOf(z), Boolean.valueOf(zzJ));
        }
        zzlwVar.zzat();
    }
}
