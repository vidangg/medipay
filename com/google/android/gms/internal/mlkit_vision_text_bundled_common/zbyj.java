package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbyj extends zbuf implements zbvn {
    private static final zbyj zbb;
    private int zbd;
    private boolean zbe;
    private int zbf;
    private int zbh;
    private int zbi;
    private int zbj;
    private int zbk;
    private boolean zbg = true;
    private String zbl = "";
    private String zbm = "";

    static {
        zbyj zbyjVar = new zbyj();
        zbb = zbyjVar;
        zbuf.zbD(zbyj.class, zbyjVar);
    }

    private zbyj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zbuj zbujVar = zbyl.zba;
            zbuj zbujVar2 = zbyh.zba;
            zbuj zbujVar3 = zbyk.zba;
            return zbA(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zbd", "zbe", "zbf", zbujVar, "zbg", "zbh", zbujVar2, "zbi", zbujVar3, "zbj", zbujVar3, "zbk", zbujVar3, "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new zbyj();
        }
        if (i2 == 4) {
            return new zbyi(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
