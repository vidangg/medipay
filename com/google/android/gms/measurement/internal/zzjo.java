package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzjo implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzjp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zzjp zzjpVar, zzr zzrVar, Bundle bundle) {
        this.zza = zzrVar;
        this.zzb = bundle;
        this.zzc = zzjpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        zzjp zzjpVar = this.zzc;
        zzpvVar = zzjpVar.zza;
        zzpvVar.zzL();
        zzpvVar2 = zzjpVar.zza;
        return zzpvVar2.zzF(this.zza, this.zzb);
    }
}
