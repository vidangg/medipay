package com.pichillilorenzo.flutter_inappwebview_android.types;

import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes4.dex */
public interface IChannelDelegate extends MethodChannel.MethodCallHandler, Disposable {
    MethodChannel getChannel();
}
