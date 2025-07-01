package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
class Bitmap2JpegBytes implements Operation<In, Packet<byte[]>> {
    @Override // androidx.camera.core.processing.Operation
    public Packet<byte[]> apply(In in) throws ImageCaptureException {
        Packet<Bitmap> packet = in.getPacket();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        packet.getData().compress(Bitmap.CompressFormat.JPEG, in.getJpegQuality(), byteArrayOutputStream);
        return Packet.of(byteArrayOutputStream.toByteArray(), (Exif) Objects.requireNonNull(packet.getExif()), 256, packet.getSize(), packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getJpegQuality();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Packet<Bitmap> getPacket();

        /* JADX INFO: Access modifiers changed from: package-private */
        public static In of(Packet<Bitmap> packet, int i) {
            return new AutoValue_Bitmap2JpegBytes_In(packet, i);
        }
    }
}
