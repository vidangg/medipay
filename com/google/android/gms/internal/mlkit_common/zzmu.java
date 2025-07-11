package com.google.android.gms.internal.mlkit_common;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import com.google.firebase.messaging.ServiceStarter;
import com.google.mlkit.common.MlKitException;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes3.dex */
public enum zzmu implements zzba {
    NO_ERROR(0),
    INCOMPATIBLE_INPUT(1),
    INCOMPATIBLE_OUTPUT(2),
    INCOMPATIBLE_TFLITE_VERSION(3),
    MISSING_OP(4),
    DATA_TYPE_ERROR(6),
    TFLITE_INTERNAL_ERROR(7),
    TFLITE_UNKNOWN_ERROR(8),
    MEDIAPIPE_ERROR(9),
    TIME_OUT_FETCHING_MODEL_METADATA(5),
    MODEL_NOT_DOWNLOADED(100),
    URI_EXPIRED(101),
    NO_NETWORK_CONNECTION(102),
    METERED_NETWORK(103),
    DOWNLOAD_FAILED(104),
    MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS(105),
    MODEL_INFO_DOWNLOAD_NO_HASH(106),
    MODEL_INFO_DOWNLOAD_CONNECTION_FAILED(107),
    NO_VALID_MODEL(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR),
    LOCAL_MODEL_INVALID(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY),
    REMOTE_MODEL_INVALID(110),
    REMOTE_MODEL_LOADER_ERROR(111),
    REMOTE_MODEL_LOADER_LOADS_NO_MODEL(112),
    SMART_REPLY_LANG_ID_DETECTAION_FAILURE(113),
    MODEL_NOT_REGISTERED(114),
    MODEL_TYPE_MISUSE(115),
    MODEL_HASH_MISMATCH(AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID),
    OPTIONAL_MODULE_NOT_AVAILABLE(MlKitException.CODE_SCANNER_CANCELLED),
    OPTIONAL_MODULE_INIT_ERROR(MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED),
    OPTIONAL_MODULE_INFERENCE_ERROR(MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE),
    OPTIONAL_MODULE_RELEASE_ERROR(MlKitException.CODE_SCANNER_TASK_IN_PROGRESS),
    OPTIONAL_TFLITE_MODULE_INIT_ERROR(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR),
    NATIVE_LIBRARY_LOAD_ERROR(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR),
    OPTIONAL_MODULE_CREATE_ERROR(MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD),
    CAMERAX_SOURCE_ERROR(301),
    CAMERA1_SOURCE_CANT_START_ERROR(302),
    CAMERA1_SOURCE_NO_SUITABLE_SIZE_ERROR(303),
    CAMERA1_SOURCE_NO_SUITABLE_FPS_ERROR(304),
    CAMERA1_SOURCE_NO_BYTE_SOURCE_FOUND_ERROR(305),
    CODE_SCANNER_UNAVAILABLE(400),
    CODE_SCANNER_CANCELLED(TypedValues.CycleType.TYPE_CURVE_FIT),
    CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED(TypedValues.CycleType.TYPE_VISIBILITY),
    CODE_SCANNER_APP_NAME_UNAVAILABLE(TypedValues.CycleType.TYPE_ALPHA),
    CODE_SCANNER_TASK_IN_PROGRESS(404),
    CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR(405),
    CODE_SCANNER_PIPELINE_INFERENCE_ERROR(406),
    CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD(407),
    LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE(ServiceStarter.ERROR_UNKNOWN),
    LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE(TypedValues.PositionType.TYPE_TRANSITION_EASING),
    PERMISSION_DENIED(600),
    CANCELLED(601),
    GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE),
    LOW_MEMORY(TypedValues.MotionType.TYPE_EASING),
    UNKNOWN_ERROR(9999);

    private final int zzad;

    zzmu(int i) {
        this.zzad = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzba
    public final int zza() {
        return this.zzad;
    }
}
