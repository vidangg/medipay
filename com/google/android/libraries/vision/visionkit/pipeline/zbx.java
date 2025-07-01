package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaiv;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbx extends zbuf implements zbvn {
    private static final zbx zbb;
    private int zbd;
    private zbaiv zbe;
    private String zbf = "";
    private boolean zbg;
    private zbeh zbh;

    static {
        zbx zbxVar = new zbx();
        zbb = zbxVar;
        zbuf.zbD(zbx.class, zbxVar);
    }

    private zbx() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbx();
        }
        if (i2 == 4) {
            return new zbw(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
