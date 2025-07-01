package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbakf extends zbuf implements zbvn {
    private static final zbakf zbb;
    private zbum zbd = zbx();

    static {
        zbakf zbakfVar = new zbakf();
        zbb = zbakfVar;
        zbuf.zbD(zbakf.class, zbakfVar);
    }

    private zbakf() {
    }

    public static /* synthetic */ zbakf zbc() {
        return zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001%", new Object[]{"zbd"});
        }
        if (i2 == 3) {
            return new zbakf();
        }
        zbakd zbakdVar = null;
        if (i2 == 4) {
            return new zbake(zbakdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
