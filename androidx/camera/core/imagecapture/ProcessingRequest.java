package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ProcessingRequest {
    private final TakePictureCallback mCallback;
    final ListenableFuture<Void> mCaptureFuture;
    private final Rect mCropRect;
    private final int mJpegQuality;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private final List<Integer> mStageIds = new ArrayList();
    private final String mTagBundleKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessingRequest(CaptureBundle captureBundle, ImageCapture.OutputFileOptions outputFileOptions, Rect rect, int i, int i2, Matrix matrix, TakePictureCallback takePictureCallback, ListenableFuture<Void> listenableFuture) {
        this.mOutputFileOptions = outputFileOptions;
        this.mJpegQuality = i2;
        this.mRotationDegrees = i;
        this.mCropRect = rect;
        this.mSensorToBufferTransform = matrix;
        this.mCallback = takePictureCallback;
        this.mTagBundleKey = String.valueOf(captureBundle.hashCode());
        Iterator it = ((List) Objects.requireNonNull(captureBundle.getCaptureStages())).iterator();
        while (it.hasNext()) {
            this.mStageIds.add(Integer.valueOf(((CaptureStage) it.next()).getId()));
        }
        this.mCaptureFuture = listenableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Integer> getStageIds() {
        return this.mStageIds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.mOutputFileOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect getCropRect() {
        return this.mCropRect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getJpegQuality() {
        return this.mJpegQuality;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInMemoryCapture() {
        return getOutputFileOptions() == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onImageCaptured() {
        this.mCallback.onImageCaptured();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFinalResult(ImageCapture.OutputFileResults outputFileResults) {
        this.mCallback.onFinalResult(outputFileResults);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFinalResult(ImageProxy imageProxy) {
        this.mCallback.onFinalResult(imageProxy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onProcessFailure(ImageCaptureException imageCaptureException) {
        this.mCallback.onProcessFailure(imageCaptureException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCaptureFailure(ImageCaptureException imageCaptureException) {
        this.mCallback.onCaptureFailure(imageCaptureException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAborted() {
        return this.mCallback.isAborted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFuture<Void> getCaptureFuture() {
        return this.mCaptureFuture;
    }
}
