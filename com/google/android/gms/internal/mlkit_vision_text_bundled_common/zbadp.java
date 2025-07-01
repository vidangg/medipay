package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbadp extends zbuf implements zbvn {
    private static final zbadp zbb;
    private int zbd;
    private zbun zbe = zbuf.zby();
    private String zbf = "";
    private float zbg;

    static {
        zbadp zbadpVar = new zbadp();
        zbb = zbadpVar;
        zbuf.zbD(zbadp.class, zbadpVar);
    }

    private zbadp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000\u0003ခ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbadp();
        }
        zbadn zbadnVar = null;
        if (i2 == 4) {
            return new zbado(zbadnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
