package androidx.datastore.core.okio;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkioStorage.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", i = {0, 0, 0}, l = {113}, m = "readScope", n = {"this", "$this$use$iv", "lock"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes.dex */
public final class OkioStorageConnection$readScope$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkioStorageConnection<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioStorageConnection$readScope$1(OkioStorageConnection<T> okioStorageConnection, Continuation<? super OkioStorageConnection$readScope$1> continuation) {
        super(continuation);
        this.this$0 = okioStorageConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readScope(null, this);
    }
}
