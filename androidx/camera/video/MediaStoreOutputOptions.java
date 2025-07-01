package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import androidx.camera.video.AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal;
import androidx.camera.video.OutputOptions;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class MediaStoreOutputOptions extends OutputOptions {
    public static final ContentValues EMPTY_CONTENT_VALUES = new ContentValues();
    private final MediaStoreOutputOptionsInternal mMediaStoreOutputOptionsInternal;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class MediaStoreOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public abstract MediaStoreOutputOptionsInternal build();

            abstract Builder setCollectionUri(Uri uri);

            abstract Builder setContentResolver(ContentResolver contentResolver);

            abstract Builder setContentValues(ContentValues contentValues);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Uri getCollectionUri();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract ContentResolver getContentResolver();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract ContentValues getContentValues();
    }

    MediaStoreOutputOptions(MediaStoreOutputOptionsInternal mediaStoreOutputOptionsInternal) {
        super(mediaStoreOutputOptionsInternal);
        this.mMediaStoreOutputOptionsInternal = mediaStoreOutputOptionsInternal;
    }

    public ContentResolver getContentResolver() {
        return this.mMediaStoreOutputOptionsInternal.getContentResolver();
    }

    public Uri getCollectionUri() {
        return this.mMediaStoreOutputOptionsInternal.getCollectionUri();
    }

    public ContentValues getContentValues() {
        return this.mMediaStoreOutputOptionsInternal.getContentValues();
    }

    public String toString() {
        return this.mMediaStoreOutputOptionsInternal.toString().replaceFirst("MediaStoreOutputOptionsInternal", "MediaStoreOutputOptions");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaStoreOutputOptions) {
            return this.mMediaStoreOutputOptionsInternal.equals(((MediaStoreOutputOptions) obj).mMediaStoreOutputOptionsInternal);
        }
        return false;
    }

    public int hashCode() {
        return this.mMediaStoreOutputOptionsInternal.hashCode();
    }

    /* loaded from: classes.dex */
    public static final class Builder extends OutputOptions.Builder<MediaStoreOutputOptions, Builder> {
        private final MediaStoreOutputOptionsInternal.Builder mInternalBuilder;

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, androidx.camera.video.MediaStoreOutputOptions$Builder] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(long j) {
            return super.setDurationLimitMillis(j);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, androidx.camera.video.MediaStoreOutputOptions$Builder] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(long j) {
            return super.setFileSizeLimit(j);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, androidx.camera.video.MediaStoreOutputOptions$Builder] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setLocation(Location location) {
            return super.setLocation(location);
        }

        public Builder(ContentResolver contentResolver, Uri uri) {
            super(new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(contentResolver, "Content resolver can't be null.");
            Preconditions.checkNotNull(uri, "Collection Uri can't be null.");
            MediaStoreOutputOptionsInternal.Builder builder = (MediaStoreOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = builder;
            builder.setContentResolver(contentResolver).setCollectionUri(uri).setContentValues(MediaStoreOutputOptions.EMPTY_CONTENT_VALUES);
        }

        public Builder setContentValues(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "Content values can't be null.");
            this.mInternalBuilder.setContentValues(contentValues);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.Builder
        public MediaStoreOutputOptions build() {
            return new MediaStoreOutputOptions(this.mInternalBuilder.build());
        }
    }
}
