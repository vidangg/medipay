package com.google.android.gms.internal.auth;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzhd implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzhe zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhd(zzhe zzheVar) {
        zzff zzffVar;
        this.zzb = zzheVar;
        zzffVar = zzheVar.zza;
        this.zza = zzffVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
