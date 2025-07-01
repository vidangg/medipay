package com.amolg.flutterbarcodescanner.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.common.C;
import com.amolg.flutterbarcodescanner.widget.FlutterBarcodeView;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes3.dex */
public class FlutterBarcodeView implements PlatformView {
    private static int SCAN_AREA_HEIGHT = 200;
    private static int SCAN_AREA_WIDTH = 400;
    private static final String TAG = "FlutterBarcodeView";
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private final Context context;
    private final FrameLayout frameLayout;
    private boolean isDetecting = true;
    private boolean isFlashOn = false;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final MethodChannel methodChannel;
    private ParamData paramData;
    private final ImageView scanLine;
    private final ScannerOverlay scannerOverlay;
    private final SurfaceView surfaceView;

    public FlutterBarcodeView(Context context, BinaryMessenger binaryMessenger, int i, Object obj) {
        this.context = context;
        this.paramData = ParamData.fromMap((Map) obj);
        setDefaultData();
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        SurfaceView surfaceView = new SurfaceView(context);
        this.surfaceView = surfaceView;
        frameLayout.addView(surfaceView, new FrameLayout.LayoutParams(-1, -1));
        ScannerOverlay scannerOverlay = new ScannerOverlay(context);
        this.scannerOverlay = scannerOverlay;
        frameLayout.addView(scannerOverlay, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(context);
        this.scanLine = imageView;
        imageView.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(SCAN_AREA_WIDTH - 40, 5));
        startScanLineAnimation();
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.codingwithtashi/barcode_scanner_view_" + i);
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.amolg.flutterbarcodescanner.widget.FlutterBarcodeView$$ExternalSyntheticLambda0
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                FlutterBarcodeView.this.onMethodCall(methodCall, result);
            }
        });
        setupBarcodeDetector();
        setupCameraSource();
        setupSurfaceHolder();
    }

    private void setDefaultData() {
        SCAN_AREA_WIDTH = this.paramData.getScannerWidth() != null ? this.paramData.getScannerWidth().intValue() : SCAN_AREA_WIDTH;
        SCAN_AREA_HEIGHT = this.paramData.getScannerHeight() != null ? this.paramData.getScannerHeight().intValue() : SCAN_AREA_HEIGHT;
    }

    private int getScreenWidth() {
        return this.context.getResources().getDisplayMetrics().widthPixels;
    }

    private int getScreenHeight() {
        return this.context.getResources().getDisplayMetrics().heightPixels;
    }

    private void startScanLineAnimation() {
        this.scanLine.post(new Runnable() { // from class: com.amolg.flutterbarcodescanner.widget.FlutterBarcodeView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlutterBarcodeView.this.m610x9fc3a45a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startScanLineAnimation$0$com-amolg-flutterbarcodescanner-widget-FlutterBarcodeView, reason: not valid java name */
    public /* synthetic */ void m610x9fc3a45a() {
        int height = (this.surfaceView.getHeight() - SCAN_AREA_HEIGHT) / 2;
        this.scanLine.setX(((this.surfaceView.getWidth() - SCAN_AREA_WIDTH) / 2) + 20);
        this.scanLine.setY(height);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, SCAN_AREA_HEIGHT - 5);
        translateAnimation.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        this.scanLine.startAnimation(translateAnimation);
    }

    /* loaded from: classes3.dex */
    private class ScannerOverlay extends View {
        private final Paint boxPaint;
        private final Paint overlayPaint;

        public ScannerOverlay(Context context) {
            super(context);
            Paint paint = new Paint();
            this.boxPaint = paint;
            paint.setColor(-1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5.0f);
            Paint paint2 = new Paint();
            this.overlayPaint = paint2;
            paint2.setColor(Color.parseColor("#80000000"));
            paint2.setStyle(Paint.Style.FILL);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();
            int i = (width - FlutterBarcodeView.SCAN_AREA_WIDTH) / 2;
            int i2 = (height - FlutterBarcodeView.SCAN_AREA_HEIGHT) / 2;
            int i3 = FlutterBarcodeView.SCAN_AREA_WIDTH + i;
            int i4 = FlutterBarcodeView.SCAN_AREA_HEIGHT + i2;
            float f = width;
            float f2 = i2;
            canvas.drawRect(0.0f, 0.0f, f, f2, this.overlayPaint);
            float f3 = i;
            float f4 = i4;
            canvas.drawRect(0.0f, f2, f3, f4, this.overlayPaint);
            float f5 = i3;
            canvas.drawRect(f5, f2, f, f4, this.overlayPaint);
            canvas.drawRect(0.0f, f4, f, height, this.overlayPaint);
            canvas.drawRect(f3, f2, f5, f4, this.boxPaint);
        }
    }

    private void setupBarcodeDetector() {
        BarcodeDetector build = new BarcodeDetector.Builder(this.context).setBarcodeFormats(0).build();
        this.barcodeDetector = build;
        build.setProcessor(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amolg.flutterbarcodescanner.widget.FlutterBarcodeView$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Detector.Processor<Barcode> {
        @Override // com.google.android.gms.vision.Detector.Processor
        public void release() {
        }

        AnonymousClass1() {
        }

        @Override // com.google.android.gms.vision.Detector.Processor
        public void receiveDetections(Detector.Detections<Barcode> detections) {
            if (FlutterBarcodeView.this.isDetecting) {
                SparseArray<Barcode> detectedItems = detections.getDetectedItems();
                if (detectedItems.size() > 0) {
                    Camera.Size previewSize = FlutterBarcodeView.this.getCamera().getParameters().getPreviewSize();
                    float width = FlutterBarcodeView.this.surfaceView.getWidth() / previewSize.width;
                    float height = FlutterBarcodeView.this.surfaceView.getHeight() / previewSize.height;
                    RectF rectF = new RectF((FlutterBarcodeView.this.surfaceView.getWidth() - FlutterBarcodeView.SCAN_AREA_WIDTH) / 2, (FlutterBarcodeView.this.surfaceView.getHeight() - FlutterBarcodeView.SCAN_AREA_HEIGHT) / 2, r0 + FlutterBarcodeView.SCAN_AREA_WIDTH, r3 + FlutterBarcodeView.SCAN_AREA_HEIGHT);
                    for (int i = 0; i < detectedItems.size(); i++) {
                        final Barcode valueAt = detectedItems.valueAt(i);
                        RectF rectF2 = new RectF(valueAt.getBoundingBox().left * width, valueAt.getBoundingBox().top * height, valueAt.getBoundingBox().right * width, valueAt.getBoundingBox().bottom * height);
                        if (RectF.intersects(rectF, rectF2)) {
                            RectF rectF3 = new RectF();
                            rectF3.setIntersect(rectF, rectF2);
                            float width2 = ((rectF3.width() * rectF3.height()) / (rectF2.width() * rectF2.height())) * 100.0f;
                            System.out.println("Overlap percentage: " + width2);
                            if (width2 >= 100.0f) {
                                FlutterBarcodeView.this.mainHandler.post(new Runnable() { // from class: com.amolg.flutterbarcodescanner.widget.FlutterBarcodeView$1$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        FlutterBarcodeView.AnonymousClass1.this.m611xe90c966d(valueAt);
                                    }
                                });
                                return;
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$receiveDetections$0$com-amolg-flutterbarcodescanner-widget-FlutterBarcodeView$1, reason: not valid java name */
        public /* synthetic */ void m611xe90c966d(Barcode barcode) {
            FlutterBarcodeView.this.methodChannel.invokeMethod("onBarcodeDetected", barcode.rawValue);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        return this.frameLayout;
    }

    private void setupCameraSource() {
        this.cameraSource = new CameraSource.Builder(this.context, this.barcodeDetector).setAutoFocusEnabled(true).setRequestedPreviewSize(1600, 1024).build();
    }

    private void setupSurfaceHolder() {
        this.surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.amolg.flutterbarcodescanner.widget.FlutterBarcodeView.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    FlutterBarcodeView.this.cameraSource.start(FlutterBarcodeView.this.surfaceView.getHolder());
                } catch (IOException e) {
                    Log.e(FlutterBarcodeView.TAG, "Error starting camera: " + e.getMessage());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                FlutterBarcodeView.this.cameraSource.stop();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera getCamera() {
        try {
            for (Field field : CameraSource.class.getDeclaredFields()) {
                if (field.getType() == Camera.class) {
                    field.setAccessible(true);
                    return (Camera) field.get(this.cameraSource);
                }
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Error accessing camera: " + e.getMessage());
            return null;
        }
    }

    private void toggleFlash(MethodChannel.Result result) {
        try {
            Camera camera = getCamera();
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();
                if (!this.isFlashOn) {
                    parameters.setFlashMode("torch");
                    this.isFlashOn = true;
                } else {
                    parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    this.isFlashOn = false;
                }
                camera.setParameters(parameters);
                result.success(Boolean.valueOf(this.isFlashOn));
                return;
            }
            result.error("CAMERA_ERROR", "Camera not available", null);
        } catch (Exception e) {
            result.error("FLASH_ERROR", "Error toggling flash: " + e.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2132834306:
                if (str.equals("resumeScanning")) {
                    c = 0;
                    break;
                }
                break;
            case -668845828:
                if (str.equals("toggleFlash")) {
                    c = 1;
                    break;
                }
                break;
            case 1526205639:
                if (str.equals("pauseScanning")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.isDetecting = true;
                result.success(null);
                return;
            case 1:
                toggleFlash(result);
                return;
            case 2:
                this.isDetecting = false;
                result.success(null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        CameraSource cameraSource = this.cameraSource;
        if (cameraSource != null) {
            cameraSource.release();
            this.cameraSource = null;
        }
        BarcodeDetector barcodeDetector = this.barcodeDetector;
        if (barcodeDetector != null) {
            barcodeDetector.release();
            this.barcodeDetector = null;
        }
        this.scanLine.clearAnimation();
    }
}
