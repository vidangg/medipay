package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.Quality;

/* loaded from: classes.dex */
public class ExcludeStretchedVideoQualityQuirk implements VideoQualityQuirk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean load() {
        return isSamsungJ4() || isSamsungJ7PrimeApi27Above() || isSamsungJ7Api27Above();
    }

    private static boolean isSamsungJ4() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J400G".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-G610M".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isSamsungJ7Api27Above() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J710MN".equalsIgnoreCase(Build.MODEL);
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public boolean isProblematicVideoQuality(CameraInfoInternal cameraInfoInternal, Quality quality) {
        return isSamsungJ4() ? quality == Quality.FHD || quality == Quality.UHD : (isSamsungJ7PrimeApi27Above() || isSamsungJ7Api27Above()) && quality == Quality.FHD;
    }
}
