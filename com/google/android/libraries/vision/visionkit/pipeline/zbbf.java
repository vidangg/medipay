package com.google.android.libraries.vision.visionkit.pipeline;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbf {
    private final int zba;
    private final Map zbb = new HashMap();

    public zbbf(int i) {
        this.zba = i;
    }

    public final synchronized void zba(long j) {
        this.zbb.remove(Long.valueOf(j));
    }

    public final synchronized boolean zbb(Object obj, long j) {
        if (this.zbb.size() == this.zba) {
            com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcq.zba.zbc(this, "Buffer is full. Drop frame " + j, new Object[0]);
            return false;
        }
        this.zbb.put(Long.valueOf(j), obj);
        return true;
    }
}
