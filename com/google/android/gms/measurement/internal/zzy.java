package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzy {
    final /* synthetic */ zzae zza;
    private String zzb;
    private boolean zzc;
    private com.google.android.gms.internal.measurement.zzic zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzy(zzae zzaeVar, String str, zzad zzadVar) {
        this.zza = zzaeVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ BitSet zzb(zzy zzyVar) {
        return zzyVar.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzhi zza(int i) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzhh zzb = com.google.android.gms.internal.measurement.zzhi.zzb();
        zzb.zza(i);
        zzb.zzc(this.zzc);
        com.google.android.gms.internal.measurement.zzic zzicVar = this.zzd;
        if (zzicVar != null) {
            zzb.zzd(zzicVar);
        }
        com.google.android.gms.internal.measurement.zzib zze = com.google.android.gms.internal.measurement.zzic.zze();
        zze.zzb(zzqa.zzu(this.zze));
        zze.zzd(zzqa.zzu(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.zzg.keySet()) {
                int intValue = num.intValue();
                Long l = (Long) this.zzg.get(num);
                if (l != null) {
                    com.google.android.gms.internal.measurement.zzhj zzc = com.google.android.gms.internal.measurement.zzhk.zzc();
                    zzc.zzb(intValue);
                    zzc.zza(l.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzhk) zzc.zzba());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zze.zza(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.zzh.keySet()) {
                com.google.android.gms.internal.measurement.zzid zzd = com.google.android.gms.internal.measurement.zzie.zzd();
                zzd.zzb(num2.intValue());
                List list2 = (List) this.zzh.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzie) zzd.zzba());
            }
            list = arrayList3;
        }
        zze.zzc(list);
        zzb.zzb(zze);
        return (com.google.android.gms.internal.measurement.zzhi) zzb.zzba();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzab zzabVar) {
        int zza = zzabVar.zza();
        Boolean bool = zzabVar.zzd;
        if (bool != null) {
            BitSet bitSet = this.zzf;
            bool.booleanValue();
            bitSet.set(zza, true);
        }
        Boolean bool2 = zzabVar.zze;
        if (bool2 != null) {
            this.zze.set(zza, bool2.booleanValue());
        }
        if (zzabVar.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza);
            Long l = (Long) map.get(valueOf);
            long longValue = zzabVar.zzf.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzabVar.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzabVar.zzc()) {
                list.clear();
            }
            com.google.android.gms.internal.measurement.zzpq.zzb();
            zzio zzioVar = this.zza.zzu;
            if (zzioVar.zzf().zzx(this.zzb, zzgi.zzaE) && zzabVar.zzb()) {
                list.clear();
            }
            com.google.android.gms.internal.measurement.zzpq.zzb();
            if (!zzioVar.zzf().zzx(this.zzb, zzgi.zzaE)) {
                list.add(Long.valueOf(zzabVar.zzg.longValue() / 1000));
                return;
            }
            Long valueOf3 = Long.valueOf(zzabVar.zzg.longValue() / 1000);
            if (list.contains(valueOf3)) {
                return;
            }
            list.add(valueOf3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzy(zzae zzaeVar, String str, com.google.android.gms.internal.measurement.zzic zzicVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzad zzadVar) {
        this.zza = zzaeVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzicVar;
    }
}
