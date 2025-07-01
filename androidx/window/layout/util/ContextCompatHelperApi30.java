package androidx.window.layout.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextCompatHelper.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Landroidx/window/layout/util/ContextCompatHelperApi30;", "", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "context", "Landroid/content/Context;", "currentWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "currentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "maximumWindowBounds", "window_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class ContextCompatHelperApi30 {
    public static final ContextCompatHelperApi30 INSTANCE = new ContextCompatHelperApi30();

    private ContextCompatHelperApi30() {
    }

    public final WindowMetrics currentWindowMetrics(Context context) {
        android.view.WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        android.view.WindowMetrics currentWindowMetrics2;
        Rect bounds;
        Intrinsics.checkNotNullParameter(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        windowInsets = currentWindowMetrics.getWindowInsets();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        currentWindowMetrics2 = windowManager.getCurrentWindowMetrics();
        bounds = currentWindowMetrics2.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "wm.currentWindowMetrics.bounds");
        return new WindowMetrics(bounds, windowInsetsCompat);
    }

    public final Rect currentWindowBounds(Context context) {
        android.view.WindowMetrics currentWindowMetrics;
        Rect bounds;
        Intrinsics.checkNotNullParameter(context, "context");
        currentWindowMetrics = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
        bounds = currentWindowMetrics.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "wm.currentWindowMetrics.bounds");
        return bounds;
    }

    public final Rect maximumWindowBounds(Context context) {
        android.view.WindowMetrics maximumWindowMetrics;
        Rect bounds;
        Intrinsics.checkNotNullParameter(context, "context");
        maximumWindowMetrics = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics();
        bounds = maximumWindowMetrics.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "wm.maximumWindowMetrics.bounds");
        return bounds;
    }

    public final WindowInsetsCompat currentWindowInsets(Context context) {
        android.view.WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        Intrinsics.checkNotNullParameter(context, "context");
        currentWindowMetrics = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics();
        windowInsets = currentWindowMetrics.getWindowInsets();
        Intrinsics.checkNotNullExpressionValue(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(platformInsets)");
        return windowInsetsCompat;
    }
}
