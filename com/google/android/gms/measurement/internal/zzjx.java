package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzjx {
    public static final zzjx zza = new zzjx(null, null, 100);
    private final EnumMap zzb;
    private final int zzc;

    public zzjx(Boolean bool, Boolean bool2, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap) zzjw.AD_STORAGE, (zzjw) zzh(null));
        enumMap.put((EnumMap) zzjw.ANALYTICS_STORAGE, (zzjw) zzh(null));
        this.zzc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char zza(zzju zzjuVar) {
        if (zzjuVar == null) {
            return '-';
        }
        int ordinal = zzjuVar.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal != 2) {
            return ordinal != 3 ? '-' : '1';
        }
        return '0';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzju zzd(String str) {
        if (str == null) {
            return zzju.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzju.GRANTED;
        }
        if (str.equals("denied")) {
            return zzju.DENIED;
        }
        return zzju.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzju zzh(Boolean bool) {
        if (bool == null) {
            return zzju.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzju.GRANTED;
        }
        return zzju.DENIED;
    }

    public static zzjx zzi(Bundle bundle, int i) {
        zzjw[] zzjwVarArr;
        if (bundle == null) {
            return new zzjx(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zzjw.class);
        zzjwVarArr = zzjv.STORAGE.zzd;
        for (zzjw zzjwVar : zzjwVarArr) {
            enumMap.put((EnumMap) zzjwVar, (zzjw) zzd(bundle.getString(zzjwVar.zze)));
        }
        return new zzjx(enumMap, i);
    }

    public static zzjx zzj(zzju zzjuVar, zzju zzjuVar2, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        enumMap.put((EnumMap) zzjw.AD_STORAGE, (zzjw) zzjuVar);
        enumMap.put((EnumMap) zzjw.ANALYTICS_STORAGE, (zzjw) zzjuVar2);
        return new zzjx(enumMap, -10);
    }

    public static zzjx zzk(String str, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        zzjw[] zzb = zzjv.STORAGE.zzb();
        for (int i2 = 0; i2 < zzb.length; i2++) {
            String str2 = str == null ? "" : str;
            zzjw zzjwVar = zzb[i2];
            int i3 = i2 + 2;
            if (i3 < str2.length()) {
                enumMap.put((EnumMap) zzjwVar, (zzjw) zzg(str2.charAt(i3)));
            } else {
                enumMap.put((EnumMap) zzjwVar, (zzjw) zzju.UNINITIALIZED);
            }
        }
        return new zzjx(enumMap, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzn(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzo(zzju zzjuVar) {
        int ordinal = zzjuVar.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    public static boolean zzs(int i, int i2) {
        int i3 = -30;
        if (i == -20) {
            if (i2 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i3 = i;
        } else if (i2 == -20) {
            return true;
        }
        return i3 == i2 || i < i2;
    }

    public final boolean equals(Object obj) {
        zzjw[] zzjwVarArr;
        if (!(obj instanceof zzjx)) {
            return false;
        }
        zzjx zzjxVar = (zzjx) obj;
        zzjwVarArr = zzjv.STORAGE.zzd;
        for (zzjw zzjwVar : zzjwVarArr) {
            if (this.zzb.get(zzjwVar) != zzjxVar.zzb.get(zzjwVar)) {
                return false;
            }
        }
        return this.zzc == zzjxVar.zzc;
    }

    public final int hashCode() {
        Iterator it = this.zzb.values().iterator();
        int i = this.zzc * 17;
        while (it.hasNext()) {
            i = (i * 31) + ((zzju) it.next()).hashCode();
        }
        return i;
    }

    public final String toString() {
        zzjw[] zzjwVarArr;
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzn(this.zzc));
        zzjwVarArr = zzjv.STORAGE.zzd;
        for (zzjw zzjwVar : zzjwVarArr) {
            sb.append(",");
            sb.append(zzjwVar.zze);
            sb.append("=");
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            if (zzjuVar == null) {
                zzjuVar = zzju.UNINITIALIZED;
            }
            sb.append(zzjuVar);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final Bundle zzc() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzb.entrySet()) {
            String zzo = zzo((zzju) entry.getValue());
            if (zzo != null) {
                bundle.putString(((zzjw) entry.getKey()).zze, zzo);
            }
        }
        return bundle;
    }

    public final zzju zze() {
        zzju zzjuVar = (zzju) this.zzb.get(zzjw.AD_STORAGE);
        return zzjuVar == null ? zzju.UNINITIALIZED : zzjuVar;
    }

    public final zzju zzf() {
        zzju zzjuVar = (zzju) this.zzb.get(zzjw.ANALYTICS_STORAGE);
        return zzjuVar == null ? zzju.UNINITIALIZED : zzjuVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjx zzl(zzjx zzjxVar) {
        zzjw[] zzjwVarArr;
        EnumMap enumMap = new EnumMap(zzjw.class);
        zzjwVarArr = zzjv.STORAGE.zzd;
        for (zzjw zzjwVar : zzjwVarArr) {
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            zzju zzjuVar2 = (zzju) zzjxVar.zzb.get(zzjwVar);
            if (zzjuVar != null) {
                if (zzjuVar2 != null) {
                    zzju zzjuVar3 = zzju.UNINITIALIZED;
                    if (zzjuVar != zzjuVar3) {
                        if (zzjuVar2 != zzjuVar3) {
                            zzju zzjuVar4 = zzju.POLICY;
                            if (zzjuVar != zzjuVar4) {
                                if (zzjuVar2 != zzjuVar4) {
                                    zzju zzjuVar5 = zzju.DENIED;
                                    zzjuVar = (zzjuVar == zzjuVar5 || zzjuVar2 == zzjuVar5) ? zzjuVar5 : zzju.GRANTED;
                                }
                            }
                        }
                    }
                }
                if (zzjuVar == null) {
                    enumMap.put((EnumMap) zzjwVar, (zzjw) zzjuVar);
                }
            }
            zzjuVar = zzjuVar2;
            if (zzjuVar == null) {
            }
        }
        return new zzjx(enumMap, 100);
    }

    public final zzjx zzm(zzjx zzjxVar) {
        zzjw[] zzjwVarArr;
        EnumMap enumMap = new EnumMap(zzjw.class);
        zzjwVarArr = zzjv.STORAGE.zzd;
        for (zzjw zzjwVar : zzjwVarArr) {
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            if (zzjuVar == zzju.UNINITIALIZED) {
                zzjuVar = (zzju) zzjxVar.zzb.get(zzjwVar);
            }
            if (zzjuVar != null) {
                enumMap.put((EnumMap) zzjwVar, (zzjw) zzjuVar);
            }
        }
        return new zzjx(enumMap, this.zzc);
    }

    public final String zzp() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zzjw zzjwVar : zzjv.STORAGE.zzb()) {
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            char c = '-';
            if (zzjuVar != null && (ordinal = zzjuVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzq() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjw zzjwVar : zzjv.STORAGE.zzb()) {
            sb.append(zza((zzju) this.zzb.get(zzjwVar)));
        }
        return sb.toString();
    }

    public final boolean zzr(zzjw zzjwVar) {
        return ((zzju) this.zzb.get(zzjwVar)) != zzju.DENIED;
    }

    public final boolean zzt() {
        Iterator it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (((zzju) it.next()) != zzju.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzu(zzjx zzjxVar) {
        EnumMap enumMap = this.zzb;
        for (zzjw zzjwVar : (zzjw[]) enumMap.keySet().toArray(new zzjw[0])) {
            zzju zzjuVar = (zzju) enumMap.get(zzjwVar);
            zzju zzjuVar2 = (zzju) zzjxVar.zzb.get(zzjwVar);
            if (zzjuVar == zzju.DENIED && zzjuVar2 != zzju.DENIED) {
                return true;
            }
        }
        return false;
    }

    private zzjx(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzju zzg(char c) {
        if (c == '+') {
            return zzju.POLICY;
        }
        if (c == '0') {
            return zzju.DENIED;
        }
        if (c == '1') {
            return zzju.GRANTED;
        }
        return zzju.UNINITIALIZED;
    }
}
