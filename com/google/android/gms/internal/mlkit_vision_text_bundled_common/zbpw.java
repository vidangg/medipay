package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbpw extends zbuf implements zbvn {
    private static final zbpw zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private float zbi;
    private zbqg zbj;
    private byte zbk = 2;

    static {
        zbpw zbpwVar = new zbpw();
        zbb = zbpwVar;
        zbuf.zbD(zbpw.class, zbpwVar);
    }

    private zbpw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbk);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002\u0004ᔄ\u0003\u0005ခ\u0004\u0006ဉ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zbpw();
        }
        if (i2 == 4) {
            return new zbpv(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
