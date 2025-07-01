package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbgz extends zbuf implements zbvn {
    private static final zbgz zbb;
    private int zbd;
    private int zbe;
    private float zbf;
    private String zbg = "";
    private String zbh = "";

    static {
        zbgz zbgzVar = new zbgz();
        zbb = zbgzVar;
        zbuf.zbD(zbgz.class, zbgzVar);
    }

    private zbgz() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbgz();
        }
        zbgx zbgxVar = null;
        if (i2 == 4) {
            return new zbgy(zbgxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
