package io.flutter.plugins.videoplayer.texture;

import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.ExoPlayer;
import io.flutter.plugins.videoplayer.ExoPlayerEventListener;
import io.flutter.plugins.videoplayer.VideoPlayerCallbacks;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class TextureExoPlayerEventListener extends ExoPlayerEventListener {
    private boolean surfaceProducerHandlesCropAndRotation;

    public TextureExoPlayerEventListener(ExoPlayer exoPlayer, VideoPlayerCallbacks videoPlayerCallbacks, boolean z) {
        super(exoPlayer, videoPlayerCallbacks);
        this.surfaceProducerHandlesCropAndRotation = z;
    }

    @Override // io.flutter.plugins.videoplayer.ExoPlayerEventListener
    protected void sendInitialized() {
        VideoSize videoSize = this.exoPlayer.getVideoSize();
        ExoPlayerEventListener.RotationDegrees rotationDegrees = ExoPlayerEventListener.RotationDegrees.ROTATE_0;
        int i = videoSize.width;
        int i2 = videoSize.height;
        if (i != 0 && i2 != 0) {
            if (this.surfaceProducerHandlesCropAndRotation) {
                rotationDegrees = ExoPlayerEventListener.RotationDegrees.ROTATE_0;
            } else {
                try {
                    rotationDegrees = ExoPlayerEventListener.RotationDegrees.fromDegrees(getRotationCorrectionFromFormat(this.exoPlayer));
                } catch (IllegalArgumentException unused) {
                    rotationDegrees = ExoPlayerEventListener.RotationDegrees.ROTATE_0;
                }
            }
        }
        this.events.onInitialized(i, i2, this.exoPlayer.getDuration(), rotationDegrees.getDegrees());
    }

    private ExoPlayerEventListener.RotationDegrees getRotationCorrectionFromUnappliedRotation(ExoPlayerEventListener.RotationDegrees rotationDegrees) {
        return rotationDegrees == ExoPlayerEventListener.RotationDegrees.ROTATE_180 ? rotationDegrees : ExoPlayerEventListener.RotationDegrees.ROTATE_0;
    }

    private int getRotationCorrectionFromFormat(ExoPlayer exoPlayer) {
        return ((Format) Objects.requireNonNull(exoPlayer.getVideoFormat())).rotationDegrees;
    }
}
