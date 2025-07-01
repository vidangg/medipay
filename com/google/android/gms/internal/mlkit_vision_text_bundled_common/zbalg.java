package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbalg extends zbuf implements zbvn {
    private static final zbalg zbb;
    private int zbd;
    private zbakx zbe;
    private double zbf;
    private double zbg;

    static {
        zbalg zbalgVar = new zbalg();
        zbb = zbalgVar;
        zbuf.zbD(zbalg.class, zbalgVar);
    }

    private zbalg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000\u0003\u0000", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbalg();
        }
        if (i2 == 4) {
            return new zbalf(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
