package io.flutter.plugins.camera.features.zoomlevel;

import android.graphics.Rect;
import androidx.core.math.MathUtils;

/* loaded from: classes4.dex */
final class ZoomUtils {
    ZoomUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect computeZoomRect(float f, Rect rect, float f2, float f3) {
        float floatValue = computeZoomRatio(f, f2, f3).floatValue();
        int width = rect.width() / 2;
        int height = rect.height() / 2;
        int width2 = (int) ((rect.width() * 0.5f) / floatValue);
        int height2 = (int) ((rect.height() * 0.5f) / floatValue);
        return new Rect(width - width2, height - height2, width + width2, height + height2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Float computeZoomRatio(float f, float f2, float f3) {
        return Float.valueOf(MathUtils.clamp(f, f2, f3));
    }
}
