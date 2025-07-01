package vn.ai.faceauth.sdk.presentation.presentation.widgets;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public interface VisionImageProcessor {
    void addProcessSuccees(FaceImageProcessor faceImageProcessor);

    void processBitmap(Bitmap bitmap);

    void processByteBuffer(ByteBuffer byteBuffer, FrameMetadata frameMetadata);

    void stop();
}
