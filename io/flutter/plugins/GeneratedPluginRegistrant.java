package io.flutter.plugins;

import com.amolg.flutterbarcodescanner.FlutterBarcodeScannerPlugin;
import com.baseflow.permissionhandler.PermissionHandlerPlugin;
import com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin;
import com.example.image_gallery_saver_plus.ImageGallerySaverPlusPlugin;
import com.google_mlkit_commons.GoogleMlKitCommonsPlugin;
import com.google_mlkit_face_detection.GoogleMlKitFaceDetectionPlugin;
import com.google_mlkit_text_recognition.GoogleMlKitTextRecognitionPlugin;
import com.llfbandit.app_links.AppLinksPlugin;
import com.lyokone.location.LocationPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.sameer.flutterstatusbarcolor.flutterstatusbarcolor.FlutterStatusbarcolorPlugin;
import com.shivam.otp_pin_field.OtpPinFieldPlugin;
import com.tekartik.sqflite.SqflitePlugin;
import com.yanisalfian.flutterphonedirectcaller.FlutterPhoneDirectCallerPlugin;
import dev.fluttercommunity.plus.connectivity.ConnectivityPlugin;
import dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin;
import dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin;
import fman.ge.smart_auth.SmartAuthPlugin;
import im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.camera.CameraPlugin;
import io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.localauth.LocalAuthPlugin;
import io.flutter.plugins.nfcmanager.NfcManagerPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;

/* loaded from: classes4.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add(new AppLinksPlugin());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin app_links, com.llfbandit.app_links.AppLinksPlugin", e);
        }
        try {
            flutterEngine.getPlugins().add(new CameraPlugin());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin camera_android, io.flutter.plugins.camera.CameraPlugin", e2);
        }
        try {
            flutterEngine.getPlugins().add(new ConnectivityPlugin());
        } catch (Exception e3) {
            Log.e(TAG, "Error registering plugin connectivity_plus, dev.fluttercommunity.plus.connectivity.ConnectivityPlugin", e3);
        }
        try {
            flutterEngine.getPlugins().add(new DeviceInfoPlusPlugin());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin device_info_plus, dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseAnalyticsPlugin());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin firebase_analytics, io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseCorePlugin());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseMessagingPlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin firebase_messaging, io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add(new InAppWebViewFlutterPlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin flutter_inappwebview_android, com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterLocalNotificationsPlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin flutter_local_notifications, com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterNfcKitPlugin());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin flutter_nfc_kit, im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterPhoneDirectCallerPlugin());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin flutter_phone_direct_caller, com.yanisalfian.flutterphonedirectcaller.FlutterPhoneDirectCallerPlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterAndroidLifecyclePlugin());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterStatusbarcolorPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin flutter_statusbarcolor_ns, com.sameer.flutterstatusbarcolor.flutterstatusbarcolor.FlutterStatusbarcolorPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add(new GoogleMlKitCommonsPlugin());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin google_mlkit_commons, com.google_mlkit_commons.GoogleMlKitCommonsPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add(new GoogleMlKitFaceDetectionPlugin());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin google_mlkit_face_detection, com.google_mlkit_face_detection.GoogleMlKitFaceDetectionPlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add(new GoogleMlKitTextRecognitionPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin google_mlkit_text_recognition, com.google_mlkit_text_recognition.GoogleMlKitTextRecognitionPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add(new ImageGallerySaverPlusPlugin());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin image_gallery_saver_plus, com.example.image_gallery_saver_plus.ImageGallerySaverPlusPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add(new ImagePickerPlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin image_picker_android, io.flutter.plugins.imagepicker.ImagePickerPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add(new LocalAuthPlugin());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin local_auth_android, io.flutter.plugins.localauth.LocalAuthPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add(new LocationPlugin());
        } catch (Exception e20) {
            Log.e(TAG, "Error registering plugin location, com.lyokone.location.LocationPlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add(new NfcManagerPlugin());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin nfc_manager, io.flutter.plugins.nfcmanager.NfcManagerPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add(new OtpPinFieldPlugin());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin otp_pin_field, com.shivam.otp_pin_field.OtpPinFieldPlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add(new PackageInfoPlugin());
        } catch (Exception e23) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add(new PathProviderPlugin());
        } catch (Exception e24) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add(new PermissionHandlerPlugin());
        } catch (Exception e25) {
            Log.e(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e25);
        }
        try {
            flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
        } catch (Exception e26) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e26);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterBarcodeScannerPlugin());
        } catch (Exception e27) {
            Log.e(TAG, "Error registering plugin simple_barcode_scanner, com.amolg.flutterbarcodescanner.FlutterBarcodeScannerPlugin", e27);
        }
        try {
            flutterEngine.getPlugins().add(new SmartAuthPlugin());
        } catch (Exception e28) {
            Log.e(TAG, "Error registering plugin smart_auth, fman.ge.smart_auth.SmartAuthPlugin", e28);
        }
        try {
            flutterEngine.getPlugins().add(new SqflitePlugin());
        } catch (Exception e29) {
            Log.e(TAG, "Error registering plugin sqflite_android, com.tekartik.sqflite.SqflitePlugin", e29);
        }
        try {
            flutterEngine.getPlugins().add(new UrlLauncherPlugin());
        } catch (Exception e30) {
            Log.e(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e30);
        }
        try {
            flutterEngine.getPlugins().add(new VideoPlayerPlugin());
        } catch (Exception e31) {
            Log.e(TAG, "Error registering plugin video_player_android, io.flutter.plugins.videoplayer.VideoPlayerPlugin", e31);
        }
        try {
            flutterEngine.getPlugins().add(new WebViewFlutterPlugin());
        } catch (Exception e32) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e32);
        }
    }
}
