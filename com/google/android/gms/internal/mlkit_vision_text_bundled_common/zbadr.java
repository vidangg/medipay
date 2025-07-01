package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbadr extends zbuf implements zbvn {
    private static final zbadr zbb;
    private int zbd;
    private zbun zbe = zbuf.zby();
    private String zbf = "";

    static {
        zbadr zbadrVar = new zbadr();
        zbb = zbadrVar;
        zbuf.zbD(zbadr.class, zbadrVar);
    }

    private zbadr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbadr();
        }
        zbadn zbadnVar = null;
        if (i2 == 4) {
            return new zbadq(zbadnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
