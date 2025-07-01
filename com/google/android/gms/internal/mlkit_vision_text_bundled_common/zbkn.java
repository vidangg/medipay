package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zbkn extends zbjz {
    final CharSequence zbb;
    int zbc = 0;
    int zbd = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: protected */
    public zbkn(zbko zbkoVar, CharSequence charSequence) {
        this.zbb = charSequence;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbjz
    @CheckForNull
    protected final /* bridge */ /* synthetic */ Object zba() {
        int zbc;
        int i = this.zbc;
        while (true) {
            int i2 = this.zbc;
            if (i2 == -1) {
                zbb();
                return null;
            }
            int zbd = zbd(i2);
            if (zbd == -1) {
                zbd = this.zbb.length();
                this.zbc = -1;
                zbc = -1;
            } else {
                zbc = zbc(zbd);
                this.zbc = zbc;
            }
            if (zbc == i) {
                int i3 = zbc + 1;
                this.zbc = i3;
                if (i3 > this.zbb.length()) {
                    this.zbc = -1;
                }
            } else {
                if (i < zbd) {
                    this.zbb.charAt(i);
                }
                if (i < zbd) {
                    this.zbb.charAt(zbd - 1);
                }
                int i4 = this.zbd;
                if (i4 == 1) {
                    zbd = this.zbb.length();
                    this.zbc = -1;
                    if (zbd > i) {
                        this.zbb.charAt(zbd - 1);
                    }
                } else {
                    this.zbd = i4 - 1;
                }
                return this.zbb.subSequence(i, zbd).toString();
            }
        }
    }

    abstract int zbc(int i);

    abstract int zbd(int i);
}
