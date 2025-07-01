package com.pichillilorenzo.flutter_inappwebview_android;

import android.os.Build;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes4.dex */
public class PlatformUtil extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "PlatformUtil";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_platformutil";
    public InAppWebViewFlutterPlugin plugin;

    public PlatformUtil(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public static String formatDate(long j, String str, Locale locale, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date(j));
    }

    public static Locale getLocaleFromString(String str) {
        if (str == null) {
            return Locale.US;
        }
        String[] split = str.split("_");
        return new Locale(split[0], split.length > 1 ? split[1] : "", split.length > 2 ? split[2] : "");
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String formatDate;
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("formatDate")) {
            long longValue = ((Long) methodCall.argument("date")).longValue();
            String str2 = (String) methodCall.argument("format");
            Locale localeFromString = getLocaleFromString((String) methodCall.argument("locale"));
            String str3 = (String) methodCall.argument("timezone");
            if (str3 == null) {
                str3 = "UTC";
            }
            formatDate = formatDate(longValue, str2, localeFromString, TimeZone.getTimeZone(str3));
        } else {
            if (!str.equals("getSystemVersion")) {
                result.notImplemented();
                return;
            }
            formatDate = String.valueOf(Build.VERSION.SDK_INT);
        }
        result.success(formatDate);
    }
}
