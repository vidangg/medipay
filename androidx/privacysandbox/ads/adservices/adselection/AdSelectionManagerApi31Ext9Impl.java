package androidx.privacysandbox.ads.adservices.adselection;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdSelectionManagerApi31Ext9Impl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerApi31Ext9Impl;", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManagerImplCommon;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class AdSelectionManagerApi31Ext9Impl extends AdSelectionManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdSelectionManagerApi31Ext9Impl(Context context) {
        super(r2);
        android.adservices.adselection.AdSelectionManager adSelectionManager;
        Intrinsics.checkNotNullParameter(context, "context");
        adSelectionManager = android.adservices.adselection.AdSelectionManager.get(context);
        Intrinsics.checkNotNullExpressionValue(adSelectionManager, "get(context)");
    }
}
