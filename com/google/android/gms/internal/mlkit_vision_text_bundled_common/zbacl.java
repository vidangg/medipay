package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbacl extends zbub implements zbvn {
    private static final zbacl zbd;
    private int zbe;
    private zbacb zbf;
    private float zbh;
    private float zbi;
    private float zbj;
    private float zbk;
    private float zbl;
    private long zbo;
    private long zbp;
    private long zbq;
    private float zbr;
    private zbacg zbs;
    private byte zbt = 2;
    private zbun zbg = zby();
    private zbun zbm = zby();
    private zbun zbn = zby();

    static {
        zbacl zbaclVar = new zbacl();
        zbd = zbaclVar;
        zbuf.zbD(zbacl.class, zbaclVar);
    }

    private zbacl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbt);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007\u001b\b\u001b\tဃ\u0007\nခ\t\u000bဃ\b\fဃ\u0006\rခ\u0005\u000eဉ\n", new Object[]{"zbe", "zbf", "zbg", zback.class, "zbh", "zbi", "zbj", "zbk", "zbm", zbace.class, "zbn", zbabz.class, "zbp", "zbr", "zbq", "zbo", "zbl", "zbs"});
        }
        if (i2 == 3) {
            return new zbacl();
        }
        if (i2 == 4) {
            return new zbacc(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
