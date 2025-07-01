package io.flutter.plugins.camera;

import android.util.Log;
import androidx.media3.extractor.ts.TsExtractor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.camera.Messages;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public class Messages {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes4.dex */
    @interface CanIgnoreReturnValue {
    }

    /* loaded from: classes4.dex */
    public interface NullableResult<T> {
        void error(Throwable th);

        void success(T t);
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void error(Throwable th);

        void success(T t);
    }

    /* loaded from: classes4.dex */
    public interface VoidResult {
        void error(Throwable th);

        void success();
    }

    /* loaded from: classes4.dex */
    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String str, String str2, Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    protected static ArrayList<Object> wrapError(Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }

    protected static FlutterError createConnectionError(String str) {
        return new FlutterError("channel-error", "Unable to establish connection on channel: " + str + ".", "");
    }

    /* loaded from: classes4.dex */
    public enum PlatformCameraLensDirection {
        FRONT(0),
        BACK(1),
        EXTERNAL(2);

        final int index;

        PlatformCameraLensDirection(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum PlatformDeviceOrientation {
        PORTRAIT_UP(0),
        PORTRAIT_DOWN(1),
        LANDSCAPE_LEFT(2),
        LANDSCAPE_RIGHT(3);

        final int index;

        PlatformDeviceOrientation(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum PlatformExposureMode {
        AUTO(0),
        LOCKED(1);

        final int index;

        PlatformExposureMode(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum PlatformFocusMode {
        AUTO(0),
        LOCKED(1);

        final int index;

        PlatformFocusMode(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum PlatformResolutionPreset {
        LOW(0),
        MEDIUM(1),
        HIGH(2),
        VERY_HIGH(3),
        ULTRA_HIGH(4),
        MAX(5);

        final int index;

        PlatformResolutionPreset(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum PlatformImageFormatGroup {
        YUV420(0),
        JPEG(1),
        NV21(2);

        final int index;

        PlatformImageFormatGroup(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum PlatformFlashMode {
        OFF(0),
        AUTO(1),
        ALWAYS(2),
        TORCH(3);

        final int index;

        PlatformFlashMode(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PlatformCameraDescription {
        private PlatformCameraLensDirection lensDirection;
        private String name;
        private Long sensorOrientation;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.name = str;
        }

        public PlatformCameraLensDirection getLensDirection() {
            return this.lensDirection;
        }

        public void setLensDirection(PlatformCameraLensDirection platformCameraLensDirection) {
            if (platformCameraLensDirection == null) {
                throw new IllegalStateException("Nonnull field \"lensDirection\" is null.");
            }
            this.lensDirection = platformCameraLensDirection;
        }

        public Long getSensorOrientation() {
            return this.sensorOrientation;
        }

        public void setSensorOrientation(Long l) {
            if (l == null) {
                throw new IllegalStateException("Nonnull field \"sensorOrientation\" is null.");
            }
            this.sensorOrientation = l;
        }

        PlatformCameraDescription() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PlatformCameraDescription platformCameraDescription = (PlatformCameraDescription) obj;
            return this.name.equals(platformCameraDescription.name) && this.lensDirection.equals(platformCameraDescription.lensDirection) && this.sensorOrientation.equals(platformCameraDescription.sensorOrientation);
        }

        public int hashCode() {
            return Objects.hash(this.name, this.lensDirection, this.sensorOrientation);
        }

        /* loaded from: classes4.dex */
        public static final class Builder {
            private PlatformCameraLensDirection lensDirection;
            private String name;
            private Long sensorOrientation;

            public Builder setName(String str) {
                this.name = str;
                return this;
            }

            public Builder setLensDirection(PlatformCameraLensDirection platformCameraLensDirection) {
                this.lensDirection = platformCameraLensDirection;
                return this;
            }

            public Builder setSensorOrientation(Long l) {
                this.sensorOrientation = l;
                return this;
            }

            public PlatformCameraDescription build() {
                PlatformCameraDescription platformCameraDescription = new PlatformCameraDescription();
                platformCameraDescription.setName(this.name);
                platformCameraDescription.setLensDirection(this.lensDirection);
                platformCameraDescription.setSensorOrientation(this.sensorOrientation);
                return platformCameraDescription;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.name);
            arrayList.add(this.lensDirection);
            arrayList.add(this.sensorOrientation);
            return arrayList;
        }

        static PlatformCameraDescription fromList(ArrayList<Object> arrayList) {
            PlatformCameraDescription platformCameraDescription = new PlatformCameraDescription();
            platformCameraDescription.setName((String) arrayList.get(0));
            platformCameraDescription.setLensDirection((PlatformCameraLensDirection) arrayList.get(1));
            platformCameraDescription.setSensorOrientation((Long) arrayList.get(2));
            return platformCameraDescription;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PlatformCameraState {
        private PlatformExposureMode exposureMode;
        private Boolean exposurePointSupported;
        private PlatformFocusMode focusMode;
        private Boolean focusPointSupported;
        private PlatformSize previewSize;

        public PlatformSize getPreviewSize() {
            return this.previewSize;
        }

        public void setPreviewSize(PlatformSize platformSize) {
            if (platformSize == null) {
                throw new IllegalStateException("Nonnull field \"previewSize\" is null.");
            }
            this.previewSize = platformSize;
        }

        public PlatformExposureMode getExposureMode() {
            return this.exposureMode;
        }

        public void setExposureMode(PlatformExposureMode platformExposureMode) {
            if (platformExposureMode == null) {
                throw new IllegalStateException("Nonnull field \"exposureMode\" is null.");
            }
            this.exposureMode = platformExposureMode;
        }

        public PlatformFocusMode getFocusMode() {
            return this.focusMode;
        }

        public void setFocusMode(PlatformFocusMode platformFocusMode) {
            if (platformFocusMode == null) {
                throw new IllegalStateException("Nonnull field \"focusMode\" is null.");
            }
            this.focusMode = platformFocusMode;
        }

        public Boolean getExposurePointSupported() {
            return this.exposurePointSupported;
        }

        public void setExposurePointSupported(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"exposurePointSupported\" is null.");
            }
            this.exposurePointSupported = bool;
        }

        public Boolean getFocusPointSupported() {
            return this.focusPointSupported;
        }

        public void setFocusPointSupported(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"focusPointSupported\" is null.");
            }
            this.focusPointSupported = bool;
        }

        PlatformCameraState() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PlatformCameraState platformCameraState = (PlatformCameraState) obj;
            return this.previewSize.equals(platformCameraState.previewSize) && this.exposureMode.equals(platformCameraState.exposureMode) && this.focusMode.equals(platformCameraState.focusMode) && this.exposurePointSupported.equals(platformCameraState.exposurePointSupported) && this.focusPointSupported.equals(platformCameraState.focusPointSupported);
        }

        public int hashCode() {
            return Objects.hash(this.previewSize, this.exposureMode, this.focusMode, this.exposurePointSupported, this.focusPointSupported);
        }

        /* loaded from: classes4.dex */
        public static final class Builder {
            private PlatformExposureMode exposureMode;
            private Boolean exposurePointSupported;
            private PlatformFocusMode focusMode;
            private Boolean focusPointSupported;
            private PlatformSize previewSize;

            public Builder setPreviewSize(PlatformSize platformSize) {
                this.previewSize = platformSize;
                return this;
            }

            public Builder setExposureMode(PlatformExposureMode platformExposureMode) {
                this.exposureMode = platformExposureMode;
                return this;
            }

            public Builder setFocusMode(PlatformFocusMode platformFocusMode) {
                this.focusMode = platformFocusMode;
                return this;
            }

            public Builder setExposurePointSupported(Boolean bool) {
                this.exposurePointSupported = bool;
                return this;
            }

            public Builder setFocusPointSupported(Boolean bool) {
                this.focusPointSupported = bool;
                return this;
            }

            public PlatformCameraState build() {
                PlatformCameraState platformCameraState = new PlatformCameraState();
                platformCameraState.setPreviewSize(this.previewSize);
                platformCameraState.setExposureMode(this.exposureMode);
                platformCameraState.setFocusMode(this.focusMode);
                platformCameraState.setExposurePointSupported(this.exposurePointSupported);
                platformCameraState.setFocusPointSupported(this.focusPointSupported);
                return platformCameraState;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.previewSize);
            arrayList.add(this.exposureMode);
            arrayList.add(this.focusMode);
            arrayList.add(this.exposurePointSupported);
            arrayList.add(this.focusPointSupported);
            return arrayList;
        }

        static PlatformCameraState fromList(ArrayList<Object> arrayList) {
            PlatformCameraState platformCameraState = new PlatformCameraState();
            platformCameraState.setPreviewSize((PlatformSize) arrayList.get(0));
            platformCameraState.setExposureMode((PlatformExposureMode) arrayList.get(1));
            platformCameraState.setFocusMode((PlatformFocusMode) arrayList.get(2));
            platformCameraState.setExposurePointSupported((Boolean) arrayList.get(3));
            platformCameraState.setFocusPointSupported((Boolean) arrayList.get(4));
            return platformCameraState;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PlatformSize {
        private Double height;
        private Double width;

        public Double getWidth() {
            return this.width;
        }

        public void setWidth(Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"width\" is null.");
            }
            this.width = d;
        }

        public Double getHeight() {
            return this.height;
        }

        public void setHeight(Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"height\" is null.");
            }
            this.height = d;
        }

        PlatformSize() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PlatformSize platformSize = (PlatformSize) obj;
            return this.width.equals(platformSize.width) && this.height.equals(platformSize.height);
        }

        public int hashCode() {
            return Objects.hash(this.width, this.height);
        }

        /* loaded from: classes4.dex */
        public static final class Builder {
            private Double height;
            private Double width;

            public Builder setWidth(Double d) {
                this.width = d;
                return this;
            }

            public Builder setHeight(Double d) {
                this.height = d;
                return this;
            }

            public PlatformSize build() {
                PlatformSize platformSize = new PlatformSize();
                platformSize.setWidth(this.width);
                platformSize.setHeight(this.height);
                return platformSize;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.width);
            arrayList.add(this.height);
            return arrayList;
        }

        static PlatformSize fromList(ArrayList<Object> arrayList) {
            PlatformSize platformSize = new PlatformSize();
            platformSize.setWidth((Double) arrayList.get(0));
            platformSize.setHeight((Double) arrayList.get(1));
            return platformSize;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PlatformPoint {
        private Double x;
        private Double y;

        public Double getX() {
            return this.x;
        }

        public void setX(Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"x\" is null.");
            }
            this.x = d;
        }

        public Double getY() {
            return this.y;
        }

        public void setY(Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"y\" is null.");
            }
            this.y = d;
        }

        PlatformPoint() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PlatformPoint platformPoint = (PlatformPoint) obj;
            return this.x.equals(platformPoint.x) && this.y.equals(platformPoint.y);
        }

        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        /* loaded from: classes4.dex */
        public static final class Builder {
            private Double x;
            private Double y;

            public Builder setX(Double d) {
                this.x = d;
                return this;
            }

            public Builder setY(Double d) {
                this.y = d;
                return this;
            }

            public PlatformPoint build() {
                PlatformPoint platformPoint = new PlatformPoint();
                platformPoint.setX(this.x);
                platformPoint.setY(this.y);
                return platformPoint;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.x);
            arrayList.add(this.y);
            return arrayList;
        }

        static PlatformPoint fromList(ArrayList<Object> arrayList) {
            PlatformPoint platformPoint = new PlatformPoint();
            platformPoint.setX((Double) arrayList.get(0));
            platformPoint.setY((Double) arrayList.get(1));
            return platformPoint;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PlatformMediaSettings {
        private Long audioBitrate;
        private Boolean enableAudio;
        private Long fps;
        private PlatformResolutionPreset resolutionPreset;
        private Long videoBitrate;

        public PlatformResolutionPreset getResolutionPreset() {
            return this.resolutionPreset;
        }

        public void setResolutionPreset(PlatformResolutionPreset platformResolutionPreset) {
            if (platformResolutionPreset == null) {
                throw new IllegalStateException("Nonnull field \"resolutionPreset\" is null.");
            }
            this.resolutionPreset = platformResolutionPreset;
        }

        public Long getFps() {
            return this.fps;
        }

        public void setFps(Long l) {
            this.fps = l;
        }

        public Long getVideoBitrate() {
            return this.videoBitrate;
        }

        public void setVideoBitrate(Long l) {
            this.videoBitrate = l;
        }

        public Long getAudioBitrate() {
            return this.audioBitrate;
        }

        public void setAudioBitrate(Long l) {
            this.audioBitrate = l;
        }

        public Boolean getEnableAudio() {
            return this.enableAudio;
        }

        public void setEnableAudio(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"enableAudio\" is null.");
            }
            this.enableAudio = bool;
        }

        PlatformMediaSettings() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PlatformMediaSettings platformMediaSettings = (PlatformMediaSettings) obj;
            return this.resolutionPreset.equals(platformMediaSettings.resolutionPreset) && Objects.equals(this.fps, platformMediaSettings.fps) && Objects.equals(this.videoBitrate, platformMediaSettings.videoBitrate) && Objects.equals(this.audioBitrate, platformMediaSettings.audioBitrate) && this.enableAudio.equals(platformMediaSettings.enableAudio);
        }

        public int hashCode() {
            return Objects.hash(this.resolutionPreset, this.fps, this.videoBitrate, this.audioBitrate, this.enableAudio);
        }

        /* loaded from: classes4.dex */
        public static final class Builder {
            private Long audioBitrate;
            private Boolean enableAudio;
            private Long fps;
            private PlatformResolutionPreset resolutionPreset;
            private Long videoBitrate;

            public Builder setResolutionPreset(PlatformResolutionPreset platformResolutionPreset) {
                this.resolutionPreset = platformResolutionPreset;
                return this;
            }

            public Builder setFps(Long l) {
                this.fps = l;
                return this;
            }

            public Builder setVideoBitrate(Long l) {
                this.videoBitrate = l;
                return this;
            }

            public Builder setAudioBitrate(Long l) {
                this.audioBitrate = l;
                return this;
            }

            public Builder setEnableAudio(Boolean bool) {
                this.enableAudio = bool;
                return this;
            }

            public PlatformMediaSettings build() {
                PlatformMediaSettings platformMediaSettings = new PlatformMediaSettings();
                platformMediaSettings.setResolutionPreset(this.resolutionPreset);
                platformMediaSettings.setFps(this.fps);
                platformMediaSettings.setVideoBitrate(this.videoBitrate);
                platformMediaSettings.setAudioBitrate(this.audioBitrate);
                platformMediaSettings.setEnableAudio(this.enableAudio);
                return platformMediaSettings;
            }
        }

        ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.resolutionPreset);
            arrayList.add(this.fps);
            arrayList.add(this.videoBitrate);
            arrayList.add(this.audioBitrate);
            arrayList.add(this.enableAudio);
            return arrayList;
        }

        static PlatformMediaSettings fromList(ArrayList<Object> arrayList) {
            PlatformMediaSettings platformMediaSettings = new PlatformMediaSettings();
            platformMediaSettings.setResolutionPreset((PlatformResolutionPreset) arrayList.get(0));
            platformMediaSettings.setFps((Long) arrayList.get(1));
            platformMediaSettings.setVideoBitrate((Long) arrayList.get(2));
            platformMediaSettings.setAudioBitrate((Long) arrayList.get(3));
            platformMediaSettings.setEnableAudio((Boolean) arrayList.get(4));
            return platformMediaSettings;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class PigeonCodec extends StandardMessageCodec {
        public static final PigeonCodec INSTANCE = new PigeonCodec();

        private PigeonCodec() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case -127:
                    Object readValue = readValue(byteBuffer);
                    if (readValue == null) {
                        return null;
                    }
                    return PlatformCameraLensDirection.values()[((Long) readValue).intValue()];
                case -126:
                    Object readValue2 = readValue(byteBuffer);
                    if (readValue2 == null) {
                        return null;
                    }
                    return PlatformDeviceOrientation.values()[((Long) readValue2).intValue()];
                case -125:
                    Object readValue3 = readValue(byteBuffer);
                    if (readValue3 == null) {
                        return null;
                    }
                    return PlatformExposureMode.values()[((Long) readValue3).intValue()];
                case -124:
                    Object readValue4 = readValue(byteBuffer);
                    if (readValue4 == null) {
                        return null;
                    }
                    return PlatformFocusMode.values()[((Long) readValue4).intValue()];
                case -123:
                    Object readValue5 = readValue(byteBuffer);
                    if (readValue5 == null) {
                        return null;
                    }
                    return PlatformResolutionPreset.values()[((Long) readValue5).intValue()];
                case -122:
                    Object readValue6 = readValue(byteBuffer);
                    if (readValue6 == null) {
                        return null;
                    }
                    return PlatformImageFormatGroup.values()[((Long) readValue6).intValue()];
                case -121:
                    Object readValue7 = readValue(byteBuffer);
                    if (readValue7 == null) {
                        return null;
                    }
                    return PlatformFlashMode.values()[((Long) readValue7).intValue()];
                case -120:
                    return PlatformCameraDescription.fromList((ArrayList) readValue(byteBuffer));
                case -119:
                    return PlatformCameraState.fromList((ArrayList) readValue(byteBuffer));
                case -118:
                    return PlatformSize.fromList((ArrayList) readValue(byteBuffer));
                case -117:
                    return PlatformPoint.fromList((ArrayList) readValue(byteBuffer));
                case -116:
                    return PlatformMediaSettings.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof PlatformCameraLensDirection) {
                byteArrayOutputStream.write(TsExtractor.TS_STREAM_TYPE_AC3);
                writeValue(byteArrayOutputStream, obj != null ? Integer.valueOf(((PlatformCameraLensDirection) obj).index) : null);
                return;
            }
            if (obj instanceof PlatformDeviceOrientation) {
                byteArrayOutputStream.write(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                writeValue(byteArrayOutputStream, obj != null ? Integer.valueOf(((PlatformDeviceOrientation) obj).index) : null);
                return;
            }
            if (obj instanceof PlatformExposureMode) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, obj != null ? Integer.valueOf(((PlatformExposureMode) obj).index) : null);
                return;
            }
            if (obj instanceof PlatformFocusMode) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, obj != null ? Integer.valueOf(((PlatformFocusMode) obj).index) : null);
                return;
            }
            if (obj instanceof PlatformResolutionPreset) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, obj != null ? Integer.valueOf(((PlatformResolutionPreset) obj).index) : null);
                return;
            }
            if (obj instanceof PlatformImageFormatGroup) {
                byteArrayOutputStream.write(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO);
                writeValue(byteArrayOutputStream, obj != null ? Integer.valueOf(((PlatformImageFormatGroup) obj).index) : null);
                return;
            }
            if (obj instanceof PlatformFlashMode) {
                byteArrayOutputStream.write(TsExtractor.TS_STREAM_TYPE_E_AC3);
                writeValue(byteArrayOutputStream, obj != null ? Integer.valueOf(((PlatformFlashMode) obj).index) : null);
                return;
            }
            if (obj instanceof PlatformCameraDescription) {
                byteArrayOutputStream.write(TsExtractor.TS_STREAM_TYPE_DTS_HD);
                writeValue(byteArrayOutputStream, ((PlatformCameraDescription) obj).toList());
                return;
            }
            if (obj instanceof PlatformCameraState) {
                byteArrayOutputStream.write(137);
                writeValue(byteArrayOutputStream, ((PlatformCameraState) obj).toList());
                return;
            }
            if (obj instanceof PlatformSize) {
                byteArrayOutputStream.write(TsExtractor.TS_STREAM_TYPE_DTS);
                writeValue(byteArrayOutputStream, ((PlatformSize) obj).toList());
            } else if (obj instanceof PlatformPoint) {
                byteArrayOutputStream.write(TsExtractor.TS_STREAM_TYPE_DTS_UHD);
                writeValue(byteArrayOutputStream, ((PlatformPoint) obj).toList());
            } else if (obj instanceof PlatformMediaSettings) {
                byteArrayOutputStream.write(140);
                writeValue(byteArrayOutputStream, ((PlatformMediaSettings) obj).toList());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface CameraApi {
        void create(String str, PlatformMediaSettings platformMediaSettings, Result<Long> result);

        void dispose();

        List<PlatformCameraDescription> getAvailableCameras();

        Double getExposureOffsetStepSize();

        Double getMaxExposureOffset();

        Double getMaxZoomLevel();

        Double getMinExposureOffset();

        Double getMinZoomLevel();

        void initialize(PlatformImageFormatGroup platformImageFormatGroup);

        void lockCaptureOrientation(PlatformDeviceOrientation platformDeviceOrientation);

        void pausePreview();

        void pauseVideoRecording();

        void resumePreview();

        void resumeVideoRecording();

        void setDescriptionWhileRecording(String str);

        void setExposureMode(PlatformExposureMode platformExposureMode, VoidResult voidResult);

        void setExposureOffset(Double d, Result<Double> result);

        void setExposurePoint(PlatformPoint platformPoint, VoidResult voidResult);

        void setFlashMode(PlatformFlashMode platformFlashMode, VoidResult voidResult);

        void setFocusMode(PlatformFocusMode platformFocusMode);

        void setFocusPoint(PlatformPoint platformPoint, VoidResult voidResult);

        void setZoomLevel(Double d, VoidResult voidResult);

        void startImageStream();

        void startVideoRecording(Boolean bool);

        void stopImageStream();

        String stopVideoRecording();

        void takePicture(Result<String> result);

        void unlockCaptureOrientation();

        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        static void setUp(BinaryMessenger binaryMessenger, CameraApi cameraApi) {
            setUp(binaryMessenger, "", cameraApi);
        }

        static void setUp(BinaryMessenger binaryMessenger, String str, final CameraApi cameraApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.getAvailableCameras" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$0(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.create" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda2
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$1(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.initialize" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda12
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$2(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.dispose" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda13
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$3(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.lockCaptureOrientation" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda14
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$4(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.unlockCaptureOrientation" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda15
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$5(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.takePicture" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda16
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$6(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.startVideoRecording" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda17
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$7(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.stopVideoRecording" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda18
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$8(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.pauseVideoRecording" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda19
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$9(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.resumeVideoRecording" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda11
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$10(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.startImageStream" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda20
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$11(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel12.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.stopImageStream" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda21
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$12(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel13.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setFlashMode" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda22
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$13(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel14.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setExposureMode" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel15.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda23
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$14(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel15.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setExposurePoint" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel16.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda24
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$15(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel16.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.getMinExposureOffset" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel17.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda25
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$16(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel17.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.getMaxExposureOffset" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel18.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda26
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$17(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel18.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.getExposureOffsetStepSize" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel19.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda27
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$18(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel19.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setExposureOffset" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel20.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$19(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel20.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setFocusMode" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel21.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda3
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$20(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel21.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setFocusPoint" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel22.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda4
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$21(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel22.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel23 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.getMaxZoomLevel" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel23.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda5
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$22(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel23.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel24 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.getMinZoomLevel" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel24.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda6
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$23(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel24.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel25 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setZoomLevel" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel25.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda7
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$24(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel25.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel26 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.pausePreview" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel26.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda8
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$25(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel26.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel27 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.resumePreview" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel27.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda9
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$26(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel27.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel28 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.camera_android.CameraApi.setDescriptionWhileRecording" + str2, getCodec());
            if (cameraApi != null) {
                basicMessageChannel28.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.camera.Messages$CameraApi$$ExternalSyntheticLambda10
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.CameraApi.lambda$setUp$27(Messages.CameraApi.this, obj, reply);
                    }
                });
            } else {
                basicMessageChannel28.setMessageHandler(null);
            }
        }

        static /* synthetic */ void lambda$setUp$0(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getAvailableCameras());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$1(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            cameraApi.create((String) arrayList2.get(0), (PlatformMediaSettings) arrayList2.get(1), new Result<Long>() { // from class: io.flutter.plugins.camera.Messages.CameraApi.1
                @Override // io.flutter.plugins.camera.Messages.Result
                public void success(Long l) {
                    arrayList.add(0, l);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$2(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.initialize((PlatformImageFormatGroup) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$3(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.dispose();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$4(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.lockCaptureOrientation((PlatformDeviceOrientation) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$5(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.unlockCaptureOrientation();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$6(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.takePicture(new Result<String>() { // from class: io.flutter.plugins.camera.Messages.CameraApi.2
                @Override // io.flutter.plugins.camera.Messages.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$7(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.startVideoRecording((Boolean) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$8(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.stopVideoRecording());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$9(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.pauseVideoRecording();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$10(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.resumeVideoRecording();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$11(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.startImageStream();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$12(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.stopImageStream();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$13(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setFlashMode((PlatformFlashMode) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.3
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$14(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setExposureMode((PlatformExposureMode) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.4
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$15(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setExposurePoint((PlatformPoint) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.5
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$16(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMinExposureOffset());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$17(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMaxExposureOffset());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$18(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getExposureOffsetStepSize());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$19(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setExposureOffset((Double) ((ArrayList) obj).get(0), new Result<Double>() { // from class: io.flutter.plugins.camera.Messages.CameraApi.6
                @Override // io.flutter.plugins.camera.Messages.Result
                public void success(Double d) {
                    arrayList.add(0, d);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$20(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.setFocusMode((PlatformFocusMode) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$21(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setFocusPoint((PlatformPoint) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.7
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$22(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMaxZoomLevel());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$23(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMinZoomLevel());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$24(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setZoomLevel((Double) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.8
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }
            });
        }

        static /* synthetic */ void lambda$setUp$25(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.pausePreview();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$26(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.resumePreview();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void lambda$setUp$27(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.setDescriptionWhileRecording((String) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }
    }

    /* loaded from: classes4.dex */
    public static class CameraGlobalEventApi {
        private final BinaryMessenger binaryMessenger;
        private final String messageChannelSuffix;

        public CameraGlobalEventApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public CameraGlobalEventApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.binaryMessenger = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.messageChannelSuffix = str2;
        }

        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        public void deviceOrientationChanged(PlatformDeviceOrientation platformDeviceOrientation, final VoidResult voidResult) {
            final String str = "dev.flutter.pigeon.camera_android.CameraGlobalEventApi.deviceOrientationChanged" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str, getCodec()).send(new ArrayList(Collections.singletonList(platformDeviceOrientation)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.camera.Messages$CameraGlobalEventApi$$ExternalSyntheticLambda0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.CameraGlobalEventApi.lambda$deviceOrientationChanged$0(Messages.VoidResult.this, str, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$deviceOrientationChanged$0(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                    return;
                } else {
                    voidResult.success();
                    return;
                }
            }
            voidResult.error(Messages.createConnectionError(str));
        }
    }

    /* loaded from: classes4.dex */
    public static class CameraEventApi {
        private final BinaryMessenger binaryMessenger;
        private final String messageChannelSuffix;

        public CameraEventApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public CameraEventApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.binaryMessenger = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.messageChannelSuffix = str2;
        }

        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        public void initialized(PlatformCameraState platformCameraState, final VoidResult voidResult) {
            final String str = "dev.flutter.pigeon.camera_android.CameraEventApi.initialized" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str, getCodec()).send(new ArrayList(Collections.singletonList(platformCameraState)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.camera.Messages$CameraEventApi$$ExternalSyntheticLambda2
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.CameraEventApi.lambda$initialized$0(Messages.VoidResult.this, str, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$initialized$0(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                    return;
                } else {
                    voidResult.success();
                    return;
                }
            }
            voidResult.error(Messages.createConnectionError(str));
        }

        public void error(String str, final VoidResult voidResult) {
            final String str2 = "dev.flutter.pigeon.camera_android.CameraEventApi.error" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str2, getCodec()).send(new ArrayList(Collections.singletonList(str)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.camera.Messages$CameraEventApi$$ExternalSyntheticLambda0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.CameraEventApi.lambda$error$1(Messages.VoidResult.this, str2, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$error$1(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                    return;
                } else {
                    voidResult.success();
                    return;
                }
            }
            voidResult.error(Messages.createConnectionError(str));
        }

        public void closed(final VoidResult voidResult) {
            final String str = "dev.flutter.pigeon.camera_android.CameraEventApi.closed" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str, getCodec()).send(null, new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.camera.Messages$CameraEventApi$$ExternalSyntheticLambda1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.CameraEventApi.lambda$closed$2(Messages.VoidResult.this, str, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$closed$2(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                    return;
                } else {
                    voidResult.success();
                    return;
                }
            }
            voidResult.error(Messages.createConnectionError(str));
        }
    }
}
