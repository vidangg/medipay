package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbrq extends zbuf implements zbvn {
    private static final zbrq zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private float zbg;
    private float zbh;
    private int zbi;
    private int zbj;
    private int zbk;
    private int zbl;
    private int zbm;
    private float zbo;
    private float zbq;
    private String zbn = "";
    private String zbp = "";
    private zbun zbr = zbuf.zby();
    private zbuk zbs = zbv();
    private zbuk zbt = zbv();
    private zbun zbu = zbuf.zby();
    private zbuk zbv = zbv();
    private zbuk zbw = zbv();

    static {
        zbrq zbrqVar = new zbrq();
        zbb = zbrqVar;
        zbuf.zbD(zbrq.class, zbrqVar);
    }

    private zbrq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0006\u0000\u0001င\u0000\u0002င\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nဈ\u000b\u000b\u001a\fဈ\t\rခ\n\u000eခ\f\u000f$\u0010$\u0011\u001a\u0012$\u0013$", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbp", "zbr", "zbn", "zbo", "zbq", "zbs", "zbt", "zbu", "zbv", "zbw"});
        }
        if (i2 == 3) {
            return new zbrq();
        }
        if (i2 == 4) {
            return new zbrp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
