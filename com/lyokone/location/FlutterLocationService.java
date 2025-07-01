package com.lyokone.location;

import android.app.Activity;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlutterLocationService.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002=>B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020\u000bJ\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020(H\u0016J\b\u00100\u001a\u00020(H\u0016J-\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u0002032\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"052\u0006\u00106\u001a\u000207H\u0016¢\u0006\u0002\u00108J\u0012\u00109\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010:\u001a\u00020(J\u0010\u0010;\u001a\u00020(2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010<\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017¨\u0006?"}, d2 = {"Lcom/lyokone/location/FlutterLocationService;", "Landroid/app/Service;", "Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;", "()V", "activity", "Landroid/app/Activity;", "backgroundNotification", "Lcom/lyokone/location/BackgroundNotification;", "binder", "Lcom/lyokone/location/FlutterLocationService$LocalBinder;", "isForeground", "", "<set-?>", "Lcom/lyokone/location/FlutterLocation;", FirebaseAnalytics.Param.LOCATION, "getLocation", "()Lcom/lyokone/location/FlutterLocation;", "locationActivityResultListener", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "getLocationActivityResultListener", "()Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "locationRequestPermissionsResultListener", "getLocationRequestPermissionsResultListener", "()Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;", Constant.PARAM_RESULT, "Lio/flutter/plugin/common/MethodChannel$Result;", "getResult", "()Lio/flutter/plugin/common/MethodChannel$Result;", "setResult", "(Lio/flutter/plugin/common/MethodChannel$Result;)V", "serviceRequestPermissionsResultListener", "getServiceRequestPermissionsResultListener", "changeNotificationOptions", "", "", "", Constant.METHOD_OPTIONS, "Lcom/lyokone/location/NotificationOptions;", "checkBackgroundPermissions", "disableBackgroundMode", "", "enableBackgroundMode", "isInForegroundMode", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "onUnbind", "requestBackgroundPermissions", "setActivity", "shouldShowRequestBackgroundPermissionRationale", "Companion", "LocalBinder", "location_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FlutterLocationService extends Service implements PluginRegistry.RequestPermissionsResultListener {
    private static final String CHANNEL_ID = "flutter_location_channel_01";
    private static final int ONGOING_NOTIFICATION_ID = 75418;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 641;
    private static final String TAG = "FlutterLocationService";
    private Activity activity;
    private BackgroundNotification backgroundNotification;
    private final LocalBinder binder = new LocalBinder();
    private boolean isForeground;
    private FlutterLocation location;
    private MethodChannel.Result result;

    public final FlutterLocation getLocation() {
        return this.location;
    }

    public final MethodChannel.Result getResult() {
        return this.result;
    }

    public final void setResult(MethodChannel.Result result) {
        this.result = result;
    }

    public final PluginRegistry.ActivityResultListener getLocationActivityResultListener() {
        return this.location;
    }

    public final PluginRegistry.RequestPermissionsResultListener getLocationRequestPermissionsResultListener() {
        return this.location;
    }

    public final PluginRegistry.RequestPermissionsResultListener getServiceRequestPermissionsResultListener() {
        return this;
    }

    /* compiled from: FlutterLocationService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/lyokone/location/FlutterLocationService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/lyokone/location/FlutterLocationService;)V", "getService", "Lcom/lyokone/location/FlutterLocationService;", "location_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final class LocalBinder extends Binder {
        public LocalBinder() {
        }

        /* renamed from: getService, reason: from getter */
        public final FlutterLocationService getThis$0() {
            return FlutterLocationService.this;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Creating service.");
        this.location = new FlutterLocation(getApplicationContext(), null);
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.backgroundNotification = new BackgroundNotification(applicationContext, CHANNEL_ID, ONGOING_NOTIFICATION_ID);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Binding to location service.");
        return this.binder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "Unbinding from location service.");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(TAG, "Destroying service.");
        this.location = null;
        this.backgroundNotification = null;
        super.onDestroy();
    }

    public final boolean checkBackgroundPermissions() {
        if (Build.VERSION.SDK_INT >= 29) {
            Activity activity = this.activity;
            if (activity != null) {
                return ActivityCompat.checkSelfPermission(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
            }
            throw new ActivityNotFoundException();
        }
        FlutterLocation flutterLocation = this.location;
        if (flutterLocation != null) {
            return flutterLocation.checkPermissions();
        }
        return false;
    }

    public final void requestBackgroundPermissions() {
        Unit unit = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Activity activity = this.activity;
            if (activity != null) {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"}, REQUEST_PERMISSIONS_REQUEST_CODE);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                throw new ActivityNotFoundException();
            }
            return;
        }
        FlutterLocation flutterLocation = this.location;
        if (flutterLocation != null) {
            flutterLocation.result = this.result;
        }
        FlutterLocation flutterLocation2 = this.location;
        if (flutterLocation2 != null) {
            flutterLocation2.requestPermissions();
        }
        this.result = null;
    }

    /* renamed from: isInForegroundMode, reason: from getter */
    public final boolean getIsForeground() {
        return this.isForeground;
    }

    public final void enableBackgroundMode() {
        if (this.isForeground) {
            Log.d(TAG, "Service already in foreground mode.");
            return;
        }
        Log.d(TAG, "Start service in foreground mode.");
        BackgroundNotification backgroundNotification = this.backgroundNotification;
        Intrinsics.checkNotNull(backgroundNotification);
        startForeground(ONGOING_NOTIFICATION_ID, backgroundNotification.build());
        this.isForeground = true;
    }

    public final void disableBackgroundMode() {
        Log.d(TAG, "Stop service in foreground.");
        stopForeground(1);
        this.isForeground = false;
    }

    public final Map<String, Object> changeNotificationOptions(NotificationOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        BackgroundNotification backgroundNotification = this.backgroundNotification;
        if (backgroundNotification != null) {
            backgroundNotification.updateOptions(options, this.isForeground);
        }
        if (this.isForeground) {
            return MapsKt.mapOf(TuplesKt.to("channelId", CHANNEL_ID), TuplesKt.to("notificationId", Integer.valueOf(ONGOING_NOTIFICATION_ID)));
        }
        return null;
    }

    public final void setActivity(Activity activity) {
        this.activity = activity;
        FlutterLocation flutterLocation = this.location;
        if (flutterLocation != null) {
            flutterLocation.setActivity(activity);
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (Build.VERSION.SDK_INT >= 29 && requestCode == REQUEST_PERMISSIONS_REQUEST_CODE && permissions.length == 2 && Intrinsics.areEqual(permissions[0], "android.permission.ACCESS_FINE_LOCATION") && Intrinsics.areEqual(permissions[1], "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            if (grantResults[0] == 0 && grantResults[1] == 0) {
                enableBackgroundMode();
                MethodChannel.Result result = this.result;
                if (result != null) {
                    result.success(1);
                }
                this.result = null;
            } else {
                if (!shouldShowRequestBackgroundPermissionRationale()) {
                    MethodChannel.Result result2 = this.result;
                    if (result2 != null) {
                        result2.error("PERMISSION_DENIED_NEVER_ASK", "Background location permission denied forever - please open app settings", null);
                    }
                } else {
                    MethodChannel.Result result3 = this.result;
                    if (result3 != null) {
                        result3.error("PERMISSION_DENIED", "Background location permission denied", null);
                    }
                }
                this.result = null;
            }
        }
        return false;
    }

    private final boolean shouldShowRequestBackgroundPermissionRationale() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        Activity activity = this.activity;
        if (activity != null) {
            return ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        throw new ActivityNotFoundException();
    }
}
