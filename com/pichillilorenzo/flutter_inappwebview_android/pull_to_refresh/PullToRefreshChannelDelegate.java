package com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh;

import android.graphics.Color;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.analytics.Constants;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class PullToRefreshChannelDelegate extends ChannelDelegateImpl {
    private PullToRefreshLayout pullToRefreshView;

    public PullToRefreshChannelDelegate(PullToRefreshLayout pullToRefreshLayout, MethodChannel methodChannel) {
        super(methodChannel);
        this.pullToRefreshView = pullToRefreshLayout;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.pullToRefreshView = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0088. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        char c;
        Object obj;
        String str = methodCall.method;
        str.hashCode();
        str.hashCode();
        switch (str.hashCode()) {
            case -1790841290:
                if (str.equals("setSlingshotDistance")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 154556713:
                if (str.equals("setRefreshing")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1235582893:
                if (str.equals("getDefaultSlingshotDistance")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1364071551:
                if (str.equals("setEnabled")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1389555745:
                if (str.equals("setColor")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1743806995:
                if (str.equals("setBackgroundColor")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1807783361:
                if (str.equals("setDistanceToTriggerSync")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1849446385:
                if (str.equals("isRefreshing")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1984958339:
                if (str.equals("setSize")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 2105594551:
                if (str.equals("isEnabled")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setSlingshotDistance(((Integer) methodCall.argument("slingshotDistance")).intValue());
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 1:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setRefreshing(((Boolean) methodCall.argument("refreshing")).booleanValue());
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 2:
                obj = -1;
                result.success(obj);
                return;
            case 3:
                if (this.pullToRefreshView != null) {
                    Boolean bool = (Boolean) methodCall.argument(Constants.ENABLED);
                    PullToRefreshLayout pullToRefreshLayout = this.pullToRefreshView;
                    pullToRefreshLayout.settings.enabled = bool;
                    pullToRefreshLayout.setEnabled(bool.booleanValue());
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 4:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setColorSchemeColors(Color.parseColor((String) methodCall.argument("color")));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 5:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setProgressBackgroundColorSchemeColor(Color.parseColor((String) methodCall.argument("color")));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 6:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setDistanceToTriggerSync(((Integer) methodCall.argument("distanceToTriggerSync")).intValue());
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 7:
                PullToRefreshLayout pullToRefreshLayout2 = this.pullToRefreshView;
                obj = Boolean.valueOf(pullToRefreshLayout2 != null && pullToRefreshLayout2.isRefreshing());
                result.success(obj);
                return;
            case '\b':
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setSize(((Integer) methodCall.argument("size")).intValue());
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case '\t':
                PullToRefreshLayout pullToRefreshLayout3 = this.pullToRefreshView;
                if (pullToRefreshLayout3 != null) {
                    obj = Boolean.valueOf(pullToRefreshLayout3.isEnabled());
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

    public void onRefresh() {
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.invokeMethod("onRefresh", new HashMap());
    }
}
