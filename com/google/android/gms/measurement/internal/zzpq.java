package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpq implements zzqe {
    final /* synthetic */ zzpv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpq(zzpv zzpvVar) {
        this.zza = zzpvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzqe
    public final void zza(String str, String str2, Bundle bundle) {
        zzio zzioVar;
        zzio zzioVar2;
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzaX().zzq(new zzpp(this, str, str2, bundle));
            return;
        }
        zzpv zzpvVar = this.zza;
        zzioVar = zzpvVar.zzn;
        if (zzioVar != null) {
            zzioVar2 = zzpvVar.zzn;
            zzioVar2.zzaW().zze().zzb("AppId not known when logging event", str2);
        }
    }
}
