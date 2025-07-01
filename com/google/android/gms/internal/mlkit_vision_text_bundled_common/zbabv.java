package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbabv extends zbuf implements zbvn {
    private static final zbabv zbb;
    private zbun zbd = zby();
    private zbun zbe = zby();

    static {
        zbabv zbabvVar = new zbabv();
        zbb = zbabvVar;
        zbuf.zbD(zbabv.class, zbabvVar);
    }

    private zbabv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zbd", zbabs.class, "zbe", zbadi.class});
        }
        if (i2 == 3) {
            return new zbabv();
        }
        if (i2 == 4) {
            return new zbabu(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
