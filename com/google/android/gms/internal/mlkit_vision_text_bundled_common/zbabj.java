package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbabj extends zbub implements zbvn {
    private static final zbabj zbd;
    private int zbD;
    private zbaar zbE;
    private zbaac zbF;
    private int zbG;
    private int zbe;
    private zbaaj zbh;
    private zbaat zbi;
    private int zbk;
    private zboz zbl;
    private float zbm;
    private float zbn;
    private float zbo;
    private float zbp;
    private float zbq;
    private zbaax zbs;
    private zbaam zbu;
    private zbabc zbv;
    private zbabi zbw;
    private int zbx;
    private long zby;
    private zbsp zbz;
    private byte zbH = 2;
    private int zbf = -1;
    private zbul zbg = zbw();
    private int zbj = 2;
    private String zbr = "";
    private String zbt = "";
    private String zbA = "";
    private zbun zbB = zbuf.zby();
    private zbuk zbC = zbv();

    static {
        zbabj zbabjVar = new zbabj();
        zbd = zbabjVar;
        zbuf.zbD(zbabj.class, zbabjVar);
    }

    private zbabj() {
    }

    public final String zbH() {
        return this.zbt;
    }

    public final int zbI() {
        int zba = zbabg.zba(this.zbj);
        if (zba == 0) {
            return 3;
        }
        return zba;
    }

    public final float zbc() {
        return this.zbp;
    }

    public final int zbe() {
        return this.zbf;
    }

    public final zbaaj zbf() {
        zbaaj zbaajVar = this.zbh;
        return zbaajVar == null ? zbaaj.zbh() : zbaajVar;
    }

    public final zbaax zbh() {
        zbaax zbaaxVar = this.zbs;
        return zbaaxVar == null ? zbaax.zbe() : zbaaxVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbH);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001\u001c\u0000\u0001\u0001 \u001c\u0000\u0003\u0005\u0001င\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဉ\u0005\u0007ခ\t\bဈ\u000b\rᐉ\f\u000eခ\u0006\u000fဈ\r\u0010ᐉ\u000e\u0011ဉ\u000f\u0012ဉ\u0010\u0013င\u0011\u0014ဂ\u0012\u0015ဉ\u0013\u0016ခ\b\u0017ဈ\u0014\u0018\u001a\u0019\u0013\u001aင\u0015\u001bခ\u0007\u001cဉ\u0016\u001d'\u001eᐉ\u0017\u001fခ\n င\u0018", new Object[]{"zbe", "zbf", "zbh", "zbi", "zbj", zbabf.zba, "zbk", zbabd.zba, "zbl", "zbp", "zbr", "zbs", "zbm", "zbt", "zbu", "zbv", "zbw", "zbx", "zby", "zbz", "zbo", "zbA", "zbB", "zbC", "zbD", "zbn", "zbE", "zbg", "zbF", "zbq", "zbG"});
        }
        if (i2 == 3) {
            return new zbabj();
        }
        if (i2 == 4) {
            return new zbaay(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbH = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
