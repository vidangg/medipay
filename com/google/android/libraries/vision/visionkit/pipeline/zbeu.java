package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbmk;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbeu extends zbuf implements zbvn {
    private static final zbeu zbb;
    private int zbd;
    private String zbe = "";
    private zbun zbf = zbuf.zby();
    private zbun zbg = zbuf.zby();
    private zbun zbh = zbuf.zby();
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbe zbi;
    private zbmk zbj;

    static {
        zbeu zbeuVar = new zbeu();
        zbb = zbeuVar;
        zbuf.zbD(zbeu.class, zbeuVar);
    }

    private zbeu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0003\u0000\u0001ဈ\u0000\u0002\u001a\u0003ဉ\u0001\u0004\u001a\u0005ဉ\u0002\u0006\u001a", new Object[]{"zbd", "zbe", "zbf", "zbi", "zbh", "zbj", "zbg"});
        }
        if (i2 == 3) {
            return new zbeu();
        }
        if (i2 == 4) {
            return new zbet(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
