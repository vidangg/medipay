package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaft extends zbuf implements zbvn {
    private static final zbaft zbb;
    private int zbd;
    private zbafw zbe;
    private zbaey zbf;
    private zbaff zbg;

    static {
        zbaft zbaftVar = new zbaft();
        zbb = zbaftVar;
        zbuf.zbD(zbaft.class, zbaftVar);
    }

    private zbaft() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbaft();
        }
        if (i2 == 4) {
            return new zbafs(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
