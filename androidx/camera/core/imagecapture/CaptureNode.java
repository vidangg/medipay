package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CaptureNode implements Node<In, Out> {
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";
    private In mInputEdge;
    private Out mOutputEdge;
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;
    private final Set<Integer> mPendingStageIds = new HashSet();
    ProcessingRequest mCurrentRequest = null;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.core.processing.Node
    public Out transform(In in) {
        Consumer<ProcessingRequest> consumer;
        NoMetadataImageReader noMetadataImageReader;
        Preconditions.checkState(this.mInputEdge == null && this.mSafeCloseImageReaderProxy == null, "CaptureNode does not support recreation yet.");
        this.mInputEdge = in;
        Size size = in.getSize();
        int inputFormat = in.getInputFormat();
        if ((true ^ in.isVirtualCamera()) && in.getImageReaderProxyProvider() == null) {
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), inputFormat, 4);
            in.setCameraCaptureCallback(metadataImageReader.getCameraCaptureCallback());
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    CaptureNode.this.onRequestAvailable((ProcessingRequest) obj);
                }
            };
            noMetadataImageReader = metadataImageReader;
        } else {
            final NoMetadataImageReader noMetadataImageReader2 = new NoMetadataImageReader(createImageReaderProxy(in.getImageReaderProxyProvider(), size.getWidth(), size.getHeight(), inputFormat));
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda1
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    CaptureNode.this.m172lambda$transform$0$androidxcameracoreimagecaptureCaptureNode(noMetadataImageReader2, (ProcessingRequest) obj);
                }
            };
            noMetadataImageReader = noMetadataImageReader2;
        }
        in.setSurface((Surface) Objects.requireNonNull(noMetadataImageReader.getSurface()));
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(noMetadataImageReader);
        noMetadataImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda2
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                CaptureNode.this.m173lambda$transform$1$androidxcameracoreimagecaptureCaptureNode(imageReaderProxy);
            }
        }, CameraXExecutors.mainThreadExecutor());
        in.getRequestEdge().setListener(consumer);
        in.getErrorEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CaptureNode.this.sendCaptureError((ImageCaptureException) obj);
            }
        });
        Out of = Out.of(in.getInputFormat(), in.getOutputFormat());
        this.mOutputEdge = of;
        return of;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$transform$0$androidx-camera-core-imagecapture-CaptureNode, reason: not valid java name */
    public /* synthetic */ void m172lambda$transform$0$androidxcameracoreimagecaptureCaptureNode(NoMetadataImageReader noMetadataImageReader, ProcessingRequest processingRequest) {
        onRequestAvailable(processingRequest);
        noMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$transform$1$androidx-camera-core-imagecapture-CaptureNode, reason: not valid java name */
    public /* synthetic */ void m173lambda$transform$1$androidxcameracoreimagecaptureCaptureNode(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                onImageProxyAvailable(acquireLatestImage);
            } else {
                sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", null));
            }
        } catch (IllegalStateException e) {
            sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", e));
        }
    }

    private static ImageReaderProxy createImageReaderProxy(ImageReaderProxyProvider imageReaderProxyProvider, int i, int i2, int i3) {
        if (imageReaderProxyProvider != null) {
            return imageReaderProxyProvider.newInstance(i, i2, i3, 4, 0L);
        }
        return ImageReaderProxys.createIsolatedReader(i, i2, i3, 4);
    }

    void onImageProxyAvailable(ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest == null) {
            Logger.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
            imageProxy.close();
            return;
        }
        matchAndPropagateImage(imageProxy);
    }

    private void matchAndPropagateImage(ImageProxy imageProxy) {
        Integer num = (Integer) Objects.requireNonNull(imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey()));
        int intValue = num.intValue();
        Preconditions.checkState(this.mPendingStageIds.contains(num), "Received an unexpected stage id" + intValue);
        this.mPendingStageIds.remove(num);
        ((Out) Objects.requireNonNull(this.mOutputEdge)).getImageEdge().accept(imageProxy);
        if (this.mPendingStageIds.isEmpty()) {
            ProcessingRequest processingRequest = this.mCurrentRequest;
            this.mCurrentRequest = null;
            processingRequest.onImageCaptured();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRequestAvailable(final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        boolean z = true;
        Preconditions.checkState(getCapacity() > 0, "Too many acquire images. Close image to be able to process next.");
        if (this.mCurrentRequest != null && !this.mPendingStageIds.isEmpty()) {
            z = false;
        }
        Preconditions.checkState(z, "The previous request is not complete");
        this.mCurrentRequest = processingRequest;
        this.mPendingStageIds.addAll(processingRequest.getStageIds());
        ((Out) Objects.requireNonNull(this.mOutputEdge)).getRequestEdge().accept(processingRequest);
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.CaptureNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                Threads.checkMainThread();
                if (processingRequest == CaptureNode.this.mCurrentRequest) {
                    CaptureNode.this.mCurrentRequest = null;
                }
            }
        }, CameraXExecutors.directExecutor());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendCaptureError(ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null) {
            processingRequest.onCaptureFailure(imageCaptureException);
        }
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        Threads.checkMainThread();
        releaseInputResources((In) Objects.requireNonNull(this.mInputEdge), (SafeCloseImageReaderProxy) Objects.requireNonNull(this.mSafeCloseImageReaderProxy));
    }

    private void releaseInputResources(In in, final SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        in.getSurface().close();
        ListenableFuture<Void> terminationFuture = in.getSurface().getTerminationFuture();
        Objects.requireNonNull(safeCloseImageReaderProxy);
        terminationFuture.addListener(new Runnable() { // from class: androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                SafeCloseImageReaderProxy.this.safeClose();
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    In getInputEdge() {
        return (In) Objects.requireNonNull(this.mInputEdge);
    }

    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        return (SafeCloseImageReaderProxy) Objects.requireNonNull(this.mSafeCloseImageReaderProxy);
    }

    public int getCapacity() {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.imagecapture.CaptureNode.In.1
        };
        private DeferrableSurface mSurface;

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<ImageCaptureException> getErrorEdge();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getInputFormat();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getOutputFormat();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<ProcessingRequest> getRequestEdge();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Size getSize();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean isVirtualCamera();

        /* JADX INFO: Access modifiers changed from: package-private */
        public DeferrableSurface getSurface() {
            return (DeferrableSurface) Objects.requireNonNull(this.mSurface);
        }

        void setSurface(Surface surface) {
            Preconditions.checkState(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        void setCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static In of(Size size, int i, int i2, boolean z, ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i, i2, z, imageReaderProxyProvider, new Edge(), new Edge());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Out {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<ImageProxy> getImageEdge();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getInputFormat();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getOutputFormat();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<ProcessingRequest> getRequestEdge();

        static Out of(int i, int i2) {
            return new AutoValue_CaptureNode_Out(new Edge(), new Edge(), i, i2);
        }
    }
}
