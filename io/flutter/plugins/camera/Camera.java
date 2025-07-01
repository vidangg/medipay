package io.flutter.plugins.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.C;
import com.tekartik.sqflite.Database$$ExternalSyntheticApiModelOutline0;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.camera.Camera;
import io.flutter.plugins.camera.CameraCaptureCallback;
import io.flutter.plugins.camera.ImageSaver;
import io.flutter.plugins.camera.Messages;
import io.flutter.plugins.camera.features.CameraFeature;
import io.flutter.plugins.camera.features.CameraFeatureFactory;
import io.flutter.plugins.camera.features.CameraFeatures;
import io.flutter.plugins.camera.features.Point;
import io.flutter.plugins.camera.features.autofocus.AutoFocusFeature;
import io.flutter.plugins.camera.features.autofocus.FocusMode;
import io.flutter.plugins.camera.features.exposurelock.ExposureLockFeature;
import io.flutter.plugins.camera.features.exposurelock.ExposureMode;
import io.flutter.plugins.camera.features.exposureoffset.ExposureOffsetFeature;
import io.flutter.plugins.camera.features.exposurepoint.ExposurePointFeature;
import io.flutter.plugins.camera.features.flash.FlashFeature;
import io.flutter.plugins.camera.features.flash.FlashMode;
import io.flutter.plugins.camera.features.focuspoint.FocusPointFeature;
import io.flutter.plugins.camera.features.fpsrange.FpsRangeFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionPreset;
import io.flutter.plugins.camera.features.sensororientation.DeviceOrientationManager;
import io.flutter.plugins.camera.features.zoomlevel.ZoomLevelFeature;
import io.flutter.plugins.camera.media.ImageStreamReader;
import io.flutter.plugins.camera.media.MediaRecorderBuilder;
import io.flutter.plugins.camera.types.CameraCaptureProperties;
import io.flutter.plugins.camera.types.CaptureTimeoutsWrapper;
import io.flutter.view.TextureRegistry;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class Camera implements CameraCaptureCallback.CameraCaptureStateListener, ImageReader.OnImageAvailableListener {
    private static final String TAG = "Camera";
    private final Activity activity;
    private final Context applicationContext;
    Handler backgroundHandler;
    private HandlerThread backgroundHandlerThread;
    private final CameraCaptureCallback cameraCaptureCallback;
    CameraDeviceWrapper cameraDevice;
    private final CameraFeatureFactory cameraFeatureFactory;
    CameraFeatures cameraFeatures;
    private CameraProperties cameraProperties;
    private File captureFile;
    private CameraCaptureProperties captureProps;
    CameraCaptureSession captureSession;
    private CaptureTimeoutsWrapper captureTimeouts;
    final DartMessenger dartMessenger;
    Messages.Result<String> flutterResult;
    final TextureRegistry.SurfaceTextureEntry flutterTexture;
    private int imageFormatGroup;
    ImageStreamReader imageStreamReader;
    int initialCameraFacing;
    MediaRecorder mediaRecorder;
    boolean pausedPreview;
    ImageReader pictureImageReader;
    CaptureRequest.Builder previewRequestBuilder;
    boolean recordingVideo;
    private final VideoCaptureSettings videoCaptureSettings;
    VideoRenderer videoRenderer;

    /* loaded from: classes4.dex */
    private class DefaultCameraDeviceWrapper implements CameraDeviceWrapper {
        private final CameraDevice cameraDevice;

        DefaultCameraDeviceWrapper(CameraDevice cameraDevice) {
            this.cameraDevice = cameraDevice;
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        public CaptureRequest.Builder createCaptureRequest(int i) throws CameraAccessException {
            return this.cameraDevice.createCaptureRequest(i);
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        public void createCaptureSession(SessionConfiguration sessionConfiguration) throws CameraAccessException {
            this.cameraDevice.createCaptureSession(sessionConfiguration);
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        public void createCaptureSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) throws CameraAccessException {
            this.cameraDevice.createCaptureSession(list, stateCallback, Camera.this.backgroundHandler);
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        public void close() {
            this.cameraDevice.close();
        }
    }

    /* loaded from: classes4.dex */
    public static class VideoCaptureSettings {
        public final Integer audioBitrate;
        public final boolean enableAudio;
        public final Integer fps;
        public final ResolutionPreset resolutionPreset;
        public final Integer videoBitrate;

        public VideoCaptureSettings(ResolutionPreset resolutionPreset, boolean z, Integer num, Integer num2, Integer num3) {
            this.resolutionPreset = resolutionPreset;
            this.enableAudio = z;
            this.fps = num;
            this.videoBitrate = num2;
            this.audioBitrate = num3;
        }

        public VideoCaptureSettings(ResolutionPreset resolutionPreset, boolean z) {
            this(resolutionPreset, z, null, null, null);
        }
    }

    public Camera(Activity activity, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, CameraFeatureFactory cameraFeatureFactory, DartMessenger dartMessenger, CameraProperties cameraProperties, VideoCaptureSettings videoCaptureSettings) {
        if (activity == null) {
            throw new IllegalStateException("No activity available!");
        }
        this.activity = activity;
        this.flutterTexture = surfaceTextureEntry;
        this.dartMessenger = dartMessenger;
        this.applicationContext = activity.getApplicationContext();
        this.cameraProperties = cameraProperties;
        this.cameraFeatureFactory = cameraFeatureFactory;
        this.videoCaptureSettings = videoCaptureSettings;
        this.cameraFeatures = CameraFeatures.init(cameraFeatureFactory, cameraProperties, activity, dartMessenger, videoCaptureSettings.resolutionPreset);
        this.captureTimeouts = new CaptureTimeoutsWrapper(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        CameraCaptureProperties cameraCaptureProperties = new CameraCaptureProperties();
        this.captureProps = cameraCaptureProperties;
        this.cameraCaptureCallback = CameraCaptureCallback.create(this, this.captureTimeouts, cameraCaptureProperties);
        startBackgroundThread();
    }

    @Override // io.flutter.plugins.camera.CameraCaptureCallback.CameraCaptureStateListener
    public void onConverged() {
        takePictureAfterPrecapture();
    }

    @Override // io.flutter.plugins.camera.CameraCaptureCallback.CameraCaptureStateListener
    public void onPrecapture() {
        runPrecaptureSequence();
    }

    void updateBuilderSettings(CaptureRequest.Builder builder) {
        Iterator<CameraFeature<?>> it = this.cameraFeatures.getAllFeatures().iterator();
        while (it.hasNext()) {
            it.next().updateBuilder(builder);
        }
    }

    private void prepareMediaRecorder(String str) throws IOException {
        MediaRecorderBuilder mediaRecorderBuilder;
        int videoOrientation;
        Log.i(TAG, "prepareMediaRecorder");
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.release();
        }
        closeRenderer();
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.cameraFeatures.getSensorOrientation().getLockedCaptureOrientation();
        if (SdkCapabilityChecker.supportsEncoderProfiles() && getRecordingProfile() != null) {
            mediaRecorderBuilder = new MediaRecorderBuilder(getRecordingProfile(), new MediaRecorderBuilder.RecordingParameters(str, this.videoCaptureSettings.fps, this.videoCaptureSettings.videoBitrate, this.videoCaptureSettings.audioBitrate));
        } else {
            mediaRecorderBuilder = new MediaRecorderBuilder(getRecordingProfileLegacy(), new MediaRecorderBuilder.RecordingParameters(str, this.videoCaptureSettings.fps, this.videoCaptureSettings.videoBitrate, this.videoCaptureSettings.audioBitrate));
        }
        MediaRecorderBuilder enableAudio = mediaRecorderBuilder.setEnableAudio(this.videoCaptureSettings.enableAudio);
        if (lockedCaptureOrientation == null) {
            videoOrientation = getDeviceOrientationManager().getVideoOrientation();
        } else {
            videoOrientation = getDeviceOrientationManager().getVideoOrientation(lockedCaptureOrientation);
        }
        this.mediaRecorder = enableAudio.setMediaOrientation(videoOrientation).build();
    }

    private void setFpsCameraFeatureForRecording(CameraProperties cameraProperties) {
        Integer valueOf;
        List videoProfiles;
        List videoProfiles2;
        int frameRate;
        if (this.videoCaptureSettings.fps != null && this.videoCaptureSettings.fps.intValue() > 0) {
            valueOf = this.videoCaptureSettings.fps;
        } else if (SdkCapabilityChecker.supportsEncoderProfiles()) {
            EncoderProfiles recordingProfile = getRecordingProfile();
            if (recordingProfile != null) {
                videoProfiles = recordingProfile.getVideoProfiles();
                if (videoProfiles.size() > 0) {
                    videoProfiles2 = recordingProfile.getVideoProfiles();
                    frameRate = Database$$ExternalSyntheticApiModelOutline0.m733m(videoProfiles2.get(0)).getFrameRate();
                    valueOf = Integer.valueOf(frameRate);
                }
            }
            valueOf = null;
        } else {
            CamcorderProfile recordingProfileLegacy = getRecordingProfileLegacy();
            if (recordingProfileLegacy != null) {
                valueOf = Integer.valueOf(recordingProfileLegacy.videoFrameRate);
            }
            valueOf = null;
        }
        if (valueOf == null || valueOf.intValue() <= 0) {
            return;
        }
        FpsRangeFeature fpsRangeFeature = new FpsRangeFeature(cameraProperties);
        fpsRangeFeature.setValue(new Range<>(valueOf, valueOf));
        this.cameraFeatures.setFpsRange(fpsRangeFeature);
    }

    public void open(Integer num) throws CameraAccessException {
        this.imageFormatGroup = num.intValue();
        ResolutionFeature resolution = this.cameraFeatures.getResolution();
        if (!resolution.checkIsSupported()) {
            this.dartMessenger.sendCameraErrorEvent("Camera with name \"" + this.cameraProperties.getCameraName() + "\" is not supported by this plugin.");
            return;
        }
        this.pictureImageReader = ImageReader.newInstance(resolution.getCaptureSize().getWidth(), resolution.getCaptureSize().getHeight(), 256, 1);
        this.imageStreamReader = new ImageStreamReader(resolution.getPreviewSize().getWidth(), resolution.getPreviewSize().getHeight(), this.imageFormatGroup, 1);
        CameraUtils.getCameraManager(this.activity).openCamera(this.cameraProperties.getCameraName(), new AnonymousClass1(resolution), this.backgroundHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.camera.Camera$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends CameraDevice.StateCallback {
        final /* synthetic */ ResolutionFeature val$resolutionFeature;

        AnonymousClass1(ResolutionFeature resolutionFeature) {
            this.val$resolutionFeature = resolutionFeature;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            String message;
            Runnable runnable;
            Camera camera = Camera.this;
            camera.cameraDevice = new DefaultCameraDeviceWrapper(cameraDevice);
            try {
                if (Camera.this.recordingVideo) {
                    runnable = null;
                } else {
                    final ResolutionFeature resolutionFeature = this.val$resolutionFeature;
                    runnable = new Runnable() { // from class: io.flutter.plugins.camera.Camera$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Camera.AnonymousClass1.this.m775lambda$onOpened$0$ioflutterpluginscameraCamera$1(resolutionFeature);
                        }
                    };
                }
                Camera.this.startPreview(runnable);
            } catch (Exception e) {
                if (e.getMessage() == null) {
                    message = e.getClass().getName() + " occurred while opening camera.";
                } else {
                    message = e.getMessage();
                }
                Camera.this.dartMessenger.sendCameraErrorEvent(message);
                Camera.this.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onOpened$0$io-flutter-plugins-camera-Camera$1, reason: not valid java name */
        public /* synthetic */ void m775lambda$onOpened$0$ioflutterpluginscameraCamera$1(ResolutionFeature resolutionFeature) {
            Camera.this.dartMessenger.sendCameraInitializedEvent(Integer.valueOf(resolutionFeature.getPreviewSize().getWidth()), Integer.valueOf(resolutionFeature.getPreviewSize().getHeight()), Camera.this.cameraFeatures.getExposureLock().getValue(), Camera.this.cameraFeatures.getAutoFocus().getValue(), Boolean.valueOf(Camera.this.cameraFeatures.getExposurePoint().checkIsSupported()), Boolean.valueOf(Camera.this.cameraFeatures.getFocusPoint().checkIsSupported()));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Log.i(Camera.TAG, "open | onClosed");
            Camera.this.cameraDevice = null;
            Camera.this.closeCaptureSession();
            Camera.this.dartMessenger.sendCameraClosingEvent();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Log.i(Camera.TAG, "open | onDisconnected");
            Camera.this.close();
            Camera.this.dartMessenger.sendCameraErrorEvent("The camera was disconnected.");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            String str;
            Log.i(Camera.TAG, "open | onError");
            Camera.this.close();
            if (i == 1) {
                str = "The camera device is in use already.";
            } else if (i == 2) {
                str = "Max cameras in use";
            } else if (i == 3) {
                str = "The camera device could not be opened due to a device policy.";
            } else if (i == 4) {
                str = "The camera device has encountered a fatal error";
            } else if (i == 5) {
                str = "The camera service has encountered a fatal error.";
            } else {
                str = "Unknown camera error";
            }
            Camera.this.dartMessenger.sendCameraErrorEvent(str);
        }
    }

    void createCaptureSession(int i, Surface... surfaceArr) throws CameraAccessException {
        createCaptureSession(i, null, surfaceArr);
    }

    private void createCaptureSession(int i, Runnable runnable, Surface... surfaceArr) throws CameraAccessException {
        this.captureSession = null;
        this.previewRequestBuilder = this.cameraDevice.createCaptureRequest(i);
        ResolutionFeature resolution = this.cameraFeatures.getResolution();
        SurfaceTexture surfaceTexture = this.flutterTexture.surfaceTexture();
        surfaceTexture.setDefaultBufferSize(resolution.getPreviewSize().getWidth(), resolution.getPreviewSize().getHeight());
        Surface surface = new Surface(surfaceTexture);
        this.previewRequestBuilder.addTarget(surface);
        List<Surface> asList = Arrays.asList(surfaceArr);
        if (i != 1) {
            Surface surface2 = this.pictureImageReader.getSurface();
            for (Surface surface3 : asList) {
                if (surface3 != surface2) {
                    this.previewRequestBuilder.addTarget(surface3);
                }
            }
        }
        Size cameraBoundaries = CameraRegionUtils.getCameraBoundaries(this.cameraProperties, this.previewRequestBuilder);
        this.cameraFeatures.getExposurePoint().setCameraBoundaries(cameraBoundaries);
        this.cameraFeatures.getFocusPoint().setCameraBoundaries(cameraBoundaries);
        CameraCaptureSession.StateCallback anonymousClass2 = new AnonymousClass2(runnable);
        if (SdkCapabilityChecker.supportsSessionConfiguration()) {
            List<OutputConfiguration> arrayList = new ArrayList<>();
            arrayList.add(new OutputConfiguration(surface));
            Iterator it = asList.iterator();
            while (it.hasNext()) {
                arrayList.add(new OutputConfiguration((Surface) it.next()));
            }
            createCaptureSessionWithSessionConfig(arrayList, anonymousClass2);
            return;
        }
        List<Surface> arrayList2 = new ArrayList<>();
        arrayList2.add(surface);
        arrayList2.addAll(asList);
        createCaptureSession(arrayList2, anonymousClass2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.camera.Camera$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 extends CameraCaptureSession.StateCallback {
        boolean captureSessionClosed = false;
        final /* synthetic */ Runnable val$onSuccessCallback;

        AnonymousClass2(Runnable runnable) {
            this.val$onSuccessCallback = runnable;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Log.i(Camera.TAG, "CameraCaptureSession onConfigured");
            if (Camera.this.cameraDevice == null || this.captureSessionClosed) {
                Camera.this.dartMessenger.sendCameraErrorEvent("The camera was closed during configuration.");
                return;
            }
            Camera.this.captureSession = cameraCaptureSession;
            Log.i(Camera.TAG, "Updating builder settings");
            Camera camera = Camera.this;
            camera.updateBuilderSettings(camera.previewRequestBuilder);
            Camera.this.refreshPreviewCaptureSession(this.val$onSuccessCallback, new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$2$$ExternalSyntheticLambda0
                @Override // io.flutter.plugins.camera.ErrorCallback
                public final void onError(String str, String str2) {
                    Camera.AnonymousClass2.this.m776lambda$onConfigured$0$ioflutterpluginscameraCamera$2(str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onConfigured$0$io-flutter-plugins-camera-Camera$2, reason: not valid java name */
        public /* synthetic */ void m776lambda$onConfigured$0$ioflutterpluginscameraCamera$2(String str, String str2) {
            Camera.this.dartMessenger.sendCameraErrorEvent(str2);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Log.i(Camera.TAG, "CameraCaptureSession onConfigureFailed");
            Camera.this.dartMessenger.sendCameraErrorEvent("Failed to configure camera session.");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            Log.i(Camera.TAG, "CameraCaptureSession onClosed");
            this.captureSessionClosed = true;
        }
    }

    private void createCaptureSessionWithSessionConfig(List<OutputConfiguration> list, CameraCaptureSession.StateCallback stateCallback) throws CameraAccessException {
        this.cameraDevice.createCaptureSession(new SessionConfiguration(0, list, Executors.newSingleThreadExecutor(), stateCallback));
    }

    private void createCaptureSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback) throws CameraAccessException {
        this.cameraDevice.createCaptureSession(list, stateCallback, this.backgroundHandler);
    }

    void refreshPreviewCaptureSession(Runnable runnable, ErrorCallback errorCallback) {
        Log.i(TAG, "refreshPreviewCaptureSession");
        CameraCaptureSession cameraCaptureSession = this.captureSession;
        if (cameraCaptureSession == null) {
            Log.i(TAG, "refreshPreviewCaptureSession: captureSession not yet initialized, skipping preview capture session refresh.");
            return;
        }
        try {
            if (!this.pausedPreview) {
                cameraCaptureSession.setRepeatingRequest(this.previewRequestBuilder.build(), this.cameraCaptureCallback, this.backgroundHandler);
            }
            if (runnable != null) {
                runnable.run();
            }
        } catch (CameraAccessException e) {
            errorCallback.onError("cameraAccess", e.getMessage());
        } catch (IllegalStateException e2) {
            errorCallback.onError("cameraAccess", "Camera is closed: " + e2.getMessage());
        }
    }

    private void startCapture(boolean z, boolean z2) throws CameraAccessException {
        Runnable runnable;
        ImageStreamReader imageStreamReader;
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(this.mediaRecorder.getSurface());
            runnable = new Runnable() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    Camera.this.m773lambda$startCapture$0$ioflutterpluginscameraCamera();
                }
            };
        } else {
            runnable = null;
        }
        if (z2 && (imageStreamReader = this.imageStreamReader) != null) {
            arrayList.add(imageStreamReader.getSurface());
        }
        arrayList.add(this.pictureImageReader.getSurface());
        createCaptureSession(3, runnable, (Surface[]) arrayList.toArray(new Surface[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startCapture$0$io-flutter-plugins-camera-Camera, reason: not valid java name */
    public /* synthetic */ void m773lambda$startCapture$0$ioflutterpluginscameraCamera() {
        this.mediaRecorder.start();
    }

    public void takePicture(Messages.Result<String> result) {
        if (this.cameraCaptureCallback.getCameraState() != CameraState.STATE_PREVIEW) {
            result.error(new Messages.FlutterError("captureAlreadyActive", "Picture is currently already being captured", null));
            return;
        }
        this.flutterResult = result;
        try {
            this.captureFile = File.createTempFile("CAP", ".jpg", this.applicationContext.getCacheDir());
            this.captureTimeouts.reset();
            this.pictureImageReader.setOnImageAvailableListener(this, this.backgroundHandler);
            AutoFocusFeature autoFocus = this.cameraFeatures.getAutoFocus();
            if (autoFocus.checkIsSupported() && autoFocus.getValue() == FocusMode.auto) {
                runPictureAutoFocus();
            } else {
                runPrecaptureSequence();
            }
        } catch (IOException | SecurityException e) {
            this.dartMessenger.error(this.flutterResult, "cannotCreateFile", e.getMessage(), null);
        }
    }

    private void runPrecaptureSequence() {
        Log.i(TAG, "runPrecaptureSequence");
        try {
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
            this.captureSession.capture(this.previewRequestBuilder.build(), this.cameraCaptureCallback, this.backgroundHandler);
            refreshPreviewCaptureSession(null, new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda6
                @Override // io.flutter.plugins.camera.ErrorCallback
                public final void onError(String str, String str2) {
                    Camera.this.m772lambda$runPrecaptureSequence$1$ioflutterpluginscameraCamera(str, str2);
                }
            });
            this.cameraCaptureCallback.setCameraState(CameraState.STATE_WAITING_PRECAPTURE_START);
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            this.captureSession.capture(this.previewRequestBuilder.build(), this.cameraCaptureCallback, this.backgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$runPrecaptureSequence$1$io-flutter-plugins-camera-Camera, reason: not valid java name */
    public /* synthetic */ void m772lambda$runPrecaptureSequence$1$ioflutterpluginscameraCamera(String str, String str2) {
        this.dartMessenger.error(this.flutterResult, "cameraAccess", str2, null);
    }

    private void takePictureAfterPrecapture() {
        int photoOrientation;
        Log.i(TAG, "captureStillPicture");
        this.cameraCaptureCallback.setCameraState(CameraState.STATE_CAPTURING);
        CameraDeviceWrapper cameraDeviceWrapper = this.cameraDevice;
        if (cameraDeviceWrapper == null) {
            return;
        }
        try {
            CaptureRequest.Builder createCaptureRequest = cameraDeviceWrapper.createCaptureRequest(2);
            createCaptureRequest.addTarget(this.pictureImageReader.getSurface());
            createCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, (Rect) this.previewRequestBuilder.get(CaptureRequest.SCALER_CROP_REGION));
            updateBuilderSettings(createCaptureRequest);
            PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.cameraFeatures.getSensorOrientation().getLockedCaptureOrientation();
            CaptureRequest.Key key = CaptureRequest.JPEG_ORIENTATION;
            if (lockedCaptureOrientation == null) {
                photoOrientation = getDeviceOrientationManager().getPhotoOrientation();
            } else {
                photoOrientation = getDeviceOrientationManager().getPhotoOrientation(lockedCaptureOrientation);
            }
            createCaptureRequest.set(key, Integer.valueOf(photoOrientation));
            CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: io.flutter.plugins.camera.Camera.3
                @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                    Camera.this.unlockAutoFocus();
                }
            };
            try {
                Log.i(TAG, "sending capture request");
                this.captureSession.capture(createCaptureRequest.build(), captureCallback, this.backgroundHandler);
            } catch (CameraAccessException e) {
                this.dartMessenger.error(this.flutterResult, "cameraAccess", e.getMessage(), null);
            }
        } catch (CameraAccessException e2) {
            this.dartMessenger.error(this.flutterResult, "cameraAccess", e2.getMessage(), null);
        }
    }

    private Display getDefaultDisplay() {
        return this.activity.getWindowManager().getDefaultDisplay();
    }

    public void startBackgroundThread() {
        if (this.backgroundHandlerThread != null) {
            return;
        }
        HandlerThread create = HandlerThreadFactory.create("CameraBackground");
        this.backgroundHandlerThread = create;
        try {
            create.start();
        } catch (IllegalThreadStateException unused) {
        }
        this.backgroundHandler = HandlerFactory.create(this.backgroundHandlerThread.getLooper());
    }

    public void stopBackgroundThread() {
        HandlerThread handlerThread = this.backgroundHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.backgroundHandlerThread = null;
        this.backgroundHandler = null;
    }

    private void runPictureAutoFocus() {
        Log.i(TAG, "runPictureAutoFocus");
        this.cameraCaptureCallback.setCameraState(CameraState.STATE_WAITING_FOCUS);
        lockAutoFocus();
    }

    private void lockAutoFocus() {
        String message;
        Log.i(TAG, "lockAutoFocus");
        if (this.captureSession == null) {
            Log.i(TAG, "[unlockAutoFocus] captureSession null, returning");
            return;
        }
        this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        try {
            this.captureSession.capture(this.previewRequestBuilder.build(), null, this.backgroundHandler);
        } catch (CameraAccessException e) {
            if (e.getMessage() == null) {
                message = "CameraAccessException occurred while locking autofocus.";
            } else {
                message = e.getMessage();
            }
            this.dartMessenger.sendCameraErrorEvent(message);
        }
    }

    void unlockAutoFocus() {
        String message;
        Log.i(TAG, "unlockAutoFocus");
        if (this.captureSession == null) {
            Log.i(TAG, "[unlockAutoFocus] captureSession null, returning");
            return;
        }
        try {
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            this.captureSession.capture(this.previewRequestBuilder.build(), null, this.backgroundHandler);
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            this.captureSession.capture(this.previewRequestBuilder.build(), null, this.backgroundHandler);
            refreshPreviewCaptureSession(null, new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda7
                @Override // io.flutter.plugins.camera.ErrorCallback
                public final void onError(String str, String str2) {
                    Camera.this.m774lambda$unlockAutoFocus$2$ioflutterpluginscameraCamera(str, str2);
                }
            });
        } catch (CameraAccessException e) {
            if (e.getMessage() == null) {
                message = "CameraAccessException occurred while unlocking autofocus.";
            } else {
                message = e.getMessage();
            }
            this.dartMessenger.sendCameraErrorEvent(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$unlockAutoFocus$2$io-flutter-plugins-camera-Camera, reason: not valid java name */
    public /* synthetic */ void m774lambda$unlockAutoFocus$2$ioflutterpluginscameraCamera(String str, String str2) {
        this.dartMessenger.error(this.flutterResult, str, str2, null);
    }

    public void startVideoRecording(EventChannel eventChannel) {
        prepareRecording();
        if (eventChannel != null) {
            setStreamHandler(eventChannel);
        }
        this.initialCameraFacing = this.cameraProperties.getLensFacing();
        this.recordingVideo = true;
        try {
            startCapture(true, eventChannel != null);
        } catch (CameraAccessException e) {
            this.recordingVideo = false;
            this.captureFile = null;
            throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
        }
    }

    private void closeRenderer() {
        VideoRenderer videoRenderer = this.videoRenderer;
        if (videoRenderer != null) {
            videoRenderer.close();
            this.videoRenderer = null;
        }
    }

    public String stopVideoRecording() {
        if (!this.recordingVideo) {
            return "";
        }
        this.cameraFeatures.setAutoFocus(this.cameraFeatureFactory.createAutoFocusFeature(this.cameraProperties, false));
        this.cameraFeatures.setFpsRange(this.cameraFeatureFactory.createFpsRangeFeature(this.cameraProperties));
        this.recordingVideo = false;
        try {
            closeRenderer();
            this.captureSession.abortCaptures();
            this.mediaRecorder.stop();
        } catch (CameraAccessException | IllegalStateException unused) {
        }
        this.mediaRecorder.reset();
        try {
            startPreview(null);
            String absolutePath = this.captureFile.getAbsolutePath();
            this.captureFile = null;
            return absolutePath;
        } catch (CameraAccessException | IllegalStateException | InterruptedException e) {
            throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
        }
    }

    public void pauseVideoRecording() {
        if (this.recordingVideo) {
            try {
                if (SdkCapabilityChecker.supportsVideoPause()) {
                    this.mediaRecorder.pause();
                    return;
                }
                throw new Messages.FlutterError("videoRecordingFailed", "pauseVideoRecording requires Android API +24.", null);
            } catch (IllegalStateException e) {
                throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
            }
        }
    }

    public void resumeVideoRecording() {
        if (this.recordingVideo) {
            try {
                if (SdkCapabilityChecker.supportsVideoPause()) {
                    this.mediaRecorder.resume();
                    return;
                }
                throw new Messages.FlutterError("videoRecordingFailed", "resumeVideoRecording requires Android API +24.", null);
            } catch (IllegalStateException e) {
                throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
            }
        }
    }

    public void setFlashMode(final Messages.VoidResult voidResult, FlashMode flashMode) {
        FlashFeature flash = this.cameraFeatures.getFlash();
        flash.setValue(flashMode);
        flash.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new Camera$$ExternalSyntheticLambda8(voidResult), new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda9
            @Override // io.flutter.plugins.camera.ErrorCallback
            public final void onError(String str, String str2) {
                Messages.VoidResult.this.error(new Messages.FlutterError("setFlashModeFailed", "Could not set flash mode.", null));
            }
        });
    }

    public void setExposureMode(final Messages.VoidResult voidResult, ExposureMode exposureMode) {
        ExposureLockFeature exposureLock = this.cameraFeatures.getExposureLock();
        exposureLock.setValue(exposureMode);
        exposureLock.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new Camera$$ExternalSyntheticLambda8(voidResult), new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda5
            @Override // io.flutter.plugins.camera.ErrorCallback
            public final void onError(String str, String str2) {
                Messages.VoidResult.this.error(new Messages.FlutterError("setExposureModeFailed", "Could not set exposure mode.", null));
            }
        });
    }

    public void setExposurePoint(final Messages.VoidResult voidResult, Point point) {
        ExposurePointFeature exposurePoint = this.cameraFeatures.getExposurePoint();
        exposurePoint.setValue(point);
        exposurePoint.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new Camera$$ExternalSyntheticLambda8(voidResult), new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda10
            @Override // io.flutter.plugins.camera.ErrorCallback
            public final void onError(String str, String str2) {
                Messages.VoidResult.this.error(new Messages.FlutterError("setExposurePointFailed", "Could not set exposure point.", null));
            }
        });
    }

    public double getMaxExposureOffset() {
        return this.cameraFeatures.getExposureOffset().getMaxExposureOffset();
    }

    public double getMinExposureOffset() {
        return this.cameraFeatures.getExposureOffset().getMinExposureOffset();
    }

    public double getExposureOffsetStepSize() {
        return this.cameraFeatures.getExposureOffset().getExposureOffsetStepSize();
    }

    public void setFocusMode(FocusMode focusMode) {
        AutoFocusFeature autoFocus = this.cameraFeatures.getAutoFocus();
        autoFocus.setValue(focusMode);
        autoFocus.updateBuilder(this.previewRequestBuilder);
        if (this.pausedPreview) {
            return;
        }
        int i = AnonymousClass7.$SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[focusMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            unlockAutoFocus();
        } else {
            if (this.captureSession == null) {
                Log.i(TAG, "[unlockAutoFocus] captureSession null, returning");
                return;
            }
            lockAutoFocus();
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            try {
                this.captureSession.setRepeatingRequest(this.previewRequestBuilder.build(), null, this.backgroundHandler);
            } catch (CameraAccessException e) {
                throw new Messages.FlutterError("setFocusModeFailed", "Error setting focus mode: " + e.getMessage(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.camera.Camera$7, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode;

        static {
            int[] iArr = new int[FocusMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode = iArr;
            try {
                iArr[FocusMode.locked.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[FocusMode.auto.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void setFocusPoint(final Messages.VoidResult voidResult, Point point) {
        FocusPointFeature focusPoint = this.cameraFeatures.getFocusPoint();
        focusPoint.setValue(point);
        focusPoint.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new Camera$$ExternalSyntheticLambda8(voidResult), new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda13
            @Override // io.flutter.plugins.camera.ErrorCallback
            public final void onError(String str, String str2) {
                Messages.VoidResult.this.error(new Messages.FlutterError("setFocusPointFailed", "Could not set focus point.", null));
            }
        });
        setFocusMode(this.cameraFeatures.getAutoFocus().getValue());
    }

    public void setExposureOffset(final Messages.Result<Double> result, double d) {
        final ExposureOffsetFeature exposureOffset = this.cameraFeatures.getExposureOffset();
        exposureOffset.setValue(Double.valueOf(d));
        exposureOffset.updateBuilder(this.previewRequestBuilder);
        refreshPreviewCaptureSession(new Runnable() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                Messages.Result.this.success(exposureOffset.getValue());
            }
        }, new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda3
            @Override // io.flutter.plugins.camera.ErrorCallback
            public final void onError(String str, String str2) {
                Messages.Result.this.error(new Messages.FlutterError("setExposureOffsetFailed", "Could not set exposure offset.", null));
            }
        });
    }

    public float getMaxZoomLevel() {
        return this.cameraFeatures.getZoomLevel().getMaximumZoomLevel();
    }

    public float getMinZoomLevel() {
        return this.cameraFeatures.getZoomLevel().getMinimumZoomLevel();
    }

    CamcorderProfile getRecordingProfileLegacy() {
        return this.cameraFeatures.getResolution().getRecordingProfileLegacy();
    }

    EncoderProfiles getRecordingProfile() {
        return this.cameraFeatures.getResolution().getRecordingProfile();
    }

    DeviceOrientationManager getDeviceOrientationManager() {
        return this.cameraFeatures.getSensorOrientation().getDeviceOrientationManager();
    }

    public void setZoomLevel(final Messages.VoidResult voidResult, float f) {
        ZoomLevelFeature zoomLevel = this.cameraFeatures.getZoomLevel();
        float maximumZoomLevel = zoomLevel.getMaximumZoomLevel();
        float minimumZoomLevel = zoomLevel.getMinimumZoomLevel();
        if (f > maximumZoomLevel || f < minimumZoomLevel) {
            voidResult.error(new Messages.FlutterError("ZOOM_ERROR", String.format(Locale.ENGLISH, "Zoom level out of bounds (zoom level should be between %f and %f).", Float.valueOf(minimumZoomLevel), Float.valueOf(maximumZoomLevel)), null));
            return;
        }
        zoomLevel.setValue(Float.valueOf(f));
        zoomLevel.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new Camera$$ExternalSyntheticLambda8(voidResult), new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda11
            @Override // io.flutter.plugins.camera.ErrorCallback
            public final void onError(String str, String str2) {
                Messages.VoidResult.this.error(new Messages.FlutterError("setZoomLevelFailed", "Could not set zoom level.", null));
            }
        });
    }

    public void lockCaptureOrientation(PlatformChannel.DeviceOrientation deviceOrientation) {
        this.cameraFeatures.getSensorOrientation().lockCaptureOrientation(deviceOrientation);
    }

    public void unlockCaptureOrientation() {
        this.cameraFeatures.getSensorOrientation().unlockCaptureOrientation();
    }

    public void pausePreview() throws CameraAccessException {
        if (this.pausedPreview) {
            return;
        }
        this.pausedPreview = true;
        CameraCaptureSession cameraCaptureSession = this.captureSession;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.stopRepeating();
        }
    }

    public void resumePreview() {
        this.pausedPreview = false;
        refreshPreviewCaptureSession(null, new ErrorCallback() { // from class: io.flutter.plugins.camera.Camera$$ExternalSyntheticLambda4
            @Override // io.flutter.plugins.camera.ErrorCallback
            public final void onError(String str, String str2) {
                Camera.this.m771lambda$resumePreview$10$ioflutterpluginscameraCamera(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$resumePreview$10$io-flutter-plugins-camera-Camera, reason: not valid java name */
    public /* synthetic */ void m771lambda$resumePreview$10$ioflutterpluginscameraCamera(String str, String str2) {
        this.dartMessenger.sendCameraErrorEvent(str2);
    }

    public void startPreview(Runnable runnable) throws CameraAccessException, InterruptedException {
        if (this.recordingVideo) {
            startPreviewWithVideoRendererStream(runnable);
        } else {
            startRegularPreview(runnable);
        }
    }

    private void startRegularPreview(Runnable runnable) throws CameraAccessException {
        ImageReader imageReader = this.pictureImageReader;
        if (imageReader != null && imageReader.getSurface() != null) {
            Log.i(TAG, "startPreview");
            createCaptureSession(1, runnable, this.pictureImageReader.getSurface());
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void startPreviewWithVideoRendererStream(Runnable runnable) throws CameraAccessException, InterruptedException {
        int i;
        if (this.videoRenderer == null) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.cameraFeatures.getSensorOrientation().getLockedCaptureOrientation();
        DeviceOrientationManager deviceOrientationManager = this.cameraFeatures.getSensorOrientation().getDeviceOrientationManager();
        if (deviceOrientationManager == null) {
            i = 0;
        } else if (lockedCaptureOrientation == null) {
            i = deviceOrientationManager.getVideoOrientation();
        } else {
            i = deviceOrientationManager.getVideoOrientation(lockedCaptureOrientation);
        }
        if (this.cameraProperties.getLensFacing() != this.initialCameraFacing) {
            i = (i + 180) % 360;
        }
        this.videoRenderer.setRotation(i);
        createCaptureSession(3, runnable, this.videoRenderer.getInputSurface());
    }

    public void startPreviewWithImageStream(EventChannel eventChannel) throws CameraAccessException {
        setStreamHandler(eventChannel);
        startCapture(false, true);
        Log.i(TAG, "startPreviewWithImageStream");
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        Log.i(TAG, "onImageAvailable");
        Image acquireNextImage = imageReader.acquireNextImage();
        if (acquireNextImage == null) {
            return;
        }
        this.backgroundHandler.post(new ImageSaver(acquireNextImage, this.captureFile, new ImageSaver.Callback() { // from class: io.flutter.plugins.camera.Camera.4
            @Override // io.flutter.plugins.camera.ImageSaver.Callback
            public void onComplete(String str) {
                Camera.this.dartMessenger.finish(Camera.this.flutterResult, str);
            }

            @Override // io.flutter.plugins.camera.ImageSaver.Callback
            public void onError(String str, String str2) {
                Camera.this.dartMessenger.error(Camera.this.flutterResult, str, str2, null);
            }
        }));
        this.cameraCaptureCallback.setCameraState(CameraState.STATE_PREVIEW);
    }

    void prepareRecording() {
        try {
            File createTempFile = File.createTempFile("REC", ".mp4", this.applicationContext.getCacheDir());
            this.captureFile = createTempFile;
            try {
                prepareMediaRecorder(createTempFile.getAbsolutePath());
                this.cameraFeatures.setAutoFocus(this.cameraFeatureFactory.createAutoFocusFeature(this.cameraProperties, true));
                setFpsCameraFeatureForRecording(this.cameraProperties);
            } catch (IOException e) {
                this.recordingVideo = false;
                this.captureFile = null;
                throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
            }
        } catch (IOException | SecurityException e2) {
            throw new Messages.FlutterError("cannotCreateFile", e2.getMessage(), null);
        }
    }

    private void setStreamHandler(EventChannel eventChannel) {
        eventChannel.setStreamHandler(new EventChannel.StreamHandler() { // from class: io.flutter.plugins.camera.Camera.5
            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onListen(Object obj, EventChannel.EventSink eventSink) {
                Camera.this.setImageStreamImageAvailableListener(eventSink);
            }

            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onCancel(Object obj) {
                if (Camera.this.imageStreamReader == null) {
                    return;
                }
                Camera.this.imageStreamReader.removeListener(Camera.this.backgroundHandler);
            }
        });
    }

    void setImageStreamImageAvailableListener(EventChannel.EventSink eventSink) {
        ImageStreamReader imageStreamReader = this.imageStreamReader;
        if (imageStreamReader == null) {
            return;
        }
        imageStreamReader.subscribeListener(this.captureProps, eventSink, this.backgroundHandler);
    }

    void closeCaptureSession() {
        if (this.captureSession != null) {
            Log.i(TAG, "closeCaptureSession");
            this.captureSession.close();
            this.captureSession = null;
        }
    }

    public void close() {
        Log.i(TAG, "close");
        stopAndReleaseCamera();
        ImageReader imageReader = this.pictureImageReader;
        if (imageReader != null) {
            imageReader.close();
            this.pictureImageReader = null;
        }
        ImageStreamReader imageStreamReader = this.imageStreamReader;
        if (imageStreamReader != null) {
            imageStreamReader.close();
            this.imageStreamReader = null;
        }
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.reset();
            this.mediaRecorder.release();
            this.mediaRecorder = null;
        }
        stopBackgroundThread();
    }

    private void stopAndReleaseCamera() {
        CameraDeviceWrapper cameraDeviceWrapper = this.cameraDevice;
        if (cameraDeviceWrapper != null) {
            cameraDeviceWrapper.close();
            this.cameraDevice = null;
            this.captureSession = null;
            return;
        }
        closeCaptureSession();
    }

    private void prepareVideoRenderer() {
        if (this.videoRenderer != null) {
            return;
        }
        ResolutionFeature resolution = this.cameraFeatures.getResolution();
        this.videoRenderer = new VideoRenderer(this.mediaRecorder.getSurface(), resolution.getCaptureSize().getWidth(), resolution.getCaptureSize().getHeight(), new Thread.UncaughtExceptionHandler() { // from class: io.flutter.plugins.camera.Camera.6
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Camera.this.dartMessenger.sendCameraErrorEvent("Failed to process frames after camera was flipped.");
            }
        });
    }

    public void setDescriptionWhileRecording(CameraProperties cameraProperties) {
        if (!this.recordingVideo) {
            throw new Messages.FlutterError("setDescriptionWhileRecordingFailed", "Device was not recording", null);
        }
        if (!SdkCapabilityChecker.supportsEglRecordableAndroid()) {
            throw new Messages.FlutterError("setDescriptionWhileRecordingFailed", "Device does not support switching the camera while recording", null);
        }
        stopAndReleaseCamera();
        prepareVideoRenderer();
        this.cameraProperties = cameraProperties;
        CameraFeatures init = CameraFeatures.init(this.cameraFeatureFactory, cameraProperties, this.activity, this.dartMessenger, this.videoCaptureSettings.resolutionPreset);
        this.cameraFeatures = init;
        init.setAutoFocus(this.cameraFeatureFactory.createAutoFocusFeature(this.cameraProperties, true));
        setFpsCameraFeatureForRecording(this.cameraProperties);
        try {
            open(Integer.valueOf(this.imageFormatGroup));
        } catch (CameraAccessException e) {
            throw new Messages.FlutterError("setDescriptionWhileRecordingFailed", e.getMessage(), null);
        }
    }

    public void dispose() {
        Log.i(TAG, "dispose");
        close();
        this.flutterTexture.release();
        getDeviceOrientationManager().stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class HandlerThreadFactory {
        HandlerThreadFactory() {
        }

        public static HandlerThread create(String str) {
            return new HandlerThread(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class HandlerFactory {
        HandlerFactory() {
        }

        public static Handler create(Looper looper) {
            return new Handler(looper);
        }
    }
}
