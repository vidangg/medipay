package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbad extends zbuf<zbad, zbac> implements zbvn {
    private static final zbad zbb;
    private int zbd;
    private zbun zbe = zby();
    private String zbf = "";

    static {
        zbad zbadVar = new zbad();
        zbb = zbadVar;
        zbuf.zbD(zbad.class, zbadVar);
    }

    private zbad() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zbd", "zbe", zbaj.class, "zbf"});
        }
        if (i2 == 3) {
            return new zbad();
        }
        zbab zbabVar = null;
        if (i2 == 4) {
            return new zbac(zbabVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
