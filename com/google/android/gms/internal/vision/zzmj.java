package com.google.android.gms.internal.vision;

import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzmj extends zzme {
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ba, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x005f, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.vision.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zza(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j = i2;
        int i5 = (int) (i3 - j);
        if (i5 >= 16) {
            long j2 = j;
            i4 = 0;
            while (true) {
                if (i4 >= i5) {
                    i4 = i5;
                    break;
                }
                long j3 = j2 + 1;
                if (zzma.zza(bArr, j2) < 0) {
                    break;
                }
                i4++;
                j2 = j3;
            }
        } else {
            i4 = 0;
        }
        int i6 = i5 - i4;
        long j4 = j + i4;
        while (true) {
            byte b = 0;
            while (true) {
                if (i6 <= 0) {
                    break;
                }
                long j5 = j4 + 1;
                b = zzma.zza(bArr, j4);
                if (b < 0) {
                    j4 = j5;
                    break;
                }
                i6--;
                j4 = j5;
            }
            if (i6 != 0) {
                int i7 = i6 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i7 < 3) {
                            return zza(bArr, b, j4, i7);
                        }
                        i6 -= 4;
                        long j6 = j4 + 1;
                        byte zza = zzma.zza(bArr, j4);
                        if (zza > -65 || (((b << Ascii.FS) + (zza + 112)) >> 30) != 0) {
                            break;
                        }
                        long j7 = j4 + 2;
                        if (zzma.zza(bArr, j6) > -65) {
                            break;
                        }
                        j4 += 3;
                        if (zzma.zza(bArr, j7) > -65) {
                            break;
                        }
                    } else {
                        if (i7 < 2) {
                            return zza(bArr, b, j4, i7);
                        }
                        i6 -= 3;
                        long j8 = j4 + 1;
                        byte zza2 = zzma.zza(bArr, j4);
                        if (zza2 > -65 || ((b == -32 && zza2 < -96) || (b == -19 && zza2 >= -96))) {
                            break;
                        }
                        j4 += 2;
                        if (zzma.zza(bArr, j8) > -65) {
                            break;
                        }
                    }
                } else if (i7 != 0) {
                    i6 -= 2;
                    if (b < -62) {
                        break;
                    }
                    long j9 = j4 + 1;
                    if (zzma.zza(bArr, j4) > -65) {
                        break;
                    }
                    j4 = j9;
                } else {
                    return b;
                }
            } else {
                return 0;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzme
    public final String zzb(byte[] bArr, int i, int i2) throws zzjk {
        boolean zzd;
        boolean zzd2;
        boolean zze;
        boolean zzf;
        boolean zzd3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte zza = zzma.zza(bArr, i);
            zzd3 = zzmf.zzd(zza);
            if (!zzd3) {
                break;
            }
            i++;
            zzmf.zzb(zza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte zza2 = zzma.zza(bArr, i);
            zzd = zzmf.zzd(zza2);
            if (zzd) {
                int i7 = i5 + 1;
                zzmf.zzb(zza2, cArr, i5);
                while (i6 < i3) {
                    byte zza3 = zzma.zza(bArr, i6);
                    zzd2 = zzmf.zzd(zza3);
                    if (!zzd2) {
                        break;
                    }
                    i6++;
                    zzmf.zzb(zza3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else {
                zze = zzmf.zze(zza2);
                if (!zze) {
                    zzf = zzmf.zzf(zza2);
                    if (zzf) {
                        if (i6 < i3 - 1) {
                            int i8 = i + 2;
                            i += 3;
                            zzmf.zzb(zza2, zzma.zza(bArr, i6), zzma.zza(bArr, i8), cArr, i5);
                            i5++;
                        } else {
                            throw zzjk.zzh();
                        }
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzjk.zzh();
                        }
                        byte zza4 = zzma.zza(bArr, i6);
                        int i9 = i + 3;
                        byte zza5 = zzma.zza(bArr, i + 2);
                        i += 4;
                        zzmf.zzb(zza2, zza4, zza5, zzma.zza(bArr, i9), cArr, i5);
                        i5 += 2;
                    }
                } else {
                    if (i6 >= i3) {
                        throw zzjk.zzh();
                    }
                    i += 2;
                    zzmf.zzb(zza2, zzma.zza(bArr, i6), cArr, i5);
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzme
    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        String str;
        String str2;
        int i3;
        long j2;
        long j3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzma.zza(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 >= 128 || j4 >= j5) {
                if (charAt3 >= 2048 || j4 > j5 - 2) {
                    str = str3;
                    str2 = str4;
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt4 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    j2 = 1;
                                    zzma.zza(bArr, j4, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                    j3 = j5;
                                    zzma.zza(bArr, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j6 = j4 + 3;
                                    zzma.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 += 4;
                                    zzma.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzmg(i4 - 1, length);
                        }
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                            throw new zzmg(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append(str2);
                        sb2.append(charAt3);
                        sb2.append(str);
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    zzma.zza(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                    long j7 = j4 + 2;
                    zzma.zza(bArr, j4 + 1, (byte) (((charAt3 >>> 6) & 63) | 128));
                    j4 += 3;
                    zzma.zza(bArr, j7, (byte) ((charAt3 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j8 = j4 + j;
                    zzma.zza(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    j4 += 2;
                    zzma.zza(bArr, j8, (byte) ((charAt3 & '?') | 128));
                }
                j3 = j5;
                j2 = 1;
            } else {
                zzma.zza(bArr, j4, (byte) charAt3);
                j3 = j5;
                str2 = str4;
                j2 = j;
                j4 += j;
                str = str3;
            }
            i4++;
            str3 = str;
            str4 = str2;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzb;
        int zzb2;
        int zzb3;
        if (i2 == 0) {
            zzb = zzmd.zzb(i);
            return zzb;
        }
        if (i2 == 1) {
            zzb2 = zzmd.zzb(i, zzma.zza(bArr, j));
            return zzb2;
        }
        if (i2 == 2) {
            zzb3 = zzmd.zzb(i, zzma.zza(bArr, j), zzma.zza(bArr, j + 1));
            return zzb3;
        }
        throw new AssertionError();
    }
}
