package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    public abstract ListenableFuture<? extends V> delegate();

    protected ForwardingListenableFuture() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor exec) {
        delegate().addListener(listener, exec);
    }

    /* loaded from: classes4.dex */
    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        private final ListenableFuture<V> delegate;

        /* JADX INFO: Access modifiers changed from: protected */
        public SimpleForwardingListenableFuture(ListenableFuture<V> delegate) {
            this.delegate = (ListenableFuture) Preconditions.checkNotNull(delegate);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public final ListenableFuture<V> delegate() {
            return this.delegate;
        }
    }
}
