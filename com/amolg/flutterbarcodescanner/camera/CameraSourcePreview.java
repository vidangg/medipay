package com.amolg.flutterbarcodescanner.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.google.android.gms.common.images.Size;
import java.io.IOException;

/* loaded from: classes3.dex */
public class CameraSourcePreview extends ViewGroup {
    private static final String TAG = "CameraSourcePreview";
    private CameraSource mCameraSource;
    private Context mContext;
    private GraphicOverlay mOverlay;
    private boolean mStartRequested;
    private boolean mSurfaceAvailable;
    private SurfaceView mSurfaceView;

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mStartRequested = false;
        this.mSurfaceAvailable = false;
        SurfaceView surfaceView = new SurfaceView(context);
        this.mSurfaceView = surfaceView;
        surfaceView.getHolder().addCallback(new SurfaceCallback());
        addView(this.mSurfaceView);
    }

    public void start(CameraSource cameraSource) throws IOException, SecurityException {
        if (cameraSource == null) {
            stop();
        }
        this.mCameraSource = cameraSource;
        if (cameraSource != null) {
            this.mStartRequested = true;
            startIfReady();
        }
    }

    public void start(CameraSource cameraSource, GraphicOverlay graphicOverlay) throws IOException, SecurityException {
        this.mOverlay = graphicOverlay;
        start(cameraSource);
    }

    public void stop() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.stop();
        }
    }

    public void release() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.release();
            this.mCameraSource = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startIfReady() throws IOException, SecurityException {
        if (this.mStartRequested && this.mSurfaceAvailable) {
            this.mCameraSource.start(this.mSurfaceView.getHolder());
            if (this.mOverlay != null) {
                Size previewSize = this.mCameraSource.getPreviewSize();
                int min = Math.min(previewSize.getWidth(), previewSize.getHeight());
                int max = Math.max(previewSize.getWidth(), previewSize.getHeight());
                if (isPortraitMode()) {
                    this.mOverlay.setCameraInfo(min, max, this.mCameraSource.getCameraFacing());
                } else {
                    this.mOverlay.setCameraInfo(max, min, this.mCameraSource.getCameraFacing());
                }
                this.mOverlay.clear();
            }
            this.mStartRequested = false;
        }
    }

    /* loaded from: classes3.dex */
    private class SurfaceCallback implements SurfaceHolder.Callback {
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private SurfaceCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.mSurfaceAvailable = true;
            try {
                CameraSourcePreview.this.startIfReady();
            } catch (IOException e) {
                Log.e(CameraSourcePreview.TAG, "Could not start camera source.", e);
            } catch (SecurityException e2) {
                Log.e(CameraSourcePreview.TAG, "Do not have permission to start the camera", e2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.mSurfaceAvailable = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Size previewSize;
        if (isPortraitMode()) {
            i5 = i4 - i2;
            i6 = i3 - i;
        } else {
            i5 = i3 - i;
            i6 = i4 - i2;
        }
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null && (previewSize = cameraSource.getPreviewSize()) != null) {
            i5 = previewSize.getWidth();
            i6 = previewSize.getHeight();
        }
        if (isPortraitMode()) {
            int i7 = i6;
            i6 = i5;
            i5 = i7;
        }
        int i8 = i3 - i;
        int i9 = i4 - i2;
        float f = i5;
        float f2 = i6;
        int i10 = (int) ((i8 / f) * f2);
        if (i10 > i9) {
            i8 = (int) ((i9 / f2) * f);
        } else {
            i9 = i10;
        }
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            getChildAt(i11).layout(0, 0, i8, i9);
        }
        try {
            startIfReady();
        } catch (IOException e) {
            Log.e(TAG, "Could not start camera source.", e);
        } catch (SecurityException e2) {
            Log.e(TAG, "Do not have permission to start the camera", e2);
        }
    }

    private boolean isPortraitMode() {
        int i = this.mContext.getResources().getConfiguration().orientation;
        if (i == 2) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        Log.d(TAG, "isPortraitMode returning false by default");
        return false;
    }
}
