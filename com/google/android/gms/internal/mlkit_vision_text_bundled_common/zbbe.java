package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbe extends zbuf implements zbvn {
    private static final zbbe zbb;
    private int zbA;
    private boolean zbB;
    private zbbd zbC;
    private int zbd;
    private boolean zbg;
    private zbpg zbh;
    private boolean zbi;
    private int zbj;
    private int zbk;
    private boolean zbl;
    private boolean zbm;
    private float zbn;
    private float zbo;
    private boolean zbp;
    private boolean zbq;
    private boolean zbt;
    private int zbu;
    private boolean zbv;
    private boolean zbx;
    private zbpr zby;
    private boolean zbz;
    private String zbe = "";
    private String zbf = "";
    private boolean zbr = true;
    private boolean zbs = true;
    private float zbw = 0.75f;

    static {
        zbbe zbbeVar = new zbbe();
        zbb = zbbeVar;
        zbuf.zbD(zbbe.class, zbbeVar);
    }

    private zbbe() {
    }

    public static zbbb zba() {
        return (zbbb) zbb.zbq();
    }

    public static /* synthetic */ void zbd(zbbe zbbeVar, String str) {
        zbbeVar.zbd |= 1;
        zbbeVar.zbe = str;
    }

    public static /* synthetic */ void zbe(zbbe zbbeVar, String str) {
        zbbeVar.zbd |= 2;
        zbbeVar.zbf = str;
    }

    public static /* synthetic */ void zbf(zbbe zbbeVar, boolean z) {
        zbbeVar.zbd |= 4;
        zbbeVar.zbg = true;
    }

    public static /* synthetic */ void zbg(zbbe zbbeVar, zbpg zbpgVar) {
        zbpgVar.getClass();
        zbbeVar.zbh = zbpgVar;
        zbbeVar.zbd |= 8;
    }

    public static /* synthetic */ void zbh(zbbe zbbeVar, boolean z) {
        zbbeVar.zbd |= 16;
        zbbeVar.zbi = true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0019\u0000\u0001\u0001\u001b\u0019\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ခ\t\u0004ဇ\u0007\u0005ခ\n\u0006ဇ\b\bင\u0016\tင\u0006\nဇ\u000b\u000bဇ\f\fဇ\r\rဇ\u000e\u000eဇ\u000f\u000fင\u0010\u0010ဇ\u0011\u0011ခ\u0012\u0012ဇ\u0013\u0013ဉ\u0014\u0014ဇ\u0002\u0015ဉ\u0018\u0016ဇ\u0017\u0017ဉ\u0003\u0018ဇ\u0004\u0019ဇ\u0015\u001bင\u0005", new Object[]{"zbd", "zbe", "zbf", "zbn", "zbl", "zbo", "zbm", "zbA", "zbk", "zbp", "zbq", "zbr", "zbs", "zbt", "zbu", "zbv", "zbw", "zbx", "zby", "zbg", "zbC", "zbB", "zbh", "zbi", "zbz", "zbj"});
        }
        if (i2 == 3) {
            return new zbbe();
        }
        if (i2 == 4) {
            return new zbbb(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
