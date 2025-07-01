package fman.ge.smart_auth;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmartAuthPlugin.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003GHIB\u0005¢\u0006\u0002\u0010\u0005J0\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015j\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0016\u0010\"\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0$H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\"\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u000bH\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010.\u001a\u000201H\u0016J\u001a\u00105\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001a\u00106\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u00108\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u000bH\u0016J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020)H\u0002J\u001a\u0010:\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010;\u001a\u00020\u001bH\u0002J\b\u0010<\u001a\u00020\u001bH\u0002J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0018\u0010>\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0018\u0010@\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u001bH\u0002J\u0012\u0010D\u001a\u00020\u001b2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0018\u00010\u0013R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lfman/ge/smart_auth/SmartAuthPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "()V", "consentReceiver", "Lfman/ge/smart_auth/SmartAuthPlugin$ConsentBroadcastReceiver;", "mActivity", "Landroid/app/Activity;", "mBinding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "mChannel", "Lio/flutter/plugin/common/MethodChannel;", "mContext", "Landroid/content/Context;", "pendingResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "smsReceiver", "Lfman/ge/smart_auth/SmartAuthPlugin$SmsBroadcastReceiver;", "credentialToMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", URLCredentialContract.FeedEntry.TABLE_NAME, "Lcom/google/android/gms/auth/api/credentials/Credential;", "deleteCredential", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "dispose", "getCredential", "getSignature", "ignoreIllegalState", "fn", "Lkotlin/Function0;", "maybeBuildCredential", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToActivity", "binding", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onGetCredentialRequest", "onHintRequest", "onMethodCall", "onReattachedToActivityForConfigChanges", "onSaveCredentialRequest", "onSmsConsentRequest", "removeSmsRetrieverListener", "removeSmsUserConsentListener", "requestHint", "saveCredential", "startSmsRetriever", "startSmsUserConsent", "stopSmsRetriever", "stopSmsUserConsent", "unregisterAllReceivers", "unregisterReceiver", "receiver", "Landroid/content/BroadcastReceiver;", "Companion", "ConsentBroadcastReceiver", "SmsBroadcastReceiver", "smart_auth_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SmartAuthPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware, PluginRegistry.ActivityResultListener {
    private static final int GET_CREDENTIAL_REQUEST = 11103;
    private static final int HINT_REQUEST = 11100;
    private static final String PLUGIN_TAG = "Pinput/SmartAuth";
    private static final int SAVE_CREDENTIAL_REQUEST = 11102;
    private static final int USER_CONSENT_REQUEST = 11101;
    private ConsentBroadcastReceiver consentReceiver;
    private Activity mActivity;
    private ActivityPluginBinding mBinding;
    private MethodChannel mChannel;
    private Context mContext;
    private MethodChannel.Result pendingResult;
    private SmsBroadcastReceiver smsReceiver;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.mChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "fman.smart_auth");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.mContext = applicationContext;
        MethodChannel methodChannel = this.mChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        dispose();
        MethodChannel methodChannel = this.mChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        this.mChannel = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        dispose();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        dispose();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mActivity = binding.getActivity();
        this.mBinding = binding;
        binding.addActivityResultListener(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mActivity = binding.getActivity();
        this.mBinding = binding;
        binding.addActivityResultListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0012. Please report as an issue. */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1067412648:
                    if (str.equals("stopSmsUserConsent")) {
                        stopSmsUserConsent(result);
                        return;
                    }
                    break;
                case -981163955:
                    if (str.equals("getCredential")) {
                        getCredential(call, result);
                        return;
                    }
                    break;
                case -133945416:
                    if (str.equals("startSmsUserConsent")) {
                        startSmsUserConsent(call, result);
                        return;
                    }
                    break;
                case 37270495:
                    if (str.equals("startSmsRetriever")) {
                        startSmsRetriever(result);
                        return;
                    }
                    break;
                case 115451405:
                    if (str.equals("getAppSignature")) {
                        getSignature(result);
                        return;
                    }
                    break;
                case 805013375:
                    if (str.equals("stopSmsRetriever")) {
                        stopSmsRetriever(result);
                        return;
                    }
                    break;
                case 1149724086:
                    if (str.equals("requestHint")) {
                        requestHint(call, result);
                        return;
                    }
                    break;
                case 1853459892:
                    if (str.equals("saveCredential")) {
                        saveCredential(call, result);
                        return;
                    }
                    break;
                case 2090692706:
                    if (str.equals("deleteCredential")) {
                        deleteCredential(call, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case HINT_REQUEST /* 11100 */:
                onHintRequest(resultCode, data);
                return true;
            case USER_CONSENT_REQUEST /* 11101 */:
                onSmsConsentRequest(resultCode, data);
                return true;
            case SAVE_CREDENTIAL_REQUEST /* 11102 */:
                onSaveCredentialRequest(resultCode);
                return true;
            case GET_CREDENTIAL_REQUEST /* 11103 */:
                onGetCredentialRequest(resultCode, data);
                return true;
            default:
                return true;
        }
    }

    private final void getSignature(MethodChannel.Result result) {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        result.success(CollectionsKt.getOrNull(new AppSignatureHelper(context).getAppSignatures(), 0));
    }

    private final void requestHint(MethodCall call, MethodChannel.Result result) {
        this.pendingResult = result;
        Boolean bool = (Boolean) call.argument("showAddAccountButton");
        Boolean bool2 = (Boolean) call.argument("showCancelButton");
        Boolean bool3 = (Boolean) call.argument("isPhoneNumberIdentifierSupported");
        Boolean bool4 = (Boolean) call.argument("isEmailAddressIdentifierSupported");
        String str = (String) call.argument("accountTypes");
        String str2 = (String) call.argument("idTokenNonce");
        Boolean bool5 = (Boolean) call.argument("isIdTokenRequested");
        String str3 = (String) call.argument("serverClientId");
        HintRequest.Builder builder = new HintRequest.Builder();
        CredentialPickerConfig.Builder builder2 = new CredentialPickerConfig.Builder();
        if (bool != null) {
            builder2.setShowAddAccountButton(bool.booleanValue());
        }
        if (bool2 != null) {
            builder2.setShowCancelButton(bool2.booleanValue());
        }
        builder.setHintPickerConfig(builder2.build());
        if (bool3 != null) {
            builder.setPhoneNumberIdentifierSupported(bool3.booleanValue());
        }
        if (bool4 != null) {
            builder.setEmailAddressIdentifierSupported(bool4.booleanValue());
        }
        if (str != null) {
            builder.setAccountTypes(new String[]{str});
        }
        if (str2 != null) {
            builder.setIdTokenNonce(str2);
        }
        if (bool5 != null) {
            builder.setIdTokenRequested(bool5.booleanValue());
        }
        if (str3 != null) {
            builder.setServerClientId(str3);
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        PendingIntent hintPickerIntent = Credentials.getClient(context).getHintPickerIntent(builder.build());
        Intrinsics.checkNotNullExpressionValue(hintPickerIntent, "getHintPickerIntent(...)");
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity);
            ActivityCompat.startIntentSenderForResult(activity, hintPickerIntent.getIntentSender(), HINT_REQUEST, null, 0, 0, 0, null);
        }
    }

    private final void saveCredential(MethodCall call, final MethodChannel.Result result) {
        Credential maybeBuildCredential = maybeBuildCredential(call, result);
        if (maybeBuildCredential == null) {
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        CredentialsClient client = Credentials.getClient(context);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        client.save(maybeBuildCredential).addOnCompleteListener(new OnCompleteListener() { // from class: fman.ge.smart_auth.SmartAuthPlugin$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SmartAuthPlugin.saveCredential$lambda$0(MethodChannel.Result.this, this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveCredential$lambda$0(MethodChannel.Result result, SmartAuthPlugin this$0, Task task) {
        Activity activity;
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            result.success(true);
            return;
        }
        Exception exception = task.getException();
        if ((exception instanceof ResolvableApiException) && ((ResolvableApiException) exception).getStatusCode() == 6 && (activity = this$0.mActivity) != null) {
            try {
                this$0.pendingResult = result;
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
                ((ResolvableApiException) exception).startResolutionForResult(activity, SAVE_CREDENTIAL_REQUEST);
                return;
            } catch (IntentSender.SendIntentException e) {
                Log.e(PLUGIN_TAG, "Failed to send resolution.", e);
            }
        }
        result.success(false);
    }

    private final void getCredential(MethodCall call, final MethodChannel.Result result) {
        String str = (String) call.argument("accountType");
        String str2 = (String) call.argument("serverClientId");
        String str3 = (String) call.argument("idTokenNonce");
        Boolean bool = (Boolean) call.argument("isIdTokenRequested");
        Boolean bool2 = (Boolean) call.argument("isPasswordLoginSupported");
        Boolean bool3 = (Boolean) call.argument("showResolveDialog");
        if (bool3 == null) {
            bool3 = false;
        }
        final boolean booleanValue = bool3.booleanValue();
        CredentialRequest.Builder accountTypes = new CredentialRequest.Builder().setAccountTypes(new String[]{str});
        Intrinsics.checkNotNullExpressionValue(accountTypes, "setAccountTypes(...)");
        if (str != null) {
            accountTypes.setAccountTypes(new String[]{str});
        }
        if (str3 != null) {
            accountTypes.setIdTokenNonce(str3);
        }
        if (bool != null) {
            accountTypes.setIdTokenRequested(bool.booleanValue());
        }
        if (bool2 != null) {
            accountTypes.setPasswordLoginSupported(bool2.booleanValue());
        }
        if (str2 != null) {
            accountTypes.setServerClientId(str2);
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        CredentialsClient client = Credentials.getClient(context);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        client.request(accountTypes.build()).addOnCompleteListener(new OnCompleteListener() { // from class: fman.ge.smart_auth.SmartAuthPlugin$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SmartAuthPlugin.getCredential$lambda$1(MethodChannel.Result.this, this, booleanValue, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCredential$lambda$1(MethodChannel.Result result, SmartAuthPlugin this$0, boolean z, Task task) {
        Activity activity;
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful() && task.getResult() != null && ((CredentialRequestResponse) task.getResult()).getCredential() != null) {
            Object result2 = task.getResult();
            Intrinsics.checkNotNull(result2);
            Credential credential = ((CredentialRequestResponse) result2).getCredential();
            if (credential != null) {
                result.success(this$0.credentialToMap(credential));
                return;
            }
        }
        Exception exception = task.getException();
        if ((exception instanceof ResolvableApiException) && ((ResolvableApiException) exception).getStatusCode() == 6 && (activity = this$0.mActivity) != null && z) {
            try {
                this$0.pendingResult = result;
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
                ((ResolvableApiException) exception).startResolutionForResult(activity, GET_CREDENTIAL_REQUEST);
                return;
            } catch (IntentSender.SendIntentException e) {
                Log.e(PLUGIN_TAG, "Failed to send resolution.", e);
            }
        }
        result.success(null);
    }

    private final void deleteCredential(MethodCall call, final MethodChannel.Result result) {
        Credential maybeBuildCredential = maybeBuildCredential(call, result);
        if (maybeBuildCredential == null) {
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        CredentialsClient client = Credentials.getClient(context);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        client.delete(maybeBuildCredential).addOnCompleteListener(new OnCompleteListener() { // from class: fman.ge.smart_auth.SmartAuthPlugin$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SmartAuthPlugin.deleteCredential$lambda$2(MethodChannel.Result.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteCredential$lambda$2(MethodChannel.Result result, Task task) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(task, "task");
        result.success(Boolean.valueOf(task.isSuccessful()));
    }

    private final void startSmsRetriever(MethodChannel.Result result) {
        Context context;
        unregisterAllReceivers();
        this.pendingResult = result;
        this.smsReceiver = new SmsBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
        Context context2 = this.mContext;
        Context context3 = null;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        } else {
            context = context2;
        }
        ContextCompat.registerReceiver(context, this.smsReceiver, intentFilter, SmsRetriever.SEND_PERMISSION, null, 2);
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context3 = context4;
        }
        SmsRetriever.getClient(context3).startSmsRetriever();
    }

    private final void stopSmsRetriever(MethodChannel.Result result) {
        if (this.smsReceiver == null) {
            result.success(false);
        } else {
            removeSmsRetrieverListener();
            result.success(true);
        }
    }

    private final void startSmsUserConsent(MethodCall call, MethodChannel.Result result) {
        Context context;
        unregisterAllReceivers();
        this.pendingResult = result;
        this.consentReceiver = new ConsentBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
        Context context2 = this.mContext;
        Context context3 = null;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        } else {
            context = context2;
        }
        ContextCompat.registerReceiver(context, this.consentReceiver, intentFilter, SmsRetriever.SEND_PERMISSION, null, 2);
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context3 = context4;
        }
        SmsRetriever.getClient(context3).startSmsUserConsent((String) call.argument("senderPhoneNumber"));
    }

    private final void stopSmsUserConsent(MethodChannel.Result result) {
        if (this.consentReceiver == null) {
            result.success(false);
        } else {
            removeSmsUserConsentListener();
            result.success(true);
        }
    }

    private final void onHintRequest(int resultCode, Intent data) {
        final Credential parcelableExtra;
        if (resultCode == -1 && data != null && (parcelableExtra = data.getParcelableExtra("com.google.android.gms.credentials.Credential")) != null) {
            ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$onHintRequest$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    HashMap credentialToMap;
                    result = SmartAuthPlugin.this.pendingResult;
                    if (result != null) {
                        credentialToMap = SmartAuthPlugin.this.credentialToMap(parcelableExtra);
                        result.success(credentialToMap);
                    }
                }
            });
        } else {
            ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$onHintRequest$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    result = SmartAuthPlugin.this.pendingResult;
                    if (result != null) {
                        result.success(null);
                    }
                }
            });
        }
    }

    private final void onSmsConsentRequest(int resultCode, Intent data) {
        if (resultCode == -1 && data != null) {
            final String stringExtra = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
            ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$onSmsConsentRequest$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    result = SmartAuthPlugin.this.pendingResult;
                    if (result != null) {
                        result.success(stringExtra);
                    }
                }
            });
        } else {
            ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$onSmsConsentRequest$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    result = SmartAuthPlugin.this.pendingResult;
                    if (result != null) {
                        result.success(null);
                    }
                }
            });
        }
    }

    private final void onSaveCredentialRequest(final int resultCode) {
        ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$onSaveCredentialRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MethodChannel.Result result;
                result = SmartAuthPlugin.this.pendingResult;
                if (result != null) {
                    result.success(Boolean.valueOf(resultCode == -1));
                }
            }
        });
    }

    private final void onGetCredentialRequest(int resultCode, Intent data) {
        final Credential parcelableExtra;
        if (resultCode == -1 && data != null && (parcelableExtra = data.getParcelableExtra("com.google.android.gms.credentials.Credential")) != null) {
            ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$onGetCredentialRequest$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    HashMap credentialToMap;
                    result = SmartAuthPlugin.this.pendingResult;
                    if (result != null) {
                        credentialToMap = SmartAuthPlugin.this.credentialToMap(parcelableExtra);
                        result.success(credentialToMap);
                    }
                }
            });
        } else {
            ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$onGetCredentialRequest$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    result = SmartAuthPlugin.this.pendingResult;
                    if (result != null) {
                        result.success(null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, String> credentialToMap(Credential credential) {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put("accountType", credential.getAccountType());
        hashMap2.put("familyName", credential.getFamilyName());
        hashMap2.put("givenName", credential.getGivenName());
        hashMap2.put(TtmlNode.ATTR_ID, credential.getId());
        hashMap2.put("name", credential.getName());
        hashMap2.put(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD, credential.getPassword());
        hashMap2.put("profilePictureUri", String.valueOf(credential.getProfilePictureUri()));
        return hashMap;
    }

    private final Credential maybeBuildCredential(MethodCall call, MethodChannel.Result result) {
        String str = (String) call.argument("accountType");
        String str2 = (String) call.argument(TtmlNode.ATTR_ID);
        String str3 = (String) call.argument("name");
        String str4 = (String) call.argument(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD);
        String str5 = (String) call.argument("profilePictureUri");
        if (str2 == null) {
            result.success(false);
            return null;
        }
        Credential.Builder builder = new Credential.Builder(str2);
        if (str != null) {
            builder.setAccountType(str);
        }
        if (str3 != null) {
            builder.setName(str3);
        }
        if (str4 != null) {
            builder.setPassword(str4);
        }
        if (str5 != null) {
            builder.setProfilePictureUri(Uri.parse(str5));
        }
        return builder.build();
    }

    private final void dispose() {
        unregisterAllReceivers();
        ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$dispose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MethodChannel.Result result;
                result = SmartAuthPlugin.this.pendingResult;
                if (result != null) {
                    result.success(null);
                }
            }
        });
        this.mActivity = null;
        ActivityPluginBinding activityPluginBinding = this.mBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this);
        }
        this.mBinding = null;
    }

    private final void unregisterAllReceivers() {
        removeSmsRetrieverListener();
        removeSmsUserConsentListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSmsRetrieverListener() {
        SmsBroadcastReceiver smsBroadcastReceiver = this.smsReceiver;
        if (smsBroadcastReceiver != null) {
            unregisterReceiver(smsBroadcastReceiver);
            this.smsReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSmsUserConsentListener() {
        ConsentBroadcastReceiver consentBroadcastReceiver = this.consentReceiver;
        if (consentBroadcastReceiver != null) {
            unregisterReceiver(consentBroadcastReceiver);
            this.consentReceiver = null;
        }
    }

    private final void unregisterReceiver(BroadcastReceiver receiver) {
        if (receiver != null) {
            try {
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context = null;
                }
                context.unregisterReceiver(receiver);
            } catch (Exception e) {
                Log.e(PLUGIN_TAG, "Unregistering receiver failed.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ignoreIllegalState(Function0<Unit> fn) {
        try {
            fn.invoke();
        } catch (IllegalStateException e) {
            Log.e(PLUGIN_TAG, "ignoring exception: " + e);
        }
    }

    /* compiled from: SmartAuthPlugin.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lfman/ge/smart_auth/SmartAuthPlugin$SmsBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lfman/ge/smart_auth/SmartAuthPlugin;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "smart_auth_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final class SmsBroadcastReceiver extends BroadcastReceiver {
        public SmsBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent.getAction())) {
                SmartAuthPlugin.this.removeSmsRetrieverListener();
                if (intent.getExtras() != null) {
                    Bundle extras = intent.getExtras();
                    Intrinsics.checkNotNull(extras);
                    if (extras.containsKey("com.google.android.gms.auth.api.phone.EXTRA_STATUS")) {
                        Bundle extras2 = intent.getExtras();
                        Intrinsics.checkNotNull(extras2);
                        Object obj = extras2.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
                        Status status = (Status) obj;
                        int statusCode = status.getStatusCode();
                        if (statusCode == 0) {
                            final String string = extras2.getString(SmsRetriever.EXTRA_SMS_MESSAGE);
                            if (string != null) {
                                SmartAuthPlugin smartAuthPlugin = SmartAuthPlugin.this;
                                final SmartAuthPlugin smartAuthPlugin2 = SmartAuthPlugin.this;
                                smartAuthPlugin.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$SmsBroadcastReceiver$onReceive$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        MethodChannel.Result result;
                                        result = SmartAuthPlugin.this.pendingResult;
                                        if (result != null) {
                                            result.success(string);
                                        }
                                    }
                                });
                                return;
                            } else {
                                Log.e(SmartAuthPlugin.PLUGIN_TAG, "Retrieved SMS is null, check if SMS contains correct app signature");
                                SmartAuthPlugin smartAuthPlugin3 = SmartAuthPlugin.this;
                                final SmartAuthPlugin smartAuthPlugin4 = SmartAuthPlugin.this;
                                smartAuthPlugin3.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$SmsBroadcastReceiver$onReceive$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        MethodChannel.Result result;
                                        result = SmartAuthPlugin.this.pendingResult;
                                        if (result != null) {
                                            result.success(null);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        if (statusCode == 15) {
                            Log.e(SmartAuthPlugin.PLUGIN_TAG, "SMS Retriever API timed out, check if SMS contains correct app signature");
                            SmartAuthPlugin smartAuthPlugin5 = SmartAuthPlugin.this;
                            final SmartAuthPlugin smartAuthPlugin6 = SmartAuthPlugin.this;
                            smartAuthPlugin5.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$SmsBroadcastReceiver$onReceive$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    MethodChannel.Result result;
                                    result = SmartAuthPlugin.this.pendingResult;
                                    if (result != null) {
                                        result.success(null);
                                    }
                                }
                            });
                            return;
                        }
                        Log.e(SmartAuthPlugin.PLUGIN_TAG, "SMS Retriever API failed with status code: " + status.getStatusCode() + ", check if SMS contains correct app signature");
                        SmartAuthPlugin smartAuthPlugin7 = SmartAuthPlugin.this;
                        final SmartAuthPlugin smartAuthPlugin8 = SmartAuthPlugin.this;
                        smartAuthPlugin7.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$SmsBroadcastReceiver$onReceive$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MethodChannel.Result result;
                                result = SmartAuthPlugin.this.pendingResult;
                                if (result != null) {
                                    result.success(null);
                                }
                            }
                        });
                        return;
                    }
                }
                Log.e(SmartAuthPlugin.PLUGIN_TAG, "SMS Retriever API failed with no status code, check if SMS contains correct app signature");
                SmartAuthPlugin smartAuthPlugin9 = SmartAuthPlugin.this;
                final SmartAuthPlugin smartAuthPlugin10 = SmartAuthPlugin.this;
                smartAuthPlugin9.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$SmsBroadcastReceiver$onReceive$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MethodChannel.Result result;
                        result = SmartAuthPlugin.this.pendingResult;
                        if (result != null) {
                            result.success(null);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: SmartAuthPlugin.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lfman/ge/smart_auth/SmartAuthPlugin$ConsentBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lfman/ge/smart_auth/SmartAuthPlugin;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "smart_auth_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final class ConsentBroadcastReceiver extends BroadcastReceiver {
        public ConsentBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent.getAction())) {
                SmartAuthPlugin.this.removeSmsUserConsentListener();
                if (intent.getExtras() != null) {
                    Bundle extras = intent.getExtras();
                    Intrinsics.checkNotNull(extras);
                    if (extras.containsKey("com.google.android.gms.auth.api.phone.EXTRA_STATUS")) {
                        Bundle extras2 = intent.getExtras();
                        Intrinsics.checkNotNull(extras2);
                        Object obj = extras2.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
                        Status status = (Status) obj;
                        int statusCode = status.getStatusCode();
                        if (statusCode != 0) {
                            if (statusCode == 15) {
                                Log.e(SmartAuthPlugin.PLUGIN_TAG, "ConsentBroadcastReceiver Timeout");
                                SmartAuthPlugin smartAuthPlugin = SmartAuthPlugin.this;
                                final SmartAuthPlugin smartAuthPlugin2 = SmartAuthPlugin.this;
                                smartAuthPlugin.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$ConsentBroadcastReceiver$onReceive$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        MethodChannel.Result result;
                                        result = SmartAuthPlugin.this.pendingResult;
                                        if (result != null) {
                                            result.success(null);
                                        }
                                    }
                                });
                                return;
                            }
                            Log.e(SmartAuthPlugin.PLUGIN_TAG, "ConsentBroadcastReceiver failed with status code: " + status.getStatusCode());
                            SmartAuthPlugin smartAuthPlugin3 = SmartAuthPlugin.this;
                            final SmartAuthPlugin smartAuthPlugin4 = SmartAuthPlugin.this;
                            smartAuthPlugin3.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$ConsentBroadcastReceiver$onReceive$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    MethodChannel.Result result;
                                    result = SmartAuthPlugin.this.pendingResult;
                                    if (result != null) {
                                        result.success(null);
                                    }
                                }
                            });
                            return;
                        }
                        try {
                            Intent intent2 = (Intent) extras2.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT);
                            if (intent2 != null && SmartAuthPlugin.this.mActivity != null) {
                                Activity activity = SmartAuthPlugin.this.mActivity;
                                if (activity != null) {
                                    activity.startActivityForResult(intent2, SmartAuthPlugin.USER_CONSENT_REQUEST);
                                }
                            } else {
                                Log.e(SmartAuthPlugin.PLUGIN_TAG, "ConsentBroadcastReceiver error: Can't start consent intent. consentIntent or mActivity is null");
                                SmartAuthPlugin smartAuthPlugin5 = SmartAuthPlugin.this;
                                final SmartAuthPlugin smartAuthPlugin6 = SmartAuthPlugin.this;
                                smartAuthPlugin5.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$ConsentBroadcastReceiver$onReceive$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        MethodChannel.Result result;
                                        result = SmartAuthPlugin.this.pendingResult;
                                        if (result != null) {
                                            result.success(null);
                                        }
                                    }
                                });
                            }
                            return;
                        } catch (ActivityNotFoundException e) {
                            Log.e(SmartAuthPlugin.PLUGIN_TAG, "ConsentBroadcastReceiver error: " + e);
                            SmartAuthPlugin smartAuthPlugin7 = SmartAuthPlugin.this;
                            final SmartAuthPlugin smartAuthPlugin8 = SmartAuthPlugin.this;
                            smartAuthPlugin7.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$ConsentBroadcastReceiver$onReceive$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    MethodChannel.Result result;
                                    result = SmartAuthPlugin.this.pendingResult;
                                    if (result != null) {
                                        result.success(null);
                                    }
                                }
                            });
                            return;
                        }
                    }
                }
                Log.e(SmartAuthPlugin.PLUGIN_TAG, "ConsentBroadcastReceiver failed with no status code");
                SmartAuthPlugin smartAuthPlugin9 = SmartAuthPlugin.this;
                final SmartAuthPlugin smartAuthPlugin10 = SmartAuthPlugin.this;
                smartAuthPlugin9.ignoreIllegalState(new Function0<Unit>() { // from class: fman.ge.smart_auth.SmartAuthPlugin$ConsentBroadcastReceiver$onReceive$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MethodChannel.Result result;
                        result = SmartAuthPlugin.this.pendingResult;
                        if (result != null) {
                            result.success(null);
                        }
                    }
                });
            }
        }
    }
}
