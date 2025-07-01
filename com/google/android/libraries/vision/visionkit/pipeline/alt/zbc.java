package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq;
import com.google.android.libraries.vision.visionkit.pipeline.zbbe;
import com.google.android.libraries.vision.visionkit.pipeline.zbbf;
import com.google.android.libraries.vision.visionkit.pipeline.zbbx;
import com.google.android.libraries.vision.visionkit.pipeline.zbca;
import com.google.android.libraries.vision.visionkit.pipeline.zbcb;
import com.google.android.libraries.vision.visionkit.pipeline.zbcc;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public class zbc implements zbbx, zbcc, zbcb {
    protected final zbtp zba;
    private final zbbf zbb;
    private final zba zbc;
    private long zbd;
    private final long zbe;
    private final long zbf;
    private final long zbg;
    private final long zbh;

    public zbc(zbca zbcaVar, String str) {
        zbtp zbb = zbtp.zbb();
        zbtp zba = zbb == null ? zbtp.zba() : zbb;
        if (zbcaVar.zbh()) {
            this.zbc = new zbb(this);
        } else if (zbcaVar.zbg()) {
            this.zbc = new NativePipelineImpl(this, this, this, zba);
        } else {
            this.zbc = new NativePipelineImpl("mlkit_google_ocr_pipeline", this, this, this, zba);
        }
        if (zbcaVar.zbi()) {
            this.zbb = new zbbf(zbcaVar.zba());
        } else {
            this.zbb = new zbbf(10);
        }
        this.zba = zba;
        long initializeFrameManager = this.zbc.initializeFrameManager();
        this.zbe = initializeFrameManager;
        long initializeFrameBufferReleaseCallback = this.zbc.initializeFrameBufferReleaseCallback(initializeFrameManager);
        this.zbf = initializeFrameBufferReleaseCallback;
        long initializeResultsCallback = this.zbc.initializeResultsCallback();
        this.zbg = initializeResultsCallback;
        long initializeIsolationCallback = this.zbc.initializeIsolationCallback();
        this.zbh = initializeIsolationCallback;
        this.zbd = this.zbc.initialize(zbcaVar.zbl(), initializeFrameBufferReleaseCallback, initializeResultsCallback, initializeIsolationCallback, 0L, 0L);
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbbx
    public final void zba(long j) {
        this.zbb.zba(j);
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbcb
    public final int zbb(String str) {
        Log.w("VKP", "openFileDescriptor called but is not available for this pipeline. Ignoring call.");
        return -1;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbcb
    public final void zbc(int i) {
        Log.w("VKP", "closeFileDescriptor called but is not available for this pipeline. Ignoring call.");
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbcc
    public final void zbd(zbcz zbczVar) {
        zbcq.zba.zbb(this, "Pipeline received results: ".concat(String.valueOf(String.valueOf(zbczVar))), new Object[0]);
    }

    public final zbki zbe(zbbe zbbeVar) {
        byte[] process;
        if (this.zbd == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!this.zbb.zbb(zbbeVar, zbbeVar.zba()) || (process = this.zbc.process(this.zbd, this.zbe, zbbeVar.zba(), zbbeVar.zbc(), zbbeVar.zbb().zbb(), zbbeVar.zbb().zba(), zbbeVar.zbd() - 1, zbbeVar.zbe() - 1)) == null) {
            return zbki.zbd();
        }
        try {
            return zbki.zbe(zbcz.zbd(process, this.zba));
        } catch (zbuq e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    public final synchronized void zbf() {
        long j = this.zbd;
        if (j != 0) {
            this.zbc.stop(j);
            this.zbc.close(this.zbd, this.zbe, this.zbf, this.zbg, this.zbh);
            this.zbd = 0L;
            this.zbc.zba();
        }
    }

    public final void zbg() throws PipelineException {
        long j = this.zbd;
        if (j == 0) {
            throw new PipelineException(zbd.FAILED_PRECONDITION.ordinal(), "Pipeline has been closed or was not initialized");
        }
        try {
            this.zbc.start(j);
            this.zbc.waitUntilIdle(this.zbd);
        } catch (PipelineException e) {
            this.zbc.stop(this.zbd);
            throw e;
        }
    }

    public final void zbh() {
        long j = this.zbd;
        if (j == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!this.zbc.stop(j)) {
            throw new IllegalStateException("Pipeline did not stop successfully.");
        }
    }

    public final zbki zbi(long j, Bitmap bitmap, int i) {
        if (this.zbd == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Unsupported bitmap config ".concat(String.valueOf(String.valueOf(bitmap.getConfig()))));
        }
        byte[] processBitmap = this.zbc.processBitmap(this.zbd, j, bitmap, bitmap.getWidth(), bitmap.getHeight(), 0, i - 1);
        if (processBitmap == null) {
            return zbki.zbd();
        }
        try {
            return zbki.zbe(zbcz.zbd(processBitmap, this.zba));
        } catch (zbuq e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    public final zbki zbj(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.zbd == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!byteBuffer.isDirect() || !byteBuffer2.isDirect() || !byteBuffer3.isDirect()) {
            throw new IllegalStateException("Byte buffers are not direct.");
        }
        byte[] processYuvFrame = this.zbc.processYuvFrame(this.zbd, j, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6 - 1);
        if (processYuvFrame == null) {
            return zbki.zbd();
        }
        try {
            return zbki.zbe(zbcz.zbd(processYuvFrame, this.zba));
        } catch (zbuq e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }
}
