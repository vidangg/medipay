package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceResponse;

/* loaded from: classes4.dex */
public class WebResourceResponseProxyApi extends PigeonApiWebResourceResponse {
    public WebResourceResponseProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceResponse
    public long statusCode(WebResourceResponse webResourceResponse) {
        return webResourceResponse.getStatusCode();
    }
}
