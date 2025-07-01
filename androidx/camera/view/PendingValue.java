package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PendingValue<T> {
    private Pair<CallbackToFutureAdapter.Completer<Void>, T> mCompleterAndValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenableFuture<Void> setValue(final T t) {
        Threads.checkMainThread();
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.PendingValue$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return PendingValue.this.m296lambda$setValue$0$androidxcameraviewPendingValue(t, completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setValue$0$androidx-camera-view-PendingValue, reason: not valid java name */
    public /* synthetic */ Object m296lambda$setValue$0$androidxcameraviewPendingValue(Object obj, CallbackToFutureAdapter.Completer completer) throws Exception {
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = this.mCompleterAndValue;
        if (pair != null) {
            ((CallbackToFutureAdapter.Completer) Objects.requireNonNull(pair.first)).setCancelled();
        }
        this.mCompleterAndValue = new Pair<>(completer, obj);
        return "PendingValue " + obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void propagateIfHasValue(Function<T, ListenableFuture<Void>> function) {
        Threads.checkMainThread();
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = this.mCompleterAndValue;
        if (pair != null) {
            Futures.propagate(function.apply(pair.second), (CallbackToFutureAdapter.Completer) Objects.requireNonNull(this.mCompleterAndValue.first));
            this.mCompleterAndValue = null;
        }
    }
}
