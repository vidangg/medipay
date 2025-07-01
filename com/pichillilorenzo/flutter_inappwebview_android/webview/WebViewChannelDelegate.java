package com.pichillilorenzo.flutter_inappwebview_android.webview;

import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserSettings;
import com.pichillilorenzo.flutter_inappwebview_android.print_job.PrintJobSettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.ClientCertChallenge;
import com.pichillilorenzo.flutter_inappwebview_android.types.ClientCertResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.ContentWorld;
import com.pichillilorenzo.flutter_inappwebview_android.types.CreateWindowAction;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomSchemeResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.DownloadStartRequest;
import com.pichillilorenzo.flutter_inappwebview_android.types.GeolocationPermissionShowPromptResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.HitTestResult;
import com.pichillilorenzo.flutter_inappwebview_android.types.HttpAuthResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.HttpAuthenticationChallenge;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsAlertResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsBeforeUnloadResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsConfirmResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.JsPromptResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.NavigationAction;
import com.pichillilorenzo.flutter_inappwebview_android.types.NavigationActionPolicy;
import com.pichillilorenzo.flutter_inappwebview_android.types.PermissionResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.SafeBrowsingResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.ServerTrustAuthResponse;
import com.pichillilorenzo.flutter_inappwebview_android.types.ServerTrustChallenge;
import com.pichillilorenzo.flutter_inappwebview_android.types.SslCertificateExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.SyncBaseCallbackResultImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview_android.types.UserScript;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessageCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePortCompatExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceErrorExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceRequestExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.WebResourceResponseExt;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewSettings;
import com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageChannel;
import com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageListener;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes4.dex */
public class WebViewChannelDelegate extends ChannelDelegateImpl {
    static final String LOG_TAG = "WebViewChannelDelegate";
    private InAppWebView webView;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate$8, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods;

