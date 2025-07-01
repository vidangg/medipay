package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbpm extends zbuf implements zbvn {
    private static final zbpm zbb;
    private int zbd;
    private zbsp zbe;

    static {
        zbpm zbpmVar = new zbpm();
        zbb = zbpmVar;
        zbuf.zbD(zbpm.class, zbpmVar);
    }

    private zbpm() {
    }

    public static zbpm zbc() {
        return zbb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbpm();
        }
        zbph zbphVar = null;
        if (i2 == 4) {
            return new zbpl(zbphVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
