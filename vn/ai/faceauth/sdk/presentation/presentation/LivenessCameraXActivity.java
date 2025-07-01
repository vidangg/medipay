package vn.ai.faceauth.sdk.presentation.presentation;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import paua.btj;
import vn.ai.faceauth.sdk.R;
import vn.ai.faceauth.sdk.camera.di.CameraModule;
import vn.ai.faceauth.sdk.presentation.di.LibraryModule;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;
import vn.ai.faceauth.sdk.presentation.navigation.SDKCallback;
import vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment;
import vn.ai.faceauth.sdk.presentation.presentation.fragment.InstructionFragment;
import vn.ai.faceauth.sdk.presentation.presentation.fragment.PermissionFragment;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0017\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u000eH\u0014J-\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00062\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006)"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/LivenessCameraXActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lvn/ai/faceauth/sdk/presentation/presentation/fragment/InstructionFragment$ICallbackAccept;", "Lvn/ai/faceauth/sdk/presentation/presentation/fragment/PermissionFragment$ICallbackCheckPermission;", "()V", "CAMERA_PERMISSION_REQUEST_CODE", "", "mLanguage", "", "getMLanguage", "()Ljava/lang/String;", "mLanguage$delegate", "Lkotlin/Lazy;", "FullScreencall", "", "initLanguage", "initializeModules", "onBackPressed", "onCallback", "isAccept", "", "(Ljava/lang/Boolean;)V", "onCallbackPermission", "isGranted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onWindowFocusChanged", "hasFocus", "openCameraFragment", "openInstructionFragment", "openPermissionFragment", "viewScreenAfterHasPermission", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class LivenessCameraXActivity extends AppCompatActivity implements InstructionFragment.ICallbackAccept, PermissionFragment.ICallbackCheckPermission {
    private final int CAMERA_PERMISSION_REQUEST_CODE = 1001;

    /* renamed from: mLanguage$delegate, reason: from kotlin metadata */
    private final Lazy mLanguage = LazyKt.lazy(new Function0<String>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.LivenessCameraXActivity$mLanguage$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle extras;
            String string;
            Intent intent = LivenessCameraXActivity.this.getIntent();
            return (intent == null || (extras = intent.getExtras()) == null || (string = extras.getString(btj.tzend(217))) == null) ? btj.tzend(218) : string;
        }
    });

    private final String getMLanguage() {
        return (String) this.mLanguage.getValue();
    }

    private final void initLanguage() {
        String mLanguage = getMLanguage();
        if (mLanguage == null || mLanguage.length() <= 0) {
            return;
        }
        if (Intrinsics.areEqual(mLanguage, btj.tzend(27)) || Intrinsics.areEqual(mLanguage, btj.tzend(28))) {
            Resources resources = getApplication().getApplicationContext().getResources();
            Configuration configuration = new Configuration(resources.getConfiguration());
            Locale locale = new Locale(mLanguage);
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Resources resources2 = getResources();
            Configuration configuration2 = new Configuration(resources2.getConfiguration());
            configuration2.setLocale(locale);
            resources2.updateConfiguration(configuration2, resources2.getDisplayMetrics());
        }
    }

    private final void initializeModules() {
        LibraryModule.INSTANCE.initializeDI(getApplication());
        CameraModule.INSTANCE.initializeDI(getApplication());
    }

    private final void openCameraFragment() {
        Log.d(btj.tzend(29), btj.tzend(30));
        CameraXFragment cameraXFragment = new CameraXFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.fragmentContainer, cameraXFragment);
        beginTransaction.commit();
        supportFragmentManager.executePendingTransactions();
    }

    private final void openInstructionFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new InstructionFragment()).commit();
    }

    private final void openPermissionFragment() {
        PermissionFragment newInstance = PermissionFragment.INSTANCE.newInstance();
        newInstance.setCallBackPermission(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, newInstance).commit();
    }

    private final void viewScreenAfterHasPermission() {
        Log.d(btj.tzend(31), btj.tzend(32));
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        if (authenticationID.getConfig$authenSDK_release() == null || !authenticationID.getConfig$authenSDK_release().isShowGuideScreen()) {
            openCameraFragment();
        } else {
            openInstructionFragment();
        }
    }

    public final void FullScreencall() {
        getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.fragment.InstructionFragment.ICallbackAccept
    public void onCallback(Boolean isAccept) {
        openCameraFragment();
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.fragment.PermissionFragment.ICallbackCheckPermission
    public void onCallbackPermission(Boolean isGranted) {
        if (Intrinsics.areEqual(isGranted, Boolean.TRUE)) {
            Log.d(btj.tzend(33), btj.tzend(34));
            viewScreenAfterHasPermission();
        } else {
            SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
            if (callbackResult$authenSDK_release != null) {
                SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 306, btj.tzend(35), null, null, null, null, 60, null);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreencall();
        setContentView(R.layout.facesdk_camerax_activity);
        initializeModules();
        initLanguage();
        if (ContextCompat.checkSelfPermission(this, btj.tzend(36)) != 0) {
            openPermissionFragment();
        } else {
            Log.d(btj.tzend(37), btj.tzend(38));
            viewScreenAfterHasPermission();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AuthenticationID.INSTANCE.removeAction();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.CAMERA_PERMISSION_REQUEST_CODE) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                Log.d(btj.tzend(39), btj.tzend(40));
                viewScreenAfterHasPermission();
            } else {
                SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
                if (callbackResult$authenSDK_release != null) {
                    SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 0, btj.tzend(41), null, null, null, null, 60, null);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreencall();
        }
    }
}
