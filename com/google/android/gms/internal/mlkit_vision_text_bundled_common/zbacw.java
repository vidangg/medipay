package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbacw extends zbuf implements zbvn {
    private static final zbacw zbb;
    private int zbd;
    private int zbe;
    private zbtc zbf = zbtc.zbb;
    private float zbg;

    static {
        zbacw zbacwVar = new zbacw();
        zbb = zbacwVar;
        zbuf.zbD(zbacw.class, zbacwVar);
    }

    private zbacw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ခ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbacw();
        }
        if (i2 == 4) {
            return new zbacv(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
