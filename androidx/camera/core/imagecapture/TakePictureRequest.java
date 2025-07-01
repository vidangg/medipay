package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.internal.compat.workaround.CaptureFailedRetryEnabler;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class TakePictureRequest {
    private int mRemainingRetires = new CaptureFailedRetryEnabler().getRetryCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface RetryControl {
        void retryRequest(TakePictureRequest takePictureRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Executor getAppExecutor();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getCaptureMode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Rect getCropRect();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImageCapture.OnImageCapturedCallback getInMemoryCallback();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getJpegQuality();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImageCapture.OnImageSavedCallback getOnDiskCallback();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getRotationDegrees();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Matrix getSensorToBufferTransform();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean decrementRetryCounter() {
        Threads.checkMainThread();
        int i = this.mRemainingRetires;
        if (i <= 0) {
            return false;
        }
        this.mRemainingRetires = i - 1;
        return true;
    }

    void incrementRetryCounter() {
        Threads.checkMainThread();
        this.mRemainingRetires++;
    }

    int getRemainingRetries() {
        Threads.checkMainThread();
        return this.mRemainingRetires;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onError(final ImageCaptureException imageCaptureException) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureRequest$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.this.m182x9daf4b5c(imageCaptureException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onError$0$androidx-camera-core-imagecapture-TakePictureRequest, reason: not valid java name */
    public /* synthetic */ void m182x9daf4b5c(ImageCaptureException imageCaptureException) {
        boolean z = getInMemoryCallback() != null;
        boolean z2 = getOnDiskCallback() != null;
        if (z && !z2) {
            ((ImageCapture.OnImageCapturedCallback) Objects.requireNonNull(getInMemoryCallback())).onError(imageCaptureException);
        } else {
            if (z2 && !z) {
                ((ImageCapture.OnImageSavedCallback) Objects.requireNonNull(getOnDiskCallback())).onError(imageCaptureException);
                return;
            }
            throw new IllegalStateException("One and only one callback is allowed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onResult$1$androidx-camera-core-imagecapture-TakePictureRequest, reason: not valid java name */
    public /* synthetic */ void m183x75636bce(ImageCapture.OutputFileResults outputFileResults) {
        ((ImageCapture.OnImageSavedCallback) Objects.requireNonNull(getOnDiskCallback())).onImageSaved((ImageCapture.OutputFileResults) Objects.requireNonNull(outputFileResults));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResult(final ImageCapture.OutputFileResults outputFileResults) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureRequest$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.this.m183x75636bce(outputFileResults);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onResult$2$androidx-camera-core-imagecapture-TakePictureRequest, reason: not valid java name */
    public /* synthetic */ void m184x8f7eea6d(ImageProxy imageProxy) {
        ((ImageCapture.OnImageCapturedCallback) Objects.requireNonNull(getInMemoryCallback())).onCaptureSuccess((ImageProxy) Objects.requireNonNull(imageProxy));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResult(final ImageProxy imageProxy) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.this.m184x8f7eea6d(imageProxy);
            }
        });
    }

    public static TakePictureRequest of(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback, ImageCapture.OutputFileOptions outputFileOptions, Rect rect, Matrix matrix, int i, int i2, int i3, List<CameraCaptureCallback> list) {
        Preconditions.checkArgument((onImageSavedCallback == null) == (outputFileOptions == null), "onDiskCallback and outputFileOptions should be both null or both non-null.");
        Preconditions.checkArgument((onImageCapturedCallback == null) ^ (onImageSavedCallback == null), "One and only one on-disk or in-memory callback should be present.");
        return new AutoValue_TakePictureRequest(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, rect, matrix, i, i2, i3, list);
    }
}
