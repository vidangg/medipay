package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public class zbtb extends zbta {
    protected final byte[] zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbtb(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zba = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zbtc) || zbd() != ((zbtc) obj).zbd()) {
            return false;
        }
        if (zbd() == 0) {
            return true;
        }
        if (obj instanceof zbtb) {
            zbtb zbtbVar = (zbtb) obj;
            int zbi = zbi();
            int zbi2 = zbtbVar.zbi();
            if (zbi != 0 && zbi2 != 0 && zbi != zbi2) {
                return false;
            }
            int zbd = zbd();
            if (zbd > zbtbVar.zbd()) {
                throw new IllegalArgumentException("Length too large: " + zbd + zbd());
            }
            if (zbd <= zbtbVar.zbd()) {
                if (zbtbVar instanceof zbtb) {
                    byte[] bArr = this.zba;
                    byte[] bArr2 = zbtbVar.zba;
                    zbtbVar.zbc();
                    int i = 0;
                    int i2 = 0;
                    while (i < zbd) {
                        if (bArr[i] != bArr2[i2]) {
                            return false;
                        }
                        i++;
                        i2++;
                    }
                    return true;
                }
                return zbtbVar.zbf(0, zbd).equals(zbf(0, zbd));
            }
            throw new IllegalArgumentException("Ran off end of other: 0, " + zbd + ", " + zbtbVar.zbd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public byte zba(int i) {
        return this.zba[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public byte zbb(int i) {
        return this.zba[i];
    }

    protected int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public int zbd() {
        return this.zba.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    protected final int zbe(int i, int i2, int i3) {
        return zbuo.zbb(i, this.zba, 0, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final zbtc zbf(int i, int i2) {
        int zbh = zbh(0, i2, zbd());
        return zbh == 0 ? zbtc.zbb : new zbsw(this.zba, 0, zbh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final void zbg(zbst zbstVar) throws IOException {
        ((zbth) zbstVar).zbc(this.zba, 0, zbd());
    }
}
