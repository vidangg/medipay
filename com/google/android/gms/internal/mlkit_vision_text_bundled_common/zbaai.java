package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaai extends zbuf implements zbvn {
    private static final zbaai zbb;
    private int zbd;
    private zbpb zbf;
    private byte zbg = 2;
    private zbun zbe = zby();

    static {
        zbaai zbaaiVar = new zbaai();
        zbb = zbaaiVar;
        zbuf.zbD(zbaai.class, zbaaiVar);
    }

    private zbaai() {
    }

    public static zbaai zbf() {
        return zbb;
    }

    public final zbpb zbc() {
        zbpb zbpbVar = this.zbf;
        return zbpbVar == null ? zbpb.zbh() : zbpbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000", new Object[]{"zbd", "zbe", zbaag.class, "zbf"});
        }
        if (i2 == 3) {
            return new zbaai();
        }
        zbaad zbaadVar = null;
        if (i2 == 4) {
            return new zbaah(zbaadVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
