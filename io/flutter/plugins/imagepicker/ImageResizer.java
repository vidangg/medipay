package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.core.util.SizeFCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
class ImageResizer {
    private final Context context;
    private final ExifDataCopier exifDataCopier;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageResizer(Context context, ExifDataCopier exifDataCopier) {
        this.context = context;
        this.exifDataCopier = exifDataCopier;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String resizeImageIfNeeded(String str, Double d, Double d2, int i) {
        SizeFCompat readFileDimensions = readFileDimensions(str);
        if (readFileDimensions.getWidth() == -1.0f || readFileDimensions.getHeight() == -1.0f) {
            return str;
        }
        if (d == null && d2 == null && i >= 100) {
            return str;
        }
        try {
            String str2 = str.split("/")[r2.length - 1];
            SizeFCompat calculateTargetSize = calculateTargetSize(readFileDimensions.getWidth(), readFileDimensions.getHeight(), d, d2);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = calculateSampleSize(options, (int) calculateTargetSize.getWidth(), (int) calculateTargetSize.getHeight());
            Bitmap decodeFile = decodeFile(str, options);
            if (decodeFile == null) {
                return str;
            }
            File resizedImage = resizedImage(decodeFile, Double.valueOf(calculateTargetSize.getWidth()), Double.valueOf(calculateTargetSize.getHeight()), i, str2);
            copyExif(str, resizedImage.getPath());
            return resizedImage.getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File resizedImage(Bitmap bitmap, Double d, Double d2, int i, String str) throws IOException {
        return createImageOnExternalDirectory("/scaled_" + str, createScaledBitmap(bitmap, d.intValue(), d2.intValue(), false), i);
    }

    private SizeFCompat calculateTargetSize(double d, double d2, Double d3, Double d4) {
        double d5 = d / d2;
        boolean z = d3 != null;
        boolean z2 = d4 != null;
        double min = z ? Math.min(d, Math.round(d3.doubleValue())) : d;
        double min2 = z2 ? Math.min(d2, Math.round(d4.doubleValue())) : d2;
        boolean z3 = z && d3.doubleValue() < d;
        boolean z4 = z2 && d4.doubleValue() < d2;
        if (z3 || z4) {
            double d6 = min2 * d5;
            double d7 = min / d5;
            if (d7 > min2) {
                min = Math.round(d6);
            } else {
                min2 = Math.round(d7);
            }
        }
        return new SizeFCompat((float) min, (float) min2);
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private FileOutputStream createOutputStream(File file) throws IOException {
        return new FileOutputStream(file);
    }

    private void copyExif(String str, String str2) {
        try {
            this.exifDataCopier.copyExif(new ExifInterface(str), new ExifInterface(str2));
        } catch (Exception e) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e);
        }
    }

    SizeFCompat readFileDimensions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(str, options);
        return new SizeFCompat(options.outWidth, options.outHeight);
    }

    private Bitmap decodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }

    private int calculateSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(hasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        File createFile = createFile(this.context.getCacheDir(), str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }
}
