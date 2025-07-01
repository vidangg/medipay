package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

/* loaded from: classes.dex */
public class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DefaultSurfaceProcessor";
    private final Executor mGlExecutor;
    final Handler mGlHandler;
    private final OpenGlRenderer mGlRenderer;
    final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private final List<PendingSnapshot> mPendingSnapshots;
    private final float[] mSurfaceOutputMatrix;
    private final float[] mTextureMatrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$executeSafely$10() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSurfaceProcessor(DynamicRange dynamicRange) {
        this(dynamicRange, ShaderProvider.DEFAULT);
    }

    DefaultSurfaceProcessor(DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.mGlThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mGlHandler = handler;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mGlRenderer = new OpenGlRenderer();
        try {
            initGlRenderer(dynamicRange, shaderProvider);
        } catch (RuntimeException e) {
            release();
            throw e;
        }
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(final SurfaceRequest surfaceRequest) {
        if (this.mIsReleaseRequested.get()) {
            surfaceRequest.willNotProvideSurface();
            return;
        }
        Runnable runnable = new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.this.m201xeeb3c23e(surfaceRequest);
            }
        };
        Objects.requireNonNull(surfaceRequest);
        executeSafely(runnable, new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceRequest.this.willNotProvideSurface();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onInputSurface$1$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m201xeeb3c23e(SurfaceRequest surfaceRequest) {
        this.mInputSurfaceCount++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(this.mGlRenderer.getTextureName());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, this.mGlExecutor, new Consumer() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda12
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                DefaultSurfaceProcessor.this.m200xc91fb93d(surfaceTexture, surface, (SurfaceRequest.Result) obj);
            }
        });
        surfaceTexture.setOnFrameAvailableListener(this, this.mGlHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onInputSurface$0$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m200xc91fb93d(SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.Result result) {
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        this.mInputSurfaceCount--;
        checkReadyToRelease();
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(final SurfaceOutput surfaceOutput) {
        if (this.mIsReleaseRequested.get()) {
            surfaceOutput.close();
            return;
        }
        Runnable runnable = new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.this.m203x7933371(surfaceOutput);
            }
        };
        Objects.requireNonNull(surfaceOutput);
        executeSafely(runnable, new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceOutput.this.close();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onOutputSurface$3$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m203x7933371(final SurfaceOutput surfaceOutput) {
        Surface surface = surfaceOutput.getSurface(this.mGlExecutor, new Consumer() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                DefaultSurfaceProcessor.this.m202xe1ff2a70(surfaceOutput, (SurfaceOutput.Event) obj);
            }
        });
        this.mGlRenderer.registerOutputSurface(surface);
        this.mOutputSurfaces.put(surfaceOutput, surface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onOutputSurface$2$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m202xe1ff2a70(SurfaceOutput surfaceOutput, SurfaceOutput.Event event) {
        surfaceOutput.close();
        Surface remove = this.mOutputSurfaces.remove(surfaceOutput);
        if (remove != null) {
            this.mGlRenderer.unregisterOutputSurface(remove);
        }
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
        if (this.mIsReleaseRequested.getAndSet(true)) {
            return;
        }
        executeSafely(new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.this.m204x94a4be2c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$4$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m204x94a4be2c() {
        this.mIsReleased = true;
        checkReadyToRelease();
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public ListenableFuture<Void> snapshot(final int i, final int i2) {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda4
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return DefaultSurfaceProcessor.this.m206xc377e846(i, i2, completer);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$snapshot$7$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ Object m206xc377e846(int i, int i2, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final AutoValue_DefaultSurfaceProcessor_PendingSnapshot of = PendingSnapshot.of(i, i2, completer);
        executeSafely(new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.this.m205x784fd644(of);
            }
        }, new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CallbackToFutureAdapter.Completer.this.setException(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
            }
        });
        return "DefaultSurfaceProcessor#snapshot";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$snapshot$5$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m205x784fd644(PendingSnapshot pendingSnapshot) {
        this.mPendingSnapshots.add(pendingSnapshot);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.mIsReleaseRequested.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.mTextureMatrix);
        Triple<Surface, Size, float[]> triple = null;
        for (Map.Entry<SurfaceOutput, Surface> entry : this.mOutputSurfaces.entrySet()) {
            Surface value = entry.getValue();
            SurfaceOutput key = entry.getKey();
            key.updateTransformMatrix(this.mSurfaceOutputMatrix, this.mTextureMatrix);
            if (key.getFormat() == 34) {
                try {
                    this.mGlRenderer.render(surfaceTexture.getTimestamp(), this.mSurfaceOutputMatrix, value);
                } catch (RuntimeException e) {
                    Logger.e(TAG, "Failed to render with OpenGL.", e);
                }
            } else {
                Preconditions.checkState(key.getFormat() == 256, "Unsupported format: " + key.getFormat());
                Preconditions.checkState(triple == null, "Only one JPEG output is supported.");
                triple = new Triple<>(value, key.getSize(), (float[]) this.mSurfaceOutputMatrix.clone());
            }
        }
        try {
            takeSnapshotAndDrawJpeg(triple);
        } catch (RuntimeException e2) {
            failAllPendingSnapshots(e2);
        }
    }

    private void takeSnapshotAndDrawJpeg(Triple<Surface, Size, float[]> triple) {
        if (this.mPendingSnapshots.isEmpty()) {
            return;
        }
        if (triple == null) {
            failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator<PendingSnapshot> it = this.mPendingSnapshots.iterator();
                int i = -1;
                int i2 = -1;
                Bitmap bitmap = null;
                byte[] bArr = null;
                while (it.hasNext()) {
                    PendingSnapshot next = it.next();
                    if (i != next.getRotationDegrees() || bitmap == null) {
                        i = next.getRotationDegrees();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        bitmap = getBitmap(triple.getSecond(), triple.getThird(), i);
                        i2 = -1;
                    }
                    if (i2 != next.getJpegQuality()) {
                        byteArrayOutputStream.reset();
                        i2 = next.getJpegQuality();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    ImageProcessingUtil.writeJpegBytesToSurface(triple.getFirst(), (byte[]) Objects.requireNonNull(bArr));
                    next.getCompleter().set(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            failAllPendingSnapshots(e);
        }
    }

    private void failAllPendingSnapshots(Throwable th) {
        Iterator<PendingSnapshot> it = this.mPendingSnapshots.iterator();
        while (it.hasNext()) {
            it.next().getCompleter().setException(th);
        }
        this.mPendingSnapshots.clear();
    }

    private Bitmap getBitmap(Size size, float[] fArr, int i) {
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        MatrixExt.preVerticalFlip(fArr2, 0.5f);
        MatrixExt.preRotate(fArr2, i, 0.5f, 0.5f);
        Matrix.multiplyMM(fArr2, 0, fArr2, 0, fArr, 0);
        return this.mGlRenderer.snapshot(TransformUtils.rotateSize(size, i), fArr2);
    }

    private void checkReadyToRelease() {
        if (this.mIsReleased && this.mInputSurfaceCount == 0) {
            Iterator<SurfaceOutput> it = this.mOutputSurfaces.keySet().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<PendingSnapshot> it2 = this.mPendingSnapshots.iterator();
            while (it2.hasNext()) {
                it2.next().getCompleter().setException(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.mOutputSurfaces.clear();
            this.mGlRenderer.release();
            this.mGlThread.quit();
        }
    }

    private void initGlRenderer(final DynamicRange dynamicRange, final ShaderProvider shaderProvider) {
        try {
            CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return DefaultSurfaceProcessor.this.m199x5398b3bc(dynamicRange, shaderProvider, completer);
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            boolean z = e instanceof ExecutionException;
            Throwable th = e;
            if (z) {
                th = e.getCause();
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initGlRenderer$9$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ Object m199x5398b3bc(final DynamicRange dynamicRange, final ShaderProvider shaderProvider, final CallbackToFutureAdapter.Completer completer) throws Exception {
        executeSafely(new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.this.m198x2e04aabb(dynamicRange, shaderProvider, completer);
            }
        });
        return "Init GlRenderer";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initGlRenderer$8$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m198x2e04aabb(DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.Completer completer) {
        try {
            this.mGlRenderer.init(dynamicRange, shaderProvider);
            completer.set(null);
        } catch (RuntimeException e) {
            completer.setException(e);
        }
    }

    private void executeSafely(Runnable runnable) {
        executeSafely(runnable, new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.lambda$executeSafely$10();
            }
        });
    }

    private void executeSafely(final Runnable runnable, final Runnable runnable2) {
        try {
            this.mGlExecutor.execute(new Runnable() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSurfaceProcessor.this.m197x1dd83064(runnable2, runnable);
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.w(TAG, "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$executeSafely$11$androidx-camera-core-processing-DefaultSurfaceProcessor, reason: not valid java name */
    public /* synthetic */ void m197x1dd83064(Runnable runnable, Runnable runnable2) {
        if (this.mIsReleased) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class PendingSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract CallbackToFutureAdapter.Completer<Void> getCompleter();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getJpegQuality();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getRotationDegrees();

        static AutoValue_DefaultSurfaceProcessor_PendingSnapshot of(int i, int i2, CallbackToFutureAdapter.Completer<Void> completer) {
            return new AutoValue_DefaultSurfaceProcessor_PendingSnapshot(i, i2, completer);
        }
    }

    /* loaded from: classes.dex */
    public static class Factory {
        private static Function<DynamicRange, SurfaceProcessorInternal> sSupplier = new Function() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$Factory$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return new DefaultSurfaceProcessor((DynamicRange) obj);
            }
        };

        private Factory() {
        }

        public static SurfaceProcessorInternal newInstance(DynamicRange dynamicRange) {
            return sSupplier.apply(dynamicRange);
        }

        public static void setSupplier(Function<DynamicRange, SurfaceProcessorInternal> function) {
            sSupplier = function;
        }
    }
}
