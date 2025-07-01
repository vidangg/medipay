package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbzv extends zbuf implements zbvn {
    private static final zbzv zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private zbuk zbg = zbv();
    private int zbh;

    static {
        zbzv zbzvVar = new zbzv();
        zbb = zbzvVar;
        zbuf.zbD(zbzv.class, zbzvVar);
    }

    private zbzv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003$\u0004᠌\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", zbzu.zba});
        }
        if (i2 == 3) {
            return new zbzv();
        }
        zbzs zbzsVar = null;
        if (i2 == 4) {
            return new zbzt(zbzsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
