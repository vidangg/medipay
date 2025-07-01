package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbagk extends zbuf implements zbvn {
    private static final zbagk zbb;
    private int zbd;
    private long zbe;
    private int zbh;
    private int zbi;
    private zbagc zbl;
    private zbagw zbn;
    private byte zbt = 2;
    private String zbf = "";
    private String zbg = "";
    private zbun zbj = zbuf.zby();
    private String zbk = "";
    private zbtc zbm = zbtc.zbb;
    private String zbo = "";
    private zbun zbp = zby();
    private zbun zbq = zby();
    private zbtc zbr = zbtc.zbb;
    private String zbs = "";

    static {
        zbagk zbagkVar = new zbagk();
        zbb = zbagkVar;
        zbuf.zbD(zbagk.class, zbagkVar);
    }

    private zbagk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbt);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u000f\u0000\u0001\u0001\u001c\u000f\u0000\u0003\u0004\u0001ᔂ\u0000\u0002б\u0010ဈ\u0001\u0011ဈ\u0002\u0012င\u0003\u0013င\u0004\u0014\u001a\u0015ဈ\u0005\u0016ည\u0007\u0017ᐉ\b\u0018ᐉ\u0006\u0019ည\n\u001aဈ\t\u001bဈ\u000b\u001c\u001b", new Object[]{"zbd", "zbe", "zbp", zbagj.class, "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbm", "zbn", "zbl", "zbr", "zbo", "zbs", "zbq", zbagf.class});
        }
        if (i2 == 3) {
            return new zbagk();
        }
        zbagg zbaggVar = null;
        if (i2 == 4) {
            return new zbagh(zbaggVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
