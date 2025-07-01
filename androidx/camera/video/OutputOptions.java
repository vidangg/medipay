package androidx.camera.video;

import android.location.Location;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public abstract class OutputOptions {
    public static final int DURATION_UNLIMITED = 0;
    public static final int FILE_SIZE_UNLIMITED = 0;
    private final OutputOptionsInternal mOutputOptionsInternal;

    /* loaded from: classes.dex */
    static abstract class OutputOptionsInternal {

        /* loaded from: classes.dex */
        static abstract class Builder<B> {
            abstract OutputOptionsInternal build();

            abstract B setDurationLimitMillis(long j);

            abstract B setFileSizeLimit(long j);

            abstract B setLocation(Location location);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long getDurationLimitMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long getFileSizeLimit();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Location getLocation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputOptions(OutputOptionsInternal outputOptionsInternal) {
        this.mOutputOptionsInternal = outputOptionsInternal;
    }

    public long getFileSizeLimit() {
        return this.mOutputOptionsInternal.getFileSizeLimit();
    }

    public Location getLocation() {
        return this.mOutputOptionsInternal.getLocation();
    }

    public long getDurationLimitMillis() {
        return this.mOutputOptionsInternal.getDurationLimitMillis();
    }

    /* loaded from: classes.dex */
    static abstract class Builder<T extends OutputOptions, B> {
        final OutputOptionsInternal.Builder<?> mRootInternalBuilder;

        abstract T build();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(OutputOptionsInternal.Builder<?> builder) {
            this.mRootInternalBuilder = builder;
            builder.setFileSizeLimit(0L);
            builder.setDurationLimitMillis(0L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setFileSizeLimit(long j) {
            Preconditions.checkArgument(j >= 0, "The specified file size limit can't be negative.");
            this.mRootInternalBuilder.setFileSizeLimit(j);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setDurationLimitMillis(long j) {
            Preconditions.checkArgument(j >= 0, "The specified duration limit can't be negative.");
            this.mRootInternalBuilder.setDurationLimitMillis(j);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setLocation(Location location) {
            if (location != null) {
                Preconditions.checkArgument(location.getLatitude() >= -90.0d && location.getLatitude() <= 90.0d, "Latitude must be in the range [-90, 90]");
                Preconditions.checkArgument(location.getLongitude() >= -180.0d && location.getLongitude() <= 180.0d, "Longitude must be in the range [-180, 180]");
            }
            this.mRootInternalBuilder.setLocation(location);
            return this;
        }
    }
}
