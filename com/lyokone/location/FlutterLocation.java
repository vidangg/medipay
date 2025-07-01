package com.lyokone.location;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class FlutterLocation implements PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener {
    private static final int GPS_ENABLE_REQUEST = 4097;
    private static final int REQUEST_CHECK_SETTINGS = 1;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    private static final String TAG = "FlutterLocation";
    public Activity activity;
    public EventChannel.EventSink events;
    public MethodChannel.Result getLocationResult;
    private final LocationManager locationManager;
    public FusedLocationProviderClient mFusedLocationClient;
    private Double mLastMslAltitude;
    public LocationCallback mLocationCallback;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest mLocationSettingsRequest;
    private OnNmeaMessageListener mMessageListener;
    private SettingsClient mSettingsClient;
    private MethodChannel.Result requestServiceResult;
    public MethodChannel.Result result;
    private long updateIntervalMilliseconds = 5000;
    private long fastestUpdateIntervalMilliseconds = 5000 / 2;
    private Integer locationAccuracy = 100;
    private float distanceFilter = 0.0f;
    public SparseArray<Integer> mapFlutterAccuracy = new SparseArray<Integer>() { // from class: com.lyokone.location.FlutterLocation.1
        {
            put(0, 105);
            put(1, 104);
            put(2, 102);
            put(3, 100);
            put(4, 100);
            put(5, 104);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlutterLocation(Context context, Activity activity) {
        this.activity = activity;
        this.locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActivity(Activity activity) {
        this.activity = activity;
        if (activity != null) {
            this.mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);
            this.mSettingsClient = LocationServices.getSettingsClient(activity);
            createLocationCallback();
            createLocationRequest();
            buildLocationSettingsRequest();
            return;
        }
        FusedLocationProviderClient fusedLocationProviderClient = this.mFusedLocationClient;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(this.mLocationCallback);
        }
        this.mFusedLocationClient = null;
        this.mSettingsClient = null;
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            locationManager.removeNmeaListener(this.mMessageListener);
            this.mMessageListener = null;
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        return onRequestPermissionsResultHandler(i, strArr, iArr);
    }

    public boolean onRequestPermissionsResultHandler(int i, String[] strArr, int[] iArr) {
        if (i != 34 || strArr.length != 1 || !strArr[0].equals("android.permission.ACCESS_FINE_LOCATION")) {
            return false;
        }
        if (iArr[0] == 0) {
            if (this.getLocationResult != null || this.events != null) {
                startRequestingLocation();
            }
            MethodChannel.Result result = this.result;
            if (result != null) {
                result.success(1);
                this.result = null;
            }
        } else if (!shouldShowRequestPermissionRationale()) {
            sendError("PERMISSION_DENIED_NEVER_ASK", "Location permission denied forever - please open app settings", null);
            MethodChannel.Result result2 = this.result;
            if (result2 != null) {
                result2.success(2);
                this.result = null;
            }
        } else {
            sendError("PERMISSION_DENIED", "Location permission denied", null);
            MethodChannel.Result result3 = this.result;
            if (result3 != null) {
                result3.success(0);
                this.result = null;
            }
        }
        return true;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i, int i2, Intent intent) {
        MethodChannel.Result result;
        if (i != 1) {
            if (i != 4097 || (result = this.requestServiceResult) == null) {
                return false;
            }
            if (i2 == -1) {
                result.success(1);
            } else {
                result.success(0);
            }
            this.requestServiceResult = null;
            return true;
        }
        MethodChannel.Result result2 = this.result;
        if (result2 == null) {
            return false;
        }
        if (i2 == -1) {
            startRequestingLocation();
            return true;
        }
        result2.error("SERVICE_STATUS_DISABLED", "Failed to get location. Location services disabled", null);
        this.result = null;
        return true;
    }

    public void changeSettings(Integer num, Long l, Long l2, Float f) {
        this.locationAccuracy = num;
        this.updateIntervalMilliseconds = l.longValue();
        this.fastestUpdateIntervalMilliseconds = l2.longValue();
        this.distanceFilter = f.floatValue();
        createLocationCallback();
        createLocationRequest();
        buildLocationSettingsRequest();
        startRequestingLocation();
    }

    private void sendError(String str, String str2, Object obj) {
        MethodChannel.Result result = this.getLocationResult;
        if (result != null) {
            result.error(str, str2, obj);
            this.getLocationResult = null;
        }
        EventChannel.EventSink eventSink = this.events;
        if (eventSink != null) {
            eventSink.error(str, str2, obj);
            this.events = null;
        }
    }

    private void createLocationCallback() {
        LocationCallback locationCallback = this.mLocationCallback;
        if (locationCallback != null) {
            this.mFusedLocationClient.removeLocationUpdates(locationCallback);
            this.mLocationCallback = null;
        }
        this.mLocationCallback = new LocationCallback() { // from class: com.lyokone.location.FlutterLocation.2
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                double elapsedRealtimeUncertaintyNanos;
                super.onLocationResult(locationResult);
                Location lastLocation = locationResult.getLastLocation();
                HashMap hashMap = new HashMap();
                hashMap.put("latitude", Double.valueOf(lastLocation.getLatitude()));
                hashMap.put("longitude", Double.valueOf(lastLocation.getLongitude()));
                hashMap.put("accuracy", Double.valueOf(lastLocation.getAccuracy()));
                hashMap.put("verticalAccuracy", Double.valueOf(lastLocation.getVerticalAccuracyMeters()));
                hashMap.put("headingAccuracy", Double.valueOf(lastLocation.getBearingAccuracyDegrees()));
                if (Build.VERSION.SDK_INT >= 29) {
                    elapsedRealtimeUncertaintyNanos = lastLocation.getElapsedRealtimeUncertaintyNanos();
                    hashMap.put("elapsedRealtimeUncertaintyNanos", Double.valueOf(elapsedRealtimeUncertaintyNanos));
                }
                hashMap.put("provider", lastLocation.getProvider());
                if (lastLocation.getExtras() != null) {
                    hashMap.put("satelliteNumber", Integer.valueOf(lastLocation.getExtras().getInt("satellites")));
                }
                hashMap.put("elapsedRealtimeNanos", Double.valueOf(lastLocation.getElapsedRealtimeNanos()));
                if (lastLocation.isFromMockProvider()) {
                    hashMap.put("isMock", Double.valueOf(1.0d));
                }
                if (FlutterLocation.this.mLastMslAltitude != null) {
                    hashMap.put("altitude", FlutterLocation.this.mLastMslAltitude);
                } else {
                    hashMap.put("altitude", Double.valueOf(lastLocation.getAltitude()));
                }
                hashMap.put("speed", Double.valueOf(lastLocation.getSpeed()));
                hashMap.put("speed_accuracy", Double.valueOf(lastLocation.getSpeedAccuracyMetersPerSecond()));
                hashMap.put("heading", Double.valueOf(lastLocation.getBearing()));
                hashMap.put("time", Double.valueOf(lastLocation.getTime()));
                if (FlutterLocation.this.getLocationResult != null) {
                    FlutterLocation.this.getLocationResult.success(hashMap);
                    FlutterLocation.this.getLocationResult = null;
                }
                if (FlutterLocation.this.events != null) {
                    FlutterLocation.this.events.success(hashMap);
                } else if (FlutterLocation.this.mFusedLocationClient != null) {
                    FlutterLocation.this.mFusedLocationClient.removeLocationUpdates(FlutterLocation.this.mLocationCallback);
                }
            }
        };
        this.mMessageListener = new OnNmeaMessageListener() { // from class: com.lyokone.location.FlutterLocation$$ExternalSyntheticLambda2
            @Override // android.location.OnNmeaMessageListener
            public final void onNmeaMessage(String str, long j) {
                FlutterLocation.this.m718x7edf22ba(str, j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createLocationCallback$0$com-lyokone-location-FlutterLocation, reason: not valid java name */
    public /* synthetic */ void m718x7edf22ba(String str, long j) {
        if (str.startsWith("$")) {
            String[] split = str.split(",");
            if (!split[0].startsWith("$GPGGA") || split.length <= 9 || split[9].isEmpty()) {
                return;
            }
            this.mLastMslAltitude = Double.valueOf(Double.parseDouble(split[9]));
        }
    }

    private void createLocationRequest() {
        LocationRequest create = LocationRequest.create();
        this.mLocationRequest = create;
        create.setInterval(this.updateIntervalMilliseconds);
        this.mLocationRequest.setFastestInterval(this.fastestUpdateIntervalMilliseconds);
        this.mLocationRequest.setPriority(this.locationAccuracy.intValue());
        this.mLocationRequest.setSmallestDisplacement(this.distanceFilter);
    }

    private void buildLocationSettingsRequest() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(this.mLocationRequest);
        this.mLocationSettingsRequest = builder.build();
    }

    public boolean checkPermissions() {
        Activity activity = this.activity;
        if (activity != null) {
            return ActivityCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") == 0;
        }
        this.result.error("MISSING_ACTIVITY", "You should not checkPermissions activation outside of an activity.", null);
        throw new ActivityNotFoundException();
    }

    public void requestPermissions() {
        if (this.activity == null) {
            this.result.error("MISSING_ACTIVITY", "You should not requestPermissions activation outside of an activity.", null);
            throw new ActivityNotFoundException();
        }
        if (checkPermissions()) {
            this.result.success(1);
        } else {
            ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 34);
        }
    }

    public boolean shouldShowRequestPermissionRationale() {
        Activity activity = this.activity;
        if (activity == null) {
            return false;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION");
    }

    public boolean checkServiceEnabled() {
        return this.locationManager.isLocationEnabled();
    }

    public void requestService(final MethodChannel.Result result) {
        if (this.activity == null) {
            result.error("MISSING_ACTIVITY", "You should not requestService activation outside of an activity.", null);
            throw new ActivityNotFoundException();
        }
        try {
            if (checkServiceEnabled()) {
                result.success(1);
            } else {
                this.requestServiceResult = result;
                this.mSettingsClient.checkLocationSettings(this.mLocationSettingsRequest).addOnFailureListener(this.activity, new OnFailureListener() { // from class: com.lyokone.location.FlutterLocation$$ExternalSyntheticLambda3
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        FlutterLocation.this.m719lambda$requestService$1$comlyokonelocationFlutterLocation(result, exc);
                    }
                });
            }
        } catch (Exception unused) {
            result.error("SERVICE_STATUS_ERROR", "Location service status couldn't be determined", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$requestService$1$com-lyokone-location-FlutterLocation, reason: not valid java name */
    public /* synthetic */ void m719lambda$requestService$1$comlyokonelocationFlutterLocation(MethodChannel.Result result, Exception exc) {
        if (exc instanceof ResolvableApiException) {
            ResolvableApiException resolvableApiException = (ResolvableApiException) exc;
            int statusCode = resolvableApiException.getStatusCode();
            if (statusCode != 6) {
                if (statusCode != 8502) {
                    return;
                }
                result.error("SERVICE_STATUS_DISABLED", "Failed to get location. Location services disabled", null);
                return;
            } else {
                try {
                    resolvableApiException.startResolutionForResult(this.activity, 4097);
                    return;
                } catch (IntentSender.SendIntentException unused) {
                    result.error("SERVICE_STATUS_ERROR", "Could not resolve location request", null);
                    return;
                }
            }
        }
        result.error("SERVICE_STATUS_ERROR", "Unexpected error type received", null);
    }

    public void startRequestingLocation() {
        if (this.activity == null) {
            this.result.error("MISSING_ACTIVITY", "You should not requestLocation activation outside of an activity.", null);
            throw new ActivityNotFoundException();
        }
        this.mSettingsClient.checkLocationSettings(this.mLocationSettingsRequest).addOnSuccessListener(this.activity, new OnSuccessListener() { // from class: com.lyokone.location.FlutterLocation$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FlutterLocation.this.m720xf9786a7e((LocationSettingsResponse) obj);
            }
        }).addOnFailureListener(this.activity, new OnFailureListener() { // from class: com.lyokone.location.FlutterLocation$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FlutterLocation.this.m721x5acb071d(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startRequestingLocation$2$com-lyokone-location-FlutterLocation, reason: not valid java name */
    public /* synthetic */ void m720xf9786a7e(LocationSettingsResponse locationSettingsResponse) {
        this.locationManager.addNmeaListener(this.mMessageListener, (Handler) null);
        FusedLocationProviderClient fusedLocationProviderClient = this.mFusedLocationClient;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.requestLocationUpdates(this.mLocationRequest, this.mLocationCallback, Looper.myLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startRequestingLocation$3$com-lyokone-location-FlutterLocation, reason: not valid java name */
    public /* synthetic */ void m721x5acb071d(Exception exc) {
        if (exc instanceof ResolvableApiException) {
            ResolvableApiException resolvableApiException = (ResolvableApiException) exc;
            if (resolvableApiException.getStatusCode() == 6) {
                try {
                    resolvableApiException.startResolutionForResult(this.activity, 1);
                    return;
                } catch (IntentSender.SendIntentException unused) {
                    Log.i(TAG, "PendingIntent unable to execute request.");
                    return;
                }
            }
            return;
        }
        if (((ApiException) exc).getStatusCode() == 8502) {
            this.locationManager.addNmeaListener(this.mMessageListener, (Handler) null);
            this.mFusedLocationClient.requestLocationUpdates(this.mLocationRequest, this.mLocationCallback, Looper.myLooper());
        } else {
            sendError("UNEXPECTED_ERROR", exc.getMessage(), null);
        }
    }
}
