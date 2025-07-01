package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbis extends zbuf implements zbvn {
    private static final zbis zbb;
    private int zbd;
    private zbun zbe = zby();
    private int zbf;

    static {
        zbis zbisVar = new zbis();
        zbb = zbisVar;
        zbuf.zbD(zbis.class, zbisVar);
    }

    private zbis() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002င\u0000", new Object[]{"zbd", "zbe", zbgz.class, "zbf"});
        }
        if (i2 == 3) {
            return new zbis();
        }
        if (i2 == 4) {
            return new zbir(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
