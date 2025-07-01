package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
final class zznt implements Runnable {
    final /* synthetic */ zznx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznt(zznx zznxVar) {
        this.zza = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzny zznyVar = this.zza.zza;
        zzio zzioVar = zznyVar.zzu;
        Context zzaT = zzioVar.zzaT();
        zzioVar.zzaV();
        zzny.zzx(zznyVar, new ComponentName(zzaT, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
