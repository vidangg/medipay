package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zboz extends zbuf implements zbvn {
    private static final zboz zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg = 2;
    private float zbh;
    private boolean zbi;

    static {
        zboz zbozVar = new zboz();
        zbb = zbozVar;
        zbuf.zbD(zboz.class, zbozVar);
    }

    private zboz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zbd", "zbe", zbox.zba, "zbf", zbpd.zba, "zbg", zbpc.zba, "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new zboz();
        }
        if (i2 == 4) {
            return new zboy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
