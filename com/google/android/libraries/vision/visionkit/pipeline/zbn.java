package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbail;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbix;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbn extends zbuf implements zbvn {
    private static final zbn zbb;
    private int zbd;
    private int zbe = 0;
    private Object zbf;
    private zbix zbg;

    static {
        zbn zbnVar = new zbn();
        zbb = zbnVar;
        zbuf.zbD(zbn.class, zbnVar);
    }

    private zbn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zbf", "zbe", "zbd", "zbg", com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbq.class, zbail.class});
        }
        if (i2 == 3) {
            return new zbn();
        }
        if (i2 == 4) {
            return new zbm(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
