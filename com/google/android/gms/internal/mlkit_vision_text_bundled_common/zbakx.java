package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbakx extends zbuf implements zbvn {
    private static final zbakx zbb;
    private Object zbe;
    private int zbd = 0;
    private String zbf = "";
    private String zbg = "";
    private String zbh = "";

    static {
        zbakx zbakxVar = new zbakx();
        zbb = zbakxVar;
        zbuf.zbD(zbakx.class, zbakxVar);
    }

    private zbakx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȼ\u0000\u0003=\u0000\u0004Ȉ\u0005Ȉ", new Object[]{"zbe", "zbd", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbakx();
        }
        zbakv zbakvVar = null;
        if (i2 == 4) {
            return new zbakw(zbakvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
