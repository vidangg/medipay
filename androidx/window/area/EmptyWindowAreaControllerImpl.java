package androidx.window.area;

import android.app.Activity;
import android.os.Binder;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: EmptyWindowAreaControllerImpl.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Landroidx/window/area/EmptyWindowAreaControllerImpl;", "Landroidx/window/area/WindowAreaController;", "()V", "windowAreaInfos", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/area/WindowAreaInfo;", "getWindowAreaInfos", "()Lkotlinx/coroutines/flow/Flow;", "presentContentOnWindowArea", "", "token", "Landroid/os/Binder;", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "windowAreaPresentationSessionCallback", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "transferActivityToWindowArea", "windowAreaSessionCallback", "Landroidx/window/area/WindowAreaSessionCallback;", "window_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class EmptyWindowAreaControllerImpl implements WindowAreaController {
    @Override // androidx.window.area.WindowAreaController
    public Flow<List<WindowAreaInfo>> getWindowAreaInfos() {
        return FlowKt.flowOf(CollectionsKt.emptyList());
    }

    @Override // androidx.window.area.WindowAreaController
    public void transferActivityToWindowArea(Binder token, Activity activity, Executor executor, WindowAreaSessionCallback windowAreaSessionCallback) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(windowAreaSessionCallback, "windowAreaSessionCallback");
        windowAreaSessionCallback.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }

    @Override // androidx.window.area.WindowAreaController
    public void presentContentOnWindowArea(Binder token, Activity activity, Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(windowAreaPresentationSessionCallback, "windowAreaPresentationSessionCallback");
        windowAreaPresentationSessionCallback.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }
}
