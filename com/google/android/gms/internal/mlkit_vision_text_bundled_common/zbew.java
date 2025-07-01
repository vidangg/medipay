package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbew extends zbuf implements zbvn {
    private static final zbew zbb;
    private int zbd;
    private boolean zbe;
    private float zbf = 0.2f;
    private zbun zbg = zby();

    static {
        zbew zbewVar = new zbew();
        zbb = zbewVar;
        zbuf.zbD(zbew.class, zbewVar);
    }

    private zbew() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0000\u0001ဇ\u0000\u0002ခ\u0001\u0004\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", zbez.class});
        }
        if (i2 == 3) {
            return new zbew();
        }
        if (i2 == 4) {
            return new zbev(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
