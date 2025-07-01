package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsService;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class CustomTabsHelper {
    static final String BETA_PACKAGE = "com.chrome.beta";
    static final String DEV_PACKAGE = "com.chrome.dev";
    protected static final String EXTRA_CUSTOM_TABS_KEEP_ALIVE = "android.support.customtabs.extra.KEEP_ALIVE";
    static final String LOCAL_PACKAGE = "com.google.android.apps.chrome";
    static final String STABLE_PACKAGE = "com.android.chrome";
    protected static final String TAG = "CustomTabsHelper";
    private static String sPackageNameToUse;

    private CustomTabsHelper() {
    }

    public static void addKeepAliveExtra(Context context, Intent intent) {
        intent.putExtra(EXTRA_CUSTOM_TABS_KEEP_ALIVE, new Intent().setClassName(context.getPackageName(), KeepAliveService.class.getCanonicalName()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b2, code lost:
    
        if (r6.contains(com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.CustomTabsHelper.LOCAL_PACKAGE) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getPackageNameToUse(Context context) {
        String str;
        String str2 = sPackageNameToUse;
        if (str2 != null) {
            return str2;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        intent.addCategory("android.intent.category.BROWSABLE");
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str3 = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 131072);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            sPackageNameToUse = null;
        } else {
            if (arrayList.size() == 1) {
                str = (String) arrayList.get(0);
            } else if (TextUtils.isEmpty(str3) || hasSpecializedHandlerIntents(context, intent) || !arrayList.contains(str3)) {
                str = STABLE_PACKAGE;
                if (!arrayList.contains(STABLE_PACKAGE)) {
                    str = BETA_PACKAGE;
                    if (!arrayList.contains(BETA_PACKAGE)) {
                        str = DEV_PACKAGE;
                        if (!arrayList.contains(DEV_PACKAGE)) {
                            str = LOCAL_PACKAGE;
                        }
                    }
                }
            } else {
                sPackageNameToUse = str3;
            }
            sPackageNameToUse = str;
        }
        return sPackageNameToUse;
    }

    public static String[] getPackages() {
        return new String[]{"", STABLE_PACKAGE, BETA_PACKAGE, DEV_PACKAGE, LOCAL_PACKAGE};
    }

    private static boolean hasSpecializedHandlerIntents(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException unused) {
            Log.e(TAG, "Runtime exception while getting specialized handlers");
        }
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
