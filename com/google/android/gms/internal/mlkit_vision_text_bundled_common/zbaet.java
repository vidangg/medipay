package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaet extends zbuf implements zbvn {
    private static final zbaet zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private float zbi;
    private float zbj;
    private zbuk zbk = zbv();
    private zbul zbl = zbw();
    private zbul zbm = zbw();

    static {
        zbaet zbaetVar = new zbaet();
        zbb = zbaetVar;
        zbuf.zbD(zbaet.class, zbaetVar);
    }

    private zbaet() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0003\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007$\b'\t'", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new zbaet();
        }
        if (i2 == 4) {
            return new zbaes(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
