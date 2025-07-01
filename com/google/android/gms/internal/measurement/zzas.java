package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzas implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String str;
        zzat zzatVar = this.zza;
        int i = this.zzb;
        str = zzatVar.zza;
        return i < str.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        String str;
        String str2;
        zzat zzatVar = this.zza;
        int i = this.zzb;
        str = zzatVar.zza;
        if (i >= str.length()) {
            throw new NoSuchElementException();
        }
        str2 = zzatVar.zza;
        this.zzb = i + 1;
        return new zzat(String.valueOf(str2.charAt(i)));
    }
}
