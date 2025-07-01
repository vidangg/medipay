package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
final class zzoi implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzop zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoi(zzop zzopVar, long j) {
        this.zza = j;
        this.zzb = zzopVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzop.zzj(this.zzb, this.zza);
    }
}
