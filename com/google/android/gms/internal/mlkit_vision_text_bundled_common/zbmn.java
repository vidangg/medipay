package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbmn extends zbuf implements zbvn {
    private static final zbmn zbb;
    private int zbd;
    private zbmp zbh;
    private byte zbi = 2;
    private String zbe = "";
    private String zbf = "";
    private String zbg = "";

    static {
        zbmn zbmnVar = new zbmn();
        zbb = zbmnVar;
        zbuf.zbD(zbmn.class, zbmnVar);
    }

    private zbmn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ᐉ\u0003Ϫဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbg"});
        }
        if (i2 == 3) {
            return new zbmn();
        }
        if (i2 == 4) {
            return new zbmm(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
