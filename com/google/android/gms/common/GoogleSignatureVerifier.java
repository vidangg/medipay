package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public class GoogleSignatureVerifier {

    @Nullable
    private static GoogleSignatureVerifier zza;

    @Nullable
    private static volatile Set zzb;

    @Nullable
    private static volatile Set zzc;
    private final Context zzd;
    private volatile String zze;

    public GoogleSignatureVerifier(Context context) {
        this.zzd = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzn.zze(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjVarArr.length; i++) {
                if (zzjVarArr[i].equals(zzkVar)) {
                    return zzjVarArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (z) {
            if (packageInfo != null) {
                if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    z = (applicationInfo == null || (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) ? false : true;
                }
            } else {
                packageInfo2 = null;
                if (packageInfo != null && packageInfo2.signatures != null) {
                    if ((!z ? zza(packageInfo2, zzm.zza) : zza(packageInfo2, zzm.zza[0])) == null) {
                        return true;
                    }
                }
                return false;
            }
        }
        packageInfo2 = packageInfo;
        if (packageInfo != null) {
            if ((!z ? zza(packageInfo2, zzm.zza) : zza(packageInfo2, zzm.zza[0])) == null) {
            }
        }
        return false;
    }

    private final zzw zzc(@Nullable String str, boolean z, boolean z2) {
        zzw zzc2;
        if (str == null) {
            return zzw.zzc("null pkg");
        }
        if (str.equals(this.zze)) {
            return zzw.zzb();
        }
        if (zzn.zzg()) {
            zzc2 = zzn.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzd.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd);
                if (packageInfo == null) {
                    zzc2 = zzw.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzc2 = zzw.zzc("single cert required");
                } else {
                    zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzw zza2 = zzn.zza(str2, zzkVar, honorsDebugCertificates, false);
                    zzc2 = (!zza2.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzn.zza(str2, zzkVar, false, true).zza) ? zza2 : zzw.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzw.zzd("no pkg ".concat(str), e);
            }
        }
        if (zzc2.zza) {
            this.zze = str;
        }
        return zzc2;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String str) {
        zzw zzc2 = zzc(str, false, false);
        zzc2.zze();
        return zzc2.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzw zzc2;
        int length;
        String[] packagesForUid = this.zzd.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzc2 = null;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    zzc2 = zzc(packagesForUid[i2], false, false);
                    if (zzc2.zza) {
                        break;
                    }
                    i2++;
                } else {
                    Preconditions.checkNotNull(zzc2);
                    break;
                }
            }
        } else {
            zzc2 = zzw.zzc("no pkgs");
        }
        zzc2.zze();
        return zzc2.zza;
    }
}
