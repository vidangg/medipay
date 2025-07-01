package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import android.util.Log;
import java.security.cert.X509Certificate;
import java.util.Date;

/* loaded from: classes4.dex */
class SslCertificateProxyApi extends PigeonApiSslCertificate {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SslCertificateProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificate
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificate
    public SslCertificate.DName getIssuedBy(SslCertificate sslCertificate) {
        return sslCertificate.getIssuedBy();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificate
    public SslCertificate.DName getIssuedTo(SslCertificate sslCertificate) {
        return sslCertificate.getIssuedTo();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificate
    public Long getValidNotAfterMsSinceEpoch(SslCertificate sslCertificate) {
        Date validNotAfterDate = sslCertificate.getValidNotAfterDate();
        if (validNotAfterDate != null) {
            return Long.valueOf(validNotAfterDate.getTime());
        }
        return null;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificate
    public Long getValidNotBeforeMsSinceEpoch(SslCertificate sslCertificate) {
        Date validNotBeforeDate = sslCertificate.getValidNotBeforeDate();
        if (validNotBeforeDate != null) {
            return Long.valueOf(validNotBeforeDate.getTime());
        }
        return null;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificate
    public X509Certificate getX509Certificate(SslCertificate sslCertificate) {
        X509Certificate x509Certificate;
        if (getPigeonRegistrar().sdkIsAtLeast(29)) {
            x509Certificate = sslCertificate.getX509Certificate();
            return x509Certificate;
        }
        Log.d("SslCertificateProxyApi", getPigeonRegistrar().createUnsupportedVersionMessage("SslCertificate.getX509Certificate", "Build.VERSION_CODES.Q"));
        return null;
    }
}
