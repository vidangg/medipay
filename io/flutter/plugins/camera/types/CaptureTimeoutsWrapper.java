package io.flutter.plugins.camera.types;

/* loaded from: classes4.dex */
public class CaptureTimeoutsWrapper {
    private Timeout preCaptureFocusing;
    private final long preCaptureFocusingTimeoutMs;
    private Timeout preCaptureMetering;
    private final long preCaptureMeteringTimeoutMs;

    public CaptureTimeoutsWrapper(long j, long j2) {
        this.preCaptureFocusingTimeoutMs = j;
        this.preCaptureMeteringTimeoutMs = j2;
        this.preCaptureFocusing = Timeout.create(j);
        this.preCaptureMetering = Timeout.create(j2);
    }

    public void reset() {
        this.preCaptureFocusing = Timeout.create(this.preCaptureFocusingTimeoutMs);
        this.preCaptureMetering = Timeout.create(this.preCaptureMeteringTimeoutMs);
    }

    public Timeout getPreCaptureFocusing() {
        return this.preCaptureFocusing;
    }

    public Timeout getPreCaptureMetering() {
        return this.preCaptureMetering;
    }
}
