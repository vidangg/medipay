package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlh implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzlw zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlh(zzlw zzlwVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zzu.zzu().zzG(this.zza, null, this.zzb, this.zzc);
    }
}
