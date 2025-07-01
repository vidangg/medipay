package io.flutter.plugins.webviewflutter;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class CookieManagerProxyApi extends PigeonApiCookieManager {
    public CookieManagerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public CookieManager instance() {
        return CookieManager.getInstance();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public void setCookie(CookieManager cookieManager, String str, String str2) {
        cookieManager.setCookie(str, str2);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public void removeAllCookies(CookieManager cookieManager, final Function1<? super Result<Boolean>, Unit> function1) {
        cookieManager.removeAllCookies(new ValueCallback() { // from class: io.flutter.plugins.webviewflutter.CookieManagerProxyApi$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ResultCompat.success((Boolean) obj, Function1.this);
            }
        });
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCookieManager
    public void setAcceptThirdPartyCookies(CookieManager cookieManager, WebView webView, boolean z) {
        cookieManager.setAcceptThirdPartyCookies(webView, z);
    }
}
