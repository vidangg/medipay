package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaen extends zbuf implements zbvn {
    private static final zbaen zbb;
    private int zbd;
    private zbaeh zbe;
    private zbun zbf = zby();
    private float zbg;

    static {
        zbaen zbaenVar = new zbaen();
        zbb = zbaenVar;
        zbuf.zbD(zbaen.class, zbaenVar);
    }

    private zbaen() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001", new Object[]{"zbd", "zbe", "zbf", zbaem.class, "zbg"});
        }
        if (i2 == 3) {
            return new zbaen();
        }
        if (i2 == 4) {
            return new zbaei(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
