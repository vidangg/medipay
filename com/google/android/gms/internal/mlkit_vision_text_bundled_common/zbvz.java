package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbvz {
    public static final /* synthetic */ int zba = 0;
    private static final zbwl zbb;

    static {
        int i = zbvu.zba;
        zbb = new zbwn();
    }

    public static void zbA(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbD(i, list, z);
    }

    public static void zbB(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbF(i, list, z);
    }

    public static void zbC(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbK(i, list, z);
    }

    public static void zbD(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbM(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zbE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zba(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zbug) {
            zbug zbugVar = (zbug) list;
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(zbugVar.zbe(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zbtk.zbD(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zbtk.zbD(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbe(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zbug) {
            zbug zbugVar = (zbug) list;
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(zbugVar.zbe(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zbva) {
            zbva zbvaVar = (zbva) list;
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(zbvaVar.zbe(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbh(int i, Object obj, zbvx zbvxVar) {
        int i2 = i << 3;
        if (obj instanceof zbuw) {
            int zbD = zbtk.zbD(i2);
            int zba2 = ((zbuw) obj).zba();
            return zbD + zbtk.zbD(zba2) + zba2;
        }
        return zbtk.zbD(i2) + zbtk.zbB((zbvm) obj, zbvxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zbug) {
            zbug zbugVar = (zbug) list;
            i = 0;
            while (i2 < size) {
                int zbe = zbugVar.zbe(i2);
                i += zbtk.zbD((zbe >> 31) ^ (zbe + zbe));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zbtk.zbD((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zbva) {
            zbva zbvaVar = (zbva) list;
            i = 0;
            while (i2 < size) {
                long zbe = zbvaVar.zbe(i2);
                i += zbtk.zbE((zbe >> 63) ^ (zbe + zbe));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zbtk.zbE((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zbug) {
            zbug zbugVar = (zbug) list;
            i = 0;
            while (i2 < size) {
                i += zbtk.zbD(zbugVar.zbe(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zbtk.zbD(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zbva) {
            zbva zbvaVar = (zbva) list;
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(zbvaVar.zbe(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zbtk.zbE(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zbwl zbm() {
        return zbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zbn(Object obj, int i, int i2, Object obj2, zbwl zbwlVar) {
        if (obj2 == null) {
            obj2 = zbwlVar.zba(obj);
        }
        ((zbwm) obj2).zbj(i << 3, Long.valueOf(i2));
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbo(zbtq zbtqVar, Object obj, Object obj2) {
        zbtu zbtuVar = ((zbub) obj2).zbb;
        if (zbtuVar.zba.isEmpty()) {
            return;
        }
        ((zbub) obj).zbg().zbi(zbtuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbp(zbwl zbwlVar, Object obj, Object obj2) {
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVar = zbufVar.zbc;
        zbwm zbwmVar2 = ((zbuf) obj2).zbc;
        if (!zbwm.zbc().equals(zbwmVar2)) {
            if (zbwm.zbc().equals(zbwmVar)) {
                zbwmVar = zbwm.zbe(zbwmVar, zbwmVar2);
            } else {
                zbwmVar.zbd(zbwmVar2);
            }
        }
        zbufVar.zbc = zbwmVar;
    }

    public static void zbq(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbc(i, list, z);
    }

    public static void zbr(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbg(i, list, z);
    }

    public static void zbs(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbj(i, list, z);
    }

    public static void zbt(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbl(i, list, z);
    }

    public static void zbu(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbn(i, list, z);
    }

    public static void zbv(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbp(i, list, z);
    }

    public static void zbw(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbs(i, list, z);
    }

    public static void zbx(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbu(i, list, z);
    }

    public static void zby(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbz(i, list, z);
    }

    public static void zbz(int i, List list, zbwy zbwyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zbwyVar.zbB(i, list, z);
    }
}
