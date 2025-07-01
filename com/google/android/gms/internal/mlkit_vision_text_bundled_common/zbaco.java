package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaco extends zbuf implements zbvn {
    private static final zbaco zbb;
    private byte zbe = 2;
    private zbun zbd = zby();

    static {
        zbaco zbacoVar = new zbaco();
        zbb = zbacoVar;
        zbuf.zbD(zbaco.class, zbacoVar);
    }

    private zbaco() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", zbacl.class});
        }
        if (i2 == 3) {
            return new zbaco();
        }
        zbacm zbacmVar = null;
        if (i2 == 4) {
            return new zbacn(zbacmVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
