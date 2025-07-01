package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbafi extends zbuf implements zbvn {
    private static final zbafi zbb;
    private int zbd = 0;
    private Object zbe;

    static {
        zbafi zbafiVar = new zbafi();
        zbb = zbafiVar;
        zbuf.zbD(zbafi.class, zbafiVar);
    }

    private zbafi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zbe", "zbd", zbafa.class, zbaew.class});
        }
        if (i2 == 3) {
            return new zbafi();
        }
        if (i2 == 4) {
            return new zbafh(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
