package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbee extends zbuf implements zbvn {
    private static final zbee zbb;
    private int zbd;
    private int zbe = 3;
    private float zbf = 100000.0f;
    private float zbg;

    static {
        zbee zbeeVar = new zbee();
        zbb = zbeeVar;
        zbuf.zbD(zbee.class, zbeeVar);
    }

    private zbee() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zbd", "zbe", zbec.zba, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbee();
        }
        if (i2 == 4) {
            return new zbed(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
