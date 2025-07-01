package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
final class zzw extends zzz {
    final /* synthetic */ zzr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzw(zzx zzxVar, zzaa zzaaVar, CharSequence charSequence, zzr zzrVar) {
        super(zzaaVar, charSequence);
        this.zza = zzrVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    final int zzc(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.common.zzz
    final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzv.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (this.zza.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
