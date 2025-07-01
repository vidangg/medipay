package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbnc extends zbuf implements zbvn {
    private static final zbnc zbb;
    private int zbd;
    private zbmd zbg;
    private byte zbh = 2;
    private String zbe = "InOrderOutputStreamHandler";
    private zbun zbf = zbuf.zby();

    static {
        zbnc zbncVar = new zbnc();
        zbb = zbncVar;
        zbuf.zbD(zbnc.class, zbncVar);
    }

    private zbnc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbnc();
        }
        if (i2 == 4) {
            return new zbnb(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
