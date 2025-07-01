package com.amolg.flutterbarcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.amolg.flutterbarcodescanner.camera.GraphicOverlay;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes3.dex */
public class BarcodeGraphicTracker extends Tracker<Barcode> {
    private int delayMillis;
    private BarcodeUpdateListener mBarcodeUpdateListener;
    private BarcodeGraphic mGraphic;
    private GraphicOverlay<BarcodeGraphic> mOverlay;
    private boolean isWaiting = false;
    private Handler handler = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public interface BarcodeUpdateListener {
        void onBarcodeDetected(Barcode barcode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public BarcodeGraphicTracker(GraphicOverlay<BarcodeGraphic> graphicOverlay, BarcodeGraphic barcodeGraphic, Context context, int i) {
        this.mOverlay = graphicOverlay;
        this.mGraphic = barcodeGraphic;
        this.delayMillis = i;
        if (context instanceof BarcodeUpdateListener) {
            this.mBarcodeUpdateListener = (BarcodeUpdateListener) context;
            return;
        }
        throw new RuntimeException("Hosting activity must implement BarcodeUpdateListener");
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onNewItem(int i, Barcode barcode) {
        this.mGraphic.setId(i);
        processDetection(barcode);
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onUpdate(Detector.Detections<Barcode> detections, Barcode barcode) {
        this.mOverlay.add(this.mGraphic);
        this.mGraphic.updateItem(barcode);
        processDetection(barcode);
    }

    private void processDetection(final Barcode barcode) {
        if (!this.isWaiting) {
            this.isWaiting = true;
            Log.d("BarcodeGraphicTracker", "Barcode detected, waiting for " + this.delayMillis + "ms");
            this.handler.postDelayed(new Runnable() { // from class: com.amolg.flutterbarcodescanner.BarcodeGraphicTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    BarcodeGraphicTracker.this.mBarcodeUpdateListener.onBarcodeDetected(barcode);
                    BarcodeGraphicTracker.this.isWaiting = false;
                    Log.d("BarcodeGraphicTracker", "Delay completed, barcode processed");
                }
            }, (long) this.delayMillis);
            return;
        }
        Log.d("BarcodeGraphicTracker", "Still waiting, ignoring new detection");
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onMissing(Detector.Detections<Barcode> detections) {
        this.mOverlay.remove(this.mGraphic);
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onDone() {
        this.mOverlay.remove(this.mGraphic);
    }
}
