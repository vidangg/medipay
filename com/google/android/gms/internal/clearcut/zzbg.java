package com.google.android.gms.internal.clearcut;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzbg {
    private final byte[] buffer;
    private final zzbn zzfo;

    private zzbg(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzfo = zzbn.zzc(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbg(int i, zzbc zzbcVar) {
        this(i);
    }

    public final zzbb zzad() {
        if (this.zzfo.zzag() == 0) {
            return new zzbi(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzbn zzae() {
        return this.zzfo;
    }
}
