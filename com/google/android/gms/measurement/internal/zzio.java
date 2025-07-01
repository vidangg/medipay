package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.DefaultLoadControl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzio implements zzjs {
    private static volatile zzio zzb;
    private Boolean zzB;
    private long zzC;
    private volatile Boolean zzD;
    private volatile boolean zzE;
    private int zzF;
    private int zzG;
    final long zza;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzaf zzh;
    private final zzam zzi;
    private final zzht zzj;
    private final zzhe zzk;
    private final zzil zzl;
    private final zzop zzm;
    private final zzqf zzn;
    private final zzgx zzo;
    private final Clock zzp;
    private final zzmo zzq;
    private final zzlw zzr;
    private final zzd zzs;
    private final zzmb zzt;
    private final String zzu;
    private zzgv zzv;
    private zzny zzw;
    private zzbb zzx;
    private zzgs zzy;
    private zzmd zzz;
    private boolean zzA = false;
    private final AtomicInteger zzH = new AtomicInteger(0);

    zzio(zzke zzkeVar) {
        long currentTimeMillis;
        Preconditions.checkNotNull(zzkeVar);
        Context context = zzkeVar.zza;
        zzaf zzafVar = new zzaf(context);
        this.zzh = zzafVar;
        zzgf.zza = zzafVar;
        this.zzc = context;
        this.zzd = zzkeVar.zzb;
        this.zze = zzkeVar.zzc;
        this.zzf = zzkeVar.zzd;
        this.zzg = zzkeVar.zzh;
        this.zzD = zzkeVar.zze;
        this.zzu = zzkeVar.zzj;
        this.zzE = true;
        com.google.android.gms.internal.measurement.zzki.zzd(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        Long l = zzkeVar.zzi;
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = currentTimeMillis;
        this.zzi = new zzam(this);
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzw();
        this.zzj = zzhtVar;
        zzhe zzheVar = new zzhe(this);
        zzheVar.zzw();
        this.zzk = zzheVar;
        zzqf zzqfVar = new zzqf(this);
        zzqfVar.zzw();
        this.zzn = zzqfVar;
        this.zzo = new zzgx(new zzkd(zzkeVar, this));
        this.zzs = new zzd(this);
        zzmo zzmoVar = new zzmo(this);
        zzmoVar.zzb();
        this.zzq = zzmoVar;
        zzlw zzlwVar = new zzlw(this);
        zzlwVar.zzb();
        this.zzr = zzlwVar;
        zzop zzopVar = new zzop(this);
        zzopVar.zzb();
        this.zzm = zzopVar;
        zzmb zzmbVar = new zzmb(this);
        zzmbVar.zzw();
        this.zzt = zzmbVar;
        zzil zzilVar = new zzil(this);
        zzilVar.zzw();
        this.zzl = zzilVar;
        com.google.android.gms.internal.measurement.zzdh zzdhVar = zzkeVar.zzg;
        boolean z = zzdhVar == null || zzdhVar.zzb == 0;
        if (!(context.getApplicationContext() instanceof Application)) {
            zzT(zzheVar);
            zzheVar.zzk().zza("Application context is not an Application");
        } else {
            zzS(zzlwVar);
            if (zzlwVar.zzu.zzc.getApplicationContext() instanceof Application) {
                Application application = (Application) zzlwVar.zzu.zzc.getApplicationContext();
                if (zzlwVar.zza == null) {
                    zzlwVar.zza = new zzlv(zzlwVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzlwVar.zza);
                    application.registerActivityLifecycleCallbacks(zzlwVar.zza);
                    zzhe zzheVar2 = zzlwVar.zzu.zzk;
                    zzT(zzheVar2);
                    zzheVar2.zzj().zza("Registered activity lifecycle callback");
                }
            }
        }
        zzilVar.zzq(new zzin(this, zzkeVar));
    }

    public static /* synthetic */ void zzB(zzio zzioVar, String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        if (i == 200 || i == 204) {
            i2 = i;
        } else {
            i2 = 304;
            if (i != 304) {
                i2 = i;
                zzhe zzheVar = zzioVar.zzk;
                zzT(zzheVar);
                zzheVar.zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            }
        }
        if (th == null) {
            zzht zzhtVar = zzioVar.zzj;
            zzR(zzhtVar);
            zzhtVar.zzo.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzhe zzheVar2 = zzioVar.zzk;
                zzT(zzheVar2);
                zzheVar2.zzd().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                if (TextUtils.isEmpty(optString)) {
                    zzhe zzheVar3 = zzioVar.zzk;
                    zzT(zzheVar3);
                    zzheVar3.zzd().zza("Deferred Deep Link is empty.");
                    return;
                }
                String optString2 = jSONObject.optString("gclid", "");
                String optString3 = jSONObject.optString("gbraid", "");
                String optString4 = jSONObject.optString("gad_source", "");
                double optDouble = jSONObject.optDouble("timestamp", AudioStats.AUDIO_AMPLITUDE_NONE);
                Bundle bundle2 = new Bundle();
                zzqf zzqfVar = zzioVar.zzn;
                zzR(zzqfVar);
                zzio zzioVar2 = zzqfVar.zzu;
                if (!TextUtils.isEmpty(optString)) {
                    Context context = zzioVar2.zzc;
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(optString3)) {
                            bundle2.putString("gbraid", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            bundle2.putString("gad_source", optString4);
                        }
                        bundle2.putString("gclid", optString2);
                        bundle2.putString("_cis", "ddp");
                        zzioVar.zzr.zzR("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle2);
                        zzR(zzqfVar);
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            edit.putString("deeplink", optString);
                            edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                            if (edit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = zzqfVar.zzu.zzc;
                                if (Build.VERSION.SDK_INT < 34) {
                                    context2.sendBroadcast(intent);
                                    return;
                                }
                                makeBasic = BroadcastOptions.makeBasic();
                                shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
                                bundle = shareIdentityEnabled.toBundle();
                                context2.sendBroadcast(intent, null, bundle);
                                return;
                            }
                            return;
                        } catch (RuntimeException e) {
                            zzhe zzheVar4 = zzqfVar.zzu.zzk;
                            zzT(zzheVar4);
                            zzheVar4.zze().zzb("Failed to persist Deferred Deep Link. exception", e);
                            return;
                        }
                    }
                }
                zzhe zzheVar5 = zzioVar.zzk;
                zzT(zzheVar5);
                zzheVar5.zzk().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                return;
            } catch (JSONException e2) {
                zzhe zzheVar6 = zzioVar.zzk;
                zzT(zzheVar6);
                zzheVar6.zze().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzhe zzheVar7 = zzioVar.zzk;
        zzT(zzheVar7);
        zzheVar7.zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzC(zzio zzioVar, zzke zzkeVar) {
        zzil zzilVar = zzioVar.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzam zzamVar = zzioVar.zzi;
        zzamVar.zzq();
        zzbb zzbbVar = new zzbb(zzioVar);
        zzbbVar.zzw();
        zzioVar.zzx = zzbbVar;
        com.google.android.gms.internal.measurement.zzdh zzdhVar = zzkeVar.zzg;
        zzgs zzgsVar = new zzgs(zzioVar, zzkeVar.zzf, zzdhVar == null ? 0L : zzdhVar.zza);
        zzgsVar.zzb();
        zzioVar.zzy = zzgsVar;
        zzgv zzgvVar = new zzgv(zzioVar);
        zzgvVar.zzb();
        zzioVar.zzv = zzgvVar;
        zzny zznyVar = new zzny(zzioVar);
        zznyVar.zzb();
        zzioVar.zzw = zznyVar;
        zzqf zzqfVar = zzioVar.zzn;
        zzqfVar.zzx();
        zzioVar.zzj.zzx();
        zzioVar.zzy.zzc();
        zzmd zzmdVar = new zzmd(zzioVar);
        zzmdVar.zzb();
        zzioVar.zzz = zzmdVar;
        zzmdVar.zzc();
        zzhe zzheVar = zzioVar.zzk;
        zzT(zzheVar);
        zzhc zzi = zzheVar.zzi();
        zzamVar.zzj();
        zzi.zzb("App measurement initialized, version", 119002L);
        zzT(zzheVar);
        zzheVar.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzm = zzgsVar.zzm();
        if (TextUtils.isEmpty(zzioVar.zzd)) {
            zzR(zzqfVar);
            if (!zzqfVar.zzak(zzm, zzamVar.zzs())) {
                zzT(zzheVar);
                zzheVar.zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzm)));
            } else {
                zzT(zzheVar);
                zzheVar.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            }
        }
        zzT(zzheVar);
        zzheVar.zzd().zza("Debug-level message logging enabled");
        int i = zzioVar.zzF;
        AtomicInteger atomicInteger = zzioVar.zzH;
        if (i != atomicInteger.get()) {
            zzT(zzheVar);
            zzheVar.zze().zzc("Not all components initialized", Integer.valueOf(zzioVar.zzF), Integer.valueOf(atomicInteger.get()));
        }
        zzioVar.zzA = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzP() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzQ(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzR(zzjq zzjqVar) {
        if (zzjqVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzS(zzg zzgVar) {
        if (zzgVar != null) {
            if (!zzgVar.zze()) {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzgVar.getClass()))));
            }
            return;
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void zzT(zzjr zzjrVar) {
        if (zzjrVar != null) {
            if (!zzjrVar.zzy()) {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzjrVar.getClass()))));
            }
            return;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzio zzp(Context context, com.google.android.gms.internal.measurement.zzdh zzdhVar, Long l) {
        Bundle bundle;
        if (zzdhVar != null && (zzdhVar.zze == null || zzdhVar.zzf == null)) {
            zzdhVar = new com.google.android.gms.internal.measurement.zzdh(zzdhVar.zza, zzdhVar.zzb, zzdhVar.zzc, zzdhVar.zzd, null, null, zzdhVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzio.class) {
                if (zzb == null) {
                    zzb = new zzio(new zzke(context, zzdhVar, l));
                }
            }
        } else if (zzdhVar != null && (bundle = zzdhVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zzD = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    @Pure
    public final String zzA() {
        return this.zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD() {
        this.zzH.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE() {
        this.zzF++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(boolean z) {
        this.zzD = Boolean.valueOf(z);
    }

    public final void zzG(boolean z) {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        this.zzE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x011a, code lost:
    
        if (r6.zzt() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (r6.zzan() == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzH(com.google.android.gms.internal.measurement.zzdh zzdhVar) {
        zzjx zzj;
        zzlw zzlwVar;
        zzju zzm;
        zzju zzm2;
        Bundle bundle;
        Boolean zzg;
        Bundle bundle2;
        zzba zzc;
        Boolean zzn;
        zzhp zzhpVar;
        boolean zzaw;
        Bundle bundle3;
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzgg zzggVar = zzgi.zzaR;
        zzam zzamVar = this.zzi;
        boolean z = zzamVar.zzx(null, zzggVar) && zzs().zzi() == com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE;
        zzqr.zzb();
        if (zzamVar.zzx(null, zzgi.zzaW)) {
            zzqf zzqfVar = this.zzn;
            zzR(zzqfVar);
        }
        if (z) {
            z = true;
            zzqf zzqfVar2 = this.zzn;
            zzR(zzqfVar2);
            zzqfVar2.zzg();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            zzio zzioVar = zzqfVar2.zzu;
            if (zzioVar.zzi.zzx(null, zzggVar)) {
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            }
            ContextCompat.registerReceiver(zzioVar.zzc, new zzw(zzqfVar2.zzu), intentFilter, 2);
            zzhe zzheVar = zzioVar.zzk;
            zzT(zzheVar);
            zzheVar.zzd().zza("Registered app receiver");
            if (z) {
                zzs().zzj(((Long) zzgi.zzB.zza(null)).longValue());
            }
        }
        zzht zzhtVar = this.zzj;
        zzR(zzhtVar);
        zzjx zzh = zzhtVar.zzh();
        int zzb2 = zzh.zzb();
        zzju zzm3 = zzamVar.zzm("google_analytics_default_allow_ad_storage", false);
        zzju zzm4 = zzamVar.zzm("google_analytics_default_allow_analytics_storage", false);
        zzju zzjuVar = zzju.UNINITIALIZED;
        if (zzm3 != zzjuVar || zzm4 != zzju.UNINITIALIZED) {
            zzR(zzhtVar);
            if (zzhtVar.zzq(-10)) {
                zzj = zzjx.zzj(zzm3, zzm4, -10);
                if (zzj != null) {
                    zzlw zzlwVar2 = this.zzr;
                    zzS(zzlwVar2);
                    zzlwVar2.zzak(zzj, true);
                    zzh = zzj;
                }
                zzlwVar = this.zzr;
                zzS(zzlwVar);
                zzlwVar.zzaj(zzh);
                zzR(zzhtVar);
                int zza = zzhtVar.zzf().zza();
                zzm = zzamVar.zzm("google_analytics_default_allow_ad_personalization_signals", true);
                if (zzm != zzjuVar) {
                    zzhe zzheVar2 = this.zzk;
                    zzT(zzheVar2);
                    zzheVar2.zzj().zzb("Default ad personalization consent from Manifest", zzm);
                }
                zzm2 = zzamVar.zzm("google_analytics_default_allow_ad_user_data", true);
                if (zzm2 != zzju.UNINITIALIZED || !zzjx.zzs(-10, zza)) {
                    if (!TextUtils.isEmpty(zzh().zzo()) || (zza != 0 && zza != 30)) {
                        if (TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle2 = zzdhVar.zzg) != null && zzjx.zzs(30, zza)) {
                            zzc = zzba.zzc(bundle2, 30);
                            if (zzc.zzk()) {
                                zzS(zzlwVar);
                                zzlwVar.zzag(zzc, true);
                            }
                        }
                        if (TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle = zzdhVar.zzg) != null) {
                            zzR(zzhtVar);
                            if (zzhtVar.zzh.zza() == null && (zzg = zzba.zzg(bundle)) != null) {
                                zzS(zzlwVar);
                                zzlwVar.zzal(zzdhVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzg.toString(), false);
                            }
                        }
                    } else {
                        zzS(zzlwVar);
                        zzlwVar.zzag(new zzba((Boolean) null, -10, (Boolean) null, (String) null), true);
                    }
                } else {
                    zzS(zzlwVar);
                    zzlwVar.zzag(zzba.zzd(zzm2, -10), true);
                }
                zzio zzioVar2 = zzamVar.zzu;
                zzn = zzamVar.zzn("google_analytics_tcf_data_enabled");
                if (zzn != null || zzn.booleanValue()) {
                    zzhe zzheVar3 = this.zzk;
                    zzT(zzheVar3);
                    zzheVar3.zzd().zza("TCF client enabled.");
                    zzS(zzlwVar);
                    zzlwVar.zzW();
                    zzS(zzlwVar);
                    zzlwVar.zzN();
                }
                zzR(zzhtVar);
                zzhpVar = zzhtVar.zzc;
                if (zzhpVar.zza() == 0) {
                    zzhe zzheVar4 = this.zzk;
                    zzT(zzheVar4);
                    long j = this.zza;
                    zzheVar4.zzj().zzb("Persisting first open", Long.valueOf(j));
                    zzR(zzhtVar);
                    zzhpVar.zzb(j);
                }
                zzS(zzlwVar);
                zzlwVar.zzb.zzc();
                if (!zzM()) {
                    if (!TextUtils.isEmpty(zzh().zzo()) || (!zzamVar.zzx(null, zzgi.zzbp) && !TextUtils.isEmpty(zzh().zzl()))) {
                        zzgg zzggVar2 = zzgi.zzbp;
                        if (zzamVar.zzx(null, zzggVar2)) {
                            zzqf zzqfVar3 = this.zzn;
                            zzR(zzqfVar3);
                            String zzo = zzh().zzo();
                            zzR(zzhtVar);
                            zzaw = zzqfVar3.zzav(zzo, zzhtVar.zzj());
                        } else {
                            zzqf zzqfVar4 = this.zzn;
                            zzR(zzqfVar4);
                            String zzo2 = zzh().zzo();
                            zzR(zzhtVar);
                            String zzj2 = zzhtVar.zzj();
                            String zzl = zzh().zzl();
                            zzR(zzhtVar);
                            zzhtVar.zzg();
                            zzaw = zzqfVar4.zzaw(zzo2, zzj2, zzl, zzhtVar.zzb().getString("admob_app_id", null));
                        }
                        if (zzaw) {
                            zzhe zzheVar5 = this.zzk;
                            zzT(zzheVar5);
                            zzheVar5.zzi().zza("Rechecking which service to use due to a GMP App Id change");
                            zzR(zzhtVar);
                            zzhtVar.zzg();
                            Boolean zzi = zzhtVar.zzi();
                            SharedPreferences.Editor edit = zzhtVar.zzb().edit();
                            edit.clear();
                            edit.apply();
                            if (zzi != null) {
                                zzhtVar.zzm(zzi);
                            }
                            zzi().zzj();
                            this.zzw.zzC();
                            this.zzw.zzB();
                            zzR(zzhtVar);
                            zzhpVar.zzb(this.zza);
                            zzR(zzhtVar);
                            zzhtVar.zze.zzb(null);
                        }
                        zzR(zzhtVar);
                        String zzo3 = zzh().zzo();
                        zzhtVar.zzg();
                        SharedPreferences.Editor edit2 = zzhtVar.zzb().edit();
                        edit2.putString("gmp_app_id", zzo3);
                        edit2.apply();
                        if (!zzamVar.zzx(null, zzggVar2)) {
                            zzR(zzhtVar);
                            zzhtVar.zzl(zzh().zzl());
                        } else {
                            zzR(zzhtVar);
                            zzhtVar.zzl(null);
                        }
                    }
                    zzR(zzhtVar);
                    if (!zzhtVar.zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
                        zzR(zzhtVar);
                        zzhtVar.zze.zzb(null);
                    }
                    zzS(zzlwVar);
                    zzR(zzhtVar);
                    zzlwVar.zzac(zzhtVar.zze.zza());
                    zzqf zzqfVar5 = this.zzn;
                    zzR(zzqfVar5);
                    try {
                        zzqfVar5.zzu.zzc.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                    } catch (ClassNotFoundException unused) {
                        zzht zzhtVar2 = this.zzj;
                        zzR(zzhtVar2);
                        zzhr zzhrVar = zzhtVar2.zzq;
                        if (!TextUtils.isEmpty(zzhrVar.zza())) {
                            zzhe zzheVar6 = this.zzk;
                            zzT(zzheVar6);
                            zzheVar6.zzk().zza("Remote config removed with active feature rollouts");
                            zzR(zzhtVar2);
                            zzhrVar.zzb(null);
                        }
                    }
                    if (!TextUtils.isEmpty(zzh().zzo()) || (!this.zzi.zzx(null, zzgi.zzbp) && !TextUtils.isEmpty(zzh().zzl()))) {
                        boolean zzJ = zzJ();
                        zzht zzhtVar3 = this.zzj;
                        zzR(zzhtVar3);
                        if (!zzhtVar3.zzo() && !this.zzi.zzA()) {
                            zzR(zzhtVar3);
                            zzhtVar3.zzn(!zzJ);
                        }
                        if (zzJ) {
                            zzlw zzlwVar3 = this.zzr;
                            zzS(zzlwVar3);
                            zzlwVar3.zzH();
                        }
                        zzop zzopVar = this.zzm;
                        zzS(zzopVar);
                        zzopVar.zza.zza();
                        zzu().zzE(new AtomicReference());
                        zzny zzu = zzu();
                        zzR(zzhtVar3);
                        zzu.zzT(zzhtVar3.zzt.zza());
                    }
                } else if (zzJ()) {
                    zzqf zzqfVar6 = this.zzn;
                    zzR(zzqfVar6);
                    if (!zzqfVar6.zzaj("android.permission.INTERNET")) {
                        zzhe zzheVar7 = this.zzk;
                        zzT(zzheVar7);
                        zzheVar7.zze().zza("App is missing INTERNET permission");
                    }
                    zzR(zzqfVar6);
                    if (!zzqfVar6.zzaj("android.permission.ACCESS_NETWORK_STATE")) {
                        zzhe zzheVar8 = this.zzk;
                        zzT(zzheVar8);
                        zzheVar8.zze().zza("App is missing ACCESS_NETWORK_STATE permission");
                    }
                    Context context = this.zzc;
                    if (!Wrappers.packageManager(context).isCallerInstantApp() && !this.zzi.zzC()) {
                        if (!zzqf.zzar(context)) {
                            zzhe zzheVar9 = this.zzk;
                            zzT(zzheVar9);
                            zzheVar9.zze().zza("AppMeasurementReceiver not registered/enabled");
                        }
                        if (!zzqf.zzat(context, false)) {
                            zzhe zzheVar10 = this.zzk;
                            zzT(zzheVar10);
                            zzheVar10.zze().zza("AppMeasurementService not registered/enabled");
                        }
                    }
                    zzhe zzheVar11 = this.zzk;
                    zzT(zzheVar11);
                    zzheVar11.zze().zza("Uploading is not possible. App measurement disabled");
                }
                zzqr.zzb();
                if (this.zzi.zzx(null, zzgi.zzaW)) {
                    zzqf zzqfVar7 = this.zzn;
                    zzR(zzqfVar7);
                    if (zzqfVar7.zzan()) {
                        long max = Math.max(500L, ((((Integer) zzgi.zzaw.zza(null)).intValue() * 1000) + new Random().nextInt(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS)) - this.zzp.elapsedRealtime());
                        if (max > 500) {
                            zzhe zzheVar12 = this.zzk;
                            zzT(zzheVar12);
                            zzheVar12.zzj().zzb("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(max));
                        }
                        zzlw zzlwVar4 = this.zzr;
                        zzS(zzlwVar4);
                        zzlwVar4.zzab(max);
                    }
                }
                zzht zzhtVar4 = this.zzj;
                zzR(zzhtVar4);
                zzhtVar4.zzj.zza(true);
            }
        }
        if (TextUtils.isEmpty(zzh().zzo()) || (zzb2 != 0 && zzb2 != 30 && zzb2 != 10 && zzb2 != 30 && zzb2 != 30 && zzb2 != 40)) {
            if (!zzamVar.zzx(null, zzgi.zzbp) && TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle3 = zzdhVar.zzg) != null) {
                zzR(zzhtVar);
                if (zzhtVar.zzq(30)) {
                    zzj = zzjx.zzi(bundle3, 30);
                }
            }
        } else {
            zzlw zzlwVar5 = this.zzr;
            zzS(zzlwVar5);
            zzlwVar5.zzak(new zzjx(null, null, -10), false);
        }
        zzj = null;
        if (zzj != null) {
        }
        zzlwVar = this.zzr;
        zzS(zzlwVar);
        zzlwVar.zzaj(zzh);
        zzR(zzhtVar);
        int zza2 = zzhtVar.zzf().zza();
        zzm = zzamVar.zzm("google_analytics_default_allow_ad_personalization_signals", true);
        if (zzm != zzjuVar) {
        }
        zzm2 = zzamVar.zzm("google_analytics_default_allow_ad_user_data", true);
        if (zzm2 != zzju.UNINITIALIZED) {
        }
        if (!TextUtils.isEmpty(zzh().zzo())) {
        }
        if (TextUtils.isEmpty(zzh().zzo())) {
            zzc = zzba.zzc(bundle2, 30);
            if (zzc.zzk()) {
            }
        }
        if (TextUtils.isEmpty(zzh().zzo())) {
            zzR(zzhtVar);
            if (zzhtVar.zzh.zza() == null) {
                zzS(zzlwVar);
                zzlwVar.zzal(zzdhVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzg.toString(), false);
            }
        }
        zzio zzioVar22 = zzamVar.zzu;
        zzn = zzamVar.zzn("google_analytics_tcf_data_enabled");
        if (zzn != null) {
        }
        zzhe zzheVar32 = this.zzk;
        zzT(zzheVar32);
        zzheVar32.zzd().zza("TCF client enabled.");
        zzS(zzlwVar);
        zzlwVar.zzW();
        zzS(zzlwVar);
        zzlwVar.zzN();
        zzR(zzhtVar);
        zzhpVar = zzhtVar.zzc;
        if (zzhpVar.zza() == 0) {
        }
        zzS(zzlwVar);
        zzlwVar.zzb.zzc();
        if (!zzM()) {
        }
        zzqr.zzb();
        if (this.zzi.zzx(null, zzgi.zzaW)) {
        }
        zzht zzhtVar42 = this.zzj;
        zzR(zzhtVar42);
        zzhtVar42.zzj.zza(true);
    }

    public final boolean zzI() {
        return this.zzD != null && this.zzD.booleanValue();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    public final boolean zzK() {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        return this.zzE;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzM() {
        boolean z;
        Boolean valueOf;
        if (this.zzA) {
            zzil zzilVar = this.zzl;
            zzT(zzilVar);
            zzilVar.zzg();
            Boolean bool = this.zzB;
            if (bool == null || this.zzC == 0 || (!bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzC) > 1000)) {
                this.zzC = this.zzp.elapsedRealtime();
                zzqf zzqfVar = this.zzn;
                zzR(zzqfVar);
                boolean z2 = true;
                if (zzqfVar.zzaj("android.permission.INTERNET")) {
                    zzR(zzqfVar);
                    if (zzqfVar.zzaj("android.permission.ACCESS_NETWORK_STATE")) {
                        Context context = this.zzc;
                        if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzi.zzC() || (zzqf.zzar(context) && zzqf.zzat(context, false))) {
                            z = true;
                            valueOf = Boolean.valueOf(z);
                            this.zzB = valueOf;
                            if (valueOf.booleanValue()) {
                                zzR(zzqfVar);
                                if (!zzqfVar.zzac(zzh().zzo(), zzh().zzl()) && (this.zzi.zzx(null, zzgi.zzbp) || TextUtils.isEmpty(zzh().zzl()))) {
                                    z2 = false;
                                }
                                this.zzB = Boolean.valueOf(z2);
                            }
                        }
                    }
                }
                z = false;
                valueOf = Boolean.valueOf(z);
                this.zzB = valueOf;
                if (valueOf.booleanValue()) {
                }
            }
            return this.zzB.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzN() {
        return this.zzg;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0087, code lost:
    
        if (r4.zzm() >= 234200) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzO() {
        NetworkInfo activeNetworkInfo;
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzmb zzmbVar = this.zzt;
        zzT(zzmbVar);
        zzT(zzmbVar);
        String zzm = zzh().zzm();
        if (this.zzi.zzw()) {
            zzht zzhtVar = this.zzj;
            zzR(zzhtVar);
            Pair zzd = zzhtVar.zzd(zzm);
            if (((Boolean) zzd.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzd.first)) {
                zzhe zzheVar = this.zzk;
                zzT(zzheVar);
                zzheVar.zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                return false;
            }
            zzT(zzmbVar);
            zzmbVar.zzv();
            ConnectivityManager connectivityManager = (ConnectivityManager) zzmbVar.zzu.zzc.getSystemService("connectivity");
            if (connectivityManager != null) {
                try {
                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (SecurityException unused) {
                }
                if (activeNetworkInfo == null && activeNetworkInfo.isConnected()) {
                    StringBuilder sb = new StringBuilder();
                    zzny zzu = zzu();
                    zzu.zzg();
                    zzu.zza();
                    if (zzu.zzad()) {
                        zzqf zzqfVar = zzu.zzu.zzn;
                        zzR(zzqfVar);
                    }
                    zzlw zzlwVar = this.zzr;
                    zzS(zzlwVar);
                    zzio zzioVar = zzlwVar.zzu;
                    zzlwVar.zzg();
                    zzap zzh = zzioVar.zzu().zzh();
                    Bundle bundle = zzh != null ? zzh.zza : null;
                    if (bundle == null) {
                        int i = this.zzG;
                        this.zzG = i + 1;
                        boolean z = i < 10;
                        zzhe zzheVar2 = this.zzk;
                        zzT(zzheVar2);
                        zzhc zzd2 = zzheVar2.zzd();
                        StringBuilder sb2 = new StringBuilder("Failed to retrieve DMA consent from the service, ");
                        sb2.append(i < 10 ? "Retrying." : "Skipping.");
                        sb2.append(" retryCount");
                        zzd2.zzb(sb2.toString(), Integer.valueOf(this.zzG));
                        return z;
                    }
                    zzjx zzi = zzjx.zzi(bundle, 100);
                    sb.append("&gcs=");
                    sb.append(zzi.zzp());
                    zzba zzc = zzba.zzc(bundle, 100);
                    sb.append("&dma=");
                    sb.append(!Objects.equals(zzc.zzh(), false) ? 1 : 0);
                    if (!TextUtils.isEmpty(zzc.zzi())) {
                        sb.append("&dma_cps=");
                        sb.append(zzc.zzi());
                    }
                    int i2 = !Objects.equals(zzba.zzg(bundle), true) ? 1 : 0;
                    sb.append("&npa=");
                    sb.append(i2);
                    zzhe zzheVar3 = this.zzk;
                    zzT(zzheVar3);
                    zzheVar3.zzj().zzb("Consent query parameters to Bow", sb);
                    zzqf zzqfVar2 = this.zzn;
                    zzR(zzqfVar2);
                    zzh().zzu.zzi.zzj();
                    String str = (String) zzd.first;
                    zzht zzhtVar2 = this.zzj;
                    zzR(zzhtVar2);
                    URL zzH = zzqfVar2.zzH(119002L, zzm, str, (-1) + zzhtVar2.zzp.zza(), sb.toString());
                    if (zzH != null) {
                        zzmb zzmbVar2 = this.zzt;
                        zzT(zzmbVar2);
                        zzly zzlyVar = new zzly() { // from class: com.google.android.gms.measurement.internal.zzim
                            @Override // com.google.android.gms.measurement.internal.zzly
                            public final void zza(String str2, int i3, Throwable th, byte[] bArr, Map map) {
                                zzio.zzB(zzio.this, str2, i3, th, bArr, map);
                            }
                        };
                        zzmbVar2.zzv();
                        Preconditions.checkNotNull(zzH);
                        Preconditions.checkNotNull(zzlyVar);
                        zzil zzilVar2 = zzmbVar2.zzu.zzl;
                        zzT(zzilVar2);
                        zzilVar2.zzp(new zzma(zzmbVar2, zzm, zzH, null, null, zzlyVar));
                    }
                    return false;
                }
                zzhe zzheVar4 = this.zzk;
                zzT(zzheVar4);
                zzheVar4.zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
                return false;
            }
            activeNetworkInfo = null;
            if (activeNetworkInfo == null) {
            }
            zzhe zzheVar42 = this.zzk;
            zzT(zzheVar42);
            zzheVar42.zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        zzhe zzheVar5 = this.zzk;
        zzT(zzheVar5);
        zzheVar5.zzj().zza("ADID collection is disabled from Manifest. Skipping");
        return false;
    }

    public final int zza() {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzam zzamVar = this.zzi;
        if (zzamVar.zzA()) {
            return 1;
        }
        zzT(zzilVar);
        zzilVar.zzg();
        if (!this.zzE) {
            return 8;
        }
        zzht zzhtVar = this.zzj;
        zzR(zzhtVar);
        Boolean zzi = zzhtVar.zzi();
        if (zzi != null) {
            return zzi.booleanValue() ? 0 : 3;
        }
        zzaf zzafVar = zzamVar.zzu.zzh;
        Boolean zzn = zzamVar.zzn("firebase_analytics_collection_enabled");
        return zzn != null ? zzn.booleanValue() ? 0 : 4 : (this.zzD == null || this.zzD.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final Context zzaT() {
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final Clock zzaU() {
        return this.zzp;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final zzaf zzaV() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final zzhe zzaW() {
        zzhe zzheVar = this.zzk;
        zzT(zzheVar);
        return zzheVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final zzil zzaX() {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        return zzilVar;
    }

    @Pure
    public final zzd zzd() {
        zzd zzdVar = this.zzs;
        zzQ(zzdVar);
        return zzdVar;
    }

    @Pure
    public final zzam zzf() {
        return this.zzi;
    }

    @Pure
    public final zzbb zzg() {
        zzT(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzgs zzh() {
        zzS(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzgv zzi() {
        zzS(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzgx zzj() {
        return this.zzo;
    }

    public final zzhe zzl() {
        zzhe zzheVar = this.zzk;
        if (zzheVar == null || !zzheVar.zzy()) {
            return null;
        }
        return zzheVar;
    }

    @Pure
    public final zzht zzm() {
        zzht zzhtVar = this.zzj;
        zzR(zzhtVar);
        return zzhtVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzil zzo() {
        return this.zzl;
    }

    @Pure
    public final zzlw zzq() {
        zzlw zzlwVar = this.zzr;
        zzS(zzlwVar);
        return zzlwVar;
    }

    @Pure
    public final zzmb zzr() {
        zzmb zzmbVar = this.zzt;
        zzT(zzmbVar);
        return zzmbVar;
    }

    @Pure
    public final zzmd zzs() {
        zzQ(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzmo zzt() {
        zzmo zzmoVar = this.zzq;
        zzS(zzmoVar);
        return zzmoVar;
    }

    @Pure
    public final zzny zzu() {
        zzS(this.zzw);
        return this.zzw;
    }

    @Pure
    public final zzop zzv() {
        zzop zzopVar = this.zzm;
        zzS(zzopVar);
        return zzopVar;
    }

    @Pure
    public final zzqf zzw() {
        zzqf zzqfVar = this.zzn;
        zzR(zzqfVar);
        return zzqfVar;
    }

    @Pure
    public final String zzx() {
        if (this.zzi.zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.zzd;
    }

    @Pure
    public final String zzy() {
        if (this.zzi.zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.zze;
    }

    @Pure
    public final String zzz() {
        return this.zzf;
    }
}
