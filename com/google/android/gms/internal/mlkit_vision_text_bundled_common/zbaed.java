package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaed extends zbuf implements zbvn {
    private static final zbaed zbb;
    private int zbd;
    private float zbf;
    private float zbg;
    private float zbi;
    private String zbe = "";
    private float zbh = 1.0f;
    private zbun zbj = zbuf.zby();

    static {
        zbaed zbaedVar = new zbaed();
        zbb = zbaedVar;
        zbuf.zbD(zbaed.class, zbaedVar);
    }

    private zbaed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zbaed();
        }
        zbadn zbadnVar = null;
        if (i2 == 4) {
            return new zbaec(zbadnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
