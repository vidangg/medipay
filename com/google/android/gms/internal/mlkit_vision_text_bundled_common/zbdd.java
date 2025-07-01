package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdd extends zbuf implements zbvn {
    private static final zbdd zbb;
    private int zbd;
    private zbhl zbe;

    static {
        zbdd zbddVar = new zbdd();
        zbb = zbddVar;
        zbuf.zbD(zbdd.class, zbddVar);
    }

    private zbdd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0000\u0004ဉ\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbdd();
        }
        if (i2 == 4) {
            return new zbdc(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
