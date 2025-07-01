package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbhi extends zbuf implements zbvn {
    private static final zbhi zbb;
    private int zbd;
    private Object zbf;
    private float zbg;
    private boolean zbi;
    private int zbe = 0;
    private String zbh = "";

    static {
        zbhi zbhiVar = new zbhi();
        zbb = zbhiVar;
        zbuf.zbD(zbhi.class, zbhiVar);
    }

    private zbhi() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001;\u0000\u0002ခ\u0000\u0003;\u0000\u0004ဈ\u0001\u0005ဇ\u0002", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new zbhi();
        }
        zbhg zbhgVar = null;
        if (i2 == 4) {
            return new zbhh(zbhgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
