package vn.ai.faceauth.sdk.presentation.presentation.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.rtsp.RtspMessageChannel;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import paua.btj;
import vn.ai.faceauth.sdk.R;
import vn.ai.faceauth.sdk.core.extensions.ImageExtensionsKt;
import vn.ai.faceauth.sdk.core.extensions.PrimitiveExtensionsKt;
import vn.ai.faceauth.sdk.presentation.domain.configs.SDKConfig;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;
import vn.ai.faceauth.sdk.presentation.navigation.SDKCallback;
import vn.ai.faceauth.sdk.presentation.presentation.utils.EnumPosition;
import vn.ai.faceauth.sdk.presentation.presentation.utils.UtilsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010'\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u0015J\b\u0010+\u001a\u00020\u0015H\u0002J\u0006\u0010,\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\n0\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/fragment/PermissionFragment;", "Landroidx/fragment/app/Fragment;", "()V", "bgLinearLayout", "Landroid/view/View;", "btnAccept", "Landroid/widget/Button;", "btnBack", "Landroid/widget/ImageView;", "cameraManifest", "", "cameraPermission", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "iCallbackCheckPermission", "Lvn/ai/faceauth/sdk/presentation/presentation/fragment/PermissionFragment$ICallbackCheckPermission;", "toolbarText", "Landroid/widget/TextView;", "txtRequestAccess", "txtSub", "forceCloseSDK", "", "handleCameraPermission", "granted", "", "parentView", "initView", "view", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "setCallBackPermission", "iCallback", "setupActionFaceSDK", "setupConfig", "timeoutSDK", "Companion", "ICallbackCheckPermission", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class PermissionFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View bgLinearLayout;
    private Button btnAccept;
    private ImageView btnBack;
    private final String cameraManifest;
    private final ActivityResultLauncher<String> cameraPermission;
    private ICallbackCheckPermission iCallbackCheckPermission;
    private TextView toolbarText;
    private TextView txtRequestAccess;
    private TextView txtSub;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/fragment/PermissionFragment$Companion;", "", "()V", "newInstance", "Lvn/ai/faceauth/sdk/presentation/presentation/fragment/PermissionFragment;", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PermissionFragment newInstance() {
            PermissionFragment permissionFragment = new PermissionFragment();
            permissionFragment.setArguments(new Bundle());
            return permissionFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/fragment/PermissionFragment$ICallbackCheckPermission;", "", "onCallbackPermission", "", "isGranted", "", "(Ljava/lang/Boolean;)V", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public interface ICallbackCheckPermission {
        void onCallbackPermission(Boolean isGranted);
    }

    public PermissionFragment() {
        super(R.layout.facesdk_fragment_permission);
        this.cameraManifest = btj.tzend(551);
        this.cameraPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.PermissionFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PermissionFragment.m2586cameraPermission$lambda2(PermissionFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cameraPermission$lambda-2, reason: not valid java name */
    public static final void m2586cameraPermission$lambda2(PermissionFragment permissionFragment, Boolean bool) {
        permissionFragment.handleCameraPermission(PrimitiveExtensionsKt.orFalse(bool), permissionFragment.getView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceCloseSDK() {
        Log.e(btj.tzend(552), btj.tzend(553));
        requireActivity().finish();
    }

    private final void handleCameraPermission(boolean granted, View parentView) {
        if (granted) {
            ICallbackCheckPermission iCallbackCheckPermission = this.iCallbackCheckPermission;
            if (iCallbackCheckPermission != null) {
                iCallbackCheckPermission.onCallbackPermission(Boolean.TRUE);
                return;
            }
            return;
        }
        ICallbackCheckPermission iCallbackCheckPermission2 = this.iCallbackCheckPermission;
        if (iCallbackCheckPermission2 != null) {
            iCallbackCheckPermission2.onCallbackPermission(Boolean.FALSE);
        }
        requireActivity().finish();
    }

    private final void initView(View view) {
        this.btnBack = (ImageView) view.findViewById(R.id.btnBack);
        this.toolbarText = (TextView) view.findViewById(R.id.toolbarText);
        this.txtSub = (TextView) view.findViewById(R.id.txtSub);
        this.txtRequestAccess = (TextView) view.findViewById(R.id.txtRequestAccess);
        this.btnAccept = (Button) view.findViewById(R.id.btnAccept);
        this.bgLinearLayout = view.findViewById(R.id.bgLinearLayout);
        TextView textView = this.txtRequestAccess;
        Button button = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(RtspMessageChannel.DEFAULT_RTSP_PORT));
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String textByKey = UtilsKt.getTextByKey(requireContext(), btj.tzend(555), AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release());
        Context context = getContext();
        textView.setText(String.format(textByKey, Arrays.copyOf(new Object[]{context != null ? PermissionFragmentKt.getAppName(context) : null}, 1)));
        ImageView imageView = this.btnBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(556));
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.PermissionFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PermissionFragment.m2587initView$lambda0(PermissionFragment.this, view2);
            }
        });
        Button button2 = this.btnAccept;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(557));
        } else {
            button = button2;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.PermissionFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PermissionFragment.m2588initView$lambda1(PermissionFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0, reason: not valid java name */
    public static final void m2587initView$lambda0(PermissionFragment permissionFragment, View view) {
        SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
        if (callbackResult$authenSDK_release != null) {
            SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 0, btj.tzend(558), null, null, null, null, 60, null);
        }
        permissionFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-1, reason: not valid java name */
    public static final void m2588initView$lambda1(PermissionFragment permissionFragment, View view) {
        permissionFragment.cameraPermission.launch(permissionFragment.cameraManifest);
    }

    @JvmStatic
    public static final PermissionFragment newInstance() {
        return INSTANCE.newInstance();
    }

    private final void setupConfig() {
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        SDKConfig sdkConfig$authenSDK_release = authenticationID.getSdkConfig$authenSDK_release();
        String closeColor = sdkConfig$authenSDK_release.getCloseColor();
        ImageView imageView = this.btnBack;
        String tzend = btj.tzend(559);
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            imageView = null;
        }
        imageView.setVisibility(sdkConfig$authenSDK_release.isCancelable() ? 0 : 4);
        ImageView imageView2 = this.btnBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            imageView2 = null;
        }
        imageView2.setColorFilter(Color.parseColor(closeColor), PorterDuff.Mode.SRC_IN);
        String textColor = sdkConfig$authenSDK_release.getTextColor();
        TextView textView = this.toolbarText;
        String tzend2 = btj.tzend(560);
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend2);
            textView = null;
        }
        textView.setTextColor(Color.parseColor(textColor));
        TextView textView2 = this.toolbarText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend2);
            textView2 = null;
        }
        UtilsKt.updateFont(textView2, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSizeTitle());
        TextView textView3 = this.toolbarText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend2);
            textView3 = null;
        }
        UtilsKt.setTextByKey(textView3, btj.tzend(561), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView4 = this.txtSub;
        String tzend3 = btj.tzend(562);
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
            textView4 = null;
        }
        textView4.setTextColor(Color.parseColor(textColor));
        TextView textView5 = this.txtSub;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
            textView5 = null;
        }
        UtilsKt.updateFont(textView5, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSize());
        TextView textView6 = this.txtSub;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
            textView6 = null;
        }
        UtilsKt.setTextByKey(textView6, btj.tzend(563), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView7 = this.txtRequestAccess;
        String tzend4 = btj.tzend(564);
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend4);
            textView7 = null;
        }
        textView7.setTextColor(Color.parseColor(textColor));
        TextView textView8 = this.txtRequestAccess;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend4);
            textView8 = null;
        }
        UtilsKt.updateFont(textView8, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSize());
        TextView textView9 = this.txtRequestAccess;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend4);
            textView9 = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String textByKey = UtilsKt.getTextByKey(requireContext(), btj.tzend(565), authenticationID.getJsonLanguage$authenSDK_release());
        Context context = getContext();
        textView9.setText(String.format(textByKey, Arrays.copyOf(new Object[]{context != null ? PermissionFragmentKt.getAppName(context) : null}, 1)));
        String obj = EnumPosition.LEFT.toString();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        if (Intrinsics.areEqual(obj, EnumPosition.RIGHT.toString())) {
            layoutParams.addRule(21);
            ImageView imageView3 = this.btnBack;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                imageView3 = null;
            }
            imageView3.setLayoutParams(layoutParams);
        }
        int parseColor = Color.parseColor(sdkConfig$authenSDK_release.getPrimaryColor());
        Button button = this.btnAccept;
        String tzend5 = btj.tzend(566);
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend5);
            button = null;
        }
        ImageExtensionsKt.setColorFilter(parseColor, button);
        String backgroundColor = sdkConfig$authenSDK_release.getBackgroundColor();
        String textButtonColor = sdkConfig$authenSDK_release.getTextButtonColor();
        Button button2 = this.btnAccept;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend5);
            button2 = null;
        }
        button2.setTextColor(Color.parseColor(textButtonColor));
        Button button3 = this.btnAccept;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend5);
            button3 = null;
        }
        UtilsKt.updateFont(button3, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSizeButton());
        Button button4 = this.btnAccept;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend5);
            button4 = null;
        }
        UtilsKt.setTextByKey(button4, btj.tzend(567), authenticationID.getJsonLanguage$authenSDK_release());
        View view2 = this.bgLinearLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(568));
        } else {
            view = view2;
        }
        view.setBackgroundColor(Color.parseColor(backgroundColor));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iCallbackCheckPermission = (ICallbackCheckPermission) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.facesdk_fragment_permission, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setupConfig();
        setupActionFaceSDK();
    }

    public final void setCallBackPermission(ICallbackCheckPermission iCallback) {
        this.iCallbackCheckPermission = iCallback;
    }

    public final void setupActionFaceSDK() {
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        authenticationID.setCloseSDK$authenSDK_release(new Function0<Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.PermissionFragment$setupActionFaceSDK$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PermissionFragment.this.forceCloseSDK();
            }
        });
        authenticationID.setTimeoutSDK$authenSDK_release(new Function0<Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.PermissionFragment$setupActionFaceSDK$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        });
        authenticationID.resetTimeOut$authenSDK_release();
    }

    public final void timeoutSDK() {
        Log.e(btj.tzend(569), btj.tzend(570));
        SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
        if (callbackResult$authenSDK_release != null) {
            SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 307, btj.tzend(571), null, null, null, null, 60, null);
        }
        requireActivity().finish();
    }
}
