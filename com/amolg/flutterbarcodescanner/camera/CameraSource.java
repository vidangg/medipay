package com.amolg.flutterbarcodescanner.camera;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class CameraSource {
    private static final float ASPECT_RATIO_TOLERANCE = 0.01f;
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    private static final int DUMMY_TEXTURE_NAME = 100;
    private Map<byte[], ByteBuffer> mBytesToByteBuffer;
    private Camera mCamera;
    private final Object mCameraLock;
    private Context mContext;
    private SurfaceTexture mDummySurfaceTexture;
    private SurfaceView mDummySurfaceView;
    private int mFacing;
    private String mFlashMode;
    private String mFocusMode;
    private FrameProcessingRunnable mFrameProcessor;
    private Size mPreviewSize;
    private Thread mProcessingThread;
    private float mRequestedFps;
    private int mRequestedPreviewHeight;
    private int mRequestedPreviewWidth;
    private int mRotation;

    /* loaded from: classes3.dex */
    public interface AutoFocusCallback {
        void onAutoFocus(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface AutoFocusMoveCallback {
        void onAutoFocusMoving(boolean z);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    private @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    private @interface FocusMode {
    }

    /* loaded from: classes3.dex */
    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface ShutterCallback {
        void onShutter();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private CameraSource mCameraSource;
        private final Detector<?> mDetector;

        public Builder(Context context, Detector<?> detector) {
            CameraSource cameraSource = new CameraSource();
            this.mCameraSource = cameraSource;
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            }
            if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            }
            this.mDetector = detector;
            cameraSource.mContext = context;
        }

        public Builder setRequestedFps(float f) {
            if (f > 0.0f) {
                this.mCameraSource.mRequestedFps = f;
                return this;
            }
            throw new IllegalArgumentException("Invalid fps: " + f);
        }

        public Builder setFocusMode(String str) {
            this.mCameraSource.mFocusMode = str;
            return this;
        }

        public Builder setFlashMode(String str) {
            this.mCameraSource.mFlashMode = str;
            return this;
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i > 0 && i <= 1000000 && i2 > 0 && i2 <= 1000000) {
                this.mCameraSource.mRequestedPreviewWidth = i;
                this.mCameraSource.mRequestedPreviewHeight = i2;
                return this;
            }
            throw new IllegalArgumentException("Invalid preview size: " + i + "x" + i2);
        }

        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                this.mCameraSource.mFacing = i;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: " + i);
        }

        public CameraSource build() {
            CameraSource cameraSource = this.mCameraSource;
            CameraSource cameraSource2 = this.mCameraSource;
            Objects.requireNonNull(cameraSource2);
            cameraSource.mFrameProcessor = new FrameProcessingRunnable(this.mDetector);
            return this.mCameraSource;
        }
    }

    public void release() {
        synchronized (this.mCameraLock) {
            stop();
            this.mFrameProcessor.release();
        }
    }

    public CameraSource start() throws IOException {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                return this;
            }
            this.mCamera = createCamera();
            SurfaceTexture surfaceTexture = new SurfaceTexture(100);
            this.mDummySurfaceTexture = surfaceTexture;
            this.mCamera.setPreviewTexture(surfaceTexture);
            this.mCamera.startPreview();
            this.mProcessingThread = new Thread(this.mFrameProcessor);
            this.mFrameProcessor.setActive(true);
            this.mProcessingThread.start();
            return this;
        }
    }

    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                return this;
            }
            Camera createCamera = createCamera();
            this.mCamera = createCamera;
            createCamera.setPreviewDisplay(surfaceHolder);
            this.mCamera.startPreview();
            this.mProcessingThread = new Thread(this.mFrameProcessor);
            this.mFrameProcessor.setActive(true);
            this.mProcessingThread.start();
            return this;
        }
    }

    public void stop() {
        synchronized (this.mCameraLock) {
            this.mFrameProcessor.setActive(false);
            Thread thread = this.mProcessingThread;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused) {
                }
                this.mProcessingThread = null;
            }
            this.mBytesToByteBuffer.clear();
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.stopPreview();
                this.mCamera.setPreviewCallbackWithBuffer(null);
                try {
                    this.mCamera.setPreviewTexture(null);
                } catch (Exception unused2) {
                }
                this.mCamera.release();
                this.mCamera = null;
            }
        }
    }

    public Size getPreviewSize() {
        return this.mPreviewSize;
    }

    public int getCameraFacing() {
        return this.mFacing;
    }

    public int doZoom(float f) {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            int i = 0;
            if (camera == null) {
                return 0;
            }
            Camera.Parameters parameters = camera.getParameters();
            if (!parameters.isZoomSupported()) {
                return 0;
            }
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom() + 1;
            int round = Math.round(f > 1.0f ? zoom + (f * (maxZoom / 10)) : zoom * f) - 1;
            if (round >= 0) {
                i = round > maxZoom ? maxZoom : round;
            }
            parameters.setZoom(i);
            this.mCamera.setParameters(parameters);
            return i;
        }
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                PictureStartCallback pictureStartCallback = new PictureStartCallback();
                pictureStartCallback.mDelegate = shutterCallback;
                PictureDoneCallback pictureDoneCallback = new PictureDoneCallback();
                pictureDoneCallback.mDelegate = pictureCallback;
                this.mCamera.takePicture(pictureStartCallback, null, null, pictureDoneCallback);
            }
        }
    }

    public String getFocusMode() {
        return this.mFocusMode;
    }

    public boolean setFocusMode(String str) {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            if (camera != null && str != null) {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters.getSupportedFocusModes().contains(str)) {
                    parameters.setFocusMode(str);
                    this.mCamera.setParameters(parameters);
                    this.mFocusMode = str;
                    return true;
                }
            }
            return false;
        }
    }

    public String getFlashMode() {
        return this.mFlashMode;
    }

    public boolean setFlashMode(String str) {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            if (camera != null && str != null) {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters.getSupportedFlashModes().contains(str)) {
                    parameters.setFlashMode(str);
                    this.mCamera.setParameters(parameters);
                    this.mFlashMode = str;
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void autoFocus(AutoFocusCallback autoFocusCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                CameraAutoFocusCallback cameraAutoFocusCallback = null;
                Object[] objArr = 0;
                if (autoFocusCallback != null) {
                    CameraAutoFocusCallback cameraAutoFocusCallback2 = new CameraAutoFocusCallback();
                    cameraAutoFocusCallback2.mDelegate = autoFocusCallback;
                    cameraAutoFocusCallback = cameraAutoFocusCallback2;
                }
                this.mCamera.autoFocus(cameraAutoFocusCallback);
            }
        }
    }

    public void cancelAutoFocus() {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.cancelAutoFocus();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setAutoFocusMoveCallback(AutoFocusMoveCallback autoFocusMoveCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                CameraAutoFocusMoveCallback cameraAutoFocusMoveCallback = null;
                Object[] objArr = 0;
                if (autoFocusMoveCallback != null) {
                    CameraAutoFocusMoveCallback cameraAutoFocusMoveCallback2 = new CameraAutoFocusMoveCallback();
                    cameraAutoFocusMoveCallback2.mDelegate = autoFocusMoveCallback;
                    cameraAutoFocusMoveCallback = cameraAutoFocusMoveCallback2;
                }
                this.mCamera.setAutoFocusMoveCallback(cameraAutoFocusMoveCallback);
            }
        }
        return true;
    }

    private CameraSource() {
        this.mCameraLock = new Object();
        this.mFacing = 0;
        this.mRequestedFps = 30.0f;
        this.mRequestedPreviewWidth = 1024;
        this.mRequestedPreviewHeight = 768;
        this.mFocusMode = null;
        this.mFlashMode = null;
        this.mBytesToByteBuffer = new HashMap();
    }

    /* loaded from: classes3.dex */
    private class PictureStartCallback implements Camera.ShutterCallback {
        private ShutterCallback mDelegate;

        private PictureStartCallback() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            ShutterCallback shutterCallback = this.mDelegate;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    /* loaded from: classes3.dex */
    private class PictureDoneCallback implements Camera.PictureCallback {
        private PictureCallback mDelegate;

        private PictureDoneCallback() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.mDelegate;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.mCameraLock) {
                if (CameraSource.this.mCamera != null) {
                    CameraSource.this.mCamera.startPreview();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class CameraAutoFocusCallback implements Camera.AutoFocusCallback {
        private AutoFocusCallback mDelegate;

        private CameraAutoFocusCallback() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            AutoFocusCallback autoFocusCallback = this.mDelegate;
            if (autoFocusCallback != null) {
                autoFocusCallback.onAutoFocus(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    private class CameraAutoFocusMoveCallback implements Camera.AutoFocusMoveCallback {
        private AutoFocusMoveCallback mDelegate;

        private CameraAutoFocusMoveCallback() {
        }

        @Override // android.hardware.Camera.AutoFocusMoveCallback
        public void onAutoFocusMoving(boolean z, Camera camera) {
            AutoFocusMoveCallback autoFocusMoveCallback = this.mDelegate;
            if (autoFocusMoveCallback != null) {
                autoFocusMoveCallback.onAutoFocusMoving(z);
            }
        }
    }

    private Camera createCamera() {
        int idForRequestedCamera = getIdForRequestedCamera(this.mFacing);
        if (idForRequestedCamera == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera open = Camera.open(idForRequestedCamera);
        SizePair selectSizePair = selectSizePair(open, this.mRequestedPreviewWidth, this.mRequestedPreviewHeight);
        if (selectSizePair == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size pictureSize = selectSizePair.pictureSize();
        this.mPreviewSize = selectSizePair.previewSize();
        int[] selectPreviewFpsRange = selectPreviewFpsRange(open, this.mRequestedFps);
        if (selectPreviewFpsRange == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Camera.Parameters parameters = open.getParameters();
        if (pictureSize != null) {
            parameters.setPictureSize(pictureSize.getWidth(), pictureSize.getHeight());
        }
        parameters.setPreviewSize(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
        parameters.setPreviewFpsRange(selectPreviewFpsRange[0], selectPreviewFpsRange[1]);
        parameters.setPreviewFormat(17);
        setRotation(open, parameters, idForRequestedCamera);
        if (this.mFocusMode != null && parameters.getSupportedFocusModes().contains(this.mFocusMode)) {
            parameters.setFocusMode(this.mFocusMode);
        }
        this.mFocusMode = parameters.getFocusMode();
        if (this.mFlashMode != null && parameters.getSupportedFlashModes() != null && parameters.getSupportedFlashModes().contains(this.mFlashMode)) {
            parameters.setFlashMode(this.mFlashMode);
        }
        this.mFlashMode = parameters.getFlashMode();
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new CameraPreviewCallback());
        open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        open.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        return open;
    }

    private static int getIdForRequestedCamera(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    private static SizePair selectSizePair(Camera camera, int i, int i2) {
        return new SizePair(getOptimalPreviewSize(camera.getParameters().getSupportedPreviewSizes(), i, i2), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SizePair {
        private Size mPicture;
        private Size mPreview;

        public SizePair(Camera.Size size, Camera.Size size2) {
            this.mPreview = new Size(size.width, size.height);
            if (size2 != null) {
                this.mPicture = new Size(size2.width, size2.height);
            }
        }

        public Size previewSize() {
            return this.mPreview;
        }

        public Size pictureSize() {
            return this.mPicture;
        }
    }

    private static List<SizePair> generateValidPreviewSizeList(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = size.width / size.height;
            Iterator<Camera.Size> it = supportedPictureSizes.iterator();
            while (true) {
                if (it.hasNext()) {
                    Camera.Size next = it.next();
                    if (Math.abs(f - (next.width / next.height)) < ASPECT_RATIO_TOLERANCE) {
                        arrayList.add(new SizePair(size, next));
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
            while (it2.hasNext()) {
                arrayList.add(new SizePair(it2.next(), null));
            }
        }
        return arrayList;
    }

    private int[] selectPreviewFpsRange(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (abs < i2) {
                iArr = iArr2;
                i2 = abs;
            }
        }
        return iArr;
    }

    private void setRotation(Camera camera, Camera.Parameters parameters, int i) {
        int i2;
        int i3;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i4 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i4 = 90;
            } else if (rotation == 2) {
                i4 = 180;
            } else if (rotation == 3) {
                i4 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i2 = (cameraInfo.orientation + i4) % 360;
            i3 = (360 - i2) % 360;
        } else {
            i2 = ((cameraInfo.orientation - i4) + 360) % 360;
            i3 = i2;
        }
        this.mRotation = i2 / 90;
        camera.setDisplayOrientation(i3);
        parameters.setRotation(i2);
    }

    private byte[] createPreviewBuffer(Size size) {
        byte[] bArr = new byte[((int) Math.ceil(((size.getHeight() * size.getWidth()) * ImageFormat.getBitsPerPixel(17)) / 8.0d)) + 1];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.mBytesToByteBuffer.put(bArr, wrap);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class CameraPreviewCallback implements Camera.PreviewCallback {
        private CameraPreviewCallback() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.mFrameProcessor.setNextFrame(bArr, camera);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class FrameProcessingRunnable implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Detector<?> mDetector;
        private ByteBuffer mPendingFrameData;
        private long mPendingTimeMillis;
        private long mStartTimeMillis = SystemClock.elapsedRealtime();
        private final Object mLock = new Object();
        private boolean mActive = true;
        private int mPendingFrameId = 0;

        FrameProcessingRunnable(Detector<?> detector) {
            this.mDetector = detector;
        }

        void release() {
            Detector<?> detector = this.mDetector;
            if (detector != null) {
                detector.release();
                this.mDetector = null;
            }
        }

        void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        void setNextFrame(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                ByteBuffer byteBuffer = this.mPendingFrameData;
                if (byteBuffer != null) {
                    camera.addCallbackBuffer(byteBuffer.array());
                    this.mPendingFrameData = null;
                }
                if (CameraSource.this.mBytesToByteBuffer.containsKey(bArr)) {
                    this.mPendingTimeMillis = SystemClock.elapsedRealtime() - this.mStartTimeMillis;
                    this.mPendingFrameId++;
                    this.mPendingFrameData = (ByteBuffer) CameraSource.this.mBytesToByteBuffer.get(bArr);
                    this.mLock.notifyAll();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Frame build;
            ByteBuffer byteBuffer;
            while (true) {
                synchronized (this.mLock) {
                    while (true) {
                        z = this.mActive;
                        if (!z || this.mPendingFrameData != null) {
                            break;
                        }
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                    if (!z) {
                        return;
                    }
                    build = new Frame.Builder().setImageData(this.mPendingFrameData, CameraSource.this.mPreviewSize.getWidth(), CameraSource.this.mPreviewSize.getHeight(), 17).setId(this.mPendingFrameId).setTimestampMillis(this.mPendingTimeMillis).setRotation(CameraSource.this.mRotation).build();
                    byteBuffer = this.mPendingFrameData;
                    this.mPendingFrameData = null;
                }
                try {
                    this.mDetector.receiveFrame(build);
                    CameraSource.this.mCamera.addCallbackBuffer(byteBuffer.array());
                } catch (Throwable unused2) {
                    CameraSource.this.mCamera.addCallbackBuffer(byteBuffer.array());
                }
            }
        }
    }

    public static Camera.Size getOptimalPreviewSize(List<Camera.Size> list, int i, int i2) {
        double d = i2 / i;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d) <= 0.1d && Math.abs(size2.height - i2) < d3) {
                d3 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i2) < d2) {
                    size = size3;
                    d2 = Math.abs(size3.height - i2);
                }
            }
        }
        return size;
    }
}
