package io.flutter.plugins.camera.media;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.camera.types.CameraCaptureProperties;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class ImageStreamReader {
    private final int dartImageFormat;
    private final ImageReader imageReader;
    private final ImageStreamReaderUtils imageStreamReaderUtils;

    public static int computeStreamImageFormat(int i) {
        if (i == 17) {
            return 35;
        }
        return i;
    }

    public ImageStreamReader(ImageReader imageReader, int i, ImageStreamReaderUtils imageStreamReaderUtils) {
        this.imageReader = imageReader;
        this.dartImageFormat = i;
        this.imageStreamReaderUtils = imageStreamReaderUtils;
    }

    public ImageStreamReader(int i, int i2, int i3, int i4) {
        this.dartImageFormat = i3;
        this.imageReader = ImageReader.newInstance(i, i2, computeStreamImageFormat(i3), i4);
        this.imageStreamReaderUtils = new ImageStreamReaderUtils();
    }

    public void onImageAvailable(Image image, CameraCaptureProperties cameraCaptureProperties, final EventChannel.EventSink eventSink) {
        try {
            final HashMap hashMap = new HashMap();
            if (this.dartImageFormat == 17) {
                hashMap.put("planes", parsePlanesForNv21(image));
            } else {
                hashMap.put("planes", parsePlanesForYuvOrJpeg(image));
            }
            hashMap.put("width", Integer.valueOf(image.getWidth()));
            hashMap.put("height", Integer.valueOf(image.getHeight()));
            hashMap.put("format", Integer.valueOf(this.dartImageFormat));
            hashMap.put("lensAperture", cameraCaptureProperties.getLastLensAperture());
            hashMap.put("sensorExposureTime", cameraCaptureProperties.getLastSensorExposureTime());
            hashMap.put("sensorSensitivity", cameraCaptureProperties.getLastSensorSensitivity() == null ? null : Double.valueOf(r6.intValue()));
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.plugins.camera.media.ImageStreamReader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EventChannel.EventSink.this.success(hashMap);
                }
            });
            image.close();
        } catch (IllegalStateException e) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.plugins.camera.media.ImageStreamReader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EventChannel.EventSink.this.error("IllegalStateException", "Caught IllegalStateException: " + e.getMessage(), null);
                }
            });
            image.close();
        }
    }

    public List<Map<String, Object>> parsePlanesForYuvOrJpeg(Image image) {
        ArrayList arrayList = new ArrayList();
        for (Image.Plane plane : image.getPlanes()) {
            ByteBuffer buffer = plane.getBuffer();
            int remaining = buffer.remaining();
            byte[] bArr = new byte[remaining];
            buffer.get(bArr, 0, remaining);
            HashMap hashMap = new HashMap();
            hashMap.put("bytesPerRow", Integer.valueOf(plane.getRowStride()));
            hashMap.put("bytesPerPixel", Integer.valueOf(plane.getPixelStride()));
            hashMap.put("bytes", bArr);
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public List<Map<String, Object>> parsePlanesForNv21(Image image) {
        ArrayList arrayList = new ArrayList();
        ByteBuffer yuv420ThreePlanesToNV21 = this.imageStreamReaderUtils.yuv420ThreePlanesToNV21(image.getPlanes(), image.getWidth(), image.getHeight());
        HashMap hashMap = new HashMap();
        hashMap.put("bytesPerRow", Integer.valueOf(image.getWidth()));
        hashMap.put("bytesPerPixel", 1);
        hashMap.put("bytes", yuv420ThreePlanesToNV21.array());
        arrayList.add(hashMap);
        return arrayList;
    }

    public Surface getSurface() {
        return this.imageReader.getSurface();
    }

    public void subscribeListener(final CameraCaptureProperties cameraCaptureProperties, final EventChannel.EventSink eventSink, Handler handler) {
        this.imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.plugins.camera.media.ImageStreamReader$$ExternalSyntheticLambda2
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader imageReader) {
                ImageStreamReader.this.m783x40dfbe7d(cameraCaptureProperties, eventSink, imageReader);
            }
        }, handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$subscribeListener$2$io-flutter-plugins-camera-media-ImageStreamReader, reason: not valid java name */
    public /* synthetic */ void m783x40dfbe7d(CameraCaptureProperties cameraCaptureProperties, EventChannel.EventSink eventSink, ImageReader imageReader) {
        Image acquireNextImage = imageReader.acquireNextImage();
        if (acquireNextImage == null) {
            return;
        }
        onImageAvailable(acquireNextImage, cameraCaptureProperties, eventSink);
    }

    public void removeListener(Handler handler) {
        this.imageReader.setOnImageAvailableListener(null, handler);
    }

    public void close() {
        this.imageReader.close();
    }
}
