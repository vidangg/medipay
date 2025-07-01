package com.google.android.libraries.vision.visionkit.pipeline;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbbd {
    private byte[] zba;
    private long zbb;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcr zbc;
    private int zbd;
    private int zbe;

    public final zbbd zba(byte[] bArr) {
        this.zba = bArr;
        return this;
    }

    public final zbbd zbb(com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcr zbcrVar) {
        this.zbc = zbcrVar;
        return this;
    }

    public final zbbd zbc(long j) {
        this.zbb = j;
        return this;
    }

    public final zbbe zbd() {
        return new zbbe(this.zba, this.zbb, this.zbc, this.zbd, this.zbe);
    }

    public final zbbd zbe(int i) {
        this.zbd = 2;
        return this;
    }

    public final zbbd zbf(int i) {
        this.zbe = i;
        return this;
    }
}
