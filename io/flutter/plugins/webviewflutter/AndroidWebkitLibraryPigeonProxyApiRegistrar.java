package io.flutter.plugins.webviewflutter;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonInstanceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020)H&J\b\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020-H&J\b\u0010.\u001a\u00020/H&J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000203H&J\b\u00104\u001a\u000205H&J\b\u00106\u001a\u000207H&J\b\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020;H&J\b\u0010<\u001a\u00020=H&J\b\u0010>\u001a\u00020?H&J\b\u0010@\u001a\u00020AH&J\b\u0010B\u001a\u00020CH&J\b\u0010D\u001a\u00020EH&J\b\u0010F\u001a\u00020GH&J\b\u0010H\u001a\u00020IH&J\b\u0010J\u001a\u00020KH&J\b\u0010L\u001a\u00020MH&J\b\u0010N\u001a\u00020OH&J\b\u0010P\u001a\u00020QH\u0016J\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020SR\u0018\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006U"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "_codec", "Lio/flutter/plugin/common/MessageCodec;", "getBinaryMessenger", "()Lio/flutter/plugin/common/BinaryMessenger;", "codec", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "ignoreCallsToDart", "", "getIgnoreCallsToDart", "()Z", "setIgnoreCallsToDart", "(Z)V", "instanceManager", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager;", "getInstanceManager", "()Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager;", "getPigeonApiAndroidMessage", "Lio/flutter/plugins/webviewflutter/PigeonApiAndroidMessage;", "getPigeonApiCertificate", "Lio/flutter/plugins/webviewflutter/PigeonApiCertificate;", "getPigeonApiClientCertRequest", "Lio/flutter/plugins/webviewflutter/PigeonApiClientCertRequest;", "getPigeonApiConsoleMessage", "Lio/flutter/plugins/webviewflutter/PigeonApiConsoleMessage;", "getPigeonApiCookieManager", "Lio/flutter/plugins/webviewflutter/PigeonApiCookieManager;", "getPigeonApiCustomViewCallback", "Lio/flutter/plugins/webviewflutter/PigeonApiCustomViewCallback;", "getPigeonApiDownloadListener", "Lio/flutter/plugins/webviewflutter/PigeonApiDownloadListener;", "getPigeonApiFileChooserParams", "Lio/flutter/plugins/webviewflutter/PigeonApiFileChooserParams;", "getPigeonApiFlutterAssetManager", "Lio/flutter/plugins/webviewflutter/PigeonApiFlutterAssetManager;", "getPigeonApiGeolocationPermissionsCallback", "Lio/flutter/plugins/webviewflutter/PigeonApiGeolocationPermissionsCallback;", "getPigeonApiHttpAuthHandler", "Lio/flutter/plugins/webviewflutter/PigeonApiHttpAuthHandler;", "getPigeonApiJavaScriptChannel", "Lio/flutter/plugins/webviewflutter/PigeonApiJavaScriptChannel;", "getPigeonApiPermissionRequest", "Lio/flutter/plugins/webviewflutter/PigeonApiPermissionRequest;", "getPigeonApiPrivateKey", "Lio/flutter/plugins/webviewflutter/PigeonApiPrivateKey;", "getPigeonApiSslCertificate", "Lio/flutter/plugins/webviewflutter/PigeonApiSslCertificate;", "getPigeonApiSslCertificateDName", "Lio/flutter/plugins/webviewflutter/PigeonApiSslCertificateDName;", "getPigeonApiSslError", "Lio/flutter/plugins/webviewflutter/PigeonApiSslError;", "getPigeonApiSslErrorHandler", "Lio/flutter/plugins/webviewflutter/PigeonApiSslErrorHandler;", "getPigeonApiView", "Lio/flutter/plugins/webviewflutter/PigeonApiView;", "getPigeonApiWebChromeClient", "Lio/flutter/plugins/webviewflutter/PigeonApiWebChromeClient;", "getPigeonApiWebResourceError", "Lio/flutter/plugins/webviewflutter/PigeonApiWebResourceError;", "getPigeonApiWebResourceErrorCompat", "Lio/flutter/plugins/webviewflutter/PigeonApiWebResourceErrorCompat;", "getPigeonApiWebResourceRequest", "Lio/flutter/plugins/webviewflutter/PigeonApiWebResourceRequest;", "getPigeonApiWebResourceResponse", "Lio/flutter/plugins/webviewflutter/PigeonApiWebResourceResponse;", "getPigeonApiWebSettings", "Lio/flutter/plugins/webviewflutter/PigeonApiWebSettings;", "getPigeonApiWebStorage", "Lio/flutter/plugins/webviewflutter/PigeonApiWebStorage;", "getPigeonApiWebView", "Lio/flutter/plugins/webviewflutter/PigeonApiWebView;", "getPigeonApiWebViewClient", "Lio/flutter/plugins/webviewflutter/PigeonApiWebViewClient;", "getPigeonApiWebViewPoint", "Lio/flutter/plugins/webviewflutter/PigeonApiWebViewPoint;", "getPigeonApiX509Certificate", "Lio/flutter/plugins/webviewflutter/PigeonApiX509Certificate;", "setUp", "", "tearDown", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public abstract class AndroidWebkitLibraryPigeonProxyApiRegistrar {
    private MessageCodec<Object> _codec;
    private final BinaryMessenger binaryMessenger;
    private boolean ignoreCallsToDart;
    private final AndroidWebkitLibraryPigeonInstanceManager instanceManager;

    public abstract PigeonApiAndroidMessage getPigeonApiAndroidMessage();

    public abstract PigeonApiCertificate getPigeonApiCertificate();

    public abstract PigeonApiClientCertRequest getPigeonApiClientCertRequest();

    public abstract PigeonApiConsoleMessage getPigeonApiConsoleMessage();

    public abstract PigeonApiCookieManager getPigeonApiCookieManager();

    public abstract PigeonApiCustomViewCallback getPigeonApiCustomViewCallback();

    public abstract PigeonApiDownloadListener getPigeonApiDownloadListener();

    public abstract PigeonApiFileChooserParams getPigeonApiFileChooserParams();

    public abstract PigeonApiFlutterAssetManager getPigeonApiFlutterAssetManager();

    public abstract PigeonApiGeolocationPermissionsCallback getPigeonApiGeolocationPermissionsCallback();

    public abstract PigeonApiHttpAuthHandler getPigeonApiHttpAuthHandler();

    public abstract PigeonApiJavaScriptChannel getPigeonApiJavaScriptChannel();

    public abstract PigeonApiPermissionRequest getPigeonApiPermissionRequest();

    public abstract PigeonApiSslCertificate getPigeonApiSslCertificate();

    public abstract PigeonApiSslCertificateDName getPigeonApiSslCertificateDName();

    public abstract PigeonApiSslError getPigeonApiSslError();

    public abstract PigeonApiSslErrorHandler getPigeonApiSslErrorHandler();

    public abstract PigeonApiView getPigeonApiView();

    public abstract PigeonApiWebChromeClient getPigeonApiWebChromeClient();

    public abstract PigeonApiWebResourceError getPigeonApiWebResourceError();

    public abstract PigeonApiWebResourceErrorCompat getPigeonApiWebResourceErrorCompat();

    public abstract PigeonApiWebResourceRequest getPigeonApiWebResourceRequest();

    public abstract PigeonApiWebResourceResponse getPigeonApiWebResourceResponse();

    public abstract PigeonApiWebSettings getPigeonApiWebSettings();

    public abstract PigeonApiWebStorage getPigeonApiWebStorage();

    public abstract PigeonApiWebView getPigeonApiWebView();

    public abstract PigeonApiWebViewClient getPigeonApiWebViewClient();

    public abstract PigeonApiWebViewPoint getPigeonApiWebViewPoint();

    public AndroidWebkitLibraryPigeonProxyApiRegistrar(BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        this.binaryMessenger = binaryMessenger;
        final AndroidWebkitLibraryPigeonInstanceManagerApi androidWebkitLibraryPigeonInstanceManagerApi = new AndroidWebkitLibraryPigeonInstanceManagerApi(binaryMessenger);
        this.instanceManager = AndroidWebkitLibraryPigeonInstanceManager.INSTANCE.create(new AndroidWebkitLibraryPigeonInstanceManager.PigeonFinalizationListener() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar.1
            @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonInstanceManager.PigeonFinalizationListener
            public void onFinalize(final long identifier) {
                AndroidWebkitLibraryPigeonInstanceManagerApi.this.removeStrongReference(identifier, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar$1$onFinalize$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                        m845invoke(result.getValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m845invoke(Object obj) {
                        if (Result.m950isFailureimpl(obj)) {
                            Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + identifier);
                        }
                    }
                });
            }
        });
    }

    public final BinaryMessenger getBinaryMessenger() {
        return this.binaryMessenger;
    }

    public final boolean getIgnoreCallsToDart() {
        return this.ignoreCallsToDart;
    }

    public final void setIgnoreCallsToDart(boolean z) {
        this.ignoreCallsToDart = z;
    }

    public final AndroidWebkitLibraryPigeonInstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    public final MessageCodec<Object> getCodec() {
        if (this._codec == null) {
            this._codec = new AndroidWebkitLibraryPigeonProxyApiBaseCodec(this);
        }
        MessageCodec<Object> messageCodec = this._codec;
        Intrinsics.checkNotNull(messageCodec);
        return messageCodec;
    }

    public PigeonApiPrivateKey getPigeonApiPrivateKey() {
        return new PigeonApiPrivateKey(this);
    }

    public PigeonApiX509Certificate getPigeonApiX509Certificate() {
        return new PigeonApiX509Certificate(this);
    }

    public final void setUp() {
        AndroidWebkitLibraryPigeonInstanceManagerApi.INSTANCE.setUpMessageHandlers(this.binaryMessenger, this.instanceManager);
        PigeonApiCookieManager.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiCookieManager());
        PigeonApiWebView.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiWebView());
        PigeonApiWebSettings.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiWebSettings());
        PigeonApiJavaScriptChannel.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiJavaScriptChannel());
        PigeonApiWebViewClient.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiWebViewClient());
        PigeonApiDownloadListener.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiDownloadListener());
        PigeonApiWebChromeClient.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiWebChromeClient());
        PigeonApiFlutterAssetManager.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiFlutterAssetManager());
        PigeonApiWebStorage.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiWebStorage());
        PigeonApiPermissionRequest.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiPermissionRequest());
        PigeonApiCustomViewCallback.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiCustomViewCallback());
        PigeonApiView.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiView());
        PigeonApiGeolocationPermissionsCallback.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiGeolocationPermissionsCallback());
        PigeonApiHttpAuthHandler.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiHttpAuthHandler());
        PigeonApiAndroidMessage.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiAndroidMessage());
        PigeonApiClientCertRequest.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiClientCertRequest());
        PigeonApiSslErrorHandler.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiSslErrorHandler());
        PigeonApiSslError.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiSslError());
        PigeonApiSslCertificateDName.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiSslCertificateDName());
        PigeonApiSslCertificate.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiSslCertificate());
        PigeonApiCertificate.INSTANCE.setUpMessageHandlers(this.binaryMessenger, getPigeonApiCertificate());
    }

    public final void tearDown() {
        AndroidWebkitLibraryPigeonInstanceManagerApi.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiCookieManager.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiWebView.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiWebSettings.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiJavaScriptChannel.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiWebViewClient.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiDownloadListener.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiWebChromeClient.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiFlutterAssetManager.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiWebStorage.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiPermissionRequest.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiCustomViewCallback.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiView.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiGeolocationPermissionsCallback.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiHttpAuthHandler.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiAndroidMessage.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiClientCertRequest.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiSslErrorHandler.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiSslError.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiSslCertificateDName.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiSslCertificate.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
        PigeonApiCertificate.INSTANCE.setUpMessageHandlers(this.binaryMessenger, null);
    }
}
