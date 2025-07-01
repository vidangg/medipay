package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;

    public static <V> ListenableFutureTask<V> create(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    public static <V> ListenableFutureTask<V> create(Runnable runnable, @ParametricNullness V result) {
        return new ListenableFutureTask<>(runnable, result);
    }

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
        this.executionList = new ExecutionList();
    }

    ListenableFutureTask(Runnable runnable, @ParametricNullness V result) {
        super(runnable, result);
        this.executionList = new ExecutionList();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor exec) {
        this.executionList.add(listener, exec);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    @ParametricNullness
    public V get(long j, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (nanos <= 2147483647999999999L) {
            return (V) super.get(j, timeUnit);
        }
        return (V) super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.executionList.execute();
    }
}
