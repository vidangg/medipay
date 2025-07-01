package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public final class zztk {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zztj zztjVar) throws zzve {
        int zzj = zzj(bArr, i, zztjVar);
        int i2 = zztjVar.zza;
        if (i2 >= 0) {
            if (i2 > bArr.length - zzj) {
                throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i2 == 0) {
                zztjVar.zzc = zztu.zzb;
                return zzj;
            }
            zztjVar.zzc = zztu.zzj(bArr, zzj, i2);
            return zzj + i2;
        }
        throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000f. Please report as an issue. */
    public static int zzb(int i, byte[] bArr, int i2, int i3, zzus zzusVar, zzuu zzuuVar, zzwv zzwvVar, zztj zztjVar) throws IOException {
        int i4;
        zzum zzumVar = zzusVar.zzb;
        zzxg zzxgVar = zzuuVar.zzd.zzb;
        Object obj = null;
        if (zzxgVar == zzxg.ENUM) {
            zzj(bArr, i2, zztjVar);
            throw null;
        }
        switch (zzxgVar) {
            case DOUBLE:
                i4 = i2 + 8;
                obj = Double.valueOf(Double.longBitsToDouble(zzq(bArr, i2)));
                i2 = i4;
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case FLOAT:
                i4 = i2 + 4;
                obj = Float.valueOf(Float.intBitsToFloat(zzc(bArr, i2)));
                i2 = i4;
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case INT64:
            case UINT64:
                i2 = zzm(bArr, i2, zztjVar);
                obj = Long.valueOf(zztjVar.zzb);
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case INT32:
            case UINT32:
                i2 = zzj(bArr, i2, zztjVar);
                obj = Integer.valueOf(zztjVar.zza);
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case FIXED64:
            case SFIXED64:
                i4 = i2 + 8;
                obj = Long.valueOf(zzq(bArr, i2));
                i2 = i4;
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case FIXED32:
            case SFIXED32:
                i4 = i2 + 4;
                obj = Integer.valueOf(zzc(bArr, i2));
                i2 = i4;
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case BOOL:
                i2 = zzm(bArr, i2, zztjVar);
                obj = Boolean.valueOf(zztjVar.zzb != 0);
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case STRING:
                i2 = zzh(bArr, i2, zztjVar);
                obj = zztjVar.zzc;
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case GROUP:
                int zzd = zzd(zzwe.zza().zzb(zzuuVar.zzc.getClass()), bArr, i2, i3, ((i >>> 3) << 3) | 4, zztjVar);
                zzumVar.zzg(zzuuVar.zzd, zztjVar.zzc);
                return zzd;
            case MESSAGE:
                int zze = zze(zzwe.zza().zzb(zzuuVar.zzc.getClass()), bArr, i2, i3, zztjVar);
                zzumVar.zzg(zzuuVar.zzd, zztjVar.zzc);
                return zze;
            case BYTES:
                i2 = zza(bArr, i2, zztjVar);
                obj = zztjVar.zzc;
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case ENUM:
                throw new IllegalStateException("Shouldn't reach here.");
            case SINT32:
                i2 = zzj(bArr, i2, zztjVar);
                obj = Integer.valueOf(zzty.zzb(zztjVar.zza));
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            case SINT64:
                i2 = zzm(bArr, i2, zztjVar);
                obj = Long.valueOf(zzty.zzc(zztjVar.zzb));
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
            default:
                zzumVar.zzg(zzuuVar.zzd, obj);
                return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzwh zzwhVar, byte[] bArr, int i, int i2, int i3, zztj zztjVar) throws IOException {
        Object zze = zzwhVar.zze();
        int zzn = zzn(zze, zzwhVar, bArr, i, i2, i3, zztjVar);
        zzwhVar.zzf(zze);
        zztjVar.zzc = zze;
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzwh zzwhVar, byte[] bArr, int i, int i2, zztj zztjVar) throws IOException {
        Object zze = zzwhVar.zze();
        int zzo = zzo(zze, zzwhVar, bArr, i, i2, zztjVar);
        zzwhVar.zzf(zze);
        zztjVar.zzc = zze;
        return zzo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(zzwh zzwhVar, int i, byte[] bArr, int i2, int i3, zzvb zzvbVar, zztj zztjVar) throws IOException {
        int zze = zze(zzwhVar, bArr, i2, i3, zztjVar);
        zzvbVar.add(zztjVar.zzc);
        while (zze < i3) {
            int zzj = zzj(bArr, zze, zztjVar);
            if (i != zztjVar.zza) {
                break;
            }
            zze = zze(zzwhVar, bArr, zzj, i3, zztjVar);
            zzvbVar.add(zztjVar.zzc);
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzvb zzvbVar, zztj zztjVar) throws IOException {
        zzux zzuxVar = (zzux) zzvbVar;
        int zzj = zzj(bArr, i, zztjVar);
        int i2 = zztjVar.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zztjVar);
            zzuxVar.zzf(zztjVar.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zztj zztjVar) throws zzve {
        int zzj = zzj(bArr, i, zztjVar);
        int i2 = zztjVar.zza;
        if (i2 < 0) {
            throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zztjVar.zzc = "";
            return zzj;
        }
        zztjVar.zzc = new String(bArr, zzj, i2, zzvc.zza);
        return zzj + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, byte[] bArr, int i2, int i3, zzww zzwwVar, zztj zztjVar) throws zzve {
        if ((i >>> 3) == 0) {
            throw new zzve("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzm = zzm(bArr, i2, zztjVar);
            zzwwVar.zzj(i, Long.valueOf(zztjVar.zzb));
            return zzm;
        }
        if (i4 == 1) {
            zzwwVar.zzj(i, Long.valueOf(zzq(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzj = zzj(bArr, i2, zztjVar);
            int i5 = zztjVar.zza;
            if (i5 >= 0) {
                if (i5 > bArr.length - zzj) {
                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i5 == 0) {
                    zzwwVar.zzj(i, zztu.zzb);
                } else {
                    zzwwVar.zzj(i, zztu.zzj(bArr, zzj, i5));
                }
                return zzj + i5;
            }
            throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzve("Protocol message contained an invalid tag (zero).");
            }
            zzwwVar.zzj(i, Integer.valueOf(zzc(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzww zzf = zzww.zzf();
        int i7 = zztjVar.zze + 1;
        zztjVar.zze = i7;
        zzr(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzj2 = zzj(bArr, i2, zztjVar);
            i8 = zztjVar.zza;
            if (i8 == i6) {
                i2 = zzj2;
                break;
            }
            i2 = zzi(i8, bArr, zzj2, i3, zzf, zztjVar);
        }
        zztjVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzve("Failed to parse the message.");
        }
        zzwwVar.zzj(i, zzf);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i, zztj zztjVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zztjVar);
        }
        zztjVar.zza = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, zztj zztjVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b >= 0) {
            zztjVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zztjVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zztjVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zztjVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zztjVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i, byte[] bArr, int i2, int i3, zzvb zzvbVar, zztj zztjVar) {
        zzux zzuxVar = (zzux) zzvbVar;
        int zzj = zzj(bArr, i2, zztjVar);
        zzuxVar.zzf(zztjVar.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zztjVar);
            if (i != zztjVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zztjVar);
            zzuxVar.zzf(zztjVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i, zztj zztjVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zztjVar.zzb = j;
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
        zztjVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(Object obj, zzwh zzwhVar, byte[] bArr, int i, int i2, int i3, zztj zztjVar) throws IOException {
        zzvz zzvzVar = (zzvz) zzwhVar;
        int i4 = zztjVar.zze + 1;
        zztjVar.zze = i4;
        zzr(i4);
        int zzc = zzvzVar.zzc(obj, bArr, i, i2, i3, zztjVar);
        zztjVar.zze--;
        zztjVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(Object obj, zzwh zzwhVar, byte[] bArr, int i, int i2, zztj zztjVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzk(i4, bArr, i3, zztjVar);
            i4 = zztjVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zztjVar.zze + 1;
        zztjVar.zze = i6;
        zzr(i6);
        int i7 = i4 + i5;
        zzwhVar.zzh(obj, bArr, i5, i7, zztjVar);
        zztjVar.zze--;
        zztjVar.zzc = obj;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i, byte[] bArr, int i2, int i3, zztj zztjVar) throws zzve {
        if ((i >>> 3) == 0) {
            throw new zzve("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zztjVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zztjVar) + zztjVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zzve("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zztjVar);
            i6 = zztjVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zztjVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zzve("Failed to parse the message.");
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzq(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zzr(int i) throws zzve {
        if (i >= zzb) {
            throw new zzve("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
