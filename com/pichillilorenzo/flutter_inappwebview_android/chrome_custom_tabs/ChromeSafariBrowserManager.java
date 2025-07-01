package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class ChromeSafariBrowserManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "ChromeBrowserManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_chromesafaribrowser";
    public static final Map<String, ChromeSafariBrowserManager> shared = new HashMap();
    public final Map<String, ChromeCustomTabsActivity> browsers;
    public String id;
    public InAppWebViewFlutterPlugin plugin;

    public ChromeSafariBrowserManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.browsers = new HashMap();
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
        this.plugin = inAppWebViewFlutterPlugin;
        shared.put(uuid, this);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        for (ChromeCustomTabsActivity chromeCustomTabsActivity : this.browsers.values()) {
            if (chromeCustomTabsActivity != null) {
                chromeCustomTabsActivity.close();
                chromeCustomTabsActivity.dispose();
            }
        }
        this.browsers.clear();
        shared.remove(this.id);
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Object valueOf;
        Activity activity;
        String str = (String) methodCall.argument(TtmlNode.ATTR_ID);
        String str2 = methodCall.method;
        str2.hashCode();
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1382009261:
                if (str2.equals("getMaxToolbarItems")) {
                    c = 0;
                    break;
                }
                break;
            case 3417674:
                if (str2.equals(TtmlNode.TEXT_EMPHASIS_MARK_OPEN)) {
                    c = 1;
                    break;
                }
                break;
            case 268490427:
                if (str2.equals("getPackageName")) {
                    c = 2;
                    break;
                }
                break;
            case 444517567:
                if (str2.equals("isAvailable")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                valueOf = Integer.valueOf(CustomTabsIntent.getMaxToolbarItems());
                result.success(valueOf);
            case 1:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
                if (inAppWebViewFlutterPlugin != null && inAppWebViewFlutterPlugin.activity != null) {
                    open(this.plugin.activity, str, (String) methodCall.argument(ImagesContract.URL), (HashMap) methodCall.argument("headers"), (String) methodCall.argument("referrer"), (ArrayList) methodCall.argument("otherLikelyURLs"), (HashMap) methodCall.argument("settings"), (HashMap) methodCall.argument("actionButton"), (HashMap) methodCall.argument("secondaryToolbar"), (List) methodCall.argument("menuItemList"), result);
                    return;
                }
                break;
            case 2:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.plugin;
                valueOf = (inAppWebViewFlutterPlugin2 == null || inAppWebViewFlutterPlugin2.activity == null) ? null : CustomTabsClient.getPackageName(this.plugin.activity, (ArrayList) methodCall.argument("packages"), ((Boolean) methodCall.argument("ignoreDefault")).booleanValue());
                result.success(valueOf);
            case 3:
                InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin3 = this.plugin;
                if (inAppWebViewFlutterPlugin3 != null && (activity = inAppWebViewFlutterPlugin3.activity) != null) {
                    valueOf = Boolean.valueOf(CustomTabActivityHelper.isAvailable(activity));
                    result.success(valueOf);
                }
                break;
            default:
                result.notImplemented();
                return;
        }
        valueOf = Boolean.FALSE;
        result.success(valueOf);
    }

    public void open(Activity activity, String str, String str2, HashMap<String, Object> hashMap, String str3, ArrayList<String> arrayList, HashMap<String, Object> hashMap2, HashMap<String, Object> hashMap3, HashMap<String, Object> hashMap4, List<HashMap<String, Object>> list, MethodChannel.Result result) {
        Bundle bundle = new Bundle();
        bundle.putString(ImagesContract.URL, str2);
        bundle.putString(TtmlNode.ATTR_ID, str);
        bundle.putString("managerId", this.id);
        bundle.putSerializable("headers", hashMap);
        bundle.putString("referrer", str3);
        bundle.putSerializable("otherLikelyURLs", arrayList);
        bundle.putSerializable("settings", hashMap2);
        bundle.putSerializable("actionButton", hashMap3);
        bundle.putSerializable("secondaryToolbar", hashMap4);
        bundle.putSerializable("menuItemList", (Serializable) list);
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = (Boolean) Util.getOrDefault(hashMap2, "isSingleInstance", bool);
        Boolean bool3 = (Boolean) Util.getOrDefault(hashMap2, "isTrustedWebActivity", bool);
        if (!CustomTabActivityHelper.isAvailable(activity)) {
            result.error(LOG_TAG, "ChromeCustomTabs is not available!", null);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) (!bool2.booleanValue() ? !bool3.booleanValue() ? ChromeCustomTabsActivity.class : TrustedWebActivity.class : !bool3.booleanValue() ? ChromeCustomTabsActivitySingleInstance.class : TrustedWebActivitySingleInstance.class));
        intent.putExtras(bundle);
        if (((Boolean) Util.getOrDefault(hashMap2, "noHistory", bool)).booleanValue()) {
            intent.addFlags(1073741824);
        }
        activity.startActivity(intent);
        result.success(Boolean.TRUE);
    }
}
