package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaee extends zbuf implements zbvn {
    private static final zbaee zbb;
    private int zbd;
    private zbun zbe = zby();
    private zbaed zbf;
    private float zbg;
    private int zbh;
    private boolean zbi;
    private boolean zbj;

    static {
        zbaee zbaeeVar = new zbaee();
        zbb = zbaeeVar;
        zbuf.zbD(zbaee.class, zbaeeVar);
        zbuf.zbr(zbadz.zbe(), zbaeeVar, zbaeeVar, null, 32149011, zbww.MESSAGE, zbaee.class);
    }

    private zbaee() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0003\u0003ဉ\u0000\u0004ခ\u0001\u0005ဇ\u0004\u0006᠌\u0002", new Object[]{"zbd", "zbe", zbaed.class, "zbi", "zbf", "zbg", "zbj", "zbh", zbaeb.zba});
        }
        if (i2 == 3) {
            return new zbaee();
        }
        if (i2 == 4) {
            return new zbaea(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
