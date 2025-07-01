package com.gotrust.medipayapp;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vn.ai.faceauth.sdk.presentation.domain.configs.SDKConfig;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;

/* compiled from: LivenessPlugin.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/gotrust/medipayapp/LivenessPlugin;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "backgroundExecutor", "Ljava/util/concurrent/ExecutorService;", "firstFaceB64", "", "lastFaceB64", "mainHandler", "Landroid/os/Handler;", "pendingResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "dispose", "", "handleMethodCall", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "startFaceAuthentication", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class LivenessPlugin {
    private static final String TAG = "LivenessPlugin";
    private final Activity activity;
    private final ExecutorService backgroundExecutor;
    private String firstFaceB64;
    private String lastFaceB64;
    private final Handler mainHandler;
    private MethodChannel.Result pendingResult;

    public LivenessPlugin(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.backgroundExecutor = newSingleThreadExecutor;
        this.mainHandler = new Handler(Looper.getMainLooper());
        try {
            Log.d(TAG, "TTXT SDK initialized");
        } catch (Exception e) {
            Log.e(TAG, "Failed to initialize TTXT SDK: " + e.getMessage());
        }
        this.firstFaceB64 = "";
        this.lastFaceB64 = "";
    }

    public final void handleMethodCall(final MethodCall call, final MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        this.backgroundExecutor.execute(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LivenessPlugin.handleMethodCall$lambda$5(MethodCall.this, this, result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0017. Please report as an issue. */
    public static final void handleMethodCall$lambda$5(MethodCall call, final LivenessPlugin this$0, final MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "$call");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1927389941:
                    if (str.equals("showError")) {
                        this$0.mainHandler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                LivenessPlugin.handleMethodCall$lambda$5$lambda$2(MethodChannel.Result.this);
                            }
                        });
                        return;
                    }
                    break;
                case -1479010746:
                    if (str.equals("showSuccess")) {
                        this$0.mainHandler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                LivenessPlugin.handleMethodCall$lambda$5$lambda$3(MethodChannel.Result.this);
                            }
                        });
                        return;
                    }
                    break;
                case 122992247:
                    if (str.equals("getFirstFace")) {
                        this$0.mainHandler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                LivenessPlugin.handleMethodCall$lambda$5$lambda$0(MethodChannel.Result.this, this$0);
                            }
                        });
                        return;
                    }
                    break;
                case 618061705:
                    if (str.equals("getLastFace")) {
                        this$0.mainHandler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                LivenessPlugin.handleMethodCall$lambda$5$lambda$1(MethodChannel.Result.this, this$0);
                            }
                        });
                        return;
                    }
                    break;
                case 1128565303:
                    if (str.equals("startFaceAuthentication")) {
                        this$0.startFaceAuthentication(call, result);
                        return;
                    }
                    break;
            }
        }
        Log.d(TAG, "Unknown method: " + call.method);
        this$0.mainHandler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                LivenessPlugin.handleMethodCall$lambda$5$lambda$4(MethodChannel.Result.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMethodCall$lambda$5$lambda$0(MethodChannel.Result result, LivenessPlugin this$0) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        result.success(this$0.firstFaceB64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMethodCall$lambda$5$lambda$1(MethodChannel.Result result, LivenessPlugin this$0) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        result.success(this$0.lastFaceB64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMethodCall$lambda$5$lambda$2(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMethodCall$lambda$5$lambda$3(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMethodCall$lambda$5$lambda$4(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.notImplemented();
    }

    private final void startFaceAuthentication(MethodCall call, final MethodChannel.Result result) {
        String str;
        try {
            this.pendingResult = result;
            String str2 = (String) call.argument("nonce");
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            String str4 = (String) call.argument("primaryColor");
            if (str4 == null) {
                str4 = "#00427A";
            }
            String str5 = str4;
            String str6 = (String) call.argument("secondaryColor");
            String str7 = str6 == null ? "#42526E" : str6;
            String str8 = (String) call.argument("ovalColor");
            String str9 = str8 == null ? "#42526E" : str8;
            String str10 = (String) call.argument("errorColor");
            if (str10 == null) {
                str10 = "#FF2633";
            }
            String str11 = str10;
            String str12 = (String) call.argument("textColor");
            String str13 = str12 == null ? "#253858" : str12;
            String str14 = (String) call.argument("textButtonColor");
            if (str14 == null) {
                str14 = "#FFFFFF";
            }
            String str15 = (String) call.argument(TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
            if (str15 == null) {
                str15 = "#FFFFFF";
            }
            String str16 = (String) call.argument("closeColor");
            String str17 = str16 == null ? "#253858" : str16;
            Boolean bool = (Boolean) call.argument("isAutoProcess");
            if (bool == null) {
                bool = true;
            }
            boolean booleanValue = bool.booleanValue();
            Boolean bool2 = (Boolean) call.argument("isCancelable");
            if (bool2 == null) {
                bool2 = false;
            }
            boolean booleanValue2 = bool2.booleanValue();
            Boolean bool3 = (Boolean) call.argument("isShowGuideScreen");
            if (bool3 == null) {
                bool3 = true;
            }
            boolean booleanValue3 = bool3.booleanValue();
            final String str18 = (String) call.argument("language");
            if (str18 == null) {
                str18 = "vi";
            }
            if (str3.length() == 0) {
                Log.e(TAG, "Nonce is empty");
                this.mainHandler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivenessPlugin.startFaceAuthentication$lambda$6(MethodChannel.Result.this);
                    }
                });
                return;
            }
            str = TAG;
            try {
                final SDKConfig sDKConfig = new SDKConfig(str5, str7, str9, str11, str13, str14, str15, str17, booleanValue, booleanValue2, booleanValue3, str3);
                this.mainHandler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivenessPlugin.startFaceAuthentication$lambda$7(SDKConfig.this, str18, this, result);
                    }
                });
            } catch (Exception e) {
                e = e;
                Log.e(str, "Failed to start SDK: " + e.getMessage(), e);
                result.error("ERROR", "Failed to start: " + e.getMessage(), null);
            }
        } catch (Exception e2) {
            e = e2;
            str = TAG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFaceAuthentication$lambda$6(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.error("INVALID_NONCE", "Nonce cannot be empty", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFaceAuthentication$lambda$7(SDKConfig sdkConfig, String language, LivenessPlugin this$0, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(sdkConfig, "$sdkConfig");
        Intrinsics.checkNotNullParameter(language, "$language");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        try {
            AuthenticationID.configure(sdkConfig);
            AuthenticationID.setLanguage(language);
            LivenessPlugin$startFaceAuthentication$2$callback$1 livenessPlugin$startFaceAuthentication$2$callback$1 = new LivenessPlugin$startFaceAuthentication$2$callback$1(this$0);
            Log.d(TAG, "Starting TTXT SDK...");
            AuthenticationID.startFaceAuthen(this$0.activity, livenessPlugin$startFaceAuthentication$2$callback$1);
        } catch (Exception e) {
            Log.e(TAG, "Failed to configure SDK: " + e.getMessage());
            result.error("CONFIG_ERROR", "Failed to configure SDK: " + e.getMessage(), null);
        }
    }

    public final void dispose() {
        this.backgroundExecutor.shutdown();
    }
}
