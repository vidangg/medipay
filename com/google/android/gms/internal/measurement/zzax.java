package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzax {
    final Map zza = new HashMap();
    final zzbj zzb = new zzbj();

    public zzax() {
        zzb(new zzav());
        zzb(new zzay());
        zzb(new zzaz());
        zzb(new zzbc());
        zzb(new zzbh());
        zzb(new zzbi());
        zzb(new zzbk());
    }

    public final zzap zza(zzg zzgVar, zzap zzapVar) {
        zzaw zzawVar;
        zzh.zzc(zzgVar);
        if (!(zzapVar instanceof zzaq)) {
            return zzapVar;
        }
        zzaq zzaqVar = (zzaq) zzapVar;
        ArrayList zzc = zzaqVar.zzc();
        String zzb = zzaqVar.zzb();
        Map map = this.zza;
        if (map.containsKey(zzb)) {
            zzawVar = (zzaw) map.get(zzb);
        } else {
            zzawVar = this.zzb;
        }
        return zzawVar.zza(zzb, zzgVar, zzc);
    }

    final void zzb(zzaw zzawVar) {
        Iterator it = zzawVar.zza.iterator();
        while (it.hasNext()) {
            this.zza.put(((zzbl) it.next()).zzb().toString(), zzawVar);
        }
    }
}
