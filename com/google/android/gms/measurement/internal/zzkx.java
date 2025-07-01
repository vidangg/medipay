package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
final class zzkx implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzlw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkx(zzlw zzlwVar, long j) {
        this.zza = j;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzio zzioVar = this.zzb.zzu;
        zzhp zzhpVar = zzioVar.zzm().zzf;
        long j = this.zza;
        zzhpVar.zzb(j);
        zzioVar.zzaW().zzd().zzb("Session timeout duration set", Long.valueOf(j));
    }
}
