package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbnt extends zbuf implements zbvn {
    private static final zbnt zbb;
    private int zbd;
    private zbun zbe = zby();
    private int zbf;
    private int zbg;

    static {
        zbnt zbntVar = new zbnt();
        zbb = zbntVar;
        zbuf.zbD(zbnt.class, zbntVar);
    }

    private zbnt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002᠌\u0000\u0003᠌\u0001", new Object[]{"zbd", "zbe", zbnr.class, "zbf", zbns.zba, "zbg", zbnn.zba});
        }
        if (i2 == 3) {
            return new zbnt();
        }
        if (i2 == 4) {
            return new zbnp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
