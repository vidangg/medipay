package com.lyokone.location;

import android.graphics.Color;
import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes4.dex */
final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String METHOD_CHANNEL_NAME = "lyokone/location";
    private static final String TAG = "MethodCallHandlerImpl";
    private MethodChannel channel;
    private FlutterLocation location;
    private FlutterLocationService locationService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocation(FlutterLocation flutterLocation) {
        this.location = flutterLocation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocationService(FlutterLocationService flutterLocationService) {
        this.locationService = flutterLocationService;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -972798202:
                if (str.equals("isBackgroundModeEnabled")) {
                    c = 0;
                    break;
                }
                break;
            case -724480940:
                if (str.equals("enableBackgroundMode")) {
                    c = 1;
                    break;
                }
                break;
            case -316023509:
                if (str.equals("getLocation")) {
                    c = 2;
                    break;
                }
                break;
            case 128007462:
                if (str.equals("requestService")) {
                    c = 3;
                    break;
                }
                break;
            case 171850761:
                if (str.equals("hasPermission")) {
                    c = 4;
                    break;
                }
                break;
            case 473496931:
                if (str.equals("changeNotificationOptions")) {
                    c = 5;
                    break;
                }
                break;
            case 646862540:
                if (str.equals("serviceEnabled")) {
                    c = 6;
                    break;
                }
                break;
            case 746581438:
                if (str.equals("requestPermission")) {
                    c = 7;
                    break;
                }
                break;
            case 1149076467:
                if (str.equals("changeSettings")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                isBackgroundModeEnabled(result);
                return;
            case 1:
                enableBackgroundMode(methodCall, result);
                return;
            case 2:
                onGetLocation(result);
                return;
            case 3:
                this.location.requestService(result);
                return;
            case 4:
                onHasPermission(result);
                return;
            case 5:
                onChangeNotificationOptions(methodCall, result);
                return;
            case 6:
                onServiceEnabled(result);
                return;
            case 7:
                onRequestPermission(result);
                return;
            case '\b':
                onChangeSettings(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListening(BinaryMessenger binaryMessenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, METHOD_CHANNEL_NAME);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListening() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
        } else {
            methodChannel.setMethodCallHandler(null);
            this.channel = null;
        }
    }

    private void onChangeSettings(MethodCall methodCall, MethodChannel.Result result) {
        try {
            Integer num = this.location.mapFlutterAccuracy.get(((Integer) methodCall.argument("accuracy")).intValue());
            Long l = new Long(((Integer) methodCall.argument("interval")).intValue());
            this.location.changeSettings(num, l, Long.valueOf(l.longValue() / 2), new Float(((Double) methodCall.argument("distanceFilter")).doubleValue()));
            result.success(1);
        } catch (Exception e) {
            result.error("CHANGE_SETTINGS_ERROR", "An unexcepted error happened during location settings change:" + e.getMessage(), null);
        }
    }

    private void onGetLocation(MethodChannel.Result result) {
        this.location.getLocationResult = result;
        if (!this.location.checkPermissions()) {
            this.location.requestPermissions();
        } else {
            this.location.startRequestingLocation();
        }
    }

    private void onHasPermission(MethodChannel.Result result) {
        if (this.location.checkPermissions()) {
            result.success(1);
        } else {
            result.success(0);
        }
    }

    private void onServiceEnabled(MethodChannel.Result result) {
        try {
            result.success(Integer.valueOf(this.location.checkServiceEnabled() ? 1 : 0));
        } catch (Exception unused) {
            result.error("SERVICE_STATUS_ERROR", "Location service status couldn't be determined", null);
        }
    }

    private void onRequestPermission(MethodChannel.Result result) {
        this.location.result = result;
        this.location.requestPermissions();
    }

    private void isBackgroundModeEnabled(MethodChannel.Result result) {
        FlutterLocationService flutterLocationService = this.locationService;
        if (flutterLocationService != null) {
            result.success(Integer.valueOf(flutterLocationService.getIsForeground() ? 1 : 0));
        } else {
            result.success(0);
        }
    }

    private void enableBackgroundMode(MethodCall methodCall, MethodChannel.Result result) {
        Boolean bool = (Boolean) methodCall.argument("enable");
        FlutterLocationService flutterLocationService = this.locationService;
        if (flutterLocationService != null && bool != null) {
            if (flutterLocationService.checkBackgroundPermissions()) {
                if (bool.booleanValue()) {
                    this.locationService.enableBackgroundMode();
                    result.success(1);
                    return;
                } else {
                    this.locationService.disableBackgroundMode();
                    result.success(0);
                    return;
                }
            }
            if (bool.booleanValue()) {
                this.locationService.setResult(result);
                this.locationService.requestBackgroundPermissions();
                return;
            } else {
                this.locationService.disableBackgroundMode();
                result.success(0);
                return;
            }
        }
        result.success(0);
    }

    private void onChangeNotificationOptions(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = (String) methodCall.argument("channelName");
            if (str == null) {
                str = FlutterLocationServiceKt.kDefaultChannelName;
            }
            String str2 = str;
            String str3 = (String) methodCall.argument("title");
            if (str3 == null) {
                str3 = FlutterLocationServiceKt.kDefaultNotificationTitle;
            }
            String str4 = str3;
            String str5 = (String) methodCall.argument("iconName");
            if (str5 == null) {
                str5 = FlutterLocationServiceKt.kDefaultNotificationIconName;
            }
            String str6 = str5;
            String str7 = (String) methodCall.argument("subtitle");
            String str8 = (String) methodCall.argument("description");
            Boolean bool = (Boolean) methodCall.argument("onTapBringToFront");
            if (bool == null) {
                bool = false;
            }
            String str9 = (String) methodCall.argument("color");
            result.success(this.locationService.changeNotificationOptions(new NotificationOptions(str2, str4, str6, str7, str8, str9 != null ? Integer.valueOf(Color.parseColor(str9)) : null, bool.booleanValue())));
        } catch (Exception e) {
            result.error("CHANGE_NOTIFICATION_OPTIONS_ERROR", "An unexpected error happened during notification options change:" + e.getMessage(), null);
        }
    }
}
