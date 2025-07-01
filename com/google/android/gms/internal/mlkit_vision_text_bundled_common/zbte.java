package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbte extends zbtg {
    private int zbb;
    private int zbc;
    private int zbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zbte(byte[] bArr, int i, int i2, boolean z, zbtd zbtdVar) {
        super(null);
        this.zbd = Integer.MAX_VALUE;
        this.zbb = 0;
    }

    public final int zba(int i) throws zbuq {
        int i2 = this.zbd;
        this.zbd = 0;
        int i3 = this.zbb + this.zbc;
        this.zbb = i3;
        if (i3 > 0) {
            this.zbc = i3;
            this.zbb = 0;
        } else {
            this.zbc = 0;
        }
        return i2;
    }
}
