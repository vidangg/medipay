package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzof {
    private static final zzof zza = new zzof(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzof() {
        this(0, new int[8], new Object[8], true);
    }

    private zzof(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzof zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzof zze(zzof zzofVar, zzof zzofVar2) {
        int i = zzofVar.zzb + zzofVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzofVar.zzc, i);
        System.arraycopy(zzofVar2.zzc, 0, copyOf, zzofVar.zzb, zzofVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzofVar.zzd, i);
        System.arraycopy(zzofVar2.zzd, 0, copyOf2, zzofVar.zzb, zzofVar2.zzb);
        return new zzof(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzof zzf() {
        return new zzof(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzof)) {
            return false;
        }
        zzof zzofVar = (zzof) obj;
        int i = this.zzb;
        if (i == zzofVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzofVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzofVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zzz;
        int zzA;
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 == 1) {
                    ((Long) this.zzd[i4]).longValue();
                    i = zzlk.zzz(i6 << 3) + 8;
                } else if (i7 == 2) {
                    int i8 = i6 << 3;
                    zzld zzldVar = (zzld) this.zzd[i4];
                    int zzz2 = zzlk.zzz(i8);
                    int zzd = zzldVar.zzd();
                    i = zzz2 + zzlk.zzz(zzd) + zzd;
                } else if (i7 == 3) {
                    int zzz3 = zzlk.zzz(i6 << 3);
                    zzz = zzz3 + zzz3;
                    zzA = ((zzof) this.zzd[i4]).zza();
                } else if (i7 == 5) {
                    ((Integer) this.zzd[i4]).intValue();
                    i = zzlk.zzz(i6 << 3) + 4;
                } else {
                    throw new IllegalStateException(new zzml("Protocol message tag had invalid wire type."));
                }
                i3 += i;
            } else {
                int i9 = i6 << 3;
                long longValue = ((Long) this.zzd[i4]).longValue();
                zzz = zzlk.zzz(i9);
                zzA = zzlk.zzA(longValue);
            }
            i = zzz + zzA;
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3] >>> 3;
            zzld zzldVar = (zzld) this.zzd[i3];
            int zzz = zzlk.zzz(8);
            int zzz2 = zzlk.zzz(16) + zzlk.zzz(i4);
            int zzz3 = zzlk.zzz(24);
            int zzd = zzldVar.zzd();
            i2 += zzz + zzz + zzz2 + zzz3 + zzlk.zzz(zzd) + zzd;
        }
        this.zze = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzof zzd(zzof zzofVar) {
        if (zzofVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzofVar.zzb;
        zzm(i);
        System.arraycopy(zzofVar.zzc, 0, this.zzc, this.zzb, zzofVar.zzb);
        System.arraycopy(zzofVar.zzd, 0, this.zzd, this.zzb, zzofVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zznj.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(zzor zzorVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzorVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzor zzorVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzorVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzorVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzorVar.zzd(i4, (zzld) obj);
                } else if (i3 == 3) {
                    zzorVar.zzF(i4);
                    ((zzof) obj).zzl(zzorVar);
                    zzorVar.zzh(i4);
                } else if (i3 == 5) {
                    zzorVar.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzml("Protocol message tag had invalid wire type."));
                }
            }
        }
    }
}
