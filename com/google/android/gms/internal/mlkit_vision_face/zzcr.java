package com.google.android.gms.internal.mlkit_vision_face;

import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* loaded from: classes3.dex */
final class zzcr extends OutputStream {
    private long zza = 0;

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.zza++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.zza += bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza() {
        return this.zza;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i < 0 || i > (length = bArr.length) || i2 < 0 || (i3 = i + i2) > length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.zza += i2;
    }
}
