package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import java.util.Objects;

/* loaded from: classes.dex */
public class AudioEncoderInfoImpl extends EncoderInfoImpl implements AudioEncoderInfo {
    private final MediaCodecInfo.AudioCapabilities mAudioCapabilities;

    public static AudioEncoderInfoImpl from(AudioEncoderConfig audioEncoderConfig) throws InvalidConfigException {
        return new AudioEncoderInfoImpl(findCodecAndGetCodecInfo(audioEncoderConfig), audioEncoderConfig.getMimeType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioEncoderInfoImpl(MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        this.mAudioCapabilities = (MediaCodecInfo.AudioCapabilities) Objects.requireNonNull(this.mCodecCapabilities.getAudioCapabilities());
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderInfo
    public Range<Integer> getBitrateRange() {
        return this.mAudioCapabilities.getBitrateRange();
    }
}
