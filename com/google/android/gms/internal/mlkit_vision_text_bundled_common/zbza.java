package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbza extends zbuf implements zbvn {
    private static final zbza zbb;
    private int zbd;
    private String zbe = "";
    private long zbf;
    private long zbg;
    private long zbh;

    static {
        zbza zbzaVar = new zbza();
        zbb = zbzaVar;
        zbuf.zbD(zbza.class, zbzaVar);
    }

    private zbza() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbza();
        }
        zbwz zbwzVar = null;
        if (i2 == 4) {
            return new zbyz(zbwzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
