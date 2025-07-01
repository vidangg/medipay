package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzx {
    private final zzio zza;

    public zzx(zzio zzioVar) {
        this.zza = zzioVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, Bundle bundle) {
        String uri;
        zzio zzioVar = this.zza;
        zzioVar.zzaX().zzg();
        if (zzioVar.zzJ()) {
            return;
        }
        if (bundle.isEmpty()) {
            uri = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            uri = builder.build().toString();
        }
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        zzioVar.zzm().zzr.zzb(uri);
        zzioVar.zzm().zzs.zzb(zzioVar.zzaU().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        zzio zzioVar = this.zza;
        zzioVar.zzaX().zzg();
        if (zzd()) {
            if (zze()) {
                zzioVar.zzm().zzr.zzb(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                zzioVar.zzq().zzR("auto", "_cmpx", bundle);
            } else {
                String zza = zzioVar.zzm().zzr.zza();
                if (TextUtils.isEmpty(zza)) {
                    zzioVar.zzaW().zzh().zza("Cache still valid but referrer not found");
                } else {
                    long zza2 = zzioVar.zzm().zzs.zza() / 3600000;
                    Uri parse = Uri.parse(zza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", (zza2 - 1) * 3600000);
                    zzioVar.zzq().zzR(pair.first == null ? "app" : (String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                zzioVar.zzm().zzr.zzb(null);
            }
            zzioVar.zzm().zzs.zzb(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        if (zzd() && zze()) {
            this.zza.zzm().zzr.zzb(null);
        }
    }

    final boolean zzd() {
        return this.zza.zzm().zzs.zza() > 0;
    }

    final boolean zze() {
        if (!zzd()) {
            return false;
        }
        zzio zzioVar = this.zza;
        return zzioVar.zzaU().currentTimeMillis() - zzioVar.zzm().zzs.zza() > zzioVar.zzf().zzk(null, zzgi.zzai);
    }
}
