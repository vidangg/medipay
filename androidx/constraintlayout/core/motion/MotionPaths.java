package androidx.constraintlayout.core.motion;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    HashMap<String, CustomVariable> customAttributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    private static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f5 - f3) * f) + ((f6 - f4) * f2) + f4;
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = motionPaths2.height;
        float f7 = motionPaths.height;
        this.position = this.time;
        float f8 = motionPaths.x;
        float f9 = motionPaths.y;
        float f10 = (motionPaths2.x + (f4 / 2.0f)) - ((f5 / 2.0f) + f8);
        float f11 = (motionPaths2.y + (f6 / 2.0f)) - (f9 + (f7 / 2.0f));
        float f12 = ((f4 - f5) * f2) / 2.0f;
        this.x = (int) ((f8 + (f10 * f)) - f12);
        float f13 = ((f6 - f7) * f3) / 2.0f;
        this.y = (int) ((f9 + (f11 * f)) - f13);
        this.width = (int) (f5 + r9);
        this.height = (int) (f7 + r12);
        float f14 = Float.isNaN(motionKeyPosition.mPercentX) ? f : motionKeyPosition.mPercentX;
        float f15 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f = motionKeyPosition.mPercentY;
        }
        float f16 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.x = (int) (((motionPaths.x + (f14 * f10)) + (f16 * f11)) - f12);
        this.y = (int) (((motionPaths.y + (f10 * f15)) + (f11 * f)) - f13);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i, i2, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i3 == 2) {
            initScreen(i, i2, motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    void initPolar(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float min;
        float f;
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (f6 + ((f5 - f6) * f3));
        this.height = (int) (f8 + ((f7 - f8) * f4));
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            float f9 = Float.isNaN(motionKeyPosition.mPercentX) ? f2 : motionKeyPosition.mPercentX;
            float f10 = motionPaths2.x;
            float f11 = motionPaths.x;
            this.x = (f9 * (f10 - f11)) + f11;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f2 = motionKeyPosition.mPercentY;
            }
            float f12 = motionPaths2.y;
            float f13 = motionPaths.y;
            this.y = (f2 * (f12 - f13)) + f13;
        } else if (i3 == 2) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f14 = motionPaths2.x;
                float f15 = motionPaths.x;
                min = ((f14 - f15) * f2) + f15;
            } else {
                min = Math.min(f4, f3) * motionKeyPosition.mPercentX;
            }
            this.x = min;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f16 = motionPaths2.y;
                float f17 = motionPaths.y;
                f = (f2 * (f16 - f17)) + f17;
            } else {
                f = motionKeyPosition.mPercentY;
            }
            this.y = f;
        } else {
            float f18 = Float.isNaN(motionKeyPosition.mPercentX) ? f2 : motionKeyPosition.mPercentX;
            float f19 = motionPaths2.x;
            float f20 = motionPaths.x;
            this.x = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f2 = motionKeyPosition.mPercentY;
            }
            float f21 = motionPaths2.y;
            float f22 = motionPaths.y;
            this.y = (f2 * (f21 - f22)) + f22;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = ((this.x + (this.width / 2.0f)) - motionPaths.x) - (motionPaths.width / 2.0f);
        double d2 = ((this.y + (this.height / 2.0f)) - motionPaths.y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
        this.x = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    void initScreen(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = motionPaths2.height;
        float f7 = motionPaths.height;
        this.position = this.time;
        float f8 = motionPaths.x;
        float f9 = motionPaths.y;
        float f10 = motionPaths2.x + (f4 / 2.0f);
        float f11 = motionPaths2.y + (f6 / 2.0f);
        float f12 = (f4 - f5) * f2;
        this.x = (int) ((f8 + ((f10 - ((f5 / 2.0f) + f8)) * f)) - (f12 / 2.0f));
        float f13 = (f6 - f7) * f3;
        this.y = (int) ((f9 + ((f11 - (f9 + (f7 / 2.0f))) * f)) - (f13 / 2.0f));
        this.width = (int) (f5 + f12);
        this.height = (int) (f7 + f13);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.x = (int) (motionKeyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.y = (int) (motionKeyPosition.mPercentY * ((int) (i2 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.width - motionPaths.width;
        float f5 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f = motionKeyPosition.mPercentX;
        }
        float f6 = motionPaths.x;
        float f7 = motionPaths.width;
        float f8 = motionPaths.y;
        float f9 = motionPaths.height;
        float f10 = (motionPaths2.x + (motionPaths2.width / 2.0f)) - ((f7 / 2.0f) + f6);
        float f11 = (motionPaths2.y + (motionPaths2.height / 2.0f)) - ((f9 / 2.0f) + f8);
        float f12 = f10 * f;
        float f13 = (f4 * f2) / 2.0f;
        this.x = (int) ((f6 + f12) - f13);
        float f14 = f * f11;
        float f15 = (f5 * f3) / 2.0f;
        this.y = (int) ((f8 + f14) - f15);
        this.width = (int) (f7 + r7);
        this.height = (int) (f9 + r8);
        float f16 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f17 = (int) ((motionPaths.x + f12) - f13);
        this.x = f17;
        float f18 = (int) ((motionPaths.y + f14) - f15);
        this.x = f17 + ((-f11) * f16);
        this.y = f18 + (f10 * f16);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    private boolean diff(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean diff = diff(this.x, motionPaths.x);
        boolean diff2 = diff(this.y, motionPaths.y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z2 = diff | diff2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = f6;
            double d3 = f;
            double d4 = f2;
            f = (float) ((d2 + (Math.sin(d4) * d3)) - (f3 / 2.0f));
            f2 = (float) ((f7 - (d3 * Math.cos(d4))) - (f4 / 2.0f));
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f10 = (float) dArr[i];
            float f11 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f2 = f10;
                f6 = f11;
            } else if (i2 == 2) {
                f3 = f10;
                f8 = f11;
            } else if (i2 == 3) {
                f4 = f10;
                f7 = f11;
            } else if (i2 == 4) {
                f5 = f10;
                f9 = f11;
            }
        }
        float f12 = 2.0f;
        float f13 = (f7 / 2.0f) + f6;
        float f14 = (f9 / 2.0f) + f8;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
            float f15 = fArr3[0];
            float f16 = fArr3[1];
            float f17 = fArr4[0];
            float f18 = fArr4[1];
            double d2 = f2;
            double d3 = f3;
            f = f4;
            float sin = (float) ((f15 + (Math.sin(d3) * d2)) - (f4 / 2.0f));
            float cos = (float) ((f16 - (d2 * Math.cos(d3))) - (f5 / 2.0f));
            double d4 = f6;
            double d5 = f8;
            float sin2 = (float) (f17 + (Math.sin(d3) * d4) + (Math.cos(d3) * d5));
            f14 = (float) ((f18 - (d4 * Math.cos(d3))) + (Math.sin(d3) * d5));
            f13 = sin2;
            f2 = sin;
            f3 = cos;
            f12 = 2.0f;
        } else {
            f = f4;
        }
        fArr[0] = f2 + (f / f12) + 0.0f;
        fArr[1] = f3 + (f5 / f12) + 0.0f;
        fArr2[0] = f13;
        fArr2[1] = f14;
    }

    void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = f6;
            double d3 = f;
            double d4 = f2;
            f = (float) ((d2 + (Math.sin(d4) * d3)) - (f3 / 2.0f));
            f2 = (float) ((f7 - (d3 * Math.cos(d4))) - (f4 / 2.0f));
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.width;
        float f2 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setView(float f, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f2;
        float f3;
        float f4;
        float f5 = this.x;
        float f6 = this.y;
        float f7 = this.width;
        float f8 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            double[] dArr4 = this.mTempValue;
            int i3 = iArr[i2];
            dArr4[i3] = dArr[i2];
            this.mTempDelta[i3] = dArr2[i2];
        }
        float f9 = Float.NaN;
        int i4 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i4 >= dArr5.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr5[i4]);
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (isNaN && (dArr3 == null || dArr3[i4] == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                f4 = f9;
            } else {
                if (dArr3 != null) {
                    d = dArr3[i4];
                }
                if (!Double.isNaN(this.mTempValue[i4])) {
                    d = this.mTempValue[i4] + d;
                }
                f4 = f9;
                float f14 = (float) d;
                float f15 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f9 = f4;
                    f5 = f14;
                    f10 = f15;
                } else if (i4 == 2) {
                    f9 = f4;
                    f6 = f14;
                    f11 = f15;
                } else if (i4 == 3) {
                    f9 = f4;
                    f7 = f14;
                    f12 = f15;
                } else if (i4 == 4) {
                    f9 = f4;
                    f8 = f14;
                    f13 = f15;
                } else if (i4 == 5) {
                    f9 = f14;
                }
                i4++;
            }
            f9 = f4;
            i4++;
        }
        float f16 = f9;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f, fArr, fArr2);
            float f17 = fArr[0];
            float f18 = fArr[1];
            float f19 = fArr2[0];
            float f20 = fArr2[1];
            double d2 = f5;
            double d3 = f6;
            float sin = (float) ((f17 + (Math.sin(d3) * d2)) - (f7 / 2.0f));
            float cos = (float) ((f18 - (Math.cos(d3) * d2)) - (f8 / 2.0f));
            double d4 = f10;
            f2 = f7;
            f3 = f8;
            double d5 = f11;
            float sin2 = (float) (f19 + (Math.sin(d3) * d4) + (Math.cos(d3) * d2 * d5));
            float cos2 = (float) ((f20 - (d4 * Math.cos(d3))) + (d2 * Math.sin(d3) * d5));
            if (dArr2.length >= 2) {
                dArr2[0] = sin2;
                dArr2[1] = cos2;
            }
            if (!Float.isNaN(f16)) {
                motionWidget.setRotationZ((float) (f16 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f5 = sin;
            f6 = cos;
        } else {
            f2 = f7;
            f3 = f8;
            if (!Float.isNaN(f16)) {
                motionWidget.setRotationZ((float) (0.0f + f16 + Math.toDegrees(Math.atan2(f11 + (f13 / 2.0f), f10 + (f12 / 2.0f)))));
            }
        }
        float f21 = f5 + 0.5f;
        float f22 = f6 + 0.5f;
        motionWidget.layout((int) f21, (int) f22, (int) (f21 + f2), (int) (f22 + f3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = f;
            double d2 = f2;
            float sin = (float) ((centerX + (Math.sin(d2) * d)) - (f3 / 2.0f));
            f2 = (float) ((centerY - (d * Math.cos(d2))) - (f4 / 2.0f));
            f = sin;
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f + 0.0f;
        fArr[i + 1] = f2 + 0.0f;
        fArr[i + 2] = f6 + 0.0f;
        fArr[i + 3] = f2 + 0.0f;
        fArr[i + 4] = f6 + 0.0f;
        fArr[i + 5] = f7 + 0.0f;
        fArr[i + 6] = f + 0.0f;
        fArr[i + 7] = f7 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = fArr[r1];
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i2 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[numberOfInterpolatedValues]);
        while (i2 < numberOfInterpolatedValues) {
            dArr[i] = r2[i2];
            i2++;
            i++;
        }
        return numberOfInterpolatedValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        this.mPathMotionArc = motionWidget.motion.mPathMotionArc;
        this.mAnimateRelativeTo = motionWidget.motion.mAnimateRelativeTo;
        this.mPathRotate = motionWidget.motion.mPathRotate;
        this.mDrawPath = motionWidget.motion.mDrawPath;
        this.mAnimateCircleAngleTo = motionWidget.motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }
}
