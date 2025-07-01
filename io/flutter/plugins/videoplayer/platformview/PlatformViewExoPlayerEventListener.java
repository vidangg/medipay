package io.flutter.plugins.videoplayer.platformview;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.ExoPlayer;
import io.flutter.plugins.videoplayer.ExoPlayerEventListener;
import io.flutter.plugins.videoplayer.VideoPlayerCallbacks;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class PlatformViewExoPlayerEventListener extends ExoPlayerEventListener {
    public PlatformViewExoPlayerEventListener(ExoPlayer exoPlayer, VideoPlayerCallbacks videoPlayerCallbacks) {
        super(exoPlayer, videoPlayerCallbacks);
    }

    @Override // io.flutter.plugins.videoplayer.ExoPlayerEventListener
    protected void sendInitialized() {
        Format videoFormat = this.exoPlayer.getVideoFormat();
        ExoPlayerEventListener.RotationDegrees fromDegrees = ExoPlayerEventListener.RotationDegrees.fromDegrees(((Format) Objects.requireNonNull(videoFormat)).rotationDegrees);
        int i = videoFormat.width;
        int i2 = videoFormat.height;
        if (fromDegrees == ExoPlayerEventListener.RotationDegrees.ROTATE_90 || fromDegrees == ExoPlayerEventListener.RotationDegrees.ROTATE_270) {
            i = videoFormat.height;
            i2 = videoFormat.width;
            fromDegrees = ExoPlayerEventListener.RotationDegrees.fromDegrees(0);
        }
        int i3 = i2;
        this.events.onInitialized(i, i3, this.exoPlayer.getDuration(), fromDegrees.getDegrees());
    }
}
