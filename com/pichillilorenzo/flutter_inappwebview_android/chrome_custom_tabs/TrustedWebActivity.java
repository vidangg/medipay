package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import androidx.browser.trusted.TrustedWebActivityIntent;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class TrustedWebActivity extends ChromeCustomTabsActivity {
    protected static final String LOG_TAG = "TrustedWebActivity";
    public TrustedWebActivityIntentBuilder builder;

    private void prepareCustomTabs() {
        CustomTabColorSchemeParams.Builder builder = new CustomTabColorSchemeParams.Builder();
        String str = this.customSettings.toolbarBackgroundColor;
        if (str != null && !str.isEmpty()) {
            builder.setToolbarColor(Color.parseColor(this.customSettings.toolbarBackgroundColor));
        }
        String str2 = this.customSettings.navigationBarColor;
        if (str2 != null && !str2.isEmpty()) {
            builder.setNavigationBarColor(Color.parseColor(this.customSettings.navigationBarColor));
        }
        String str3 = this.customSettings.navigationBarDividerColor;
        if (str3 != null && !str3.isEmpty()) {
            builder.setNavigationBarDividerColor(Color.parseColor(this.customSettings.navigationBarDividerColor));
        }
        String str4 = this.customSettings.secondaryToolbarColor;
        if (str4 != null && !str4.isEmpty()) {
            builder.setSecondaryToolbarColor(Color.parseColor(this.customSettings.secondaryToolbarColor));
        }
        this.builder.setDefaultColorSchemeParams(builder.build());
        List<String> list = this.customSettings.additionalTrustedOrigins;
        if (list != null && !list.isEmpty()) {
            this.builder.setAdditionalTrustedOrigins(this.customSettings.additionalTrustedOrigins);
        }
        TrustedWebActivityDisplayMode trustedWebActivityDisplayMode = this.customSettings.displayMode;
        if (trustedWebActivityDisplayMode != null) {
            this.builder.setDisplayMode(trustedWebActivityDisplayMode);
        }
        this.builder.setScreenOrientation(this.customSettings.screenOrientation.intValue());
    }

    private void prepareCustomTabsIntent(TrustedWebActivityIntent trustedWebActivityIntent) {
        Intent intent = trustedWebActivityIntent.getIntent();
        String str = this.customSettings.packageName;
        if (str == null) {
            str = CustomTabsHelper.getPackageNameToUse(this);
        }
        intent.setPackage(str);
        if (this.customSettings.keepAliveEnabled.booleanValue()) {
            CustomTabsHelper.addKeepAliveExtra(this, intent);
        }
        if (this.customSettings.alwaysUseBrowserUI.booleanValue()) {
            CustomTabsIntent.setAlwaysUseBrowserUI(intent);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity
    public void launchUrl(String str, Map<String, String> map, String str2, List<String> list) {
        if (this.customTabsSession == null) {
            return;
        }
        Uri parse = Uri.parse(str);
        mayLaunchUrl(str, list);
        this.builder = new TrustedWebActivityIntentBuilder(parse);
        prepareCustomTabs();
        TrustedWebActivityIntent build = this.builder.build(this.customTabsSession);
        prepareCustomTabsIntent(build);
        CustomTabActivityHelper.openTrustedWebActivity(this, build, parse, map, str2 != null ? Uri.parse(str2) : null, 100);
    }
}
