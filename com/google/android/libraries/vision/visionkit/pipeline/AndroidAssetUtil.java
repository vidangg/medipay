package com.google.android.libraries.vision.visionkit.pipeline;

import android.content.Context;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class AndroidAssetUtil {
    private static native boolean nativeInitializeAssetManager(Context context, String str);

    public static synchronized boolean zba(Context context) {
        boolean nativeInitializeAssetManager;
        synchronized (AndroidAssetUtil.class) {
            nativeInitializeAssetManager = nativeInitializeAssetManager(context, context.getCacheDir().getAbsolutePath());
        }
        return nativeInitializeAssetManager;
    }
}
