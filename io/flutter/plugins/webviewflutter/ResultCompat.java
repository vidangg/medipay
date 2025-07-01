package io.flutter.plugins.webviewflutter;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: ResultCompat.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0012B\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000f\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lio/flutter/plugins/webviewflutter/ResultCompat;", ExifInterface.GPS_DIRECTION_TRUE, "", Constant.PARAM_RESULT, "Lkotlin/Result;", "(Ljava/lang/Object;)V", "exception", "", "isFailure", "", "()Z", "isSuccess", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "value", "exceptionOrNull", "getOrNull", "Companion", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ResultCompat<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Throwable exception;
    private final boolean isFailure;
    private final boolean isSuccess;
    private final Object result;
    private final T value;

    @JvmStatic
    public static final <T> Function1<Result<? extends T>, Unit> asCompatCallback(Function1<? super ResultCompat<T>, Unit> function1) {
        return INSTANCE.asCompatCallback(function1);
    }

    @JvmStatic
    public static final <T> void success(T t, Object obj) {
        INSTANCE.success(t, obj);
    }

    public ResultCompat(Object obj) {
        this.result = obj;
        this.value = Result.m950isFailureimpl(obj) ? null : (T) obj;
        this.exception = Result.m947exceptionOrNullimpl(obj);
        this.isSuccess = Result.m951isSuccessimpl(obj);
        this.isFailure = Result.m950isFailureimpl(obj);
    }

    /* renamed from: getResult-d1pmJ48, reason: not valid java name and from getter */
    public final Object getResult() {
        return this.result;
    }

    /* renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: isFailure, reason: from getter */
    public final boolean getIsFailure() {
        return this.isFailure;
    }

    /* compiled from: ResultCompat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004\"\u0004\b\u0001\u0010\u00062\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\u00070\u0004H\u0007ø\u0001\u0000J#\u0010\n\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u000b\u001a\u0002H\u00062\u0006\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lio/flutter/plugins/webviewflutter/ResultCompat$Companion;", "", "()V", "asCompatCallback", "Lkotlin/Function1;", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "", Constant.PARAM_RESULT, "Lio/flutter/plugins/webviewflutter/ResultCompat;", FirebaseAnalytics.Param.SUCCESS, "value", "callback", "(Ljava/lang/Object;Ljava/lang/Object;)V", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> void success(T value, Object callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(callback, 1);
            Result.Companion companion = Result.INSTANCE;
            function1.invoke(Result.m943boximpl(Result.m944constructorimpl(value)));
        }

        @JvmStatic
        public final <T> Function1<Result<? extends T>, Unit> asCompatCallback(final Function1<? super ResultCompat<T>, Unit> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new Function1<Result<? extends T>, Unit>() { // from class: io.flutter.plugins.webviewflutter.ResultCompat$Companion$asCompatCallback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2(((Result) obj).getValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    result.invoke(new ResultCompat<>(obj));
                }
            };
        }
    }

    public final T getOrNull() {
        return this.value;
    }

    /* renamed from: exceptionOrNull, reason: from getter */
    public final Throwable getException() {
        return this.exception;
    }
}
