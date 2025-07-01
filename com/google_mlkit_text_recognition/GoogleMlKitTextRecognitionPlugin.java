package com.google_mlkit_text_recognition;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes4.dex */
public class GoogleMlKitTextRecognitionPlugin implements FlutterPlugin {
    private static final String channelName = "google_mlkit_text_recognizer";
    private MethodChannel channel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), channelName);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(new TextRecognizer(flutterPluginBinding.getApplicationContext()));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
    }
}
