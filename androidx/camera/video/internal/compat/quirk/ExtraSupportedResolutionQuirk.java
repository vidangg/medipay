package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class ExtraSupportedResolutionQuirk implements Quirk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean load() {
        return isMotoE5Play();
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }
}
