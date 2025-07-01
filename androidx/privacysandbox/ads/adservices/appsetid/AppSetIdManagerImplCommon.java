package androidx.privacysandbox.ads.adservices.appsetid;

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

/* compiled from: AppSetIdManagerImplCommon.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u0006H\u0097@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager;", "mAppSetIdManager", "Landroid/adservices/appsetid/AppSetIdManager;", "(Landroid/adservices/appsetid/AppSetIdManager;)V", "convertResponse", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "response", "Landroid/adservices/appsetid/AppSetId;", "getAppSetId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppSetIdAsyncInternal", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public class AppSetIdManagerImplCommon extends AppSetIdManager {
    private final android.adservices.appsetid.AppSetIdManager mAppSetIdManager;

    @Override // androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager
    public Object getAppSetId(Continuation<? super AppSetId> continuation) {
        return getAppSetId$suspendImpl(this, continuation);
    }

    public AppSetIdManagerImplCommon(android.adservices.appsetid.AppSetIdManager mAppSetIdManager) {
        Intrinsics.checkNotNullParameter(mAppSetIdManager, "mAppSetIdManager");
        this.mAppSetIdManager = mAppSetIdManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object getAppSetId$suspendImpl(AppSetIdManagerImplCommon appSetIdManagerImplCommon, Continuation<? super AppSetId> continuation) {
        AppSetIdManagerImplCommon$getAppSetId$1 appSetIdManagerImplCommon$getAppSetId$1;
        int i;
        if (continuation instanceof AppSetIdManagerImplCommon$getAppSetId$1) {
            appSetIdManagerImplCommon$getAppSetId$1 = (AppSetIdManagerImplCommon$getAppSetId$1) continuation;
            if ((appSetIdManagerImplCommon$getAppSetId$1.label & Integer.MIN_VALUE) != 0) {
                appSetIdManagerImplCommon$getAppSetId$1.label -= Integer.MIN_VALUE;
                Object obj = appSetIdManagerImplCommon$getAppSetId$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appSetIdManagerImplCommon$getAppSetId$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    appSetIdManagerImplCommon$getAppSetId$1.L$0 = appSetIdManagerImplCommon;
                    appSetIdManagerImplCommon$getAppSetId$1.label = 1;
                    obj = appSetIdManagerImplCommon.getAppSetIdAsyncInternal(appSetIdManagerImplCommon$getAppSetId$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    appSetIdManagerImplCommon = (AppSetIdManagerImplCommon) appSetIdManagerImplCommon$getAppSetId$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return appSetIdManagerImplCommon.convertResponse(AdFilters$$ExternalSyntheticApiModelOutline0.m561m(obj));
            }
        }
        appSetIdManagerImplCommon$getAppSetId$1 = new AppSetIdManagerImplCommon$getAppSetId$1(appSetIdManagerImplCommon, continuation);
        Object obj2 = appSetIdManagerImplCommon$getAppSetId$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appSetIdManagerImplCommon$getAppSetId$1.label;
        if (i != 0) {
        }
        return appSetIdManagerImplCommon.convertResponse(AdFilters$$ExternalSyntheticApiModelOutline0.m561m(obj2));
    }

    private final AppSetId convertResponse(android.adservices.appsetid.AppSetId response) {
        int scope;
        String id;
        String id2;
        scope = response.getScope();
        if (scope == 1) {
            id2 = response.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "response.id");
            return new AppSetId(id2, 1);
        }
        id = response.getId();
        Intrinsics.checkNotNullExpressionValue(id, "response.id");
        return new AppSetId(id, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAppSetIdAsyncInternal(Continuation<? super android.adservices.appsetid.AppSetId> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.mAppSetIdManager.getAppSetId(new DashDownloader$$ExternalSyntheticLambda0(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
