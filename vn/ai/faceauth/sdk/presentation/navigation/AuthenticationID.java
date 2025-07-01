package vn.ai.faceauth.sdk.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import paua.btj;
import vn.ai.faceauth.sdk.presentation.domain.configs.CameraSettings;
import vn.ai.faceauth.sdk.presentation.domain.configs.LivenessConfig;
import vn.ai.faceauth.sdk.presentation.domain.configs.SDKConfig;
import vn.ai.faceauth.sdk.presentation.navigation.SDKCallback;
import vn.ai.faceauth.sdk.presentation.presentation.LivenessCameraXActivity;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00106\u001a\u00020\u000fH\u0002J\u0010\u0010\r\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0007J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020%H\u0007J\u0018\u0010;\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u0010=\u001a\u00020\u0004H\u0002J\u000f\u0010>\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\b?J\u0010\u0010@\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0007J\u000e\u0010A\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u0004J\u0010\u0010C\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0004H\u0007J\u0010\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0006\u0010H\u001a\u00020\u000fJ\b\u0010I\u001a\u00020\u000fH\u0002J\r\u0010J\u001a\u00020\u000fH\u0000¢\u0006\u0002\bKJ\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u0004H\u0007J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0015\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bRJ\u0010\u0010*\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0007J\u0010\u00100\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0007J\u0018\u0010S\u001a\u00020\u000f2\u0006\u00107\u001a\u0002082\u0006\u0010T\u001a\u00020\bH\u0007J\u0010\u0010U\u001a\u00020\u00172\u0006\u0010:\u001a\u00020%H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010*\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013¨\u0006V"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/navigation/AuthenticationID;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackResult", "Lvn/ai/faceauth/sdk/presentation/navigation/SDKCallback;", "getCallbackResult$authenSDK_release", "()Lvn/ai/faceauth/sdk/presentation/navigation/SDKCallback;", "setCallbackResult$authenSDK_release", "(Lvn/ai/faceauth/sdk/presentation/navigation/SDKCallback;)V", "closeSDK", "Lkotlin/Function0;", "", "getCloseSDK$authenSDK_release", "()Lkotlin/jvm/functions/Function0;", "setCloseSDK$authenSDK_release", "(Lkotlin/jvm/functions/Function0;)V", "handler", "Landroid/os/Handler;", "isSendCallback", "", "isStart", "jsonLanguage", "Lorg/json/JSONObject;", "getJsonLanguage$authenSDK_release", "()Lorg/json/JSONObject;", "setJsonLanguage$authenSDK_release", "(Lorg/json/JSONObject;)V", "livenessConfig", "Lvn/ai/faceauth/sdk/presentation/domain/configs/LivenessConfig;", "mLanguage", "runTimeOut", "Ljava/lang/Runnable;", "sdkConfig", "Lvn/ai/faceauth/sdk/presentation/domain/configs/SDKConfig;", "getSdkConfig$authenSDK_release", "()Lvn/ai/faceauth/sdk/presentation/domain/configs/SDKConfig;", "setSdkConfig$authenSDK_release", "(Lvn/ai/faceauth/sdk/presentation/domain/configs/SDKConfig;)V", "showError", "Lkotlin/Function1;", "getShowError$authenSDK_release", "()Lkotlin/jvm/functions/Function1;", "setShowError$authenSDK_release", "(Lkotlin/jvm/functions/Function1;)V", "showSuccess", "getShowSuccess$authenSDK_release", "setShowSuccess$authenSDK_release", "timeoutSDK", "getTimeoutSDK$authenSDK_release", "setTimeoutSDK$authenSDK_release", "clearHandlerCallbacks", "context", "Landroid/content/Context;", "configure", "obj", "getAssetFileSizeIfExists", "", "fileName", "getConfig", "getConfig$authenSDK_release", "info", "isBase64", "input", "isDebuggable", "isJSONValid", "text", "logConfigError", "property", "removeAction", "removeTimeOut", "resetTimeOut", "resetTimeOut$authenSDK_release", "setLanguage", CmcdData.Factory.STREAMING_FORMAT_SS, "setLivenessConfig", "setUpTimeOut", "timeout", "", "setUpTimeOut$authenSDK_release", "startFaceAuthen", "callback", "validConfig", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AuthenticationID {
    private static SDKCallback callbackResult;
    private static Function0<Unit> closeSDK;
    private static boolean isSendCallback;
    private static boolean isStart;
    private static JSONObject jsonLanguage;
    private static LivenessConfig livenessConfig;
    private static String mLanguage;
    private static SDKConfig sdkConfig;
    private static Function1<? super String, Unit> showError;
    private static Function0<Unit> showSuccess;
    private static Function0<Unit> timeoutSDK;
    public static final AuthenticationID INSTANCE = new AuthenticationID();
    private static final String TAG = btj.tzend(48);
    private static final Runnable runTimeOut = new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AuthenticationID.m2548runTimeOut$lambda3();
        }
    };
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private AuthenticationID() {
    }

    private final void clearHandlerCallbacks() {
        Handler handler2 = handler;
        handler2.removeCallbacksAndMessages(runTimeOut);
        handler2.removeCallbacksAndMessages(null);
    }

    @JvmStatic
    public static final void closeSDK(Context context) {
        Function0<Unit> function0 = closeSDK;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @JvmStatic
    public static final void configure(SDKConfig obj) {
        try {
            AuthenticationID authenticationID = INSTANCE;
            if (authenticationID.validConfig(obj)) {
                sdkConfig = obj;
                authenticationID.setLivenessConfig(new LivenessConfig(0.0f, 0.0f, 0.0f, 0.0f, 2, null));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private final long getAssetFileSizeIfExists(Context context, String fileName) {
        try {
            InputStream open = context.getAssets().open(fileName);
            try {
                long available = open.available();
                CloseableKt.closeFinally(open, null);
                return available;
            } finally {
            }
        } catch (IOException e) {
            Log.e(btj.tzend(49), btj.tzend(50), e);
            return 0L;
        }
    }

    @JvmStatic
    public static final String info(Context context) {
        AuthenticationID authenticationID = INSTANCE;
        long assetFileSizeIfExists = authenticationID.getAssetFileSizeIfExists(context, btj.tzend(51));
        String tzend = btj.tzend(52);
        if (assetFileSizeIfExists == 0) {
            Log.e(tzend, btj.tzend(53));
        }
        String str = btj.tzend(54) + authenticationID.isDebuggable(context) + btj.tzend(55) + assetFileSizeIfExists;
        Log.e(tzend, btj.tzend(56) + str);
        return str;
    }

    private final boolean isDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    @JvmStatic
    public static final boolean isJSONValid(String text) {
        try {
            try {
                new JSONObject(text);
                return true;
            } catch (JSONException unused) {
                new JSONArray(text);
                return true;
            }
        } catch (JSONException unused2) {
            return false;
        }
    }

    private final void logConfigError(String property) {
        Log.e(btj.tzend(59), btj.tzend(57) + property + btj.tzend(58));
    }

    private final void removeTimeOut() {
        Log.e(TAG, btj.tzend(60));
        clearHandlerCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: runTimeOut$lambda-3, reason: not valid java name */
    public static final void m2548runTimeOut$lambda3() {
        Log.e(TAG, btj.tzend(61));
        Function0<Unit> function0 = timeoutSDK;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @JvmStatic
    public static final void setLanguage(String s) {
        if (isJSONValid(s)) {
            jsonLanguage = new JSONObject(s);
        } else {
            mLanguage = s;
        }
    }

    private final void setLivenessConfig(LivenessConfig livenessConfig2) {
        livenessConfig = livenessConfig2;
    }

    @JvmStatic
    public static final void showError(Context context) {
        Function1<? super String, Unit> function1 = showError;
        if (function1 != null) {
            function1.invoke("");
        }
    }

    @JvmStatic
    public static final void showSuccess(Context context) {
        Function0<Unit> function0 = showSuccess;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004f, code lost:
    
        if (r0.isBase64(r1) == false) goto L13;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void startFaceAuthen(Context context, SDKCallback callback) {
        String nonce;
        info(context);
        Log.e(TAG, btj.tzend(62) + isStart);
        if (isStart) {
            return;
        }
        isStart = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthenticationID.isStart = false;
            }
        }, 1500L);
        AuthenticationID authenticationID = INSTANCE;
        String str = "";
        if (authenticationID.getConfig$authenSDK_release() != null) {
            SDKConfig sDKConfig = sdkConfig;
            if (sDKConfig == null || (r1 = sDKConfig.getNonce()) == null) {
                String str2 = "";
            }
        }
        SDKConfig sDKConfig2 = sdkConfig;
        if (sDKConfig2 != null && (nonce = sDKConfig2.getNonce()) != null) {
            str = nonce;
        }
        if (!authenticationID.isBase64(str)) {
            SDKCallback.DefaultImpls.complete$default(callback, 311, btj.tzend(63), "", "", "", null, 32, null);
            return;
        }
        SDKCallback.DefaultImpls.complete$default(callback, 311, btj.tzend(64), "", "", "", null, 32, null);
        if (sdkConfig != null) {
            Intent intent = new Intent(context, (Class<?>) LivenessCameraXActivity.class);
            intent.putExtra(btj.tzend(65), new CameraSettings(null, null, 3, null));
            intent.putExtra(btj.tzend(66), mLanguage);
            intent.putExtra(btj.tzend(67), livenessConfig);
            context.startActivity(intent);
            callbackResult = callback;
            isSendCallback = false;
        }
    }

    private final boolean validConfig(SDKConfig obj) {
        int i;
        if (obj.getPrimaryColor().length() == 0) {
            i = 69;
        } else if (obj.getSecondaryColor().length() == 0) {
            i = 70;
        } else if (obj.getErrorColor().length() == 0) {
            i = 71;
        } else if (obj.getCloseColor().length() == 0) {
            i = 72;
        } else if (obj.getTextColor().length() == 0) {
            i = 73;
        } else if (obj.getBackgroundColor().length() == 0) {
            i = 74;
        } else {
            if (obj.getNonce().length() != 0) {
                return true;
            }
            i = 75;
        }
        logConfigError(btj.tzend(i));
        Unit unit = Unit.INSTANCE;
        return false;
    }

    public final SDKCallback getCallbackResult$authenSDK_release() {
        return callbackResult;
    }

    public final Function0<Unit> getCloseSDK$authenSDK_release() {
        return closeSDK;
    }

    public final SDKConfig getConfig$authenSDK_release() {
        return sdkConfig;
    }

    public final JSONObject getJsonLanguage$authenSDK_release() {
        return jsonLanguage;
    }

    public final SDKConfig getSdkConfig$authenSDK_release() {
        return sdkConfig;
    }

    public final Function1<String, Unit> getShowError$authenSDK_release() {
        return showError;
    }

    public final Function0<Unit> getShowSuccess$authenSDK_release() {
        return showSuccess;
    }

    public final String getTAG() {
        return TAG;
    }

    public final Function0<Unit> getTimeoutSDK$authenSDK_release() {
        return timeoutSDK;
    }

    public final boolean isBase64(String input) {
        if (!new Regex(btj.tzend(76)).matches(input)) {
            return false;
        }
        try {
            return Base64.decode(input, 0).length >= 32;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final void removeAction() {
        removeTimeOut();
        timeoutSDK = null;
        showSuccess = null;
        closeSDK = null;
        showError = null;
    }

    public final void resetTimeOut$authenSDK_release() {
        removeTimeOut();
        setUpTimeOut$authenSDK_release(sdkConfig.getApiTimeout());
    }

    public final void setCallbackResult$authenSDK_release(SDKCallback sDKCallback) {
        callbackResult = sDKCallback;
    }

    public final void setCloseSDK$authenSDK_release(Function0<Unit> function0) {
        closeSDK = function0;
    }

    public final void setJsonLanguage$authenSDK_release(JSONObject jSONObject) {
        jsonLanguage = jSONObject;
    }

    public final void setSdkConfig$authenSDK_release(SDKConfig sDKConfig) {
        sdkConfig = sDKConfig;
    }

    public final void setShowError$authenSDK_release(Function1<? super String, Unit> function1) {
        showError = function1;
    }

    public final void setShowSuccess$authenSDK_release(Function0<Unit> function0) {
        showSuccess = function0;
    }

    public final void setTimeoutSDK$authenSDK_release(Function0<Unit> function0) {
        timeoutSDK = function0;
    }

    public final void setUpTimeOut$authenSDK_release(int timeout) {
        handler.postDelayed(runTimeOut, (timeout * 1000) + 1000);
    }
}
