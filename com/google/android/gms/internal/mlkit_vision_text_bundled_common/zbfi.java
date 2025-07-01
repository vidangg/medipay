package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbfi extends zbuf implements zbvn {
    private static final zbfi zbb;
    private int zbd;
    private boolean zbe;
    private String zbf = "";
    private String zbg = "";

    static {
        zbfi zbfiVar = new zbfi();
        zbb = zbfiVar;
        zbuf.zbD(zbfi.class, zbfiVar);
    }

    private zbfi() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbfi();
        }
        zbfg zbfgVar = null;
        if (i2 == 4) {
            return new zbfh(zbfgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
