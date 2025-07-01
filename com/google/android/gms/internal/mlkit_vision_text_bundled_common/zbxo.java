package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbxo extends zbuf implements zbvn {
    private static final zbxo zbb;
    private int zbd;
    private String zbe = "";
    private int zbf = 1;
    private boolean zbg;
    private int zbh;

    static {
        zbxo zbxoVar = new zbxo();
        zbb = zbxoVar;
        zbuf.zbD(zbxo.class, zbxoVar);
    }

    private zbxo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", "zbf", zbxn.zba, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbxo();
        }
        if (i2 == 4) {
            return new zbxm(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
