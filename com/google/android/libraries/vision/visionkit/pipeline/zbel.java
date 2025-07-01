package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbafq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbja;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbel extends zbuf implements zbvn {
    private static final zbel zbb;
    private int zbd;
    private int zbe;
    private zbafq zbf;
    private zbja zbg;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbdy zbh;
    private zbx zbi;
    private byte zbj = 2;

    static {
        zbel zbelVar = new zbel();
        zbb = zbelVar;
        zbuf.zbD(zbel.class, zbelVar);
    }

    private zbel() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ဉ\u0002\u0002ဉ\u0003\u0003᠌\u0000\u0004ဉ\u0004\u0005ᐉ\u0001", new Object[]{"zbd", "zbg", "zbh", "zbe", zbek.zba, "zbi", "zbf"});
        }
        if (i2 == 3) {
            return new zbel();
        }
        if (i2 == 4) {
            return new zbej(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
