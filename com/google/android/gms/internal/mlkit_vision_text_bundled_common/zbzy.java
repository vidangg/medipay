package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbzy extends zbub implements zbvn {
    private static final zbzy zbd;
    private int zbe;
    private double zbf;
    private int zbg;
    private int zbh;
    private double zbi;
    private double zbj;
    private byte zbk = 2;

    static {
        zbzy zbzyVar = new zbzy();
        zbd = zbzyVar;
        zbuf.zbD(zbzy.class, zbzyVar);
    }

    private zbzy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbk);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001က\u0000\u0002င\u0001\u0003င\u0002\u0004က\u0003\u0005က\u0004", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new zbzy();
        }
        if (i2 == 4) {
            return new zbzx(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
