package com.google_mlkit_face_detection;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes4.dex */
public class GoogleMlKitFaceDetectionPlugin implements FlutterPlugin {
    private static final String channelName = "google_mlkit_face_detector";
    private MethodChannel channel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), channelName);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(new FaceDetector(flutterPluginBinding.getApplicationContext()));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
    }
}
