package kotlinx.coroutines.selects;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Select.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {TypedValues.TransitionType.TYPE_STAGGERED}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation<R> selectImplementation, Continuation<? super SelectImplementation$processResultAndInvokeBlockRecoveringException$1> continuation) {
        super(continuation);
        this.this$0 = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object processResultAndInvokeBlockRecoveringException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processResultAndInvokeBlockRecoveringException = this.this$0.processResultAndInvokeBlockRecoveringException(null, null, this);
        return processResultAndInvokeBlockRecoveringException;
    }
}
