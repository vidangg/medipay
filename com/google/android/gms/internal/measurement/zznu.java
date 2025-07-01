package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznu {
    public static final /* synthetic */ int zza = 0;
    private static final zzoe zzb;

    static {
        int i = zznp.zza;
        zzb = new zzog();
    }

    public static void zzA(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzL(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzE(Object obj, Object obj2) {
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
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(zzmeVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Integer) list.get(i2)).intValue());
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
        return size * (zzlk.zzz(i << 3) + 4);
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
        return size * (zzlk.zzz(i << 3) + 8);
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
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(zzmeVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Integer) list.get(i2)).intValue());
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
        if (list instanceof zzmw) {
            zzmw zzmwVar = (zzmw) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(zzmwVar.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, Object obj, zzns zznsVar) {
        int i2 = i << 3;
        if (obj instanceof zzms) {
            int zzz = zzlk.zzz(i2);
            int zza2 = ((zzms) obj).zza();
            return zzz + zzlk.zzz(zza2) + zza2;
        }
        return zzlk.zzz(i2) + zzlk.zzx((zznh) obj, zznsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            i = 0;
            while (i2 < size) {
                int zze = zzmeVar.zze(i2);
                i += zzlk.zzz((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzlk.zzz((intValue >> 31) ^ (intValue + intValue));
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
        if (list instanceof zzmw) {
            zzmw zzmwVar = (zzmw) list;
            i = 0;
            while (i2 < size) {
                long zza2 = zzmwVar.zza(i2);
                i += zzlk.zzA((zza2 >> 63) ^ (zza2 + zza2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzlk.zzA((longValue >> 63) ^ (longValue + longValue));
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
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzz(zzmeVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzz(((Integer) list.get(i2)).intValue());
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
        if (list instanceof zzmw) {
            zzmw zzmwVar = (zzmw) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(zzmwVar.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzoe zzm() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r5 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object zzn(Object obj, int i, int i2, Object obj2, zzoe zzoeVar) {
        Object obj3;
        if (obj2 == null) {
            zzmd zzmdVar = (zzmd) obj;
            zzof zzofVar = zzmdVar.zzc;
            obj3 = zzofVar;
            if (zzofVar == zzof.zzc()) {
                zzof zzf = zzof.zzf();
                zzmdVar.zzc = zzf;
                obj3 = zzf;
            }
        }
        ((zzof) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(zzlq zzlqVar, Object obj, Object obj2) {
        if (((zzma) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzoe zzoeVar, Object obj, Object obj2) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        zzof zzofVar2 = ((zzmd) obj2).zzc;
        if (!zzof.zzc().equals(zzofVar2)) {
            if (zzof.zzc().equals(zzofVar)) {
                zzofVar = zzof.zze(zzofVar, zzofVar2);
            } else {
                zzofVar.zzd(zzofVar2);
            }
        }
        zzmdVar.zzc = zzofVar;
    }

    public static void zzq(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzA(i, list, z);
    }
}
