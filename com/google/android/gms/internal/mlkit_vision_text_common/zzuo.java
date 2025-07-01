package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzuo {
    private static zzuo zza;

    private zzuo() {
    }

    public static synchronized zzuo zza() {
        zzuo zzuoVar;
        synchronized (zzuo.class) {
            if (zza == null) {
                zza = new zzuo();
            }
            zzuoVar = zza;
        }
        return zzuoVar;
    }
}
