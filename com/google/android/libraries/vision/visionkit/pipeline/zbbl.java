package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zblm;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnw;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbl extends zbuf implements zbvn {
    private static final zbbl zbb;
    private int zbd;
    private zblm zbe;
    private zbnw zbf;
    private boolean zbg;
    private byte zbi = 2;
    private String zbh = "";

    static {
        zbbl zbblVar = new zbbl();
        zbb = zbblVar;
        zbuf.zbD(zbbl.class, zbblVar);
    }

    private zbbl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new zbbl();
        }
        zbbj zbbjVar = null;
        if (i2 == 4) {
            return new zbbk(zbbjVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
