package com.amolg.flutterbarcodescanner;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.amolg.flutterbarcodescanner.BarcodeCaptureActivity;
import com.amolg.flutterbarcodescanner.widget.BarcodeViewFactory;
import com.google.android.gms.vision.barcode.Barcode;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Map;

/* loaded from: classes3.dex */
public class FlutterBarcodeScannerPlugin implements MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener, EventChannel.StreamHandler, FlutterPlugin, ActivityAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CHANNEL = "flutter_barcode_scanner";
    private static final int RC_BARCODE_CAPTURE = 9001;
    private static final String TAG = "FlutterBarcodeScannerPlugin";
    private static FlutterActivity activity = null;
    static EventChannel.EventSink barcodeStream = null;
    public static String cameraFacingText = "";
    public static int delayMillis = 0;
    public static boolean isContinuousScan = false;
    public static boolean isShowFlashIcon = false;
    public static String lineColor = "";
    private static MethodChannel.Result pendingResult;
    private ActivityPluginBinding activityBinding;
    private Application applicationContext;
    private Map<String, Object> arguments;
    private MethodChannel channel;
    private EventChannel eventChannel;
    private Lifecycle lifecycle;
    private LifeCycleObserver observer;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            pendingResult = result;
            if (methodCall.method.equals("scanBarcode")) {
                if (!(methodCall.arguments instanceof Map)) {
                    throw new IllegalArgumentException("Plugin not passing a map as parameter: " + methodCall.arguments);
                }
                Map<String, Object> map = (Map) methodCall.arguments;
                this.arguments = map;
                lineColor = (String) map.get("lineColor");
                isShowFlashIcon = ((Boolean) this.arguments.get("isShowFlashIcon")).booleanValue();
                String str = lineColor;
                if (str == null || str.equalsIgnoreCase("")) {
                    lineColor = "#DC143C";
                }
                if (this.arguments.get("scanMode") != null) {
                    if (((Integer) this.arguments.get("scanMode")).intValue() == BarcodeCaptureActivity.SCAN_MODE_ENUM.DEFAULT.ordinal()) {
                        BarcodeCaptureActivity.SCAN_MODE = BarcodeCaptureActivity.SCAN_MODE_ENUM.QR.ordinal();
                    } else {
                        BarcodeCaptureActivity.SCAN_MODE = ((Integer) this.arguments.get("scanMode")).intValue();
                    }
                } else {
                    BarcodeCaptureActivity.SCAN_MODE = BarcodeCaptureActivity.SCAN_MODE_ENUM.QR.ordinal();
                }
                setScanFormat();
                isContinuousScan = ((Boolean) this.arguments.get("isContinuousScan")).booleanValue();
                cameraFacingText = (String) this.arguments.get("cameraFacingText");
                if (this.arguments.get("delayMillis") != null) {
                    delayMillis = ((Integer) this.arguments.get("delayMillis")).intValue();
                }
                startBarcodeScannerActivityView((String) this.arguments.get("cancelButtonText"), isContinuousScan, cameraFacingText);
            }
        } catch (Exception e) {
            Log.e(TAG, "onMethodCall: " + e.getLocalizedMessage());
        }
    }

    private void setScanFormat() {
        BarcodeCaptureActivity.SCAN_FORMAT_ENUM scan_format_enum = BarcodeCaptureActivity.SCAN_FORMAT_ENUM.ALL_FORMATS;
        if (this.arguments.get("scanFormat") != null) {
            String upperCase = ((String) this.arguments.get("scanFormat")).toUpperCase();
            upperCase.hashCode();
            if (upperCase.equals("ONLY_QR_CODE")) {
                scan_format_enum = BarcodeCaptureActivity.SCAN_FORMAT_ENUM.ONLY_QR_CODE;
            } else if (upperCase.equals("ONLY_BARCODE")) {
                scan_format_enum = BarcodeCaptureActivity.SCAN_FORMAT_ENUM.ONLY_BARCODE;
            }
        }
        BarcodeCaptureActivity.SCAN_FORMAT = scan_format_enum;
    }

    private void startBarcodeScannerActivityView(String str, boolean z, String str2) {
        try {
            Intent putExtra = new Intent(activity, (Class<?>) BarcodeCaptureActivity.class).putExtra("cancelButtonText", str).putExtra("delayMillis", delayMillis).putExtra("cameraFacingText", str2);
            if (z) {
                activity.startActivity(putExtra);
            } else {
                activity.startActivityForResult(putExtra, RC_BARCODE_CAPTURE);
            }
        } catch (Exception e) {
            Log.e(TAG, "startView: " + e.getLocalizedMessage());
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i != RC_BARCODE_CAPTURE) {
            return false;
        }
        if (i2 != 0) {
            pendingResult.success("-1");
            return false;
        }
        if (intent == null) {
            pendingResult.success("-1");
        } else {
            try {
                pendingResult.success(((Barcode) intent.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject)).rawValue);
            } catch (Exception unused) {
                pendingResult.success("-1");
            }
        }
        pendingResult = null;
        this.arguments = null;
        return true;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        try {
            barcodeStream = eventSink;
        } catch (Exception unused) {
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        try {
            barcodeStream = null;
        } catch (Exception unused) {
        }
    }

    public static void onBarcodeScanReceiver(final Barcode barcode) {
        if (barcode != null) {
            try {
                if (barcode.displayValue.isEmpty()) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.amolg.flutterbarcodescanner.FlutterBarcodeScannerPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FlutterBarcodeScannerPlugin.barcodeStream.success(Barcode.this.rawValue);
                    }
                });
            } catch (Exception e) {
                Log.e(TAG, "onBarcodeScanReceiver: " + e.getLocalizedMessage());
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
        flutterPluginBinding.getPlatformViewRegistry().registerViewFactory("plugins.codingwithtashi/barcode_scanner_view", new BarcodeViewFactory(flutterPluginBinding.getBinaryMessenger()));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }

    private void createPluginSetup(BinaryMessenger binaryMessenger, Application application, Activity activity2, ActivityPluginBinding activityPluginBinding) {
        activity = (FlutterActivity) activity2;
        EventChannel eventChannel = new EventChannel(binaryMessenger, "flutter_barcode_scanner_receiver");
        this.eventChannel = eventChannel;
        eventChannel.setStreamHandler(this);
        this.applicationContext = application;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        activityPluginBinding.addActivityResultListener(this);
        this.lifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
        LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity2);
        this.observer = lifeCycleObserver;
        this.lifecycle.addObserver(lifeCycleObserver);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
        createPluginSetup(this.pluginBinding.getBinaryMessenger(), (Application) this.pluginBinding.getApplicationContext(), this.activityBinding.getActivity(), this.activityBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        clearPluginSetup();
    }

    private void clearPluginSetup() {
        activity = null;
        this.activityBinding.removeActivityResultListener(this);
        this.activityBinding = null;
        this.lifecycle.removeObserver(this.observer);
        this.lifecycle = null;
        this.channel.setMethodCallHandler(null);
        this.eventChannel.setStreamHandler(null);
        this.channel = null;
        this.applicationContext.unregisterActivityLifecycleCallbacks(this.observer);
        this.applicationContext = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
        private final Activity thisActivity;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onCreate(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onPause(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(LifecycleOwner lifecycleOwner) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(LifecycleOwner lifecycleOwner) {
        }

        LifeCycleObserver(Activity activity) {
            this.thisActivity = activity;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(LifecycleOwner lifecycleOwner) {
            onActivityStopped(this.thisActivity);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            onActivityDestroyed(this.thisActivity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.thisActivity != activity || activity.getApplicationContext() == null) {
                return;
            }
            ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        }
    }
}
