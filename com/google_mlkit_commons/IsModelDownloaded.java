package com.google_mlkit_commons;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;

/* compiled from: GenericModelManager.java */
/* loaded from: classes4.dex */
class IsModelDownloaded implements Callable<Boolean> {
    final Task<Boolean> booleanTask;

    public IsModelDownloaded(Task<Boolean> task) {
        this.booleanTask = task;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        return (Boolean) Tasks.await(this.booleanTask);
    }
}
