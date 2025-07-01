package vn.ai.faceauth.sdk.domain.model;

import kotlin.Metadata;
import paua.btj;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lvn/ai/faceauth/sdk/domain/model/StepLivenessDomain;", "", "", "textValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getTextValue", "()Ljava/lang/String;", "STEP_BLINK", "STEP_FIRST_CHECK", "STEP_HEAD_FRONTAL", "STEP_LUMINOSITY", "STEP_N0_SMILE", "STEP_ZOOM_IN", "STEP_ZOOM_OUT", "authenSDK_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public enum StepLivenessDomain {
    STEP_LUMINOSITY(btj.tzend(224)),
    STEP_N0_SMILE(btj.tzend(226)),
    STEP_HEAD_FRONTAL(btj.tzend(228)),
    STEP_FIRST_CHECK(btj.tzend(230)),
    STEP_BLINK(btj.tzend(232)),
    STEP_ZOOM_IN(btj.tzend(234)),
    STEP_ZOOM_OUT(btj.tzend(236));

    private final String textValue;

    StepLivenessDomain(String str) {
        this.textValue = str;
    }

    public final String getTextValue() {
        return this.textValue;
    }
}
