package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzle {
    private static final Class<?> zza = zzd();
    private static final zzlu<?, ?> zzb = zza(false);
    private static final zzlu<?, ?> zzc = zza(true);
    private static final zzlu<?, ?> zzd = new zzlw();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzjb.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzmr zzmrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zza(i, list);
    }

    public static void zzb(int i, List<zzht> list, zzmr zzmrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzmr zzmrVar, zzlc zzlcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zza(i, list, zzlcVar);
    }

    public static void zzb(int i, List<?> list, zzmr zzmrVar, zzlc zzlcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzb(i, list, zzlcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzd(zzjyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzii.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zze(zzjyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzii.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(zzjyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzii.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzk(zzjdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzii.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(zzjdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzii.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzg(zzjdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzii.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzh(zzjdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzii.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzi(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzb(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list) {
        int zzb2;
        int zzb3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzii.zze(i) * size;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            while (i2 < size) {
                Object zzb4 = zzjvVar.zzb(i2);
                if (zzb4 instanceof zzht) {
                    zzb3 = zzii.zzb((zzht) zzb4);
                } else {
                    zzb3 = zzii.zzb((String) zzb4);
                }
                zze += zzb3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzht) {
                    zzb2 = zzii.zzb((zzht) obj);
                } else {
                    zzb2 = zzii.zzb((String) obj);
                }
                zze += zzb2;
                i2++;
            }
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, Object obj, zzlc zzlcVar) {
        if (obj instanceof zzjt) {
            return zzii.zza(i, (zzjt) obj);
        }
        return zzii.zzb(i, (zzkk) obj, zzlcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list, zzlc zzlcVar) {
        int zza2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzii.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzjt) {
                zza2 = zzii.zza((zzjt) obj);
            } else {
                zza2 = zzii.zza((zzkk) obj, zzlcVar);
            }
            zze += zza2;
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<zzht> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzii.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzii.zzb(list.get(i2));
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<zzkk> list, zzlc zzlcVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzii.zzc(i, list.get(i3), zzlcVar);
        }
        return i2;
    }

    public static zzlu<?, ?> zza() {
        return zzb;
    }

    public static zzlu<?, ?> zzb() {
        return zzc;
    }

    public static zzlu<?, ?> zzc() {
        return zzd;
    }

    private static zzlu<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzlu) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzkh zzkhVar, T t, T t2, long j) {
        zzma.zza(t, j, zzkhVar.zza(zzma.zzf(t, j), zzma.zzf(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zziw<FT>> void zza(zziq<FT> zziqVar, T t, T t2) {
        zziu<FT> zza2 = zziqVar.zza(t2);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zziqVar.zzb(t).zza(zza2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzlu<UT, UB> zzluVar, T t, T t2) {
        zzluVar.zza(t, zzluVar.zzc(zzluVar.zzb(t), zzluVar.zzb(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, List<Integer> list, zzjg zzjgVar, UB ub, zzlu<UT, UB> zzluVar) {
        if (zzjgVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int intValue = num.intValue();
                if (zzjgVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzluVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzjgVar.zza(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zzluVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, int i2, UB ub, zzlu<UT, UB> zzluVar) {
        if (ub == null) {
            ub = zzluVar.zza();
        }
        zzluVar.zza((zzlu<UT, UB>) ub, i, i2);
        return ub;
    }
}
