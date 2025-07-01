package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzkt {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzks zzksVar) throws zzmm {
        int zzh = zzh(bArr, i, zzksVar);
        int i2 = zzksVar.zza;
        if (i2 < 0) {
            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - zzh) {
            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzksVar.zzc = zzld.zzb;
            return zzh;
        }
        zzksVar.zzc = zzld.zzj(bArr, zzh, i2);
        return zzh + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzns zznsVar, byte[] bArr, int i, int i2, int i3, zzks zzksVar) throws IOException {
        Object zze = zznsVar.zze();
        int zzl = zzl(zze, zznsVar, bArr, i, i2, i3, zzksVar);
        zznsVar.zzf(zze);
        zzksVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzns zznsVar, byte[] bArr, int i, int i2, zzks zzksVar) throws IOException {
        Object zze = zznsVar.zze();
        int zzm = zzm(zze, zznsVar, bArr, i, i2, zzksVar);
        zznsVar.zzf(zze);
        zzksVar.zzc = zze;
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzns zznsVar, int i, byte[] bArr, int i2, int i3, zzmj zzmjVar, zzks zzksVar) throws IOException {
        int zzd = zzd(zznsVar, bArr, i2, i3, zzksVar);
        zzmjVar.add(zzksVar.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzksVar);
            if (i != zzksVar.zza) {
                break;
            }
            zzd = zzd(zznsVar, bArr, zzh, i3, zzksVar);
            zzmjVar.add(zzksVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzmj zzmjVar, zzks zzksVar) throws IOException {
        zzme zzmeVar = (zzme) zzmjVar;
        int zzh = zzh(bArr, i, zzksVar);
        int i2 = zzksVar.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzksVar);
            zzmeVar.zzh(zzksVar.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, byte[] bArr, int i2, int i3, zzof zzofVar, zzks zzksVar) throws zzmm {
        if ((i >>> 3) == 0) {
            throw new zzmm("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzk = zzk(bArr, i2, zzksVar);
            zzofVar.zzj(i, Long.valueOf(zzksVar.zzb));
            return zzk;
        }
        if (i4 == 1) {
            zzofVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzh = zzh(bArr, i2, zzksVar);
            int i5 = zzksVar.zza;
            if (i5 < 0) {
                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - zzh) {
                throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzofVar.zzj(i, zzld.zzb);
            } else {
                zzofVar.zzj(i, zzld.zzj(bArr, zzh, i5));
            }
            return zzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzmm("Protocol message contained an invalid tag (zero).");
            }
            zzofVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzof zzf = zzof.zzf();
        int i7 = zzksVar.zze + 1;
        zzksVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzh2 = zzh(bArr, i2, zzksVar);
            i8 = zzksVar.zza;
            if (i8 == i6) {
                i2 = zzh2;
                break;
            }
            i2 = zzg(i8, bArr, zzh2, i3, zzf, zzksVar);
        }
        zzksVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzmm("Failed to parse the message.");
        }
        zzofVar.zzj(i, zzf);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzks zzksVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzksVar);
        }
        zzksVar.zza = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, byte[] bArr, int i2, zzks zzksVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b >= 0) {
            zzksVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzksVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzksVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzksVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzksVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, byte[] bArr, int i2, int i3, zzmj zzmjVar, zzks zzksVar) {
        zzme zzmeVar = (zzme) zzmjVar;
        int zzh = zzh(bArr, i2, zzksVar);
        zzmeVar.zzh(zzksVar.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzksVar);
            if (i != zzksVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzksVar);
            zzmeVar.zzh(zzksVar.zza);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(byte[] bArr, int i, zzks zzksVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzksVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzksVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(Object obj, zzns zznsVar, byte[] bArr, int i, int i2, int i3, zzks zzksVar) throws IOException {
        zznk zznkVar = (zznk) zznsVar;
        int i4 = zzksVar.zze + 1;
        zzksVar.zze = i4;
        zzo(i4);
        int zzc = zznkVar.zzc(obj, bArr, i, i2, i3, zzksVar);
        zzksVar.zze--;
        zzksVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzns zznsVar, byte[] bArr, int i, int i2, zzks zzksVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzi(i4, bArr, i3, zzksVar);
            i4 = zzksVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzksVar.zze + 1;
        zzksVar.zze = i6;
        zzo(i6);
        int i7 = i4 + i5;
        zznsVar.zzh(obj, bArr, i5, i7, zzksVar);
        zzksVar.zze--;
        zzksVar.zzc = obj;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zzo(int i) throws zzmm {
        if (i >= zzb) {
            throw new zzmm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
