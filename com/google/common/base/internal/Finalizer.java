package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";

    @CheckForNull
    private static final Constructor<Thread> bigThreadConstructor;

    @CheckForNull
    private static final Field inheritableThreadLocals;
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        Constructor<Thread> bigThreadConstructor2 = getBigThreadConstructor();
        bigThreadConstructor = bigThreadConstructor2;
        inheritableThreadLocals = bigThreadConstructor2 == null ? getInheritableThreadLocalsField() : null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(9:19|20|(1:7)|8|9|10|(1:12)|14|15)|5|(0)|8|9|10|(0)|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        com.google.common.base.internal.Finalizer.logger.log(java.util.logging.Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0052 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #1 {all -> 0x0056, blocks: (B:10:0x004e, B:12:0x0052), top: B:9:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void startFinalizer(Class<?> finalizableReferenceClass, ReferenceQueue<Object> queue, PhantomReference<Object> frqReference) {
        Thread newInstance;
        Field field;
        if (!finalizableReferenceClass.getName().equals(FINALIZABLE_REFERENCE)) {
            throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
        }
        Finalizer finalizer = new Finalizer(finalizableReferenceClass, queue, frqReference);
        String name = Finalizer.class.getName();
        Constructor<Thread> constructor = bigThreadConstructor;
        if (constructor != null) {
            try {
                newInstance = constructor.newInstance(null, finalizer, name, 0L, false);
            } catch (Throwable th) {
                logger.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th);
            }
            if (newInstance == null) {
                newInstance = new Thread(null, finalizer, name);
            }
            newInstance.setDaemon(true);
            field = inheritableThreadLocals;
            if (field != null) {
                field.set(newInstance, null);
            }
            newInstance.start();
        }
        newInstance = null;
        if (newInstance == null) {
        }
        newInstance.setDaemon(true);
        field = inheritableThreadLocals;
        if (field != null) {
        }
        newInstance.start();
    }

    private Finalizer(Class<?> finalizableReferenceClass, ReferenceQueue<Object> queue, PhantomReference<Object> frqReference) {
        this.queue = queue;
        this.finalizableReferenceClassReference = new WeakReference<>(finalizableReferenceClass);
        this.frqReference = frqReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (cleanUp(this.queue.remove())) {
        }
    }

    private boolean cleanUp(Reference<?> firstReference) {
        Reference<? extends Object> poll;
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        if (finalizeReferentMethod == null || !finalizeReference(firstReference, finalizeReferentMethod)) {
            return false;
        }
        do {
            poll = this.queue.poll();
            if (poll == null) {
                return true;
            }
        } while (finalizeReference(poll, finalizeReferentMethod));
        return false;
    }

    private boolean finalizeReference(Reference<?> reference, Method finalizeReferentMethod) {
        reference.clear();
        if (reference == this.frqReference) {
            return false;
        }
        try {
            finalizeReferentMethod.invoke(reference, null);
            return true;
        } catch (Throwable th) {
            logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            return true;
        }
    }

    @CheckForNull
    private Method getFinalizeReferentMethod() {
        Class<?> cls = this.finalizableReferenceClassReference.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", null);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @CheckForNull
    private static Field getInheritableThreadLocalsField() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    @CheckForNull
    private static Constructor<Thread> getBigThreadConstructor() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }
}
