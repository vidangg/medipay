package androidx.window.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInfoTracker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Landroidx/window/layout/EmptyDecorator;", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "()V", "decorate", "Landroidx/window/layout/WindowInfoTracker;", "tracker", "window_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class EmptyDecorator implements WindowInfoTrackerDecorator {
    public static final EmptyDecorator INSTANCE = new EmptyDecorator();

    @Override // androidx.window.layout.WindowInfoTrackerDecorator
    public WindowInfoTracker decorate(WindowInfoTracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        return tracker;
    }

    private EmptyDecorator() {
    }
}
