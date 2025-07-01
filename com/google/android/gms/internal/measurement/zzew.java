package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes3.dex */
final class zzew extends zzdd {
    private final com.google.android.gms.measurement.internal.zzkc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzew(com.google.android.gms.measurement.internal.zzkc zzkcVar) {
        this.zza = zzkcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final int zze() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final void zzf(String str, String str2, Bundle bundle, long j) {
        this.zza.onEvent(str, str2, bundle, j);
    }
}
