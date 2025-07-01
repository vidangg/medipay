package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbjg extends zbuf implements zbvn {
    private static final zbjg zbb;
    private int zbd;
    private zbun zbe = zby();
    private String zbf = "";

    static {
        zbjg zbjgVar = new zbjg();
        zbb = zbjgVar;
        zbuf.zbD(zbjg.class, zbjgVar);
    }

    private zbjg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zbd", "zbe", zbjd.class, "zbf"});
        }
        if (i2 == 3) {
            return new zbjg();
        }
        zbje zbjeVar = null;
        if (i2 == 4) {
            return new zbjf(zbjeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
