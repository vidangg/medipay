package androidx.camera.video.internal.audio;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface AudioStream {

    /* loaded from: classes.dex */
    public interface AudioStreamCallback {
        default void onSilenceStateChanged(boolean z) {
        }
    }

    PacketInfo read(ByteBuffer byteBuffer);

    void release();

    void setCallback(AudioStreamCallback audioStreamCallback, Executor executor);

    void start() throws AudioStreamException, IllegalStateException;

    void stop() throws IllegalStateException;

    /* loaded from: classes.dex */
    public static abstract class PacketInfo {
        public abstract int getSizeInBytes();

        public abstract long getTimestampNs();

        public static PacketInfo of(int i, long j) {
            return new AutoValue_AudioStream_PacketInfo(i, j);
        }
    }

    /* loaded from: classes.dex */
    public static class AudioStreamException extends Exception {
        public AudioStreamException() {
        }

        public AudioStreamException(String str) {
            super(str);
        }

        public AudioStreamException(String str, Throwable th) {
            super(str, th);
        }

        public AudioStreamException(Throwable th) {
            super(th);
        }
    }
}
