package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdr extends zbuf implements zbvn {
    private static final zbdr zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";

    static {
        zbdr zbdrVar = new zbdr();
        zbb = zbdrVar;
        zbuf.zbD(zbdr.class, zbdrVar);
    }

    private zbdr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", zbdq.zba, "zbf"});
        }
        if (i2 == 3) {
            return new zbdr();
        }
        if (i2 == 4) {
            return new zbdp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
