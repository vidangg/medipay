package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbnw extends zbuf implements zbvn {
    private static final zbnw zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private float zbh;
    private float zbi;
    private long zbj;
    private byte zbk = 2;

    static {
        zbnw zbnwVar = new zbnw();
        zbb = zbnwVar;
        zbuf.zbD(zbnw.class, zbnwVar);
    }

    private zbnw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbk);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ᔁ\u0003\u0005ခ\u0004\u0006ဂ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zbnw();
        }
        zbnu zbnuVar = null;
        if (i2 == 4) {
            return new zbnv(zbnuVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
