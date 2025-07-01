package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.Renderer;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlw extends zzg {
    protected zzlv zza;
    final zzx zzb;
    protected boolean zzc;
    private zzkb zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private boolean zzi;
    private int zzj;
    private zzaz zzk;
    private zzaz zzl;
    private PriorityQueue zzm;
    private boolean zzn;
    private zzjx zzo;
    private final AtomicLong zzp;
    private long zzq;
    private zzaz zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzaz zzt;
    private final zzqe zzv;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlw(zzio zzioVar) {
        super(zzioVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzv = new zzlk(this);
        this.zzg = new AtomicReference();
        this.zzo = zzjx.zza;
        this.zzq = -1L;
        this.zzp = new AtomicLong(0L);
        this.zzb = new zzx(zzioVar);
    }

    public static /* synthetic */ void zzA(zzlw zzlwVar, SharedPreferences sharedPreferences, String str) {
        zzio zzioVar = zzlwVar.zzu;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbj)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                zzioVar.zzaW().zzj().zza("IABTCF_TCString change picked up in listener.");
                ((zzaz) Preconditions.checkNotNull(zzlwVar.zzt)).zzd(500L);
                return;
            }
            return;
        }
        if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            zzioVar.zzaW().zzj().zza("IABTCF_TCString change picked up in listener.");
            ((zzaz) Preconditions.checkNotNull(zzlwVar.zzt)).zzd(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzD(zzlw zzlwVar, zzjx zzjxVar, long j, boolean z, boolean z2) {
        zzlwVar.zzg();
        zzlwVar.zza();
        zzio zzioVar = zzlwVar.zzu;
        zzjx zzh = zzioVar.zzm().zzh();
        if (j > zzlwVar.zzq || !zzjx.zzs(zzh.zzb(), zzjxVar.zzb())) {
            zzht zzm = zzioVar.zzm();
            zzio zzioVar2 = zzm.zzu;
            zzm.zzg();
            int zzb = zzjxVar.zzb();
            if (zzm.zzq(zzb)) {
                zzio zzioVar3 = zzlwVar.zzu;
                SharedPreferences.Editor edit = zzm.zzb().edit();
                edit.putString("consent_settings", zzjxVar.zzq());
                edit.putInt("consent_source", zzb);
                edit.apply();
                zzioVar.zzaW().zzj().zzb("Setting storage consent(FE)", zzjxVar);
                zzlwVar.zzq = j;
                if (!zzioVar3.zzu().zzac()) {
                    zzioVar3.zzu().zzR(z);
                } else {
                    zzioVar3.zzu().zzX(z);
                }
                if (z2) {
                    zzioVar3.zzu().zzE(new AtomicReference());
                    return;
                }
                return;
            }
            zzioVar.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjxVar.zzb()));
            return;
        }
        zzioVar.zzaW().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzF(zzlw zzlwVar, int i) {
        if (zzlwVar.zzk == null) {
            zzlwVar.zzk = new zzku(zzlwVar, zzlwVar.zzu);
        }
        zzlwVar.zzk.zzd(i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ int zzaq(zzlw zzlwVar, Throwable th) {
        String message = th.getMessage();
        zzlwVar.zzn = false;
        int i = 2;
        if (message != null) {
            if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                i = 1;
                if (message.contains("Background")) {
                    zzlwVar.zzn = true;
                    return 1;
                }
            } else if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                return 3;
            }
        }
        return i;
    }

    private final zzme zzar(final zzpa zzpaVar) {
        try {
            URL url = new URI(zzpaVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzn = this.zzu.zzh().zzn();
            zzio zzioVar = this.zzu;
            zzhc zzj = zzioVar.zzaW().zzj();
            Long valueOf = Long.valueOf(zzpaVar.zza);
            zzj.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzpaVar.zzc, Integer.valueOf(zzpaVar.zzb.length));
            if (!TextUtils.isEmpty(zzpaVar.zzg)) {
                zzioVar.zzaW().zzj().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzpaVar.zzg);
            }
            HashMap hashMap = new HashMap();
            Bundle bundle = zzpaVar.zzd;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            zzmb zzr = zzioVar.zzr();
            byte[] bArr = zzpaVar.zzb;
            zzly zzlyVar = new zzly() { // from class: com.google.android.gms.measurement.internal.zzkn
                /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
                @Override // com.google.android.gms.measurement.internal.zzly
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void zza(String str2, int i, Throwable th, byte[] bArr2, Map map) {
                    zzme zzmeVar;
                    AtomicReference atomicReference2;
                    zzlw zzlwVar = zzlw.this;
                    zzlwVar.zzg();
                    zzpa zzpaVar2 = zzpaVar;
                    if (i != 200 && i != 204) {
                        if (i == 304) {
                            i = 304;
                        }
                        zzlwVar.zzu.zzaW().zzk().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzpaVar2.zza), Integer.valueOf(i), th);
                        zzmeVar = !Arrays.asList(((String) zzgi.zzt.zza(null)).split(",")).contains(String.valueOf(i)) ? zzme.BACKOFF : zzme.FAILURE;
                        atomicReference2 = atomicReference;
                        zzny zzu = zzlwVar.zzu.zzu();
                        long j = zzpaVar2.zza;
                        zzu.zzZ(new zzag(j, zzmeVar.zza(), zzpaVar2.zzf));
                        zzlwVar.zzu.zzaW().zzj().zzc("[sgtm] Updated status for row_id", Long.valueOf(j), zzmeVar);
                        synchronized (atomicReference2) {
                            atomicReference2.set(zzmeVar);
                            atomicReference2.notifyAll();
                        }
                        return;
                    }
                    if (th == null) {
                        zzlwVar.zzu.zzaW().zzj().zzb("[sgtm] Upload succeeded for row_id", Long.valueOf(zzpaVar2.zza));
                        zzmeVar = zzme.SUCCESS;
                        atomicReference2 = atomicReference;
                        zzny zzu2 = zzlwVar.zzu.zzu();
                        long j2 = zzpaVar2.zza;
                        zzu2.zzZ(new zzag(j2, zzmeVar.zza(), zzpaVar2.zzf));
                        zzlwVar.zzu.zzaW().zzj().zzc("[sgtm] Updated status for row_id", Long.valueOf(j2), zzmeVar);
                        synchronized (atomicReference2) {
                        }
                    }
                    zzlwVar.zzu.zzaW().zzk().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzpaVar2.zza), Integer.valueOf(i), th);
                    if (!Arrays.asList(((String) zzgi.zzt.zza(null)).split(",")).contains(String.valueOf(i))) {
                    }
                    atomicReference2 = atomicReference;
                    zzny zzu22 = zzlwVar.zzu.zzu();
                    long j22 = zzpaVar2.zza;
                    zzu22.zzZ(new zzag(j22, zzmeVar.zza(), zzpaVar2.zzf));
                    zzlwVar.zzu.zzaW().zzj().zzc("[sgtm] Updated status for row_id", Long.valueOf(j22), zzmeVar);
                    synchronized (atomicReference2) {
                    }
                }
            };
            zzr.zzv();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzlyVar);
            zzr.zzu.zzaX().zzp(new zzma(zzr, zzn, url, bArr, hashMap, zzlyVar));
            try {
                zzio zzioVar2 = zzioVar.zzw().zzu;
                long currentTimeMillis = zzioVar2.zzaU().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long j = 60000; atomicReference.get() == null && j > 0; j = currentTimeMillis - zzioVar2.zzaU().currentTimeMillis()) {
                        atomicReference.wait(j);
                    }
                }
            } catch (InterruptedException unused) {
                this.zzu.zzaW().zzk().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? zzme.UNKNOWN : (zzme) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e) {
            this.zzu.zzaW().zze().zzd("[sgtm] Bad upload url for row_id", zzpaVar.zzc, Long.valueOf(zzpaVar.zza), e);
            return zzme.FAILURE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzas(Boolean bool, boolean z) {
        zzg();
        zza();
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zzd().zzb("Setting app measurement enabled (FE)", bool);
        zzioVar.zzm().zzm(bool);
        if (z) {
            zzht zzm = zzioVar.zzm();
            zzio zzioVar2 = zzm.zzu;
            zzm.zzg();
            SharedPreferences.Editor edit = zzm.zzb().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzu.zzK() || !(bool == null || bool.booleanValue())) {
            zzat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzat() {
        zzg();
        zzio zzioVar = this.zzu;
        String zza = zzioVar.zzm().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zzan("app", "_npa", null, zzioVar.zzaU().currentTimeMillis());
            } else {
                zzan("app", "_npa", Long.valueOf(true != "true".equals(zza) ? 0L : 1L), zzioVar.zzaU().currentTimeMillis());
            }
        }
        if (!this.zzu.zzJ() || !this.zzc) {
            zzioVar.zzaW().zzd().zza("Updating Scion state (FE)");
            this.zzu.zzu().zzV();
        } else {
            zzioVar.zzaW().zzd().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzH();
            this.zzu.zzv().zza.zza();
            zzioVar.zzaX().zzq(new zzkw(this));
        }
    }

    public static /* synthetic */ void zzz(zzlw zzlwVar, Bundle bundle) {
        Bundle bundle2;
        int i;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            zzio zzioVar = zzlwVar.zzu;
            bundle2 = new Bundle(zzioVar.zzm().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj == null || (obj instanceof String) || (obj instanceof Long) || (obj instanceof Double)) {
                    if (zzqf.zzap(next)) {
                        zzioVar.zzaW().zzl().zzb("Invalid default event parameter name. Name", next);
                    } else if (obj == null) {
                        bundle2.remove(next);
                    } else if (zzioVar.zzw().zzaf("param", next, zzioVar.zzf().zzc(null, false), obj)) {
                        zzioVar.zzw().zzS(bundle2, next, obj);
                    }
                } else {
                    if (zzioVar.zzw().zzal(obj)) {
                        zzioVar.zzw().zzR(zzlwVar.zzv, null, 27, null, null, 0);
                    }
                    zzioVar.zzaW().zzl().zzc("Invalid default event parameter type. Name, value", next, obj);
                }
            }
            zzioVar.zzw();
            int zze = zzioVar.zzf().zze();
            if (bundle2.size() > zze) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i++;
                    if (i > zze) {
                        bundle2.remove(str);
                    }
                }
                zzioVar.zzw().zzR(zzlwVar.zzv, null, 26, null, null, 0);
                zzioVar.zzaW().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzio zzioVar2 = zzlwVar.zzu;
        zzioVar2.zzm().zzt.zzb(bundle2);
        if (!bundle.isEmpty() || zzioVar2.zzf().zzx(null, zzgi.zzbd)) {
            zzlwVar.zzu.zzu().zzT(bundle2);
        }
    }

    public final void zzH() {
        zzg();
        zza();
        if (this.zzu.zzM()) {
            zzio zzioVar = this.zzu;
            zzam zzf = zzioVar.zzf();
            zzf.zzu.zzaV();
            Boolean zzn = zzf.zzn("google_analytics_deferred_deep_link_enabled");
            if (zzn != null && zzn.booleanValue()) {
                zzioVar.zzaW().zzd().zza("Deferred Deep Link feature enabled.");
                zzioVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzko
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzlw.this.zzM();
                    }
                });
            }
            this.zzu.zzu().zzA();
            this.zzc = false;
            zzht zzm = zzioVar.zzm();
            zzm.zzg();
            String string = zzm.zzb().getString("previous_os_version", null);
            zzm.zzu.zzg().zzv();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm.zzb().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            zzioVar.zzg().zzv();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzR("auto", "_ou", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI() {
        zzg();
        zzaz zzazVar = this.zzl;
        if (zzazVar != null) {
            zzazVar.zzb();
        }
    }

    public final void zzJ(String str, String str2, Bundle bundle) {
        zzio zzioVar = this.zzu;
        long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzioVar.zzaX().zzq(new zzlg(this, bundle2));
    }

    public final void zzK() {
        zzio zzioVar = this.zzu;
        if (!(zzioVar.zzaT().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zzioVar.zzaT().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzL() {
        zzqr.zzb();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaW)) {
            if (!zzioVar.zzaX().zzu()) {
                zzioVar.zzaV();
                if (!zzaf.zza()) {
                    zza();
                    zzioVar.zzaW().zzj().zza("Getting trigger URIs (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzioVar.zzaX().zze(atomicReference, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzki
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzlw zzlwVar = zzlw.this;
                            zzlwVar.zzu.zzu().zzH(atomicReference, zzlwVar.zzu.zzm().zzi.zza());
                        }
                    });
                    final List list = (List) atomicReference.get();
                    if (list == null) {
                        zzioVar.zzaW().zze().zza("Timed out waiting for get trigger URIs");
                        return;
                    } else {
                        zzioVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkj
                            @Override // java.lang.Runnable
                            public final void run() {
                                boolean contains;
                                zzlw zzlwVar = zzlw.this;
                                zzlwVar.zzg();
                                if (Build.VERSION.SDK_INT < 30) {
                                    return;
                                }
                                List<zzov> list2 = list;
                                SparseArray zze = zzlwVar.zzu.zzm().zze();
                                for (zzov zzovVar : list2) {
                                    int i = zzovVar.zzc;
                                    contains = zze.contains(i);
                                    if (!contains || ((Long) zze.get(i)).longValue() < zzovVar.zzb) {
                                        zzlwVar.zzy().add(zzovVar);
                                    }
                                }
                                zzlwVar.zzU();
                            }
                        });
                        return;
                    }
                }
                zzioVar.zzaW().zze().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzioVar.zzaW().zze().zza("Cannot get trigger URIs from analytics worker thread");
        }
    }

    public final void zzM() {
        zzg();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzm().zzo.zzb()) {
            long zza = zzioVar.zzm().zzp.zza();
            zzioVar.zzm().zzp.zzb(1 + zza);
            zzioVar.zzf();
            if (zza >= 5) {
                zzioVar.zzaW().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzioVar.zzm().zzo.zza(true);
                return;
            } else {
                if (this.zzr == null) {
                    this.zzr = new zzld(this, this.zzu);
                }
                this.zzr.zzd(0L);
                return;
            }
        }
        zzioVar.zzaW().zzd().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzN() {
        zzoq zzoqVar;
        zzoq zzoqVar2;
        com.google.android.gms.internal.measurement.zzkm zzkmVar;
        zzg();
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zzd().zza("Handle tcf update.");
        SharedPreferences zza = zzioVar.zzm().zza();
        HashMap hashMap = new HashMap();
        zzgg zzggVar = zzgi.zzbj;
        if (((Boolean) zzggVar.zza(null)).booleanValue()) {
            int i = zzot.zzb;
            com.google.android.gms.internal.measurement.zzkl zzklVar = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            zzos zzosVar = zzos.CONSENT;
            Map.Entry zza2 = zzor.zza(zzklVar, zzosVar);
            com.google.android.gms.internal.measurement.zzkl zzklVar2 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            zzos zzosVar2 = zzos.FLEXIBLE_LEGITIMATE_INTEREST;
            ImmutableMap ofEntries = ImmutableMap.ofEntries(zza2, zzor.zza(zzklVar2, zzosVar2), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, zzosVar), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, zzosVar), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, zzosVar2), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzosVar2), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzosVar2));
            ImmutableSet of = ImmutableSet.of("CH");
            char[] cArr = new char[5];
            int zza3 = zzot.zza(zza, "IABTCF_CmpSdkID");
            int zza4 = zzot.zza(zza, "IABTCF_PolicyVersion");
            int zza5 = zzot.zza(zza, "IABTCF_gdprApplies");
            int zza6 = zzot.zza(zza, "IABTCF_PurposeOneTreatment");
            int zza7 = zzot.zza(zza, "IABTCF_EnableAdvertiserConsentMode");
            String zzb = zzot.zzb(zza, "IABTCF_PublisherCC");
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ofEntries.keySet().iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzkl zzklVar3 = (com.google.android.gms.internal.measurement.zzkl) it.next();
                String zzb2 = zzot.zzb(zza, "IABTCF_PublisherRestrictions" + zzklVar3.zza());
                if (TextUtils.isEmpty(zzb2) || zzb2.length() < 755) {
                    zzkmVar = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    int digit = Character.digit(zzb2.charAt(754), 10);
                    zzkmVar = (digit < 0 || digit > com.google.android.gms.internal.measurement.zzkm.values().length || digit == 0) ? com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_NOT_ALLOWED : digit != 1 ? digit != 2 ? com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED : com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                }
                builder.put(zzklVar3, zzkmVar);
            }
            ImmutableMap buildOrThrow = builder.buildOrThrow();
            String zzb3 = zzot.zzb(zza, "IABTCF_PurposeConsents");
            String zzb4 = zzot.zzb(zza, "IABTCF_VendorConsents");
            boolean z = !TextUtils.isEmpty(zzb4) && zzb4.length() >= 755 && zzb4.charAt(754) == '1';
            String zzb5 = zzot.zzb(zza, "IABTCF_PurposeLegitimateInterests");
            String zzb6 = zzot.zzb(zza, "IABTCF_VendorLegitimateInterests");
            boolean z2 = !TextUtils.isEmpty(zzb6) && zzb6.length() >= 755 && zzb6.charAt(754) == '1';
            cArr[0] = '2';
            zzoqVar = new zzoq(zzot.zzc(ofEntries, buildOrThrow, of, cArr, zza3, zza7, zza5, zza4, zza6, zzb, zzb3, zzb5, z, z2));
        } else {
            String zzb7 = zzot.zzb(zza, "IABTCF_VendorConsents");
            if (!"".equals(zzb7) && zzb7.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(zzb7.charAt(754)));
            }
            int zza8 = zzot.zza(zza, "IABTCF_gdprApplies");
            if (zza8 != -1) {
                hashMap.put("gdprApplies", String.valueOf(zza8));
            }
            int zza9 = zzot.zza(zza, "IABTCF_EnableAdvertiserConsentMode");
            if (zza9 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(zza9));
            }
            int zza10 = zzot.zza(zza, "IABTCF_PolicyVersion");
            if (zza10 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(zza10));
            }
            String zzb8 = zzot.zzb(zza, "IABTCF_PurposeConsents");
            if (!"".equals(zzb8)) {
                hashMap.put("PurposeConsents", zzb8);
            }
            int zza11 = zzot.zza(zza, "IABTCF_CmpSdkID");
            if (zza11 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(zza11));
            }
            zzoqVar = new zzoq(hashMap);
        }
        zzioVar.zzaW().zzj().zzb("Tcf preferences read", zzoqVar);
        if (!zzioVar.zzf().zzx(null, zzggVar)) {
            if (zzioVar.zzm().zzr(zzoqVar)) {
                Bundle zza12 = zzoqVar.zza();
                zzioVar.zzaW().zzj().zzb("Consent generated from Tcf", zza12);
                if (zza12 != Bundle.EMPTY) {
                    zzaf(zza12, -30, zzioVar.zzaU().currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", zzoqVar.zzd());
                zzR("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        zzht zzm = zzioVar.zzm();
        zzm.zzg();
        String string = zzm.zzb().getString("stored_tcf_param", "");
        HashMap hashMap2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzoqVar2 = new zzoq(hashMap2);
        } else {
            for (String str : string.split(";")) {
                String[] split = str.split("=");
                if (split.length >= 2 && zzot.zza.contains(split[0])) {
                    hashMap2.put(split[0], split[1]);
                }
            }
            zzoqVar2 = new zzoq(hashMap2);
        }
        if (zzioVar.zzm().zzr(zzoqVar)) {
            Bundle zza13 = zzoqVar.zza();
            zzioVar.zzaW().zzj().zzb("Consent generated from Tcf", zza13);
            if (zza13 != Bundle.EMPTY) {
                zzaf(zza13, -30, zzioVar.zzaU().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfm", zzoqVar.zzc(zzoqVar2));
            bundle2.putString("_tcfd2", zzoqVar.zzb());
            bundle2.putString("_tcfd", zzoqVar.zzd());
            zzR("auto", "_tcf", bundle2);
        }
    }

    public final void zzO(String str, String str2, Bundle bundle) {
        zzP(str, str2, bundle, true, true, this.zzu.zzaU().currentTimeMillis());
    }

    public final void zzP(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.zzu.zzt().zzy(bundle2, j);
            return;
        }
        boolean z3 = true;
        if (z2 && this.zzd != null && !zzqf.zzap(str2)) {
            z3 = false;
        }
        zzZ(str == null ? "app" : str, str2, j, bundle2, z2, z3, z, null);
    }

    public final void zzQ(String str, String str2, Bundle bundle, String str3) {
        zzio.zzP();
        zzZ("auto", str2, this.zzu.zzaU().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzR(String str, String str2, Bundle bundle) {
        zzg();
        zzS(str, str2, this.zzu.zzaU().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzS(String str, String str2, long j, Bundle bundle) {
        zzg();
        zzT(str, str2, j, bundle, true, this.zzd == null || zzqf.zzap(str2), true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzT(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        boolean zzb;
        Bundle bundle2;
        String str4;
        ArrayList arrayList;
        long j2;
        Bundle[] bundleArr;
        int i;
        Class<?> cls;
        String str5 = str;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzJ()) {
            List zzp = this.zzu.zzh().zzp();
            if (zzp == null || zzp.contains(str2)) {
                if (!this.zzf) {
                    this.zzf = true;
                    try {
                        if (zzioVar.zzN()) {
                            cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                        } else {
                            cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzu.zzaT().getClassLoader());
                        }
                        try {
                            cls.getDeclaredMethod("initialize", Context.class).invoke(null, this.zzu.zzaT());
                        } catch (Exception e) {
                            this.zzu.zzaW().zzk().zzb("Failed to invoke Tag Manager's initialize() method", e);
                        }
                    } catch (ClassNotFoundException unused) {
                        this.zzu.zzaW().zzi().zza("Tag Manager is not found and thus will not be used");
                    }
                }
                if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
                    zzio zzioVar2 = this.zzu;
                    zzioVar2.zzaV();
                    zzan("auto", "_lgclid", bundle.getString("gclid"), zzioVar2.zzaU().currentTimeMillis());
                }
                zzio zzioVar3 = this.zzu;
                zzioVar3.zzaV();
                if (z && zzqf.zzau(str2)) {
                    zzioVar3.zzw().zzO(bundle, zzioVar3.zzm().zzt.zza());
                }
                if (!z3) {
                    zzioVar3.zzaV();
                    if (!"_iap".equals(str2)) {
                        zzio zzioVar4 = this.zzu;
                        zzqf zzw = zzioVar4.zzw();
                        if (zzw.zzah(NotificationCompat.CATEGORY_EVENT, str2)) {
                            if (zzw.zzae(NotificationCompat.CATEGORY_EVENT, zzjy.zza, zzjy.zzb, str2)) {
                                zzw.zzu.zzf();
                                if (zzw.zzad(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                                    i = 0;
                                }
                            } else {
                                i = 13;
                            }
                            if (i != 0) {
                                zzioVar3.zzaW().zzf().zzb("Invalid public event name. Event will not be logged (FE)", zzioVar3.zzj().zzd(str2));
                                zzqf zzw2 = zzioVar4.zzw();
                                zzioVar4.zzf();
                                zzioVar4.zzw().zzR(this.zzv, null, i, "_ev", zzw2.zzG(str2, 40, true), str2 != null ? str2.length() : 0);
                                return;
                            }
                        }
                        i = 2;
                        if (i != 0) {
                        }
                    }
                }
                zzioVar3.zzaV();
                zzio zzioVar5 = this.zzu;
                zzmh zzj = zzioVar5.zzt().zzj(false);
                if (zzj != null && !bundle.containsKey("_sc")) {
                    zzj.zzd = true;
                }
                zzqf.zzN(zzj, bundle, z && !z3);
                boolean equals = "am".equals(str5);
                boolean zzap = zzqf.zzap(str2);
                if (!z || this.zzd == null || zzap) {
                    z4 = equals;
                } else {
                    if (!equals) {
                        zzioVar3.zzaW().zzd().zzc("Passing event to registered event handler (FE)", zzioVar3.zzj().zzd(str2), zzioVar3.zzj().zzb(bundle));
                        Preconditions.checkNotNull(this.zzd);
                        this.zzd.interceptEvent(str, str2, bundle, j);
                        return;
                    }
                    z4 = true;
                }
                zzio zzioVar6 = this.zzu;
                if (zzioVar6.zzM()) {
                    int zzf = zzioVar3.zzw().zzf(str2);
                    if (zzf != 0) {
                        zzioVar3.zzaW().zzf().zzb("Invalid event name. Event will not be logged (FE)", zzioVar3.zzj().zzd(str2));
                        zzqf zzw3 = zzioVar3.zzw();
                        zzioVar3.zzf();
                        zzioVar6.zzw().zzR(this.zzv, str3, zzf, "_ev", zzw3.zzG(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                    String str6 = "_o";
                    Bundle zzA = zzioVar3.zzw().zzA(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
                    Preconditions.checkNotNull(zzA);
                    zzioVar3.zzaV();
                    if (zzioVar5.zzt().zzj(false) != null && "_ae".equals(str2)) {
                        zzon zzonVar = zzioVar5.zzv().zzb;
                        long elapsedRealtime = zzonVar.zzc.zzu.zzaU().elapsedRealtime();
                        long j3 = elapsedRealtime - zzonVar.zzb;
                        zzonVar.zzb = elapsedRealtime;
                        if (j3 > 0) {
                            zzioVar3.zzw().zzL(zzA, j3);
                        }
                    }
                    if ("auto".equals(str5) || !"_ssr".equals(str2)) {
                        if ("_ae".equals(str2)) {
                            String zza = zzioVar3.zzw().zzu.zzm().zzq.zza();
                            if (!TextUtils.isEmpty(zza)) {
                                zzA.putString("_ffr", zza);
                            }
                        }
                    } else {
                        zzqf zzw4 = zzioVar3.zzw();
                        String string = zzA.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            string = null;
                        } else if (string != null) {
                            string = string.trim();
                        }
                        zzio zzioVar7 = zzw4.zzu;
                        if (!Objects.equals(string, zzioVar7.zzm().zzq.zza())) {
                            zzioVar7.zzm().zzq.zzb(string);
                        } else {
                            zzioVar7.zzaW().zzd().zza("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(zzA);
                    if (!zzioVar3.zzf().zzx(null, zzgi.zzba)) {
                        zzb = zzioVar3.zzm().zzn.zzb();
                    } else {
                        zzb = zzioVar5.zzv().zzp();
                    }
                    if (zzioVar3.zzm().zzk.zza() > 0 && zzioVar3.zzm().zzp(j) && zzb) {
                        zzioVar3.zzaW().zzj().zza("Current session is expired, remove the session number, ID, and engagement time");
                        arrayList = arrayList2;
                        j2 = 0;
                        bundle2 = zzA;
                        str4 = "_ae";
                        zzan("auto", "_sid", null, zzioVar3.zzaU().currentTimeMillis());
                        zzan("auto", "_sno", null, zzioVar3.zzaU().currentTimeMillis());
                        zzan("auto", "_se", null, zzioVar3.zzaU().currentTimeMillis());
                        zzioVar3.zzm().zzl.zzb(0L);
                    } else {
                        bundle2 = zzA;
                        str4 = "_ae";
                        arrayList = arrayList2;
                        j2 = 0;
                    }
                    if (bundle2.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                        zzioVar3.zzaW().zzj().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                        zzioVar6.zzv().zza.zzb(j, true);
                    }
                    ArrayList arrayList3 = new ArrayList(bundle2.keySet());
                    Collections.sort(arrayList3);
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str7 = (String) arrayList3.get(i2);
                        if (str7 != null) {
                            zzioVar3.zzw();
                            Object obj = bundle2.get(str7);
                            if (obj instanceof Bundle) {
                                bundleArr = new Bundle[]{(Bundle) obj};
                            } else if (obj instanceof Parcelable[]) {
                                Parcelable[] parcelableArr = (Parcelable[]) obj;
                                bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                            } else if (obj instanceof ArrayList) {
                                ArrayList arrayList4 = (ArrayList) obj;
                                bundleArr = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                            } else {
                                bundleArr = null;
                            }
                            if (bundleArr != null) {
                                bundle2.putParcelableArray(str7, bundleArr);
                            }
                        }
                    }
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        ArrayList arrayList5 = arrayList;
                        Bundle bundle3 = (Bundle) arrayList5.get(i3);
                        String str8 = i3 != 0 ? "_ep" : str2;
                        String str9 = str6;
                        bundle3.putString(str9, str5);
                        if (z2) {
                            bundle3 = zzioVar3.zzw().zzz(bundle3, null);
                        }
                        Bundle bundle4 = bundle3;
                        zzioVar5.zzu().zzM(new zzbh(str8, new zzbf(bundle4), str, j), str3);
                        if (!z4) {
                            Iterator it = this.zze.iterator();
                            while (it.hasNext()) {
                                ((zzkc) it.next()).onEvent(str, str2, new Bundle(bundle4), j);
                            }
                        }
                        i3++;
                        str5 = str;
                        arrayList = arrayList5;
                        str6 = str9;
                    }
                    zzioVar3.zzaV();
                    if (zzioVar5.zzt().zzj(false) == null || !str4.equals(str2)) {
                        return;
                    }
                    zzioVar5.zzv().zzb.zzd(true, true, zzioVar3.zzaU().elapsedRealtime());
                    return;
                }
                return;
            }
            this.zzu.zzaW().zzd().zzc("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        this.zzu.zzaW().zzd().zza("Event not sent since app measurement is disabled");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzU() {
        zzov zzovVar;
        zzg();
        this.zzn = false;
        if (zzy().isEmpty() || this.zzi || (zzovVar = (zzov) zzy().poll()) == null) {
            return;
        }
        zzio zzioVar = this.zzu;
        MeasurementManagerFutures zzB = zzioVar.zzw().zzB();
        if (zzB != null) {
            this.zzi = true;
            zzhc zzj = zzioVar.zzaW().zzj();
            String str = zzovVar.zza;
            zzj.zzb("Registering trigger URI", str);
            ListenableFuture<Unit> registerTriggerAsync = zzB.registerTriggerAsync(Uri.parse(str));
            if (registerTriggerAsync == null) {
                this.zzi = false;
                zzy().add(zzovVar);
            } else {
                Futures.addCallback(registerTriggerAsync, new zzkt(this, zzovVar), new zzks(this));
            }
        }
    }

    public final void zzV(zzkc zzkcVar) {
        zza();
        Preconditions.checkNotNull(zzkcVar);
        if (this.zze.add(zzkcVar)) {
            return;
        }
        this.zzu.zzaW().zzk().zza("OnEventListener already registered");
    }

    public final void zzW() {
        zzg();
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zzd().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzky(this, this.zzu);
            this.zzs = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzkp
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzlw.zzA(zzlw.this, sharedPreferences, str);
                }
            };
        }
        zzioVar.zzm().zza().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    public final void zzX(long j) {
        this.zzg.set(null);
        this.zzu.zzaX().zzq(new zzle(this, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzY(Runnable runnable) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaR)) {
            zza();
            if (!zzioVar.zzaX().zzu()) {
                if (!zzioVar.zzaX().zzt()) {
                    zzioVar.zzaV();
                    if (!zzaf.zza()) {
                        zzioVar.zzaW().zzj().zza("[sgtm] Started client-side batch upload work.");
                        boolean z = false;
                        int i = 0;
                        int i2 = 0;
                        while (!z) {
                            zzioVar.zzaW().zzj().zza("[sgtm] Getting upload batches from service (FE)");
                            final AtomicReference atomicReference = new AtomicReference();
                            zzioVar.zzaX().zze(atomicReference, Renderer.DEFAULT_DURATION_TO_PROGRESS_US, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkl
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzlw.this.zzu.zzu().zzI(atomicReference, zzpc.zza(zzmf.SGTM_CLIENT));
                                }
                            });
                            zzpe zzpeVar = (zzpe) atomicReference.get();
                            if (zzpeVar == null) {
                                break;
                            }
                            List list = zzpeVar.zza;
                            if (!list.isEmpty()) {
                                zzioVar.zzaW().zzj().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                                i += list.size();
                                Iterator it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    zzme zzar = zzar((zzpa) it.next());
                                    if (zzar == zzme.SUCCESS) {
                                        i2++;
                                    } else if (zzar == zzme.BACKOFF) {
                                        z = true;
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        zzioVar.zzaW().zzj().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i), Integer.valueOf(i2));
                        runnable.run();
                        return;
                    }
                    zzioVar.zzaW().zze().zza("Cannot retrieve and upload batches from main thread");
                    return;
                }
                zzioVar.zzaW().zze().zza("Cannot retrieve and upload batches from analytics network thread");
                return;
            }
            zzioVar.zzaW().zze().zza("Cannot retrieve and upload batches from analytics worker thread");
        }
    }

    protected final void zzZ(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i = zzqf.zza;
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i2];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelable);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        this.zzu.zzaX().zzq(new zzkz(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    final void zzaa(String str, String str2, long j, Object obj) {
        this.zzu.zzaX().zzq(new zzla(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzab(long j) {
        zzg();
        if (this.zzl == null) {
            this.zzl = new zzkr(this, this.zzu);
        }
        this.zzl.zzd(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzac(String str) {
        this.zzg.set(str);
    }

    public final void zzad(Bundle bundle) {
        zzae(bundle, this.zzu.zzaU().currentTimeMillis());
    }

    public final void zzae(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzu.zzaW().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjt.zza(bundle2, "app_id", String.class, null);
        zzjt.zza(bundle2, "origin", String.class, null);
        zzjt.zza(bundle2, "name", String.class, null);
        zzjt.zza(bundle2, "value", Object.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzio zzioVar = this.zzu;
        if (zzioVar.zzw().zzj(string) == 0) {
            if (zzioVar.zzw().zzd(string, obj) == 0) {
                Object zzE = zzioVar.zzw().zzE(string, obj);
                if (zzE == null) {
                    zzioVar.zzaW().zze().zzc("Unable to normalize conditional user property value", zzioVar.zzj().zzf(string), obj);
                    return;
                }
                zzjt.zzb(bundle2, zzE);
                long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    zzioVar.zzf();
                    if (j2 > 15552000000L || j2 < 1) {
                        zzioVar.zzaW().zze().zzc("Invalid conditional user property timeout", zzioVar.zzj().zzf(string), Long.valueOf(j2));
                        return;
                    }
                }
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                zzioVar.zzf();
                if (j3 > 15552000000L || j3 < 1) {
                    zzioVar.zzaW().zze().zzc("Invalid conditional user property time to live", zzioVar.zzj().zzf(string), Long.valueOf(j3));
                    return;
                } else {
                    zzioVar.zzaX().zzq(new zzlf(this, bundle2));
                    return;
                }
            }
            zzioVar.zzaW().zze().zzc("Invalid conditional user property value", zzioVar.zzj().zzf(string), obj);
            return;
        }
        zzioVar.zzaW().zze().zzb("Invalid conditional user property name", zzioVar.zzj().zzf(string));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaf(Bundle bundle, int i, long j) {
        zzjw[] zzjwVarArr;
        Object obj;
        String string;
        zza();
        zzjx zzjxVar = zzjx.zza;
        zzjwVarArr = zzjv.STORAGE.zzd;
        int length = zzjwVarArr.length;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= length) {
                break;
            }
            String str = zzjwVarArr[i2].zze;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i2++;
        }
        if (obj != null) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzl().zzb("Ignoring invalid consent setting", obj);
            zzioVar.zzaW().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zzu = this.zzu.zzaX().zzu();
        zzjx zzi = zzjx.zzi(bundle, i);
        if (zzi.zzt()) {
            zzak(zzi, zzu);
        }
        zzba zzc = zzba.zzc(bundle, i);
        if (zzc.zzk()) {
            zzag(zzc, zzu);
        }
        Boolean zzg = zzba.zzg(bundle);
        if (zzg != null) {
            String str2 = i == -30 ? "tcf" : "app";
            if (zzu) {
                zzan(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzg.toString(), j);
            } else {
                zzam(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzg.toString(), false, j);
            }
        }
    }

    public final void zzah(zzkb zzkbVar) {
        zzkb zzkbVar2;
        zzg();
        zza();
        if (zzkbVar != null && zzkbVar != (zzkbVar2 = this.zzd)) {
            Preconditions.checkState(zzkbVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzkbVar;
    }

    public final void zzai(Boolean bool) {
        zza();
        this.zzu.zzaX().zzq(new zzlp(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaj(zzjx zzjxVar) {
        zzg();
        boolean z = (zzjxVar.zzr(zzjw.ANALYTICS_STORAGE) && zzjxVar.zzr(zzjw.AD_STORAGE)) || this.zzu.zzu().zzab();
        zzio zzioVar = this.zzu;
        if (z != zzioVar.zzK()) {
            zzioVar.zzG(z);
            zzht zzm = this.zzu.zzm();
            zzio zzioVar2 = zzm.zzu;
            zzm.zzg();
            Boolean valueOf = zzm.zzb().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzm.zzb().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzas(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzak(zzjx zzjxVar, boolean z) {
        boolean z2;
        zzjx zzjxVar2;
        boolean z3;
        boolean z4;
        zza();
        int zzb = zzjxVar.zzb();
        if (zzb == -10 || zzjxVar.zze() != zzju.UNINITIALIZED || zzjxVar.zzf() != zzju.UNINITIALIZED) {
            synchronized (this.zzh) {
                z2 = false;
                if (zzjx.zzs(zzb, this.zzo.zzb())) {
                    z3 = zzjxVar.zzu(this.zzo);
                    zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                    if (zzjxVar.zzr(zzjwVar) && !this.zzo.zzr(zzjwVar)) {
                        z2 = true;
                    }
                    zzjx zzm = zzjxVar.zzm(this.zzo);
                    this.zzo = zzm;
                    zzjxVar2 = zzm;
                    z4 = z2;
                    z2 = true;
                } else {
                    zzjxVar2 = zzjxVar;
                    z3 = false;
                    z4 = false;
                }
            }
            if (!z2) {
                this.zzu.zzaW().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjxVar2);
                return;
            }
            long andIncrement = this.zzp.getAndIncrement();
            if (z3) {
                this.zzg.set(null);
                zzlr zzlrVar = new zzlr(this, zzjxVar2, andIncrement, z4);
                if (!z) {
                    this.zzu.zzaX().zzr(zzlrVar);
                    return;
                } else {
                    zzg();
                    zzlrVar.run();
                    return;
                }
            }
            zzls zzlsVar = new zzls(this, zzjxVar2, andIncrement, z4);
            if (z) {
                zzg();
                zzlsVar.run();
                return;
            } else if (zzb == 30 || zzb == -10) {
                this.zzu.zzaX().zzr(zzlsVar);
                return;
            } else {
                this.zzu.zzaX().zzq(zzlsVar);
                return;
            }
        }
        this.zzu.zzaW().zzl().zza("Ignoring empty consent settings");
    }

    public final void zzal(String str, String str2, Object obj, boolean z) {
        zzam(str, str2, obj, z, this.zzu.zzaU().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzan(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zza();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    long j2 = true != "false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 0L : 1L;
                    zzio zzioVar = this.zzu;
                    Long valueOf = Long.valueOf(j2);
                    zzioVar.zzm().zzh.zzb(valueOf.longValue() == 1 ? "true" : "false");
                    obj = valueOf;
                    str2 = "_npa";
                    this.zzu.zzaW().zzj().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                this.zzu.zzm().zzh.zzb("unset");
                str2 = "_npa";
            }
            this.zzu.zzaW().zzj().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        zzio zzioVar2 = this.zzu;
        if (!zzioVar2.zzJ()) {
            this.zzu.zzaW().zzj().zza("User property not set since app measurement is disabled");
        } else if (zzioVar2.zzM()) {
            this.zzu.zzu().zzY(new zzqb(str4, j, obj2, str));
        }
    }

    public final void zzao(zzkc zzkcVar) {
        zza();
        Preconditions.checkNotNull(zzkcVar);
        if (this.zze.remove(zzkcVar)) {
            return;
        }
        this.zzu.zzaW().zzk().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzap() {
        return this.zzn;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return false;
    }

    public final int zzi(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzf();
        return 25;
    }

    public final Boolean zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaX().zze(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "boolean test flag value", new zzlb(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaX().zze(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "double test flag value", new zzlo(this, atomicReference));
    }

    public final Integer zzp() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaX().zze(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "int test flag value", new zzln(this, atomicReference));
    }

    public final Long zzq() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaX().zze(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "long test flag value", new zzlm(this, atomicReference));
    }

    public final String zzr() {
        return (String) this.zzg.get();
    }

    public final String zzs() {
        zzmh zzi = this.zzu.zzt().zzi();
        if (zzi != null) {
            return zzi.zzb;
        }
        return null;
    }

    public final String zzt() {
        zzmh zzi = this.zzu.zzt().zzi();
        if (zzi != null) {
            return zzi.zza;
        }
        return null;
    }

    public final String zzu() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaX().zze(atomicReference, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "String test flag value", new zzll(this, atomicReference));
    }

    public final ArrayList zzv(String str, String str2) {
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzaX().zzu()) {
            zzioVar.zzaV();
            if (zzaf.zza()) {
                zzioVar.zzaW().zze().zza("Cannot get conditional user properties from main thread");
                return new ArrayList(0);
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zze(atomicReference, 5000L, "get conditional user properties", new zzlh(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzioVar.zzaW().zze().zzb("Timed out waiting for get conditional user properties", null);
                return new ArrayList();
            }
            return zzqf.zzK(list);
        }
        zzioVar.zzaW().zze().zza("Cannot get conditional user properties from analytics worker thread");
        return new ArrayList(0);
    }

    public final List zzw(boolean z) {
        zza();
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zzj().zza("Getting user properties (FE)");
        if (!zzioVar.zzaX().zzu()) {
            zzioVar.zzaV();
            if (zzaf.zza()) {
                zzioVar.zzaW().zze().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zze(atomicReference, 5000L, "get user properties", new zzlc(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzioVar.zzaW().zze().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        zzioVar.zzaW().zze().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzx(String str, String str2, boolean z) {
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzaX().zzu()) {
            zzioVar.zzaV();
            if (zzaf.zza()) {
                zzioVar.zzaW().zze().zza("Cannot get user properties from main thread");
                return Collections.emptyMap();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zze(atomicReference, 5000L, "get user properties", new zzli(this, atomicReference, null, str, str2, z));
            List<zzqb> list = (List) atomicReference.get();
            if (list == null) {
                zzioVar.zzaW().zze().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzqb zzqbVar : list) {
                Object zza = zzqbVar.zza();
                if (zza != null) {
                    arrayMap.put(zzqbVar.zzb, zza);
                }
            }
            return arrayMap;
        }
        zzioVar.zzaW().zze().zza("Cannot get user properties from analytics worker thread");
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PriorityQueue zzy() {
        if (this.zzm == null) {
            this.zzm = new PriorityQueue(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzkf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzov) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzkh
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzag(zzba zzbaVar, boolean z) {
        zzlq zzlqVar = new zzlq(this, zzbaVar);
        if (!z) {
            this.zzu.zzaX().zzq(zzlqVar);
        } else {
            zzg();
            zzlqVar.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzam(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        if (!z) {
            zzqf zzw = this.zzu.zzw();
            if (zzw.zzah("user property", str2)) {
                if (zzw.zzae("user property", zzka.zza, null, str2)) {
                    zzw.zzu.zzf();
                    if (zzw.zzad("user property", 24, str2)) {
                        i = 0;
                        if (i != 0) {
                            zzio zzioVar = this.zzu;
                            zzqf zzw2 = zzioVar.zzw();
                            zzioVar.zzf();
                            this.zzu.zzw().zzR(this.zzv, null, i, "_ev", zzw2.zzG(str2, 24, true), str2 != null ? str2.length() : 0);
                            return;
                        }
                        String str3 = str == null ? "app" : str;
                        if (obj != null) {
                            zzio zzioVar2 = this.zzu;
                            int zzd = zzioVar2.zzw().zzd(str2, obj);
                            if (zzd == 0) {
                                Object zzE = zzioVar2.zzw().zzE(str2, obj);
                                if (zzE != null) {
                                    zzaa(str3, str2, j, zzE);
                                    return;
                                }
                                return;
                            }
                            zzqf zzw3 = zzioVar2.zzw();
                            zzioVar2.zzf();
                            this.zzu.zzw().zzR(this.zzv, null, zzd, "_ev", zzw3.zzG(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
                            return;
                        }
                        zzaa(str3, str2, j, null);
                        return;
                    }
                } else {
                    i2 = 15;
                }
            }
            i = 6;
            if (i != 0) {
            }
        } else {
            i2 = this.zzu.zzw().zzj(str2);
        }
        i = i2;
        if (i != 0) {
        }
    }
}
