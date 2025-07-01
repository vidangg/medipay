package vn.ai.faceauth.sdk.presentation.presentation.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import paua.btj;
import vn.ai.faceauth.sdk.R;
import vn.ai.faceauth.sdk.core.extensions.ImageExtensionsKt;
import vn.ai.faceauth.sdk.presentation.domain.configs.SDKConfig;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;
import vn.ai.faceauth.sdk.presentation.navigation.SDKCallback;
import vn.ai.faceauth.sdk.presentation.presentation.utils.UtilsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\u000fJ\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u0006\u0010 \u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/fragment/InstructionFragment;", "Landroidx/fragment/app/Fragment;", "()V", "btnAccept", "Landroid/widget/Button;", "iCallbackAccept", "Lvn/ai/faceauth/sdk/presentation/presentation/fragment/InstructionFragment$ICallbackAccept;", "textInstruction", "Landroid/widget/TextView;", "textInstruction1", "textInstruction2", "textInstruction3", "textInstruction4", "toolbarText", "forceCloseSDK", "", "initView", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupActionFaceSDK", "setupConfig", "timeoutSDK", "Companion", "ICallbackAccept", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class InstructionFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Button btnAccept;
    private ICallbackAccept iCallbackAccept;
    private TextView textInstruction;
    private TextView textInstruction1;
    private TextView textInstruction2;
    private TextView textInstruction3;
    private TextView textInstruction4;
    private TextView toolbarText;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/fragment/InstructionFragment$Companion;", "", "()V", "newInstance", "Lvn/ai/faceauth/sdk/presentation/presentation/fragment/InstructionFragment;", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final InstructionFragment newInstance() {
            InstructionFragment instructionFragment = new InstructionFragment();
            instructionFragment.setArguments(new Bundle());
            return instructionFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/fragment/InstructionFragment$ICallbackAccept;", "", "onCallback", "", "isGranted", "", "(Ljava/lang/Boolean;)V", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public interface ICallbackAccept {
        void onCallback(Boolean isGranted);
    }

    public InstructionFragment() {
        super(R.layout.facesdk_fragment_instruction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceCloseSDK() {
        Log.e(btj.tzend(376), btj.tzend(377));
        requireActivity().finish();
    }

    private final void initView() {
        Button button = this.btnAccept;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(378));
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.InstructionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstructionFragment.m2585initView$lambda0(InstructionFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0, reason: not valid java name */
    public static final void m2585initView$lambda0(InstructionFragment instructionFragment, View view) {
        ICallbackAccept iCallbackAccept = instructionFragment.iCallbackAccept;
        if (iCallbackAccept != null) {
            iCallbackAccept.onCallback(Boolean.TRUE);
        }
    }

    @JvmStatic
    public static final InstructionFragment newInstance() {
        return INSTANCE.newInstance();
    }

    private final void setupConfig() {
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        SDKConfig sdkConfig$authenSDK_release = authenticationID.getSdkConfig$authenSDK_release();
        sdkConfig$authenSDK_release.getTextColor();
        String primaryColor = sdkConfig$authenSDK_release.getPrimaryColor();
        TextView textView = (TextView) requireView().findViewById(R.id.toolbarText);
        this.toolbarText = textView;
        String tzend = btj.tzend(379);
        Button button = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            textView = null;
        }
        UtilsKt.updateFont(textView, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSizeTitle());
        TextView textView2 = this.toolbarText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            textView2 = null;
        }
        UtilsKt.setTextByKey(textView2, btj.tzend(380), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView3 = (TextView) requireView().findViewById(R.id.textInstruction);
        this.textInstruction = textView3;
        String tzend2 = btj.tzend(381);
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend2);
            textView3 = null;
        }
        UtilsKt.updateFont(textView3, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSize());
        TextView textView4 = this.textInstruction;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend2);
            textView4 = null;
        }
        UtilsKt.setTextByKey(textView4, btj.tzend(382), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView5 = (TextView) requireView().findViewById(R.id.textInstruction1);
        this.textInstruction1 = textView5;
        String tzend3 = btj.tzend(383);
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
            textView5 = null;
        }
        UtilsKt.updateFont(textView5, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSize());
        TextView textView6 = this.textInstruction1;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
            textView6 = null;
        }
        UtilsKt.setTextByKey(textView6, btj.tzend(RendererCapabilities.DECODER_SUPPORT_MASK), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView7 = (TextView) requireView().findViewById(R.id.textInstruction2);
        this.textInstruction2 = textView7;
        String tzend4 = btj.tzend(385);
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend4);
            textView7 = null;
        }
        UtilsKt.updateFont(textView7, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSize());
        TextView textView8 = this.textInstruction2;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend4);
            textView8 = null;
        }
        UtilsKt.setTextByKey(textView8, btj.tzend(386), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView9 = (TextView) requireView().findViewById(R.id.textInstruction3);
        this.textInstruction3 = textView9;
        String tzend5 = btj.tzend(387);
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend5);
            textView9 = null;
        }
        UtilsKt.updateFont(textView9, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSize());
        TextView textView10 = this.textInstruction3;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend5);
            textView10 = null;
        }
        UtilsKt.setTextByKey(textView10, btj.tzend(388), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView11 = (TextView) requireView().findViewById(R.id.textInstruction4);
        this.textInstruction4 = textView11;
        String tzend6 = btj.tzend(389);
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend6);
            textView11 = null;
        }
        UtilsKt.updateFont(textView11, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSize());
        TextView textView12 = this.textInstruction4;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend6);
            textView12 = null;
        }
        UtilsKt.setTextByKey(textView12, btj.tzend(390), authenticationID.getJsonLanguage$authenSDK_release());
        this.btnAccept = (Button) requireView().findViewById(R.id.btnAccept);
        int parseColor = Color.parseColor(primaryColor);
        Button button2 = this.btnAccept;
        String tzend7 = btj.tzend(391);
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend7);
            button2 = null;
        }
        ImageExtensionsKt.setColorFilter(parseColor, button2);
        Button button3 = this.btnAccept;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend7);
            button3 = null;
        }
        UtilsKt.updateFont(button3, sdkConfig$authenSDK_release.getFontName(), sdkConfig$authenSDK_release.getTextSizeButton());
        Button button4 = this.btnAccept;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend7);
            button4 = null;
        }
        UtilsKt.setTextByKey(button4, btj.tzend(392), authenticationID.getJsonLanguage$authenSDK_release());
        Button button5 = this.btnAccept;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend7);
        } else {
            button = button5;
        }
        button.setTextColor(Color.parseColor(sdkConfig$authenSDK_release.getTextButtonColor()));
        requireView().setBackgroundColor(Color.parseColor(sdkConfig$authenSDK_release.getBackgroundColor()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iCallbackAccept = (ICallbackAccept) context;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.facesdk_fragment_instruction, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupConfig();
        initView();
        setupActionFaceSDK();
    }

    public final void setupActionFaceSDK() {
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        authenticationID.setCloseSDK$authenSDK_release(new Function0<Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.InstructionFragment$setupActionFaceSDK$1
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
                InstructionFragment.this.forceCloseSDK();
            }
        });
        authenticationID.setTimeoutSDK$authenSDK_release(new Function0<Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.InstructionFragment$setupActionFaceSDK$2
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
        Log.e(btj.tzend(393), btj.tzend(394));
        SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
        if (callbackResult$authenSDK_release != null) {
            SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 307, btj.tzend(395), null, null, null, null, 60, null);
        }
        requireActivity().finish();
    }
}
