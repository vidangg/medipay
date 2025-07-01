package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzps {
    final String zza;
    long zzb;

    private zzps(zzpv zzpvVar, String str) {
        this.zza = str;
        this.zzb = zzpvVar.zzaU().elapsedRealtime();
    }
}
