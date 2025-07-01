package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaio extends zbuf implements zbvn {
    private static final zbaio zbb;
    private int zbd;
    private int zbe;
    private boolean zbh;
    private int zbf = 100;
    private int zbg = -100;
    private float zbi = 40.0f;

    static {
        zbaio zbaioVar = new zbaio();
        zbb = zbaioVar;
        zbuf.zbD(zbaio.class, zbaioVar);
    }

    private zbaio() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0005ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new zbaio();
        }
        zbaim zbaimVar = null;
        if (i2 == 4) {
            return new zbain(zbaimVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
