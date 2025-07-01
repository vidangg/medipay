package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbrm extends zbuf implements zbvn {
    private static final zbrm zbb;
    private int zbd;
    private zbpw zbe;
    private int zbh;
    private int zbi;
    private byte zbj = 2;
    private String zbf = "";
    private zbul zbg = zbw();

    static {
        zbrm zbrmVar = new zbrm();
        zbb = zbrmVar;
        zbuf.zbD(zbrm.class, zbrmVar);
    }

    private zbrm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ဈ\u0001\u0003\u0016\u0004င\u0002\u0005᠌\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", zbabe.zba()});
        }
        if (i2 == 3) {
            return new zbrm();
        }
        if (i2 == 4) {
            return new zbrl(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
