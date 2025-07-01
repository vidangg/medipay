package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlk implements zzqe {
    final /* synthetic */ zzlw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlk(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzqe
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzQ("auto", "_err", bundle, str);
        } else {
            this.zza.zzO("auto", "_err", bundle);
        }
    }
}
