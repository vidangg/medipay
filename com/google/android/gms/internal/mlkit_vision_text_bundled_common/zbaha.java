package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaha extends zbuf implements zbvn {
    private static final zbaha zbb;
    private int zbd;
    private zbul zbe = zbw();

    static {
        zbaha zbahaVar = new zbaha();
        zbb = zbahaVar;
        zbuf.zbD(zbaha.class, zbahaVar);
    }

    private zbaha() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002'", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbaha();
        }
        if (i2 == 4) {
            return new zbagz(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
