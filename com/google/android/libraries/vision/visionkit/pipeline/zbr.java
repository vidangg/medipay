package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaiv;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbr extends zbuf implements zbvn {
    private static final zbr zbb;
    private int zbd;
    private zbaiv zbe;
    private String zbf = "";
    private int zbg;
    private boolean zbh;
    private int zbi;

    static {
        zbr zbrVar = new zbr();
        zbb = zbrVar;
        zbuf.zbD(zbr.class, zbrVar);
    }

    private zbr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဇ\u0003\u0005᠌\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", zbq.zba});
        }
        if (i2 == 3) {
            return new zbr();
        }
        if (i2 == 4) {
            return new zbp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
