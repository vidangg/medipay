package com.yanisalfian.flutterphonedirectcaller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: FlutterPhoneDirectCallerPlugin.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J+\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0017H\u0002J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/yanisalfian/flutterphonedirectcaller/FlutterPhoneDirectCallerHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activityPluginBinding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "flutterResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "isTelephonyEnabled", "", "()Z", "number", "", "permissionStatus", "", "getPermissionStatus", "()I", "callNumber", "onMethodCall", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "requestsPermission", "setActivityPluginBinding", "Companion", "flutter_phone_direct_caller_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FlutterPhoneDirectCallerHandler implements MethodChannel.MethodCallHandler, PluginRegistry.RequestPermissionsResultListener {
    private static final String CALL_PHONE = "android.permission.CALL_PHONE";
    private static final int CALL_REQ_CODE = 0;
    private ActivityPluginBinding activityPluginBinding;
    private MethodChannel.Result flutterResult;
    private String number;

    public final void setActivityPluginBinding(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "activityPluginBinding");
        this.activityPluginBinding = activityPluginBinding;
        activityPluginBinding.addRequestPermissionsResultListener(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        this.flutterResult = result;
        if (Intrinsics.areEqual(call.method, "callNumber")) {
            this.number = (String) call.argument("number");
            Log.d("Caller", "Message");
            String str = this.number;
            Intrinsics.checkNotNull(str);
            String replace = new Regex("#").replace(str, "%23");
            this.number = replace;
            Intrinsics.checkNotNull(replace);
            if (!StringsKt.startsWith$default(replace, "tel:", false, 2, (Object) null)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("tel:%s", Arrays.copyOf(new Object[]{this.number}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                this.number = format;
            }
            if (getPermissionStatus() != 1) {
                requestsPermission();
                return;
            } else {
                result.success(Boolean.valueOf(callNumber(this.number)));
                return;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (this.number == null || requestCode != 0) {
            return true;
        }
        for (int i : grantResults) {
            if (i == -1) {
                MethodChannel.Result result = this.flutterResult;
                Intrinsics.checkNotNull(result);
                result.success(false);
                return false;
            }
        }
        MethodChannel.Result result2 = this.flutterResult;
        Intrinsics.checkNotNull(result2);
        result2.success(Boolean.valueOf(callNumber(this.number)));
        return true;
    }

    private final void requestsPermission() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{CALL_PHONE}, 0);
    }

    private final int getPermissionStatus() {
        if (ContextCompat.checkSelfPermission(getActivity(), CALL_PHONE) == -1) {
            return !ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), CALL_PHONE) ? -1 : 0;
        }
        return 1;
    }

    private final boolean callNumber(String number) {
        try {
            Intent intent = new Intent(isTelephonyEnabled() ? "android.intent.action.CALL" : "android.intent.action.VIEW");
            intent.setData(Uri.parse(number));
            getActivity().startActivity(intent);
            return true;
        } catch (Exception e) {
            Log.d("Caller", "error: " + e.getMessage());
            return false;
        }
    }

    private final boolean isTelephonyEnabled() {
        Object systemService = getActivity().getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return ((TelephonyManager) systemService).getPhoneType() != 0;
    }

    private final Activity getActivity() {
        ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
        Intrinsics.checkNotNull(activityPluginBinding);
        Activity activity = activityPluginBinding.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }
}
