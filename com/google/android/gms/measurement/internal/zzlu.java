package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzlv zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlu(zzlv zzlvVar, boolean z, Uri uri, String str, String str2) {
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzlvVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5 A[Catch: RuntimeException -> 0x0150, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0150, blocks: (B:3:0x000d, B:9:0x0096, B:11:0x00a0, B:14:0x00ad, B:16:0x00b3, B:17:0x00c6, B:18:0x00ce, B:23:0x00d5, B:27:0x00f6, B:29:0x010e, B:31:0x0100, B:32:0x0112, B:34:0x0118, B:36:0x011e, B:38:0x0124, B:40:0x012a, B:42:0x0132, B:44:0x013a, B:46:0x0140, B:49:0x0144, B:51:0x0027, B:53:0x002d, B:55:0x0035, B:57:0x003b, B:59:0x0041, B:61:0x0047, B:63:0x004f, B:65:0x0057, B:67:0x005f, B:69:0x0067, B:70:0x0075, B:72:0x0089), top: B:2:0x000d }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Bundle zzu;
        String str;
        Bundle zzu2;
        zzlv zzlvVar = this.zze;
        zzlw zzlwVar = zzlvVar.zza;
        zzlwVar.zzg();
        String str2 = this.zzd;
        Uri uri = this.zzb;
        try {
            zzio zzioVar = zzlwVar.zzu;
            zzqf zzw = zzioVar.zzw();
            if (!TextUtils.isEmpty(str2)) {
                if (str2.contains("gclid") || str2.contains("gbraid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id")) {
                    zzu = zzw.zzu(Uri.parse("https://google.com/search?".concat(String.valueOf(str2))));
                    if (zzu != null) {
                        zzu.putString("_cis", "referrer");
                    }
                    str = this.zzc;
                    if (this.zza && (zzu2 = zzioVar.zzw().zzu(uri)) != null) {
                        zzu2.putString("_cis", "intent");
                        if (!zzu2.containsKey("gclid") && zzu != null && zzu.containsKey("gclid")) {
                            zzu2.putString("_cer", String.format("gclid=%s", zzu.getString("gclid")));
                        }
                        zzlwVar.zzR(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzu2);
                        zzlwVar.zzb.zza(str, zzu2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        zzioVar.zzaW().zzd().zzb("Activity created with referrer", str2);
                        if (zzioVar.zzf().zzx(null, zzgi.zzaF)) {
                            if (zzu != null) {
                                zzlwVar.zzR(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzu);
                                zzlwVar.zzb.zza(str, zzu);
                            } else {
                                zzioVar.zzaW().zzd().zzb("Referrer does not contain valid parameters", str2);
                            }
                            zzlwVar.zzal("auto", "_ldl", null, true);
                            return;
                        }
                        if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                            zzioVar.zzaW().zzd().zza("Activity created with data 'referrer' without required params");
                            return;
                        } else {
                            if (TextUtils.isEmpty(str2)) {
                                return;
                            }
                            zzlwVar.zzal("auto", "_ldl", str2, true);
                            return;
                        }
                    }
                    return;
                }
                zzw.zzu.zzaW().zzd().zza("Activity created with data 'referrer' without required params");
            }
            zzu = null;
            str = this.zzc;
            if (this.zza) {
                zzu2.putString("_cis", "intent");
                if (!zzu2.containsKey("gclid")) {
                    zzu2.putString("_cer", String.format("gclid=%s", zzu.getString("gclid")));
                }
                zzlwVar.zzR(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzu2);
                zzlwVar.zzb.zza(str, zzu2);
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (RuntimeException e) {
            zzlvVar.zza.zzu.zzaW().zze().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
