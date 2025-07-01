package androidx.camera.video.internal.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.compat.Api23Impl;
import androidx.camera.video.internal.compat.Api24Impl;
import androidx.camera.video.internal.compat.Api29Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.camera.video.internal.compat.quirk.AudioTimestampFramePositionIncorrectQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class AudioStreamImpl implements AudioStream {
    private static final String TAG = "AudioStreamImpl";
    final AudioRecord mAudioRecord;
    private AudioManager.AudioRecordingCallback mAudioRecordingCallback;
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBufferSize;
    private final int mBytesPerFrame;
    private Executor mCallbackExecutor;
    private final AtomicBoolean mIsReleased = new AtomicBoolean(false);
    private final AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private final AtomicReference<Boolean> mNotifiedSilenceState = new AtomicReference<>(null);
    private final AudioSettings mSettings;
    private long mTotalFramesRead;

    public AudioStreamImpl(AudioSettings audioSettings, Context context) throws IllegalArgumentException, AudioStream.AudioStreamException {
        if (!isSettingsSupported(audioSettings.getSampleRate(), audioSettings.getChannelCount(), audioSettings.getAudioFormat())) {
            throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", Integer.valueOf(audioSettings.getSampleRate()), Integer.valueOf(audioSettings.getChannelCount()), Integer.valueOf(audioSettings.getAudioFormat())));
        }
        this.mSettings = audioSettings;
        this.mBytesPerFrame = audioSettings.getBytesPerFrame();
        int minBufferSize = getMinBufferSize(audioSettings.getSampleRate(), audioSettings.getChannelCount(), audioSettings.getAudioFormat());
        Preconditions.checkState(minBufferSize > 0);
        int i = minBufferSize * 2;
        this.mBufferSize = i;
        AudioFormat build = new AudioFormat.Builder().setSampleRate(audioSettings.getSampleRate()).setChannelMask(AudioUtils.channelCountToChannelMask(audioSettings.getChannelCount())).setEncoding(audioSettings.getAudioFormat()).build();
        AudioRecord.Builder createAudioRecordBuilder = Api23Impl.createAudioRecordBuilder();
        if (Build.VERSION.SDK_INT >= 31 && context != null) {
            Api31Impl.setContext(createAudioRecordBuilder, context);
        }
        Api23Impl.setAudioSource(createAudioRecordBuilder, audioSettings.getAudioSource());
        Api23Impl.setAudioFormat(createAudioRecordBuilder, build);
        Api23Impl.setBufferSizeInBytes(createAudioRecordBuilder, i);
        AudioRecord build2 = Api23Impl.build(createAudioRecordBuilder);
        this.mAudioRecord = build2;
        if (build2.getState() == 1) {
            return;
        }
        build2.release();
        throw new AudioStream.AudioStreamException("Unable to initialize AudioRecord");
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true)) {
            return;
        }
        this.mAudioRecord.startRecording();
        boolean z = false;
        if (this.mAudioRecord.getRecordingState() != 3) {
            this.mIsStarted.set(false);
            throw new AudioStream.AudioStreamException("Unable to start AudioRecord with state: " + this.mAudioRecord.getRecordingState());
        }
        this.mTotalFramesRead = 0L;
        this.mNotifiedSilenceState.set(null);
        if (Build.VERSION.SDK_INT >= 29) {
            AudioRecordingConfiguration activeRecordingConfiguration = Api29Impl.getActiveRecordingConfiguration(this.mAudioRecord);
            z = activeRecordingConfiguration != null && Api29Impl.isClientSilenced(activeRecordingConfiguration);
        }
        notifySilenced(z);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false)) {
            this.mAudioRecord.stop();
            if (this.mAudioRecord.getRecordingState() != 1) {
                Logger.w(TAG, "Failed to stop AudioRecord with state: " + this.mAudioRecord.getRecordingState());
            }
        }
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        AudioManager.AudioRecordingCallback audioRecordingCallback;
        if (this.mIsReleased.getAndSet(true)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29 && (audioRecordingCallback = this.mAudioRecordingCallback) != null) {
            Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, audioRecordingCallback);
        }
        this.mAudioRecord.release();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer byteBuffer) {
        long j;
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        int read = this.mAudioRecord.read(byteBuffer, this.mBufferSize);
        if (read > 0) {
            byteBuffer.limit(read);
            j = generatePresentationTimeNs();
            this.mTotalFramesRead += AudioUtils.sizeToFrameCount(read, this.mBytesPerFrame);
        } else {
            j = 0;
        }
        return AudioStream.PacketInfo.of(read, j);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(AudioStream.AudioStreamCallback audioStreamCallback, Executor executor) {
        boolean z = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (audioStreamCallback != null && executor == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "executor can't be null with non-null callback.");
        this.mAudioStreamCallback = audioStreamCallback;
        this.mCallbackExecutor = executor;
        if (Build.VERSION.SDK_INT >= 29) {
            AudioManager.AudioRecordingCallback audioRecordingCallback = this.mAudioRecordingCallback;
            if (audioRecordingCallback != null) {
                Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, audioRecordingCallback);
            }
            if (audioStreamCallback == null) {
                return;
            }
            if (this.mAudioRecordingCallback == null) {
                this.mAudioRecordingCallback = new AudioRecordingApi29Callback();
            }
            Api29Impl.registerAudioRecordingCallback(this.mAudioRecord, executor, this.mAudioRecordingCallback);
        }
    }

    void notifySilenced(final boolean z) {
        Executor executor = this.mCallbackExecutor;
        final AudioStream.AudioStreamCallback audioStreamCallback = this.mAudioStreamCallback;
        if (executor == null || audioStreamCallback == null || Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(z)), Boolean.valueOf(z))) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.AudioStreamImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AudioStream.AudioStreamCallback.this.onSilenceStateChanged(z);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long generatePresentationTimeNs() {
        long j;
        if (!hasAudioTimestampQuirk()) {
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            if (Api24Impl.getTimestamp(this.mAudioRecord, audioTimestamp, 0) == 0) {
                j = computeInterpolatedTimeNs(this.mSettings.getSampleRate(), this.mTotalFramesRead, audioTimestamp);
                return j != -1 ? System.nanoTime() : j;
            }
            Logger.w(TAG, "Unable to get audio timestamp");
        }
        j = -1;
        if (j != -1) {
        }
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    public static boolean isSettingsSupported(int i, int i2, int i3) {
        return i > 0 && i2 > 0 && getMinBufferSize(i, i2, i3) > 0;
    }

    private static boolean hasAudioTimestampQuirk() {
        return DeviceQuirks.get(AudioTimestampFramePositionIncorrectQuirk.class) != null;
    }

    private static long computeInterpolatedTimeNs(int i, long j, AudioTimestamp audioTimestamp) {
        long frameCountToDurationNs = audioTimestamp.nanoTime + AudioUtils.frameCountToDurationNs(j - audioTimestamp.framePosition, i);
        if (frameCountToDurationNs < 0) {
            return 0L;
        }
        return frameCountToDurationNs;
    }

    private static int getMinBufferSize(int i, int i2, int i3) {
        return AudioRecord.getMinBufferSize(i, AudioUtils.channelCountToChannelConfig(i2), i3);
    }

    /* loaded from: classes.dex */
    class AudioRecordingApi29Callback extends AudioManager.AudioRecordingCallback {
        AudioRecordingApi29Callback() {
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
                if (Api24Impl.getClientAudioSessionId(audioRecordingConfiguration) == AudioStreamImpl.this.mAudioRecord.getAudioSessionId()) {
                    AudioStreamImpl.this.notifySilenced(Api29Impl.isClientSilenced(audioRecordingConfiguration));
                    return;
                }
            }
        }
    }
}
