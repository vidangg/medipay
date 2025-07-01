package com.example.image_gallery_saver_plus;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ImageGallerySaverPlusPlugin.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u000f2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0016J<\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001a`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002JK\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001a`\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/example/image_gallery_saver_plus/ImageGallerySaverPlusPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "applicationContext", "Landroid/content/Context;", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "generateUri", "Landroid/net/Uri;", "extension", "", "name", "getMIMEType", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onMethodCall", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "Lio/flutter/plugin/common/MethodChannel$Result;", "saveFileToGallery", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "filePath", "saveImageToGallery", "bmp", "Landroid/graphics/Bitmap;", "quality", "", "(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/HashMap;", "sendBroadcast", "context", "fileUri", "SaveResultModel", "image_gallery_saver_plus_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class ImageGallerySaverPlusPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private Context applicationContext;
    private MethodChannel methodChannel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.applicationContext = binding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(binding.getBinaryMessenger(), "image_gallery_saver_plus");
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (Intrinsics.areEqual(str, "saveImageToGallery")) {
            byte[] bArr = (byte[]) call.argument("imageBytes");
            result.success(saveImageToGallery(BitmapFactory.decodeByteArray(bArr == null ? new byte[0] : bArr, 0, bArr != null ? bArr.length : 0), (Integer) call.argument("quality"), (String) call.argument("name")));
        } else if (Intrinsics.areEqual(str, "saveFileToGallery")) {
            result.success(saveFileToGallery((String) call.argument("file"), (String) call.argument("name")));
        } else {
            result.notImplemented();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.applicationContext = null;
        MethodChannel methodChannel = this.methodChannel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }

    static /* synthetic */ Uri generateUri$default(ImageGallerySaverPlusPlugin imageGallerySaverPlusPlugin, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return imageGallerySaverPlusPlugin.generateUri(str, str2);
    }

    private final Uri generateUri(String extension, String name) {
        String str;
        Uri uri;
        String str2;
        ContentResolver contentResolver;
        if (name == null) {
            name = String.valueOf(System.currentTimeMillis());
        }
        String mIMEType = getMIMEType(extension);
        boolean z = false;
        if (mIMEType != null && StringsKt.startsWith$default(mIMEType, "video", false, 2, (Object) null)) {
            z = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (z) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", name);
            if (z) {
                str2 = Environment.DIRECTORY_MOVIES;
            } else {
                str2 = Environment.DIRECTORY_PICTURES;
            }
            contentValues.put("relative_path", str2);
            if (!TextUtils.isEmpty(mIMEType)) {
                contentValues.put("mime_type", mIMEType);
            }
            Context context = this.applicationContext;
            if (context == null || (contentResolver = context.getContentResolver()) == null) {
                return null;
            }
            return contentResolver.insert(uri, contentValues);
        }
        if (z) {
            str = Environment.DIRECTORY_MOVIES;
        } else {
            str = Environment.DIRECTORY_PICTURES;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(str).getAbsolutePath());
        if (!file.exists()) {
            file.mkdir();
        }
        if (extension.length() > 0) {
            name = ((Object) name) + "." + extension;
        }
        return Uri.fromFile(new File(file, name));
    }

    private final String getMIMEType(String extension) {
        if (TextUtils.isEmpty(extension)) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }

    private final void sendBroadcast(Context context, Uri fileUri) {
        String path;
        if (fileUri == null || (path = fileUri.getPath()) == null) {
            return;
        }
        MediaScannerConnection.scanFile(context, new String[]{path}, null, null);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00a5: MOVE (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:43:0x00a5 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final HashMap<String, Object> saveImageToGallery(Bitmap bmp, Integer quality, String name) {
        Uri uri;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        OutputStream outputStream3 = null;
        if (bmp == null || quality == null) {
            return new SaveResultModel(false, null, "parameters error").toHashMap();
        }
        Context context = this.applicationContext;
        if (context == null) {
            return new SaveResultModel(false, null, "applicationContext null").toHashMap();
        }
        try {
            try {
                try {
                    uri = generateUri("jpg", name);
                    if (uri != null) {
                        try {
                            outputStream = context.getContentResolver().openOutputStream(uri);
                            if (outputStream != null) {
                                try {
                                    System.out.println((Object) ("ImageGallerySaverPlugin " + quality));
                                    bmp.compress(Bitmap.CompressFormat.JPEG, quality.intValue(), outputStream);
                                    outputStream.flush();
                                    z = true;
                                } catch (IOException e) {
                                    e = e;
                                    new SaveResultModel(false, null, e.toString()).toHashMap();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    bmp.recycle();
                                    z = false;
                                    if (!z) {
                                    }
                                }
                            } else {
                                z = false;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            outputStream = null;
                        }
                    } else {
                        z = false;
                        outputStream = null;
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    bmp.recycle();
                } catch (Throwable th) {
                    th = th;
                    outputStream3 = outputStream2;
                    if (outputStream3 != null) {
                        outputStream3.close();
                    }
                    bmp.recycle();
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                uri = null;
                outputStream = null;
            }
            if (!z) {
                sendBroadcast(context, uri);
                return new SaveResultModel(String.valueOf(uri).length() > 0, String.valueOf(uri), null).toHashMap();
            }
            return new SaveResultModel(false, null, "saveImageToGallery fail").toHashMap();
        } catch (Throwable th2) {
            th = th2;
            if (outputStream3 != null) {
            }
            bmp.recycle();
            throw th;
        }
    }

    private final HashMap<String, Object> saveFileToGallery(String filePath, String name) {
        if (filePath == null) {
            return new SaveResultModel(false, null, "parameters error").toHashMap();
        }
        Context context = this.applicationContext;
        if (context == null) {
            return new SaveResultModel(false, null, "applicationContext null").toHashMap();
        }
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return new SaveResultModel(false, null, filePath + " does not exist").toHashMap();
            }
            Uri generateUri = generateUri(FilesKt.getExtension(file), name);
            if (generateUri == null) {
                return new SaveResultModel(false, null, "Failed to generate URI").toHashMap();
            }
            OutputStream openOutputStream = context.getContentResolver().openOutputStream(generateUri);
            if (openOutputStream != null) {
                FileInputStream fileInputStream = openOutputStream;
                try {
                    OutputStream outputStream = fileInputStream;
                    fileInputStream = new FileInputStream(file);
                    try {
                        if (ByteStreamsKt.copyTo$default(fileInputStream, outputStream, 0, 2, null) < 1) {
                            throw new IOException("No bytes copied. File might be empty.");
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, null);
                        sendBroadcast(context, generateUri);
                        return new SaveResultModel(true, generateUri.toString(), null).toHashMap();
                    } finally {
                    }
                } finally {
                }
            } else {
                return new SaveResultModel(false, null, "saveFileToGallery failed").toHashMap();
            }
        } catch (IOException e) {
            return new SaveResultModel(false, null, e.toString()).toHashMap();
        }
    }

    /* compiled from: ImageGallerySaverPlusPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/example/image_gallery_saver_plus/ImageGallerySaverPlusPlugin$SaveResultModel;", "", "isSuccess", "", "filePath", "", "errorMessage", "(ZLjava/lang/String;Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "()Z", "setSuccess", "(Z)V", "toHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "image_gallery_saver_plus_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class SaveResultModel {
        private String errorMessage;
        private String filePath;
        private boolean isSuccess;

        public SaveResultModel(boolean z, String str, String str2) {
            this.isSuccess = z;
            this.filePath = str;
            this.errorMessage = str2;
        }

        public /* synthetic */ SaveResultModel(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }

        /* renamed from: isSuccess, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public final void setSuccess(boolean z) {
            this.isSuccess = z;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final void setFilePath(String str) {
            this.filePath = str;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public final HashMap<String, Object> toHashMap() {
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap<String, Object> hashMap2 = hashMap;
            hashMap2.put("isSuccess", Boolean.valueOf(this.isSuccess));
            hashMap2.put("filePath", this.filePath);
            hashMap2.put("errorMessage", this.errorMessage);
            return hashMap;
        }
    }
}
