package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbxb extends zbuf implements zbvn {
    private static final zbxb zbb;
    private int zbd;
    private int zbe;
    private zbzo zbf;
    private zbyw zbg;
    private zbyy zbh;

    static {
        zbxb zbxbVar = new zbxb();
        zbb = zbxbVar;
        zbuf.zbD(zbxb.class, zbxbVar);
    }

    private zbxb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zbd", "zbe", zbye.zba, "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbxb();
        }
        if (i2 == 4) {
            return new zbxa(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
