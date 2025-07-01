package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x017c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x027e  */
    @Override // com.google.android.gms.internal.measurement.zzap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        char c;
        zzat zzatVar;
        int i;
        String str7;
        zzat zzatVar2;
        double min;
        double min2;
        int i2;
        int i3;
        zzg zzgVar2;
        int i4;
        int length;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || FirebaseAnalytics.Event.SEARCH.equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
        } else {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "hasOwnProperty";
                if (!"trim".equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
                switch (str.hashCode()) {
                    case -1789698943:
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        if (str.equals(str5)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1776922004:
                        str4 = "charAt";
                        str6 = "toString";
                        if (str.equals(str6)) {
                            c = 14;
                            str5 = str3;
                            break;
                        } else {
                            str5 = str3;
                            c = 65535;
                            break;
                        }
                    case -1464939364:
                        str4 = "charAt";
                        if (str.equals("toLocaleLowerCase")) {
                            c = '\f';
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case -1361633751:
                        str4 = "charAt";
                        if (str.equals(str4)) {
                            str5 = str3;
                            str6 = "toString";
                            c = 0;
                            break;
                        }
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case -1354795244:
                        if (str.equals("concat")) {
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            c = 1;
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case -1137582698:
                        if (str.equals("toLowerCase")) {
                            c = '\r';
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case -906336856:
                        if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                            c = 7;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case -726908483:
                        if (str.equals(str2)) {
                            c = 11;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case -467511597:
                        if (str.equals("lastIndexOf")) {
                            c = 4;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case -399551817:
                        if (str.equals("toUpperCase")) {
                            c = 15;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case 3568674:
                        if (str.equals("trim")) {
                            c = 16;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case 103668165:
                        if (str.equals("match")) {
                            c = 5;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case 109526418:
                        if (str.equals("slice")) {
                            c = '\b';
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case 109648666:
                        if (str.equals("split")) {
                            c = '\t';
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case 530542161:
                        if (str.equals("substring")) {
                            c = '\n';
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case 1094496948:
                        if (str.equals("replace")) {
                            c = 6;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    case 1943291465:
                        if (str.equals("indexOf")) {
                            c = 3;
                            str4 = "charAt";
                            str5 = str3;
                            str6 = "toString";
                            break;
                        }
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                    default:
                        str4 = "charAt";
                        str5 = str3;
                        str6 = "toString";
                        c = 65535;
                        break;
                }
                String str8 = str5;
                String str9 = str4;
                switch (c) {
                    case 0:
                        zzh.zzj(str9, 1, list);
                        int zza = !list.isEmpty() ? (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) : 0;
                        String str10 = this.zza;
                        if (zza < 0 || zza >= str10.length()) {
                            return zzap.zzm;
                        }
                        return new zzat(String.valueOf(str10.charAt(zza)));
                    case 1:
                        zzatVar = this;
                        if (!list.isEmpty()) {
                            StringBuilder sb = new StringBuilder(zzatVar.zza);
                            for (int i5 = 0; i5 < list.size(); i5++) {
                                sb.append(zzgVar.zzb((zzap) list.get(i5)).zzi());
                            }
                            return new zzat(sb.toString());
                        }
                        return zzatVar;
                    case 2:
                        zzh.zzh(str8, 1, list);
                        String str11 = this.zza;
                        zzap zzb = zzgVar.zzb((zzap) list.get(0));
                        if (SessionDescription.ATTR_LENGTH.equals(zzb.zzi())) {
                            return zzaf.zzk;
                        }
                        double doubleValue = zzb.zzh().doubleValue();
                        if (doubleValue != Math.floor(doubleValue) || (i = (int) doubleValue) < 0 || i >= str11.length()) {
                            return zzaf.zzl;
                        }
                        return zzaf.zzk;
                    case 3:
                        zzh.zzj("indexOf", 2, list);
                        return new zzah(Double.valueOf(this.zza.indexOf(list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined", (int) zzh.zza(list.size() < 2 ? 0.0d : zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()))));
                    case 4:
                        zzh.zzj("lastIndexOf", 2, list);
                        String str12 = this.zza;
                        String zzi = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                        return new zzah(Double.valueOf(str12.lastIndexOf(zzi, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) ? Double.POSITIVE_INFINITY : zzh.zza(r1)))));
                    case 5:
                        zzh.zzj("match", 1, list);
                        Matcher matcher = Pattern.compile(list.size() <= 0 ? "" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(this.zza);
                        return matcher.find() ? new zzae(Arrays.asList(new zzat(matcher.group()))) : zzap.zzg;
                    case 6:
                        zzatVar = this;
                        zzh.zzj("replace", 2, list);
                        zzap zzapVar = zzap.zzf;
                        if (!list.isEmpty()) {
                            str7 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            if (list.size() > 1) {
                                zzapVar = zzgVar.zzb((zzap) list.get(1));
                            }
                        }
                        String str13 = str7;
                        String str14 = zzatVar.zza;
                        int indexOf = str14.indexOf(str13);
                        if (indexOf >= 0) {
                            if (zzapVar instanceof zzai) {
                                zzapVar = ((zzai) zzapVar).zza(zzgVar, Arrays.asList(new zzat(str13), new zzah(Double.valueOf(indexOf)), zzatVar));
                            }
                            zzatVar2 = new zzat(str14.substring(0, indexOf) + zzapVar.zzi() + str14.substring(indexOf + str13.length()));
                            return zzatVar2;
                        }
                        return zzatVar;
                    case 7:
                        zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                        if (Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(this.zza).find()) {
                            return new zzah(Double.valueOf(r1.start()));
                        }
                        return new zzah(Double.valueOf(-1.0d));
                    case '\b':
                        zzh.zzj("slice", 2, list);
                        String str15 = this.zza;
                        double zza2 = zzh.zza(!list.isEmpty() ? zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
                        if (zza2 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                            min = Math.max(str15.length() + zza2, AudioStats.AUDIO_AMPLITUDE_NONE);
                        } else {
                            min = Math.min(zza2, str15.length());
                        }
                        double zza3 = zzh.zza(list.size() > 1 ? zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() : str15.length());
                        if (zza3 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                            min2 = Math.max(str15.length() + zza3, AudioStats.AUDIO_AMPLITUDE_NONE);
                        } else {
                            min2 = Math.min(zza3, str15.length());
                        }
                        int i6 = (int) min;
                        return new zzat(str15.substring(i6, Math.max(0, ((int) min2) - i6) + i6));
                    case '\t':
                        zzh.zzj("split", 2, list);
                        String str16 = this.zza;
                        if (str16.length() == 0) {
                            return new zzae(Arrays.asList(this));
                        }
                        ArrayList arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(this);
                        } else {
                            String zzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            long zzd = list.size() > 1 ? zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) : 2147483647L;
                            if (zzd == 0) {
                                return new zzae();
                            }
                            String[] split = str16.split(Pattern.quote(zzi2), ((int) zzd) + 1);
                            int length2 = split.length;
                            if (!zzi2.isEmpty() || length2 <= 0) {
                                i2 = length2;
                                i3 = 0;
                            } else {
                                boolean isEmpty = split[0].isEmpty();
                                i2 = length2 - 1;
                                i3 = isEmpty;
                                if (!split[i2].isEmpty()) {
                                    i2 = length2;
                                    i3 = isEmpty;
                                }
                            }
                            if (length2 > zzd) {
                                i2--;
                            }
                            while (i3 < i2) {
                                arrayList.add(new zzat(split[i3]));
                                i3++;
                            }
                        }
                        return new zzae(arrayList);
                    case '\n':
                        zzh.zzj("substring", 2, list);
                        String str17 = this.zza;
                        if (list.isEmpty()) {
                            zzgVar2 = zzgVar;
                            i4 = 0;
                        } else {
                            zzgVar2 = zzgVar;
                            i4 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                        }
                        if (list.size() > 1) {
                            length = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                        } else {
                            length = str17.length();
                        }
                        int min3 = Math.min(Math.max(i4, 0), str17.length());
                        int min4 = Math.min(Math.max(length, 0), str17.length());
                        zzatVar2 = new zzat(str17.substring(Math.min(min3, min4), Math.max(min3, min4)));
                        return zzatVar2;
                    case 11:
                        zzh.zzh(str2, 0, list);
                        return new zzat(this.zza.toUpperCase());
                    case '\f':
                        zzh.zzh("toLocaleLowerCase", 0, list);
                        return new zzat(this.zza.toLowerCase());
                    case '\r':
                        zzh.zzh("toLowerCase", 0, list);
                        return new zzat(this.zza.toLowerCase(Locale.ENGLISH));
                    case 14:
                        zzatVar = this;
                        zzh.zzh(str6, 0, list);
                        return zzatVar;
                    case 15:
                        zzh.zzh("toUpperCase", 0, list);
                        return new zzat(this.zza.toUpperCase(Locale.ENGLISH));
                    case 16:
                        zzh.zzh("toUpperCase", 0, list);
                        return new zzat(this.zza.trim());
                    default:
                        throw new IllegalArgumentException("Command not supported");
                }
            }
        }
        str3 = "hasOwnProperty";
        switch (str.hashCode()) {
            case -1789698943:
                break;
            case -1776922004:
                break;
            case -1464939364:
                break;
            case -1361633751:
                break;
            case -1354795244:
                break;
            case -1137582698:
                break;
            case -906336856:
                break;
            case -726908483:
                break;
            case -467511597:
                break;
            case -399551817:
                break;
            case 3568674:
                break;
            case 103668165:
                break;
            case 109526418:
                break;
            case 109648666:
                break;
            case 530542161:
                break;
            case 1094496948:
                break;
            case 1943291465:
                break;
        }
        String str82 = str5;
        String str92 = str4;
        switch (c) {
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        String str = this.zza;
        if (!str.isEmpty()) {
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException unused) {
                return Double.valueOf(Double.NaN);
            }
        }
        return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}
