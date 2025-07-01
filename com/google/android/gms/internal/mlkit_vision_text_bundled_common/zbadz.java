package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbadz extends zbub implements zbvn {
    private static final zbadz zbd;
    private byte zbf = 2;
    private zbun zbe = zby();

    static {
        zbadz zbadzVar = new zbadz();
        zbd = zbadzVar;
        zbuf.zbD(zbadz.class, zbadzVar);
    }

    private zbadz() {
    }

    public static zbadz zbe() {
        return zbd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbf);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0001\u0000\u0000\u0003\u0003\u0001\u0000\u0001\u0000\u0003\u001b", new Object[]{"zbe", zbady.class});
        }
        if (i2 == 3) {
            return new zbadz();
        }
        if (i2 == 4) {
            return new zbadw(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
