package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbyu extends zbuf implements zbvn {
    private static final zbyu zbb;
    private int zbd;
    private int zbe;

    static {
        zbyu zbyuVar = new zbyu();
        zbb = zbyuVar;
        zbuf.zbD(zbyu.class, zbyuVar);
    }

    private zbyu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbyu();
        }
        zbwz zbwzVar = null;
        if (i2 == 4) {
            return new zbyt(zbwzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
