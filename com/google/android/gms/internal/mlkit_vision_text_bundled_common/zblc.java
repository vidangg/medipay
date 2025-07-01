package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zblc {
    public static List zba(List list, zbkf zbkfVar) {
        if (list instanceof RandomAccess) {
            return new zbkz(list, zbkfVar);
        }
        return new zblb(list, zbkfVar);
    }
}
