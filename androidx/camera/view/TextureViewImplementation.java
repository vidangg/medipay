package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TextureViewImplementation extends PreviewViewImplementation {
    private static final String TAG = "TextureViewImpl";
    SurfaceTexture mDetachedSurfaceTexture;
    Executor mFrameUpdateExecutor;
    boolean mIsSurfaceTextureDetachedFromView;
    AtomicReference<CallbackToFutureAdapter.Completer<Void>> mNextFrameCompleter;
    PreviewView.OnFrameUpdateListener mOnFrameUpdateListener;
    PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    ListenableFuture<SurfaceRequest.Result> mSurfaceReleaseFuture;
    SurfaceRequest mSurfaceRequest;
    SurfaceTexture mSurfaceTexture;
    TextureView mTextureView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextureViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
        this.mIsSurfaceTextureDetachedFromView = false;
        this.mNextFrameCompleter = new AtomicReference<>();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    View getPreview() {
        return this.mTextureView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void onAttachedToWindow() {
        reattachSurfaceTexture();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void onDetachedFromWindow() {
        this.mIsSurfaceTextureDetachedFromView = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void onSurfaceRequested(final SurfaceRequest surfaceRequest, PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.mResolution = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = onSurfaceNotInUseListener;
        initializePreview();
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mTextureView.getContext()), new Runnable() { // from class: androidx.camera.view.TextureViewImplementation$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TextureViewImplementation.this.m306xce057d29(surfaceRequest);
            }
        });
        tryToProvidePreviewSurface();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSurfaceRequested$0$androidx-camera-view-TextureViewImplementation, reason: not valid java name */
    public /* synthetic */ void m306xce057d29(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.mSurfaceRequest = null;
            this.mSurfaceReleaseFuture = null;
        }
        notifySurfaceNotInUse();
    }

    private void notifySurfaceNotInUse() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (onSurfaceNotInUseListener != null) {
            onSurfaceNotInUseListener.onSurfaceNotInUse();
            this.mOnSurfaceNotInUseListener = null;
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    public void initializePreview() {
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        TextureView textureView = new TextureView(this.mParent.getContext());
        this.mTextureView = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mTextureView.setSurfaceTextureListener(new AnonymousClass1());
        this.mParent.removeAllViews();
        this.mParent.addView(this.mTextureView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.view.TextureViewImplementation$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Logger.d(TextureViewImplementation.TAG, "SurfaceTexture available. Size: " + i + "x" + i2);
            TextureViewImplementation.this.mSurfaceTexture = surfaceTexture;
            if (TextureViewImplementation.this.mSurfaceReleaseFuture != null) {
                Preconditions.checkNotNull(TextureViewImplementation.this.mSurfaceRequest);
                Logger.d(TextureViewImplementation.TAG, "Surface invalidated " + TextureViewImplementation.this.mSurfaceRequest);
                TextureViewImplementation.this.mSurfaceRequest.getDeferrableSurface().close();
                return;
            }
            TextureViewImplementation.this.tryToProvidePreviewSurface();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Logger.d(TextureViewImplementation.TAG, "SurfaceTexture size changed: " + i + "x" + i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(final SurfaceTexture surfaceTexture) {
            TextureViewImplementation.this.mSurfaceTexture = null;
            if (TextureViewImplementation.this.mSurfaceReleaseFuture != null) {
                Futures.addCallback(TextureViewImplementation.this.mSurfaceReleaseFuture, new FutureCallback<SurfaceRequest.Result>() { // from class: androidx.camera.view.TextureViewImplementation.1.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(SurfaceRequest.Result result) {
                        Preconditions.checkState(result.getResultCode() != 3, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                        Logger.d(TextureViewImplementation.TAG, "SurfaceTexture about to manually be destroyed");
                        surfaceTexture.release();
                        if (TextureViewImplementation.this.mDetachedSurfaceTexture != null) {
                            TextureViewImplementation.this.mDetachedSurfaceTexture = null;
                        }
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable th) {
                        throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
                    }
                }, ContextCompat.getMainExecutor(TextureViewImplementation.this.mTextureView.getContext()));
                TextureViewImplementation.this.mDetachedSurfaceTexture = surfaceTexture;
                return false;
            }
            Logger.d(TextureViewImplementation.TAG, "SurfaceTexture about to be destroyed");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(final SurfaceTexture surfaceTexture) {
            CallbackToFutureAdapter.Completer<Void> andSet = TextureViewImplementation.this.mNextFrameCompleter.getAndSet(null);
            if (andSet != null) {
                andSet.set(null);
            }
            final PreviewView.OnFrameUpdateListener onFrameUpdateListener = TextureViewImplementation.this.mOnFrameUpdateListener;
            Executor executor = TextureViewImplementation.this.mFrameUpdateExecutor;
            if (onFrameUpdateListener == null || executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.camera.view.TextureViewImplementation$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewView.OnFrameUpdateListener.this.onFrameUpdate(surfaceTexture.getTimestamp());
                }
            });
        }
    }

    void tryToProvidePreviewSurface() {
        SurfaceTexture surfaceTexture;
        if (this.mResolution == null || (surfaceTexture = this.mSurfaceTexture) == null || this.mSurfaceRequest == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(this.mResolution.getWidth(), this.mResolution.getHeight());
        final Surface surface = new Surface(this.mSurfaceTexture);
        final SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        final ListenableFuture<SurfaceRequest.Result> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.TextureViewImplementation$$ExternalSyntheticLambda3
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return TextureViewImplementation.this.m307xdd0bd278(surface, completer);
            }
        });
        this.mSurfaceReleaseFuture = future;
        future.addListener(new Runnable() { // from class: androidx.camera.view.TextureViewImplementation$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                TextureViewImplementation.this.m308x16d67457(surface, future, surfaceRequest);
            }
        }, ContextCompat.getMainExecutor(this.mTextureView.getContext()));
        onSurfaceProvided();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tryToProvidePreviewSurface$1$androidx-camera-view-TextureViewImplementation, reason: not valid java name */
    public /* synthetic */ Object m307xdd0bd278(Surface surface, final CallbackToFutureAdapter.Completer completer) throws Exception {
        Logger.d(TAG, "Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Executor directExecutor = CameraXExecutors.directExecutor();
        Objects.requireNonNull(completer);
        surfaceRequest.provideSurface(surface, directExecutor, new Consumer() { // from class: androidx.camera.view.TextureViewImplementation$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CallbackToFutureAdapter.Completer.this.set((SurfaceRequest.Result) obj);
            }
        });
        return "provideSurface[request=" + this.mSurfaceRequest + " surface=" + surface + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tryToProvidePreviewSurface$2$androidx-camera-view-TextureViewImplementation, reason: not valid java name */
    public /* synthetic */ void m308x16d67457(Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        Logger.d(TAG, "Safe to release surface.");
        notifySurfaceNotInUse();
        surface.release();
        if (this.mSurfaceReleaseFuture == listenableFuture) {
            this.mSurfaceReleaseFuture = null;
        }
        if (this.mSurfaceRequest == surfaceRequest) {
            this.mSurfaceRequest = null;
        }
    }

    private void reattachSurfaceTexture() {
        if (!this.mIsSurfaceTextureDetachedFromView || this.mDetachedSurfaceTexture == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.mDetachedSurfaceTexture;
        if (surfaceTexture != surfaceTexture2) {
            this.mTextureView.setSurfaceTexture(surfaceTexture2);
            this.mDetachedSurfaceTexture = null;
            this.mIsSurfaceTextureDetachedFromView = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public ListenableFuture<Void> waitForNextFrame() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.TextureViewImplementation$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return TextureViewImplementation.this.m309x86b0fc00(completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$waitForNextFrame$3$androidx-camera-view-TextureViewImplementation, reason: not valid java name */
    public /* synthetic */ Object m309x86b0fc00(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mNextFrameCompleter.set(completer);
        return "textureViewImpl_waitForNextFrame";
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    Bitmap getPreviewBitmap() {
        TextureView textureView = this.mTextureView;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.mTextureView.getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    public void setFrameUpdateListener(Executor executor, PreviewView.OnFrameUpdateListener onFrameUpdateListener) {
        this.mOnFrameUpdateListener = onFrameUpdateListener;
        this.mFrameUpdateExecutor = executor;
    }
}
