package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzdw extends zzdy {
    final /* synthetic */ zzef zza;
    private int zzb = 0;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdw(zzef zzefVar) {
        this.zza = zzefVar;
        this.zzc = zzefVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzea
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
