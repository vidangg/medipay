package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbt extends zbuf implements zbvn {
    private static final zbbt zbb;
    private int zbd;
    private int zbe = -1;
    private float zbf = 0.3f;
    private int zbg = 5;
    private float zbh = 0.5f;
    private int zbi = 1;
    private boolean zbj = true;
    private float zbk = 0.85f;
    private boolean zbl = true;
    private float zbm;

    static {
        zbbt zbbtVar = new zbbt();
        zbb = zbbtVar;
        zbuf.zbD(zbbt.class, zbbtVar);
    }

    private zbbt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\t\u0000\u0001\u0001\u0011\t\u0000\u0000\u0000\u0001င\u0000\u0005ခ\u0001\u0006င\u0002\u0007ခ\u0003\f᠌\u0004\u000eဇ\u0005\u000fခ\u0006\u0010ဇ\u0007\u0011ခ\b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", zbbs.zba, "zbj", "zbk", "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new zbbt();
        }
        if (i2 == 4) {
            return new zbbr(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
