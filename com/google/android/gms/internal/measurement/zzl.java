package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzl extends zzam {
    private final zzab zzb;

    public zzl(zzab zzabVar) {
        this.zzb = zzabVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzam, com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        char c;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            zzh.zzh("getEventName", 0, list);
            return new zzat(this.zzb.zzb().zze());
        }
        if (c == 1) {
            zzh.zzh("getParamValue", 1, list);
            return zzi.zzb(this.zzb.zzb().zzc(zzgVar.zzb((zzap) list.get(0)).zzi()));
        }
        if (c == 2) {
            zzh.zzh("getParams", 0, list);
            Map zzf = this.zzb.zzb().zzf();
            zzam zzamVar = new zzam();
            for (String str2 : zzf.keySet()) {
                zzamVar.zzr(str2, zzi.zzb(zzf.get(str2)));
            }
            return zzamVar;
        }
        if (c == 3) {
            zzh.zzh("getTimestamp", 0, list);
            return new zzah(Double.valueOf(this.zzb.zzb().zza()));
        }
        if (c != 4) {
            if (c == 5) {
                zzh.zzh("setParamValue", 2, list);
                String zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                zzap zzb = zzgVar.zzb((zzap) list.get(1));
                this.zzb.zzb().zzh(zzi, zzh.zzf(zzb));
                return zzb;
            }
            return super.zzcz(str, zzgVar, list);
        }
        zzh.zzh("setEventName", 1, list);
        zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
        if (zzf.equals(zzb2) || zzg.equals(zzb2)) {
            throw new IllegalArgumentException("Illegal event name");
        }
        this.zzb.zzb().zzg(zzb2.zzi());
        return new zzat(zzb2.zzi());
    }
}
