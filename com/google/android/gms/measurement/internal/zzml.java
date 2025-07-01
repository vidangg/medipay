package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzml implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzmo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzml(zzmo zzmoVar, long j) {
        this.zza = j;
        this.zzb = zzmoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmo zzmoVar = this.zzb;
        zzmoVar.zzu.zzd().zzf(this.zza);
        zzmoVar.zza = null;
    }
}
