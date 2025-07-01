package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbajq extends zbuf implements zbvn {
    private static final zbajq zbb;
    private zbun zbd = zby();
    private zbun zbe = zby();

    static {
        zbajq zbajqVar = new zbajq();
        zbb = zbajqVar;
        zbuf.zbD(zbajq.class, zbajqVar);
    }

    private zbajq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zbd", zbajk.class, "zbe", zbajn.class});
        }
        if (i2 == 3) {
            return new zbajq();
        }
        if (i2 == 4) {
            return new zbajp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
