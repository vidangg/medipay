package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhw {
    final zzio zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhw(zzpv zzpvVar) {
        this.zza = zzpvVar.zzt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza() {
        try {
            zzio zzioVar = this.zza;
            PackageManagerWrapper packageManager = Wrappers.packageManager(zzioVar.zzaT());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            zzioVar.zzaW().zzj().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.zza.zzaW().zzj().zzb("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
