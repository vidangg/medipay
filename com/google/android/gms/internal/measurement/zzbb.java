package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzbb {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x011f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.google.android.gms.internal.measurement.zzat] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v43, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.google.android.gms.internal.measurement.zzae] */
    public static zzap zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        String str2;
        String str3;
        char c;
        zzap zzapVar;
        String str4;
        double d;
        zzae zzaeVar2;
        double min;
        zzai zzaiVar;
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                str3 = "filter";
                if (str.equals(str2)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1354795244:
                str3 = "filter";
                if (str.equals("concat")) {
                    str2 = "toString";
                    c = 0;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -1274492040:
                str3 = "filter";
                if (str.equals(str3)) {
                    str2 = "toString";
                    c = 2;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c = '\n';
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c = 17;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c = 3;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c = 19;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = 7;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c = '\b';
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c = 5;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c = '\t';
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c = 15;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c = 16;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    str2 = "toString";
                    str3 = "filter";
                    c = 1;
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = '\r';
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 14;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 11;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = '\f';
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 4;
                    str2 = "toString";
                    str3 = "filter";
                    break;
                }
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
            default:
                str2 = "toString";
                str3 = "filter";
                c = 65535;
                break;
        }
        String str5 = str2;
        String str6 = str3;
        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        switch (c) {
            case 0:
                zzapVar = (zzae) zzaeVar.zzd();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzap zzb = zzgVar.zzb((zzap) it.next());
                        if (!(zzb instanceof zzag)) {
                            int zzc = zzapVar.zzc();
                            if (zzb instanceof zzae) {
                                zzae zzaeVar3 = (zzae) zzb;
                                Iterator zzk = zzaeVar3.zzk();
                                while (zzk.hasNext()) {
                                    Integer num = (Integer) zzk.next();
                                    zzapVar.zzq(num.intValue() + zzc, zzaeVar3.zze(num.intValue()));
                                }
                            } else {
                                zzapVar.zzq(zzc, zzb);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                return zzapVar;
            case 1:
                zzh.zzh("every", 1, list);
                zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb2 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() != 0 && zzb(zzaeVar, zzgVar, (zzao) zzb2, false, true).zzc() != zzaeVar.zzc()) {
                    return zzap.zzl;
                }
                return zzap.zzk;
            case 2:
                zzh.zzh(str6, 1, list);
                zzap zzb3 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb3 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return new zzae();
                }
                zzae zzaeVar4 = (zzae) zzaeVar.zzd();
                zzae zzb4 = zzb(zzaeVar, zzgVar, (zzao) zzb3, null, true);
                zzapVar = new zzae();
                Iterator zzk2 = zzb4.zzk();
                while (zzk2.hasNext()) {
                    zzapVar.zzq(zzapVar.zzc(), zzaeVar4.zze(((Integer) zzk2.next()).intValue()));
                }
                return zzapVar;
            case 3:
                zzh.zzh("forEach", 1, list);
                zzap zzb5 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb5 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return zzap.zzf;
                }
                zzb(zzaeVar, zzgVar, (zzao) zzb5, null, null);
                return zzap.zzf;
            case 4:
                zzh.zzj("indexOf", 2, list);
                zzap zzapVar2 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar2 = zzgVar.zzb((zzap) list.get(0));
                }
                if (list.size() > 1) {
                    double zza = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (zza >= zzaeVar.zzc()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    d2 = zza < AudioStats.AUDIO_AMPLITUDE_NONE ? zzaeVar.zzc() + zza : zza;
                }
                Iterator zzk3 = zzaeVar.zzk();
                while (zzk3.hasNext()) {
                    int intValue = ((Integer) zzk3.next()).intValue();
                    double d3 = intValue;
                    if (d3 >= d2 && zzh.zzl(zzaeVar.zze(intValue), zzapVar2)) {
                        return new zzah(Double.valueOf(d3));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzj("join", 1, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzm;
                }
                if (!list.isEmpty()) {
                    zzap zzb6 = zzgVar.zzb((zzap) list.get(0));
                    str4 = ((zzb6 instanceof zzan) || (zzb6 instanceof zzau)) ? "" : zzb6.zzi();
                } else {
                    str4 = ",";
                }
                zzapVar = new zzat(zzaeVar.zzj(str4));
                return zzapVar;
            case 6:
                zzh.zzj("lastIndexOf", 2, list);
                zzap zzapVar3 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar3 = zzgVar.zzb((zzap) list.get(0));
                }
                int zzc2 = zzaeVar.zzc() - 1;
                if (list.size() > 1) {
                    zzap zzb7 = zzgVar.zzb((zzap) list.get(1));
                    d = Double.isNaN(zzb7.zzh().doubleValue()) ? zzaeVar.zzc() - 1 : zzh.zza(zzb7.zzh().doubleValue());
                    if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
                        d += zzaeVar.zzc();
                    }
                } else {
                    d = zzc2;
                }
                if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int min2 = (int) Math.min(zzaeVar.zzc(), d); min2 >= 0; min2--) {
                    if (zzaeVar.zzs(min2) && zzh.zzl(zzaeVar.zze(min2), zzapVar3)) {
                        return new zzah(Double.valueOf(min2));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zzh("map", 1, list);
                zzap zzb8 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb8 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() == 0) {
                    return new zzae();
                }
                return zzb(zzaeVar, zzgVar, (zzao) zzb8, null, null);
            case '\b':
                zzh.zzh("pop", 0, list);
                int zzc3 = zzaeVar.zzc();
                if (zzc3 == 0) {
                    return zzap.zzf;
                }
                int i = zzc3 - 1;
                zzapVar = zzaeVar.zze(i);
                zzaeVar.zzp(i);
                return zzapVar;
            case '\t':
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzq(zzaeVar.zzc(), zzgVar.zzb((zzap) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            case '\n':
                return zzc(zzaeVar, zzgVar, list, true);
            case 11:
                return zzc(zzaeVar, zzgVar, list, false);
            case '\f':
                zzaeVar2 = zzaeVar;
                zzh.zzh("reverse", 0, list);
                int zzc4 = zzaeVar.zzc();
                if (zzc4 != 0) {
                    for (int i2 = 0; i2 < zzc4 / 2; i2++) {
                        if (zzaeVar2.zzs(i2)) {
                            zzap zze = zzaeVar2.zze(i2);
                            zzaeVar2.zzq(i2, null);
                            int i3 = (zzc4 - 1) - i2;
                            if (zzaeVar2.zzs(i3)) {
                                zzaeVar2.zzq(i2, zzaeVar2.zze(i3));
                            }
                            zzaeVar2.zzq(i3, zze);
                        }
                    }
                }
                return zzaeVar2;
            case '\r':
                zzh.zzh("shift", 0, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzf;
                }
                zzap zze2 = zzaeVar.zze(0);
                zzaeVar.zzp(0);
                return zze2;
            case 14:
                zzh.zzj("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzd();
                }
                double zzc5 = zzaeVar.zzc();
                double zza2 = zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza2 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                    min = Math.max(zza2 + zzc5, AudioStats.AUDIO_AMPLITUDE_NONE);
                } else {
                    min = Math.min(zza2, zzc5);
                }
                if (list.size() == 2) {
                    double zza3 = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (zza3 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                        zzc5 = Math.max(zzc5 + zza3, AudioStats.AUDIO_AMPLITUDE_NONE);
                    } else {
                        zzc5 = Math.min(zzc5, zza3);
                    }
                }
                zzae zzaeVar5 = new zzae();
                for (int i4 = (int) min; i4 < zzc5; i4++) {
                    zzaeVar5.zzq(zzaeVar5.zzc(), zzaeVar.zze(i4));
                }
                return zzaeVar5;
            case 15:
                zzh.zzh("some", 1, list);
                zzap zzb9 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb9 instanceof zzai)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzl;
                }
                zzai zzaiVar2 = (zzai) zzb9;
                Iterator zzk4 = zzaeVar.zzk();
                while (zzk4.hasNext()) {
                    int intValue2 = ((Integer) zzk4.next()).intValue();
                    if (zzaeVar.zzs(intValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue2), new zzah(Double.valueOf(intValue2)), zzaeVar)).zzg().booleanValue()) {
                        return zzap.zzk;
                    }
                }
                return zzap.zzl;
            case 16:
                zzaeVar2 = zzaeVar;
                zzh.zzj("sort", 1, list);
                if (zzaeVar.zzc() >= 2) {
                    List zzm = zzaeVar.zzm();
                    if (list.isEmpty()) {
                        zzaiVar = null;
                    } else {
                        zzap zzb10 = zzgVar.zzb((zzap) list.get(0));
                        if (!(zzb10 instanceof zzai)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzaiVar = (zzai) zzb10;
                    }
                    Collections.sort(zzm, new zzba(zzaiVar, zzgVar));
                    zzaeVar.zzn();
                    Iterator it3 = zzm.iterator();
                    int i5 = 0;
                    while (it3.hasNext()) {
                        zzaeVar2.zzq(i5, (zzap) it3.next());
                        i5++;
                    }
                }
                return zzaeVar2;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int zza4 = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza4 < 0) {
                    zza4 = Math.max(0, zza4 + zzaeVar.zzc());
                } else if (zza4 > zzaeVar.zzc()) {
                    zza4 = zzaeVar.zzc();
                }
                int zzc6 = zzaeVar.zzc();
                zzae zzaeVar6 = new zzae();
                if (list.size() > 1) {
                    int max = Math.max(0, (int) zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    if (max > 0) {
                        for (int i6 = zza4; i6 < Math.min(zzc6, zza4 + max); i6++) {
                            zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(zza4));
                            zzaeVar.zzp(zza4);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i7 = 2; i7 < list.size(); i7++) {
                            zzap zzb11 = zzgVar.zzb((zzap) list.get(i7));
                            if (!(zzb11 instanceof zzag)) {
                                zzaeVar.zzo((zza4 + i7) - 2, zzb11);
                            } else {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                        }
                    }
                } else {
                    while (zza4 < zzc6) {
                        zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(zza4));
                        zzaeVar.zzq(zza4, null);
                        zza4++;
                    }
                }
                return zzaeVar6;
            case 18:
                zzh.zzh(str5, 0, list);
                return new zzat(zzaeVar.zzj(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar7 = new zzae();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        zzap zzb12 = zzgVar.zzb((zzap) it4.next());
                        if (!(zzb12 instanceof zzag)) {
                            zzaeVar7.zzq(zzaeVar7.zzc(), zzb12);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int zzc7 = zzaeVar7.zzc();
                    Iterator zzk5 = zzaeVar.zzk();
                    while (zzk5.hasNext()) {
                        Integer num2 = (Integer) zzk5.next();
                        zzaeVar7.zzq(num2.intValue() + zzc7, zzaeVar.zze(num2.intValue()));
                    }
                    zzaeVar.zzn();
                    Iterator zzk6 = zzaeVar7.zzk();
                    while (zzk6.hasNext()) {
                        Integer num3 = (Integer) zzk6.next();
                        zzaeVar.zzq(num3.intValue(), zzaeVar7.zze(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzae zzb(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator zzk = zzaeVar.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzaeVar.zzs(intValue)) {
                zzap zza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue), new zzah(Double.valueOf(intValue)), zzaeVar));
                if (zza.zzg().equals(bool)) {
                    break;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzaeVar2.zzq(intValue, zza);
                }
            }
        }
        return zzaeVar2;
    }

    private static zzap zzc(zzae zzaeVar, zzg zzgVar, List list, boolean z) {
        zzap zzapVar;
        zzh.zzi("reduce", 1, list);
        zzh.zzj("reduce", 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        if (!(zzb instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzapVar = zzgVar.zzb((zzap) list.get(1));
            if (zzapVar instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (zzaeVar.zzc() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzapVar = null;
        }
        zzai zzaiVar = (zzai) zzb;
        int zzc = zzaeVar.zzc();
        int i = z ? 0 : zzc - 1;
        int i2 = z ? zzc - 1 : 0;
        int i3 = true == z ? 1 : -1;
        if (zzapVar == null) {
            zzapVar = zzaeVar.zze(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (zzaeVar.zzs(i)) {
                zzapVar = zzaiVar.zza(zzgVar, Arrays.asList(zzapVar, zzaeVar.zze(i), new zzah(Double.valueOf(i)), zzaeVar));
                if (zzapVar instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return zzapVar;
    }
}
