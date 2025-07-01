package io.flutter.plugins.webviewflutter;

import android.webkit.PermissionRequest;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class PermissionRequestProxyApi extends PigeonApiPermissionRequest {
    public PermissionRequestProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiPermissionRequest
    public List<String> resources(PermissionRequest permissionRequest) {
        return Arrays.asList(permissionRequest.getResources());
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiPermissionRequest
    public void grant(PermissionRequest permissionRequest, List<String> list) {
        permissionRequest.grant((String[]) list.toArray(new String[0]));
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiPermissionRequest
    public void deny(PermissionRequest permissionRequest) {
        permissionRequest.deny();
    }
}
