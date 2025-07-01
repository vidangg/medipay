package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public class PackageSignatureVerifier {
    static volatile zzab zza;
    private static zzac zzb;

    private static zzac zza(Context context) {
        zzac zzacVar;
        synchronized (PackageSignatureVerifier.class) {
            if (zzb == null) {
                zzb = new zzac(context);
            }
            zzacVar = zzb;
        }
        return zzacVar;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        PackageVerificationResult packageVerificationResult;
        String str2;
        PackageVerificationResult packageVerificationResult2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        if (zzn.zzf()) {
            String concat = String.valueOf(str).concat(true != honorsDebugCertificates ? "-0" : "-1");
            if (zza != null) {
                str2 = zza.zza;
                if (str2.equals(concat)) {
                    packageVerificationResult2 = zza.zzb;
                    return packageVerificationResult2;
                }
            }
            zza(context);
            zzw zzc = zzn.zzc(str, honorsDebugCertificates, false, false);
            if (!zzc.zza) {
                Preconditions.checkNotNull(zzc.zzb);
                return PackageVerificationResult.zza(str, zzc.zzb, zzc.zzc);
            }
            zza = new zzab(concat, PackageVerificationResult.zzd(str, zzc.zzd));
            packageVerificationResult = zza.zzb;
            return packageVerificationResult;
        }
        throw new zzad();
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!queryPackageSignatureVerified2.zzc()) {
                return queryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            return queryPackageSignatureVerified2;
        }
    }
}
