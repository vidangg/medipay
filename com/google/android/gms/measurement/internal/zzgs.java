package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzrp;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgs extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private long zzo;
    private String zzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgs(zzio zzioVar, long j, long j2) {
        super(zzioVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(1:3)(6:80|81|(1:83)(2:98|(1:100))|84|85|(21:87|(1:89)(1:96)|90|91|5|(2:7|(15:11|12|(1:(2:15|(2:17|(2:19|(2:21|(2:23|(1:25)(1:72))(1:73))(1:74))(1:75))(1:76))(1:77))(1:78)|26|(1:28)|29|30|(1:32)(1:69)|33|(3:37|(1:39)(1:41)|40)|(3:43|(1:45)(1:48)|46)|49|(3:51|(1:53)(3:60|(3:63|(1:65)(1:66)|61)|67)|(2:55|56)(2:58|59))|68|(0)(0)))|79|12|(0)(0)|26|(0)|29|30|(0)(0)|33|(4:35|37|(0)(0)|40)|(0)|49|(0)|68|(0)(0)))|4|5|(0)|79|12|(0)(0)|26|(0)|29|30|(0)(0)|33|(0)|(0)|49|(0)|68|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01fa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01fb, code lost:
    
        r11.zzu.zzaW().zze().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r1), r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b3 A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:30:0x018f, B:33:0x01a5, B:35:0x01b3, B:37:0x01b9, B:40:0x01d3, B:41:0x01cf, B:43:0x01dd, B:45:0x01f1, B:46:0x01f6, B:48:0x01f4), top: B:29:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01cf A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:30:0x018f, B:33:0x01a5, B:35:0x01b3, B:37:0x01b9, B:40:0x01d3, B:41:0x01cf, B:43:0x01dd, B:45:0x01f1, B:46:0x01f6, B:48:0x01f4), top: B:29:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01dd A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:30:0x018f, B:33:0x01a5, B:35:0x01b3, B:37:0x01b9, B:40:0x01d3, B:41:0x01cf, B:43:0x01dd, B:45:0x01f1, B:46:0x01f6, B:48:0x01f4), top: B:29:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00cf  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzd() {
        String str;
        String str2;
        PackageInfo packageInfo;
        zzio zzioVar;
        Object[] objArr;
        zzio zzioVar2;
        int zza;
        List zzt;
        String zzc;
        String zzA;
        zzio zzioVar3 = this.zzu;
        zzioVar3.zzaW().zzj().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzioVar3.zzaT().getPackageName();
        PackageManager packageManager = zzioVar3.zzaT().getPackageManager();
        int i = Integer.MIN_VALUE;
        String str3 = "";
        String str4 = "Unknown";
        String str5 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (packageManager == null) {
            zzioVar3.zzaW().zze().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzhe.zzn(packageName));
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaW().zze().zzb("Error retrieving app installer package name. appId", zzhe.zzn(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = "";
            }
            try {
                packageInfo = packageManager.getPackageInfo(this.zzu.zzaT().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = "Unknown";
            }
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                str2 = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                try {
                    str4 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = str4;
                    str4 = str2;
                    this.zzu.zzaW().zze().zzc("Error retrieving package info. appId, appName", zzhe.zzn(packageName), str4);
                    str2 = str4;
                    str4 = str;
                    this.zza = packageName;
                    this.zzd = str5;
                    this.zzb = str4;
                    this.zzc = i;
                    this.zze = str2;
                    this.zzf = 0L;
                    zzioVar = this.zzu;
                    if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    }
                    objArr = false;
                    zzioVar2 = this.zzu;
                    zza = zzioVar2.zza();
                    if (zza != 0) {
                    }
                    this.zzl = "";
                    this.zzm = "";
                    zzioVar.zzaV();
                    if (objArr != false) {
                    }
                    zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                    if (TextUtils.isEmpty(zzc)) {
                    }
                    this.zzl = str3;
                    if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    }
                    if (zza == 0) {
                    }
                    this.zzi = null;
                    zzio zzioVar4 = this.zzu;
                    zzioVar4.zzaV();
                    zzt = zzioVar4.zzf().zzt("analytics.safelisted_events");
                    if (zzt != null) {
                    }
                    this.zzi = zzt;
                    if (packageManager != null) {
                    }
                }
                this.zza = packageName;
                this.zzd = str5;
                this.zzb = str4;
                this.zzc = i;
                this.zze = str2;
                this.zzf = 0L;
                zzioVar = this.zzu;
                if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    zzio zzioVar5 = this.zzu;
                    if (!TextUtils.isEmpty(zzioVar5.zzx()) && "am".equals(zzioVar5.zzy())) {
                        objArr = true;
                        zzioVar2 = this.zzu;
                        zza = zzioVar2.zza();
                        if (zza != 0) {
                            zzioVar.zzaW().zzj().zza("App measurement collection enabled");
                        } else if (zza == 1) {
                            zzioVar.zzaW().zzi().zza("App measurement deactivated via the manifest");
                        } else if (zza == 3) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        } else if (zza == 4) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled via the manifest");
                        } else if (zza == 6) {
                            zzioVar.zzaW().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        } else if (zza == 7) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
                        } else if (zza != 8) {
                            zzioVar.zzaW().zzi().zza("App measurement disabled");
                            zzioVar.zzaW().zzh().zza("Invalid scion state in identity");
                        } else {
                            zzioVar.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
                        }
                        this.zzl = "";
                        this.zzm = "";
                        zzioVar.zzaV();
                        if (objArr != false) {
                            this.zzm = zzioVar2.zzx();
                        }
                        zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                        if (TextUtils.isEmpty(zzc)) {
                            str3 = zzc;
                        }
                        this.zzl = str3;
                        if (!zzioVar.zzf().zzx(null, zzgi.zzbp) && !TextUtils.isEmpty(zzc)) {
                            Context zzaT = zzioVar.zzaT();
                            zzA = zzioVar2.zzA();
                            Preconditions.checkNotNull(zzaT);
                            Resources resources = zzaT.getResources();
                            if (!TextUtils.isEmpty(zzA)) {
                                zzA = zzig.zza(zzaT);
                            }
                            this.zzm = zzig.zzb("admob_app_id", resources, zzA);
                        }
                        if (zza == 0) {
                            zzioVar.zzaW().zzj().zzc("App measurement enabled for app package, google app id", this.zza, TextUtils.isEmpty(this.zzl) ? this.zzm : this.zzl);
                        }
                        this.zzi = null;
                        zzio zzioVar42 = this.zzu;
                        zzioVar42.zzaV();
                        zzt = zzioVar42.zzf().zzt("analytics.safelisted_events");
                        if (zzt != null) {
                            if (zzt.isEmpty()) {
                                zzioVar42.zzaW().zzl().zza("Safelisted event list is empty. Ignoring");
                            } else {
                                Iterator it = zzt.iterator();
                                while (it.hasNext()) {
                                    if (!zzioVar42.zzw().zzag("safelisted event", (String) it.next())) {
                                        break;
                                    }
                                }
                            }
                            if (packageManager != null) {
                                this.zzk = InstantApps.isInstantApp(zzioVar42.zzaT()) ? 1 : 0;
                                return;
                            } else {
                                this.zzk = 0;
                                return;
                            }
                        }
                        this.zzi = zzt;
                        if (packageManager != null) {
                        }
                    }
                }
                objArr = false;
                zzioVar2 = this.zzu;
                zza = zzioVar2.zza();
                if (zza != 0) {
                }
                this.zzl = "";
                this.zzm = "";
                zzioVar.zzaV();
                if (objArr != false) {
                }
                zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                if (TextUtils.isEmpty(zzc)) {
                }
                this.zzl = str3;
                if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    Context zzaT2 = zzioVar.zzaT();
                    zzA = zzioVar2.zzA();
                    Preconditions.checkNotNull(zzaT2);
                    Resources resources2 = zzaT2.getResources();
                    if (!TextUtils.isEmpty(zzA)) {
                    }
                    this.zzm = zzig.zzb("admob_app_id", resources2, zzA);
                }
                if (zza == 0) {
                }
                this.zzi = null;
                zzio zzioVar422 = this.zzu;
                zzioVar422.zzaV();
                zzt = zzioVar422.zzf().zzt("analytics.safelisted_events");
                if (zzt != null) {
                }
                this.zzi = zzt;
                if (packageManager != null) {
                }
            }
        }
        str2 = "Unknown";
        this.zza = packageName;
        this.zzd = str5;
        this.zzb = str4;
        this.zzc = i;
        this.zze = str2;
        this.zzf = 0L;
        zzioVar = this.zzu;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
        }
        objArr = false;
        zzioVar2 = this.zzu;
        zza = zzioVar2.zza();
        if (zza != 0) {
        }
        this.zzl = "";
        this.zzm = "";
        zzioVar.zzaV();
        if (objArr != false) {
        }
        zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
        if (TextUtils.isEmpty(zzc)) {
        }
        this.zzl = str3;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
        }
        if (zza == 0) {
        }
        this.zzi = null;
        zzio zzioVar4222 = this.zzu;
        zzioVar4222.zzaV();
        zzt = zzioVar4222.zzf().zzt("analytics.safelisted_events");
        if (zzt != null) {
        }
        this.zzi = zzt;
        if (packageManager != null) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzh() {
        zza();
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzj() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0259 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzr zzk(String str) {
        Class<?> loadClass;
        Object invoke;
        String str2;
        zzio zzioVar;
        String str3;
        boolean z;
        long j;
        int i;
        List list;
        String str4;
        zzio zzioVar2;
        int i2;
        int i3;
        long j2;
        ApplicationInfo applicationInfo;
        long j3;
        zzg();
        String zzm = zzm();
        String zzo = zzo();
        zza();
        String str5 = this.zzb;
        zza();
        long j4 = this.zzc;
        zza();
        Preconditions.checkNotNull(this.zzd);
        String str6 = this.zzd;
        zzio zzioVar3 = this.zzu;
        zzioVar3.zzf().zzj();
        zza();
        zzg();
        long j5 = this.zzf;
        if (j5 == 0) {
            zzqf zzw = this.zzu.zzw();
            Context zzaT = zzioVar3.zzaT();
            String packageName = zzioVar3.zzaT().getPackageName();
            zzw.zzg();
            Preconditions.checkNotNull(zzaT);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = zzaT.getPackageManager();
            MessageDigest zzI = zzqf.zzI();
            if (zzI == null) {
                zzw.zzu.zzaW().zze().zza("Could not get MD5 instance");
                j5 = -1;
            } else {
                if (packageManager != null) {
                    try {
                        if (zzw.zzam(zzaT, packageName)) {
                            j3 = 0;
                        } else {
                            PackageManagerWrapper packageManager2 = Wrappers.packageManager(zzaT);
                            zzio zzioVar4 = zzw.zzu;
                            PackageInfo packageInfo = packageManager2.getPackageInfo(zzioVar4.zzaT().getPackageName(), 64);
                            if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                                zzioVar4.zzaW().zzk().zza("Could not get signatures");
                                j3 = -1;
                            } else {
                                j3 = zzqf.zzr(zzI.digest(packageInfo.signatures[0].toByteArray()));
                            }
                        }
                        j5 = j3;
                    } catch (PackageManager.NameNotFoundException e) {
                        zzw.zzu.zzaW().zze().zzb("Package name not found", e);
                    }
                }
                j5 = 0;
            }
            this.zzf = j5;
        }
        long j6 = j5;
        zzio zzioVar5 = this.zzu;
        zzio zzioVar6 = this.zzu;
        boolean zzJ = zzioVar5.zzJ();
        boolean z2 = !zzioVar6.zzm().zzm;
        zzg();
        if (zzioVar5.zzJ()) {
            zzrp.zzb();
            if (!zzioVar6.zzf().zzx(null, zzgi.zzaG)) {
                try {
                    loadClass = zzioVar6.zzaT().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (loadClass != null) {
                    try {
                        invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzu.zzaT());
                    } catch (Exception unused2) {
                        this.zzu.zzaW().zzm().zza("Failed to obtain Firebase Analytics instance");
                    }
                    if (invoke != null) {
                        try {
                            str2 = (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(invoke, null);
                        } catch (Exception unused3) {
                            this.zzu.zzaW().zzl().zza("Failed to retrieve Firebase Instance Id");
                        }
                        zzio zzioVar7 = this.zzu;
                        long zza = zzioVar7.zzm().zzc.zza();
                        long min = zza != 0 ? zzioVar7.zza : Math.min(zzioVar7.zza, zza);
                        zza();
                        int i4 = this.zzk;
                        zzioVar = this.zzu;
                        boolean zzw2 = zzioVar.zzf().zzw();
                        zzht zzm2 = zzioVar.zzm();
                        zzm2.zzg();
                        boolean z3 = zzm2.zzb().getBoolean("deferred_analytics_collection", false);
                        String zzl = zzl();
                        if (zzioVar.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true) == zzju.GRANTED) {
                            str3 = "google_analytics_default_allow_ad_personalization_signals";
                            z = true;
                        } else {
                            str3 = "google_analytics_default_allow_ad_personalization_signals";
                            z = false;
                        }
                        long j7 = this.zzg;
                        Boolean valueOf = Boolean.valueOf(z);
                        List list2 = this.zzi;
                        String zzq = zzioVar.zzm().zzh().zzq();
                        if (this.zzj == null) {
                            this.zzj = zzioVar.zzw().zzF();
                        }
                        String str7 = this.zzj;
                        if (zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
                            i = i4;
                            list = list2;
                            j = 0;
                            str4 = null;
                        } else {
                            zzg();
                            j = 0;
                            if (this.zzo == 0) {
                                i = i4;
                                list = list2;
                            } else {
                                i = i4;
                                list = list2;
                                long currentTimeMillis = zzioVar.zzaU().currentTimeMillis() - this.zzo;
                                if (this.zzn != null && currentTimeMillis > 86400000 && this.zzp == null) {
                                    zzq();
                                }
                            }
                            if (this.zzn == null) {
                                zzq();
                            }
                            str4 = this.zzn;
                        }
                        boolean zzE = zzioVar.zzf().zzE();
                        zzqf zzw3 = zzioVar.zzw();
                        String zzm3 = zzm();
                        zzioVar2 = zzw3.zzu;
                        if (zzioVar2.zzaT().getPackageManager() != null) {
                            j2 = j;
                            i2 = 0;
                        } else {
                            try {
                                i2 = 0;
                                try {
                                    applicationInfo = Wrappers.packageManager(zzioVar2.zzaT()).getApplicationInfo(zzm3, 0);
                                } catch (PackageManager.NameNotFoundException unused4) {
                                    zzio zzioVar8 = zzw3.zzu;
                                    zzioVar8.zzaV();
                                    zzioVar8.zzaW().zzi().zzb("PackageManager failed to find running app: app_id", zzm3);
                                    i3 = i2;
                                    j2 = i3;
                                    zzio zzioVar9 = this.zzu;
                                    int zzb = zzioVar9.zzm().zzh().zzb();
                                    String zzj = zzioVar9.zzm().zzf().zzj();
                                    zzqr.zzb();
                                    zzam zzf = zzioVar9.zzf();
                                    zzgg zzggVar = zzgi.zzaW;
                                    if (zzf.zzx(null, zzggVar)) {
                                    }
                                    zzqr.zzb();
                                    return new zzr(zzm, zzo, str5, j4, str6, 119002L, j6, str, zzJ, z2, str2, min, i, zzw2, z3, zzl, valueOf, j7, list, (String) null, zzq, str7, str4, zzE, j2, zzb, zzj, r41, zzioVar9.zzf().zzx(null, zzggVar) ? zzioVar9.zzw().zzq() : j, zzioVar9.zzf().zzs(), new zze(zzioVar9.zzf().zzm(str3, true)).zzc(), this.zzu.zza, zzioVar9.zzf().zzx(null, zzgi.zzaR) ? this.zzu.zzs().zzi().zza() : 0);
                                }
                            } catch (PackageManager.NameNotFoundException unused5) {
                                i2 = 0;
                            }
                            if (applicationInfo != null) {
                                i3 = applicationInfo.targetSdkVersion;
                                j2 = i3;
                            }
                            i3 = i2;
                            j2 = i3;
                        }
                        zzio zzioVar92 = this.zzu;
                        int zzb2 = zzioVar92.zzm().zzh().zzb();
                        String zzj2 = zzioVar92.zzm().zzf().zzj();
                        zzqr.zzb();
                        zzam zzf2 = zzioVar92.zzf();
                        zzgg zzggVar2 = zzgi.zzaW;
                        int zzl2 = zzf2.zzx(null, zzggVar2) ? zzioVar92.zzw().zzl() : i2;
                        zzqr.zzb();
                        return new zzr(zzm, zzo, str5, j4, str6, 119002L, j6, str, zzJ, z2, str2, min, i, zzw2, z3, zzl, valueOf, j7, list, (String) null, zzq, str7, str4, zzE, j2, zzb2, zzj2, zzl2, zzioVar92.zzf().zzx(null, zzggVar2) ? zzioVar92.zzw().zzq() : j, zzioVar92.zzf().zzs(), new zze(zzioVar92.zzf().zzm(str3, true)).zzc(), this.zzu.zza, zzioVar92.zzf().zzx(null, zzgi.zzaR) ? this.zzu.zzs().zzi().zza() : 0);
                    }
                }
            } else {
                this.zzu.zzaW().zzj().zza("Disabled IID for tests.");
            }
        }
        str2 = null;
        zzio zzioVar72 = this.zzu;
        long zza2 = zzioVar72.zzm().zzc.zza();
        long min2 = zza2 != 0 ? zzioVar72.zza : Math.min(zzioVar72.zza, zza2);
        zza();
        int i42 = this.zzk;
        zzioVar = this.zzu;
        boolean zzw22 = zzioVar.zzf().zzw();
        zzht zzm22 = zzioVar.zzm();
        zzm22.zzg();
        boolean z32 = zzm22.zzb().getBoolean("deferred_analytics_collection", false);
        String zzl3 = zzl();
        if (zzioVar.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true) == zzju.GRANTED) {
        }
        long j72 = this.zzg;
        Boolean valueOf2 = Boolean.valueOf(z);
        List list22 = this.zzi;
        String zzq2 = zzioVar.zzm().zzh().zzq();
        if (this.zzj == null) {
        }
        String str72 = this.zzj;
        if (zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
        }
        boolean zzE2 = zzioVar.zzf().zzE();
        zzqf zzw32 = zzioVar.zzw();
        String zzm32 = zzm();
        zzioVar2 = zzw32.zzu;
        if (zzioVar2.zzaT().getPackageManager() != null) {
        }
        zzio zzioVar922 = this.zzu;
        int zzb22 = zzioVar922.zzm().zzh().zzb();
        String zzj22 = zzioVar922.zzm().zzf().zzj();
        zzqr.zzb();
        zzam zzf22 = zzioVar922.zzf();
        zzgg zzggVar22 = zzgi.zzaW;
        if (zzf22.zzx(null, zzggVar22)) {
        }
        zzqr.zzb();
        return new zzr(zzm, zzo, str5, j4, str6, 119002L, j6, str, zzJ, z2, str2, min2, i, zzw22, z32, zzl3, valueOf2, j72, list, (String) null, zzq2, str72, str4, zzE2, j2, zzb22, zzj22, zzl2, zzioVar922.zzf().zzx(null, zzggVar22) ? zzioVar922.zzw().zzq() : j, zzioVar922.zzf().zzs(), new zze(zzioVar922.zzf().zzm(str3, true)).zzc(), this.zzu.zza, zzioVar922.zzf().zzx(null, zzgi.zzaR) ? this.zzu.zzs().zzi().zza() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzl() {
        zza();
        if (this.zzu.zzf().zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzm() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzn() {
        zza();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzo() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzp() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq() {
        String format;
        zzg();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
            zzioVar.zzaW().zzd().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzioVar.zzw().zzJ().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzioVar.zzaW().zzd().zza(String.format("Resetting session stitching token to %s", format == null ? "null" : "not null"));
        this.zzn = format;
        this.zzo = zzioVar.zzaU().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
