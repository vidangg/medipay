package com.pichillilorenzo.flutter_inappwebview_android.content_blocker;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.webkit.ProxyConfig;
import androidx.webkit.internal.AssetHelper;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: classes4.dex */
public class ContentBlockerHandler {
    protected static final String LOG_TAG = "ContentBlockerHandler";
    protected List<ContentBlocker> ruleList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.pichillilorenzo.flutter_inappwebview_android.content_blocker.ContentBlockerHandler$3, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType;

        static {
            int[] iArr = new int[ContentBlockerActionType.values().length];
            $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType = iArr;
            try {
                iArr[ContentBlockerActionType.BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType[ContentBlockerActionType.CSS_DISPLAY_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType[ContentBlockerActionType.MAKE_HTTPS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ContentBlockerHandler() {
        this.ruleList = new ArrayList();
    }

    public WebResourceResponse checkUrl(InAppWebView inAppWebView, WebResourceRequestExt webResourceRequestExt) {
        return checkUrl(inAppWebView, webResourceRequestExt, getResourceTypeFromUrl(webResourceRequestExt));
    }

    public ContentBlockerTriggerResourceType getResourceTypeFromContentType(String str) {
        return str.equals("text/css") ? ContentBlockerTriggerResourceType.STYLE_SHEET : str.equals("image/svg+xml") ? ContentBlockerTriggerResourceType.SVG_DOCUMENT : str.startsWith("image/") ? ContentBlockerTriggerResourceType.IMAGE : str.startsWith("font/") ? ContentBlockerTriggerResourceType.FONT : (str.startsWith("audio/") || str.startsWith("video/") || str.equals("application/ogg")) ? ContentBlockerTriggerResourceType.MEDIA : str.endsWith("javascript") ? ContentBlockerTriggerResourceType.SCRIPT : str.startsWith("text/") ? ContentBlockerTriggerResourceType.DOCUMENT : ContentBlockerTriggerResourceType.RAW;
    }

    public ContentBlockerTriggerResourceType getResourceTypeFromUrl(WebResourceRequestExt webResourceRequestExt) {
        HttpURLConnection makeHttpRequest;
        ContentBlockerTriggerResourceType contentBlockerTriggerResourceType = ContentBlockerTriggerResourceType.RAW;
        String url = webResourceRequestExt.getUrl();
        if ((url.startsWith("http://") || url.startsWith("https://")) && (makeHttpRequest = Util.makeHttpRequest(url, "HEAD", webResourceRequestExt.getHeaders())) != null) {
            try {
                try {
                    String contentType = makeHttpRequest.getContentType();
                    if (contentType != null) {
                        contentBlockerTriggerResourceType = getResourceTypeFromContentType(contentType.split(";")[0].trim());
                    }
                } catch (Exception e) {
                    Log.e(LOG_TAG, "", e);
                }
            } finally {
                makeHttpRequest.disconnect();
            }
        }
        return contentBlockerTriggerResourceType;
    }

    public List<ContentBlocker> getRuleList() {
        return this.ruleList;
    }

    public void setRuleList(List<ContentBlocker> list) {
        this.ruleList = list;
    }

    public ContentBlockerHandler(List<ContentBlocker> list) {
        new ArrayList();
        this.ruleList = list;
    }

    public WebResourceResponse checkUrl(final InAppWebView inAppWebView, WebResourceRequestExt webResourceRequestExt, ContentBlockerTriggerResourceType contentBlockerTriggerResourceType) {
        URI uri;
        Iterator it;
        String str;
        HttpURLConnection makeHttpRequest;
        String trim;
        String str2 = "charset=";
        WebResourceResponse webResourceResponse = null;
        if (inAppWebView.customSettings.contentBlockers == null) {
            return null;
        }
        String url = webResourceRequestExt.getUrl();
        try {
            uri = new URI(url);
        } catch (URISyntaxException unused) {
            String str3 = url.split(":")[0];
            URL url2 = new URL(url.replace(str3, ProxyConfig.MATCH_HTTPS));
            uri = new URI(str3, url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
        }
        String host = uri.getHost();
        int port = uri.getPort();
        String scheme = uri.getScheme();
        Iterator it2 = new CopyOnWriteArrayList(this.ruleList).iterator();
        while (it2.hasNext()) {
            ContentBlocker contentBlocker = (ContentBlocker) it2.next();
            ContentBlockerTrigger trigger = contentBlocker.getTrigger();
            List<ContentBlockerTriggerResourceType> resourceType = trigger.getResourceType();
            if (resourceType.contains(ContentBlockerTriggerResourceType.IMAGE)) {
                ContentBlockerTriggerResourceType contentBlockerTriggerResourceType2 = ContentBlockerTriggerResourceType.SVG_DOCUMENT;
                if (!resourceType.contains(contentBlockerTriggerResourceType2)) {
                    resourceType.add(contentBlockerTriggerResourceType2);
                }
            }
            ContentBlockerAction action = contentBlocker.getAction();
            if (trigger.getUrlFilterPatternCompiled().matcher(url).matches()) {
                if (!resourceType.isEmpty() && !resourceType.contains(contentBlockerTriggerResourceType)) {
                    return webResourceResponse;
                }
                if (!trigger.getIfDomain().isEmpty()) {
                    for (String str4 : trigger.getIfDomain()) {
                        if ((!str4.startsWith(ProxyConfig.MATCH_ALL_SCHEMES) || !host.endsWith(str4.replace(ProxyConfig.MATCH_ALL_SCHEMES, ""))) && !str4.equals(host)) {
                            webResourceResponse = null;
                        }
                    }
                    return webResourceResponse;
                }
                if (!trigger.getUnlessDomain().isEmpty()) {
                    for (String str5 : trigger.getUnlessDomain()) {
                        if ((str5.startsWith(ProxyConfig.MATCH_ALL_SCHEMES) && host.endsWith(str5.replace(ProxyConfig.MATCH_ALL_SCHEMES, ""))) || str5.equals(host)) {
                            return null;
                        }
                    }
                }
                final String[] strArr = new String[1];
                if (!trigger.getLoadType().isEmpty() || !trigger.getIfTopUrl().isEmpty() || !trigger.getUnlessTopUrl().isEmpty()) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    new Handler(inAppWebView.getWebViewLooper()).post(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.content_blocker.ContentBlockerHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            strArr[0] = inAppWebView.getUrl();
                            countDownLatch.countDown();
                        }
                    });
                    countDownLatch.await();
                }
                if (strArr[0] != null) {
                    if (trigger.getLoadType().isEmpty()) {
                        it = it2;
                    } else {
                        URI uri2 = new URI(strArr[0]);
                        String host2 = uri2.getHost();
                        int port2 = uri2.getPort();
                        String scheme2 = uri2.getScheme();
                        it = it2;
                        if (trigger.getLoadType().contains("first-party") && host2 != null && (!scheme2.equals(scheme) || !host2.equals(host) || port2 != port)) {
                            return null;
                        }
                        if (trigger.getLoadType().contains("third-party") && host2 != null && host2.equals(host)) {
                            return null;
                        }
                    }
                    if (!trigger.getIfTopUrl().isEmpty()) {
                        Iterator<String> it3 = trigger.getIfTopUrl().iterator();
                        while (it3.hasNext()) {
                            if (strArr[0].startsWith(it3.next())) {
                            }
                        }
                        return null;
                    }
                    if (!trigger.getUnlessTopUrl().isEmpty()) {
                        Iterator<String> it4 = trigger.getUnlessTopUrl().iterator();
                        while (it4.hasNext()) {
                            if (strArr[0].startsWith(it4.next())) {
                                return null;
                            }
                        }
                    }
                } else {
                    it = it2;
                }
                int i = AnonymousClass3.$SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$content_blocker$ContentBlockerActionType[action.getType().ordinal()];
                if (i == 1) {
                    return new WebResourceResponse("", "", null);
                }
                if (i != 2) {
                    if (i == 3 && scheme.equals(ProxyConfig.MATCH_HTTP) && ((port == -1 || port == 80) && (makeHttpRequest = Util.makeHttpRequest(url.replace("http://", "https://"), webResourceRequestExt.getMethod(), webResourceRequestExt.getHeaders())) != null)) {
                        try {
                            try {
                                byte[] readAllBytes = Util.readAllBytes(makeHttpRequest.getInputStream());
                                if (readAllBytes == null) {
                                    makeHttpRequest.disconnect();
                                    return null;
                                }
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readAllBytes);
                                String contentEncoding = makeHttpRequest.getContentEncoding();
                                String contentType = makeHttpRequest.getContentType();
                                if (contentType == null) {
                                    trim = AssetHelper.DEFAULT_MIME_TYPE;
                                } else {
                                    String[] split = contentType.split(";");
                                    trim = split[0].trim();
                                    if (contentEncoding == null) {
                                        contentEncoding = (split.length <= 1 || !split[1].contains(str2)) ? "utf-8" : split[1].replace(str2, "").trim();
                                    }
                                }
                                String responseMessage = makeHttpRequest.getResponseMessage();
                                if (responseMessage == null) {
                                    return new WebResourceResponse(trim, contentEncoding, byteArrayInputStream);
                                }
                                HashMap hashMap = new HashMap();
                                for (Map.Entry<String, List<String>> entry : makeHttpRequest.getHeaderFields().entrySet()) {
                                    str = str2;
                                    try {
                                        hashMap.put(entry.getKey(), TextUtils.join(",", entry.getValue()));
                                        str2 = str;
                                    } catch (Exception e) {
                                        e = e;
                                        if (!(e instanceof SSLHandshakeException)) {
                                            Log.e(LOG_TAG, "", e);
                                        }
                                        str2 = str;
                                        it2 = it;
                                        webResourceResponse = null;
                                    }
                                }
                                return new WebResourceResponse(trim, contentEncoding, makeHttpRequest.getResponseCode(), responseMessage, hashMap, byteArrayInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                str = str2;
                            }
                        } finally {
                            makeHttpRequest.disconnect();
                        }
                    }
                    it2 = it;
                    webResourceResponse = null;
                } else {
                    str = str2;
                    String selector = action.getSelector();
                    final String str6 = "(function(d) {    function hide () {        if (d.body != null && !d.getElementById('flutter_inappwebview-css-display-none-style')) {            var c = d.createElement('style');            c.id = 'flutter_inappwebview-css-display-none-style';            c.innerHTML = '" + selector + " { display: none !important; }';            d.body.appendChild(c);        }       d.querySelectorAll('" + selector + "').forEach(function (item, index) {            item.setAttribute('style', 'display: none !important;');        });    };    hide();    d.addEventListener('DOMContentLoaded', function(event) { hide(); }); })(document);";
                    new Handler(inAppWebView.getWebViewLooper()).postDelayed(new Runnable() { // from class: com.pichillilorenzo.flutter_inappwebview_android.content_blocker.ContentBlockerHandler.2
                        @Override // java.lang.Runnable
                        public void run() {
                            inAppWebView.evaluateJavascript(str6, null);
                        }
                    }, 800L);
                }
                str2 = str;
                it2 = it;
                webResourceResponse = null;
            }
        }
        return webResourceResponse;
    }

    public WebResourceResponse checkUrl(InAppWebView inAppWebView, WebResourceRequestExt webResourceRequestExt, String str) {
        return checkUrl(inAppWebView, webResourceRequestExt, getResourceTypeFromContentType(str));
    }
}
