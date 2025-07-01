package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzpp implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzpq zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpp(zzpq zzpqVar, String str, String str2, Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
        this.zzd = zzpqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar = this.zzd.zza;
        zzqf zzB = zzpvVar.zzB();
        long currentTimeMillis = zzpvVar.zzaU().currentTimeMillis();
        String str = this.zza;
        zzpvVar.zzT((zzbh) Preconditions.checkNotNull(zzB.zzC(str, this.zzb, this.zzc, "auto", currentTimeMillis, false, true)), str);
    }
}
