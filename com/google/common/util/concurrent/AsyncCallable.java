package com.google.common.util.concurrent;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
