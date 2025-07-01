package io.flutter.plugins.camera;

import android.media.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class ImageSaver implements Runnable {
    private final Callback callback;
    private final File file;
    private final Image image;

    /* loaded from: classes4.dex */
    public interface Callback {
        void onComplete(String str);

        void onError(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageSaver(Image image, File file, Callback callback) {
        this.image = image;
        this.file = file;
        this.callback = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        ByteBuffer buffer = this.image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = FileOutputStreamFactory.create(this.file);
                    fileOutputStream.write(bArr);
                    this.callback.onComplete(this.file.getAbsolutePath());
                    this.image.close();
                } catch (IOException unused) {
                    this.callback.onError("IOError", "Failed saving image");
                    this.image.close();
                    if (fileOutputStream == null) {
                        return;
                    } else {
                        fileOutputStream.close();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th) {
                this.image.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        this.callback.onError("cameraAccess", e.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            this.callback.onError("cameraAccess", e2.getMessage());
        }
    }

    /* loaded from: classes4.dex */
    static class FileOutputStreamFactory {
        FileOutputStreamFactory() {
        }

        public static FileOutputStream create(File file) throws FileNotFoundException {
            return new FileOutputStream(file);
        }
    }
}
