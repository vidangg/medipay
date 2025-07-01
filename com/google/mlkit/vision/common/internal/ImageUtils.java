package com.google.mlkit.vision.common.internal;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes4.dex */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static final ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    public IObjectWrapper getImageDataWrapper(InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format != 17) {
                if (format == 35) {
                    return ObjectWrapper.wrap(inputImage.getMediaImage());
                }
                if (format != 842094169) {
                    throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
                }
            }
            return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
        }
        return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
    }

    public int getMobileVisionImageFormat(InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        }
        if (inputImage.getFormat() != 35) {
            return 0;
        }
        return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
    }

    public Matrix getUprightRotationMatrix(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3 A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7 A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c A[Catch: FileNotFoundException -> 0x00d0, TryCatch #0 {FileNotFoundException -> 0x00d0, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:9:0x0073, B:10:0x0088, B:13:0x00b9, B:15:0x00c3, B:20:0x008d, B:22:0x0091, B:23:0x0098, B:24:0x009c, B:25:0x00a3, B:26:0x00a7, B:27:0x00ae, B:35:0x006c, B:40:0x0056, B:56:0x00c8, B:57:0x00cf), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap zza(ContentResolver contentResolver, Uri uri) throws IOException {
        ExifInterface exifInterface;
        Matrix matrix;
        Bitmap createBitmap;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            if (bitmap != null) {
                int i = 0;
                if (FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) || "file".equals(uri.getScheme())) {
                    try {
                        InputStream openInputStream = contentResolver.openInputStream(uri);
                        if (openInputStream != null) {
                            try {
                                exifInterface = new ExifInterface(openInputStream);
                            } finally {
                                try {
                                    openInputStream.close();
                                } catch (Throwable e) {
                                    try {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, e);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        } else {
                            exifInterface = null;
                        }
                        if (openInputStream != null) {
                            try {
                            } catch (IOException e2) {
                                zza.e("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(String.valueOf(uri))), e);
                                if (exifInterface == null) {
                                }
                                Matrix matrix2 = new Matrix();
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                switch (i) {
                                }
                                return matrix == null ? bitmap : bitmap;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        exifInterface = null;
                    }
                    if (exifInterface == null) {
                        i = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                    }
                }
                Matrix matrix22 = new Matrix();
                int width2 = bitmap.getWidth();
                int height2 = bitmap.getHeight();
                switch (i) {
                    case 2:
                        matrix22 = new Matrix();
                        matrix22.postScale(-1.0f, 1.0f);
                        matrix = matrix22;
                        break;
                    case 3:
                        matrix22.postRotate(180.0f);
                        matrix = matrix22;
                        break;
                    case 4:
                        matrix22.postScale(1.0f, -1.0f);
                        matrix = matrix22;
                        break;
                    case 5:
                        matrix22.postRotate(90.0f);
                        matrix22.postScale(-1.0f, 1.0f);
                        matrix = matrix22;
                        break;
                    case 6:
                        matrix22.postRotate(90.0f);
                        matrix = matrix22;
                        break;
                    case 7:
                        matrix22.postRotate(-90.0f);
                        matrix22.postScale(-1.0f, 1.0f);
                        matrix = matrix22;
                        break;
                    case 8:
                        matrix22.postRotate(-90.0f);
                        matrix = matrix22;
                        break;
                    default:
                        matrix = null;
                        break;
                }
                if (matrix == null && bitmap != (createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width2, height2, matrix, true))) {
                    bitmap.recycle();
                    return createBitmap;
                }
            }
            throw new IOException("The image Uri could not be resolved.");
        } catch (FileNotFoundException e4) {
            zza.e("MLKitImageUtils", "Could not open file: ".concat(String.valueOf(String.valueOf(uri))), e4);
            throw e4;
        }
    }
}
