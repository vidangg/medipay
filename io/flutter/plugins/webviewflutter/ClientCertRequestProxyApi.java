package io.flutter.plugins.webviewflutter;

import android.webkit.ClientCertRequest;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* loaded from: classes4.dex */
class ClientCertRequestProxyApi extends PigeonApiClientCertRequest {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCertRequestProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiClientCertRequest
    public void cancel(ClientCertRequest clientCertRequest) {
        clientCertRequest.cancel();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiClientCertRequest
    public void ignore(ClientCertRequest clientCertRequest) {
        clientCertRequest.ignore();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiClientCertRequest
    public void proceed(ClientCertRequest clientCertRequest, PrivateKey privateKey, List<? extends X509Certificate> list) {
        clientCertRequest.proceed(privateKey, (X509Certificate[]) list.toArray(new X509Certificate[0]));
    }
}
