package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zziy implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzjp zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziy(zzjp zzjpVar, String str, String str2, String str3, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
        this.zze = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        String str = this.zza;
        if (str == null) {
            zzjp zzjpVar = this.zze;
            String str2 = this.zzb;
            zzpvVar2 = zzjpVar.zza;
            zzpvVar2.zzaj(str2, null);
            return;
        }
        zzmh zzmhVar = new zzmh(this.zzc, str, this.zzd);
        zzjp zzjpVar2 = this.zze;
        String str3 = this.zzb;
        zzpvVar = zzjpVar2.zza;
        zzpvVar.zzaj(str3, zzmhVar);
    }
}
