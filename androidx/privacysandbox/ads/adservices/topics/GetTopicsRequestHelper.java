package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.CanvasUtils$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetTopicsRequestHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequestHelper;", "", "()V", "convertRequestWithRecordObservation", "Landroid/adservices/topics/GetTopicsRequest;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "convertRequestWithRecordObservation$ads_adservices_release", "convertRequestWithoutRecordObservation", "convertRequestWithoutRecordObservation$ads_adservices_release", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class GetTopicsRequestHelper {
    public static final GetTopicsRequestHelper INSTANCE = new GetTopicsRequestHelper();

    private GetTopicsRequestHelper() {
    }

    public final android.adservices.topics.GetTopicsRequest convertRequestWithRecordObservation$ads_adservices_release(GetTopicsRequest request) {
        GetTopicsRequest.Builder adsSdkName;
        GetTopicsRequest.Builder shouldRecordObservation;
        android.adservices.topics.GetTopicsRequest build;
        Intrinsics.checkNotNullParameter(request, "request");
        adsSdkName = CanvasUtils$$ExternalSyntheticApiModelOutline0.m591m().setAdsSdkName(request.getAdsSdkName());
        shouldRecordObservation = adsSdkName.setShouldRecordObservation(request.getShouldRecordObservation());
        build = shouldRecordObservation.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ion)\n            .build()");
        return build;
    }

    public final android.adservices.topics.GetTopicsRequest convertRequestWithoutRecordObservation$ads_adservices_release(GetTopicsRequest request) {
        GetTopicsRequest.Builder adsSdkName;
        android.adservices.topics.GetTopicsRequest build;
        Intrinsics.checkNotNullParameter(request, "request");
        adsSdkName = CanvasUtils$$ExternalSyntheticApiModelOutline0.m591m().setAdsSdkName(request.getAdsSdkName());
        build = adsSdkName.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ame)\n            .build()");
        return build;
    }
}
