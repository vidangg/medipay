package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsSecondaryToolbar;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class ChromeCustomTabsChannelDelegate extends ChannelDelegateImpl {
    private ChromeCustomTabsActivity chromeCustomTabsActivity;

    public ChromeCustomTabsChannelDelegate(ChromeCustomTabsActivity chromeCustomTabsActivity, MethodChannel methodChannel) {
        super(methodChannel);
        this.chromeCustomTabsActivity = chromeCustomTabsActivity;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.chromeCustomTabsActivity = null;
    }

    public void onClosed() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onClosed", new HashMap());
    }

    public void onCompletedInitialLoad() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onCompletedInitialLoad", new HashMap());
    }

    public void onGreatestScrollPercentageIncreased(int i) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scrollPercentage", Integer.valueOf(i));
        channel.invokeMethod("onGreatestScrollPercentageIncreased", hashMap);
    }

    public void onItemActionPerform(int i, String str, String str2) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TtmlNode.ATTR_ID, Integer.valueOf(i));
        hashMap.put(ImagesContract.URL, str);
        hashMap.put("title", str2);
        channel.invokeMethod("onItemActionPerform", hashMap);
    }

    public void onMessageChannelReady() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onMessageChannelReady", new HashMap());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x007c. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        CustomTabsSession customTabsSession;
        String str;
        Object obj;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        Activity activity;
        boolean validateRelationship;
        String str2 = methodCall.method;
        str2.hashCode();
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1526944655:
                if (str2.equals("isEngagementSignalsApiAvailable")) {
                    c = 0;
                    break;
                }
                break;
            case -675108676:
                if (str2.equals("launchUrl")) {
                    c = 1;
                    break;
                }
                break;
            case -334843312:
                if (str2.equals("updateSecondaryToolbar")) {
                    c = 2;
                    break;
                }
                break;
            case 50870385:
                if (str2.equals("updateActionButton")) {
                    c = 3;
                    break;
                }
                break;
            case 94756344:
                if (str2.equals("close")) {
                    c = 4;
                    break;
                }
                break;
            case 1256059502:
                if (str2.equals("validateRelationship")) {
                    c = 5;
                    break;
                }
                break;
            case 1392239787:
                if (str2.equals("requestPostMessageChannel")) {
                    c = 6;
                    break;
                }
                break;
            case 1490029383:
                if (str2.equals("postMessage")) {
                    c = 7;
                    break;
                }
                break;
            case 2000053463:
                if (str2.equals("mayLaunchUrl")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ChromeCustomTabsActivity chromeCustomTabsActivity = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity != null && (customTabsSession = chromeCustomTabsActivity.customTabsSession) != null) {
                    try {
                        result.success(Boolean.valueOf(customTabsSession.isEngagementSignalsApiAvailable(new Bundle())));
                        return;
                    } catch (Throwable unused) {
                    }
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 1:
                if (this.chromeCustomTabsActivity != null && (str = (String) methodCall.argument(ImagesContract.URL)) != null) {
                    this.chromeCustomTabsActivity.launchUrl(str, (Map) methodCall.argument("headers"), (String) methodCall.argument("referrer"), (List) methodCall.argument("otherLikelyURLs"));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 2:
                if (this.chromeCustomTabsActivity != null) {
                    this.chromeCustomTabsActivity.updateSecondaryToolbar(CustomTabsSecondaryToolbar.fromMap((Map) methodCall.argument("secondaryToolbar")));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 3:
                if (this.chromeCustomTabsActivity != null) {
                    this.chromeCustomTabsActivity.updateActionButton((byte[]) methodCall.argument("icon"), (String) methodCall.argument("description"));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 4:
                ChromeCustomTabsActivity chromeCustomTabsActivity2 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity2 != null) {
                    chromeCustomTabsActivity2.onStop();
                    this.chromeCustomTabsActivity.onDestroy();
                    this.chromeCustomTabsActivity.close();
                    ChromeSafariBrowserManager chromeSafariBrowserManager = this.chromeCustomTabsActivity.manager;
                    if (chromeSafariBrowserManager != null && (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) != null && (activity = inAppWebViewFlutterPlugin.activity) != null) {
                        Intent intent = new Intent(activity, activity.getClass());
                        intent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                        intent.addFlags(C.BUFFER_FLAG_LAST_SAMPLE);
                        activity.startActivity(intent);
                    }
                    this.chromeCustomTabsActivity.dispose();
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 5:
                ChromeCustomTabsActivity chromeCustomTabsActivity3 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity3 != null && chromeCustomTabsActivity3.customTabsSession != null) {
                    validateRelationship = this.chromeCustomTabsActivity.customTabsSession.validateRelationship(((Integer) methodCall.argument("relation")).intValue(), Uri.parse((String) methodCall.argument("origin")), null);
                    obj = Boolean.valueOf(validateRelationship);
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 6:
                ChromeCustomTabsActivity chromeCustomTabsActivity4 = this.chromeCustomTabsActivity;
                if (chromeCustomTabsActivity4 != null && chromeCustomTabsActivity4.customTabsSession != null) {
                    String str3 = (String) methodCall.argument("sourceOrigin");
                    String str4 = (String) methodCall.argument("targetOrigin");
                    validateRelationship = this.chromeCustomTabsActivity.customTabsSession.requestPostMessageChannel(Uri.parse(str3), str4 != null ? Uri.parse(str4) : null, new Bundle());
                    obj = Boolean.valueOf(validateRelationship);
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 7:
                ChromeCustomTabsActivity chromeCustomTabsActivity5 = this.chromeCustomTabsActivity;
                obj = Integer.valueOf((chromeCustomTabsActivity5 == null || chromeCustomTabsActivity5.customTabsSession == null) ? -3 : this.chromeCustomTabsActivity.customTabsSession.postMessage((String) methodCall.argument(Constant.PARAM_ERROR_MESSAGE), new Bundle()));
                result.success(obj);
                return;
            case '\b':
                if (this.chromeCustomTabsActivity != null) {
                    validateRelationship = this.chromeCustomTabsActivity.mayLaunchUrl((String) methodCall.argument(ImagesContract.URL), (List) methodCall.argument("otherLikelyURLs"));
                    obj = Boolean.valueOf(validateRelationship);
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void onNavigationEvent(int i) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("navigationEvent", Integer.valueOf(i));
        channel.invokeMethod("onNavigationEvent", hashMap);
    }

    public void onOpened() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onOpened", new HashMap());
    }

    public void onPostMessage(String str) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constant.PARAM_ERROR_MESSAGE, str);
        channel.invokeMethod("onPostMessage", hashMap);
    }

    public void onRelationshipValidationResult(int i, Uri uri, boolean z) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("relation", Integer.valueOf(i));
        hashMap.put("requestedOrigin", uri.toString());
        hashMap.put(Constant.PARAM_RESULT, Boolean.valueOf(z));
        channel.invokeMethod("onRelationshipValidationResult", hashMap);
    }

    public void onSecondaryItemActionPerform(String str, String str2) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put(ImagesContract.URL, str2);
        channel.invokeMethod("onSecondaryItemActionPerform", hashMap);
    }

    public void onServiceConnected() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onServiceConnected", new HashMap());
    }

    public void onSessionEnded(boolean z) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("didUserInteract", Boolean.valueOf(z));
        channel.invokeMethod("onSessionEnded", hashMap);
    }

    public void onVerticalScrollEvent(boolean z) {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isDirectionUp", Boolean.valueOf(z));
        channel.invokeMethod("onVerticalScrollEvent", hashMap);
    }
}
