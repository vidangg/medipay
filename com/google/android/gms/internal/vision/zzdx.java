package com.google.android.gms.internal.vision;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzdx<V> extends AbstractCollection<V> {
    private final /* synthetic */ zzdp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdx(zzdp zzdpVar) {
        this.zza = zzdpVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return this.zza.zzg();
    }
}
