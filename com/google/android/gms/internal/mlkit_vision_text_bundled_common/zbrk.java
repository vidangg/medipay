package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbrk extends zbuf implements zbvn {
    private static final zbrk zbb;
    private int zbd;
    private zbpw zbe;
    private byte zbg = 2;
    private zbul zbf = zbw();

    static {
        zbrk zbrkVar = new zbrk();
        zbb = zbrkVar;
        zbuf.zbD(zbrk.class, zbrkVar);
    }

    private zbrk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ᐉ\u0000\u0002\u0016", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbrk();
        }
        if (i2 == 4) {
            return new zbrj(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
