package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.config.AudioMimeInfo;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AudioConfigUtil {
    static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    static final int AUDIO_SOURCE_DEFAULT = 5;
    static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    private static final String TAG = "AudioConfigUtil";

    private AudioConfigUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AudioMimeInfo resolveAudioMimeInfo(MediaSpec mediaSpec, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy;
        String outputFormatToAudioMime = MediaSpec.outputFormatToAudioMime(mediaSpec.getOutputFormat());
        int outputFormatToAudioProfile = MediaSpec.outputFormatToAudioProfile(mediaSpec.getOutputFormat());
        if (videoValidatedEncoderProfilesProxy != null && videoValidatedEncoderProfilesProxy.getDefaultAudioProfile() != null) {
            audioProfileProxy = videoValidatedEncoderProfilesProxy.getDefaultAudioProfile();
            String mediaType = audioProfileProxy.getMediaType();
            int profile = audioProfileProxy.getProfile();
            if (Objects.equals(mediaType, EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE)) {
                Logger.d(TAG, "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + outputFormatToAudioMime + "(profile: " + outputFormatToAudioProfile + ")]");
            } else {
                if (mediaSpec.getOutputFormat() == -1) {
                    Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: " + mediaType + "(profile: " + profile + ")]");
                    outputFormatToAudioMime = mediaType;
                    outputFormatToAudioProfile = profile;
                } else if (Objects.equals(outputFormatToAudioMime, mediaType) && outputFormatToAudioProfile == profile) {
                    Logger.d(TAG, "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: " + mediaType + "(profile: " + outputFormatToAudioProfile + ")]");
                    outputFormatToAudioMime = mediaType;
                } else {
                    Logger.d(TAG, "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: " + mediaType + "(profile: " + profile + "), chosen mime type: " + outputFormatToAudioMime + "(profile: " + outputFormatToAudioProfile + ")]");
                }
                AudioMimeInfo.Builder profile2 = AudioMimeInfo.builder(outputFormatToAudioMime).setProfile(outputFormatToAudioProfile);
                if (audioProfileProxy != null) {
                    profile2.setCompatibleAudioProfile(audioProfileProxy);
                }
                return profile2.build();
            }
        }
        audioProfileProxy = null;
        AudioMimeInfo.Builder profile22 = AudioMimeInfo.builder(outputFormatToAudioMime).setProfile(outputFormatToAudioProfile);
        if (audioProfileProxy != null) {
        }
        return profile22.build();
    }

    public static AudioSettings resolveAudioSettings(AudioMimeInfo audioMimeInfo, AudioSpec audioSpec) {
        Supplier audioSettingsDefaultResolver;
        EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile = audioMimeInfo.getCompatibleAudioProfile();
        if (compatibleAudioProfile != null) {
            audioSettingsDefaultResolver = new AudioSettingsAudioProfileResolver(audioSpec, compatibleAudioProfile);
        } else {
            audioSettingsDefaultResolver = new AudioSettingsDefaultResolver(audioSpec);
        }
        return (AudioSettings) audioSettingsDefaultResolver.get();
    }

    public static AudioEncoderConfig resolveAudioEncoderConfig(AudioMimeInfo audioMimeInfo, Timebase timebase, AudioSettings audioSettings, AudioSpec audioSpec) {
        Supplier audioEncoderConfigDefaultResolver;
        EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile = audioMimeInfo.getCompatibleAudioProfile();
        if (compatibleAudioProfile != null) {
            audioEncoderConfigDefaultResolver = new AudioEncoderConfigAudioProfileResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), timebase, audioSpec, audioSettings, compatibleAudioProfile);
        } else {
            audioEncoderConfigDefaultResolver = new AudioEncoderConfigDefaultResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), timebase, audioSpec, audioSettings);
        }
        return (AudioEncoderConfig) audioEncoderConfigDefaultResolver.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int resolveAudioSource(AudioSpec audioSpec) {
        int source = audioSpec.getSource();
        if (source == -1) {
            Logger.d(TAG, "Using default AUDIO source: 5");
            return 5;
        }
        Logger.d(TAG, "Using provided AUDIO source: " + source);
        return source;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int resolveAudioSourceFormat(AudioSpec audioSpec) {
        int sourceFormat = audioSpec.getSourceFormat();
        if (sourceFormat == -1) {
            Logger.d(TAG, "Using default AUDIO source format: 2");
            return 2;
        }
        Logger.d(TAG, "Using provided AUDIO source format: " + sourceFormat);
        return sourceFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int selectSampleRateOrNearestSupported(Range<Integer> range, int i, int i2, final int i3) {
        ArrayList arrayList = null;
        int i4 = 0;
        int i5 = i3;
        while (true) {
            if (range.contains((Range<Integer>) Integer.valueOf(i5))) {
                if (AudioSource.isSettingsSupported(i5, i, i2)) {
                    return i5;
                }
                Logger.d(TAG, "Sample rate " + i5 + "Hz is not supported by audio source with channel count " + i + " and source format " + i2);
            } else {
                Logger.d(TAG, "Sample rate " + i5 + "Hz is not in target range " + range);
            }
            if (arrayList == null) {
                Logger.d(TAG, "Trying common sample rates in proximity order to target " + i3 + "Hz");
                arrayList = new ArrayList(AudioSettings.COMMON_SAMPLE_RATES);
                Collections.sort(arrayList, new Comparator() { // from class: androidx.camera.video.internal.config.AudioConfigUtil$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return AudioConfigUtil.lambda$selectSampleRateOrNearestSupported$0(i3, (Integer) obj, (Integer) obj2);
                    }
                });
            }
            if (i4 < arrayList.size()) {
                i5 = ((Integer) arrayList.get(i4)).intValue();
                i4++;
            } else {
                Logger.d(TAG, "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return AUDIO_SAMPLE_RATE_DEFAULT;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$selectSampleRateOrNearestSupported$0(int i, Integer num, Integer num2) {
        float signum;
        int abs = Math.abs(num.intValue() - i) - Math.abs(num2.intValue() - i);
        if (abs == 0) {
            signum = Math.signum(num.intValue() - num2.intValue());
        } else {
            signum = Math.signum(abs);
        }
        return (int) signum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int scaleAndClampBitrate(int i, int i2, int i3, int i4, int i5, Range<Integer> range) {
        String str;
        int doubleValue = (int) (i * new Rational(i2, i3).doubleValue() * new Rational(i4, i5).doubleValue());
        if (!Logger.isDebugEnabled(TAG)) {
            str = "";
        } else {
            str = String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(doubleValue));
        }
        if (!AudioSpec.BITRATE_RANGE_AUTO.equals(range)) {
            Integer clamp = range.clamp(Integer.valueOf(doubleValue));
            doubleValue = clamp.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                str = str + String.format("\nClamped to range %s -> %dbps", range, clamp);
            }
        }
        Logger.d(TAG, str);
        return doubleValue;
    }
}
