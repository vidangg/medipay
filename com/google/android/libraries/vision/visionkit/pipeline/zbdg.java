package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbgo;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbjg;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdg extends zbuf implements zbvn {
    private static final zbdg zbb;
    private int zbd;
    private zbgo zbe;
    private zbun zbf = zby();
    private zbun zbg = zby();

    static {
        zbdg zbdgVar = new zbdg();
        zbb = zbdgVar;
        zbuf.zbD(zbdg.class, zbdgVar);
    }

    private zbdg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", zbjg.class, "zbg", com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcw.class});
        }
        if (i2 == 3) {
            return new zbdg();
        }
        zbde zbdeVar = null;
        if (i2 == 4) {
            return new zbdf(zbdeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
