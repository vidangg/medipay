package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbey extends zbuf implements zbvn {
    private static final zbey zbb;
    private int zbd;
    private String zbe = "";
    private zbun zbf = zbuf.zby();
    private boolean zbg;

    static {
        zbey zbeyVar = new zbey();
        zbb = zbeyVar;
        zbuf.zbD(zbey.class, zbeyVar);
    }

    private zbey() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001a\u0003ဇ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new zbey();
        }
        zbev zbevVar = null;
        if (i2 == 4) {
            return new zbex(zbevVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
