package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaaj extends zbuf implements zbvn {
    private static final zbaaj zbb;
    private Object zbe;
    private int zbd = 0;
    private byte zbf = 2;

    static {
        zbaaj zbaajVar = new zbaaj();
        zbb = zbaajVar;
        zbuf.zbD(zbaaj.class, zbaajVar);
    }

    private zbaaj() {
    }

    public static zbaaj zbh() {
        return zbb;
    }

    public final boolean zbH() {
        return this.zbd == 1;
    }

    public final zbow zbc() {
        return this.zbd == 3 ? (zbow) this.zbe : zbow.zbc();
    }

    public final zbpb zbe() {
        return this.zbd == 2 ? (zbpb) this.zbe : zbpb.zbh();
    }

    public final zbaai zbf() {
        return this.zbd == 1 ? (zbaai) this.zbe : zbaai.zbf();
    }

    public final boolean zbi() {
        return this.zbd == 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbf);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0003\u0001м\u0000\u0002м\u0000\u0003м\u0000", new Object[]{"zbe", "zbd", zbaai.class, zbpb.class, zbow.class});
        }
        if (i2 == 3) {
            return new zbaaj();
        }
        zbaad zbaadVar = null;
        if (i2 == 4) {
            return new zbaae(zbaadVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
