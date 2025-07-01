package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaki extends zbuf implements zbvn {
    private static final zbaki zbb;
    private int zbd;
    private zbakx zbe;
    private double zbf;

    static {
        zbaki zbakiVar = new zbaki();
        zbb = zbakiVar;
        zbuf.zbD(zbaki.class, zbakiVar);
    }

    private zbaki() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbaki();
        }
        if (i2 == 4) {
            return new zbakh(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
