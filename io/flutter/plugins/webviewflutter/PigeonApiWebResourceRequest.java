package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceRequest;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ImagesContract;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0017\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH&J+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0015\u0012\u0004\u0012\u00020\u00110\u0014ø\u0001\u0000J\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lio/flutter/plugins/webviewflutter/PigeonApiWebResourceRequest;", "", "pigeonRegistrar", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "(Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;)V", "getPigeonRegistrar", "()Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "hasGesture", "", "pigeon_instance", "Landroid/webkit/WebResourceRequest;", "isForMainFrame", "isRedirect", "(Landroid/webkit/WebResourceRequest;)Ljava/lang/Boolean;", "method", "", "pigeon_newInstance", "", "pigeon_instanceArg", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "requestHeaders", "", ImagesContract.URL, "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public abstract class PigeonApiWebResourceRequest {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public abstract boolean hasGesture(WebResourceRequest pigeon_instance);

    public abstract boolean isForMainFrame(WebResourceRequest pigeon_instance);

    public abstract Boolean isRedirect(WebResourceRequest pigeon_instance);

    public abstract String method(WebResourceRequest pigeon_instance);

    public abstract Map<String, String> requestHeaders(WebResourceRequest pigeon_instance);

    public abstract String url(WebResourceRequest pigeon_instance);

    public PigeonApiWebResourceRequest(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        Intrinsics.checkNotNullParameter(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public final void pigeon_newInstance(WebResourceRequest pigeon_instanceArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
            return;
        }
        if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(Unit.INSTANCE)));
            return;
        }
        long addHostCreatedInstance = getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg);
        String url = url(pigeon_instanceArg);
        boolean isForMainFrame = isForMainFrame(pigeon_instanceArg);
        Boolean isRedirect = isRedirect(pigeon_instanceArg);
        boolean hasGesture = hasGesture(pigeon_instanceArg);
        final String str = "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance";
        new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(Long.valueOf(addHostCreatedInstance), url, Boolean.valueOf(isForMainFrame), isRedirect, Boolean.valueOf(hasGesture), method(pigeon_instanceArg), requestHeaders(pigeon_instanceArg)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest$$ExternalSyntheticLambda0
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                PigeonApiWebResourceRequest.pigeon_newInstance$lambda$0(Function1.this, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pigeon_newInstance$lambda$0(Function1 callback, String channelName, Object obj) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(channelName, "$channelName");
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() > 1) {
                Result.Companion companion = Result.INSTANCE;
                Object obj2 = list.get(0);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = list.get(1);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2))))));
                return;
            }
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(Unit.INSTANCE)));
            return;
        }
        Result.Companion companion3 = Result.INSTANCE;
        callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(channelName)))));
    }
}
