package io.flutter.plugins.webviewflutter;

import androidx.webkit.WebResourceErrorCompat;

/* loaded from: classes4.dex */
public class WebResourceErrorCompatProxyApi extends PigeonApiWebResourceErrorCompat {
    public WebResourceErrorCompatProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceErrorCompat
    public long errorCode(WebResourceErrorCompat webResourceErrorCompat) {
        return webResourceErrorCompat.getErrorCode();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceErrorCompat
    public String description(WebResourceErrorCompat webResourceErrorCompat) {
        return webResourceErrorCompat.getDescription().toString();
    }
}
