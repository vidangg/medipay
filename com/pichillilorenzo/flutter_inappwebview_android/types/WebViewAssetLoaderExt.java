package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.content.Context;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.WebViewAssetLoader;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class WebViewAssetLoaderExt implements Disposable {
    public List<PathHandlerExt> customPathHandlers;
    public WebViewAssetLoader loader;

    /* loaded from: classes4.dex */
    public static class PathHandlerExt implements WebViewAssetLoader.PathHandler, Disposable {
        protected static final String LOG_TAG = "PathHandlerExt";
        public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_custompathhandler_";
        public PathHandlerExtChannelDelegate channelDelegate;
        public String id;

        public PathHandlerExt(String str, InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
            this.id = str;
            this.channelDelegate = new PathHandlerExtChannelDelegate(this, new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME_PREFIX + str));
        }

        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
        public void dispose() {
            PathHandlerExtChannelDelegate pathHandlerExtChannelDelegate = this.channelDelegate;
            if (pathHandlerExtChannelDelegate != null) {
                pathHandlerExtChannelDelegate.dispose();
                this.channelDelegate = null;
            }
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        public WebResourceResponse handle(String str) {
            PathHandlerExtChannelDelegate pathHandlerExtChannelDelegate = this.channelDelegate;
            if (pathHandlerExtChannelDelegate != null) {
                try {
                    WebResourceResponseExt handle = pathHandlerExtChannelDelegate.handle(str);
                    if (handle != null) {
                        String contentType = handle.getContentType();
                        String contentEncoding = handle.getContentEncoding();
                        byte[] data = handle.getData();
                        Map<String, String> headers = handle.getHeaders();
                        Integer statusCode = handle.getStatusCode();
                        String reasonPhrase = handle.getReasonPhrase();
                        ByteArrayInputStream byteArrayInputStream = data != null ? new ByteArrayInputStream(data) : null;
                        return (statusCode == null || reasonPhrase == null) ? new WebResourceResponse(contentType, contentEncoding, byteArrayInputStream) : new WebResourceResponse(contentType, contentEncoding, statusCode.intValue(), reasonPhrase, headers, byteArrayInputStream);
                    }
                } catch (InterruptedException e) {
                    Log.e(LOG_TAG, "", e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class PathHandlerExtChannelDelegate extends ChannelDelegateImpl {
        private PathHandlerExt pathHandler;

        /* loaded from: classes4.dex */
        public static class HandleCallback extends BaseCallbackResultImpl<WebResourceResponseExt> {
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public WebResourceResponseExt decodeResult(Object obj) {
                return WebResourceResponseExt.fromMap((Map) obj);
            }
        }

        /* loaded from: classes4.dex */
        public static class SyncHandleCallback extends SyncBaseCallbackResultImpl<WebResourceResponseExt> {
            @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
            public WebResourceResponseExt decodeResult(Object obj) {
                return new HandleCallback().decodeResult(obj);
            }
        }

        public PathHandlerExtChannelDelegate(PathHandlerExt pathHandlerExt, MethodChannel methodChannel) {
            super(methodChannel);
            this.pathHandler = pathHandlerExt;
        }

        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
        public void dispose() {
            super.dispose();
            this.pathHandler = null;
        }

        public WebResourceResponseExt handle(String str) {
            MethodChannel channel = getChannel();
            if (channel == null) {
                return null;
            }
            SyncHandleCallback syncHandleCallback = new SyncHandleCallback();
            HashMap hashMap = new HashMap();
            hashMap.put("path", str);
            return (WebResourceResponseExt) Util.invokeMethodAndWaitResult(channel, "handle", hashMap, syncHandleCallback);
        }

        public void handle(String str, HandleCallback handleCallback) {
            MethodChannel channel = getChannel();
            if (channel == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("path", str);
            channel.invokeMethod("handle", hashMap, handleCallback);
        }
    }

    public WebViewAssetLoaderExt(WebViewAssetLoader webViewAssetLoader, List<PathHandlerExt> list) {
        this.loader = webViewAssetLoader;
        this.customPathHandlers = list;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0069. Please report as an issue. */
    public static WebViewAssetLoaderExt fromMap(Map<String, Object> map, InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, Context context) {
        WebViewAssetLoader.PathHandler resourcesPathHandler;
        if (map == null) {
            return null;
        }
        WebViewAssetLoader.Builder builder = new WebViewAssetLoader.Builder();
        String str = (String) map.get("domain");
        Boolean bool = (Boolean) map.get("httpAllowed");
        List<Map> list = (List) map.get("pathHandlers");
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            builder.setDomain(str);
        }
        if (bool != null) {
            builder.setHttpAllowed(bool.booleanValue());
        }
        if (list != null) {
            for (Map map2 : list) {
                String str2 = (String) map2.get(SessionDescription.ATTR_TYPE);
                String str3 = (String) map2.get("path");
                if (str2 != null && str3 != null) {
                    str2.hashCode();
                    char c = 65535;
                    switch (str2.hashCode()) {
                        case -1506882528:
                            if (str2.equals("ResourcesPathHandler")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -667829310:
                            if (str2.equals("AssetsPathHandler")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1490480039:
                            if (str2.equals("InternalStoragePathHandler")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            resourcesPathHandler = new WebViewAssetLoader.ResourcesPathHandler(context);
                            break;
                        case 1:
                            resourcesPathHandler = new WebViewAssetLoader.AssetsPathHandler(context);
                            break;
                        case 2:
                            String str4 = (String) map2.get("directory");
                            if (str4 == null) {
                                break;
                            } else {
                                resourcesPathHandler = new WebViewAssetLoader.InternalStoragePathHandler(context, new File(str4));
                                break;
                            }
                        default:
                            String str5 = (String) map2.get(TtmlNode.ATTR_ID);
                            if (str5 != null) {
                                PathHandlerExt pathHandlerExt = new PathHandlerExt(str5, inAppWebViewFlutterPlugin);
                                builder.addPathHandler(str3, pathHandlerExt);
                                arrayList.add(pathHandlerExt);
                                break;
                            } else {
                                continue;
                            }
                    }
                    builder.addPathHandler(str3, resourcesPathHandler);
                }
            }
        }
        return new WebViewAssetLoaderExt(builder.build(), arrayList);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        Iterator<PathHandlerExt> it = this.customPathHandlers.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
        this.customPathHandlers.clear();
    }
}
