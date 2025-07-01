package vn.ai.faceauth.sdk.presentation.presentation.widgets;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import com.google.android.odml.image.BitmapMlImageBuilder;
import com.google.android.odml.image.ByteBufferMlImageBuilder;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import paua.btj;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 >*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001>B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\"\u001a\u00020$H$J\u0012\u0010%\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0014J\u0014\u0010&\u001a\u00020'2\n\u0010(\u001a\u00060)j\u0002`*H$J\u0015\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00028\u0000H$¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001c\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u00132\b\u00103\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u00104\u001a\u00020'2\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0015H\u0002J\b\u00105\u001a\u00020'H\u0002J0\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\"\u001a\u00020#2\b\u00107\u001a\u0004\u0018\u0001002\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0017H\u0002J0\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\"\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u0001002\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0017H\u0002J\b\u0010:\u001a\u00020'H\u0002J6\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000!2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000!2\b\u00107\u001a\u0004\u0018\u0001002\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0017H\u0002J\b\u0010=\u001a\u00020'H\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/widgets/VisionProcessorBase;", ExifInterface.GPS_DIRECTION_TRUE, "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/VisionImageProcessor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_context", "activityManager", "Landroid/app/ActivityManager;", "executor", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/ScopedExecutor;", "fpsTimer", "Ljava/util/Timer;", "frameProcessedInOneSecondInterval", "", "framesPerSecond", "isShutdown", "", "latestImage", "Ljava/nio/ByteBuffer;", "latestImageMetaData", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/FrameMetadata;", "maxDetectorMs", "", "maxFrameMs", "minDetectorMs", "minFrameMs", "numRuns", "processingImage", "processingMetaData", "totalDetectorMs", "totalFrameMs", "detectInImage", "Lcom/google/android/gms/tasks/Task;", "image", "Lcom/google/android/odml/image/MlImage;", "Lcom/google/mlkit/vision/common/InputImage;", "isMlImageEnabled", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "results", "(Ljava/lang/Object;)V", "processBitmap", "bitmap", "Landroid/graphics/Bitmap;", "processByteBuffer", "data", "frameMetadata", "processImage", "processLatestImage", "requestDetectInImage", "originalCameraImage", "shouldShowFps", "frameStartMs", "resetLatencyStats", "setUpListener", "task", "stop", "Companion", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public abstract class VisionProcessorBase<T> implements VisionImageProcessor {
    public static String MANUAL_TESTING_LOG;
    private static String TAG;
    private Context _context;
    private ActivityManager activityManager;
    private final ScopedExecutor executor;
    private final Timer fpsTimer;
    private int frameProcessedInOneSecondInterval;
    private int framesPerSecond;
    private boolean isShutdown;
    private ByteBuffer latestImage;
    private FrameMetadata latestImageMetaData;
    private long maxDetectorMs;
    private long maxFrameMs;
    private long minDetectorMs;
    private long minFrameMs;
    private int numRuns;
    private ByteBuffer processingImage;
    private FrameMetadata processingMetaData;
    private long totalDetectorMs;
    private long totalFrameMs;

    static {
        btj.sfgt(VisionProcessorBase.class, 618, 619);
        INSTANCE = new Companion(null);
    }

    public VisionProcessorBase(Context context) {
        this._context = context;
        Object systemService = context.getSystemService(btj.tzend(90));
        if (systemService == null) {
            throw new NullPointerException(btj.tzend(91));
        }
        this.activityManager = (ActivityManager) systemService;
        Timer timer = new Timer();
        this.fpsTimer = timer;
        this.executor = new ScopedExecutor(TaskExecutors.MAIN_THREAD);
        this.minFrameMs = Long.MAX_VALUE;
        this.minDetectorMs = Long.MAX_VALUE;
        timer.scheduleAtFixedRate(new TimerTask(this) { // from class: vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionProcessorBase.1
            final /* synthetic */ VisionProcessorBase<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                VisionProcessorBase<T> visionProcessorBase = this.this$0;
                ((VisionProcessorBase) visionProcessorBase).framesPerSecond = ((VisionProcessorBase) visionProcessorBase).frameProcessedInOneSecondInterval;
                ((VisionProcessorBase) this.this$0).frameProcessedInOneSecondInterval = 0;
            }
        }, 0L, 1000L);
    }

    private final void processImage(ByteBuffer data, FrameMetadata frameMetadata) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap bitmap = PreferenceUtils.isCameraLiveViewportEnabled(this._context) ? null : BitmapUtils.getBitmap(data, frameMetadata);
        if (!isMlImageEnabled(this._context)) {
            requestDetectInImage(InputImage.fromByteBuffer(data, frameMetadata.getWidth(), frameMetadata.getHeight(), frameMetadata.getRotation(), 17), bitmap, true, elapsedRealtime).addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionProcessorBase$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    VisionProcessorBase.this.processLatestImage();
                }
            });
            return;
        }
        MlImage build = new ByteBufferMlImageBuilder(data, frameMetadata.getWidth(), frameMetadata.getHeight(), 4).setRotation(frameMetadata.getRotation()).build();
        requestDetectInImage(build, bitmap, true, elapsedRealtime).addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionProcessorBase$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                VisionProcessorBase.this.processLatestImage();
            }
        });
        build.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processLatestImage() {
        synchronized (this) {
            ByteBuffer byteBuffer = this.latestImage;
            this.processingImage = byteBuffer;
            FrameMetadata frameMetadata = this.latestImageMetaData;
            this.processingMetaData = frameMetadata;
            this.latestImage = null;
            this.latestImageMetaData = null;
            if (byteBuffer != null && frameMetadata != null && !this.isShutdown) {
                processImage(byteBuffer, frameMetadata);
            }
        }
    }

    private final Task<T> requestDetectInImage(MlImage image, Bitmap originalCameraImage, boolean shouldShowFps, long frameStartMs) {
        return setUpListener(detectInImage(image), originalCameraImage, shouldShowFps, frameStartMs);
    }

    private final Task<T> requestDetectInImage(InputImage image, Bitmap originalCameraImage, boolean shouldShowFps, long frameStartMs) {
        return setUpListener(detectInImage(image), originalCameraImage, shouldShowFps, frameStartMs);
    }

    private final void resetLatencyStats() {
        this.numRuns = 0;
        this.totalFrameMs = 0L;
        this.maxFrameMs = 0L;
        this.minFrameMs = Long.MAX_VALUE;
        this.totalDetectorMs = 0L;
        this.maxDetectorMs = 0L;
        this.minDetectorMs = Long.MAX_VALUE;
    }

    private final Task<T> setUpListener(Task<T> task, Bitmap originalCameraImage, boolean shouldShowFps, final long frameStartMs) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        return task.addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionProcessorBase$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                VisionProcessorBase.m2597setUpListener$lambda2(frameStartMs, elapsedRealtime, this, obj);
            }
        }).addOnFailureListener(this.executor, new OnFailureListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionProcessorBase$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                VisionProcessorBase.m2598setUpListener$lambda3(VisionProcessorBase.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpListener$lambda-2, reason: not valid java name */
    public static final void m2597setUpListener$lambda2(long j, long j2, VisionProcessorBase visionProcessorBase, Object obj) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - j;
        long j4 = elapsedRealtime - j2;
        if (visionProcessorBase.numRuns >= 500) {
            visionProcessorBase.resetLatencyStats();
        }
        visionProcessorBase.numRuns++;
        visionProcessorBase.frameProcessedInOneSecondInterval++;
        visionProcessorBase.totalFrameMs += j3;
        visionProcessorBase.maxFrameMs = Math.max(j3, visionProcessorBase.maxFrameMs);
        visionProcessorBase.minFrameMs = Math.min(j3, visionProcessorBase.minFrameMs);
        visionProcessorBase.totalDetectorMs += j4;
        visionProcessorBase.maxDetectorMs = Math.max(j4, visionProcessorBase.maxDetectorMs);
        visionProcessorBase.minDetectorMs = Math.min(j4, visionProcessorBase.minDetectorMs);
        if (visionProcessorBase.frameProcessedInOneSecondInterval == 1) {
            String str = btj.tzend(92) + visionProcessorBase.numRuns;
            String tzend = btj.tzend(93);
            Log.d(tzend, str);
            StringBuilder sb = new StringBuilder(btj.tzend(94));
            sb.append(visionProcessorBase.maxFrameMs);
            String tzend2 = btj.tzend(95);
            sb.append(tzend2);
            sb.append(visionProcessorBase.minFrameMs);
            String tzend3 = btj.tzend(96);
            sb.append(tzend3);
            sb.append(visionProcessorBase.totalFrameMs / visionProcessorBase.numRuns);
            Log.d(tzend, sb.toString());
            Log.d(tzend, btj.tzend(97) + visionProcessorBase.maxDetectorMs + tzend2 + visionProcessorBase.minDetectorMs + tzend3 + (visionProcessorBase.totalDetectorMs / visionProcessorBase.numRuns));
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            visionProcessorBase.activityManager.getMemoryInfo(memoryInfo);
            Log.d(tzend, btj.tzend(98) + (memoryInfo.availMem / 1048576) + btj.tzend(99));
        }
        visionProcessorBase.onSuccess(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpListener$lambda-3, reason: not valid java name */
    public static final void m2598setUpListener$lambda3(VisionProcessorBase visionProcessorBase, Exception exc) {
        Log.d(btj.tzend(101), btj.tzend(100) + exc.getLocalizedMessage());
        exc.printStackTrace();
        visionProcessorBase.onFailure(exc);
    }

    public Task<T> detectInImage(MlImage image) {
        return Tasks.forException(new MlKitException(btj.tzend(102), 3));
    }

    public abstract Task<T> detectInImage(InputImage image);

    public boolean isMlImageEnabled(Context context) {
        return false;
    }

    public abstract void onFailure(Exception e);

    public abstract void onSuccess(T results);

    @Override // vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionImageProcessor
    public void processBitmap(Bitmap bitmap) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!isMlImageEnabled(this._context)) {
            requestDetectInImage(InputImage.fromBitmap(bitmap, 0), (Bitmap) null, false, elapsedRealtime);
            return;
        }
        MlImage build = new BitmapMlImageBuilder(bitmap).build();
        requestDetectInImage(build, (Bitmap) null, false, elapsedRealtime);
        build.close();
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionImageProcessor
    public void processByteBuffer(ByteBuffer data, FrameMetadata frameMetadata) {
        synchronized (this) {
            this.latestImage = data;
            this.latestImageMetaData = frameMetadata;
            if (this.processingImage == null && this.processingMetaData == null) {
                processLatestImage();
            }
        }
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionImageProcessor
    public void stop() {
        this.executor.shutdown();
        this.isShutdown = true;
        resetLatencyStats();
        this.fpsTimer.cancel();
    }
}
