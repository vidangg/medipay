package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.media3.common.C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznk<T> implements zzns<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzol.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznh zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoe zzl;
    private final zzlq zzm;

    private zznk(int[] iArr, Object[] objArr, int i, int i2, zznh zznhVar, boolean z, int[] iArr2, int i3, int i4, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzlqVar != null && (zznhVar instanceof zzma)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzoeVar;
        this.zzm = zzlqVar;
        this.zzg = zznhVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzns zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzns zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzol.zzq(obj, j, (1 << (zzp >>> 20)) | zzol.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzol.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzol.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzol.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzol.zzb(obj, j2)) != 0;
            case 2:
                return zzol.zzd(obj, j2) != 0;
            case 3:
                return zzol.zzd(obj, j2) != 0;
            case 4:
                return zzol.zzc(obj, j2) != 0;
            case 5:
                return zzol.zzd(obj, j2) != 0;
            case 6:
                return zzol.zzc(obj, j2) != 0;
            case 7:
                return zzol.zzw(obj, j2);
            case 8:
                Object zzf = zzol.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzld) {
                    return !zzld.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzol.zzf(obj, j2) != null;
            case 10:
                return !zzld.zzb.equals(zzol.zzf(obj, j2));
            case 11:
                return zzol.zzc(obj, j2) != 0;
            case 12:
                return zzol.zzc(obj, j2) != 0;
            case 13:
                return zzol.zzc(obj, j2) != 0;
            case 14:
                return zzol.zzd(obj, j2) != 0;
            case 15:
                return zzol.zzc(obj, j2) != 0;
            case 16:
                return zzol.zzd(obj, j2) != 0;
            case 17:
                return zzol.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzns zznsVar) {
        return zznsVar.zzk(zzol.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmd) {
            return ((zzmd) obj).zzcw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzol.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzol.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzor zzorVar) throws IOException {
        if (obj instanceof String) {
            zzorVar.zzG(i, (String) obj);
        } else {
            zzorVar.zzd(i, (zzld) obj);
        }
    }

    static zzof zzd(Object obj) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        if (zzofVar != zzof.zzc()) {
            return zzofVar;
        }
        zzof zzf = zzof.zzf();
        zzmdVar.zzc = zzf;
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zznk zzl(Class cls, zzne zzneVar, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        int i;
        int charAt;
        int charAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
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
        zznr zznrVar;
        String str;
        int objectFieldOffset;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Field zzz;
        int i25;
        char charAt11;
        int i26;
        int i27;
        int i28;
        int i29;
        Object obj;
        Field zzz2;
        Object obj2;
        Field zzz3;
        int i30;
        char charAt12;
        int i31;
        char charAt13;
        int i32;
        char charAt14;
        int i33;
        char charAt15;
        if (zzneVar instanceof zznr) {
            zznr zznrVar2 = (zznr) zzneVar;
            String zzd = zznrVar2.zzd();
            int length = zzd.length();
            char c = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i34 = 1;
                while (true) {
                    i = i34 + 1;
                    if (zzd.charAt(i34) < 55296) {
                        break;
                    }
                    i34 = i;
                }
            } else {
                i = 1;
            }
            int i35 = i + 1;
            int charAt16 = zzd.charAt(i);
            if (charAt16 >= 55296) {
                int i36 = charAt16 & 8191;
                int i37 = 13;
                while (true) {
                    i33 = i35 + 1;
                    charAt15 = zzd.charAt(i35);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i36 |= (charAt15 & 8191) << i37;
                    i37 += 13;
                    i35 = i33;
                }
                charAt16 = i36 | (charAt15 << i37);
                i35 = i33;
            }
            if (charAt16 == 0) {
                i4 = 0;
                charAt = 0;
                charAt2 = 0;
                i2 = 0;
                i5 = 0;
                i3 = 0;
                iArr = zza;
                i6 = 0;
            } else {
                int i38 = i35 + 1;
                int charAt17 = zzd.charAt(i35);
                if (charAt17 >= 55296) {
                    int i39 = charAt17 & 8191;
                    int i40 = 13;
                    while (true) {
                        i14 = i38 + 1;
                        charAt10 = zzd.charAt(i38);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i39 |= (charAt10 & 8191) << i40;
                        i40 += 13;
                        i38 = i14;
                    }
                    charAt17 = i39 | (charAt10 << i40);
                    i38 = i14;
                }
                int i41 = i38 + 1;
                int charAt18 = zzd.charAt(i38);
                if (charAt18 >= 55296) {
                    int i42 = charAt18 & 8191;
                    int i43 = 13;
                    while (true) {
                        i13 = i41 + 1;
                        charAt9 = zzd.charAt(i41);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i42 |= (charAt9 & 8191) << i43;
                        i43 += 13;
                        i41 = i13;
                    }
                    charAt18 = i42 | (charAt9 << i43);
                    i41 = i13;
                }
                int i44 = i41 + 1;
                int charAt19 = zzd.charAt(i41);
                if (charAt19 >= 55296) {
                    int i45 = charAt19 & 8191;
                    int i46 = 13;
                    while (true) {
                        i12 = i44 + 1;
                        charAt8 = zzd.charAt(i44);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i45 |= (charAt8 & 8191) << i46;
                        i46 += 13;
                        i44 = i12;
                    }
                    charAt19 = i45 | (charAt8 << i46);
                    i44 = i12;
                }
                int i47 = i44 + 1;
                int charAt20 = zzd.charAt(i44);
                if (charAt20 >= 55296) {
                    int i48 = charAt20 & 8191;
                    int i49 = 13;
                    while (true) {
                        i11 = i47 + 1;
                        charAt7 = zzd.charAt(i47);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i48 |= (charAt7 & 8191) << i49;
                        i49 += 13;
                        i47 = i11;
                    }
                    charAt20 = i48 | (charAt7 << i49);
                    i47 = i11;
                }
                int i50 = i47 + 1;
                charAt = zzd.charAt(i47);
                if (charAt >= 55296) {
                    int i51 = charAt & 8191;
                    int i52 = 13;
                    while (true) {
                        i10 = i50 + 1;
                        charAt6 = zzd.charAt(i50);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i51 |= (charAt6 & 8191) << i52;
                        i52 += 13;
                        i50 = i10;
                    }
                    charAt = i51 | (charAt6 << i52);
                    i50 = i10;
                }
                int i53 = i50 + 1;
                charAt2 = zzd.charAt(i50);
                if (charAt2 >= 55296) {
                    int i54 = charAt2 & 8191;
                    int i55 = 13;
                    while (true) {
                        i9 = i53 + 1;
                        charAt5 = zzd.charAt(i53);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i54 |= (charAt5 & 8191) << i55;
                        i55 += 13;
                        i53 = i9;
                    }
                    charAt2 = i54 | (charAt5 << i55);
                    i53 = i9;
                }
                int i56 = i53 + 1;
                int charAt21 = zzd.charAt(i53);
                if (charAt21 >= 55296) {
                    int i57 = charAt21 & 8191;
                    int i58 = 13;
                    while (true) {
                        i8 = i56 + 1;
                        charAt4 = zzd.charAt(i56);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i57 |= (charAt4 & 8191) << i58;
                        i58 += 13;
                        i56 = i8;
                    }
                    charAt21 = i57 | (charAt4 << i58);
                    i56 = i8;
                }
                int i59 = i56 + 1;
                int charAt22 = zzd.charAt(i56);
                if (charAt22 >= 55296) {
                    int i60 = charAt22 & 8191;
                    int i61 = 13;
                    while (true) {
                        i7 = i59 + 1;
                        charAt3 = zzd.charAt(i59);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i60 |= (charAt3 & 8191) << i61;
                        i61 += 13;
                        i59 = i7;
                    }
                    charAt22 = i60 | (charAt3 << i61);
                    i59 = i7;
                }
                int i62 = charAt17 + charAt17 + charAt18;
                int[] iArr2 = new int[charAt22 + charAt2 + charAt21];
                i2 = charAt19;
                i3 = charAt22;
                i4 = i62;
                iArr = iArr2;
                i5 = charAt20;
                i6 = charAt17;
                i35 = i59;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zznrVar2.zze();
            Class<?> cls2 = zznrVar2.zza().getClass();
            int i63 = i3 + charAt2;
            int i64 = charAt + charAt;
            int[] iArr3 = new int[charAt * 3];
            Object[] objArr = new Object[i64];
            int i65 = i3;
            int i66 = i63;
            int i67 = 0;
            int i68 = 0;
            while (i35 < length) {
                int i69 = i35 + 1;
                int charAt23 = zzd.charAt(i35);
                if (charAt23 >= c) {
                    int i70 = charAt23 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i32 = i71 + 1;
                        charAt14 = zzd.charAt(i71);
                        if (charAt14 < c) {
                            break;
                        }
                        i70 |= (charAt14 & 8191) << i72;
                        i72 += 13;
                        i71 = i32;
                    }
                    charAt23 = i70 | (charAt14 << i72);
                    i15 = i32;
                } else {
                    i15 = i69;
                }
                int i73 = i15 + 1;
                int charAt24 = zzd.charAt(i15);
                if (charAt24 >= c) {
                    int i74 = charAt24 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i31 = i75 + 1;
                        charAt13 = zzd.charAt(i75);
                        if (charAt13 < c) {
                            break;
                        }
                        i74 |= (charAt13 & 8191) << i76;
                        i76 += 13;
                        i75 = i31;
                    }
                    charAt24 = i74 | (charAt13 << i76);
                    i16 = i31;
                } else {
                    i16 = i73;
                }
                if ((charAt24 & 1024) != 0) {
                    iArr[i67] = i68;
                    i67++;
                }
                int i77 = charAt24 & 255;
                int i78 = length;
                int i79 = charAt24 & 2048;
                int i80 = i5;
                if (i77 >= 51) {
                    int i81 = i16 + 1;
                    int charAt25 = zzd.charAt(i16);
                    if (charAt25 >= 55296) {
                        int i82 = charAt25 & 8191;
                        int i83 = i81;
                        int i84 = 13;
                        while (true) {
                            i30 = i83 + 1;
                            charAt12 = zzd.charAt(i83);
                            i17 = i2;
                            if (charAt12 < 55296) {
                                break;
                            }
                            i82 |= (charAt12 & 8191) << i84;
                            i84 += 13;
                            i83 = i30;
                            i2 = i17;
                        }
                        charAt25 = i82 | (charAt12 << i84);
                        i28 = i30;
                    } else {
                        i17 = i2;
                        i28 = i81;
                    }
                    int i85 = i77 - 51;
                    int i86 = i28;
                    if (i85 == 9 || i85 == 17) {
                        i29 = i4 + 1;
                        int i87 = i68 / 3;
                        objArr[i87 + i87 + 1] = zze[i4];
                    } else {
                        if (i85 == 12) {
                            if (zznrVar2.zzc() == 1 || i79 != 0) {
                                i29 = i4 + 1;
                                int i88 = i68 / 3;
                                objArr[i88 + i88 + 1] = zze[i4];
                            } else {
                                i79 = 0;
                            }
                        }
                        int i89 = charAt25 + charAt25;
                        obj = zze[i89];
                        if (!(obj instanceof Field)) {
                            zzz2 = (Field) obj;
                        } else {
                            zzz2 = zzz(cls2, (String) obj);
                            zze[i89] = zzz2;
                        }
                        int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzz2);
                        int i90 = i89 + 1;
                        obj2 = zze[i90];
                        int i91 = i79;
                        if (!(obj2 instanceof Field)) {
                            zzz3 = (Field) obj2;
                        } else {
                            zzz3 = zzz(cls2, (String) obj2);
                            zze[i90] = zzz3;
                        }
                        i18 = i4;
                        i22 = i86;
                        i19 = charAt23;
                        i20 = (int) unsafe.objectFieldOffset(zzz3);
                        i23 = 0;
                        str = zzd;
                        zznrVar = zznrVar2;
                        objectFieldOffset = objectFieldOffset2;
                        i24 = i91;
                    }
                    i4 = i29;
                    int i892 = charAt25 + charAt25;
                    obj = zze[i892];
                    if (!(obj instanceof Field)) {
                    }
                    int objectFieldOffset22 = (int) unsafe.objectFieldOffset(zzz2);
                    int i902 = i892 + 1;
                    obj2 = zze[i902];
                    int i912 = i79;
                    if (!(obj2 instanceof Field)) {
                    }
                    i18 = i4;
                    i22 = i86;
                    i19 = charAt23;
                    i20 = (int) unsafe.objectFieldOffset(zzz3);
                    i23 = 0;
                    str = zzd;
                    zznrVar = zznrVar2;
                    objectFieldOffset = objectFieldOffset22;
                    i24 = i912;
                } else {
                    i17 = i2;
                    i18 = i4 + 1;
                    Field zzz4 = zzz(cls2, (String) zze[i4]);
                    i19 = charAt23;
                    if (i77 == 9 || i77 == 17) {
                        zznrVar = zznrVar2;
                        int i92 = i68 / 3;
                        objArr[i92 + i92 + 1] = zzz4.getType();
                    } else {
                        if (i77 == 27) {
                            zznrVar = zznrVar2;
                            i26 = 1;
                            i27 = i4 + 2;
                        } else if (i77 == 49) {
                            i27 = i4 + 2;
                            zznrVar = zznrVar2;
                            i26 = 1;
                        } else {
                            if (i77 == 12 || i77 == 30 || i77 == 44) {
                                zznrVar = zznrVar2;
                                if (zznrVar2.zzc() == 1 || i79 != 0) {
                                    i27 = i4 + 2;
                                    int i93 = i68 / 3;
                                    objArr[i93 + i93 + 1] = zze[i18];
                                    str = zzd;
                                    i18 = i27;
                                } else {
                                    str = zzd;
                                    i79 = 0;
                                }
                            } else if (i77 == 50) {
                                int i94 = i4 + 2;
                                int i95 = i65 + 1;
                                iArr[i65] = i68;
                                int i96 = i68 / 3;
                                int i97 = i96 + i96;
                                objArr[i97] = zze[i18];
                                if (i79 != 0) {
                                    i18 = i4 + 3;
                                    objArr[i97 + 1] = zze[i94];
                                    str = zzd;
                                    i65 = i95;
                                    zznrVar = zznrVar2;
                                } else {
                                    i18 = i94;
                                    i65 = i95;
                                    i79 = 0;
                                    zznrVar = zznrVar2;
                                }
                            } else {
                                zznrVar = zznrVar2;
                            }
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                            i20 = 1048575;
                            if ((charAt24 & 4096) != 0 || i77 > 17) {
                                i21 = i79;
                                i22 = i16;
                                i23 = 0;
                            } else {
                                int i98 = i16 + 1;
                                int charAt26 = str.charAt(i16);
                                if (charAt26 >= 55296) {
                                    int i99 = charAt26 & 8191;
                                    int i100 = 13;
                                    while (true) {
                                        i25 = i98 + 1;
                                        charAt11 = str.charAt(i98);
                                        if (charAt11 < 55296) {
                                            break;
                                        }
                                        i99 |= (charAt11 & 8191) << i100;
                                        i100 += 13;
                                        i98 = i25;
                                    }
                                    charAt26 = i99 | (charAt11 << i100);
                                    i98 = i25;
                                }
                                int i101 = i6 + i6 + (charAt26 / 32);
                                Object obj3 = zze[i101];
                                i22 = i98;
                                if (obj3 instanceof Field) {
                                    zzz = (Field) obj3;
                                } else {
                                    zzz = zzz(cls2, (String) obj3);
                                    zze[i101] = zzz;
                                }
                                i21 = i79;
                                i23 = charAt26 % 32;
                                i20 = (int) unsafe.objectFieldOffset(zzz);
                            }
                            if (i77 >= 18 && i77 <= 49) {
                                iArr[i66] = objectFieldOffset;
                                i66++;
                            }
                            i24 = i21;
                        }
                        int i102 = i68 / 3;
                        objArr[i102 + i102 + i26] = zze[i18];
                        str = zzd;
                        i18 = i27;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                        i20 = 1048575;
                        if ((charAt24 & 4096) != 0) {
                        }
                        i21 = i79;
                        i22 = i16;
                        i23 = 0;
                        if (i77 >= 18) {
                            iArr[i66] = objectFieldOffset;
                            i66++;
                        }
                        i24 = i21;
                    }
                    str = zzd;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                    i20 = 1048575;
                    if ((charAt24 & 4096) != 0) {
                    }
                    i21 = i79;
                    i22 = i16;
                    i23 = 0;
                    if (i77 >= 18) {
                    }
                    i24 = i21;
                }
                int i103 = i68 + 1;
                iArr3[i68] = i19;
                int i104 = i68 + 2;
                Class<?> cls3 = cls2;
                iArr3[i103] = objectFieldOffset | (i24 != 0 ? Integer.MIN_VALUE : 0) | ((charAt24 & 512) != 0 ? C.BUFFER_FLAG_LAST_SAMPLE : 0) | ((charAt24 & 256) != 0 ? 268435456 : 0) | (i77 << 20);
                i68 += 3;
                iArr3[i104] = (i23 << 20) | i20;
                zzd = str;
                i4 = i18;
                length = i78;
                i5 = i80;
                cls2 = cls3;
                zznrVar2 = zznrVar;
                i35 = i22;
                i2 = i17;
                c = 55296;
            }
            return new zznk(iArr3, objArr, i2, i5, zznrVar2.zza(), false, iArr, i3, i63, zznmVar, zzmuVar, zzoeVar, zzlqVar, zzncVar);
        }
        throw null;
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzol.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzol.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzol.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzol.zzf(obj, j)).longValue();
    }

    private final zzmg zzu(int i) {
        int i2 = i / 3;
        return (zzmg) this.zzd[i2 + i2 + 1];
    }

    private final zzns zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzns zznsVar = (zzns) objArr[i3];
        if (zznsVar != null) {
            return zznsVar;
        }
        zzns zzb2 = zznp.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzns zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzns zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0054. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v263, types: [int] */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v163 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v40, types: [int] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zza(Object obj) {
        int i;
        int i2;
        ?? r5;
        int zzz;
        int zzz2;
        int zzz3;
        int zzA;
        int zzz4;
        int zzz5;
        int zzd;
        int zzz6;
        ?? zzg;
        int size;
        int zzz7;
        int zzy;
        int zzy2;
        ?? r3;
        int zzx;
        ?? r1;
        ?? r0;
        int zze;
        int zzz8;
        int zzz9;
        ?? r4;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i3 = 1048575;
        ?? r12 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (true) {
            int[] iArr = this.zzc;
            if (i4 < iArr.length) {
                int zzs = zzs(i4);
                int zzr = zzr(zzs);
                int i7 = iArr[i4];
                int i8 = iArr[i4 + 2];
                int i9 = i8 & i3;
                if (zzr <= 17) {
                    if (i9 != i6) {
                        r12 = i9 == i3 ? z : unsafe.getInt(obj, i9);
                        i6 = i9;
                    }
                    i = i6;
                    i2 = r12;
                    r5 = 1 << (i8 >>> 20);
                } else {
                    i = i6;
                    i2 = r12;
                    r5 = z;
                }
                int i10 = zzs & i3;
                if (zzr >= zzlv.DOUBLE_LIST_PACKED.zza()) {
                    zzlv.SINT64_LIST_PACKED.zza();
                }
                long j = i10;
                switch (zzr) {
                    case 0:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzz = zzlk.zzz(i7 << 3);
                            r0 = zzz + 8;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 1:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzz2 = zzlk.zzz(i7 << 3);
                            r0 = zzz2 + 4;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 2:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            long j2 = unsafe.getLong(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(j2);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 3:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            long j3 = unsafe.getLong(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(j3);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 4:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            long j4 = unsafe.getInt(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(j4);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 5:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzz = zzlk.zzz(i7 << 3);
                            r0 = zzz + 8;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 6:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzz2 = zzlk.zzz(i7 << 3);
                            r0 = zzz2 + 4;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 7:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzz4 = zzlk.zzz(i7 << 3);
                            r0 = zzz4 + 1;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 8:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            int i11 = i7 << 3;
                            Object object = unsafe.getObject(obj, j);
                            if (object instanceof zzld) {
                                zzz5 = zzlk.zzz(i11);
                                zzd = ((zzld) object).zzd();
                                zzz6 = zzlk.zzz(zzd);
                                r0 = zzz5 + zzz6 + zzd;
                                i5 += r0;
                                i4 += 3;
                                i6 = i;
                                r12 = i2;
                                z = false;
                                i3 = 1048575;
                            } else {
                                zzz3 = zzlk.zzz(i11);
                                zzA = zzlk.zzy((String) object);
                                r0 = zzz3 + zzA;
                                i5 += r0;
                                i4 += 3;
                                i6 = i;
                                r12 = i2;
                                z = false;
                                i3 = 1048575;
                            }
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 9:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            r0 = zznu.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 10:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzld zzldVar = (zzld) unsafe.getObject(obj, j);
                            zzz5 = zzlk.zzz(i7 << 3);
                            zzd = zzldVar.zzd();
                            zzz6 = zzlk.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 11:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            int i12 = unsafe.getInt(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzz(i12);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 12:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            long j5 = unsafe.getInt(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(j5);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 13:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzz2 = zzlk.zzz(i7 << 3);
                            r0 = zzz2 + 4;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 14:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            zzz = zzlk.zzz(i7 << 3);
                            r0 = zzz + 8;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 15:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            int i13 = unsafe.getInt(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzz((i13 >> 31) ^ (i13 + i13));
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 16:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            long j6 = unsafe.getLong(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA((j6 >> 63) ^ (j6 + j6));
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 17:
                        if (zzJ(obj, i4, i, i2, r5)) {
                            r0 = zzlk.zzw(i7, (zznh) unsafe.getObject(obj, j), zzv(i4));
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 18:
                        r0 = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 19:
                        r0 = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 20:
                        List list = (List) unsafe.getObject(obj, j);
                        int i14 = zznu.zza;
                        if (list.size() != 0) {
                            zzg = zznu.zzg(list) + (list.size() * zzlk.zzz(i7 << 3));
                            i5 += zzg;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        zzg = z;
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj, j);
                        int i15 = zznu.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzz3 = zznu.zzl(list2);
                            zzz7 = zzlk.zzz(i7 << 3);
                            zzA = size * zzz7;
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        r0 = z;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj, j);
                        int i16 = zznu.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzz3 = zznu.zzf(list3);
                            zzz7 = zzlk.zzz(i7 << 3);
                            zzA = size * zzz7;
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        r0 = z;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 23:
                        r0 = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 24:
                        r0 = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 25:
                        List list4 = (List) unsafe.getObject(obj, j);
                        int i17 = zznu.zza;
                        int size2 = list4.size();
                        if (size2 != 0) {
                            r0 = size2 * (zzlk.zzz(i7 << 3) + 1);
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        r0 = z;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 26:
                        ?? r02 = (List) unsafe.getObject(obj, j);
                        int i18 = zznu.zza;
                        int size3 = r02.size();
                        if (size3 != 0) {
                            int zzz10 = zzlk.zzz(i7 << 3) * size3;
                            if (r02 instanceof zzmt) {
                                zzmt zzmtVar = (zzmt) r02;
                                zzg = zzz10;
                                for (?? r32 = z; r32 < size3; r32++) {
                                    Object zzc = zzmtVar.zzc();
                                    if (zzc instanceof zzld) {
                                        int zzd2 = ((zzld) zzc).zzd();
                                        zzy2 = zzg + zzlk.zzz(zzd2) + zzd2;
                                    } else {
                                        zzy2 = zzg + zzlk.zzy((String) zzc);
                                    }
                                    zzg = zzy2;
                                }
                            } else {
                                zzg = zzz10;
                                for (?? r33 = z; r33 < size3; r33++) {
                                    Object obj2 = r02.get(r33);
                                    if (obj2 instanceof zzld) {
                                        int zzd3 = ((zzld) obj2).zzd();
                                        zzy = zzg + zzlk.zzz(zzd3) + zzd3;
                                    } else {
                                        zzy = zzg + zzlk.zzy((String) obj2);
                                    }
                                    zzg = zzy;
                                }
                            }
                            i5 += zzg;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        zzg = z;
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 27:
                        ?? r03 = (List) unsafe.getObject(obj, j);
                        zzns zzv = zzv(i4);
                        int i19 = zznu.zza;
                        int size4 = r03.size();
                        if (size4 == 0) {
                            r3 = z;
                        } else {
                            r3 = zzlk.zzz(i7 << 3) * size4;
                            for (?? r42 = z; r42 < size4; r42++) {
                                Object obj3 = r03.get(r42);
                                if (obj3 instanceof zzms) {
                                    int zza2 = ((zzms) obj3).zza();
                                    zzx = (r3 == true ? 1 : 0) + zzlk.zzz(zza2) + zza2;
                                } else {
                                    zzx = (r3 == true ? 1 : 0) + zzlk.zzx((zznh) obj3, zzv);
                                }
                                r3 = zzx;
                            }
                        }
                        i5 += r3;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 28:
                        ?? r04 = (List) unsafe.getObject(obj, j);
                        int i20 = zznu.zza;
                        int size5 = r04.size();
                        if (size5 == 0) {
                            r1 = z;
                        } else {
                            r1 = size5 * zzlk.zzz(i7 << 3);
                            for (?? r2 = z; r2 < r04.size(); r2++) {
                                int zzd4 = ((zzld) r04.get(r2)).zzd();
                                r1 += zzlk.zzz(zzd4) + zzd4;
                            }
                        }
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 29:
                        List list5 = (List) unsafe.getObject(obj, j);
                        int i21 = zznu.zza;
                        size = list5.size();
                        if (size != 0) {
                            zzz3 = zznu.zzk(list5);
                            zzz7 = zzlk.zzz(i7 << 3);
                            zzA = size * zzz7;
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        r0 = z;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 30:
                        List list6 = (List) unsafe.getObject(obj, j);
                        int i22 = zznu.zza;
                        size = list6.size();
                        if (size != 0) {
                            zzz3 = zznu.zza(list6);
                            zzz7 = zzlk.zzz(i7 << 3);
                            zzA = size * zzz7;
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        r0 = z;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 31:
                        r0 = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 32:
                        r0 = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 33:
                        List list7 = (List) unsafe.getObject(obj, j);
                        int i23 = zznu.zza;
                        size = list7.size();
                        if (size != 0) {
                            zzz3 = zznu.zzi(list7);
                            zzz7 = zzlk.zzz(i7 << 3);
                            zzA = size * zzz7;
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        r0 = z;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 34:
                        List list8 = (List) unsafe.getObject(obj, j);
                        int i24 = zznu.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzz3 = zznu.zzj(list8);
                            zzz7 = zzlk.zzz(i7 << 3);
                            zzA = size * zzz7;
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                        r0 = z;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 35:
                        zze = zznu.zze((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 36:
                        zze = zznu.zzc((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 37:
                        zze = zznu.zzg((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 38:
                        zze = zznu.zzl((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 39:
                        zze = zznu.zzf((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 40:
                        zze = zznu.zze((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 41:
                        zze = zznu.zzc((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 42:
                        List list9 = (List) unsafe.getObject(obj, j);
                        int i25 = zznu.zza;
                        zze = list9.size();
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 43:
                        zze = zznu.zzk((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 44:
                        zze = zznu.zza((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 45:
                        zze = zznu.zzc((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 46:
                        zze = zznu.zze((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 47:
                        zze = zznu.zzi((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        zze = zznu.zzj((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzz8 = zzlk.zzz(i7 << 3);
                            zzz9 = zzlk.zzz(zze);
                            r1 = zzz8 + zzz9 + zze;
                            i5 += r1;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        ?? r05 = (List) unsafe.getObject(obj, j);
                        zzns zzv2 = zzv(i4);
                        int i26 = zznu.zza;
                        int size6 = r05.size();
                        if (size6 == 0) {
                            r4 = z;
                        } else {
                            boolean z2 = z;
                            r4 = z2;
                            ?? r34 = z2;
                            while (r34 < size6) {
                                int zzw = zzlk.zzw(i7, (zznh) r05.get(r34), zzv2);
                                r34++;
                                r4 = (r4 == true ? 1 : 0) + zzw;
                            }
                        }
                        i5 += r4;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case 50:
                        zznb zznbVar = (zznb) unsafe.getObject(obj, j);
                        if (zznbVar.isEmpty()) {
                            continue;
                        } else {
                            Iterator it = zznbVar.entrySet().iterator();
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                entry.getKey();
                                entry.getValue();
                                throw null;
                            }
                        }
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzM(obj, i7, i4)) {
                            zzz = zzlk.zzz(i7 << 3);
                            r0 = zzz + 8;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (zzM(obj, i7, i4)) {
                            zzz2 = zzlk.zzz(i7 << 3);
                            r0 = zzz2 + 4;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zzM(obj, i7, i4)) {
                            long zzt = zzt(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(zzt);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zzM(obj, i7, i4)) {
                            long zzt2 = zzt(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(zzt2);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zzM(obj, i7, i4)) {
                            long zzo = zzo(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(zzo);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 56:
                        if (zzM(obj, i7, i4)) {
                            zzz = zzlk.zzz(i7 << 3);
                            r0 = zzz + 8;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 57:
                        if (zzM(obj, i7, i4)) {
                            zzz2 = zzlk.zzz(i7 << 3);
                            r0 = zzz2 + 4;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 58:
                        if (zzM(obj, i7, i4)) {
                            zzz4 = zzlk.zzz(i7 << 3);
                            r0 = zzz4 + 1;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 59:
                        if (zzM(obj, i7, i4)) {
                            int i27 = i7 << 3;
                            Object object2 = unsafe.getObject(obj, j);
                            if (object2 instanceof zzld) {
                                zzz5 = zzlk.zzz(i27);
                                zzd = ((zzld) object2).zzd();
                                zzz6 = zzlk.zzz(zzd);
                                r0 = zzz5 + zzz6 + zzd;
                                i5 += r0;
                                i4 += 3;
                                i6 = i;
                                r12 = i2;
                                z = false;
                                i3 = 1048575;
                            } else {
                                zzz3 = zzlk.zzz(i27);
                                zzA = zzlk.zzy((String) object2);
                                r0 = zzz3 + zzA;
                                i5 += r0;
                                i4 += 3;
                                i6 = i;
                                r12 = i2;
                                z = false;
                                i3 = 1048575;
                            }
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        if (zzM(obj, i7, i4)) {
                            r0 = zznu.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zzM(obj, i7, i4)) {
                            zzld zzldVar2 = (zzld) unsafe.getObject(obj, j);
                            zzz5 = zzlk.zzz(i7 << 3);
                            zzd = zzldVar2.zzd();
                            zzz6 = zzlk.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 62:
                        if (zzM(obj, i7, i4)) {
                            int zzo2 = zzo(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzz(zzo2);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        if (zzM(obj, i7, i4)) {
                            long zzo3 = zzo(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA(zzo3);
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 64:
                        if (zzM(obj, i7, i4)) {
                            zzz2 = zzlk.zzz(i7 << 3);
                            r0 = zzz2 + 4;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 65:
                        if (zzM(obj, i7, i4)) {
                            zzz = zzlk.zzz(i7 << 3);
                            r0 = zzz + 8;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zzM(obj, i7, i4)) {
                            int zzo4 = zzo(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzz((zzo4 >> 31) ^ (zzo4 + zzo4));
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 67:
                        if (zzM(obj, i7, i4)) {
                            long zzt3 = zzt(obj, j);
                            zzz3 = zzlk.zzz(i7 << 3);
                            zzA = zzlk.zzA((zzt3 >> 63) ^ (zzt3 + zzt3));
                            r0 = zzz3 + zzA;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    case 68:
                        if (zzM(obj, i7, i4)) {
                            r0 = zzlk.zzw(i7, (zznh) unsafe.getObject(obj, j), zzv(i4));
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    default:
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                }
            } else {
                int zza3 = i5 + ((zzmd) obj).zzc.zza();
                if (!this.zzh) {
                    return zza3;
                }
                zzoa zzoaVar = ((zzma) obj).zzb.zza;
                int zzc2 = zzoaVar.zzc();
                int i28 = 0;
                for (int i29 = 0; i29 < zzc2; i29++) {
                    Map.Entry zzg2 = zzoaVar.zzg(i29);
                    i28 += zzlu.zzb((zzlt) ((zznw) zzg2).zza(), zzg2.getValue());
                }
                for (Map.Entry entry2 : zzoaVar.zzd()) {
                    i28 += zzlu.zzb((zzlt) entry2.getKey(), entry2.getValue());
                }
                return zza3 + i28;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 < iArr.length) {
                int zzs = zzs(i3);
                int i5 = 1048575 & zzs;
                int zzr = zzr(zzs);
                int i6 = iArr[i3];
                long j = i5;
                int i7 = 37;
                switch (zzr) {
                    case 0:
                        i = i4 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzol.zza(obj, j));
                        byte[] bArr = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 1:
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzol.zzb(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 2:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr2 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 3:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr3 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 4:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 5:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr4 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 6:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 7:
                        i = i4 * 53;
                        floatToIntBits = zzmk.zza(zzol.zzw(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 8:
                        i = i4 * 53;
                        floatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 9:
                        i2 = i4 * 53;
                        Object zzf = zzol.zzf(obj, j);
                        if (zzf != null) {
                            i7 = zzf.hashCode();
                        }
                        i4 = i2 + i7;
                        break;
                    case 10:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 11:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 12:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 13:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 14:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr5 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 15:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 16:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr6 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 17:
                        i2 = i4 * 53;
                        Object zzf2 = zzol.zzf(obj, j);
                        if (zzf2 != null) {
                            i7 = zzf2.hashCode();
                        }
                        i4 = i2 + i7;
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
                        i = i4 * 53;
                        floatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 50:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                            byte[] bArr7 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr8 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr9 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 56:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr10 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 57:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 58:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzmk.zza(zzN(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 59:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzol.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzol.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 62:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 64:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 65:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr11 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 67:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr12 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 68:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzol.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                }
                i3 += 3;
            } else {
                int hashCode = (i4 * 53) + ((zzmd) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzma) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0ddd, code lost:
    
        if (r6 == r12) goto L580;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0ddf, code lost:
    
        r11.putInt(r8, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0de3, code lost:
    
        r0 = r7.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0de7, code lost:
    
        if (r0 >= r7.zzk) goto L700;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0de9, code lost:
    
        r2 = r7.zzi;
        r3 = r7.zzc;
        r2 = r2[r0];
        r3 = r3[r2];
        r3 = com.google.android.gms.internal.measurement.zzol.zzf(r8, r7.zzs(r2) & r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0dfb, code lost:
    
        if (r3 != null) goto L586;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0e02, code lost:
    
        if (r7.zzu(r2) != null) goto L699;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0e0b, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zznb) r3;
        r0 = (com.google.android.gms.internal.measurement.zzna) r7.zzw(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0e13, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0e04, code lost:
    
        r2 = (com.google.android.gms.internal.measurement.zzof) null;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0e16, code lost:
    
        if (r9 != 0) goto L598;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0e1a, code lost:
    
        if (r1 != r44) goto L596;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0e22, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzmm("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0e29, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0e25, code lost:
    
        if (r1 > r44) goto L602;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0e27, code lost:
    
        if (r4 != r9) goto L602;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0e2f, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzmm("Failed to parse the message.");
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:473:0x0b2a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:573:0x00bf. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:91:0x049b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0ab2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0ac3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0d52 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0d65 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:639:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0d80  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzks zzksVar) throws IOException {
        Object obj2;
        int i4;
        int i5;
        zznk<T> zznkVar;
        int i6;
        int i7;
        int i8;
        int i9;
        int zzq;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Unsafe unsafe;
        zzks zzksVar2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Unsafe unsafe2;
        zzks zzksVar3;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        zzks zzksVar4;
        Unsafe unsafe3;
        int i28;
        int i29;
        int i30;
        int zzk;
        int i31;
        int zza2;
        int zzh;
        String str;
        zzmj zzmjVar;
        zzks zzksVar5;
        Unsafe unsafe4;
        int i32;
        int i33;
        zznk<T> zznkVar2;
        int zzh2;
        zzks zzksVar6;
        int i34;
        zznk<T> zznkVar3;
        int zzf;
        Object obj3;
        int i35;
        int i36;
        int i37;
        Unsafe unsafe5;
        int zzj;
        int i38;
        int i39;
        int zzh3;
        zznk<T> zznkVar4 = this;
        Object obj4 = obj;
        int i40 = i2;
        int i41 = i3;
        zzks zzksVar7 = zzksVar;
        zzA(obj);
        Unsafe unsafe6 = zzb;
        int i42 = 0;
        int i43 = i;
        int i44 = 0;
        int i45 = 0;
        int i46 = 0;
        int i47 = -1;
        int i48 = 1048575;
        while (true) {
            if (i43 < i40) {
                int i49 = i43 + 1;
                int i50 = bArr[i43];
                if (i50 < 0) {
                    i7 = zzkt.zzi(i50, bArr, i49, zzksVar7);
                    i6 = zzksVar7.zza;
                } else {
                    i6 = i50;
                    i7 = i49;
                }
                int i51 = i6 >>> 3;
                if (i51 > i47) {
                    zzq = (i51 < zznkVar4.zze || i51 > zznkVar4.zzf) ? -1 : zznkVar4.zzq(i51, i44 / 3);
                } else if (i51 < zznkVar4.zze || i51 > zznkVar4.zzf) {
                    i8 = -1;
                    i9 = -1;
                    if (i9 != i8) {
                        i10 = i7;
                        i11 = i46;
                        i12 = i48;
                        i13 = i51;
                        i14 = i42;
                        unsafe = unsafe6;
                        i4 = i41;
                        obj2 = obj4;
                        zzksVar2 = zzksVar7;
                        zznkVar = zznkVar4;
                        i15 = i14;
                        i16 = i6;
                    } else {
                        int i52 = i6 & 7;
                        int[] iArr = zznkVar4.zzc;
                        int i53 = iArr[i9 + 1];
                        int i54 = i6;
                        int zzr = zzr(i53);
                        long j = i53 & 1048575;
                        String str2 = "Protocol message had invalid UTF-8.";
                        if (zzr <= 17) {
                            int i55 = iArr[i9 + 2];
                            int i56 = 1 << (i55 >>> 20);
                            int i57 = i55 & 1048575;
                            if (i57 != i48) {
                                if (i48 != 1048575) {
                                    unsafe6.putInt(obj4, i48, i46);
                                }
                                i46 = i57 == 1048575 ? 0 : unsafe6.getInt(obj4, i57);
                                i12 = i57;
                            } else {
                                i12 = i48;
                            }
                            switch (zzr) {
                                case 0:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 1) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i43 = i18 + 8;
                                        i46 |= i56;
                                        zzol.zzo(obj4, j, Double.longBitsToDouble(zzkt.zzn(bArr, i18)));
                                        i41 = i3;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                case 1:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 5) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i43 = i18 + 4;
                                        i46 |= i56;
                                        zzol.zzp(obj4, j, Float.intBitsToFloat(zzkt.zzb(bArr, i18)));
                                        i41 = i3;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                case 2:
                                case 3:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 0) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        int i58 = i46 | i56;
                                        int zzk2 = zzkt.zzk(bArr, i18, zzksVar7);
                                        unsafe6.putLong(obj, j, zzksVar7.zzb);
                                        i41 = i3;
                                        i46 = i58;
                                        i43 = zzk2;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                case 4:
                                case 11:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 0) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i46 |= i56;
                                        i43 = zzkt.zzh(bArr, i18, zzksVar7);
                                        unsafe6.putInt(obj4, j, zzksVar7.zza);
                                        i41 = i3;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                case 5:
                                case 14:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 1) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        unsafe6.putLong(obj, j, zzkt.zzn(bArr, i18));
                                        i41 = i3;
                                        i43 = i18 + 8;
                                        i46 = i56 | i46;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                case 6:
                                case 13:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 5) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i43 = i18 + 4;
                                        i46 |= i56;
                                        unsafe6.putInt(obj4, j, zzkt.zzb(bArr, i18));
                                        i41 = i3;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                case 7:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 0) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i46 |= i56;
                                        i43 = zzkt.zzk(bArr, i18, zzksVar7);
                                        zzol.zzm(obj4, j, zzksVar7.zzb != 0);
                                        i41 = i3;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                case 8:
                                    int i59 = i7;
                                    i19 = i9;
                                    int i60 = i54;
                                    if (i52 != 2) {
                                        i20 = i46;
                                        i21 = i59;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i54 = i60;
                                        i22 = i19;
                                        i23 = i51;
                                        i14 = 0;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        if ((i53 & C.BUFFER_FLAG_LAST_SAMPLE) == 0) {
                                            i54 = i60;
                                            i42 = 0;
                                            i43 = zzkt.zzh(bArr, i59, zzksVar7);
                                            int i61 = zzksVar7.zza;
                                            if (i61 < 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i46 |= i56;
                                            if (i61 != 0) {
                                                zzksVar7.zzc = new String(bArr, i43, i61, zzmk.zza);
                                                i43 += i61;
                                            } else {
                                                zzksVar7.zzc = "";
                                            }
                                        } else {
                                            i43 = zzkt.zzh(bArr, i59, zzksVar7);
                                            int i62 = zzksVar7.zza;
                                            if (i62 < 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            int i63 = i46 | i56;
                                            if (i62 != 0) {
                                                int i64 = zzoo.zza;
                                                int length = bArr.length;
                                                if ((((length - i43) - i62) | i43 | i62) < 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i43), Integer.valueOf(i62)));
                                                }
                                                int i65 = i43 + i62;
                                                char[] cArr = new char[i62];
                                                int i66 = 0;
                                                while (i43 < i65) {
                                                    byte b = bArr[i43];
                                                    if (zzom.zzd(b)) {
                                                        i43++;
                                                        cArr[i66] = (char) b;
                                                        i66++;
                                                    } else {
                                                        while (i43 < i65) {
                                                            int i67 = i43 + 1;
                                                            byte b2 = bArr[i43];
                                                            if (zzom.zzd(b2)) {
                                                                cArr[i66] = (char) b2;
                                                                i66++;
                                                                i43 = i67;
                                                                while (i43 < i65) {
                                                                    byte b3 = bArr[i43];
                                                                    if (zzom.zzd(b3)) {
                                                                        i43++;
                                                                        cArr[i66] = (char) b3;
                                                                        i66++;
                                                                    }
                                                                }
                                                            } else {
                                                                int i68 = i63;
                                                                if (b2 >= -32) {
                                                                    int i69 = i60;
                                                                    String str3 = str2;
                                                                    if (b2 < -16) {
                                                                        if (i67 < i65 - 1) {
                                                                            zzom.zzb(b2, bArr[i67], bArr[i43 + 2], cArr, i66);
                                                                            str2 = str3;
                                                                            i66++;
                                                                            i63 = i68;
                                                                            i60 = i69;
                                                                            i43 += 3;
                                                                        } else {
                                                                            throw new zzmm(str3);
                                                                        }
                                                                    } else if (i67 < i65 - 2) {
                                                                        byte b4 = bArr[i67];
                                                                        int i70 = i43 + 3;
                                                                        byte b5 = bArr[i43 + 2];
                                                                        i43 += 4;
                                                                        zzom.zza(b2, b4, b5, bArr[i70], cArr, i66);
                                                                        i66 += 2;
                                                                        str2 = str3;
                                                                        i63 = i68;
                                                                        i60 = i69;
                                                                    } else {
                                                                        throw new zzmm(str3);
                                                                    }
                                                                } else if (i67 < i65) {
                                                                    i43 += 2;
                                                                    zzom.zzc(b2, bArr[i67], cArr, i66);
                                                                    i66++;
                                                                    i63 = i68;
                                                                } else {
                                                                    throw new zzmm(str2);
                                                                }
                                                            }
                                                        }
                                                        i24 = i63;
                                                        i54 = i60;
                                                        i42 = 0;
                                                        zzksVar7.zzc = new String(cArr, 0, i66);
                                                        i43 = i65;
                                                    }
                                                }
                                                while (i43 < i65) {
                                                }
                                                i24 = i63;
                                                i54 = i60;
                                                i42 = 0;
                                                zzksVar7.zzc = new String(cArr, 0, i66);
                                                i43 = i65;
                                            } else {
                                                zzksVar7.zzc = "";
                                                i24 = i63;
                                                i54 = i60;
                                                i42 = 0;
                                            }
                                            i46 = i24;
                                        }
                                        unsafe6.putObject(obj4, j, zzksVar7.zzc);
                                        i41 = i3;
                                        i44 = i19;
                                        i48 = i12;
                                        i45 = i54;
                                        i47 = i51;
                                        i40 = i2;
                                    }
                                    break;
                                case 9:
                                    i25 = i9;
                                    i26 = i54;
                                    if (i52 != 2) {
                                        i21 = i7;
                                        i20 = i46;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i54 = i26;
                                        i22 = i25;
                                        i23 = i51;
                                        i14 = 0;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        int i71 = i46 | i56;
                                        Object zzx = zznkVar4.zzx(obj4, i25);
                                        i43 = zzkt.zzm(zzx, zznkVar4.zzv(i25), bArr, i7, i2, zzksVar);
                                        zznkVar4.zzF(obj4, i25, zzx);
                                        i46 = i71;
                                        i45 = i26;
                                        i44 = i25;
                                        i48 = i12;
                                        i47 = i51;
                                        i42 = 0;
                                        i40 = i2;
                                        i41 = i3;
                                    }
                                case 10:
                                    i25 = i9;
                                    i26 = i54;
                                    if (i52 != 2) {
                                        i21 = i7;
                                        i20 = i46;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i54 = i26;
                                        i22 = i25;
                                        i23 = i51;
                                        i14 = 0;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i46 |= i56;
                                        i43 = zzkt.zza(bArr, i7, zzksVar7);
                                        unsafe6.putObject(obj4, j, zzksVar7.zzc);
                                        i45 = i26;
                                        i44 = i25;
                                        i48 = i12;
                                        i47 = i51;
                                        i42 = 0;
                                        i40 = i2;
                                        i41 = i3;
                                    }
                                case 12:
                                    i25 = i9;
                                    i26 = i54;
                                    if (i52 != 0) {
                                        i21 = i7;
                                        i20 = i46;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i54 = i26;
                                        i22 = i25;
                                        i23 = i51;
                                        i14 = 0;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i43 = zzkt.zzh(bArr, i7, zzksVar7);
                                        int i72 = zzksVar7.zza;
                                        zzmg zzu = zznkVar4.zzu(i25);
                                        if ((i53 & Integer.MIN_VALUE) == 0 || zzu == null || zzu.zza(i72)) {
                                            i46 |= i56;
                                            unsafe6.putInt(obj4, j, i72);
                                        } else {
                                            zzd(obj).zzj(i26, Long.valueOf(i72));
                                        }
                                        i45 = i26;
                                        i44 = i25;
                                        i48 = i12;
                                        i47 = i51;
                                        i42 = 0;
                                        i40 = i2;
                                        i41 = i3;
                                    }
                                case 15:
                                    i25 = i9;
                                    i26 = i54;
                                    if (i52 != 0) {
                                        i21 = i7;
                                        i20 = i46;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i54 = i26;
                                        i22 = i25;
                                        i23 = i51;
                                        i14 = 0;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        i46 |= i56;
                                        i43 = zzkt.zzh(bArr, i7, zzksVar7);
                                        unsafe6.putInt(obj4, j, zzlg.zzb(zzksVar7.zza));
                                        i45 = i26;
                                        i44 = i25;
                                        i48 = i12;
                                        i47 = i51;
                                        i42 = 0;
                                        i40 = i2;
                                        i41 = i3;
                                    }
                                case 16:
                                    if (i52 != 0) {
                                        i21 = i7;
                                        i20 = i46;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i14 = 0;
                                        i22 = i9;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        int i73 = i46 | i56;
                                        int zzk3 = zzkt.zzk(bArr, i7, zzksVar7);
                                        i25 = i9;
                                        i26 = i54;
                                        unsafe6.putLong(obj, j, zzlg.zzc(zzksVar7.zzb));
                                        i46 = i73;
                                        i43 = zzk3;
                                        i45 = i26;
                                        i44 = i25;
                                        i48 = i12;
                                        i47 = i51;
                                        i42 = 0;
                                        i40 = i2;
                                        i41 = i3;
                                    }
                                default:
                                    i18 = i7;
                                    i19 = i9;
                                    i42 = 0;
                                    if (i52 != 3) {
                                        i20 = i46;
                                        i21 = i18;
                                        i14 = i42;
                                        unsafe2 = unsafe6;
                                        zzksVar3 = zzksVar7;
                                        i22 = i19;
                                        i23 = i51;
                                        zzksVar2 = zzksVar3;
                                        unsafe = unsafe2;
                                        i11 = i20;
                                        i16 = i54;
                                        obj2 = obj4;
                                        zznkVar = zznkVar4;
                                        i15 = i22;
                                        i13 = i23;
                                        i10 = i21;
                                        i4 = i3;
                                        break;
                                    } else {
                                        Object zzx2 = zznkVar4.zzx(obj4, i19);
                                        int zzl = zzkt.zzl(zzx2, zznkVar4.zzv(i19), bArr, i18, i2, (i51 << 3) | 4, zzksVar);
                                        zznkVar4.zzF(obj4, i19, zzx2);
                                        i41 = i3;
                                        zzksVar7 = zzksVar;
                                        i47 = i51;
                                        unsafe6 = unsafe6;
                                        i44 = i19;
                                        i40 = i2;
                                        i43 = zzl;
                                        i48 = i12;
                                        i45 = i54;
                                        i42 = 0;
                                        i46 |= i56;
                                    }
                            }
                        } else {
                            i12 = i48;
                            int i74 = i51;
                            i14 = 0;
                            i11 = i46;
                            int i75 = i9;
                            zzks zzksVar8 = zzksVar7;
                            int i76 = i7;
                            Unsafe unsafe7 = unsafe6;
                            if (zzr != 27) {
                                if (zzr > 49) {
                                    zznkVar = zznkVar4;
                                    i15 = i75;
                                    i27 = i54;
                                    i13 = i74;
                                    zzksVar4 = zzksVar8;
                                    if (zzr != 50) {
                                        obj2 = obj;
                                        long j2 = iArr[i15 + 2] & 1048575;
                                        switch (zzr) {
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 1) {
                                                    i43 = i29 + 8;
                                                    unsafe.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzkt.zzn(bArr, i29))));
                                                    unsafe.putInt(obj2, j2, i13);
                                                    if (i43 != i29) {
                                                        i4 = i3;
                                                        i10 = i43;
                                                        i15 = i28;
                                                        i16 = i30;
                                                        break;
                                                    } else {
                                                        i40 = i2;
                                                        i47 = i13;
                                                        unsafe6 = unsafe;
                                                        zznkVar4 = zznkVar;
                                                        obj4 = obj2;
                                                        zzksVar7 = zzksVar2;
                                                        i48 = i12;
                                                        i42 = 0;
                                                        i46 = i11;
                                                        i44 = i28;
                                                        i45 = i30;
                                                        break;
                                                    }
                                                }
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 5) {
                                                    i43 = i29 + 4;
                                                    unsafe.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzkt.zzb(bArr, i29))));
                                                    unsafe.putInt(obj2, j2, i13);
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 0) {
                                                    zzk = zzkt.zzk(bArr, i29, zzksVar2);
                                                    unsafe.putObject(obj2, j, Long.valueOf(zzksVar2.zzb));
                                                    unsafe.putInt(obj2, j2, i13);
                                                    i43 = zzk;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                            case 62:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 0) {
                                                    zzk = zzkt.zzh(bArr, i29, zzksVar2);
                                                    unsafe.putObject(obj2, j, Integer.valueOf(zzksVar2.zza));
                                                    unsafe.putInt(obj2, j2, i13);
                                                    i43 = zzk;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 1) {
                                                    i43 = i29 + 8;
                                                    unsafe.putObject(obj2, j, Long.valueOf(zzkt.zzn(bArr, i29)));
                                                    unsafe.putInt(obj2, j2, i13);
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 5) {
                                                    i43 = i29 + 4;
                                                    unsafe.putObject(obj2, j, Integer.valueOf(zzkt.zzb(bArr, i29)));
                                                    unsafe.putInt(obj2, j2, i13);
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case 58:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 0) {
                                                    zzk = zzkt.zzk(bArr, i29, zzksVar2);
                                                    unsafe.putObject(obj2, j, Boolean.valueOf(zzksVar2.zzb != 0));
                                                    unsafe.putInt(obj2, j2, i13);
                                                    i43 = zzk;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case 59:
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                if (i52 == 2) {
                                                    i43 = zzkt.zzh(bArr, i29, zzksVar2);
                                                    int i77 = zzksVar2.zza;
                                                    if (i77 == 0) {
                                                        unsafe.putObject(obj2, j, "");
                                                        i28 = i15;
                                                    } else {
                                                        int i78 = i43 + i77;
                                                        if ((i53 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zzoo.zzd(bArr, i43, i78)) {
                                                            i28 = i15;
                                                            unsafe.putObject(obj2, j, new String(bArr, i43, i77, zzmk.zza));
                                                            i43 = i78;
                                                        } else {
                                                            throw new zzmm(str2);
                                                        }
                                                    }
                                                    unsafe.putInt(obj2, j2, i13);
                                                    if (i43 != i29) {
                                                    }
                                                } else {
                                                    i28 = i15;
                                                    i43 = i29;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                if (i52 == 2) {
                                                    Object zzy = zznkVar.zzy(obj2, i13, i15);
                                                    i29 = i76;
                                                    i30 = i27;
                                                    zzksVar2 = zzksVar4;
                                                    i43 = zzkt.zzm(zzy, zznkVar.zzv(i15), bArr, i29, i2, zzksVar);
                                                    zznkVar.zzG(obj2, i13, i15, zzy);
                                                    i28 = i15;
                                                    unsafe = unsafe7;
                                                    i13 = i13;
                                                    if (i43 != i29) {
                                                    }
                                                } else {
                                                    i29 = i76;
                                                    i30 = i27;
                                                    zzksVar2 = zzksVar4;
                                                    i28 = i15;
                                                    unsafe = unsafe7;
                                                    i43 = i29;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                i31 = i76;
                                                if (i52 == 2) {
                                                    zza2 = zzkt.zza(bArr, i31, zzksVar4);
                                                    unsafe7.putObject(obj2, j, zzksVar4.zzc);
                                                    unsafe7.putInt(obj2, j2, i13);
                                                    i28 = i15;
                                                    i29 = i31;
                                                    i43 = zza2;
                                                    i30 = i27;
                                                    zzksVar2 = zzksVar4;
                                                    unsafe = unsafe7;
                                                    if (i43 != i29) {
                                                    }
                                                } else {
                                                    i28 = i15;
                                                    i29 = i31;
                                                    i30 = i27;
                                                    zzksVar2 = zzksVar4;
                                                    unsafe = unsafe7;
                                                    i43 = i29;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                break;
                                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                i31 = i76;
                                                i30 = i27;
                                                if (i52 == 0) {
                                                    zza2 = zzkt.zzh(bArr, i31, zzksVar4);
                                                    int i79 = zzksVar4.zza;
                                                    zzmg zzu2 = zznkVar.zzu(i15);
                                                    if (zzu2 == null || zzu2.zza(i79)) {
                                                        i27 = i30;
                                                        unsafe7.putObject(obj2, j, Integer.valueOf(i79));
                                                        unsafe7.putInt(obj2, j2, i13);
                                                    } else {
                                                        i27 = i30;
                                                        zzd(obj).zzj(i27, Long.valueOf(i79));
                                                    }
                                                    i28 = i15;
                                                    i29 = i31;
                                                    i43 = zza2;
                                                    i30 = i27;
                                                    zzksVar2 = zzksVar4;
                                                    unsafe = unsafe7;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i28 = i15;
                                                i29 = i31;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                i31 = i76;
                                                i30 = i27;
                                                if (i52 == 0) {
                                                    zzh = zzkt.zzh(bArr, i31, zzksVar4);
                                                    unsafe7.putObject(obj2, j, Integer.valueOf(zzlg.zzb(zzksVar4.zza)));
                                                    unsafe7.putInt(obj2, j2, i13);
                                                    i28 = i15;
                                                    i29 = i31;
                                                    i43 = zzh;
                                                    zzksVar2 = zzksVar4;
                                                    unsafe = unsafe7;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i28 = i15;
                                                i29 = i31;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case 67:
                                                i31 = i76;
                                                i30 = i27;
                                                if (i52 == 0) {
                                                    zzh = zzkt.zzk(bArr, i31, zzksVar4);
                                                    unsafe7.putObject(obj2, j, Long.valueOf(zzlg.zzc(zzksVar4.zzb)));
                                                    unsafe7.putInt(obj2, j2, i13);
                                                    i28 = i15;
                                                    i29 = i31;
                                                    i43 = zzh;
                                                    zzksVar2 = zzksVar4;
                                                    unsafe = unsafe7;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                i28 = i15;
                                                i29 = i31;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                            case 68:
                                                if (i52 == 3) {
                                                    Object zzy2 = zznkVar.zzy(obj2, i13, i15);
                                                    i30 = i27;
                                                    int zzl2 = zzkt.zzl(zzy2, zznkVar.zzv(i15), bArr, i76, i2, (i27 & (-8)) | 4, zzksVar);
                                                    zznkVar.zzG(obj2, i13, i15, zzy2);
                                                    i28 = i15;
                                                    i29 = i76;
                                                    zzksVar2 = zzksVar4;
                                                    i43 = zzl2;
                                                    obj2 = obj2;
                                                    unsafe = unsafe7;
                                                    if (i43 != i29) {
                                                    }
                                                }
                                                break;
                                            default:
                                                i28 = i15;
                                                i29 = i76;
                                                i30 = i27;
                                                zzksVar2 = zzksVar4;
                                                unsafe = unsafe7;
                                                i43 = i29;
                                                if (i43 != i29) {
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i52 == 2) {
                                            Object zzw = zznkVar.zzw(i15);
                                            Object object = unsafe7.getObject(obj, j);
                                            if (!((zznb) object).zze()) {
                                                zznb zzb2 = zznb.zza().zzb();
                                                zznc.zza(zzb2, object);
                                                unsafe7.putObject(obj, j, zzb2);
                                            }
                                            throw null;
                                        }
                                        obj2 = obj;
                                        unsafe3 = unsafe7;
                                    }
                                } else {
                                    long j3 = i53;
                                    zzmj zzmjVar2 = (zzmj) unsafe7.getObject(obj4, j);
                                    if (zzmjVar2.zzc()) {
                                        str = str2;
                                        zzmjVar = zzmjVar2;
                                    } else {
                                        int size = zzmjVar2.size();
                                        str = str2;
                                        zzmj zzd = zzmjVar2.zzd(size + size);
                                        unsafe7.putObject(obj4, j, zzd);
                                        zzmjVar = zzd;
                                    }
                                    switch (zzr) {
                                        case 18:
                                        case 35:
                                            zzksVar5 = zzksVar8;
                                            zzmj zzmjVar3 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i32 = i54;
                                            i33 = i74;
                                            zznkVar2 = zznkVar4;
                                            i40 = i2;
                                            i15 = i75;
                                            if (i52 == 2) {
                                                int i80 = zzkt.zza;
                                                zzlm zzlmVar = (zzlm) zzmjVar3;
                                                zzh2 = zzkt.zzh(bArr, i76, zzksVar5);
                                                int i81 = zzksVar5.zza;
                                                int i82 = zzh2 + i81;
                                                if (i82 <= bArr.length) {
                                                    zzlmVar.zzg(zzlmVar.size() + (i81 / 8));
                                                    while (zzh2 < i82) {
                                                        zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, zzh2)));
                                                        zzh2 += 8;
                                                    }
                                                    if (zzh2 != i82) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    i43 = zzh2;
                                                    if (i43 == i76) {
                                                        obj2 = obj;
                                                        i10 = i43;
                                                        i13 = i33;
                                                        zznkVar = zznkVar2;
                                                        i16 = i32;
                                                        unsafe = unsafe4;
                                                        zzksVar2 = zzksVar5;
                                                        i4 = i3;
                                                        break;
                                                    } else {
                                                        obj4 = obj;
                                                        i44 = i15;
                                                        zzksVar7 = zzksVar5;
                                                        i47 = i33;
                                                        zznkVar4 = zznkVar2;
                                                        i45 = i32;
                                                        i48 = i12;
                                                        i42 = 0;
                                                        i46 = i11;
                                                        unsafe6 = unsafe4;
                                                        break;
                                                    }
                                                } else {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i52 == 1) {
                                                    i43 = i76 + 8;
                                                    int i83 = zzkt.zza;
                                                    zzlm zzlmVar2 = (zzlm) zzmjVar3;
                                                    zzlmVar2.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, i76)));
                                                    while (i43 < i40) {
                                                        int zzh4 = zzkt.zzh(bArr, i43, zzksVar5);
                                                        if (i32 == zzksVar5.zza) {
                                                            zzlmVar2.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, zzh4)));
                                                            i43 = zzh4 + 8;
                                                        } else if (i43 == i76) {
                                                        }
                                                    }
                                                    if (i43 == i76) {
                                                    }
                                                }
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                        case 19:
                                        case 36:
                                            zzksVar5 = zzksVar8;
                                            zzmj zzmjVar4 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i32 = i54;
                                            i33 = i74;
                                            zznkVar2 = zznkVar4;
                                            i40 = i2;
                                            i15 = i75;
                                            if (i52 == 2) {
                                                int i84 = zzkt.zza;
                                                zzlw zzlwVar = (zzlw) zzmjVar4;
                                                zzh2 = zzkt.zzh(bArr, i76, zzksVar5);
                                                int i85 = zzksVar5.zza;
                                                int i86 = zzh2 + i85;
                                                if (i86 <= bArr.length) {
                                                    zzlwVar.zzg(zzlwVar.size() + (i85 / 4));
                                                    while (zzh2 < i86) {
                                                        zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, zzh2)));
                                                        zzh2 += 4;
                                                    }
                                                    if (zzh2 != i86) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    i43 = zzh2;
                                                    if (i43 == i76) {
                                                    }
                                                } else {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i52 == 5) {
                                                    i43 = i76 + 4;
                                                    int i87 = zzkt.zza;
                                                    zzlw zzlwVar2 = (zzlw) zzmjVar4;
                                                    zzlwVar2.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, i76)));
                                                    while (i43 < i40) {
                                                        int zzh5 = zzkt.zzh(bArr, i43, zzksVar5);
                                                        if (i32 == zzksVar5.zza) {
                                                            zzlwVar2.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, zzh5)));
                                                            i43 = zzh5 + 4;
                                                        } else if (i43 == i76) {
                                                        }
                                                    }
                                                    if (i43 == i76) {
                                                    }
                                                }
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            zzksVar5 = zzksVar8;
                                            zzmj zzmjVar5 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i32 = i54;
                                            i33 = i74;
                                            zznkVar2 = zznkVar4;
                                            i40 = i2;
                                            i15 = i75;
                                            if (i52 == 2) {
                                                int i88 = zzkt.zza;
                                                zzmw zzmwVar = (zzmw) zzmjVar5;
                                                zzh2 = zzkt.zzh(bArr, i76, zzksVar5);
                                                int i89 = zzksVar5.zza + zzh2;
                                                while (zzh2 < i89) {
                                                    zzh2 = zzkt.zzk(bArr, zzh2, zzksVar5);
                                                    zzmwVar.zzg(zzksVar5.zzb);
                                                }
                                                if (zzh2 != i89) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i52 == 0) {
                                                    int i90 = zzkt.zza;
                                                    zzmw zzmwVar2 = (zzmw) zzmjVar5;
                                                    zzh2 = zzkt.zzk(bArr, i76, zzksVar5);
                                                    zzmwVar2.zzg(zzksVar5.zzb);
                                                    while (zzh2 < i40) {
                                                        int zzh6 = zzkt.zzh(bArr, zzh2, zzksVar5);
                                                        if (i32 == zzksVar5.zza) {
                                                            zzh2 = zzkt.zzk(bArr, zzh6, zzksVar5);
                                                            zzmwVar2.zzg(zzksVar5.zzb);
                                                        }
                                                    }
                                                }
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            i43 = zzh2;
                                            if (i43 == i76) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            zzksVar6 = zzksVar8;
                                            zzmj zzmjVar6 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i34 = i54;
                                            i40 = i2;
                                            zznkVar3 = zznkVar4;
                                            i15 = i75;
                                            if (i52 == 2) {
                                                zzf = zzkt.zzf(bArr, i76, zzmjVar6, zzksVar6);
                                                i32 = i34;
                                                i43 = zzf;
                                                zzksVar5 = zzksVar6;
                                                zznkVar2 = zznkVar3;
                                                i33 = i74;
                                                if (i43 == i76) {
                                                }
                                            } else {
                                                if (i52 == 0) {
                                                    i32 = i34;
                                                    zzksVar5 = zzksVar6;
                                                    i33 = i74;
                                                    zznkVar2 = zznkVar3;
                                                    i43 = zzkt.zzj(i34, bArr, i76, i2, zzmjVar6, zzksVar);
                                                    if (i43 == i76) {
                                                    }
                                                }
                                                i32 = i34;
                                                zzksVar5 = zzksVar6;
                                                zznkVar2 = zznkVar3;
                                                i33 = i74;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            zzksVar6 = zzksVar8;
                                            zzmj zzmjVar7 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i34 = i54;
                                            i40 = i2;
                                            zznkVar3 = zznkVar4;
                                            i15 = i75;
                                            if (i52 == 2) {
                                                int i91 = zzkt.zza;
                                                zzmw zzmwVar3 = (zzmw) zzmjVar7;
                                                zzf = zzkt.zzh(bArr, i76, zzksVar6);
                                                int i92 = zzksVar6.zza;
                                                int i93 = zzf + i92;
                                                if (i93 <= bArr.length) {
                                                    zzmwVar3.zzh(zzmwVar3.size() + (i92 / 8));
                                                    while (zzf < i93) {
                                                        zzmwVar3.zzg(zzkt.zzn(bArr, zzf));
                                                        zzf += 8;
                                                    }
                                                    if (zzf != i93) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                } else {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i52 == 1) {
                                                    zzf = i76 + 8;
                                                    int i94 = zzkt.zza;
                                                    zzmw zzmwVar4 = (zzmw) zzmjVar7;
                                                    zzmwVar4.zzg(zzkt.zzn(bArr, i76));
                                                    while (zzf < i40) {
                                                        int zzh7 = zzkt.zzh(bArr, zzf, zzksVar6);
                                                        if (i34 == zzksVar6.zza) {
                                                            zzmwVar4.zzg(zzkt.zzn(bArr, zzh7));
                                                            zzf = zzh7 + 8;
                                                        }
                                                    }
                                                }
                                                i32 = i34;
                                                zzksVar5 = zzksVar6;
                                                zznkVar2 = zznkVar3;
                                                i33 = i74;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            i32 = i34;
                                            i43 = zzf;
                                            zzksVar5 = zzksVar6;
                                            zznkVar2 = zznkVar3;
                                            i33 = i74;
                                            if (i43 == i76) {
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            zzksVar6 = zzksVar8;
                                            zzmj zzmjVar8 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i34 = i54;
                                            i40 = i2;
                                            zznkVar3 = zznkVar4;
                                            i15 = i75;
                                            if (i52 == 2) {
                                                int i95 = zzkt.zza;
                                                zzme zzmeVar = (zzme) zzmjVar8;
                                                zzf = zzkt.zzh(bArr, i76, zzksVar6);
                                                int i96 = zzksVar6.zza;
                                                int i97 = zzf + i96;
                                                if (i97 <= bArr.length) {
                                                    zzmeVar.zzi(zzmeVar.size() + (i96 / 4));
                                                    while (zzf < i97) {
                                                        zzmeVar.zzh(zzkt.zzb(bArr, zzf));
                                                        zzf += 4;
                                                    }
                                                    if (zzf != i97) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                } else {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i52 == 5) {
                                                    zzf = i76 + 4;
                                                    int i98 = zzkt.zza;
                                                    zzme zzmeVar2 = (zzme) zzmjVar8;
                                                    zzmeVar2.zzh(zzkt.zzb(bArr, i76));
                                                    while (zzf < i40) {
                                                        int zzh8 = zzkt.zzh(bArr, zzf, zzksVar6);
                                                        if (i34 == zzksVar6.zza) {
                                                            zzmeVar2.zzh(zzkt.zzb(bArr, zzh8));
                                                            zzf = zzh8 + 4;
                                                        }
                                                    }
                                                }
                                                i32 = i34;
                                                zzksVar5 = zzksVar6;
                                                zznkVar2 = zznkVar3;
                                                i33 = i74;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            i32 = i34;
                                            i43 = zzf;
                                            zzksVar5 = zzksVar6;
                                            zznkVar2 = zznkVar3;
                                            i33 = i74;
                                            if (i43 == i76) {
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            zzksVar6 = zzksVar8;
                                            zzmj zzmjVar9 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i34 = i54;
                                            i40 = i2;
                                            zznkVar3 = zznkVar4;
                                            i15 = i75;
                                            if (i52 == 2) {
                                                int i99 = zzkt.zza;
                                                zzku zzkuVar = (zzku) zzmjVar9;
                                                zzf = zzkt.zzh(bArr, i76, zzksVar6);
                                                int i100 = zzksVar6.zza + zzf;
                                                while (zzf < i100) {
                                                    zzf = zzkt.zzk(bArr, zzf, zzksVar6);
                                                    zzkuVar.zze(zzksVar6.zzb != 0);
                                                }
                                                if (zzf != i100) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i52 == 0) {
                                                    int i101 = zzkt.zza;
                                                    zzku zzkuVar2 = (zzku) zzmjVar9;
                                                    zzf = zzkt.zzk(bArr, i76, zzksVar6);
                                                    zzkuVar2.zze(zzksVar6.zzb != 0);
                                                    while (zzf < i40) {
                                                        int zzh9 = zzkt.zzh(bArr, zzf, zzksVar6);
                                                        if (i34 == zzksVar6.zza) {
                                                            zzf = zzkt.zzk(bArr, zzh9, zzksVar6);
                                                            zzkuVar2.zze(zzksVar6.zzb != 0);
                                                        }
                                                    }
                                                }
                                                i32 = i34;
                                                zzksVar5 = zzksVar6;
                                                zznkVar2 = zznkVar3;
                                                i33 = i74;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            i32 = i34;
                                            i43 = zzf;
                                            zzksVar5 = zzksVar6;
                                            zznkVar2 = zznkVar3;
                                            i33 = i74;
                                            if (i43 == i76) {
                                            }
                                            break;
                                        case 26:
                                            zzksVar6 = zzksVar8;
                                            zzmj zzmjVar10 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i34 = i54;
                                            i40 = i2;
                                            zznkVar3 = zznkVar4;
                                            i15 = i75;
                                            if (i52 != 2) {
                                                i32 = i34;
                                                zzksVar5 = zzksVar6;
                                                i33 = i74;
                                                zznkVar2 = zznkVar3;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            } else if ((j3 & 536870912) == 0) {
                                                int zzh10 = zzkt.zzh(bArr, i76, zzksVar6);
                                                int i102 = zzksVar6.zza;
                                                if (i102 < 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i102 == 0) {
                                                    obj3 = "";
                                                    zzmjVar10.add(obj3);
                                                } else {
                                                    obj3 = "";
                                                    zzmjVar10.add(new String(bArr, zzh10, i102, zzmk.zza));
                                                    zzh10 += i102;
                                                }
                                                while (zzh10 < i40) {
                                                    int zzh11 = zzkt.zzh(bArr, zzh10, zzksVar6);
                                                    if (i34 == zzksVar6.zza) {
                                                        zzh10 = zzkt.zzh(bArr, zzh11, zzksVar6);
                                                        int i103 = zzksVar6.zza;
                                                        if (i103 < 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i103 == 0) {
                                                            zzmjVar10.add(obj3);
                                                        } else {
                                                            zzmjVar10.add(new String(bArr, zzh10, i103, zzmk.zza));
                                                            zzh10 += i103;
                                                        }
                                                    } else {
                                                        i32 = i34;
                                                        i43 = zzh10;
                                                        zzksVar5 = zzksVar6;
                                                        i33 = i74;
                                                        zznkVar2 = zznkVar3;
                                                        if (i43 == i76) {
                                                        }
                                                    }
                                                }
                                                i32 = i34;
                                                i43 = zzh10;
                                                zzksVar5 = zzksVar6;
                                                i33 = i74;
                                                zznkVar2 = zznkVar3;
                                                if (i43 == i76) {
                                                }
                                            } else {
                                                zzf = zzkt.zzh(bArr, i76, zzksVar6);
                                                int i104 = zzksVar6.zza;
                                                if (i104 < 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i104 == 0) {
                                                    zzmjVar10.add("");
                                                    i74 = i74;
                                                } else {
                                                    int i105 = zzf + i104;
                                                    if (zzoo.zzd(bArr, zzf, i105)) {
                                                        i74 = i74;
                                                        zzmjVar10.add(new String(bArr, zzf, i104, zzmk.zza));
                                                        zzf = i105;
                                                    } else {
                                                        throw new zzmm(str);
                                                    }
                                                }
                                                while (zzf < i40) {
                                                    int zzh12 = zzkt.zzh(bArr, zzf, zzksVar6);
                                                    if (i34 == zzksVar6.zza) {
                                                        zzf = zzkt.zzh(bArr, zzh12, zzksVar6);
                                                        int i106 = zzksVar6.zza;
                                                        if (i106 < 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i106 == 0) {
                                                            zzmjVar10.add("");
                                                        } else {
                                                            int i107 = zzf + i106;
                                                            if (zzoo.zzd(bArr, zzf, i107)) {
                                                                zzmjVar10.add(new String(bArr, zzf, i106, zzmk.zza));
                                                                zzf = i107;
                                                            } else {
                                                                throw new zzmm(str);
                                                            }
                                                        }
                                                    } else {
                                                        i32 = i34;
                                                        i43 = zzf;
                                                        zzksVar5 = zzksVar6;
                                                        zznkVar2 = zznkVar3;
                                                        i33 = i74;
                                                        if (i43 == i76) {
                                                        }
                                                    }
                                                }
                                                i32 = i34;
                                                i43 = zzf;
                                                zzksVar5 = zzksVar6;
                                                zznkVar2 = zznkVar3;
                                                i33 = i74;
                                                if (i43 == i76) {
                                                }
                                            }
                                            break;
                                        case 27:
                                            zzksVar5 = zzksVar8;
                                            i35 = i74;
                                            i15 = i75;
                                            i40 = i2;
                                            if (i52 == 2) {
                                                unsafe4 = unsafe7;
                                                int zze = zzkt.zze(zzv(i15), i54, bArr, i76, i2, zzmjVar, zzksVar);
                                                i32 = i54;
                                                i76 = i76;
                                                i40 = i40;
                                                zzksVar5 = zzksVar5;
                                                i33 = i35;
                                                zznkVar2 = this;
                                                i43 = zze;
                                                if (i43 == i76) {
                                                }
                                            } else {
                                                unsafe4 = unsafe7;
                                                zznkVar2 = this;
                                                i32 = i54;
                                                i33 = i35;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            break;
                                        case 28:
                                            zzksVar5 = zzksVar8;
                                            i35 = i74;
                                            i15 = i75;
                                            i40 = i2;
                                            if (i52 == 2) {
                                                i43 = zzkt.zzh(bArr, i76, zzksVar5);
                                                int i108 = zzksVar5.zza;
                                                if (i108 >= 0) {
                                                    if (i108 > bArr.length - i43) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i108 == 0) {
                                                        zzmjVar.add(zzld.zzb);
                                                    } else {
                                                        zzmjVar.add(zzld.zzj(bArr, i43, i108));
                                                        i43 += i108;
                                                    }
                                                    while (i43 < i40) {
                                                        int zzh13 = zzkt.zzh(bArr, i43, zzksVar5);
                                                        if (i54 == zzksVar5.zza) {
                                                            i43 = zzkt.zzh(bArr, zzh13, zzksVar5);
                                                            int i109 = zzksVar5.zza;
                                                            if (i109 >= 0) {
                                                                if (i109 > bArr.length - i43) {
                                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                if (i109 == 0) {
                                                                    zzmjVar.add(zzld.zzb);
                                                                } else {
                                                                    zzmjVar.add(zzld.zzj(bArr, i43, i109));
                                                                    i43 += i109;
                                                                }
                                                            } else {
                                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                        } else {
                                                            zznkVar2 = this;
                                                            i32 = i54;
                                                            unsafe4 = unsafe7;
                                                            i33 = i35;
                                                            if (i43 == i76) {
                                                            }
                                                        }
                                                    }
                                                    zznkVar2 = this;
                                                    i32 = i54;
                                                    unsafe4 = unsafe7;
                                                    i33 = i35;
                                                    if (i43 == i76) {
                                                    }
                                                } else {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                            } else {
                                                zznkVar2 = this;
                                                i32 = i54;
                                                unsafe4 = unsafe7;
                                                i33 = i35;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i36 = i54;
                                            if (i52 == 2) {
                                                zzj = zzkt.zzf(bArr, i76, zzmjVar, zzksVar8);
                                                zzksVar5 = zzksVar8;
                                                unsafe5 = unsafe7;
                                                i35 = i74;
                                                i37 = i75;
                                                i40 = i2;
                                            } else if (i52 == 0) {
                                                zzksVar5 = zzksVar8;
                                                i35 = i74;
                                                i37 = i75;
                                                unsafe5 = unsafe7;
                                                i40 = i2;
                                                zzj = zzkt.zzj(i36, bArr, i76, i2, zzmjVar, zzksVar);
                                            } else {
                                                zznkVar2 = this;
                                                zzksVar5 = zzksVar8;
                                                i32 = i36;
                                                unsafe4 = unsafe7;
                                                i33 = i74;
                                                i15 = i75;
                                                i40 = i2;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            zzmg zzu3 = zznkVar4.zzu(i37);
                                            zzoe zzoeVar = zznkVar4.zzl;
                                            int i110 = zznu.zza;
                                            if (zzu3 == null) {
                                                i38 = zzj;
                                                i39 = i37;
                                            } else if (zzmjVar instanceof RandomAccess) {
                                                int size2 = zzmjVar.size();
                                                i38 = zzj;
                                                Object obj5 = null;
                                                int i111 = 0;
                                                int i112 = 0;
                                                while (i111 < size2) {
                                                    int i113 = i37;
                                                    Integer num = (Integer) zzmjVar.get(i111);
                                                    int intValue = num.intValue();
                                                    if (zzu3.zza(intValue)) {
                                                        if (i111 != i112) {
                                                            zzmjVar.set(i112, num);
                                                        }
                                                        i112++;
                                                    } else {
                                                        obj5 = zznu.zzn(obj4, i35, intValue, obj5, zzoeVar);
                                                    }
                                                    i111++;
                                                    i37 = i113;
                                                }
                                                i39 = i37;
                                                if (i112 != size2) {
                                                    zzmjVar.subList(i112, size2).clear();
                                                }
                                            } else {
                                                i38 = zzj;
                                                i39 = i37;
                                                Iterator it = zzmjVar.iterator();
                                                Object obj6 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!zzu3.zza(intValue2)) {
                                                        obj6 = zznu.zzn(obj4, i35, intValue2, obj6, zzoeVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            zznkVar2 = this;
                                            i43 = i38;
                                            i32 = i36;
                                            unsafe4 = unsafe5;
                                            i15 = i39;
                                            i33 = i35;
                                            if (i43 == i76) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i36 = i54;
                                            if (i52 == 2) {
                                                int i114 = zzkt.zza;
                                                zzme zzmeVar3 = (zzme) zzmjVar;
                                                zzh3 = zzkt.zzh(bArr, i76, zzksVar8);
                                                int i115 = zzksVar8.zza + zzh3;
                                                while (zzh3 < i115) {
                                                    zzh3 = zzkt.zzh(bArr, zzh3, zzksVar8);
                                                    zzmeVar3.zzh(zzlg.zzb(zzksVar8.zza));
                                                }
                                                if (zzh3 != i115) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else if (i52 == 0) {
                                                int i116 = zzkt.zza;
                                                zzme zzmeVar4 = (zzme) zzmjVar;
                                                zzh3 = zzkt.zzh(bArr, i76, zzksVar8);
                                                zzmeVar4.zzh(zzlg.zzb(zzksVar8.zza));
                                                while (zzh3 < i2) {
                                                    int zzh14 = zzkt.zzh(bArr, zzh3, zzksVar8);
                                                    if (i36 == zzksVar8.zza) {
                                                        zzh3 = zzkt.zzh(bArr, zzh14, zzksVar8);
                                                        zzmeVar4.zzh(zzlg.zzb(zzksVar8.zza));
                                                    }
                                                }
                                            } else {
                                                zznkVar2 = zznkVar4;
                                                zzksVar5 = zzksVar8;
                                                i32 = i36;
                                                unsafe4 = unsafe7;
                                                i33 = i74;
                                                i15 = i75;
                                                i40 = i2;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            zznkVar2 = zznkVar4;
                                            zzksVar5 = zzksVar8;
                                            i43 = zzh3;
                                            i32 = i36;
                                            unsafe4 = unsafe7;
                                            i33 = i74;
                                            i15 = i75;
                                            i40 = i2;
                                            if (i43 == i76) {
                                            }
                                            break;
                                        case 34:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                            if (i52 == 2) {
                                                int i117 = zzkt.zza;
                                                zzmw zzmwVar5 = (zzmw) zzmjVar;
                                                int zzh15 = zzkt.zzh(bArr, i76, zzksVar8);
                                                int i118 = zzksVar8.zza + zzh15;
                                                while (zzh15 < i118) {
                                                    zzh15 = zzkt.zzk(bArr, zzh15, zzksVar8);
                                                    zzmwVar5.zzg(zzlg.zzc(zzksVar8.zzb));
                                                }
                                                if (zzh15 != i118) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zznkVar2 = zznkVar4;
                                                zzksVar5 = zzksVar8;
                                                i43 = zzh15;
                                                unsafe4 = unsafe7;
                                                i32 = i54;
                                                i33 = i74;
                                                i15 = i75;
                                                i40 = i2;
                                                if (i43 == i76) {
                                                }
                                            } else if (i52 == 0) {
                                                int i119 = zzkt.zza;
                                                zzmw zzmwVar6 = (zzmw) zzmjVar;
                                                zzh3 = zzkt.zzk(bArr, i76, zzksVar8);
                                                zzmwVar6.zzg(zzlg.zzc(zzksVar8.zzb));
                                                while (true) {
                                                    if (zzh3 < i2) {
                                                        int zzh16 = zzkt.zzh(bArr, zzh3, zzksVar8);
                                                        i36 = i54;
                                                        if (i36 == zzksVar8.zza) {
                                                            zzh3 = zzkt.zzk(bArr, zzh16, zzksVar8);
                                                            zzmwVar6.zzg(zzlg.zzc(zzksVar8.zzb));
                                                            i54 = i36;
                                                        }
                                                    } else {
                                                        i36 = i54;
                                                    }
                                                }
                                                zznkVar2 = zznkVar4;
                                                zzksVar5 = zzksVar8;
                                                i43 = zzh3;
                                                i32 = i36;
                                                unsafe4 = unsafe7;
                                                i33 = i74;
                                                i15 = i75;
                                                i40 = i2;
                                                if (i43 == i76) {
                                                }
                                            } else {
                                                zznkVar2 = zznkVar4;
                                                zzksVar5 = zzksVar8;
                                                unsafe4 = unsafe7;
                                                i32 = i54;
                                                i33 = i74;
                                                i15 = i75;
                                                i40 = i2;
                                                i43 = i76;
                                                if (i43 == i76) {
                                                }
                                            }
                                            break;
                                        default:
                                            zzksVar5 = zzksVar8;
                                            zzmj zzmjVar11 = zzmjVar;
                                            unsafe4 = unsafe7;
                                            i32 = i54;
                                            i33 = i74;
                                            zznkVar2 = zznkVar4;
                                            i40 = i2;
                                            i15 = i75;
                                            if (i52 == 3) {
                                                int i120 = (i32 & (-8)) | 4;
                                                zzns zzv = zznkVar2.zzv(i15);
                                                i43 = zzkt.zzc(zzv, bArr, i76, i2, i120, zzksVar);
                                                zzmjVar11.add(zzksVar5.zzc);
                                                while (i43 < i40) {
                                                    int zzh17 = zzkt.zzh(bArr, i43, zzksVar5);
                                                    if (i32 == zzksVar5.zza) {
                                                        i43 = zzkt.zzc(zzv, bArr, zzh17, i2, i120, zzksVar);
                                                        zzmjVar11.add(zzksVar5.zzc);
                                                    } else if (i43 == i76) {
                                                    }
                                                }
                                                if (i43 == i76) {
                                                }
                                            }
                                            i43 = i76;
                                            if (i43 == i76) {
                                            }
                                            break;
                                    }
                                }
                                i41 = i3;
                            } else if (i52 == 2) {
                                zzmj zzmjVar12 = (zzmj) unsafe7.getObject(obj4, j);
                                if (!zzmjVar12.zzc()) {
                                    int size3 = zzmjVar12.size();
                                    zzmjVar12 = zzmjVar12.zzd(size3 == 0 ? 10 : size3 + size3);
                                    unsafe7.putObject(obj4, j, zzmjVar12);
                                }
                                int zze2 = zzkt.zze(zznkVar4.zzv(i75), i54, bArr, i76, i2, zzmjVar12, zzksVar);
                                i41 = i3;
                                zzksVar7 = zzksVar8;
                                unsafe6 = unsafe7;
                                i43 = zze2;
                                i44 = i75;
                                i40 = i2;
                                i48 = i12;
                                i45 = i54;
                                i42 = 0;
                                i46 = i11;
                                i47 = i74;
                            } else {
                                obj2 = obj4;
                                i27 = i54;
                                zznkVar = zznkVar4;
                                i15 = i75;
                                i13 = i74;
                                zzksVar4 = zzksVar8;
                                unsafe3 = unsafe7;
                            }
                            i4 = i3;
                            i10 = i76;
                            i16 = i27;
                            zzksVar2 = zzksVar4;
                            unsafe = unsafe3;
                        }
                    }
                    if (i16 == i4 || i4 == 0) {
                        if (zznkVar.zzh) {
                            zzlp zzlpVar = zzksVar2.zzd;
                            int i121 = zzlp.zzb;
                            int i122 = zznp.zza;
                            if (zzlpVar != zzlp.zza) {
                                zznh zznhVar = zznkVar.zzg;
                                int i123 = zzkt.zza;
                                if (zzlpVar.zzb(zznhVar, i13) == null) {
                                    i17 = i13;
                                    unsafe6 = unsafe;
                                    i43 = zzkt.zzg(i16, bArr, i10, i2, zzd(obj), zzksVar);
                                    i44 = i15;
                                    zznkVar4 = zznkVar;
                                    obj4 = obj2;
                                    i45 = i16;
                                    zzksVar7 = zzksVar2;
                                    i47 = i17;
                                    i48 = i12;
                                    i42 = i14;
                                    i46 = i11;
                                    i40 = i2;
                                    i41 = i4;
                                } else {
                                    throw null;
                                }
                            }
                        }
                        i17 = i13;
                        unsafe6 = unsafe;
                        i43 = zzkt.zzg(i16, bArr, i10, i2, zzd(obj), zzksVar);
                        i44 = i15;
                        zznkVar4 = zznkVar;
                        obj4 = obj2;
                        i45 = i16;
                        zzksVar7 = zzksVar2;
                        i47 = i17;
                        i48 = i12;
                        i42 = i14;
                        i46 = i11;
                        i40 = i2;
                        i41 = i4;
                    } else {
                        i43 = i10;
                        unsafe6 = unsafe;
                        i45 = i16;
                        i48 = i12;
                        i46 = i11;
                        i5 = 1048575;
                    }
                } else {
                    zzq = zznkVar4.zzq(i51, i42);
                }
                i9 = zzq;
                i8 = -1;
                if (i9 != i8) {
                }
                if (i16 == i4) {
                }
                if (zznkVar.zzh) {
                }
                i17 = i13;
                unsafe6 = unsafe;
                i43 = zzkt.zzg(i16, bArr, i10, i2, zzd(obj), zzksVar);
                i44 = i15;
                zznkVar4 = zznkVar;
                obj4 = obj2;
                i45 = i16;
                zzksVar7 = zzksVar2;
                i47 = i17;
                i48 = i12;
                i42 = i14;
                i46 = i11;
                i40 = i2;
                i41 = i4;
            } else {
                obj2 = obj4;
                i4 = i41;
                i5 = 1048575;
                zznkVar = zznkVar4;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final Object zze() {
        return ((zzmd) this.zzg).zzcj();
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzmd) {
                zzmd zzmdVar = (zzmd) obj;
                zzmdVar.zzcu(Integer.MAX_VALUE);
                zzmdVar.zza = 0;
                zzmdVar.zzcs();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = i2;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
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
                                ((zzmj) zzol.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zznb) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                int i3 = iArr[i];
                long j = i2;
                switch (zzr) {
                    case 0:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzo(obj, j, zzol.zza(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzp(obj, j, zzol.zzb(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzm(obj, j, zzol.zzw(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 9:
                        zzB(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 17:
                        zzB(obj, obj2, i);
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
                        zzmj zzmjVar = (zzmj) zzol.zzf(obj, j);
                        zzmj zzmjVar2 = (zzmj) zzol.zzf(obj2, j);
                        int size = zzmjVar.size();
                        int size2 = zzmjVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzmjVar.zzc()) {
                                zzmjVar = zzmjVar.zzd(size2 + size);
                            }
                            zzmjVar.addAll(zzmjVar2);
                        }
                        if (size > 0) {
                            zzmjVar2 = zzmjVar;
                        }
                        zzol.zzs(obj, j, zzmjVar2);
                        break;
                    case 50:
                        int i4 = zznu.zza;
                        zzol.zzs(obj, j, zznc.zza(zzol.zzf(obj, j), zzol.zzf(obj2, j)));
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
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        zzC(obj, obj2, i);
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    case 62:
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    case 64:
                    case 65:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    case 67:
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzC(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zznu.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zznu.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzks zzksVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzksVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0067. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.gms.internal.measurement.zzns
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(Object obj, zzor zzorVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr2;
        if (this.zzh) {
            zzlu zzluVar = ((zzma) obj).zzb;
            if (!zzluVar.zza.isEmpty()) {
                entry = (Map.Entry) zzluVar.zze().next();
                iArr = this.zzc;
                Unsafe unsafe = zzb;
                int i5 = 1048575;
                int i6 = 1048575;
                int i7 = 0;
                i = 0;
                while (i < iArr.length) {
                    int zzs = zzs(i);
                    int zzr = zzr(zzs);
                    int i8 = iArr[i];
                    if (zzr <= 17) {
                        int i9 = iArr[i + 2];
                        int i10 = i9 & i5;
                        if (i10 != i6) {
                            i7 = i10 == i5 ? 0 : unsafe.getInt(obj, i10);
                            i6 = i10;
                        }
                        i2 = i6;
                        i3 = i7;
                        i4 = 1 << (i9 >>> 20);
                    } else {
                        i2 = i6;
                        i3 = i7;
                        i4 = 0;
                    }
                    if (entry == null) {
                        long j = zzs & i5;
                        switch (zzr) {
                            case 0:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzf(i8, zzol.zza(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 1:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzo(i8, zzol.zzb(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 2:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzt(i8, unsafe.getLong(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 3:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzK(i8, unsafe.getLong(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 4:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzr(i8, unsafe.getInt(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 5:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzm(i8, unsafe.getLong(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 6:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzk(i8, unsafe.getInt(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 7:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzb(i8, zzol.zzw(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 8:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzO(i8, unsafe.getObject(obj, j), zzorVar);
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 9:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzv(i8, unsafe.getObject(obj, j), zzv(i));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 10:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzd(i8, (zzld) unsafe.getObject(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 11:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzI(i8, unsafe.getInt(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 12:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzi(i8, unsafe.getInt(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 13:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzx(i8, unsafe.getInt(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 14:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzz(i8, unsafe.getLong(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 15:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzB(i8, unsafe.getInt(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 16:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzD(i8, unsafe.getLong(obj, j));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 17:
                                iArr2 = iArr;
                                if (zzJ(obj, i, i2, i3, i4)) {
                                    zzorVar.zzq(i8, unsafe.getObject(obj, j), zzv(i));
                                }
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 18:
                                zznu.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 19:
                                zznu.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 20:
                                zznu.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 21:
                                zznu.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 22:
                                zznu.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 23:
                                zznu.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 24:
                                zznu.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 25:
                                zznu.zzq(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 26:
                                int i11 = iArr[i];
                                List list = (List) unsafe.getObject(obj, j);
                                int i12 = zznu.zza;
                                if (list != null && !list.isEmpty()) {
                                    zzorVar.zzH(i11, list);
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                                break;
                            case 27:
                                int i13 = iArr[i];
                                List list2 = (List) unsafe.getObject(obj, j);
                                zzns zzv = zzv(i);
                                int i14 = zznu.zza;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (int i15 = 0; i15 < list2.size(); i15++) {
                                        ((zzll) zzorVar).zzv(i13, list2.get(i15), zzv);
                                    }
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                                break;
                            case 28:
                                int i16 = iArr[i];
                                List list3 = (List) unsafe.getObject(obj, j);
                                int i17 = zznu.zza;
                                if (list3 != null && !list3.isEmpty()) {
                                    zzorVar.zze(i16, list3);
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                                break;
                            case 29:
                                zznu.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 30:
                                zznu.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 31:
                                zznu.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 32:
                                zznu.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 33:
                                zznu.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 34:
                                zznu.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 35:
                                zznu.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 36:
                                zznu.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 37:
                                zznu.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 38:
                                zznu.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 39:
                                zznu.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 40:
                                zznu.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 41:
                                zznu.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 42:
                                zznu.zzq(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 43:
                                zznu.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 44:
                                zznu.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 45:
                                zznu.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 46:
                                zznu.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 47:
                                zznu.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                zznu.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                int i18 = iArr[i];
                                List list4 = (List) unsafe.getObject(obj, j);
                                zzns zzv2 = zzv(i);
                                int i19 = zznu.zza;
                                if (list4 != null && !list4.isEmpty()) {
                                    for (int i20 = 0; i20 < list4.size(); i20++) {
                                        ((zzll) zzorVar).zzq(i18, list4.get(i20), zzv2);
                                    }
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                                break;
                            case 50:
                                if (unsafe.getObject(obj, j) != null) {
                                    throw null;
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzf(i8, zzm(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzo(i8, zzn(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzt(i8, zzt(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzK(i8, zzt(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzr(i8, zzo(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 56:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzm(i8, zzt(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 57:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzk(i8, zzo(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 58:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzb(i8, zzN(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 59:
                                if (zzM(obj, i8, i)) {
                                    zzO(i8, unsafe.getObject(obj, j), zzorVar);
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzv(i8, unsafe.getObject(obj, j), zzv(i));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzd(i8, (zzld) unsafe.getObject(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 62:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzI(i8, zzo(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzi(i8, zzo(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 64:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzx(i8, zzo(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 65:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzz(i8, zzt(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzB(i8, zzo(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 67:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzD(i8, zzt(obj, j));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            case 68:
                                if (zzM(obj, i8, i)) {
                                    zzorVar.zzq(i8, unsafe.getObject(obj, j), zzv(i));
                                }
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                            default:
                                iArr2 = iArr;
                                i += 3;
                                i6 = i2;
                                i7 = i3;
                                iArr = iArr2;
                                i5 = 1048575;
                        }
                    } else {
                        throw null;
                    }
                }
                if (entry != null) {
                    ((zzmd) obj).zzc.zzl(zzorVar);
                    return;
                } else {
                    throw null;
                }
            }
        }
        entry = null;
        iArr = this.zzc;
        Unsafe unsafe2 = zzb;
        int i52 = 1048575;
        int i62 = 1048575;
        int i72 = 0;
        i = 0;
        while (i < iArr.length) {
        }
        if (entry != null) {
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzns
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzj(Object obj, Object obj2) {
        int i;
        boolean zzE;
        for (0; i < this.zzc.length; i + 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    i = (zzH(obj, obj2, i) && Double.doubleToLongBits(zzol.zza(obj, j)) == Double.doubleToLongBits(zzol.zza(obj2, j))) ? i + 3 : 0;
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzol.zzb(obj, j)) == Float.floatToIntBits(zzol.zzb(obj2, j))) {
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzol.zzw(obj, j) == zzol.zzw(obj2, j)) {
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
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
                    zzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
                    if (zzE) {
                        return false;
                    }
                case 50:
                    zzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
                    if (zzE) {
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
                    long zzp = zzp(i) & 1048575;
                    if (zzol.zzc(obj, zzp) == zzol.zzc(obj2, zzp) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                    }
                    return false;
                default:
            }
        }
        if (!((zzmd) obj).zzc.equals(((zzmd) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzma) obj).zzb.equals(((zzma) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zzs = zzs(i6);
            int i8 = iArr2[i6 + 2];
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
            if ((268435456 & zzs) != 0 && !zzJ(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i7, i6) && !zzK(obj, zzs, zzv(i6))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zznb) zzol.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzol.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzns zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i6, i, i2, i10) && !zzK(obj, zzs, zzv(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return !this.zzh || ((zzma) obj).zzb.zzh();
    }
}
