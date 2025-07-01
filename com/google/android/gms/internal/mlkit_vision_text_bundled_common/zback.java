package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zback extends zbuf implements zbvn {
    private static final zback zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private int zbh = 15000;
    private int zbi;
    private float zbj;

    static {
        zback zbackVar = new zback();
        zbb = zbackVar;
        zbuf.zbD(zback.class, zbackVar);
    }

    private zback() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ခ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", zbaci.zba, "zbi", zbacj.zba, "zbj"});
        }
        if (i2 == 3) {
            return new zback();
        }
        if (i2 == 4) {
            return new zbach(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
