package io.flutter.plugins.webviewflutter;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class FlutterAssetManager {
    final AssetManager assetManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String getAssetFilePathByName(String str);

    public FlutterAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public String[] list(String str) throws IOException {
        return this.assetManager.list(str);
    }

    /* loaded from: classes4.dex */
    static class PluginBindingFlutterAssetManager extends FlutterAssetManager {
        final FlutterPlugin.FlutterAssets flutterAssets;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PluginBindingFlutterAssetManager(AssetManager assetManager, FlutterPlugin.FlutterAssets flutterAssets) {
            super(assetManager);
            this.flutterAssets = flutterAssets;
        }

        @Override // io.flutter.plugins.webviewflutter.FlutterAssetManager
        public String getAssetFilePathByName(String str) {
            return this.flutterAssets.getAssetFilePathByName(str);
        }
    }
}
