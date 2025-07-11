package androidx.transition;

import android.view.View;

/* loaded from: classes3.dex */
class ViewUtilsApi19 extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(View view, float f) {
        if (sTryHiddenTransitionAlpha) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f);
    }

    @Override // androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(View view) {
        float transitionAlpha;
        if (sTryHiddenTransitionAlpha) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }
}
