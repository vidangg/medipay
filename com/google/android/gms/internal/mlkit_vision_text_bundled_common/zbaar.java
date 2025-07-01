package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaar extends zbuf implements zbvn {
    private static final zbaar zbb;
    private int zbd;
    private int zbe;
    private double zbf;
    private double zbg;
    private int zbh;
    private boolean zbi;
    private boolean zbj;
    private boolean zbk;
    private boolean zbl;
    private boolean zbm;
    private boolean zbn;
    private boolean zbo;
    private int zbp;
    private zbaap zbq;
    private float zbr;
    private zbaap zbs;
    private float zbt;
    private String zbu = "";

    static {
        zbaar zbaarVar = new zbaar();
        zbb = zbaarVar;
        zbuf.zbD(zbaar.class, zbaarVar);
    }

    private zbaar() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0011\u0000\u0001\u0001\u0011\u0011\u0000\u0000\u0000\u0001င\u0000\u0002က\u0001\u0003က\u0002\u0004᠌\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b\nဇ\t\u000bဇ\n\fင\u000b\rဉ\f\u000eခ\r\u000fဉ\u000e\u0010ခ\u000f\u0011ဈ\u0010", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", zbaaq.zba, "zbi", "zbj", "zbk", "zbl", "zbm", "zbn", "zbo", "zbp", "zbq", "zbr", "zbs", "zbt", "zbu"});
        }
        if (i2 == 3) {
            return new zbaar();
        }
        if (i2 == 4) {
            return new zbaan(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
