package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbagc extends zbuf implements zbvn {
    private static final zbagc zbb;
    private int zbd;
    private double zbe;
    private double zbf;
    private double zbh;
    private boolean zbi;
    private double zbj;
    private double zbk;
    private byte zbl = 2;
    private String zbg = "";

    static {
        zbagc zbagcVar = new zbagc();
        zbb = zbagcVar;
        zbuf.zbD(zbagc.class, zbagcVar);
    }

    private zbagc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbl);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001\u0004က\u0005\u0005က\u0006\u0006ဇ\u0004\u0007က\u0003\bဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbj", "zbk", "zbi", "zbh", "zbg"});
        }
        if (i2 == 3) {
            return new zbagc();
        }
        zbaga zbagaVar = null;
        if (i2 == 4) {
            return new zbagb(zbagaVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
