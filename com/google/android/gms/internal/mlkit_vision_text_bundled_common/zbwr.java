package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zbwr {
    final Unsafe zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbwr(Unsafe unsafe) {
        this.zba = unsafe;
    }

    public abstract double zba(Object obj, long j);

    public abstract float zbb(Object obj, long j);

    public abstract void zbc(Object obj, long j, boolean z);

    public abstract void zbd(Object obj, long j, byte b);

    public abstract void zbe(Object obj, long j, double d);

    public abstract void zbf(Object obj, long j, float f);

    public abstract boolean zbg(Object obj, long j);
}
