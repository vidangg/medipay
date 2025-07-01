package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbyy extends zbuf implements zbvn {
    private static final zbyy zbb;
    private int zbd;
    private zbun zbe = zby();
    private zbza zbf;
    private zbxh zbg;

    static {
        zbyy zbyyVar = new zbyy();
        zbb = zbyyVar;
        zbuf.zbD(zbyy.class, zbyyVar);
    }

    private zbyy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zbd", "zbe", zbzo.class, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbyy();
        }
        if (i2 == 4) {
            return new zbyx(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
