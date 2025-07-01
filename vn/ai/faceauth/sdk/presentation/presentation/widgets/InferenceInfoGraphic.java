package vn.ai.faceauth.sdk.presentation.presentation.widgets;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.PsExtractor;
import paua.btj;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.GraphicOverlay;

/* loaded from: classes4.dex */
public class InferenceInfoGraphic extends GraphicOverlay.Graphic {
    private static int TEXT_COLOR;
    private static float TEXT_SIZE;
    private final long detectorLatency;
    private final long frameLatency;
    private final Integer framesPerSecond;
    private final GraphicOverlay overlay;
    private boolean showLatencyInfo;
    private final Paint textPaint;

    static {
        btj.sfgt(InferenceInfoGraphic.class, 621, 622);
    }

    public InferenceInfoGraphic(GraphicOverlay graphicOverlay) {
        this(graphicOverlay, 0L, 0L, null);
        this.showLatencyInfo = false;
    }

    public InferenceInfoGraphic(GraphicOverlay graphicOverlay, long j, long j2, Integer num) {
        super(graphicOverlay);
        this.showLatencyInfo = true;
        this.overlay = graphicOverlay;
        this.frameLatency = j;
        this.detectorLatency = j2;
        this.framesPerSecond = num;
        Paint paint = new Paint();
        this.textPaint = paint;
        paint.setColor(-1);
        paint.setTextSize(60.0f);
        paint.setShadowLayer(5.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        postInvalidate();
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.widgets.GraphicOverlay.Graphic
    public void draw(Canvas canvas) {
        String str;
        synchronized (this) {
            canvas.drawText(btj.tzend(238) + this.overlay.getImageHeight() + btj.tzend(239) + this.overlay.getImageWidth(), 30.0f, 90.0f, this.textPaint);
            if (this.showLatencyInfo) {
                if (this.framesPerSecond != null) {
                    str = btj.tzend(PsExtractor.VIDEO_STREAM_MASK) + this.framesPerSecond + btj.tzend(241) + this.frameLatency + btj.tzend(242);
                } else {
                    str = btj.tzend(243) + this.frameLatency + btj.tzend(244);
                }
                canvas.drawText(str, 30.0f, 150.0f, this.textPaint);
                canvas.drawText(btj.tzend(245) + this.detectorLatency + btj.tzend(246), 30.0f, 210.0f, this.textPaint);
            }
        }
    }
}
