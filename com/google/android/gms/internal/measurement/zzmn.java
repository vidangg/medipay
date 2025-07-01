package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public enum zzmn {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzld.class, zzld.class, zzld.zzb),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class zzl;

    zzmn(Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }

    public final Class zza() {
        return this.zzl;
    }
}
