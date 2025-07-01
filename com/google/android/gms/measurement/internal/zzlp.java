package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlp implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzlw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlp(zzlw zzlwVar, Boolean bool) {
        this.zza = bool;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzas(this.zza, true);
    }
}
