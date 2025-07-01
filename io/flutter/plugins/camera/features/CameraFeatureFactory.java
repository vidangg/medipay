package io.flutter.plugins.camera.features;

import android.app.Activity;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.DartMessenger;
import io.flutter.plugins.camera.features.autofocus.AutoFocusFeature;
import io.flutter.plugins.camera.features.exposurelock.ExposureLockFeature;
import io.flutter.plugins.camera.features.exposureoffset.ExposureOffsetFeature;
import io.flutter.plugins.camera.features.exposurepoint.ExposurePointFeature;
import io.flutter.plugins.camera.features.flash.FlashFeature;
import io.flutter.plugins.camera.features.focuspoint.FocusPointFeature;
import io.flutter.plugins.camera.features.fpsrange.FpsRangeFeature;
import io.flutter.plugins.camera.features.noisereduction.NoiseReductionFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionPreset;
import io.flutter.plugins.camera.features.sensororientation.SensorOrientationFeature;
import io.flutter.plugins.camera.features.zoomlevel.ZoomLevelFeature;

/* loaded from: classes4.dex */
public interface CameraFeatureFactory {
    AutoFocusFeature createAutoFocusFeature(CameraProperties cameraProperties, boolean z);

    ExposureLockFeature createExposureLockFeature(CameraProperties cameraProperties);

    ExposureOffsetFeature createExposureOffsetFeature(CameraProperties cameraProperties);

    ExposurePointFeature createExposurePointFeature(CameraProperties cameraProperties, SensorOrientationFeature sensorOrientationFeature);

    FlashFeature createFlashFeature(CameraProperties cameraProperties);

    FocusPointFeature createFocusPointFeature(CameraProperties cameraProperties, SensorOrientationFeature sensorOrientationFeature);

    FpsRangeFeature createFpsRangeFeature(CameraProperties cameraProperties);

    NoiseReductionFeature createNoiseReductionFeature(CameraProperties cameraProperties);

    ResolutionFeature createResolutionFeature(CameraProperties cameraProperties, ResolutionPreset resolutionPreset, String str);

    SensorOrientationFeature createSensorOrientationFeature(CameraProperties cameraProperties, Activity activity, DartMessenger dartMessenger);

    ZoomLevelFeature createZoomLevelFeature(CameraProperties cameraProperties);
}
