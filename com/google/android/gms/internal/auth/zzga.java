package com.google.android.gms.internal.auth;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.media3.common.C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfxVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = iArr2;
        this.zzi = i4;
        this.zzj = i5;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i, int i2) {
        zzhj.zzn(obj, zzl(i2) & 1048575, i);
    }

    private final void zzB(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzo(i) & 1048575, obj2);
        zzz(obj, i);
    }

    private final void zzC(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzo(i2) & 1048575, obj2);
        zzA(obj, i, i2);
    }

    private final boolean zzD(Object obj, Object obj2, int i) {
        return zzE(obj, i) == zzE(obj2, i);
    }

    private final boolean zzE(Object obj, int i) {
        int zzl = zzl(i);
        long j = zzl & 1048575;
        if (j != 1048575) {
            return (zzhj.zzc(obj, j) & (1 << (zzl >>> 20))) != 0;
        }
        int zzo = zzo(i);
        long j2 = zzo & 1048575;
        switch (zzn(zzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzhj.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhj.zzb(obj, j2)) != 0;
            case 2:
                return zzhj.zzd(obj, j2) != 0;
            case 3:
                return zzhj.zzd(obj, j2) != 0;
            case 4:
                return zzhj.zzc(obj, j2) != 0;
            case 5:
                return zzhj.zzd(obj, j2) != 0;
            case 6:
                return zzhj.zzc(obj, j2) != 0;
            case 7:
                return zzhj.zzt(obj, j2);
            case 8:
                Object zzf = zzhj.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzef) {
                    return !zzef.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhj.zzf(obj, j2) != null;
            case 10:
                return !zzef.zzb.equals(zzhj.zzf(obj, j2));
            case 11:
                return zzhj.zzc(obj, j2) != 0;
            case 12:
                return zzhj.zzc(obj, j2) != 0;
            case 13:
                return zzhj.zzc(obj, j2) != 0;
            case 14:
                return zzhj.zzd(obj, j2) != 0;
            case 15:
                return zzhj.zzc(obj, j2) != 0;
            case 16:
                return zzhj.zzd(obj, j2) != 0;
            case 17:
                return zzhj.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzF(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzE(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzG(Object obj, int i, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i, int i2) {
        return zzhj.zzc(obj, (long) (zzl(i2) & 1048575)) == i;
    }

    static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzd = zzha.zzd();
        zzevVar.zzc = zzd;
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzga zzj(Class cls, zzfu zzfuVar, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        int i;
        int charAt;
        int charAt2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char charAt3;
        int i8;
        char charAt4;
        int i9;
        char charAt5;
        int i10;
        char charAt6;
        int i11;
        char charAt7;
        int i12;
        char charAt8;
        int i13;
        char charAt9;
        int i14;
        char charAt10;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        String str;
        int i21;
        int i22;
        int i23;
        int i24;
        Field zzv;
        char charAt11;
        int i25;
        int i26;
        Object obj;
        Field zzv2;
        Object obj2;
        Field zzv3;
        int i27;
        char charAt12;
        int i28;
        char charAt13;
        int i29;
        char charAt14;
        int i30;
        char charAt15;
        if (zzfuVar instanceof zzgh) {
            zzgh zzghVar = (zzgh) zzfuVar;
            String zzd = zzghVar.zzd();
            int length = zzd.length();
            char c = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i31 = 1;
                while (true) {
                    i = i31 + 1;
                    if (zzd.charAt(i31) < 55296) {
                        break;
                    }
                    i31 = i;
                }
            } else {
                i = 1;
            }
            int i32 = i + 1;
            int charAt16 = zzd.charAt(i);
            if (charAt16 >= 55296) {
                int i33 = charAt16 & 8191;
                int i34 = 13;
                while (true) {
                    i30 = i32 + 1;
                    charAt15 = zzd.charAt(i32);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i33 |= (charAt15 & 8191) << i34;
                    i34 += 13;
                    i32 = i30;
                }
                charAt16 = i33 | (charAt15 << i34);
                i32 = i30;
            }
            if (charAt16 == 0) {
                charAt = 0;
                charAt2 = 0;
                i3 = 0;
                i6 = 0;
                i2 = 0;
                i4 = 0;
                iArr = zza;
                i5 = 0;
            } else {
                int i35 = i32 + 1;
                int charAt17 = zzd.charAt(i32);
                if (charAt17 >= 55296) {
                    int i36 = charAt17 & 8191;
                    int i37 = 13;
                    while (true) {
                        i14 = i35 + 1;
                        charAt10 = zzd.charAt(i35);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i36 |= (charAt10 & 8191) << i37;
                        i37 += 13;
                        i35 = i14;
                    }
                    charAt17 = i36 | (charAt10 << i37);
                    i35 = i14;
                }
                int i38 = i35 + 1;
                int charAt18 = zzd.charAt(i35);
                if (charAt18 >= 55296) {
                    int i39 = charAt18 & 8191;
                    int i40 = 13;
                    while (true) {
                        i13 = i38 + 1;
                        charAt9 = zzd.charAt(i38);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i39 |= (charAt9 & 8191) << i40;
                        i40 += 13;
                        i38 = i13;
                    }
                    charAt18 = i39 | (charAt9 << i40);
                    i38 = i13;
                }
                int i41 = i38 + 1;
                int charAt19 = zzd.charAt(i38);
                if (charAt19 >= 55296) {
                    int i42 = charAt19 & 8191;
                    int i43 = 13;
                    while (true) {
                        i12 = i41 + 1;
                        charAt8 = zzd.charAt(i41);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i42 |= (charAt8 & 8191) << i43;
                        i43 += 13;
                        i41 = i12;
                    }
                    charAt19 = i42 | (charAt8 << i43);
                    i41 = i12;
                }
                int i44 = i41 + 1;
                int charAt20 = zzd.charAt(i41);
                if (charAt20 >= 55296) {
                    int i45 = charAt20 & 8191;
                    int i46 = 13;
                    while (true) {
                        i11 = i44 + 1;
                        charAt7 = zzd.charAt(i44);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i45 |= (charAt7 & 8191) << i46;
                        i46 += 13;
                        i44 = i11;
                    }
                    charAt20 = i45 | (charAt7 << i46);
                    i44 = i11;
                }
                int i47 = i44 + 1;
                charAt = zzd.charAt(i44);
                if (charAt >= 55296) {
                    int i48 = charAt & 8191;
                    int i49 = 13;
                    while (true) {
                        i10 = i47 + 1;
                        charAt6 = zzd.charAt(i47);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i48 |= (charAt6 & 8191) << i49;
                        i49 += 13;
                        i47 = i10;
                    }
                    charAt = i48 | (charAt6 << i49);
                    i47 = i10;
                }
                int i50 = i47 + 1;
                charAt2 = zzd.charAt(i47);
                if (charAt2 >= 55296) {
                    int i51 = charAt2 & 8191;
                    int i52 = 13;
                    while (true) {
                        i9 = i50 + 1;
                        charAt5 = zzd.charAt(i50);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i51 |= (charAt5 & 8191) << i52;
                        i52 += 13;
                        i50 = i9;
                    }
                    charAt2 = i51 | (charAt5 << i52);
                    i50 = i9;
                }
                int i53 = i50 + 1;
                int charAt21 = zzd.charAt(i50);
                if (charAt21 >= 55296) {
                    int i54 = charAt21 & 8191;
                    int i55 = 13;
                    while (true) {
                        i8 = i53 + 1;
                        charAt4 = zzd.charAt(i53);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i54 |= (charAt4 & 8191) << i55;
                        i55 += 13;
                        i53 = i8;
                    }
                    charAt21 = i54 | (charAt4 << i55);
                    i53 = i8;
                }
                int i56 = i53 + 1;
                int charAt22 = zzd.charAt(i53);
                if (charAt22 >= 55296) {
                    int i57 = charAt22 & 8191;
                    int i58 = 13;
                    while (true) {
                        i7 = i56 + 1;
                        charAt3 = zzd.charAt(i56);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i57 |= (charAt3 & 8191) << i58;
                        i58 += 13;
                        i56 = i7;
                    }
                    charAt22 = i57 | (charAt3 << i58);
                    i56 = i7;
                }
                i2 = charAt17 + charAt17 + charAt18;
                iArr = new int[charAt22 + charAt2 + charAt21];
                i3 = charAt19;
                i4 = charAt22;
                i5 = charAt17;
                i6 = charAt20;
                i32 = i56;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zzghVar.zze();
            Class<?> cls2 = zzghVar.zza().getClass();
            int i59 = i4 + charAt2;
            int i60 = charAt + charAt;
            int[] iArr2 = new int[charAt * 3];
            Object[] objArr = new Object[i60];
            int i61 = 0;
            int i62 = 0;
            int i63 = i4;
            int i64 = i59;
            while (i32 < length) {
                int i65 = i32 + 1;
                int charAt23 = zzd.charAt(i32);
                if (charAt23 >= c) {
                    int i66 = charAt23 & 8191;
                    int i67 = i65;
                    int i68 = 13;
                    while (true) {
                        i29 = i67 + 1;
                        charAt14 = zzd.charAt(i67);
                        if (charAt14 < c) {
                            break;
                        }
                        i66 |= (charAt14 & 8191) << i68;
                        i68 += 13;
                        i67 = i29;
                    }
                    charAt23 = i66 | (charAt14 << i68);
                    i15 = i29;
                } else {
                    i15 = i65;
                }
                int i69 = i15 + 1;
                int charAt24 = zzd.charAt(i15);
                if (charAt24 >= c) {
                    int i70 = charAt24 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i28 = i71 + 1;
                        charAt13 = zzd.charAt(i71);
                        if (charAt13 < c) {
                            break;
                        }
                        i70 |= (charAt13 & 8191) << i72;
                        i72 += 13;
                        i71 = i28;
                    }
                    charAt24 = i70 | (charAt13 << i72);
                    i16 = i28;
                } else {
                    i16 = i69;
                }
                if ((charAt24 & 1024) != 0) {
                    iArr[i61] = i62;
                    i61++;
                }
                int i73 = charAt24 & 255;
                if (i73 >= 51) {
                    int i74 = i16 + 1;
                    int charAt25 = zzd.charAt(i16);
                    i17 = length;
                    char c2 = 55296;
                    if (charAt25 >= 55296) {
                        int i75 = charAt25 & 8191;
                        int i76 = 13;
                        while (true) {
                            i27 = i74 + 1;
                            charAt12 = zzd.charAt(i74);
                            if (charAt12 < c2) {
                                break;
                            }
                            i75 |= (charAt12 & 8191) << i76;
                            i76 += 13;
                            i74 = i27;
                            c2 = 55296;
                        }
                        charAt25 = i75 | (charAt12 << i76);
                        i74 = i27;
                    }
                    int i77 = i73 - 51;
                    int i78 = i74;
                    if (i77 == 9 || i77 == 17) {
                        int i79 = i62 / 3;
                        i26 = i2 + 1;
                        objArr[i79 + i79 + 1] = zze[i2];
                    } else {
                        if (i77 == 12 && (zzghVar.zzc() == 1 || (charAt24 & 2048) != 0)) {
                            int i80 = i62 / 3;
                            i26 = i2 + 1;
                            objArr[i80 + i80 + 1] = zze[i2];
                        }
                        int i81 = charAt25 + charAt25;
                        obj = zze[i81];
                        if (!(obj instanceof Field)) {
                            zzv2 = (Field) obj;
                        } else {
                            zzv2 = zzv(cls2, (String) obj);
                            zze[i81] = zzv2;
                        }
                        int i82 = i3;
                        i18 = i6;
                        i24 = (int) unsafe.objectFieldOffset(zzv2);
                        int i83 = i81 + 1;
                        obj2 = zze[i83];
                        if (!(obj2 instanceof Field)) {
                            zzv3 = (Field) obj2;
                        } else {
                            zzv3 = zzv(cls2, (String) obj2);
                            zze[i83] = zzv3;
                        }
                        str = zzd;
                        i19 = i82;
                        i21 = i2;
                        i22 = i78;
                        i20 = (int) unsafe.objectFieldOffset(zzv3);
                        i23 = 0;
                    }
                    i2 = i26;
                    int i812 = charAt25 + charAt25;
                    obj = zze[i812];
                    if (!(obj instanceof Field)) {
                    }
                    int i822 = i3;
                    i18 = i6;
                    i24 = (int) unsafe.objectFieldOffset(zzv2);
                    int i832 = i812 + 1;
                    obj2 = zze[i832];
                    if (!(obj2 instanceof Field)) {
                    }
                    str = zzd;
                    i19 = i822;
                    i21 = i2;
                    i22 = i78;
                    i20 = (int) unsafe.objectFieldOffset(zzv3);
                    i23 = 0;
                } else {
                    i17 = length;
                    int i84 = i3;
                    i18 = i6;
                    int i85 = i2 + 1;
                    Field zzv4 = zzv(cls2, (String) zze[i2]);
                    if (i73 == 9 || i73 == 17) {
                        i19 = i84;
                        int i86 = i62 / 3;
                        objArr[i86 + i86 + 1] = zzv4.getType();
                    } else {
                        if (i73 == 27 || i73 == 49) {
                            i19 = i84;
                            int i87 = i62 / 3;
                            i25 = i2 + 2;
                            objArr[i87 + i87 + 1] = zze[i85];
                        } else if (i73 == 12 || i73 == 30 || i73 == 44) {
                            i19 = i84;
                            if (zzghVar.zzc() == 1 || (charAt24 & 2048) != 0) {
                                int i88 = i62 / 3;
                                i25 = i2 + 2;
                                objArr[i88 + i88 + 1] = zze[i85];
                            }
                        } else {
                            if (i73 == 50) {
                                int i89 = i63 + 1;
                                iArr[i63] = i62;
                                int i90 = i62 / 3;
                                int i91 = i2 + 2;
                                int i92 = i90 + i90;
                                objArr[i92] = zze[i85];
                                if ((charAt24 & 2048) != 0) {
                                    i85 = i2 + 3;
                                    objArr[i92 + 1] = zze[i91];
                                    i19 = i84;
                                    i63 = i89;
                                } else {
                                    i63 = i89;
                                    i85 = i91;
                                }
                            }
                            i19 = i84;
                        }
                        i85 = i25;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(zzv4);
                    i20 = 1048575;
                    if ((charAt24 & 4096) == 0 || i73 > 17) {
                        str = zzd;
                        i21 = i85;
                        i22 = i16;
                        i23 = 0;
                    } else {
                        int i93 = i16 + 1;
                        int charAt26 = zzd.charAt(i16);
                        if (charAt26 >= 55296) {
                            int i94 = charAt26 & 8191;
                            int i95 = 13;
                            while (true) {
                                i22 = i93 + 1;
                                charAt11 = zzd.charAt(i93);
                                if (charAt11 < 55296) {
                                    break;
                                }
                                i94 |= (charAt11 & 8191) << i95;
                                i95 += 13;
                                i93 = i22;
                            }
                            charAt26 = i94 | (charAt11 << i95);
                        } else {
                            i22 = i93;
                        }
                        int i96 = i5 + i5 + (charAt26 / 32);
                        Object obj3 = zze[i96];
                        str = zzd;
                        if (obj3 instanceof Field) {
                            zzv = (Field) obj3;
                        } else {
                            zzv = zzv(cls2, (String) obj3);
                            zze[i96] = zzv;
                        }
                        i21 = i85;
                        i23 = charAt26 % 32;
                        i20 = (int) unsafe.objectFieldOffset(zzv);
                    }
                    if (i73 >= 18 && i73 <= 49) {
                        iArr[i64] = objectFieldOffset;
                        i64++;
                    }
                    i24 = objectFieldOffset;
                }
                int i97 = i62 + 1;
                iArr2[i62] = charAt23;
                int i98 = i62 + 2;
                iArr2[i97] = i24 | ((charAt24 & 2048) != 0 ? Integer.MIN_VALUE : 0) | ((charAt24 & 512) != 0 ? C.BUFFER_FLAG_LAST_SAMPLE : 0) | ((charAt24 & 256) != 0 ? 268435456 : 0) | (i73 << 20);
                i62 += 3;
                iArr2[i98] = (i23 << 20) | i20;
                i2 = i21;
                i32 = i22;
                length = i17;
                i3 = i19;
                zzd = str;
                i6 = i18;
                c = 55296;
            }
            return new zzga(iArr2, objArr, i3, i6, zzghVar.zza(), zzghVar.zzc(), false, iArr, i4, i59, zzgcVar, zzflVar, zzgzVar, zzemVar, zzfsVar);
        }
        throw null;
    }

    private static int zzk(Object obj, long j) {
        return ((Integer) zzhj.zzf(obj, j)).intValue();
    }

    private final int zzl(int i) {
        return this.zzc[i + 2];
    }

    private final int zzm(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzhj.zzf(obj, j)).longValue();
    }

    private final zzey zzq(int i) {
        int i2 = i / 3;
        return (zzey) this.zzd[i2 + i2 + 1];
    }

    private final zzgi zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgi zzgiVar = (zzgi) this.zzd[i3];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzb2 = zzgf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzt(Object obj, int i) {
        zzgi zzr = zzr(i);
        int zzo = zzo(i) & 1048575;
        if (!zzE(obj, i)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo);
        if (zzH(object)) {
            return object;
        }
        Object zzd = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd, object);
        }
        return zzd;
    }

    private final Object zzu(Object obj, int i, int i2) {
        zzgi zzr = zzr(i2);
        if (!zzI(obj, i, i2)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i2) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object zzd = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd, object);
        }
        return zzd;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzx(Object obj, Object obj2, int i) {
        if (zzE(obj2, i)) {
            int zzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzr = zzr(i);
            if (!zzE(obj, i)) {
                if (!zzH(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zzd = zzr.zzd();
                    zzr.zzf(zzd, object);
                    unsafe.putObject(obj, j, zzd);
                }
                zzz(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object zzd2 = zzr.zzd();
                zzr.zzf(zzd2, object2);
                unsafe.putObject(obj, j, zzd2);
                object2 = zzd2;
            }
            zzr.zzf(object2, object);
        }
    }

    private final void zzy(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzI(obj2, i2, i)) {
            int zzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzr = zzr(i);
            if (!zzI(obj, i2, i)) {
                if (!zzH(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zzd = zzr.zzd();
                    zzr.zzf(zzd, object);
                    unsafe.putObject(obj, j, zzd);
                }
                zzA(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object zzd2 = zzr.zzd();
                zzr.zzf(zzd2, object2);
                unsafe.putObject(obj, j, zzd2);
                object2 = zzd2;
            }
            zzr.zzf(object2, object);
        }
    }

    private final void zzz(Object obj, int i) {
        int zzl = zzl(i);
        long j = 1048575 & zzl;
        if (j == 1048575) {
            return;
        }
        zzhj.zzn(obj, j, (1 << (zzl >>> 20)) | zzhj.zzc(obj, j));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzo = zzo(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzo;
            int i5 = 37;
            switch (zzn(zzo)) {
                case 0:
                    i = i2 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhj.zza(obj, j));
                    byte[] bArr = zzfa.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhj.zzb(obj, j));
                    i2 = i + floatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr2 = zzfa.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr3 = zzfa.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr4 = zzfa.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    floatToIntBits = zzfa.zza(zzhj.zzt(obj, j));
                    i2 = i + floatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    floatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case 9:
                    Object zzf = zzhj.zzf(obj, j);
                    if (zzf != null) {
                        i5 = zzf.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr5 = zzfa.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + floatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    doubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr6 = zzfa.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i2 = i + floatToIntBits;
                    break;
                case 17:
                    Object zzf2 = zzhj.zzf(obj, j);
                    if (zzf2 != null) {
                        i5 = zzf2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    floatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + floatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = Double.doubleToLongBits(((Double) zzhj.zzf(obj, j)).doubleValue());
                        byte[] bArr7 = zzfa.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = Float.floatToIntBits(((Float) zzhj.zzf(obj, j)).floatValue());
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzp(obj, j);
                        byte[] bArr8 = zzfa.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzp(obj, j);
                        byte[] bArr9 = zzfa.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzk(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzp(obj, j);
                        byte[] bArr10 = zzfa.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzk(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzfa.zza(((Boolean) zzhj.zzf(obj, j)).booleanValue());
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzk(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzk(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzk(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzp(obj, j);
                        byte[] bArr11 = zzfa.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzk(obj, j);
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        doubleToLongBits = zzp(obj, j);
                        byte[] bArr12 = zzfa.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        floatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return (i2 * 53) + this.zzl.zzb(obj).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0cf3, code lost:
    
        if (r6 == 1048575) goto L552;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0cf5, code lost:
    
        r13.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0cf9, code lost:
    
        r2 = r0.zzi;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0cfd, code lost:
    
        if (r2 >= r0.zzj) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0cff, code lost:
    
        r3 = r0.zzh[r2];
        r5 = r0.zzc[r3];
        r5 = com.google.android.gms.internal.auth.zzhj.zzf(r7, r0.zzo(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0d14, code lost:
    
        if (r5 != null) goto L558;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0d1b, code lost:
    
        if (r0.zzq(r3) != null) goto L668;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0d20, code lost:
    
        r5 = (com.google.android.gms.internal.auth.zzfr) r5;
        r1 = (com.google.android.gms.internal.auth.zzfq) r0.zzs(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0d28, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0d1d, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0d29, code lost:
    
        if (r8 != 0) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0d2b, code lost:
    
        if (r1 != r9) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0d32, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0d37, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0d33, code lost:
    
        if (r1 > r9) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0d35, code lost:
    
        if (r4 != r8) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0d3c, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.zzd();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:158:0x043c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0a1e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:537:0x00b9. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:168:0x09a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x09b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0c98 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0caf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:606:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:723:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(Object obj, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        int i8;
        int zzm;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Unsafe unsafe2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Unsafe unsafe3;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Object obj2;
        zzez zzezVar;
        int i25;
        int i26;
        int i27;
        Unsafe unsafe4;
        int i28;
        int i29;
        Unsafe unsafe5;
        int zzf;
        Object obj3;
        int i30;
        int i31;
        int zzj;
        int i32;
        int i33;
        int i34;
        int zzh;
        int i35;
        zzdt zzdtVar2;
        int i36;
        int i37;
        zzdt zzdtVar3;
        int i38;
        zzga<T> zzgaVar = this;
        Object obj4 = obj;
        int i39 = i2;
        int i40 = i3;
        zzdt zzdtVar4 = zzdtVar;
        zzw(obj);
        Unsafe unsafe6 = zzb;
        int i41 = 0;
        int i42 = i;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        int i46 = -1;
        int i47 = 1048575;
        while (true) {
            if (i42 < i39) {
                int i48 = i42 + 1;
                int i49 = bArr[i42];
                if (i49 < 0) {
                    i6 = zzdu.zzi(i49, bArr, i48, zzdtVar4);
                    i44 = zzdtVar4.zza;
                } else {
                    i44 = i49;
                    i6 = i48;
                }
                int i50 = i44 >>> 3;
                if (i50 > i46) {
                    zzm = (i50 < zzgaVar.zze || i50 > zzgaVar.zzf) ? -1 : zzgaVar.zzm(i50, i43 / 3);
                } else if (i50 < zzgaVar.zze || i50 > zzgaVar.zzf) {
                    i7 = -1;
                    i8 = -1;
                    if (i8 == i7) {
                        int i51 = i44 & 7;
                        int[] iArr = zzgaVar.zzc;
                        int i52 = iArr[i8 + 1];
                        int i53 = i44;
                        int zzn = zzn(i52);
                        long j = i52 & 1048575;
                        if (zzn > 17) {
                            int i54 = i8;
                            i11 = i47;
                            int i55 = i53;
                            i13 = 0;
                            i14 = i2;
                            int i56 = i45;
                            if (zzn != 27) {
                                if (zzn > 49) {
                                    unsafe2 = unsafe6;
                                    i10 = i56;
                                    i23 = i6;
                                    i24 = i54;
                                    i21 = i50;
                                    if (zzn != 50) {
                                        Unsafe unsafe7 = zzb;
                                        long j2 = iArr[i24 + 2] & 1048575;
                                        switch (zzn) {
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                i19 = i55;
                                                i35 = i23;
                                                zzdtVar2 = zzdtVar4;
                                                i36 = i24;
                                                i12 = i21;
                                                obj4 = obj;
                                                i14 = i2;
                                                if (i51 == 1) {
                                                    unsafe7.putObject(obj4, j, Double.valueOf(Double.longBitsToDouble(zzdu.zzn(bArr, i35))));
                                                    i37 = i35 + 8;
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    if (i37 != i35) {
                                                        i4 = i3;
                                                        i9 = i37;
                                                        i41 = i36;
                                                        i44 = i19;
                                                        break;
                                                    } else {
                                                        i40 = i3;
                                                        zzdtVar4 = zzdtVar2;
                                                        i39 = i14;
                                                        i43 = i36;
                                                        i41 = 0;
                                                        i44 = i19;
                                                        i45 = i10;
                                                        unsafe6 = unsafe2;
                                                        i47 = i11;
                                                        int i57 = i37;
                                                        i46 = i12;
                                                        i42 = i57;
                                                        break;
                                                    }
                                                }
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                                i19 = i55;
                                                i35 = i23;
                                                zzdtVar2 = zzdtVar4;
                                                i36 = i24;
                                                i12 = i21;
                                                obj4 = obj;
                                                i14 = i2;
                                                if (i51 == 5) {
                                                    unsafe7.putObject(obj4, j, Float.valueOf(Float.intBitsToFloat(zzdu.zzb(bArr, i35))));
                                                    i37 = i35 + 4;
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                i19 = i55;
                                                i35 = i23;
                                                zzdtVar2 = zzdtVar4;
                                                i36 = i24;
                                                i12 = i21;
                                                obj4 = obj;
                                                i14 = i2;
                                                if (i51 == 0) {
                                                    i37 = zzdu.zzk(bArr, i35, zzdtVar2);
                                                    unsafe7.putObject(obj4, j, Long.valueOf(zzdtVar2.zzb));
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                            case 62:
                                                i19 = i55;
                                                i35 = i23;
                                                zzdtVar2 = zzdtVar4;
                                                i36 = i24;
                                                i12 = i21;
                                                obj4 = obj;
                                                i14 = i2;
                                                if (i51 == 0) {
                                                    i37 = zzdu.zzh(bArr, i35, zzdtVar2);
                                                    unsafe7.putObject(obj4, j, Integer.valueOf(zzdtVar2.zza));
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i19 = i55;
                                                i35 = i23;
                                                zzdtVar2 = zzdtVar4;
                                                i36 = i24;
                                                i12 = i21;
                                                obj4 = obj;
                                                i14 = i2;
                                                if (i51 == 1) {
                                                    unsafe7.putObject(obj4, j, Long.valueOf(zzdu.zzn(bArr, i35)));
                                                    i37 = i35 + 8;
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i19 = i55;
                                                i35 = i23;
                                                zzdtVar2 = zzdtVar4;
                                                i36 = i24;
                                                i12 = i21;
                                                obj4 = obj;
                                                i14 = i2;
                                                if (i51 == 5) {
                                                    unsafe7.putObject(obj4, j, Integer.valueOf(zzdu.zzb(bArr, i35)));
                                                    i37 = i35 + 4;
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case 58:
                                                i19 = i55;
                                                zzdtVar2 = zzdtVar4;
                                                i36 = i24;
                                                i12 = i21;
                                                obj4 = obj;
                                                i14 = i2;
                                                if (i51 == 0) {
                                                    i37 = zzdu.zzk(bArr, i23, zzdtVar2);
                                                    i35 = i23;
                                                    unsafe7.putObject(obj4, j, Boolean.valueOf(zzdtVar2.zzb != 0));
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i35 = i23;
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case 59:
                                                obj4 = obj;
                                                i14 = i2;
                                                i36 = i24;
                                                i12 = i21;
                                                zzdtVar2 = zzdtVar4;
                                                if (i51 == 2) {
                                                    i37 = zzdu.zzh(bArr, i23, zzdtVar2);
                                                    int i58 = zzdtVar2.zza;
                                                    if (i58 == 0) {
                                                        unsafe7.putObject(obj4, j, "");
                                                    } else if ((i52 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zzhn.zzc(bArr, i37, i37 + i58)) {
                                                        unsafe7.putObject(obj4, j, new String(bArr, i37, i58, zzfa.zzb));
                                                        i37 += i58;
                                                    } else {
                                                        throw zzfb.zzb();
                                                    }
                                                    unsafe7.putInt(obj4, j2, i12);
                                                    i19 = i55;
                                                    unsafe2 = unsafe2;
                                                    i35 = i23;
                                                    if (i37 != i35) {
                                                    }
                                                } else {
                                                    i19 = i55;
                                                    unsafe2 = unsafe2;
                                                    i35 = i23;
                                                    i37 = i35;
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                obj4 = obj;
                                                if (i51 == 2) {
                                                    Object zzu = zzgaVar.zzu(obj4, i21, i24);
                                                    int zzm2 = zzdu.zzm(zzu, zzgaVar.zzr(i24), bArr, i23, i2, zzdtVar);
                                                    zzgaVar.zzC(obj4, i21, i24, zzu);
                                                    zzdtVar2 = zzdtVar;
                                                    i37 = zzm2;
                                                    i36 = i24;
                                                    i12 = i21;
                                                    i35 = i23;
                                                    i19 = i55;
                                                    i14 = i2;
                                                    if (i37 != i35) {
                                                    }
                                                } else {
                                                    i36 = i24;
                                                    i12 = i21;
                                                    i19 = i55;
                                                    i35 = i23;
                                                    i14 = i2;
                                                    zzdtVar2 = zzdtVar;
                                                    i37 = i35;
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                zzdtVar3 = zzdtVar4;
                                                obj4 = obj;
                                                i38 = i23;
                                                if (i51 == 2) {
                                                    i37 = zzdu.zza(bArr, i38, zzdtVar3);
                                                    unsafe7.putObject(obj4, j, zzdtVar3.zzc);
                                                    unsafe7.putInt(obj4, j2, i21);
                                                    i36 = i24;
                                                    i12 = i21;
                                                    i19 = i55;
                                                    i35 = i38;
                                                    i14 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i36 = i24;
                                                i12 = i21;
                                                i19 = i55;
                                                i35 = i38;
                                                i14 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                zzdtVar3 = zzdtVar4;
                                                obj4 = obj;
                                                i38 = i23;
                                                if (i51 == 0) {
                                                    i37 = zzdu.zzh(bArr, i38, zzdtVar3);
                                                    int i59 = zzdtVar3.zza;
                                                    zzey zzq = zzgaVar.zzq(i24);
                                                    if (zzq == null || zzq.zza()) {
                                                        unsafe7.putObject(obj4, j, Integer.valueOf(i59));
                                                        unsafe7.putInt(obj4, j2, i21);
                                                    } else {
                                                        zzc(obj).zzh(i55, Long.valueOf(i59));
                                                    }
                                                    i36 = i24;
                                                    i12 = i21;
                                                    i19 = i55;
                                                    i35 = i38;
                                                    i14 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i36 = i24;
                                                i12 = i21;
                                                i19 = i55;
                                                i35 = i38;
                                                i14 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                zzdtVar3 = zzdtVar4;
                                                obj4 = obj;
                                                i38 = i23;
                                                if (i51 == 0) {
                                                    i37 = zzdu.zzh(bArr, i38, zzdtVar3);
                                                    unsafe7.putObject(obj4, j, Integer.valueOf(zzej.zzb(zzdtVar3.zza)));
                                                    unsafe7.putInt(obj4, j2, i21);
                                                    i36 = i24;
                                                    i12 = i21;
                                                    i19 = i55;
                                                    i35 = i38;
                                                    i14 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i36 = i24;
                                                i12 = i21;
                                                i19 = i55;
                                                i35 = i38;
                                                i14 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case 67:
                                                zzdtVar3 = zzdtVar4;
                                                obj4 = obj;
                                                i38 = i23;
                                                if (i51 == 0) {
                                                    i37 = zzdu.zzk(bArr, i38, zzdtVar3);
                                                    unsafe7.putObject(obj4, j, Long.valueOf(zzej.zzc(zzdtVar3.zzb)));
                                                    unsafe7.putInt(obj4, j2, i21);
                                                    i36 = i24;
                                                    i12 = i21;
                                                    i19 = i55;
                                                    i35 = i38;
                                                    i14 = i2;
                                                    zzdtVar2 = zzdtVar3;
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                i36 = i24;
                                                i12 = i21;
                                                i19 = i55;
                                                i35 = i38;
                                                i14 = i2;
                                                zzdtVar2 = zzdtVar3;
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                            case 68:
                                                if (i51 == 3) {
                                                    obj4 = obj;
                                                    Object zzu2 = zzgaVar.zzu(obj4, i21, i24);
                                                    int zzl = zzdu.zzl(zzu2, zzgaVar.zzr(i24), bArr, i23, i2, (i55 & (-8)) | 4, zzdtVar);
                                                    zzgaVar.zzC(obj4, i21, i24, zzu2);
                                                    i36 = i24;
                                                    i12 = i21;
                                                    i19 = i55;
                                                    i37 = zzl;
                                                    zzdtVar2 = zzdtVar4;
                                                    i35 = i23;
                                                    i14 = i2;
                                                    if (i37 != i35) {
                                                    }
                                                }
                                                break;
                                            default:
                                                obj4 = obj;
                                                i14 = i2;
                                                i36 = i24;
                                                i12 = i21;
                                                i19 = i55;
                                                i35 = i23;
                                                zzdtVar2 = zzdtVar4;
                                                i37 = i35;
                                                if (i37 != i35) {
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i51 == 2) {
                                            Unsafe unsafe8 = zzb;
                                            Object zzs = zzgaVar.zzs(i24);
                                            Object object = unsafe8.getObject(obj, j);
                                            if (!((zzfr) object).zze()) {
                                                zzfr zzb2 = zzfr.zza().zzb();
                                                zzfs.zza(zzb2, object);
                                                unsafe8.putObject(obj, j, zzb2);
                                            }
                                            throw null;
                                        }
                                        i22 = i55;
                                        obj4 = obj;
                                        i4 = i3;
                                        i41 = i24;
                                        i12 = i21;
                                        i44 = i22;
                                        i9 = i23;
                                    }
                                } else {
                                    long j3 = i52;
                                    Unsafe unsafe9 = zzb;
                                    Unsafe unsafe10 = unsafe6;
                                    zzez zzezVar2 = (zzez) unsafe9.getObject(obj4, j);
                                    if (zzezVar2.zzc()) {
                                        obj2 = "";
                                        zzezVar = zzezVar2;
                                    } else {
                                        int size = zzezVar2.size();
                                        obj2 = "";
                                        zzez zzd = zzezVar2.zzd(size != 0 ? size + size : 10);
                                        unsafe9.putObject(obj4, j, zzd);
                                        zzezVar = zzd;
                                    }
                                    switch (zzn) {
                                        case 18:
                                        case 35:
                                            i25 = i6;
                                            i39 = i14;
                                            i26 = i50;
                                            i41 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe4 = unsafe10;
                                            if (i51 == 2) {
                                                zzek zzekVar = (zzek) zzezVar;
                                                i42 = zzdu.zzh(bArr, i25, zzdtVar4);
                                                int i60 = zzdtVar4.zza + i42;
                                                while (i42 < i60) {
                                                    zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, i42)));
                                                    i42 += 8;
                                                }
                                                if (i42 != i60) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i51 == 1) {
                                                    zzek zzekVar2 = (zzek) zzezVar;
                                                    zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr, i25)));
                                                    i42 = i25 + 8;
                                                    while (i42 < i39) {
                                                        int zzh2 = zzdu.zzh(bArr, i42, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr, zzh2)));
                                                            i42 = zzh2 + 8;
                                                        }
                                                    }
                                                }
                                                i42 = i25;
                                            }
                                            if (i42 == i25) {
                                                i9 = i42;
                                                i44 = i27;
                                                unsafe2 = unsafe4;
                                                i12 = i26;
                                                i14 = i39;
                                                obj4 = obj;
                                                i4 = i3;
                                                break;
                                            } else {
                                                i40 = i3;
                                                i44 = i27;
                                                unsafe6 = unsafe4;
                                                i46 = i26;
                                                i43 = i41;
                                                i41 = 0;
                                                i45 = i10;
                                                i47 = i11;
                                                obj4 = obj;
                                                break;
                                            }
                                        case 19:
                                        case 36:
                                            i25 = i6;
                                            i39 = i14;
                                            i26 = i50;
                                            i41 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe4 = unsafe10;
                                            if (i51 == 2) {
                                                zzer zzerVar = (zzer) zzezVar;
                                                i42 = zzdu.zzh(bArr, i25, zzdtVar4);
                                                int i61 = zzdtVar4.zza + i42;
                                                while (i42 < i61) {
                                                    zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, i42)));
                                                    i42 += 4;
                                                }
                                                if (i42 != i61) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i51 == 5) {
                                                    zzer zzerVar2 = (zzer) zzezVar;
                                                    zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr, i25)));
                                                    i42 = i25 + 4;
                                                    while (i42 < i39) {
                                                        int zzh3 = zzdu.zzh(bArr, i42, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr, zzh3)));
                                                            i42 = zzh3 + 4;
                                                        }
                                                    }
                                                }
                                                i42 = i25;
                                            }
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i25 = i6;
                                            i39 = i14;
                                            i26 = i50;
                                            i41 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe4 = unsafe10;
                                            if (i51 == 2) {
                                                zzfm zzfmVar = (zzfm) zzezVar;
                                                i42 = zzdu.zzh(bArr, i25, zzdtVar4);
                                                int i62 = zzdtVar4.zza + i42;
                                                while (i42 < i62) {
                                                    i42 = zzdu.zzk(bArr, i42, zzdtVar4);
                                                    zzfmVar.zze(zzdtVar4.zzb);
                                                }
                                                if (i42 != i62) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i51 == 0) {
                                                    zzfm zzfmVar2 = (zzfm) zzezVar;
                                                    i42 = zzdu.zzk(bArr, i25, zzdtVar4);
                                                    zzfmVar2.zze(zzdtVar4.zzb);
                                                    while (i42 < i39) {
                                                        int zzh4 = zzdu.zzh(bArr, i42, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            i42 = zzdu.zzk(bArr, zzh4, zzdtVar4);
                                                            zzfmVar2.zze(zzdtVar4.zzb);
                                                        }
                                                    }
                                                }
                                                i42 = i25;
                                            }
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i28 = i50;
                                            i29 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe5 = unsafe10;
                                            if (i51 == 2) {
                                                zzf = zzdu.zzf(bArr, i6, zzezVar, zzdtVar4);
                                                i25 = i6;
                                                i42 = zzf;
                                                unsafe4 = unsafe5;
                                                i26 = i28;
                                                i41 = i29;
                                                i39 = i14;
                                                if (i42 == i25) {
                                                }
                                            } else {
                                                if (i51 == 0) {
                                                    i25 = i6;
                                                    unsafe4 = unsafe5;
                                                    i26 = i28;
                                                    i41 = i29;
                                                    i39 = i14;
                                                    i42 = zzdu.zzj(i27, bArr, i25, i2, zzezVar, zzdtVar);
                                                    if (i42 == i25) {
                                                    }
                                                }
                                                i25 = i6;
                                                unsafe4 = unsafe5;
                                                i26 = i28;
                                                i41 = i29;
                                                i39 = i14;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i28 = i50;
                                            i29 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe5 = unsafe10;
                                            if (i51 == 2) {
                                                zzfm zzfmVar3 = (zzfm) zzezVar;
                                                zzf = zzdu.zzh(bArr, i6, zzdtVar4);
                                                int i63 = zzdtVar4.zza + zzf;
                                                while (zzf < i63) {
                                                    zzfmVar3.zze(zzdu.zzn(bArr, zzf));
                                                    zzf += 8;
                                                }
                                                if (zzf != i63) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i51 == 1) {
                                                    zzfm zzfmVar4 = (zzfm) zzezVar;
                                                    zzfmVar4.zze(zzdu.zzn(bArr, i6));
                                                    zzf = i6 + 8;
                                                    while (zzf < i14) {
                                                        int zzh5 = zzdu.zzh(bArr, zzf, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            zzfmVar4.zze(zzdu.zzn(bArr, zzh5));
                                                            zzf = zzh5 + 8;
                                                        }
                                                    }
                                                }
                                                i25 = i6;
                                                unsafe4 = unsafe5;
                                                i26 = i28;
                                                i41 = i29;
                                                i39 = i14;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            i25 = i6;
                                            i42 = zzf;
                                            unsafe4 = unsafe5;
                                            i26 = i28;
                                            i41 = i29;
                                            i39 = i14;
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i28 = i50;
                                            i29 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe5 = unsafe10;
                                            if (i51 == 2) {
                                                zzew zzewVar = (zzew) zzezVar;
                                                zzf = zzdu.zzh(bArr, i6, zzdtVar4);
                                                int i64 = zzdtVar4.zza + zzf;
                                                while (zzf < i64) {
                                                    zzewVar.zze(zzdu.zzb(bArr, zzf));
                                                    zzf += 4;
                                                }
                                                if (zzf != i64) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i51 == 5) {
                                                    zzew zzewVar2 = (zzew) zzezVar;
                                                    zzewVar2.zze(zzdu.zzb(bArr, i6));
                                                    zzf = i6 + 4;
                                                    while (zzf < i14) {
                                                        int zzh6 = zzdu.zzh(bArr, zzf, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            zzewVar2.zze(zzdu.zzb(bArr, zzh6));
                                                            zzf = zzh6 + 4;
                                                        }
                                                    }
                                                }
                                                i25 = i6;
                                                unsafe4 = unsafe5;
                                                i26 = i28;
                                                i41 = i29;
                                                i39 = i14;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            i25 = i6;
                                            i42 = zzf;
                                            unsafe4 = unsafe5;
                                            i26 = i28;
                                            i41 = i29;
                                            i39 = i14;
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i28 = i50;
                                            i29 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe5 = unsafe10;
                                            if (i51 == 2) {
                                                zzdv zzdvVar = (zzdv) zzezVar;
                                                zzf = zzdu.zzh(bArr, i6, zzdtVar4);
                                                int i65 = zzdtVar4.zza + zzf;
                                                while (zzf < i65) {
                                                    zzf = zzdu.zzk(bArr, zzf, zzdtVar4);
                                                    zzdvVar.zze(zzdtVar4.zzb != 0);
                                                }
                                                if (zzf != i65) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i51 == 0) {
                                                    zzdv zzdvVar2 = (zzdv) zzezVar;
                                                    zzf = zzdu.zzk(bArr, i6, zzdtVar4);
                                                    zzdvVar2.zze(zzdtVar4.zzb != 0);
                                                    while (zzf < i14) {
                                                        int zzh7 = zzdu.zzh(bArr, zzf, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            zzf = zzdu.zzk(bArr, zzh7, zzdtVar4);
                                                            zzdvVar2.zze(zzdtVar4.zzb != 0);
                                                        }
                                                    }
                                                }
                                                i25 = i6;
                                                unsafe4 = unsafe5;
                                                i26 = i28;
                                                i41 = i29;
                                                i39 = i14;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            i25 = i6;
                                            i42 = zzf;
                                            unsafe4 = unsafe5;
                                            i26 = i28;
                                            i41 = i29;
                                            i39 = i14;
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 26:
                                            i28 = i50;
                                            i29 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe5 = unsafe10;
                                            if (i51 == 2) {
                                                if ((j3 & 536870912) != 0) {
                                                    Object obj5 = obj2;
                                                    zzf = zzdu.zzh(bArr, i6, zzdtVar4);
                                                    int i66 = zzdtVar4.zza;
                                                    if (i66 < 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i66 == 0) {
                                                        zzezVar.add(obj5);
                                                    } else {
                                                        int i67 = zzf + i66;
                                                        if (zzhn.zzc(bArr, zzf, i67)) {
                                                            zzezVar.add(new String(bArr, zzf, i66, zzfa.zzb));
                                                            zzf = i67;
                                                        } else {
                                                            throw zzfb.zzb();
                                                        }
                                                    }
                                                    while (zzf < i14) {
                                                        int zzh8 = zzdu.zzh(bArr, zzf, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            zzf = zzdu.zzh(bArr, zzh8, zzdtVar4);
                                                            int i68 = zzdtVar4.zza;
                                                            if (i68 < 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i68 == 0) {
                                                                zzezVar.add(obj5);
                                                            } else {
                                                                int i69 = zzf + i68;
                                                                if (zzhn.zzc(bArr, zzf, i69)) {
                                                                    zzezVar.add(new String(bArr, zzf, i68, zzfa.zzb));
                                                                    zzf = i69;
                                                                } else {
                                                                    throw zzfb.zzb();
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    zzf = zzdu.zzh(bArr, i6, zzdtVar4);
                                                    int i70 = zzdtVar4.zza;
                                                    if (i70 < 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i70 == 0) {
                                                        obj3 = obj2;
                                                        zzezVar.add(obj3);
                                                    } else {
                                                        obj3 = obj2;
                                                        zzezVar.add(new String(bArr, zzf, i70, zzfa.zzb));
                                                        zzf += i70;
                                                    }
                                                    while (zzf < i14) {
                                                        int zzh9 = zzdu.zzh(bArr, zzf, zzdtVar4);
                                                        if (i27 == zzdtVar4.zza) {
                                                            zzf = zzdu.zzh(bArr, zzh9, zzdtVar4);
                                                            int i71 = zzdtVar4.zza;
                                                            if (i71 < 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i71 == 0) {
                                                                zzezVar.add(obj3);
                                                            } else {
                                                                zzezVar.add(new String(bArr, zzf, i71, zzfa.zzb));
                                                                zzf += i71;
                                                            }
                                                        }
                                                    }
                                                }
                                                i25 = i6;
                                                i42 = zzf;
                                                unsafe4 = unsafe5;
                                                i26 = i28;
                                                i41 = i29;
                                                i39 = i14;
                                                if (i42 == i25) {
                                                }
                                            }
                                            i25 = i6;
                                            unsafe4 = unsafe5;
                                            i26 = i28;
                                            i41 = i29;
                                            i39 = i14;
                                            i42 = i25;
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 27:
                                            i25 = i6;
                                            i10 = i56;
                                            if (i51 == 2) {
                                                zzgaVar = this;
                                                i27 = i55;
                                                zzdtVar4 = zzdtVar4;
                                                i26 = i50;
                                                i41 = i54;
                                                i39 = i14;
                                                i42 = zzdu.zze(zzgaVar.zzr(i54), i55, bArr, i25, i2, zzezVar, zzdtVar);
                                                unsafe4 = unsafe10;
                                                if (i42 == i25) {
                                                }
                                            } else {
                                                zzgaVar = this;
                                                i27 = i55;
                                                i39 = i14;
                                                i26 = i50;
                                                i41 = i54;
                                                unsafe4 = unsafe10;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            break;
                                        case 28:
                                            i25 = i6;
                                            i30 = i14;
                                            i10 = i56;
                                            if (i51 == 2) {
                                                int zzh10 = zzdu.zzh(bArr, i25, zzdtVar4);
                                                int i72 = zzdtVar4.zza;
                                                if (i72 >= 0) {
                                                    if (i72 > bArr.length - zzh10) {
                                                        throw zzfb.zzf();
                                                    }
                                                    if (i72 == 0) {
                                                        zzezVar.add(zzef.zzb);
                                                    } else {
                                                        zzezVar.add(zzef.zzk(bArr, zzh10, i72));
                                                        zzh10 += i72;
                                                    }
                                                    while (zzh10 < i30) {
                                                        int zzh11 = zzdu.zzh(bArr, zzh10, zzdtVar4);
                                                        if (i55 == zzdtVar4.zza) {
                                                            zzh10 = zzdu.zzh(bArr, zzh11, zzdtVar4);
                                                            int i73 = zzdtVar4.zza;
                                                            if (i73 >= 0) {
                                                                if (i73 > bArr.length - zzh10) {
                                                                    throw zzfb.zzf();
                                                                }
                                                                if (i73 == 0) {
                                                                    zzezVar.add(zzef.zzb);
                                                                } else {
                                                                    zzezVar.add(zzef.zzk(bArr, zzh10, i73));
                                                                    zzh10 += i73;
                                                                }
                                                            } else {
                                                                throw zzfb.zzc();
                                                            }
                                                        } else {
                                                            i42 = zzh10;
                                                            i26 = i50;
                                                            i27 = i55;
                                                            i41 = i54;
                                                            zzgaVar = this;
                                                            i39 = i30;
                                                            unsafe4 = unsafe10;
                                                            if (i42 == i25) {
                                                            }
                                                        }
                                                    }
                                                    i42 = zzh10;
                                                    i26 = i50;
                                                    i27 = i55;
                                                    i41 = i54;
                                                    zzgaVar = this;
                                                    i39 = i30;
                                                    unsafe4 = unsafe10;
                                                    if (i42 == i25) {
                                                    }
                                                } else {
                                                    throw zzfb.zzc();
                                                }
                                            } else {
                                                zzgaVar = this;
                                                i26 = i50;
                                                i27 = i55;
                                                i41 = i54;
                                                i39 = i30;
                                                unsafe4 = unsafe10;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            if (i51 == 2) {
                                                zzj = zzdu.zzf(bArr, i6, zzezVar, zzdtVar4);
                                                i25 = i6;
                                                i30 = i14;
                                                i31 = i54;
                                                i10 = i56;
                                            } else if (i51 == 0) {
                                                i25 = i6;
                                                i31 = i54;
                                                i10 = i56;
                                                i30 = i14;
                                                zzj = zzdu.zzj(i55, bArr, i25, i2, zzezVar, zzdtVar);
                                            } else {
                                                i10 = i56;
                                                zzgaVar = this;
                                                i25 = i6;
                                                i26 = i50;
                                                i27 = i55;
                                                i41 = i54;
                                                unsafe4 = unsafe10;
                                                i39 = i14;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            zzey zzq2 = zzgaVar.zzq(i31);
                                            zzgz zzgzVar = zzgaVar.zzl;
                                            int i74 = zzgk.zza;
                                            if (zzq2 == null) {
                                                i32 = zzj;
                                                i33 = i31;
                                            } else if (zzezVar instanceof RandomAccess) {
                                                int size2 = zzezVar.size();
                                                i32 = zzj;
                                                Object obj6 = null;
                                                int i75 = 0;
                                                int i76 = 0;
                                                while (i75 < size2) {
                                                    Integer num = (Integer) zzezVar.get(i75);
                                                    int i77 = i31;
                                                    int intValue = num.intValue();
                                                    if (zzq2.zza()) {
                                                        if (i75 != i76) {
                                                            zzezVar.set(i76, num);
                                                        }
                                                        i76++;
                                                    } else {
                                                        obj6 = zzgk.zzc(obj4, i50, intValue, obj6, zzgzVar);
                                                    }
                                                    i75++;
                                                    i31 = i77;
                                                }
                                                i33 = i31;
                                                if (i76 != size2) {
                                                    zzezVar.subList(i76, size2).clear();
                                                }
                                            } else {
                                                i32 = zzj;
                                                i33 = i31;
                                                Iterator it = zzezVar.iterator();
                                                Object obj7 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!zzq2.zza()) {
                                                        obj7 = zzgk.zzc(obj4, i50, intValue2, obj7, zzgzVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            zzgaVar = this;
                                            i42 = i32;
                                            i26 = i50;
                                            i27 = i55;
                                            i41 = i33;
                                            i39 = i30;
                                            unsafe4 = unsafe10;
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i34 = i55;
                                            if (i51 == 2) {
                                                zzew zzewVar3 = (zzew) zzezVar;
                                                zzh = zzdu.zzh(bArr, i6, zzdtVar4);
                                                int i78 = zzdtVar4.zza + zzh;
                                                while (zzh < i78) {
                                                    zzh = zzdu.zzh(bArr, zzh, zzdtVar4);
                                                    zzewVar3.zze(zzej.zzb(zzdtVar4.zza));
                                                }
                                                if (zzh != i78) {
                                                    throw zzfb.zzf();
                                                }
                                            } else if (i51 == 0) {
                                                zzew zzewVar4 = (zzew) zzezVar;
                                                zzh = zzdu.zzh(bArr, i6, zzdtVar4);
                                                zzewVar4.zze(zzej.zzb(zzdtVar4.zza));
                                                while (zzh < i14) {
                                                    int zzh12 = zzdu.zzh(bArr, zzh, zzdtVar4);
                                                    if (i34 == zzdtVar4.zza) {
                                                        zzh = zzdu.zzh(bArr, zzh12, zzdtVar4);
                                                        zzewVar4.zze(zzej.zzb(zzdtVar4.zza));
                                                    }
                                                }
                                            } else {
                                                i25 = i6;
                                                i26 = i50;
                                                i27 = i34;
                                                i41 = i54;
                                                i10 = i56;
                                                unsafe4 = unsafe10;
                                                i39 = i14;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            i25 = i6;
                                            i42 = zzh;
                                            i26 = i50;
                                            i27 = i34;
                                            i41 = i54;
                                            i10 = i56;
                                            unsafe4 = unsafe10;
                                            i39 = i14;
                                            if (i42 == i25) {
                                            }
                                            break;
                                        case 34:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                            if (i51 == 2) {
                                                zzfm zzfmVar5 = (zzfm) zzezVar;
                                                int zzh13 = zzdu.zzh(bArr, i6, zzdtVar4);
                                                int i79 = zzdtVar4.zza + zzh13;
                                                while (zzh13 < i79) {
                                                    zzh13 = zzdu.zzk(bArr, zzh13, zzdtVar4);
                                                    zzfmVar5.zze(zzej.zzc(zzdtVar4.zzb));
                                                }
                                                if (zzh13 != i79) {
                                                    throw zzfb.zzf();
                                                }
                                                i25 = i6;
                                                i42 = zzh13;
                                                i39 = i14;
                                                i26 = i50;
                                                i41 = i54;
                                                i27 = i55;
                                                i10 = i56;
                                                unsafe4 = unsafe10;
                                                if (i42 == i25) {
                                                }
                                            } else if (i51 == 0) {
                                                zzfm zzfmVar6 = (zzfm) zzezVar;
                                                zzh = zzdu.zzk(bArr, i6, zzdtVar4);
                                                zzfmVar6.zze(zzej.zzc(zzdtVar4.zzb));
                                                while (true) {
                                                    if (zzh < i14) {
                                                        int zzh14 = zzdu.zzh(bArr, zzh, zzdtVar4);
                                                        i34 = i55;
                                                        if (i34 == zzdtVar4.zza) {
                                                            zzh = zzdu.zzk(bArr, zzh14, zzdtVar4);
                                                            zzfmVar6.zze(zzej.zzc(zzdtVar4.zzb));
                                                            i55 = i34;
                                                        }
                                                    } else {
                                                        i34 = i55;
                                                    }
                                                }
                                                i25 = i6;
                                                i42 = zzh;
                                                i26 = i50;
                                                i27 = i34;
                                                i41 = i54;
                                                i10 = i56;
                                                unsafe4 = unsafe10;
                                                i39 = i14;
                                                if (i42 == i25) {
                                                }
                                            } else {
                                                i25 = i6;
                                                i39 = i14;
                                                i26 = i50;
                                                i41 = i54;
                                                i27 = i55;
                                                i10 = i56;
                                                unsafe4 = unsafe10;
                                                i42 = i25;
                                                if (i42 == i25) {
                                                }
                                            }
                                            break;
                                        default:
                                            i25 = i6;
                                            i39 = i14;
                                            i26 = i50;
                                            i41 = i54;
                                            i27 = i55;
                                            i10 = i56;
                                            unsafe4 = unsafe10;
                                            if (i51 == 3) {
                                                zzgi zzr = zzgaVar.zzr(i41);
                                                int i80 = (i27 & (-8)) | 4;
                                                i42 = zzdu.zzc(zzr, bArr, i25, i2, i80, zzdtVar);
                                                zzezVar.add(zzdtVar4.zzc);
                                                while (i42 < i39) {
                                                    int zzh15 = zzdu.zzh(bArr, i42, zzdtVar4);
                                                    if (i27 == zzdtVar4.zza) {
                                                        i42 = zzdu.zzc(zzr, bArr, zzh15, i2, i80, zzdtVar);
                                                        zzezVar.add(zzdtVar4.zzc);
                                                    } else if (i42 == i25) {
                                                    }
                                                }
                                                if (i42 == i25) {
                                                }
                                            }
                                            i42 = i25;
                                            if (i42 == i25) {
                                            }
                                            break;
                                    }
                                }
                            } else if (i51 == 2) {
                                zzez zzezVar3 = (zzez) unsafe6.getObject(obj4, j);
                                if (!zzezVar3.zzc()) {
                                    int size3 = zzezVar3.size();
                                    zzezVar3 = zzezVar3.zzd(size3 != 0 ? size3 + size3 : 10);
                                    unsafe6.putObject(obj4, j, zzezVar3);
                                }
                                zzez zzezVar4 = zzezVar3;
                                i46 = i50;
                                i42 = zzdu.zze(zzgaVar.zzr(i54), i55, bArr, i6, i2, zzezVar4, zzdtVar);
                                i40 = i3;
                                unsafe6 = unsafe6;
                                zzdtVar4 = zzdtVar4;
                                i43 = i54;
                                i39 = i14;
                                i41 = 0;
                                i44 = i55;
                                i45 = i56;
                                i47 = i11;
                            } else {
                                i21 = i50;
                                unsafe2 = unsafe6;
                                i22 = i55;
                                i10 = i56;
                                i23 = i6;
                                i24 = i54;
                                i4 = i3;
                                i41 = i24;
                                i12 = i21;
                                i44 = i22;
                                i9 = i23;
                            }
                        } else {
                            int i81 = iArr[i8 + 2];
                            int i82 = 1 << (i81 >>> 20);
                            int i83 = 1048575;
                            int i84 = i81 & 1048575;
                            if (i84 != i47) {
                                if (i47 != 1048575) {
                                    unsafe6.putInt(obj4, i47, i45);
                                    i83 = 1048575;
                                }
                                i10 = i84 == i83 ? 0 : unsafe6.getInt(obj4, i84);
                                i11 = i84;
                            } else {
                                i10 = i45;
                                i11 = i47;
                            }
                            switch (zzn) {
                                case 0:
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 1) {
                                        i14 = i2;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        zzhj.zzl(obj4, j, Double.longBitsToDouble(zzdu.zzn(bArr, i6)));
                                        i42 = i6 + 8;
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                case 1:
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 5) {
                                        i14 = i2;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        zzhj.zzm(obj4, j, Float.intBitsToFloat(zzdu.zzb(bArr, i6)));
                                        i42 = i6 + 4;
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                case 2:
                                case 3:
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 0) {
                                        i14 = i2;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        int zzk = zzdu.zzk(bArr, i6, zzdtVar4);
                                        unsafe6.putLong(obj, j, zzdtVar4.zzb);
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i42 = zzk;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                case 4:
                                case 11:
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 0) {
                                        i14 = i2;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        i42 = zzdu.zzh(bArr, i6, zzdtVar4);
                                        unsafe6.putInt(obj4, j, zzdtVar4.zza);
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                case 5:
                                case 14:
                                    i18 = i6;
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 1) {
                                        i14 = i2;
                                        i6 = i18;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        unsafe6.putLong(obj, j, zzdu.zzn(bArr, i18));
                                        i42 = i18 + 8;
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                case 6:
                                case 13:
                                    i18 = i6;
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 5) {
                                        i14 = i2;
                                        i6 = i18;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        unsafe6.putInt(obj4, j, zzdu.zzb(bArr, i18));
                                        i42 = i18 + 4;
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                case 7:
                                    i18 = i6;
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 0) {
                                        i14 = i2;
                                        i6 = i18;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        i42 = zzdu.zzk(bArr, i18, zzdtVar4);
                                        zzhj.zzk(obj4, j, zzdtVar4.zzb != 0);
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                case 8:
                                    int i85 = i6;
                                    i15 = i8;
                                    i16 = i53;
                                    if (i51 != 2) {
                                        i14 = i2;
                                        i6 = i85;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i13 = 0;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        if ((i52 & C.BUFFER_FLAG_LAST_SAMPLE) != 0) {
                                            i42 = zzdu.zzh(bArr, i85, zzdtVar4);
                                            int i86 = zzdtVar4.zza;
                                            if (i86 < 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i86 != 0) {
                                                int i87 = zzhn.zza;
                                                int length = bArr.length;
                                                if ((((length - i42) - i86) | i42 | i86) < 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i42), Integer.valueOf(i86)));
                                                }
                                                int i88 = i42 + i86;
                                                char[] cArr = new char[i86];
                                                int i89 = 0;
                                                while (i42 < i88) {
                                                    byte b = bArr[i42];
                                                    if (zzhk.zzd(b)) {
                                                        i42++;
                                                        cArr[i89] = (char) b;
                                                        i89++;
                                                    } else {
                                                        while (i42 < i88) {
                                                            int i90 = i42 + 1;
                                                            byte b2 = bArr[i42];
                                                            if (zzhk.zzd(b2)) {
                                                                cArr[i89] = (char) b2;
                                                                i89++;
                                                                i42 = i90;
                                                                while (i42 < i88) {
                                                                    byte b3 = bArr[i42];
                                                                    if (zzhk.zzd(b3)) {
                                                                        i42++;
                                                                        cArr[i89] = (char) b3;
                                                                        i89++;
                                                                    }
                                                                }
                                                            } else if (b2 < -32) {
                                                                if (i90 < i88) {
                                                                    i42 += 2;
                                                                    zzhk.zzc(b2, bArr[i90], cArr, i89);
                                                                    i89++;
                                                                } else {
                                                                    throw zzfb.zzb();
                                                                }
                                                            } else if (b2 < -16) {
                                                                if (i90 < i88 - 1) {
                                                                    int i91 = i42 + 2;
                                                                    i42 += 3;
                                                                    zzhk.zzb(b2, bArr[i90], bArr[i91], cArr, i89);
                                                                    i89++;
                                                                } else {
                                                                    throw zzfb.zzb();
                                                                }
                                                            } else if (i90 < i88 - 2) {
                                                                byte b4 = bArr[i90];
                                                                int i92 = i42 + 3;
                                                                byte b5 = bArr[i42 + 2];
                                                                i42 += 4;
                                                                zzhk.zza(b2, b4, b5, bArr[i92], cArr, i89);
                                                                i89 += 2;
                                                            } else {
                                                                throw zzfb.zzb();
                                                            }
                                                        }
                                                        i17 = 0;
                                                        zzdtVar4.zzc = new String(cArr, 0, i89);
                                                        i42 = i88;
                                                    }
                                                }
                                                while (i42 < i88) {
                                                }
                                                i17 = 0;
                                                zzdtVar4.zzc = new String(cArr, 0, i89);
                                                i42 = i88;
                                            } else {
                                                zzdtVar4.zzc = "";
                                                i17 = 0;
                                            }
                                        } else {
                                            i17 = 0;
                                            i42 = zzdu.zzh(bArr, i85, zzdtVar4);
                                            int i93 = zzdtVar4.zza;
                                            if (i93 < 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i93 != 0) {
                                                zzdtVar4.zzc = new String(bArr, i42, i93, zzfa.zzb);
                                                i42 += i93;
                                            } else {
                                                zzdtVar4.zzc = "";
                                            }
                                        }
                                        unsafe6.putObject(obj4, j, zzdtVar4.zzc);
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = i17;
                                    }
                                    break;
                                case 9:
                                    i15 = i8;
                                    i16 = i53;
                                    if (i51 != 2) {
                                        i14 = i2;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i13 = 0;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        Object zzt = zzgaVar.zzt(obj4, i15);
                                        i42 = zzdu.zzm(zzt, zzgaVar.zzr(i15), bArr, i6, i2, zzdtVar);
                                        zzgaVar.zzB(obj4, i15, zzt);
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = 0;
                                    }
                                case 10:
                                    i15 = i8;
                                    i16 = i53;
                                    if (i51 != 2) {
                                        i14 = i2;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i13 = 0;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        i42 = zzdu.zza(bArr, i6, zzdtVar4);
                                        unsafe6.putObject(obj4, j, zzdtVar4.zzc);
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = 0;
                                    }
                                case 12:
                                    i15 = i8;
                                    i16 = i53;
                                    if (i51 != 0) {
                                        i14 = i2;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i13 = 0;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        i42 = zzdu.zzh(bArr, i6, zzdtVar4);
                                        int i94 = zzdtVar4.zza;
                                        zzey zzq3 = zzgaVar.zzq(i15);
                                        if ((i52 & Integer.MIN_VALUE) == 0 || zzq3 == null || zzq3.zza()) {
                                            unsafe6.putInt(obj4, j, i94);
                                            i45 = i10 | i82;
                                            i39 = i2;
                                            i40 = i3;
                                            i44 = i16;
                                            i43 = i15;
                                            i46 = i50;
                                            i47 = i11;
                                            i41 = 0;
                                        } else {
                                            zzc(obj).zzh(i16, Long.valueOf(i94));
                                            i39 = i2;
                                            i40 = i3;
                                            i44 = i16;
                                            i43 = i15;
                                            i46 = i50;
                                            i45 = i10;
                                            i47 = i11;
                                            i41 = 0;
                                        }
                                    }
                                case 15:
                                    i15 = i8;
                                    i16 = i53;
                                    if (i51 != 0) {
                                        i14 = i2;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i13 = 0;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        i42 = zzdu.zzh(bArr, i6, zzdtVar4);
                                        unsafe6.putInt(obj4, j, zzej.zzb(zzdtVar4.zza));
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = 0;
                                    }
                                case 16:
                                    if (i51 != 0) {
                                        i14 = i2;
                                        i19 = i53;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i13 = 0;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        int zzk2 = zzdu.zzk(bArr, i6, zzdtVar4);
                                        i15 = i8;
                                        i16 = i53;
                                        unsafe6.putLong(obj, j, zzej.zzc(zzdtVar4.zzb));
                                        i45 = i10 | i82;
                                        i39 = i2;
                                        i40 = i3;
                                        i42 = zzk2;
                                        i44 = i16;
                                        i43 = i15;
                                        i46 = i50;
                                        i47 = i11;
                                        i41 = 0;
                                    }
                                default:
                                    i15 = i8;
                                    i16 = i53;
                                    i17 = 0;
                                    if (i51 != 3) {
                                        i14 = i2;
                                        i13 = i17;
                                        i19 = i16;
                                        i8 = i15;
                                        unsafe3 = unsafe6;
                                        i20 = i50;
                                        i4 = i3;
                                        i41 = i8;
                                        unsafe2 = unsafe3;
                                        i9 = i6;
                                        i12 = i20;
                                        i44 = i19;
                                        break;
                                    } else {
                                        Object zzt2 = zzgaVar.zzt(obj4, i15);
                                        i43 = i15;
                                        int zzl2 = zzdu.zzl(zzt2, zzgaVar.zzr(i15), bArr, i6, i2, (i50 << 3) | 4, zzdtVar);
                                        zzgaVar.zzB(obj4, i43, zzt2);
                                        i40 = i3;
                                        zzdtVar4 = zzdtVar4;
                                        unsafe6 = unsafe6;
                                        i39 = i2;
                                        i42 = zzl2;
                                        i41 = 0;
                                        i47 = i11;
                                        i45 = i10 | i82;
                                        i46 = i50;
                                        i44 = i16;
                                    }
                            }
                        }
                    } else {
                        i9 = i6;
                        i10 = i45;
                        i11 = i47;
                        i12 = i50;
                        i13 = i41;
                        unsafe2 = unsafe6;
                        i4 = i40;
                        i14 = i39;
                    }
                    if (i44 == i4 || i4 == 0) {
                        int i95 = i12;
                        i42 = zzdu.zzg(i44, bArr, i9, i2, zzc(obj), zzdtVar);
                        i39 = i14;
                        i43 = i41;
                        i46 = i95;
                        i44 = i44;
                        unsafe6 = unsafe2;
                        i41 = i13;
                        i45 = i10;
                        i47 = i11;
                        zzdtVar4 = zzdtVar;
                        i40 = i4;
                    } else {
                        i42 = i9;
                        i5 = i14;
                        i45 = i10;
                        unsafe = unsafe2;
                        i47 = i11;
                    }
                } else {
                    zzm = zzgaVar.zzm(i50, i41);
                }
                i8 = zzm;
                i7 = -1;
                if (i8 == i7) {
                }
                if (i44 == i4) {
                }
                int i952 = i12;
                i42 = zzdu.zzg(i44, bArr, i9, i2, zzc(obj), zzdtVar);
                i39 = i14;
                i43 = i41;
                i46 = i952;
                i44 = i44;
                unsafe6 = unsafe2;
                i41 = i13;
                i45 = i10;
                i47 = i11;
                zzdtVar4 = zzdtVar;
                i40 = i4;
            } else {
                i4 = i40;
                i5 = i39;
                unsafe = unsafe6;
            }
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object obj) {
        if (zzH(obj)) {
            if (obj instanceof zzev) {
                zzev zzevVar = (zzev) obj;
                zzevVar.zzl(Integer.MAX_VALUE);
                zzevVar.zza = 0;
                zzevVar.zzj();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzo = zzo(i);
                int i2 = 1048575 & zzo;
                int zzn = zzn(zzo);
                long j = i2;
                if (zzn != 9) {
                    if (zzn == 60 || zzn == 68) {
                        if (zzI(obj, this.zzc[i], i)) {
                            zzr(i).zze(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzn) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.zzk.zza(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfr) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                if (zzE(obj, i)) {
                    zzr(i).zze(zzb.getObject(obj, j));
                }
            }
            this.zzl.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzo = zzo(i);
            int i2 = this.zzc[i];
            long j = 1048575 & zzo;
            switch (zzn(zzo)) {
                case 0:
                    if (zzE(obj2, i)) {
                        zzhj.zzl(obj, j, zzhj.zza(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzE(obj2, i)) {
                        zzhj.zzm(obj, j, zzhj.zzb(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzE(obj2, i)) {
                        zzhj.zzk(obj, j, zzhj.zzt(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzx(obj, obj2, i);
                    break;
                case 10:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzx(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.zzk.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzgk.zza;
                    zzhj.zzp(obj, j, zzfs.zza(zzhj.zzf(obj, j), zzhj.zzf(obj2, j)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzy(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzy(obj, obj2, i);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        zzb(obj, bArr, i, i2, 0, zzdtVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzh(Object obj, Object obj2) {
        int i;
        boolean zzf;
        int length = this.zzc.length;
        for (0; i < length; i + 3) {
            int zzo = zzo(i);
            long j = zzo & 1048575;
            switch (zzn(zzo)) {
                case 0:
                    i = (zzD(obj, obj2, i) && Double.doubleToLongBits(zzhj.zza(obj, j)) == Double.doubleToLongBits(zzhj.zza(obj2, j))) ? i + 3 : 0;
                    return false;
                case 1:
                    if (zzD(obj, obj2, i) && Float.floatToIntBits(zzhj.zzb(obj, j)) == Float.floatToIntBits(zzhj.zzb(obj2, j))) {
                    }
                    return false;
                case 2:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                    }
                    return false;
                case 3:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                    }
                    return false;
                case 4:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                    }
                    return false;
                case 5:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                    }
                    return false;
                case 6:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                    }
                    return false;
                case 7:
                    if (zzD(obj, obj2, i) && zzhj.zzt(obj, j) == zzhj.zzt(obj2, j)) {
                    }
                    return false;
                case 8:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                    }
                    return false;
                case 9:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                    }
                    return false;
                case 10:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                    }
                    return false;
                case 11:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                    }
                    return false;
                case 12:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                    }
                    return false;
                case 13:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                    }
                    return false;
                case 14:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                    }
                    return false;
                case 15:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                    }
                    return false;
                case 16:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                    }
                    return false;
                case 17:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    if (zzf) {
                        return false;
                    }
                case 50:
                    zzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    if (zzf) {
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                case 68:
                    long zzl = zzl(i) & 1048575;
                    if (zzhj.zzc(obj, zzl) == zzhj.zzc(obj2, zzl) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                    }
                    return false;
                default:
            }
        }
        return this.zzl.zzb(obj).equals(this.zzl.zzb(obj2));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzi) {
            int i6 = this.zzh[i4];
            int i7 = this.zzc[i6];
            int zzo = zzo(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zzb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & zzo) != 0 && !zzF(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzn = zzn(zzo);
            if (zzn != 9 && zzn != 17) {
                if (zzn != 27) {
                    if (zzn == 60 || zzn == 68) {
                        if (zzI(obj, i7, i6) && !zzG(obj, zzo, zzr(i6))) {
                            return false;
                        }
                    } else if (zzn != 49) {
                        if (zzn == 50 && !((zzfr) zzhj.zzf(obj, zzo & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhj.zzf(obj, zzo & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgi zzr = zzr(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzr.zzi(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzF(obj, i6, i, i2, i10) && !zzG(obj, zzo, zzr(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return true;
    }
}
