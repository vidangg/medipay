package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbpp extends zbuf implements zbvn {
    private static final zbpp zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private String zbh = "";

    static {
        zbpp zbppVar = new zbpp();
        zbb = zbppVar;
        zbuf.zbD(zbpp.class, zbppVar);
    }

    private zbpp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဏ\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", zbpt.zba, "zbf", zbps.zba, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbpp();
        }
        if (i2 == 4) {
            return new zbpo(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
