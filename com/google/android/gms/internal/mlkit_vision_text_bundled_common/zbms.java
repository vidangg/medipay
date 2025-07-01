package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zbms extends zbuf implements zbvn {
    private static final zbms zbb;
    private int zbd;
    private zbmu zbj;
    private byte zbk = 2;
    private String zbe = "";
    private zbun zbf = zbuf.zby();
    private zbun zbg = zbuf.zby();
    private zbun zbh = zbuf.zby();
    private zbun zbi = zbuf.zby();

    static {
        zbms zbmsVar = new zbms();
        zbb = zbmsVar;
        zbuf.zbD(zbms.class, zbmsVar);
    }

    private zbms() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbk);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001ϫ\u0006\u0000\u0004\u0001\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ᐉ\u0001Ϫ\u001aϫ\u001a", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbj", "zbg", "zbi"});
        }
        if (i2 == 3) {
            return new zbms();
        }
        if (i2 == 4) {
            return new zbmr(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
