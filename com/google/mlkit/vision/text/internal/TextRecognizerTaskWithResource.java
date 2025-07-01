package com.google.mlkit.vision.text.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_text_common.zzep;
import com.google.android.gms.internal.mlkit_vision_text_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_text_common.zzes;
import com.google.android.gms.internal.mlkit_vision_text_common.zznw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoa;
import com.google.android.gms.internal.mlkit_vision_text_common.zzob;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoh;
import com.google.android.gms.internal.mlkit_vision_text_common.zzot;
import com.google.android.gms.internal.mlkit_vision_text_common.zzou;
import com.google.android.gms.internal.mlkit_vision_text_common.zzov;
import com.google.android.gms.internal.mlkit_vision_text_common.zzow;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrx;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrz;
import com.google.android.gms.internal.mlkit_vision_text_common.zzsa;
import com.google.android.gms.internal.mlkit_vision_text_common.zztr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzub;
import com.google.android.gms.internal.mlkit_vision_text_common.zzuc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzue;
import com.google.android.gms.internal.mlkit_vision_text_common.zzuf;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.TaskQueue;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public class TextRecognizerTaskWithResource extends MLTask<Text, InputImage> {
    static boolean zza = true;
    private final zzm zzc;
    private final zzuc zzd;
    private final zzue zze;
    private final TextRecognizerOptionsInterface zzf;
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private static final TaskQueue taskQueue = new TaskQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextRecognizerTaskWithResource(zzuc zzucVar, zzm zzmVar, TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        super(r0);
        TaskQueue taskQueue2;
        if (textRecognizerOptionsInterface.getLoggingLanguageOption() == 8 || textRecognizerOptionsInterface.getLoggingLanguageOption() == 7) {
            taskQueue2 = new TaskQueue();
        } else {
            taskQueue2 = taskQueue;
        }
        this.zzd = zzucVar;
        this.zzc = zzmVar;
        this.zze = zzue.zza(MlKitContext.getInstance().getApplicationContext());
        this.zzf = textRecognizerOptionsInterface;
    }

    private final void zzf(final zzou zzouVar, long j, final InputImage inputImage) {
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzd.zzf(new zzub() { // from class: com.google.mlkit.vision.text.internal.zzq
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzub
            public final zztr zza() {
                return TextRecognizerTaskWithResource.this.zzc(elapsedRealtime, zzouVar, inputImage);
            }
        }, zzov.ON_DEVICE_TEXT_DETECT);
        zzeq zzeqVar = new zzeq();
        zzeqVar.zza(zzouVar);
        zzeqVar.zzb(Boolean.valueOf(zza));
        zzsa zzsaVar = new zzsa();
        zzsaVar.zza(LoggingUtils.zza(this.zzf.getLoggingLanguageOption()));
        zzeqVar.zzc(zzsaVar.zzc());
        final zzes zzd = zzeqVar.zzd();
        final zzr zzrVar = new zzr(this);
        final zzov zzovVar = zzov.AGGREGATED_ON_DEVICE_TEXT_DETECTION;
        Executor workerThreadExecutor = MLTaskExecutor.workerThreadExecutor();
        final zzuc zzucVar = this.zzd;
        workerThreadExecutor.execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zzua
            @Override // java.lang.Runnable
            public final void run() {
                zzuc.this.zzh(zzovVar, zzd, elapsedRealtime, zzrVar);
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        this.zze.zzc(this.zzf.getLoggingEventId(), zzouVar.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void load() throws MlKitException {
        this.zzc.zzb();
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void release() {
        zza = true;
        this.zzc.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zztr zzc(long j, zzou zzouVar, InputImage inputImage) {
        zzob zzobVar;
        zzrx zzrxVar = new zzrx();
        zzoh zzohVar = new zzoh();
        zzohVar.zzc(Long.valueOf(j));
        zzohVar.zzd(zzouVar);
        zzohVar.zze(Boolean.valueOf(zza));
        zzohVar.zza(true);
        zzohVar.zzb(true);
        zzrxVar.zzd(zzohVar.zzf());
        ImageUtils imageUtils = zzb;
        int mobileVisionImageFormat = imageUtils.getMobileVisionImageFormat(inputImage);
        int mobileVisionImageSize = imageUtils.getMobileVisionImageSize(inputImage);
        zzoa zzoaVar = new zzoa();
        if (mobileVisionImageFormat == -1) {
            zzobVar = zzob.BITMAP;
        } else if (mobileVisionImageFormat == 35) {
            zzobVar = zzob.YUV_420_888;
        } else if (mobileVisionImageFormat == 842094169) {
            zzobVar = zzob.YV12;
        } else if (mobileVisionImageFormat != 16) {
            zzobVar = mobileVisionImageFormat != 17 ? zzob.UNKNOWN_FORMAT : zzob.NV21;
        } else {
            zzobVar = zzob.NV16;
        }
        zzoaVar.zza(zzobVar);
        zzoaVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zzrxVar.zzc(zzoaVar.zzd());
        zzsa zzsaVar = new zzsa();
        zzsaVar.zza(LoggingUtils.zza(this.zzf.getLoggingLanguageOption()));
        zzrxVar.zze(zzsaVar.zzc());
        zzrz zzf = zzrxVar.zzf();
        zzow zzowVar = new zzow();
        zzowVar.zze(this.zzf.getIsThickClient() ? zzot.TYPE_THICK : zzot.TYPE_THIN);
        zzowVar.zzh(zzf);
        return zzuf.zzf(zzowVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zztr zzd(zzes zzesVar, int i, zznw zznwVar) {
        zzow zzowVar = new zzow();
        zzowVar.zze(this.zzf.getIsThickClient() ? zzot.TYPE_THICK : zzot.TYPE_THIN);
        zzep zzepVar = new zzep();
        zzepVar.zza(Integer.valueOf(i));
        zzepVar.zzc(zzesVar);
        zzepVar.zzb(zznwVar);
        zzowVar.zzd(zzepVar.zze());
        return zzuf.zzf(zzowVar);
    }

    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final synchronized Text run(InputImage inputImage) throws MlKitException {
        Text zza2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            zza2 = this.zzc.zza(inputImage);
            zzf(zzou.NO_ERROR, elapsedRealtime, inputImage);
            zza = false;
        } catch (MlKitException e) {
            zzf(e.getErrorCode() == 14 ? zzou.MODEL_NOT_DOWNLOADED : zzou.UNKNOWN_ERROR, elapsedRealtime, inputImage);
            throw e;
        }
        return zza2;
    }
}
