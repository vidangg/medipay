package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaj extends zbuf implements zbvn {
    private static final zbaj zbb;
    private int zbd;
    private String zbe = "";
    private String zbf = "";
    private String zbg = "";
    private int zbh;

    static {
        zbaj zbajVar = new zbaj();
        zbb = zbajVar;
        zbuf.zbD(zbaj.class, zbajVar);
    }

    private zbaj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", zbai.zba});
        }
        if (i2 == 3) {
            return new zbaj();
        }
        if (i2 == 4) {
            return new zbah(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
