package androidx.privacysandbox.ads.adservices.topics;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopicsManagerApi31Ext11Impl.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0010¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0011¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/TopicsManagerApi31Ext11Impl;", "Landroidx/privacysandbox/ads/adservices/topics/TopicsManagerImplCommon;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "convertRequest", "Landroid/adservices/topics/GetTopicsRequest;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "convertRequest$ads_adservices_release", "convertResponse", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "response", "Landroid/adservices/topics/GetTopicsResponse;", "convertResponse$ads_adservices_release", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class TopicsManagerApi31Ext11Impl extends TopicsManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TopicsManagerApi31Ext11Impl(Context context) {
        super(r2);
        android.adservices.topics.TopicsManager topicsManager;
        Intrinsics.checkNotNullParameter(context, "context");
        topicsManager = android.adservices.topics.TopicsManager.get(context);
        Intrinsics.checkNotNullExpressionValue(topicsManager, "get(context)");
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public android.adservices.topics.GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return GetTopicsRequestHelper.INSTANCE.convertRequestWithRecordObservation$ads_adservices_release(request);
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse convertResponse$ads_adservices_release(android.adservices.topics.GetTopicsResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return GetTopicsResponseHelper.INSTANCE.convertResponseWithEncryptedTopics$ads_adservices_release(response);
    }
}
