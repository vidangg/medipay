package com.google.android.libraries.vision.visionkit.pipeline.alt;

import androidx.core.os.EnvironmentCompat;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public enum zbd {
    OK("ok"),
    CANCELLED("canceled"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    INVALID_ARGUMENT("invalid argument"),
    DEADLINE_EXCEEDED("deadline exceeded"),
    NOT_FOUND("not found"),
    ALREADY_EXISTS("already exists"),
    PERMISSION_DENIED("permission denied"),
    RESOURCE_EXHAUSTED("resource exhausted"),
    FAILED_PRECONDITION("failed precondition"),
    ABORTED("aborted"),
    OUT_OF_RANGE("out of range"),
    UNIMPLEMENTED("unimplemented"),
    INTERNAL("internal"),
    UNAVAILABLE("unavailable"),
    DATA_LOSS("data loss"),
    UNAUTHENTICATED("unauthenticated");

    private final String zbs;

    zbd(String str) {
        this.zbs = str;
    }

    public final String zba() {
        return this.zbs;
    }
}
