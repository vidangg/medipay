package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DirectExecutor implements Executor {
    private static volatile DirectExecutor sDirectExecutor;

    DirectExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor getInstance() {
        if (sDirectExecutor != null) {
            return sDirectExecutor;
        }
        synchronized (DirectExecutor.class) {
            if (sDirectExecutor == null) {
                sDirectExecutor = new DirectExecutor();
            }
        }
        return sDirectExecutor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
