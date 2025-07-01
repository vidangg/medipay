package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbcv extends zbuf implements zbvn {
    private static final zbcv zbb;
    private int zbd;
    private zbtc zbe = zbtc.zbb;
    private float zbf;
    private zbgw zbg;
    private long zbh;

    static {
        zbcv zbcvVar = new zbcv();
        zbb = zbcvVar;
        zbuf.zbD(zbcv.class, zbcvVar);
    }

    private zbcv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ခ\u0001\u0003ဉ\u0002\u0004ဂ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbcv();
        }
        if (i2 == 4) {
            return new zbcu(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
