package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzkw implements Runnable {
    final /* synthetic */ zzlw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zzb();
    }
}
