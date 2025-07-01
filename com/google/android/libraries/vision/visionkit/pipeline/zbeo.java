package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbeo extends zbuf implements zbvn {
    private static final zbeo zbb;
    private int zbd = 0;
    private Object zbe;

    static {
        zbeo zbeoVar = new zbeo();
        zbb = zbeoVar;
        zbuf.zbD(zbeo.class, zbeoVar);
    }

    private zbeo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zbe", "zbd", zbbc.class, zbbw.class});
        }
        if (i2 == 3) {
            return new zbeo();
        }
        if (i2 == 4) {
            return new zben(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
