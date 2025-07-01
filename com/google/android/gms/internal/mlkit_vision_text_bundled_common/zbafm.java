package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbafm extends zbuf implements zbvn {
    private static final zbafm zbb;
    private int zbd;
    private zbafo zbg;
    private zbtc zbi;
    private zbafo zbj;
    private String zbk;
    private zbtc zbl;
    private zbafo zbm;
    private String zbn;
    private String zbo;
    private zbafo zbp;
    private String zbe = "";
    private zbtc zbf = zbtc.zbb;
    private String zbh = "";

    static {
        zbafm zbafmVar = new zbafm();
        zbb = zbafmVar;
        zbuf.zbD(zbafm.class, zbafmVar);
    }

    private zbafm() {
        zbtc zbtcVar = zbtc.zbb;
        this.zbi = zbtcVar;
        this.zbk = "";
        this.zbl = zbtcVar;
        this.zbn = "";
        this.zbo = "";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ည\u0004\u0004ဈ\u0003\u0005ဈ\u0006\u0006ည\u0007\u0007ဈ\t\bဈ\n\tဉ\u0002\nဉ\u0005\u000bဉ\b\fဉ\u000b", new Object[]{"zbd", "zbe", "zbf", "zbi", "zbh", "zbk", "zbl", "zbn", "zbo", "zbg", "zbj", "zbm", "zbp"});
        }
        if (i2 == 3) {
            return new zbafm();
        }
        if (i2 == 4) {
            return new zbafl(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
