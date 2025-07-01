package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
public final class zzex<E> extends zzej<E> {
    private final transient E zza;
    private transient int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzex(E e) {
        this.zza = (E) zzde.zza(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzex(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* renamed from: zza */
    public final zzfa<E> iterator() {
        return new zzeo(this.zza);
    }

    @Override // com.google.android.gms.internal.vision.zzej
    final zzee<E> zzh() {
        return zzee.zza(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.vision.zzej, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    final boolean zzg() {
        return this.zzb != 0;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzej, com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
