package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbafq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbhf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbix;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbam extends zbuf implements zbvn {
    private static final zbam zbb;
    private int zbd;
    private Object zbf;
    private boolean zbg;
    private zbix zbh;
    private boolean zbi;
    private zbhf zbj;
    private float zbk;
    private boolean zbl;
    private boolean zbm;
    private boolean zbo;
    private float zbp;
    private int zbq;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbq zbr;
    private int zbe = 0;
    private byte zbs = 2;
    private int zbn = -1;

    static {
        zbam zbamVar = new zbam();
        zbb = zbamVar;
        zbuf.zbD(zbam.class, zbamVar);
    }

    private zbam() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbs);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0004\u000e\u0001\u0001\u0001\u000e\u000e\u0000\u0000\u0001\u0001м\u0000\u0002ဉ\u0001\u0003ဉ\u0003\u0004ဇ\u0006\u0005င\u0007\u0006ဇ\b\u0007ဇ\u0000\bခ\t\tင\n\nဇ\u0002\u000bဉ\u000b\fခ\u0004\rဇ\u0005\u000e<\u0000", new Object[]{"zbf", "zbe", "zbd", zbafq.class, "zbh", "zbj", "zbm", "zbn", "zbo", "zbg", "zbp", "zbq", "zbi", "zbr", "zbk", "zbl", com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcz.class});
        }
        if (i2 == 3) {
            return new zbam();
        }
        if (i2 == 4) {
            return new zbal(null);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
