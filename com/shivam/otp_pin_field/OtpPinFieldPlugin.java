package com.shivam.otp_pin_field;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.shivam.otp_pin_field.OtpPinFieldPlugin;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OtpPinFieldPlugin.kt */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\b\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002)*B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/shivam/otp_pin_field/OtpPinFieldPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "activity", "Landroid/app/Activity;", "activityResultListener", "com/shivam/otp_pin_field/OtpPinFieldPlugin$activityResultListener$1", "Lcom/shivam/otp_pin_field/OtpPinFieldPlugin$activityResultListener$1;", "broadcastReceiver", "Lcom/shivam/otp_pin_field/OtpPinFieldPlugin$SmsBroadcastReceiver;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "isSimSupport", "", "()Z", "pendingHintResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "onReattachedToActivityForConfigChanges", "requestHint", "setCode", Constant.PARAM_ERROR_CODE, "", "setupChannel", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "unregisterReceiver", "Companion", "SmsBroadcastReceiver", "otp_pin_field_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class OtpPinFieldPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    private static final int PHONE_HINT_REQUEST = 1112;
    private static final String channelName = "otp_pin_field";
    private Activity activity;
    private final OtpPinFieldPlugin$activityResultListener$1 activityResultListener = new PluginRegistry.ActivityResultListener() { // from class: com.shivam.otp_pin_field.OtpPinFieldPlugin$activityResultListener$1
        @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
        public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
            MethodChannel.Result result;
            MethodChannel.Result result2;
            Activity activity;
            MethodChannel.Result result3;
            if (requestCode != 1112) {
                return false;
            }
            try {
                result = OtpPinFieldPlugin.this.pendingHintResult;
                if (result == null) {
                    return false;
                }
                if (resultCode != -1 || data == null) {
                    result2 = OtpPinFieldPlugin.this.pendingHintResult;
                    if (result2 == null) {
                        return true;
                    }
                    result2.success(null);
                    return true;
                }
                activity = OtpPinFieldPlugin.this.activity;
                Intrinsics.checkNotNull(activity);
                String phoneNumberFromIntent = Identity.getSignInClient(activity).getPhoneNumberFromIntent(data);
                Intrinsics.checkNotNullExpressionValue(phoneNumberFromIntent, "getPhoneNumberFromIntent(...)");
                result3 = OtpPinFieldPlugin.this.pendingHintResult;
                if (result3 == null) {
                    return true;
                }
                result3.success(phoneNumberFromIntent);
                return true;
            } catch (Exception e) {
                Log.e("Exception", e.toString());
                return false;
            }
        }
    };
    private SmsBroadcastReceiver broadcastReceiver;
    private MethodChannel channel;
    private MethodChannel.Result pendingHintResult;

    public final void setCode(String code) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("smsCode", code);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0012. Please report as an issue. */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, final MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1213403505:
                    if (str.equals("listenForCode")) {
                        final String str2 = (String) call.argument("smsCodeRegexPattern");
                        Activity activity = this.activity;
                        Intrinsics.checkNotNull(activity);
                        SmsRetrieverClient client = SmsRetriever.getClient(activity);
                        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
                        Task<Void> startSmsRetriever = client.startSmsRetriever();
                        Intrinsics.checkNotNullExpressionValue(startSmsRetriever, "startSmsRetriever(...)");
                        final Function1<Void, Unit> function1 = new Function1<Void, Unit>() { // from class: com.shivam.otp_pin_field.OtpPinFieldPlugin$onMethodCall$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                                invoke2(r1);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Void r4) {
                                Activity activity2;
                                OtpPinFieldPlugin.SmsBroadcastReceiver smsBroadcastReceiver;
                                Activity activity3;
                                OtpPinFieldPlugin.SmsBroadcastReceiver smsBroadcastReceiver2;
                                OtpPinFieldPlugin.this.unregisterReceiver();
                                OtpPinFieldPlugin otpPinFieldPlugin = OtpPinFieldPlugin.this;
                                WeakReference weakReference = new WeakReference(OtpPinFieldPlugin.this);
                                String str3 = str2;
                                Intrinsics.checkNotNull(str3);
                                otpPinFieldPlugin.broadcastReceiver = new OtpPinFieldPlugin.SmsBroadcastReceiver(weakReference, str3);
                                if (Build.VERSION.SDK_INT >= 33) {
                                    activity3 = OtpPinFieldPlugin.this.activity;
                                    if (activity3 != null) {
                                        smsBroadcastReceiver2 = OtpPinFieldPlugin.this.broadcastReceiver;
                                        activity3.registerReceiver(smsBroadcastReceiver2, new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION), 2);
                                    }
                                } else {
                                    activity2 = OtpPinFieldPlugin.this.activity;
                                    if (activity2 != null) {
                                        smsBroadcastReceiver = OtpPinFieldPlugin.this.broadcastReceiver;
                                        activity2.registerReceiver(smsBroadcastReceiver, new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION));
                                    }
                                }
                                result.success(null);
                            }
                        };
                        startSmsRetriever.addOnSuccessListener(new OnSuccessListener() { // from class: com.shivam.otp_pin_field.OtpPinFieldPlugin$$ExternalSyntheticLambda2
                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final void onSuccess(Object obj) {
                                OtpPinFieldPlugin.onMethodCall$lambda$0(Function1.this, obj);
                            }
                        });
                        startSmsRetriever.addOnFailureListener(new OnFailureListener() { // from class: com.shivam.otp_pin_field.OtpPinFieldPlugin$$ExternalSyntheticLambda3
                            @Override // com.google.android.gms.tasks.OnFailureListener
                            public final void onFailure(Exception exc) {
                                OtpPinFieldPlugin.onMethodCall$lambda$1(MethodChannel.Result.this, exc);
                            }
                        });
                        return;
                    }
                    break;
                case -1037975280:
                    if (str.equals("unregisterListener")) {
                        unregisterReceiver();
                        result.success("Successfully unregistered receiver");
                        return;
                    }
                    break;
                case 115451405:
                    if (str.equals("getAppSignature")) {
                        Activity activity2 = this.activity;
                        result.success(new AppSignatureHelper(activity2 != null ? activity2.getApplicationContext() : null).getAppSignature());
                        return;
                    }
                    break;
                case 1920911174:
                    if (str.equals("requestPhoneHint")) {
                        this.pendingHintResult = result;
                        requestHint();
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMethodCall$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMethodCall$lambda$1(MethodChannel.Result result, Exception it) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(it, "it");
        result.error("ERROR_START_SMS_RETRIEVER", "Can't start SMS retriever", it);
    }

    private final void requestHint() {
        if (!isSimSupport()) {
            MethodChannel.Result result = this.pendingHintResult;
            if (result != null) {
                result.success(null);
                return;
            }
            return;
        }
        GetPhoneNumberHintIntentRequest build = GetPhoneNumberHintIntentRequest.builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        Task<PendingIntent> phoneNumberHintIntent = Identity.getSignInClient(activity).getPhoneNumberHintIntent(build);
        final Function1<PendingIntent, Unit> function1 = new Function1<PendingIntent, Unit>() { // from class: com.shivam.otp_pin_field.OtpPinFieldPlugin$requestHint$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PendingIntent pendingIntent) {
                invoke2(pendingIntent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PendingIntent pendingIntent) {
                MethodChannel.Result result2;
                Activity activity2;
                try {
                    activity2 = OtpPinFieldPlugin.this.activity;
                    if (activity2 != null) {
                        Intrinsics.checkNotNull(pendingIntent);
                        activity2.startIntentSenderForResult(pendingIntent.getIntentSender(), 1112, null, 0, 0, 0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result2 = OtpPinFieldPlugin.this.pendingHintResult;
                    if (result2 != null) {
                        result2.error("ERROR", e.getMessage(), e);
                    }
                }
            }
        };
        phoneNumberHintIntent.addOnSuccessListener(new OnSuccessListener() { // from class: com.shivam.otp_pin_field.OtpPinFieldPlugin$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                OtpPinFieldPlugin.requestHint$lambda$2(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.shivam.otp_pin_field.OtpPinFieldPlugin$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                OtpPinFieldPlugin.requestHint$lambda$3(OtpPinFieldPlugin.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestHint$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestHint$lambda$3(OtpPinFieldPlugin this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        it.printStackTrace();
        MethodChannel.Result result = this$0.pendingHintResult;
        if (result != null) {
            result.error("ERROR", it.getMessage(), it);
        }
    }

    private final boolean isSimSupport() {
        Activity activity = this.activity;
        Object systemService = activity != null ? activity.getSystemService("phone") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return ((TelephonyManager) systemService).getSimState() != 1;
    }

    private final void setupChannel(BinaryMessenger messenger) {
        MethodChannel methodChannel = new MethodChannel(messenger, channelName);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterReceiver() {
        SmsBroadcastReceiver smsBroadcastReceiver = this.broadcastReceiver;
        if (smsBroadcastReceiver != null) {
            try {
                Activity activity = this.activity;
                if (activity != null) {
                    activity.unregisterReceiver(smsBroadcastReceiver);
                }
            } catch (Exception unused) {
            }
            this.broadcastReceiver = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        setupChannel(binaryMessenger);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        unregisterReceiver();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.activity = binding.getActivity();
        binding.addActivityResultListener(this.activityResultListener);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        unregisterReceiver();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.activity = binding.getActivity();
        binding.addActivityResultListener(this.activityResultListener);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        unregisterReceiver();
    }

    /* compiled from: OtpPinFieldPlugin.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/shivam/otp_pin_field/OtpPinFieldPlugin$SmsBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "plugin", "Ljava/lang/ref/WeakReference;", "Lcom/shivam/otp_pin_field/OtpPinFieldPlugin;", "smsCodeRegexPattern", "", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "otp_pin_field_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class SmsBroadcastReceiver extends BroadcastReceiver {
        private final WeakReference<OtpPinFieldPlugin> plugin;
        private final String smsCodeRegexPattern;

        public SmsBroadcastReceiver(WeakReference<OtpPinFieldPlugin> plugin, String smsCodeRegexPattern) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(smsCodeRegexPattern, "smsCodeRegexPattern");
            this.plugin = plugin;
            this.smsCodeRegexPattern = smsCodeRegexPattern;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            OtpPinFieldPlugin otpPinFieldPlugin;
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (!Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent.getAction()) || (otpPinFieldPlugin = this.plugin.get()) == null) {
                return;
            }
            Bundle extras = intent.getExtras();
            Object obj = extras != null ? extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS") : null;
            Status status = obj instanceof Status ? (Status) obj : null;
            if (status == null || status.getStatusCode() != 0) {
                return;
            }
            String string = extras.getString(SmsRetriever.EXTRA_SMS_MESSAGE);
            if (string == null) {
                string = "";
            }
            Intrinsics.checkNotNull(string);
            Matcher matcher = Pattern.compile(this.smsCodeRegexPattern).matcher(string);
            Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
            if (matcher.find()) {
                otpPinFieldPlugin.setCode(matcher.group(0));
            } else {
                otpPinFieldPlugin.setCode(string);
            }
        }
    }
}
