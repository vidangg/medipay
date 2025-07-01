package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zblw extends zbuf implements zbvn {
    private static final zblw zbb;
    private int zbd;
    private zbmd zbg;
    private byte zbh = 2;
    private String zbe = "";
    private String zbf = "";

    static {
        zblw zblwVar = new zblw();
        zbb = zblwVar;
        zbuf.zbD(zblw.class, zblwVar);
    }

    private zblw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ȉ\u0002Ȉ\u0003ᐉ\u0000", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zblw();
        }
        if (i2 == 4) {
            return new zblv(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
