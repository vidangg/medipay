package androidx.camera.core.impl.utils;

import androidx.media3.exoplayer.Renderer;

/* loaded from: classes.dex */
final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongRational(long j, long j2) {
        this.mNumerator = j;
        this.mDenominator = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongRational(double d) {
        this((long) (d * 10000.0d), Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNumerator() {
        return this.mNumerator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getDenominator() {
        return this.mDenominator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }
}
