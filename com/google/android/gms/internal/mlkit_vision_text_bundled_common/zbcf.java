package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbcf extends zbuf implements zbvn {
    private static final zbcf zbb;
    private int zbd;
    private float zbf;
    private int zbi;
    private float zbj;
    private zbun zbe = zbuf.zby();
    private boolean zbg = true;
    private float zbh = 0.8f;

    static {
        zbcf zbcfVar = new zbcf();
        zbb = zbcfVar;
        zbuf.zbD(zbcf.class, zbcfVar);
    }

    private zbcf() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001a\u0002ခ\u0000\u0003ဇ\u0001\u0004ခ\u0002\u0005င\u0003\u0006ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zbcf();
        }
        zbcd zbcdVar = null;
        if (i2 == 4) {
            return new zbce(zbcdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
