package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbkv extends zbkq {
    private final zbkx zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbkv(zbkx zbkxVar, int i) {
        super(zbkxVar.size(), i);
        this.zba = zbkxVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkq
    protected final Object zba(int i) {
        return this.zba.get(i);
    }
}
