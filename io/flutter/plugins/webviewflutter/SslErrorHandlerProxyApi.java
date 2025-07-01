package io.flutter.plugins.webviewflutter;

import android.webkit.SslErrorHandler;

/* loaded from: classes4.dex */
class SslErrorHandlerProxyApi extends PigeonApiSslErrorHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SslErrorHandlerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslErrorHandler
    public void cancel(SslErrorHandler sslErrorHandler) {
        sslErrorHandler.cancel();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslErrorHandler
    public void proceed(SslErrorHandler sslErrorHandler) {
        sslErrorHandler.proceed();
    }
}
