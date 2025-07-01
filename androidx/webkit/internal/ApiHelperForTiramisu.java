package androidx.webkit.internal;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* loaded from: classes3.dex */
public class ApiHelperForTiramisu {
    private ApiHelperForTiramisu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PackageManager.ComponentInfoFlags of(long j) {
        PackageManager.ComponentInfoFlags of;
        of = PackageManager.ComponentInfoFlags.of(j);
        return of;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        ServiceInfo serviceInfo;
        serviceInfo = packageManager.getServiceInfo(componentName, componentInfoFlags);
        return serviceInfo;
    }
}
