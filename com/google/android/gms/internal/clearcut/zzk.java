package com.google.android.gms.internal.clearcut;

import io.flutter.embedding.android.KeyboardMap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public final class zzk {
    private static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static long zza(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long zza(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("Out of bound index with offput: 0 and length: ");
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        char c = 0;
        if (length <= 32) {
            if (length > 16) {
                long j = (length << 1) - 7286425919675154353L;
                long zzb = zzb(bArr, 0) * (-5435081209227447693L);
                long zzb2 = zzb(bArr, 8);
                long zzb3 = zzb(bArr, length - 8) * j;
                return zza(Long.rotateRight(zzb + zzb2, 43) + Long.rotateRight(zzb3, 30) + (zzb(bArr, length - 16) * (-7286425919675154353L)), zzb + Long.rotateRight(zzb2 - 7286425919675154353L, 18) + zzb3, j);
            }
            if (length >= 8) {
                long j2 = (length << 1) - 7286425919675154353L;
                long zzb4 = zzb(bArr, 0) - 7286425919675154353L;
                long zzb5 = zzb(bArr, length - 8);
                return zza((Long.rotateRight(zzb5, 37) * j2) + zzb4, (Long.rotateRight(zzb4, 25) + zzb5) * j2, j2);
            }
            if (length >= 4) {
                return zza(length + ((zza(bArr, 0) & KeyboardMap.kValueMask) << 3), zza(bArr, length - 4) & KeyboardMap.kValueMask, (length << 1) - 7286425919675154353L);
            }
            if (length <= 0) {
                return -7286425919675154353L;
            }
            long j3 = (((bArr[0] & 255) + ((bArr[length >> 1] & 255) << 8)) * (-7286425919675154353L)) ^ ((length + ((bArr[length - 1] & 255) << 2)) * (-4348849565147123417L));
            return (j3 ^ (j3 >>> 47)) * (-7286425919675154353L);
        }
        if (length <= 64) {
            long j4 = (length << 1) - 7286425919675154353L;
            long zzb6 = zzb(bArr, 0) * (-7286425919675154353L);
            long zzb7 = zzb(bArr, 8);
            long zzb8 = zzb(bArr, length - 8) * j4;
            long rotateRight = Long.rotateRight(zzb6 + zzb7, 43) + Long.rotateRight(zzb8, 30) + (zzb(bArr, length - 16) * (-7286425919675154353L));
            long zza = zza(rotateRight, zzb8 + zzb6 + Long.rotateRight(zzb7 - 7286425919675154353L, 18), j4);
            long zzb9 = zzb(bArr, 16) * j4;
            long zzb10 = zzb(bArr, 24);
            long zzb11 = (rotateRight + zzb(bArr, length - 32)) * j4;
            return zza(Long.rotateRight(zzb9 + zzb10, 43) + Long.rotateRight(zzb11, 30) + ((zza + zzb(bArr, length - 24)) * j4), zzb9 + Long.rotateRight(zzb10 + zzb6, 18) + zzb11, j4);
        }
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long zzb12 = zzb(bArr, 0) + 95310865018149119L;
        int i = length - 1;
        int i2 = (i / 64) << 6;
        int i3 = i & 63;
        int i4 = i2 + i3;
        int i5 = i4 - 63;
        long j5 = 2480279821605975764L;
        long j6 = 1390051526045402406L;
        int i6 = 0;
        while (true) {
            int i7 = i2;
            long rotateRight2 = Long.rotateRight(zzb12 + j5 + jArr[c] + zzb(bArr, i6 + 8), 37) * (-5435081209227447693L);
            long rotateRight3 = Long.rotateRight(j5 + jArr[1] + zzb(bArr, i6 + 48), 42) * (-5435081209227447693L);
            long j7 = rotateRight2 ^ jArr2[1];
            long zzb13 = rotateRight3 + jArr[c] + zzb(bArr, i6 + 40);
            long rotateRight4 = Long.rotateRight(j6 + jArr2[c], 33) * (-5435081209227447693L);
            char c2 = c;
            int i8 = i3;
            zza(bArr, i6, jArr[1] * (-5435081209227447693L), j7 + jArr2[c], jArr);
            zza(bArr, i6 + 32, rotateRight4 + jArr2[1], zzb13 + zzb(bArr, i6 + 16), jArr2);
            int i9 = i6 + 64;
            if (i9 == i7) {
                long j8 = (-5435081209227447693L) + ((j7 & 255) << 1);
                long j9 = jArr2[c2] + i8;
                jArr2[c2] = j9;
                long j10 = jArr[c2] + j9;
                jArr[c2] = j10;
                jArr2[c2] = jArr2[c2] + j10;
                long rotateRight5 = Long.rotateRight(rotateRight4 + zzb13 + jArr[c2] + zzb(bArr, i4 - 55), 37) * j8;
                long rotateRight6 = Long.rotateRight(zzb13 + jArr[1] + zzb(bArr, i4 - 15), 42) * j8;
                long j11 = rotateRight5 ^ (jArr2[1] * 9);
                long zzb14 = rotateRight6 + (jArr[c2] * 9) + zzb(bArr, i4 - 23);
                long rotateRight7 = Long.rotateRight(j7 + jArr2[c2], 33) * j8;
                zza(bArr, i5, jArr[1] * j8, j11 + jArr2[c2], jArr);
                zza(bArr, i4 - 31, rotateRight7 + jArr2[1], zzb(bArr, i4 - 47) + zzb14, jArr2);
                return zza(zza(jArr[c2], jArr2[c2], j8) + (((zzb14 >>> 47) ^ zzb14) * (-4348849565147123417L)) + j11, zza(jArr[1], jArr2[1], j8) + rotateRight7, j8);
            }
            i6 = i9;
            i3 = i8;
            i2 = i7;
            c = c2;
            j5 = zzb13;
            zzb12 = rotateRight4;
            j6 = j7;
        }
    }

    private static void zza(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long zzb = zzb(bArr, i);
        long zzb2 = zzb(bArr, i + 8);
        long zzb3 = zzb(bArr, i + 16);
        long zzb4 = zzb(bArr, i + 24);
        long j3 = j + zzb;
        long j4 = zzb2 + j3 + zzb3;
        long rotateRight = Long.rotateRight(j2 + j3 + zzb4, 21) + Long.rotateRight(j4, 44);
        jArr[0] = j4 + zzb4;
        jArr[1] = rotateRight + j3;
    }

    private static long zzb(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }
}
