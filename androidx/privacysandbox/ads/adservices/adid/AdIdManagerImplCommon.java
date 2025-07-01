package androidx.privacysandbox.ads.adservices.adid;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.OutcomeReceiverKt;
import androidx.media3.exoplayer.dash.offline.DashDownloader$$ExternalSyntheticLambda0;
import androidx.privacysandbox.ads.adservices.common.AdFilters$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: AdIdManagerImplCommon.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u0006H\u0097@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0083@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adid/AdIdManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/adid/AdIdManager;", "mAdIdManager", "Landroid/adservices/adid/AdIdManager;", "(Landroid/adservices/adid/AdIdManager;)V", "convertResponse", "Landroidx/privacysandbox/ads/adservices/adid/AdId;", "response", "Landroid/adservices/adid/AdId;", "getAdId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdIdAsyncInternal", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public class AdIdManagerImplCommon extends AdIdManager {
    private final android.adservices.adid.AdIdManager mAdIdManager;

    @Override // androidx.privacysandbox.ads.adservices.adid.AdIdManager
    public Object getAdId(Continuation<? super AdId> continuation) {
        return getAdId$suspendImpl(this, continuation);
    }

    public AdIdManagerImplCommon(android.adservices.adid.AdIdManager mAdIdManager) {
        Intrinsics.checkNotNullParameter(mAdIdManager, "mAdIdManager");
        this.mAdIdManager = mAdIdManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object getAdId$suspendImpl(AdIdManagerImplCommon adIdManagerImplCommon, Continuation<? super AdId> continuation) {
        AdIdManagerImplCommon$getAdId$1 adIdManagerImplCommon$getAdId$1;
        int i;
        if (continuation instanceof AdIdManagerImplCommon$getAdId$1) {
            adIdManagerImplCommon$getAdId$1 = (AdIdManagerImplCommon$getAdId$1) continuation;
            if ((adIdManagerImplCommon$getAdId$1.label & Integer.MIN_VALUE) != 0) {
                adIdManagerImplCommon$getAdId$1.label -= Integer.MIN_VALUE;
                Object obj = adIdManagerImplCommon$getAdId$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = adIdManagerImplCommon$getAdId$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    adIdManagerImplCommon$getAdId$1.L$0 = adIdManagerImplCommon;
                    adIdManagerImplCommon$getAdId$1.label = 1;
                    obj = adIdManagerImplCommon.getAdIdAsyncInternal(adIdManagerImplCommon$getAdId$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    adIdManagerImplCommon = (AdIdManagerImplCommon) adIdManagerImplCommon$getAdId$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return adIdManagerImplCommon.convertResponse(AdFilters$$ExternalSyntheticApiModelOutline0.m(obj));
            }
        }
        adIdManagerImplCommon$getAdId$1 = new AdIdManagerImplCommon$getAdId$1(adIdManagerImplCommon, continuation);
        Object obj2 = adIdManagerImplCommon$getAdId$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = adIdManagerImplCommon$getAdId$1.label;
        if (i != 0) {
        }
        return adIdManagerImplCommon.convertResponse(AdFilters$$ExternalSyntheticApiModelOutline0.m(obj2));
    }

    private final AdId convertResponse(android.adservices.adid.AdId response) {
        String adId;
        boolean isLimitAdTrackingEnabled;
        adId = response.getAdId();
        Intrinsics.checkNotNullExpressionValue(adId, "response.adId");
        isLimitAdTrackingEnabled = response.isLimitAdTrackingEnabled();
        return new AdId(adId, isLimitAdTrackingEnabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAdIdAsyncInternal(Continuation<? super android.adservices.adid.AdId> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.mAdIdManager.getAdId(new DashDownloader$$ExternalSyntheticLambda0(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
