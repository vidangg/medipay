package com.gotrust.medipayapp;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J-\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/gotrust/medipayapp/MainActivity;", "Lio/flutter/embedding/android/FlutterFragmentActivity;", "()V", "CAMERA_PERMISSION_REQUEST_CODE", "", "CHANNEL", "", "livenessPlugin", "Lcom/gotrust/medipayapp/LivenessPlugin;", "permissionResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class MainActivity extends FlutterFragmentActivity {
    private LivenessPlugin livenessPlugin;
    private MethodChannel.Result permissionResult;
    private final String CHANNEL = "com.gotrust.medipayV2/liveness";
    private final int CAMERA_PERMISSION_REQUEST_CODE = 1001;

    static {
        try {
            Log.d("MainActivity", "🔄 Loading TTXT native libraries...");
            System.loadLibrary("c++_shared");
            System.loadLibrary("VFaceLib");
            System.loadLibrary("cwnmdbful");
            Log.d("MainActivity", "✅ TTXT native libraries loaded successfully!");
        } catch (Exception e) {
            Log.e("MainActivity", "❌ Unexpected error loading native libraries: " + e.getMessage());
        } catch (UnsatisfiedLinkError e2) {
            Log.w("MainActivity", "⚠️ Native libraries not loaded manually: " + e2.getMessage());
            Log.w("MainActivity", "SDK will try to load them automatically");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.embedding.android.FlutterFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.gotrust.medipayapp.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                MainActivity.onCreate$lambda$0(thread, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(Thread thread, Throwable th) {
        String message;
        Log.e("MainActivity", "🚨 Uncaught exception in thread " + thread.getName() + ": " + th.getMessage());
        th.printStackTrace();
        String message2 = th.getMessage();
        if ((message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "miuilog", false, 2, (Object) null)) || ((message = th.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "CameraX", false, 2, (Object) null))) {
            Log.w("MainActivity", "⚠️ MIUI camera permission issue detected, continuing...");
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragmentActivity, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        this.livenessPlugin = new LivenessPlugin(this);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), this.CHANNEL).setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.gotrust.medipayapp.MainActivity$$ExternalSyntheticLambda1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                MainActivity.configureFlutterEngine$lambda$1(MainActivity.this, methodCall, result);
            }
        });
        Log.d("MainActivity", "✅ TTXT Liveness method channel registered successfully");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureFlutterEngine$lambda$1(MainActivity this$0, MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (Intrinsics.areEqual(str, "checkCameraPermission")) {
            result.success(Boolean.valueOf(ContextCompat.checkSelfPermission(this$0, "android.permission.CAMERA") == 0));
            return;
        }
        if (Intrinsics.areEqual(str, "requestCameraPermission")) {
            if (ContextCompat.checkSelfPermission(this$0, "android.permission.CAMERA") == 0) {
                result.success(true);
                return;
            } else {
                this$0.permissionResult = result;
                ActivityCompat.requestPermissions(this$0, new String[]{"android.permission.CAMERA"}, this$0.CAMERA_PERMISSION_REQUEST_CODE);
                return;
            }
        }
        LivenessPlugin livenessPlugin = this$0.livenessPlugin;
        if (livenessPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("livenessPlugin");
            livenessPlugin = null;
        }
        livenessPlugin.handleMethodCall(call, result);
    }

    @Override // io.flutter.embedding.android.FlutterFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.CAMERA_PERMISSION_REQUEST_CODE) {
            boolean z = ((grantResults.length == 0) ^ true) && grantResults[0] == 0;
            MethodChannel.Result result = this.permissionResult;
            if (result != null) {
                result.success(Boolean.valueOf(z));
            }
            this.permissionResult = null;
        }
    }
}
