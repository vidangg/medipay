package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzaz extends zzaw {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzaz() {
        this.zza.add(zzbl.APPLY);
        this.zza.add(zzbl.BLOCK);
        this.zza.add(zzbl.BREAK);
        this.zza.add(zzbl.CASE);
        this.zza.add(zzbl.DEFAULT);
        this.zza.add(zzbl.CONTINUE);
        this.zza.add(zzbl.DEFINE_FUNCTION);
        this.zza.add(zzbl.FN);
        this.zza.add(zzbl.IF);
        this.zza.add(zzbl.QUOTE);
        this.zza.add(zzbl.RETURN);
        this.zza.add(zzbl.SWITCH);
        this.zza.add(zzbl.TERNARY);
    }

    private static zzap zzc(zzg zzgVar, List list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
        if (!(zzb2 instanceof zzae)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", zzb2.getClass().getCanonicalName()));
        }
        List zzm = ((zzae) zzb2).zzm();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new zzao(zzb.zzi(), zzm, arrayList, zzgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzap zzc;
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 2) {
            zzh.zzh(zzbl.APPLY.name(), 3, list);
            zzap zzb = zzgVar.zzb((zzap) list.get(0));
            String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
            zzap zzb2 = zzgVar.zzb((zzap) list.get(2));
            if (!(zzb2 instanceof zzae)) {
                throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", zzb2.getClass().getCanonicalName()));
            }
            if (zzi.isEmpty()) {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
            return zzb.zzcz(zzi, zzgVar, ((zzae) zzb2).zzm());
        }
        if (ordinal == 15) {
            zzh.zzh(zzbl.BREAK.name(), 0, list);
            return zzap.zzh;
        }
        if (ordinal == 25) {
            return zzc(zzgVar, list);
        }
        if (ordinal != 41) {
            if (ordinal == 54) {
                return new zzae(list);
            }
            if (ordinal != 57) {
                if (ordinal != 19) {
                    if (ordinal == 20) {
                        zzh.zzi(zzbl.DEFINE_FUNCTION.name(), 2, list);
                        zzao zzaoVar = (zzao) zzc(zzgVar, list);
                        if (zzaoVar.zzc() == null) {
                            zzgVar.zzg("", zzaoVar);
                            return zzaoVar;
                        }
                        zzgVar.zzg(zzaoVar.zzc(), zzaoVar);
                        return zzaoVar;
                    }
                    if (ordinal == 60) {
                        zzh.zzh(zzbl.SWITCH.name(), 3, list);
                        zzap zzb3 = zzgVar.zzb((zzap) list.get(0));
                        zzap zzb4 = zzgVar.zzb((zzap) list.get(1));
                        zzap zzb5 = zzgVar.zzb((zzap) list.get(2));
                        if (zzb4 instanceof zzae) {
                            if (!(zzb5 instanceof zzae)) {
                                throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                            }
                            zzae zzaeVar = (zzae) zzb4;
                            zzae zzaeVar2 = (zzae) zzb5;
                            int i = 0;
                            boolean z = false;
                            while (true) {
                                if (i < zzaeVar.zzc()) {
                                    if (z || zzb3.equals(zzgVar.zzb(zzaeVar.zze(i)))) {
                                        zzap zzb6 = zzgVar.zzb(zzaeVar2.zze(i));
                                        if (!(zzb6 instanceof zzag)) {
                                            z = true;
                                        } else if (!((zzag) zzb6).zzc().equals("break")) {
                                            return zzb6;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    i++;
                                } else if (zzaeVar.zzc() + 1 == zzaeVar2.zzc()) {
                                    zzap zzb7 = zzgVar.zzb(zzaeVar2.zze(zzaeVar.zzc()));
                                    if (zzb7 instanceof zzag) {
                                        String zzc2 = ((zzag) zzb7).zzc();
                                        if (zzc2.equals("return") || zzc2.equals("continue")) {
                                            return zzb7;
                                        }
                                    }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                        }
                    } else if (ordinal != 61) {
                        switch (ordinal) {
                            case 11:
                                return zzgVar.zza().zzc(new zzae(list));
                            case 12:
                                zzh.zzh(zzbl.BREAK.name(), 0, list);
                                return zzap.zzi;
                            case 13:
                                break;
                            default:
                                return super.zzb(str);
                        }
                    } else {
                        zzh.zzh(zzbl.TERNARY.name(), 3, list);
                        if (zzgVar.zzb((zzap) list.get(0)).zzg().booleanValue()) {
                            return zzgVar.zzb((zzap) list.get(1));
                        }
                        return zzgVar.zzb((zzap) list.get(2));
                    }
                }
                if (list.isEmpty()) {
                    return zzap.zzf;
                }
                zzap zzb8 = zzgVar.zzb((zzap) list.get(0));
                if (zzb8 instanceof zzae) {
                    return zzgVar.zzc((zzae) zzb8);
                }
                return zzap.zzf;
            }
            if (list.isEmpty()) {
                return zzap.zzj;
            }
            zzh.zzh(zzbl.RETURN.name(), 1, list);
            return new zzag("return", zzgVar.zzb((zzap) list.get(0)));
        }
        zzh.zzi(zzbl.IF.name(), 2, list);
        zzap zzb9 = zzgVar.zzb((zzap) list.get(0));
        zzap zzb10 = zzgVar.zzb((zzap) list.get(1));
        zzap zzb11 = list.size() > 2 ? zzgVar.zzb((zzap) list.get(2)) : null;
        zzap zzapVar = zzap.zzf;
        if (zzb9.zzg().booleanValue()) {
            zzc = zzgVar.zzc((zzae) zzb10);
        } else {
            zzc = zzb11 != null ? zzgVar.zzc((zzae) zzb11) : zzapVar;
        }
        if (zzc instanceof zzag) {
            return zzc;
        }
        return zzap.zzf;
    }
}
