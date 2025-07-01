package com.google.android.gms.measurement.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpm implements zzhg {
    final /* synthetic */ String zza;
    final /* synthetic */ zzpz zzb;
    final /* synthetic */ zzpv zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpm(zzpv zzpvVar, String str, zzpz zzpzVar) {
        this.zza = str;
        this.zzb = zzpzVar;
        this.zzc = zzpvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhg
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzc.zzZ(this.zza, i, th, bArr, this.zzb);
    }
}
