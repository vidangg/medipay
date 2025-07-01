package dev.fluttercommunity.plus.device_info;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MethodCallHandlerImpl.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ldev/fluttercommunity/plus/device_info/MethodCallHandlerImpl;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "packageManager", "Landroid/content/pm/PackageManager;", "activityManager", "Landroid/app/ActivityManager;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/pm/PackageManager;Landroid/app/ActivityManager;Landroid/content/ContentResolver;)V", "isEmulator", "", "()Z", "getSystemFeatures", "", "", "onMethodCall", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "Lio/flutter/plugin/common/MethodChannel$Result;", "device_info_plus_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private final ActivityManager activityManager;
    private final ContentResolver contentResolver;
    private final PackageManager packageManager;

    public MethodCallHandlerImpl(PackageManager packageManager, ActivityManager activityManager, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(activityManager, "activityManager");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.packageManager = packageManager;
        this.activityManager = activityManager;
        this.contentResolver = contentResolver;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        String str;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (call.method.equals("getDeviceInfo")) {
            HashMap hashMap = new HashMap();
            String BOARD = Build.BOARD;
            Intrinsics.checkNotNullExpressionValue(BOARD, "BOARD");
            hashMap.put("board", BOARD);
            String BOOTLOADER = Build.BOOTLOADER;
            Intrinsics.checkNotNullExpressionValue(BOOTLOADER, "BOOTLOADER");
            hashMap.put("bootloader", BOOTLOADER);
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            hashMap.put("brand", BRAND);
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            hashMap.put("device", DEVICE);
            String DISPLAY = Build.DISPLAY;
            Intrinsics.checkNotNullExpressionValue(DISPLAY, "DISPLAY");
            hashMap.put(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, DISPLAY);
            String FINGERPRINT = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            hashMap.put("fingerprint", FINGERPRINT);
            String HARDWARE = Build.HARDWARE;
            Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
            hashMap.put("hardware", HARDWARE);
            String HOST = Build.HOST;
            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
            hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, HOST);
            String ID = Build.ID;
            Intrinsics.checkNotNullExpressionValue(ID, "ID");
            hashMap.put(TtmlNode.ATTR_ID, ID);
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            hashMap.put("manufacturer", MANUFACTURER);
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            hashMap.put("model", MODEL);
            String PRODUCT = Build.PRODUCT;
            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
            hashMap.put("product", PRODUCT);
            String string = Settings.Global.getString(this.contentResolver, "device_name");
            if (string == null) {
                string = "";
            }
            hashMap.put("name", string);
            String[] SUPPORTED_32_BIT_ABIS = Build.SUPPORTED_32_BIT_ABIS;
            Intrinsics.checkNotNullExpressionValue(SUPPORTED_32_BIT_ABIS, "SUPPORTED_32_BIT_ABIS");
            hashMap.put("supported32BitAbis", CollectionsKt.listOf(Arrays.copyOf(SUPPORTED_32_BIT_ABIS, SUPPORTED_32_BIT_ABIS.length)));
            String[] SUPPORTED_64_BIT_ABIS = Build.SUPPORTED_64_BIT_ABIS;
            Intrinsics.checkNotNullExpressionValue(SUPPORTED_64_BIT_ABIS, "SUPPORTED_64_BIT_ABIS");
            hashMap.put("supported64BitAbis", CollectionsKt.listOf(Arrays.copyOf(SUPPORTED_64_BIT_ABIS, SUPPORTED_64_BIT_ABIS.length)));
            String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
            hashMap.put("supportedAbis", CollectionsKt.listOf(Arrays.copyOf(SUPPORTED_ABIS, SUPPORTED_ABIS.length)));
            String TAGS = Build.TAGS;
            Intrinsics.checkNotNullExpressionValue(TAGS, "TAGS");
            hashMap.put("tags", TAGS);
            String TYPE = Build.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            hashMap.put(SessionDescription.ATTR_TYPE, TYPE);
            hashMap.put("isPhysicalDevice", Boolean.valueOf(!isEmulator()));
            hashMap.put("systemFeatures", getSystemFeatures());
            HashMap hashMap2 = new HashMap();
            String BASE_OS = Build.VERSION.BASE_OS;
            Intrinsics.checkNotNullExpressionValue(BASE_OS, "BASE_OS");
            hashMap2.put("baseOS", BASE_OS);
            hashMap2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
            String SECURITY_PATCH = Build.VERSION.SECURITY_PATCH;
            Intrinsics.checkNotNullExpressionValue(SECURITY_PATCH, "SECURITY_PATCH");
            hashMap2.put("securityPatch", SECURITY_PATCH);
            String CODENAME = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
            hashMap2.put("codename", CODENAME);
            String INCREMENTAL = Build.VERSION.INCREMENTAL;
            Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
            hashMap2.put("incremental", INCREMENTAL);
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            hashMap2.put("release", RELEASE);
            hashMap2.put("sdkInt", Integer.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("version", hashMap2);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            this.activityManager.getMemoryInfo(memoryInfo);
            hashMap.put("isLowRamDevice", Boolean.valueOf(memoryInfo.lowMemory));
            hashMap.put("physicalRamSize", Long.valueOf(memoryInfo.totalMem / 1048576));
            hashMap.put("availableRamSize", Long.valueOf(memoryInfo.availMem / 1048576));
            try {
                str = Build.getSerial();
            } catch (SecurityException unused) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            Intrinsics.checkNotNull(str);
            hashMap.put("serialNumber", str);
            result.success(hashMap);
            return;
        }
        result.notImplemented();
    }

    private final List<String> getSystemFeatures() {
        FeatureInfo[] systemAvailableFeatures = this.packageManager.getSystemAvailableFeatures();
        Intrinsics.checkNotNullExpressionValue(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
        ArrayList arrayList = new ArrayList();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo.name != null) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((FeatureInfo) it.next()).name);
        }
        return arrayList3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001d, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r0, "generic", false, 2, (java.lang.Object) null) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isEmulator() {
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
        }
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
            String FINGERPRINT2 = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                String HARDWARE = Build.HARDWARE;
                Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "goldfish", false, 2, (Object) null)) {
                    String HARDWARE2 = Build.HARDWARE;
                    Intrinsics.checkNotNullExpressionValue(HARDWARE2, "HARDWARE");
                    if (!StringsKt.contains$default((CharSequence) HARDWARE2, (CharSequence) "ranchu", false, 2, (Object) null)) {
                        String MODEL = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                            String MODEL2 = Build.MODEL;
                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                String MODEL3 = Build.MODEL;
                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                    String MANUFACTURER = Build.MANUFACTURER;
                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                        String PRODUCT = Build.PRODUCT;
                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                        if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk", false, 2, (Object) null)) {
                                            String PRODUCT2 = Build.PRODUCT;
                                            Intrinsics.checkNotNullExpressionValue(PRODUCT2, "PRODUCT");
                                            if (!StringsKt.contains$default((CharSequence) PRODUCT2, (CharSequence) "vbox86p", false, 2, (Object) null)) {
                                                String PRODUCT3 = Build.PRODUCT;
                                                Intrinsics.checkNotNullExpressionValue(PRODUCT3, "PRODUCT");
                                                if (!StringsKt.contains$default((CharSequence) PRODUCT3, (CharSequence) "emulator", false, 2, (Object) null)) {
                                                    String PRODUCT4 = Build.PRODUCT;
                                                    Intrinsics.checkNotNullExpressionValue(PRODUCT4, "PRODUCT");
                                                    if (!StringsKt.contains$default((CharSequence) PRODUCT4, (CharSequence) "simulator", false, 2, (Object) null)) {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
