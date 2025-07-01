package io.flutter.plugins.webviewflutter;

import android.webkit.JavascriptInterface;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class JavaScriptChannel {
    private final JavaScriptChannelProxyApi api;
    final String javaScriptChannelName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$postMessage$0(Result result) {
        return null;
    }

    public JavaScriptChannel(String str, JavaScriptChannelProxyApi javaScriptChannelProxyApi) {
        this.javaScriptChannelName = str;
        this.api = javaScriptChannelProxyApi;
    }

    @JavascriptInterface
    public void postMessage(final String str) {
        this.api.getPigeonRegistrar().runOnMainThread(new Runnable() { // from class: io.flutter.plugins.webviewflutter.JavaScriptChannel$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                JavaScriptChannel.this.m847x6cafa204(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$postMessage$1$io-flutter-plugins-webviewflutter-JavaScriptChannel, reason: not valid java name */
    public /* synthetic */ void m847x6cafa204(String str) {
        this.api.postMessage(this, str, new Function1() { // from class: io.flutter.plugins.webviewflutter.JavaScriptChannel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JavaScriptChannel.lambda$postMessage$0((Result) obj);
            }
        });
    }
}
