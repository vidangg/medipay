package com.google.android.gms.internal.clearcut;

import androidx.camera.video.AudioStats;

/* loaded from: classes3.dex */
public enum zzfq {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzbb.zzfi),
    ENUM(null),
    MESSAGE(null);

    private final Object zzlj;

    zzfq(Object obj) {
        this.zzlj = obj;
    }
}
