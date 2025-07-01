package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzi {
    public static zzap zza(zziz zzizVar) {
        if (zzizVar == null) {
            return zzap.zzf;
        }
        int zzj = zzizVar.zzj() - 1;
        if (zzj == 1) {
            if (zzizVar.zzi()) {
                return new zzat(zzizVar.zzd());
            }
            return zzap.zzm;
        }
        if (zzj == 2) {
            if (zzizVar.zzh()) {
                return new zzah(Double.valueOf(zzizVar.zza()));
            }
            return new zzah(null);
        }
        if (zzj == 3) {
            if (zzizVar.zzg()) {
                return new zzaf(Boolean.valueOf(zzizVar.zzf()));
            }
            return new zzaf(null);
        }
        if (zzj == 4) {
            List zze = zzizVar.zze();
            ArrayList arrayList = new ArrayList();
            Iterator it = zze.iterator();
            while (it.hasNext()) {
                arrayList.add(zza((zziz) it.next()));
            }
            return new zzaq(zzizVar.zzc(), arrayList);
        }
        throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
    }

    public static zzap zzb(Object obj) {
        if (obj == null) {
            return zzap.zzg;
        }
        if (obj instanceof String) {
            return new zzat((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (obj instanceof Map) {
            zzam zzamVar = new zzam();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                zzap zzb = zzb(map.get(obj2));
                if (obj2 != null) {
                    if (!(obj2 instanceof String)) {
                        obj2 = obj2.toString();
                    }
                    zzamVar.zzr((String) obj2, zzb);
                }
            }
            return zzamVar;
        }
        if (obj instanceof List) {
            zzae zzaeVar = new zzae();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzaeVar.zzq(zzaeVar.zzc(), zzb(it.next()));
            }
            return zzaeVar;
        }
        throw new IllegalArgumentException("Invalid value type");
    }
}
