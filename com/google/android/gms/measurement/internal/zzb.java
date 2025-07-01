package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzd zzdVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd.zzb(this.zzc, this.zza, this.zzb);
    }
}
