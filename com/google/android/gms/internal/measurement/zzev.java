package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes3.dex */
final class zzev extends zzdd {
    private final com.google.android.gms.measurement.internal.zzkb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(com.google.android.gms.measurement.internal.zzkb zzkbVar) {
        this.zza = zzkbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final int zze() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final void zzf(String str, String str2, Bundle bundle, long j) {
        this.zza.interceptEvent(str, str2, bundle, j);
    }
}
