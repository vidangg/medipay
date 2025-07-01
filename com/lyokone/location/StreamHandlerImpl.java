package com.lyokone.location;

import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

/* loaded from: classes4.dex */
class StreamHandlerImpl implements EventChannel.StreamHandler {
    private static final String STREAM_CHANNEL_NAME = "lyokone/locationstream";
    private static final String TAG = "StreamHandlerImpl";
    private EventChannel channel;
    private FlutterLocation location;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocation(FlutterLocation flutterLocation) {
        this.location = flutterLocation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListening(BinaryMessenger binaryMessenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        EventChannel eventChannel = new EventChannel(binaryMessenger, STREAM_CHANNEL_NAME);
        this.channel = eventChannel;
        eventChannel.setStreamHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListening() {
        EventChannel eventChannel = this.channel;
        if (eventChannel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
        } else {
            eventChannel.setStreamHandler(null);
            this.channel = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.location.events = eventSink;
        if (this.location.activity == null) {
            eventSink.error("NO_ACTIVITY", null, null);
        } else if (!this.location.checkPermissions()) {
            this.location.requestPermissions();
        } else {
            this.location.startRequestingLocation();
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        this.location.mFusedLocationClient.removeLocationUpdates(this.location.mLocationCallback);
        this.location.events = null;
    }
}
