package com.pichillilorenzo.flutter_inappwebview_android.webview.web_message;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.PluginScript;
import com.pichillilorenzo.flutter_inappwebview_android.types.UserScriptInjectionTime;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewInterface;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class WebMessageListener implements Disposable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String LOG_TAG = "WebMessageListener";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_web_message_listener_";
    public Set<String> allowedOriginRules;
    public WebMessageListenerChannelDelegate channelDelegate;
    public String id;
    public String jsObjectName;
    public WebViewCompat.WebMessageListener listener;
    public JavaScriptReplyProxy replyProxy;
    public InAppWebViewInterface webView;

    public WebMessageListener(String str, InAppWebViewInterface inAppWebViewInterface, BinaryMessenger binaryMessenger, String str2, Set<String> set) {
        this.id = str;
        this.webView = inAppWebViewInterface;
        this.jsObjectName = str2;
        this.allowedOriginRules = set;
        this.channelDelegate = new WebMessageListenerChannelDelegate(this, new MethodChannel(binaryMessenger, METHOD_CHANNEL_NAME_PREFIX + this.id + "_" + this.jsObjectName));
        if (this.webView instanceof InAppWebView) {
            this.listener = new WebViewCompat.WebMessageListener() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageListener.1
                @Override // androidx.webkit.WebViewCompat.WebMessageListener
                public void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
                    WebMessageListener webMessageListener = WebMessageListener.this;
                    webMessageListener.replyProxy = javaScriptReplyProxy;
                    WebMessageListenerChannelDelegate webMessageListenerChannelDelegate = webMessageListener.channelDelegate;
                    if (webMessageListenerChannelDelegate != null) {
                        webMessageListenerChannelDelegate.onPostMessage(WebMessageCompatExt.fromMapWebMessageCompat(webMessageCompat), uri.toString().equals("null") ? null : uri.toString(), z);
                    }
                }
            };
        }
    }

    public static WebMessageListener fromMap(InAppWebViewInterface inAppWebViewInterface, BinaryMessenger binaryMessenger, Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new WebMessageListener((String) map.get(TtmlNode.ATTR_ID), inAppWebViewInterface, binaryMessenger, (String) map.get("jsObjectName"), new HashSet((List) map.get("allowedOriginRules")));
    }

    public void assertOriginRulesValid() {
        int i = 0;
        for (String str : this.allowedOriginRules) {
            if (str == null) {
                throw new Exception("allowedOriginRules[" + i + "] is null");
            }
            if (str.isEmpty()) {
                throw new Exception("allowedOriginRules[" + i + "] is empty");
            }
            if (!ProxyConfig.MATCH_ALL_SCHEMES.equals(str)) {
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String host = parse.getHost();
                String path = parse.getPath();
                int port = parse.getPort();
                if (scheme == null) {
                    throw new Exception("allowedOriginRules " + str + " is invalid");
                }
                if ((ProxyConfig.MATCH_HTTP.equals(scheme) || ProxyConfig.MATCH_HTTPS.equals(scheme)) && (host == null || host.isEmpty())) {
                    throw new Exception("allowedOriginRules " + str + " is invalid");
                }
                if (!ProxyConfig.MATCH_HTTP.equals(scheme) && !ProxyConfig.MATCH_HTTPS.equals(scheme) && (host != null || port != -1)) {
                    throw new Exception("allowedOriginRules " + str + " is invalid");
                }
                if ((host == null || host.isEmpty()) && port != -1) {
                    throw new Exception("allowedOriginRules " + str + " is invalid");
                }
                if (!path.isEmpty()) {
                    throw new Exception("allowedOriginRules " + str + " is invalid");
                }
                if (host != null) {
                    int indexOf = host.indexOf(ProxyConfig.MATCH_ALL_SCHEMES);
                    if (indexOf != 0 || (indexOf == 0 && !host.startsWith("*."))) {
                        throw new Exception("allowedOriginRules " + str + " is invalid");
                    }
                    if (host.startsWith("[")) {
                        if (!host.endsWith("]")) {
                            throw new Exception("allowedOriginRules " + str + " is invalid");
                        }
                        if (!Util.isIPv6(host.substring(1, host.length() - 1))) {
                            throw new Exception("allowedOriginRules " + str + " is invalid");
                        }
                    }
                }
                i++;
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        WebMessageListenerChannelDelegate webMessageListenerChannelDelegate = this.channelDelegate;
        if (webMessageListenerChannelDelegate != null) {
            webMessageListenerChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.listener = null;
        this.replyProxy = null;
        this.webView = null;
    }

    public void initJsInstance() {
        String sb;
        if (this.webView != null) {
            String replaceAll = Util.replaceAll(this.jsObjectName, "'", "\\'");
            ArrayList arrayList = new ArrayList();
            for (String str : this.allowedOriginRules) {
                if (ProxyConfig.MATCH_ALL_SCHEMES.equals(str)) {
                    sb = "'*'";
                } else {
                    Uri parse = Uri.parse(str);
                    String str2 = parse.getHost() != null ? "'" + Util.replaceAll(parse.getHost(), "'", "\\'") + "'" : "null";
                    StringBuilder sb2 = new StringBuilder("{scheme: '");
                    sb2.append(parse.getScheme());
                    sb2.append("', host: ");
                    sb2.append(str2);
                    sb2.append(", port: ");
                    sb2.append(parse.getPort() != -1 ? Integer.valueOf(parse.getPort()) : "null");
                    sb2.append("}");
                    sb = sb2.toString();
                }
                arrayList.add(sb);
            }
            this.webView.getUserContentController().addPluginScript(new PluginScript("WebMessageListener-" + this.jsObjectName, "(function() {  var allowedOriginRules = [" + TextUtils.join(", ", arrayList) + "];  var isPageBlank = window.location.href === 'about:blank';  var scheme = !isPageBlank ? window.location.protocol.replace(':', '') : null;  var host = !isPageBlank ? window.location.hostname : null;  var port = !isPageBlank ? window.location.port : null;  if (window.flutter_inappwebview._isOriginAllowed(allowedOriginRules, scheme, host, port)) {      window['" + replaceAll + "'] = new FlutterInAppWebViewWebMessageListener('" + replaceAll + "');  }})();", UserScriptInjectionTime.AT_DOCUMENT_START, null, false, null));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:17|(2:72|(1:74)(1:75))(1:21)|(2:69|(1:71))(1:24)|25|(8:29|30|31|32|33|(1:63)(1:48)|(1:50)|(2:56|57))|68|31|32|33|(1:35)|63|(0)|(1:62)(4:52|54|56|57)) */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isOriginAllowed(String str, String str2, int i) {
        String str3;
        boolean equals;
        Iterator<String> it = this.allowedOriginRules.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            String next = it.next();
            if (ProxyConfig.MATCH_ALL_SCHEMES.equals(next)) {
                return true;
            }
            if (str != null && !str.isEmpty() && (!str.isEmpty() || ((str2 != null && !str2.isEmpty()) || (i != 0 && i != -1)))) {
                Uri parse = Uri.parse(next);
                int i2 = 443;
                int port = (parse.getPort() == -1 || parse.getPort() == 0) ? ProxyConfig.MATCH_HTTPS.equals(parse.getScheme()) ? 443 : 80 : parse.getPort();
                if (i != 0 && i != -1) {
                    i2 = i;
                } else if (!ProxyConfig.MATCH_HTTPS.equals(str)) {
                    i2 = 80;
                }
                String str4 = null;
                if (parse.getHost() != null && parse.getHost().startsWith("[")) {
                    try {
                        str3 = Util.normalizeIPv6(parse.getHost().substring(1, parse.getHost().length() - 1));
                    } catch (Exception unused) {
                    }
                    str4 = Util.normalizeIPv6(str2);
                    equals = parse.getScheme().equals(str);
                    boolean z = parse.getHost() != null || parse.getHost().isEmpty() || parse.getHost().equals(str2) || (parse.getHost().startsWith(ProxyConfig.MATCH_ALL_SCHEMES) && str2 != null && str2.contains(parse.getHost().split("\\*")[1])) || !(str4 == null || str3 == null || !str4.equals(str3));
                    boolean z2 = port == i2;
                    if (equals && z && z2) {
                        return true;
                    }
                }
                str3 = null;
                str4 = Util.normalizeIPv6(str2);
                equals = parse.getScheme().equals(str);
                if (parse.getHost() != null) {
                }
                if (port == i2) {
                }
                if (equals) {
                    return true;
                }
                continue;
            }
        }
    }

    public void postMessageForInAppWebView(WebMessageCompatExt webMessageCompatExt, MethodChannel.Result result) {
        Object data;
        if (this.replyProxy != null && WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER") && (data = webMessageCompatExt.getData()) != null) {
            if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_ARRAY_BUFFER") && webMessageCompatExt.getType() == 1) {
                this.replyProxy.postMessage((byte[]) data);
            } else {
                this.replyProxy.postMessage(data.toString());
            }
        }
        result.success(Boolean.TRUE);
    }
}
