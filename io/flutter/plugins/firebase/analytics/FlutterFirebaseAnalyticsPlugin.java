package io.flutter.plugins.firebase.analytics;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public class FlutterFirebaseAnalyticsPlugin implements FlutterFirebasePlugin, MethodChannel.MethodCallHandler, FlutterPlugin {
    private FirebaseAnalytics analytics;
    private MethodChannel channel;

    private void initInstance(BinaryMessenger binaryMessenger, Context context) {
        this.analytics = FirebaseAnalytics.getInstance(context);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_analytics");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_analytics", this);
    }

    private static Bundle createBundleFromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof String) {
                bundle.putString(key, (String) value);
            } else if (value instanceof Integer) {
                bundle.putLong(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Double) {
                bundle.putDouble(key, ((Double) value).doubleValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value == null) {
                bundle.putString(key, null);
            } else if (value instanceof Iterable) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (Object obj : (Iterable) value) {
                    if (obj instanceof Map) {
                        arrayList.add(createBundleFromMap((Map) obj));
                    } else {
                        throw new IllegalArgumentException("Unsupported value type: " + obj.getClass().getCanonicalName() + " in list at key " + key);
                    }
                }
                bundle.putParcelableArrayList(key, arrayList);
            } else if (value instanceof Map) {
                bundle.putParcelable(key, createBundleFromMap((Map) value));
            } else {
                throw new IllegalArgumentException("Unsupported value type: " + value.getClass().getCanonicalName());
            }
        }
        return bundle;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
            this.channel = null;
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Task handleGetAppInstanceId;
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2090892968:
                if (str.equals("Analytics#getAppInstanceId")) {
                    c = 0;
                    break;
                }
                break;
            case -1931910274:
                if (str.equals("Analytics#resetAnalyticsData")) {
                    c = 1;
                    break;
                }
                break;
            case -1572470123:
                if (str.equals("Analytics#setConsent")) {
                    c = 2;
                    break;
                }
                break;
            case -273201790:
                if (str.equals("Analytics#setAnalyticsCollectionEnabled")) {
                    c = 3;
                    break;
                }
                break;
            case -99047480:
                if (str.equals("Analytics#setDefaultEventParameters")) {
                    c = 4;
                    break;
                }
                break;
            case -45011405:
                if (str.equals("Analytics#logEvent")) {
                    c = 5;
                    break;
                }
                break;
            case 179244440:
                if (str.equals("Analytics#getSessionId")) {
                    c = 6;
                    break;
                }
                break;
            case 1083589925:
                if (str.equals("Analytics#setUserProperty")) {
                    c = 7;
                    break;
                }
                break;
            case 1751063748:
                if (str.equals("Analytics#setSessionTimeoutDuration")) {
                    c = '\b';
                    break;
                }
                break;
            case 1992044651:
                if (str.equals("Analytics#setUserId")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                handleGetAppInstanceId = handleGetAppInstanceId();
                break;
            case 1:
                handleGetAppInstanceId = handleResetAnalyticsData();
                break;
            case 2:
                handleGetAppInstanceId = setConsent((Map) methodCall.arguments());
                break;
            case 3:
                handleGetAppInstanceId = handleSetAnalyticsCollectionEnabled((Map) methodCall.arguments());
                break;
            case 4:
                handleGetAppInstanceId = setDefaultEventParameters((Map) methodCall.arguments());
                break;
            case 5:
                handleGetAppInstanceId = handleLogEvent((Map) methodCall.arguments());
                break;
            case 6:
                handleGetAppInstanceId = handleGetSessionId();
                break;
            case 7:
                handleGetAppInstanceId = handleSetUserProperty((Map) methodCall.arguments());
                break;
            case '\b':
                handleGetAppInstanceId = handleSetSessionTimeoutDuration((Map) methodCall.arguments());
                break;
            case '\t':
                handleGetAppInstanceId = handleSetUserId((Map) methodCall.arguments());
                break;
            default:
                result.notImplemented();
                return;
        }
        handleGetAppInstanceId.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.lambda$onMethodCall$0(MethodChannel.Result.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onMethodCall$0(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
        } else {
            Exception exception = task.getException();
            result.error("firebase_analytics", exception != null ? exception.getMessage() : "An unknown error occurred", null);
        }
    }

    private Task<Long> handleGetSessionId() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleGetSessionId$1(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleGetSessionId$1(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult((Long) Tasks.await(this.analytics.getSessionId()));
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> handleLogEvent(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleLogEvent$2(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogEvent$2(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            this.analytics.logEvent((String) Objects.requireNonNull(map.get(Constants.EVENT_NAME)), createBundleFromMap((Map) map.get(Constants.PARAMETERS)));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> handleSetUserId(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleSetUserId$3(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSetUserId$3(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            this.analytics.setUserId((String) map.get(Constants.USER_ID));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> handleSetAnalyticsCollectionEnabled(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleSetAnalyticsCollectionEnabled$4(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSetAnalyticsCollectionEnabled$4(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            this.analytics.setAnalyticsCollectionEnabled(((Boolean) Objects.requireNonNull(map.get(Constants.ENABLED))).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> handleSetSessionTimeoutDuration(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleSetSessionTimeoutDuration$5(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSetSessionTimeoutDuration$5(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            this.analytics.setSessionTimeoutDuration(((Integer) Objects.requireNonNull(map.get(Constants.MILLISECONDS))).intValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> handleSetUserProperty(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleSetUserProperty$6(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSetUserProperty$6(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            this.analytics.setUserProperty((String) Objects.requireNonNull(map.get("name")), (String) map.get("value"));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> handleResetAnalyticsData() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleResetAnalyticsData$7(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleResetAnalyticsData$7(TaskCompletionSource taskCompletionSource) {
        try {
            this.analytics.resetAnalyticsData();
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> setConsent(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$setConsent$8(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setConsent$8(Map map, TaskCompletionSource taskCompletionSource) {
        FirebaseAnalytics.ConsentStatus consentStatus;
        FirebaseAnalytics.ConsentStatus consentStatus2;
        FirebaseAnalytics.ConsentStatus consentStatus3;
        FirebaseAnalytics.ConsentStatus consentStatus4;
        try {
            Boolean bool = (Boolean) map.get(Constants.AD_STORAGE_CONSENT_GRANTED);
            Boolean bool2 = (Boolean) map.get(Constants.ANALYTICS_STORAGE_CONSENT_GRANTED);
            Boolean bool3 = (Boolean) map.get(Constants.AD_PERSONALIZATION_SIGNALS_CONSENT_GRANTED);
            Boolean bool4 = (Boolean) map.get(Constants.AD_USER_DATA_CONSENT_GRANTED);
            HashMap hashMap = new HashMap();
            if (bool != null) {
                FirebaseAnalytics.ConsentType consentType = FirebaseAnalytics.ConsentType.AD_STORAGE;
                if (bool.booleanValue()) {
                    consentStatus4 = FirebaseAnalytics.ConsentStatus.GRANTED;
                } else {
                    consentStatus4 = FirebaseAnalytics.ConsentStatus.DENIED;
                }
                hashMap.put(consentType, consentStatus4);
            }
            if (bool2 != null) {
                FirebaseAnalytics.ConsentType consentType2 = FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE;
                if (bool2.booleanValue()) {
                    consentStatus3 = FirebaseAnalytics.ConsentStatus.GRANTED;
                } else {
                    consentStatus3 = FirebaseAnalytics.ConsentStatus.DENIED;
                }
                hashMap.put(consentType2, consentStatus3);
            }
            if (bool3 != null) {
                FirebaseAnalytics.ConsentType consentType3 = FirebaseAnalytics.ConsentType.AD_PERSONALIZATION;
                if (bool3.booleanValue()) {
                    consentStatus2 = FirebaseAnalytics.ConsentStatus.GRANTED;
                } else {
                    consentStatus2 = FirebaseAnalytics.ConsentStatus.DENIED;
                }
                hashMap.put(consentType3, consentStatus2);
            }
            if (bool4 != null) {
                FirebaseAnalytics.ConsentType consentType4 = FirebaseAnalytics.ConsentType.AD_USER_DATA;
                if (bool4.booleanValue()) {
                    consentStatus = FirebaseAnalytics.ConsentStatus.GRANTED;
                } else {
                    consentStatus = FirebaseAnalytics.ConsentStatus.DENIED;
                }
                hashMap.put(consentType4, consentStatus);
            }
            this.analytics.setConsent(hashMap);
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<Void> setDefaultEventParameters(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$setDefaultEventParameters$9(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultEventParameters$9(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            this.analytics.setDefaultEventParameters(createBundleFromMap(map));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    private Task<String> handleGetAppInstanceId() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$handleGetAppInstanceId$10(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleGetAppInstanceId$10(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult((String) Tasks.await(this.analytics.getAppInstanceId()));
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.this.lambda$getPluginConstantsForFirebaseApp$11(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPluginConstantsForFirebaseApp$11(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin.1
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.lambda$didReinitializeFirebaseCore$12(TaskCompletionSource.this);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$didReinitializeFirebaseCore$12(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }
}
