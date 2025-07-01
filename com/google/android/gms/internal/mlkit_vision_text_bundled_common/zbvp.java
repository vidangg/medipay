package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

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
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbvp<T> implements zbvx<T> {
    private static final int[] zba = new int[0];
    private static final Unsafe zbb = zbws.zbg();
    private final int[] zbc;
    private final Object[] zbd;
    private final int zbe;
    private final int zbf;
    private final zbvm zbg;
    private final boolean zbh;
    private final int[] zbi;
    private final int zbj;
    private final int zbk;
    private final zbwl zbl;
    private final zbtq zbm;

    private zbvp(int[] iArr, Object[] objArr, int i, int i2, zbvm zbvmVar, boolean z, int[] iArr2, int i3, int i4, zbvs zbvsVar, zbuy zbuyVar, zbwl zbwlVar, zbtq zbtqVar, zbvh zbvhVar) {
        this.zbc = iArr;
        this.zbd = objArr;
        this.zbe = i;
        this.zbf = i2;
        boolean z2 = false;
        if (zbtqVar != null && (zbvmVar instanceof zbub)) {
            z2 = true;
        }
        this.zbh = z2;
        this.zbi = iArr2;
        this.zbj = i3;
        this.zbk = i4;
        this.zbl = zbwlVar;
        this.zbm = zbtqVar;
        this.zbg = zbvmVar;
    }

    private static void zbA(Object obj) {
        if (!zbL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zbB(Object obj, Object obj2, int i) {
        if (zbI(obj2, i)) {
            int zbs = zbs(i) & 1048575;
            Unsafe unsafe = zbb;
            long j = zbs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zbc[i] + " is present but null: " + obj2.toString());
            }
            zbvx zbv = zbv(i);
            if (!zbI(obj, i)) {
                if (!zbL(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zbe = zbv.zbe();
                    zbv.zbg(zbe, object);
                    unsafe.putObject(obj, j, zbe);
                }
                zbD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zbL(object2)) {
                Object zbe2 = zbv.zbe();
                zbv.zbg(zbe2, object2);
                unsafe.putObject(obj, j, zbe2);
                object2 = zbe2;
            }
            zbv.zbg(object2, object);
        }
    }

    private final void zbC(Object obj, Object obj2, int i) {
        int i2 = this.zbc[i];
        if (zbM(obj2, i2, i)) {
            int zbs = zbs(i) & 1048575;
            Unsafe unsafe = zbb;
            long j = zbs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zbc[i] + " is present but null: " + obj2.toString());
            }
            zbvx zbv = zbv(i);
            if (!zbM(obj, i2, i)) {
                if (!zbL(object)) {
                    unsafe.putObject(obj, j, object);
                } else {
                    Object zbe = zbv.zbe();
                    zbv.zbg(zbe, object);
                    unsafe.putObject(obj, j, zbe);
                }
                zbE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zbL(object2)) {
                Object zbe2 = zbv.zbe();
                zbv.zbg(zbe2, object2);
                unsafe.putObject(obj, j, zbe2);
                object2 = zbe2;
            }
            zbv.zbg(object2, object);
        }
    }

    private final void zbD(Object obj, int i) {
        int zbp = zbp(i);
        long j = 1048575 & zbp;
        if (j == 1048575) {
            return;
        }
        zbws.zbq(obj, j, (1 << (zbp >>> 20)) | zbws.zbc(obj, j));
    }

    private final void zbE(Object obj, int i, int i2) {
        zbws.zbq(obj, zbp(i2) & 1048575, i);
    }

    private final void zbF(Object obj, int i, Object obj2) {
        zbb.putObject(obj, zbs(i) & 1048575, obj2);
        zbD(obj, i);
    }

    private final void zbG(Object obj, int i, int i2, Object obj2) {
        zbb.putObject(obj, zbs(i2) & 1048575, obj2);
        zbE(obj, i, i2);
    }

    private final boolean zbH(Object obj, Object obj2, int i) {
        return zbI(obj, i) == zbI(obj2, i);
    }

    private final boolean zbI(Object obj, int i) {
        int zbp = zbp(i);
        long j = zbp & 1048575;
        if (j != 1048575) {
            return (zbws.zbc(obj, j) & (1 << (zbp >>> 20))) != 0;
        }
        int zbs = zbs(i);
        long j2 = zbs & 1048575;
        switch (zbr(zbs)) {
            case 0:
                return Double.doubleToRawLongBits(zbws.zba(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zbws.zbb(obj, j2)) != 0;
            case 2:
                return zbws.zbd(obj, j2) != 0;
            case 3:
                return zbws.zbd(obj, j2) != 0;
            case 4:
                return zbws.zbc(obj, j2) != 0;
            case 5:
                return zbws.zbd(obj, j2) != 0;
            case 6:
                return zbws.zbc(obj, j2) != 0;
            case 7:
                return zbws.zbw(obj, j2);
            case 8:
                Object zbf = zbws.zbf(obj, j2);
                if (zbf instanceof String) {
                    return !((String) zbf).isEmpty();
                }
                if (zbf instanceof zbtc) {
                    return !zbtc.zbb.equals(zbf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zbws.zbf(obj, j2) != null;
            case 10:
                return !zbtc.zbb.equals(zbws.zbf(obj, j2));
            case 11:
                return zbws.zbc(obj, j2) != 0;
            case 12:
                return zbws.zbc(obj, j2) != 0;
            case 13:
                return zbws.zbc(obj, j2) != 0;
            case 14:
                return zbws.zbd(obj, j2) != 0;
            case 15:
                return zbws.zbc(obj, j2) != 0;
            case 16:
                return zbws.zbd(obj, j2) != 0;
            case 17:
                return zbws.zbf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zbJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zbI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zbK(Object obj, int i, zbvx zbvxVar) {
        return zbvxVar.zbk(zbws.zbf(obj, i & 1048575));
    }

    private static boolean zbL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zbuf) {
            return ((zbuf) obj).zbG();
        }
        return true;
    }

    private final boolean zbM(Object obj, int i, int i2) {
        return zbws.zbc(obj, (long) (zbp(i2) & 1048575)) == i;
    }

    private static boolean zbN(Object obj, long j) {
        return ((Boolean) zbws.zbf(obj, j)).booleanValue();
    }

    private static final int zbO(byte[] bArr, int i, int i2, zbww zbwwVar, Class cls, zbsq zbsqVar) throws IOException {
        int i3;
        zbww zbwwVar2 = zbww.DOUBLE;
        switch (zbwwVar) {
            case DOUBLE:
                i3 = i + 8;
                zbsqVar.zbc = Double.valueOf(Double.longBitsToDouble(zbsr.zbr(bArr, i)));
                break;
            case FLOAT:
                i3 = i + 4;
                zbsqVar.zbc = Float.valueOf(Float.intBitsToFloat(zbsr.zbc(bArr, i)));
                break;
            case INT64:
            case UINT64:
                int zbn = zbsr.zbn(bArr, i, zbsqVar);
                zbsqVar.zbc = Long.valueOf(zbsqVar.zbb);
                return zbn;
            case INT32:
            case UINT32:
            case ENUM:
                int zbk = zbsr.zbk(bArr, i, zbsqVar);
                zbsqVar.zbc = Integer.valueOf(zbsqVar.zba);
                return zbk;
            case FIXED64:
            case SFIXED64:
                i3 = i + 8;
                zbsqVar.zbc = Long.valueOf(zbsr.zbr(bArr, i));
                break;
            case FIXED32:
            case SFIXED32:
                i3 = i + 4;
                zbsqVar.zbc = Integer.valueOf(zbsr.zbc(bArr, i));
                break;
            case BOOL:
                int zbn2 = zbsr.zbn(bArr, i, zbsqVar);
                zbsqVar.zbc = Boolean.valueOf(zbsqVar.zbb != 0);
                return zbn2;
            case STRING:
                return zbsr.zbi(bArr, i, zbsqVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zbsr.zbe(zbvu.zba().zbb(cls), bArr, i, i2, zbsqVar);
            case BYTES:
                return zbsr.zba(bArr, i, zbsqVar);
            case SINT32:
                int zbk2 = zbsr.zbk(bArr, i, zbsqVar);
                zbsqVar.zbc = Integer.valueOf(zbtg.zbb(zbsqVar.zba));
                return zbk2;
            case SINT64:
                int zbn3 = zbsr.zbn(bArr, i, zbsqVar);
                zbsqVar.zbc = Long.valueOf(zbtg.zbc(zbsqVar.zbb));
                return zbn3;
        }
        return i3;
    }

    private static final void zbP(int i, Object obj, zbwy zbwyVar) throws IOException {
        if (obj instanceof String) {
            zbwyVar.zbH(i, (String) obj);
        } else {
            zbwyVar.zbd(i, (zbtc) obj);
        }
    }

    static zbwm zbd(Object obj) {
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVar = zbufVar.zbc;
        if (zbwmVar != zbwm.zbc()) {
            return zbwmVar;
        }
        zbwm zbf = zbwm.zbf();
        zbufVar.zbc = zbf;
        return zbf;
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
    public static zbvp zbl(Class cls, zbvj zbvjVar, zbvs zbvsVar, zbuy zbuyVar, zbwl zbwlVar, zbtq zbtqVar, zbvh zbvhVar) {
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
        zbvw zbvwVar;
        String str;
        int objectFieldOffset;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Field zbz;
        int i25;
        char charAt11;
        int i26;
        int i27;
        int i28;
        int i29;
        Object obj;
        Field zbz2;
        Object obj2;
        Field zbz3;
        int i30;
        char charAt12;
        int i31;
        char charAt13;
        int i32;
        char charAt14;
        int i33;
        char charAt15;
        if (zbvjVar instanceof zbvw) {
            zbvw zbvwVar2 = (zbvw) zbvjVar;
            String zbd = zbvwVar2.zbd();
            int length = zbd.length();
            char c = 55296;
            if (zbd.charAt(0) >= 55296) {
                int i34 = 1;
                while (true) {
                    i = i34 + 1;
                    if (zbd.charAt(i34) < 55296) {
                        break;
                    }
                    i34 = i;
                }
            } else {
                i = 1;
            }
            int i35 = i + 1;
            int charAt16 = zbd.charAt(i);
            if (charAt16 >= 55296) {
                int i36 = charAt16 & 8191;
                int i37 = 13;
                while (true) {
                    i33 = i35 + 1;
                    charAt15 = zbd.charAt(i35);
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
                iArr = zba;
                i6 = 0;
            } else {
                int i38 = i35 + 1;
                int charAt17 = zbd.charAt(i35);
                if (charAt17 >= 55296) {
                    int i39 = charAt17 & 8191;
                    int i40 = 13;
                    while (true) {
                        i14 = i38 + 1;
                        charAt10 = zbd.charAt(i38);
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
                int charAt18 = zbd.charAt(i38);
                if (charAt18 >= 55296) {
                    int i42 = charAt18 & 8191;
                    int i43 = 13;
                    while (true) {
                        i13 = i41 + 1;
                        charAt9 = zbd.charAt(i41);
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
                int charAt19 = zbd.charAt(i41);
                if (charAt19 >= 55296) {
                    int i45 = charAt19 & 8191;
                    int i46 = 13;
                    while (true) {
                        i12 = i44 + 1;
                        charAt8 = zbd.charAt(i44);
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
                int charAt20 = zbd.charAt(i44);
                if (charAt20 >= 55296) {
                    int i48 = charAt20 & 8191;
                    int i49 = 13;
                    while (true) {
                        i11 = i47 + 1;
                        charAt7 = zbd.charAt(i47);
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
                charAt = zbd.charAt(i47);
                if (charAt >= 55296) {
                    int i51 = charAt & 8191;
                    int i52 = 13;
                    while (true) {
                        i10 = i50 + 1;
                        charAt6 = zbd.charAt(i50);
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
                charAt2 = zbd.charAt(i50);
                if (charAt2 >= 55296) {
                    int i54 = charAt2 & 8191;
                    int i55 = 13;
                    while (true) {
                        i9 = i53 + 1;
                        charAt5 = zbd.charAt(i53);
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
                int charAt21 = zbd.charAt(i53);
                if (charAt21 >= 55296) {
                    int i57 = charAt21 & 8191;
                    int i58 = 13;
                    while (true) {
                        i8 = i56 + 1;
                        charAt4 = zbd.charAt(i56);
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
                int charAt22 = zbd.charAt(i56);
                if (charAt22 >= 55296) {
                    int i60 = charAt22 & 8191;
                    int i61 = 13;
                    while (true) {
                        i7 = i59 + 1;
                        charAt3 = zbd.charAt(i59);
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
            Unsafe unsafe = zbb;
            Object[] zbe = zbvwVar2.zbe();
            Class<?> cls2 = zbvwVar2.zba().getClass();
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
                int charAt23 = zbd.charAt(i35);
                if (charAt23 >= c) {
                    int i70 = charAt23 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i32 = i71 + 1;
                        charAt14 = zbd.charAt(i71);
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
                int charAt24 = zbd.charAt(i15);
                if (charAt24 >= c) {
                    int i74 = charAt24 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i31 = i75 + 1;
                        charAt13 = zbd.charAt(i75);
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
                    int charAt25 = zbd.charAt(i16);
                    if (charAt25 >= 55296) {
                        int i82 = charAt25 & 8191;
                        int i83 = i81;
                        int i84 = 13;
                        while (true) {
                            i30 = i83 + 1;
                            charAt12 = zbd.charAt(i83);
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
                        objArr[i87 + i87 + 1] = zbe[i4];
                    } else {
                        if (i85 == 12) {
                            if (zbvwVar2.zbc() == 1 || i79 != 0) {
                                i29 = i4 + 1;
                                int i88 = i68 / 3;
                                objArr[i88 + i88 + 1] = zbe[i4];
                            } else {
                                i79 = 0;
                            }
                        }
                        int i89 = charAt25 + charAt25;
                        obj = zbe[i89];
                        if (!(obj instanceof Field)) {
                            zbz2 = (Field) obj;
                        } else {
                            zbz2 = zbz(cls2, (String) obj);
                            zbe[i89] = zbz2;
                        }
                        int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zbz2);
                        int i90 = i89 + 1;
                        obj2 = zbe[i90];
                        int i91 = i79;
                        if (!(obj2 instanceof Field)) {
                            zbz3 = (Field) obj2;
                        } else {
                            zbz3 = zbz(cls2, (String) obj2);
                            zbe[i90] = zbz3;
                        }
                        i18 = i4;
                        i22 = i86;
                        i19 = charAt23;
                        i20 = (int) unsafe.objectFieldOffset(zbz3);
                        i23 = 0;
                        str = zbd;
                        zbvwVar = zbvwVar2;
                        objectFieldOffset = objectFieldOffset2;
                        i24 = i91;
                    }
                    i4 = i29;
                    int i892 = charAt25 + charAt25;
                    obj = zbe[i892];
                    if (!(obj instanceof Field)) {
                    }
                    int objectFieldOffset22 = (int) unsafe.objectFieldOffset(zbz2);
                    int i902 = i892 + 1;
                    obj2 = zbe[i902];
                    int i912 = i79;
                    if (!(obj2 instanceof Field)) {
                    }
                    i18 = i4;
                    i22 = i86;
                    i19 = charAt23;
                    i20 = (int) unsafe.objectFieldOffset(zbz3);
                    i23 = 0;
                    str = zbd;
                    zbvwVar = zbvwVar2;
                    objectFieldOffset = objectFieldOffset22;
                    i24 = i912;
                } else {
                    i17 = i2;
                    i18 = i4 + 1;
                    Field zbz4 = zbz(cls2, (String) zbe[i4]);
                    i19 = charAt23;
                    if (i77 == 9 || i77 == 17) {
                        zbvwVar = zbvwVar2;
                        int i92 = i68 / 3;
                        objArr[i92 + i92 + 1] = zbz4.getType();
                    } else {
                        if (i77 == 27) {
                            zbvwVar = zbvwVar2;
                            i26 = 1;
                            i27 = i4 + 2;
                        } else if (i77 == 49) {
                            i27 = i4 + 2;
                            zbvwVar = zbvwVar2;
                            i26 = 1;
                        } else {
                            if (i77 == 12 || i77 == 30 || i77 == 44) {
                                zbvwVar = zbvwVar2;
                                if (zbvwVar2.zbc() == 1 || i79 != 0) {
                                    i27 = i4 + 2;
                                    int i93 = i68 / 3;
                                    objArr[i93 + i93 + 1] = zbe[i18];
                                    str = zbd;
                                    i18 = i27;
                                } else {
                                    str = zbd;
                                    i79 = 0;
                                }
                            } else if (i77 == 50) {
                                int i94 = i4 + 2;
                                int i95 = i65 + 1;
                                iArr[i65] = i68;
                                int i96 = i68 / 3;
                                int i97 = i96 + i96;
                                objArr[i97] = zbe[i18];
                                if (i79 != 0) {
                                    i18 = i4 + 3;
                                    objArr[i97 + 1] = zbe[i94];
                                    str = zbd;
                                    i65 = i95;
                                    zbvwVar = zbvwVar2;
                                } else {
                                    i18 = i94;
                                    i65 = i95;
                                    i79 = 0;
                                    zbvwVar = zbvwVar2;
                                }
                            } else {
                                zbvwVar = zbvwVar2;
                            }
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zbz4);
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
                                Object obj3 = zbe[i101];
                                i22 = i98;
                                if (obj3 instanceof Field) {
                                    zbz = (Field) obj3;
                                } else {
                                    zbz = zbz(cls2, (String) obj3);
                                    zbe[i101] = zbz;
                                }
                                i21 = i79;
                                i23 = charAt26 % 32;
                                i20 = (int) unsafe.objectFieldOffset(zbz);
                            }
                            if (i77 >= 18 && i77 <= 49) {
                                iArr[i66] = objectFieldOffset;
                                i66++;
                            }
                            i24 = i21;
                        }
                        int i102 = i68 / 3;
                        objArr[i102 + i102 + i26] = zbe[i18];
                        str = zbd;
                        i18 = i27;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zbz4);
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
                    str = zbd;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zbz4);
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
                zbd = str;
                i4 = i18;
                length = i78;
                i5 = i80;
                cls2 = cls3;
                zbvwVar2 = zbvwVar;
                i35 = i22;
                i2 = i17;
                c = 55296;
            }
            return new zbvp(iArr3, objArr, i2, i5, zbvwVar2.zba(), false, iArr, i3, i63, zbvsVar, zbuyVar, zbwlVar, zbtqVar, zbvhVar);
        }
        throw null;
    }

    private static double zbm(Object obj, long j) {
        return ((Double) zbws.zbf(obj, j)).doubleValue();
    }

    private static float zbn(Object obj, long j) {
        return ((Float) zbws.zbf(obj, j)).floatValue();
    }

    private static int zbo(Object obj, long j) {
        return ((Integer) zbws.zbf(obj, j)).intValue();
    }

    private final int zbp(int i) {
        return this.zbc[i + 2];
    }

    private final int zbq(int i, int i2) {
        int length = (this.zbc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zbc[i4];
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

    private static int zbr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zbs(int i) {
        return this.zbc[i + 1];
    }

    private static long zbt(Object obj, long j) {
        return ((Long) zbws.zbf(obj, j)).longValue();
    }

    private final zbuj zbu(int i) {
        int i2 = i / 3;
        return (zbuj) this.zbd[i2 + i2 + 1];
    }

    private final zbvx zbv(int i) {
        Object[] objArr = this.zbd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zbvx zbvxVar = (zbvx) objArr[i3];
        if (zbvxVar != null) {
            return zbvxVar;
        }
        zbvx zbb2 = zbvu.zba().zbb((Class) objArr[i3 + 1]);
        this.zbd[i3] = zbb2;
        return zbb2;
    }

    private final Object zbw(int i) {
        int i2 = i / 3;
        return this.zbd[i2 + i2];
    }

    private final Object zbx(Object obj, int i) {
        zbvx zbv = zbv(i);
        int zbs = zbs(i) & 1048575;
        if (!zbI(obj, i)) {
            return zbv.zbe();
        }
        Object object = zbb.getObject(obj, zbs);
        if (zbL(object)) {
            return object;
        }
        Object zbe = zbv.zbe();
        if (object != null) {
            zbv.zbg(zbe, object);
        }
        return zbe;
    }

    private final Object zby(Object obj, int i, int i2) {
        zbvx zbv = zbv(i2);
        if (!zbM(obj, i, i2)) {
            return zbv.zbe();
        }
        Object object = zbb.getObject(obj, zbs(i2) & 1048575);
        if (zbL(object)) {
            return object;
        }
        Object zbe = zbv.zbe();
        if (object != null) {
            zbv.zbg(zbe, object);
        }
        return zbe;
    }

    private static Field zbz(Class cls, String str) {
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
    /* JADX WARN: Type inference failed for: r0v253, types: [int] */
    /* JADX WARN: Type inference failed for: r0v260, types: [int] */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
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
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v120, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v163 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [int] */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82, types: [int] */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85, types: [int] */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zba(Object obj) {
        int i;
        int i2;
        ?? r5;
        int zbD;
        int zbD2;
        int zbD3;
        int zbE;
        int zbD4;
        int zbD5;
        int zbd;
        int zbD6;
        ?? zbg;
        int size;
        int zbD7;
        int zbC;
        int zbC2;
        ?? r3;
        int zbB;
        ?? r1;
        ?? r0;
        int zbe;
        int zbD8;
        int zbD9;
        ?? r4;
        Unsafe unsafe = zbb;
        boolean z = false;
        int i3 = 1048575;
        ?? r12 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zbc.length) {
            int zbs = zbs(i4);
            int zbr = zbr(zbs);
            int[] iArr = this.zbc;
            int i7 = iArr[i4];
            int i8 = iArr[i4 + 2];
            int i9 = i8 & i3;
            if (zbr <= 17) {
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
            int i10 = zbs & i3;
            if (zbr >= zbtv.DOUBLE_LIST_PACKED.zba()) {
                zbtv.SINT64_LIST_PACKED.zba();
            }
            long j = i10;
            switch (zbr) {
                case 0:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbD = zbtk.zbD(i7 << 3);
                        r0 = zbD + 8;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbD2 = zbtk.zbD(i7 << 3);
                        r0 = zbD2 + 4;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(j2);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(j3);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(j4);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbD = zbtk.zbD(i7 << 3);
                        r0 = zbD + 8;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbD2 = zbtk.zbD(i7 << 3);
                        r0 = zbD2 + 4;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbD4 = zbtk.zbD(i7 << 3);
                        r0 = zbD4 + 1;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zbJ(obj, i4, i, i2, r5)) {
                        break;
                    } else {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zbtc) {
                            zbD5 = zbtk.zbD(i11);
                            zbd = ((zbtc) object).zbd();
                            zbD6 = zbtk.zbD(zbd);
                            r0 = zbD5 + zbD6 + zbd;
                            i5 += r0;
                            break;
                        } else {
                            zbD3 = zbtk.zbD(i11);
                            zbE = zbtk.zbC((String) object);
                            r0 = zbD3 + zbE;
                            i5 += r0;
                        }
                    }
                case 9:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        r0 = zbvz.zbh(i7, unsafe.getObject(obj, j), zbv(i4));
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbtc zbtcVar = (zbtc) unsafe.getObject(obj, j);
                        zbD5 = zbtk.zbD(i7 << 3);
                        zbd = zbtcVar.zbd();
                        zbD6 = zbtk.zbD(zbd);
                        r0 = zbD5 + zbD6 + zbd;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbD(i12);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(j5);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbD2 = zbtk.zbD(i7 << 3);
                        r0 = zbD2 + 4;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        zbD = zbtk.zbD(i7 << 3);
                        r0 = zbD + 8;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbD((i13 >> 31) ^ (i13 + i13));
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE((j6 >> 63) ^ (j6 + j6));
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zbJ(obj, i4, i, i2, r5)) {
                        r0 = zbtk.zbz(i7, (zbvm) unsafe.getObject(obj, j), zbv(i4));
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    r0 = zbvz.zbd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    break;
                case 19:
                    r0 = zbvz.zbb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zbvz.zba;
                    if (list.size() != 0) {
                        zbg = zbvz.zbg(list) + (list.size() * zbtk.zbD(i7 << 3));
                        i5 += zbg;
                        break;
                    }
                    zbg = z;
                    i5 += zbg;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zbvz.zba;
                    size = list2.size();
                    if (size != 0) {
                        zbD3 = zbvz.zbl(list2);
                        zbD7 = zbtk.zbD(i7 << 3);
                        zbE = size * zbD7;
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    }
                    r0 = z;
                    i5 += r0;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zbvz.zba;
                    size = list3.size();
                    if (size != 0) {
                        zbD3 = zbvz.zbf(list3);
                        zbD7 = zbtk.zbD(i7 << 3);
                        zbE = size * zbD7;
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    }
                    r0 = z;
                    i5 += r0;
                case 23:
                    r0 = zbvz.zbd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    break;
                case 24:
                    r0 = zbvz.zbb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zbvz.zba;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        r0 = size2 * (zbtk.zbD(i7 << 3) + 1);
                        i5 += r0;
                        break;
                    }
                    r0 = z;
                    i5 += r0;
                case 26:
                    ?? r02 = (List) unsafe.getObject(obj, j);
                    int i18 = zbvz.zba;
                    int size3 = r02.size();
                    if (size3 != 0) {
                        int zbD10 = zbtk.zbD(i7 << 3) * size3;
                        if (r02 instanceof zbux) {
                            zbux zbuxVar = (zbux) r02;
                            zbg = zbD10;
                            for (?? r32 = z; r32 < size3; r32++) {
                                Object zba2 = zbuxVar.zba();
                                if (zba2 instanceof zbtc) {
                                    int zbd2 = ((zbtc) zba2).zbd();
                                    zbC2 = zbg + zbtk.zbD(zbd2) + zbd2;
                                } else {
                                    zbC2 = zbg + zbtk.zbC((String) zba2);
                                }
                                zbg = zbC2;
                            }
                        } else {
                            zbg = zbD10;
                            for (?? r33 = z; r33 < size3; r33++) {
                                Object obj2 = r02.get(r33);
                                if (obj2 instanceof zbtc) {
                                    int zbd3 = ((zbtc) obj2).zbd();
                                    zbC = zbg + zbtk.zbD(zbd3) + zbd3;
                                } else {
                                    zbC = zbg + zbtk.zbC((String) obj2);
                                }
                                zbg = zbC;
                            }
                        }
                        i5 += zbg;
                        break;
                    }
                    zbg = z;
                    i5 += zbg;
                case 27:
                    ?? r03 = (List) unsafe.getObject(obj, j);
                    zbvx zbv = zbv(i4);
                    int i19 = zbvz.zba;
                    int size4 = r03.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        r3 = zbtk.zbD(i7 << 3) * size4;
                        for (?? r42 = z; r42 < size4; r42++) {
                            Object obj3 = r03.get(r42);
                            if (obj3 instanceof zbuw) {
                                int zba3 = ((zbuw) obj3).zba();
                                zbB = (r3 == true ? 1 : 0) + zbtk.zbD(zba3) + zba3;
                            } else {
                                zbB = (r3 == true ? 1 : 0) + zbtk.zbB((zbvm) obj3, zbv);
                            }
                            r3 = zbB;
                        }
                    }
                    i5 += r3;
                    break;
                case 28:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    int i20 = zbvz.zba;
                    int size5 = r04.size();
                    if (size5 == 0) {
                        r1 = z;
                    } else {
                        r1 = size5 * zbtk.zbD(i7 << 3);
                        for (?? r2 = z; r2 < r04.size(); r2++) {
                            int zbd4 = ((zbtc) r04.get(r2)).zbd();
                            r1 += zbtk.zbD(zbd4) + zbd4;
                        }
                    }
                    i5 += r1;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zbvz.zba;
                    size = list5.size();
                    if (size != 0) {
                        zbD3 = zbvz.zbk(list5);
                        zbD7 = zbtk.zbD(i7 << 3);
                        zbE = size * zbD7;
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    }
                    r0 = z;
                    i5 += r0;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zbvz.zba;
                    size = list6.size();
                    if (size != 0) {
                        zbD3 = zbvz.zba(list6);
                        zbD7 = zbtk.zbD(i7 << 3);
                        zbE = size * zbD7;
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    }
                    r0 = z;
                    i5 += r0;
                case 31:
                    r0 = zbvz.zbb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    break;
                case 32:
                    r0 = zbvz.zbd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zbvz.zba;
                    size = list7.size();
                    if (size != 0) {
                        zbD3 = zbvz.zbi(list7);
                        zbD7 = zbtk.zbD(i7 << 3);
                        zbE = size * zbD7;
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    }
                    r0 = z;
                    i5 += r0;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zbvz.zba;
                    size = list8.size();
                    if (size != 0) {
                        zbD3 = zbvz.zbj(list8);
                        zbD7 = zbtk.zbD(i7 << 3);
                        zbE = size * zbD7;
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    }
                    r0 = z;
                    i5 += r0;
                case 35:
                    zbe = zbvz.zbe((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zbe = zbvz.zbc((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zbe = zbvz.zbg((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zbe = zbvz.zbl((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zbe = zbvz.zbf((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zbe = zbvz.zbe((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zbe = zbvz.zbc((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zbvz.zba;
                    zbe = list9.size();
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zbe = zbvz.zbk((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zbe = zbvz.zba((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zbe = zbvz.zbc((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zbe = zbvz.zbe((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zbe = zbvz.zbi((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    zbe = zbvz.zbj((List) unsafe.getObject(obj, j));
                    if (zbe > 0) {
                        zbD8 = zbtk.zbD(i7 << 3);
                        zbD9 = zbtk.zbD(zbe);
                        r1 = zbD8 + zbD9 + zbe;
                        i5 += r1;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    ?? r05 = (List) unsafe.getObject(obj, j);
                    zbvx zbv2 = zbv(i4);
                    int i26 = zbvz.zba;
                    int size6 = r05.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        ?? r34 = z2;
                        while (r34 < size6) {
                            int zbz = zbtk.zbz(i7, (zbvm) r05.get(r34), zbv2);
                            r34++;
                            r4 = (r4 == true ? 1 : 0) + zbz;
                        }
                    }
                    i5 += r4;
                    break;
                case 50:
                    zbvg zbvgVar = (zbvg) unsafe.getObject(obj, j);
                    zbvf zbvfVar = (zbvf) zbw(i4);
                    if (!zbvgVar.isEmpty()) {
                        zbg = z;
                        for (Map.Entry entry : zbvgVar.entrySet()) {
                            zbg += zbvfVar.zba(i7, entry.getKey(), entry.getValue());
                        }
                        i5 += zbg;
                        break;
                    }
                    zbg = z;
                    i5 += zbg;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zbM(obj, i7, i4)) {
                        zbD = zbtk.zbD(i7 << 3);
                        r0 = zbD + 8;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (zbM(obj, i7, i4)) {
                        zbD2 = zbtk.zbD(i7 << 3);
                        r0 = zbD2 + 4;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zbM(obj, i7, i4)) {
                        long zbt = zbt(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(zbt);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zbM(obj, i7, i4)) {
                        long zbt2 = zbt(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(zbt2);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zbM(obj, i7, i4)) {
                        long zbo = zbo(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(zbo);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zbM(obj, i7, i4)) {
                        zbD = zbtk.zbD(i7 << 3);
                        r0 = zbD + 8;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zbM(obj, i7, i4)) {
                        zbD2 = zbtk.zbD(i7 << 3);
                        r0 = zbD2 + 4;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zbM(obj, i7, i4)) {
                        zbD4 = zbtk.zbD(i7 << 3);
                        r0 = zbD4 + 1;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zbM(obj, i7, i4)) {
                        break;
                    } else {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zbtc) {
                            zbD5 = zbtk.zbD(i27);
                            zbd = ((zbtc) object2).zbd();
                            zbD6 = zbtk.zbD(zbd);
                            r0 = zbD5 + zbD6 + zbd;
                            i5 += r0;
                            break;
                        } else {
                            zbD3 = zbtk.zbD(i27);
                            zbE = zbtk.zbC((String) object2);
                            r0 = zbD3 + zbE;
                            i5 += r0;
                        }
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zbM(obj, i7, i4)) {
                        r0 = zbvz.zbh(i7, unsafe.getObject(obj, j), zbv(i4));
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zbM(obj, i7, i4)) {
                        zbtc zbtcVar2 = (zbtc) unsafe.getObject(obj, j);
                        zbD5 = zbtk.zbD(i7 << 3);
                        zbd = zbtcVar2.zbd();
                        zbD6 = zbtk.zbD(zbd);
                        r0 = zbD5 + zbD6 + zbd;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zbM(obj, i7, i4)) {
                        int zbo2 = zbo(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbD(zbo2);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zbM(obj, i7, i4)) {
                        long zbo3 = zbo(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE(zbo3);
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zbM(obj, i7, i4)) {
                        zbD2 = zbtk.zbD(i7 << 3);
                        r0 = zbD2 + 4;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zbM(obj, i7, i4)) {
                        zbD = zbtk.zbD(i7 << 3);
                        r0 = zbD + 8;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zbM(obj, i7, i4)) {
                        int zbo4 = zbo(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbD((zbo4 >> 31) ^ (zbo4 + zbo4));
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zbM(obj, i7, i4)) {
                        long zbt3 = zbt(obj, j);
                        zbD3 = zbtk.zbD(i7 << 3);
                        zbE = zbtk.zbE((zbt3 >> 63) ^ (zbt3 + zbt3));
                        r0 = zbD3 + zbE;
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zbM(obj, i7, i4)) {
                        r0 = zbtk.zbz(i7, (zbvm) unsafe.getObject(obj, j), zbv(i4));
                        i5 += r0;
                        break;
                    } else {
                        break;
                    }
            }
            i4 += 3;
            i6 = i;
            r12 = i2;
            z = false;
            i3 = 1048575;
        }
        int zba4 = i5 + ((zbuf) obj).zbc.zba();
        if (!this.zbh) {
            return zba4;
        }
        zbtu zbtuVar = ((zbub) obj).zbb;
        int zbc = zbtuVar.zba.zbc();
        int i28 = 0;
        for (int i29 = 0; i29 < zbc; i29++) {
            Map.Entry zbg2 = zbtuVar.zba.zbg(i29);
            i28 += zbtu.zbb((zbtt) ((zbwb) zbg2).zba(), zbg2.getValue());
        }
        for (Map.Entry entry2 : zbtuVar.zba.zbd()) {
            i28 += zbtu.zbb((zbtt) entry2.getKey(), entry2.getValue());
        }
        return zba4 + i28;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zbb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zbc.length; i4 += 3) {
            int zbs = zbs(i4);
            int[] iArr = this.zbc;
            int i5 = 1048575 & zbs;
            int zbr = zbr(zbs);
            int i6 = iArr[i4];
            long j = i5;
            int i7 = 37;
            switch (zbr) {
                case 0:
                    i = i3 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zbws.zba(obj, j));
                    byte[] bArr = zbuo.zbb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zbws.zbb(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr2 = zbuo.zbb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr3 = zbuo.zbb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr4 = zbuo.zbb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zbuo.zba(zbws.zbw(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zbws.zbf(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zbf = zbws.zbf(obj, j);
                    if (zbf != null) {
                        i7 = zbf.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr5 = zbuo.zbb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr6 = zbuo.zbb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zbf2 = zbws.zbf(obj, j);
                    if (zbf2 != null) {
                        i7 = zbf2.hashCode();
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
                    floatToIntBits = zbws.zbf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zbws.zbf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zbm(obj, j));
                        byte[] bArr7 = zbuo.zbb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zbn(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zbt(obj, j);
                        byte[] bArr8 = zbuo.zbb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zbt(obj, j);
                        byte[] bArr9 = zbuo.zbb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zbt(obj, j);
                        byte[] bArr10 = zbuo.zbb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbuo.zba(zbN(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zbws.zbf(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbws.zbf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbws.zbf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zbt(obj, j);
                        byte[] bArr11 = zbuo.zbb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zbt(obj, j);
                        byte[] bArr12 = zbuo.zbb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zbws.zbf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + ((zbuf) obj).zbc.hashCode();
        return this.zbh ? (hashCode * 53) + ((zbub) obj).zbb.zba.hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0dc3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0dc9, code lost:
    
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0dca, code lost:
    
        r3 = r3 + 1;
        r4 = (com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwm) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0dd4, code lost:
    
        if (r4 == 0) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0dd6, code lost:
    
        ((com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf) r0).zbc = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0ddd, code lost:
    
        if (r1 != 0) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0de1, code lost:
    
        if (r2 != r37) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0deb, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0df4, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0dec, code lost:
    
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0df0, code lost:
    
        if (r2 > r37) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0df2, code lost:
    
        if (r5 != r1) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0dfa, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0a2a, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0d21, code lost:
    
        if (r7 == 1048575) goto L533;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0d23, code lost:
    
        r26.putInt(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0d29, code lost:
    
        r3 = r15.zbj;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0d2f, code lost:
    
        if (r3 >= r15.zbk) goto L667;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0d31, code lost:
    
        r6 = r15.zbi;
        r7 = r15.zbl;
        r8 = r15.zbc;
        r6 = r6[r3];
        r8 = r8[r6];
        r9 = com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbws.zbf(r0, r15.zbs(r6) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0d48, code lost:
    
        if (r9 == null) goto L668;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0d4a, code lost:
    
        r11 = r15.zbu(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0d4e, code lost:
    
        if (r11 == null) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0d50, code lost:
    
        r6 = ((com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvf) r15.zbw(r6)).zbc();
        r9 = ((com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvg) r9).entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0d68, code lost:
    
        if (r9.hasNext() == false) goto L670;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0d6a, code lost:
    
        r12 = (java.util.Map.Entry) r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0d7e, code lost:
    
        if (r11.zba(((java.lang.Integer) r12.getValue()).intValue()) != false) goto L673;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0d80, code lost:
    
        if (r4 != 0) goto L547;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0d82, code lost:
    
        r4 = r7.zba(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0d86, code lost:
    
        r13 = com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvf.zbb(r6, r12.getKey(), r12.getValue());
        r14 = com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc.zbb;
        r14 = new byte[r13];
        r16 = r7;
        r10 = new com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbth(r14, 0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0d9e, code lost:
    
        com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvf.zbe(r10, r6, r12.getKey(), r12.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0da9, code lost:
    
        r4.zbj((r8 << 3) | 2, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsy.zba(r10, r14));
        r9.remove();
        r7 = r16;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:146:0x0a4a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:233:0x03c1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:601:0x00b4. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0cb5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0c8f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0ca0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x08f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0903 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:714:0x005b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v116 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwm] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zbc(Object obj, byte[] bArr, int i, int i2, int i3, zbsq zbsqVar) throws IOException {
        zbvp<T> zbvpVar;
        String str;
        int i4;
        Unsafe unsafe;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        zbvp<T> zbvpVar2;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int zbn;
        int i23;
        int i24;
        int i25;
        String str2;
        long j;
        int i26;
        int i27;
        String str3;
        int zbk;
        Object obj2;
        int i28;
        int i29;
        int zbm;
        int i30;
        int i31;
        int i32;
        int i33;
        int zbk2;
        int i34;
        int zbn2;
        int i35;
        int i36;
        zbvg zbvgVar;
        int i37;
        Object obj3;
        zbvp<T> zbvpVar3 = this;
        Object obj4 = obj;
        int i38 = i2;
        int i39 = i3;
        zbA(obj);
        Unsafe unsafe2 = zbb;
        int i40 = i;
        int i41 = -1;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = 1048575;
        while (true) {
            if (i40 < i38) {
                int i46 = i40 + 1;
                int i47 = bArr[i40];
                if (i47 < 0) {
                    i6 = zbsr.zbl(i47, bArr, i46, zbsqVar);
                    i5 = zbsqVar.zba;
                } else {
                    i5 = i47;
                    i6 = i46;
                }
                int i48 = i5 >>> 3;
                if (i48 > i41) {
                    i8 = (i48 < zbvpVar3.zbe || i48 > zbvpVar3.zbf) ? -1 : zbvpVar3.zbq(i48, i42 / 3);
                } else if (i48 < zbvpVar3.zbe || i48 > zbvpVar3.zbf) {
                    i7 = -1;
                    i8 = -1;
                    if (i8 == i7) {
                        int i49 = i5 & 7;
                        int[] iArr = zbvpVar3.zbc;
                        int i50 = i5;
                        int i51 = iArr[i8 + 1];
                        int zbr = zbr(i51);
                        long j2 = i51 & 1048575;
                        int i52 = i48;
                        if (zbr > 17) {
                            zbvpVar = zbvpVar3;
                            int i53 = i6;
                            int i54 = i50;
                            int i55 = i8;
                            if (zbr != 27) {
                                i11 = i45;
                                i10 = i44;
                                unsafe = unsafe2;
                                if (zbr > 49) {
                                    i13 = i55;
                                    str2 = "Failed to parse the message.";
                                    i38 = i2;
                                    i25 = i53;
                                    if (zbr != 50) {
                                        Unsafe unsafe3 = zbb;
                                        long j3 = iArr[i13 + 2] & 1048575;
                                        switch (zbr) {
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 1) {
                                                    i40 = i25 + 8;
                                                    unsafe3.putObject(obj4, j2, Double.valueOf(Double.longBitsToDouble(zbsr.zbr(bArr, i25))));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    if (i40 == i25) {
                                                        i4 = i3;
                                                        i9 = i40;
                                                        i13 = i34;
                                                        break;
                                                    } else {
                                                        i38 = i2;
                                                        i39 = i3;
                                                        i43 = i14;
                                                        i41 = i12;
                                                        zbvpVar3 = zbvpVar;
                                                        i44 = i10;
                                                        i42 = i34;
                                                        i45 = i11;
                                                        unsafe2 = unsafe;
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 5) {
                                                    i40 = i25 + 4;
                                                    unsafe3.putObject(obj4, j2, Float.valueOf(Float.intBitsToFloat(zbsr.zbc(bArr, i25))));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 0) {
                                                    zbn2 = zbsr.zbn(bArr, i25, zbsqVar);
                                                    unsafe3.putObject(obj4, j2, Long.valueOf(zbsqVar.zbb));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    i40 = zbn2;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                            case 62:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 0) {
                                                    i40 = zbsr.zbk(bArr, i25, zbsqVar);
                                                    unsafe3.putObject(obj4, j2, Integer.valueOf(zbsqVar.zba));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 1) {
                                                    i40 = i25 + 8;
                                                    unsafe3.putObject(obj4, j2, Long.valueOf(zbsr.zbr(bArr, i25)));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 5) {
                                                    i40 = i25 + 4;
                                                    unsafe3.putObject(obj4, j2, Integer.valueOf(zbsr.zbc(bArr, i25)));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case 58:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 0) {
                                                    zbn2 = zbsr.zbn(bArr, i25, zbsqVar);
                                                    unsafe3.putObject(obj4, j2, Boolean.valueOf(zbsqVar.zbb != 0));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    i40 = zbn2;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case 59:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                if (i49 == 2) {
                                                    int zbk3 = zbsr.zbk(bArr, i25, zbsqVar);
                                                    int i56 = zbsqVar.zba;
                                                    if (i56 == 0) {
                                                        unsafe3.putObject(obj4, j2, "");
                                                    } else {
                                                        int i57 = zbk3 + i56;
                                                        if ((i51 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zbwv.zbd(bArr, zbk3, i57)) {
                                                            unsafe3.putObject(obj4, j2, new String(bArr, zbk3, i56, zbuo.zba));
                                                            zbk3 = i57;
                                                        } else {
                                                            throw new zbuq("Protocol message had invalid UTF-8.");
                                                        }
                                                    }
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    i40 = zbk3;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                if (i49 == 2) {
                                                    Object zby = zbvpVar.zby(obj4, i12, i13);
                                                    i40 = zbsr.zbp(zby, zbvpVar.zbv(i13), bArr, i25, i2, zbsqVar);
                                                    zbvpVar.zbG(obj4, i12, i13, zby);
                                                    i34 = i13;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i34 = i13;
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                if (i49 == 2) {
                                                    int zba2 = zbsr.zba(bArr, i25, zbsqVar);
                                                    unsafe3.putObject(obj4, j2, zbsqVar.zbc);
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    i40 = zba2;
                                                    i34 = i13;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i34 = i13;
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                if (i49 == 0) {
                                                    i40 = zbsr.zbk(bArr, i25, zbsqVar);
                                                    int i58 = zbsqVar.zba;
                                                    zbuj zbu = zbvpVar.zbu(i13);
                                                    if (zbu == null || zbu.zba(i58)) {
                                                        i14 = i54;
                                                        unsafe3.putObject(obj4, j2, Integer.valueOf(i58));
                                                        unsafe3.putInt(obj4, j3, i12);
                                                    } else {
                                                        i14 = i54;
                                                        zbd(obj).zbj(i14, Long.valueOf(i58));
                                                    }
                                                    i34 = i13;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i14 = i54;
                                                i34 = i13;
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                if (i49 == 0) {
                                                    i40 = zbsr.zbk(bArr, i25, zbsqVar);
                                                    unsafe3.putObject(obj4, j2, Integer.valueOf(zbtg.zbb(zbsqVar.zba)));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    i34 = i13;
                                                    i14 = i54;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i34 = i13;
                                                i14 = i54;
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case 67:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                if (i49 == 0) {
                                                    int zbn3 = zbsr.zbn(bArr, i25, zbsqVar);
                                                    unsafe3.putObject(obj4, j2, Long.valueOf(zbtg.zbc(zbsqVar.zbb)));
                                                    unsafe3.putInt(obj4, j3, i12);
                                                    i40 = zbn3;
                                                    i34 = i13;
                                                    i14 = i54;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                i34 = i13;
                                                i14 = i54;
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                            case 68:
                                                if (i49 == 3) {
                                                    obj4 = obj;
                                                    Object zby2 = zby(obj4, i52, i13);
                                                    str = str2;
                                                    i12 = i52;
                                                    i40 = zbsr.zbo(zby2, zbv(i13), bArr, i25, i2, (i54 & (-8)) | 4, zbsqVar);
                                                    zbG(obj4, i12, i13, zby2);
                                                    zbvpVar = this;
                                                    i34 = i13;
                                                    i14 = i54;
                                                    if (i40 == i25) {
                                                    }
                                                } else {
                                                    obj4 = obj;
                                                    str = str2;
                                                    i12 = i52;
                                                    zbvpVar = this;
                                                    i34 = i13;
                                                    i14 = i54;
                                                    i40 = i25;
                                                    if (i40 == i25) {
                                                    }
                                                }
                                                break;
                                            default:
                                                zbvpVar = this;
                                                obj4 = obj;
                                                str = str2;
                                                i12 = i52;
                                                i14 = i54;
                                                i34 = i13;
                                                i40 = i25;
                                                if (i40 == i25) {
                                                }
                                                break;
                                        }
                                    } else if (i49 == 2) {
                                        Unsafe unsafe4 = zbb;
                                        Object zbw = zbvpVar.zbw(i13);
                                        Object object = unsafe4.getObject(obj4, j2);
                                        if (!((zbvg) object).zbe()) {
                                            zbvg zbb2 = zbvg.zba().zbb();
                                            zbvh.zba(zbb2, object);
                                            unsafe4.putObject(obj4, j2, zbb2);
                                            object = zbb2;
                                        }
                                        zbve zbc = ((zbvf) zbw).zbc();
                                        zbvg zbvgVar2 = (zbvg) object;
                                        int zbk4 = zbsr.zbk(bArr, i25, zbsqVar);
                                        int i59 = zbsqVar.zba;
                                        if (i59 >= 0 && i59 <= i38 - zbk4) {
                                            int i60 = zbk4 + i59;
                                            Object obj5 = zbc.zbb;
                                            Object obj6 = zbc.zbd;
                                            Object obj7 = obj5;
                                            while (zbk4 < i60) {
                                                int i61 = zbk4 + 1;
                                                int i62 = bArr[zbk4];
                                                if (i62 < 0) {
                                                    i61 = zbsr.zbl(i62, bArr, i61, zbsqVar);
                                                    i62 = zbsqVar.zba;
                                                }
                                                int i63 = i61;
                                                int i64 = i62 >>> 3;
                                                Object obj8 = obj6;
                                                int i65 = i62 & 7;
                                                Object obj9 = obj7;
                                                if (i64 == 1) {
                                                    i35 = i54;
                                                    i36 = i60;
                                                    zbvgVar = zbvgVar2;
                                                    i37 = i63;
                                                    obj3 = obj9;
                                                    if (i65 == zbc.zba.zba()) {
                                                        zbk4 = zbO(bArr, i37, i2, zbc.zba, null, zbsqVar);
                                                        obj7 = zbsqVar.zbc;
                                                        obj6 = obj8;
                                                        zbvgVar2 = zbvgVar;
                                                        i60 = i36;
                                                        i54 = i35;
                                                    }
                                                } else if (i64 == 2) {
                                                    if (i65 == zbc.zbc.zba()) {
                                                        obj3 = obj9;
                                                        i36 = i60;
                                                        i35 = i54;
                                                        zbvgVar = zbvgVar2;
                                                        zbk4 = zbO(bArr, i63, i2, zbc.zbc, zbc.zbd.getClass(), zbsqVar);
                                                        obj6 = zbsqVar.zbc;
                                                        obj7 = obj3;
                                                        zbvgVar2 = zbvgVar;
                                                        i60 = i36;
                                                        i54 = i35;
                                                    } else {
                                                        i35 = i54;
                                                        i36 = i60;
                                                        zbvgVar = zbvgVar2;
                                                        obj3 = obj9;
                                                        i37 = i63;
                                                    }
                                                } else {
                                                    i35 = i54;
                                                    i36 = i60;
                                                    zbvgVar = zbvgVar2;
                                                    i37 = i63;
                                                    obj6 = obj8;
                                                    obj3 = obj9;
                                                    zbk4 = zbsr.zbq(i62, bArr, i37, i38, zbsqVar);
                                                    obj7 = obj3;
                                                    zbvgVar2 = zbvgVar;
                                                    i60 = i36;
                                                    i54 = i35;
                                                }
                                                obj6 = obj8;
                                                zbk4 = zbsr.zbq(i62, bArr, i37, i38, zbsqVar);
                                                obj7 = obj3;
                                                zbvgVar2 = zbvgVar;
                                                i60 = i36;
                                                i54 = i35;
                                            }
                                            int i66 = i54;
                                            Object obj10 = obj7;
                                            int i67 = i60;
                                            zbvg zbvgVar3 = zbvgVar2;
                                            if (zbk4 == i67) {
                                                zbvgVar3.put(obj10, obj6);
                                                if (i67 != i25) {
                                                    zbvpVar3 = this;
                                                    obj4 = obj;
                                                    i39 = i3;
                                                    i42 = i13;
                                                    i40 = i67;
                                                    i44 = i10;
                                                    i41 = i52;
                                                    i45 = i11;
                                                    unsafe2 = unsafe;
                                                    i43 = i66;
                                                } else {
                                                    obj4 = obj;
                                                    i4 = i3;
                                                    str = str2;
                                                    i9 = i67;
                                                    i12 = i52;
                                                    i14 = i66;
                                                    zbvpVar = this;
                                                }
                                            } else {
                                                throw new zbuq(str2);
                                            }
                                        }
                                    } else {
                                        i24 = i54;
                                        zbvpVar = this;
                                        obj4 = obj;
                                        i4 = i3;
                                        str = str2;
                                        i9 = i25;
                                        i12 = i52;
                                        i14 = i24;
                                    }
                                } else {
                                    long j4 = i51;
                                    Unsafe unsafe5 = zbb;
                                    zbun zbunVar = (zbun) unsafe5.getObject(obj4, j2);
                                    if (zbunVar.zbc()) {
                                        j = j4;
                                    } else {
                                        int size = zbunVar.size();
                                        j = j4;
                                        zbun zbd = zbunVar.zbd(size != 0 ? size + size : 10);
                                        unsafe5.putObject(obj4, j2, zbd);
                                        zbunVar = zbd;
                                    }
                                    switch (zbr) {
                                        case 18:
                                        case 35:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                int i68 = zbsr.zba;
                                                zbtm zbtmVar = (zbtm) zbunVar;
                                                zbk = zbsr.zbk(bArr, i26, zbsqVar);
                                                int i69 = zbsqVar.zba + zbk;
                                                while (zbk < i69) {
                                                    zbtmVar.zbf(Double.longBitsToDouble(zbsr.zbr(bArr, zbk)));
                                                    zbk += 8;
                                                }
                                                if (zbk != i69) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i40 = zbk;
                                                if (i40 == i26) {
                                                    i9 = i40;
                                                    i13 = i27;
                                                    str = str3;
                                                    i12 = i52;
                                                    i14 = i54;
                                                    i4 = i3;
                                                    break;
                                                } else {
                                                    i39 = i3;
                                                    i43 = i54;
                                                    i42 = i27;
                                                    zbvpVar3 = zbvpVar;
                                                    i44 = i10;
                                                    i41 = i52;
                                                    i45 = i11;
                                                    unsafe2 = unsafe;
                                                }
                                            } else {
                                                if (i49 == 1) {
                                                    i40 = i26 + 8;
                                                    int i70 = zbsr.zba;
                                                    zbtm zbtmVar2 = (zbtm) zbunVar;
                                                    zbtmVar2.zbf(Double.longBitsToDouble(zbsr.zbr(bArr, i26)));
                                                    while (i40 < i38) {
                                                        int zbk5 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            zbtmVar2.zbf(Double.longBitsToDouble(zbsr.zbr(bArr, zbk5)));
                                                            i40 = zbk5 + 8;
                                                        } else if (i40 == i26) {
                                                        }
                                                    }
                                                    if (i40 == i26) {
                                                    }
                                                }
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                        case 19:
                                        case 36:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                int i71 = zbsr.zba;
                                                zbtw zbtwVar = (zbtw) zbunVar;
                                                zbk = zbsr.zbk(bArr, i26, zbsqVar);
                                                int i72 = zbsqVar.zba + zbk;
                                                while (zbk < i72) {
                                                    zbtwVar.zbg(Float.intBitsToFloat(zbsr.zbc(bArr, zbk)));
                                                    zbk += 4;
                                                }
                                                if (zbk != i72) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i40 = zbk;
                                                if (i40 == i26) {
                                                }
                                            } else {
                                                if (i49 == 5) {
                                                    i40 = i26 + 4;
                                                    int i73 = zbsr.zba;
                                                    zbtw zbtwVar2 = (zbtw) zbunVar;
                                                    zbtwVar2.zbg(Float.intBitsToFloat(zbsr.zbc(bArr, i26)));
                                                    while (i40 < i38) {
                                                        int zbk6 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            zbtwVar2.zbg(Float.intBitsToFloat(zbsr.zbc(bArr, zbk6)));
                                                            i40 = zbk6 + 4;
                                                        } else if (i40 == i26) {
                                                        }
                                                    }
                                                    if (i40 == i26) {
                                                    }
                                                }
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                int i74 = zbsr.zba;
                                                zbva zbvaVar = (zbva) zbunVar;
                                                zbk = zbsr.zbk(bArr, i26, zbsqVar);
                                                int i75 = zbsqVar.zba + zbk;
                                                while (zbk < i75) {
                                                    zbk = zbsr.zbn(bArr, zbk, zbsqVar);
                                                    zbvaVar.zbg(zbsqVar.zbb);
                                                }
                                                if (zbk != i75) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i40 = zbk;
                                                if (i40 == i26) {
                                                }
                                            } else {
                                                if (i49 == 0) {
                                                    int i76 = zbsr.zba;
                                                    zbva zbvaVar2 = (zbva) zbunVar;
                                                    i40 = zbsr.zbn(bArr, i26, zbsqVar);
                                                    zbvaVar2.zbg(zbsqVar.zbb);
                                                    while (i40 < i38) {
                                                        int zbk7 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            i40 = zbsr.zbn(bArr, zbk7, zbsqVar);
                                                            zbvaVar2.zbg(zbsqVar.zbb);
                                                        } else if (i40 == i26) {
                                                        }
                                                    }
                                                    if (i40 == i26) {
                                                    }
                                                }
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                i40 = zbsr.zbg(bArr, i26, zbunVar, zbsqVar);
                                            } else {
                                                if (i49 == 0) {
                                                    i40 = zbsr.zbm(i54, bArr, i26, i2, zbunVar, zbsqVar);
                                                }
                                                i40 = i26;
                                            }
                                            if (i40 == i26) {
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                int i77 = zbsr.zba;
                                                zbva zbvaVar3 = (zbva) zbunVar;
                                                zbk = zbsr.zbk(bArr, i26, zbsqVar);
                                                int i78 = zbsqVar.zba + zbk;
                                                while (zbk < i78) {
                                                    zbvaVar3.zbg(zbsr.zbr(bArr, zbk));
                                                    zbk += 8;
                                                }
                                                if (zbk != i78) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i40 = zbk;
                                                if (i40 == i26) {
                                                }
                                            } else {
                                                if (i49 == 1) {
                                                    i40 = i26 + 8;
                                                    int i79 = zbsr.zba;
                                                    zbva zbvaVar4 = (zbva) zbunVar;
                                                    zbvaVar4.zbg(zbsr.zbr(bArr, i26));
                                                    while (i40 < i38) {
                                                        int zbk8 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            zbvaVar4.zbg(zbsr.zbr(bArr, zbk8));
                                                            i40 = zbk8 + 8;
                                                        } else if (i40 == i26) {
                                                        }
                                                    }
                                                    if (i40 == i26) {
                                                    }
                                                }
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                int i80 = zbsr.zba;
                                                zbug zbugVar = (zbug) zbunVar;
                                                zbk = zbsr.zbk(bArr, i26, zbsqVar);
                                                int i81 = zbsqVar.zba + zbk;
                                                while (zbk < i81) {
                                                    zbugVar.zbg(zbsr.zbc(bArr, zbk));
                                                    zbk += 4;
                                                }
                                                if (zbk != i81) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i40 = zbk;
                                                if (i40 == i26) {
                                                }
                                            } else {
                                                if (i49 == 5) {
                                                    i40 = i26 + 4;
                                                    int i82 = zbsr.zba;
                                                    zbug zbugVar2 = (zbug) zbunVar;
                                                    zbugVar2.zbg(zbsr.zbc(bArr, i26));
                                                    while (i40 < i38) {
                                                        int zbk9 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            zbugVar2.zbg(zbsr.zbc(bArr, zbk9));
                                                            i40 = zbk9 + 4;
                                                        } else if (i40 == i26) {
                                                        }
                                                    }
                                                    if (i40 == i26) {
                                                    }
                                                }
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                int i83 = zbsr.zba;
                                                zbss zbssVar = (zbss) zbunVar;
                                                zbk = zbsr.zbk(bArr, i26, zbsqVar);
                                                int i84 = zbsqVar.zba + zbk;
                                                while (zbk < i84) {
                                                    zbk = zbsr.zbn(bArr, zbk, zbsqVar);
                                                    zbssVar.zbe(zbsqVar.zbb != 0);
                                                }
                                                if (zbk != i84) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i40 = zbk;
                                                if (i40 == i26) {
                                                }
                                            } else {
                                                if (i49 == 0) {
                                                    int i85 = zbsr.zba;
                                                    zbss zbssVar2 = (zbss) zbunVar;
                                                    i40 = zbsr.zbn(bArr, i26, zbsqVar);
                                                    zbssVar2.zbe(zbsqVar.zbb != 0);
                                                    while (i40 < i38) {
                                                        int zbk10 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            i40 = zbsr.zbn(bArr, zbk10, zbsqVar);
                                                            zbssVar2.zbe(zbsqVar.zbb != 0);
                                                        } else if (i40 == i26) {
                                                        }
                                                    }
                                                    if (i40 == i26) {
                                                    }
                                                }
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            break;
                                        case 26:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 2) {
                                                if ((j & 536870912) == 0) {
                                                    i40 = zbsr.zbk(bArr, i26, zbsqVar);
                                                    int i86 = zbsqVar.zba;
                                                    if (i86 < 0) {
                                                        throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i86 == 0) {
                                                        obj2 = "";
                                                        zbunVar.add(obj2);
                                                    } else {
                                                        obj2 = "";
                                                        zbunVar.add(new String(bArr, i40, i86, zbuo.zba));
                                                        i40 += i86;
                                                    }
                                                    while (i40 < i38) {
                                                        int zbk11 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            i40 = zbsr.zbk(bArr, zbk11, zbsqVar);
                                                            int i87 = zbsqVar.zba;
                                                            if (i87 < 0) {
                                                                throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i87 == 0) {
                                                                zbunVar.add(obj2);
                                                            } else {
                                                                zbunVar.add(new String(bArr, i40, i87, zbuo.zba));
                                                                i40 += i87;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    i40 = zbsr.zbk(bArr, i26, zbsqVar);
                                                    int i88 = zbsqVar.zba;
                                                    if (i88 < 0) {
                                                        throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i88 == 0) {
                                                        zbunVar.add("");
                                                    } else {
                                                        int i89 = i40 + i88;
                                                        if (zbwv.zbd(bArr, i40, i89)) {
                                                            zbunVar.add(new String(bArr, i40, i88, zbuo.zba));
                                                            i40 = i89;
                                                        } else {
                                                            throw new zbuq("Protocol message had invalid UTF-8.");
                                                        }
                                                    }
                                                    while (i40 < i38) {
                                                        int zbk12 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            i40 = zbsr.zbk(bArr, zbk12, zbsqVar);
                                                            int i90 = zbsqVar.zba;
                                                            if (i90 < 0) {
                                                                throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i90 == 0) {
                                                                zbunVar.add("");
                                                            } else {
                                                                int i91 = i40 + i90;
                                                                if (zbwv.zbd(bArr, i40, i91)) {
                                                                    zbunVar.add(new String(bArr, i40, i90, zbuo.zba));
                                                                    i40 = i91;
                                                                } else {
                                                                    throw new zbuq("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i40 == i26) {
                                                }
                                            }
                                            i40 = i26;
                                            if (i40 == i26) {
                                            }
                                            break;
                                        case 27:
                                            i38 = i2;
                                            i26 = i53;
                                            i28 = i55;
                                            i29 = i52;
                                            if (i49 == 2) {
                                                i52 = i29;
                                                str3 = "Failed to parse the message.";
                                                i40 = zbsr.zbf(zbvpVar.zbv(i28), i54, bArr, i26, i2, zbunVar, zbsqVar);
                                                i27 = i28;
                                                if (i40 == i26) {
                                                }
                                            }
                                            i52 = i29;
                                            str3 = "Failed to parse the message.";
                                            i27 = i28;
                                            i40 = i26;
                                            if (i40 == i26) {
                                            }
                                            break;
                                        case 28:
                                            i38 = i2;
                                            i26 = i53;
                                            i28 = i55;
                                            i29 = i52;
                                            if (i49 == 2) {
                                                int zbk13 = zbsr.zbk(bArr, i26, zbsqVar);
                                                int i92 = zbsqVar.zba;
                                                if (i92 >= 0) {
                                                    if (i92 > bArr.length - zbk13) {
                                                        throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i92 == 0) {
                                                        zbunVar.add(zbtc.zbb);
                                                    } else {
                                                        zbunVar.add(zbtc.zbj(bArr, zbk13, i92));
                                                        zbk13 += i92;
                                                    }
                                                    while (zbk13 < i38) {
                                                        int zbk14 = zbsr.zbk(bArr, zbk13, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            zbk13 = zbsr.zbk(bArr, zbk14, zbsqVar);
                                                            int i93 = zbsqVar.zba;
                                                            if (i93 >= 0) {
                                                                if (i93 > bArr.length - zbk13) {
                                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                if (i93 == 0) {
                                                                    zbunVar.add(zbtc.zbb);
                                                                } else {
                                                                    zbunVar.add(zbtc.zbj(bArr, zbk13, i93));
                                                                    zbk13 += i93;
                                                                }
                                                            } else {
                                                                throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                        } else {
                                                            i40 = zbk13;
                                                            i52 = i29;
                                                            str3 = "Failed to parse the message.";
                                                            i27 = i28;
                                                            if (i40 == i26) {
                                                            }
                                                        }
                                                    }
                                                    i40 = zbk13;
                                                    i52 = i29;
                                                    str3 = "Failed to parse the message.";
                                                    i27 = i28;
                                                    if (i40 == i26) {
                                                    }
                                                } else {
                                                    throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                            }
                                            i52 = i29;
                                            str3 = "Failed to parse the message.";
                                            i27 = i28;
                                            i40 = i26;
                                            if (i40 == i26) {
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i38 = i2;
                                            if (i49 == 2) {
                                                zbm = zbsr.zbg(bArr, i53, zbunVar, zbsqVar);
                                                i26 = i53;
                                            } else {
                                                if (i49 == 0) {
                                                    i26 = i53;
                                                    zbm = zbsr.zbm(i54, bArr, i53, i2, zbunVar, zbsqVar);
                                                }
                                                i26 = i53;
                                                i27 = i55;
                                                str3 = "Failed to parse the message.";
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            zbuj zbu2 = zbvpVar.zbu(i55);
                                            zbwl zbwlVar = zbvpVar.zbl;
                                            int i94 = zbvz.zba;
                                            if (zbu2 == null) {
                                                i30 = zbm;
                                                i31 = i55;
                                                i32 = i52;
                                            } else if (zbunVar instanceof RandomAccess) {
                                                int size2 = zbunVar.size();
                                                Object obj11 = null;
                                                int i95 = 0;
                                                int i96 = 0;
                                                while (i95 < size2) {
                                                    int i97 = zbm;
                                                    Integer num = (Integer) zbunVar.get(i95);
                                                    int i98 = i55;
                                                    int intValue = num.intValue();
                                                    if (zbu2.zba(intValue)) {
                                                        if (i95 != i96) {
                                                            zbunVar.set(i96, num);
                                                        }
                                                        i96++;
                                                        i33 = i52;
                                                    } else {
                                                        i33 = i52;
                                                        obj11 = zbvz.zbn(obj4, i33, intValue, obj11, zbwlVar);
                                                    }
                                                    i95++;
                                                    i52 = i33;
                                                    i55 = i98;
                                                    zbm = i97;
                                                }
                                                i30 = zbm;
                                                i31 = i55;
                                                i32 = i52;
                                                if (i96 != size2) {
                                                    zbunVar.subList(i96, size2).clear();
                                                }
                                            } else {
                                                i30 = zbm;
                                                i31 = i55;
                                                i32 = i52;
                                                Iterator it = zbunVar.iterator();
                                                Object obj12 = null;
                                                while (it.hasNext()) {
                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                    if (!zbu2.zba(intValue2)) {
                                                        obj12 = zbvz.zbn(obj4, i32, intValue2, obj12, zbwlVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            i52 = i32;
                                            str3 = "Failed to parse the message.";
                                            i27 = i31;
                                            i40 = i30;
                                            if (i40 == i26) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i38 = i2;
                                            if (i49 == 2) {
                                                int i99 = zbsr.zba;
                                                zbug zbugVar3 = (zbug) zbunVar;
                                                zbk2 = zbsr.zbk(bArr, i53, zbsqVar);
                                                int i100 = zbsqVar.zba + zbk2;
                                                while (zbk2 < i100) {
                                                    zbk2 = zbsr.zbk(bArr, zbk2, zbsqVar);
                                                    zbugVar3.zbg(zbtg.zbb(zbsqVar.zba));
                                                }
                                                if (zbk2 != i100) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i40 = zbk2;
                                                i26 = i53;
                                                i27 = i55;
                                                str3 = "Failed to parse the message.";
                                                if (i40 == i26) {
                                                }
                                            } else {
                                                if (i49 == 0) {
                                                    int i101 = zbsr.zba;
                                                    zbug zbugVar4 = (zbug) zbunVar;
                                                    i40 = zbsr.zbk(bArr, i53, zbsqVar);
                                                    zbugVar4.zbg(zbtg.zbb(zbsqVar.zba));
                                                    while (i40 < i38) {
                                                        int zbk15 = zbsr.zbk(bArr, i40, zbsqVar);
                                                        if (i54 == zbsqVar.zba) {
                                                            i40 = zbsr.zbk(bArr, zbk15, zbsqVar);
                                                            zbugVar4.zbg(zbtg.zbb(zbsqVar.zba));
                                                        } else {
                                                            i26 = i53;
                                                            i27 = i55;
                                                            str3 = "Failed to parse the message.";
                                                            if (i40 == i26) {
                                                            }
                                                        }
                                                    }
                                                    i26 = i53;
                                                    i27 = i55;
                                                    str3 = "Failed to parse the message.";
                                                    if (i40 == i26) {
                                                    }
                                                }
                                                i26 = i53;
                                                i27 = i55;
                                                str3 = "Failed to parse the message.";
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            break;
                                        case 34:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                            if (i49 == 2) {
                                                int i102 = zbsr.zba;
                                                zbva zbvaVar5 = (zbva) zbunVar;
                                                zbk2 = zbsr.zbk(bArr, i53, zbsqVar);
                                                int i103 = zbsqVar.zba + zbk2;
                                                while (zbk2 < i103) {
                                                    zbk2 = zbsr.zbn(bArr, zbk2, zbsqVar);
                                                    zbvaVar5.zbg(zbtg.zbc(zbsqVar.zbb));
                                                }
                                                if (zbk2 != i103) {
                                                    throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i38 = i2;
                                                i40 = zbk2;
                                                i26 = i53;
                                                i27 = i55;
                                                str3 = "Failed to parse the message.";
                                                if (i40 == i26) {
                                                }
                                            } else if (i49 == 0) {
                                                int i104 = zbsr.zba;
                                                zbva zbvaVar6 = (zbva) zbunVar;
                                                i40 = zbsr.zbn(bArr, i53, zbsqVar);
                                                zbvaVar6.zbg(zbtg.zbc(zbsqVar.zbb));
                                                i38 = i2;
                                                while (i40 < i38) {
                                                    int zbk16 = zbsr.zbk(bArr, i40, zbsqVar);
                                                    if (i54 == zbsqVar.zba) {
                                                        i40 = zbsr.zbn(bArr, zbk16, zbsqVar);
                                                        zbvaVar6.zbg(zbtg.zbc(zbsqVar.zbb));
                                                    } else {
                                                        i26 = i53;
                                                        i27 = i55;
                                                        str3 = "Failed to parse the message.";
                                                        if (i40 == i26) {
                                                        }
                                                    }
                                                }
                                                i26 = i53;
                                                i27 = i55;
                                                str3 = "Failed to parse the message.";
                                                if (i40 == i26) {
                                                }
                                            } else {
                                                i38 = i2;
                                                i26 = i53;
                                                i27 = i55;
                                                str3 = "Failed to parse the message.";
                                                i40 = i26;
                                                if (i40 == i26) {
                                                }
                                            }
                                            break;
                                        default:
                                            i38 = i2;
                                            i26 = i53;
                                            i27 = i55;
                                            str3 = "Failed to parse the message.";
                                            if (i49 == 3) {
                                                int i105 = (i54 & (-8)) | 4;
                                                zbvx zbv = zbvpVar.zbv(i27);
                                                i40 = zbsr.zbd(zbv, bArr, i26, i2, i105, zbsqVar);
                                                zbunVar.add(zbsqVar.zbc);
                                                while (i40 < i38) {
                                                    int zbk17 = zbsr.zbk(bArr, i40, zbsqVar);
                                                    if (i54 == zbsqVar.zba) {
                                                        i40 = zbsr.zbd(zbv, bArr, zbk17, i2, i105, zbsqVar);
                                                        zbunVar.add(zbsqVar.zbc);
                                                    } else if (i40 == i26) {
                                                    }
                                                }
                                                if (i40 == i26) {
                                                }
                                            }
                                            i40 = i26;
                                            if (i40 == i26) {
                                            }
                                            break;
                                    }
                                }
                            } else if (i49 == 2) {
                                zbun zbunVar2 = (zbun) unsafe2.getObject(obj4, j2);
                                if (!zbunVar2.zbc()) {
                                    int size3 = zbunVar2.size();
                                    zbunVar2 = zbunVar2.zbd(size3 != 0 ? size3 + size3 : 10);
                                    unsafe2.putObject(obj4, j2, zbunVar2);
                                }
                                i40 = zbsr.zbf(zbvpVar.zbv(i55), i54, bArr, i53, i2, zbunVar2, zbsqVar);
                                i38 = i2;
                                i39 = i3;
                                i43 = i54;
                                i42 = i55;
                                zbvpVar3 = zbvpVar;
                                i44 = i44;
                                i41 = i52;
                                i45 = i45;
                            } else {
                                i11 = i45;
                                i10 = i44;
                                i24 = i54;
                                i25 = i53;
                                unsafe = unsafe2;
                                i13 = i55;
                                str2 = "Failed to parse the message.";
                                zbvpVar = this;
                                obj4 = obj;
                                i4 = i3;
                                str = str2;
                                i9 = i25;
                                i12 = i52;
                                i14 = i24;
                            }
                        } else {
                            int i106 = iArr[i8 + 2];
                            int i107 = 1 << (i106 >>> 20);
                            int i108 = 1048575;
                            int i109 = i106 & 1048575;
                            int i110 = i6;
                            if (i109 != i45) {
                                if (i45 != 1048575) {
                                    unsafe2.putInt(obj4, i45, i44);
                                    i108 = 1048575;
                                }
                                i44 = i109 == i108 ? 0 : unsafe2.getInt(obj4, i109);
                            } else {
                                i109 = i45;
                            }
                            switch (zbr) {
                                case 0:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 1) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i40 = i21 + 8;
                                        i44 |= i107;
                                        zbws.zbo(obj4, j2, Double.longBitsToDouble(zbsr.zbr(bArr, i21)));
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 1:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 5) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i40 = i21 + 4;
                                        i44 |= i107;
                                        zbws.zbp(obj4, j2, Float.intBitsToFloat(zbsr.zbc(bArr, i21)));
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 2:
                                case 3:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 0) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i22 = i107 | i44;
                                        zbn = zbsr.zbn(bArr, i21, zbsqVar);
                                        unsafe2.putLong(obj, j2, zbsqVar.zbb);
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i44 = i22;
                                        i40 = zbn;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 4:
                                case 11:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 0) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i44 |= i107;
                                        i40 = zbsr.zbk(bArr, i21, zbsqVar);
                                        unsafe2.putInt(obj4, j2, zbsqVar.zba);
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 5:
                                case 14:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 1) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        zbn = i21 + 8;
                                        i22 = i107 | i44;
                                        unsafe2.putLong(obj, j2, zbsr.zbr(bArr, i21));
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i44 = i22;
                                        i40 = zbn;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 6:
                                case 13:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 5) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i40 = i21 + 4;
                                        i44 |= i107;
                                        unsafe2.putInt(obj4, j2, zbsr.zbc(bArr, i21));
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 7:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 0) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i44 |= i107;
                                        i40 = zbsr.zbn(bArr, i21, zbsqVar);
                                        zbws.zbm(obj4, j2, zbsqVar.zbb != 0);
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 8:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 2) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i44 |= i107;
                                        if ((i51 & C.BUFFER_FLAG_LAST_SAMPLE) == 0) {
                                            i40 = zbsr.zbh(bArr, i21, zbsqVar);
                                        } else {
                                            i40 = zbsr.zbi(bArr, i21, zbsqVar);
                                        }
                                        unsafe2.putObject(obj4, j2, zbsqVar.zbc);
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 9:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i18 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 2) {
                                        i21 = i18;
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        Object zbx = zbvpVar2.zbx(obj4, i19);
                                        i40 = zbsr.zbp(zbx, zbvpVar2.zbv(i19), bArr, i18, i2, zbsqVar);
                                        zbvpVar2.zbF(obj4, i19, zbx);
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i44 |= i107;
                                        i45 = i17;
                                        i41 = i52;
                                        i38 = i2;
                                    }
                                case 10:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i18 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 2) {
                                        i21 = i18;
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i44 |= i107;
                                        i40 = zbsr.zba(bArr, i18, zbsqVar);
                                        unsafe2.putObject(obj4, j2, zbsqVar.zbc);
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 12:
                                    i17 = i109;
                                    i23 = i110;
                                    i20 = i50;
                                    i19 = i8;
                                    if (i49 != 0) {
                                        zbvpVar = this;
                                        i21 = i23;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i40 = zbsr.zbk(bArr, i23, zbsqVar);
                                        int i111 = zbsqVar.zba;
                                        zbvpVar2 = this;
                                        zbuj zbu3 = zbvpVar2.zbu(i19);
                                        if ((i51 & Integer.MIN_VALUE) == 0 || zbu3 == null || zbu3.zba(i111)) {
                                            i44 |= i107;
                                            unsafe2.putInt(obj4, j2, i111);
                                        } else {
                                            zbd(obj).zbj(i20, Long.valueOf(i111));
                                        }
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        zbvpVar3 = zbvpVar2;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                    }
                                case 15:
                                    i17 = i109;
                                    i23 = i110;
                                    i20 = i50;
                                    i19 = i8;
                                    if (i49 != 0) {
                                        zbvpVar = this;
                                        i21 = i23;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        i44 |= i107;
                                        i40 = zbsr.zbk(bArr, i23, zbsqVar);
                                        unsafe2.putInt(obj4, j2, zbtg.zbb(zbsqVar.zba));
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i20;
                                        i42 = i19;
                                        i45 = i17;
                                        i41 = i52;
                                        zbvpVar3 = this;
                                    }
                                case 16:
                                    if (i49 != 0) {
                                        i17 = i109;
                                        i23 = i110;
                                        i20 = i50;
                                        i19 = i8;
                                        zbvpVar = this;
                                        i21 = i23;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        int i112 = i44 | i107;
                                        int zbn4 = zbsr.zbn(bArr, i110, zbsqVar);
                                        i17 = i109;
                                        unsafe2.putLong(obj, j2, zbtg.zbc(zbsqVar.zbb));
                                        i38 = i2;
                                        i39 = i3;
                                        i43 = i50;
                                        i44 = i112;
                                        i42 = i8;
                                        i40 = zbn4;
                                        i45 = i17;
                                        i41 = i52;
                                        zbvpVar3 = this;
                                    }
                                default:
                                    zbvpVar2 = this;
                                    i17 = i109;
                                    i21 = i110;
                                    i19 = i8;
                                    i20 = i50;
                                    if (i49 != 3) {
                                        zbvpVar = zbvpVar2;
                                        i14 = i20;
                                        i9 = i21;
                                        unsafe = unsafe2;
                                        i11 = i17;
                                        str = "Failed to parse the message.";
                                        i4 = i3;
                                        i10 = i44;
                                        i13 = i19;
                                        i12 = i52;
                                        break;
                                    } else {
                                        Object zbx2 = zbvpVar2.zbx(obj4, i19);
                                        i40 = zbsr.zbo(zbx2, zbvpVar2.zbv(i19), bArr, i21, i2, (i52 << 3) | 4, zbsqVar);
                                        zbvpVar2.zbF(obj4, i19, zbx2);
                                        i39 = i3;
                                        i43 = i20;
                                        i42 = i19;
                                        i44 |= i107;
                                        zbvpVar3 = zbvpVar2;
                                        i45 = i17;
                                        i41 = i52;
                                        i38 = i2;
                                    }
                            }
                        }
                    } else {
                        i9 = i6;
                        i10 = i44;
                        i11 = i45;
                        str = "Failed to parse the message.";
                        unsafe = unsafe2;
                        i12 = i48;
                        i13 = 0;
                        zbvpVar = zbvpVar3;
                        i14 = i5;
                        i4 = i39;
                    }
                    if (i14 == i4 || i4 == 0) {
                        if (zbvpVar.zbh) {
                            zbtp zbtpVar = zbsqVar.zbd;
                            int i113 = zbtp.zbb;
                            int i114 = zbvu.zba;
                            if (zbtpVar != zbtp.zba) {
                                zbvm zbvmVar = zbvpVar.zbg;
                                zbwl zbwlVar2 = zbvpVar.zbl;
                                zbtp zbtpVar2 = zbsqVar.zbd;
                                int i115 = zbsr.zba;
                                zbud zbc2 = zbtpVar2.zbc(zbvmVar, i12);
                                if (zbc2 == null) {
                                    i40 = zbsr.zbj(i14, bArr, i9, i2, zbd(obj), zbsqVar);
                                    i15 = i14;
                                    i16 = i12;
                                } else {
                                    zbub zbubVar = (zbub) obj4;
                                    zbubVar.zbg();
                                    i15 = i14;
                                    i16 = i12;
                                    i40 = zbsr.zbb(i14, bArr, i9, i2, zbubVar, zbc2, zbwlVar2, zbsqVar);
                                }
                                i41 = i16;
                                i43 = i15;
                                i42 = i13;
                                i44 = i10;
                                i45 = i11;
                                unsafe2 = unsafe;
                                i38 = i2;
                                i39 = i4;
                                zbvpVar3 = zbvpVar;
                            }
                        }
                        i15 = i14;
                        i16 = i12;
                        i40 = zbsr.zbj(i15, bArr, i9, i2, zbd(obj), zbsqVar);
                        i41 = i16;
                        i43 = i15;
                        i42 = i13;
                        i44 = i10;
                        i45 = i11;
                        unsafe2 = unsafe;
                        i38 = i2;
                        i39 = i4;
                        zbvpVar3 = zbvpVar;
                    } else {
                        i40 = i9;
                        i43 = i14;
                        i44 = i10;
                        i45 = i11;
                    }
                } else {
                    i8 = zbvpVar3.zbq(i48, 0);
                }
                i7 = -1;
                if (i8 == i7) {
                }
                if (i14 == i4) {
                }
                if (zbvpVar.zbh) {
                }
                i15 = i14;
                i16 = i12;
                i40 = zbsr.zbj(i15, bArr, i9, i2, zbd(obj), zbsqVar);
                i41 = i16;
                i43 = i15;
                i42 = i13;
                i44 = i10;
                i45 = i11;
                unsafe2 = unsafe;
                i38 = i2;
                i39 = i4;
                zbvpVar3 = zbvpVar;
            } else {
                zbvpVar = zbvpVar3;
                str = "Failed to parse the message.";
                i4 = i39;
                unsafe = unsafe2;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final Object zbe() {
        return ((zbuf) this.zbg).zbt();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbf(Object obj) {
        if (zbL(obj)) {
            if (obj instanceof zbuf) {
                zbuf zbufVar = (zbuf) obj;
                zbufVar.zbE(Integer.MAX_VALUE);
                zbufVar.zba = 0;
                zbufVar.zbC();
            }
            int[] iArr = this.zbc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zbs = zbs(i);
                int i2 = 1048575 & zbs;
                int zbr = zbr(zbs);
                long j = i2;
                if (zbr != 9) {
                    if (zbr != 60 && zbr != 68) {
                        switch (zbr) {
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
                                ((zbun) zbws.zbf(obj, j)).zbb();
                                break;
                            case 50:
                                Unsafe unsafe = zbb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zbvg) object).zbc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zbM(obj, this.zbc[i], i)) {
                        zbv(i).zbf(zbb.getObject(obj, j));
                    }
                }
                if (zbI(obj, i)) {
                    zbv(i).zbf(zbb.getObject(obj, j));
                }
            }
            this.zbl.zbb(obj);
            if (this.zbh) {
                this.zbm.zba(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbg(Object obj, Object obj2) {
        zbA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zbc.length; i += 3) {
            int zbs = zbs(i);
            int i2 = 1048575 & zbs;
            int[] iArr = this.zbc;
            int zbr = zbr(zbs);
            int i3 = iArr[i];
            long j = i2;
            switch (zbr) {
                case 0:
                    if (zbI(obj2, i)) {
                        zbws.zbo(obj, j, zbws.zba(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zbI(obj2, i)) {
                        zbws.zbp(obj, j, zbws.zbb(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zbI(obj2, i)) {
                        zbws.zbm(obj, j, zbws.zbw(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zbI(obj2, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zbB(obj, obj2, i);
                    break;
                case 10:
                    if (zbI(obj2, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zbB(obj, obj2, i);
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
                    zbun zbunVar = (zbun) zbws.zbf(obj, j);
                    zbun zbunVar2 = (zbun) zbws.zbf(obj2, j);
                    int size = zbunVar.size();
                    int size2 = zbunVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zbunVar.zbc()) {
                            zbunVar = zbunVar.zbd(size2 + size);
                        }
                        zbunVar.addAll(zbunVar2);
                    }
                    if (size > 0) {
                        zbunVar2 = zbunVar;
                    }
                    zbws.zbs(obj, j, zbunVar2);
                    break;
                case 50:
                    int i4 = zbvz.zba;
                    zbws.zbs(obj, j, zbvh.zba(zbws.zbf(obj, j), zbws.zbf(obj2, j)));
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
                    if (zbM(obj2, i3, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zbC(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                    if (zbM(obj2, i3, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zbC(obj, obj2, i);
                    break;
            }
        }
        zbvz.zbp(this.zbl, obj, obj2);
        if (this.zbh) {
            zbvz.zbo(this.zbm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbh(Object obj, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        zbc(obj, bArr, i, i2, 0, zbsqVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0094. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zbi(Object obj, zbwy zbwyVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int[] iArr;
        int i;
        Map.Entry entry2;
        int i2;
        int i3;
        int i4;
        Iterator it2;
        int[] iArr2;
        boolean z;
        boolean z2;
        if (this.zbh) {
            zbtu zbtuVar = ((zbub) obj).zbb;
            if (!zbtuVar.zba.isEmpty()) {
                Iterator zbg = zbtuVar.zbg();
                entry = (Map.Entry) zbg.next();
                it = zbg;
                iArr = this.zbc;
                Unsafe unsafe = zbb;
                int i5 = 1048575;
                int i6 = 0;
                i = 0;
                while (i < iArr.length) {
                    int zbs = zbs(i);
                    int[] iArr3 = this.zbc;
                    int zbr = zbr(zbs);
                    int i7 = iArr3[i];
                    if (zbr <= 17) {
                        int i8 = iArr3[i + 2];
                        int i9 = i8 & 1048575;
                        if (i9 != i5) {
                            if (i9 == 1048575) {
                                entry2 = entry;
                                i6 = 0;
                            } else {
                                entry2 = entry;
                                i6 = unsafe.getInt(obj, i9);
                            }
                            i5 = i9;
                        } else {
                            entry2 = entry;
                        }
                        i2 = i5;
                        i4 = 1 << (i8 >>> 20);
                        i3 = i6;
                    } else {
                        entry2 = entry;
                        i2 = i5;
                        i3 = i6;
                        i4 = 0;
                    }
                    while (entry2 != null) {
                        if (i7 >= 32149011) {
                            this.zbm.zbb(zbwyVar, entry2);
                            entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                        } else {
                            long j = zbs & 1048575;
                            switch (zbr) {
                                case 0:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbf(i7, zbws.zba(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbo(i7, zbws.zbb(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbt(i7, unsafe.getLong(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbL(i7, unsafe.getLong(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 4:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbr(i7, unsafe.getInt(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 5:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbm(i7, unsafe.getLong(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 6:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbk(i7, unsafe.getInt(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 7:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbb(i7, zbws.zbw(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 8:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbP(i7, unsafe.getObject(obj, j), zbwyVar);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 9:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbw(i7, unsafe.getObject(obj, j), zbv(i));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 10:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbd(i7, (zbtc) unsafe.getObject(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 11:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbJ(i7, unsafe.getInt(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 12:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbi(i7, unsafe.getInt(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 13:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zby(i7, unsafe.getInt(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 14:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbA(i7, unsafe.getLong(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 15:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbC(i7, unsafe.getInt(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 16:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbE(i7, unsafe.getLong(obj, j));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 17:
                                    it2 = it;
                                    iArr2 = iArr;
                                    if (zbJ(obj, i, i2, i3, i4)) {
                                        zbwyVar.zbq(i7, unsafe.getObject(obj, j), zbv(i));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 18:
                                    z = false;
                                    zbvz.zbr(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 19:
                                    z = false;
                                    zbvz.zbv(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 20:
                                    z = false;
                                    zbvz.zbx(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 21:
                                    z = false;
                                    zbvz.zbD(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 22:
                                    z = false;
                                    zbvz.zbw(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 23:
                                    z = false;
                                    zbvz.zbu(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 24:
                                    z = false;
                                    zbvz.zbt(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 25:
                                    z = false;
                                    zbvz.zbq(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 26:
                                    int i10 = this.zbc[i];
                                    List list = (List) unsafe.getObject(obj, j);
                                    int i11 = zbvz.zba;
                                    if (list != null && !list.isEmpty()) {
                                        zbwyVar.zbI(i10, list);
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 27:
                                    int i12 = this.zbc[i];
                                    List list2 = (List) unsafe.getObject(obj, j);
                                    zbvx zbv = zbv(i);
                                    int i13 = zbvz.zba;
                                    if (list2 != null && !list2.isEmpty()) {
                                        for (int i14 = 0; i14 < list2.size(); i14++) {
                                            ((zbtl) zbwyVar).zbw(i12, list2.get(i14), zbv);
                                        }
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 28:
                                    int i15 = this.zbc[i];
                                    List list3 = (List) unsafe.getObject(obj, j);
                                    int i16 = zbvz.zba;
                                    if (list3 != null && !list3.isEmpty()) {
                                        zbwyVar.zbe(i15, list3);
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 29:
                                    z2 = false;
                                    zbvz.zbC(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 30:
                                    z2 = false;
                                    zbvz.zbs(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 31:
                                    z2 = false;
                                    zbvz.zby(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 32:
                                    z2 = false;
                                    zbvz.zbz(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 33:
                                    z2 = false;
                                    zbvz.zbA(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 34:
                                    z2 = false;
                                    zbvz.zbB(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, false);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 35:
                                    zbvz.zbr(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 36:
                                    zbvz.zbv(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 37:
                                    zbvz.zbx(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 38:
                                    zbvz.zbD(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 39:
                                    zbvz.zbw(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 40:
                                    zbvz.zbu(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 41:
                                    zbvz.zbt(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 42:
                                    zbvz.zbq(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 43:
                                    zbvz.zbC(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 44:
                                    zbvz.zbs(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 45:
                                    zbvz.zby(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 46:
                                    zbvz.zbz(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 47:
                                    zbvz.zbA(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                    zbvz.zbB(this.zbc[i], (List) unsafe.getObject(obj, j), zbwyVar, true);
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    int i17 = this.zbc[i];
                                    List list4 = (List) unsafe.getObject(obj, j);
                                    zbvx zbv2 = zbv(i);
                                    int i18 = zbvz.zba;
                                    if (list4 != null && !list4.isEmpty()) {
                                        for (int i19 = 0; i19 < list4.size(); i19++) {
                                            ((zbtl) zbwyVar).zbq(i17, list4.get(i19), zbv2);
                                        }
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 50:
                                    Object object = unsafe.getObject(obj, j);
                                    if (object != null) {
                                        zbwyVar.zbv(i7, ((zbvf) zbw(i)).zbc(), (zbvg) object);
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbf(i7, zbm(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbo(i7, zbn(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbt(i7, zbt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbL(i7, zbt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbr(i7, zbo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 56:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbm(i7, zbt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 57:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbk(i7, zbo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 58:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbb(i7, zbN(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 59:
                                    if (zbM(obj, i7, i)) {
                                        zbP(i7, unsafe.getObject(obj, j), zbwyVar);
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbw(i7, unsafe.getObject(obj, j), zbv(i));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbd(i7, (zbtc) unsafe.getObject(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 62:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbJ(i7, zbo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbi(i7, zbo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 64:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zby(i7, zbo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 65:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbA(i7, zbt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbC(i7, zbo(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 67:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbE(i7, zbt(obj, j));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                case 68:
                                    if (zbM(obj, i7, i)) {
                                        zbwyVar.zbq(i7, unsafe.getObject(obj, j), zbv(i));
                                    }
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                                default:
                                    it2 = it;
                                    iArr2 = iArr;
                                    break;
                            }
                            i += 3;
                            i5 = i2;
                            entry = entry2;
                            it = it2;
                            iArr = iArr2;
                            i6 = i3;
                        }
                    }
                    long j2 = zbs & 1048575;
                    switch (zbr) {
                    }
                    i += 3;
                    i5 = i2;
                    entry = entry2;
                    it = it2;
                    iArr = iArr2;
                    i6 = i3;
                }
                Iterator it3 = it;
                while (entry != null) {
                    this.zbm.zbb(zbwyVar, entry);
                    entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
                }
                ((zbuf) obj).zbc.zbl(zbwyVar);
            }
        }
        entry = null;
        it = null;
        iArr = this.zbc;
        Unsafe unsafe2 = zbb;
        int i52 = 1048575;
        int i62 = 0;
        i = 0;
        while (i < iArr.length) {
        }
        Iterator it32 = it;
        while (entry != null) {
        }
        ((zbuf) obj).zbc.zbl(zbwyVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zbj(Object obj, Object obj2) {
        int i;
        boolean zbE;
        for (0; i < this.zbc.length; i + 3) {
            int zbs = zbs(i);
            long j = zbs & 1048575;
            switch (zbr(zbs)) {
                case 0:
                    i = (zbH(obj, obj2, i) && Double.doubleToLongBits(zbws.zba(obj, j)) == Double.doubleToLongBits(zbws.zba(obj2, j))) ? i + 3 : 0;
                    return false;
                case 1:
                    if (zbH(obj, obj2, i) && Float.floatToIntBits(zbws.zbb(obj, j)) == Float.floatToIntBits(zbws.zbb(obj2, j))) {
                    }
                    return false;
                case 2:
                    if (zbH(obj, obj2, i) && zbws.zbd(obj, j) == zbws.zbd(obj2, j)) {
                    }
                    return false;
                case 3:
                    if (zbH(obj, obj2, i) && zbws.zbd(obj, j) == zbws.zbd(obj2, j)) {
                    }
                    return false;
                case 4:
                    if (zbH(obj, obj2, i) && zbws.zbc(obj, j) == zbws.zbc(obj2, j)) {
                    }
                    return false;
                case 5:
                    if (zbH(obj, obj2, i) && zbws.zbd(obj, j) == zbws.zbd(obj2, j)) {
                    }
                    return false;
                case 6:
                    if (zbH(obj, obj2, i) && zbws.zbc(obj, j) == zbws.zbc(obj2, j)) {
                    }
                    return false;
                case 7:
                    if (zbH(obj, obj2, i) && zbws.zbw(obj, j) == zbws.zbw(obj2, j)) {
                    }
                    return false;
                case 8:
                    if (zbH(obj, obj2, i) && zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                    }
                    return false;
                case 9:
                    if (zbH(obj, obj2, i) && zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                    }
                    return false;
                case 10:
                    if (zbH(obj, obj2, i) && zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                    }
                    return false;
                case 11:
                    if (zbH(obj, obj2, i) && zbws.zbc(obj, j) == zbws.zbc(obj2, j)) {
                    }
                    return false;
                case 12:
                    if (zbH(obj, obj2, i) && zbws.zbc(obj, j) == zbws.zbc(obj2, j)) {
                    }
                    return false;
                case 13:
                    if (zbH(obj, obj2, i) && zbws.zbc(obj, j) == zbws.zbc(obj2, j)) {
                    }
                    return false;
                case 14:
                    if (zbH(obj, obj2, i) && zbws.zbd(obj, j) == zbws.zbd(obj2, j)) {
                    }
                    return false;
                case 15:
                    if (zbH(obj, obj2, i) && zbws.zbc(obj, j) == zbws.zbc(obj2, j)) {
                    }
                    return false;
                case 16:
                    if (zbH(obj, obj2, i) && zbws.zbd(obj, j) == zbws.zbd(obj2, j)) {
                    }
                    return false;
                case 17:
                    if (zbH(obj, obj2, i) && zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
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
                    zbE = zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j));
                    if (zbE) {
                        return false;
                    }
                case 50:
                    zbE = zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j));
                    if (zbE) {
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
                    long zbp = zbp(i) & 1048575;
                    if (zbws.zbc(obj, zbp) == zbws.zbc(obj2, zbp) && zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                    }
                    return false;
                default:
            }
        }
        if (!((zbuf) obj).zbc.equals(((zbuf) obj2).zbc)) {
            return false;
        }
        if (this.zbh) {
            return ((zbub) obj).zbb.equals(((zbub) obj2).zbb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zbj) {
            int[] iArr = this.zbi;
            int[] iArr2 = this.zbc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zbs = zbs(i6);
            int i8 = this.zbc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zbb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & zbs) != 0 && !zbJ(obj, i6, i, i2, i10)) {
                return false;
            }
            int zbr = zbr(zbs);
            if (zbr != 9 && zbr != 17) {
                if (zbr != 27) {
                    if (zbr == 60 || zbr == 68) {
                        if (zbM(obj, i7, i6) && !zbK(obj, zbs, zbv(i6))) {
                            return false;
                        }
                    } else if (zbr != 49) {
                        if (zbr != 50) {
                            continue;
                        } else {
                            zbvg zbvgVar = (zbvg) zbws.zbf(obj, zbs & 1048575);
                            if (!zbvgVar.isEmpty() && ((zbvf) zbw(i6)).zbc().zbc.zbb() == zbwx.MESSAGE) {
                                zbvx zbvxVar = null;
                                for (Object obj2 : zbvgVar.values()) {
                                    if (zbvxVar == null) {
                                        zbvxVar = zbvu.zba().zbb(obj2.getClass());
                                    }
                                    if (!zbvxVar.zbk(obj2)) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
                List list = (List) zbws.zbf(obj, zbs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zbvx zbv = zbv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zbv.zbk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zbJ(obj, i6, i, i2, i10) && !zbK(obj, zbs, zbv(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return !this.zbh || ((zbub) obj).zbb.zbm();
    }
}
