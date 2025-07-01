package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbpr extends zbuf implements zbvn {
    private static final zbpr zbb;
    private int zbd;
    private int zbe;
    private int zbg;
    private boolean zbh;
    private int zbi;
    private boolean zbk;
    private zbxb zbl;
    private zbun zbf = zby();
    private int zbj = 1;

    static {
        zbpr zbprVar = new zbpr();
        zbb = zbprVar;
        zbuf.zbD(zbpr.class, zbprVar);
    }

    private zbpr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002\u001b\u0003င\u0001\u0004ဇ\u0002\u0005င\u0003\u0006င\u0004\u0007ဇ\u0005\bဉ\u0006", new Object[]{"zbd", "zbe", "zbf", zbpp.class, "zbg", "zbh", "zbi", "zbj", "zbk", "zbl"});
        }
        if (i2 == 3) {
            return new zbpr();
        }
        if (i2 == 4) {
            return new zbpq(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
