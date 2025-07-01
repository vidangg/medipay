package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbfc extends zbuf implements zbvn {
    private static final zbfc zbb;
    private int zbd;
    private int zbe = 1;
    private boolean zbf;

    static {
        zbfc zbfcVar = new zbfc();
        zbb = zbfcVar;
        zbuf.zbD(zbfc.class, zbfcVar);
    }

    private zbfc() {
    }

    public static zbfb zba() {
        return (zbfb) zbb.zbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zbd(zbfc zbfcVar, int i) {
        zbfcVar.zbe = 1;
        zbfcVar.zbd = 1 | zbfcVar.zbd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001", new Object[]{"zbd", "zbe", zbk.zba, "zbf"});
        }
        if (i2 == 3) {
            return new zbfc();
        }
        zbfa zbfaVar = null;
        if (i2 == 4) {
            return new zbfb(zbfaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
