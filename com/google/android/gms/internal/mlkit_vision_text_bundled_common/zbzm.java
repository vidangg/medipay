package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbzm extends zbuf implements zbvn {
    private static final zbzm zbb;
    private int zbd;
    private int zbf;
    private boolean zbh;
    private int zbm;
    private String zbe = "";
    private String zbg = "";
    private String zbi = "";
    private zbun zbj = zbuf.zby();
    private zbun zbk = zby();
    private zbun zbl = zbuf.zby();

    static {
        zbzm zbzmVar = new zbzm();
        zbb = zbzmVar;
        zbuf.zbD(zbzm.class, zbzmVar);
    }

    private zbzm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0003\u0000\u0001ဈ\u0000\u0002င\u0001\u0003\u001a\u0004\u001b\u0006ဈ\u0002\u0007ဇ\u0003\bဈ\u0004\t\u001a\nင\u0005", new Object[]{"zbd", "zbe", "zbf", "zbj", "zbk", zbzg.class, "zbg", "zbh", "zbi", "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new zbzm();
        }
        if (i2 == 4) {
            return new zbzl(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
