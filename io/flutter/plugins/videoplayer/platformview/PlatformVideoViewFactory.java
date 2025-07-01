package io.flutter.plugins.videoplayer.platformview;

import android.content.Context;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.plugins.videoplayer.VideoPlayer;
import java.util.Objects;

/* loaded from: classes4.dex */
public class PlatformVideoViewFactory extends PlatformViewFactory {
    private final VideoPlayerProvider videoPlayerProvider;

    @FunctionalInterface
    /* loaded from: classes4.dex */
    public interface VideoPlayerProvider {
        VideoPlayer getVideoPlayer(Long l);
    }

    public PlatformVideoViewFactory(VideoPlayerProvider videoPlayerProvider) {
        super(Messages.AndroidVideoPlayerApi.getCodec());
        this.videoPlayerProvider = videoPlayerProvider;
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i, Object obj) {
        return new PlatformVideoView(context, this.videoPlayerProvider.getVideoPlayer(((Messages.PlatformVideoViewCreationParams) Objects.requireNonNull((Messages.PlatformVideoViewCreationParams) obj)).getPlayerId()).getExoPlayer());
    }
}
