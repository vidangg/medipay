package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdy extends zbuf implements zbvn {
    private static final zbdy zbb;
    private int zbd;
    private zbdj zbe;
    private zbdr zbf;
    private zbdn zbg;
    private zbdv zbh;

    static {
        zbdy zbdyVar = new zbdy();
        zbb = zbdyVar;
        zbuf.zbD(zbdy.class, zbdyVar);
    }

    private zbdy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbdy();
        }
        if (i2 == 4) {
            return new zbdx(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
