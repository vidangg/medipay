package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbsr {
    public static final /* synthetic */ int zba = 0;
    private static volatile int zbb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zba(byte[] bArr, int i, zbsq zbsqVar) throws zbuq {
        int zbk = zbk(bArr, i, zbsqVar);
        int i2 = zbsqVar.zba;
        if (i2 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - zbk) {
            throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zbsqVar.zbc = zbtc.zbb;
            return zbk;
        }
        zbsqVar.zbc = zbtc.zbj(bArr, zbk, i2);
        return zbk + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000f. Please report as an issue. */
    public static int zbb(int i, byte[] bArr, int i2, int i3, zbub zbubVar, zbud zbudVar, zbwl zbwlVar, zbsq zbsqVar) throws IOException {
        int i4;
        zbtu zbtuVar = zbubVar.zbb;
        zbww zbwwVar = zbudVar.zbb.zbb;
        Object obj = null;
        if (zbwwVar == zbww.ENUM) {
            zbk(bArr, i2, zbsqVar);
            throw null;
        }
        switch (zbwwVar) {
            case DOUBLE:
                i4 = i2 + 8;
                obj = Double.valueOf(Double.longBitsToDouble(zbr(bArr, i2)));
                i2 = i4;
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case FLOAT:
                i4 = i2 + 4;
                obj = Float.valueOf(Float.intBitsToFloat(zbc(bArr, i2)));
                i2 = i4;
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case INT64:
            case UINT64:
                i2 = zbn(bArr, i2, zbsqVar);
                obj = Long.valueOf(zbsqVar.zbb);
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case INT32:
            case UINT32:
                i2 = zbk(bArr, i2, zbsqVar);
                obj = Integer.valueOf(zbsqVar.zba);
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case FIXED64:
            case SFIXED64:
                i4 = i2 + 8;
                obj = Long.valueOf(zbr(bArr, i2));
                i2 = i4;
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case FIXED32:
            case SFIXED32:
                i4 = i2 + 4;
                obj = Integer.valueOf(zbc(bArr, i2));
                i2 = i4;
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case BOOL:
                i2 = zbn(bArr, i2, zbsqVar);
                obj = Boolean.valueOf(zbsqVar.zbb != 0);
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case STRING:
                i2 = zbh(bArr, i2, zbsqVar);
                obj = zbsqVar.zbc;
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case GROUP:
                int i5 = ((i >>> 3) << 3) | 4;
                zbvx zbb2 = zbvu.zba().zbb(zbudVar.zba.getClass());
                Object zbf = zbtuVar.zbf(zbudVar.zbb);
                if (zbf == null) {
                    zbf = zbb2.zbe();
                    zbtuVar.zbj(zbudVar.zbb, zbf);
                }
                return zbo(zbf, zbb2, bArr, i2, i3, i5, zbsqVar);
            case MESSAGE:
                zbvx zbb3 = zbvu.zba().zbb(zbudVar.zba.getClass());
                Object zbf2 = zbtuVar.zbf(zbudVar.zbb);
                if (zbf2 == null) {
                    zbf2 = zbb3.zbe();
                    zbtuVar.zbj(zbudVar.zbb, zbf2);
                }
                return zbp(zbf2, zbb3, bArr, i2, i3, zbsqVar);
            case BYTES:
                i2 = zba(bArr, i2, zbsqVar);
                obj = zbsqVar.zbc;
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case ENUM:
                throw new IllegalStateException("Shouldn't reach here.");
            case SINT32:
                i2 = zbk(bArr, i2, zbsqVar);
                obj = Integer.valueOf(zbtg.zbb(zbsqVar.zba));
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            case SINT64:
                i2 = zbn(bArr, i2, zbsqVar);
                obj = Long.valueOf(zbtg.zbc(zbsqVar.zbb));
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
            default:
                zbtuVar.zbj(zbudVar.zbb, obj);
                return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbc(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbd(zbvx zbvxVar, byte[] bArr, int i, int i2, int i3, zbsq zbsqVar) throws IOException {
        Object zbe = zbvxVar.zbe();
        int zbo = zbo(zbe, zbvxVar, bArr, i, i2, i3, zbsqVar);
        zbvxVar.zbf(zbe);
        zbsqVar.zbc = zbe;
        return zbo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbe(zbvx zbvxVar, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        Object zbe = zbvxVar.zbe();
        int zbp = zbp(zbe, zbvxVar, bArr, i, i2, zbsqVar);
        zbvxVar.zbf(zbe);
        zbsqVar.zbc = zbe;
        return zbp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbf(zbvx zbvxVar, int i, byte[] bArr, int i2, int i3, zbun zbunVar, zbsq zbsqVar) throws IOException {
        int zbe = zbe(zbvxVar, bArr, i2, i3, zbsqVar);
        zbunVar.add(zbsqVar.zbc);
        while (zbe < i3) {
            int zbk = zbk(bArr, zbe, zbsqVar);
            if (i != zbsqVar.zba) {
                break;
            }
            zbe = zbe(zbvxVar, bArr, zbk, i3, zbsqVar);
            zbunVar.add(zbsqVar.zbc);
        }
        return zbe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbg(byte[] bArr, int i, zbun zbunVar, zbsq zbsqVar) throws IOException {
        zbug zbugVar = (zbug) zbunVar;
        int zbk = zbk(bArr, i, zbsqVar);
        int i2 = zbsqVar.zba + zbk;
        while (zbk < i2) {
            zbk = zbk(bArr, zbk, zbsqVar);
            zbugVar.zbg(zbsqVar.zba);
        }
        if (zbk == i2) {
            return zbk;
        }
        throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbh(byte[] bArr, int i, zbsq zbsqVar) throws zbuq {
        int zbk = zbk(bArr, i, zbsqVar);
        int i2 = zbsqVar.zba;
        if (i2 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zbsqVar.zbc = "";
            return zbk;
        }
        zbsqVar.zbc = new String(bArr, zbk, i2, zbuo.zba);
        return zbk + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbi(byte[] bArr, int i, zbsq zbsqVar) throws zbuq {
        int i2;
        int zbk = zbk(bArr, i, zbsqVar);
        int i3 = zbsqVar.zba;
        if (i3 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 == 0) {
            zbsqVar.zbc = "";
            return zbk;
        }
        int i4 = zbwv.zba;
        int length = bArr.length;
        if ((((length - zbk) - i3) | zbk | i3) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zbk), Integer.valueOf(i3)));
        }
        int i5 = zbk + i3;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (zbk < i5) {
            byte b = bArr[zbk];
            if (!zbwt.zbd(b)) {
                break;
            }
            zbk++;
            cArr[i6] = (char) b;
            i6++;
        }
        int i7 = i6;
        while (zbk < i5) {
            int i8 = zbk + 1;
            byte b2 = bArr[zbk];
            if (zbwt.zbd(b2)) {
                cArr[i7] = (char) b2;
                i7++;
                zbk = i8;
                while (zbk < i5) {
                    byte b3 = bArr[zbk];
                    if (zbwt.zbd(b3)) {
                        zbk++;
                        cArr[i7] = (char) b3;
                        i7++;
                    }
                }
            } else {
                if (b2 < -32) {
                    if (i8 < i5) {
                        i2 = i7 + 1;
                        zbk += 2;
                        zbwt.zbc(b2, bArr[i8], cArr, i7);
                    } else {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                } else if (b2 < -16) {
                    if (i8 < i5 - 1) {
                        i2 = i7 + 1;
                        int i9 = zbk + 2;
                        zbk += 3;
                        zbwt.zbb(b2, bArr[i8], bArr[i9], cArr, i7);
                    } else {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                } else if (i8 < i5 - 2) {
                    byte b4 = bArr[i8];
                    int i10 = zbk + 3;
                    byte b5 = bArr[zbk + 2];
                    zbk += 4;
                    zbwt.zba(b2, b4, b5, bArr[i10], cArr, i7);
                    i7 += 2;
                } else {
                    throw new zbuq("Protocol message had invalid UTF-8.");
                }
                i7 = i2;
            }
        }
        zbsqVar.zbc = new String(cArr, 0, i7);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbj(int i, byte[] bArr, int i2, int i3, zbwm zbwmVar, zbsq zbsqVar) throws zbuq {
        if ((i >>> 3) == 0) {
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zbn = zbn(bArr, i2, zbsqVar);
            zbwmVar.zbj(i, Long.valueOf(zbsqVar.zbb));
            return zbn;
        }
        if (i4 == 1) {
            zbwmVar.zbj(i, Long.valueOf(zbr(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zbk = zbk(bArr, i2, zbsqVar);
            int i5 = zbsqVar.zba;
            if (i5 < 0) {
                throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - zbk) {
                throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zbwmVar.zbj(i, zbtc.zbb);
            } else {
                zbwmVar.zbj(i, zbtc.zbj(bArr, zbk, i5));
            }
            return zbk + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zbuq("Protocol message contained an invalid tag (zero).");
            }
            zbwmVar.zbj(i, Integer.valueOf(zbc(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zbwm zbf = zbwm.zbf();
        int i7 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i7;
        zbs(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zbk2 = zbk(bArr, i2, zbsqVar);
            i8 = zbsqVar.zba;
            if (i8 == i6) {
                i2 = zbk2;
                break;
            }
            i2 = zbj(i8, bArr, zbk2, i3, zbf, zbsqVar);
        }
        zbsqVar.zbe--;
        if (i2 > i3 || i8 != i6) {
            throw new zbuq("Failed to parse the message.");
        }
        zbwmVar.zbj(i, zbf);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbk(byte[] bArr, int i, zbsq zbsqVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zbl(b, bArr, i2, zbsqVar);
        }
        zbsqVar.zba = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbl(int i, byte[] bArr, int i2, zbsq zbsqVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b >= 0) {
            zbsqVar.zba = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zbsqVar.zba = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zbsqVar.zba = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zbsqVar.zba = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zbsqVar.zba = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbm(int i, byte[] bArr, int i2, int i3, zbun zbunVar, zbsq zbsqVar) {
        zbug zbugVar = (zbug) zbunVar;
        int zbk = zbk(bArr, i2, zbsqVar);
        zbugVar.zbg(zbsqVar.zba);
        while (zbk < i3) {
            int zbk2 = zbk(bArr, zbk, zbsqVar);
            if (i != zbsqVar.zba) {
                break;
            }
            zbk = zbk(bArr, zbk2, zbsqVar);
            zbugVar.zbg(zbsqVar.zba);
        }
        return zbk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbn(byte[] bArr, int i, zbsq zbsqVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zbsqVar.zbb = j;
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
        zbsqVar.zbb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbo(Object obj, zbvx zbvxVar, byte[] bArr, int i, int i2, int i3, zbsq zbsqVar) throws IOException {
        zbvp zbvpVar = (zbvp) zbvxVar;
        int i4 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i4;
        zbs(i4);
        int zbc = zbvpVar.zbc(obj, bArr, i, i2, i3, zbsqVar);
        zbsqVar.zbe--;
        zbsqVar.zbc = obj;
        return zbc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbp(Object obj, zbvx zbvxVar, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zbl(i4, bArr, i3, zbsqVar);
            i4 = zbsqVar.zba;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i6;
        zbs(i6);
        int i7 = i4 + i5;
        zbvxVar.zbh(obj, bArr, i5, i7, zbsqVar);
        zbsqVar.zbe--;
        zbsqVar.zbc = obj;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbq(int i, byte[] bArr, int i2, int i3, zbsq zbsqVar) throws zbuq {
        if ((i >>> 3) == 0) {
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zbn(bArr, i2, zbsqVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zbk(bArr, i2, zbsqVar) + zbsqVar.zba;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zbk(bArr, i2, zbsqVar);
            i6 = zbsqVar.zba;
            if (i6 == i5) {
                break;
            }
            i2 = zbq(i6, bArr, i2, i3, zbsqVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zbuq("Failed to parse the message.");
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zbr(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zbs(int i) throws zbuq {
        if (i >= zbb) {
            throw new zbuq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
