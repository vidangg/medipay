package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbma extends zbuf implements zbvn {
    private static final zbma zbb;
    private long zbd;
    private long zbe;
    private boolean zbf;
    private boolean zbg;
    private boolean zbh;
    private boolean zbi;
    private long zbj;
    private int zbm;
    private long zbn;
    private long zbo;
    private boolean zbp;
    private int zbq;
    private boolean zbr;
    private boolean zbs;
    private boolean zbt;
    private zbul zbk = zbw();
    private String zbl = "";
    private String zbu = "";

    static {
        zbma zbmaVar = new zbma();
        zbb = zbmaVar;
        zbuf.zbD(zbma.class, zbmaVar);
    }

    private zbma() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0012\u0000\u0000\u0001\u0012\u0012\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003\u0007\u0004\u0007\u0005\u0007\u0006\u0007\u0007\u0002\b'\tȈ\n\u0004\u000b\u0002\f\u0002\r\u0007\u000e\u0004\u000f\u0007\u0010\u0007\u0011\u0007\u0012Ȉ", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn", "zbo", "zbp", "zbq", "zbr", "zbs", "zbt", "zbu"});
        }
        if (i2 == 3) {
            return new zbma();
        }
        if (i2 == 4) {
            return new zblz(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
