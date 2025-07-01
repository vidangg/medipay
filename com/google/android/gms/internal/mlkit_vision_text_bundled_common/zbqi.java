package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbqi extends zbuf implements zbvn {
    private static final zbqi zbb;
    private float zbC;
    private int zbD;
    private int zbE;
    private int zbd;
    private zbpw zbe;
    private float zbf;
    private zbpw zbi;
    private int zbj;
    private boolean zbl;
    private boolean zbm;
    private int zbs;
    private float zbu;
    private float zbv;
    private float zbw;
    private int zbx;
    private zbqy zby;
    private byte zbF = 2;
    private zbtc zbg = zbtc.zbb;
    private zbtc zbh = zbtc.zbb;
    private zbun zbk = zby();
    private zbun zbn = zby();
    private String zbo = "";
    private String zbp = "";
    private zbun zbq = zby();
    private zbun zbr = zby();
    private int zbt = 1;
    private zbun zbz = zby();
    private zbuk zbA = zbv();
    private zbul zbB = zbw();

    static {
        zbqi zbqiVar = new zbqi();
        zbb = zbqiVar;
        zbuf.zbD(zbqi.class, zbqiVar);
    }

    private zbqi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbF);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u001b\u0000\u0001\u0001d\u001b\u0000\u0007\u0007\u0001ᔉ\u0000\u0002ခ\u0001\u0003ည\u0002\u0004ည\u0003\u0005င\u0005\u0006ᐉ\u0004\u0007Л\bဇ\u0006\tဇ\u0007\nЛ\u000bဈ\b\fЛ\rЛ\u000eင\n\u000f᠌\u000b\u0010ခ\u000e\u0011ဈ\t\u0012င\u000f\u0013ဉ\u0010\u0014Л\u0015\u0013\u0016\u0016\u0017ခ\f\u0018ခ\r\u0019ခ\u0011\u001aင\u0012dင\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbj", "zbi", "zbk", zbqk.class, "zbl", "zbm", "zbn", zbse.class, "zbo", "zbq", zbpw.class, "zbr", zbqa.class, "zbs", "zbt", zbqr.zba, "zbw", "zbp", "zbx", "zby", "zbz", zbpw.class, "zbA", "zbB", "zbu", "zbv", "zbC", "zbD", "zbE"});
        }
        if (i2 == 3) {
            return new zbqi();
        }
        if (i2 == 4) {
            return new zbqh(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbF = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
