package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbro extends zbuf implements zbvn {
    private static final zbro zbb;
    private int zbd;
    private int zbf;
    private int zbg;
    private zbrq zbj;
    private zbqw zbl;
    private zbqt zbm;
    private byte zbo = 2;
    private zbtc zbe = zbtc.zbb;
    private String zbh = "";
    private zbun zbi = zby();
    private zbun zbk = zby();
    private zbun zbn = zby();

    static {
        zbro zbroVar = new zbro();
        zbb = zbroVar;
        zbuf.zbD(zbro.class, zbroVar);
    }

    private zbro() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0003\u0004\u0001ᔊ\u0000\u0002ဈ\u0003\u0003Л\u0004ဉ\u0004\u0005Л\u0006ဉ\u0005\u0007ဉ\u0006\bЛ\tင\u0001\nင\u0002", new Object[]{"zbd", "zbe", "zbh", "zbi", zbqq.class, "zbj", "zbk", zbrm.class, "zbl", "zbm", "zbn", zbrk.class, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbro();
        }
        zbpu zbpuVar = null;
        if (i2 == 4) {
            return new zbrn(zbpuVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
