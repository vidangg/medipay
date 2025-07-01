package io.flutter.plugins.webviewflutter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class FlutterAssetManagerProxyApi extends PigeonApiFlutterAssetManager {
    public FlutterAssetManagerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public FlutterAssetManager instance() {
        return getPigeonRegistrar().getFlutterAssetManager();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public List<String> list(FlutterAssetManager flutterAssetManager, String str) {
        try {
            String[] list = flutterAssetManager.list(str);
            if (list == null) {
                return new ArrayList();
            }
            return Arrays.asList(list);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public String getAssetFilePathByName(FlutterAssetManager flutterAssetManager, String str) {
        return flutterAssetManager.getAssetFilePathByName(str);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
