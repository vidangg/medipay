package io.flutter.plugins.videoplayer;

import androidx.camera.video.AudioStats;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.exoplayer.ExoPlayer;
import io.flutter.view.TextureRegistry;

/* loaded from: classes4.dex */
public abstract class VideoPlayer {
    protected ExoPlayer exoPlayer;
    protected final TextureRegistry.SurfaceProducer surfaceProducer;
    protected final VideoPlayerCallbacks videoPlayerEvents;

    /* loaded from: classes4.dex */
    public interface ExoPlayerProvider {
        ExoPlayer get();
    }

    protected abstract ExoPlayerEventListener createExoPlayerEventListener(ExoPlayer exoPlayer, TextureRegistry.SurfaceProducer surfaceProducer);

    public VideoPlayer(VideoPlayerCallbacks videoPlayerCallbacks, MediaItem mediaItem, VideoPlayerOptions videoPlayerOptions, TextureRegistry.SurfaceProducer surfaceProducer, ExoPlayerProvider exoPlayerProvider) {
        this.videoPlayerEvents = videoPlayerCallbacks;
        this.surfaceProducer = surfaceProducer;
        ExoPlayer exoPlayer = exoPlayerProvider.get();
        this.exoPlayer = exoPlayer;
        exoPlayer.setMediaItem(mediaItem);
        this.exoPlayer.prepare();
        ExoPlayer exoPlayer2 = this.exoPlayer;
        exoPlayer2.addListener(createExoPlayerEventListener(exoPlayer2, surfaceProducer));
        setAudioAttributes(this.exoPlayer, videoPlayerOptions.mixWithOthers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendBufferingUpdate() {
        this.videoPlayerEvents.onBufferingUpdate(this.exoPlayer.getBufferedPosition());
    }

    private static void setAudioAttributes(ExoPlayer exoPlayer, boolean z) {
        exoPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(3).build(), !z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void play() {
        this.exoPlayer.play();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        this.exoPlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLooping(boolean z) {
        this.exoPlayer.setRepeatMode(z ? 2 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVolume(double d) {
        this.exoPlayer.setVolume((float) Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(1.0d, d)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlaybackSpeed(double d) {
        this.exoPlayer.setPlaybackParameters(new PlaybackParameters((float) d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void seekTo(int i) {
        this.exoPlayer.seekTo(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getPosition() {
        return this.exoPlayer.getCurrentPosition();
    }

    public ExoPlayer getExoPlayer() {
        return this.exoPlayer;
    }

    public void dispose() {
        this.exoPlayer.release();
    }
}
