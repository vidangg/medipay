package com.pichillilorenzo.flutter_inappwebview_android.tracing;

import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.TracingController;
import androidx.webkit.WebViewFeature;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class TracingControllerChannelDelegate extends ChannelDelegateImpl {
    private TracingControllerManager tracingControllerManager;

    public TracingControllerChannelDelegate(TracingControllerManager tracingControllerManager, MethodChannel methodChannel) {
        super(methodChannel);
        this.tracingControllerManager = tracingControllerManager;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.tracingControllerManager = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Boolean valueOf;
        FileOutputStream fileOutputStream;
        TracingControllerManager.init();
        TracingController tracingController = TracingControllerManager.tracingController;
        String str = methodCall.method;
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1647175624:
                if (str.equals("isTracing")) {
                    c = 0;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(TtmlNode.START)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (tracingController != null) {
                    valueOf = Boolean.valueOf(tracingController.isTracing());
                    result.success(valueOf);
                }
                break;
            case 1:
                if (tracingController != null && WebViewFeature.isFeatureSupported("TRACING_CONTROLLER_BASIC_USAGE")) {
                    String str2 = (String) methodCall.argument("filePath");
                    if (str2 != null) {
                        try {
                            fileOutputStream = new FileOutputStream(str2);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            break;
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    result.success(Boolean.valueOf(tracingController.stop(fileOutputStream, Executors.newSingleThreadExecutor())));
                    return;
                }
                break;
            case 2:
                if (tracingController != null && WebViewFeature.isFeatureSupported("TRACING_CONTROLLER_BASIC_USAGE")) {
                    Map<String, Object> map = (Map) methodCall.argument("settings");
                    TracingSettings tracingSettings = new TracingSettings();
                    tracingSettings.parse2(map);
                    tracingController.start(TracingControllerManager.buildTracingConfig(tracingSettings));
                    valueOf = Boolean.TRUE;
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
}
