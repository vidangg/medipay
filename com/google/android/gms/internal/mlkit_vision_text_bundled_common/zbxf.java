package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbxf extends zbuf implements zbvn {
    private static final zbxf zbb;
    private int zbd;
    private zbyw zbe;
    private zbun zbf = zby();
    private zbun zbg = zby();

    static {
        zbxf zbxfVar = new zbxf();
        zbb = zbxfVar;
        zbuf.zbD(zbxf.class, zbxfVar);
    }

    private zbxf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", zbzm.class, "zbg", zbxb.class});
        }
        if (i2 == 3) {
            return new zbxf();
        }
        if (i2 == 4) {
            return new zbxe(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
