package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbqd extends zbuf implements zbvn {
    private static final zbqd zbb;
    private int zbd;
    private double zbe;
    private double zbf;

    static {
        zbqd zbqdVar = new zbqd();
        zbb = zbqdVar;
        zbuf.zbD(zbqd.class, zbqdVar);
    }

    private zbqd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbqd();
        }
        zbpu zbpuVar = null;
        if (i2 == 4) {
            return new zbqc(zbpuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
