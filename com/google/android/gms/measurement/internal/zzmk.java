package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzmk implements Runnable {
    final /* synthetic */ zzmo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmk(zzmo zzmoVar) {
        this.zza = zzmoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmh zzmhVar;
        zzmo zzmoVar = this.zza;
        zzmhVar = zzmoVar.zzh;
        zzmoVar.zza = zzmhVar;
    }
}
