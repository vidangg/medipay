package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbcr {
    private final int zba;
    private final int zbb;

    public zbcr(int i, int i2) {
        zbkj.zbc(i < 32767 && i >= 0);
        zbkj.zbc(i2 < 32767 && i2 >= 0);
        this.zba = i;
        this.zbb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zbcr) {
            zbcr zbcrVar = (zbcr) obj;
            if (this.zba == zbcrVar.zba && this.zbb == zbcrVar.zbb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zba << 16) | this.zbb;
    }

    public final String toString() {
        return this.zba + "x" + this.zbb;
    }

    public final int zba() {
        return this.zbb;
    }

    public final int zbb() {
        return this.zba;
    }
}
