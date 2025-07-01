package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.AutoValue_ResolutionInfo_ResolutionInfoInternal;

/* loaded from: classes.dex */
public class ResolutionInfo {
    private final ResolutionInfoInternal mResolutionInfoInternal;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class ResolutionInfoInternal {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static abstract class Builder {
            abstract ResolutionInfoInternal build();

            abstract Builder setCropRect(Rect rect);

            abstract Builder setResolution(Size size);

            abstract Builder setRotationDegrees(int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Rect getCropRect();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Size getResolution();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getRotationDegrees();
    }

    public ResolutionInfo(Size size, Rect rect, int i) {
        this.mResolutionInfoInternal = new AutoValue_ResolutionInfo_ResolutionInfoInternal.Builder().setResolution(size).setCropRect(rect).setRotationDegrees(i).build();
    }

    public Size getResolution() {
        return this.mResolutionInfoInternal.getResolution();
    }

    public Rect getCropRect() {
        return this.mResolutionInfoInternal.getCropRect();
    }

    public int getRotationDegrees() {
        return this.mResolutionInfoInternal.getRotationDegrees();
    }

    public int hashCode() {
        return this.mResolutionInfoInternal.hashCode();
    }

    public boolean equals(Object obj) {
        return this.mResolutionInfoInternal.equals(obj);
    }

    public String toString() {
        return this.mResolutionInfoInternal.toString();
    }
}
