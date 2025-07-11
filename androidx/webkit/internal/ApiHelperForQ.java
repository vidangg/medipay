package androidx.webkit.internal;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    @Deprecated
    public static void setForceDark(WebSettings webSettings, int i) {
        webSettings.setForceDark(i);
    }

    @Deprecated
    public static int getForceDark(WebSettings webSettings) {
        int forceDark;
        forceDark = webSettings.getForceDark();
        return forceDark;
    }

    public static WebViewRenderProcess getWebViewRenderProcess(WebView webView) {
        WebViewRenderProcess webViewRenderProcess;
        webViewRenderProcess = webView.getWebViewRenderProcess();
        return webViewRenderProcess;
    }

    public static boolean terminate(WebViewRenderProcess webViewRenderProcess) {
        boolean terminate;
        terminate = webViewRenderProcess.terminate();
        return terminate;
    }

    public static void setWebViewRenderProcessClient(WebView webView, Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        webView.setWebViewRenderProcessClient(executor, webViewRenderProcessClient != null ? new WebViewRenderProcessClientFrameworkAdapter(webViewRenderProcessClient) : null);
    }

    public static void setWebViewRenderProcessClient(WebView webView, WebViewRenderProcessClient webViewRenderProcessClient) {
        webView.setWebViewRenderProcessClient(webViewRenderProcessClient != null ? new WebViewRenderProcessClientFrameworkAdapter(webViewRenderProcessClient) : null);
    }

    public static android.webkit.WebViewRenderProcessClient getWebViewRenderProcessClient(WebView webView) {
        android.webkit.WebViewRenderProcessClient webViewRenderProcessClient;
        webViewRenderProcessClient = webView.getWebViewRenderProcessClient();
        return webViewRenderProcessClient;
    }
}
