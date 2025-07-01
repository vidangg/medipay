package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbiw extends zbuf implements zbvn {
    private static final zbiw zbb;
    private int zbd;
    private zbhl zbe;
    private zbhl zbf;

    static {
        zbiw zbiwVar = new zbiw();
        zbb = zbiwVar;
        zbuf.zbD(zbiw.class, zbiwVar);
    }

    private zbiw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbiw();
        }
        if (i2 == 4) {
            return new zbiv(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
