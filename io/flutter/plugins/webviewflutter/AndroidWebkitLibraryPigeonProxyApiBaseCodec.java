package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.webkit.WebResourceErrorCompat;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiBaseCodec;", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonCodec;", "registrar", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "(Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;)V", "getRegistrar", "()Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "readValueOfType", "", SessionDescription.ATTR_TYPE, "", "buffer", "Ljava/nio/ByteBuffer;", "writeValue", "", "stream", "Ljava/io/ByteArrayOutputStream;", "value", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidWebkitLibraryPigeonProxyApiBaseCodec extends AndroidWebkitLibraryPigeonCodec {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar registrar;

    public final AndroidWebkitLibraryPigeonProxyApiRegistrar getRegistrar() {
        return this.registrar;
    }

    public AndroidWebkitLibraryPigeonProxyApiBaseCodec(AndroidWebkitLibraryPigeonProxyApiRegistrar registrar) {
        Intrinsics.checkNotNullParameter(registrar, "registrar");
        this.registrar = registrar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte type, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (type == Byte.MIN_VALUE) {
            Object readValue = readValue(buffer);
            Intrinsics.checkNotNull(readValue, "null cannot be cast to non-null type kotlin.Long");
            long longValue = ((Long) readValue).longValue();
            Object androidWebkitLibraryPigeonInstanceManager = this.registrar.getInstanceManager().getInstance(longValue);
            if (androidWebkitLibraryPigeonInstanceManager == null) {
                Log.e("PigeonProxyApiBaseCodec", "Failed to find instance with identifier: " + longValue);
            }
            return androidWebkitLibraryPigeonInstanceManager;
        }
        return super.readValueOfType(type, buffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object value) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        if ((value instanceof Boolean) || (value instanceof byte[]) || (value instanceof Double) || (value instanceof double[]) || (value instanceof float[]) || (value instanceof Integer) || (value instanceof int[]) || (value instanceof List) || (value instanceof Long) || (value instanceof long[]) || (value instanceof Map) || (value instanceof String) || (value instanceof FileChooserMode) || (value instanceof ConsoleMessageLevel) || (value instanceof OverScrollMode) || (value instanceof SslErrorType) || value == null) {
            super.writeValue(stream, value);
            return;
        }
        if (value instanceof WebResourceRequest) {
            this.registrar.getPigeonApiWebResourceRequest().pigeon_newInstance((WebResourceRequest) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m815invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m815invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebResourceResponse) {
            this.registrar.getPigeonApiWebResourceResponse().pigeon_newInstance((WebResourceResponse) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$2
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m826invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m826invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebResourceError) {
            this.registrar.getPigeonApiWebResourceError().pigeon_newInstance((WebResourceError) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$3
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m837invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m837invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebResourceErrorCompat) {
            this.registrar.getPigeonApiWebResourceErrorCompat().pigeon_newInstance((WebResourceErrorCompat) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$4
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m839invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m839invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebViewPoint) {
            this.registrar.getPigeonApiWebViewPoint().pigeon_newInstance((WebViewPoint) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$5
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m840invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m840invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof ConsoleMessage) {
            this.registrar.getPigeonApiConsoleMessage().pigeon_newInstance((ConsoleMessage) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$6
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m841invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m841invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof CookieManager) {
            this.registrar.getPigeonApiCookieManager().pigeon_newInstance((CookieManager) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$7
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m842invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m842invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebView) {
            this.registrar.getPigeonApiWebView().pigeon_newInstance((WebView) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$8
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m843invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m843invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebSettings) {
            this.registrar.getPigeonApiWebSettings().pigeon_newInstance((WebSettings) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$9
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m844invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m844invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof JavaScriptChannel) {
            this.registrar.getPigeonApiJavaScriptChannel().pigeon_newInstance((JavaScriptChannel) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$10
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m816invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m816invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebViewClient) {
            this.registrar.getPigeonApiWebViewClient().pigeon_newInstance((WebViewClient) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$11
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m817invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m817invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof DownloadListener) {
            this.registrar.getPigeonApiDownloadListener().pigeon_newInstance((DownloadListener) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$12
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m818invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m818invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebChromeClientProxyApi.WebChromeClientImpl) {
            this.registrar.getPigeonApiWebChromeClient().pigeon_newInstance((WebChromeClientProxyApi.WebChromeClientImpl) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$13
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m819invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m819invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof FlutterAssetManager) {
            this.registrar.getPigeonApiFlutterAssetManager().pigeon_newInstance((FlutterAssetManager) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$14
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m820invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m820invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebStorage) {
            this.registrar.getPigeonApiWebStorage().pigeon_newInstance((WebStorage) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$15
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m821invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m821invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebChromeClient.FileChooserParams) {
            this.registrar.getPigeonApiFileChooserParams().pigeon_newInstance((WebChromeClient.FileChooserParams) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$16
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m822invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m822invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof PermissionRequest) {
            this.registrar.getPigeonApiPermissionRequest().pigeon_newInstance((PermissionRequest) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$17
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m823invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m823invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof WebChromeClient.CustomViewCallback) {
            this.registrar.getPigeonApiCustomViewCallback().pigeon_newInstance((WebChromeClient.CustomViewCallback) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$18
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m824invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m824invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof View) {
            this.registrar.getPigeonApiView().pigeon_newInstance((View) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$19
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m825invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m825invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof GeolocationPermissions.Callback) {
            this.registrar.getPigeonApiGeolocationPermissionsCallback().pigeon_newInstance((GeolocationPermissions.Callback) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$20
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m827invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m827invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof HttpAuthHandler) {
            this.registrar.getPigeonApiHttpAuthHandler().pigeon_newInstance((HttpAuthHandler) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$21
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m828invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m828invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof Message) {
            this.registrar.getPigeonApiAndroidMessage().pigeon_newInstance((Message) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$22
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m829invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m829invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof ClientCertRequest) {
            this.registrar.getPigeonApiClientCertRequest().pigeon_newInstance((ClientCertRequest) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$23
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m830invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m830invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof PrivateKey) {
            this.registrar.getPigeonApiPrivateKey().pigeon_newInstance((PrivateKey) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$24
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m831invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m831invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof X509Certificate) {
            this.registrar.getPigeonApiX509Certificate().pigeon_newInstance((X509Certificate) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$25
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m832invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m832invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof SslErrorHandler) {
            this.registrar.getPigeonApiSslErrorHandler().pigeon_newInstance((SslErrorHandler) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$26
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m833invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m833invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof SslError) {
            this.registrar.getPigeonApiSslError().pigeon_newInstance((SslError) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$27
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m834invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m834invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof SslCertificate.DName) {
            this.registrar.getPigeonApiSslCertificateDName().pigeon_newInstance((SslCertificate.DName) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$28
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m835invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m835invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof SslCertificate) {
            this.registrar.getPigeonApiSslCertificate().pigeon_newInstance((SslCertificate) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$29
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m836invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m836invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (value instanceof Certificate) {
            this.registrar.getPigeonApiCertificate().pigeon_newInstance((Certificate) value, new Function1<Result<? extends Unit>, Unit>() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiBaseCodec$writeValue$30
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m838invoke(Object obj) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> result) {
                    m838invoke(result.getValue());
                    return Unit.INSTANCE;
                }
            });
        }
        if (this.registrar.getInstanceManager().containsInstance(value)) {
            stream.write(128);
            writeValue(stream, this.registrar.getInstanceManager().getIdentifierForStrongReference(value));
            return;
        }
        throw new IllegalArgumentException("Unsupported value: '" + value + "' of type '" + value.getClass().getName() + "'");
    }
}
