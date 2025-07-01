package com.pichillilorenzo.flutter_inappwebview_android.in_app_browser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.internal.AssetHelper;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.R;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.find_interaction.FindInteractionController;
import com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh.PullToRefreshChannelDelegate;
import com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh.PullToRefreshLayout;
import com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh.PullToRefreshSettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.AndroidResource;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.InAppBrowserMenuItem;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview_android.types.UserScript;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewManager;
import com.pichillilorenzo.flutter_inappwebview_android.webview.WebViewChannelDelegate;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewChromeClient;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.InAppWebViewSettings;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class InAppBrowserActivity extends AppCompatActivity implements InAppBrowserDelegate, Disposable {
    protected static final String LOG_TAG = "InAppBrowserActivity";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappbrowser_";
    public ActionBar actionBar;
    public InAppBrowserChannelDelegate channelDelegate;
    public String fromActivity;
    public String id;
    public InAppBrowserManager manager;
    public Menu menu;
    public ProgressBar progressBar;
    public PullToRefreshLayout pullToRefreshLayout;
    public SearchView searchView;
    public InAppWebView webView;
    public Integer windowId;
    public InAppBrowserSettings customSettings = new InAppBrowserSettings();
    public boolean isHidden = false;
    private List<ActivityResultListener> activityResultListeners = new ArrayList();
    public List<InAppBrowserMenuItem> menuItems = new ArrayList();

    private void prepareView() {
        ProgressBar progressBar;
        int i;
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.prepare();
        }
        if (this.customSettings.hidden.booleanValue()) {
            hide();
        } else {
            show();
        }
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar);
        this.progressBar = progressBar2;
        if (progressBar2 != null) {
            if (this.customSettings.hideProgressBar.booleanValue()) {
                progressBar = this.progressBar;
                i = 0;
            } else {
                progressBar = this.progressBar;
                i = 100;
            }
            progressBar.setMax(i);
        }
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(!this.customSettings.hideTitleBar.booleanValue());
            if (this.customSettings.hideToolbarTop.booleanValue()) {
                this.actionBar.hide();
            }
            String str = this.customSettings.toolbarTopBackgroundColor;
            if (str != null && !str.isEmpty()) {
                this.actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.customSettings.toolbarTopBackgroundColor)));
            }
            String str2 = this.customSettings.toolbarTopFixedTitle;
            if (str2 == null || str2.isEmpty()) {
                return;
            }
            this.actionBar.setTitle(this.customSettings.toolbarTopFixedTitle);
        }
    }

    public boolean canGoBack() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            return inAppWebView.canGoBack();
        }
        return false;
    }

    public boolean canGoForward() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            return inAppWebView.canGoForward();
        }
        return false;
    }

    public void close(MethodChannel.Result result) {
        InAppBrowserChannelDelegate inAppBrowserChannelDelegate = this.channelDelegate;
        if (inAppBrowserChannelDelegate != null) {
            inAppBrowserChannelDelegate.onExit();
        }
        dispose();
        if (result != null) {
            result.success(Boolean.TRUE);
        }
    }

    public void closeButtonClicked(MenuItem menuItem) {
        close(null);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public void didChangeProgress(int i) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            this.progressBar.setProgress(i, true);
            if (i == 100) {
                this.progressBar.setVisibility(8);
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public void didChangeTitle(String str) {
        if (this.actionBar != null) {
            String str2 = this.customSettings.toolbarTopFixedTitle;
            if (str2 == null || str2.isEmpty()) {
                this.actionBar.setTitle(str);
            }
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public void didFailNavigation(String str, int i, String str2) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public void didFinishNavigation(String str) {
        SearchView searchView = this.searchView;
        if (searchView != null) {
            searchView.setQuery(str, false);
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public void didStartNavigation(String str) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        SearchView searchView = this.searchView;
        if (searchView != null) {
            searchView.setQuery(str, false);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public void didUpdateVisitedHistory(String str) {
        SearchView searchView = this.searchView;
        if (searchView != null) {
            searchView.setQuery(str, false);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        ActivityPluginBinding activityPluginBinding;
        InAppWebViewChromeClient inAppWebViewChromeClient;
        InAppBrowserChannelDelegate inAppBrowserChannelDelegate = this.channelDelegate;
        if (inAppBrowserChannelDelegate != null) {
            inAppBrowserChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.activityResultListeners.clear();
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            InAppBrowserManager inAppBrowserManager = this.manager;
            if (inAppBrowserManager != null && (inAppWebViewFlutterPlugin = inAppBrowserManager.plugin) != null && (activityPluginBinding = inAppWebViewFlutterPlugin.activityPluginBinding) != null && (inAppWebViewChromeClient = inAppWebView.inAppWebViewChromeClient) != null) {
                activityPluginBinding.removeActivityResultListener(inAppWebViewChromeClient);
            }
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            this.webView.dispose();
            this.webView = null;
            finish();
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public Activity getActivity() {
        return this;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserDelegate
    public List<ActivityResultListener> getActivityResultListeners() {
        return this.activityResultListeners;
    }

    public Map<String, Object> getCustomSettings() {
        InAppWebView inAppWebView = this.webView;
        Map<String, Object> customSettings = inAppWebView != null ? inAppWebView.getCustomSettings() : null;
        InAppBrowserSettings inAppBrowserSettings = this.customSettings;
        if (inAppBrowserSettings == null || customSettings == null) {
            return null;
        }
        Map<String, Object> realSettings = inAppBrowserSettings.getRealSettings(this);
        realSettings.putAll(customSettings);
        return realSettings;
    }

    public void goBack() {
        if (this.webView == null || !canGoBack()) {
            return;
        }
        this.webView.goBack();
    }

    public void goBackButtonClicked(MenuItem menuItem) {
        goBack();
    }

    public void goForward() {
        if (this.webView == null || !canGoForward()) {
            return;
        }
        this.webView.goForward();
    }

    public void goForwardButtonClicked(MenuItem menuItem) {
        goForward();
    }

    public void hide() {
        if (this.fromActivity != null) {
            try {
                this.isHidden = true;
                Intent intent = new Intent(this, Class.forName(this.fromActivity));
                intent.setFlags(131072);
                startActivityIfNeeded(intent, 0);
            } catch (ClassNotFoundException e) {
                Log.d(LOG_TAG, "", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Iterator<ActivityResultListener> it = this.activityResultListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onActivityResult(i, i2, intent)) {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        URLRequest fromMap;
        InAppWebViewManager inAppWebViewManager;
        Message message;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.id = extras.getString(TtmlNode.ATTR_ID);
        InAppBrowserManager inAppBrowserManager = InAppBrowserManager.shared.get(extras.getString("managerId"));
        this.manager = inAppBrowserManager;
        if (inAppBrowserManager == null || (inAppWebViewFlutterPlugin = inAppBrowserManager.plugin) == null || inAppWebViewFlutterPlugin.messenger == null) {
            return;
        }
        Map<String, Object> map = (Map) extras.getSerializable("settings");
        this.customSettings.parse2(map);
        this.windowId = Integer.valueOf(extras.getInt("windowId"));
        setContentView(R.layout.activity_web_view);
        Map<String, Object> map2 = (Map) extras.getSerializable("pullToRefreshInitialSettings");
        MethodChannel methodChannel = new MethodChannel(this.manager.plugin.messenger, PullToRefreshLayout.METHOD_CHANNEL_NAME_PREFIX + this.id);
        PullToRefreshSettings pullToRefreshSettings = new PullToRefreshSettings();
        pullToRefreshSettings.parse2(map2);
        PullToRefreshLayout pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.pullToRefresh);
        this.pullToRefreshLayout = pullToRefreshLayout;
        pullToRefreshLayout.channelDelegate = new PullToRefreshChannelDelegate(pullToRefreshLayout, methodChannel);
        PullToRefreshLayout pullToRefreshLayout2 = this.pullToRefreshLayout;
        pullToRefreshLayout2.settings = pullToRefreshSettings;
        pullToRefreshLayout2.prepare();
        InAppWebView inAppWebView = (InAppWebView) findViewById(R.id.webView);
        this.webView = inAppWebView;
        String str = this.id;
        inAppWebView.id = str;
        inAppWebView.windowId = this.windowId;
        inAppWebView.inAppBrowserDelegate = this;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.manager.plugin;
        inAppWebView.plugin = inAppWebViewFlutterPlugin2;
        FindInteractionController findInteractionController = new FindInteractionController(inAppWebView, inAppWebViewFlutterPlugin2, str, null);
        this.webView.findInteractionController = findInteractionController;
        findInteractionController.prepare();
        MethodChannel methodChannel2 = new MethodChannel(this.manager.plugin.messenger, METHOD_CHANNEL_NAME_PREFIX + this.id);
        this.channelDelegate = new InAppBrowserChannelDelegate(methodChannel2);
        InAppWebView inAppWebView2 = this.webView;
        inAppWebView2.channelDelegate = new WebViewChannelDelegate(inAppWebView2, methodChannel2);
        this.fromActivity = extras.getString("fromActivity");
        Map<String, Object> map3 = (Map) extras.getSerializable("contextMenu");
        List list = (List) extras.getSerializable("initialUserScripts");
        Iterator it = ((List) extras.getSerializable("menuItems")).iterator();
        while (it.hasNext()) {
            this.menuItems.add(InAppBrowserMenuItem.fromMap((Map) it.next()));
        }
        InAppWebViewSettings inAppWebViewSettings = new InAppWebViewSettings();
        inAppWebViewSettings.parse2(map);
        InAppWebView inAppWebView3 = this.webView;
        inAppWebView3.customSettings = inAppWebViewSettings;
        inAppWebView3.contextMenu = map3;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(UserScript.fromMap((Map) it2.next()));
            }
        }
        this.webView.userContentController.addUserOnlyScripts(arrayList);
        this.actionBar = getSupportActionBar();
        prepareView();
        if (this.windowId.intValue() != -1) {
            InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin3 = this.webView.plugin;
            if (inAppWebViewFlutterPlugin3 != null && (inAppWebViewManager = inAppWebViewFlutterPlugin3.inAppWebViewManager) != null && (message = inAppWebViewManager.windowWebViewMessages.get(this.windowId)) != null) {
                ((WebView.WebViewTransport) message.obj).setWebView(this.webView);
                message.sendToTarget();
            }
        } else {
            String string = extras.getString("initialFile");
            Map map4 = (Map) extras.getSerializable("initialUrlRequest");
            String string2 = extras.getString("initialData");
            if (string != null) {
                try {
                    this.webView.loadFile(string);
                } catch (IOException e) {
                    Log.e(LOG_TAG, string + " asset file cannot be found!", e);
                    return;
                }
            } else if (string2 != null) {
                this.webView.loadDataWithBaseURL(extras.getString("initialBaseUrl"), string2, extras.getString("initialMimeType"), extras.getString("initialEncoding"), extras.getString("initialHistoryUrl"));
            } else if (map4 != null && (fromMap = URLRequest.fromMap(map4)) != null) {
                this.webView.loadUrl(fromMap);
            }
        }
        InAppBrowserChannelDelegate inAppBrowserChannelDelegate = this.channelDelegate;
        if (inAppBrowserChannelDelegate != null) {
            inAppBrowserChannelDelegate.onBrowserCreated();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        String str;
        this.menu = menu;
        if (this.actionBar != null && ((str = this.customSettings.toolbarTopFixedTitle) == null || str.isEmpty())) {
            ActionBar actionBar = this.actionBar;
            InAppWebView inAppWebView = this.webView;
            actionBar.setTitle(inAppWebView != null ? inAppWebView.getTitle() : "");
        }
        Menu menu2 = this.menu;
        if (menu2 == null) {
            return super.onCreateOptionsMenu(menu);
        }
        if (menu2 instanceof MenuBuilder) {
            ((MenuBuilder) menu2).setOptionalIconsVisible(true);
        }
        getMenuInflater().inflate(R.menu.menu_main, this.menu);
        MenuItem findItem = this.menu.findItem(R.id.menu_search);
        if (findItem != null) {
            if (this.customSettings.hideUrlBar.booleanValue()) {
                findItem.setVisible(false);
            }
            SearchView searchView = (SearchView) findItem.getActionView();
            this.searchView = searchView;
            if (searchView != null) {
                searchView.setFocusable(true);
                SearchView searchView2 = this.searchView;
                InAppWebView inAppWebView2 = this.webView;
                searchView2.setQuery(inAppWebView2 != null ? inAppWebView2.getUrl() : "", false);
                this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity.1
                    @Override // android.widget.SearchView.OnQueryTextListener
                    public boolean onQueryTextChange(String str2) {
                        return false;
                    }

                    @Override // android.widget.SearchView.OnQueryTextListener
                    public boolean onQueryTextSubmit(String str2) {
                        if (str2.isEmpty()) {
                            return false;
                        }
                        InAppWebView inAppWebView3 = InAppBrowserActivity.this.webView;
                        if (inAppWebView3 != null) {
                            inAppWebView3.loadUrl(str2);
                        }
                        SearchView searchView3 = InAppBrowserActivity.this.searchView;
                        if (searchView3 != null) {
                            searchView3.setQuery("", false);
                            InAppBrowserActivity.this.searchView.setIconified(true);
                        }
                        return true;
                    }
                });
                this.searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity.2
                    @Override // android.widget.SearchView.OnCloseListener
                    public boolean onClose() {
                        SearchView searchView3 = InAppBrowserActivity.this.searchView;
                        if (searchView3 != null && searchView3.getQuery().toString().isEmpty()) {
                            InAppBrowserActivity inAppBrowserActivity = InAppBrowserActivity.this;
                            SearchView searchView4 = inAppBrowserActivity.searchView;
                            InAppWebView inAppWebView3 = inAppBrowserActivity.webView;
                            searchView4.setQuery(inAppWebView3 != null ? inAppWebView3.getUrl() : "", false);
                        }
                        return false;
                    }
                });
                this.searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity.3
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        SearchView searchView3;
                        if (z || (searchView3 = InAppBrowserActivity.this.searchView) == null) {
                            return;
                        }
                        searchView3.setQuery("", false);
                        InAppBrowserActivity.this.searchView.setIconified(true);
                    }
                });
            }
        }
        if (this.customSettings.hideDefaultMenuItems.booleanValue()) {
            MenuItem findItem2 = this.menu.findItem(R.id.action_close);
            if (findItem2 != null) {
                findItem2.setVisible(false);
            }
            MenuItem findItem3 = this.menu.findItem(R.id.action_go_back);
            if (findItem3 != null) {
                findItem3.setVisible(false);
            }
            MenuItem findItem4 = this.menu.findItem(R.id.action_reload);
            if (findItem4 != null) {
                findItem4.setVisible(false);
            }
            MenuItem findItem5 = this.menu.findItem(R.id.action_go_forward);
            if (findItem5 != null) {
                findItem5.setVisible(false);
            }
            MenuItem findItem6 = this.menu.findItem(R.id.action_share);
            if (findItem6 != null) {
                findItem6.setVisible(false);
            }
        }
        for (final InAppBrowserMenuItem inAppBrowserMenuItem : this.menuItems) {
            MenuItem add = this.menu.add(0, inAppBrowserMenuItem.getId(), inAppBrowserMenuItem.getOrder() != null ? inAppBrowserMenuItem.getOrder().intValue() : 0, inAppBrowserMenuItem.getTitle());
            if (inAppBrowserMenuItem.isShowAsAction()) {
                add.setShowAsAction(2);
            }
            Object icon = inAppBrowserMenuItem.getIcon();
            if (icon != null) {
                if (icon instanceof AndroidResource) {
                    add.setIcon(((AndroidResource) icon).getIdentifier(this));
                } else {
                    add.setIcon(Util.drawableFromBytes(this, (byte[]) icon));
                }
                String iconColor = inAppBrowserMenuItem.getIconColor();
                if (iconColor != null && !iconColor.isEmpty()) {
                    add.getIcon().setTint(Color.parseColor(iconColor));
                }
            }
            add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity.4
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    InAppBrowserChannelDelegate inAppBrowserChannelDelegate = InAppBrowserActivity.this.channelDelegate;
                    if (inAppBrowserChannelDelegate == null) {
                        return true;
                    }
                    inAppBrowserChannelDelegate.onMenuItemClicked(inAppBrowserMenuItem);
                    return true;
                }
            });
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.customSettings.shouldCloseOnBackButtonPressed.booleanValue()) {
                close(null);
                return true;
            }
            if (this.customSettings.allowGoBackWithBackButton.booleanValue()) {
                if (canGoBack()) {
                    goBack();
                } else if (this.customSettings.closeOnCannotGoBack.booleanValue()) {
                    close(null);
                }
                return true;
            }
            if (!this.customSettings.shouldCloseOnBackButtonPressed.booleanValue()) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void reload() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.reload();
        }
    }

    public void reloadButtonClicked(MenuItem menuItem) {
        reload();
    }

    public void setSettings(InAppBrowserSettings inAppBrowserSettings, HashMap<String, Object> hashMap) {
        MenuItem findItem;
        String str;
        String str2;
        ProgressBar progressBar;
        int i;
        InAppWebViewSettings inAppWebViewSettings = new InAppWebViewSettings();
        inAppWebViewSettings.parse2((Map<String, Object>) hashMap);
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.setSettings(inAppWebViewSettings, hashMap);
        }
        if (hashMap.get("hidden") != null) {
            Boolean bool = this.customSettings.hidden;
            Boolean bool2 = inAppBrowserSettings.hidden;
            if (bool != bool2) {
                if (bool2.booleanValue()) {
                    hide();
                } else {
                    show();
                }
            }
        }
        if (hashMap.get("hideProgressBar") != null) {
            Boolean bool3 = this.customSettings.hideProgressBar;
            Boolean bool4 = inAppBrowserSettings.hideProgressBar;
            if (bool3 != bool4 && this.progressBar != null) {
                if (bool4.booleanValue()) {
                    progressBar = this.progressBar;
                    i = 0;
                } else {
                    progressBar = this.progressBar;
                    i = 100;
                }
                progressBar.setMax(i);
            }
        }
        if (this.actionBar != null && hashMap.get("hideTitleBar") != null) {
            if (this.customSettings.hideTitleBar != inAppBrowserSettings.hideTitleBar) {
                this.actionBar.setDisplayShowTitleEnabled(!r1.booleanValue());
            }
        }
        if (this.actionBar != null && hashMap.get("hideToolbarTop") != null) {
            Boolean bool5 = this.customSettings.hideToolbarTop;
            Boolean bool6 = inAppBrowserSettings.hideToolbarTop;
            if (bool5 != bool6) {
                if (bool6.booleanValue()) {
                    this.actionBar.hide();
                } else {
                    this.actionBar.show();
                }
            }
        }
        if (this.actionBar != null && hashMap.get("toolbarTopBackgroundColor") != null && !Util.objEquals(this.customSettings.toolbarTopBackgroundColor, inAppBrowserSettings.toolbarTopBackgroundColor) && (str2 = inAppBrowserSettings.toolbarTopBackgroundColor) != null && !str2.isEmpty()) {
            this.actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(inAppBrowserSettings.toolbarTopBackgroundColor)));
        }
        if (this.actionBar != null && hashMap.get("toolbarTopFixedTitle") != null && !Util.objEquals(this.customSettings.toolbarTopFixedTitle, inAppBrowserSettings.toolbarTopFixedTitle) && (str = inAppBrowserSettings.toolbarTopFixedTitle) != null && !str.isEmpty()) {
            this.actionBar.setTitle(inAppBrowserSettings.toolbarTopFixedTitle);
        }
        if (this.menu != null && hashMap.get("hideUrlBar") != null && this.customSettings.hideUrlBar != inAppBrowserSettings.hideUrlBar && (findItem = this.menu.findItem(R.id.menu_search)) != null) {
            findItem.setVisible(!inAppBrowserSettings.hideUrlBar.booleanValue());
        }
        if (this.menu != null && hashMap.get("hideDefaultMenuItems") != null && this.customSettings.hideDefaultMenuItems != inAppBrowserSettings.hideDefaultMenuItems) {
            MenuItem findItem2 = this.menu.findItem(R.id.action_close);
            if (findItem2 != null) {
                findItem2.setVisible(!inAppBrowserSettings.hideDefaultMenuItems.booleanValue());
            }
            MenuItem findItem3 = this.menu.findItem(R.id.action_go_back);
            if (findItem3 != null) {
                findItem3.setVisible(!inAppBrowserSettings.hideDefaultMenuItems.booleanValue());
            }
            MenuItem findItem4 = this.menu.findItem(R.id.action_reload);
            if (findItem4 != null) {
                findItem4.setVisible(!inAppBrowserSettings.hideDefaultMenuItems.booleanValue());
            }
            MenuItem findItem5 = this.menu.findItem(R.id.action_go_forward);
            if (findItem5 != null) {
                findItem5.setVisible(!inAppBrowserSettings.hideDefaultMenuItems.booleanValue());
            }
            MenuItem findItem6 = this.menu.findItem(R.id.action_share);
            if (findItem6 != null) {
                findItem6.setVisible(!inAppBrowserSettings.hideDefaultMenuItems.booleanValue());
            }
        }
        this.customSettings = inAppBrowserSettings;
    }

    public void shareButtonClicked(MenuItem menuItem) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        InAppWebView inAppWebView = this.webView;
        intent.putExtra("android.intent.extra.TEXT", inAppWebView != null ? inAppWebView.getUrl() : "");
        startActivity(Intent.createChooser(intent, "Share"));
    }

    public void show() {
        this.isHidden = false;
        Intent intent = new Intent(this, (Class<?>) InAppBrowserActivity.class);
        intent.setFlags(131072);
        startActivityIfNeeded(intent, 0);
    }
}
