package com.google.mlkit.vision.text.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes4.dex */
final class zbb extends zbo {
    private final int zba;
    private final zbki zbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbb(int i, zbki zbkiVar) {
        this.zba = i;
        this.zbb = zbkiVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zbo) {
            zbo zboVar = (zbo) obj;
            if (this.zba == zboVar.zba() && this.zbb.equals(zboVar.zbb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zba ^ 1000003) * 1000003) ^ this.zbb.hashCode();
    }

    public final String toString() {
        return "VkpStatus{exceptionType=" + this.zba + ", remoteException=" + this.zbb.toString() + "}";
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbo
    public final int zba() {
        return this.zba;
    }

    @Override // com.google.mlkit.vision.text.pipeline.zbo
    public final zbki zbb() {
        return this.zbb;
    }
}
