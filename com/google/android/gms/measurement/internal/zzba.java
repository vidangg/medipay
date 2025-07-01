package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzba {
    public static final zzba zza = new zzba((Boolean) null, 100, (Boolean) null, (String) null);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap zzf;

    static {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap) zzjw.AD_USER_DATA, (zzjw) zzjx.zzh(bool));
        this.zzb = i;
        this.zzc = zzl();
        this.zzd = bool2;
        this.zze = str;
    }

    public static zzba zzc(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzba((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.DMA.zzb()) {
            enumMap.put((EnumMap) zzjwVar, (zzjw) zzjx.zzd(bundle.getString(zzjwVar.zze)));
        }
        return new zzba(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzba zzd(zzju zzjuVar, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        enumMap.put((EnumMap) zzjw.AD_USER_DATA, (zzjw) zzjuVar);
        return new zzba(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzba zze(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(zzjw.class);
        zzjw[] zzb = zzjv.DMA.zzb();
        int length = zzb.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            enumMap.put((EnumMap) zzb[i2], (zzjw) zzjx.zzg(split[i].charAt(0)));
            i2++;
            i++;
        }
        return new zzba(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public static Boolean zzg(Bundle bundle) {
        zzju zzd;
        if (bundle == null || (zzd = zzjx.zzd(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int ordinal = zzd.ordinal();
        if (ordinal != 2) {
            return ordinal != 3 ? null : true;
        }
        return false;
    }

    private final String zzl() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjw zzjwVar : zzjv.DMA.zzb()) {
            sb.append(":");
            sb.append(zzjx.zza((zzju) this.zzf.get(zzjwVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzba)) {
            return false;
        }
        zzba zzbaVar = (zzba) obj;
        if (this.zzc.equalsIgnoreCase(zzbaVar.zzc) && Objects.equals(this.zzd, zzbaVar.zzd)) {
            return Objects.equals(this.zze, zzbaVar.zze);
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjx.zzn(this.zzb));
        for (zzjw zzjwVar : zzjv.DMA.zzb()) {
            sb.append(",");
            sb.append(zzjwVar.zze);
            sb.append("=");
            zzju zzjuVar = (zzju) this.zzf.get(zzjwVar);
            if (zzjuVar == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = zzjuVar.ordinal();
                if (ordinal == 0) {
                    sb.append("uninitialized");
                } else if (ordinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (ordinal == 2) {
                    sb.append("denied");
                } else if (ordinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.zze;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzf.entrySet()) {
            String zzo = zzjx.zzo((zzju) entry.getValue());
            if (zzo != null) {
                bundle.putString(((zzjw) entry.getKey()).zze, zzo);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final zzju zzf() {
        zzju zzjuVar = (zzju) this.zzf.get(zzjw.AD_USER_DATA);
        return zzjuVar == null ? zzju.UNINITIALIZED : zzjuVar;
    }

    public final Boolean zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zze;
    }

    public final String zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        Iterator it = this.zzf.values().iterator();
        while (it.hasNext()) {
            if (((zzju) it.next()) != zzju.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        Boolean bool = this.zzd;
        if (bool == null) {
            i = 3;
        } else {
            i = true != bool.booleanValue() ? 13 : 7;
        }
        String str = this.zze;
        return this.zzc.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    private zzba(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzl();
        this.zzd = bool;
        this.zze = str;
    }
}
