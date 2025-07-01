package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzky extends zzlb {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzky(byte[] bArr, int i, int i2) {
        super(bArr);
        zzh(0, i2, bArr.length);
        this.zzc = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzlb, com.google.android.gms.internal.measurement.zzld
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzlb, com.google.android.gms.internal.measurement.zzld
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlb, com.google.android.gms.internal.measurement.zzld
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
