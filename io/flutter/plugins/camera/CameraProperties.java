package io.flutter.plugins.camera;

import android.graphics.Rect;
import android.util.Range;
import android.util.Size;

/* loaded from: classes4.dex */
public interface CameraProperties {
    int[] getAvailableNoiseReductionModes();

    String getCameraName();

    Range<Integer>[] getControlAutoExposureAvailableTargetFpsRanges();

    Range<Integer> getControlAutoExposureCompensationRange();

    double getControlAutoExposureCompensationStep();

    int[] getControlAutoFocusAvailableModes();

    Integer getControlMaxRegionsAutoExposure();

    Integer getControlMaxRegionsAutoFocus();

    int[] getDistortionCorrectionAvailableModes();

    Boolean getFlashInfoAvailable();

    int getHardwareLevel();

    int getLensFacing();

    Float getLensInfoMinimumFocusDistance();

    Float getScalerAvailableMaxDigitalZoom();

    Float getScalerMaxZoomRatio();

    Float getScalerMinZoomRatio();

    Rect getSensorInfoActiveArraySize();

    Size getSensorInfoPixelArraySize();

    Rect getSensorInfoPreCorrectionActiveArraySize();

    int getSensorOrientation();
}
