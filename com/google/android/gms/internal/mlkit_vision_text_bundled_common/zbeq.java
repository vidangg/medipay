package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbeq extends zbuf implements zbvn {
    private static final zbeq zbb;
    private int zbd;
    private int zbf;
    private int zbg;
    private float zbi;
    private zbun zbe = zby();
    private String zbh = "";

    static {
        zbeq zbeqVar = new zbeq();
        zbb = zbeqVar;
        zbuf.zbD(zbeq.class, zbeqVar);
    }

    private zbeq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001c\u0002င\u0000\u0003င\u0001\u0004ဈ\u0002\u0005ခ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new zbeq();
        }
        zbeo zbeoVar = null;
        if (i2 == 4) {
            return new zbep(zbeoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
