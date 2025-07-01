package io.flutter.plugins.videoplayer;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;

/* loaded from: classes4.dex */
public abstract class ExoPlayerEventListener implements Player.Listener {
    protected final VideoPlayerCallbacks events;
    protected final ExoPlayer exoPlayer;
    private boolean isBuffering = false;
    private boolean isInitialized = false;

    protected abstract void sendInitialized();

    /* loaded from: classes4.dex */
    protected enum RotationDegrees {
        ROTATE_0(0),
        ROTATE_90(90),
        ROTATE_180(180),
        ROTATE_270(270);

        private final int degrees;

        RotationDegrees(int i) {
            this.degrees = i;
        }

        public static RotationDegrees fromDegrees(int i) {
            for (RotationDegrees rotationDegrees : values()) {
                if (rotationDegrees.degrees == i) {
                    return rotationDegrees;
                }
            }
            throw new IllegalArgumentException("Invalid rotation degrees specified: " + i);
        }

        public int getDegrees() {
            return this.degrees;
        }
    }

    public ExoPlayerEventListener(ExoPlayer exoPlayer, VideoPlayerCallbacks videoPlayerCallbacks) {
        this.exoPlayer = exoPlayer;
        this.events = videoPlayerCallbacks;
    }

    private void setBuffering(boolean z) {
        if (this.isBuffering == z) {
            return;
        }
        this.isBuffering = z;
        if (z) {
            this.events.onBufferingStart();
        } else {
            this.events.onBufferingEnd();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackStateChanged(int i) {
        if (i == 2) {
            setBuffering(true);
            this.events.onBufferingUpdate(this.exoPlayer.getBufferedPosition());
        } else if (i != 3) {
            if (i == 4) {
                this.events.onCompleted();
            }
        } else if (!this.isInitialized) {
            this.isInitialized = true;
            sendInitialized();
        }
        if (i != 2) {
            setBuffering(false);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(PlaybackException playbackException) {
        setBuffering(false);
        if (playbackException.errorCode == 1002) {
            this.exoPlayer.seekToDefaultPosition();
            this.exoPlayer.prepare();
        } else {
            this.events.onError("VideoError", "Video player had error " + playbackException, null);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean z) {
        this.events.onIsPlayingStateUpdate(z);
    }
}
