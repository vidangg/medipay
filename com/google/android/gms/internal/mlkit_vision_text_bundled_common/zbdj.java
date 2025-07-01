package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdj extends zbuf implements zbvn {
    private static final zbdj zbb;
    private int zbd;
    private float zbe = 1.0f;
    private int zbf;

    static {
        zbdj zbdjVar = new zbdj();
        zbb = zbdjVar;
        zbuf.zbD(zbdj.class, zbdjVar);
    }

    private zbdj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbdj();
        }
        zbdh zbdhVar = null;
        if (i2 == 4) {
            return new zbdi(zbdhVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
