package io.flutter.plugin.platform;

import android.view.Surface;

/* loaded from: classes4.dex */
public interface PlatformViewRenderTarget {
    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    boolean isReleased();

    void release();

    void resize(int i, int i2);

    default void scheduleFrame() {
    }
}
