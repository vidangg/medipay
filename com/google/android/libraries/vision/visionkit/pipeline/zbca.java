package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbca extends zbuf implements zbvn {
    private static final zbca zbb;
    private int zbd;
    private Object zbf;
    private zbdo zbg;
    private boolean zbh;
    private zbg zbi;
    private zbfc zbj;
    private zbd zbk;
    private int zbl;
    private int zbe = 0;
    private byte zbm = 2;

    static {
        zbca zbcaVar = new zbca();
        zbb = zbcaVar;
        zbuf.zbD(zbca.class, zbcaVar);
    }

    private zbca() {
    }

    public static zbbz zbc() {
        return (zbbz) zbb.zbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zbe(zbca zbcaVar, zbfc zbfcVar) {
        zbfcVar.getClass();
        zbcaVar.zbj = zbfcVar;
        zbcaVar.zbd |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zbf(zbca zbcaVar, zbdo zbdoVar) {
        zbdoVar.getClass();
        zbcaVar.zbg = zbdoVar;
        zbcaVar.zbd |= 1;
    }

    public final int zba() {
        return this.zbl;
    }

    public final boolean zbg() {
        if (this.zbe == 6) {
            return ((Boolean) this.zbf).booleanValue();
        }
        return false;
    }

    public final boolean zbh() {
        if (this.zbe == 5) {
            return ((Boolean) this.zbf).booleanValue();
        }
        return false;
    }

    public final boolean zbi() {
        return (this.zbd & 32) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbm);
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\b\u0001\u0001\u0001\b\b\u0000\u0000\u0001\u0001ᐉ\u0000\u0002ဇ\u0001\u0003ဉ\u0003\u0004ဉ\u0002\u0005:\u0000\u0006:\u0000\u0007ဉ\u0004\bင\u0005", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbj", "zbi", "zbk", "zbl"});
        }
        if (i2 == 3) {
            return new zbca();
        }
        zbby zbbyVar = null;
        if (i2 == 4) {
            return new zbbz(zbbyVar);
        }
        if (i2 == 5) {
            return zbb;
        }
        this.zbm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
