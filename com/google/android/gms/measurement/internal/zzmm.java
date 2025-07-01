package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzmm implements Runnable {
    final /* synthetic */ zzmh zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzmo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmm(zzmo zzmoVar, zzmh zzmhVar, long j) {
        this.zza = zzmhVar;
        this.zzb = j;
        this.zzc = zzmoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmo zzmoVar = this.zzc;
        zzmoVar.zzC(this.zza, false, this.zzb);
        zzmoVar.zza = null;
        zzmoVar.zzu.zzu().zzS(null);
    }
}
