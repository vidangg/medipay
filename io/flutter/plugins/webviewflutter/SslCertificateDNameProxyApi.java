package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;

/* loaded from: classes4.dex */
class SslCertificateDNameProxyApi extends PigeonApiSslCertificateDName {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SslCertificateDNameProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getCName(SslCertificate.DName dName) {
        return dName.getCName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getDName(SslCertificate.DName dName) {
        return dName.getDName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getOName(SslCertificate.DName dName) {
        return dName.getOName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    public String getUName(SslCertificate.DName dName) {
        return dName.getUName();
    }
}
