package io.flutter.plugins.camera.features.sensororientation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.Display;
import android.view.WindowManager;
import androidx.media3.extractor.ts.TsExtractor;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.DartMessenger;

/* loaded from: classes4.dex */
public class DeviceOrientationManager {
    private static final IntentFilter orientationIntentFilter = new IntentFilter("android.intent.action.CONFIGURATION_CHANGED");
    private final Activity activity;
    private BroadcastReceiver broadcastReceiver;
    private final boolean isFrontFacing;
    private PlatformChannel.DeviceOrientation lastOrientation;
    private final DartMessenger messenger;
    private final int sensorOrientation;

    public static DeviceOrientationManager create(Activity activity, DartMessenger dartMessenger, boolean z, int i) {
        return new DeviceOrientationManager(activity, dartMessenger, z, i);
    }

    private DeviceOrientationManager(Activity activity, DartMessenger dartMessenger, boolean z, int i) {
        this.activity = activity;
        this.messenger = dartMessenger;
        this.isFrontFacing = z;
        this.sensorOrientation = i;
    }

    public void start() {
        if (this.broadcastReceiver != null) {
            return;
        }
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: io.flutter.plugins.camera.features.sensororientation.DeviceOrientationManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                DeviceOrientationManager.this.handleUIOrientationChange();
            }
        };
        this.broadcastReceiver = broadcastReceiver;
        this.activity.registerReceiver(broadcastReceiver, orientationIntentFilter);
        this.broadcastReceiver.onReceive(this.activity, null);
    }

    public void stop() {
        BroadcastReceiver broadcastReceiver = this.broadcastReceiver;
        if (broadcastReceiver == null) {
            return;
        }
        this.activity.unregisterReceiver(broadcastReceiver);
        this.broadcastReceiver = null;
    }

    public int getPhotoOrientation() {
        return getPhotoOrientation(this.lastOrientation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r4.isFrontFacing != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        if (r4.isFrontFacing != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getPhotoOrientation(PlatformChannel.DeviceOrientation deviceOrientation) {
        int i;
        if (deviceOrientation == null) {
            deviceOrientation = getUIOrientation();
        }
        int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[deviceOrientation.ordinal()];
        if (i2 == 1) {
            i = 90;
        } else if (i2 != 2) {
            int i3 = 180;
            i = 0;
            if (i2 != 3) {
                if (i2 == 4) {
                }
            }
        } else {
            i = 270;
        }
        return ((i + this.sensorOrientation) + 270) % 360;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.camera.features.sensororientation.DeviceOrientationManager$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;

        static {
            int[] iArr = new int[PlatformChannel.DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr;
            try {
                iArr[PlatformChannel.DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public int getVideoOrientation() {
        return getVideoOrientation(this.lastOrientation);
    }

    public int getVideoOrientation(PlatformChannel.DeviceOrientation deviceOrientation) {
        if (deviceOrientation == null) {
            deviceOrientation = getUIOrientation();
        }
        int i = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[deviceOrientation.ordinal()];
        int i2 = 0;
        if (i != 1) {
            if (i == 2) {
                i2 = 180;
            } else if (i == 3) {
                i2 = 270;
            } else if (i == 4) {
                i2 = 90;
            }
        }
        if (this.isFrontFacing) {
            i2 *= -1;
        }
        return ((i2 + this.sensorOrientation) + 360) % 360;
    }

    public PlatformChannel.DeviceOrientation getLastUIOrientation() {
        return this.lastOrientation;
    }

    void handleUIOrientationChange() {
        PlatformChannel.DeviceOrientation uIOrientation = getUIOrientation();
        handleOrientationChange(uIOrientation, this.lastOrientation, this.messenger);
        this.lastOrientation = uIOrientation;
    }

    static void handleOrientationChange(PlatformChannel.DeviceOrientation deviceOrientation, PlatformChannel.DeviceOrientation deviceOrientation2, DartMessenger dartMessenger) {
        if (deviceOrientation.equals(deviceOrientation2)) {
            return;
        }
        dartMessenger.sendDeviceOrientationChangeEvent(deviceOrientation);
    }

    PlatformChannel.DeviceOrientation getUIOrientation() {
        int rotation = getDisplay().getRotation();
        int i = this.activity.getResources().getConfiguration().orientation;
        if (i == 1) {
            if (rotation == 0 || rotation == 1) {
                return PlatformChannel.DeviceOrientation.PORTRAIT_UP;
            }
            return PlatformChannel.DeviceOrientation.PORTRAIT_DOWN;
        }
        if (i != 2) {
            return PlatformChannel.DeviceOrientation.PORTRAIT_UP;
        }
        if (rotation == 0 || rotation == 1) {
            return PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT;
        }
        return PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT;
    }

    PlatformChannel.DeviceOrientation calculateSensorOrientation(int i) {
        int i2 = i + 45;
        if (getDeviceDefaultOrientation() == 2) {
            i2 = i + TsExtractor.TS_STREAM_TYPE_E_AC3;
        }
        return new PlatformChannel.DeviceOrientation[]{PlatformChannel.DeviceOrientation.PORTRAIT_UP, PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT, PlatformChannel.DeviceOrientation.PORTRAIT_DOWN, PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT}[(i2 % 360) / 90];
    }

    int getDeviceDefaultOrientation() {
        Configuration configuration = this.activity.getResources().getConfiguration();
        int rotation = getDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    Display getDisplay() {
        return ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay();
    }
}
