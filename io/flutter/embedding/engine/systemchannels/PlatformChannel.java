package io.flutter.embedding.engine.systemchannels;

import androidx.core.view.ViewCompat;
import androidx.webkit.internal.AssetHelper;
import com.google.firebase.messaging.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PlatformChannel {
    private static final String TAG = "PlatformChannel";
    public final MethodChannel channel;
    final MethodChannel.MethodCallHandler parsingMethodCallHandler;
    private PlatformMessageHandler platformMessageHandler;

    /* loaded from: classes4.dex */
    public interface PlatformMessageHandler {
        boolean clipboardHasStrings();

        CharSequence getClipboardData(ClipboardContentFormat clipboardContentFormat);

        void playSystemSound(SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(String str);

        default void setFrameworkHandlesBack(boolean z) {
        }

        void setPreferredOrientations(int i);

        void setSystemUiChangeListener();

        void setSystemUiOverlayStyle(SystemChromeStyle systemChromeStyle);

        void share(String str);

        void showSystemOverlays(List<SystemUiOverlay> list);

        void showSystemUiMode(SystemUiMode systemUiMode);

        void vibrateHapticFeedback(HapticFeedbackType hapticFeedbackType);
    }

    public PlatformChannel(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformChannel.1
            /* JADX WARN: Removed duplicated region for block: B:26:0x0142 A[Catch: JSONException -> 0x026f, TryCatch #12 {JSONException -> 0x026f, blocks: (B:7:0x002a, B:8:0x002e, B:13:0x00db, B:15:0x00e0, B:17:0x00f0, B:19:0x0109, B:21:0x011d, B:31:0x0121, B:24:0x0136, B:26:0x0142, B:28:0x014f, B:33:0x0126, B:34:0x0154, B:36:0x0162, B:38:0x0198, B:40:0x01a6, B:43:0x0237, B:50:0x0253, B:89:0x018f, B:68:0x01cd, B:82:0x01ef, B:61:0x020f, B:75:0x022f, B:47:0x024b, B:54:0x0267, B:91:0x0033, B:94:0x003e, B:97:0x0049, B:100:0x0055, B:103:0x0061, B:106:0x006c, B:109:0x0077, B:112:0x0081, B:115:0x008b, B:118:0x0095, B:121:0x009f, B:124:0x00a9, B:127:0x00b4, B:130:0x00bf, B:133:0x00ca, B:57:0x01f8), top: B:6:0x002a, inners: #0, #5, #6, #9 }] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x014f A[Catch: JSONException -> 0x026f, TryCatch #12 {JSONException -> 0x026f, blocks: (B:7:0x002a, B:8:0x002e, B:13:0x00db, B:15:0x00e0, B:17:0x00f0, B:19:0x0109, B:21:0x011d, B:31:0x0121, B:24:0x0136, B:26:0x0142, B:28:0x014f, B:33:0x0126, B:34:0x0154, B:36:0x0162, B:38:0x0198, B:40:0x01a6, B:43:0x0237, B:50:0x0253, B:89:0x018f, B:68:0x01cd, B:82:0x01ef, B:61:0x020f, B:75:0x022f, B:47:0x024b, B:54:0x0267, B:91:0x0033, B:94:0x003e, B:97:0x0049, B:100:0x0055, B:103:0x0061, B:106:0x006c, B:109:0x0077, B:112:0x0081, B:115:0x008b, B:118:0x0095, B:121:0x009f, B:124:0x00a9, B:127:0x00b4, B:130:0x00bf, B:133:0x00ca, B:57:0x01f8), top: B:6:0x002a, inners: #0, #5, #6, #9 }] */
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                char c;
                ClipboardContentFormat fromValue;
                CharSequence clipboardData;
                if (PlatformChannel.this.platformMessageHandler == null) {
                    return;
                }
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(PlatformChannel.TAG, "Received '" + str + "' message.");
                try {
                    switch (str.hashCode()) {
                        case -1501580720:
                            if (str.equals("SystemNavigator.setFrameworkHandlesBack")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -931781241:
                            if (str.equals("Share.invoke")) {
                                c = 14;
                                break;
                            }
                            c = 65535;
                            break;
                        case -766342101:
                            if (str.equals("SystemNavigator.pop")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -720677196:
                            if (str.equals("Clipboard.setData")) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case -577225884:
                            if (str.equals("SystemChrome.setSystemUIChangeListener")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -548468504:
                            if (str.equals("SystemChrome.setApplicationSwitcherDescription")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -247230243:
                            if (str.equals("HapticFeedback.vibrate")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -215273374:
                            if (str.equals("SystemSound.play")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 241845679:
                            if (str.equals("SystemChrome.restoreSystemUIOverlays")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 875995648:
                            if (str.equals("Clipboard.hasStrings")) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1128339786:
                            if (str.equals("SystemChrome.setEnabledSystemUIMode")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1390477857:
                            if (str.equals("SystemChrome.setSystemUIOverlayStyle")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1514180520:
                            if (str.equals("Clipboard.getData")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1674312266:
                            if (str.equals("SystemChrome.setEnabledSystemUIOverlays")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2119655719:
                            if (str.equals("SystemChrome.setPreferredOrientations")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            try {
                                PlatformChannel.this.platformMessageHandler.playSystemSound(SoundType.fromValue((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException e) {
                                result.error("error", e.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                PlatformChannel.this.platformMessageHandler.vibrateHapticFeedback(HapticFeedbackType.fromValue((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException e2) {
                                result.error("error", e2.getMessage(), null);
                                return;
                            }
                        case 2:
                            try {
                                PlatformChannel.this.platformMessageHandler.setPreferredOrientations(PlatformChannel.this.decodeOrientations((JSONArray) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e3) {
                                result.error("error", e3.getMessage(), null);
                                return;
                            }
                        case 3:
                            try {
                                PlatformChannel.this.platformMessageHandler.setApplicationSwitcherDescription(PlatformChannel.this.decodeAppSwitcherDescription((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (JSONException e4) {
                                result.error("error", e4.getMessage(), null);
                                return;
                            }
                        case 4:
                            try {
                                PlatformChannel.this.platformMessageHandler.showSystemOverlays(PlatformChannel.this.decodeSystemUiOverlays((JSONArray) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e5) {
                                result.error("error", e5.getMessage(), null);
                                return;
                            }
                        case 5:
                            try {
                                PlatformChannel.this.platformMessageHandler.showSystemUiMode(PlatformChannel.this.decodeSystemUiMode((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e6) {
                                result.error("error", e6.getMessage(), null);
                                return;
                            }
                        case 6:
                            PlatformChannel.this.platformMessageHandler.setSystemUiChangeListener();
                            result.success(null);
                            return;
                        case 7:
                            PlatformChannel.this.platformMessageHandler.restoreSystemUiOverlays();
                            result.success(null);
                            return;
                        case '\b':
                            try {
                                PlatformChannel.this.platformMessageHandler.setSystemUiOverlayStyle(PlatformChannel.this.decodeSystemChromeStyle((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e7) {
                                result.error("error", e7.getMessage(), null);
                                return;
                            }
                        case '\t':
                            PlatformChannel.this.platformMessageHandler.setFrameworkHandlesBack(((Boolean) obj).booleanValue());
                            result.success(null);
                            return;
                        case '\n':
                            PlatformChannel.this.platformMessageHandler.popSystemNavigator();
                            result.success(null);
                            return;
                        case 11:
                            String str2 = (String) obj;
                            if (str2 != null) {
                                try {
                                    fromValue = ClipboardContentFormat.fromValue(str2);
                                } catch (NoSuchFieldException unused) {
                                    result.error("error", "No such clipboard content format: " + str2, null);
                                }
                                clipboardData = PlatformChannel.this.platformMessageHandler.getClipboardData(fromValue);
                                if (clipboardData == null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("text", clipboardData);
                                    result.success(jSONObject);
                                    return;
                                }
                                result.success(null);
                                return;
                            }
                            fromValue = null;
                            clipboardData = PlatformChannel.this.platformMessageHandler.getClipboardData(fromValue);
                            if (clipboardData == null) {
                            }
                        case '\f':
                            PlatformChannel.this.platformMessageHandler.setClipboardData(((JSONObject) obj).getString("text"));
                            result.success(null);
                            return;
                        case '\r':
                            boolean clipboardHasStrings = PlatformChannel.this.platformMessageHandler.clipboardHasStrings();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("value", clipboardHasStrings);
                            result.success(jSONObject2);
                            return;
                        case 14:
                            PlatformChannel.this.platformMessageHandler.share((String) obj);
                            result.success(null);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                } catch (JSONException e8) {
                    result.error("error", "JSON error: " + e8.getMessage(), null);
                }
                result.error("error", "JSON error: " + e8.getMessage(), null);
            }
        };
        this.parsingMethodCallHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    public void setPlatformMessageHandler(PlatformMessageHandler platformMessageHandler) {
        this.platformMessageHandler = platformMessageHandler;
    }

    public void systemChromeChanged(boolean z) {
        Log.v(TAG, "Sending 'systemUIChange' message.");
        this.channel.invokeMethod("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x003e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int decodeOrientations(JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            int i4 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.fromValue(jSONArray.getString(i3)).ordinal()];
            if (i4 == 1) {
                i |= 1;
            } else if (i4 == 2) {
                i |= 4;
            } else if (i4 == 3) {
                i |= 2;
            } else if (i4 == 4) {
                i |= 8;
            }
            if (i2 == 0) {
                i2 = i;
            }
        }
        if (i == 0) {
            return -1;
        }
        switch (i) {
            case 2:
                return 0;
            case 3:
            case 6:
            case 7:
            case 9:
            case 12:
            case 13:
            case 14:
                if (i2 != 2) {
                    if (i2 != 4) {
                        return i2 != 8 ? 1 : 8;
                    }
                    return 9;
                }
                return 0;
            case 4:
                return 9;
            case 5:
                return 12;
            case 8:
                return 8;
            case 10:
                return 11;
            case 11:
                return 2;
            case 15:
                return 13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppSwitcherDescription decodeAppSwitcherDescription(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("primaryColor");
        if (i != 0) {
            i |= ViewCompat.MEASURED_STATE_MASK;
        }
        return new AppSwitcherDescription(i, jSONObject.getString(Constants.ScionAnalytics.PARAM_LABEL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SystemUiOverlay> decodeSystemUiOverlays(JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.fromValue(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
            } else if (i2 == 2) {
                arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformChannel$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        static {
            int[] iArr = new int[SystemUiMode.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode = iArr;
            try {
                iArr[SystemUiMode.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr2;
            try {
                iArr2[SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr3;
            try {
                iArr3[DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SystemUiMode decodeSystemUiMode(String str) throws JSONException, NoSuchFieldException {
        int i = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.fromValue(str).ordinal()];
        if (i == 1) {
            return SystemUiMode.LEAN_BACK;
        }
        if (i == 2) {
            return SystemUiMode.IMMERSIVE;
        }
        if (i == 3) {
            return SystemUiMode.IMMERSIVE_STICKY;
        }
        if (i == 4) {
            return SystemUiMode.EDGE_TO_EDGE;
        }
        return SystemUiMode.EDGE_TO_EDGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SystemChromeStyle decodeSystemChromeStyle(JSONObject jSONObject) throws JSONException, NoSuchFieldException {
        return new SystemChromeStyle(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    /* loaded from: classes4.dex */
    public enum SoundType {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");

        private final String encodedName;

        static SoundType fromValue(String str) throws NoSuchFieldException {
            for (SoundType soundType : values()) {
                if (soundType.encodedName.equals(str)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }

        SoundType(String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes4.dex */
    public enum HapticFeedbackType {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");

        private final String encodedName;

        static HapticFeedbackType fromValue(String str) throws NoSuchFieldException {
            for (HapticFeedbackType hapticFeedbackType : values()) {
                String str2 = hapticFeedbackType.encodedName;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return hapticFeedbackType;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }

        HapticFeedbackType(String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes4.dex */
    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");

        private String encodedName;

        static DeviceOrientation fromValue(String str) throws NoSuchFieldException {
            for (DeviceOrientation deviceOrientation : values()) {
                if (deviceOrientation.encodedName.equals(str)) {
                    return deviceOrientation;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }

        DeviceOrientation(String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes4.dex */
    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");

        private String encodedName;

        static SystemUiOverlay fromValue(String str) throws NoSuchFieldException {
            for (SystemUiOverlay systemUiOverlay : values()) {
                if (systemUiOverlay.encodedName.equals(str)) {
                    return systemUiOverlay;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }

        SystemUiOverlay(String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes4.dex */
    public enum SystemUiMode {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");

        private String encodedName;

        static SystemUiMode fromValue(String str) throws NoSuchFieldException {
            for (SystemUiMode systemUiMode : values()) {
                if (systemUiMode.encodedName.equals(str)) {
                    return systemUiMode;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }

        SystemUiMode(String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class AppSwitcherDescription {
        public final int color;
        public final String label;

        public AppSwitcherDescription(int i, String str) {
            this.color = i;
            this.label = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class SystemChromeStyle {
        public final Integer statusBarColor;
        public final Brightness statusBarIconBrightness;
        public final Integer systemNavigationBarColor;
        public final Boolean systemNavigationBarContrastEnforced;
        public final Integer systemNavigationBarDividerColor;
        public final Brightness systemNavigationBarIconBrightness;
        public final Boolean systemStatusBarContrastEnforced;

        public SystemChromeStyle(Integer num, Brightness brightness, Boolean bool, Integer num2, Brightness brightness2, Integer num3, Boolean bool2) {
            this.statusBarColor = num;
            this.statusBarIconBrightness = brightness;
            this.systemStatusBarContrastEnforced = bool;
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
            this.systemNavigationBarContrastEnforced = bool2;
        }
    }

    /* loaded from: classes4.dex */
    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");

        private String encodedName;

        static Brightness fromValue(String str) throws NoSuchFieldException {
            for (Brightness brightness : values()) {
                if (brightness.encodedName.equals(str)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }

        Brightness(String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes4.dex */
    public enum ClipboardContentFormat {
        PLAIN_TEXT(AssetHelper.DEFAULT_MIME_TYPE);

        private String encodedName;

        static ClipboardContentFormat fromValue(String str) throws NoSuchFieldException {
            for (ClipboardContentFormat clipboardContentFormat : values()) {
                if (clipboardContentFormat.encodedName.equals(str)) {
                    return clipboardContentFormat;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }

        ClipboardContentFormat(String str) {
            this.encodedName = str;
        }
    }
}
