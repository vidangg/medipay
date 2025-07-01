package com.pichillilorenzo.flutter_inappwebview_android;

import androidx.webkit.WebViewFeature;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes4.dex */
public class WebViewFeatureManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "WebViewFeatureManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_webviewfeature";
    public InAppWebViewFlutterPlugin plugin;

    public WebViewFeatureManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        boolean isStartupFeatureSupported;
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("isStartupFeatureSupported")) {
            InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
            if (inAppWebViewFlutterPlugin == null || inAppWebViewFlutterPlugin.activity == null) {
                return;
            }
            isStartupFeatureSupported = WebViewFeature.isStartupFeatureSupported(this.plugin.activity, (String) methodCall.argument("startupFeature"));
        } else {
            if (!str.equals("isFeatureSupported")) {
                result.notImplemented();
                return;
            }
            isStartupFeatureSupported = WebViewFeature.isFeatureSupported((String) methodCall.argument("feature"));
        }
        result.success(Boolean.valueOf(isStartupFeatureSupported));
    }
}
