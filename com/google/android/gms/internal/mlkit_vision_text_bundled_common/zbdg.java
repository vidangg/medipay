package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdg extends zbuf implements zbvn {
    private static final zbdg zbb;
    private int zbd;
    private zbdd zbe;
    private zbdf zbf;
    private zbhl zbg;
    private zbhl zbh;

    static {
        zbdg zbdgVar = new zbdg();
        zbb = zbdgVar;
        zbuf.zbD(zbdg.class, zbdgVar);
    }

    private zbdg() {
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
            return new zbdg();
        }
        if (i2 == 4) {
            return new zbdb(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
