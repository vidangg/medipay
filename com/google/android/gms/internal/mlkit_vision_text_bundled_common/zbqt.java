package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbqt extends zbuf implements zbvn {
    private static final zbqt zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";
    private zbul zbg = zbw();

    static {
        zbqt zbqtVar = new zbqt();
        zbb = zbqtVar;
        zbuf.zbD(zbqt.class, zbqtVar);
    }

    private zbqt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0001\u0002င\u0000\u0003ࠞ", new Object[]{"zbd", "zbf", "zbe", "zbg", zbqu.zba});
        }
        if (i2 == 3) {
            return new zbqt();
        }
        if (i2 == 4) {
            return new zbqs(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
