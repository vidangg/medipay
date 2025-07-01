package vn.ai.faceauth.sdk.presentation.presentation.widgets;

import android.app.Activity;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import paua.btj;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.FrameMetadata;

/* loaded from: classes4.dex */
public class CameraSource {
    private static float ASPECT_RATIO_TOLERANCE;
    public static int CAMERA_FACING_BACK;
    public static int CAMERA_FACING_FRONT;
    public static int DEFAULT_REQUESTED_CAMERA_PREVIEW_HEIGHT;
    public static int DEFAULT_REQUESTED_CAMERA_PREVIEW_WIDTH;
    private static int DUMMY_TEXTURE_NAME;
    public static int IMAGE_FORMAT;
    private static boolean REQUESTED_AUTO_FOCUS;
    private static float REQUESTED_FPS;
    private static String TAG;
    protected Activity activity;
    private Camera camera;
    private SurfaceTexture dummySurfaceTexture;
    private VisionImageProcessor frameProcessor;
    private final GraphicOverlay graphicOverlay;
    private Size previewSize;
    private final FrameProcessingRunnable processingRunnable;
    private Thread processingThread;
    private int rotationDegrees;
    private final Object processorLock = new Object();
    private final IdentityHashMap<byte[], ByteBuffer> bytesToByteBuffer = new IdentityHashMap<>();
    private int facing = 0;

