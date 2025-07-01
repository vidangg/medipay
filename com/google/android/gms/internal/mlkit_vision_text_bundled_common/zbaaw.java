package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaaw extends zbuf implements zbvn {
    private static final zbaaw zbb;
    private int zbd;
    private byte zbg = 2;
    private String zbe = "";
    private float zbf = 1.0f;

    static {
        zbaaw zbaawVar = new zbaaw();
        zbb = zbaawVar;
        zbuf.zbD(zbaaw.class, zbaawVar);
    }

    private zbaaw() {
    }

    public final float zbc() {
        return this.zbf;
    }

    public final String zbf() {
        return this.zbe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔈ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbaaw();
        }
        zbaad zbaadVar = null;
        if (i2 == 4) {
            return new zbaav(zbaadVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
