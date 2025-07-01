package com.google.android.gms.internal.mlkit_vision_text_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzuc {
    private static zzbk zza;
    private static final zzbm zzb = zzbm.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzts zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzuc(Context context, final SharedPrefManager sharedPrefManager, zzts zztsVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zztsVar;
        zzuo.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zzty
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzuc.this.zzb();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zztz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzbm zzbmVar = zzb;
        this.zzj = zzbmVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzbmVar.get(str)) : -1;
    }

    static long zza(List list, double d) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d / 100.0d) * list.size())) - 1, 0))).longValue();
    }

    private static synchronized zzbk zzi() {
        synchronized (zzuc.class) {
            zzbk zzbkVar = zza;
            if (zzbkVar != null) {
                return zzbkVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzbh zzbhVar = new zzbh();
            for (int i = 0; i < locales.size(); i++) {
                zzbhVar.zza(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzbk zzb2 = zzbhVar.zzb();
            zza = zzb2;
            return zzb2;
        }
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    private final boolean zzk(zzov zzovVar, long j, long j2) {
        return this.zzk.get(zzovVar) == null || j - ((Long) this.zzk.get(zzovVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzb() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zztr zztrVar, zzov zzovVar, String str) {
        String mlSdkInstanceId;
        zztrVar.zzb(zzovVar);
        String zzd = zztrVar.zzd();
        zzsr zzsrVar = new zzsr();
        zzsrVar.zzb(this.zzc);
        zzsrVar.zzc(this.zzd);
        zzsrVar.zzh(zzi());
        zzsrVar.zzg(true);
        zzsrVar.zzl(zzd);
        zzsrVar.zzj(str);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zzsrVar.zzi(mlSdkInstanceId);
        zzsrVar.zzd(10);
        zzsrVar.zzk(Integer.valueOf(this.zzj));
        zztrVar.zzc(zzsrVar);
        this.zze.zza(zztrVar);
    }

    public final void zzd(zztr zztrVar, zzov zzovVar) {
        zze(zztrVar, zzovVar, zzj());
    }

    public final void zze(final zztr zztrVar, final zzov zzovVar, final String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zztw
            @Override // java.lang.Runnable
            public final void run() {
                zzuc.this.zzc(zztrVar, zzovVar, str);
            }
        });
    }

    public final void zzf(zzub zzubVar, zzov zzovVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzovVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzovVar, Long.valueOf(elapsedRealtime));
            zze(zzubVar.zza(), zzovVar, zzj());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzov zzovVar, com.google.mlkit.vision.text.internal.zzr zzrVar) {
        zzbp zzbpVar = (zzbp) this.zzl.get(zzovVar);
        if (zzbpVar != null) {
            for (Object obj : zzbpVar.zzo()) {
                ArrayList arrayList = new ArrayList(zzbpVar.zzc(obj));
                Collections.sort(arrayList);
                zznu zznuVar = new zznu();
                Iterator it = arrayList.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j += ((Long) it.next()).longValue();
                }
                zznuVar.zza(Long.valueOf(j / arrayList.size()));
                zznuVar.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zznuVar.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zznuVar.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zznuVar.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zznuVar.zze(Long.valueOf(zza(arrayList, AudioStats.AUDIO_AMPLITUDE_NONE)));
                zze(zzrVar.zza(obj, arrayList.size(), zznuVar.zzg()), zzovVar, zzj());
            }
            this.zzl.remove(zzovVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(final zzov zzovVar, Object obj, long j, final com.google.mlkit.vision.text.internal.zzr zzrVar) {
        if (!this.zzl.containsKey(zzovVar)) {
            this.zzl.put(zzovVar, zzao.zzp());
        }
        ((zzbp) this.zzl.get(zzovVar)).zzm(obj, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzovVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzovVar, Long.valueOf(elapsedRealtime));
            MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zztx
                @Override // java.lang.Runnable
                public final void run() {
                    zzuc.this.zzg(zzovVar, zzrVar);
                }
            });
        }
    }
}
