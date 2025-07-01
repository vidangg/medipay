package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;

/* loaded from: classes4.dex */
public interface TextureRegistry {

    /* loaded from: classes4.dex */
    public interface GLTextureConsumer {
        SurfaceTexture getSurfaceTexture();
    }

    /* loaded from: classes4.dex */
    public interface ImageConsumer {
        Image acquireLatestImage();
    }

    /* loaded from: classes4.dex */
    public interface ImageTextureEntry extends TextureEntry {
        void pushImage(Image image);
    }

    /* loaded from: classes4.dex */
    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    /* loaded from: classes4.dex */
    public interface OnTrimMemoryListener {
        void onTrimMemory(int i);
    }

    /* loaded from: classes4.dex */
    public enum SurfaceLifecycle {
        manual,
        resetInBackground
    }

    /* loaded from: classes4.dex */
    public interface SurfaceTextureEntry extends TextureEntry {
        default void setOnFrameConsumedListener(OnFrameConsumedListener onFrameConsumedListener) {
        }

        default void setOnTrimMemoryListener(OnTrimMemoryListener onTrimMemoryListener) {
        }

        SurfaceTexture surfaceTexture();
    }

    /* loaded from: classes4.dex */
    public interface TextureEntry {
        long id();

        void release();
    }

    ImageTextureEntry createImageTexture();

    SurfaceProducer createSurfaceProducer(SurfaceLifecycle surfaceLifecycle);

    SurfaceTextureEntry createSurfaceTexture();

    default void onTrimMemory(int i) {
    }

    SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture);

    default SurfaceProducer createSurfaceProducer() {
        return createSurfaceProducer(SurfaceLifecycle.manual);
    }

    /* loaded from: classes4.dex */
    public interface SurfaceProducer extends TextureEntry {
        int getHeight();

        Surface getSurface();

        int getWidth();

        boolean handlesCropAndRotation();

        void scheduleFrame();

        void setCallback(Callback callback);

        void setSize(int i, int i2);

        /* loaded from: classes4.dex */
        public interface Callback {
            @Deprecated(forRemoval = true, since = "Flutter 3.27")
            default void onSurfaceCreated() {
            }

            @Deprecated(forRemoval = true, since = "Flutter 3.28")
            default void onSurfaceDestroyed() {
            }

            default void onSurfaceAvailable() {
                onSurfaceCreated();
            }

            default void onSurfaceCleanup() {
                onSurfaceDestroyed();
            }
        }
    }
}
