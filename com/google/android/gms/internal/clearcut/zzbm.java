package com.google.android.gms.internal.clearcut;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzbm extends zzbk {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzfu;
    private int zzfv;
    private int zzfw;
    private int zzfx;

    private zzbm(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzfx = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzfw = i;
        this.zzfu = z;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbk
    public final int zzaf() {
        return this.pos - this.zzfw;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbk
    public final int zzl(int i) throws zzco {
        if (i < 0) {
            throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int zzaf = i + zzaf();
        int i2 = this.zzfx;
        if (zzaf > i2) {
            throw zzco.zzbl();
        }
        this.zzfx = zzaf;
        int i3 = this.limit + this.zzfv;
        this.limit = i3;
        int i4 = i3 - this.zzfw;
        if (i4 > zzaf) {
            int i5 = i4 - zzaf;
            this.zzfv = i5;
            this.limit = i3 - i5;
        } else {
            this.zzfv = 0;
        }
        return i2;
    }
}
