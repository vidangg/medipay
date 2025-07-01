package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzla implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzlw zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzla(zzlw zzlwVar, String str, String str2, Object obj, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
        this.zze = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzan(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
