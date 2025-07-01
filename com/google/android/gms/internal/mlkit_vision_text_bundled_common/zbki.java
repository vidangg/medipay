package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zbki<T> implements Serializable {
    public static zbki zbd() {
        return zbjy.zba;
    }

    public static zbki zbe(Object obj) {
        obj.getClass();
        return new zbkk(obj);
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract Object zba();

    public abstract Object zbb(Object obj);

    public abstract boolean zbc();
}
