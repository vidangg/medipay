package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbagj extends zbuf implements zbvn {
    private static final zbagj zbb;
    private int zbd;
    private int zbe;
    private int zbg;
    private boolean zbh;
    private byte zbi = 2;
    private zbun zbf = zby();

    static {
        zbagj zbagjVar = new zbagj();
        zbb = zbagjVar;
        zbuf.zbD(zbagj.class, zbagjVar);
    }

    private zbagj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0003\u0006\u0004\u0000\u0001\u0002\u0003ᔄ\u0000\u0004Л\u0005င\u0001\u0006ဇ\u0002", new Object[]{"zbd", "zbe", "zbf", zbagn.class, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbagj();
        }
        if (i2 == 4) {
            return new zbagi(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
