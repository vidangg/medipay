package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbahm extends zbuf implements zbvn {
    private static final zbahm zbb;
    private int zbd;
    private Object zbf;
    private zbahf zbg;
    private int zbe = 0;
    private zbvg zbm = zbvg.zba();
    private String zbh = "";
    private String zbi = "";
    private String zbj = "";
    private zbun zbk = zby();
    private zbun zbl = zby();
    private zbun zbn = zby();

    static {
        zbahm zbahmVar = new zbahm();
        zbb = zbahmVar;
        zbuf.zbD(zbahm.class, zbahmVar);
    }

    private zbahm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\t\u0001\u0001\u0001\u000b\t\u0001\u0003\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u001b\u0004\u001b\u0005<\u0000\b2\t\u001b\nȈ\u000bȈ", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbk", zbahj.class, "zbl", zbahl.class, zbahd.class, "zbm", zbahg.zba, "zbn", zbsp.class, "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zbahm();
        }
        if (i2 == 4) {
            return new zbahh(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
