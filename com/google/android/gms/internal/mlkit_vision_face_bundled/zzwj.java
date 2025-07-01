package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
final class zzwj {
    public static final /* synthetic */ int zza = 0;
    private static final zzwv zzb;

    static {
        int i = zzwe.zza;
        zzb = new zzwx();
    }

    public static void zzA(int i, List list, zzxi zzxiVar, zzwh zzwhVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzud) zzxiVar).zzv(i, list.get(i2), zzwhVar);
        }
    }

    public static void zzB(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzy(i, list, z);
    }

    public static void zzC(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzA(i, list, z);
    }

    public static void zzD(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzC(i, list, z);
    }

    public static void zzE(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzE(i, list, z);
    }

    public static void zzF(int i, List list, zzxi zzxiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzH(i, list);
    }

    public static void zzG(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzJ(i, list, z);
    }

    public static void zzH(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzL(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzI(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzux) {
            zzux zzuxVar = (zzux) list;
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(zzuxVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzuc.zzz(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzuc.zzz(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzux) {
            zzux zzuxVar = (zzux) list;
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(zzuxVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvl) {
            zzvl zzvlVar = (zzvl) list;
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(zzvlVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, Object obj, zzwh zzwhVar) {
        int i2 = i << 3;
        if (obj instanceof zzvh) {
            int zzz = zzuc.zzz(i2);
            int zza2 = ((zzvh) obj).zza();
            return zzz + zzuc.zzz(zza2) + zza2;
        }
        return zzuc.zzz(i2) + zzuc.zzx((zzvw) obj, zzwhVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzux) {
            zzux zzuxVar = (zzux) list;
            i = 0;
            while (i2 < size) {
                int zze = zzuxVar.zze(i2);
                i += zzuc.zzz((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzuc.zzz((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvl) {
            zzvl zzvlVar = (zzvl) list;
            i = 0;
            while (i2 < size) {
                long zze = zzvlVar.zze(i2);
                i += zzuc.zzA((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzuc.zzA((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzux) {
            zzux zzuxVar = (zzux) list;
            i = 0;
            while (i2 < size) {
                i += zzuc.zzz(zzuxVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzuc.zzz(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvl) {
            zzvl zzvlVar = (zzvl) list;
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(zzvlVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzuc.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzwv zzm() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r5 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object zzn(Object obj, int i, int i2, Object obj2, zzwv zzwvVar) {
        Object obj3;
        if (obj2 == null) {
            zzuw zzuwVar = (zzuw) obj;
            zzww zzwwVar = zzuwVar.zzc;
            obj3 = zzwwVar;
            if (zzwwVar == zzww.zzc()) {
                zzww zzf = zzww.zzf();
                zzuwVar.zzc = zzf;
                obj3 = zzf;
            }
        }
        ((zzww) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(zzui zzuiVar, Object obj, Object obj2) {
        zzum zzumVar = ((zzus) obj2).zzb;
        if (zzumVar.zza.isEmpty()) {
            return;
        }
        ((zzus) obj).zzb().zzi(zzumVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzwv zzwvVar, Object obj, Object obj2) {
        zzuw zzuwVar = (zzuw) obj;
        zzww zzwwVar = zzuwVar.zzc;
        zzww zzwwVar2 = ((zzuw) obj2).zzc;
        if (!zzww.zzc().equals(zzwwVar2)) {
            if (zzww.zzc().equals(zzwwVar)) {
                zzwwVar = zzww.zze(zzwwVar, zzwwVar2);
            } else {
                zzwwVar.zzd(zzwwVar2);
            }
        }
        zzuwVar.zzc = zzwwVar;
    }

    public static void zzq(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzxi zzxiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zze(i, list);
    }

    public static void zzs(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzxi zzxiVar, zzwh zzwhVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzud) zzxiVar).zzq(i, list.get(i2), zzwhVar);
        }
    }

    public static void zzy(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzs(i, list, z);
    }

    public static void zzz(int i, List list, zzxi zzxiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzxiVar.zzu(i, list, z);
    }
}
