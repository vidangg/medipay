package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbec extends zbuf implements zbvn {
    private static final zbec zbb;
    private int zbd;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbe zbe;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbk zbf;
    private zbdz zbg;
    private boolean zbh;
    private byte zbi = 2;

    static {
        zbec zbecVar = new zbec();
        zbb = zbecVar;
        zbuf.zbD(zbec.class, zbecVar);
    }

    private zbec() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဇ\u0003\u0003ᐉ\u0002\u0004ဉ\u0001", new Object[]{"zbd", "zbe", "zbh", "zbg", "zbf"});
        }
        if (i2 == 3) {
            return new zbec();
        }
        if (i2 == 4) {
            return new zbeb(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
