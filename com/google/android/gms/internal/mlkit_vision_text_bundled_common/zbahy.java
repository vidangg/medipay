package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbahy extends zbuf implements zbvn {
    private static final zbahy zbb;
    private int zbd;
    private long zbh;
    private zbahr zbl;
    private zbahf zbm;
    private int zbo;
    private zbun zbe = zby();
    private zbun zbf = zby();
    private zbun zbg = zby();
    private String zbi = "";
    private zbun zbj = zbuf.zby();
    private String zbk = "";
    private zbum zbn = zbx();

    static {
        zbahy zbahyVar = new zbahy();
        zbb = zbahyVar;
        zbuf.zbD(zbahy.class, zbahyVar);
    }

    private zbahy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001\u001b\u0002\u001b\u0003\u0002\u0004Ȉ\u0005Ț\u0006Ȉ\u0007ဉ\u0001\b%\t\u0004\n\u001b\u000bဉ\u0000", new Object[]{"zbd", "zbe", zbaht.class, "zbf", zbahv.class, "zbh", "zbi", "zbj", "zbk", "zbm", "zbn", "zbo", "zbg", zbahp.class, "zbl"});
        }
        if (i2 == 3) {
            return new zbahy();
        }
        if (i2 == 4) {
            return new zbahn(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
