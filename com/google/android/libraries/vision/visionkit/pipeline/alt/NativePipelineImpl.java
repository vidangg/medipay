package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq;
import com.google.android.libraries.vision.visionkit.pipeline.zbbx;
import com.google.android.libraries.vision.visionkit.pipeline.zbcb;
import com.google.android.libraries.vision.visionkit.pipeline.zbcc;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
class NativePipelineImpl implements zba {
    private zbtp zba;
    private zbbx zbb;
    private zbcc zbc;
    private zbcb zbd;

    public NativePipelineImpl(zbbx zbbxVar, zbcc zbccVar, zbcb zbcbVar, zbtp zbtpVar) {
        this.zbb = zbbxVar;
        this.zbc = zbccVar;
        this.zbd = zbcbVar;
        this.zba = zbtpVar;
    }

    public NativePipelineImpl(String str, zbbx zbbxVar, zbcc zbccVar, zbcb zbcbVar, zbtp zbtpVar) {
        this(zbbxVar, zbccVar, zbcbVar, zbtpVar);
        System.loadLibrary("mlkit_google_ocr_pipeline");
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native void close(long j, long j2, long j3, long j4, long j5);

    public void closeFileDescriptor(int i) {
        this.zbd.zbc(i);
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeFrameBufferReleaseCallback(long j);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeFrameManager();

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeIsolationCallback();

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeResultsCallback();

    public void onReleaseAtTimestampUs(long j) {
        this.zbb.zba(j);
    }

    public void onResult(byte[] bArr) {
        try {
            this.zbc.zbd(zbcz.zbd(bArr, this.zba));
        } catch (zbuq e) {
            zbcq.zba.zba(e, "Error in result from JNI layer", new Object[0]);
        }
    }

    public int openFileDescriptor(String str) {
        this.zbd.zbb(str);
        return -1;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native byte[] process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native void start(long j) throws PipelineException;

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native boolean stop(long j);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native void waitUntilIdle(long j) throws PipelineException;

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void zba() {
        this.zba = null;
        this.zbb = null;
        this.zbc = null;
        this.zbd = null;
    }
}
