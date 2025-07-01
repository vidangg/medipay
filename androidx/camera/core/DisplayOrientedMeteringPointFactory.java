package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;

/* loaded from: classes.dex */
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(Display display, CameraInfo cameraInfo, float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
        this.mDisplay = display;
        this.mCameraInfo = cameraInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    @Override // androidx.camera.core.MeteringPointFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected PointF convertPoint(float f, float f2) {
        float f3 = this.mWidth;
        float f4 = this.mHeight;
        boolean z = this.mCameraInfo.getLensFacing() == 0;
        int relativeCameraOrientation = getRelativeCameraOrientation(z);
        if (relativeCameraOrientation != 90 && relativeCameraOrientation != 270) {
            f2 = f;
            f = f2;
            f4 = f3;
            f3 = f4;
        }
        if (relativeCameraOrientation != 90) {
            if (relativeCameraOrientation != 180) {
                if (relativeCameraOrientation == 270) {
                    f2 = f4 - f2;
                }
                if (z) {
                    f2 = f4 - f2;
                }
                return new PointF(f2 / f4, f / f3);
            }
            f2 = f4 - f2;
        }
        f = f3 - f;
        if (z) {
        }
        return new PointF(f2 / f4, f / f3);
    }

    private int getRelativeCameraOrientation(boolean z) {
        try {
            int sensorRotationDegrees = this.mCameraInfo.getSensorRotationDegrees(this.mDisplay.getRotation());
            return z ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
        } catch (Exception unused) {
            return 0;
        }
    }
}
