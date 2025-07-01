package paua;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;

/* loaded from: classes4.dex */
public class wvg {
    public static X509TrustManager spxyeh = new cmx();

    public static Interceptor doaq() {
        return new onepv((cmx) spxyeh);
    }

    public static SSLSocketFactory lgbhp() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new X509TrustManager[]{spxyeh}, null);
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static X509TrustManager mtnlyf() {
        return spxyeh;
    }
}
