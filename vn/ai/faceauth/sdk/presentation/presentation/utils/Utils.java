package vn.ai.faceauth.sdk.presentation.presentation.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Base64;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.mlkit.common.MlKitException;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import paua.btj;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/utils/Utils;", "", "()V", "Companion", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Utils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/utils/Utils$Companion;", "", "()V", "deviceModel", "", "getDeviceModel", "()Ljava/lang/String;", "bitmapToBase64", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "capitalize", "str", "getOutputDirectory", "Ljava/io/File;", "initFileImage", "saveBitmapToFile", "rootBitmap", "file", "saveFileJPEGToInternal", "setMetaDataToFile", "", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String capitalize(String str) {
            if (str.length() > 0) {
                char first = StringsKt.first(str);
                if (Character.isLowerCase(first)) {
                    Character.toUpperCase(first);
                }
            }
            return str;
        }

        private final String getDeviceModel() {
            String str = Build.MODEL;
            String lowerCase = str.toLowerCase();
            String str2 = Build.MANUFACTURER;
            if (!StringsKt.startsWith$default(lowerCase, str2.toLowerCase(), false, 2, (Object) null)) {
                str = str2 + ' ' + str;
            }
            return capitalize(str);
        }

        private final File getOutputDirectory(Context context) {
            File file;
            Context applicationContext = context.getApplicationContext();
            File cacheDir = context.getCacheDir();
            if (cacheDir != null) {
                file = new File(cacheDir, btj.tzend(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR));
                file.mkdirs();
            } else {
                file = null;
            }
            return (file == null || !file.exists()) ? applicationContext.getFilesDir() : file;
        }

        private final File initFileImage(Context context) {
            return new File(getOutputDirectory(context), btj.tzend(MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD) + System.currentTimeMillis() + btj.tzend(208));
        }

        private final File saveBitmapToFile(Bitmap rootBitmap, File file) {
            try {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                rootBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return file;
        }

        private final File saveFileJPEGToInternal(Context context, Bitmap rootBitmap) {
            File saveBitmapToFile = saveBitmapToFile(rootBitmap, initFileImage(context));
            setMetaDataToFile(saveBitmapToFile);
            return saveBitmapToFile;
        }

        private final void setMetaDataToFile(File file) {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            exifInterface.setAttribute(btj.tzend(209), btj.tzend(210));
            exifInterface.setAttribute(btj.tzend(211), Build.MANUFACTURER);
            exifInterface.setAttribute(btj.tzend(212), getDeviceModel());
            exifInterface.setAttribute(btj.tzend(215), btj.tzend(213) + Build.VERSION.SDK_INT + btj.tzend(214));
            exifInterface.setAttribute(btj.tzend(216), String.valueOf(System.currentTimeMillis()));
            exifInterface.saveAttributes();
        }

        public final String bitmapToBase64(Context context, Bitmap bitmap) {
            File saveFileJPEGToInternal = saveFileJPEGToInternal(context, bitmap);
            String encodeToString = Base64.encodeToString(FilesKt.readBytes(saveFileJPEGToInternal), 2);
            saveFileJPEGToInternal.exists();
            saveFileJPEGToInternal.delete();
            return encodeToString;
        }
    }
}
