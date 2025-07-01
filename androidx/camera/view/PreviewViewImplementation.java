package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class PreviewViewImplementation {
    FrameLayout mParent;
    private final PreviewTransformation mPreviewTransform;
    Size mResolution;
    private boolean mWasSurfaceProvided = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnSurfaceNotInUseListener {
        void onSurfaceNotInUse();
    }

    abstract View getPreview();

    abstract Bitmap getPreviewBitmap();

    abstract void initializePreview();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onAttachedToWindow();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onDetachedFromWindow();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onSurfaceRequested(SurfaceRequest surfaceRequest, OnSurfaceNotInUseListener onSurfaceNotInUseListener);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFrameUpdateListener(Executor executor, PreviewView.OnFrameUpdateListener onFrameUpdateListener) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> waitForNextFrame();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        this.mParent = frameLayout;
        this.mPreviewTransform = previewTransformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void redrawPreview() {
        View preview = getPreview();
        if (preview == null || !this.mWasSurfaceProvided) {
            return;
        }
        this.mPreviewTransform.transformView(new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection(), preview);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSurfaceProvided() {
        this.mWasSurfaceProvided = true;
        redrawPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap getBitmap() {
        Bitmap previewBitmap = getPreviewBitmap();
        if (previewBitmap == null) {
            return null;
        }
        return this.mPreviewTransform.createTransformedBitmap(previewBitmap, new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection());
    }
}
