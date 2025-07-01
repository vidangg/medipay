package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.List;

/* loaded from: classes.dex */
public final class OutputConfigurationCompat {
    public static final int STREAM_USE_CASE_NONE = -1;
    public static final int SURFACE_GROUP_ID_NONE = -1;
    private final OutputConfigurationCompatImpl mImpl;

    /* loaded from: classes.dex */
    interface OutputConfigurationCompatImpl {
        void addSurface(Surface surface);

        void enableSurfaceSharing();

        long getDynamicRangeProfile();

        int getMaxSharedSurfaceCount();

        Object getOutputConfiguration();

        String getPhysicalCameraId();

        long getStreamUseCase();

        Surface getSurface();

        int getSurfaceGroupId();

        List<Surface> getSurfaces();

        void removeSurface(Surface surface);

        void setDynamicRangeProfile(long j);

        void setPhysicalCameraId(String str);

        void setStreamUseCase(long j);
    }

    public OutputConfigurationCompat(Surface surface) {
        this(-1, surface);
    }

    public OutputConfigurationCompat(int i, Surface surface) {
        if (Build.VERSION.SDK_INT >= 33) {
            this.mImpl = new OutputConfigurationCompatApi33Impl(i, surface);
        } else {
            this.mImpl = new OutputConfigurationCompatApi28Impl(i, surface);
        }
    }

    public <T> OutputConfigurationCompat(Size size, Class<T> cls) {
        OutputConfiguration newOutputConfiguration = ApiCompat.Api26Impl.newOutputConfiguration(size, cls);
        if (Build.VERSION.SDK_INT >= 33) {
            this.mImpl = OutputConfigurationCompatApi33Impl.wrap(newOutputConfiguration);
        } else {
            this.mImpl = OutputConfigurationCompatApi28Impl.wrap(newOutputConfiguration);
        }
    }

    private OutputConfigurationCompat(OutputConfigurationCompatImpl outputConfigurationCompatImpl) {
        this.mImpl = outputConfigurationCompatImpl;
    }

    public static OutputConfigurationCompat wrap(Object obj) {
        OutputConfigurationCompatImpl wrap;
        if (obj == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            wrap = OutputConfigurationCompatApi33Impl.wrap((OutputConfiguration) obj);
        } else {
            wrap = OutputConfigurationCompatApi28Impl.wrap((OutputConfiguration) obj);
        }
        if (wrap == null) {
            return null;
        }
        return new OutputConfigurationCompat(wrap);
    }

    public void enableSurfaceSharing() {
        this.mImpl.enableSurfaceSharing();
    }

    public String getPhysicalCameraId() {
        return this.mImpl.getPhysicalCameraId();
    }

    public void setPhysicalCameraId(String str) {
        this.mImpl.setPhysicalCameraId(str);
    }

    public void addSurface(Surface surface) {
        this.mImpl.addSurface(surface);
    }

    public void removeSurface(Surface surface) {
        this.mImpl.removeSurface(surface);
    }

    public int getMaxSharedSurfaceCount() {
        return this.mImpl.getMaxSharedSurfaceCount();
    }

    public Surface getSurface() {
        return this.mImpl.getSurface();
    }

    public List<Surface> getSurfaces() {
        return this.mImpl.getSurfaces();
    }

    public int getSurfaceGroupId() {
        return this.mImpl.getSurfaceGroupId();
    }

    public long getDynamicRangeProfile() {
        return this.mImpl.getDynamicRangeProfile();
    }

    public void setDynamicRangeProfile(long j) {
        this.mImpl.setDynamicRangeProfile(j);
    }

    public void setStreamUseCase(long j) {
        this.mImpl.setStreamUseCase(j);
    }

    public long getStreamUseCase() {
        return this.mImpl.getStreamUseCase();
    }

    public boolean equals(Object obj) {
        if (obj instanceof OutputConfigurationCompat) {
            return this.mImpl.equals(((OutputConfigurationCompat) obj).mImpl);
        }
        return false;
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public Object unwrap() {
        return this.mImpl.getOutputConfiguration();
    }
}
