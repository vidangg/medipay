package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbafz extends zbuf implements zbvn {
    private static final zbafz zbb;
    private zbuk zbd = zbv();

    static {
        zbafz zbafzVar = new zbafz();
        zbb = zbafzVar;
        zbuf.zbD(zbafz.class, zbafzVar);
    }

    private zbafz() {
    }

    public static /* synthetic */ zbafz zbc() {
        return zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001$", new Object[]{"zbd"});
        }
        if (i2 == 3) {
            return new zbafz();
        }
        if (i2 == 4) {
            return new zbafy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
