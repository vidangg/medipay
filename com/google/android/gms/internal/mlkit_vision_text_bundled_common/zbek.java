package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbek extends zbuf implements zbvn {
    private static final zbek zbb;
    private int zbd;
    private long zbe;
    private float zbf;

    static {
        zbek zbekVar = new zbek();
        zbb = zbekVar;
        zbuf.zbD(zbek.class, zbekVar);
    }

    private zbek() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbek();
        }
        zbei zbeiVar = null;
        if (i2 == 4) {
            return new zbej(zbeiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
