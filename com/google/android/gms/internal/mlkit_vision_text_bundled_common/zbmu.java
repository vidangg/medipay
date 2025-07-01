package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zbmu extends zbub implements zbvn {
    private static final zbmu zbd;
    private int zbe;
    private byte zbg = 2;
    private boolean zbf = true;

    static {
        zbmu zbmuVar = new zbmu();
        zbd = zbmuVar;
        zbuf.zbD(zbmu.class, zbmuVar);
    }

    private zbmu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbmu();
        }
        if (i2 == 4) {
            return new zbmt(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
