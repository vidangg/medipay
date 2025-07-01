package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbat extends zbuf implements zbvn {
    private static final zbat zbb;
    private int zbd;
    private float zbe;
    private boolean zbf;

    static {
        zbat zbatVar = new zbat();
        zbb = zbatVar;
        zbuf.zbD(zbat.class, zbatVar);
    }

    private zbat() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဇ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbat();
        }
        zbar zbarVar = null;
        if (i2 == 4) {
            return new zbas(zbarVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
