package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbace extends zbuf implements zbvn {
    private static final zbace zbb;
    private int zbd;
    private int zbe;
    private zbtc zbf = zbtc.zbb;
    private String zbg = "";
    private float zbh;

    static {
        zbace zbaceVar = new zbace();
        zbb = zbaceVar;
        zbuf.zbD(zbace.class, zbaceVar);
    }

    private zbace() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbace();
        }
        if (i2 == 4) {
            return new zbacd(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
