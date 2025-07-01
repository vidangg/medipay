package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.messaging.ServiceStarter;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzam extends zzjq {
    private Boolean zza;
    private String zzb;
    private zzal zzc;
    private Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(zzio zzioVar) {
        super(zzioVar);
        this.zzc = new zzal() { // from class: com.google.android.gms.measurement.internal.zzak
            @Override // com.google.android.gms.measurement.internal.zzal
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    public static final long zzF() {
        return ((Long) zzgi.zzd.zza(null)).longValue();
    }

    public static final int zzG() {
        return Math.max(0, ((Integer) zzgi.zzi.zza(null)).intValue());
    }

    public static final long zzH() {
        return ((Integer) zzgi.zzk.zza(null)).intValue();
    }

    public static final long zzI() {
        return ((Long) zzgi.zzQ.zza(null)).longValue();
    }

    public static final long zzJ() {
        return ((Long) zzgi.zzL.zza(null)).longValue();
    }

    private final String zzK(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzu.zzaW().zze().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            this.zzu.zzaW().zze().zzb("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            this.zzu.zzaW().zze().zzb("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzu.zzaW().zze().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public final boolean zzA() {
        this.zzu.zzaV();
        Boolean zzn = zzn("firebase_analytics_collection_deactivated");
        return zzn != null && zzn.booleanValue();
    }

    public final boolean zzB(String str) {
        return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzC() {
        if (this.zza == null) {
            Boolean zzn = zzn("app_measurement_lite");
            this.zza = zzn;
            if (zzn == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzu.zzN();
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzD() {
        if (this.zzd == null) {
            synchronized (this) {
                if (this.zzd == null) {
                    zzio zzioVar = this.zzu;
                    ApplicationInfo applicationInfo = zzioVar.zzaT().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(myProcessName)) {
                            z = true;
                        }
                        this.zzd = Boolean.valueOf(z);
                    }
                    if (this.zzd == null) {
                        this.zzd = Boolean.TRUE;
                        zzioVar.zzaW().zze().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzd.booleanValue();
    }

    public final boolean zzE() {
        Boolean zzn = zzn("google_analytics_sgtm_upload_enabled");
        if (zzn == null) {
            return false;
        }
        return zzn.booleanValue();
    }

    public final double zza(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) zzggVar.zza(null)).doubleValue();
        }
        String zza = this.zzc.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzggVar.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzggVar.zza(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzggVar.zza(null)).doubleValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(String str) {
        return zzi(str, zzgi.zzV, ServiceStarter.ERROR_UNKNOWN, 2000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzc(String str, boolean z) {
        return z ? zzi(str, zzgi.zzag, 100, ServiceStarter.ERROR_UNKNOWN) : ServiceStarter.ERROR_UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzd(String str, boolean z) {
        return Math.max(zzc(str, z), 256);
    }

    public final int zze() {
        return this.zzu.zzw().zzao(201500000, true) ? 100 : 25;
    }

    public final int zzf(String str) {
        return zzi(str, zzgi.zzW, 25, 100);
    }

    public final int zzh(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) zzggVar.zza(null)).intValue();
        }
        String zza = this.zzc.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzggVar.zza(null)).intValue();
        }
        try {
            return ((Integer) zzggVar.zza(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzggVar.zza(null)).intValue();
        }
    }

    public final int zzi(String str, zzgg zzggVar, int i, int i2) {
        return Math.max(Math.min(zzh(str, zzggVar), i2), i);
    }

    public final long zzj() {
        this.zzu.zzaV();
        return 119002L;
    }

    public final long zzk(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) zzggVar.zza(null)).longValue();
        }
        String zza = this.zzc.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzggVar.zza(null)).longValue();
        }
        try {
            return ((Long) zzggVar.zza(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzggVar.zza(null)).longValue();
        }
    }

    final Bundle zzl() {
        try {
            zzio zzioVar = this.zzu;
            if (zzioVar.zzaT().getPackageManager() != null) {
                ApplicationInfo applicationInfo = Wrappers.packageManager(zzioVar.zzaT()).getApplicationInfo(zzioVar.zzaT().getPackageName(), 128);
                if (applicationInfo == null) {
                    zzioVar.zzaW().zze().zza("Failed to load metadata: ApplicationInfo is null");
                    return null;
                }
                return applicationInfo.metaData;
            }
            zzioVar.zzaW().zze().zza("Failed to load metadata: PackageManager is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaW().zze().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final zzju zzm(String str, boolean z) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        Bundle zzl = zzl();
        if (zzl == null) {
            zzioVar.zzaW().zze().zza("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = zzl.get(str);
        }
        if (obj == null) {
            return zzju.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzju.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzju.DENIED;
        }
        if (!z || !"eu_consent_policy".equals(obj)) {
            zzioVar.zzaW().zzk().zzb("Invalid manifest metadata for", str);
            return zzju.UNINITIALIZED;
        }
        return zzju.POLICY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzn(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzl = zzl();
        if (zzl == null) {
            this.zzu.zzaW().zze().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (zzl.containsKey(str)) {
            return Boolean.valueOf(zzl.getBoolean(str));
        }
        return null;
    }

    public final String zzo() {
        return zzK("debug.firebase.analytics.app", "");
    }

    public final String zzp() {
        return zzK("debug.deferred.deeplink", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzq() {
        this.zzu.zzaV();
        return "FA";
    }

    public final String zzr(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return (String) zzggVar.zza(null);
        }
        return (String) zzggVar.zza(this.zzc.zza(str, zzggVar.zzb()));
    }

    public final String zzs() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzt(String str) {
        Integer valueOf;
        Preconditions.checkNotEmpty("analytics.safelisted_events");
        Bundle zzl = zzl();
        if (zzl == null) {
            this.zzu.zzaW().zze().zza("Failed to load metadata: Metadata bundle is null");
        } else if (zzl.containsKey("analytics.safelisted_events")) {
            valueOf = Integer.valueOf(zzl.getInt("analytics.safelisted_events"));
            if (valueOf != null) {
                try {
                    String[] stringArray = this.zzu.zzaT().getResources().getStringArray(valueOf.intValue());
                    if (stringArray == null) {
                        return null;
                    }
                    return Arrays.asList(stringArray);
                } catch (Resources.NotFoundException e) {
                    this.zzu.zzaW().zze().zzb("Failed to load string array from metadata: resource not found", e);
                }
            }
            return null;
        }
        valueOf = null;
        if (valueOf != null) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(zzal zzalVar) {
        this.zzc = zzalVar;
    }

    public final void zzv(String str) {
        this.zzb = str;
    }

    public final boolean zzw() {
        Boolean zzn = zzn("google_analytics_adid_collection_enabled");
        return zzn == null || zzn.booleanValue();
    }

    public final boolean zzx(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) zzggVar.zza(null)).booleanValue();
        }
        String zza = this.zzc.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzggVar.zza(null)).booleanValue();
        }
        return ((Boolean) zzggVar.zza(Boolean.valueOf(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zza)))).booleanValue();
    }

    public final boolean zzy(String str) {
        return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzz() {
        Boolean zzn = zzn("google_analytics_automatic_screen_reporting_enabled");
        return zzn == null || zzn.booleanValue();
    }
}
