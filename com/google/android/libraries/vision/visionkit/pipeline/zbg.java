package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbg extends zbuf implements zbvn {
    private static final zbg zbb;
    private int zbd;
    private int zbe;
    private zbdd zbf;

    static {
        zbg zbgVar = new zbg();
        zbb = zbgVar;
        zbuf.zbD(zbg.class, zbgVar);
    }

    private zbg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zbd", "zbe", zbk.zba, "zbf"});
        }
        if (i2 == 3) {
            return new zbg();
        }
        zbe zbeVar = null;
        if (i2 == 4) {
            return new zbf(zbeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
