package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbto {
    private final Object zba;
    private final int zbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbto(Object obj, int i) {
        this.zba = obj;
        this.zbb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zbto)) {
            return false;
        }
        zbto zbtoVar = (zbto) obj;
        return this.zba == zbtoVar.zba && this.zbb == zbtoVar.zbb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zba) * 65535) + this.zbb;
    }
}
