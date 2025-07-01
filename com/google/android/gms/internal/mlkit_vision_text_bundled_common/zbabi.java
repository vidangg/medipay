package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbabi extends zbuf implements zbvn {
    private static final zbabi zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg = 1;
    private int zbh = 1;

    static {
        zbabi zbabiVar = new zbabi();
        zbb = zbabiVar;
        zbuf.zbD(zbabi.class, zbabiVar);
    }

    private zbabi() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbabi();
        }
        zbaad zbaadVar = null;
        if (i2 == 4) {
            return new zbabh(zbaadVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
