package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzic extends LruCache {
    final /* synthetic */ zzif zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzic(zzif zzifVar, int i) {
        super(20);
        this.zza = zzifVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        zzif zzifVar = this.zza;
        if (zzifVar.zzu.zzf().zzx(null, zzgi.zzbn)) {
            return zzif.zze(zzifVar, str);
        }
        return zzif.zzd(zzifVar, str);
    }
}
