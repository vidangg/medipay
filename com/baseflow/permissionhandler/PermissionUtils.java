package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class PermissionUtils {
    static final String SHARED_PREFERENCES_PERMISSION_WAS_DENIED_BEFORE_KEY = "sp_permission_handler_permission_was_denied_before";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int parseManifestName(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2062386608:
                if (str.equals("android.permission.READ_SMS")) {
                    c = 0;
                    break;
                }
                break;
            case -1928411001:
                if (str.equals("android.permission.READ_CALENDAR")) {
                    c = 1;
                    break;
                }
                break;
            case -1925850455:
                if (str.equals("android.permission.POST_NOTIFICATIONS")) {
                    c = 2;
                    break;
                }
                break;
            case -1921431796:
                if (str.equals("android.permission.READ_CALL_LOG")) {
                    c = 3;
                    break;
                }
                break;
            case -1888586689:
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    c = 4;
                    break;
                }
                break;
            case -1813079487:
                if (str.equals("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    c = 5;
                    break;
                }
                break;
            case -1783097621:
                if (str.equals("android.permission.ACCESS_NOTIFICATION_POLICY")) {
                    c = 6;
                    break;
                }
                break;
            case -1561629405:
                if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                    c = 7;
                    break;
                }
                break;
            case -1479758289:
                if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                    c = '\b';
                    break;
                }
                break;
            case -1238066820:
                if (str.equals("android.permission.BODY_SENSORS")) {
                    c = '\t';
                    break;
                }
                break;
            case -1164582768:
                if (str.equals("android.permission.READ_PHONE_NUMBERS")) {
                    c = '\n';
                    break;
                }
                break;
            case -909527021:
                if (str.equals("android.permission.NEARBY_WIFI_DEVICES")) {
                    c = 11;
                    break;
                }
                break;
            case -895679497:
                if (str.equals("android.permission.RECEIVE_MMS")) {
                    c = '\f';
                    break;
                }
                break;
            case -895673731:
                if (str.equals("android.permission.RECEIVE_SMS")) {
                    c = '\r';
                    break;
                }
                break;
            case -798669607:
                if (str.equals("android.permission.BLUETOOTH_CONNECT")) {
                    c = 14;
                    break;
                }
                break;
            case -406040016:
                if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    c = 15;
                    break;
                }
                break;
            case -63024214:
                if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    c = 16;
                    break;
                }
                break;
            case -5573545:
                if (str.equals("android.permission.READ_PHONE_STATE")) {
                    c = 17;
                    break;
                }
                break;
            case 52602690:
                if (str.equals("android.permission.SEND_SMS")) {
                    c = 18;
                    break;
                }
                break;
            case 112197485:
                if (str.equals("android.permission.CALL_PHONE")) {
                    c = 19;
                    break;
                }
                break;
            case 175802396:
                if (str.equals("android.permission.READ_MEDIA_IMAGES")) {
                    c = 20;
                    break;
                }
                break;
            case 214526995:
                if (str.equals("android.permission.WRITE_CONTACTS")) {
                    c = 21;
                    break;
                }
                break;
            case 361658321:
                if (str.equals("android.permission.BODY_SENSORS_BACKGROUND")) {
                    c = 22;
                    break;
                }
                break;
            case 463403621:
                if (str.equals("android.permission.CAMERA")) {
                    c = 23;
                    break;
                }
                break;
            case 603653886:
                if (str.equals("android.permission.WRITE_CALENDAR")) {
                    c = 24;
                    break;
                }
                break;
            case 610633091:
                if (str.equals("android.permission.WRITE_CALL_LOG")) {
                    c = 25;
                    break;
                }
                break;
            case 691260818:
                if (str.equals("android.permission.READ_MEDIA_AUDIO")) {
                    c = 26;
                    break;
                }
                break;
            case 710297143:
                if (str.equals("android.permission.READ_MEDIA_VIDEO")) {
                    c = 27;
                    break;
                }
                break;
            case 784519842:
                if (str.equals("android.permission.USE_SIP")) {
                    c = 28;
                    break;
                }
                break;
            case 970694249:
                if (str.equals("android.permission.SCHEDULE_EXACT_ALARM")) {
                    c = 29;
                    break;
                }
                break;
            case 1166454870:
                if (str.equals("android.permission.BLUETOOTH_ADVERTISE")) {
                    c = 30;
                    break;
                }
                break;
            case 1271781903:
                if (str.equals("android.permission.GET_ACCOUNTS")) {
                    c = 31;
                    break;
                }
                break;
            case 1365911975:
                if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    c = ' ';
                    break;
                }
                break;
            case 1777263169:
                if (str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                    c = '!';
                    break;
                }
                break;
            case 1780337063:
                if (str.equals("android.permission.ACTIVITY_RECOGNITION")) {
                    c = Typography.quote;
                    break;
                }
                break;
            case 1831139720:
                if (str.equals("android.permission.RECORD_AUDIO")) {
                    c = '#';
                    break;
                }
                break;
            case 1977429404:
                if (str.equals("android.permission.READ_CONTACTS")) {
                    c = Typography.dollar;
                    break;
                }
                break;
            case 2024715147:
                if (str.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    c = '%';
                    break;
                }
                break;
            case 2062356686:
                if (str.equals("android.permission.BLUETOOTH_SCAN")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 2114579147:
                if (str.equals("android.permission.ACCESS_MEDIA_LOCATION")) {
                    c = '\'';
                    break;
                }
                break;
            case 2133799037:
                if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    c = '(';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case '\b':
            case '\f':
            case '\r':
            case 18:
                return 13;
            case 1:
            case 24:
                return 0;
            case 2:
                return 17;
            case 3:
            case '\n':
            case 17:
            case 19:
            case 25:
            case 28:
            case '(':
                return 8;
            case 4:
            case 16:
                return 3;
            case 5:
                return 22;
            case 6:
                return 27;
            case 7:
                return 23;
            case '\t':
                return 12;
            case 11:
                return 31;
            case 14:
                return 30;
            case 15:
            case ' ':
                return 15;
            case 20:
                return 9;
            case 21:
            case 31:
            case '$':
                return 2;
            case 22:
                return 35;
            case 23:
                return 1;
            case 26:
                return 33;
            case 27:
                return 32;
            case 29:
                return 34;
            case 30:
                return 29;
            case '!':
                return 24;
            case '\"':
                return 19;
            case '#':
                return 7;
            case '%':
                return 4;
            case '&':
                return 28;
            case '\'':
                return 18;
            default:
                return 20;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0154, code lost:
    
        if (r7 != false) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> getManifestNames(Context context, int i) {
        boolean isExternalStorageLegacy;
        String determineBluetoothPermission;
        String determineBluetoothPermission2;
        String determineBluetoothPermission3;
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
            case 37:
                if (hasPermissionInManifest(context, arrayList, "android.permission.WRITE_CALENDAR")) {
                    arrayList.add("android.permission.WRITE_CALENDAR");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.READ_CALENDAR")) {
                    arrayList.add("android.permission.READ_CALENDAR");
                }
                return arrayList;
            case 1:
                if (hasPermissionInManifest(context, arrayList, "android.permission.CAMERA")) {
                    arrayList.add("android.permission.CAMERA");
                }
                return arrayList;
            case 2:
                if (hasPermissionInManifest(context, arrayList, "android.permission.READ_CONTACTS")) {
                    arrayList.add("android.permission.READ_CONTACTS");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.WRITE_CONTACTS")) {
                    arrayList.add("android.permission.WRITE_CONTACTS");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.GET_ACCOUNTS")) {
                    arrayList.add("android.permission.GET_ACCOUNTS");
                }
                return arrayList;
            case 3:
            case 4:
            case 5:
                if (i == 4 && Build.VERSION.SDK_INT >= 29) {
                    if (hasPermissionInManifest(context, arrayList, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    }
                } else {
                    if (hasPermissionInManifest(context, arrayList, "android.permission.ACCESS_COARSE_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (hasPermissionInManifest(context, arrayList, "android.permission.ACCESS_FINE_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    }
                }
                return arrayList;
            case 6:
            case 11:
            case 20:
                return null;
            case 7:
            case 14:
                if (hasPermissionInManifest(context, arrayList, "android.permission.RECORD_AUDIO")) {
                    arrayList.add("android.permission.RECORD_AUDIO");
                }
                return arrayList;
            case 8:
                if (hasPermissionInManifest(context, arrayList, "android.permission.READ_PHONE_STATE")) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (Build.VERSION.SDK_INT > 29 && hasPermissionInManifest(context, arrayList, "android.permission.READ_PHONE_NUMBERS")) {
                    arrayList.add("android.permission.READ_PHONE_NUMBERS");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.CALL_PHONE")) {
                    arrayList.add("android.permission.CALL_PHONE");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.READ_CALL_LOG")) {
                    arrayList.add("android.permission.READ_CALL_LOG");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.WRITE_CALL_LOG")) {
                    arrayList.add("android.permission.WRITE_CALL_LOG");
                }
                if (hasPermissionInManifest(context, arrayList, "com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    arrayList.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.USE_SIP")) {
                    arrayList.add("android.permission.USE_SIP");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.ANSWER_PHONE_CALLS")) {
                    arrayList.add("android.permission.ANSWER_PHONE_CALLS");
                }
                return arrayList;
            case 9:
                if (Build.VERSION.SDK_INT >= 33 && hasPermissionInManifest(context, arrayList, "android.permission.READ_MEDIA_IMAGES")) {
                    arrayList.add("android.permission.READ_MEDIA_IMAGES");
                }
                return arrayList;
            case 10:
            case 25:
            case 26:
            default:
                return arrayList;
            case 12:
                if (hasPermissionInManifest(context, arrayList, "android.permission.BODY_SENSORS")) {
                    arrayList.add("android.permission.BODY_SENSORS");
                }
                return arrayList;
            case 13:
                if (hasPermissionInManifest(context, arrayList, "android.permission.SEND_SMS")) {
                    arrayList.add("android.permission.SEND_SMS");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.RECEIVE_SMS")) {
                    arrayList.add("android.permission.RECEIVE_SMS");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.READ_SMS")) {
                    arrayList.add("android.permission.READ_SMS");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.RECEIVE_WAP_PUSH")) {
                    arrayList.add("android.permission.RECEIVE_WAP_PUSH");
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.RECEIVE_MMS")) {
                    arrayList.add("android.permission.RECEIVE_MMS");
                }
                return arrayList;
            case 15:
                if (hasPermissionInManifest(context, arrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    if (Build.VERSION.SDK_INT == 29) {
                        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
                        break;
                    }
                    return arrayList;
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                return arrayList;
            case 16:
                if (hasPermissionInManifest(context, arrayList, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
                    arrayList.add("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                }
                return arrayList;
            case 17:
                if (Build.VERSION.SDK_INT >= 33 && hasPermissionInManifest(context, arrayList, "android.permission.POST_NOTIFICATIONS")) {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                }
                return arrayList;
            case 18:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    arrayList.add("android.permission.ACCESS_MEDIA_LOCATION");
                }
                return arrayList;
            case 19:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (hasPermissionInManifest(context, arrayList, "android.permission.ACTIVITY_RECOGNITION")) {
                    arrayList.add("android.permission.ACTIVITY_RECOGNITION");
                }
                return arrayList;
            case 21:
                if (hasPermissionInManifest(context, arrayList, "android.permission.BLUETOOTH")) {
                    arrayList.add("android.permission.BLUETOOTH");
                }
                return arrayList;
            case 22:
                if (Build.VERSION.SDK_INT >= 30 && hasPermissionInManifest(context, arrayList, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                }
                return arrayList;
            case 23:
                if (hasPermissionInManifest(context, arrayList, "android.permission.SYSTEM_ALERT_WINDOW")) {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                }
                return arrayList;
            case 24:
                if (hasPermissionInManifest(context, arrayList, "android.permission.REQUEST_INSTALL_PACKAGES")) {
                    arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
                }
                return arrayList;
            case 27:
                if (hasPermissionInManifest(context, arrayList, "android.permission.ACCESS_NOTIFICATION_POLICY")) {
                    arrayList.add("android.permission.ACCESS_NOTIFICATION_POLICY");
                }
                return arrayList;
            case 28:
                if (Build.VERSION.SDK_INT >= 31 && (determineBluetoothPermission = determineBluetoothPermission(context, "android.permission.BLUETOOTH_SCAN")) != null) {
                    arrayList.add(determineBluetoothPermission);
                }
                return arrayList;
            case 29:
                if (Build.VERSION.SDK_INT >= 31 && (determineBluetoothPermission2 = determineBluetoothPermission(context, "android.permission.BLUETOOTH_ADVERTISE")) != null) {
                    arrayList.add(determineBluetoothPermission2);
                }
                return arrayList;
            case 30:
                if (Build.VERSION.SDK_INT >= 31 && (determineBluetoothPermission3 = determineBluetoothPermission(context, "android.permission.BLUETOOTH_CONNECT")) != null) {
                    arrayList.add(determineBluetoothPermission3);
                }
                return arrayList;
            case 31:
                if (Build.VERSION.SDK_INT >= 33 && hasPermissionInManifest(context, arrayList, "android.permission.NEARBY_WIFI_DEVICES")) {
                    arrayList.add("android.permission.NEARBY_WIFI_DEVICES");
                }
                return arrayList;
            case 32:
                if (Build.VERSION.SDK_INT >= 33 && hasPermissionInManifest(context, arrayList, "android.permission.READ_MEDIA_VIDEO")) {
                    arrayList.add("android.permission.READ_MEDIA_VIDEO");
                }
                return arrayList;
            case 33:
                if (Build.VERSION.SDK_INT >= 33 && hasPermissionInManifest(context, arrayList, "android.permission.READ_MEDIA_AUDIO")) {
                    arrayList.add("android.permission.READ_MEDIA_AUDIO");
                }
                return arrayList;
            case 34:
                if (hasPermissionInManifest(context, arrayList, "android.permission.SCHEDULE_EXACT_ALARM")) {
                    arrayList.add("android.permission.SCHEDULE_EXACT_ALARM");
                }
                return arrayList;
            case 35:
                if (Build.VERSION.SDK_INT >= 33 && hasPermissionInManifest(context, arrayList, "android.permission.BODY_SENSORS_BACKGROUND")) {
                    arrayList.add("android.permission.BODY_SENSORS_BACKGROUND");
                }
                return arrayList;
            case 36:
                if (hasPermissionInManifest(context, arrayList, "android.permission.WRITE_CALENDAR")) {
                    arrayList.add("android.permission.WRITE_CALENDAR");
                }
                return arrayList;
        }
    }

    private static boolean hasPermissionInManifest(Context context, ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                Log.d("permissions_handler", "Unable to check manifest for permission: ", e);
            }
        }
        if (context == null) {
            Log.d("permissions_handler", "Unable to detect current Activity or App Context.");
            return false;
        }
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo == null) {
            Log.d("permissions_handler", "Unable to get Package info, will not be able to determine permissions to request.");
            return false;
        }
        Iterator it2 = new ArrayList(Arrays.asList(packageInfo.requestedPermissions)).iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toPermissionStatus(Activity activity, String str, int i) {
        if (i == -1) {
            return determineDeniedVariant(activity, str);
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Integer strictestStatus(Collection<Integer> collection) {
        if (collection.contains(4)) {
            return 4;
        }
        if (collection.contains(2)) {
            return 2;
        }
        if (collection.contains(0)) {
            return 0;
        }
        if (collection.contains(3)) {
            return 3;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Integer strictestStatus(Integer num, Integer num2) {
        HashSet hashSet = new HashSet();
        hashSet.add(num);
        hashSet.add(num2);
        return strictestStatus(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int determineDeniedVariant(Activity activity, String str) {
        if (activity == null) {
            return 0;
        }
        boolean wasPermissionDeniedBefore = wasPermissionDeniedBefore(activity, str);
        boolean z = true;
        boolean z2 = !isNeverAskAgainSelected(activity, str);
        if (!wasPermissionDeniedBefore) {
            z = z2;
        } else if (z2) {
            z = false;
        }
        if (!wasPermissionDeniedBefore && z) {
            setPermissionDenied(activity, str);
        }
        return (wasPermissionDeniedBefore && z) ? 4 : 0;
    }

    static boolean isNeverAskAgainSelected(Activity activity, String str) {
        return !ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }

    private static String determineBluetoothPermission(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 31 && hasPermissionInManifest(context, null, str)) {
            return str;
        }
        if (Build.VERSION.SDK_INT < 29) {
            if (hasPermissionInManifest(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
                return "android.permission.ACCESS_FINE_LOCATION";
            }
            if (hasPermissionInManifest(context, null, "android.permission.ACCESS_COARSE_LOCATION")) {
                return "android.permission.ACCESS_COARSE_LOCATION";
            }
            return null;
        }
        if (hasPermissionInManifest(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
            return "android.permission.ACCESS_FINE_LOCATION";
        }
        return null;
    }

    private static PackageInfo getPackageInfo(Context context) throws PackageManager.NameNotFoundException {
        PackageManager.PackageInfoFlags of;
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            String packageName = context.getPackageName();
            of = PackageManager.PackageInfoFlags.of(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            packageInfo = packageManager.getPackageInfo(packageName, of);
            return packageInfo;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 4096);
    }

    private static boolean wasPermissionDeniedBefore(Context context, String str) {
        return context.getSharedPreferences(str, 0).getBoolean(SHARED_PREFERENCES_PERMISSION_WAS_DENIED_BEFORE_KEY, false);
    }

    private static void setPermissionDenied(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().putBoolean(SHARED_PREFERENCES_PERMISSION_WAS_DENIED_BEFORE_KEY, true).apply();
    }
}
