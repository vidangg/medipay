package com.amolg.flutterbarcodescanner;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.amolg.flutterbarcodescanner.BarcodeGraphicTracker;
import com.amolg.flutterbarcodescanner.camera.CameraSource;
import com.amolg.flutterbarcodescanner.camera.CameraSourcePreview;
import com.amolg.flutterbarcodescanner.camera.GraphicOverlay;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.material.snackbar.Snackbar;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes3.dex */
public final class BarcodeCaptureActivity extends AppCompatActivity implements BarcodeGraphicTracker.BarcodeUpdateListener, View.OnClickListener {
    public static final int BARCODE_FORMATS = 3823;
    public static final String BarcodeObject = "Barcode";
    public static final int QR_CODE_FORMATS = 256;
    private static final int RC_HANDLE_CAMERA_PERM = 2;
    private static final int RC_HANDLE_GMS = 9001;
    public static SCAN_FORMAT_ENUM SCAN_FORMAT = SCAN_FORMAT_ENUM.ALL_FORMATS;
    public static int SCAN_MODE = SCAN_MODE_ENUM.QR.ordinal();
    private int cameraFacing = 0;
    private int flashStatus = USE_FLASH.OFF.ordinal();
    private GestureDetector gestureDetector;
    private ImageView imgViewBarcodeCaptureUseFlash;
    private ImageView imgViewSwitchCamera;
    private CameraSource mCameraSource;
    private GraphicOverlay<BarcodeGraphic> mGraphicOverlay;
    private CameraSourcePreview mPreview;
    private ScaleGestureDetector scaleGestureDetector;

    /* loaded from: classes3.dex */
    public enum SCAN_FORMAT_ENUM {
        ALL_FORMATS,
        ONLY_QR_CODE,
        ONLY_BARCODE
    }

    /* loaded from: classes3.dex */
    public enum SCAN_MODE_ENUM {
        QR,
        BARCODE,
        DEFAULT
    }

    /* loaded from: classes3.dex */
    enum USE_FLASH {
        ON,
        OFF
    }

    private int getInverseCameraFacing(int i) {
        return (i != 1 && i == 0) ? 1 : 0;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Barcode barcode = new Barcode();
        barcode.rawValue = "-2";
        barcode.displayValue = "-2";
        FlutterBarcodeScannerPlugin.onBarcodeScanReceiver(barcode);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        try {
            setContentView(R.layout.barcode_capture);
            String str2 = "";
            try {
                str = getIntent().getStringExtra("cancelButtonText");
                str2 = getIntent().getStringExtra("cameraFacingText");
            } catch (Exception e) {
                Log.e("BCActivity:onCreate()", "onCreate: " + e.getLocalizedMessage());
                str = "Cancel";
            }
            Button button = (Button) findViewById(R.id.btnBarcodeCaptureCancel);
            button.setText(str);
            button.setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(R.id.imgViewBarcodeCaptureUseFlash);
            this.imgViewBarcodeCaptureUseFlash = imageView;
            imageView.setOnClickListener(this);
            this.imgViewBarcodeCaptureUseFlash.setVisibility(FlutterBarcodeScannerPlugin.isShowFlashIcon ? 0 : 8);
            ImageView imageView2 = (ImageView) findViewById(R.id.imgViewSwitchCamera);
            this.imgViewSwitchCamera = imageView2;
            imageView2.setOnClickListener(this);
            this.mPreview = (CameraSourcePreview) findViewById(R.id.preview);
            this.mGraphicOverlay = (GraphicOverlay) findViewById(R.id.graphicOverlay);
            this.cameraFacing = Objects.equals(str2, "FRONT") ? 1 : 0;
            if (ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                createCameraSource(true, false, this.cameraFacing);
            } else {
                requestCameraPermission();
            }
            this.gestureDetector = new GestureDetector(this, new CaptureGestureListener());
            this.scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        } catch (Exception unused) {
        }
    }

