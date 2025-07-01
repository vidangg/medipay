package io.flutter.plugins.camera.media;

import android.media.Image;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class ImageStreamReaderUtils {
    public ByteBuffer yuv420ThreePlanesToNV21(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[((i3 / 4) * 2) + i3];
        if (areUVPlanesNV21(planeArr, i, i2)) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer.get(bArr, i3 + 1, ((i3 * 2) / 4) - 1);
        } else {
            unpackPlane(planeArr[0], i, i2, bArr, 0, 1);
            unpackPlane(planeArr[1], i, i2, bArr, i3 + 1, 2);
            unpackPlane(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    private static boolean areUVPlanesNV21(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        boolean z = buffer2.remaining() == ((i3 * 2) / 4) - 2 && buffer2.compareTo(buffer) == 0;
        buffer2.position(position);
        buffer.limit(limit);
        return z;
    }

    private static void unpackPlane(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) throws IllegalStateException {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int limit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (limit == 0) {
            return;
        }
        int i5 = i / (i2 / limit);
        int i6 = 0;
        for (int i7 = 0; i7 < limit; i7++) {
            int i8 = i6;
            for (int i9 = 0; i9 < i5; i9++) {
                bArr[i3] = buffer.get(i8);
                i3 += i4;
                i8 += plane.getPixelStride();
            }
            i6 += plane.getRowStride();
        }
    }
}
