package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbqg extends zbuf implements zbvn {
    private static final zbqg zbb;
    private int zbd;
    private zbqe zbe;
    private double zbf;
    private boolean zbg;

    static {
        zbqg zbqgVar = new zbqg();
        zbb = zbqgVar;
        zbuf.zbD(zbqg.class, zbqgVar);
    }

    private zbqg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002က\u0001\u0003ဇ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbqg();
        }
        if (i2 == 4) {
            return new zbqf(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
