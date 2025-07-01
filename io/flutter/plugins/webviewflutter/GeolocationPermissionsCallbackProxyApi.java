package io.flutter.plugins.webviewflutter;

import android.webkit.GeolocationPermissions;

/* loaded from: classes4.dex */
public class GeolocationPermissionsCallbackProxyApi extends PigeonApiGeolocationPermissionsCallback {
    public GeolocationPermissionsCallbackProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiGeolocationPermissionsCallback
    public void invoke(GeolocationPermissions.Callback callback, String str, boolean z, boolean z2) {
        callback.invoke(str, z, z2);
    }
}
