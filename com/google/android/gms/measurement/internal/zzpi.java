package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpi extends zzoz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpi(zzpv zzpvVar) {
        super(zzpvVar);
    }

    private final String zzf(String str) {
        String zzm = this.zzg.zzr().zzm(str);
        if (!TextUtils.isEmpty(zzm)) {
            Uri parse = Uri.parse((String) zzgi.zzq.zza(null));
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.authority(zzm + "." + parse.getAuthority());
            return buildUpon.build().toString();
        }
        return (String) zzgi.zzq.zza(null);
    }

    private final boolean zzh(String str, String str2) {
        zzh zzl;
        zzpv zzpvVar = this.zzg;
        com.google.android.gms.internal.measurement.zzgo zzj = zzpvVar.zzr().zzj(str);
        if (zzj == null || (zzl = zzpvVar.zzj().zzl(str)) == null) {
            return false;
        }
        if ((zzj.zzv() && zzj.zzi().zza() == 100) || this.zzu.zzw().zzak(str, zzl.zzM())) {
            return true;
        }
        return !TextUtils.isEmpty(str2) && Math.abs(str2.hashCode() % 100) < zzj.zzi().zza();
    }

    private static final boolean zzi(String str) {
        String str2 = (String) zzgi.zzs.zza(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0243 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzph zza(String str) {
        zzph zzphVar;
        zzio zzioVar = this.zzu;
        zzam zzf = zzioVar.zzf();
        zzgg zzggVar = zzgi.zzaP;
        zzph zzphVar2 = null;
        if (zzf.zzx(null, zzggVar)) {
            zzpv zzpvVar = this.zzg;
            zzh zzl = zzpvVar.zzj().zzl(str);
            if (zzl == null || !zzl.zzaL()) {
                return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
            }
            com.google.android.gms.internal.measurement.zzif zza = com.google.android.gms.internal.measurement.zzim.zza();
            zza.zzc(2);
            zza.zza((com.google.android.gms.internal.measurement.zzih) Preconditions.checkNotNull(com.google.android.gms.internal.measurement.zzih.zzb(zzl.zzb())));
            if (zzh(str, zzl.zzD())) {
                String zzC = zzl.zzC();
                zza.zzc(2);
                com.google.android.gms.internal.measurement.zzgo zzj = zzpvVar.zzr().zzj(zzl.zzC());
                if (zzj == null || !zzj.zzv()) {
                    zzioVar.zzaW().zzj().zzb("[sgtm] Missing sgtm_setting in remote config. appId", zzC);
                    zza.zzb(4);
                } else {
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(zzl.zzM())) {
                        hashMap.put("x-gtm-server-preview", zzl.zzM());
                    }
                    String zze = zzj.zzi().zze();
                    com.google.android.gms.internal.measurement.zzih zzb = com.google.android.gms.internal.measurement.zzih.zzb(zzl.zzb());
                    if (zzb == null || zzb == com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE) {
                        if (!zzioVar.zzf().zzx(null, zzggVar)) {
                            zza.zza(com.google.android.gms.internal.measurement.zzih.SERVICE_FLAG_OFF);
                        } else if (zzi(zzl.zzC())) {
                            zza.zza(com.google.android.gms.internal.measurement.zzih.PINNED_TO_SERVICE_UPLOAD);
                        } else if (!TextUtils.isEmpty(zze)) {
                            zzioVar.zzaW().zzj().zzb("[sgtm] Eligible for client side upload. appId", zzC);
                            zza.zzc(3);
                            zza.zza(com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE);
                            zzphVar2 = new zzph(zze, hashMap, zzmf.SGTM_CLIENT, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
                        } else {
                            zza.zza(com.google.android.gms.internal.measurement.zzih.MISSING_SGTM_SERVER_URL);
                        }
                    } else {
                        zza.zza(zzb);
                    }
                    zzj.zzi().zzf();
                    zzj.zzi().zzd();
                    zzioVar.zzaV();
                    if (!TextUtils.isEmpty(zze)) {
                        zzioVar.zzaW().zzj().zzb("[sgtm] Eligible for local service direct upload. appId", zzC);
                        zza.zzc(5);
                        zza.zzb(2);
                        zzphVar2 = new zzph(zze, hashMap, zzmf.SGTM, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
                    } else {
                        zza.zzb(6);
                        zzioVar.zzaW().zzj().zzb("[sgtm] Local service, missing sgtm_server_url", zzl.zzC());
                    }
                }
                return zzphVar2 != null ? zzphVar2 : new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
            }
            zza.zzb(3);
            return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzim) zza.zzba());
        }
        zzpv zzpvVar2 = this.zzg;
        zzh zzl2 = zzpvVar2.zzj().zzl(str);
        if (zzl2 == null) {
            return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
        }
        if (zzh(str, zzl2.zzD())) {
            if (zzl2.zzaL()) {
                zzioVar.zzaW().zzj().zza("sgtm upload enabled in manifest.");
                com.google.android.gms.internal.measurement.zzgo zzj2 = zzpvVar2.zzr().zzj(zzl2.zzC());
                if (zzj2 != null && zzj2.zzv()) {
                    String zzf2 = zzj2.zzi().zzf();
                    if (!TextUtils.isEmpty(zzf2)) {
                        String zzd = zzj2.zzi().zzd();
                        zzioVar.zzaW().zzj().zzc("sgtm configured with upload_url, server_info", zzf2, true != TextUtils.isEmpty(zzd) ? "N" : "Y");
                        if (TextUtils.isEmpty(zzd)) {
                            zzioVar.zzaV();
                            zzphVar = new zzph(zzf2, Collections.emptyMap(), zzmf.SGTM, null);
                        } else {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("x-sgtm-server-info", zzd);
                            if (!TextUtils.isEmpty(zzl2.zzM())) {
                                hashMap2.put("x-gtm-server-preview", zzl2.zzM());
                            }
                            zzphVar = new zzph(zzf2, hashMap2, zzmf.SGTM, null);
                        }
                        if (zzphVar == null) {
                            return zzphVar;
                        }
                        return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
                    }
                }
            }
            zzphVar = null;
            if (zzphVar == null) {
            }
        } else {
            return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(String str, com.google.android.gms.internal.measurement.zzih zzihVar) {
        com.google.android.gms.internal.measurement.zzgo zzj;
        zzg();
        return this.zzu.zzf().zzx(null, zzgi.zzaP) && zzihVar == com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE && !zzi(str) && (zzj = this.zzg.zzr().zzj(str)) != null && zzj.zzv() && !zzj.zzi().zze().isEmpty();
    }
}
