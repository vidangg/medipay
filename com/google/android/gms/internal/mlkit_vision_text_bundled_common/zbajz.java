package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbajz extends zbuf implements zbvn {
    private static final zbajz zbb;
    private zbuk zbd = zbv();

    static {
        zbajz zbajzVar = new zbajz();
        zbb = zbajzVar;
        zbuf.zbD(zbajz.class, zbajzVar);
    }

    private zbajz() {
    }

    public static /* synthetic */ zbajz zbc() {
        return zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001$", new Object[]{"zbd"});
        }
        if (i2 == 3) {
            return new zbajz();
        }
        if (i2 == 4) {
            return new zbajy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
