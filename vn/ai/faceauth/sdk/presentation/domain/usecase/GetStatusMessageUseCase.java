package vn.ai.faceauth.sdk.presentation.domain.usecase;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import org.json.JSONObject;
import paua.btj;
import vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider;
import vn.ai.faceauth.sdk.domain.model.StateFaceWithOval;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;
import vn.ai.faceauth.sdk.presentation.presentation.utils.UtilsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/domain/usecase/GetStatusMessageUseCase;", "", "resourcesProvider", "Lvn/ai/faceauth/sdk/core/resourceprovider/ResourcesProvider;", "(Lvn/ai/faceauth/sdk/core/resourceprovider/ResourcesProvider;)V", "invoke", "", "stateFaceWithOval", "Lvn/ai/faceauth/sdk/domain/model/StateFaceWithOval;", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class GetStatusMessageUseCase {
    private final ResourcesProvider resourcesProvider;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateFaceWithOval.values().length];
            iArr[StateFaceWithOval.WITHIN.ordinal()] = 1;
            iArr[StateFaceWithOval.MOVE_AWAY.ordinal()] = 2;
            iArr[StateFaceWithOval.MOVE_CLOSER.ordinal()] = 3;
            iArr[StateFaceWithOval.NO_SMILE.ordinal()] = 4;
            iArr[StateFaceWithOval.FRAME_YOUR_FACE_IN_OVAL.ordinal()] = 5;
            iArr[StateFaceWithOval.EYES_CLOSED.ordinal()] = 6;
            iArr[StateFaceWithOval.KEEP_HOLD_ON.ordinal()] = 7;
            iArr[StateFaceWithOval.FACE_NOT_ALIGN.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GetStatusMessageUseCase(ResourcesProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    public final String invoke(StateFaceWithOval stateFaceWithOval) {
        Context context;
        JSONObject jsonLanguage$authenSDK_release;
        int i;
        switch (WhenMappings.$EnumSwitchMapping$0[stateFaceWithOval.ordinal()]) {
            case 1:
            case 7:
                context = this.resourcesProvider.getContext();
                jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
                i = 350;
                return UtilsKt.getTextByKey(context, btj.tzend(i), jsonLanguage$authenSDK_release);
            case 2:
                context = this.resourcesProvider.getContext();
                jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
                i = 349;
                return UtilsKt.getTextByKey(context, btj.tzend(i), jsonLanguage$authenSDK_release);
            case 3:
                context = this.resourcesProvider.getContext();
                jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
                i = 348;
                return UtilsKt.getTextByKey(context, btj.tzend(i), jsonLanguage$authenSDK_release);
            case 4:
                context = this.resourcesProvider.getContext();
                jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
                i = 347;
                return UtilsKt.getTextByKey(context, btj.tzend(i), jsonLanguage$authenSDK_release);
            case 5:
                context = this.resourcesProvider.getContext();
                jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
                i = 346;
                return UtilsKt.getTextByKey(context, btj.tzend(i), jsonLanguage$authenSDK_release);
            case 6:
                context = this.resourcesProvider.getContext();
                jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
                i = 345;
                return UtilsKt.getTextByKey(context, btj.tzend(i), jsonLanguage$authenSDK_release);
            case 8:
                context = this.resourcesProvider.getContext();
                jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
                i = 344;
                return UtilsKt.getTextByKey(context, btj.tzend(i), jsonLanguage$authenSDK_release);
            default:
                return String.valueOf(stateFaceWithOval);
        }
    }
}
