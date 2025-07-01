package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaax extends zbuf implements zbvn {
    private static final zbaax zbb;
    private byte zbe = 2;
    private zbun zbd = zby();

    static {
        zbaax zbaaxVar = new zbaax();
        zbb = zbaaxVar;
        zbuf.zbD(zbaax.class, zbaaxVar);
    }

    private zbaax() {
    }

    public static zbaax zbe() {
        return zbb;
    }

    public final List zbf() {
        return this.zbd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", zbaaw.class});
        }
        if (i2 == 3) {
            return new zbaax();
        }
        if (i2 == 4) {
            return new zbaau(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
