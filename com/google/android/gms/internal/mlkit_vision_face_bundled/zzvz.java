package com.google.android.gms.internal.mlkit_vision_face_bundled;

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
/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public final class zzvz<T> implements zzwh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzxc.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzvw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzwv zzl;
    private final zzui zzm;

    private zzvz(int[] iArr, Object[] objArr, int i, int i2, zzvw zzvwVar, boolean z, int[] iArr2, int i3, int i4, zzwc zzwcVar, zzvj zzvjVar, zzwv zzwvVar, zzui zzuiVar, zzvr zzvrVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzuiVar != null && (zzvwVar instanceof zzus)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzwvVar;
        this.zzm = zzuiVar;
        this.zzg = zzvwVar;
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
            zzwh zzv = zzv(i);
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
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzwh zzv = zzv(i);
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
        zzxc.zzq(obj, j, (1 << (zzp >>> 20)) | zzxc.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzxc.zzq(obj, zzp(i2) & 1048575, i);
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
            return (zzxc.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzxc.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzxc.zzb(obj, j2)) != 0;
            case 2:
                return zzxc.zzd(obj, j2) != 0;
            case 3:
                return zzxc.zzd(obj, j2) != 0;
            case 4:
                return zzxc.zzc(obj, j2) != 0;
            case 5:
                return zzxc.zzd(obj, j2) != 0;
            case 6:
                return zzxc.zzc(obj, j2) != 0;
            case 7:
                return zzxc.zzw(obj, j2);
            case 8:
                Object zzf = zzxc.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zztu) {
                    return !zztu.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzxc.zzf(obj, j2) != null;
            case 10:
                return !zztu.zzb.equals(zzxc.zzf(obj, j2));
            case 11:
                return zzxc.zzc(obj, j2) != 0;
            case 12:
                return zzxc.zzc(obj, j2) != 0;
            case 13:
                return zzxc.zzc(obj, j2) != 0;
            case 14:
                return zzxc.zzd(obj, j2) != 0;
            case 15:
                return zzxc.zzc(obj, j2) != 0;
            case 16:
                return zzxc.zzd(obj, j2) != 0;
            case 17:
                return zzxc.zzf(obj, j2) != null;
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

    private static boolean zzK(Object obj, int i, zzwh zzwhVar) {
        return zzwhVar.zzk(zzxc.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzuw) {
            return ((zzuw) obj).zzI();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzxc.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzxc.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzxi zzxiVar) throws IOException {
        if (obj instanceof String) {
            zzxiVar.zzG(i, (String) obj);
        } else {
            zzxiVar.zzd(i, (zztu) obj);
        }
    }

    static zzww zzd(Object obj) {
        zzuw zzuwVar = (zzuw) obj;
        zzww zzwwVar = zzuwVar.zzc;
        if (zzwwVar != zzww.zzc()) {
            return zzwwVar;
        }
        zzww zzf = zzww.zzf();
        zzuwVar.zzc = zzf;
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
    public static zzvz zzl(Class cls, zzvt zzvtVar, zzwc zzwcVar, zzvj zzvjVar, zzwv zzwvVar, zzui zzuiVar, zzvr zzvrVar) {
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
        zzwg zzwgVar;
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
        if (zzvtVar instanceof zzwg) {
            zzwg zzwgVar2 = (zzwg) zzvtVar;
            String zzd = zzwgVar2.zzd();
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
            Object[] zze = zzwgVar2.zze();
            Class<?> cls2 = zzwgVar2.zza().getClass();
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
                            if (zzwgVar2.zzc() == 1 || i79 != 0) {
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
                        zzwgVar = zzwgVar2;
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
                    zzwgVar = zzwgVar2;
                    objectFieldOffset = objectFieldOffset22;
                    i24 = i912;
                } else {
                    i17 = i2;
                    i18 = i4 + 1;
                    Field zzz4 = zzz(cls2, (String) zze[i4]);
                    i19 = charAt23;
                    if (i77 == 9 || i77 == 17) {
                        zzwgVar = zzwgVar2;
                        int i92 = i68 / 3;
                        objArr[i92 + i92 + 1] = zzz4.getType();
                    } else {
                        if (i77 == 27) {
                            zzwgVar = zzwgVar2;
                            i26 = 1;
                            i27 = i4 + 2;
                        } else if (i77 == 49) {
                            i27 = i4 + 2;
                            zzwgVar = zzwgVar2;
                            i26 = 1;
                        } else {
                            if (i77 == 12 || i77 == 30 || i77 == 44) {
                                zzwgVar = zzwgVar2;
                                if (zzwgVar2.zzc() == 1 || i79 != 0) {
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
                                    zzwgVar = zzwgVar2;
                                } else {
                                    i18 = i94;
                                    i65 = i95;
                                    i79 = 0;
                                    zzwgVar = zzwgVar2;
                                }
                            } else {
                                zzwgVar = zzwgVar2;
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
                zzwgVar2 = zzwgVar;
                i35 = i22;
                i2 = i17;
                c = 55296;
            }
            return new zzvz(iArr3, objArr, i2, i5, zzwgVar2.zza(), false, iArr, i3, i63, zzwcVar, zzvjVar, zzwvVar, zzuiVar, zzvrVar);
        }
        throw null;
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzxc.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzxc.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzxc.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzxc.zzf(obj, j)).longValue();
    }

    private final zzva zzu(int i) {
        int i2 = i / 3;
        return (zzva) this.zzd[i2 + i2 + 1];
    }

    private final zzwh zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzwh zzwhVar = (zzwh) objArr[i3];
        if (zzwhVar != null) {
            return zzwhVar;
        }
        zzwh zzb2 = zzwe.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzwh zzv = zzv(i);
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
        zzwh zzv = zzv(i2);
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

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0056. Please report as an issue. */
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
    /* JADX WARN: Type inference failed for: r1v120, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
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
        while (i4 < this.zzc.length) {
            int zzs = zzs(i4);
            int zzr = zzr(zzs);
            int[] iArr = this.zzc;
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
            if (zzr >= zzun.DOUBLE_LIST_PACKED.zza()) {
                zzun.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzz = zzuc.zzz(i7 << 3);
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
                        zzz2 = zzuc.zzz(i7 << 3);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(j2);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(j3);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(j4);
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
                        zzz = zzuc.zzz(i7 << 3);
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
                        zzz2 = zzuc.zzz(i7 << 3);
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
                        zzz4 = zzuc.zzz(i7 << 3);
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
                        if (object instanceof zztu) {
                            zzz5 = zzuc.zzz(i11);
                            zzd = ((zztu) object).zzd();
                            zzz6 = zzuc.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzz3 = zzuc.zzz(i11);
                            zzA = zzuc.zzy((String) object);
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
                        r0 = zzwj.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
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
                        zztu zztuVar = (zztu) unsafe.getObject(obj, j);
                        zzz5 = zzuc.zzz(i7 << 3);
                        zzd = zztuVar.zzd();
                        zzz6 = zzuc.zzz(zzd);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzz(i12);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(j5);
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
                        zzz2 = zzuc.zzz(i7 << 3);
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
                        zzz = zzuc.zzz(i7 << 3);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzz((i13 >> 31) ^ (i13 + i13));
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA((j6 >> 63) ^ (j6 + j6));
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
                        r0 = zzuc.zzw(i7, (zzvw) unsafe.getObject(obj, j), zzv(i4));
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
                    r0 = zzwj.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 19:
                    r0 = zzwj.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzwj.zza;
                    if (list.size() != 0) {
                        zzg = zzwj.zzg(list) + (list.size() * zzuc.zzz(i7 << 3));
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
                    int i15 = zzwj.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzz3 = zzwj.zzl(list2);
                        zzz7 = zzuc.zzz(i7 << 3);
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
                    int i16 = zzwj.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzz3 = zzwj.zzf(list3);
                        zzz7 = zzuc.zzz(i7 << 3);
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
                    r0 = zzwj.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 24:
                    r0 = zzwj.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzwj.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        r0 = size2 * (zzuc.zzz(i7 << 3) + 1);
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
                    int i18 = zzwj.zza;
                    int size3 = r02.size();
                    if (size3 != 0) {
                        int zzz10 = zzuc.zzz(i7 << 3) * size3;
                        if (r02 instanceof zzvi) {
                            zzvi zzviVar = (zzvi) r02;
                            zzg = zzz10;
                            for (?? r32 = z; r32 < size3; r32++) {
                                Object zza2 = zzviVar.zza();
                                if (zza2 instanceof zztu) {
                                    int zzd2 = ((zztu) zza2).zzd();
                                    zzy2 = zzg + zzuc.zzz(zzd2) + zzd2;
                                } else {
                                    zzy2 = zzg + zzuc.zzy((String) zza2);
                                }
                                zzg = zzy2;
                            }
                        } else {
                            zzg = zzz10;
                            for (?? r33 = z; r33 < size3; r33++) {
                                Object obj2 = r02.get(r33);
                                if (obj2 instanceof zztu) {
                                    int zzd3 = ((zztu) obj2).zzd();
                                    zzy = zzg + zzuc.zzz(zzd3) + zzd3;
                                } else {
                                    zzy = zzg + zzuc.zzy((String) obj2);
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
                    zzwh zzv = zzv(i4);
                    int i19 = zzwj.zza;
                    int size4 = r03.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        r3 = zzuc.zzz(i7 << 3) * size4;
                        for (?? r42 = z; r42 < size4; r42++) {
                            Object obj3 = r03.get(r42);
                            if (obj3 instanceof zzvh) {
                                int zza3 = ((zzvh) obj3).zza();
                                zzx = (r3 == true ? 1 : 0) + zzuc.zzz(zza3) + zza3;
                            } else {
                                zzx = (r3 == true ? 1 : 0) + zzuc.zzx((zzvw) obj3, zzv);
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
                    int i20 = zzwj.zza;
                    int size5 = r04.size();
                    if (size5 == 0) {
                        r1 = z;
                    } else {
                        r1 = size5 * zzuc.zzz(i7 << 3);
                        for (?? r2 = z; r2 < r04.size(); r2++) {
                            int zzd4 = ((zztu) r04.get(r2)).zzd();
                            r1 += zzuc.zzz(zzd4) + zzd4;
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
                    int i21 = zzwj.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzz3 = zzwj.zzk(list5);
                        zzz7 = zzuc.zzz(i7 << 3);
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
                    int i22 = zzwj.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzz3 = zzwj.zza(list6);
                        zzz7 = zzuc.zzz(i7 << 3);
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
                    r0 = zzwj.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 32:
                    r0 = zzwj.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzwj.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzz3 = zzwj.zzi(list7);
                        zzz7 = zzuc.zzz(i7 << 3);
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
                    int i24 = zzwj.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzz3 = zzwj.zzj(list8);
                        zzz7 = zzuc.zzz(i7 << 3);
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
                    zze = zzwj.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzg((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzl((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzf((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    int i25 = zzwj.zza;
                    zze = list9.size();
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzk((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zza((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzi((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zze = zzwj.zzj((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz8 = zzuc.zzz(i7 << 3);
                        zzz9 = zzuc.zzz(zze);
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
                    zzwh zzv2 = zzv(i4);
                    int i26 = zzwj.zza;
                    int size6 = r05.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        ?? r34 = z2;
                        while (r34 < size6) {
                            int zzw = zzuc.zzw(i7, (zzvw) r05.get(r34), zzv2);
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
                    zzvq zzvqVar = (zzvq) unsafe.getObject(obj, j);
                    if (zzvqVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzvqVar.entrySet().iterator();
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
                        zzz = zzuc.zzz(i7 << 3);
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
                        zzz2 = zzuc.zzz(i7 << 3);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(zzt);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(zzt2);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(zzo);
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
                        zzz = zzuc.zzz(i7 << 3);
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
                        zzz2 = zzuc.zzz(i7 << 3);
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
                        zzz4 = zzuc.zzz(i7 << 3);
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
                        if (object2 instanceof zztu) {
                            zzz5 = zzuc.zzz(i27);
                            zzd = ((zztu) object2).zzd();
                            zzz6 = zzuc.zzz(zzd);
                            r0 = zzz5 + zzz6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzz3 = zzuc.zzz(i27);
                            zzA = zzuc.zzy((String) object2);
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
                        r0 = zzwj.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
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
                        zztu zztuVar2 = (zztu) unsafe.getObject(obj, j);
                        zzz5 = zzuc.zzz(i7 << 3);
                        zzd = zztuVar2.zzd();
                        zzz6 = zzuc.zzz(zzd);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzz(zzo2);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA(zzo3);
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
                        zzz2 = zzuc.zzz(i7 << 3);
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
                        zzz = zzuc.zzz(i7 << 3);
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzz((zzo4 >> 31) ^ (zzo4 + zzo4));
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
                        zzz3 = zzuc.zzz(i7 << 3);
                        zzA = zzuc.zzA((zzt3 >> 63) ^ (zzt3 + zzt3));
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
                        r0 = zzuc.zzw(i7, (zzvw) unsafe.getObject(obj, j), zzv(i4));
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
        }
        int zza4 = i5 + ((zzuw) obj).zzc.zza();
        if (!this.zzh) {
            return zza4;
        }
        zzum zzumVar = ((zzus) obj).zzb;
        int zzc = zzumVar.zza.zzc();
        int i28 = 0;
        for (int i29 = 0; i29 < zzc; i29++) {
            Map.Entry zzg2 = zzumVar.zza.zzg(i29);
            i28 += zzum.zza((zzul) ((zzwl) zzg2).zza(), zzg2.getValue());
        }
        for (Map.Entry entry2 : zzumVar.zza.zzd()) {
            i28 += zzum.zza((zzul) entry2.getKey(), entry2.getValue());
        }
        return zza4 + i28;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i6 = iArr[i4];
            long j = i5;
            int i7 = 37;
            switch (zzr) {
                case 0:
                    i = i3 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzxc.zza(obj, j));
                    byte[] bArr = zzvc.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zzxc.zzb(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zzxc.zzd(obj, j);
                    byte[] bArr2 = zzvc.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zzxc.zzd(obj, j);
                    byte[] bArr3 = zzvc.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zzxc.zzd(obj, j);
                    byte[] bArr4 = zzvc.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zzvc.zza(zzxc.zzw(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zzxc.zzf(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zzf = zzxc.zzf(obj, j);
                    if (zzf != null) {
                        i7 = zzf.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zzxc.zzd(obj, j);
                    byte[] bArr5 = zzvc.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zzxc.zzd(obj, j);
                    byte[] bArr6 = zzvc.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zzf2 = zzxc.zzf(obj, j);
                    if (zzf2 != null) {
                        i7 = zzf2.hashCode();
                    }
                    i3 = i2 + i7;
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
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zzxc.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzvc.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzvc.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzvc.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzvc.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzvc.zza(zzN(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zzxc.zzf(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzxc.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzxc.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzvc.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzvc.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzxc.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + ((zzuw) obj).zzc.hashCode();
        return this.zzh ? (hashCode * 53) + ((zzus) obj).zzb.zza.hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0da6, code lost:
    
        if (r6 == 1048575) goto L553;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0da8, code lost:
    
        r9.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0dac, code lost:
    
        r3 = r10.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0db0, code lost:
    
        if (r3 >= r10.zzk) goto L668;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0db2, code lost:
    
        r5 = r10.zzi;
        r6 = r10.zzc;
        r5 = r5[r3];
        r6 = r6[r5];
        r6 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzxc.zzf(r7, r10.zzs(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0dc4, code lost:
    
        if (r6 != null) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0dcb, code lost:
    
        if (r10.zzu(r5) != null) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0dd4, code lost:
    
        r6 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzvq) r6;
        r0 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzvp) r10.zzw(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0ddc, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0dcd, code lost:
    
        r5 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzww) null;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0ddf, code lost:
    
        if (r0 != 0) goto L570;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0de1, code lost:
    
        if (r1 != r8) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0de9, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_face_bundled.zzve("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0dee, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0dea, code lost:
    
        if (r1 > r8) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0dec, code lost:
    
        if (r4 != r0) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0df4, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_face_bundled.zzve("Failed to parse the message.");
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:168:0x0488. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0a99. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:547:0x00be. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0a18 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0a2d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0ce4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0cfa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:614:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0d15  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zztj zztjVar) throws IOException {
        zzvz<T> zzvzVar;
        Unsafe unsafe;
        int i4;
        int i5;
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
        int i15;
        Unsafe unsafe2;
        zztj zztjVar2;
        int i16;
        int i17;
        int i18;
        Unsafe unsafe3;
        zzvz<T> zzvzVar2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        Unsafe unsafe4;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        zztj zztjVar3;
        int i29;
        int i30;
        int i31;
        long j;
        zztj zztjVar4;
        int i32;
        int i33;
        int i34;
        int i35;
        Unsafe unsafe5;
        int i36;
        Object obj2;
        zztj zztjVar5;
        int i37;
        int i38;
        int i39;
        int zzl;
        int i40;
        int i41;
        int zzj;
        int i42;
        int i43;
        zztj zztjVar6;
        int i44;
        int i45;
        Unsafe unsafe6;
        int zza2;
        zzvz<T> zzvzVar3 = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int i46 = i2;
        int i47 = i3;
        zztj zztjVar7 = zztjVar;
        zzA(obj);
        Unsafe unsafe7 = zzb;
        int i48 = 0;
        int i49 = i;
        int i50 = 0;
        int i51 = 0;
        int i52 = 0;
        int i53 = -1;
        int i54 = 1048575;
        while (true) {
            if (i49 < i46) {
                int i55 = i49 + 1;
                byte b = bArr2[i49];
                if (b < 0) {
                    i7 = zztk.zzk(b, bArr2, i55, zztjVar7);
                    i6 = zztjVar7.zza;
                } else {
                    i6 = b;
                    i7 = i55;
                }
                int i56 = i6 >>> 3;
                if (i56 > i53) {
                    zzq = (i56 < zzvzVar3.zze || i56 > zzvzVar3.zzf) ? -1 : zzvzVar3.zzq(i56, i50 / 3);
                } else if (i56 < zzvzVar3.zze || i56 > zzvzVar3.zzf) {
                    i8 = -1;
                    i9 = -1;
                    if (i9 == i8) {
                        int i57 = i6 & 7;
                        int[] iArr = zzvzVar3.zzc;
                        int i58 = iArr[i9 + 1];
                        int i59 = i6;
                        int zzr = zzr(i58);
                        long j2 = i58 & 1048575;
                        String str = "Protocol message had invalid UTF-8.";
                        if (zzr > 17) {
                            i13 = i54;
                            i15 = 0;
                            i12 = i52;
                            int i60 = i9;
                            zztj zztjVar8 = zztjVar7;
                            int i61 = i7;
                            Unsafe unsafe8 = unsafe7;
                            if (zzr != 27) {
                                int i62 = i60;
                                if (zzr > 49) {
                                    i29 = i62;
                                    zztjVar3 = zztjVar8;
                                    i31 = i56;
                                    if (zzr != 50) {
                                        obj3 = obj;
                                        Unsafe unsafe9 = zzb;
                                        unsafe2 = unsafe8;
                                        long j3 = iArr[i29 + 2] & 1048575;
                                        switch (zzr) {
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 1) {
                                                    i43 = i42 + 8;
                                                    unsafe9.putObject(obj3, j2, Double.valueOf(Double.longBitsToDouble(zztk.zzq(bArr2, i42))));
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    if (i43 != i42) {
                                                        i10 = i43;
                                                        i4 = i3;
                                                        break;
                                                    } else {
                                                        i47 = i3;
                                                        i53 = i16;
                                                        i51 = i11;
                                                        i54 = i13;
                                                        i50 = i14;
                                                        i48 = 0;
                                                        i52 = i12;
                                                        unsafe7 = unsafe2;
                                                        i46 = i2;
                                                        zztjVar7 = zztjVar2;
                                                        i49 = i43;
                                                        zzvzVar3 = this;
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 5) {
                                                    i43 = i42 + 4;
                                                    unsafe9.putObject(obj3, j2, Float.valueOf(Float.intBitsToFloat(zztk.zzc(bArr2, i42))));
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 0) {
                                                    i43 = zztk.zzm(bArr2, i42, zztjVar2);
                                                    unsafe9.putObject(obj3, j2, Long.valueOf(zztjVar2.zzb));
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                            case 62:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 0) {
                                                    i43 = zztk.zzj(bArr2, i42, zztjVar2);
                                                    unsafe9.putObject(obj3, j2, Integer.valueOf(zztjVar2.zza));
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 1) {
                                                    i43 = i42 + 8;
                                                    unsafe9.putObject(obj3, j2, Long.valueOf(zztk.zzq(bArr2, i42)));
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 5) {
                                                    i43 = i42 + 4;
                                                    unsafe9.putObject(obj3, j2, Integer.valueOf(zztk.zzc(bArr2, i42)));
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case 58:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 0) {
                                                    i43 = zztk.zzm(bArr2, i42, zztjVar2);
                                                    unsafe9.putObject(obj3, j2, Boolean.valueOf(zztjVar2.zzb != 0));
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case 59:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                if (i57 == 2) {
                                                    int zzj2 = zztk.zzj(bArr2, i42, zztjVar2);
                                                    int i63 = zztjVar2.zza;
                                                    if (i63 == 0) {
                                                        unsafe9.putObject(obj3, j2, "");
                                                    } else {
                                                        int i64 = zzj2 + i63;
                                                        if ((i58 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zzxf.zzd(bArr2, zzj2, i64)) {
                                                            unsafe9.putObject(obj3, j2, new String(bArr2, zzj2, i63, zzvc.zza));
                                                            zzj2 = i64;
                                                        } else {
                                                            throw new zzve(str);
                                                        }
                                                    }
                                                    unsafe9.putInt(obj3, j3, i16);
                                                    i43 = zzj2;
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                zztjVar6 = zztjVar;
                                                i42 = i61;
                                                i44 = i29;
                                                if (i57 == 2) {
                                                    Object zzy = zzvzVar3.zzy(obj3, i31, i44);
                                                    unsafe2 = unsafe2;
                                                    i11 = i59;
                                                    int zzo = zztk.zzo(zzy, zzvzVar3.zzv(i44), bArr, i42, i2, zztjVar);
                                                    zzvzVar3.zzG(obj3, i31, i44, zzy);
                                                    i43 = zzo;
                                                    zztjVar2 = zztjVar6;
                                                    i14 = i44;
                                                    i16 = i31;
                                                    if (i43 != i42) {
                                                    }
                                                } else {
                                                    unsafe2 = unsafe2;
                                                    i11 = i59;
                                                    i14 = i44;
                                                    i16 = i31;
                                                    zztjVar2 = zztjVar6;
                                                    i43 = i42;
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                zztjVar6 = zztjVar;
                                                i45 = i59;
                                                unsafe6 = unsafe2;
                                                i42 = i61;
                                                i44 = i29;
                                                if (i57 == 2) {
                                                    zza2 = zztk.zza(bArr2, i42, zztjVar6);
                                                    unsafe9.putObject(obj3, j2, zztjVar6.zzc);
                                                    unsafe9.putInt(obj3, j3, i31);
                                                    i43 = zza2;
                                                    i14 = i44;
                                                    unsafe2 = unsafe6;
                                                    i16 = i31;
                                                    zztjVar2 = zztjVar6;
                                                    i11 = i45;
                                                    if (i43 != i42) {
                                                    }
                                                } else {
                                                    i14 = i44;
                                                    unsafe2 = unsafe6;
                                                    i16 = i31;
                                                    zztjVar2 = zztjVar6;
                                                    i11 = i45;
                                                    i43 = i42;
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                break;
                                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                zztjVar6 = zztjVar;
                                                unsafe6 = unsafe2;
                                                i42 = i61;
                                                i44 = i29;
                                                if (i57 == 0) {
                                                    zza2 = zztk.zzj(bArr2, i42, zztjVar6);
                                                    int i65 = zztjVar6.zza;
                                                    zzva zzu = zzvzVar3.zzu(i44);
                                                    if (zzu == null || zzu.zza(i65)) {
                                                        i45 = i59;
                                                        unsafe9.putObject(obj3, j2, Integer.valueOf(i65));
                                                        unsafe9.putInt(obj3, j3, i31);
                                                    } else {
                                                        i45 = i59;
                                                        zzd(obj).zzj(i45, Long.valueOf(i65));
                                                    }
                                                    i43 = zza2;
                                                    i14 = i44;
                                                    unsafe2 = unsafe6;
                                                    i16 = i31;
                                                    zztjVar2 = zztjVar6;
                                                    i11 = i45;
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                unsafe2 = unsafe6;
                                                i11 = i59;
                                                i14 = i44;
                                                i16 = i31;
                                                zztjVar2 = zztjVar6;
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                zztjVar6 = zztjVar;
                                                unsafe6 = unsafe2;
                                                i42 = i61;
                                                i44 = i29;
                                                if (i57 == 0) {
                                                    int zzj3 = zztk.zzj(bArr2, i42, zztjVar6);
                                                    unsafe9.putObject(obj3, j2, Integer.valueOf(zzty.zzb(zztjVar6.zza)));
                                                    unsafe9.putInt(obj3, j3, i31);
                                                    i43 = zzj3;
                                                    unsafe2 = unsafe6;
                                                    i11 = i59;
                                                    i14 = i44;
                                                    i16 = i31;
                                                    zztjVar2 = zztjVar6;
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                unsafe2 = unsafe6;
                                                i11 = i59;
                                                i14 = i44;
                                                i16 = i31;
                                                zztjVar2 = zztjVar6;
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case 67:
                                                zztjVar6 = zztjVar;
                                                unsafe6 = unsafe2;
                                                i42 = i61;
                                                i44 = i29;
                                                if (i57 == 0) {
                                                    int zzm = zztk.zzm(bArr2, i42, zztjVar6);
                                                    unsafe9.putObject(obj3, j2, Long.valueOf(zzty.zzc(zztjVar6.zzb)));
                                                    unsafe9.putInt(obj3, j3, i31);
                                                    i43 = zzm;
                                                    unsafe2 = unsafe6;
                                                    i11 = i59;
                                                    i14 = i44;
                                                    i16 = i31;
                                                    zztjVar2 = zztjVar6;
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                unsafe2 = unsafe6;
                                                i11 = i59;
                                                i14 = i44;
                                                i16 = i31;
                                                zztjVar2 = zztjVar6;
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                            case 68:
                                                if (i57 == 3) {
                                                    Object zzy2 = zzvzVar3.zzy(obj3, i31, i29);
                                                    int zzn = zztk.zzn(zzy2, zzvzVar3.zzv(i29), bArr, i61, i2, (i59 & (-8)) | 4, zztjVar);
                                                    zzvzVar3.zzG(obj3, i31, i29, zzy2);
                                                    i16 = i31;
                                                    zztjVar2 = zztjVar;
                                                    i42 = i61;
                                                    i43 = zzn;
                                                    i11 = i59;
                                                    i14 = i29;
                                                    if (i43 != i42) {
                                                    }
                                                }
                                                break;
                                            default:
                                                i11 = i59;
                                                i14 = i29;
                                                i42 = i61;
                                                i16 = i31;
                                                zztjVar2 = zztjVar;
                                                i43 = i42;
                                                if (i43 != i42) {
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i57 == 2) {
                                            Unsafe unsafe10 = zzb;
                                            Object zzw = zzvzVar3.zzw(i29);
                                            Object object = unsafe10.getObject(obj, j2);
                                            if (!((zzvq) object).zze()) {
                                                zzvq zzb2 = zzvq.zza().zzb();
                                                zzvr.zza(zzb2, object);
                                                unsafe10.putObject(obj, j2, zzb2);
                                            }
                                            throw null;
                                        }
                                        i30 = i59;
                                        obj3 = obj;
                                        i4 = i3;
                                        i10 = i61;
                                        i14 = i29;
                                        unsafe2 = unsafe8;
                                        i16 = i31;
                                        i11 = i30;
                                        zztjVar2 = zztjVar3;
                                    }
                                } else {
                                    long j4 = i58;
                                    Unsafe unsafe11 = zzb;
                                    zzvb zzvbVar = (zzvb) unsafe11.getObject(obj3, j2);
                                    if (zzvbVar.zzc()) {
                                        j = j4;
                                    } else {
                                        int size = zzvbVar.size();
                                        j = j4;
                                        zzvbVar = zzvbVar.zzd(size != 0 ? size + size : 10);
                                        unsafe11.putObject(obj3, j2, zzvbVar);
                                    }
                                    zzvb zzvbVar2 = zzvbVar;
                                    switch (zzr) {
                                        case 18:
                                        case 35:
                                            zztjVar4 = zztjVar8;
                                            i32 = i2;
                                            i33 = i56;
                                            i34 = i59;
                                            i35 = i62;
                                            unsafe5 = unsafe8;
                                            if (i57 == 2) {
                                                int i66 = zztk.zza;
                                                zzue zzueVar = (zzue) zzvbVar2;
                                                i49 = zztk.zzj(bArr2, i61, zztjVar4);
                                                int i67 = zztjVar4.zza + i49;
                                                while (i49 < i67) {
                                                    zzueVar.zzf(Double.longBitsToDouble(zztk.zzq(bArr2, i49)));
                                                    i49 += 8;
                                                }
                                                if (i49 != i67) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i57 == 1) {
                                                    i49 = i61 + 8;
                                                    int i68 = zztk.zza;
                                                    zzue zzueVar2 = (zzue) zzvbVar2;
                                                    zzueVar2.zzf(Double.longBitsToDouble(zztk.zzq(bArr2, i61)));
                                                    while (i49 < i32) {
                                                        int zzj4 = zztk.zzj(bArr2, i49, zztjVar4);
                                                        if (i34 == zztjVar4.zza) {
                                                            zzueVar2.zzf(Double.longBitsToDouble(zztk.zzq(bArr2, zzj4)));
                                                            i49 = zzj4 + 8;
                                                        }
                                                    }
                                                }
                                                i49 = i61;
                                            }
                                            if (i49 != i61) {
                                                i4 = i3;
                                                i10 = i49;
                                                zztjVar2 = zztjVar4;
                                                i14 = i35;
                                                i16 = i33;
                                                unsafe2 = unsafe5;
                                                i11 = i34;
                                                obj3 = obj;
                                                break;
                                            } else {
                                                i47 = i3;
                                                i51 = i34;
                                                zztjVar7 = zztjVar4;
                                                i50 = i35;
                                                i53 = i33;
                                                i54 = i13;
                                                i48 = 0;
                                                i52 = i12;
                                                obj3 = obj;
                                                Unsafe unsafe12 = unsafe5;
                                                i46 = i32;
                                                unsafe7 = unsafe12;
                                            }
                                        case 19:
                                        case 36:
                                            zztjVar4 = zztjVar8;
                                            i32 = i2;
                                            i33 = i56;
                                            i34 = i59;
                                            i35 = i62;
                                            unsafe5 = unsafe8;
                                            if (i57 == 2) {
                                                int i69 = zztk.zza;
                                                zzuo zzuoVar = (zzuo) zzvbVar2;
                                                i49 = zztk.zzj(bArr2, i61, zztjVar4);
                                                int i70 = zztjVar4.zza + i49;
                                                while (i49 < i70) {
                                                    zzuoVar.zzf(Float.intBitsToFloat(zztk.zzc(bArr2, i49)));
                                                    i49 += 4;
                                                }
                                                if (i49 != i70) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i57 == 5) {
                                                    i49 = i61 + 4;
                                                    int i71 = zztk.zza;
                                                    zzuo zzuoVar2 = (zzuo) zzvbVar2;
                                                    zzuoVar2.zzf(Float.intBitsToFloat(zztk.zzc(bArr2, i61)));
                                                    while (i49 < i32) {
                                                        int zzj5 = zztk.zzj(bArr2, i49, zztjVar4);
                                                        if (i34 == zztjVar4.zza) {
                                                            zzuoVar2.zzf(Float.intBitsToFloat(zztk.zzc(bArr2, zzj5)));
                                                            i49 = zzj5 + 4;
                                                        }
                                                    }
                                                }
                                                i49 = i61;
                                            }
                                            if (i49 != i61) {
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            zztjVar4 = zztjVar8;
                                            i32 = i2;
                                            i33 = i56;
                                            i34 = i59;
                                            i35 = i62;
                                            unsafe5 = unsafe8;
                                            if (i57 == 2) {
                                                int i72 = zztk.zza;
                                                zzvl zzvlVar = (zzvl) zzvbVar2;
                                                i49 = zztk.zzj(bArr2, i61, zztjVar4);
                                                int i73 = zztjVar4.zza + i49;
                                                while (i49 < i73) {
                                                    i49 = zztk.zzm(bArr2, i49, zztjVar4);
                                                    zzvlVar.zzf(zztjVar4.zzb);
                                                }
                                                if (i49 != i73) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    int i74 = zztk.zza;
                                                    zzvl zzvlVar2 = (zzvl) zzvbVar2;
                                                    i49 = zztk.zzm(bArr2, i61, zztjVar4);
                                                    zzvlVar2.zzf(zztjVar4.zzb);
                                                    while (i49 < i32) {
                                                        int zzj6 = zztk.zzj(bArr2, i49, zztjVar4);
                                                        if (i34 == zztjVar4.zza) {
                                                            i49 = zztk.zzm(bArr2, zzj6, zztjVar4);
                                                            zzvlVar2.zzf(zztjVar4.zzb);
                                                        }
                                                    }
                                                }
                                                i49 = i61;
                                            }
                                            if (i49 != i61) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            zztjVar4 = zztjVar8;
                                            i36 = i56;
                                            i34 = i59;
                                            unsafe5 = unsafe8;
                                            if (i57 == 2) {
                                                i49 = zztk.zzg(bArr2, i61, zzvbVar2, zztjVar4);
                                                i33 = i36;
                                                i32 = i2;
                                                i35 = i62;
                                                if (i49 != i61) {
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    i35 = i62;
                                                    i33 = i36;
                                                    i32 = i2;
                                                    i49 = zztk.zzl(i34, bArr, i61, i2, zzvbVar2, zztjVar);
                                                    if (i49 != i61) {
                                                    }
                                                }
                                                i33 = i36;
                                                i32 = i2;
                                                i35 = i62;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            zztjVar4 = zztjVar8;
                                            i36 = i56;
                                            i34 = i59;
                                            unsafe5 = unsafe8;
                                            if (i57 == 2) {
                                                int i75 = zztk.zza;
                                                zzvl zzvlVar3 = (zzvl) zzvbVar2;
                                                i49 = zztk.zzj(bArr2, i61, zztjVar4);
                                                int i76 = zztjVar4.zza + i49;
                                                while (i49 < i76) {
                                                    zzvlVar3.zzf(zztk.zzq(bArr2, i49));
                                                    i49 += 8;
                                                }
                                                if (i49 != i76) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i57 == 1) {
                                                    i49 = i61 + 8;
                                                    int i77 = zztk.zza;
                                                    zzvl zzvlVar4 = (zzvl) zzvbVar2;
                                                    zzvlVar4.zzf(zztk.zzq(bArr2, i61));
                                                    while (i49 < i2) {
                                                        int zzj7 = zztk.zzj(bArr2, i49, zztjVar4);
                                                        if (i34 == zztjVar4.zza) {
                                                            zzvlVar4.zzf(zztk.zzq(bArr2, zzj7));
                                                            i49 = zzj7 + 8;
                                                        }
                                                    }
                                                }
                                                i33 = i36;
                                                i32 = i2;
                                                i35 = i62;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            i33 = i36;
                                            i32 = i2;
                                            i35 = i62;
                                            if (i49 != i61) {
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            zztjVar4 = zztjVar8;
                                            i36 = i56;
                                            i34 = i59;
                                            unsafe5 = unsafe8;
                                            if (i57 == 2) {
                                                int i78 = zztk.zza;
                                                zzux zzuxVar = (zzux) zzvbVar2;
                                                i49 = zztk.zzj(bArr2, i61, zztjVar4);
                                                int i79 = zztjVar4.zza + i49;
                                                while (i49 < i79) {
                                                    zzuxVar.zzf(zztk.zzc(bArr2, i49));
                                                    i49 += 4;
                                                }
                                                if (i49 != i79) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i57 == 5) {
                                                    i49 = i61 + 4;
                                                    int i80 = zztk.zza;
                                                    zzux zzuxVar2 = (zzux) zzvbVar2;
                                                    zzuxVar2.zzf(zztk.zzc(bArr2, i61));
                                                    while (i49 < i2) {
                                                        int zzj8 = zztk.zzj(bArr2, i49, zztjVar4);
                                                        if (i34 == zztjVar4.zza) {
                                                            zzuxVar2.zzf(zztk.zzc(bArr2, zzj8));
                                                            i49 = zzj8 + 4;
                                                        }
                                                    }
                                                }
                                                i33 = i36;
                                                i32 = i2;
                                                i35 = i62;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            i33 = i36;
                                            i32 = i2;
                                            i35 = i62;
                                            if (i49 != i61) {
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            zztjVar4 = zztjVar8;
                                            i36 = i56;
                                            i34 = i59;
                                            unsafe5 = unsafe8;
                                            if (i57 == 2) {
                                                int i81 = zztk.zza;
                                                zztl zztlVar = (zztl) zzvbVar2;
                                                i49 = zztk.zzj(bArr2, i61, zztjVar4);
                                                int i82 = zztjVar4.zza + i49;
                                                while (i49 < i82) {
                                                    i49 = zztk.zzm(bArr2, i49, zztjVar4);
                                                    zztlVar.zze(zztjVar4.zzb != 0);
                                                }
                                                if (i49 != i82) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    int i83 = zztk.zza;
                                                    zztl zztlVar2 = (zztl) zzvbVar2;
                                                    i49 = zztk.zzm(bArr2, i61, zztjVar4);
                                                    zztlVar2.zze(zztjVar4.zzb != 0);
                                                    while (i49 < i2) {
                                                        int zzj9 = zztk.zzj(bArr2, i49, zztjVar4);
                                                        if (i34 == zztjVar4.zza) {
                                                            i49 = zztk.zzm(bArr2, zzj9, zztjVar4);
                                                            zztlVar2.zze(zztjVar4.zzb != 0);
                                                        }
                                                    }
                                                }
                                                i33 = i36;
                                                i32 = i2;
                                                i35 = i62;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            i33 = i36;
                                            i32 = i2;
                                            i35 = i62;
                                            if (i49 != i61) {
                                            }
                                            break;
                                        case 26:
                                            i34 = i59;
                                            unsafe5 = unsafe8;
                                            if (i57 != 2) {
                                                i35 = i62;
                                                i33 = i56;
                                                zztjVar4 = zztjVar8;
                                                i32 = i2;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            } else if ((j & 536870912) == 0) {
                                                int zzj10 = zztk.zzj(bArr2, i61, zztjVar8);
                                                int i84 = zztjVar8.zza;
                                                if (i84 < 0) {
                                                    throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i84 == 0) {
                                                    obj2 = "";
                                                    zzvbVar2.add(obj2);
                                                } else {
                                                    obj2 = "";
                                                    zzvbVar2.add(new String(bArr2, zzj10, i84, zzvc.zza));
                                                    zzj10 += i84;
                                                }
                                                while (zzj10 < i2) {
                                                    int zzj11 = zztk.zzj(bArr2, zzj10, zztjVar8);
                                                    if (i34 == zztjVar8.zza) {
                                                        zzj10 = zztk.zzj(bArr2, zzj11, zztjVar8);
                                                        int i85 = zztjVar8.zza;
                                                        if (i85 < 0) {
                                                            throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i85 == 0) {
                                                            zzvbVar2.add(obj2);
                                                        } else {
                                                            zzvbVar2.add(new String(bArr2, zzj10, i85, zzvc.zza));
                                                            zzj10 += i85;
                                                        }
                                                    } else {
                                                        i35 = i62;
                                                        i49 = zzj10;
                                                        i33 = i56;
                                                        zztjVar4 = zztjVar8;
                                                        i32 = i2;
                                                        if (i49 != i61) {
                                                        }
                                                    }
                                                }
                                                i35 = i62;
                                                i49 = zzj10;
                                                i33 = i56;
                                                zztjVar4 = zztjVar8;
                                                i32 = i2;
                                                if (i49 != i61) {
                                                }
                                            } else {
                                                int zzj12 = zztk.zzj(bArr2, i61, zztjVar8);
                                                int i86 = zztjVar8.zza;
                                                if (i86 < 0) {
                                                    throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i86 == 0) {
                                                    zzvbVar2.add("");
                                                    i62 = i62;
                                                } else {
                                                    int i87 = zzj12 + i86;
                                                    if (zzxf.zzd(bArr2, zzj12, i87)) {
                                                        i62 = i62;
                                                        zzvbVar2.add(new String(bArr2, zzj12, i86, zzvc.zza));
                                                        zzj12 = i87;
                                                    } else {
                                                        throw new zzve(str);
                                                    }
                                                }
                                                while (zzj12 < i2) {
                                                    int zzj13 = zztk.zzj(bArr2, zzj12, zztjVar8);
                                                    if (i34 == zztjVar8.zza) {
                                                        zzj12 = zztk.zzj(bArr2, zzj13, zztjVar8);
                                                        int i88 = zztjVar8.zza;
                                                        if (i88 < 0) {
                                                            throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i88 == 0) {
                                                            zzvbVar2.add("");
                                                        } else {
                                                            int i89 = zzj12 + i88;
                                                            if (zzxf.zzd(bArr2, zzj12, i89)) {
                                                                zzvbVar2.add(new String(bArr2, zzj12, i88, zzvc.zza));
                                                                zzj12 = i89;
                                                            } else {
                                                                throw new zzve(str);
                                                            }
                                                        }
                                                    } else {
                                                        i49 = zzj12;
                                                        i33 = i56;
                                                        zztjVar4 = zztjVar8;
                                                        i32 = i2;
                                                        i35 = i62;
                                                        if (i49 != i61) {
                                                        }
                                                    }
                                                }
                                                i49 = zzj12;
                                                i33 = i56;
                                                zztjVar4 = zztjVar8;
                                                i32 = i2;
                                                i35 = i62;
                                                if (i49 != i61) {
                                                }
                                            }
                                            break;
                                        case 27:
                                            zztjVar5 = zztjVar8;
                                            i37 = i2;
                                            if (i57 == 2) {
                                                zzvzVar3 = this;
                                                i34 = i59;
                                                int zzf = zztk.zzf(zzvzVar3.zzv(i62), i59, bArr, i61, i2, zzvbVar2, zztjVar);
                                                i35 = i62;
                                                i61 = i61;
                                                unsafe5 = unsafe8;
                                                i33 = i56;
                                                i32 = i37;
                                                i49 = zzf;
                                                zztjVar4 = zztjVar5;
                                                if (i49 != i61) {
                                                }
                                            } else {
                                                zzvzVar3 = this;
                                                i34 = i59;
                                                i33 = i56;
                                                i35 = i62;
                                                unsafe5 = unsafe8;
                                                zztj zztjVar9 = zztjVar5;
                                                i32 = i37;
                                                zztjVar4 = zztjVar9;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            break;
                                        case 28:
                                            zztjVar5 = zztjVar8;
                                            i37 = i2;
                                            if (i57 == 2) {
                                                int zzj14 = zztk.zzj(bArr2, i61, zztjVar5);
                                                int i90 = zztjVar5.zza;
                                                if (i90 >= 0) {
                                                    if (i90 > bArr2.length - zzj14) {
                                                        throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i90 == 0) {
                                                        zzvbVar2.add(zztu.zzb);
                                                    } else {
                                                        zzvbVar2.add(zztu.zzj(bArr2, zzj14, i90));
                                                        zzj14 += i90;
                                                    }
                                                    while (zzj14 < i37) {
                                                        int zzj15 = zztk.zzj(bArr2, zzj14, zztjVar5);
                                                        if (i59 == zztjVar5.zza) {
                                                            zzj14 = zztk.zzj(bArr2, zzj15, zztjVar5);
                                                            int i91 = zztjVar5.zza;
                                                            if (i91 >= 0) {
                                                                if (i91 > bArr2.length - zzj14) {
                                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                if (i91 == 0) {
                                                                    zzvbVar2.add(zztu.zzb);
                                                                } else {
                                                                    zzvbVar2.add(zztu.zzj(bArr2, zzj14, i91));
                                                                    zzj14 += i91;
                                                                }
                                                            } else {
                                                                throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                        } else {
                                                            i49 = zzj14;
                                                            i33 = i56;
                                                            i34 = i59;
                                                            i35 = i62;
                                                            unsafe5 = unsafe8;
                                                            zzvzVar3 = this;
                                                            zztj zztjVar10 = zztjVar5;
                                                            i32 = i37;
                                                            zztjVar4 = zztjVar10;
                                                            if (i49 != i61) {
                                                            }
                                                        }
                                                    }
                                                    i49 = zzj14;
                                                    i33 = i56;
                                                    i34 = i59;
                                                    i35 = i62;
                                                    unsafe5 = unsafe8;
                                                    zzvzVar3 = this;
                                                    zztj zztjVar102 = zztjVar5;
                                                    i32 = i37;
                                                    zztjVar4 = zztjVar102;
                                                    if (i49 != i61) {
                                                    }
                                                } else {
                                                    throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                            } else {
                                                zzvzVar3 = this;
                                                i33 = i56;
                                                i34 = i59;
                                                i35 = i62;
                                                unsafe5 = unsafe8;
                                                zztj zztjVar92 = zztjVar5;
                                                i32 = i37;
                                                zztjVar4 = zztjVar92;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i38 = i59;
                                            if (i57 == 2) {
                                                zzl = zztk.zzg(bArr2, i61, zzvbVar2, zztjVar8);
                                                zztjVar5 = zztjVar8;
                                                i37 = i2;
                                                i39 = i62;
                                            } else if (i57 == 0) {
                                                zztjVar5 = zztjVar8;
                                                i39 = i62;
                                                i37 = i2;
                                                zzl = zztk.zzl(i38, bArr, i61, i2, zzvbVar2, zztjVar);
                                            } else {
                                                zzvzVar3 = this;
                                                zztjVar4 = zztjVar8;
                                                i32 = i2;
                                                i33 = i56;
                                                i34 = i38;
                                                i35 = i62;
                                                unsafe5 = unsafe8;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            zzva zzu2 = zzvzVar3.zzu(i39);
                                            zzwv zzwvVar = zzvzVar3.zzl;
                                            int i92 = zzwj.zza;
                                            if (zzu2 == null) {
                                                i40 = zzl;
                                                i41 = i39;
                                            } else if (zzvbVar2 instanceof RandomAccess) {
                                                int size2 = zzvbVar2.size();
                                                i40 = zzl;
                                                Object obj4 = null;
                                                int i93 = 0;
                                                int i94 = 0;
                                                while (i93 < size2) {
                                                    Integer num = (Integer) zzvbVar2.get(i93);
                                                    int i95 = i39;
                                                    int intValue = num.intValue();
                                                    if (zzu2.zza(intValue)) {
                                                        if (i93 != i94) {
                                                            zzvbVar2.set(i94, num);
                                                        }
                                                        i94++;
                                                    } else {
                                                        obj4 = zzwj.zzn(obj3, i56, intValue, obj4, zzwvVar);
                                                    }
                                                    i93++;
                                                    i39 = i95;
                                                }
                                                i41 = i39;
                                                if (i94 != size2) {
                                                    zzvbVar2.subList(i94, size2).clear();
                                                }
                                            } else {
                                                i40 = zzl;
                                                i41 = i39;
                                                Iterator it = zzvbVar2.iterator();
                                                Object obj5 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!zzu2.zza(intValue2)) {
                                                        obj5 = zzwj.zzn(obj3, i56, intValue2, obj5, zzwvVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            zzvzVar3 = this;
                                            i49 = i40;
                                            i33 = i56;
                                            i34 = i38;
                                            i35 = i41;
                                            unsafe5 = unsafe8;
                                            zztj zztjVar1022 = zztjVar5;
                                            i32 = i37;
                                            zztjVar4 = zztjVar1022;
                                            if (i49 != i61) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i38 = i59;
                                            if (i57 == 2) {
                                                int i96 = zztk.zza;
                                                zzux zzuxVar3 = (zzux) zzvbVar2;
                                                zzj = zztk.zzj(bArr2, i61, zztjVar8);
                                                int i97 = zztjVar8.zza + zzj;
                                                while (zzj < i97) {
                                                    zzj = zztk.zzj(bArr2, zzj, zztjVar8);
                                                    zzuxVar3.zzf(zzty.zzb(zztjVar8.zza));
                                                }
                                                if (zzj != i97) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    int i98 = zztk.zza;
                                                    zzux zzuxVar4 = (zzux) zzvbVar2;
                                                    zzj = zztk.zzj(bArr2, i61, zztjVar8);
                                                    zzuxVar4.zzf(zzty.zzb(zztjVar8.zza));
                                                    while (zzj < i2) {
                                                        int zzj16 = zztk.zzj(bArr2, zzj, zztjVar8);
                                                        if (i38 == zztjVar8.zza) {
                                                            zzj = zztk.zzj(bArr2, zzj16, zztjVar8);
                                                            zzuxVar4.zzf(zzty.zzb(zztjVar8.zza));
                                                        }
                                                    }
                                                }
                                                zztjVar4 = zztjVar8;
                                                i32 = i2;
                                                i33 = i56;
                                                i34 = i38;
                                                i35 = i62;
                                                unsafe5 = unsafe8;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            zztjVar4 = zztjVar8;
                                            i49 = zzj;
                                            i32 = i2;
                                            i33 = i56;
                                            i34 = i38;
                                            i35 = i62;
                                            unsafe5 = unsafe8;
                                            if (i49 != i61) {
                                            }
                                            break;
                                        case 34:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                            if (i57 == 2) {
                                                int i99 = zztk.zza;
                                                zzvl zzvlVar5 = (zzvl) zzvbVar2;
                                                int zzj17 = zztk.zzj(bArr2, i61, zztjVar8);
                                                int i100 = zztjVar8.zza + zzj17;
                                                while (zzj17 < i100) {
                                                    zzj17 = zztk.zzm(bArr2, zzj17, zztjVar8);
                                                    zzvlVar5.zzf(zzty.zzc(zztjVar8.zzb));
                                                }
                                                if (zzj17 != i100) {
                                                    throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zztjVar4 = zztjVar8;
                                                i49 = zzj17;
                                                i32 = i2;
                                                i33 = i56;
                                                i34 = i59;
                                                i35 = i62;
                                                unsafe5 = unsafe8;
                                                if (i49 != i61) {
                                                }
                                            } else if (i57 == 0) {
                                                int i101 = zztk.zza;
                                                zzvl zzvlVar6 = (zzvl) zzvbVar2;
                                                zzj = zztk.zzm(bArr2, i61, zztjVar8);
                                                zzvlVar6.zzf(zzty.zzc(zztjVar8.zzb));
                                                while (true) {
                                                    if (zzj < i2) {
                                                        int zzj18 = zztk.zzj(bArr2, zzj, zztjVar8);
                                                        i38 = i59;
                                                        if (i38 == zztjVar8.zza) {
                                                            zzj = zztk.zzm(bArr2, zzj18, zztjVar8);
                                                            zzvlVar6.zzf(zzty.zzc(zztjVar8.zzb));
                                                            i59 = i38;
                                                        }
                                                    } else {
                                                        i38 = i59;
                                                    }
                                                }
                                                zztjVar4 = zztjVar8;
                                                i49 = zzj;
                                                i32 = i2;
                                                i33 = i56;
                                                i34 = i38;
                                                i35 = i62;
                                                unsafe5 = unsafe8;
                                                if (i49 != i61) {
                                                }
                                            } else {
                                                zztjVar4 = zztjVar8;
                                                i32 = i2;
                                                i33 = i56;
                                                i34 = i59;
                                                i35 = i62;
                                                unsafe5 = unsafe8;
                                                i49 = i61;
                                                if (i49 != i61) {
                                                }
                                            }
                                            break;
                                        default:
                                            zztjVar4 = zztjVar8;
                                            i32 = i2;
                                            i33 = i56;
                                            i34 = i59;
                                            i35 = i62;
                                            unsafe5 = unsafe8;
                                            if (i57 == 3) {
                                                int i102 = (i34 & (-8)) | 4;
                                                zzwh zzv = zzvzVar3.zzv(i35);
                                                i49 = zztk.zzd(zzv, bArr, i61, i2, i102, zztjVar);
                                                zzvbVar2.add(zztjVar4.zzc);
                                                while (i49 < i32) {
                                                    int zzj19 = zztk.zzj(bArr2, i49, zztjVar4);
                                                    if (i34 == zztjVar4.zza) {
                                                        i49 = zztk.zzd(zzv, bArr, zzj19, i2, i102, zztjVar);
                                                        zzvbVar2.add(zztjVar4.zzc);
                                                    } else if (i49 != i61) {
                                                    }
                                                }
                                                if (i49 != i61) {
                                                }
                                            }
                                            i49 = i61;
                                            if (i49 != i61) {
                                            }
                                            break;
                                    }
                                }
                            } else if (i57 == 2) {
                                zzvb zzvbVar3 = (zzvb) unsafe8.getObject(obj3, j2);
                                if (!zzvbVar3.zzc()) {
                                    int size3 = zzvbVar3.size();
                                    zzvbVar3 = zzvbVar3.zzd(size3 != 0 ? size3 + size3 : 10);
                                    unsafe8.putObject(obj3, j2, zzvbVar3);
                                }
                                zzvb zzvbVar4 = zzvbVar3;
                                i53 = i56;
                                int zzf2 = zztk.zzf(zzvzVar3.zzv(i60), i59, bArr, i61, i2, zzvbVar4, zztjVar);
                                i47 = i3;
                                zztjVar7 = zztjVar8;
                                unsafe7 = unsafe8;
                                i49 = zzf2;
                                i50 = i60;
                                i46 = i2;
                                i54 = i13;
                                i51 = i59;
                                i48 = 0;
                                i52 = i12;
                            } else {
                                zztjVar3 = zztjVar8;
                                i29 = i60;
                                i30 = i59;
                                i31 = i56;
                                i4 = i3;
                                i10 = i61;
                                i14 = i29;
                                unsafe2 = unsafe8;
                                i16 = i31;
                                i11 = i30;
                                zztjVar2 = zztjVar3;
                            }
                        } else {
                            int i103 = iArr[i9 + 2];
                            int i104 = 1 << (i103 >>> 20);
                            int i105 = i103 & 1048575;
                            if (i105 != i54) {
                                if (i54 != 1048575) {
                                    unsafe7.putInt(obj3, i54, i52);
                                }
                                i52 = i105 == 1048575 ? 0 : unsafe7.getInt(obj3, i105);
                                i13 = i105;
                            } else {
                                i13 = i54;
                            }
                            switch (zzr) {
                                case 0:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 1) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i49 = i20 + 8;
                                        i52 |= i104;
                                        zzxc.zzo(obj3, j2, Double.longBitsToDouble(zztk.zzq(bArr2, i20)));
                                        i47 = i3;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                case 1:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 5) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i49 = i20 + 4;
                                        i52 |= i104;
                                        zzxc.zzp(obj3, j2, Float.intBitsToFloat(zztk.zzc(bArr2, i20)));
                                        i47 = i3;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                case 2:
                                case 3:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 0) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        int i106 = i52 | i104;
                                        int zzm2 = zztk.zzm(bArr2, i20, zztjVar7);
                                        unsafe7.putLong(obj, j2, zztjVar7.zzb);
                                        i47 = i3;
                                        i52 = i106;
                                        i49 = zzm2;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                case 4:
                                case 11:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 0) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i52 |= i104;
                                        i49 = zztk.zzj(bArr2, i20, zztjVar7);
                                        unsafe7.putInt(obj3, j2, zztjVar7.zza);
                                        i47 = i3;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                case 5:
                                case 14:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 1) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        unsafe7.putLong(obj, j2, zztk.zzq(bArr2, i20));
                                        i47 = i3;
                                        i49 = i20 + 8;
                                        i52 = i104 | i52;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                case 6:
                                case 13:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 5) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i49 = i20 + 4;
                                        i52 |= i104;
                                        unsafe7.putInt(obj3, j2, zztk.zzc(bArr2, i20));
                                        i47 = i3;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                case 7:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 0) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i52 |= i104;
                                        i49 = zztk.zzm(bArr2, i20, zztjVar7);
                                        zzxc.zzm(obj3, j2, zztjVar7.zzb != 0);
                                        i47 = i3;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                case 8:
                                    int i107 = i7;
                                    i21 = i9;
                                    int i108 = i59;
                                    if (i57 != 2) {
                                        i22 = i52;
                                        i23 = i107;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i59 = i108;
                                        i24 = i21;
                                        i25 = i56;
                                        i15 = 0;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        if ((i58 & C.BUFFER_FLAG_LAST_SAMPLE) == 0) {
                                            i59 = i108;
                                            i48 = 0;
                                            i52 |= i104;
                                            i49 = zztk.zzh(bArr2, i107, zztjVar7);
                                        } else {
                                            i49 = zztk.zzj(bArr2, i107, zztjVar7);
                                            int i109 = zztjVar7.zza;
                                            if (i109 < 0) {
                                                throw new zzve("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            int i110 = i52 | i104;
                                            if (i109 != 0) {
                                                int length = bArr2.length;
                                                int i111 = zzxf.zza;
                                                if ((i49 | i109 | ((length - i49) - i109)) < 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i49), Integer.valueOf(i109)));
                                                }
                                                int i112 = i49 + i109;
                                                char[] cArr = new char[i109];
                                                int i113 = 0;
                                                while (i49 < i112) {
                                                    byte b2 = bArr2[i49];
                                                    if (zzxd.zzd(b2)) {
                                                        i49++;
                                                        cArr[i113] = (char) b2;
                                                        i113++;
                                                    } else {
                                                        while (i49 < i112) {
                                                            int i114 = i49 + 1;
                                                            byte b3 = bArr2[i49];
                                                            if (zzxd.zzd(b3)) {
                                                                cArr[i113] = (char) b3;
                                                                i113++;
                                                                i49 = i114;
                                                                while (i49 < i112) {
                                                                    byte b4 = bArr2[i49];
                                                                    if (zzxd.zzd(b4)) {
                                                                        i49++;
                                                                        cArr[i113] = (char) b4;
                                                                        i113++;
                                                                    }
                                                                }
                                                            } else {
                                                                int i115 = i110;
                                                                if (b3 >= -32) {
                                                                    int i116 = i108;
                                                                    String str2 = str;
                                                                    if (b3 < -16) {
                                                                        if (i114 < i112 - 1) {
                                                                            zzxd.zzb(b3, bArr2[i114], bArr2[i49 + 2], cArr, i113);
                                                                            str = str2;
                                                                            i113++;
                                                                            i110 = i115;
                                                                            i108 = i116;
                                                                            i49 += 3;
                                                                        } else {
                                                                            throw new zzve(str2);
                                                                        }
                                                                    } else if (i114 < i112 - 2) {
                                                                        byte b5 = bArr2[i114];
                                                                        int i117 = i49 + 3;
                                                                        byte b6 = bArr2[i49 + 2];
                                                                        i49 += 4;
                                                                        zzxd.zza(b3, b5, b6, bArr2[i117], cArr, i113);
                                                                        i113 += 2;
                                                                        str = str2;
                                                                        i110 = i115;
                                                                        i108 = i116;
                                                                    } else {
                                                                        throw new zzve(str2);
                                                                    }
                                                                } else if (i114 < i112) {
                                                                    i49 += 2;
                                                                    zzxd.zzc(b3, bArr2[i114], cArr, i113);
                                                                    i113++;
                                                                    i110 = i115;
                                                                } else {
                                                                    throw new zzve(str);
                                                                }
                                                            }
                                                        }
                                                        i26 = i110;
                                                        i59 = i108;
                                                        i48 = 0;
                                                        zztjVar7.zzc = new String(cArr, 0, i113);
                                                        i49 = i112;
                                                    }
                                                }
                                                while (i49 < i112) {
                                                }
                                                i26 = i110;
                                                i59 = i108;
                                                i48 = 0;
                                                zztjVar7.zzc = new String(cArr, 0, i113);
                                                i49 = i112;
                                            } else {
                                                zztjVar7.zzc = "";
                                                i26 = i110;
                                                i59 = i108;
                                                i48 = 0;
                                            }
                                            i52 = i26;
                                        }
                                        unsafe7.putObject(obj3, j2, zztjVar7.zzc);
                                        i47 = i3;
                                        i50 = i21;
                                        i54 = i13;
                                        i51 = i59;
                                        i53 = i56;
                                        i46 = i2;
                                    }
                                    break;
                                case 9:
                                    i27 = i9;
                                    i28 = i59;
                                    if (i57 != 2) {
                                        i23 = i7;
                                        i22 = i52;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i59 = i28;
                                        i24 = i27;
                                        i25 = i56;
                                        i15 = 0;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        int i118 = i52 | i104;
                                        Object zzx = zzvzVar3.zzx(obj3, i27);
                                        i49 = zztk.zzo(zzx, zzvzVar3.zzv(i27), bArr, i7, i2, zztjVar);
                                        zzvzVar3.zzF(obj3, i27, zzx);
                                        i52 = i118;
                                        i51 = i28;
                                        i50 = i27;
                                        i54 = i13;
                                        i53 = i56;
                                        i48 = 0;
                                        i46 = i2;
                                        i47 = i3;
                                    }
                                case 10:
                                    i27 = i9;
                                    i28 = i59;
                                    if (i57 != 2) {
                                        i23 = i7;
                                        i22 = i52;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i59 = i28;
                                        i24 = i27;
                                        i25 = i56;
                                        i15 = 0;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i52 |= i104;
                                        i49 = zztk.zza(bArr2, i7, zztjVar7);
                                        unsafe7.putObject(obj3, j2, zztjVar7.zzc);
                                        i51 = i28;
                                        i50 = i27;
                                        i54 = i13;
                                        i53 = i56;
                                        i48 = 0;
                                        i46 = i2;
                                        i47 = i3;
                                    }
                                case 12:
                                    i27 = i9;
                                    i28 = i59;
                                    if (i57 != 0) {
                                        i23 = i7;
                                        i22 = i52;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i59 = i28;
                                        i24 = i27;
                                        i25 = i56;
                                        i15 = 0;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i49 = zztk.zzj(bArr2, i7, zztjVar7);
                                        int i119 = zztjVar7.zza;
                                        zzva zzu3 = zzvzVar3.zzu(i27);
                                        if ((i58 & Integer.MIN_VALUE) == 0 || zzu3 == null || zzu3.zza(i119)) {
                                            i52 |= i104;
                                            unsafe7.putInt(obj3, j2, i119);
                                        } else {
                                            zzd(obj).zzj(i28, Long.valueOf(i119));
                                        }
                                        i51 = i28;
                                        i50 = i27;
                                        i54 = i13;
                                        i53 = i56;
                                        i48 = 0;
                                        i46 = i2;
                                        i47 = i3;
                                    }
                                case 15:
                                    i27 = i9;
                                    i28 = i59;
                                    if (i57 != 0) {
                                        i23 = i7;
                                        i22 = i52;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i59 = i28;
                                        i24 = i27;
                                        i25 = i56;
                                        i15 = 0;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        i52 |= i104;
                                        i49 = zztk.zzj(bArr2, i7, zztjVar7);
                                        unsafe7.putInt(obj3, j2, zzty.zzb(zztjVar7.zza));
                                        i51 = i28;
                                        i50 = i27;
                                        i54 = i13;
                                        i53 = i56;
                                        i48 = 0;
                                        i46 = i2;
                                        i47 = i3;
                                    }
                                case 16:
                                    if (i57 != 0) {
                                        i23 = i7;
                                        i22 = i52;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i25 = i56;
                                        i15 = 0;
                                        i24 = i9;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        int i120 = i52 | i104;
                                        int zzm3 = zztk.zzm(bArr2, i7, zztjVar7);
                                        i27 = i9;
                                        i28 = i59;
                                        unsafe7.putLong(obj, j2, zzty.zzc(zztjVar7.zzb));
                                        i52 = i120;
                                        i49 = zzm3;
                                        i51 = i28;
                                        i50 = i27;
                                        i54 = i13;
                                        i53 = i56;
                                        i48 = 0;
                                        i46 = i2;
                                        i47 = i3;
                                    }
                                default:
                                    i20 = i7;
                                    i21 = i9;
                                    i48 = 0;
                                    if (i57 != 3) {
                                        i22 = i52;
                                        i23 = i20;
                                        i15 = i48;
                                        unsafe4 = unsafe7;
                                        zztjVar2 = zztjVar7;
                                        i24 = i21;
                                        i25 = i56;
                                        i4 = i3;
                                        i16 = i25;
                                        unsafe2 = unsafe4;
                                        i12 = i22;
                                        i10 = i23;
                                        i11 = i59;
                                        i14 = i24;
                                        break;
                                    } else {
                                        Object zzx2 = zzvzVar3.zzx(obj3, i21);
                                        i53 = i56;
                                        int zzn2 = zztk.zzn(zzx2, zzvzVar3.zzv(i21), bArr, i20, i2, (i56 << 3) | 4, zztjVar);
                                        zzvzVar3.zzF(obj3, i21, zzx2);
                                        i47 = i3;
                                        zztjVar7 = zztjVar;
                                        unsafe7 = unsafe7;
                                        i50 = i21;
                                        i46 = i2;
                                        i49 = zzn2;
                                        i54 = i13;
                                        i51 = i59;
                                        i48 = 0;
                                        i52 |= i104;
                                    }
                            }
                        }
                    } else {
                        i10 = i7;
                        i11 = i6;
                        i12 = i52;
                        i13 = i54;
                        i14 = i48;
                        i15 = i14;
                        unsafe2 = unsafe7;
                        zztjVar2 = zztjVar7;
                        i4 = i47;
                        i16 = i56;
                    }
                    if (i11 == i4 || i4 == 0) {
                        if (this.zzh) {
                            zzuh zzuhVar = zztjVar2.zzd;
                            int i121 = zzuh.zzb;
                            int i122 = zzwe.zza;
                            if (zzuhVar != zzuh.zza) {
                                zzvw zzvwVar = this.zzg;
                                zzwv zzwvVar2 = this.zzl;
                                zzuh zzuhVar2 = zztjVar2.zzd;
                                int i123 = zztk.zza;
                                zzuu zzb3 = zzuhVar2.zzb(zzvwVar, i16);
                                if (zzb3 == null) {
                                    i49 = zztk.zzi(i11, bArr, i10, i2, zzd(obj), zztjVar);
                                    i19 = i2;
                                    i17 = i16;
                                    zzvzVar2 = this;
                                    i18 = i11;
                                    unsafe3 = unsafe2;
                                } else {
                                    zzus zzusVar = (zzus) obj3;
                                    zzusVar.zzb();
                                    i17 = i16;
                                    i18 = i11;
                                    i49 = zztk.zzb(i11, bArr, i10, i2, zzusVar, zzb3, zzwvVar2, zztjVar);
                                    unsafe3 = unsafe2;
                                    zzvzVar2 = this;
                                    i19 = i2;
                                }
                                bArr2 = bArr;
                                zztjVar7 = zztjVar;
                                i47 = i4;
                                i46 = i19;
                                unsafe7 = unsafe3;
                                zzvzVar3 = zzvzVar2;
                                i53 = i17;
                                i54 = i13;
                                i50 = i14;
                                i48 = i15;
                                i52 = i12;
                                i51 = i18;
                            }
                        }
                        i17 = i16;
                        i18 = i11;
                        unsafe3 = unsafe2;
                        zzvzVar2 = this;
                        i19 = i2;
                        i49 = zztk.zzi(i18, bArr, i10, i2, zzd(obj), zztjVar);
                        bArr2 = bArr;
                        zztjVar7 = zztjVar;
                        i47 = i4;
                        i46 = i19;
                        unsafe7 = unsafe3;
                        zzvzVar3 = zzvzVar2;
                        i53 = i17;
                        i54 = i13;
                        i50 = i14;
                        i48 = i15;
                        i52 = i12;
                        i51 = i18;
                    } else {
                        zzvzVar = this;
                        i5 = i2;
                        i49 = i10;
                        i51 = i11;
                        i54 = i13;
                        i52 = i12;
                        unsafe = unsafe2;
                    }
                } else {
                    zzq = zzvzVar3.zzq(i56, i48);
                }
                i9 = zzq;
                i8 = -1;
                if (i9 == i8) {
                }
                if (i11 == i4) {
                }
                if (this.zzh) {
                }
                i17 = i16;
                i18 = i11;
                unsafe3 = unsafe2;
                zzvzVar2 = this;
                i19 = i2;
                i49 = zztk.zzi(i18, bArr, i10, i2, zzd(obj), zztjVar);
                bArr2 = bArr;
                zztjVar7 = zztjVar;
                i47 = i4;
                i46 = i19;
                unsafe7 = unsafe3;
                zzvzVar3 = zzvzVar2;
                i53 = i17;
                i54 = i13;
                i50 = i14;
                i48 = i15;
                i52 = i12;
                i51 = i18;
            } else {
                zzvzVar = zzvzVar3;
                unsafe = unsafe7;
                i4 = i47;
                i5 = i46;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final Object zze() {
        return ((zzuw) this.zzg).zzy();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzuw) {
                zzuw zzuwVar = (zzuw) obj;
                zzuwVar.zzG(Integer.MAX_VALUE);
                zzuwVar.zza = 0;
                zzuwVar.zzE();
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
                                ((zzvb) zzxc.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzvq) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
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

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            int i2 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i3 = iArr[i];
            long j = i2;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzxc.zzo(obj, j, zzxc.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzxc.zzp(obj, j, zzxc.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzxc.zzr(obj, j, zzxc.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzxc.zzr(obj, j, zzxc.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzxc.zzq(obj, j, zzxc.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzxc.zzr(obj, j, zzxc.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzxc.zzq(obj, j, zzxc.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzxc.zzm(obj, j, zzxc.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzxc.zzs(obj, j, zzxc.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzxc.zzs(obj, j, zzxc.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzxc.zzq(obj, j, zzxc.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzxc.zzq(obj, j, zzxc.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzxc.zzq(obj, j, zzxc.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzxc.zzr(obj, j, zzxc.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzxc.zzq(obj, j, zzxc.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzxc.zzr(obj, j, zzxc.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
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
                    zzvb zzvbVar = (zzvb) zzxc.zzf(obj, j);
                    zzvb zzvbVar2 = (zzvb) zzxc.zzf(obj2, j);
                    int size = zzvbVar.size();
                    int size2 = zzvbVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzvbVar.zzc()) {
                            zzvbVar = zzvbVar.zzd(size2 + size);
                        }
                        zzvbVar.addAll(zzvbVar2);
                    }
                    if (size > 0) {
                        zzvbVar2 = zzvbVar;
                    }
                    zzxc.zzs(obj, j, zzvbVar2);
                    break;
                case 50:
                    int i4 = zzwj.zza;
                    zzxc.zzs(obj, j, zzvr.zza(zzxc.zzf(obj, j), zzxc.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzxc.zzs(obj, j, zzxc.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
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
                    if (zzM(obj2, i3, i)) {
                        zzxc.zzs(obj, j, zzxc.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzwj.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zzwj.zzo(this.zzm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zztj zztjVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zztjVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0095. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(Object obj, zzxi zzxiVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int[] iArr;
        int i;
        int i2;
        Map.Entry entry2;
        int i3;
        Iterator it2;
        int[] iArr2;
        boolean z;
        boolean z2;
        Map.Entry entry3;
        if (this.zzh) {
            zzum zzumVar = ((zzus) obj).zzb;
            if (!zzumVar.zza.isEmpty()) {
                Iterator zzf = zzumVar.zzf();
                entry = (Map.Entry) zzf.next();
                it = zzf;
                iArr = this.zzc;
                Unsafe unsafe = zzb;
                int i4 = 1048575;
                int i5 = 0;
                i = 0;
                while (i < iArr.length) {
                    int zzs = zzs(i);
                    int[] iArr3 = this.zzc;
                    int zzr = zzr(zzs);
                    int i6 = iArr3[i];
                    if (zzr <= 17) {
                        int i7 = iArr3[i + 2];
                        int i8 = i7 & 1048575;
                        if (i8 != i4) {
                            if (i8 == 1048575) {
                                entry3 = entry;
                                i5 = 0;
                            } else {
                                entry3 = entry;
                                i5 = unsafe.getInt(obj, i8);
                            }
                            i4 = i8;
                        } else {
                            entry3 = entry;
                        }
                        i3 = 1 << (i7 >>> 20);
                        i2 = i5;
                        entry2 = entry3;
                    } else {
                        i2 = i5;
                        entry2 = entry;
                        i3 = 0;
                    }
                    int i9 = i4;
                    while (entry2 != null) {
                        if (i6 >= 202056002) {
                            this.zzm.zzb(zzxiVar, entry2);
                            entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                        } else {
                            long j = zzs & 1048575;
                            switch (zzr) {
                                case 0:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzf(i6, zzxc.zza(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 1:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzo(i6, zzxc.zzb(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 2:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzt(i6, unsafe.getLong(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 3:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzK(i6, unsafe.getLong(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 4:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzr(i6, unsafe.getInt(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 5:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzm(i6, unsafe.getLong(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 6:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzk(i6, unsafe.getInt(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 7:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzb(i6, zzxc.zzw(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 8:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzO(i6, unsafe.getObject(obj, j), zzxiVar);
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 9:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzv(i6, unsafe.getObject(obj, j), zzv(i));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 10:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzd(i6, (zztu) unsafe.getObject(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 11:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzI(i6, unsafe.getInt(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 12:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzi(i6, unsafe.getInt(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 13:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzx(i6, unsafe.getInt(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 14:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzz(i6, unsafe.getLong(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 15:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzB(i6, unsafe.getInt(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 16:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzD(i6, unsafe.getLong(obj, j));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 17:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zzJ(obj, i, i9, i2, i3)) {
                                        zzxiVar.zzq(i6, unsafe.getObject(obj, j), zzv(i));
                                    }
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 18:
                                    z = false;
                                    zzwj.zzs(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 19:
                                    z = false;
                                    zzwj.zzw(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 20:
                                    z = false;
                                    zzwj.zzz(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 21:
                                    z = false;
                                    zzwj.zzH(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 22:
                                    z = false;
                                    zzwj.zzy(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 23:
                                    z = false;
                                    zzwj.zzv(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 24:
                                    z = false;
                                    zzwj.zzu(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 25:
                                    z = false;
                                    zzwj.zzq(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 26:
                                    zzwj.zzF(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 27:
                                    zzwj.zzA(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, zzv(i));
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 28:
                                    zzwj.zzr(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 29:
                                    z2 = false;
                                    zzwj.zzG(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 30:
                                    z2 = false;
                                    zzwj.zzt(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 31:
                                    z2 = false;
                                    zzwj.zzB(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 32:
                                    z2 = false;
                                    zzwj.zzC(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 33:
                                    z2 = false;
                                    zzwj.zzD(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 34:
                                    z2 = false;
                                    zzwj.zzE(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 35:
                                    zzwj.zzs(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 36:
                                    zzwj.zzw(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 37:
                                    zzwj.zzz(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 38:
                                    zzwj.zzH(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 39:
                                    zzwj.zzy(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 40:
                                    zzwj.zzv(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 41:
                                    zzwj.zzu(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 42:
                                    zzwj.zzq(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 43:
                                    zzwj.zzG(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 44:
                                    zzwj.zzt(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 45:
                                    zzwj.zzB(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 46:
                                    zzwj.zzC(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 47:
                                    zzwj.zzD(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                    zzwj.zzE(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    zzwj.zzx(this.zzc[i], (List) unsafe.getObject(obj, j), zzxiVar, zzv(i));
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 50:
                                    if (unsafe.getObject(obj, j) != null) {
                                        throw null;
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzf(i6, zzm(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzo(i6, zzn(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzt(i6, zzt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzK(i6, zzt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzr(i6, zzo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 56:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzm(i6, zzt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 57:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzk(i6, zzo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 58:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzb(i6, zzN(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 59:
                                    if (zzM(obj, i6, i)) {
                                        zzO(i6, unsafe.getObject(obj, j), zzxiVar);
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzv(i6, unsafe.getObject(obj, j), zzv(i));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzd(i6, (zztu) unsafe.getObject(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 62:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzI(i6, zzo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzi(i6, zzo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 64:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzx(i6, zzo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 65:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzz(i6, zzt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzB(i6, zzo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 67:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzD(i6, zzt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                case 68:
                                    if (zzM(obj, i6, i)) {
                                        zzxiVar.zzq(i6, unsafe.getObject(obj, j), zzv(i));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                                default:
                                    it2 = it;
                                    iArr2 = iArr;
                                    i += 3;
                                    i4 = i9;
                                    entry = entry2;
                                    it = it2;
                                    iArr = iArr2;
                                    i5 = i2;
                            }
                        }
                    }
                    long j2 = zzs & 1048575;
                    switch (zzr) {
                    }
                }
                Iterator it3 = it;
                while (entry != null) {
                    this.zzm.zzb(zzxiVar, entry);
                    entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
                }
                ((zzuw) obj).zzc.zzl(zzxiVar);
            }
        }
        entry = null;
        it = null;
        iArr = this.zzc;
        Unsafe unsafe2 = zzb;
        int i42 = 1048575;
        int i52 = 0;
        i = 0;
        while (i < iArr.length) {
        }
        Iterator it32 = it;
        while (entry != null) {
        }
        ((zzuw) obj).zzc.zzl(zzxiVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzj(Object obj, Object obj2) {
        int i;
        boolean zzI;
        for (0; i < this.zzc.length; i + 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    i = (zzH(obj, obj2, i) && Double.doubleToLongBits(zzxc.zza(obj, j)) == Double.doubleToLongBits(zzxc.zza(obj2, j))) ? i + 3 : 0;
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzxc.zzb(obj, j)) == Float.floatToIntBits(zzxc.zzb(obj2, j))) {
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzxc.zzd(obj, j) == zzxc.zzd(obj2, j)) {
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzxc.zzd(obj, j) == zzxc.zzd(obj2, j)) {
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzxc.zzc(obj, j) == zzxc.zzc(obj2, j)) {
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzxc.zzd(obj, j) == zzxc.zzd(obj2, j)) {
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzxc.zzc(obj, j) == zzxc.zzc(obj2, j)) {
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzxc.zzw(obj, j) == zzxc.zzw(obj2, j)) {
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zzwj.zzI(zzxc.zzf(obj, j), zzxc.zzf(obj2, j))) {
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zzwj.zzI(zzxc.zzf(obj, j), zzxc.zzf(obj2, j))) {
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zzwj.zzI(zzxc.zzf(obj, j), zzxc.zzf(obj2, j))) {
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzxc.zzc(obj, j) == zzxc.zzc(obj2, j)) {
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzxc.zzc(obj, j) == zzxc.zzc(obj2, j)) {
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzxc.zzc(obj, j) == zzxc.zzc(obj2, j)) {
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzxc.zzd(obj, j) == zzxc.zzd(obj2, j)) {
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzxc.zzc(obj, j) == zzxc.zzc(obj2, j)) {
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzxc.zzd(obj, j) == zzxc.zzd(obj2, j)) {
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zzwj.zzI(zzxc.zzf(obj, j), zzxc.zzf(obj2, j))) {
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
                    zzI = zzwj.zzI(zzxc.zzf(obj, j), zzxc.zzf(obj2, j));
                    if (zzI) {
                        return false;
                    }
                case 50:
                    zzI = zzwj.zzI(zzxc.zzf(obj, j), zzxc.zzf(obj2, j));
                    if (zzI) {
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
                    if (zzxc.zzc(obj, zzp) == zzxc.zzc(obj2, zzp) && zzwj.zzI(zzxc.zzf(obj, j), zzxc.zzf(obj2, j))) {
                    }
                    return false;
                default:
            }
        }
        if (!((zzuw) obj).zzc.equals(((zzuw) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzus) obj).zzb.equals(((zzus) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
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
                        if (zzr == 50 && !((zzvq) zzxc.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzxc.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzwh zzv = zzv(i6);
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
        return !this.zzh || ((zzus) obj).zzb.zzl();
    }
}
