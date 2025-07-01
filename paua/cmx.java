package paua;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class cmx implements X509TrustManager {
    public ThreadLocal<String> iirh;
    public X509TrustManagerExtensions ndrde;

    public cmx() {
        this.iirh = new ThreadLocal<>();
        this.ndrde = btj.qqcikh();
    }

    public cmx(String str) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        this.iirh = threadLocal;
        threadLocal.set(str);
        this.ndrde = btj.qqcikh();
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        btj.ghrqkn(x509CertificateArr, str, this.iirh.get(), this.ndrde);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        btj.wwiqty(x509CertificateArr, str, this.iirh.get(), this.ndrde);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return btj.svttu();
    }

    public void uzp(String str) {
        this.iirh.set(str);
    }
}
