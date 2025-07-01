package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.media3.common.C;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbjs extends zbuf implements zbvn {
    private static final zbjs zbb;
    private int zbd;
    private zbaiq zbq;
    private long zbe = C.NANOS_PER_SECOND;
    private float zbf = 0.2f;
    private float zbg = 0.6f;
    private float zbh = 0.6f;
    private float zbi = 0.5f;
    private int zbj = 3;
    private float zbk = -0.5f;
    private float zbl = -0.5f;
    private int zbm = 1000000;
    private float zbn = 10.0f;
    private float zbo = 0.8f;
    private float zbp = 1.5f;
    private float zbr = 0.15f;
    private float zbs = 0.5f;
    private float zbt = 0.3f;
    private float zbu = 3.0f;
    private float zbv = 3.0f;
    private int zbw = 5;
    private int zbx = 5;
    private float zby = 0.5f;

    static {
        zbjs zbjsVar = new zbjs();
        zbb = zbjsVar;
        zbuf.zbD(zbjs.class, zbjsVar);
    }

    private zbjs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006င\u0005\u0007ခ\u0006\bခ\u0007\tင\b\nခ\t\u000bခ\n\fဉ\f\rခ\u000b\u000eခ\r\u000fခ\u000e\u0010ခ\u000f\u0011ခ\u0010\u0012ခ\u0011\u0013င\u0012\u0014င\u0013\u0015ခ\u0014", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn", "zbo", "zbq", "zbp", "zbr", "zbs", "zbt", "zbu", "zbv", "zbw", "zbx", "zby"});
        }
        if (i2 == 3) {
            return new zbjs();
        }
        if (i2 == 4) {
            return new zbjr(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
