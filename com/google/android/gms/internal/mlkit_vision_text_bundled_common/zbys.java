package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbys extends zbuf implements zbvn {
    private static final zbys zbb;
    private int zbd;
    private int zbe;
    private int zbf = 100;
    private int zbg;

    static {
        zbys zbysVar = new zbys();
        zbb = zbysVar;
        zbuf.zbD(zbys.class, zbysVar);
    }

    private zbys() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zbd", "zbe", zbyq.zba, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbys();
        }
        if (i2 == 4) {
            return new zbyr(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
