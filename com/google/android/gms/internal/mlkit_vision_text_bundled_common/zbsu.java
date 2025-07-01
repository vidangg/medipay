package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbsu extends zbsv {
    final /* synthetic */ zbtc zba;
    private int zbb = 0;
    private final int zbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbsu(zbtc zbtcVar) {
        this.zba = zbtcVar;
        this.zbc = zbtcVar.zbd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zbb < this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsx
    public final byte zba() {
        int i = this.zbb;
        if (i >= this.zbc) {
            throw new NoSuchElementException();
        }
        this.zbb = i + 1;
        return this.zba.zbb(i);
    }
}
