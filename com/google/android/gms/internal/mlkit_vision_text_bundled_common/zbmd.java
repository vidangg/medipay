package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbmd extends zbub implements zbvn {
    private static final zbmd zbd;
    private byte zbe = 2;

    static {
        zbmd zbmdVar = new zbmd();
        zbd = zbmdVar;
        zbuf.zbD(zbmd.class, zbmdVar);
    }

    private zbmd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zbmd();
        }
        if (i2 == 4) {
            return new zbmc(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
