package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;

/* loaded from: classes.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    private float mProgress;
    float mTransitionPathRotate;
    Motion motion;
    PropertySet propertySet;
    WidgetFrame widgetFrame;

    /* loaded from: classes.dex */
    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;
    }

    /* loaded from: classes.dex */
    public static class PropertySet {
        public int visibility = 4;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
    }

    public MotionWidget findViewById(int i) {
        return null;
    }

    public MotionWidget getParent() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public MotionWidget() {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
    }

    public void setVisibility(int i) {
        this.propertySet.visibility = i;
    }

    public String getName() {
        return this.widgetFrame.getId();
    }

    public void layout(int i, int i2, int i3, int i4) {
        setBounds(i, i2, i3, i4);
    }

    public String toString() {
        return this.widgetFrame.left + ", " + this.widgetFrame.top + ", " + this.widgetFrame.right + ", " + this.widgetFrame.bottom;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.widgetFrame == null) {
            this.widgetFrame = new WidgetFrame((ConstraintWidget) null);
        }
        this.widgetFrame.top = i2;
        this.widgetFrame.left = i;
        this.widgetFrame.right = i3;
        this.widgetFrame.bottom = i4;
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
        this.widgetFrame = widgetFrame;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        return setValueAttributes(i, i2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (setValueAttributes(i, f)) {
            return true;
        }
        return setValueMotion(i, f);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        return setValueMotion(i, str);
    }

    public boolean setValueMotion(int i, int i2) {
        switch (i) {
            case TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO /* 605 */:
                this.motion.mAnimateRelativeTo = i2;
                return true;
            case TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO /* 606 */:
                this.motion.mAnimateCircleAngleTo = i2;
                return true;
            case TypedValues.MotionType.TYPE_PATHMOTION_ARC /* 607 */:
                this.motion.mPathMotionArc = i2;
                return true;
            case TypedValues.MotionType.TYPE_DRAW_PATH /* 608 */:
                this.motion.mDrawPath = i2;
                return true;
            case TypedValues.MotionType.TYPE_POLAR_RELATIVETO /* 609 */:
                this.motion.mPolarRelativeTo = i2;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS /* 610 */:
                this.motion.mQuantizeMotionSteps = i2;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE /* 611 */:
                this.motion.mQuantizeInterpolatorType = i2;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID /* 612 */:
                this.motion.mQuantizeInterpolatorID = i2;
                return true;
            default:
                return false;
        }
    }

    public boolean setValueMotion(int i, String str) {
        if (i == 603) {
            this.motion.mTransitionEasing = str;
            return true;
        }
        if (i != 604) {
            return false;
        }
        this.motion.mQuantizeInterpolatorString = str;
        return true;
    }

    public boolean setValueMotion(int i, float f) {
        switch (i) {
            case 600:
                this.motion.mMotionStagger = f;
                return true;
            case 601:
                this.motion.mPathRotate = f;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE /* 602 */:
                this.motion.mQuantizeMotionPhase = f;
                return true;
            default:
                return false;
        }
    }

    public boolean setValueAttributes(int i, float f) {
        switch (i) {
            case 303:
                this.widgetFrame.alpha = f;
                return true;
            case 304:
                this.widgetFrame.translationX = f;
                return true;
            case 305:
                this.widgetFrame.translationY = f;
                return true;
            case 306:
                this.widgetFrame.translationZ = f;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.widgetFrame.rotationX = f;
                return true;
            case 309:
                this.widgetFrame.rotationY = f;
                return true;
            case 310:
                this.widgetFrame.rotationZ = f;
                return true;
            case 311:
                this.widgetFrame.scaleX = f;
                return true;
            case 312:
                this.widgetFrame.scaleY = f;
                return true;
            case 313:
                this.widgetFrame.pivotX = f;
                return true;
            case 314:
                this.widgetFrame.pivotY = f;
                return true;
            case 315:
                this.mProgress = f;
                return true;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                this.mTransitionPathRotate = f;
                return true;
        }
    }

    public float getValueAttributes(int i) {
        switch (i) {
            case 303:
                return this.widgetFrame.alpha;
            case 304:
                return this.widgetFrame.translationX;
            case 305:
                return this.widgetFrame.translationY;
            case 306:
                return this.widgetFrame.translationZ;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.widgetFrame.rotationX;
            case 309:
                return this.widgetFrame.rotationY;
            case 310:
                return this.widgetFrame.rotationZ;
            case 311:
                return this.widgetFrame.scaleX;
            case 312:
                return this.widgetFrame.scaleY;
            case 313:
                return this.widgetFrame.pivotX;
            case 314:
                return this.widgetFrame.pivotY;
            case 315:
                return this.mProgress;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                return this.mTransitionPathRotate;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        int id = TypedValues.AttributesType.getId(str);
        return id != -1 ? id : TypedValues.MotionType.getId(str);
    }

    public int getTop() {
        return this.widgetFrame.top;
    }

    public int getLeft() {
        return this.widgetFrame.left;
    }

    public int getBottom() {
        return this.widgetFrame.bottom;
    }

    public int getRight() {
        return this.widgetFrame.right;
    }

    public void setPivotX(float f) {
        this.widgetFrame.pivotX = f;
    }

    public void setPivotY(float f) {
        this.widgetFrame.pivotY = f;
    }

    public float getRotationX() {
        return this.widgetFrame.rotationX;
    }

    public void setRotationX(float f) {
        this.widgetFrame.rotationX = f;
    }

    public float getRotationY() {
        return this.widgetFrame.rotationY;
    }

    public void setRotationY(float f) {
        this.widgetFrame.rotationY = f;
    }

    public float getRotationZ() {
        return this.widgetFrame.rotationZ;
    }

    public void setRotationZ(float f) {
        this.widgetFrame.rotationZ = f;
    }

    public float getTranslationX() {
        return this.widgetFrame.translationX;
    }

    public void setTranslationX(float f) {
        this.widgetFrame.translationX = f;
    }

    public float getTranslationY() {
        return this.widgetFrame.translationY;
    }

    public void setTranslationY(float f) {
        this.widgetFrame.translationY = f;
    }

    public void setTranslationZ(float f) {
        this.widgetFrame.translationZ = f;
    }

    public float getTranslationZ() {
        return this.widgetFrame.translationZ;
    }

    public float getScaleX() {
        return this.widgetFrame.scaleX;
    }

    public void setScaleX(float f) {
        this.widgetFrame.scaleX = f;
    }

    public float getScaleY() {
        return this.widgetFrame.scaleY;
    }

    public void setScaleY(float f) {
        this.widgetFrame.scaleY = f;
    }

    public int getVisibility() {
        return this.propertySet.visibility;
    }

    public float getPivotX() {
        return this.widgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.widgetFrame.pivotY;
    }

    public float getAlpha() {
        return this.propertySet.alpha;
    }

    public int getX() {
        return this.widgetFrame.left;
    }

    public int getY() {
        return this.widgetFrame.top;
    }

    public int getWidth() {
        return this.widgetFrame.right - this.widgetFrame.left;
    }

    public int getHeight() {
        return this.widgetFrame.bottom - this.widgetFrame.top;
    }

    public WidgetFrame getWidgetFrame() {
        return this.widgetFrame;
    }

    public Set<String> getCustomAttributeNames() {
        return this.widgetFrame.getCustomAttributeNames();
    }

    public void setCustomAttribute(String str, int i, float f) {
        this.widgetFrame.setCustomAttribute(str, i, f);
    }

    public void setCustomAttribute(String str, int i, int i2) {
        this.widgetFrame.setCustomAttribute(str, i, i2);
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        this.widgetFrame.setCustomAttribute(str, i, z);
    }

    public void setCustomAttribute(String str, int i, String str2) {
        this.widgetFrame.setCustomAttribute(str, i, str2);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.widgetFrame.getCustomAttribute(str);
    }

    public void setInterpolatedValue(CustomAttribute customAttribute, float[] fArr) {
        this.widgetFrame.setCustomAttribute(customAttribute.mName, TypedValues.Custom.TYPE_FLOAT, fArr[0]);
    }
}
