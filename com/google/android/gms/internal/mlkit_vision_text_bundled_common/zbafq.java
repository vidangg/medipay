package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbafq extends zbub implements zbvn {
    private static final zbafq zbd;
    private boolean zbA;
    private int zbe;
    private float zbi;
    private boolean zbl;
    private boolean zbm;
    private boolean zbn;
    private int zbo;
    private zbaft zbp;
    private zbaet zbq;
    private zbabv zbr;
    private zbafi zbs;
    private zbafm zbt;
    private zbxb zbv;
    private boolean zbw;
    private boolean zbx;
    private int zby;
    private int zbz;
    private byte zbB = 2;
    private String zbf = "";
    private int zbg = 10;
    private int zbh = 1;
    private float zbj = 0.3f;
    private zbun zbk = zbuf.zby();
    private int zbu = 1;

    static {
        zbafq zbafqVar = new zbafq();
        zbd = zbafqVar;
        zbuf.zbD(zbafq.class, zbafqVar);
    }

    private zbafq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbB);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006\u001a\u0007ဇ\u0005\bဇ\u0006\tဇ\u0007\nဋ\b\u000bဉ\t\fဉ\n\rဉ\f\u000fင\u000e\u0010ဉ\r\u0011ဉ\u000f\u0012ဇ\u0010\u0013ဇ\u0011\u0014င\u0012\u0015ဉ\u000b\u0016᠌\u0013\u0017ဇ\u0014", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn", "zbo", "zbp", "zbq", "zbs", "zbu", "zbt", "zbv", "zbw", "zbx", "zby", "zbr", "zbz", zbafp.zba, "zbA"});
        }
        if (i2 == 3) {
            return new zbafq();
        }
        if (i2 == 4) {
            return new zbafk(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbB = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
