package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzli implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzlw zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzli(zzlw zzlwVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        this.zze = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzu.zzu().zzL(this.zza, null, this.zzb, this.zzc, this.zzd);
    }
}
