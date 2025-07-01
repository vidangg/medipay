package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zbtc implements Iterable, Serializable {
    public static final zbtc zbb = new zbtb(zbuo.zbb);
    private int zba = 0;

    static {
        int i = zbsm.zba;
    }

    public static zbtc zbj(byte[] bArr, int i, int i2) {
        zbh(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zbtb(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zba;
        if (i == 0) {
            int zbd = zbd();
            i = zbe(zbd, 0, zbd);
            if (i == 0) {
                i = 1;
            }
            this.zba = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zbsu(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zbd()), zbd() <= 50 ? zbwj.zba(this) : zbwj.zba(zbf(0, 47)).concat("..."));
    }

    public abstract byte zba(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zbb(int i);

    public abstract int zbd();

    protected abstract int zbe(int i, int i2, int i3);

    public abstract zbtc zbf(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zbg(zbst zbstVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zbi() {
        return this.zba;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbh(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
