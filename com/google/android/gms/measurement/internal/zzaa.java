package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzaa extends zzab {
    final /* synthetic */ zzae zza;
    private final com.google.android.gms.internal.measurement.zzfj zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(zzae zzaeVar, String str, int i, com.google.android.gms.internal.measurement.zzfj zzfjVar) {
        super(str, i);
        this.zza = zzaeVar;
        this.zzh = zzfjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return this.zzh.zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x036c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0364  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzhm zzhmVar, long j, zzbd zzbdVar, boolean z) {
        Boolean zzi;
        com.google.android.gms.internal.measurement.zzpq.zzb();
        zzae zzaeVar = this.zza;
        zzio zzioVar = zzaeVar.zzu;
        zzam zzf = zzioVar.zzf();
        String str = this.zzb;
        boolean zzx = zzf.zzx(str, zzgi.zzaE);
        com.google.android.gms.internal.measurement.zzfj zzfjVar = this.zzh;
        long j2 = zzfjVar.zzn() ? zzbdVar.zze : j;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        Boolean bool = null;
        if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
            zzioVar.zzaW().zzj().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzc), zzfjVar.zzp() ? Integer.valueOf(zzfjVar.zzb()) : null, zzioVar.zzj().zzd(zzfjVar.zzg()));
            zzioVar.zzaW().zzj().zzb("Filter definition", zzaeVar.zzg.zzA().zzr(zzfjVar));
        }
        if (!zzfjVar.zzp() || zzfjVar.zzb() > 256) {
            zzioVar.zzaW().zzk().zzc("Invalid event filter ID. appId, id", zzhe.zzn(str), String.valueOf(zzfjVar.zzp() ? Integer.valueOf(zzfjVar.zzb()) : null));
            return false;
        }
        Object[] objArr = zzfjVar.zzk() || zzfjVar.zzm() || zzfjVar.zzn();
        if (!z || objArr != false) {
            String zzh = zzhmVar.zzh();
            if (zzfjVar.zzo()) {
                Boolean zzh2 = zzh(j2, zzfjVar.zzf());
                if (zzh2 != null) {
                    if (!zzh2.booleanValue()) {
                        bool = false;
                    }
                }
                zzioVar.zzaW().zzj().zzb("Event filter result", bool != null ? "null" : bool);
                if (bool != null) {
                    return false;
                }
                this.zzd = true;
                if (!bool.booleanValue()) {
                    return true;
                }
                this.zze = true;
                if (objArr != false && zzhmVar.zzu()) {
                    Long valueOf = Long.valueOf(zzhmVar.zzd());
                    if (zzfjVar.zzm()) {
                        if (zzx && zzfjVar.zzo()) {
                            valueOf = l;
                        }
                        this.zzg = valueOf;
                    } else {
                        if (zzx && zzfjVar.zzo()) {
                            valueOf = l2;
                        }
                        this.zzf = valueOf;
                    }
                }
                return true;
            }
            HashSet hashSet = new HashSet();
            Iterator it = zzfjVar.zzh().iterator();
            while (true) {
                if (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzfl zzflVar = (com.google.android.gms.internal.measurement.zzfl) it.next();
                    if (!zzflVar.zze().isEmpty()) {
                        hashSet.add(zzflVar.zze());
                    } else {
                        zzioVar.zzaW().zzk().zzb("null or empty param name in filter. event", zzioVar.zzj().zzd(zzh));
                        break;
                    }
                } else {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator it2 = zzhmVar.zzi().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it2.next();
                            if (hashSet.contains(zzhqVar.zzg())) {
                                if (zzhqVar.zzw()) {
                                    arrayMap.put(zzhqVar.zzg(), zzhqVar.zzw() ? Long.valueOf(zzhqVar.zzd()) : null);
                                } else if (zzhqVar.zzu()) {
                                    arrayMap.put(zzhqVar.zzg(), zzhqVar.zzu() ? Double.valueOf(zzhqVar.zza()) : null);
                                } else if (zzhqVar.zzy()) {
                                    arrayMap.put(zzhqVar.zzg(), zzhqVar.zzh());
                                } else {
                                    zzioVar.zzaW().zzk().zzc("Unknown value for param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zzhqVar.zzg()));
                                    break;
                                }
                            }
                        } else {
                            Iterator it3 = zzfjVar.zzh().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzfl zzflVar2 = (com.google.android.gms.internal.measurement.zzfl) it3.next();
                                    boolean z2 = zzflVar2.zzh() && zzflVar2.zzg();
                                    String zze = zzflVar2.zze();
                                    if (!zze.isEmpty()) {
                                        V v = arrayMap.get(zze);
                                        if (v instanceof Long) {
                                            if (zzflVar2.zzi()) {
                                                Boolean zzh3 = zzh(((Long) v).longValue(), zzflVar2.zzc());
                                                if (zzh3 == null) {
                                                    break;
                                                }
                                                if (zzh3.booleanValue() == z2) {
                                                    bool = false;
                                                    break;
                                                }
                                            } else {
                                                zzioVar.zzaW().zzk().zzc("No number filter for long param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                                break;
                                            }
                                        } else if (v instanceof Double) {
                                            if (zzflVar2.zzi()) {
                                                Boolean zzg = zzg(((Double) v).doubleValue(), zzflVar2.zzc());
                                                if (zzg == null) {
                                                    break;
                                                }
                                                if (zzg.booleanValue() == z2) {
                                                    bool = false;
                                                    break;
                                                }
                                            } else {
                                                zzioVar.zzaW().zzk().zzc("No number filter for double param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                                break;
                                            }
                                        } else if (v instanceof String) {
                                            if (zzflVar2.zzk()) {
                                                zzi = zzf((String) v, zzflVar2.zzd(), zzioVar.zzaW());
                                            } else if (zzflVar2.zzi()) {
                                                String str2 = (String) v;
                                                if (zzqa.zzA(str2)) {
                                                    zzi = zzi(str2, zzflVar2.zzc());
                                                } else {
                                                    zzioVar.zzaW().zzk().zzc("Invalid param value for number filter. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                                    break;
                                                }
                                            } else {
                                                zzioVar.zzaW().zzk().zzc("No filter for String param. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                                break;
                                            }
                                            if (zzi == null) {
                                                break;
                                            }
                                            if (zzi.booleanValue() == z2) {
                                                bool = false;
                                                break;
                                            }
                                        } else if (v == 0) {
                                            zzioVar.zzaW().zzj().zzc("Missing param for filter. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                            bool = false;
                                        } else {
                                            zzioVar.zzaW().zzk().zzc("Unknown param type. event, param", zzioVar.zzj().zzd(zzh), zzioVar.zzj().zze(zze));
                                        }
                                    } else {
                                        zzioVar.zzaW().zzk().zzb("Event has empty param name. event", zzioVar.zzj().zzd(zzh));
                                        break;
                                    }
                                } else {
                                    bool = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            zzioVar.zzaW().zzj().zzb("Event filter result", bool != null ? "null" : bool);
            if (bool != null) {
            }
        } else {
            zzioVar.zzaW().zzj().zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), zzfjVar.zzp() ? Integer.valueOf(zzfjVar.zzb()) : null);
            return true;
        }
    }
}
