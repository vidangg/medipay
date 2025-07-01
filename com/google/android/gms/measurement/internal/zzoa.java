package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzoa extends zzpg {
    public final zzhp zza;
    public final zzhp zzb;
    public final zzhp zzc;
    public final zzhp zzd;
    public final zzhp zze;
    public final zzhp zzf;
    private final Map zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoa(zzpv zzpvVar) {
        super(zzpvVar);
        this.zzh = new HashMap();
        zzht zzm = this.zzu.zzm();
        Objects.requireNonNull(zzm);
        this.zza = new zzhp(zzm, "last_delete_stale", 0L);
        zzht zzm2 = this.zzu.zzm();
        Objects.requireNonNull(zzm2);
        this.zzb = new zzhp(zzm2, "last_delete_stale_batch", 0L);
        zzht zzm3 = this.zzu.zzm();
        Objects.requireNonNull(zzm3);
        this.zzc = new zzhp(zzm3, "backoff", 0L);
        zzht zzm4 = this.zzu.zzm();
        Objects.requireNonNull(zzm4);
        this.zzd = new zzhp(zzm4, "last_upload", 0L);
        zzht zzm5 = this.zzu.zzm();
        Objects.requireNonNull(zzm5);
        this.zze = new zzhp(zzm5, "last_upload_attempt", 0L);
        zzht zzm6 = this.zzu.zzm();
        Objects.requireNonNull(zzm6);
        this.zzf = new zzhp(zzm6, "midnight_offset", 0L);
    }

    @Deprecated
    final Pair zza(String str) {
        zznz zznzVar;
        AdvertisingIdClient.Info info;
        zzg();
        zzio zzioVar = this.zzu;
        long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
        zznz zznzVar2 = (zznz) this.zzh.get(str);
        if (zznzVar2 == null || elapsedRealtime >= zznzVar2.zzc) {
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            long zzk = zzioVar.zzf().zzk(str, zzgi.zza) + elapsedRealtime;
            try {
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(zzioVar.zzaT());
                } catch (PackageManager.NameNotFoundException unused) {
                    info = null;
                    if (zznzVar2 != null && elapsedRealtime < zznzVar2.zzc + this.zzu.zzf().zzk(str, zzgi.zzb)) {
                        return new Pair(zznzVar2.zza, Boolean.valueOf(zznzVar2.zzb));
                    }
                }
            } catch (Exception e) {
                this.zzu.zzaW().zzd().zzb("Unable to get advertising id", e);
                zznzVar = new zznz("", false, zzk);
            }
            if (info == null) {
                return new Pair("00000000-0000-0000-0000-000000000000", false);
            }
            String id = info.getId();
            if (id != null) {
                zznzVar = new zznz(id, info.isLimitAdTrackingEnabled(), zzk);
            } else {
                zznzVar = new zznz("", info.isLimitAdTrackingEnabled(), zzk);
            }
            this.zzh.put(str, zznzVar);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(zznzVar.zza, Boolean.valueOf(zznzVar.zzb));
        }
        return new Pair(zznzVar2.zza, Boolean.valueOf(zznzVar2.zzb));
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair zzd(String str, zzjx zzjxVar) {
        if (zzjxVar.zzr(zzjw.AD_STORAGE)) {
            return zza(str);
        }
        return new Pair("", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final String zzf(String str, boolean z) {
        String str2;
        zzg();
        if (z) {
            str2 = (String) zza(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest zzI = zzqf.zzI();
        if (zzI == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzI.digest(str2.getBytes())));
    }
}
