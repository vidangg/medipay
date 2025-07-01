package io.flutter.plugins.camera.types;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class Timeout {
    private final long timeStarted = SystemClock.elapsedRealtime();
    private final long timeoutMs;

    public static Timeout create(long j) {
        return new Timeout(j);
    }

    private Timeout(long j) {
        this.timeoutMs = j;
    }

    public boolean getIsExpired() {
        return SystemClock.elapsedRealtime() - this.timeStarted > this.timeoutMs;
    }
}
