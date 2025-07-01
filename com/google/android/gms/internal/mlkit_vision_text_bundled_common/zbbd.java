package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbd extends zbuf implements zbvn {
    private static final zbbd zbb;
    private int zbd;
    private String zbe = "";
    private String zbf = "";
    private String zbg = "";

    static {
        zbbd zbbdVar = new zbbd();
        zbb = zbbdVar;
        zbuf.zbD(zbbd.class, zbbdVar);
    }

    private zbbd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbbd();
        }
        zbba zbbaVar = null;
        if (i2 == 4) {
            return new zbbc(zbbaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
