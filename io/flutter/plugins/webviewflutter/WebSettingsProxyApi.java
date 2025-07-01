package io.flutter.plugins.webviewflutter;

import android.webkit.WebSettings;

/* loaded from: classes4.dex */
public class WebSettingsProxyApi extends PigeonApiWebSettings {
    public WebSettingsProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setDomStorageEnabled(WebSettings webSettings, boolean z) {
        webSettings.setDomStorageEnabled(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setJavaScriptCanOpenWindowsAutomatically(WebSettings webSettings, boolean z) {
        webSettings.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setSupportMultipleWindows(WebSettings webSettings, boolean z) {
        webSettings.setSupportMultipleWindows(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setJavaScriptEnabled(WebSettings webSettings, boolean z) {
        webSettings.setJavaScriptEnabled(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setUserAgentString(WebSettings webSettings, String str) {
        webSettings.setUserAgentString(str);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean z) {
        webSettings.setMediaPlaybackRequiresUserGesture(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setSupportZoom(WebSettings webSettings, boolean z) {
        webSettings.setSupportZoom(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setLoadWithOverviewMode(WebSettings webSettings, boolean z) {
        webSettings.setLoadWithOverviewMode(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setUseWideViewPort(WebSettings webSettings, boolean z) {
        webSettings.setUseWideViewPort(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setDisplayZoomControls(WebSettings webSettings, boolean z) {
        webSettings.setDisplayZoomControls(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setBuiltInZoomControls(WebSettings webSettings, boolean z) {
        webSettings.setBuiltInZoomControls(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setAllowFileAccess(WebSettings webSettings, boolean z) {
        webSettings.setAllowFileAccess(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setAllowContentAccess(WebSettings webSettings, boolean z) {
        webSettings.setAllowContentAccess(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setGeolocationEnabled(WebSettings webSettings, boolean z) {
        webSettings.setGeolocationEnabled(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setTextZoom(WebSettings webSettings, long j) {
        webSettings.setTextZoom((int) j);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public String getUserAgentString(WebSettings webSettings) {
        return webSettings.getUserAgentString();
    }
}
