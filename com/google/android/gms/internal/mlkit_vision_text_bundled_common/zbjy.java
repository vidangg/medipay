package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbjy extends zbki {
    static final zbjy zba = new zbjy();

    private zbjy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final Object zba() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final Object zbb(Object obj) {
        return "";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final boolean zbc() {
        return false;
    }
}
