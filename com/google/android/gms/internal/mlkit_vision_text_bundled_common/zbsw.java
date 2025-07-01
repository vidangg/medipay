package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbsw extends zbtb {
    private final int zbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbsw(byte[] bArr, int i, int i2) {
        super(bArr);
        zbh(0, i2, bArr.length);
        this.zbc = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final byte zbb(int i) {
        return this.zba[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb
    protected final int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final int zbd() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtb, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final byte zba(int i) {
        int i2 = this.zbc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zba[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
