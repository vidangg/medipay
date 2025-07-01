package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdf extends zbuf implements zbvn {
    private static final zbdf zbb;
    private int zbd;
    private int zbe = -1;
    private float zbf = 1.0f;
    private int zbg;

    static {
        zbdf zbdfVar = new zbdf();
        zbb = zbdfVar;
        zbuf.zbD(zbdf.class, zbdfVar);
    }

    private zbdf() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001\u0003င\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbdf();
        }
        zbda zbdaVar = null;
        if (i2 == 4) {
            return new zbde(zbdaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
