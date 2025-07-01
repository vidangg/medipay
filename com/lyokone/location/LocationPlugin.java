package com.lyokone.location;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.lyokone.location.FlutterLocationService;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* loaded from: classes4.dex */
public class LocationPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "LocationPlugin";
    private ActivityPluginBinding activityBinding;
    private FlutterLocationService locationService;
    private MethodCallHandlerImpl methodCallHandler;
    private final ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.lyokone.location.LocationPlugin.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(LocationPlugin.TAG, "Service connected: " + componentName);
            if (iBinder instanceof FlutterLocationService.LocalBinder) {
                LocationPlugin.this.initialize(((FlutterLocationService.LocalBinder) iBinder).getThis$0());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(LocationPlugin.TAG, "Service disconnected:" + componentName);
        }
    };
    private StreamHandlerImpl streamHandlerImpl;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl();
        this.methodCallHandler = methodCallHandlerImpl;
        methodCallHandlerImpl.startListening(flutterPluginBinding.getBinaryMessenger());
        StreamHandlerImpl streamHandlerImpl = new StreamHandlerImpl();
        this.streamHandlerImpl = streamHandlerImpl;
        streamHandlerImpl.startListening(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.stopListening();
            this.methodCallHandler = null;
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandlerImpl;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.stopListening();
            this.streamHandlerImpl = null;
        }
    }

    private void attachToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
        activityPluginBinding.getActivity().bindService(new Intent(activityPluginBinding.getActivity(), (Class<?>) FlutterLocationService.class), this.serviceConnection, 1);
    }

    private void detachActivity() {
        dispose();
        this.activityBinding.getActivity().unbindService(this.serviceConnection);
        this.activityBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        detachActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        detachActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize(FlutterLocationService flutterLocationService) {
        this.locationService = flutterLocationService;
        flutterLocationService.setActivity(this.activityBinding.getActivity());
        this.activityBinding.addActivityResultListener(this.locationService.getLocationActivityResultListener());
        this.activityBinding.addRequestPermissionsResultListener(this.locationService.getLocationRequestPermissionsResultListener());
        this.activityBinding.addRequestPermissionsResultListener(this.locationService.getServiceRequestPermissionsResultListener());
        this.methodCallHandler.setLocation(this.locationService.getLocation());
        this.methodCallHandler.setLocationService(this.locationService);
        this.streamHandlerImpl.setLocation(this.locationService.getLocation());
    }

    private void dispose() {
        this.streamHandlerImpl.setLocation(null);
        this.methodCallHandler.setLocationService(null);
        this.methodCallHandler.setLocation(null);
        FlutterLocationService flutterLocationService = this.locationService;
        if (flutterLocationService != null) {
            this.activityBinding.removeRequestPermissionsResultListener(flutterLocationService.getServiceRequestPermissionsResultListener());
            this.activityBinding.removeRequestPermissionsResultListener(this.locationService.getLocationRequestPermissionsResultListener());
            this.activityBinding.removeActivityResultListener(this.locationService.getLocationActivityResultListener());
            this.locationService.setActivity(null);
            this.locationService = null;
        }
    }
}
