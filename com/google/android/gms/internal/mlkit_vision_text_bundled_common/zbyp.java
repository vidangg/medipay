package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbyp extends zbuf implements zbvn {
    private static final zbyp zbb;
    private int zbd;
    private boolean zbf;
    private int zbg;
    private boolean zbj;
    private int zbm;
    private int zbn;
    private boolean zbo;
    private int zbe = -1;
    private zbtc zbh = zbtc.zbb;
    private String zbi = "";
    private boolean zbk = true;
    private boolean zbl = true;

    static {
        zbyp zbypVar = new zbyp();
        zbb = zbypVar;
        zbuf.zbD(zbyp.class, zbypVar);
    }

    private zbyp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zbuj zbujVar = zbyn.zba;
            zbuj zbujVar2 = zbyo.zba;
            return zbA(zbb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zbd", "zbe", "zbf", "zbg", zbujVar, "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", zbujVar2, "zbn", zbujVar2, "zbo"});
        }
        if (i2 == 3) {
            return new zbyp();
        }
        if (i2 == 4) {
            return new zbym(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
