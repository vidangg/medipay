package io.flutter.plugin.common;

import android.content.Intent;

/* loaded from: classes4.dex */
public interface PluginRegistry {

    /* loaded from: classes4.dex */
    public interface ActivityResultListener {
        boolean onActivityResult(int i, int i2, Intent intent);
    }

    /* loaded from: classes4.dex */
    public interface NewIntentListener {
        boolean onNewIntent(Intent intent);
    }

    /* loaded from: classes4.dex */
    public interface RequestPermissionsResultListener {
        boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes4.dex */
    public interface UserLeaveHintListener {
        void onUserLeaveHint();
    }

    /* loaded from: classes4.dex */
    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(boolean z);
    }
}
