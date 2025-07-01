package com.google.android.gms.measurement.internal;

import androidx.camera.video.AudioStats;
import com.google.android.gms.common.internal.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzab {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, int i, boolean z, String str2, List list, String str3, zzhe zzheVar) {
        if (i == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzheVar != null) {
                        zzheVar.zzk().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zze(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzfp zzfpVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzfpVar);
        if (zzfpVar.zzg()) {
            if (zzfpVar.zzm() != 1) {
                if (zzfpVar.zzm() == 5) {
                    if (!zzfpVar.zzk() || !zzfpVar.zzj()) {
                        return null;
                    }
                } else if (!zzfpVar.zzh()) {
                    return null;
                }
                int zzm = zzfpVar.zzm();
                if (zzfpVar.zzm() == 5) {
                    if (zzqa.zzA(zzfpVar.zze()) && zzqa.zzA(zzfpVar.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzfpVar.zze());
                            bigDecimal4 = new BigDecimal(zzfpVar.zzd());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!zzqa.zzA(zzfpVar.zzc())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(zzfpVar.zzc());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (zzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i = zzm - 1;
                if (i == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i != 3) {
                    if (i == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzf(String str, com.google.android.gms.internal.measurement.zzfv zzfvVar, zzhe zzheVar) {
        String zzd;
        List list;
        Preconditions.checkNotNull(zzfvVar);
        if (str == null || !zzfvVar.zzi() || zzfvVar.zzj() == 1 || (zzfvVar.zzj() != 7 ? !zzfvVar.zzh() : zzfvVar.zza() == 0)) {
            return null;
        }
        int zzj = zzfvVar.zzj();
        boolean zzf = zzfvVar.zzf();
        if (zzf || zzj == 2 || zzj == 7) {
            zzd = zzfvVar.zzd();
        } else {
            zzd = zzfvVar.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str2 = zzd;
        if (zzfvVar.zza() == 0) {
            list = null;
        } else {
            List zze = zzfvVar.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                Iterator it = zze.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
            list = zze;
        }
        return zzd(str, zzj, zzf, str2, list, zzj == 2 ? str2 : null, zzheVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzg(double d, com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        try {
            return zze(new BigDecimal(d), zzfpVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzh(long j, com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        try {
            return zze(new BigDecimal(j), zzfpVar, AudioStats.AUDIO_AMPLITUDE_NONE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzi(String str, com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        if (!zzqa.zzA(str)) {
            return null;
        }
        try {
            return zze(new BigDecimal(str), zzfpVar, AudioStats.AUDIO_AMPLITUDE_NONE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzj(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzc();
}
