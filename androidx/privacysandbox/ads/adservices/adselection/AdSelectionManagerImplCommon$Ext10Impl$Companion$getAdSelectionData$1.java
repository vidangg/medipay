package androidx.privacysandbox.ads.adservices.adselection;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdSelectionManagerImplCommon.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion", f = "AdSelectionManagerImplCommon.kt", i = {0, 0}, l = {231}, m = "getAdSelectionData", n = {"adSelectionManager", "getAdSelectionDataRequest"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManagerImplCommon.Ext10Impl.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1(AdSelectionManagerImplCommon.Ext10Impl.Companion companion, Continuation<? super AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAdSelectionData(null, null, this);
    }
}
