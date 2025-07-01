package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbcl extends zbuf implements zbvn {
    private static final zbcl zbb;
    private int zbd;
    private zbbz zbe;
    private zbuk zbf = zbv();

    static {
        zbcl zbclVar = new zbcl();
        zbb = zbclVar;
        zbuf.zbD(zbcl.class, zbclVar);
    }

    private zbcl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0013", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbcl();
        }
        zbcj zbcjVar = null;
        if (i2 == 4) {
            return new zbck(zbcjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
