package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbh extends zbuf implements zbvn {
    private static final zbbh zbb;
    private int zbd;
    private zbaii zbg;
    private zbjs zbh;
    private boolean zbk;
    private boolean zbe = true;
    private boolean zbf = true;
    private float zbi = 0.7f;
    private float zbj = 0.8f;

    static {
        zbbh zbbhVar = new zbbh();
        zbb = zbbhVar;
        zbuf.zbD(zbbh.class, zbbhVar);
    }

    private zbbh() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဉ\u0002\u0003ဉ\u0003\u0004ဇ\u0001\u0005ခ\u0004\u0006ခ\u0005\u0007ဇ\u0006", new Object[]{"zbd", "zbe", "zbg", "zbh", "zbf", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new zbbh();
        }
        if (i2 == 4) {
            return new zbbg(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
