package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbalv extends zbuf implements zbvn {
    private static final zbalv zbb;
    private int zbd;
    private float zbg;
    private String zbe = "en";
    private int zbf = -1;
    private zbun zbh = zbuf.zby();
    private zbun zbi = zbuf.zby();

    static {
        zbalv zbalvVar = new zbalv();
        zbb = zbalvVar;
        zbuf.zbD(zbalv.class, zbalvVar);
    }

    private zbalv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ခ\u0002\u0004\u001a\u0005\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new zbalv();
        }
        zbalt zbaltVar = null;
        if (i2 == 4) {
            return new zbalu(zbaltVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
