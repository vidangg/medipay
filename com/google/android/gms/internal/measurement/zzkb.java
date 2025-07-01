package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzkb extends zzki {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkb(zzkf zzkfVar, String str, Long l, boolean z) {
        super(zzkfVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzki
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        Log.e("PhenotypeFlag", "Invalid long value for " + this.zzb + ": " + obj.toString());
        return null;
    }
}