    /* loaded from: classes4.dex */
    public class CameraPreviewCallback implements Camera.PreviewCallback {
        private CameraPreviewCallback() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.processingRunnable.setNextFrame(bArr, camera);
        }
    }

    /* loaded from: classes4.dex */
    public class FrameProcessingRunnable implements Runnable {
        private ByteBuffer pendingFrameData;
        private final Object lock = new Object();
        private boolean active = true;

        public FrameProcessingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            ByteBuffer byteBuffer;
            while (true) {
                synchronized (this.lock) {
                    while (true) {
                        z = this.active;
                        if (!z || this.pendingFrameData != null) {
                            break;
                        }
                        try {
                            this.lock.wait();
                        } catch (InterruptedException e) {
                            Log.d(btj.tzend(587), btj.tzend(588), e);
                            return;
                        }
                    }
                    if (!z) {
                        return;
                    }
                    byteBuffer = this.pendingFrameData;
                    this.pendingFrameData = null;
                }
                try {
                    synchronized (CameraSource.this.processorLock) {
                        CameraSource.this.frameProcessor.processByteBuffer(byteBuffer, new FrameMetadata.Builder().setWidth(CameraSource.this.previewSize.getWidth()).setHeight(CameraSource.this.previewSize.getHeight()).setRotation(CameraSource.this.rotationDegrees).build());
                    }
                } catch (Exception e2) {
                    Log.e(btj.tzend(589), btj.tzend(590), e2);
                } finally {
                    CameraSource.this.camera.addCallbackBuffer(byteBuffer.array());
                }
            }
        }

        public void setActive(boolean z) {
            synchronized (this.lock) {
                this.active = z;
                this.lock.notifyAll();
            }
        }

        public void setNextFrame(byte[] bArr, Camera camera) {
            synchronized (this.lock) {
                ByteBuffer byteBuffer = this.pendingFrameData;
                if (byteBuffer != null) {
                    camera.addCallbackBuffer(byteBuffer.array());
                    this.pendingFrameData = null;
                }
                if (!CameraSource.this.bytesToByteBuffer.containsKey(bArr)) {
                    Log.d(btj.tzend(591), btj.tzend(592));
                } else {
                    this.pendingFrameData = (ByteBuffer) CameraSource.this.bytesToByteBuffer.get(bArr);
                    this.lock.notifyAll();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SizePair {
        public final Size picture;
        public final Size preview;

        public SizePair(Camera.Size size, Camera.Size size2) {
            this.preview = new Size(size.width, size.height);
            this.picture = size2 != null ? new Size(size2.width, size2.height) : null;
        }

        public SizePair(Size size, Size size2) {
            this.preview = size;
            this.picture = size2;
        }
    }

    static {
        btj.sfgt(CameraSource.class, 634, 643);
    }

    public CameraSource(Activity activity, GraphicOverlay graphicOverlay) {
        this.activity = activity;
        this.graphicOverlay = graphicOverlay;
        graphicOverlay.clear();
        this.processingRunnable = new FrameProcessingRunnable();
    }

    private void cleanScreen() {
        this.graphicOverlay.clear();
    }

    private Camera createCamera() {
        int idForRequestedCamera = getIdForRequestedCamera(this.facing);
        if (idForRequestedCamera == -1) {
            throw new IOException(btj.tzend(326));
        }
        Camera open = Camera.open(idForRequestedCamera);
        SizePair cameraPreviewSizePair = PreferenceUtils.getCameraPreviewSizePair(this.activity, idForRequestedCamera);
        if (cameraPreviewSizePair == null) {
            cameraPreviewSizePair = selectSizePair(open, 480, 360);
        }
        if (cameraPreviewSizePair == null) {
            throw new IOException(btj.tzend(325));
        }
        this.previewSize = cameraPreviewSizePair.preview;
        String str = btj.tzend(319) + this.previewSize;
        String tzend = btj.tzend(320);
        Log.v(tzend, str);
        int[] selectPreviewFpsRange = selectPreviewFpsRange(open, 30.0f);
        if (selectPreviewFpsRange == null) {
            throw new IOException(btj.tzend(324));
        }
        Camera.Parameters parameters = open.getParameters();
        Size size = cameraPreviewSizePair.picture;
        if (size != null) {
            Log.v(tzend, btj.tzend(321) + size);
            parameters.setPictureSize(size.getWidth(), size.getHeight());
        }
        parameters.setPreviewSize(this.previewSize.getWidth(), this.previewSize.getHeight());
        parameters.setPreviewFpsRange(selectPreviewFpsRange[0], selectPreviewFpsRange[1]);
        parameters.setPreviewFormat(17);
        setRotation(open, parameters, idForRequestedCamera);
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String tzend2 = btj.tzend(322);
        if (supportedFocusModes.contains(tzend2)) {
            parameters.setFocusMode(tzend2);
        } else {
            Log.i(tzend, btj.tzend(323));
        }
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new CameraPreviewCallback());
        open.addCallbackBuffer(createPreviewBuffer(this.previewSize));
        open.addCallbackBuffer(createPreviewBuffer(this.previewSize));
        open.addCallbackBuffer(createPreviewBuffer(this.previewSize));
        open.addCallbackBuffer(createPreviewBuffer(this.previewSize));
        return open;
    }

    private byte[] createPreviewBuffer(Size size) {
        double height = size.getHeight() * size.getWidth() * ImageFormat.getBitsPerPixel(17);
        Double.isNaN(height);
        byte[] bArr = new byte[((int) Math.ceil(height / 8.0d)) + 1];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException(btj.tzend(327));
        }
        this.bytesToByteBuffer.put(bArr, wrap);
        return bArr;
    }

    public static List<SizePair> generateValidPreviewSizeList(Camera camera) {
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
                    if (Math.abs(f - (next.width / next.height)) < 0.01f) {
                        arrayList.add(new SizePair(size, next));
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w(btj.tzend(328), btj.tzend(329));
            Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
            while (it2.hasNext()) {
                arrayList.add(new SizePair(it2.next(), (Camera.Size) null));
            }
        }
        return arrayList;
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

    private static int getZoomValue(Camera.Parameters parameters, float f) {
        int max = (int) (Math.max(f, 1.0f) * 100.0f);
        List<Integer> zoomRatios = parameters.getZoomRatios();
        int maxZoom = parameters.getMaxZoom();
        int i = 0;
        while (i < maxZoom) {
            int i2 = i + 1;
            if (zoomRatios.get(i2).intValue() > max) {
                return i;
            }
            i = i2;
        }
        return maxZoom;
    }

    private static int[] selectPreviewFpsRange(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i - iArr2[1]);
            int i4 = iArr2[0];
            if (abs <= i2 && i4 <= i3) {
                iArr = iArr2;
                i2 = abs;
                i3 = i4;
            }
        }
        return iArr;
    }

    public static SizePair selectSizePair(Camera camera, int i, int i2) {
        SizePair sizePair = null;
        int i3 = Integer.MAX_VALUE;
        for (SizePair sizePair2 : generateValidPreviewSizeList(camera)) {
            Size size = sizePair2.preview;
            int abs = Math.abs(size.getHeight() - i2) + Math.abs(size.getWidth() - i);
            if (abs < i3) {
                sizePair = sizePair2;
                i3 = abs;
            }
        }
        return sizePair;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setRotation(Camera camera, Camera.Parameters parameters, int i) {
        int i2;
        Camera.CameraInfo cameraInfo;
        int i3;
        int rotation = ((WindowManager) this.activity.getSystemService(btj.tzend(330))).getDefaultDisplay().getRotation();
        String tzend = btj.tzend(331);
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation != 3) {
                Log.e(tzend, btj.tzend(332) + rotation);
            } else {
                i2 = 270;
            }
            cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1) {
                int i4 = (cameraInfo.orientation + i2) % 360;
                this.rotationDegrees = i4;
                i3 = (360 - i4) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i2) + 360) % 360;
                this.rotationDegrees = i3;
            }
            Log.d(tzend, btj.tzend(333) + rotation);
            Log.d(tzend, btj.tzend(334) + cameraInfo.facing);
            Log.d(tzend, btj.tzend(335) + cameraInfo.orientation);
            Log.d(tzend, btj.tzend(336) + this.rotationDegrees);
            camera.setDisplayOrientation(i3);
            parameters.setRotation(this.rotationDegrees);
        }
        i2 = 0;
        cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing != 1) {
        }
        Log.d(tzend, btj.tzend(333) + rotation);
        Log.d(tzend, btj.tzend(334) + cameraInfo.facing);
        Log.d(tzend, btj.tzend(335) + cameraInfo.orientation);
        Log.d(tzend, btj.tzend(336) + this.rotationDegrees);
        camera.setDisplayOrientation(i3);
        parameters.setRotation(this.rotationDegrees);
    }

    public int getCameraFacing() {
        return this.facing;
    }

    public Size getPreviewSize() {
        return this.previewSize;
    }

    public void release() {
        synchronized (this.processorLock) {
            stop();
            cleanScreen();
            VisionImageProcessor visionImageProcessor = this.frameProcessor;
            if (visionImageProcessor != null) {
                visionImageProcessor.stop();
            }
        }
    }

    public void setFacing(int i) {
        synchronized (this) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException(btj.tzend(337) + i);
            }
            this.facing = i;
        }
    }

    public void setMachineLearningFrameProcessor(VisionImageProcessor visionImageProcessor) {
        synchronized (this.processorLock) {
            cleanScreen();
            VisionImageProcessor visionImageProcessor2 = this.frameProcessor;
            if (visionImageProcessor2 != null) {
                visionImageProcessor2.stop();
            }
            this.frameProcessor = visionImageProcessor;
        }
    }

    public boolean setZoom(float f) {
        Log.d(btj.tzend(339), btj.tzend(338) + f);
        Camera camera = this.camera;
        if (camera == null) {
            return false;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(getZoomValue(parameters, f));
        this.camera.setParameters(parameters);
        return true;
    }

    public CameraSource start() {
        synchronized (this) {
            if (this.camera != null) {
                return this;
            }
            this.camera = createCamera();
            SurfaceTexture surfaceTexture = new SurfaceTexture(100);
            this.dummySurfaceTexture = surfaceTexture;
            this.camera.setPreviewTexture(surfaceTexture);
            this.camera.startPreview();
            this.processingThread = new Thread(this.processingRunnable);
            this.processingRunnable.setActive(true);
            this.processingThread.start();
            return this;
        }
    }

    public CameraSource start(SurfaceHolder surfaceHolder) {
        synchronized (this) {
            if (this.camera != null) {
                return this;
            }
            Camera createCamera = createCamera();
            this.camera = createCamera;
            createCamera.setPreviewDisplay(surfaceHolder);
            this.camera.startPreview();
            this.processingThread = new Thread(this.processingRunnable);
            this.processingRunnable.setActive(true);
            this.processingThread.start();
            return this;
        }
    }

    public void stop() {
        synchronized (this) {
            this.processingRunnable.setActive(false);
            Thread thread = this.processingThread;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused) {
                    Log.d(btj.tzend(340), btj.tzend(341));
                }
                this.processingThread = null;
            }
            Camera camera = this.camera;
            if (camera != null) {
                camera.stopPreview();
                this.camera.setPreviewCallbackWithBuffer(null);
                try {
                    this.camera.setPreviewTexture(null);
                    this.dummySurfaceTexture = null;
                    this.camera.setPreviewDisplay(null);
                } catch (Exception e) {
                    Log.e(btj.tzend(343), btj.tzend(342) + e);
                }
                this.camera.release();
                this.camera = null;
            }
            this.bytesToByteBuffer.clear();
        }
    }
}
