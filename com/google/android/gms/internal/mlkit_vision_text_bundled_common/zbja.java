package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbja extends zbuf implements zbvn {
    private static final zbja zbb;
    private int zbd;
    private zbhl zbg;
    private zbhl zbh;
    private boolean zbi;
    private boolean zbj;
    private boolean zbk;
    private zbxb zbm;
    private String zbe = "";
    private String zbf = "";
    private int zbl = 1;

    static {
        zbja zbjaVar = new zbja();
        zbb = zbjaVar;
        zbuf.zbD(zbja.class, zbjaVar);
    }

    private zbja() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0005\u0003ဇ\u0006\u0004ဉ\u0002\u0006ဇ\u0004\u0007င\u0007\bဉ\b\tဉ\u0003\nဈ\u0001", new Object[]{"zbd", "zbe", "zbj", "zbk", "zbg", "zbi", "zbl", "zbm", "zbh", "zbf"});
        }
        if (i2 == 3) {
            return new zbja();
        }
        if (i2 == 4) {
            return new zbiz(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
