package io.flutter.plugins.webviewflutter;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tekartik.sqflite.Constant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001¨\u0006\r"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonUtils;", "", "()V", "createConnectionError", "Lio/flutter/plugins/webviewflutter/AndroidWebKitError;", "channelName", "", "wrapError", "", "exception", "", "wrapResult", Constant.PARAM_RESULT, "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidWebkitLibraryPigeonUtils {
    public static final AndroidWebkitLibraryPigeonUtils INSTANCE = new AndroidWebkitLibraryPigeonUtils();

    private AndroidWebkitLibraryPigeonUtils() {
    }

    public final AndroidWebKitError createConnectionError(String channelName) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        return new AndroidWebKitError("channel-error", "Unable to establish connection on channel: '" + channelName + "'.", "");
    }

    public final List<Object> wrapResult(Object result) {
        return CollectionsKt.listOf(result);
    }

    public final List<Object> wrapError(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof AndroidWebKitError) {
            AndroidWebKitError androidWebKitError = (AndroidWebKitError) exception;
            return CollectionsKt.listOf(androidWebKitError.getCode(), exception.getMessage(), androidWebKitError.getDetails());
        }
        return CollectionsKt.listOf((Object[]) new String[]{exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception)});
    }
}
