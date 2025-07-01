package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbco extends zbuf implements zbvn {
    private static final zbco zbb;
    private zbun zbd = zby();

    static {
        zbco zbcoVar = new zbco();
        zbb = zbcoVar;
        zbuf.zbD(zbco.class, zbcoVar);
    }

    private zbco() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbcn.class});
        }
        if (i2 == 3) {
            return new zbco();
        }
        if (i2 == 4) {
            return new zbch(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
