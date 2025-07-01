package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbjm extends zbub implements zbvn {
    private static final zbjm zbd;
    private int zbe;
    private long zbf;
    private zbgo zbg;
    private zbgw zbh;
    private byte zbj = 2;
    private zbun zbi = zby();

    static {
        zbjm zbjmVar = new zbjm();
        zbd = zbjmVar;
        zbuf.zbD(zbjm.class, zbjmVar);
    }

    private zbjm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဉ\u0001\u0003\u001b\u0004ဉ\u0002", new Object[]{"zbe", "zbf", "zbg", "zbi", zbgz.class, "zbh"});
        }
        if (i2 == 3) {
            return new zbjm();
        }
        if (i2 == 4) {
            return new zbjl(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
