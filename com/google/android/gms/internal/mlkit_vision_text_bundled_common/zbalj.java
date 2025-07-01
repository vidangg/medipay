package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbalj extends zbuf implements zbvn {
    private static final zbalj zbb;
    private zbun zbd = zby();

    static {
        zbalj zbaljVar = new zbalj();
        zbb = zbaljVar;
        zbuf.zbD(zbalj.class, zbaljVar);
    }

    private zbalj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbalg.class});
        }
        if (i2 == 3) {
            return new zbalj();
        }
        if (i2 == 4) {
            return new zbali(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
