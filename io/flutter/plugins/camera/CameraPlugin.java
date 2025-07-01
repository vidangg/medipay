package io.flutter.plugins.camera;

import android.app.Activity;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.camera.CameraPermissions;
import io.flutter.view.TextureRegistry;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class CameraPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "CameraPlugin";
    private CameraApiImpl cameraApi;
    private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.flutterPluginBinding = flutterPluginBinding;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.flutterPluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(final ActivityPluginBinding activityPluginBinding) {
        Activity activity = activityPluginBinding.getActivity();
        BinaryMessenger binaryMessenger = this.flutterPluginBinding.getBinaryMessenger();
        Objects.requireNonNull(activityPluginBinding);
        maybeStartListening(activity, binaryMessenger, new CameraPermissions.PermissionsRegistry() { // from class: io.flutter.plugins.camera.CameraPlugin$$ExternalSyntheticLambda0
            @Override // io.flutter.plugins.camera.CameraPermissions.PermissionsRegistry
            public final void addListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
                ActivityPluginBinding.this.addRequestPermissionsResultListener(requestPermissionsResultListener);
            }
        }, this.flutterPluginBinding.getTextureRegistry());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        CameraApiImpl cameraApiImpl = this.cameraApi;
        if (cameraApiImpl != null) {
            cameraApiImpl.tearDownMessageHandler();
            this.cameraApi = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    private void maybeStartListening(Activity activity, BinaryMessenger binaryMessenger, CameraPermissions.PermissionsRegistry permissionsRegistry, TextureRegistry textureRegistry) {
        this.cameraApi = new CameraApiImpl(activity, binaryMessenger, new CameraPermissions(), permissionsRegistry, textureRegistry);
    }
}
