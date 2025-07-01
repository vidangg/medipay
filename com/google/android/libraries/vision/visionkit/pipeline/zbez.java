package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbez extends zbuf implements zbvn {
    private static final zbez zbb;
    private zbun zbd = zby();

    static {
        zbez zbezVar = new zbez();
        zbb = zbezVar;
        zbuf.zbD(zbez.class, zbezVar);
    }

    private zbez() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbey.class});
        }
        if (i2 == 3) {
            return new zbez();
        }
        if (i2 == 4) {
            return new zbew(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
