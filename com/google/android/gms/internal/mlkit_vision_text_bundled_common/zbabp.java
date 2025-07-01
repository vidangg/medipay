package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbabp extends zbuf implements zbvn {
    private static final zbabp zbb;
    private zbvg zbd = zbvg.zba();

    static {
        zbabp zbabpVar = new zbabp();
        zbb = zbabpVar;
        zbuf.zbD(zbabp.class, zbabpVar);
    }

    private zbabp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"zbd", zbabo.zba});
        }
        if (i2 == 3) {
            return new zbabp();
        }
        if (i2 == 4) {
            return new zbabn(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
