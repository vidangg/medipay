package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import com.google.android.libraries.vision.visionkit.pipeline.zbbx;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbb implements zba {
    public zbb(zbbx zbbxVar) {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void close(long j, long j2, long j3, long j4, long j5) {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5) {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeFrameBufferReleaseCallback(long j) {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeFrameManager() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeIsolationCallback() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeResultsCallback() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final byte[] process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4) {
        return zbcz.zbc().zbl();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4) {
        return zbcz.zbc().zbl();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6) {
        return zbcz.zbc().zbl();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void start(long j) throws PipelineException {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final boolean stop(long j) {
        return true;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void waitUntilIdle(long j) throws PipelineException {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void zba() {
    }
}
