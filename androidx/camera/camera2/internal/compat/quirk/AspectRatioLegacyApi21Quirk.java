package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class AspectRatioLegacyApi21Quirk implements Quirk {
    public int getCorrectedAspectRatio() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean load(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null) {
            return false;
        }
        num.intValue();
        return false;
    }
}
