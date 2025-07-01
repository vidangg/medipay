package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbadm;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaz extends zbuf implements zbvn {
    private static final zbaz zbb;
    private Object zbe;
    private int zbd = 0;
    private byte zbg = 2;
    private zbun zbf = zby();

    static {
        zbaz zbazVar = new zbaz();
        zbb = zbazVar;
        zbuf.zbD(zbaz.class, zbazVar);
    }

    private zbaz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0001\u0001:\u0000\u0003Л", new Object[]{"zbe", "zbd", "zbf", zbadm.class});
        }
        if (i2 == 3) {
            return new zbaz();
        }
        if (i2 == 4) {
            return new zbay(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
