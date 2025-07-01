package com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview;

import android.os.Build;
import android.webkit.WebSettings;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.media3.common.C;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.PreferredContentModeOptionType;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.io.encoding.Base64;
import kotlin.text.Typography;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.commons.io.IOUtils;

/* loaded from: classes4.dex */
public class InAppWebViewSettings implements ISettings<InAppWebViewInterface> {
    public static final String LOG_TAG = "InAppWebViewSettings";
    public Boolean algorithmicDarkeningAllowed;
    public Boolean allowBackgroundAudioPlaying;
    public Boolean allowContentAccess;
    public Boolean allowFileAccess;
    public Boolean allowFileAccessFromFileURLs;
    public Boolean allowUniversalAccessFromFileURLs;
    public String appCachePath;
    public String applicationNameForUserAgent;
    public Boolean blockNetworkImage;
    public Boolean blockNetworkLoads;
    public Boolean builtInZoomControls;
    public Boolean cacheEnabled;
    public Integer cacheMode;

    @Deprecated
    public Boolean clearCache;

    @Deprecated
    public Boolean clearSessionCache;
    public List<Map<String, Map<String, Object>>> contentBlockers;
    public String cursiveFontFamily;
    public Boolean databaseEnabled;
    public Integer defaultFixedFontSize;
    public Integer defaultFontSize;
    public String defaultTextEncodingName;
    public byte[] defaultVideoPoster;
    public Boolean disableContextMenu;
    public Boolean disableDefaultErrorPage;
    public Boolean disableHorizontalScroll;
    public Boolean disableVerticalScroll;
    public Integer disabledActionModeMenuItems;
    public Boolean displayZoomControls;
    public Boolean domStorageEnabled;
    public Boolean enterpriseAuthenticationAppLinkPolicyEnabled;
    public String fantasyFontFamily;
    public String fixedFontFamily;
    public Integer forceDark;
    public Integer forceDarkStrategy;
    public Boolean geolocationEnabled;
    public Boolean hardwareAcceleration;
    public Boolean horizontalScrollBarEnabled;
    public String horizontalScrollbarThumbColor;
    public String horizontalScrollbarTrackColor;
    public Boolean incognito;
    public Integer initialScale;
    public Boolean interceptOnlyAsyncAjaxRequests;
    public Boolean javaScriptCanOpenWindowsAutomatically;
    public Boolean javaScriptEnabled;
    public WebSettings.LayoutAlgorithm layoutAlgorithm;
    public Boolean loadWithOverviewMode;
    public Boolean loadsImagesAutomatically;
    public Boolean mediaPlaybackRequiresUserGesture;
    public Integer minimumFontSize;
    public Integer minimumLogicalFontSize;
    public Integer mixedContentMode;
    public Boolean needInitialFocus;
    public Boolean networkAvailable;
    public Boolean offscreenPreRaster;
    public Integer overScrollMode;
    public Integer preferredContentMode;
    public String regexToCancelSubFramesLoading;
    public Map<String, Object> rendererPriorityPolicy;
    public Set<String> requestedWithHeaderOriginAllowList;
    public List<String> resourceCustomSchemes;
    public Boolean safeBrowsingEnabled;
    public String sansSerifFontFamily;
    public Boolean saveFormData;
    public Integer scrollBarDefaultDelayBeforeFade;
    public Integer scrollBarFadeDuration;
    public Integer scrollBarStyle;
    public Boolean scrollbarFadingEnabled;
    public String serifFontFamily;
    public String standardFontFamily;
    public Boolean supportMultipleWindows;
    public Boolean supportZoom;
    public Integer textZoom;
    public Boolean thirdPartyCookiesEnabled;
    public Boolean transparentBackground;
    public Boolean useHybridComposition;
    public Boolean useOnDownloadStart;
    public Boolean useOnLoadResource;
    public Boolean useOnRenderProcessGone;
    public Boolean useShouldInterceptAjaxRequest;
    public Boolean useShouldInterceptFetchRequest;
    public Boolean useShouldInterceptRequest;
    public Boolean useShouldOverrideUrlLoading;
    public Boolean useWideViewPort;
    public String userAgent;
    public Boolean verticalScrollBarEnabled;
    public Integer verticalScrollbarPosition;
    public String verticalScrollbarThumbColor;
    public String verticalScrollbarTrackColor;
    public Map<String, Object> webViewAssetLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewSettings$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm;