        static {
            int[] iArr = new int[WebViewChannelDelegateMethods.values().length];
            $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods = iArr;
            try {
                iArr[WebViewChannelDelegateMethods.getUrl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getTitle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getProgress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.loadUrl.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.postUrl.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.loadData.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.loadFile.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.evaluateJavascript.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.injectJavascriptFileFromUrl.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.injectCSSCode.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.injectCSSFileFromUrl.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.reload.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.goBack.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canGoBack.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.goForward.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canGoForward.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.goBackOrForward.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canGoBackOrForward.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.stopLoading.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isLoading.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.takeScreenshot.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.setSettings.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getSettings.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.close.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.show.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.hide.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isHidden.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getCopyBackForwardList.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.startSafeBrowsing.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearCache.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearSslPreferences.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.findAll.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.findNext.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearMatches.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.scrollTo.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.scrollBy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pause.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.resume.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pauseTimers.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.resumeTimers.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.printCurrentPage.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getContentHeight.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getContentWidth.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.zoomBy.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getOriginalUrl.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getZoomScale.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getSelectedText.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getHitTestResult.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pageDown.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.pageUp.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.saveWebArchive.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.zoomIn.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.zoomOut.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearFocus.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.setContextMenu.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.requestFocusNodeHref.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.requestImageRef.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getScrollX.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getScrollY.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.getCertificate.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearHistory.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.addUserScript.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.removeUserScript.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.removeUserScriptsByGroupName.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.removeAllUserScripts.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.callAsyncJavaScript.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isSecureContext.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.createWebMessageChannel.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.postWebMessage.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.addWebMessageListener.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canScrollVertically.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.canScrollHorizontally.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.isInFullscreen.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.clearFormData.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class CallJsHandlerCallback extends BaseCallbackResultImpl<Object> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Object decodeResult(Object obj) {
            return obj;
        }
    }

    /* loaded from: classes4.dex */
    public static class CreateWindowCallback extends BaseCallbackResultImpl<Boolean> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Boolean decodeResult(Object obj) {
            return Boolean.valueOf((obj instanceof Boolean) && ((Boolean) obj).booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    public static class FormResubmissionCallback extends BaseCallbackResultImpl<Integer> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Integer decodeResult(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class GeolocationPermissionsShowPromptCallback extends BaseCallbackResultImpl<GeolocationPermissionShowPromptResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public GeolocationPermissionShowPromptResponse decodeResult(Object obj) {
            return GeolocationPermissionShowPromptResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class JsAlertCallback extends BaseCallbackResultImpl<JsAlertResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsAlertResponse decodeResult(Object obj) {
            return JsAlertResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class JsBeforeUnloadCallback extends BaseCallbackResultImpl<JsBeforeUnloadResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsBeforeUnloadResponse decodeResult(Object obj) {
            return JsBeforeUnloadResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class JsConfirmCallback extends BaseCallbackResultImpl<JsConfirmResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsConfirmResponse decodeResult(Object obj) {
            return JsConfirmResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class JsPromptCallback extends BaseCallbackResultImpl<JsPromptResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public JsPromptResponse decodeResult(Object obj) {
            return JsPromptResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class LoadResourceWithCustomSchemeCallback extends BaseCallbackResultImpl<CustomSchemeResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public CustomSchemeResponse decodeResult(Object obj) {
            return CustomSchemeResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class PermissionRequestCallback extends BaseCallbackResultImpl<PermissionResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public PermissionResponse decodeResult(Object obj) {
            return PermissionResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class PrintRequestCallback extends BaseCallbackResultImpl<Boolean> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Boolean decodeResult(Object obj) {
            return Boolean.valueOf((obj instanceof Boolean) && ((Boolean) obj).booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    public static class ReceivedClientCertRequestCallback extends BaseCallbackResultImpl<ClientCertResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public ClientCertResponse decodeResult(Object obj) {
            return ClientCertResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class ReceivedHttpAuthRequestCallback extends BaseCallbackResultImpl<HttpAuthResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public HttpAuthResponse decodeResult(Object obj) {
            return HttpAuthResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class ReceivedServerTrustAuthRequestCallback extends BaseCallbackResultImpl<ServerTrustAuthResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public ServerTrustAuthResponse decodeResult(Object obj) {
            return ServerTrustAuthResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class RenderProcessResponsiveCallback extends BaseCallbackResultImpl<Integer> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Integer decodeResult(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class RenderProcessUnresponsiveCallback extends BaseCallbackResultImpl<Integer> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public Integer decodeResult(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class SafeBrowsingHitCallback extends BaseCallbackResultImpl<SafeBrowsingResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public SafeBrowsingResponse decodeResult(Object obj) {
            return SafeBrowsingResponse.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class ShouldInterceptRequestCallback extends BaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return WebResourceResponseExt.fromMap((Map) obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class ShouldOverrideUrlLoadingCallback extends BaseCallbackResultImpl<NavigationActionPolicy> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public NavigationActionPolicy decodeResult(Object obj) {
            return NavigationActionPolicy.fromValue(obj instanceof Integer ? ((Integer) obj).intValue() : NavigationActionPolicy.CANCEL.rawValue());
        }
    }

    /* loaded from: classes4.dex */
    public static class SyncLoadResourceWithCustomSchemeCallback extends SyncBaseCallbackResultImpl<CustomSchemeResponse> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public CustomSchemeResponse decodeResult(Object obj) {
            return new LoadResourceWithCustomSchemeCallback().decodeResult(obj);
        }
    }

    /* loaded from: classes4.dex */
    public static class SyncShouldInterceptRequestCallback extends SyncBaseCallbackResultImpl<WebResourceResponseExt> {
        @Override // com.pichillilorenzo.flutter_inappwebview_android.types.BaseCallbackResultImpl, com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
        public WebResourceResponseExt decodeResult(Object obj) {
            return new ShouldInterceptRequestCallback().decodeResult(obj);
        }
    }

    public WebViewChannelDelegate(InAppWebView inAppWebView, MethodChannel methodChannel) {
        super(methodChannel);
        this.webView = inAppWebView;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.webView = null;
    }

    public void onCallJsHandler(String str, String str2, CallJsHandlerCallback callJsHandlerCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            callJsHandlerCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("handlerName", str);
        hashMap.put("args", str2);
        channel.invokeMethod("onCallJsHandler", hashMap, callJsHandlerCallback);
    }

    public void onCloseWindow() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onCloseWindow", new HashMap());
    }

    public void onConsoleMessage(String str, int i) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constant.PARAM_ERROR_MESSAGE, str);
        hashMap.put("messageLevel", Integer.valueOf(i));
        channel.invokeMethod("onConsoleMessage", hashMap);
    }

    public void onContextMenuActionItemClicked(int i, String str) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TtmlNode.ATTR_ID, Integer.valueOf(i));
        hashMap.put("androidId", Integer.valueOf(i));
        hashMap.put("iosId", null);
        hashMap.put("title", str);
        channel.invokeMethod("onContextMenuActionItemClicked", hashMap);
    }

    public void onCreateContextMenu(HitTestResult hitTestResult) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onCreateContextMenu", hitTestResult.toMap());
    }

    public void onCreateWindow(CreateWindowAction createWindowAction, CreateWindowCallback createWindowCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            createWindowCallback.defaultBehaviour(null);
        } else {
            channel.invokeMethod("onCreateWindow", createWindowAction.toMap(), createWindowCallback);
        }
    }

    public void onDownloadStartRequest(DownloadStartRequest downloadStartRequest) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onDownloadStartRequest", downloadStartRequest.toMap());
    }

    public void onEnterFullscreen() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onEnterFullscreen", new HashMap());
    }

    public void onExitFullscreen() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onExitFullscreen", new HashMap());
    }

    @Deprecated
    public void onFindResultReceived(int i, int i2, boolean z) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("activeMatchOrdinal", Integer.valueOf(i));
        hashMap.put("numberOfMatches", Integer.valueOf(i2));
        hashMap.put("isDoneCounting", Boolean.valueOf(z));
        channel.invokeMethod("onFindResultReceived", hashMap);
    }

    public void onFormResubmission(String str, FormResubmissionCallback formResubmissionCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            formResubmissionCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        channel.invokeMethod("onFormResubmission", hashMap, formResubmissionCallback);
    }

    public void onGeolocationPermissionsHidePrompt() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onGeolocationPermissionsHidePrompt", new HashMap());
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsShowPromptCallback geolocationPermissionsShowPromptCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            geolocationPermissionsShowPromptCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("origin", str);
        channel.invokeMethod("onGeolocationPermissionsShowPrompt", hashMap, geolocationPermissionsShowPromptCallback);
    }

    public void onHideContextMenu() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onHideContextMenu", new HashMap());
    }

    public void onJsAlert(String str, String str2, Boolean bool, JsAlertCallback jsAlertCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            jsAlertCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put(Constant.PARAM_ERROR_MESSAGE, str2);
        hashMap.put("isMainFrame", bool);
        channel.invokeMethod("onJsAlert", hashMap, jsAlertCallback);
    }

    public void onJsBeforeUnload(String str, String str2, JsBeforeUnloadCallback jsBeforeUnloadCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            jsBeforeUnloadCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put(Constant.PARAM_ERROR_MESSAGE, str2);
        channel.invokeMethod("onJsBeforeUnload", hashMap, jsBeforeUnloadCallback);
    }

    public void onJsConfirm(String str, String str2, Boolean bool, JsConfirmCallback jsConfirmCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            jsConfirmCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put(Constant.PARAM_ERROR_MESSAGE, str2);
        hashMap.put("isMainFrame", bool);
        channel.invokeMethod("onJsConfirm", hashMap, jsConfirmCallback);
    }

    public void onJsPrompt(String str, String str2, String str3, Boolean bool, JsPromptCallback jsPromptCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            jsPromptCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put(Constant.PARAM_ERROR_MESSAGE, str2);
        hashMap.put("defaultValue", str3);
        hashMap.put("isMainFrame", bool);
        channel.invokeMethod("onJsPrompt", hashMap, jsPromptCallback);
    }

    public CustomSchemeResponse onLoadResourceWithCustomScheme(WebResourceRequestExt webResourceRequestExt) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        return (CustomSchemeResponse) Util.invokeMethodAndWaitResult(channel, "onLoadResourceWithCustomScheme", hashMap, new SyncLoadResourceWithCustomSchemeCallback());
    }

    public void onLoadStart(String str) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        channel.invokeMethod("onLoadStart", hashMap);
    }

    public void onLoadStop(String str) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        channel.invokeMethod("onLoadStop", hashMap);
    }

    public void onLongPressHitTestResult(HitTestResult hitTestResult) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onLongPressHitTestResult", hitTestResult.toMap());
    }

    /* JADX WARN: Code restructure failed: missing block: B:265:0x052e, code lost:
    
        if (r0.isLoading() != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x054d, code lost:
    
        if (r3.canGoBackOrForward(((java.lang.Integer) r17.argument("steps")).intValue()) != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x056c, code lost:
    
        if (r0.canGoForward() != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0581, code lost:
    
        if (r0.canGoBack() != false) goto L272;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x002a. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        boolean z;
        Object valueOf;
        boolean z2;
        int contentHeight;
        InAppWebView inAppWebView;
        WebMessageCompat webMessageCompat;
        Uri parse;
        try {
            boolean z3 = true;
            Object obj = null;
            try {
                switch (AnonymousClass8.$SwitchMap$com$pichillilorenzo$flutter_inappwebview_android$webview$WebViewChannelDelegateMethods[WebViewChannelDelegateMethods.valueOf(methodCall.method).ordinal()]) {
                    case 1:
                        InAppWebView inAppWebView2 = this.webView;
                        if (inAppWebView2 != null) {
                            obj = inAppWebView2.getUrl();
                        }
                        result.success(obj);
                        return;
                    case 2:
                        InAppWebView inAppWebView3 = this.webView;
                        if (inAppWebView3 != null) {
                            obj = inAppWebView3.getTitle();
                        }
                        result.success(obj);
                        return;
                    case 3:
                        InAppWebView inAppWebView4 = this.webView;
                        if (inAppWebView4 != null) {
                            obj = Integer.valueOf(inAppWebView4.getProgress());
                        }
                        result.success(obj);
                        return;
                    case 4:
                        if (this.webView != null) {
                            this.webView.loadUrl(URLRequest.fromMap((Map) methodCall.argument("urlRequest")));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 5:
                        if (this.webView != null) {
                            this.webView.postUrl((String) methodCall.argument(ImagesContract.URL), (byte[]) methodCall.argument("postData"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 6:
                        if (this.webView != null) {
                            this.webView.loadDataWithBaseURL((String) methodCall.argument("baseUrl"), (String) methodCall.argument("data"), (String) methodCall.argument("mimeType"), (String) methodCall.argument("encoding"), (String) methodCall.argument("historyUrl"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 7:
                        if (this.webView != null) {
                            try {
                                this.webView.loadFile((String) methodCall.argument("assetFilePath"));
                            } catch (IOException e) {
                                e.printStackTrace();
                                result.error(LOG_TAG, e.getMessage(), null);
                                return;
                            }
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 8:
                        if (this.webView != null) {
                            this.webView.evaluateJavascript((String) methodCall.argument("source"), ContentWorld.fromMap((Map) methodCall.argument("contentWorld")), new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.1
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str) {
                                    result.success(str);
                                }
                            });
                            return;
                        }
                        result.success(obj);
                        return;
                    case 9:
                        if (this.webView != null) {
                            this.webView.injectJavascriptFileFromUrl((String) methodCall.argument("urlFile"), (Map) methodCall.argument("scriptHtmlTagAttributes"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 10:
                        if (this.webView != null) {
                            this.webView.injectCSSCode((String) methodCall.argument("source"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 11:
                        if (this.webView != null) {
                            this.webView.injectCSSFileFromUrl((String) methodCall.argument("urlFile"), (Map) methodCall.argument("cssLinkHtmlTagAttributes"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 12:
                        InAppWebView inAppWebView5 = this.webView;
                        if (inAppWebView5 != null) {
                            inAppWebView5.reload();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 13:
                        InAppWebView inAppWebView6 = this.webView;
                        if (inAppWebView6 != null) {
                            inAppWebView6.goBack();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 14:
                        z = false;
                        InAppWebView inAppWebView7 = this.webView;
                        if (inAppWebView7 != null) {
                            break;
                        }
                        z3 = z;
                        valueOf = Boolean.valueOf(z3);
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 15:
                        InAppWebView inAppWebView8 = this.webView;
                        if (inAppWebView8 != null) {
                            inAppWebView8.goForward();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 16:
                        z = false;
                        InAppWebView inAppWebView9 = this.webView;
                        if (inAppWebView9 != null) {
                            break;
                        }
                        z3 = z;
                        valueOf = Boolean.valueOf(z3);
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 17:
                        InAppWebView inAppWebView10 = this.webView;
                        if (inAppWebView10 != null) {
                            inAppWebView10.goBackOrForward(((Integer) methodCall.argument("steps")).intValue());
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 18:
                        z = false;
                        InAppWebView inAppWebView11 = this.webView;
                        if (inAppWebView11 != null) {
                            break;
                        }
                        z3 = z;
                        valueOf = Boolean.valueOf(z3);
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 19:
                        InAppWebView inAppWebView12 = this.webView;
                        if (inAppWebView12 != null) {
                            inAppWebView12.stopLoading();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 20:
                        z = false;
                        InAppWebView inAppWebView13 = this.webView;
                        if (inAppWebView13 != null) {
                            break;
                        }
                        z3 = z;
                        valueOf = Boolean.valueOf(z3);
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 21:
                        if (this.webView != null) {
                            this.webView.takeScreenshot((Map) methodCall.argument("screenshotConfiguration"), result);
                            return;
                        }
                        result.success(obj);
                        return;
                    case 22:
                        InAppWebView inAppWebView14 = this.webView;
                        if (inAppWebView14 != null && (inAppWebView14.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                            InAppBrowserActivity inAppBrowserActivity = (InAppBrowserActivity) this.webView.getInAppBrowserDelegate();
                            InAppBrowserSettings inAppBrowserSettings = new InAppBrowserSettings();
                            HashMap<String, Object> hashMap = (HashMap) methodCall.argument("settings");
                            inAppBrowserSettings.parse2((Map<String, Object>) hashMap);
                            inAppBrowserActivity.setSettings(inAppBrowserSettings, hashMap);
                        } else if (this.webView != null) {
                            InAppWebViewSettings inAppWebViewSettings = new InAppWebViewSettings();
                            HashMap<String, Object> hashMap2 = (HashMap) methodCall.argument("settings");
                            inAppWebViewSettings.parse2((Map<String, Object>) hashMap2);
                            this.webView.setSettings(inAppWebViewSettings, hashMap2);
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 23:
                        InAppWebView inAppWebView15 = this.webView;
                        if (inAppWebView15 != null && (inAppWebView15.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                            valueOf = ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).getCustomSettings();
                            obj = valueOf;
                            result.success(obj);
                            return;
                        } else {
                            InAppWebView inAppWebView16 = this.webView;
                            if (inAppWebView16 != null) {
                                obj = inAppWebView16.getCustomSettings();
                            }
                            result.success(obj);
                            return;
                        }
                    case 24:
                        InAppWebView inAppWebView17 = this.webView;
                        if (inAppWebView17 != null && (inAppWebView17.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                            ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).close(result);
                            return;
                        }
                        result.notImplemented();
                        return;
                    case 25:
                        InAppWebView inAppWebView18 = this.webView;
                        if (inAppWebView18 != null && (inAppWebView18.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                            ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).show();
                            valueOf = Boolean.TRUE;
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        result.notImplemented();
                        return;
                    case 26:
                        InAppWebView inAppWebView19 = this.webView;
                        if (inAppWebView19 != null && (inAppWebView19.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                            ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).hide();
                            valueOf = Boolean.TRUE;
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        result.notImplemented();
                        return;
                    case 27:
                        InAppWebView inAppWebView20 = this.webView;
                        if (inAppWebView20 != null && (inAppWebView20.getInAppBrowserDelegate() instanceof InAppBrowserActivity)) {
                            z2 = ((InAppBrowserActivity) this.webView.getInAppBrowserDelegate()).isHidden;
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        result.notImplemented();
                        return;
                    case 28:
                        InAppWebView inAppWebView21 = this.webView;
                        if (inAppWebView21 != null) {
                            obj = inAppWebView21.getCopyBackForwardList();
                        }
                        result.success(obj);
                        return;
                    case 29:
                        if (this.webView != null && WebViewFeature.isFeatureSupported("START_SAFE_BROWSING")) {
                            WebViewCompat.startSafeBrowsing(this.webView.getContext(), new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.2
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(Boolean bool) {
                                    result.success(bool);
                                }
                            });
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 30:
                        InAppWebView inAppWebView22 = this.webView;
                        if (inAppWebView22 != null) {
                            inAppWebView22.clearAllCache();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 31:
                        InAppWebView inAppWebView23 = this.webView;
                        if (inAppWebView23 != null) {
                            inAppWebView23.clearSslPreferences();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 32:
                        if (this.webView != null) {
                            this.webView.findAllAsync((String) methodCall.argument("find"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 33:
                        if (this.webView != null) {
                            this.webView.findNext(((Boolean) methodCall.argument("forward")).booleanValue());
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 34:
                        InAppWebView inAppWebView24 = this.webView;
                        if (inAppWebView24 != null) {
                            inAppWebView24.clearMatches();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 35:
                        if (this.webView != null) {
                            this.webView.scrollTo((Integer) methodCall.argument("x"), (Integer) methodCall.argument("y"), (Boolean) methodCall.argument("animated"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 36:
                        if (this.webView != null) {
                            this.webView.scrollBy((Integer) methodCall.argument("x"), (Integer) methodCall.argument("y"), (Boolean) methodCall.argument("animated"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 37:
                        InAppWebView inAppWebView25 = this.webView;
                        if (inAppWebView25 != null) {
                            inAppWebView25.onPause();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 38:
                        InAppWebView inAppWebView26 = this.webView;
                        if (inAppWebView26 != null) {
                            inAppWebView26.onResume();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 39:
                        InAppWebView inAppWebView27 = this.webView;
                        if (inAppWebView27 != null) {
                            inAppWebView27.pauseTimers();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 40:
                        InAppWebView inAppWebView28 = this.webView;
                        if (inAppWebView28 != null) {
                            inAppWebView28.resumeTimers();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 41:
                        if (this.webView != null) {
                            PrintJobSettings printJobSettings = new PrintJobSettings();
                            Map<String, Object> map = (Map) methodCall.argument("settings");
                            if (map != null) {
                                printJobSettings.parse2(map);
                            }
                            valueOf = this.webView.printCurrentPage(printJobSettings);
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case 42:
                        InAppWebView inAppWebView29 = this.webView;
                        if (inAppWebView29 instanceof InAppWebView) {
                            contentHeight = inAppWebView29.getContentHeight();
                            valueOf = Integer.valueOf(contentHeight);
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case 43:
                        InAppWebView inAppWebView30 = this.webView;
                        if (inAppWebView30 instanceof InAppWebView) {
                            inAppWebView30.getContentWidth(new ValueCallback<Integer>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.3
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(Integer num) {
                                    result.success(num);
                                }
                            });
                            return;
                        }
                        result.success(obj);
                        return;
                    case 44:
                        if (this.webView != null) {
                            this.webView.zoomBy((float) ((Double) methodCall.argument("zoomFactor")).doubleValue());
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 45:
                        InAppWebView inAppWebView31 = this.webView;
                        if (inAppWebView31 != null) {
                            obj = inAppWebView31.getOriginalUrl();
                        }
                        result.success(obj);
                        return;
                    case 46:
                        InAppWebView inAppWebView32 = this.webView;
                        if (inAppWebView32 instanceof InAppWebView) {
                            valueOf = Float.valueOf(inAppWebView32.getZoomScale());
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case 47:
                        InAppWebView inAppWebView33 = this.webView;
                        if (inAppWebView33 instanceof InAppWebView) {
                            inAppWebView33.getSelectedText(new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.4
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str) {
                                    result.success(str);
                                }
                            });
                            return;
                        }
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        InAppWebView inAppWebView34 = this.webView;
                        if (inAppWebView34 instanceof InAppWebView) {
                            valueOf = HitTestResult.fromWebViewHitTestResult(inAppWebView34.getHitTestResult()).toMap();
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        if (this.webView != null) {
                            z2 = this.webView.pageDown(((Boolean) methodCall.argument("bottom")).booleanValue());
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 50:
                        if (this.webView != null) {
                            z2 = this.webView.pageUp(((Boolean) methodCall.argument("top")).booleanValue());
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (this.webView != null) {
                            this.webView.saveWebArchive((String) methodCall.argument("filePath"), ((Boolean) methodCall.argument("autoname")).booleanValue(), new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.5
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str) {
                                    result.success(str);
                                }
                            });
                            return;
                        }
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        InAppWebView inAppWebView35 = this.webView;
                        if (inAppWebView35 != null) {
                            z2 = inAppWebView35.zoomIn();
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        InAppWebView inAppWebView36 = this.webView;
                        if (inAppWebView36 != null) {
                            z2 = inAppWebView36.zoomOut();
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        InAppWebView inAppWebView37 = this.webView;
                        if (inAppWebView37 != null) {
                            inAppWebView37.clearFocus();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (this.webView != null) {
                            this.webView.setContextMenu((Map) methodCall.argument("contextMenu"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 56:
                        InAppWebView inAppWebView38 = this.webView;
                        if (inAppWebView38 != null) {
                            valueOf = inAppWebView38.requestFocusNodeHref();
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case 57:
                        InAppWebView inAppWebView39 = this.webView;
                        if (inAppWebView39 != null) {
                            valueOf = inAppWebView39.requestImageRef();
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case 58:
                        InAppWebView inAppWebView40 = this.webView;
                        if (inAppWebView40 != null) {
                            contentHeight = inAppWebView40.getScrollX();
                            valueOf = Integer.valueOf(contentHeight);
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case 59:
                        InAppWebView inAppWebView41 = this.webView;
                        if (inAppWebView41 != null) {
                            contentHeight = inAppWebView41.getScrollY();
                            valueOf = Integer.valueOf(contentHeight);
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        InAppWebView inAppWebView42 = this.webView;
                        if (inAppWebView42 != null) {
                            valueOf = SslCertificateExt.toMap(inAppWebView42.getCertificate());
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        InAppWebView inAppWebView43 = this.webView;
                        if (inAppWebView43 != null) {
                            inAppWebView43.clearHistory();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 62:
                        InAppWebView inAppWebView44 = this.webView;
                        if (inAppWebView44 != null && inAppWebView44.getUserContentController() != null) {
                            z2 = this.webView.getUserContentController().addUserOnlyScript(UserScript.fromMap((Map) methodCall.argument("userScript")));
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        InAppWebView inAppWebView45 = this.webView;
                        if (inAppWebView45 != null && inAppWebView45.getUserContentController() != null) {
                            z2 = this.webView.getUserContentController().removeUserOnlyScriptAt(((Integer) methodCall.argument(FirebaseAnalytics.Param.INDEX)).intValue(), UserScript.fromMap((Map) methodCall.argument("userScript")).getInjectionTime());
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 64:
                        InAppWebView inAppWebView46 = this.webView;
                        if (inAppWebView46 != null && inAppWebView46.getUserContentController() != null) {
                            this.webView.getUserContentController().removeUserOnlyScriptsByGroupName((String) methodCall.argument("groupName"));
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 65:
                        InAppWebView inAppWebView47 = this.webView;
                        if (inAppWebView47 != null && inAppWebView47.getUserContentController() != null) {
                            this.webView.getUserContentController().removeAllUserOnlyScripts();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (this.webView != null) {
                            this.webView.callAsyncJavaScript((String) methodCall.argument("functionBody"), (Map) methodCall.argument(Constant.PARAM_SQL_ARGUMENTS), ContentWorld.fromMap((Map) methodCall.argument("contentWorld")), new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.6
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str) {
                                    result.success(str);
                                }
                            });
                            return;
                        }
                        result.success(obj);
                        return;
                    case 67:
                        InAppWebView inAppWebView48 = this.webView;
                        if (inAppWebView48 != null) {
                            inAppWebView48.isSecureContext(new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate.7
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(Boolean bool) {
                                    result.success(bool);
                                }
                            });
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 68:
                        InAppWebView inAppWebView49 = this.webView;
                        if (inAppWebView49 != null && (inAppWebView49 instanceof InAppWebView) && WebViewFeature.isFeatureSupported("CREATE_WEB_MESSAGE_CHANNEL")) {
                            valueOf = this.webView.createCompatWebMessageChannel().toMap();
                            obj = valueOf;
                        }
                        result.success(obj);
                        return;
                    case 69:
                        if (this.webView != null && WebViewFeature.isFeatureSupported("POST_WEB_MESSAGE")) {
                            WebMessageCompatExt fromMap = WebMessageCompatExt.fromMap((Map) methodCall.argument(Constant.PARAM_ERROR_MESSAGE));
                            String str = (String) methodCall.argument("targetOrigin");
                            ArrayList arrayList = new ArrayList();
                            List<WebMessagePortCompatExt> ports = fromMap.getPorts();
                            if (ports != null) {
                                for (WebMessagePortCompatExt webMessagePortCompatExt : ports) {
                                    WebMessageChannel webMessageChannel = this.webView.getWebMessageChannels().get(webMessagePortCompatExt.getWebMessageChannelId());
                                    if (webMessageChannel != null && (this.webView instanceof InAppWebView)) {
                                        arrayList.add(webMessageChannel.compatPorts.get(webMessagePortCompatExt.getIndex()));
                                    }
                                }
                            }
                            Object data = fromMap.getData();
                            if (this.webView instanceof InAppWebView) {
                                if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_ARRAY_BUFFER") && data != null && fromMap.getType() == 1) {
                                    inAppWebView = this.webView;
                                    webMessageCompat = new WebMessageCompat((byte[]) data, (WebMessagePortCompat[]) arrayList.toArray(new WebMessagePortCompat[0]));
                                    parse = Uri.parse(str);
                                } else {
                                    inAppWebView = this.webView;
                                    webMessageCompat = new WebMessageCompat(data != null ? data.toString() : null, (WebMessagePortCompat[]) arrayList.toArray(new WebMessagePortCompat[0]));
                                    parse = Uri.parse(str);
                                }
                                WebViewCompat.postWebMessage(inAppWebView, webMessageCompat, parse);
                                result.success(Boolean.TRUE);
                                return;
                            }
                            return;
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 70:
                        if (this.webView != null) {
                            Map map2 = (Map) methodCall.argument("webMessageListener");
                            InAppWebView inAppWebView50 = this.webView;
                            WebMessageListener fromMap2 = WebMessageListener.fromMap(inAppWebView50, inAppWebView50.getPlugin().messenger, map2);
                            if ((this.webView instanceof InAppWebView) && WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
                                this.webView.addWebMessageListener(fromMap2);
                                result.success(Boolean.TRUE);
                                return;
                            }
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case TsExtractor.TS_SYNC_BYTE /* 71 */:
                        InAppWebView inAppWebView51 = this.webView;
                        if (inAppWebView51 != null) {
                            z2 = inAppWebView51.canScrollVertically();
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 72:
                        InAppWebView inAppWebView52 = this.webView;
                        if (inAppWebView52 != null) {
                            z2 = inAppWebView52.canScrollHorizontally();
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 73:
                        InAppWebView inAppWebView53 = this.webView;
                        if (inAppWebView53 != null) {
                            z2 = inAppWebView53.isInFullscreen();
                            valueOf = Boolean.valueOf(z2);
                            obj = valueOf;
                            result.success(obj);
                            return;
                        }
                        valueOf = Boolean.FALSE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    case 74:
                        InAppWebView inAppWebView54 = this.webView;
                        if (inAppWebView54 != null) {
                            inAppWebView54.clearFormData();
                        }
                        valueOf = Boolean.TRUE;
                        obj = valueOf;
                        result.success(obj);
                        return;
                    default:
                        return;
                }
            } catch (Exception e2) {
                result.error(LOG_TAG, e2.getMessage(), null);
            }
        } catch (IllegalArgumentException unused) {
            result.notImplemented();
        }
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("x", Integer.valueOf(i));
        hashMap.put("y", Integer.valueOf(i2));
        hashMap.put("clampedX", Boolean.valueOf(z));
        hashMap.put("clampedY", Boolean.valueOf(z2));
        channel.invokeMethod("onOverScrolled", hashMap);
    }

