package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbna extends zbuf implements zbvn {
    private static final zbna zbb;
    private int zbd;
    private zbmd zbf;
    private byte zbg = 2;
    private String zbe = "DefaultInputStreamHandler";

    static {
        zbna zbnaVar = new zbna();
        zbb = zbnaVar;
        zbuf.zbD(zbna.class, zbnaVar);
    }

    private zbna() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0003ᐉ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbna();
        }
        if (i2 == 4) {
            return new zbmz(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
