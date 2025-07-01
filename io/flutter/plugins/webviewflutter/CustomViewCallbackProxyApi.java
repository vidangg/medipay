package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;

/* loaded from: classes4.dex */
public class CustomViewCallbackProxyApi extends PigeonApiCustomViewCallback {
    public CustomViewCallbackProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCustomViewCallback
    public void onCustomViewHidden(WebChromeClient.CustomViewCallback customViewCallback) {
        customViewCallback.onCustomViewHidden();
    }
}
