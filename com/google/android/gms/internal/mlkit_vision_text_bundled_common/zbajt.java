package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbajt extends zbuf implements zbvn {
    private static final zbajt zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private String zbg = "";

    static {
        zbajt zbajtVar = new zbajt();
        zbb = zbajtVar;
        zbuf.zbD(zbajt.class, zbajtVar);
    }

    private zbajt() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004Ȉ", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbajt();
        }
        zbajr zbajrVar = null;
        if (i2 == 4) {
            return new zbajs(zbajrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
