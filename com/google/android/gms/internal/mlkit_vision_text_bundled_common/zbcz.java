package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbcz extends zbuf implements zbvn {
    private static final zbcz zbb;
    private int zbd;
    private zbalp zbe;
    private zbhl zbf;
    private float zbi;
    private zbxb zbm;
    private String zbg = "en";
    private int zbh = -1;
    private zbun zbj = zbuf.zby();
    private zbun zbk = zbuf.zby();
    private int zbl = -1;

    static {
        zbcz zbczVar = new zbcz();
        zbb = zbczVar;
        zbuf.zbD(zbcz.class, zbczVar);
    }

    private zbcz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001ဉ\u0001\u0002ဈ\u0002\u0003င\u0003\u0004ခ\u0004\u0005\u001a\u0006\u001a\u0007င\u0005\bဉ\u0006\tဉ\u0000", new Object[]{"zbd", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbe"});
        }
        if (i2 == 3) {
            return new zbcz();
        }
        if (i2 == 4) {
            return new zbcy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
