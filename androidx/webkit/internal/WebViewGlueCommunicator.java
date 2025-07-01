package androidx.webkit.internal;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class WebViewGlueCommunicator {
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_CLASS = "org.chromium.support_lib_glue.SupportLibReflectionUtil";
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_METHOD = "createWebViewProviderFactory";

    public static WebViewProviderFactory getFactory() {
        return LAZY_FACTORY_HOLDER.INSTANCE;
    }

    public static WebkitToCompatConverter getCompatConverter() {
        return LAZY_COMPAT_CONVERTER_HOLDER.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class LAZY_FACTORY_HOLDER {
        static final WebViewProviderFactory INSTANCE = WebViewGlueCommunicator.createGlueProviderFactory();

        private LAZY_FACTORY_HOLDER() {
        }
    }

    /* loaded from: classes3.dex */
    private static class LAZY_COMPAT_CONVERTER_HOLDER {
        static final WebkitToCompatConverter INSTANCE = new WebkitToCompatConverter(WebViewGlueCommunicator.getFactory().getWebkitToCompatConverter());

        private LAZY_COMPAT_CONVERTER_HOLDER() {
        }
    }

    private static InvocationHandler fetchGlueProviderFactoryImpl() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        return (InvocationHandler) Class.forName(GLUE_FACTORY_PROVIDER_FETCHER_CLASS, false, getWebViewClassLoader()).getDeclaredMethod(GLUE_FACTORY_PROVIDER_FETCHER_METHOD, null).invoke(null, null);
    }

    static WebViewProviderFactory createGlueProviderFactory() {
        try {
            return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, fetchGlueProviderFactoryImpl()));
        } catch (ClassNotFoundException unused) {
            return new IncompatibleApkWebViewProviderFactory();
        } catch (IllegalAccessException e) {
            e = e;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    public static ClassLoader getWebViewClassLoader() {
        return ApiHelperForP.getWebViewClassLoader();
    }

    private static Object getWebViewProviderFactory() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private WebViewGlueCommunicator() {
    }
}
