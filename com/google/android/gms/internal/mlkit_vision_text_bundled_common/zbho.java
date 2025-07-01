package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbho extends zbuf implements zbvn {
    private static final zbho zbb;
    private int zbd;
    private int zbe;
    private long zbf;
    private long zbg;

    static {
        zbho zbhoVar = new zbho();
        zbb = zbhoVar;
        zbuf.zbD(zbho.class, zbhoVar);
    }

    private zbho() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbho();
        }
        zbhm zbhmVar = null;
        if (i2 == 4) {
            return new zbhn(zbhmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
