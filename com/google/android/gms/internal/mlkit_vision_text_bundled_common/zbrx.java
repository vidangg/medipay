package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbrx extends zbuf implements zbvn {
    private static final zbrx zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";
    private zbuk zbg = zbv();
    private int zbh;
    private int zbi;
    private float zbj;

    static {
        zbrx zbrxVar = new zbrx();
        zbb = zbrxVar;
        zbuf.zbD(zbrx.class, zbrxVar);
    }

    private zbrx() {
    }

    public static /* synthetic */ zbrx zba() {
        return zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0013\u0004င\u0002\u0005င\u0003\u0006ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zbrx();
        }
        if (i2 == 4) {
            return new zbrw(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
