package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbahp extends zbuf implements zbvn {
    private static final zbahp zbb;
    private int zbd = 0;
    private Object zbe;
    private float zbf;

    static {
        zbahp zbahpVar = new zbahp();
        zbb = zbahpVar;
        zbuf.zbD(zbahp.class, zbahpVar);
    }

    private zbahp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001?\u0000\u0002Ȼ\u0000\u0003\u0001", new Object[]{"zbe", "zbd", "zbf"});
        }
        if (i2 == 3) {
            return new zbahp();
        }
        zbagx zbagxVar = null;
        if (i2 == 4) {
            return new zbaho(zbagxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
