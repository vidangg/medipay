package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public class zzlb extends zzla {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlb(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzld) || zzd() != ((zzld) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzlb) {
            zzlb zzlbVar = (zzlb) obj;
            int zzi = zzi();
            int zzi2 = zzlbVar.zzi();
            if (zzi != 0 && zzi2 != 0 && zzi != zzi2) {
                return false;
            }
            int zzd = zzd();
            if (zzd > zzlbVar.zzd()) {
                throw new IllegalArgumentException("Length too large: " + zzd + zzd());
            }
            if (zzd <= zzlbVar.zzd()) {
                if (zzlbVar instanceof zzlb) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzlbVar.zza;
                    zzlbVar.zzc();
                    int i = 0;
                    int i2 = 0;
                    while (i < zzd) {
                        if (bArr[i] != bArr2[i2]) {
                            return false;
                        }
                        i++;
                        i2++;
                    }
                    return true;
                }
                return zzlbVar.zzf(0, zzd).equals(zzf(0, zzd));
            }
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzlbVar.zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzld
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    protected final int zze(int i, int i2, int i3) {
        return zzmk.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final zzld zzf(int i, int i2) {
        int zzh = zzh(0, i2, zzd());
        return zzh == 0 ? zzld.zzb : new zzky(this.zza, 0, zzh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzld
    public final void zzg(zzkv zzkvVar) throws IOException {
        ((zzlh) zzkvVar).zzc(this.zza, 0, zzd());
    }
}
