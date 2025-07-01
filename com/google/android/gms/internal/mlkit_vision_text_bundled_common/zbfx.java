package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbfx extends zbuf implements zbvn {
    private static final zbfx zbb;
    private int zbd;
    private float zbe = 0.7f;
    private int zbf = 2;
    private float zbg = 0.2f;

    static {
        zbfx zbfxVar = new zbfx();
        zbb = zbfxVar;
        zbuf.zbD(zbfx.class, zbfxVar);
    }

    private zbfx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002င\u0001\u0003ခ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbfx();
        }
        zbfv zbfvVar = null;
        if (i2 == 4) {
            return new zbfw(zbfvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
