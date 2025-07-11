package kotlinx.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {956, 958}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes4.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Job> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0070 -> B:6:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0083 -> B:6:0x0086). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NodeList list;
        SequenceScope sequenceScope;
        LockFreeLinkedListHead lockFreeLinkedListHead;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                this.label = 1;
                if (sequenceScope2.yield(((ChildHandleNode) state$kotlinx_coroutines_core).childJob, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                NodeList nodeList = list;
                Object next = nodeList.getNext();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) next;
                sequenceScope = sequenceScope2;
                lockFreeLinkedListHead = nodeList;
                lockFreeLinkedListNode = lockFreeLinkedListNode2;
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) this.L$2;
            lockFreeLinkedListHead = (LockFreeLinkedListHead) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    ChildJob childJob = ((ChildHandleNode) lockFreeLinkedListNode).childJob;
                    this.L$0 = sequenceScope;
                    this.L$1 = lockFreeLinkedListHead;
                    this.L$2 = lockFreeLinkedListNode;
                    this.label = 2;
                    if (sequenceScope.yield(childJob, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                }
            }
        }
        return Unit.INSTANCE;
    }
}
