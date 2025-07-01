package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaf extends zbuf implements zbvn {
    private static final zbaf zbb;
    private int zbd;
    private zbaw zbe;
    private zbsh zbf;
    private String zbg = "";

    static {
        zbaf zbafVar = new zbaf();
        zbb = zbafVar;
        zbuf.zbD(zbaf.class, zbafVar);
    }

    private zbaf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0002\u0003ဉ\u0001", new Object[]{"zbd", "zbe", "zbg", "zbf"});
        }
        if (i2 == 3) {
            return new zbaf();
        }
        if (i2 == 4) {
            return new zbae(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
