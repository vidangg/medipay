package com.pichillilorenzo.flutter_inappwebview_android.service_worker;

import androidx.webkit.ServiceWorkerControllerCompat;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.SyncBaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

/* loaded from: classes4.dex */
public class ServiceWorkerChannelDelegate extends ChannelDelegateImpl {
    private ServiceWorkerManager serviceWorkerManager;

    /* loaded from: classes4.dex */
    public static class ShouldInterceptRequestCallback extends BaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return WebResourceResponseExt.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class SyncShouldInterceptRequestCallback extends SyncBaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return new ShouldInterceptRequestCallback().decodeResult(obj);
        }
    }

    public ServiceWorkerChannelDelegate(ServiceWorkerManager serviceWorkerManager, MethodChannel methodChannel) {
        super(methodChannel);
        this.serviceWorkerManager = serviceWorkerManager;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.serviceWorkerManager = null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x008f. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        boolean allowContentAccess;
        Object valueOf;
        ServiceWorkerManager.init();
        ServiceWorkerControllerCompat serviceWorkerControllerCompat = ServiceWorkerManager.serviceWorkerController;
        ServiceWorkerWebSettingsCompat serviceWorkerWebSettings = serviceWorkerControllerCompat != null ? serviceWorkerControllerCompat.getServiceWorkerWebSettings() : null;
        String str = methodCall.method;
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1332730774:
                if (str.equals("getAllowContentAccess")) {
                    c = 0;
                    break;
                }
                break;
            case -1165005700:
                if (str.equals("setServiceWorkerClient")) {
                    c = 1;
                    break;
                }
                break;
            case -563397233:
                if (str.equals("getCacheMode")) {
                    c = 2;
                    break;
                }
                break;
            case 674894835:
                if (str.equals("getAllowFileAccess")) {
                    c = 3;
                    break;
                }
                break;
            case 985595395:
                if (str.equals("setCacheMode")) {
                    c = 4;
                    break;
                }
                break;
            case 1083898794:
                if (str.equals("setBlockNetworkLoads")) {
                    c = 5;
                    break;
                }
                break;
            case 1203480182:
                if (str.equals("setAllowContentAccess")) {
                    c = 6;
                    break;
                }
                break;
            case 1594928487:
                if (str.equals("setAllowFileAccess")) {
                    c = 7;
                    break;
                }
                break;
            case 1694822198:
                if (str.equals("getBlockNetworkLoads")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (serviceWorkerWebSettings != null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_CONTENT_ACCESS")) {
                    allowContentAccess = serviceWorkerWebSettings.getAllowContentAccess();
                    valueOf = Boolean.valueOf(allowContentAccess);
                    result.success(valueOf);
                    return;
                }
                valueOf = Boolean.FALSE;
                result.success(valueOf);
                return;
            case 1:
                if (this.serviceWorkerManager != null) {
                    this.serviceWorkerManager.setServiceWorkerClient((Boolean) methodCall.argument("isNull"));
                    valueOf = Boolean.TRUE;
                    result.success(valueOf);
                    return;
                }
                valueOf = Boolean.FALSE;
                result.success(valueOf);
                return;
            case 2:
                if (serviceWorkerWebSettings == null || !WebViewFeature.isFeatureSupported("SERVICE_WORKER_CACHE_MODE")) {
                    result.success(null);
                    return;
                } else {
                    valueOf = Integer.valueOf(serviceWorkerWebSettings.getCacheMode());
                    result.success(valueOf);
                    return;
                }
            case 3:
                if (serviceWorkerWebSettings != null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_FILE_ACCESS")) {
                    allowContentAccess = serviceWorkerWebSettings.getAllowFileAccess();
                    valueOf = Boolean.valueOf(allowContentAccess);
                    result.success(valueOf);
                    return;
                }
                valueOf = Boolean.FALSE;
                result.success(valueOf);
                return;
            case 4:
                if (serviceWorkerWebSettings != null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_CACHE_MODE")) {
                    serviceWorkerWebSettings.setCacheMode(((Integer) methodCall.argument("mode")).intValue());
                }
                valueOf = Boolean.TRUE;
                result.success(valueOf);
                return;
            case 5:
                if (serviceWorkerWebSettings != null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_BLOCK_NETWORK_LOADS")) {
                    serviceWorkerWebSettings.setBlockNetworkLoads(((Boolean) methodCall.argument("flag")).booleanValue());
                }
                valueOf = Boolean.TRUE;
                result.success(valueOf);
                return;
            case 6:
                if (serviceWorkerWebSettings != null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_CONTENT_ACCESS")) {
                    serviceWorkerWebSettings.setAllowContentAccess(((Boolean) methodCall.argument("allow")).booleanValue());
                }
                valueOf = Boolean.TRUE;
                result.success(valueOf);
                return;
            case 7:
                if (serviceWorkerWebSettings != null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_FILE_ACCESS")) {
                    serviceWorkerWebSettings.setAllowFileAccess(((Boolean) methodCall.argument("allow")).booleanValue());
                }
                valueOf = Boolean.TRUE;
                result.success(valueOf);
                return;
            case '\b':
                if (serviceWorkerWebSettings != null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_BLOCK_NETWORK_LOADS")) {
                    allowContentAccess = serviceWorkerWebSettings.getBlockNetworkLoads();
                    valueOf = Boolean.valueOf(allowContentAccess);
                    result.success(valueOf);
                    return;
                }
                valueOf = Boolean.FALSE;
                result.success(valueOf);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public WebResourceResponseExt shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return null;
        }
        return (WebResourceResponseExt) Util.invokeMethodAndWaitResult(channel, "shouldInterceptRequest", webResourceRequestExt.toMap(), new SyncShouldInterceptRequestCallback());
    }

    public void shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt, ShouldInterceptRequestCallback shouldInterceptRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("shouldInterceptRequest", webResourceRequestExt.toMap(), shouldInterceptRequestCallback);
    }
}
