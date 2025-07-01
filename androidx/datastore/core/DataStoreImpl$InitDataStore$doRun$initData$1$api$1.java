package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JA\u0010\u0002\u001a\u00028\u000021\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004H\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"androidx/datastore/core/DataStoreImpl$InitDataStore$doRun$initData$1$api$1", "Landroidx/datastore/core/InitializerApi;", "updateData", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ Ref.ObjectRef<T> $currentData;
    final /* synthetic */ Ref.BooleanRef $initializationComplete;
    final /* synthetic */ Mutex $updateLock;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataStoreImpl$InitDataStore$doRun$initData$1$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef<T> objectRef, DataStoreImpl<T> dataStoreImpl) {
        this.$updateLock = mutex;
        this.$initializationComplete = booleanRef;
        this.$currentData = objectRef;
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #1 {all -> 0x0057, blocks: (B:27:0x0053, B:28:0x00b1, B:30:0x00b9), top: B:26:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099 A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #0 {all -> 0x00e3, blocks: (B:40:0x0094, B:42:0x0099, B:46:0x00d7, B:47:0x00e2), top: B:39:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7 A[Catch: all -> 0x00e3, TRY_ENTER, TryCatch #0 {all -> 0x00e3, blocks: (B:40:0x0094, B:42:0x0099, B:46:0x00d7, B:47:0x00e2), top: B:39:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // androidx.datastore.core.InitializerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1;
        int i;
        Mutex mutex;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef<T> objectRef;
        DataStoreImpl dataStoreImpl;
        Mutex mutex2;
        Mutex mutex3;
        DataStoreImpl dataStoreImpl2;
        T t;
        Ref.ObjectRef<T> objectRef2;
        try {
            if (continuation instanceof DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) {
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) continuation;
                if ((dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label -= Integer.MIN_VALUE;
                    Object obj = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.$updateLock;
                        booleanRef = this.$initializationComplete;
                        objectRef = this.$currentData;
                        dataStoreImpl = this.this$0;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = function2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = mutex;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = booleanRef;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = objectRef;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = dataStoreImpl;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 1;
                        if (mutex.lock(null, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                t = (T) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                                objectRef2 = (Ref.ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                                mutex2 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    objectRef2.element = t;
                                    objectRef = objectRef2;
                                    T t2 = objectRef.element;
                                    mutex2.unlock(null);
                                    return t2;
                                } catch (Throwable th) {
                                    th = th;
                                    mutex2.unlock(null);
                                    throw th;
                                }
                            }
                            DataStoreImpl dataStoreImpl3 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                            objectRef = (Ref.ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                            mutex3 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                dataStoreImpl2 = dataStoreImpl3;
                                if (Intrinsics.areEqual(obj, objectRef.element)) {
                                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = mutex3;
                                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = objectRef;
                                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = obj;
                                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 3;
                                    if (dataStoreImpl2.writeData$datastore_core_release(obj, false, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    t = (T) obj;
                                    objectRef2 = objectRef;
                                    mutex2 = mutex3;
                                    objectRef2.element = t;
                                    objectRef = objectRef2;
                                    T t22 = objectRef.element;
                                    mutex2.unlock(null);
                                    return t22;
                                }
                                mutex2 = mutex3;
                                T t222 = objectRef.element;
                                mutex2.unlock(null);
                                return t222;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2 = mutex3;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }
                        DataStoreImpl dataStoreImpl4 = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4;
                        objectRef = (Ref.ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3;
                        booleanRef = (Ref.BooleanRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                        Mutex mutex4 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                        Function2<? super T, ? super Continuation<? super T>, ? extends Object> function22 = (Function2) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                        dataStoreImpl = dataStoreImpl4;
                        function2 = function22;
                    }
                    if (true ^ booleanRef.element) {
                        throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.".toString());
                    }
                    T t3 = objectRef.element;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = mutex;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = objectRef;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = dataStoreImpl;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = null;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = null;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 2;
                    Object invoke = function2.invoke(t3, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex3 = mutex;
                    obj = invoke;
                    dataStoreImpl2 = dataStoreImpl;
                    if (Intrinsics.areEqual(obj, objectRef.element)) {
                    }
                }
            }
            if (true ^ booleanRef.element) {
            }
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(this, continuation);
        Object obj2 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
        if (i != 0) {
        }
    }
}
