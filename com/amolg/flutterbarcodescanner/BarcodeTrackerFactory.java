package com.amolg.flutterbarcodescanner;

import android.content.Context;
import com.amolg.flutterbarcodescanner.camera.GraphicOverlay;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BarcodeTrackerFactory implements MultiProcessor.Factory<Barcode> {
    private int delayMillis;
    private Context mContext;
    private GraphicOverlay<BarcodeGraphic> mGraphicOverlay;

    public BarcodeTrackerFactory(GraphicOverlay<BarcodeGraphic> graphicOverlay, Context context, int i) {
        this.mGraphicOverlay = graphicOverlay;
        this.mContext = context;
        this.delayMillis = i;
    }

    @Override // com.google.android.gms.vision.MultiProcessor.Factory
    public Tracker<Barcode> create(Barcode barcode) {
        return new BarcodeGraphicTracker(this.mGraphicOverlay, new BarcodeGraphic(this.mGraphicOverlay), this.mContext, this.delayMillis);
    }
}
