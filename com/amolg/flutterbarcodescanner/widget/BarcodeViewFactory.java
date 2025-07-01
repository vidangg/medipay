package com.amolg.flutterbarcodescanner.widget;

import android.content.Context;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/* loaded from: classes3.dex */
public class BarcodeViewFactory extends PlatformViewFactory {
    private final BinaryMessenger messenger;

    public BarcodeViewFactory(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = binaryMessenger;
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i, Object obj) {
        return new FlutterBarcodeView(context, this.messenger, i, obj);
    }
}
