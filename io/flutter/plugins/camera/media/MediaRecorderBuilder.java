package io.flutter.plugins.camera.media;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.media.MediaRecorder;
import com.tekartik.sqflite.Database$$ExternalSyntheticApiModelOutline0;
import io.flutter.plugins.camera.SdkCapabilityChecker;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public class MediaRecorderBuilder {
    private final CamcorderProfile camcorderProfile;
    private boolean enableAudio;
    private final EncoderProfiles encoderProfiles;
    private int mediaOrientation;
    private final RecordingParameters parameters;
    private final MediaRecorderFactory recorderFactory;

    /* loaded from: classes4.dex */
    static class MediaRecorderFactory {
        MediaRecorderFactory() {
        }

        MediaRecorder makeMediaRecorder() {
            return new MediaRecorder();
        }
    }

    /* loaded from: classes4.dex */
    public static class RecordingParameters {
        public final Integer audioBitrate;
        public final Integer fps;
        public final String outputFilePath;
        public final Integer videoBitrate;

        public RecordingParameters(String str) {
            this(str, null, null, null);
        }

        public RecordingParameters(String str, Integer num, Integer num2, Integer num3) {
            this.outputFilePath = str;
            this.fps = num;
            this.videoBitrate = num2;
            this.audioBitrate = num3;
        }
    }

    public MediaRecorderBuilder(CamcorderProfile camcorderProfile, RecordingParameters recordingParameters) {
        this(camcorderProfile, new MediaRecorderFactory(), recordingParameters);
    }

    public MediaRecorderBuilder(EncoderProfiles encoderProfiles, RecordingParameters recordingParameters) {
        this(encoderProfiles, new MediaRecorderFactory(), recordingParameters);
    }

    MediaRecorderBuilder(CamcorderProfile camcorderProfile, MediaRecorderFactory mediaRecorderFactory, RecordingParameters recordingParameters) {
        this.camcorderProfile = camcorderProfile;
        this.encoderProfiles = null;
        this.recorderFactory = mediaRecorderFactory;
        this.parameters = recordingParameters;
    }

    MediaRecorderBuilder(EncoderProfiles encoderProfiles, MediaRecorderFactory mediaRecorderFactory, RecordingParameters recordingParameters) {
        this.encoderProfiles = encoderProfiles;
        this.camcorderProfile = null;
        this.recorderFactory = mediaRecorderFactory;
        this.parameters = recordingParameters;
    }

    public MediaRecorderBuilder setEnableAudio(boolean z) {
        this.enableAudio = z;
        return this;
    }

    public MediaRecorderBuilder setMediaOrientation(int i) {
        this.mediaOrientation = i;
        return this;
    }

    public MediaRecorder build() throws IOException, NullPointerException, IndexOutOfBoundsException {
        int i;
        int i2;
        int i3;
        EncoderProfiles encoderProfiles;
        int recommendedFileFormat;
        List videoProfiles;
        int codec;
        int bitrate;
        int frameRate;
        int width;
        int height;
        List audioProfiles;
        int codec2;
        int bitrate2;
        int sampleRate;
        MediaRecorder makeMediaRecorder = this.recorderFactory.makeMediaRecorder();
        if (this.enableAudio) {
            makeMediaRecorder.setAudioSource(1);
        }
        makeMediaRecorder.setVideoSource(2);
        if (SdkCapabilityChecker.supportsEncoderProfiles() && (encoderProfiles = this.encoderProfiles) != null) {
            recommendedFileFormat = encoderProfiles.getRecommendedFileFormat();
            makeMediaRecorder.setOutputFormat(recommendedFileFormat);
            videoProfiles = this.encoderProfiles.getVideoProfiles();
            EncoderProfiles.VideoProfile m733m = Database$$ExternalSyntheticApiModelOutline0.m733m(videoProfiles.get(0));
            if (this.enableAudio) {
                audioProfiles = this.encoderProfiles.getAudioProfiles();
                EncoderProfiles.AudioProfile m = Database$$ExternalSyntheticApiModelOutline0.m(audioProfiles.get(0));
                codec2 = m.getCodec();
                makeMediaRecorder.setAudioEncoder(codec2);
                if (this.parameters.audioBitrate != null && this.parameters.audioBitrate.intValue() > 0) {
                    bitrate2 = this.parameters.audioBitrate.intValue();
                } else {
                    bitrate2 = m.getBitrate();
                }
                makeMediaRecorder.setAudioEncodingBitRate(bitrate2);
                sampleRate = m.getSampleRate();
                makeMediaRecorder.setAudioSamplingRate(sampleRate);
            }
            codec = m733m.getCodec();
            makeMediaRecorder.setVideoEncoder(codec);
            if (this.parameters.videoBitrate != null && this.parameters.videoBitrate.intValue() > 0) {
                bitrate = this.parameters.videoBitrate.intValue();
            } else {
                bitrate = m733m.getBitrate();
            }
            makeMediaRecorder.setVideoEncodingBitRate(bitrate);
            if (this.parameters.fps != null && this.parameters.fps.intValue() > 0) {
                frameRate = this.parameters.fps.intValue();
            } else {
                frameRate = m733m.getFrameRate();
            }
            makeMediaRecorder.setVideoFrameRate(frameRate);
            width = m733m.getWidth();
            height = m733m.getHeight();
            makeMediaRecorder.setVideoSize(width, height);
        } else {
            CamcorderProfile camcorderProfile = this.camcorderProfile;
            if (camcorderProfile != null) {
                makeMediaRecorder.setOutputFormat(camcorderProfile.fileFormat);
                if (this.enableAudio) {
                    makeMediaRecorder.setAudioEncoder(this.camcorderProfile.audioCodec);
                    if (this.parameters.audioBitrate != null && this.parameters.audioBitrate.intValue() > 0) {
                        i3 = this.parameters.audioBitrate.intValue();
                    } else {
                        i3 = this.camcorderProfile.audioBitRate;
                    }
                    makeMediaRecorder.setAudioEncodingBitRate(i3);
                    makeMediaRecorder.setAudioSamplingRate(this.camcorderProfile.audioSampleRate);
                }
                makeMediaRecorder.setVideoEncoder(this.camcorderProfile.videoCodec);
                if (this.parameters.videoBitrate != null && this.parameters.videoBitrate.intValue() > 0) {
                    i = this.parameters.videoBitrate.intValue();
                } else {
                    i = this.camcorderProfile.videoBitRate;
                }
                makeMediaRecorder.setVideoEncodingBitRate(i);
                if (this.parameters.fps != null && this.parameters.fps.intValue() > 0) {
                    i2 = this.parameters.fps.intValue();
                } else {
                    i2 = this.camcorderProfile.videoFrameRate;
                }
                makeMediaRecorder.setVideoFrameRate(i2);
                makeMediaRecorder.setVideoSize(this.camcorderProfile.videoFrameWidth, this.camcorderProfile.videoFrameHeight);
            }
        }
        makeMediaRecorder.setOutputFile(this.parameters.outputFilePath);
        makeMediaRecorder.setOrientationHint(this.mediaOrientation);
        makeMediaRecorder.prepare();
        return makeMediaRecorder;
    }
}
