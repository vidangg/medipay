package io.flutter.plugins.webviewflutter;

import android.view.View;

/* loaded from: classes4.dex */
public class ViewProxyApi extends PigeonApiView {
    public ViewProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiView
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiView
    public void scrollTo(View view, long j, long j2) {
        view.scrollTo((int) j, (int) j2);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiView
    public void scrollBy(View view, long j, long j2) {
        view.scrollBy((int) j, (int) j2);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiView
    public WebViewPoint getScrollPosition(View view) {
        return new WebViewPoint(view.getScrollX(), view.getScrollY());
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiView
    public void setVerticalScrollBarEnabled(View view, boolean z) {
        view.setVerticalScrollBarEnabled(z);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiView
    public void setHorizontalScrollBarEnabled(View view, boolean z) {
        view.setHorizontalScrollBarEnabled(z);
    }

    /* renamed from: io.flutter.plugins.webviewflutter.ViewProxyApi$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$webviewflutter$OverScrollMode;

        static {
            int[] iArr = new int[OverScrollMode.values().length];
            $SwitchMap$io$flutter$plugins$webviewflutter$OverScrollMode = iArr;
            try {
                iArr[OverScrollMode.ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$OverScrollMode[OverScrollMode.IF_CONTENT_SCROLLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$OverScrollMode[OverScrollMode.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$OverScrollMode[OverScrollMode.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiView
    public void setOverScrollMode(View view, OverScrollMode overScrollMode) {
        int i = AnonymousClass1.$SwitchMap$io$flutter$plugins$webviewflutter$OverScrollMode[overScrollMode.ordinal()];
        if (i == 1) {
            view.setOverScrollMode(0);
            return;
        }
        if (i == 2) {
            view.setOverScrollMode(1);
        } else if (i == 3) {
            view.setOverScrollMode(2);
        } else if (i == 4) {
            throw getPigeonRegistrar().createUnknownEnumException(OverScrollMode.UNKNOWN);
        }
    }
}
