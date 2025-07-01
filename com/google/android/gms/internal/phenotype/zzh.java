package com.google.android.gms.internal.phenotype;

import android.content.Context;

/* loaded from: classes3.dex */
public final class zzh<T> {
    private static final Object zzak = new Object();
    private static Context zzal = null;
    private static boolean zzam = false;
    private static volatile Boolean zzan;
    private static volatile Boolean zzbq;

    public static void init(Context context) {
        Context applicationContext;
        synchronized (zzak) {
            if (!context.isDeviceProtectedStorage() && (applicationContext = context.getApplicationContext()) != null) {
                context = applicationContext;
            }
            if (zzal != context) {
                zzan = null;
            }
            zzal = context;
        }
        zzam = false;
    }

    public static void maybeInit(Context context) {
        if (zzal == null) {
            init(context);
        }
    }
}
