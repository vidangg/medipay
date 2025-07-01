package io.flutter.plugins.webviewflutter;

/* loaded from: classes4.dex */
public class JavaScriptChannelProxyApi extends PigeonApiJavaScriptChannel {
    public JavaScriptChannelProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiJavaScriptChannel
    public JavaScriptChannel pigeon_defaultConstructor(String str) {
        return new JavaScriptChannel(str, this);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiJavaScriptChannel
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
