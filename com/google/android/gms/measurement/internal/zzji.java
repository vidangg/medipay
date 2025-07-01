package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzji implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzjp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzji(zzjp zzjpVar, zzr zzrVar) {
        this.zza = zzrVar;
        this.zzb = zzjpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        zzjp zzjpVar = this.zzb;
        zzpvVar = zzjpVar.zza;
        zzpvVar.zzL();
        zzr zzrVar = this.zza;
        zzpvVar2 = zzjpVar.zza;
        return new zzap(zzpvVar2.zzd(zzrVar.zza));
    }
}
