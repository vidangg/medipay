package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal;
import androidx.camera.video.OutputOptions;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class FileDescriptorOutputOptions extends OutputOptions {
    private final FileDescriptorOutputOptionsInternal mFileDescriptorOutputOptionsInternal;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class FileDescriptorOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public abstract FileDescriptorOutputOptionsInternal build();

            abstract Builder setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract ParcelFileDescriptor getParcelFileDescriptor();
    }

    FileDescriptorOutputOptions(FileDescriptorOutputOptionsInternal fileDescriptorOutputOptionsInternal) {
        super(fileDescriptorOutputOptionsInternal);
        this.mFileDescriptorOutputOptionsInternal = fileDescriptorOutputOptionsInternal;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mFileDescriptorOutputOptionsInternal.getParcelFileDescriptor();
    }

    public String toString() {
        return this.mFileDescriptorOutputOptionsInternal.toString().replaceFirst("FileDescriptorOutputOptionsInternal", "FileDescriptorOutputOptions");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileDescriptorOutputOptions) {
            return this.mFileDescriptorOutputOptionsInternal.equals(((FileDescriptorOutputOptions) obj).mFileDescriptorOutputOptionsInternal);
        }
        return false;
    }

    public int hashCode() {
        return this.mFileDescriptorOutputOptionsInternal.hashCode();
    }

    /* loaded from: classes.dex */
    public static final class Builder extends OutputOptions.Builder<FileDescriptorOutputOptions, Builder> {
        private final FileDescriptorOutputOptionsInternal.Builder mInternalBuilder;

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(long j) {
            return super.setDurationLimitMillis(j);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(long j) {
            return super.setFileSizeLimit(j);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setLocation(Location location) {
            return super.setLocation(location);
        }

        public Builder(ParcelFileDescriptor parcelFileDescriptor) {
            super(new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(parcelFileDescriptor, "File descriptor can't be null.");
            FileDescriptorOutputOptionsInternal.Builder builder = (FileDescriptorOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = builder;
            builder.setParcelFileDescriptor(parcelFileDescriptor);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.Builder
        public FileDescriptorOutputOptions build() {
            return new FileDescriptorOutputOptions(this.mInternalBuilder.build());
        }
    }
}