    private void requestCameraPermission() {
        final String[] strArr = {"android.permission.CAMERA"};
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
            ActivityCompat.requestPermissions(this, strArr, 2);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.amolg.flutterbarcodescanner.BarcodeCaptureActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityCompat.requestPermissions(this, strArr, 2);
            }
        };
        findViewById(R.id.topLayout).setOnClickListener(onClickListener);
        Snackbar.make(this.mGraphicOverlay, R.string.permission_camera_rationale, -2).setAction(R.string.ok, onClickListener).show();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.scaleGestureDetector.onTouchEvent(motionEvent) || this.gestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    private void createCameraSource(boolean z, boolean z2, int i) {
        Context applicationContext = getApplicationContext();
        int intExtra = getIntent().getIntExtra("delayMillis", 0);
        BarcodeDetector build = new BarcodeDetector.Builder(applicationContext).setBarcodeFormats(getFormats()).build();
        Log.d("BarcodeCaptureActivity", "Barcode detector set up:" + intExtra);
        build.setProcessor(new MultiProcessor.Builder(new BarcodeTrackerFactory(this.mGraphicOverlay, this, intExtra)).build());
        if (!build.isOperational() && registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) != null) {
            Toast.makeText(this, R.string.low_storage_error, 1).show();
        }
        CameraSource.Builder focusMode = new CameraSource.Builder(getApplicationContext(), build).setFacing(i).setRequestedPreviewSize(1600, 1024).setRequestedFps(30.0f).setFlashMode(z2 ? "torch" : null).setFocusMode(z ? "continuous-picture" : null);
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.stop();
            this.mCameraSource.release();
        }
        this.mCameraSource = focusMode.build();
    }

    private static int getFormats() {
        return SCAN_FORMAT == SCAN_FORMAT_ENUM.ONLY_BARCODE ? BARCODE_FORMATS : SCAN_FORMAT == SCAN_FORMAT_ENUM.ONLY_QR_CODE ? 256 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        startCameraSource();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.stop();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.release();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 2) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (iArr.length != 0 && iArr[0] == 0) {
            createCameraSource(true, false, this.cameraFacing);
        } else {
            new AlertDialog.Builder(this).setTitle("Allow permissions").setMessage(R.string.no_camera_permission).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.amolg.flutterbarcodescanner.BarcodeCaptureActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    BarcodeCaptureActivity.this.finish();
                }
            }).show();
        }
    }

    private void startCameraSource() throws SecurityException {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getApplicationContext());
        if (isGooglePlayServicesAvailable != 0) {
            GoogleApiAvailability.getInstance().getErrorDialog(this, isGooglePlayServicesAvailable, RC_HANDLE_GMS).show();
        }
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            try {
                this.mPreview.start(cameraSource, this.mGraphicOverlay);
            } catch (IOException unused) {
                this.mCameraSource.release();
                this.mCameraSource = null;
            }
        }
        System.gc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onTap(float f, float f2) {
        this.mGraphicOverlay.getLocationOnScreen(new int[2]);
        float widthScaleFactor = (f - r0[0]) / this.mGraphicOverlay.getWidthScaleFactor();
        float heightScaleFactor = (f2 - r0[1]) / this.mGraphicOverlay.getHeightScaleFactor();
        Iterator<BarcodeGraphic> it = this.mGraphicOverlay.getGraphics().iterator();
        Barcode barcode = null;
        float f3 = Float.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Barcode barcode2 = it.next().getBarcode();
            if (barcode2.getBoundingBox().contains((int) widthScaleFactor, (int) heightScaleFactor)) {
                barcode = barcode2;
                break;
            }
            float centerX = widthScaleFactor - barcode2.getBoundingBox().centerX();
            float centerY = heightScaleFactor - barcode2.getBoundingBox().centerY();
            float f4 = (centerX * centerX) + (centerY * centerY);
            if (f4 < f3) {
                barcode = barcode2;
                f3 = f4;
            }
        }
        if (barcode == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra(BarcodeObject, barcode);
        setResult(0, intent);
        finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imgViewBarcodeCaptureUseFlash && getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            try {
                if (this.flashStatus == USE_FLASH.OFF.ordinal()) {
                    this.flashStatus = USE_FLASH.ON.ordinal();
                    this.imgViewBarcodeCaptureUseFlash.setImageResource(R.drawable.ic_barcode_flash_on);
                    turnOnOffFlashLight(true);
                } else {
                    this.flashStatus = USE_FLASH.OFF.ordinal();
                    this.imgViewBarcodeCaptureUseFlash.setImageResource(R.drawable.ic_barcode_flash_off);
                    turnOnOffFlashLight(false);
                }
                return;
            } catch (Exception e) {
                Toast.makeText(this, "Unable to turn on flash", 0).show();
                Log.e("BarcodeCaptureActivity", "FlashOnFailure: " + e.getLocalizedMessage());
                return;
            }
        }
        if (id == R.id.btnBarcodeCaptureCancel) {
            onBackPressed();
        } else if (id == R.id.imgViewSwitchCamera) {
            this.cameraFacing = this.mCameraSource.getCameraFacing();
            createCameraSource(this.mCameraSource.getFocusMode() != null, this.flashStatus == USE_FLASH.ON.ordinal(), getInverseCameraFacing(this.cameraFacing));
            startCameraSource();
        }
    }

    private void turnOnOffFlashLight(boolean z) {
        try {
            if (getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                this.mCameraSource.setFlashMode(z ? "torch" : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                Toast.makeText(getBaseContext(), "Unable to access flashlight as flashlight not available", 0).show();
            }
        } catch (Exception unused) {
            Toast.makeText(getBaseContext(), "Unable to access flashlight.", 0).show();
        }
    }

    /* loaded from: classes3.dex */
    private class CaptureGestureListener extends GestureDetector.SimpleOnGestureListener {
        private CaptureGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return BarcodeCaptureActivity.this.onTap(motionEvent.getRawX(), motionEvent.getRawY()) || super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    private class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            BarcodeCaptureActivity.this.mCameraSource.doZoom(scaleGestureDetector.getScaleFactor());
        }
    }

    @Override // com.amolg.flutterbarcodescanner.BarcodeGraphicTracker.BarcodeUpdateListener
    public void onBarcodeDetected(Barcode barcode) {
        if (barcode != null) {
            if (FlutterBarcodeScannerPlugin.isContinuousScan) {
                FlutterBarcodeScannerPlugin.onBarcodeScanReceiver(barcode);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(BarcodeObject, barcode);
            setResult(0, intent);
            finish();
        }
    }
}
