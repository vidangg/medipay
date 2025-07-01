package androidx.webkit.internal;

import androidx.webkit.JavaScriptReplyProxy;
import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class JavaScriptReplyProxyImpl extends JavaScriptReplyProxy {
    private final JsReplyProxyBoundaryInterface mBoundaryInterface;

    public JavaScriptReplyProxyImpl(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.mBoundaryInterface = jsReplyProxyBoundaryInterface;
    }

    public static JavaScriptReplyProxyImpl forInvocationHandler(InvocationHandler invocationHandler) {
        final JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (JavaScriptReplyProxyImpl) jsReplyProxyBoundaryInterface.getOrCreatePeer(new Callable() { // from class: androidx.webkit.internal.JavaScriptReplyProxyImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JavaScriptReplyProxyImpl.lambda$forInvocationHandler$0(JsReplyProxyBoundaryInterface.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$forInvocationHandler$0(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) throws Exception {
        return new JavaScriptReplyProxyImpl(jsReplyProxyBoundaryInterface);
    }

    @Override // androidx.webkit.JavaScriptReplyProxy
    public void postMessage(String str) {
        if (WebViewFeatureInternal.WEB_MESSAGE_LISTENER.isSupportedByWebView()) {
            this.mBoundaryInterface.postMessage(str);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.JavaScriptReplyProxy
    public void postMessage(byte[] bArr) {
        Objects.requireNonNull(bArr, "ArrayBuffer must be non-null");
        if (WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER.isSupportedByWebView()) {
            this.mBoundaryInterface.postMessageWithPayload(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessagePayloadAdapter(bArr)));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
