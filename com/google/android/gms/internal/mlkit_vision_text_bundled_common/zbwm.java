package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbwm {
    private static final zbwm zba = new zbwm(0, new int[0], new Object[0], false);
    private int zbb;
    private int[] zbc;
    private Object[] zbd;
    private int zbe;
    private boolean zbf;

    private zbwm() {
        this(0, new int[8], new Object[8], true);
    }

    private zbwm(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zbe = -1;
        this.zbb = i;
        this.zbc = iArr;
        this.zbd = objArr;
        this.zbf = z;
    }

    public static zbwm zbc() {
        return zba;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zbwm zbe(zbwm zbwmVar, zbwm zbwmVar2) {
        int i = zbwmVar.zbb + zbwmVar2.zbb;
        int[] copyOf = Arrays.copyOf(zbwmVar.zbc, i);
        System.arraycopy(zbwmVar2.zbc, 0, copyOf, zbwmVar.zbb, zbwmVar2.zbb);
        Object[] copyOf2 = Arrays.copyOf(zbwmVar.zbd, i);
        System.arraycopy(zbwmVar2.zbd, 0, copyOf2, zbwmVar.zbb, zbwmVar2.zbb);
        return new zbwm(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zbwm zbf() {
        return new zbwm(0, new int[8], new Object[8], true);
    }

    private final void zbm(int i) {
        int[] iArr = this.zbc;
        if (i > iArr.length) {
            int i2 = this.zbb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zbc = Arrays.copyOf(iArr, i);
            this.zbd = Arrays.copyOf(this.zbd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zbwm)) {
            return false;
        }
        zbwm zbwmVar = (zbwm) obj;
        int i = this.zbb;
        if (i == zbwmVar.zbb) {
            int[] iArr = this.zbc;
            int[] iArr2 = zbwmVar.zbc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zbd;
                    Object[] objArr2 = zbwmVar.zbd;
                    int i3 = this.zbb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zbb;
        int i2 = i + 527;
        int[] iArr = this.zbc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zbd;
        int i7 = this.zbb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zba() {
        int zbD;
        int zbE;
        int i;
        int i2 = this.zbe;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zbb; i4++) {
            int i5 = this.zbc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 == 1) {
                    ((Long) this.zbd[i4]).longValue();
                    i = zbtk.zbD(i6 << 3) + 8;
                } else if (i7 == 2) {
                    int i8 = i6 << 3;
                    zbtc zbtcVar = (zbtc) this.zbd[i4];
                    int zbD2 = zbtk.zbD(i8);
                    int zbd = zbtcVar.zbd();
                    i = zbD2 + zbtk.zbD(zbd) + zbd;
                } else if (i7 == 3) {
                    int zbD3 = zbtk.zbD(i6 << 3);
                    zbD = zbD3 + zbD3;
                    zbE = ((zbwm) this.zbd[i4]).zba();
                } else if (i7 == 5) {
                    ((Integer) this.zbd[i4]).intValue();
                    i = zbtk.zbD(i6 << 3) + 4;
                } else {
                    throw new IllegalStateException(new zbup("Protocol message tag had invalid wire type."));
                }
                i3 += i;
            } else {
                int i9 = i6 << 3;
                long longValue = ((Long) this.zbd[i4]).longValue();
                zbD = zbtk.zbD(i9);
                zbE = zbtk.zbE(longValue);
            }
            i = zbD + zbE;
            i3 += i;
        }
        this.zbe = i3;
        return i3;
    }

    public final int zbb() {
        int i = this.zbe;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zbb; i3++) {
            int i4 = this.zbc[i3] >>> 3;
            zbtc zbtcVar = (zbtc) this.zbd[i3];
            int zbD = zbtk.zbD(8);
            int zbD2 = zbtk.zbD(16) + zbtk.zbD(i4);
            int zbD3 = zbtk.zbD(24);
            int zbd = zbtcVar.zbd();
            i2 += zbD + zbD + zbD2 + zbD3 + zbtk.zbD(zbd) + zbd;
        }
        this.zbe = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zbwm zbd(zbwm zbwmVar) {
        if (zbwmVar.equals(zba)) {
            return this;
        }
        zbg();
        int i = this.zbb + zbwmVar.zbb;
        zbm(i);
        System.arraycopy(zbwmVar.zbc, 0, this.zbc, this.zbb, zbwmVar.zbb);
        System.arraycopy(zbwmVar.zbd, 0, this.zbd, this.zbb, zbwmVar.zbb);
        this.zbb = i;
        return this;
    }

    final void zbg() {
        if (!this.zbf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zbh() {
        if (this.zbf) {
            this.zbf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zbi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zbb; i2++) {
            zbvo.zbb(sb, i, String.valueOf(this.zbc[i2] >>> 3), this.zbd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zbj(int i, Object obj) {
        zbg();
        zbm(this.zbb + 1);
        int[] iArr = this.zbc;
        int i2 = this.zbb;
        iArr[i2] = i;
        this.zbd[i2] = obj;
        this.zbb = i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zbk(zbwy zbwyVar) throws IOException {
        for (int i = 0; i < this.zbb; i++) {
            zbwyVar.zbx(this.zbc[i] >>> 3, this.zbd[i]);
        }
    }

    public final void zbl(zbwy zbwyVar) throws IOException {
        if (this.zbb != 0) {
            for (int i = 0; i < this.zbb; i++) {
                int i2 = this.zbc[i];
                Object obj = this.zbd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zbwyVar.zbt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zbwyVar.zbm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zbwyVar.zbd(i4, (zbtc) obj);
                } else if (i3 == 3) {
                    zbwyVar.zbG(i4);
                    ((zbwm) obj).zbl(zbwyVar);
                    zbwyVar.zbh(i4);
                } else if (i3 == 5) {
                    zbwyVar.zbk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zbup("Protocol message tag had invalid wire type."));
                }
            }
        }
    }
}
