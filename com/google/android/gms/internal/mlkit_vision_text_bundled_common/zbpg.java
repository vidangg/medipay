package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbpg extends zbuf implements zbvn {
    private static final zbpg zbb;
    private int zbd;
    private zbpk zbe;
    private double zbf;
    private double zbg;

    static {
        zbpg zbpgVar = new zbpg();
        zbb = zbpgVar;
        zbuf.zbD(zbpg.class, zbpgVar);
    }

    private zbpg() {
    }

    public static zbpf zba() {
        return (zbpf) zbb.zbq();
    }

    public static /* synthetic */ void zbd(zbpg zbpgVar, zbpk zbpkVar) {
        zbpkVar.getClass();
        zbpgVar.zbe = zbpkVar;
        zbpgVar.zbd |= 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000\u0003\u0000", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbpg();
        }
        if (i2 == 4) {
            return new zbpf(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
