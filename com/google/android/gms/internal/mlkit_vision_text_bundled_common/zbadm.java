package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbadm extends zbub implements zbvn {
    private static final zbadm zbd;
    private int zbe;
    private Object zbg;
    private Object zbi;
    private zbxb zbm;
    private int zbn;
    private int zbo;
    private int zbf = 0;
    private int zbh = 0;
    private byte zbs = 2;
    private String zbj = "FaceAttributesClientBrainEmbedder";
    private String zbk = "";
    private zbtc zbl = zbtc.zbb;
    private boolean zbp = true;
    private int zbq = 1;
    private zbtc zbr = zbtc.zbb;

    static {
        zbadm zbadmVar = new zbadm();
        zbd = zbadmVar;
        zbuf.zbD(zbadm.class, zbadmVar);
    }

    private zbadm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbs);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0004\r\u0002\u0001\u0002\u0010\r\u0000\u0000\u0001\u0002<\u0000\u0003;\u0000\u0004ဇ\u0006\u0005᠌\u0007\u0007м\u0001\b;\u0001\tဈ\u0000\nဈ\u0001\fင\u0004\rဉ\u0003\u000eည\b\u000fည\u0002\u0010င\u0005", new Object[]{"zbg", "zbf", "zbi", "zbh", "zbe", zbabp.class, "zbp", "zbq", zbadk.zba, zbadz.class, "zbj", "zbk", "zbn", "zbm", "zbr", "zbl", "zbo"});
        }
        if (i2 == 3) {
            return new zbadm();
        }
        if (i2 == 4) {
            return new zbadl(null);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
