package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;
import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zber extends zbuf implements zbvn {
    private static final zber zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";
    private zbun zbg = zby();

    static {
        zber zberVar = new zber();
        zbb = zberVar;
        zbuf.zbD(zber.class, zberVar);
    }

    private zber() {
    }

    public static zber zbd(byte[] bArr, zbtp zbtpVar) throws zbuq {
        return (zber) zbuf.zbu(zbb, bArr, zbtpVar);
    }

    public final int zba() {
        return this.zbe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", zbad.class});
        }
        if (i2 == 3) {
            return new zber();
        }
        zbep zbepVar = null;
        if (i2 == 4) {
            return new zbeq(zbepVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }

    public final String zbe() {
        return this.zbf;
    }

    public final List zbf() {
        return this.zbg;
    }
}
