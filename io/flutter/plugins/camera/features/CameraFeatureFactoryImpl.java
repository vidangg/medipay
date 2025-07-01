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
public class CameraFeatureFactoryImpl implements CameraFeatureFactory {
    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public AutoFocusFeature createAutoFocusFeature(CameraProperties cameraProperties, boolean z) {
        return new AutoFocusFeature(cameraProperties, z);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public ExposureLockFeature createExposureLockFeature(CameraProperties cameraProperties) {
        return new ExposureLockFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public ExposureOffsetFeature createExposureOffsetFeature(CameraProperties cameraProperties) {
        return new ExposureOffsetFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public FlashFeature createFlashFeature(CameraProperties cameraProperties) {
        return new FlashFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public ResolutionFeature createResolutionFeature(CameraProperties cameraProperties, ResolutionPreset resolutionPreset, String str) {
        return new ResolutionFeature(cameraProperties, resolutionPreset, str);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public FocusPointFeature createFocusPointFeature(CameraProperties cameraProperties, SensorOrientationFeature sensorOrientationFeature) {
        return new FocusPointFeature(cameraProperties, sensorOrientationFeature);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public FpsRangeFeature createFpsRangeFeature(CameraProperties cameraProperties) {
        return new FpsRangeFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public SensorOrientationFeature createSensorOrientationFeature(CameraProperties cameraProperties, Activity activity, DartMessenger dartMessenger) {
        return new SensorOrientationFeature(cameraProperties, activity, dartMessenger);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public ZoomLevelFeature createZoomLevelFeature(CameraProperties cameraProperties) {
        return new ZoomLevelFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public ExposurePointFeature createExposurePointFeature(CameraProperties cameraProperties, SensorOrientationFeature sensorOrientationFeature) {
        return new ExposurePointFeature(cameraProperties, sensorOrientationFeature);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    public NoiseReductionFeature createNoiseReductionFeature(CameraProperties cameraProperties) {
        return new NoiseReductionFeature(cameraProperties);
    }
}
