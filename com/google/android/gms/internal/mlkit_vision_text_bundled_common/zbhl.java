package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbhl extends zbuf implements zbvn {
    private static final zbhl zbb;
    private int zbd;
    private zbtc zbe = zbtc.zbb;
    private String zbf = "";
    private zbho zbg;

    static {
        zbhl zbhlVar = new zbhl();
        zbb = zbhlVar;
        zbuf.zbD(zbhl.class, zbhlVar);
    }

    private zbhl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဈ\u0001\u0002ည\u0000\u0004ဉ\u0002", new Object[]{"zbd", "zbf", "zbe", "zbg"});
        }
        if (i2 == 3) {
            return new zbhl();
        }
        if (i2 == 4) {
            return new zbhk(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
