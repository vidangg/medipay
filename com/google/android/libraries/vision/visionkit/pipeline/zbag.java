package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbag extends zbuf implements zbvn {
    private static final zbag zbb;
    private int zbd;
    private long zbe;
    private float zbf = 0.5f;

    static {
        zbag zbagVar = new zbag();
        zbb = zbagVar;
        zbuf.zbD(zbag.class, zbagVar);
    }

    private zbag() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new zbag();
        }
        zbae zbaeVar = null;
        if (i2 == 4) {
            return new zbaf(zbaeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
