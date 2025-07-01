package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbkk extends zbki {
    private final Object zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbkk(Object obj) {
        this.zba = obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zbkk) {
            return this.zba.equals(((zbkk) obj).zba);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final int hashCode() {
        return this.zba.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zba.toString() + ")";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final Object zba() {
        return this.zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final Object zbb(Object obj) {
        return this.zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki
    public final boolean zbc() {
        return true;
    }
}
