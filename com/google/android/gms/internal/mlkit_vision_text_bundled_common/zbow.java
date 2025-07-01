package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbow extends zbuf implements zbvn {
    private static final zbow zbb;
    private int zbd;
    private zbou zbe;
    private double zbf;
    private boolean zbg;
    private zbpb zbh;
    private byte zbi = 2;

    static {
        zbow zbowVar = new zbow();
        zbb = zbowVar;
        zbuf.zbD(zbow.class, zbowVar);
    }

    private zbow() {
    }

    public static zbow zbc() {
        return zbb;
    }

    public final zbpb zbd() {
        zbpb zbpbVar = this.zbh;
        return zbpbVar == null ? zbpb.zbh() : zbpbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002က\u0001\u0003ဇ\u0002\u0004ᐉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbow();
        }
        zboq zboqVar = null;
        if (i2 == 4) {
            return new zbov(zboqVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
