package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbabz extends zbuf implements zbvn {
    private static final zbabz zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";
    private float zbg;
    private float zbh;

    static {
        zbabz zbabzVar = new zbabz();
        zbb = zbabzVar;
        zbuf.zbD(zbabz.class, zbabzVar);
    }

    private zbabz() {
    }

    public static zbabz zbe() {
        return zbb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zbd", "zbe", zbaby.zba, "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbabz();
        }
        zbabw zbabwVar = null;
        if (i2 == 4) {
            return new zbabx(zbabwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