    public void onPageCommitVisible(String str) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        channel.invokeMethod("onPageCommitVisible", hashMap);
    }

    public void onPermissionRequest(String str, List<String> list, Object obj, PermissionRequestCallback permissionRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            permissionRequestCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("origin", str);
        hashMap.put("resources", list);
        hashMap.put(TypedValues.AttributesType.S_FRAME, obj);
        channel.invokeMethod("onPermissionRequest", hashMap, permissionRequestCallback);
    }

    public void onPermissionRequestCanceled(String str, List<String> list) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("origin", str);
        hashMap.put("resources", list);
        channel.invokeMethod("onPermissionRequestCanceled", hashMap);
    }

    public void onPrintRequest(String str, String str2, PrintRequestCallback printRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            printRequestCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put("printJobId", str2);
        channel.invokeMethod("onPrintRequest", hashMap, printRequestCallback);
    }

    public void onProgressChanged(int i) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("progress", Integer.valueOf(i));
        channel.invokeMethod("onProgressChanged", hashMap);
    }

    public void onReceivedClientCertRequest(ClientCertChallenge clientCertChallenge, ReceivedClientCertRequestCallback receivedClientCertRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            receivedClientCertRequestCallback.defaultBehaviour(null);
        } else {
            channel.invokeMethod("onReceivedClientCertRequest", clientCertChallenge.toMap(), receivedClientCertRequestCallback);
        }
    }

    public void onReceivedError(WebResourceRequestExt webResourceRequestExt, WebResourceErrorExt webResourceErrorExt) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        hashMap.put("error", webResourceErrorExt.toMap());
        channel.invokeMethod("onReceivedError", hashMap);
    }

    public void onReceivedHttpAuthRequest(HttpAuthenticationChallenge httpAuthenticationChallenge, ReceivedHttpAuthRequestCallback receivedHttpAuthRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            receivedHttpAuthRequestCallback.defaultBehaviour(null);
        } else {
            channel.invokeMethod("onReceivedHttpAuthRequest", httpAuthenticationChallenge.toMap(), receivedHttpAuthRequestCallback);
        }
    }

    public void onReceivedHttpError(WebResourceRequestExt webResourceRequestExt, WebResourceResponseExt webResourceResponseExt) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        hashMap.put("errorResponse", webResourceResponseExt.toMap());
        channel.invokeMethod("onReceivedHttpError", hashMap);
    }

    public void onReceivedIcon(byte[] bArr) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("icon", bArr);
        channel.invokeMethod("onReceivedIcon", hashMap);
    }

    public void onReceivedLoginRequest(String str, String str2, String str3) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, str);
        hashMap.put("account", str2);
        hashMap.put("args", str3);
        channel.invokeMethod("onReceivedLoginRequest", hashMap);
    }

    public void onReceivedServerTrustAuthRequest(ServerTrustChallenge serverTrustChallenge, ReceivedServerTrustAuthRequestCallback receivedServerTrustAuthRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            receivedServerTrustAuthRequestCallback.defaultBehaviour(null);
        } else {
            channel.invokeMethod("onReceivedServerTrustAuthRequest", serverTrustChallenge.toMap(), receivedServerTrustAuthRequestCallback);
        }
    }

    public void onReceivedTouchIconUrl(String str, boolean z) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put("precomposed", Boolean.valueOf(z));
        channel.invokeMethod("onReceivedTouchIconUrl", hashMap);
    }

    public void onRenderProcessGone(boolean z, int i) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("didCrash", Boolean.valueOf(z));
        hashMap.put("rendererPriorityAtExit", Integer.valueOf(i));
        channel.invokeMethod("onRenderProcessGone", hashMap);
    }

    public void onRenderProcessResponsive(String str, RenderProcessResponsiveCallback renderProcessResponsiveCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            renderProcessResponsiveCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        channel.invokeMethod("onRenderProcessResponsive", hashMap, renderProcessResponsiveCallback);
    }

    public void onRenderProcessUnresponsive(String str, RenderProcessUnresponsiveCallback renderProcessUnresponsiveCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            renderProcessUnresponsiveCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        channel.invokeMethod("onRenderProcessUnresponsive", hashMap, renderProcessUnresponsiveCallback);
    }

    public void onRequestFocus() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onRequestFocus", new HashMap());
    }

    public void onSafeBrowsingHit(String str, int i, SafeBrowsingHitCallback safeBrowsingHitCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            safeBrowsingHitCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put("threatType", Integer.valueOf(i));
        channel.invokeMethod("onSafeBrowsingHit", hashMap, safeBrowsingHitCallback);
    }

    public void onScrollChanged(int i, int i2) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("x", Integer.valueOf(i));
        hashMap.put("y", Integer.valueOf(i2));
        channel.invokeMethod("onScrollChanged", hashMap);
    }

    public void onTitleChanged(String str) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("title", str);
        channel.invokeMethod("onTitleChanged", hashMap);
    }

    public void onUpdateVisitedHistory(String str, boolean z) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, str);
        hashMap.put("isReload", Boolean.valueOf(z));
        channel.invokeMethod("onUpdateVisitedHistory", hashMap);
    }

    public void onZoomScaleChanged(float f, float f2) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("oldScale", Float.valueOf(f));
        hashMap.put("newScale", Float.valueOf(f2));
        channel.invokeMethod("onZoomScaleChanged", hashMap);
    }

    public WebResourceResponseExt shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return null;
        }
        return (WebResourceResponseExt) Util.invokeMethodAndWaitResult(channel, "shouldInterceptRequest", webResourceRequestExt.toMap(), new SyncShouldInterceptRequestCallback());
    }

    public void shouldOverrideUrlLoading(NavigationAction navigationAction, ShouldOverrideUrlLoadingCallback shouldOverrideUrlLoadingCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            shouldOverrideUrlLoadingCallback.defaultBehaviour(null);
        } else {
            channel.invokeMethod("shouldOverrideUrlLoading", navigationAction.toMap(), shouldOverrideUrlLoadingCallback);
        }
    }

    public void onLoadResourceWithCustomScheme(WebResourceRequestExt webResourceRequestExt, LoadResourceWithCustomSchemeCallback loadResourceWithCustomSchemeCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            loadResourceWithCustomSchemeCallback.defaultBehaviour(null);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request", webResourceRequestExt.toMap());
        channel.invokeMethod("onLoadResourceWithCustomScheme", hashMap, loadResourceWithCustomSchemeCallback);
    }

    public void shouldInterceptRequest(WebResourceRequestExt webResourceRequestExt, ShouldInterceptRequestCallback shouldInterceptRequestCallback) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            shouldInterceptRequestCallback.defaultBehaviour(null);
        } else {
            channel.invokeMethod("shouldInterceptRequest", webResourceRequestExt.toMap(), shouldInterceptRequestCallback);
        }
    }
}
