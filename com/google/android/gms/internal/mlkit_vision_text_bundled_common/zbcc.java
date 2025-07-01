package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbcc extends zbuf implements zbvn {
    private static final zbcc zbb;
    private int zbd;
    private String zbe = "";
    private String zbf = "";

    static {
        zbcc zbccVar = new zbcc();
        zbb = zbccVar;
        zbuf.zbD(zbcc.class, zbccVar);
    }

    private zbcc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbcc();
        }
        zbca zbcaVar = null;
        if (i2 == 4) {
            return new zbcb(zbcaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
