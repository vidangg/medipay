package io.flutter.plugins.webviewflutter;

import android.os.Message;

/* loaded from: classes4.dex */
public class MessageProxyApi extends PigeonApiAndroidMessage {
    public MessageProxyApi(AndroidWebkitLibraryPigeonProxyApiRegistrar androidWebkitLibraryPigeonProxyApiRegistrar) {
        super(androidWebkitLibraryPigeonProxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiAndroidMessage
    public void sendToTarget(Message message) {
        message.sendToTarget();
    }
}
