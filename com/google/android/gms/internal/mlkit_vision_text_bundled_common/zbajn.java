package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbajn extends zbuf implements zbvn {
    private static final zbajn zbb;
    private String zbd = "";
    private zbun zbe = zby();
    private String zbf = "";

    static {
        zbajn zbajnVar = new zbajn();
        zbb = zbajnVar;
        zbuf.zbD(zbajn.class, zbajnVar);
    }

    private zbajn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003Ȉ", new Object[]{"zbd", "zbe", zbajk.class, "zbf"});
        }
        if (i2 == 3) {
            return new zbajn();
        }
        if (i2 == 4) {
            return new zbajm(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
