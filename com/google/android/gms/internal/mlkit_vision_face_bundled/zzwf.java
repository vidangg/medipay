package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
final class zzwf extends zzth implements RandomAccess {
    private static final zzwf zza = new zzwf(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    zzwf() {
        this(new Object[10], 0, true);
    }

    public static zzwf zze() {
        return zza;
    }

    private final String zzf(int i) {
        return "Index:" + i + ", Size:" + this.zzc;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzth, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
        int i3 = i + 1;
        Object[] objArr = this.zzb;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i3, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.zzb, i, objArr2, i3, this.zzc - i);
            this.zzb = objArr2;
        }
        this.zzb[i] = obj;
        this.zzc++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zzg(i);
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzth, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zza();
        zzg(i);
        Object[] objArr = this.zzb;
        Object obj = objArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzth, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zza();
        zzg(i);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvb
    public final /* bridge */ /* synthetic */ zzvb zzd(int i) {
        if (i < this.zzc) {
            throw new IllegalArgumentException();
        }
        return new zzwf(Arrays.copyOf(this.zzb, i), this.zzc, true);
    }

    private zzwf(Object[] objArr, int i, boolean z) {
        super(z);
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzth, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i = this.zzc;
        Object[] objArr = this.zzb;
        if (i == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        objArr2[i2] = obj;
        this.modCount++;
        return true;
    }
}
