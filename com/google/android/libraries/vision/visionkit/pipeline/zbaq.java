package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaq extends zbuf implements zbvn {
    private static final zbaq zbb;
    private int zbd;
    private String zbe = "";
    private zbun zbf = zbuf.zby();
    private zbun zbg = zby();
    private long zbh;

    static {
        zbaq zbaqVar = new zbaq();
        zbb = zbaqVar;
        zbuf.zbD(zbaq.class, zbaqVar);
    }

    private zbaq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001a\u0003\u001b\u0004ဂ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg", zbas.class, "zbh"});
        }
        if (i2 == 3) {
            return new zbaq();
        }
        if (i2 == 4) {
            return new zbap(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
