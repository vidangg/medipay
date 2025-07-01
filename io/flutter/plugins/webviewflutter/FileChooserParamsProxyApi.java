package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class FileChooserParamsProxyApi extends PigeonApiFileChooserParams {
    public FileChooserParamsProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFileChooserParams
    public boolean isCaptureEnabled(WebChromeClient.FileChooserParams fileChooserParams) {
        return fileChooserParams.isCaptureEnabled();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFileChooserParams
    public List<String> acceptTypes(WebChromeClient.FileChooserParams fileChooserParams) {
        return Arrays.asList(fileChooserParams.getAcceptTypes());
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFileChooserParams
    public FileChooserMode mode(WebChromeClient.FileChooserParams fileChooserParams) {
        int mode = fileChooserParams.getMode();
        if (mode == 0) {
            return FileChooserMode.OPEN;
        }
        if (mode == 1) {
            return FileChooserMode.OPEN_MULTIPLE;
        }
        if (mode == 3) {
            return FileChooserMode.SAVE;
        }
        return FileChooserMode.UNKNOWN;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFileChooserParams
    public String filenameHint(WebChromeClient.FileChooserParams fileChooserParams) {
        return fileChooserParams.getFilenameHint();
    }
}
