package io.flutter.plugins.webviewflutter;

import android.webkit.HttpAuthHandler;

/* loaded from: classes4.dex */
public class HttpAuthHandlerProxyApi extends PigeonApiHttpAuthHandler {
    public HttpAuthHandlerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public boolean useHttpAuthUsernamePassword(HttpAuthHandler httpAuthHandler) {
        return httpAuthHandler.useHttpAuthUsernamePassword();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public void cancel(HttpAuthHandler httpAuthHandler) {
        httpAuthHandler.cancel();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public void proceed(HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.proceed(str, str2);
    }
}
