package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbn extends zbuf implements zbvn {
    private static final zbbn zbb;
    private int zbd;
    private float zbh;
    private byte zbi = 2;
    private String zbe = "";
    private String zbf = "";
    private zbun zbg = zby();

    static {
        zbbn zbbnVar = new zbbn();
        zbb = zbbnVar;
        zbuf.zbD(zbbn.class, zbbnVar);
    }

    private zbbn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003Л\u0004ခ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg", zbre.class, "zbh"});
        }
        if (i2 == 3) {
            return new zbbn();
        }
        if (i2 == 4) {
            return new zbbm(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
