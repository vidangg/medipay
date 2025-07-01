package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.Renderer;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzqf extends zzjr {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"firebase_", "google_", "ga_"};
    private static final String[] zzc = {"_err"};
    private SecureRandom zzd;
    private final AtomicLong zze;
    private int zzf;
    private MeasurementManagerFutures zzg;
    private Boolean zzh;
    private Integer zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqf(zzio zzioVar) {
        super(zzioVar);
        this.zzi = null;
        this.zze = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest zzI() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList zzK(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzai zzaiVar = (zzai) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzaiVar.zza);
            bundle.putString("origin", zzaiVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzaiVar.zzd);
            bundle.putString("name", zzaiVar.zzc.zzb);
            zzjt.zzb(bundle, Preconditions.checkNotNull(zzaiVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzaiVar.zze);
            String str = zzaiVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzbh zzbhVar = zzaiVar.zzg;
            if (zzbhVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbhVar.zza);
                zzbf zzbfVar = zzbhVar.zzb;
                if (zzbfVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbfVar.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzaiVar.zzh);
            zzbh zzbhVar2 = zzaiVar.zzi;
            if (zzbhVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbhVar2.zza);
                zzbf zzbfVar2 = zzbhVar2.zzb;
                if (zzbfVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbfVar2.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzaiVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzaiVar.zzj);
            zzbh zzbhVar3 = zzaiVar.zzk;
            if (zzbhVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbhVar3.zza);
                zzbf zzbfVar3 = zzbhVar3.zzb;
                if (zzbfVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbfVar3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void zzN(zzmh zzmhVar, Bundle bundle, boolean z) {
        if (bundle != null && zzmhVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzmhVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzmhVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzmhVar.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zzmhVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    private final int zzaA(String str) {
        if ("_ldl".equals(str)) {
            this.zzu.zzf();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.zzu.zzf();
            return 256;
        }
        if (!"_lgclid".equals(str)) {
            this.zzu.zzf();
            return 36;
        }
        this.zzu.zzf();
        return 100;
    }

    private final Object zzaB(int i, Object obj, boolean z, boolean z2, String str) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zzG(obj.toString(), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle zzz = zzz((Bundle) parcelable, null);
                if (!zzz.isEmpty()) {
                    arrayList.add(zzz);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private static boolean zzaC(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzap(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzaq(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzar(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzas(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzat(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzas(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public static boolean zzau(String str) {
        return !zzc[0].equals(str);
    }

    static final boolean zzaz(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzr(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (bArr[i2] & 255) << i;
            i += 8;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzA(String str, String str2, Bundle bundle, List list, boolean z) {
        int zzi;
        int i;
        zzio zzioVar;
        List list2 = list;
        boolean zzaC = zzaC(str2, zzjy.zzd);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        zzio zzioVar2 = this.zzu;
        int zze = zzioVar2.zzf().zze();
        int i2 = 0;
        boolean z2 = false;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str3)) {
                zzi = !z ? zzi(str3) : 0;
                if (zzi == 0) {
                    zzi = zzh(str3);
                }
            } else {
                zzi = 0;
            }
            if (zzi != 0) {
                zzM(bundle2, zzi, str3, zzi == 3 ? str3 : null);
                bundle2.remove(str3);
                i = zze;
                zzioVar = zzioVar2;
            } else {
                i = zze;
                zzioVar = zzioVar2;
                int zza2 = zza(str, str2, str3, bundle.get(str3), bundle2, list, z, zzaC);
                if (zza2 == 17) {
                    zzM(bundle2, 17, str3, false);
                } else if (zza2 != 0 && !"_ev".equals(str3)) {
                    zzM(bundle2, zza2, zza2 == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (zzaq(str3)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z2) {
                            zzioVar.zzaW().zzf().zzc("Event can't contain more than " + i + " params", zzioVar.zzj().zzd(str2), zzioVar.zzj().zzb(bundle));
                        }
                        zzaz(bundle2, 5);
                        bundle2.remove(str3);
                        z2 = true;
                    }
                    i2 = i3;
                    zze = i;
                    zzioVar2 = zzioVar;
                    list2 = list;
                }
            }
            zze = i;
            zzioVar2 = zzioVar;
            list2 = list;
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MeasurementManagerFutures zzB() {
        if (this.zzg == null) {
            this.zzg = MeasurementManagerFutures.from(this.zzu.zzaT());
        }
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbh zzC(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzf(str2) != 0) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zze().zzb("Invalid conditional property event name", zzioVar.zzj().zzf(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle zzA = zzA(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
        if (z) {
            zzA = zzz(zzA, str);
        }
        Preconditions.checkNotNull(zzA);
        return new zzbh(str2, new zzbf(zzA), str3, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzD(String str, Object obj) {
        int zzc2;
        if ("_ev".equals(str)) {
            return zzaB(this.zzu.zzf().zzd(null, false), obj, true, true, null);
        }
        if (!zzap(str)) {
            zzc2 = this.zzu.zzf().zzc(null, false);
        } else {
            zzc2 = this.zzu.zzf().zzd(null, false);
        }
        return zzaB(zzc2, obj, false, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzE(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzaB(zzaA(str), obj, true, false, null);
        }
        return zzaB(zzaA(str), obj, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzF() {
        byte[] bArr = new byte[16];
        zzJ().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final String zzG(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public final URL zzH(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 119002L, Integer.valueOf(zzm())), str2, str, Long.valueOf(j2));
            if (str.equals(this.zzu.zzf().zzp())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat("&");
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            this.zzu.zzaW().zze().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzJ() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzL(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzu.zzaW().zzk().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    final void zzM(Bundle bundle, int i, String str, Object obj) {
        if (zzaz(bundle, i)) {
            this.zzu.zzf();
            bundle.putString("_ev", zzG(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzO(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.zzu.zzw().zzS(bundle, str, bundle2.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzP(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i2 = 0;
            boolean z = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzaq(str) && !zzaC(str, zzjz.zzd) && (i2 = i2 + 1) > i) {
                    zzio zzioVar = this.zzu;
                    if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z) {
                        zzioVar.zzaW().zzf().zzc("Param can't contain more than " + i + " item-scoped custom parameters", zzioVar.zzj().zze(str), zzioVar.zzj().zzb(bundle));
                    }
                    zzaz(bundle, 28);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzQ(zzhf zzhfVar, int i) {
        Bundle bundle = zzhfVar.zzd;
        int i2 = 0;
        boolean z = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (zzaq(str) && (i2 = i2 + 1) > i) {
                zzio zzioVar = this.zzu;
                if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z) {
                    zzioVar.zzaW().zzf().zzc("Event can't contain more than " + i + " params", zzioVar.zzj().zzd(zzhfVar.zza), zzioVar.zzj().zzb(bundle));
                    zzaz(bundle, 5);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzR(zzqe zzqeVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzaz(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzqeVar.zza(str, "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzS(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzl().zzc("Not putting event parameter. Invalid value type. name, type", zzioVar.zzj().zze(str), simpleName);
        }
    }

    public final void zzT(com.google.android.gms.internal.measurement.zzcy zzcyVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzU(com.google.android.gms.internal.measurement.zzcy zzcyVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final void zzV(com.google.android.gms.internal.measurement.zzcy zzcyVar, Bundle bundle) {
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzW(com.google.android.gms.internal.measurement.zzcy zzcyVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzX(com.google.android.gms.internal.measurement.zzcy zzcyVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzY(com.google.android.gms.internal.measurement.zzcy zzcyVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzZ(com.google.android.gms.internal.measurement.zzcy zzcyVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning string value to wrapper", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zza(String str, String str2, String str3, Object obj, Bundle bundle, List list, boolean z, boolean z2) {
        int i;
        int zzd;
        int size;
        zzg();
        if (zzal(obj)) {
            if (!z2) {
                return 21;
            }
            if (!zzaC(str3, zzjz.zzc)) {
                return 20;
            }
            zzny zzu = this.zzu.zzu();
            zzu.zzg();
            zzu.zza();
            if (zzu.zzad() && zzu.zzu.zzw().zzm() < 200900) {
                return 25;
            }
            zzio zzioVar = this.zzu;
            zzioVar.zzf();
            boolean z3 = obj instanceof Parcelable[];
            if (z3) {
                size = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            if (size > 200) {
                zzioVar.zzaW().zzl().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                zzioVar.zzf();
                if (z3) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i = 17;
                if (!zzap(str2) || zzap(str3)) {
                    zzd = this.zzu.zzf().zzd(null, false);
                } else {
                    zzd = this.zzu.zzf().zzc(null, false);
                }
                if (!zzaf("param", str3, zzd, obj)) {
                    return i;
                }
                if (!z2) {
                    return 4;
                }
                if (obj instanceof Bundle) {
                    zzaa(str, str2, str3, (Bundle) obj, list, z);
                } else if (obj instanceof Parcelable[]) {
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (parcelable instanceof Bundle) {
                            zzaa(str, str2, str3, (Bundle) parcelable, list, z);
                        } else {
                            this.zzu.zzaW().zzl().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                            return 4;
                        }
                    }
                } else {
                    if (!(obj instanceof ArrayList)) {
                        return 4;
                    }
                    ArrayList arrayList2 = (ArrayList) obj;
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        Object obj2 = arrayList2.get(i2);
                        if (obj2 instanceof Bundle) {
                            zzaa(str, str2, str3, (Bundle) obj2, list, z);
                        } else {
                            this.zzu.zzaW().zzl().zzc("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : "null", str3);
                            return 4;
                        }
                    }
                }
                return i;
            }
        }
        i = 0;
        if (!zzap(str2)) {
        }
        zzd = this.zzu.zzf().zzd(null, false);
        if (!zzaf("param", str3, zzd, obj)) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjr
    protected final void zzaZ() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzu.zzaW().zzk().zza("Utils falling back to Random for random id");
            }
        }
        this.zze.set(nextLong);
    }

    final void zzaa(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int zzi;
        int i;
        char c;
        String str4;
        int i2;
        int zza2;
        if (bundle == null) {
            return;
        }
        zzio zzioVar = this.zzu;
        char c2 = 20064;
        int i3 = true != zzioVar.zzf().zzu.zzw().zzao(231100000, true) ? 0 : 35;
        int i4 = 0;
        boolean z2 = false;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                zzi = !z ? zzi(str5) : 0;
                if (zzi == 0) {
                    zzi = zzh(str5);
                }
            } else {
                zzi = 0;
            }
            if (zzi != 0) {
                zzM(bundle, zzi, str5, zzi == 3 ? str5 : null);
                bundle.remove(str5);
                i = i3;
                c = c2;
            } else {
                if (zzal(bundle.get(str5))) {
                    zzioVar.zzaW().zzl().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    zza2 = 22;
                    str4 = str5;
                    i2 = i3;
                } else {
                    str4 = str5;
                    i2 = i3;
                    zza2 = zza(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (zza2 == 0 || "_ev".equals(str4)) {
                    if (zzaq(str4) && !zzaC(str4, zzjz.zzd)) {
                        int i5 = i4 + 1;
                        c = 20064;
                        if (zzao(231100000, true)) {
                            i = i2;
                            if (i5 > i) {
                                if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z2) {
                                    zzioVar.zzaW().zzf().zzc("Item can't contain more than " + i + " item-scoped custom params", zzioVar.zzj().zzd(str2), zzioVar.zzj().zzb(bundle));
                                }
                                zzaz(bundle, 28);
                                bundle.remove(str4);
                                i4 = i5;
                                c2 = 20064;
                                i3 = i;
                                z2 = true;
                            }
                        } else {
                            zzioVar.zzaW().zzf().zzc("Item array not supported on client's version of Google Play Services (Android Only)", zzioVar.zzj().zzd(str2), zzioVar.zzj().zzb(bundle));
                            zzaz(bundle, 23);
                            bundle.remove(str4);
                            i = i2;
                        }
                        i4 = i5;
                    }
                } else {
                    zzM(bundle, zza2, str4, bundle.get(str4));
                    bundle.remove(str4);
                }
                i = i2;
                c = 20064;
            }
            c2 = c;
            i3 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzab(String str) {
        String str2 = (String) zzgi.zzaq.zza(null);
        return str2.equals(ProxyConfig.MATCH_ALL_SCHEMES) || Arrays.asList(str2.split(",")).contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzac(String str, String str2) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzbp)) {
            if (!TextUtils.isEmpty(str)) {
                if (zzax(str)) {
                    return true;
                }
                if (this.zzu.zzL()) {
                    zzioVar.zzaW().zzf().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzhe.zzn(str));
                    return false;
                }
            } else if (this.zzu.zzL()) {
                zzioVar.zzaW().zzf().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                return false;
            }
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!zzax(str)) {
                if (this.zzu.zzL()) {
                    zzioVar.zzaW().zzf().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzhe.zzn(str));
                }
                return false;
            }
        } else if (!TextUtils.isEmpty(str2)) {
            if (!zzax(str2)) {
                zzioVar.zzaW().zzf().zzb("Invalid admob_app_id. Analytics disabled.", zzhe.zzn(str2));
                return false;
            }
        } else {
            if (this.zzu.zzL()) {
                zzioVar.zzaW().zzf().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzad(String str, int i, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        this.zzu.zzaW().zzf().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzae(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzu.zzaW().zzf().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzaC(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzaC(str2, strArr2)) {
            return true;
        }
        this.zzu.zzaW().zzf().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaf(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.zzu.zzaW().zzl().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzag(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            if (codePointAt != 95) {
                this.zzu.zzaW().zzf().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            codePointAt = 95;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                charCount += Character.charCount(codePointAt2);
            } else {
                this.zzu.zzaW().zzf().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzah(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            this.zzu.zzaW().zzf().zzc("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                charCount += Character.charCount(codePointAt2);
            } else {
                this.zzu.zzaW().zzf().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    final boolean zzai() {
        Object e;
        Integer num;
        boolean z;
        if (this.zzh == null) {
            MeasurementManagerFutures zzB = zzB();
            if (zzB == null) {
                return false;
            }
            try {
                num = zzB.getMeasurementApiStatusAsync().get(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e2) {
                e = e2;
                num = null;
            }
            if (num != null) {
                try {
                    z = true;
                } catch (InterruptedException e3) {
                    e = e3;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (CancellationException e4) {
                    e = e4;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (ExecutionException e5) {
                    e = e5;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (TimeoutException e6) {
                    e = e6;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                }
                if (num.intValue() == 1) {
                    this.zzh = Boolean.valueOf(z);
                    this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                }
            }
            z = false;
            this.zzh = Boolean.valueOf(z);
            this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
        }
        return this.zzh.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaj(String str) {
        zzg();
        zzio zzioVar = this.zzu;
        if (Wrappers.packageManager(zzioVar.zzaT()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzioVar.zzaW().zzd().zzb("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzak(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        zzio zzioVar = this.zzu;
        String zzo = zzioVar.zzf().zzo();
        zzioVar.zzaV();
        return zzo.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzal(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzam(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaW().zze().zzb("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            this.zzu.zzaW().zze().zzb("Error obtaining certificate", e2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzan() {
        zzg();
        return zzq() == 1;
    }

    public final boolean zzao(int i, boolean z) {
        Boolean zzl = this.zzu.zzu().zzl();
        if (zzm() < i / 1000) {
            return (zzl == null || zzl.booleanValue()) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzav(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaw(String str, String str2, String str3, String str4) {
        if (this.zzu.zzf().zzx(null, zzgi.zzbp)) {
            return zzav(str, str2);
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    final boolean zzax(String str) {
        Preconditions.checkNotNull(str);
        return str.matches(true != this.zzu.zzf().zzx(null, zzgi.zzbp) ? "^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$" : "^1:\\d+:android:[a-f0-9]+$");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzay(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjr
    protected final boolean zzc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzd(String str, Object obj) {
        boolean zzaf;
        if ("_ldl".equals(str)) {
            zzaf = zzaf("user property referrer", str, zzaA(str), obj);
        } else {
            zzaf = zzaf("user property", str, zzaA(str), obj);
        }
        return zzaf ? 0 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzf(String str) {
        if (!zzag(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zzae(NotificationCompat.CATEGORY_EVENT, zzjy.zza, zzjy.zzb, str)) {
            return 13;
        }
        this.zzu.zzf();
        return !zzad(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
    }

    final int zzh(String str) {
        if (!zzag("event param", str)) {
            return 3;
        }
        if (!zzae("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzf();
        return !zzad("event param", 40, str) ? 3 : 0;
    }

    final int zzi(String str) {
        if (!zzah("event param", str)) {
            return 3;
        }
        if (!zzae("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzf();
        return !zzad("event param", 40, str) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzj(String str) {
        if (!zzag("user property", str)) {
            return 6;
        }
        if (!zzae("user property", zzka.zza, null, str)) {
            return 15;
        }
        this.zzu.zzf();
        return !zzad("user property", 24, str) ? 6 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzl() {
        int extensionVersion;
        int extensionVersion2;
        if (Build.VERSION.SDK_INT < 30) {
            return 0;
        }
        extensionVersion = SdkExtensions.getExtensionVersion(30);
        if (extensionVersion <= 3) {
            return 0;
        }
        extensionVersion2 = SdkExtensions.getExtensionVersion(1000000);
        return extensionVersion2;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.zzi == null) {
            this.zzi = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaT()) / 1000);
        }
        return this.zzi.intValue();
    }

    public final int zzp(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaT(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzq() {
        int extensionVersion;
        long j;
        zzg();
        if (!zzab(this.zzu.zzh().zzm())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j = 4;
        } else {
            extensionVersion = SdkExtensions.getExtensionVersion(30);
            if (extensionVersion < 4) {
                j = 8;
            } else {
                zzio zzioVar = this.zzu;
                int zzl = zzl();
                zzioVar.zzf();
                j = zzl < ((Integer) zzgi.zzak.zza(null)).intValue() ? 16L : 0L;
            }
        }
        if (!zzaj("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0 && !zzai()) {
            j = 64;
        }
        if (j == 0) {
            return 1L;
        }
        return j;
    }

    public final long zzs() {
        long andIncrement;
        long j;
        AtomicLong atomicLong = this.zze;
        if (atomicLong.get() == 0) {
            synchronized (atomicLong) {
                long nextLong = new Random(System.nanoTime() ^ this.zzu.zzaU().currentTimeMillis()).nextLong();
                int i = this.zzf + 1;
                this.zzf = i;
                j = nextLong + i;
            }
            return j;
        }
        AtomicLong atomicLong2 = this.zze;
        synchronized (atomicLong2) {
            atomicLong2.compareAndSet(-1L, 1L);
            andIncrement = atomicLong2.getAndIncrement();
        }
        return andIncrement;
    }

    public final long zzt(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzu(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
                str5 = uri.getQueryParameter("gbraid");
                str6 = uri.getQueryParameter("utm_id");
                str7 = uri.getQueryParameter("dclid");
                str8 = uri.getQueryParameter("srsltid");
                str9 = uri.getQueryParameter("sfmc_id");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                str9 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str10 = "sfmc_id";
            } else {
                str10 = "sfmc_id";
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gad_source", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("anid", queryParameter6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("dclid", str7);
            }
            String queryParameter7 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter9);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("srsltid", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                bundle.putString(str10, str9);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            this.zzu.zzaW().zzk().zzb("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzz(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object zzD = zzD(str2, bundle.get(str2));
                if (zzD == null) {
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zzl().zzb("Param value can't be null", zzioVar.zzj().zze(str2));
                } else {
                    zzS(bundle2, str2, zzD);
                }
            }
        }
        return bundle2;
    }
}
