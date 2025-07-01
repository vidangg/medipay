package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzif extends zzpg implements zzal {
    final Map zza;
    final Map zzb;
    final Map zzc;
    final LruCache zzd;
    final com.google.android.gms.internal.measurement.zzr zze;
    private final Map zzf;
    private final Map zzh;
    private final Map zzi;
    private final Map zzj;
    private final Map zzk;
    private final Map zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzif(zzpv zzpvVar) {
        super(zzpvVar);
        this.zzf = new ArrayMap();
        this.zza = new ArrayMap();
        this.zzb = new ArrayMap();
        this.zzc = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzd = new zzic(this, 20);
        this.zze = new zzid(this);
    }

    private final com.google.android.gms.internal.measurement.zzgo zzG(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzgo.zzh();
        }
        try {
            com.google.android.gms.internal.measurement.zzgo zzgoVar = (com.google.android.gms.internal.measurement.zzgo) ((com.google.android.gms.internal.measurement.zzgn) zzqa.zzp(com.google.android.gms.internal.measurement.zzgo.zzf(), bArr)).zzba();
            this.zzu.zzaW().zzj().zzc("Parsed config. version, gmp_app_id", zzgoVar.zzw() ? Long.valueOf(zzgoVar.zzc()) : null, zzgoVar.zzu() ? zzgoVar.zzj() : null);
            return zzgoVar;
        } catch (com.google.android.gms.internal.measurement.zzmm e) {
            this.zzu.zzaW().zzk().zzc("Unable to merge remote config. appId", zzhe.zzn(str), e);
            return com.google.android.gms.internal.measurement.zzgo.zzh();
        } catch (RuntimeException e2) {
            this.zzu.zzaW().zzk().zzc("Unable to merge remote config. appId", zzhe.zzn(str), e2);
            return com.google.android.gms.internal.measurement.zzgo.zzh();
        }
    }

    private final void zzH(String str, com.google.android.gms.internal.measurement.zzgn zzgnVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = zzgnVar.zzh().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzgk) it.next()).zzb());
        }
        for (int i = 0; i < zzgnVar.zza(); i++) {
            com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) zzgnVar.zzb(i).zzch();
            if (zzglVar.zzc().isEmpty()) {
                this.zzu.zzaW().zzk().zza("EventConfig contained null event name");
            } else {
                String zzc = zzglVar.zzc();
                String zzb = zzjy.zzb(zzglVar.zzc());
                if (!TextUtils.isEmpty(zzb)) {
                    zzglVar.zzb(zzb);
                    zzgnVar.zze(i, zzglVar);
                }
                if (zzglVar.zzf() && zzglVar.zzd()) {
                    arrayMap.put(zzc, true);
                }
                if (zzglVar.zzg() && zzglVar.zze()) {
                    arrayMap2.put(zzglVar.zzc(), true);
                }
                if (zzglVar.zzh()) {
                    if (zzglVar.zza() < 2 || zzglVar.zza() > 65535) {
                        this.zzu.zzaW().zzk().zzc("Invalid sampling rate. Event name, sample rate", zzglVar.zzc(), Integer.valueOf(zzglVar.zza()));
                    } else {
                        arrayMap3.put(zzglVar.zzc(), Integer.valueOf(zzglVar.zza()));
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    private final void zzI(String str) {
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzh;
        if (map.get(str) == null) {
            zzar zzn = this.zzg.zzj().zzn(str);
            if (zzn == null) {
                this.zzf.put(str, null);
                this.zzb.put(str, null);
                this.zza.put(str, null);
                this.zzc.put(str, null);
                map.put(str, null);
                this.zzj.put(str, null);
                this.zzk.put(str, null);
                this.zzl.put(str, null);
                this.zzi.put(str, null);
                return;
            }
            com.google.android.gms.internal.measurement.zzgn zzgnVar = (com.google.android.gms.internal.measurement.zzgn) zzG(str, zzn.zza).zzch();
            zzH(str, zzgnVar);
            this.zzf.put(str, zzK((com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba()));
            map.put(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
            zzJ(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
            this.zzj.put(str, zzgnVar.zzf());
            this.zzk.put(str, zzn.zzb);
            this.zzl.put(str, zzn.zzc);
        }
    }

    private final void zzJ(final String str, com.google.android.gms.internal.measurement.zzgo zzgoVar) {
        if (zzgoVar.zza() != 0) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzj().zzb("EES programs found", Integer.valueOf(zzgoVar.zza()));
            com.google.android.gms.internal.measurement.zziv zzivVar = (com.google.android.gms.internal.measurement.zziv) zzgoVar.zzo().get(0);
            try {
                com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
                zzcVar.zzd("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhy
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new com.google.android.gms.internal.measurement.zzn("internal.remoteConfig", new zzie(zzif.this, str));
                    }
                });
                zzcVar.zzd("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhz
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        final zzif zzifVar = zzif.this;
                        final String str2 = str;
                        return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzib
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                zzif zzifVar2 = zzif.this;
                                zzaw zzj = zzifVar2.zzg.zzj();
                                String str3 = str2;
                                zzh zzl = zzj.zzl(str3);
                                HashMap hashMap = new HashMap();
                                hashMap.put("platform", "android");
                                hashMap.put("package_name", str3);
                                zzifVar2.zzu.zzf().zzj();
                                hashMap.put("gmp_version", 119002L);
                                if (zzl != null) {
                                    String zzF = zzl.zzF();
                                    if (zzF != null) {
                                        hashMap.put("app_version", zzF);
                                    }
                                    hashMap.put("app_version_int", Long.valueOf(zzl.zze()));
                                    hashMap.put("dynamite_version", Long.valueOf(zzl.zzo()));
                                }
                                return hashMap;
                            }
                        });
                    }
                });
                zzcVar.zzd("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzia
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new com.google.android.gms.internal.measurement.zzt(zzif.this.zze);
                    }
                });
                zzcVar.zzc(zzivVar);
                this.zzd.put(str, zzcVar);
                zzioVar.zzaW().zzj().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzivVar.zza().zza()));
                Iterator it = zzivVar.zza().zzd().iterator();
                while (it.hasNext()) {
                    zzioVar.zzaW().zzj().zzb("EES program activity", ((com.google.android.gms.internal.measurement.zzit) it.next()).zzb());
                }
                return;
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                this.zzu.zzaW().zze().zzb("Failed to load EES program. appId", str);
                return;
            }
        }
        this.zzd.remove(str);
    }

    private static final Map zzK(com.google.android.gms.internal.measurement.zzgo zzgoVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzgoVar != null) {
            for (com.google.android.gms.internal.measurement.zzgw zzgwVar : zzgoVar.zzp()) {
                arrayMap.put(zzgwVar.zzb(), zzgwVar.zzc());
            }
        }
        return arrayMap;
    }

    private static final zzjw zzL(int i) {
        int i2 = i - 1;
        if (i2 == 1) {
            return zzjw.AD_STORAGE;
        }
        if (i2 == 2) {
            return zzjw.ANALYTICS_STORAGE;
        }
        if (i2 == 3) {
            return zzjw.AD_USER_DATA;
        }
        if (i2 != 4) {
            return null;
        }
        return zzjw.AD_PERSONALIZATION;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ com.google.android.gms.internal.measurement.zzc zzd(zzif zzifVar, String str) {
        zzifVar.zzav();
        Preconditions.checkNotEmpty(str);
        if (!zzifVar.zzs(str)) {
            return null;
        }
        Map map = zzifVar.zzh;
        if (!map.containsKey(str) || map.get(str) == null) {
            zzifVar.zzI(str);
        } else {
            zzifVar.zzJ(str, (com.google.android.gms.internal.measurement.zzgo) map.get(str));
        }
        return (com.google.android.gms.internal.measurement.zzc) zzifVar.zzd.snapshot().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ com.google.android.gms.internal.measurement.zzc zze(zzif zzifVar, String str) {
        zzifVar.zzav();
        Preconditions.checkNotEmpty(str);
        zzar zzn = zzifVar.zzg.zzj().zzn(str);
        if (zzn == null) {
            return null;
        }
        zzifVar.zzu.zzaW().zzj().zzb("Populate EES config from database on cache miss. appId", str);
        zzifVar.zzJ(str, zzifVar.zzG(str, zzn.zza));
        return (com.google.android.gms.internal.measurement.zzc) zzifVar.zzd.snapshot().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzA(String str) {
        zzg();
        zzI(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("app_instance_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzB(String str) {
        zzg();
        zzI(str);
        Map map = this.zza;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("device_model") || ((Set) map.get(str)).contains("device_info");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzC(String str) {
        zzg();
        zzI(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("enhanced_user_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzD(String str) {
        zzg();
        zzI(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("google_signals");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzE(String str) {
        zzg();
        zzI(str);
        Map map = this.zza;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("os_version") || ((Set) map.get(str)).contains("device_info");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzF(String str) {
        zzg();
        zzI(str);
        Map map = this.zza;
        return map.get(str) != null && ((Set) map.get(str)).contains("user_id");
    }

    @Override // com.google.android.gms.measurement.internal.zzal
    public final String zza(String str, String str2) {
        zzg();
        zzI(str);
        Map map = (Map) this.zzf.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzc(String str, String str2) {
        Integer num;
        zzg();
        zzI(str);
        Map map = (Map) this.zzi.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzju zzf(String str, zzjw zzjwVar) {
        zzg();
        zzI(str);
        com.google.android.gms.internal.measurement.zzgi zzi = zzi(str);
        if (zzi == null) {
            return zzju.UNINITIALIZED;
        }
        for (com.google.android.gms.internal.measurement.zzfz zzfzVar : zzi.zzf()) {
            if (zzL(zzfzVar.zzc()) == zzjwVar) {
                int zzb = zzfzVar.zzb() - 1;
                if (zzb == 1) {
                    return zzju.GRANTED;
                }
                if (zzb == 2) {
                    return zzju.DENIED;
                }
                return zzju.UNINITIALIZED;
            }
        }
        return zzju.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjw zzh(String str, zzjw zzjwVar) {
        zzg();
        zzI(str);
        com.google.android.gms.internal.measurement.zzgi zzi = zzi(str);
        if (zzi == null) {
            return null;
        }
        for (com.google.android.gms.internal.measurement.zzgb zzgbVar : zzi.zze()) {
            if (zzjwVar == zzL(zzgbVar.zzc())) {
                return zzL(zzgbVar.zzb());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzgi zzi(String str) {
        zzg();
        zzI(str);
        com.google.android.gms.internal.measurement.zzgo zzj = zzj(str);
        if (zzj == null || !zzj.zzt()) {
            return null;
        }
        return zzj.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.internal.measurement.zzgo zzj(String str) {
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzI(str);
        return (com.google.android.gms.internal.measurement.zzgo) this.zzh.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzk(String str) {
        zzg();
        return (String) this.zzl.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzl(String str) {
        zzg();
        return (String) this.zzk.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzm(String str) {
        zzg();
        zzI(str);
        return (String) this.zzj.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set zzo(String str) {
        zzg();
        zzI(str);
        return (Set) this.zza.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SortedSet zzp(String str) {
        zzg();
        zzI(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.zzgi zzi = zzi(str);
        if (zzi != null) {
            Iterator it = zzi.zzc().iterator();
            while (it.hasNext()) {
                treeSet.add(((com.google.android.gms.internal.measurement.zzgh) it.next()).zzb());
            }
        }
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzq(String str) {
        zzg();
        this.zzk.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzr(String str) {
        zzg();
        this.zzh.remove(str);
    }

    public final boolean zzs(String str) {
        com.google.android.gms.internal.measurement.zzgo zzgoVar;
        return (TextUtils.isEmpty(str) || (zzgoVar = (com.google.android.gms.internal.measurement.zzgo) this.zzh.get(str)) == null || zzgoVar.zza() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(String str) {
        return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzu(String str, zzjw zzjwVar) {
        zzg();
        zzI(str);
        com.google.android.gms.internal.measurement.zzgi zzi = zzi(str);
        if (zzi == null) {
            return false;
        }
        Iterator it = zzi.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.zzfz zzfzVar = (com.google.android.gms.internal.measurement.zzfz) it.next();
            if (zzjwVar == zzL(zzfzVar.zzc())) {
                if (zzfzVar.zzb() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzv(String str) {
        zzg();
        zzI(str);
        com.google.android.gms.internal.measurement.zzgi zzi = zzi(str);
        return zzi == null || !zzi.zzh() || zzi.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzw(String str, String str2) {
        Boolean bool;
        zzg();
        zzI(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzx(String str, String str2) {
        Boolean bool;
        zzg();
        zzI(str);
        if (zzt(str) && zzqf.zzap(str2)) {
            return true;
        }
        if (zzy(str) && zzqf.zzaq(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzy(String str) {
        return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzz(String str, byte[] bArr, String str2, String str3) {
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzgn zzgnVar = (com.google.android.gms.internal.measurement.zzgn) zzG(str, bArr).zzch();
        zzH(str, zzgnVar);
        zzJ(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
        this.zzj.put(str, zzgnVar.zzf());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzf.put(str, zzK((com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba()));
        this.zzg.zzj().zzR(str, new ArrayList(zzgnVar.zzg()));
        try {
            zzgnVar.zzc();
            bArr = ((com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba()).zzcd();
        } catch (RuntimeException e) {
            this.zzu.zzaW().zzk().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzhe.zzn(str), e);
        }
        zzaw zzj = this.zzg.zzj();
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzav();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzj.zzj().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzj.zzu.zzaW().zze().zzb("Failed to update remote config (got 0). appId", zzhe.zzn(str));
            }
        } catch (SQLiteException e2) {
            zzj.zzu.zzaW().zze().zzc("Error storing remote config. appId", zzhe.zzn(str), e2);
        }
        if (this.zzu.zzf().zzx(null, zzgi.zzbn)) {
            zzgnVar.zzd();
        }
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
        return true;
    }
}
