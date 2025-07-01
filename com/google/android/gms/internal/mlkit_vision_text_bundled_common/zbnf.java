package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbnf extends zbuf implements zbvn {
    private static final zbnf zbb;
    private int zbd;
    private int zbe;
    private zbgo zbf;
    private String zbg = "";

    static {
        zbnf zbnfVar = new zbnf();
        zbb = zbnfVar;
        zbuf.zbD(zbnf.class, zbnfVar);
    }

    private zbnf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbnf();
        }
        if (i2 == 4) {
            return new zbne(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
