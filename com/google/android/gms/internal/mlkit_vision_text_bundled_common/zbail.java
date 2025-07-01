package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbail extends zbuf implements zbvn {
    private static final zbail zbb;
    private int zbd;
    private zbhl zbe;
    private String zbf = "";

    static {
        zbail zbailVar = new zbail();
        zbb = zbailVar;
        zbuf.zbD(zbail.class, zbailVar);
    }

    private zbail() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbail();
        }
        if (i2 == 4) {
            return new zbaik(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
