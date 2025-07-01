package vn.ai.faceauth.sdk.presentation.presentation.widgets;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import paua.btj;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.CameraSource;

/* loaded from: classes4.dex */
public class PreferenceUtils {
    private static int POSE_DETECTOR_PERFORMANCE_MODE_FAST;

    static {
        btj.sfgt(PreferenceUtils.class, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID);
    }

    private PreferenceUtils() {
    }

    public static CameraSource.SizePair getCameraPreviewSizePair(Context context, int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        String tzend = btj.tzend(20);
        String tzend2 = btj.tzend(21);
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            return new CameraSource.SizePair(Size.parseSize(defaultSharedPreferences.getString(tzend, null)), Size.parseSize(defaultSharedPreferences.getString(tzend2, null)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static FaceDetectorOptions getFaceDetectorOptions() {
        return new FaceDetectorOptions.Builder().setLandmarkMode(1).setContourMode(2).setClassificationMode(1).setPerformanceMode(1).setMinFaceSize(0.1f).build();
    }

    public static boolean isCameraLiveViewportEnabled(Context context) {
        return false;
    }

    public static boolean shouldHideDetectionInfo(Context context) {
        return false;
    }
}
