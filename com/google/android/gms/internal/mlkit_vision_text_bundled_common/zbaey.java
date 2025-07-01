package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaey extends zbuf implements zbvn {
    private static final zbaey zbb;
    private zbuk zbd = zbv();
    private zbuk zbe = zbv();
    private zbuk zbf = zbv();
    private zbuk zbg = zbv();
    private zbuk zbh = zbv();
    private zbuk zbi = zbv();

    static {
        zbaey zbaeyVar = new zbaey();
        zbb = zbaeyVar;
        zbuf.zbD(zbaey.class, zbaeyVar);
    }

    private zbaey() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0006\u0000\u0001\u0013\u0002\u0013\u0003\u0013\u0004\u0013\u0005\u0013\u0006\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new zbaey();
        }
        if (i2 == 4) {
            return new zbaex(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
