package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaia extends zbuf implements zbvn {
    private static final zbaia zbb;
    private zbun zbd = zby();
    private zbun zbe = zby();
    private zbun zbf = zby();
    private zbun zbg = zby();

    static {
        zbaia zbaiaVar = new zbaia();
        zbb = zbaiaVar;
        zbuf.zbD(zbaia.class, zbaiaVar);
    }

    private zbaia() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b", new Object[]{"zbd", zbahm.class, "zbe", zbahb.class, "zbf", zbaif.class, "zbg", zbahy.class});
        }
        if (i2 == 3) {
            return new zbaia();
        }
        zbagx zbagxVar = null;
        if (i2 == 4) {
            return new zbahz(zbagxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
