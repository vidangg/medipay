package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzka;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.4.0 */
/* loaded from: classes4.dex */
public final class zzc {
    public static final /* synthetic */ int zza = 0;
    private static final ImmutableSet zzb = ImmutableSet.of("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");
    private static final ImmutableList zzc = ImmutableList.of("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final ImmutableList zzd = ImmutableList.of("auto", "app", "am");
    private static final ImmutableList zze = ImmutableList.of("_r", "_dbg");
    private static final ImmutableList zzf = new ImmutableList.Builder().add((Object[]) zzka.zza).add((Object[]) zzka.zzb).build();
    private static final ImmutableList zzg = ImmutableList.of("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zza(String str, String str2, Bundle bundle) {
        char c;
        if (!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2)) {
            return true;
        }
        if (!zzd(str) || bundle == null) {
            return false;
        }
        ImmutableList immutableList = zze;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            boolean containsKey = bundle.containsKey((String) immutableList.get(i));
            i++;
            if (containsKey) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode == 101200) {
            if (str.equals("fcm")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 101230) {
            if (hashCode == 3142703 && str.equals(AppMeasurement.FIAM_ORIGIN)) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("fdl")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        if (c == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        if (c != 2) {
            return false;
        }
        bundle.putString("_cis", "fiam_integration");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzb(String str, Bundle bundle) {
        if (zzc.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        ImmutableList immutableList = zze;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            boolean containsKey = bundle.containsKey((String) immutableList.get(i));
            i++;
            if (containsKey) {
                return false;
            }
        }
        return true;
    }

    public static boolean zzc(String str) {
        return !zzb.contains(str);
    }

    public static boolean zzd(String str) {
        return !zzd.contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zze(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if (Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION.equals(str2)) {
            return str.equals("fcm") || str.equals(AppMeasurement.FIAM_ORIGIN);
        }
        if (zzf.contains(str2)) {
            return false;
        }
        ImmutableList immutableList = zzg;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            boolean matches = str2.matches((String) immutableList.get(i));
            i++;
            if (matches) {
                return false;
            }
        }
        return true;
    }
}
