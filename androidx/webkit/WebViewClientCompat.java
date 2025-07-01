package androidx.webkit;

import android.app.PendingIntent;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.SafeBrowsingResponseImpl;
import androidx.webkit.internal.WebResourceErrorImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;

/* loaded from: classes3.dex */
public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SafeBrowsingThreat {
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onPageCommitVisible(WebView webView, String str) {
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public boolean onWebAuthnIntent(WebView webView, PendingIntent pendingIntent, InvocationHandler invocationHandler) {
        return false;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, InvocationHandler invocationHandler) {
        onReceivedError(webView, webResourceRequest, new WebResourceErrorImpl(invocationHandler));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        onReceivedError(webView, webResourceRequest, new WebResourceErrorImpl(webResourceError));
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorCompat webResourceErrorCompat) {
        if (WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_CODE") && WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_DESCRIPTION") && webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, webResourceErrorCompat.getErrorCode(), webResourceErrorCompat.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, InvocationHandler invocationHandler) {
        onSafeBrowsingHit(webView, webResourceRequest, i, new SafeBrowsingResponseImpl(invocationHandler));
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        onSafeBrowsingHit(webView, webResourceRequest, i, new SafeBrowsingResponseImpl(safeBrowsingResponse));
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponseCompat safeBrowsingResponseCompat) {
        if (WebViewFeature.isFeatureSupported("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
            safeBrowsingResponseCompat.showInterstitial(true);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
