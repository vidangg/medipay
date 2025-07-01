package com.sameer.flutterstatusbarcolor.flutterstatusbarcolor;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.WindowCompat;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlutterStatusbarcolorPlugin.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/sameer/flutterstatusbarcolor/flutterstatusbarcolor/FlutterStatusbarcolorPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "activity", "Landroid/app/Activity;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "Lio/flutter/plugin/common/MethodChannel$Result;", "onReattachedToActivityForConfigChanges", "flutter_statusbarcolor_ns_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FlutterStatusbarcolorPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
    private Activity activity;
    private MethodChannel channel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.sameer.com/statusbar");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.activity == null) {
            result.success(null);
            return;
        }
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -2014534886:
                    if (str.equals("getnavigationbarcolor")) {
                        Activity activity = this.activity;
                        Intrinsics.checkNotNull(activity);
                        result.success(Integer.valueOf(activity.getWindow().getNavigationBarColor()));
                        return;
                    }
                    break;
                case -1238995452:
                    if (str.equals("setstatusbarcolor")) {
                        Object argument = call.argument("color");
                        Intrinsics.checkNotNull(argument);
                        int intValue = ((Number) argument).intValue();
                        Object argument2 = call.argument("animate");
                        Intrinsics.checkNotNull(argument2);
                        if (((Boolean) argument2).booleanValue()) {
                            Activity activity2 = this.activity;
                            Intrinsics.checkNotNull(activity2);
                            ValueAnimator ofArgb = ValueAnimator.ofArgb(activity2.getWindow().getStatusBarColor(), intValue);
                            ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sameer.flutterstatusbarcolor.flutterstatusbarcolor.FlutterStatusbarcolorPlugin$$ExternalSyntheticLambda1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    FlutterStatusbarcolorPlugin.onMethodCall$lambda$0(FlutterStatusbarcolorPlugin.this, valueAnimator);
                                }
                            });
                            ofArgb.setDuration(300L);
                            ofArgb.start();
                        } else {
                            Activity activity3 = this.activity;
                            Intrinsics.checkNotNull(activity3);
                            activity3.getWindow().setStatusBarColor(intValue);
                        }
                        result.success(null);
                        return;
                    }
                    break;
                case -298842632:
                    if (str.equals("getstatusbarcolor")) {
                        Activity activity4 = this.activity;
                        Intrinsics.checkNotNull(activity4);
                        result.success(Integer.valueOf(activity4.getWindow().getStatusBarColor()));
                        return;
                    }
                    break;
                case 521676070:
                    if (str.equals("setnavigationbarcolor")) {
                        Object argument3 = call.argument("color");
                        Intrinsics.checkNotNull(argument3);
                        int intValue2 = ((Number) argument3).intValue();
                        Object argument4 = call.argument("animate");
                        Intrinsics.checkNotNull(argument4);
                        if (((Boolean) argument4).booleanValue()) {
                            Activity activity5 = this.activity;
                            Intrinsics.checkNotNull(activity5);
                            ValueAnimator ofArgb2 = ValueAnimator.ofArgb(activity5.getWindow().getNavigationBarColor(), intValue2);
                            ofArgb2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sameer.flutterstatusbarcolor.flutterstatusbarcolor.FlutterStatusbarcolorPlugin$$ExternalSyntheticLambda2
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    FlutterStatusbarcolorPlugin.onMethodCall$lambda$1(FlutterStatusbarcolorPlugin.this, valueAnimator);
                                }
                            });
                            ofArgb2.setDuration(300L);
                            ofArgb2.start();
                        } else {
                            Activity activity6 = this.activity;
                            Intrinsics.checkNotNull(activity6);
                            activity6.getWindow().setNavigationBarColor(intValue2);
                        }
                        result.success(null);
                        return;
                    }
                    break;
                case 1653519407:
                    if (str.equals("setnavigationbarwhiteforeground")) {
                        Object argument5 = call.argument("whiteForeground");
                        Intrinsics.checkNotNull(argument5);
                        boolean booleanValue = ((Boolean) argument5).booleanValue();
                        Activity activity7 = this.activity;
                        Intrinsics.checkNotNull(activity7);
                        Window window = activity7.getWindow();
                        if (Build.VERSION.SDK_INT >= 30) {
                            WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(!booleanValue);
                            window.setNavigationBarContrastEnforced(true);
                        } else if (booleanValue) {
                            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-17));
                        } else {
                            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 16);
                        }
                        result.success(null);
                        return;
                    }
                    break;
                case 1890975629:
                    if (str.equals("setstatusbarwhiteforeground")) {
                        Object argument6 = call.argument("whiteForeground");
                        Intrinsics.checkNotNull(argument6);
                        boolean booleanValue2 = ((Boolean) argument6).booleanValue();
                        Activity activity8 = this.activity;
                        Intrinsics.checkNotNull(activity8);
                        Window window2 = activity8.getWindow();
                        if (Build.VERSION.SDK_INT >= 30) {
                            WindowCompat.getInsetsController(window2, window2.getDecorView()).setAppearanceLightStatusBars(!booleanValue2);
                        } else if (booleanValue2) {
                            window2.getDecorView().setSystemUiVisibility(window2.getDecorView().getSystemUiVisibility() & (-8193));
                        } else {
                            window2.getDecorView().setSystemUiVisibility(window2.getDecorView().getSystemUiVisibility() | 8192);
                        }
                        result.success(null);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMethodCall$lambda$0(FlutterStatusbarcolorPlugin this$0, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anim, "anim");
        Activity activity = this$0.activity;
        Intrinsics.checkNotNull(activity);
        Window window = activity.getWindow();
        Object animatedValue = anim.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setStatusBarColor(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMethodCall$lambda$1(FlutterStatusbarcolorPlugin this$0, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anim, "anim");
        Activity activity = this$0.activity;
        Intrinsics.checkNotNull(activity);
        Window window = activity.getWindow();
        Object animatedValue = anim.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setNavigationBarColor(((Integer) animatedValue).intValue());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.activity = binding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.activity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.activity = binding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.activity = null;
    }
}
