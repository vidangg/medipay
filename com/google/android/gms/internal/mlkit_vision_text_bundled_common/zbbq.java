package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbq extends zbuf implements zbvn {
    private static final zbbq zbb;
    private int zbd;
    private int zbf;
    private zban zbh;
    private double zbe = 1.0d;
    private float zbg = 0.3f;

    static {
        zbbq zbbqVar = new zbbq();
        zbb = zbbqVar;
        zbuf.zbD(zbbq.class, zbbqVar);
    }

    private zbbq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001က\u0000\u0002င\u0001\u0003ခ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbbq();
        }
        if (i2 == 4) {
            return new zbbp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
