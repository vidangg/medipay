package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes3.dex */
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(Window window, boolean z) {
        applyEdgeToEdge(window, z, null, null);
    }

    public static void applyEdgeToEdge(Window window, boolean z, Integer num, Integer num2) {
        boolean z2 = num == null || num.intValue() == 0;
        boolean z3 = num2 == null || num2.intValue() == 0;
        if (z2 || z3) {
            int color = MaterialColors.getColor(window.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
            if (z2) {
                num = Integer.valueOf(color);
            }
            if (z3) {
                num2 = Integer.valueOf(color);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z);
        int statusBarColor = getStatusBarColor(window.getContext(), z);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        boolean isUsingLightSystemBar = isUsingLightSystemBar(statusBarColor, MaterialColors.isColorLight(num.intValue()));
        boolean isUsingLightSystemBar2 = isUsingLightSystemBar(navigationBarColor, MaterialColors.isColorLight(num2.intValue()));
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        if (insetsController != null) {
            insetsController.setAppearanceLightStatusBars(isUsingLightSystemBar);
            insetsController.setAppearanceLightNavigationBars(isUsingLightSystemBar2);
        }
    }

    private static int getStatusBarColor(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private static int getNavigationBarColor(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private static boolean isUsingLightSystemBar(int i, boolean z) {
        return MaterialColors.isColorLight(i) || (i == 0 && z);
    }
}
