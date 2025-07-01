package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zban extends zbuf implements zbvn {
    private static final zban zbb;
    private int zbd;
    private int zbe;
    private float zbf = 1.0f;

    static {
        zban zbanVar = new zban();
        zbb = zbanVar;
        zbuf.zbD(zban.class, zbanVar);
    }

    private zban() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", zbam.zba, "zbf"});
        }
        if (i2 == 3) {
            return new zban();
        }
        if (i2 == 4) {
            return new zbal(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
