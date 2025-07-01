package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbmg extends zbuf implements zbvn {
    private static final zbmg zbb;
    private Object zbe;
    private int zbd = 0;
    private zbun zbf = zby();

    static {
        zbmg zbmgVar = new zbmg();
        zbb = zbmgVar;
        zbuf.zbD(zbmg.class, zbmgVar);
    }

    private zbmg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001;\u0000\u00023\u0000\u0003<\u0000\u0004\u001b", new Object[]{"zbe", "zbd", zbmk.class, "zbf", zbmg.class});
        }
        if (i2 == 3) {
            return new zbmg();
        }
        if (i2 == 4) {
            return new zbmf(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
