package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbtw extends zbsl implements RandomAccess, zbuk {
    private static final zbtw zba = new zbtw(new float[0], 0, false);
    private float[] zbb;
    private int zbc;

    zbtw() {
        this(new float[10], 0, true);
    }

    public static zbtw zbf() {
        return zba;
    }

    private final String zbh(int i) {
        return "Index:" + i + ", Size:" + this.zbc;
    }

    private final void zbi(int i) {
        if (i < 0 || i >= this.zbc) {
            throw new IndexOutOfBoundsException(zbh(i));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        zba();
        if (i < 0 || i > (i2 = this.zbc)) {
            throw new IndexOutOfBoundsException(zbh(i));
        }
        int i3 = i + 1;
        float[] fArr = this.zbb;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i3, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zbb, i, fArr2, i3, this.zbc - i);
            this.zbb = fArr2;
        }
        this.zbb[i] = floatValue;
        this.zbc++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zba();
        byte[] bArr = zbuo.zbb;
        collection.getClass();
        if (!(collection instanceof zbtw)) {
            return super.addAll(collection);
        }
        zbtw zbtwVar = (zbtw) collection;
        int i = zbtwVar.zbc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zbc;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zbb;
            if (i3 > fArr.length) {
                this.zbb = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zbtwVar.zbb, 0, this.zbb, this.zbc, zbtwVar.zbc);
            this.zbc = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zbtw)) {
            return super.equals(obj);
        }
        zbtw zbtwVar = (zbtw) obj;
        if (this.zbc != zbtwVar.zbc) {
            return false;
        }
        float[] fArr = zbtwVar.zbb;
        for (int i = 0; i < this.zbc; i++) {
            if (Float.floatToIntBits(this.zbb[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zbi(i);
        return Float.valueOf(this.zbb[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zbc; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zbb[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i = this.zbc;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zbb[i2] == floatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zba();
        zbi(i);
        float[] fArr = this.zbb;
        float f = fArr[i];
        if (i < this.zbc - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.zbc--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zba();
        if (i2 >= i) {
            float[] fArr = this.zbb;
            System.arraycopy(fArr, i2, fArr, i, this.zbc - i2);
            this.zbc -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zba();
        zbi(i);
        float[] fArr = this.zbb;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun
    public final /* bridge */ /* synthetic */ zbun zbd(int i) {
        if (i < this.zbc) {
            throw new IllegalArgumentException();
        }
        return new zbtw(Arrays.copyOf(this.zbb, i), this.zbc, true);
    }

    public final float zbe(int i) {
        zbi(i);
        return this.zbb[i];
    }

    public final void zbg(float f) {
        zba();
        int i = this.zbc;
        float[] fArr = this.zbb;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zbb = fArr2;
        }
        float[] fArr3 = this.zbb;
        int i2 = this.zbc;
        this.zbc = i2 + 1;
        fArr3[i2] = f;
    }

    private zbtw(float[] fArr, int i, boolean z) {
        super(z);
        this.zbb = fArr;
        this.zbc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zbg(((Float) obj).floatValue());
        return true;
    }
}