        static {
            int[] iArr = new int[WebSettings.LayoutAlgorithm.values().length];
            $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm = iArr;
            try {
                iArr[WebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[WebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public InAppWebViewSettings() {
        Boolean bool = Boolean.FALSE;
        this.useShouldOverrideUrlLoading = bool;
        this.useOnLoadResource = bool;
        this.useOnDownloadStart = bool;
        this.clearCache = bool;
        this.userAgent = "";
        this.applicationNameForUserAgent = "";
        Boolean bool2 = Boolean.TRUE;
        this.javaScriptEnabled = bool2;
        this.javaScriptCanOpenWindowsAutomatically = bool;
        this.mediaPlaybackRequiresUserGesture = bool2;
        this.minimumFontSize = 8;
        this.verticalScrollBarEnabled = bool2;
        this.horizontalScrollBarEnabled = bool2;
        this.resourceCustomSchemes = new ArrayList();
        this.contentBlockers = new ArrayList();
        this.preferredContentMode = Integer.valueOf(PreferredContentModeOptionType.RECOMMENDED.toValue());
        this.useShouldInterceptAjaxRequest = bool;
        this.interceptOnlyAsyncAjaxRequests = bool2;
        this.useShouldInterceptFetchRequest = bool;
        this.incognito = bool;
        this.cacheEnabled = bool2;
        this.transparentBackground = bool;
        this.disableVerticalScroll = bool;
        this.disableHorizontalScroll = bool;
        this.disableContextMenu = bool;
        this.supportZoom = bool2;
        this.allowFileAccessFromFileURLs = bool;
        this.allowUniversalAccessFromFileURLs = bool;
        this.allowBackgroundAudioPlaying = bool;
        this.textZoom = 100;
        this.clearSessionCache = bool;
        this.builtInZoomControls = bool2;
        this.displayZoomControls = bool;
        this.databaseEnabled = bool;
        this.domStorageEnabled = bool2;
        this.useWideViewPort = bool2;
        this.safeBrowsingEnabled = bool2;
        this.allowContentAccess = bool2;
        this.allowFileAccess = bool2;
        this.blockNetworkImage = bool;
        this.blockNetworkLoads = bool;
        this.cacheMode = -1;
        this.cursiveFontFamily = "cursive";
        this.defaultFixedFontSize = 16;
        this.defaultFontSize = 16;
        this.defaultTextEncodingName = "UTF-8";
        this.fantasyFontFamily = "fantasy";
        this.fixedFontFamily = "monospace";
        this.forceDark = 0;
        this.forceDarkStrategy = 2;
        this.geolocationEnabled = bool2;
        this.loadWithOverviewMode = bool2;
        this.loadsImagesAutomatically = bool2;
        this.minimumLogicalFontSize = 8;
        this.initialScale = 0;
        this.needInitialFocus = bool2;
        this.offscreenPreRaster = bool;
        this.sansSerifFontFamily = C.SANS_SERIF_NAME;
        this.serifFontFamily = C.SANS_SERIF_NAME;
        this.standardFontFamily = C.SANS_SERIF_NAME;
        this.saveFormData = bool2;
        this.thirdPartyCookiesEnabled = bool2;
        this.hardwareAcceleration = bool2;
        this.supportMultipleWindows = bool;
        this.overScrollMode = 1;
        this.networkAvailable = null;
        this.scrollBarStyle = 0;
        this.verticalScrollbarPosition = 0;
        this.scrollBarDefaultDelayBeforeFade = null;
        this.scrollbarFadingEnabled = bool2;
        this.scrollBarFadeDuration = null;
        this.rendererPriorityPolicy = null;
        this.useShouldInterceptRequest = bool;
        this.useOnRenderProcessGone = bool;
        this.disableDefaultErrorPage = bool;
        this.useHybridComposition = bool2;
        this.algorithmicDarkeningAllowed = bool;
        this.enterpriseAuthenticationAppLinkPolicyEnabled = bool2;
    }

    private String getLayoutAlgorithm() {
        WebSettings.LayoutAlgorithm layoutAlgorithm = this.layoutAlgorithm;
        if (layoutAlgorithm == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$android$webkit$WebSettings$LayoutAlgorithm[layoutAlgorithm.ordinal()];
        if (i == 1) {
            return "NORMAL";
        }
        if (i == 2) {
            return "TEXT_AUTOSIZING";
        }
        if (i != 3) {
            return null;
        }
        return "NARROW_COLUMNS";
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x002e. Please report as an issue. */
    private void setLayoutAlgorithm(String str) {
        if (str == null) {
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1986416409:
                if (str.equals("NORMAL")) {
                    c = 0;
                    break;
                }
                break;
            case 1055046617:
                if (str.equals("NARROW_COLUMNS")) {
                    c = 1;
                    break;
                }
                break;
            case 1561826623:
                if (str.equals("TEXT_AUTOSIZING")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 1:
                this.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
            case 0:
                this.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL;
            case 2:
                this.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING;
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0221  */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Object> getRealSettings(InAppWebViewInterface inAppWebViewInterface) {
        int forceDark;
        Map<String, Object> map = toMap();
        if (inAppWebViewInterface instanceof InAppWebView) {
            InAppWebView inAppWebView = (InAppWebView) inAppWebViewInterface;
            WebSettings settings = inAppWebView.getSettings();
            map.put("userAgent", settings.getUserAgentString());
            map.put("javaScriptEnabled", Boolean.valueOf(settings.getJavaScriptEnabled()));
            map.put("javaScriptCanOpenWindowsAutomatically", Boolean.valueOf(settings.getJavaScriptCanOpenWindowsAutomatically()));
            map.put("mediaPlaybackRequiresUserGesture", Boolean.valueOf(settings.getMediaPlaybackRequiresUserGesture()));
            map.put("minimumFontSize", Integer.valueOf(settings.getMinimumFontSize()));
            map.put("verticalScrollBarEnabled", Boolean.valueOf(inAppWebView.isVerticalScrollBarEnabled()));
            map.put("horizontalScrollBarEnabled", Boolean.valueOf(inAppWebView.isHorizontalScrollBarEnabled()));
            map.put("textZoom", Integer.valueOf(settings.getTextZoom()));
            map.put("builtInZoomControls", Boolean.valueOf(settings.getBuiltInZoomControls()));
            map.put("supportZoom", Boolean.valueOf(settings.supportZoom()));
            map.put("displayZoomControls", Boolean.valueOf(settings.getDisplayZoomControls()));
            map.put("databaseEnabled", Boolean.valueOf(settings.getDatabaseEnabled()));
            map.put("domStorageEnabled", Boolean.valueOf(settings.getDomStorageEnabled()));
            map.put("useWideViewPort", Boolean.valueOf(settings.getUseWideViewPort()));
            map.put("safeBrowsingEnabled", Boolean.valueOf(WebViewFeature.isFeatureSupported("SAFE_BROWSING_ENABLE") ? WebSettingsCompat.getSafeBrowsingEnabled(settings) : settings.getSafeBrowsingEnabled()));
            int i = Build.VERSION.SDK_INT;
            map.put("mixedContentMode", Integer.valueOf(settings.getMixedContentMode()));
            map.put("allowContentAccess", Boolean.valueOf(settings.getAllowContentAccess()));
            map.put("allowFileAccess", Boolean.valueOf(settings.getAllowFileAccess()));
            map.put("allowFileAccessFromFileURLs", Boolean.valueOf(settings.getAllowFileAccessFromFileURLs()));
            map.put("allowUniversalAccessFromFileURLs", Boolean.valueOf(settings.getAllowUniversalAccessFromFileURLs()));
            map.put("blockNetworkImage", Boolean.valueOf(settings.getBlockNetworkImage()));
            map.put("blockNetworkLoads", Boolean.valueOf(settings.getBlockNetworkLoads()));
            map.put("cacheMode", Integer.valueOf(settings.getCacheMode()));
            map.put("cursiveFontFamily", settings.getCursiveFontFamily());
            map.put("defaultFixedFontSize", Integer.valueOf(settings.getDefaultFixedFontSize()));
            map.put("defaultFontSize", Integer.valueOf(settings.getDefaultFontSize()));
            map.put("defaultTextEncodingName", settings.getDefaultTextEncodingName());
            if (WebViewFeature.isFeatureSupported("DISABLED_ACTION_MODE_MENU_ITEMS")) {
                map.put("disabledActionModeMenuItems", Integer.valueOf(WebSettingsCompat.getDisabledActionModeMenuItems(settings)));
            }
            map.put("disabledActionModeMenuItems", Integer.valueOf(settings.getDisabledActionModeMenuItems()));
            map.put("fantasyFontFamily", settings.getFantasyFontFamily());
            map.put("fixedFontFamily", settings.getFixedFontFamily());
            if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
                forceDark = WebSettingsCompat.getForceDark(settings);
            } else {
                if (i >= 29) {
                    forceDark = settings.getForceDark();
                }
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                    map.put("forceDarkStrategy", Integer.valueOf(WebSettingsCompat.getForceDarkStrategy(settings)));
                }
                map.put("layoutAlgorithm", settings.getLayoutAlgorithm().name());
                map.put("loadWithOverviewMode", Boolean.valueOf(settings.getLoadWithOverviewMode()));
                map.put("loadsImagesAutomatically", Boolean.valueOf(settings.getLoadsImagesAutomatically()));
                map.put("minimumLogicalFontSize", Integer.valueOf(settings.getMinimumLogicalFontSize()));
                map.put("offscreenPreRaster", Boolean.valueOf(!WebViewFeature.isFeatureSupported("OFF_SCREEN_PRERASTER") ? WebSettingsCompat.getOffscreenPreRaster(settings) : settings.getOffscreenPreRaster()));
                map.put("sansSerifFontFamily", settings.getSansSerifFontFamily());
                map.put("serifFontFamily", settings.getSerifFontFamily());
                map.put("standardFontFamily", settings.getStandardFontFamily());
                map.put("saveFormData", Boolean.valueOf(settings.getSaveFormData()));
                map.put("supportMultipleWindows", Boolean.valueOf(settings.supportMultipleWindows()));
                map.put("overScrollMode", Integer.valueOf(inAppWebView.getOverScrollMode()));
                map.put("scrollBarStyle", Integer.valueOf(inAppWebView.getScrollBarStyle()));
                map.put("verticalScrollbarPosition", Integer.valueOf(inAppWebView.getVerticalScrollbarPosition()));
                map.put("scrollBarDefaultDelayBeforeFade", Integer.valueOf(inAppWebView.getScrollBarDefaultDelayBeforeFade()));
                map.put("scrollbarFadingEnabled", Boolean.valueOf(inAppWebView.isScrollbarFadingEnabled()));
                map.put("scrollBarFadeDuration", Integer.valueOf(inAppWebView.getScrollBarFadeDuration()));
                HashMap hashMap = new HashMap();
                hashMap.put("rendererRequestedPriority", Integer.valueOf(inAppWebView.getRendererRequestedPriority()));
                hashMap.put("waivedWhenNotVisible", Boolean.valueOf(inAppWebView.getRendererPriorityWaivedWhenNotVisible()));
                map.put("rendererPriorityPolicy", hashMap);
                if (WebViewFeature.isFeatureSupported("ALGORITHMIC_DARKENING") && i >= 29) {
                    map.put("algorithmicDarkeningAllowed", Boolean.valueOf(WebSettingsCompat.isAlgorithmicDarkeningAllowed(settings)));
                }
                if (WebViewFeature.isFeatureSupported("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY")) {
                    map.put("enterpriseAuthenticationAppLinkPolicyEnabled", Boolean.valueOf(WebSettingsCompat.getEnterpriseAuthenticationAppLinkPolicyEnabled(settings)));
                }
                if (WebViewFeature.isFeatureSupported("REQUESTED_WITH_HEADER_ALLOW_LIST")) {
                    map.put("requestedWithHeaderOriginAllowList", new ArrayList(WebSettingsCompat.getRequestedWithHeaderOriginAllowList(settings)));
                }
            }
            map.put("forceDark", Integer.valueOf(forceDark));
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
            }
            map.put("layoutAlgorithm", settings.getLayoutAlgorithm().name());
            map.put("loadWithOverviewMode", Boolean.valueOf(settings.getLoadWithOverviewMode()));
            map.put("loadsImagesAutomatically", Boolean.valueOf(settings.getLoadsImagesAutomatically()));
            map.put("minimumLogicalFontSize", Integer.valueOf(settings.getMinimumLogicalFontSize()));
            map.put("offscreenPreRaster", Boolean.valueOf(!WebViewFeature.isFeatureSupported("OFF_SCREEN_PRERASTER") ? WebSettingsCompat.getOffscreenPreRaster(settings) : settings.getOffscreenPreRaster()));
            map.put("sansSerifFontFamily", settings.getSansSerifFontFamily());
            map.put("serifFontFamily", settings.getSerifFontFamily());
            map.put("standardFontFamily", settings.getStandardFontFamily());
            map.put("saveFormData", Boolean.valueOf(settings.getSaveFormData()));
            map.put("supportMultipleWindows", Boolean.valueOf(settings.supportMultipleWindows()));
            map.put("overScrollMode", Integer.valueOf(inAppWebView.getOverScrollMode()));
            map.put("scrollBarStyle", Integer.valueOf(inAppWebView.getScrollBarStyle()));
            map.put("verticalScrollbarPosition", Integer.valueOf(inAppWebView.getVerticalScrollbarPosition()));
            map.put("scrollBarDefaultDelayBeforeFade", Integer.valueOf(inAppWebView.getScrollBarDefaultDelayBeforeFade()));
            map.put("scrollbarFadingEnabled", Boolean.valueOf(inAppWebView.isScrollbarFadingEnabled()));
            map.put("scrollBarFadeDuration", Integer.valueOf(inAppWebView.getScrollBarFadeDuration()));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("rendererRequestedPriority", Integer.valueOf(inAppWebView.getRendererRequestedPriority()));
            hashMap2.put("waivedWhenNotVisible", Boolean.valueOf(inAppWebView.getRendererPriorityWaivedWhenNotVisible()));
            map.put("rendererPriorityPolicy", hashMap2);
            if (WebViewFeature.isFeatureSupported("ALGORITHMIC_DARKENING")) {
                map.put("algorithmicDarkeningAllowed", Boolean.valueOf(WebSettingsCompat.isAlgorithmicDarkeningAllowed(settings)));
            }
            if (WebViewFeature.isFeatureSupported("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY")) {
            }
            if (WebViewFeature.isFeatureSupported("REQUESTED_WITH_HEADER_ALLOW_LIST")) {
            }
        }
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<InAppWebViewInterface> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("useShouldOverrideUrlLoading", this.useShouldOverrideUrlLoading);
        hashMap.put("useOnLoadResource", this.useOnLoadResource);
        hashMap.put("useOnDownloadStart", this.useOnDownloadStart);
        hashMap.put("clearCache", this.clearCache);
        hashMap.put("userAgent", this.userAgent);
        hashMap.put("applicationNameForUserAgent", this.applicationNameForUserAgent);
        hashMap.put("javaScriptEnabled", this.javaScriptEnabled);
        hashMap.put("javaScriptCanOpenWindowsAutomatically", this.javaScriptCanOpenWindowsAutomatically);
        hashMap.put("mediaPlaybackRequiresUserGesture", this.mediaPlaybackRequiresUserGesture);
        hashMap.put("minimumFontSize", this.minimumFontSize);
        hashMap.put("verticalScrollBarEnabled", this.verticalScrollBarEnabled);
        hashMap.put("horizontalScrollBarEnabled", this.horizontalScrollBarEnabled);
        hashMap.put("resourceCustomSchemes", this.resourceCustomSchemes);
        hashMap.put("contentBlockers", this.contentBlockers);
        hashMap.put("preferredContentMode", this.preferredContentMode);
        hashMap.put("useShouldInterceptAjaxRequest", this.useShouldInterceptAjaxRequest);
        hashMap.put("interceptOnlyAsyncAjaxRequests", this.interceptOnlyAsyncAjaxRequests);
        hashMap.put("useShouldInterceptFetchRequest", this.useShouldInterceptFetchRequest);
        hashMap.put("incognito", this.incognito);
        hashMap.put("cacheEnabled", this.cacheEnabled);
        hashMap.put("transparentBackground", this.transparentBackground);
        hashMap.put("disableVerticalScroll", this.disableVerticalScroll);
        hashMap.put("disableHorizontalScroll", this.disableHorizontalScroll);
        hashMap.put("disableContextMenu", this.disableContextMenu);
        hashMap.put("textZoom", this.textZoom);
        hashMap.put("clearSessionCache", this.clearSessionCache);
        hashMap.put("builtInZoomControls", this.builtInZoomControls);
        hashMap.put("displayZoomControls", this.displayZoomControls);
        hashMap.put("supportZoom", this.supportZoom);
        hashMap.put("databaseEnabled", this.databaseEnabled);
        hashMap.put("domStorageEnabled", this.domStorageEnabled);
        hashMap.put("useWideViewPort", this.useWideViewPort);
        hashMap.put("safeBrowsingEnabled", this.safeBrowsingEnabled);
        hashMap.put("mixedContentMode", this.mixedContentMode);
        hashMap.put("allowContentAccess", this.allowContentAccess);
        hashMap.put("allowFileAccess", this.allowFileAccess);
        hashMap.put("allowFileAccessFromFileURLs", this.allowFileAccessFromFileURLs);
        hashMap.put("allowUniversalAccessFromFileURLs", this.allowUniversalAccessFromFileURLs);
        hashMap.put("appCachePath", this.appCachePath);
        hashMap.put("blockNetworkImage", this.blockNetworkImage);
        hashMap.put("blockNetworkLoads", this.blockNetworkLoads);
        hashMap.put("cacheMode", this.cacheMode);
        hashMap.put("cursiveFontFamily", this.cursiveFontFamily);
        hashMap.put("defaultFixedFontSize", this.defaultFixedFontSize);
        hashMap.put("defaultFontSize", this.defaultFontSize);
        hashMap.put("defaultTextEncodingName", this.defaultTextEncodingName);
        hashMap.put("disabledActionModeMenuItems", this.disabledActionModeMenuItems);
        hashMap.put("fantasyFontFamily", this.fantasyFontFamily);
        hashMap.put("fixedFontFamily", this.fixedFontFamily);
        hashMap.put("forceDark", this.forceDark);
        hashMap.put("forceDarkStrategy", this.forceDarkStrategy);
        hashMap.put("geolocationEnabled", this.geolocationEnabled);
        hashMap.put("layoutAlgorithm", getLayoutAlgorithm());
        hashMap.put("loadWithOverviewMode", this.loadWithOverviewMode);
        hashMap.put("loadsImagesAutomatically", this.loadsImagesAutomatically);
        hashMap.put("minimumLogicalFontSize", this.minimumLogicalFontSize);
        hashMap.put("initialScale", this.initialScale);
        hashMap.put("needInitialFocus", this.needInitialFocus);
        hashMap.put("offscreenPreRaster", this.offscreenPreRaster);
        hashMap.put("sansSerifFontFamily", this.sansSerifFontFamily);
        hashMap.put("serifFontFamily", this.serifFontFamily);
        hashMap.put("standardFontFamily", this.standardFontFamily);
        hashMap.put("saveFormData", this.saveFormData);
        hashMap.put("thirdPartyCookiesEnabled", this.thirdPartyCookiesEnabled);
        hashMap.put("hardwareAcceleration", this.hardwareAcceleration);
        hashMap.put("supportMultipleWindows", this.supportMultipleWindows);
        hashMap.put("regexToCancelSubFramesLoading", this.regexToCancelSubFramesLoading);
        hashMap.put("overScrollMode", this.overScrollMode);
        hashMap.put("networkAvailable", this.networkAvailable);
        hashMap.put("scrollBarStyle", this.scrollBarStyle);
        hashMap.put("verticalScrollbarPosition", this.verticalScrollbarPosition);
        hashMap.put("scrollBarDefaultDelayBeforeFade", this.scrollBarDefaultDelayBeforeFade);
        hashMap.put("scrollbarFadingEnabled", this.scrollbarFadingEnabled);
        hashMap.put("scrollBarFadeDuration", this.scrollBarFadeDuration);
        hashMap.put("rendererPriorityPolicy", this.rendererPriorityPolicy);
        hashMap.put("useShouldInterceptRequest", this.useShouldInterceptRequest);
        hashMap.put("useOnRenderProcessGone", this.useOnRenderProcessGone);
        hashMap.put("disableDefaultErrorPage", this.disableDefaultErrorPage);
        hashMap.put("useHybridComposition", this.useHybridComposition);
        hashMap.put("verticalScrollbarThumbColor", this.verticalScrollbarThumbColor);
        hashMap.put("verticalScrollbarTrackColor", this.verticalScrollbarTrackColor);
        hashMap.put("horizontalScrollbarThumbColor", this.horizontalScrollbarThumbColor);
        hashMap.put("horizontalScrollbarTrackColor", this.horizontalScrollbarTrackColor);
        hashMap.put("algorithmicDarkeningAllowed", this.algorithmicDarkeningAllowed);
        hashMap.put("enterpriseAuthenticationAppLinkPolicyEnabled", this.enterpriseAuthenticationAppLinkPolicyEnabled);
        hashMap.put("allowBackgroundAudioPlaying", this.allowBackgroundAudioPlaying);
        hashMap.put("defaultVideoPoster", this.defaultVideoPoster);
        hashMap.put("requestedWithHeaderOriginAllowList", this.requestedWithHeaderOriginAllowList != null ? new ArrayList(this.requestedWithHeaderOriginAllowList) : null);
        return hashMap;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x002c. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<InAppWebViewInterface> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.hashCode();
                key.hashCode();
                char c = 65535;
                switch (key.hashCode()) {
                    case -2116596967:
                        if (key.equals("disableHorizontalScroll")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -2095822429:
                        if (key.equals("scrollBarDefaultDelayBeforeFade")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -2020146208:
                        if (key.equals("useWideViewPort")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -2014672109:
                        if (key.equals("allowFileAccessFromFileURLs")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1931277743:
                        if (key.equals("defaultFontSize")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1851090878:
                        if (key.equals("supportZoom")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -1845480382:
                        if (key.equals("scrollbarFadingEnabled")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -1834028884:
                        if (key.equals("defaultTextEncodingName")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -1746033750:
                        if (key.equals("needInitialFocus")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -1712086669:
                        if (key.equals("useShouldOverrideUrlLoading")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -1673892229:
                        if (key.equals("preferredContentMode")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -1657552268:
                        if (key.equals("allowContentAccess")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -1626497241:
                        if (key.equals("fixedFontFamily")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case -1615103092:
                        if (key.equals("builtInZoomControls")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -1607633676:
                        if (key.equals("javaScriptEnabled")) {
                            c = 14;
                            break;
                        }
                        break;
                    case -1578962296:
                        if (key.equals("hardwareAcceleration")) {
                            c = 15;
                            break;
                        }
                        break;
                    case -1578507205:
                        if (key.equals("networkAvailable")) {
                            c = 16;
                            break;
                        }
                        break;
                    case -1574470051:
                        if (key.equals("useShouldInterceptFetchRequest")) {
                            c = 17;
                            break;
                        }
                        break;
                    case -1480607106:
                        if (key.equals("loadsImagesAutomatically")) {
                            c = 18;
                            break;
                        }
                        break;
                    case -1455624881:
                        if (key.equals("resourceCustomSchemes")) {
                            c = 19;
                            break;
                        }
                        break;
                    case -1443655540:
                        if (key.equals("disabledActionModeMenuItems")) {
                            c = 20;
                            break;
                        }
                        break;
                    case -1423657812:
                        if (key.equals("incognito")) {
                            c = 21;
                            break;
                        }
                        break;
                    case -1410791825:
                        if (key.equals("allowBackgroundAudioPlaying")) {
                            c = 22;
                            break;
                        }
                        break;
                    case -1349570230:
                        if (key.equals("webViewAssetLoader")) {
                            c = 23;
                            break;
                        }
                        break;
                    case -1321236988:
                        if (key.equals("overScrollMode")) {
                            c = 24;
                            break;
                        }
                        break;
                    case -1146673624:
                        if (key.equals("domStorageEnabled")) {
                            c = 25;
                            break;
                        }
                        break;
                    case -1143245914:
                        if (key.equals("disableContextMenu")) {
                            c = 26;
                            break;
                        }
                        break;
                    case -1038715033:
                        if (key.equals("useShouldInterceptAjaxRequest")) {
                            c = 27;
                            break;
                        }
                        break;
                    case -1003454816:
                        if (key.equals("textZoom")) {
                            c = 28;
                            break;
                        }
                        break;
                    case -868328270:
                        if (key.equals("interceptOnlyAsyncAjaxRequests")) {
                            c = 29;
                            break;
                        }
                        break;
                    case -800676066:
                        if (key.equals("minimumFontSize")) {
                            c = 30;
                            break;
                        }
                        break;
                    case -767637403:
                        if (key.equals("layoutAlgorithm")) {
                            c = 31;
                            break;
                        }
                        break;
                    case -759238347:
                        if (key.equals("clearCache")) {
                            c = ' ';
                            break;
                        }
                        break;
                    case -742944736:
                        if (key.equals("transparentBackground")) {
                            c = '!';
                            break;
                        }
                        break;
                    case -741649011:
                        if (key.equals("enterpriseAuthenticationAppLinkPolicyEnabled")) {
                            c = Typography.quote;
                            break;
                        }
                        break;
                    case -728016272:
                        if (key.equals("allowUniversalAccessFromFileURLs")) {
                            c = '#';
                            break;
                        }
                        break;
                    case -710246074:
                        if (key.equals("databaseEnabled")) {
                            c = Typography.dollar;
                            break;
                        }
                        break;
                    case -706772569:
                        if (key.equals("useShouldInterceptRequest")) {
                            c = '%';
                            break;
                        }
                        break;
                    case -553792443:
                        if (key.equals("cacheMode")) {
                            c = Typography.amp;
                            break;
                        }
                        break;
                    case -443422049:
                        if (key.equals("horizontalScrollBarEnabled")) {
                            c = '\'';
                            break;
                        }
                        break;
                    case -435719349:
                        if (key.equals("scrollBarStyle")) {
                            c = '(';
                            break;
                        }
                        break;
                    case -421090202:
                        if (key.equals("initialScale")) {
                            c = ')';
                            break;
                        }
                        break;
                    case -321425255:
                        if (key.equals("verticalScrollbarPosition")) {
                            c = '*';
                            break;
                        }
                        break;
                    case -229178645:
                        if (key.equals("disableVerticalScroll")) {
                            c = '+';
                            break;
                        }
                        break;
                    case -227577491:
                        if (key.equals("javaScriptCanOpenWindowsAutomatically")) {
                            c = ',';
                            break;
                        }
                        break;
                    case -225496870:
                        if (key.equals("horizontalScrollbarTrackColor")) {
                            c = '-';
                            break;
                        }
                        break;
                    case -225165915:
                        if (key.equals("offscreenPreRaster")) {
                            c = '.';
                            break;
                        }
                        break;
                    case -216514471:
                        if (key.equals("fantasyFontFamily")) {
                            c = IOUtils.DIR_SEPARATOR_UNIX;
                            break;
                        }
                        break;
                    case -158057575:
                        if (key.equals("rendererPriorityPolicy")) {
                            c = '0';
                            break;
                        }
                        break;
                    case -98561827:
                        if (key.equals("sansSerifFontFamily")) {
                            c = '1';
                            break;
                        }
                        break;
                    case 57717170:
                        if (key.equals("regexToCancelSubFramesLoading")) {
                            c = '2';
                            break;
                        }
                        break;
                    case 100868168:
                        if (key.equals("verticalScrollbarTrackColor")) {
                            c = '3';
                            break;
                        }
                        break;
                    case 174479508:
                        if (key.equals("useOnDownloadStart")) {
                            c = '4';
                            break;
                        }
                        break;
                    case 229242772:
                        if (key.equals("forceDarkStrategy")) {
                            c = '5';
                            break;
                        }
                        break;
                    case 257886264:
                        if (key.equals("cursiveFontFamily")) {
                            c = '6';
                            break;
                        }
                        break;
                    case 273267153:
                        if (key.equals("mediaPlaybackRequiresUserGesture")) {
                            c = '7';
                            break;
                        }
                        break;
                    case 296040698:
                        if (key.equals("blockNetworkImage")) {
                            c = '8';
                            break;
                        }
                        break;
                    case 298870764:
                        if (key.equals("blockNetworkLoads")) {
                            c = '9';
                            break;
                        }
                        break;
                    case 311430650:
                        if (key.equals("userAgent")) {
                            c = ':';
                            break;
                        }
                        break;
                    case 387230482:
                        if (key.equals("useOnRenderProcessGone")) {
                            c = ';';
                            break;
                        }
                        break;
                    case 393481210:
                        if (key.equals("useOnLoadResource")) {
                            c = Typography.less;
                            break;
                        }
                        break;
                    case 397237599:
                        if (key.equals("cacheEnabled")) {
                            c = '=';
                            break;
                        }
                        break;
                    case 408799019:
                        if (key.equals("saveFormData")) {
                            c = Typography.greater;
                            break;
                        }
                        break;
                    case 477312960:
                        if (key.equals("requestedWithHeaderOriginAllowList")) {
                            c = '?';
                            break;
                        }
                        break;
                    case 487904071:
                        if (key.equals("useHybridComposition")) {
                            c = '@';
                            break;
                        }
                        break;
                    case 590869196:
                        if (key.equals("applicationNameForUserAgent")) {
                            c = 'A';
                            break;
                        }
                        break;
                    case 760962753:
                        if (key.equals("mixedContentMode")) {
                            c = 'B';
                            break;
                        }
                        break;
                    case 849171798:
                        if (key.equals("scrollBarFadeDuration")) {
                            c = 'C';
                            break;
                        }
                        break;
                    case 1138246185:
                        if (key.equals("allowFileAccess")) {
                            c = 'D';
                            break;
                        }
                        break;
                    case 1156608422:
                        if (key.equals("appCachePath")) {
                            c = 'E';
                            break;
                        }
                        break;
                    case 1193086767:
                        if (key.equals("horizontalScrollbarThumbColor")) {
                            c = 'F';
                            break;
                        }
                        break;
                    case 1301942064:
                        if (key.equals("standardFontFamily")) {
                            c = 'G';
                            break;
                        }
                        break;
                    case 1320461707:
                        if (key.equals("displayZoomControls")) {
                            c = 'H';
                            break;
                        }
                        break;
                    case 1344414299:
                        if (key.equals("geolocationEnabled")) {
                            c = 'I';
                            break;
                        }
                        break;
                    case 1409728424:
                        if (key.equals("loadWithOverviewMode")) {
                            c = 'J';
                            break;
                        }
                        break;
                    case 1474890029:
                        if (key.equals("safeBrowsingEnabled")) {
                            c = 'K';
                            break;
                        }
                        break;
                    case 1496887792:
                        if (key.equals("serifFontFamily")) {
                            c = 'L';
                            break;
                        }
                        break;
                    case 1519451805:
                        if (key.equals("verticalScrollbarThumbColor")) {
                            c = 'M';
                            break;
                        }
                        break;
                    case 1527546113:
                        if (key.equals("forceDark")) {
                            c = 'N';
                            break;
                        }
                        break;
                    case 1583791742:
                        if (key.equals("disableDefaultErrorPage")) {
                            c = 'O';
                            break;
                        }
                        break;
                    case 1759079762:
                        if (key.equals("contentBlockers")) {
                            c = 'P';
                            break;
                        }
                        break;
                    case 1774215812:
                        if (key.equals("supportMultipleWindows")) {
                            c = 'Q';
                            break;
                        }
                        break;
                    case 1793491907:
                        if (key.equals("defaultFixedFontSize")) {
                            c = 'R';
                            break;
                        }
                        break;
                    case 1812525393:
                        if (key.equals("thirdPartyCookiesEnabled")) {
                            c = 'S';
                            break;
                        }
                        break;
                    case 1956631083:
                        if (key.equals("minimumLogicalFontSize")) {
                            c = 'T';
                            break;
                        }
                        break;
                    case 2011947505:
                        if (key.equals("verticalScrollBarEnabled")) {
                            c = 'U';
                            break;
                        }
                        break;
                    case 2038327673:
                        if (key.equals("clearSessionCache")) {
                            c = 'V';
                            break;
                        }
                        break;
                    case 2056553639:
                        if (key.equals("defaultVideoPoster")) {
                            c = 'W';
                            break;
                        }
                        break;
                    case 2086547246:
                        if (key.equals("algorithmicDarkeningAllowed")) {
                            c = 'X';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.disableHorizontalScroll = (Boolean) value;
                        break;
                    case 1:
                        this.scrollBarDefaultDelayBeforeFade = (Integer) value;
                        break;
                    case 2:
                        this.useWideViewPort = (Boolean) value;
                        break;
                    case 3:
                        this.allowFileAccessFromFileURLs = (Boolean) value;
                        break;
                    case 4:
                        this.defaultFontSize = (Integer) value;
                        break;
                    case 5:
                        this.supportZoom = (Boolean) value;
                        break;
                    case 6:
                        this.scrollbarFadingEnabled = (Boolean) value;
                        break;
                    case 7:
                        this.defaultTextEncodingName = (String) value;
                        break;
                    case '\b':
                        this.needInitialFocus = (Boolean) value;
                        break;
                    case '\t':
                        this.useShouldOverrideUrlLoading = (Boolean) value;
                        break;
                    case '\n':
                        this.preferredContentMode = (Integer) value;
                        break;
                    case 11:
                        this.allowContentAccess = (Boolean) value;
                        break;
                    case '\f':
                        this.fixedFontFamily = (String) value;
                        break;
                    case '\r':
                        this.builtInZoomControls = (Boolean) value;
                        break;
                    case 14:
                        this.javaScriptEnabled = (Boolean) value;
                        break;
                    case 15:
                        this.hardwareAcceleration = (Boolean) value;
                        break;
                    case 16:
                        this.networkAvailable = (Boolean) value;
                        break;
                    case 17:
                        this.useShouldInterceptFetchRequest = (Boolean) value;
                        break;
                    case 18:
                        this.loadsImagesAutomatically = (Boolean) value;
                        break;
                    case 19:
                        this.resourceCustomSchemes = (List) value;
                        break;
                    case 20:
                        this.disabledActionModeMenuItems = (Integer) value;
                        break;
                    case 21:
                        this.incognito = (Boolean) value;
                        break;
                    case 22:
                        this.allowBackgroundAudioPlaying = (Boolean) value;
                        break;
                    case 23:
                        this.webViewAssetLoader = (Map) value;
                        break;
                    case 24:
                        this.overScrollMode = (Integer) value;
                        break;
                    case 25:
                        this.domStorageEnabled = (Boolean) value;
                        break;
                    case 26:
                        this.disableContextMenu = (Boolean) value;
                        break;
                    case 27:
                        this.useShouldInterceptAjaxRequest = (Boolean) value;
                        break;
                    case 28:
                        this.textZoom = (Integer) value;
                        break;
                    case 29:
                        this.interceptOnlyAsyncAjaxRequests = (Boolean) value;
                        break;
                    case 30:
                        this.minimumFontSize = (Integer) value;
                        break;
                    case 31:
                        setLayoutAlgorithm((String) value);
                        break;
                    case ' ':
                        this.clearCache = (Boolean) value;
                        break;
                    case '!':
                        this.transparentBackground = (Boolean) value;
                        break;
                    case '\"':
                        this.enterpriseAuthenticationAppLinkPolicyEnabled = (Boolean) value;
                        break;
                    case '#':
                        this.allowUniversalAccessFromFileURLs = (Boolean) value;
                        break;
                    case '$':
                        this.databaseEnabled = (Boolean) value;
                        break;
                    case '%':
                        this.useShouldInterceptRequest = (Boolean) value;
                        break;
                    case '&':
                        this.cacheMode = (Integer) value;
                        break;
                    case '\'':
                        this.horizontalScrollBarEnabled = (Boolean) value;
                        break;
                    case '(':
                        this.scrollBarStyle = (Integer) value;
                        break;
                    case ')':
                        this.initialScale = (Integer) value;
                        break;
                    case '*':
                        this.verticalScrollbarPosition = (Integer) value;
                        break;
                    case '+':
                        this.disableVerticalScroll = (Boolean) value;
                        break;
                    case ',':
                        this.javaScriptCanOpenWindowsAutomatically = (Boolean) value;
                        break;
                    case '-':
                        this.horizontalScrollbarTrackColor = (String) value;
                        break;
                    case '.':
                        this.offscreenPreRaster = (Boolean) value;
                        break;
                    case '/':
                        this.fantasyFontFamily = (String) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        this.rendererPriorityPolicy = (Map) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        this.sansSerifFontFamily = (String) value;
                        break;
                    case '2':
                        this.regexToCancelSubFramesLoading = (String) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        this.verticalScrollbarTrackColor = (String) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        this.useOnDownloadStart = (Boolean) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        this.forceDarkStrategy = (Integer) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        this.cursiveFontFamily = (String) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        this.mediaPlaybackRequiresUserGesture = (Boolean) value;
                        break;
                    case '8':
                        this.blockNetworkImage = (Boolean) value;
                        break;
                    case '9':
                        this.blockNetworkLoads = (Boolean) value;
                        break;
                    case ':':
                        this.userAgent = (String) value;
                        break;
                    case ';':
                        this.useOnRenderProcessGone = (Boolean) value;
                        break;
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        this.useOnLoadResource = (Boolean) value;
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        this.cacheEnabled = (Boolean) value;
                        break;
                    case '>':
                        this.saveFormData = (Boolean) value;
                        break;
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        this.requestedWithHeaderOriginAllowList = new HashSet((List) value);
                        break;
                    case '@':
                        this.useHybridComposition = (Boolean) value;
                        break;
                    case 'A':
                        this.applicationNameForUserAgent = (String) value;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        this.mixedContentMode = (Integer) value;
                        break;
                    case 'C':
                        this.scrollBarFadeDuration = (Integer) value;
                        break;
                    case 'D':
                        this.allowFileAccess = (Boolean) value;
                        break;
                    case 'E':
                        this.appCachePath = (String) value;
                        break;
                    case 'F':
                        this.horizontalScrollbarThumbColor = (String) value;
                        break;
                    case TsExtractor.TS_SYNC_BYTE /* 71 */:
                        this.standardFontFamily = (String) value;
                        break;
                    case 'H':
                        this.displayZoomControls = (Boolean) value;
                        break;
                    case 'I':
                        this.geolocationEnabled = (Boolean) value;
                        break;
                    case 'J':
                        this.loadWithOverviewMode = (Boolean) value;
                        break;
                    case 'K':
                        this.safeBrowsingEnabled = (Boolean) value;
                        break;
                    case Base64.mimeLineLength /* 76 */:
                        this.serifFontFamily = (String) value;
                        break;
                    case 'M':
                        this.verticalScrollbarThumbColor = (String) value;
                        break;
                    case 'N':
                        this.forceDark = (Integer) value;
                        break;
                    case 'O':
                        this.disableDefaultErrorPage = (Boolean) value;
                        break;
                    case 'P':
                        this.contentBlockers = (List) value;
                        break;
                    case 'Q':
                        this.supportMultipleWindows = (Boolean) value;
                        break;
                    case 'R':
                        this.defaultFixedFontSize = (Integer) value;
                        break;
                    case 'S':
                        this.thirdPartyCookiesEnabled = (Boolean) value;
                        break;
                    case 'T':
                        this.minimumLogicalFontSize = (Integer) value;
                        break;
                    case 'U':
                        this.verticalScrollBarEnabled = (Boolean) value;
                        break;
                    case 'V':
                        this.clearSessionCache = (Boolean) value;
                        break;
                    case 'W':
                        this.defaultVideoPoster = (byte[]) value;
                        break;
                    case 'X':
                        this.algorithmicDarkeningAllowed = (Boolean) value;
                        break;
                }
            }
        }
        return this;
    }
}
