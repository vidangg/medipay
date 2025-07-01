package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbahb extends zbuf implements zbvn {
    private static final zbahb zbb;
    private Object zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private int zbd = 0;
    private zbun zbi = zby();

    static {
        zbahb zbahbVar = new zbahb();
        zbb = zbahbVar;
        zbuf.zbD(zbahb.class, zbahbVar);
    }

    private zbahb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\f\u0002<\u0000\u0003\u0004\u0004\u001b\u00057\u0000\u0006\u0004", new Object[]{"zbe", "zbd", "zbf", zbaha.class, "zbg", "zbi", zbsp.class, "zbh"});
        }
        if (i2 == 3) {
            return new zbahb();
        }
        if (i2 == 4) {
            return new zbagy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
