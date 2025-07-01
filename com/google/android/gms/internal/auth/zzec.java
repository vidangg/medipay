package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public class zzec extends zzeb {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzec(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzef) || zzd() != ((zzef) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzec) {
            zzec zzecVar = (zzec) obj;
            int zzj = zzj();
            int zzj2 = zzecVar.zzj();
            if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
                return false;
            }
            int zzd = zzd();
            if (zzd > zzecVar.zzd()) {
                throw new IllegalArgumentException("Length too large: " + zzd + zzd());
            }
            if (zzd <= zzecVar.zzd()) {
                if (zzecVar instanceof zzec) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzecVar.zza;
                    zzecVar.zzc();
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
                return zzecVar.zzf(0, zzd).equals(zzf(0, zzd));
            }
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzecVar.zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzef
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    protected final int zze(int i, int i2, int i3) {
        return zzfa.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final zzef zzf(int i, int i2) {
        int zzi = zzi(0, i2, zzd());
        return zzi == 0 ? zzef.zzb : new zzdz(this.zza, 0, zzi);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean zzh() {
        return zzhn.zzc(this.zza, 0, zzd());
    }
}
