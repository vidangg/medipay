package com.pichillilorenzo.flutter_inappwebview_android.webview.web_message;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class WebMessageChannelChannelDelegate extends ChannelDelegateImpl {
    private WebMessageChannel webMessageChannel;

    public WebMessageChannelChannelDelegate(WebMessageChannel webMessageChannel, MethodChannel methodChannel) {
        super(methodChannel);
        this.webMessageChannel = webMessageChannel;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.webMessageChannel = null;
    }

    public void onMessage(int i, WebMessageCompatExt webMessageCompatExt) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        hashMap.put(Constant.PARAM_ERROR_MESSAGE, webMessageCompatExt != null ? webMessageCompatExt.toMap() : null);
        channel.invokeMethod("onMessage", hashMap);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0033. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 94756344:
                if (str.equals("close")) {
                    c = 0;
                    break;
                }
                break;
            case 556190586:
                if (str.equals("setWebMessageCallback")) {
                    c = 1;
                    break;
                }
                break;
            case 1490029383:
                if (str.equals("postMessage")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                WebMessageChannel webMessageChannel = this.webMessageChannel;
                if (webMessageChannel != null && (webMessageChannel.webView instanceof InAppWebView)) {
                    this.webMessageChannel.closeForInAppWebView((Integer) methodCall.argument(FirebaseAnalytics.Param.INDEX), result);
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 1:
                WebMessageChannel webMessageChannel2 = this.webMessageChannel;
                if (webMessageChannel2 != null && (webMessageChannel2.webView instanceof InAppWebView)) {
                    this.webMessageChannel.setWebMessageCallbackForInAppWebView(((Integer) methodCall.argument(FirebaseAnalytics.Param.INDEX)).intValue(), result);
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 2:
                WebMessageChannel webMessageChannel3 = this.webMessageChannel;
                if (webMessageChannel3 != null && (webMessageChannel3.webView instanceof InAppWebView)) {
                    this.webMessageChannel.postMessageForInAppWebView((Integer) methodCall.argument(FirebaseAnalytics.Param.INDEX), WebMessageCompatExt.fromMap((Map) methodCall.argument(Constant.PARAM_ERROR_MESSAGE)), result);
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
