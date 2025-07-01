package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbsp extends zbuf implements zbvn {
    private static final zbsp zbb;
    private String zbd = "";
    private zbtc zbe = zbtc.zbb;

    static {
        zbsp zbspVar = new zbsp();
        zbb = zbspVar;
        zbuf.zbD(zbsp.class, zbspVar);
    }

    private zbsp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zbvw(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbsp();
        }
        zbsn zbsnVar = null;
        if (i2 == 4) {
            return new zbso(zbsnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
