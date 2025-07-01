package io.flutter.plugins.webviewflutter;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class WebViewClientProxyApi extends PigeonApiWebViewClient {

    /* loaded from: classes4.dex */
    public static class WebViewClientImpl extends WebViewClient {
        private final WebViewClientProxyApi api;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$doUpdateVisitedHistory$14(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onFormResubmission$18(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onLoadResource$20(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPageCommitVisible$22(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPageFinished$2(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPageStarted$0(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedClientCertRequest$24(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedError$6(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedError$8(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedHttpAuthRequest$16(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedHttpError$4(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedLoginRequest$26(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedSslError$28(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onScaleChanged$30(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$shouldOverrideUrlLoading$10(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$shouldOverrideUrlLoading$12(Result result) {
            return null;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        }

        public WebViewClientImpl(WebViewClientProxyApi webViewClientProxyApi) {
            this.api = webViewClientProxyApi;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(final WebView webView, final String str, Bitmap bitmap) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m928x4a8a024a(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPageStarted$1$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m928x4a8a024a(WebView webView, String str) {
            this.api.onPageStarted(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onPageStarted$0((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m927x568bd1f3(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPageFinished$3$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m927x568bd1f3(WebView webView, String str) {
            this.api.onPageFinished(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onPageFinished$2((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m933x934c515b(webView, webResourceRequest, webResourceResponse);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedHttpError$5$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m933x934c515b(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            this.api.onReceivedHttpError(this, webView, webResourceRequest, webResourceResponse, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedHttpError$4((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m930x974b9805(webView, webResourceRequest, webResourceError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedError$7$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m930x974b9805(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            this.api.onReceivedRequestError(this, webView, webResourceRequest, webResourceError, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedError$6((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(final WebView webView, final int i, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m931xfea7ed87(webView, i, str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedError$9$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m931xfea7ed87(WebView webView, int i, String str, String str2) {
            this.api.onReceivedError(this, webView, i, str, str2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedError$8((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m937x296b9962(webView, webResourceRequest);
                }
            });
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$shouldOverrideUrlLoading$11$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m937x296b9962(WebView webView, WebResourceRequest webResourceRequest) {
            this.api.requestLoading(this, webView, webResourceRequest, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$shouldOverrideUrlLoading$10((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m938x90c7eee4(webView, str);
                }
            });
            return this.returnValueForShouldOverrideUrlLoading;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$shouldOverrideUrlLoading$13$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m938x90c7eee4(WebView webView, String str) {
            this.api.urlLoading(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$shouldOverrideUrlLoading$12((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(final WebView webView, final String str, final boolean z) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m923x8373e6d4(webView, str, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$doUpdateVisitedHistory$15$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m923x8373e6d4(WebView webView, String str, boolean z) {
            this.api.doUpdateVisitedHistory(this, webView, str, z, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$doUpdateVisitedHistory$14((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m932xa177970f(webView, httpAuthHandler, str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedHttpAuthRequest$17$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m932xa177970f(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.api.onReceivedHttpAuthRequest(this, webView, httpAuthHandler, str, str2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedHttpAuthRequest$16((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m924xaaab5994(webView, message, message2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFormResubmission$19$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m924xaaab5994(WebView webView, Message message, Message message2) {
            this.api.onFormResubmission(this, webView, message, message2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onFormResubmission$18((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m925x8bc1741a(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onLoadResource$21$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m925x8bc1741a(WebView webView, String str) {
            this.api.onLoadResource(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onLoadResource$20((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m926xe0c1023c(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPageCommitVisible$23$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m926xe0c1023c(WebView webView, String str) {
            this.api.onPageCommitVisible(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onPageCommitVisible$22((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(final WebView webView, final ClientCertRequest clientCertRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m929x17af746b(webView, clientCertRequest);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedClientCertRequest$25$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m929x17af746b(WebView webView, ClientCertRequest clientCertRequest) {
            this.api.onReceivedClientCertRequest(this, webView, clientCertRequest, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedClientCertRequest$24((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(final WebView webView, final String str, final String str2, final String str3) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m934x3c50372d(webView, str, str2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedLoginRequest$27$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m934x3c50372d(WebView webView, String str, String str2, String str3) {
            this.api.onReceivedLoginRequest(this, webView, str, str2, str3, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedLoginRequest$26((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m935xf6ba0d79(webView, sslErrorHandler, sslError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedSslError$29$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m935xf6ba0d79(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.api.onReceivedSslError(this, webView, sslErrorHandler, sslError, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedSslError$28((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(final WebView webView, final float f, final float f2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientImpl.this.m936x5cf92e43(webView, f, f2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onScaleChanged$31$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientImpl, reason: not valid java name */
        public /* synthetic */ void m936x5cf92e43(WebView webView, float f, float f2) {
            this.api.onScaleChanged(this, webView, f, f2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientImpl$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientImpl.lambda$onScaleChanged$30((Result) obj);
                }
            });
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z) {
            this.returnValueForShouldOverrideUrlLoading = z;
        }
    }

    /* loaded from: classes4.dex */
    public static class WebViewClientCompatImpl extends WebViewClientCompat {
        private final WebViewClientProxyApi api;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$doUpdateVisitedHistory$14(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onFormResubmission$18(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onLoadResource$20(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPageCommitVisible$22(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPageFinished$2(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPageStarted$0(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedClientCertRequest$24(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedError$6(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedError$8(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedHttpAuthRequest$16(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedHttpError$4(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedLoginRequest$26(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onReceivedSslError$28(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onScaleChanged$30(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$shouldOverrideUrlLoading$10(Result result) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$shouldOverrideUrlLoading$12(Result result) {
            return null;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        }

        public WebViewClientCompatImpl(WebViewClientProxyApi webViewClientProxyApi) {
            this.api = webViewClientProxyApi;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(final WebView webView, final String str, Bitmap bitmap) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m912x88ded16c(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPageStarted$1$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m912x88ded16c(WebView webView, String str) {
            this.api.onPageStarted(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onPageStarted$0((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m911xe6067e55(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPageFinished$3$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m911xe6067e55(WebView webView, String str) {
            this.api.onPageFinished(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onPageFinished$2((Result) obj);
                }
            });
        }

        @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public void onReceivedHttpError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m917x47b3cfbd(webView, webResourceRequest, webResourceResponse);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedHttpError$5$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m917x47b3cfbd(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            this.api.onReceivedHttpError(this, webView, webResourceRequest, webResourceResponse, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onReceivedHttpError$4((Result) obj);
                }
            });
        }

        @Override // androidx.webkit.WebViewClientCompat
        public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceErrorCompat webResourceErrorCompat) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m914x2589eee7(webView, webResourceRequest, webResourceErrorCompat);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedError$7$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m914x2589eee7(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorCompat webResourceErrorCompat) {
            this.api.onReceivedRequestErrorCompat(this, webView, webResourceRequest, webResourceErrorCompat, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onReceivedError$6((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(final WebView webView, final int i, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m915xe67c9ae9(webView, i, str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedError$9$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m915xe67c9ae9(WebView webView, int i, String str, String str2) {
            this.api.onReceivedError(this, webView, i, str, str2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onReceivedError$8((Result) obj);
                }
            });
        }

        @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m921xbd88b684(webView, webResourceRequest);
                }
            });
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$shouldOverrideUrlLoading$11$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m921xbd88b684(WebView webView, WebResourceRequest webResourceRequest) {
            this.api.requestLoading(this, webView, webResourceRequest, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$shouldOverrideUrlLoading$10((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m922x7e7b6286(webView, str);
                }
            });
            return this.returnValueForShouldOverrideUrlLoading;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$shouldOverrideUrlLoading$13$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m922x7e7b6286(WebView webView, String str) {
            this.api.urlLoading(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$shouldOverrideUrlLoading$12((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(final WebView webView, final String str, final boolean z) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m907x3fe9a676(webView, str, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$doUpdateVisitedHistory$15$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m907x3fe9a676(WebView webView, String str, boolean z) {
            this.api.doUpdateVisitedHistory(this, webView, str, z, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$doUpdateVisitedHistory$14((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String str, final String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m916x978fe71(webView, httpAuthHandler, str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedHttpAuthRequest$17$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m916x978fe71(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.api.onReceivedHttpAuthRequest(this, webView, httpAuthHandler, str, str2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onReceivedHttpAuthRequest$16((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m908x14f00936(webView, message, message2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFormResubmission$19$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m908x14f00936(WebView webView, Message message, Message message2) {
            this.api.onFormResubmission(this, webView, message, message2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onFormResubmission$18((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m909x600da73c(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onLoadResource$21$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m909x600da73c(WebView webView, String str) {
            this.api.onLoadResource(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onLoadResource$20((Result) obj);
                }
            });
        }

        @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public void onPageCommitVisible(final WebView webView, final String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m910x753e93de(webView, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPageCommitVisible$23$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m910x753e93de(WebView webView, String str) {
            this.api.onPageCommitVisible(this, webView, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onPageCommitVisible$22((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(final WebView webView, final ClientCertRequest clientCertRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m913x7e5466cd(webView, clientCertRequest);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedClientCertRequest$25$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m913x7e5466cd(WebView webView, ClientCertRequest clientCertRequest) {
            this.api.onReceivedClientCertRequest(this, webView, clientCertRequest, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onReceivedClientCertRequest$24((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(final WebView webView, final String str, final String str2, final String str3) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m918x3a54900f(webView, str, str2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedLoginRequest$27$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m918x3a54900f(WebView webView, String str, String str2, String str3) {
            this.api.onReceivedLoginRequest(this, webView, str, str2, str3, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onReceivedLoginRequest$26((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m919xebdf7d5b(webView, sslErrorHandler, sslError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onReceivedSslError$29$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m919xebdf7d5b(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.api.onReceivedSslError(this, webView, sslErrorHandler, sslError, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onReceivedSslError$28((Result) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(final WebView webView, final float f, final float f2) {
            this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewClientProxyApi.WebViewClientCompatImpl.this.m920xebf15ea5(webView, f, f2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onScaleChanged$31$io-flutter-plugins-webviewflutter-WebViewClientProxyApi$WebViewClientCompatImpl, reason: not valid java name */
        public /* synthetic */ void m920xebf15ea5(WebView webView, float f, float f2) {
            this.api.onScaleChanged(this, webView, f, f2, new Function1() { // from class: io.flutter.plugins.webviewflutter.WebViewClientProxyApi$WebViewClientCompatImpl$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WebViewClientProxyApi.WebViewClientCompatImpl.lambda$onScaleChanged$30((Result) obj);
                }
            });
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z) {
            this.returnValueForShouldOverrideUrlLoading = z;
        }
    }

    public WebViewClientProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public WebViewClient pigeon_defaultConstructor() {
        if (getPigeonRegistrar().sdkIsAtLeast(24)) {
            return new WebViewClientImpl(this);
        }
        return new WebViewClientCompatImpl(this);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public void setSynchronousReturnValueForShouldOverrideUrlLoading(WebViewClient webViewClient, boolean z) {
        if (webViewClient instanceof WebViewClientCompatImpl) {
            ((WebViewClientCompatImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(z);
        } else {
            if (getPigeonRegistrar().sdkIsAtLeast(24) && (webViewClient instanceof WebViewClientImpl)) {
                ((WebViewClientImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(z);
                return;
            }
            throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
