package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraUseInconsistentTimebaseQuirk implements Quirk {
    private static final Set<String> BUILD_HARDWARE_SET = new HashSet(Arrays.asList("samsungexynos7570", "samsungexynos7870", "qcom"));
    private static final Set<String> BUILD_SOC_MODEL_SET = new HashSet(Arrays.asList("sm4350", "sm6375"));
    private static final Set<String> BUILD_MODEL_SET = new HashSet(Arrays.asList("m2007j20cg", "m2007j20ct"));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean load() {
        return usesAffectedSoc() || isAffectedSamsungDevice() || isAffectedModel();
    }

    private static boolean usesAffectedSoc() {
        String str;
        if (Build.VERSION.SDK_INT >= 31) {
            Set<String> set = BUILD_SOC_MODEL_SET;
            str = Build.SOC_MODEL;
            if (set.contains(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAffectedSamsungDevice() {
        return "SAMSUNG".equalsIgnoreCase(Build.BRAND) && BUILD_HARDWARE_SET.contains(Build.HARDWARE.toLowerCase());
    }

    private static boolean isAffectedModel() {
        return BUILD_MODEL_SET.contains(Build.MODEL.toLowerCase());
    }
}
