package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbnm extends zbuf implements zbvn {
    private static final zbnm zbb;
    private int zbd;
    private zbnt zbe;
    private float zbf;
    private int zbg;
    private boolean zbh;

    static {
        zbnm zbnmVar = new zbnm();
        zbb = zbnmVar;
        zbuf.zbD(zbnm.class, zbnmVar);
    }

    private zbnm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003᠌\u0002\u0004ဇ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", zbnl.zba, "zbh"});
        }
        if (i2 == 3) {
            return new zbnm();
        }
        if (i2 == 4) {
            return new zbnk(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
