package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbtp {
    static final zbtp zba = new zbtp(true);
    public static final /* synthetic */ int zbb = 0;
    private static volatile boolean zbc = false;
    private static volatile zbtp zbd;
    private final Map zbe;

    zbtp() {
        this.zbe = new HashMap();
    }

    public static zbtp zba() {
        int i = zbvu.zba;
        return zba;
    }

    public static zbtp zbb() {
        zbtp zbtpVar = zbd;
        if (zbtpVar != null) {
            return zbtpVar;
        }
        synchronized (zbtp.class) {
            zbtp zbtpVar2 = zbd;
            if (zbtpVar2 != null) {
                return zbtpVar2;
            }
            int i = zbvu.zba;
            zbtp zbb2 = zbtx.zbb(zbtp.class);
            zbd = zbb2;
            return zbb2;
        }
    }

    public final zbud zbc(zbvm zbvmVar, int i) {
        return (zbud) this.zbe.get(new zbto(zbvmVar, i));
    }

    zbtp(boolean z) {
        this.zbe = Collections.emptyMap();
    }
}
