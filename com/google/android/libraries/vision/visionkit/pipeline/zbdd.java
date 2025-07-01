package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdd extends zbuf implements zbvn {
    private static final zbdd zbb;
    private int zbd;
    private int zbe = 1;
    private int zbf = 5;

    static {
        zbdd zbddVar = new zbdd();
        zbb = zbddVar;
        zbuf.zbD(zbdd.class, zbddVar);
    }

    private zbdd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", zbdc.zba, "zbf"});
        }
        if (i2 == 3) {
            return new zbdd();
        }
        if (i2 == 4) {
            return new zbdb(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
