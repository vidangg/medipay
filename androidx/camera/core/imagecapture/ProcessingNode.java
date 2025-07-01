package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ProcessingNode implements Node<In, Void> {
    private Operation<Bitmap2JpegBytes.In, Packet<byte[]>> mBitmap2JpegBytes;
    private Operation<Packet<Bitmap>, Packet<Bitmap>> mBitmapEffect;
    final Executor mBlockingExecutor;
    private final boolean mHasIncorrectJpegMetadataQuirk;
    private Operation<Image2JpegBytes.In, Packet<byte[]>> mImage2JpegBytes;
    final InternalImageProcessor mImageProcessor;
    private Operation<InputPacket, Packet<ImageProxy>> mInput2Packet;
    private In mInputEdge;
    private Operation<Packet<byte[]>, Packet<Bitmap>> mJpegBytes2CroppedBitmap;
    private Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> mJpegBytes2Disk;
    private Operation<Packet<byte[]>, Packet<ImageProxy>> mJpegBytes2Image;
    private Operation<Packet<ImageProxy>, ImageProxy> mJpegImage2Result;
    private final Quirks mQuirks;

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }

    ProcessingNode(Executor executor) {
        this(executor, null, DeviceQuirks.getAll());
    }

    ProcessingNode(Executor executor, Quirks quirks) {
        this(executor, null, quirks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessingNode(Executor executor, InternalImageProcessor internalImageProcessor) {
        this(executor, internalImageProcessor, DeviceQuirks.getAll());
    }

    ProcessingNode(Executor executor, InternalImageProcessor internalImageProcessor, Quirks quirks) {
        if (DeviceQuirks.get(LowMemoryQuirk.class) != null) {
            this.mBlockingExecutor = CameraXExecutors.newSequentialExecutor(executor);
        } else {
            this.mBlockingExecutor = executor;
        }
        this.mImageProcessor = internalImageProcessor;
        this.mQuirks = quirks;
        this.mHasIncorrectJpegMetadataQuirk = quirks.contains(IncorrectJpegMetadataQuirk.class);
    }

    @Override // androidx.camera.core.processing.Node
    public Void transform(In in) {
        this.mInputEdge = in;
        in.getEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ProcessingNode.this.m176xc5c546f5((ProcessingNode.InputPacket) obj);
            }
        });
        this.mInput2Packet = new ProcessingInput2Packet();
        this.mImage2JpegBytes = new Image2JpegBytes(this.mQuirks);
        this.mJpegBytes2CroppedBitmap = new JpegBytes2CroppedBitmap();
        this.mBitmap2JpegBytes = new Bitmap2JpegBytes();
        this.mJpegBytes2Disk = new JpegBytes2Disk();
        this.mJpegImage2Result = new JpegImage2Result();
        if (in.getInputFormat() == 35 || this.mImageProcessor != null || this.mHasIncorrectJpegMetadataQuirk) {
            this.mJpegBytes2Image = new JpegBytes2Image();
        }
        InternalImageProcessor internalImageProcessor = this.mImageProcessor;
        if (internalImageProcessor == null) {
            return null;
        }
        this.mBitmapEffect = new BitmapEffect(internalImageProcessor);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$transform$1$androidx-camera-core-imagecapture-ProcessingNode, reason: not valid java name */
    public /* synthetic */ void m176xc5c546f5(final InputPacket inputPacket) {
        if (inputPacket.getProcessingRequest().isAborted()) {
            return;
        }
        this.mBlockingExecutor.execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingNode.this.m175xd41ba0d6(inputPacket);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: processInputPacket, reason: merged with bridge method [inline-methods] */
    public void m175xd41ba0d6(InputPacket inputPacket) {
        final ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        try {
            if (inputPacket.getProcessingRequest().isInMemoryCapture()) {
                final ImageProxy processInMemoryCapture = processInMemoryCapture(inputPacket);
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingRequest.this.onFinalResult(processInMemoryCapture);
                    }
                });
            } else {
                final ImageCapture.OutputFileResults processOnDiskCapture = processOnDiskCapture(inputPacket);
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingRequest.this.onFinalResult(processOnDiskCapture);
                    }
                });
            }
        } catch (ImageCaptureException e) {
            sendError(processingRequest, e);
        } catch (OutOfMemoryError e2) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed due to low memory.", e2));
        } catch (RuntimeException e3) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed.", e3));
        }
    }

    ImageCapture.OutputFileResults processOnDiskCapture(InputPacket inputPacket) throws ImageCaptureException {
        Preconditions.checkArgument(this.mInputEdge.getOutputFormat() == 256, String.format("On-disk capture only support JPEG output format. Output format: %s", Integer.valueOf(this.mInputEdge.getOutputFormat())));
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet<byte[]> apply = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(this.mInput2Packet.apply(inputPacket), processingRequest.getJpegQuality()));
        if (apply.hasCropping() || this.mBitmapEffect != null) {
            apply = cropAndMaybeApplyEffect(apply, processingRequest.getJpegQuality());
        }
        return this.mJpegBytes2Disk.apply(JpegBytes2Disk.In.of(apply, (ImageCapture.OutputFileOptions) Objects.requireNonNull(processingRequest.getOutputFileOptions())));
    }

    ImageProxy processInMemoryCapture(InputPacket inputPacket) throws ImageCaptureException {
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet<ImageProxy> apply = this.mInput2Packet.apply(inputPacket);
        if ((apply.getFormat() == 35 || this.mBitmapEffect != null || this.mHasIncorrectJpegMetadataQuirk) && this.mInputEdge.getOutputFormat() == 256) {
            Packet<byte[]> apply2 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(apply, processingRequest.getJpegQuality()));
            if (this.mBitmapEffect != null) {
                apply2 = cropAndMaybeApplyEffect(apply2, processingRequest.getJpegQuality());
            }
            apply = this.mJpegBytes2Image.apply(apply2);
        }
        return this.mJpegImage2Result.apply(apply);
    }

    private Packet<byte[]> cropAndMaybeApplyEffect(Packet<byte[]> packet, int i) throws ImageCaptureException {
        Preconditions.checkState(packet.getFormat() == 256);
        Packet<Bitmap> apply = this.mJpegBytes2CroppedBitmap.apply(packet);
        Operation<Packet<Bitmap>, Packet<Bitmap>> operation = this.mBitmapEffect;
        if (operation != null) {
            apply = operation.apply(apply);
        }
        return this.mBitmap2JpegBytes.apply(Bitmap2JpegBytes.In.of(apply, i));
    }

    private static void sendError(final ProcessingRequest processingRequest, final ImageCaptureException imageCaptureException) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingRequest.this.onProcessFailure(imageCaptureException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class InputPacket {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract ImageProxy getImageProxy();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract ProcessingRequest getProcessingRequest();

        /* JADX INFO: Access modifiers changed from: package-private */
        public static InputPacket of(ProcessingRequest processingRequest, ImageProxy imageProxy) {
            return new AutoValue_ProcessingNode_InputPacket(processingRequest, imageProxy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<InputPacket> getEdge();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getInputFormat();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getOutputFormat();

        /* JADX INFO: Access modifiers changed from: package-private */
        public static In of(int i, int i2) {
            return new AutoValue_ProcessingNode_In(new Edge(), i, i2);
        }
    }

    void injectProcessingInput2Packet(Operation<InputPacket, Packet<ImageProxy>> operation) {
        this.mInput2Packet = operation;
    }
}
