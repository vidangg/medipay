package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaiu extends zbuf implements zbvn {
    private static final zbaiu zbb;
    private int zbd;
    private String zbe = "";
    private zbtc zbf = zbtc.zbb;

    static {
        zbaiu zbaiuVar = new zbaiu();
        zbb = zbaiuVar;
        zbuf.zbD(zbaiu.class, zbaiuVar);
    }

    private zbaiu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbaiu();
        }
        if (i2 == 4) {
            return new zbait(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
