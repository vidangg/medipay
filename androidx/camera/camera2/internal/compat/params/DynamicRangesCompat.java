package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Set;

/* loaded from: classes.dex */
public final class DynamicRangesCompat {
    private final DynamicRangeProfilesCompatImpl mImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface DynamicRangeProfilesCompatImpl {
        Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange);

        Set<DynamicRange> getSupportedDynamicRanges();

        boolean isExtraLatencyPresent(DynamicRange dynamicRange);

        DynamicRangeProfiles unwrap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicRangesCompat(DynamicRangeProfilesCompatImpl dynamicRangeProfilesCompatImpl) {
        this.mImpl = dynamicRangeProfilesCompatImpl;
    }

    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange) {
        return this.mImpl.getDynamicRangeCaptureRequestConstraints(dynamicRange);
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mImpl.getSupportedDynamicRanges();
    }

    public boolean isExtraLatencyPresent(DynamicRange dynamicRange) {
        return this.mImpl.isExtraLatencyPresent(dynamicRange);
    }

    public static DynamicRangesCompat fromCameraCharacteristics(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        DynamicRangesCompat dynamicRangesCompat;
        CameraCharacteristics.Key key;
        if (Build.VERSION.SDK_INT >= 33) {
            key = CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES;
            dynamicRangesCompat = toDynamicRangesCompat(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(cameraCharacteristicsCompat.get(key)));
        } else {
            dynamicRangesCompat = null;
        }
        return dynamicRangesCompat == null ? DynamicRangesCompatBaseImpl.COMPAT_INSTANCE : dynamicRangesCompat;
    }

    public static DynamicRangesCompat toDynamicRangesCompat(DynamicRangeProfiles dynamicRangeProfiles) {
        if (dynamicRangeProfiles == null) {
            return null;
        }
        Preconditions.checkState(Build.VERSION.SDK_INT >= 33, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new DynamicRangesCompat(new DynamicRangesCompatApi33Impl(dynamicRangeProfiles));
    }

    public DynamicRangeProfiles toDynamicRangeProfiles() {
        Preconditions.checkState(Build.VERSION.SDK_INT >= 33, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.mImpl.unwrap();
    }
}
