package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AutoValue_AudioSettings;
import androidx.media3.extractor.OpusUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AudioSettings {
    public static final List<Integer> COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(Integer.valueOf(OpusUtil.SAMPLE_RATE), 44100, 22050, 11025, 8000, 4800));

    public abstract int getAudioFormat();

    public abstract int getAudioSource();

    public abstract int getChannelCount();

    public abstract int getSampleRate();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_AudioSettings.Builder().setAudioSource(-1).setSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
    }

    public int getBytesPerFrame() {
        return AudioUtils.getBytesPerFrame(getAudioFormat(), getChannelCount());
    }

    /* loaded from: classes.dex */
    public static abstract class Builder {
        abstract AudioSettings autoBuild();

        public abstract Builder setAudioFormat(int i);

        public abstract Builder setAudioSource(int i);

        public abstract Builder setChannelCount(int i);

        public abstract Builder setSampleRate(int i);

        public final AudioSettings build() {
            String str;
            AudioSettings autoBuild = autoBuild();
            if (autoBuild.getAudioSource() != -1) {
                str = "";
            } else {
                str = " audioSource";
            }
            if (autoBuild.getSampleRate() <= 0) {
                str = str + " sampleRate";
            }
            if (autoBuild.getChannelCount() <= 0) {
                str = str + " channelCount";
            }
            if (autoBuild.getAudioFormat() == -1) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return autoBuild;
            }
            throw new IllegalArgumentException("Required settings missing or non-positive:" + str);
        }
    }
}
