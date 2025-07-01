package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlc implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzlw zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlc(zzlw zzlwVar, AtomicReference atomicReference, boolean z) {
        this.zza = atomicReference;
        this.zzb = z;
        this.zzc = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzu.zzu().zzJ(this.zza, this.zzb);
    }
}
