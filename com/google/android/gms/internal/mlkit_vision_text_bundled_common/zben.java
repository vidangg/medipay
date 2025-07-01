package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zben extends zbuf implements zbvn {
    private static final zben zbb;
    private int zbd;
    private zbfu zbe;
    private zbnm zbf;
    private zbbn zbg;
    private zbfl zbh;
    private zbet zbi;
    private zbeq zbj;
    private zbff zbk;
    private byte zbl = 2;

    static {
        zben zbenVar = new zben();
        zbb = zbenVar;
        zbuf.zbD(zben.class, zbenVar);
    }

    private zben() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbl);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new zben();
        }
        zbel zbelVar = null;
        if (i2 == 4) {
            return new zbem(zbelVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
