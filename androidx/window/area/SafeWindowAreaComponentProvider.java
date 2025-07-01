package androidx.window.area;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.area.reflectionguard.WindowAreaComponentValidator;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.reflection.ReflectionUtils;
import androidx.window.reflection.WindowExtensionsConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafeWindowAreaComponentProvider.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0001H\u0002R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/area/SafeWindowAreaComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "extensionWindowAreaPresentationClass", "Ljava/lang/Class;", "getExtensionWindowAreaPresentationClass", "()Ljava/lang/Class;", "extensionWindowAreaStatusClass", "getExtensionWindowAreaStatusClass", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "getWindowAreaComponent", "()Landroidx/window/extensions/area/WindowAreaComponent;", "windowAreaComponentClass", "getWindowAreaComponentClass", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "isValidExtensionWindowPresentation", "", "isWindowAreaProviderValid", "window_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class SafeWindowAreaComponentProvider {
    private final ClassLoader loader;
    private final WindowExtensions windowExtensions;

    public SafeWindowAreaComponentProvider(ClassLoader loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.loader = loader;
        this.windowExtensions = new SafeWindowExtensionsProvider(loader).getWindowExtensions();
    }

    public final WindowAreaComponent getWindowAreaComponent() {
        try {
            WindowExtensions windowExtensions = this.windowExtensions;
            if (windowExtensions != null && isWindowAreaProviderValid(windowExtensions) && WindowAreaComponentValidator.INSTANCE.isWindowAreaComponentValid$window_release(getWindowAreaComponentClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel()) && WindowAreaComponentValidator.INSTANCE.isExtensionWindowAreaStatusValid$window_release(getExtensionWindowAreaStatusClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel()) && isValidExtensionWindowPresentation()) {
                return this.windowExtensions.getWindowAreaComponent();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean isWindowAreaProviderValid(final Object windowExtensions) {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getWindowAreaComponent is not valid", new Function0<Boolean>() { // from class: androidx.window.area.SafeWindowAreaComponentProvider$isWindowAreaProviderValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                Class<?> windowAreaComponentClass;
                Method getWindowAreaComponentMethod = windowExtensions.getClass().getMethod("getWindowAreaComponent", null);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getWindowAreaComponentMethod, "getWindowAreaComponentMethod");
                if (reflectionUtils.isPublic$window_release(getWindowAreaComponentMethod)) {
                    ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
                    windowAreaComponentClass = this.getWindowAreaComponentClass();
                    if (reflectionUtils2.doesReturn$window_release(getWindowAreaComponentMethod, windowAreaComponentClass)) {
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isValidExtensionWindowPresentation() {
        return ExtensionsUtil.INSTANCE.getSafeVendorApiLevel() <= 2 || WindowAreaComponentValidator.INSTANCE.isExtensionWindowAreaPresentationValid$window_release(getExtensionWindowAreaPresentationClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getWindowAreaComponentClass() {
        Class<?> loadClass = this.loader.loadClass(WindowExtensionsConstants.WINDOW_AREA_COMPONENT_CLASS);
        Intrinsics.checkNotNullExpressionValue(loadClass, "loader.loadClass(WindowE…DOW_AREA_COMPONENT_CLASS)");
        return loadClass;
    }

    private final Class<?> getExtensionWindowAreaStatusClass() {
        Class<?> loadClass = this.loader.loadClass(WindowExtensionsConstants.EXTENSION_WINDOW_AREA_STATUS_CLASS);
        Intrinsics.checkNotNullExpressionValue(loadClass, "loader.loadClass(WindowE…WINDOW_AREA_STATUS_CLASS)");
        return loadClass;
    }

    private final Class<?> getExtensionWindowAreaPresentationClass() {
        Class<?> loadClass = this.loader.loadClass(WindowExtensionsConstants.EXTENSION_WINDOW_AREA_PRESENTATION_CLASS);
        Intrinsics.checkNotNullExpressionValue(loadClass, "loader.loadClass(\n      …ATION_CLASS\n            )");
        return loadClass;
    }
}
