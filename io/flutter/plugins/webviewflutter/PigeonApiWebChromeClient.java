package io.flutter.plugins.webviewflutter;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000b\b&\u0018\u0000 62\u00020\u0001:\u00016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J+\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J;\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J+\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000JC\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00132\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000JC\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00132\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000JM\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u001a\u0010\r\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J3\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J;\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J;\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020(2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000JA\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u001e\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130,0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J\b\u0010-\u001a\u00020\nH&J+\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\b0\u000eø\u0001\u0000J\u0018\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001cH&J\u0018\u00102\u001a\u00020\b2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001cH&J\u0018\u00103\u001a\u00020\b2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001cH&J\u0018\u00104\u001a\u00020\b2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001cH&J\u0018\u00105\u001a\u00020\b2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u001cH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lio/flutter/plugins/webviewflutter/PigeonApiWebChromeClient;", "", "pigeonRegistrar", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "(Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;)V", "getPigeonRegistrar", "()Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "onConsoleMessage", "", "pigeon_instanceArg", "Lio/flutter/plugins/webviewflutter/WebChromeClientProxyApi$WebChromeClientImpl;", "messageArg", "Landroid/webkit/ConsoleMessage;", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "onGeolocationPermissionsHidePrompt", "onGeolocationPermissionsShowPrompt", "originArg", "", "callbackArg", "Landroid/webkit/GeolocationPermissions$Callback;", "onHideCustomView", "onJsAlert", "webViewArg", "Landroid/webkit/WebView;", "urlArg", "onJsConfirm", "", "onJsPrompt", "defaultValueArg", "onPermissionRequest", "requestArg", "Landroid/webkit/PermissionRequest;", "onProgressChanged", "progressArg", "", "onShowCustomView", "viewArg", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "onShowFileChooser", "paramsArg", "Landroid/webkit/WebChromeClient$FileChooserParams;", "", "pigeon_defaultConstructor", "pigeon_newInstance", "setSynchronousReturnValueForOnConsoleMessage", "pigeon_instance", "value", "setSynchronousReturnValueForOnJsAlert", "setSynchronousReturnValueForOnJsConfirm", "setSynchronousReturnValueForOnJsPrompt", "setSynchronousReturnValueForOnShowFileChooser", "Companion", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public abstract class PigeonApiWebChromeClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public abstract WebChromeClientProxyApi.WebChromeClientImpl pigeon_defaultConstructor();

    public abstract void setSynchronousReturnValueForOnConsoleMessage(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instance, boolean value);

    public abstract void setSynchronousReturnValueForOnJsAlert(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instance, boolean value);

    public abstract void setSynchronousReturnValueForOnJsConfirm(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instance, boolean value);

    public abstract void setSynchronousReturnValueForOnJsPrompt(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instance, boolean value);

    public abstract void setSynchronousReturnValueForOnShowFileChooser(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instance, boolean value);

    public PigeonApiWebChromeClient(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        Intrinsics.checkNotNullParameter(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    /* compiled from: AndroidWebkitLibrary.g.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lio/flutter/plugins/webviewflutter/PigeonApiWebChromeClient$Companion;", "", "()V", "setUpMessageHandlers", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "api", "Lio/flutter/plugins/webviewflutter/PigeonApiWebChromeClient;", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiWebChromeClient api) {
            AndroidWebkitLibraryPigeonCodec androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            if (api == null || (pigeonRegistrar = api.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.pigeon_defaultConstructor", androidWebkitLibraryPigeonCodec);
            if (api != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$Companion$$ExternalSyntheticLambda0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$1$lambda$0(PigeonApiWebChromeClient.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnShowFileChooser", androidWebkitLibraryPigeonCodec);
            if (api != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$Companion$$ExternalSyntheticLambda1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$3$lambda$2(PigeonApiWebChromeClient.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnConsoleMessage", androidWebkitLibraryPigeonCodec);
            if (api != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$Companion$$ExternalSyntheticLambda2
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$5$lambda$4(PigeonApiWebChromeClient.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsAlert", androidWebkitLibraryPigeonCodec);
            if (api != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$Companion$$ExternalSyntheticLambda3
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$7$lambda$6(PigeonApiWebChromeClient.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsConfirm", androidWebkitLibraryPigeonCodec);
            if (api != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$Companion$$ExternalSyntheticLambda4
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$9$lambda$8(PigeonApiWebChromeClient.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsPrompt", androidWebkitLibraryPigeonCodec);
            if (api != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$Companion$$ExternalSyntheticLambda5
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$11$lambda$10(PigeonApiWebChromeClient.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiWebChromeClient.getPigeonRegistrar().getInstanceManager().addDartCreatedInstance(pigeonApiWebChromeClient.pigeon_defaultConstructor(), ((Long) obj2).longValue());
                wrapError = CollectionsKt.listOf((Object) null);
            } catch (Throwable th) {
                wrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnShowFileChooser(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                wrapError = CollectionsKt.listOf((Object) null);
            } catch (Throwable th) {
                wrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$5$lambda$4(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnConsoleMessage(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                wrapError = CollectionsKt.listOf((Object) null);
            } catch (Throwable th) {
                wrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$7$lambda$6(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnJsAlert(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                wrapError = CollectionsKt.listOf((Object) null);
            } catch (Throwable th) {
                wrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$9$lambda$8(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnJsConfirm(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                wrapError = CollectionsKt.listOf((Object) null);
            } catch (Throwable th) {
                wrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$11$lambda$10(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnJsPrompt(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                wrapError = CollectionsKt.listOf((Object) null);
            } catch (Throwable th) {
                wrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }
    }

    public final void pigeon_newInstance(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(Unit.INSTANCE)));
        } else {
            Result.Companion companion3 = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("new-instance-error", "Attempting to create a new Dart instance of WebChromeClient, but the class has a nonnull callback method.", "")))));
        }
    }

    public final void onProgressChanged(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, long progressArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(webViewArg, "webViewArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, webViewArg, Long.valueOf(progressArg)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onProgressChanged$lambda$0(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onProgressChanged$lambda$0(Function1 callback, String channelName, Object obj) {
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

    public final void onShowFileChooser(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, WebChromeClient.FileChooserParams paramsArg, final Function1<? super Result<? extends List<String>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(webViewArg, "webViewArg");
        Intrinsics.checkNotNullParameter(paramsArg, "paramsArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, webViewArg, paramsArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda4
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onShowFileChooser$lambda$1(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShowFileChooser$lambda$1(Function1 callback, String channelName, Object obj) {
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
            if (list.get(0) == null) {
                Result.Companion companion2 = Result.INSTANCE;
                callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("null-error", "Flutter api returned null value for non-null return value.", "")))));
                return;
            } else {
                Object obj4 = list.get(0);
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                Result.Companion companion3 = Result.INSTANCE;
                callback.invoke(Result.m943boximpl(Result.m944constructorimpl((List) obj4)));
                return;
            }
        }
        Result.Companion companion4 = Result.INSTANCE;
        callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(channelName)))));
    }

    public final void onPermissionRequest(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, PermissionRequest requestArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(requestArg, "requestArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, requestArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda5
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onPermissionRequest$lambda$2(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPermissionRequest$lambda$2(Function1 callback, String channelName, Object obj) {
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

    public final void onShowCustomView(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, View viewArg, WebChromeClient.CustomViewCallback callbackArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(viewArg, "viewArg");
        Intrinsics.checkNotNullParameter(callbackArg, "callbackArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, viewArg, callbackArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda6
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onShowCustomView$lambda$3(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShowCustomView$lambda$3(Function1 callback, String channelName, Object obj) {
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

    public final void onHideCustomView(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onHideCustomView$lambda$4(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHideCustomView$lambda$4(Function1 callback, String channelName, Object obj) {
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

    public final void onGeolocationPermissionsShowPrompt(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, String originArg, GeolocationPermissions.Callback callbackArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(originArg, "originArg");
        Intrinsics.checkNotNullParameter(callbackArg, "callbackArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, originArg, callbackArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda8
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onGeolocationPermissionsShowPrompt$lambda$5(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGeolocationPermissionsShowPrompt$lambda$5(Function1 callback, String channelName, Object obj) {
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

    public final void onGeolocationPermissionsHidePrompt(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda10
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onGeolocationPermissionsHidePrompt$lambda$6(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGeolocationPermissionsHidePrompt$lambda$6(Function1 callback, String channelName, Object obj) {
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

    public final void onConsoleMessage(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, ConsoleMessage messageArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(messageArg, "messageArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, messageArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda7
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onConsoleMessage$lambda$7(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConsoleMessage$lambda$7(Function1 callback, String channelName, Object obj) {
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

    public final void onJsAlert(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, String urlArg, String messageArg, final Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(webViewArg, "webViewArg");
        Intrinsics.checkNotNullParameter(urlArg, "urlArg");
        Intrinsics.checkNotNullParameter(messageArg, "messageArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, webViewArg, urlArg, messageArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda3
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onJsAlert$lambda$8(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onJsAlert$lambda$8(Function1 callback, String channelName, Object obj) {
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

    public final void onJsConfirm(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, String urlArg, String messageArg, final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(webViewArg, "webViewArg");
        Intrinsics.checkNotNullParameter(urlArg, "urlArg");
        Intrinsics.checkNotNullParameter(messageArg, "messageArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, webViewArg, urlArg, messageArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda9
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onJsConfirm$lambda$9(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onJsConfirm$lambda$9(Function1 callback, String channelName, Object obj) {
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
            if (list.get(0) == null) {
                Result.Companion companion2 = Result.INSTANCE;
                callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("null-error", "Flutter api returned null value for non-null return value.", "")))));
                return;
            }
            Object obj4 = list.get(0);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) obj4;
            bool.booleanValue();
            Result.Companion companion3 = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(bool)));
            return;
        }
        Result.Companion companion4 = Result.INSTANCE;
        callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(channelName)))));
    }

    public final void onJsPrompt(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, String urlArg, String messageArg, String defaultValueArg, final Function1<? super Result<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(pigeon_instanceArg, "pigeon_instanceArg");
        Intrinsics.checkNotNullParameter(webViewArg, "webViewArg");
        Intrinsics.checkNotNullParameter(urlArg, "urlArg");
        Intrinsics.checkNotNullParameter(messageArg, "messageArg");
        Intrinsics.checkNotNullParameter(defaultValueArg, "defaultValueArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt", getPigeonRegistrar().getCodec()).send(CollectionsKt.listOf(pigeon_instanceArg, webViewArg, urlArg, messageArg, defaultValueArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient$$ExternalSyntheticLambda2
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onJsPrompt$lambda$10(Function1.this, str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onJsPrompt$lambda$10(Function1 callback, String channelName, Object obj) {
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
            String str = (String) list.get(0);
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m943boximpl(Result.m944constructorimpl(str)));
            return;
        }
        Result.Companion companion3 = Result.INSTANCE;
        callback.invoke(Result.m943boximpl(Result.m944constructorimpl(ResultKt.createFailure(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(channelName)))));
    }
}
