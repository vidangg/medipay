package com.amolg.flutterbarcodescanner.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amolg.flutterbarcodescanner.BarcodeCaptureActivity;
import com.amolg.flutterbarcodescanner.FlutterBarcodeScannerPlugin;
import com.amolg.flutterbarcodescanner.camera.GraphicOverlay.Graphic;
import com.amolg.flutterbarcodescanner.utils.AppUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/* loaded from: classes3.dex */
public class GraphicOverlay<T extends Graphic> extends View {
    private float endY;
    private int frames;
    private float left;
    private int lineColor;
    private int lineWidth;
    private int mFacing;
    private Set<T> mGraphics;
    private float mHeightScaleFactor;
    private final Object mLock;
    private float mWidthScaleFactor;
    private int rectHeight;
    private int rectWidth;
    private boolean revAnimation;
    private float top;

    /* loaded from: classes3.dex */
    public static abstract class Graphic {
        private GraphicOverlay mOverlay;

        public abstract void draw(Canvas canvas);

        public Graphic(GraphicOverlay graphicOverlay) {
            this.mOverlay = graphicOverlay;
        }

        public float scaleX(float f) {
            return f * this.mOverlay.mWidthScaleFactor;
        }

        public float scaleY(float f) {
            return f * this.mOverlay.mHeightScaleFactor;
        }

        public float translateX(float f) {
            if (this.mOverlay.mFacing == 1) {
                return this.mOverlay.getWidth() - scaleX(f);
            }
            return scaleX(f);
        }

        public float translateY(float f) {
            return scaleY(f);
        }

        public void postInvalidate() {
            this.mOverlay.postInvalidate();
        }
    }

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLock = new Object();
        this.mWidthScaleFactor = 1.0f;
        this.mHeightScaleFactor = 1.0f;
        this.mFacing = 0;
        this.mGraphics = new HashSet();
        this.rectWidth = 350;
        this.rectHeight = BarcodeCaptureActivity.SCAN_MODE != BarcodeCaptureActivity.SCAN_MODE_ENUM.QR.ordinal() ? 233 : 350;
        this.lineColor = Color.parseColor(FlutterBarcodeScannerPlugin.lineColor);
        this.lineWidth = 4;
        this.frames = 5;
    }

    public void clear() {
        synchronized (this.mLock) {
            this.mGraphics.clear();
        }
        postInvalidate();
    }

    public void add(T t) {
        synchronized (this.mLock) {
            this.mGraphics.add(t);
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.left = (i - AppUtil.dpToPx(getContext(), this.rectWidth)) / 2;
        float dpToPx = (i2 - AppUtil.dpToPx(getContext(), this.rectHeight)) / 2;
        this.top = dpToPx;
        this.endY = dpToPx;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void remove(T t) {
        synchronized (this.mLock) {
            this.mGraphics.remove(t);
        }
        postInvalidate();
    }

    public List<T> getGraphics() {
        Vector vector;
        synchronized (this.mLock) {
            vector = new Vector(this.mGraphics);
        }
        return vector;
    }

    public float getWidthScaleFactor() {
        return this.mWidthScaleFactor;
    }

    public float getHeightScaleFactor() {
        return this.mHeightScaleFactor;
    }

    public void setCameraInfo(int i, int i2, int i3) {
        synchronized (this.mLock) {
            this.mFacing = i3;
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float f = 0;
        canvas.drawRoundRect(new RectF(this.left, this.top, AppUtil.dpToPx(getContext(), this.rectWidth) + this.left, AppUtil.dpToPx(getContext(), this.rectHeight) + this.top), f, f, paint);
        Paint paint2 = new Paint();
        paint2.setColor(this.lineColor);
        float f2 = this.lineWidth;
        Float.valueOf(f2).getClass();
        paint2.setStrokeWidth(f2);
        float f3 = this.endY;
        float dpToPx = this.top + AppUtil.dpToPx(getContext(), this.rectHeight);
        int i = this.frames;
        if (f3 >= dpToPx + i) {
            this.revAnimation = true;
        } else if (this.endY == this.top + i) {
            this.revAnimation = false;
        }
        if (this.revAnimation) {
            this.endY -= i;
        } else {
            this.endY += i;
        }
        float f4 = this.left;
        canvas.drawLine(f4, this.endY, f4 + AppUtil.dpToPx(getContext(), this.rectWidth), this.endY, paint2);
        invalidate();
    }
}
