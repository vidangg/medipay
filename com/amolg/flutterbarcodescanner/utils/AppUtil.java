package com.amolg.flutterbarcodescanner.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public class AppUtil {
    public static int dpToPx(Context context, int i) {
        return Math.round(i * (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }
}
