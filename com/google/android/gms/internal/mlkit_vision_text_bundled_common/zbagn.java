package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbagn extends zbuf implements zbvn {
    private static final zbagn zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private float zbh;
    private zbagq zbi;
    private float zbj;
    private zbafz zbk;
    private float zbl;
    private byte zbo = 2;
    private zbtc zbm = zbtc.zbb;
    private zbtc zbn = zbtc.zbb;

    static {
        zbagn zbagnVar = new zbagn();
        zbb = zbagnVar;
        zbuf.zbD(zbagn.class, zbagnVar);
    }

    private zbagn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ခ\u0003\u0005ခ\u0007\u0006ည\b\u0007ခ\u0005\bဉ\u0006\tᐉ\u0004\nည\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbl", "zbm", "zbj", "zbk", "zbi", "zbn"});
        }
        if (i2 == 3) {
            return new zbagn();
        }
        if (i2 == 4) {
            return new zbagm(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
