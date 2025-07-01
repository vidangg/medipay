package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public class WebResourceRequestProxyApi extends PigeonApiWebResourceRequest {
    public WebResourceRequestProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public String url(WebResourceRequest webResourceRequest) {
        return webResourceRequest.getUrl().toString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public boolean isForMainFrame(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isForMainFrame();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public Boolean isRedirect(WebResourceRequest webResourceRequest) {
        if (getPigeonRegistrar().sdkIsAtLeast(24)) {
            return Boolean.valueOf(webResourceRequest.isRedirect());
        }
        return null;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public boolean hasGesture(WebResourceRequest webResourceRequest) {
        return webResourceRequest.hasGesture();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public String method(WebResourceRequest webResourceRequest) {
        return webResourceRequest.getMethod();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public Map<String, String> requestHeaders(WebResourceRequest webResourceRequest) {
        if (webResourceRequest.getRequestHeaders() == null) {
            return Collections.emptyMap();
        }
        return webResourceRequest.getRequestHeaders();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
