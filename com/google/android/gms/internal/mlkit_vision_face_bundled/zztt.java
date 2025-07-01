package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public class zztt extends zzts {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztt(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zztu) || zzd() != ((zztu) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zztt) {
            zztt zzttVar = (zztt) obj;
            int zzi = zzi();
            int zzi2 = zzttVar.zzi();
            if (zzi != 0 && zzi2 != 0 && zzi != zzi2) {
                return false;
            }
            int zzd = zzd();
            if (zzd > zzttVar.zzd()) {
                throw new IllegalArgumentException("Length too large: " + zzd + zzd());
            }
            if (zzd <= zzttVar.zzd()) {
                if (zzttVar instanceof zztt) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzttVar.zza;
                    zzttVar.zzc();
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
                return zzttVar.zzf(0, zzd).equals(zzf(0, zzd));
            }
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzttVar.zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    protected final int zze(int i, int i2, int i3) {
        return zzvc.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    public final zztu zzf(int i, int i2) {
        int zzh = zzh(0, i2, zzd());
        return zzh == 0 ? zztu.zzb : new zztp(this.zza, 0, zzh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    public final void zzg(zztm zztmVar) throws IOException {
        ((zztz) zztmVar).zzc(this.zza, 0, zzd());
    }
}
