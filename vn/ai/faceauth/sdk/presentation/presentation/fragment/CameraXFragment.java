package vn.ai.faceauth.sdk.presentation.presentation.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.video.AudioStats;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.firebase.messaging.ServiceStarter;
import com.google.gson.Gson;
import com.tekartik.sqflite.Constant;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import paua.btj;
import vn.ai.faceauth.sdk.R;
import vn.ai.faceauth.sdk.camera.CameraX;
import vn.ai.faceauth.sdk.camera.core.callback.CameraXCallback;
import vn.ai.faceauth.sdk.camera.core.callback.CameraXCallbackFactory;
import vn.ai.faceauth.sdk.camera.navigation.CameraXNavigation;
import vn.ai.faceauth.sdk.core.extensions.ActivityExtensionsKt;
import vn.ai.faceauth.sdk.core.extensions.ImageExtensionsKt;
import vn.ai.faceauth.sdk.core.extensions.PrimitiveExtensionsKt;
import vn.ai.faceauth.sdk.domain.model.CameraSettingsDomain;
import vn.ai.faceauth.sdk.domain.model.PhotoResultDomain;
import vn.ai.faceauth.sdk.domain.model.StateFaceWithOval;
import vn.ai.faceauth.sdk.opencv.VFaceLib;
import vn.ai.faceauth.sdk.presentation.domain.configs.CameraSettings;
import vn.ai.faceauth.sdk.presentation.domain.configs.CameraSettingsKt;
import vn.ai.faceauth.sdk.presentation.domain.configs.LivenessConfig;
import vn.ai.faceauth.sdk.presentation.domain.configs.SDKConfig;
import vn.ai.faceauth.sdk.presentation.domain.model.StepLiveness;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;
import vn.ai.faceauth.sdk.presentation.navigation.SDKCallback;
import vn.ai.faceauth.sdk.presentation.presentation.opencv.Point;
import vn.ai.faceauth.sdk.presentation.presentation.utils.BShield;
import vn.ai.faceauth.sdk.presentation.presentation.utils.EnumPosition;
import vn.ai.faceauth.sdk.presentation.presentation.utils.UtilsKt;
import vn.ai.faceauth.sdk.presentation.presentation.viewmodel.LivenessViewModel;
import vn.ai.faceauth.sdk.presentation.presentation.viewmodel.LivenessViewModelFactory;
import vn.ai.faceauth.sdk.presentation.presentation.viewmodel.LivenessViewState;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.FaceDetectorProcessor;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.GraphicOverlay;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.OnCallbackOverlayListener;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.OverlayView;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.VisionImageProcessor;

@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010a\u001a\u00020bH\u0002J\b\u0010c\u001a\u00020bH\u0002J\b\u0010d\u001a\u00020bH\u0002J\u000e\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020gJ\u0018\u0010h\u001a\u0004\u0018\u00010.2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J$\u0010j\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u0010\u0010n\u001a\u00020b2\u0006\u0010o\u001a\u00020'H\u0002J\u0010\u0010p\u001a\u00020b2\u0006\u0010o\u001a\u00020'H\u0002J\b\u0010q\u001a\u00020bH\u0002J \u0010r\u001a\u00020g2\u0006\u0010f\u001a\u00020g2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020AH\u0002J\u0016\u0010v\u001a\u00020g2\u0006\u0010f\u001a\u00020g2\u0006\u0010w\u001a\u00020xJ\u0012\u0010y\u001a\u00020b2\b\u0010z\u001a\u0004\u0018\u00010GH\u0002J\b\u0010{\u001a\u00020bH\u0002J\b\u0010|\u001a\u00020bH\u0002J\b\u0010}\u001a\u00020bH\u0002J)\u0010~\u001a\u00020g2\u0006\u0010\u007f\u001a\u00020g2\u0017\u0010\u0080\u0001\u001a\u0012\u0012\u0004\u0012\u00020.0Fj\b\u0012\u0004\u0012\u00020.`HH\u0002J\u0007\u0010\u0081\u0001\u001a\u00020bJ\u0007\u0010\u0082\u0001\u001a\u00020bJ\u0007\u0010\u0083\u0001\u001a\u00020bJ\t\u0010\u0084\u0001\u001a\u00020bH\u0002J\t\u0010\u0085\u0001\u001a\u00020bH\u0002J\n\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002J\u001b\u0010\u0088\u0001\u001a\u00020b2\u0007\u0010\u0089\u0001\u001a\u00020'2\u0007\u0010\u008a\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u008b\u0001\u001a\u00020bH\u0002J\u0013\u0010\u008c\u0001\u001a\u00020b2\b\u0010o\u001a\u0004\u0018\u00010GH\u0002J\t\u0010\u008d\u0001\u001a\u00020bH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020b2\u0007\u0010\u008f\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u0090\u0001\u001a\u00020'H\u0002J\u001a\u0010\u0091\u0001\u001a\u00020'2\u0006\u0010f\u001a\u00020g2\t\b\u0002\u0010\u0092\u0001\u001a\u00020kJ\t\u0010\u0093\u0001\u001a\u00020'H\u0002J\"\u0010\u0094\u0001\u001a\u00020'2\u0017\u0010\u0080\u0001\u001a\u0012\u0012\u0004\u0012\u00020.0Fj\b\u0012\u0004\u0012\u00020.`HH\u0002J\t\u0010\u0095\u0001\u001a\u00020'H\u0002J0\u0010\u0096\u0001\u001a\u00020\u00052\u0007\u0010\u0097\u0001\u001a\u00020x2\u0006\u0010f\u001a\u00020g2\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020.0Fj\b\u0012\u0004\u0012\u00020.`HJ\u0007\u0010\u0098\u0001\u001a\u00020\u0005J\t\u0010\u0099\u0001\u001a\u00020bH\u0002J\u0013\u0010\u009a\u0001\u001a\u00020b2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\u0015\u0010\u009d\u0001\u001a\u00020b2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J+\u0010 \u0001\u001a\u00020\u001f2\b\u0010¡\u0001\u001a\u00030¢\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\t\u0010¥\u0001\u001a\u00020bH\u0016J\t\u0010¦\u0001\u001a\u00020bH\u0016J\t\u0010§\u0001\u001a\u00020bH\u0016J\t\u0010¨\u0001\u001a\u00020bH\u0016J\u001e\u0010©\u0001\u001a\u00020b2\u0007\u0010\u008f\u0001\u001a\u00020\u001f2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\t\u0010ª\u0001\u001a\u00020bH\u0016J\t\u0010«\u0001\u001a\u00020bH\u0016J\t\u0010¬\u0001\u001a\u00020bH\u0002J$\u0010\u00ad\u0001\u001a\u00020g2\u0007\u0010®\u0001\u001a\u00020g2\u0007\u0010¯\u0001\u001a\u00020A2\u0007\u0010°\u0001\u001a\u00020AH\u0002J\u0007\u0010±\u0001\u001a\u00020bJ\t\u0010²\u0001\u001a\u00020bH\u0002J\t\u0010³\u0001\u001a\u00020bH\u0002J\t\u0010´\u0001\u001a\u00020bH\u0002J\u0018\u0010µ\u0001\u001a\u00020b2\r\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0002J\t\u0010·\u0001\u001a\u00020bH\u0002J\t\u0010¸\u0001\u001a\u00020bH\u0002J\u0007\u0010¹\u0001\u001a\u00020bJ\u0011\u0010º\u0001\u001a\u00020b2\u0006\u0010o\u001a\u00020GH\u0002J\t\u0010»\u0001\u001a\u00020bH\u0002J\t\u0010¼\u0001\u001a\u00020bH\u0002J\t\u0010½\u0001\u001a\u00020bH\u0002J\t\u0010¾\u0001\u001a\u00020bH\u0002J\t\u0010¿\u0001\u001a\u00020bH\u0002J\t\u0010À\u0001\u001a\u00020bH\u0002J/\u0010Á\u0001\u001a\u00020b*\u00020\u001f2\u0007\u0010Â\u0001\u001a\u00020A2\u0007\u0010Ã\u0001\u001a\u00020A2\u0007\u0010Ä\u0001\u001a\u00020A2\u0007\u0010Å\u0001\u001a\u00020AR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00050\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0016\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R*\u0010E\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0082.¢\u0006\u0002\n\u0000¨\u0006Æ\u0001"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/fragment/CameraXFragment;", "Landroidx/fragment/app/Fragment;", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/OnCallbackOverlayListener;", "()V", "TAG", "", "btnAccept", "Landroid/widget/Button;", "btnBack", "Landroid/widget/ImageView;", "btnTryAgain", "buttonAcceptColor", "", "cameraManifest", "cameraPermission", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "cameraSettings", "Lvn/ai/faceauth/sdk/presentation/domain/configs/CameraSettings;", "getCameraSettings", "()Lvn/ai/faceauth/sdk/presentation/domain/configs/CameraSettings;", "cameraSettings$delegate", "Lkotlin/Lazy;", "cameraX", "Lvn/ai/faceauth/sdk/camera/CameraX;", "getCameraX", "()Lvn/ai/faceauth/sdk/camera/CameraX;", "cameraX$delegate", "cameraXCallback", "Lvn/ai/faceauth/sdk/camera/core/callback/CameraXCallback;", "clRoot", "Landroid/view/View;", "debounceDelay", "", "graphicOverlay", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/GraphicOverlay;", "imageProcessor", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/VisionImageProcessor;", "isCountDownFinished", "", "isCountDownRunning", "isCountDownZoomInStepRunning", "isEnableButtonProceed", "landmarksHistory", "", "", "Lvn/ai/faceauth/sdk/presentation/presentation/opencv/Point;", "lastHandledTime", "layoutStatus", "layoutSuccess", "livenessConfig", "Lvn/ai/faceauth/sdk/presentation/domain/configs/LivenessConfig;", "getLivenessConfig", "()Lvn/ai/faceauth/sdk/presentation/domain/configs/LivenessConfig;", "livenessConfig$delegate", "livenessViewModel", "Lvn/ai/faceauth/sdk/presentation/presentation/viewmodel/LivenessViewModel;", "getLivenessViewModel", "()Lvn/ai/faceauth/sdk/presentation/presentation/viewmodel/LivenessViewModel;", "livenessViewModel$delegate", "mapDataUploadAPI", "", "getMapDataUploadAPI", "()Ljava/util/Map;", "maxFrames", "", "movementThreshold", "overlayView", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/OverlayView;", "rawImage", "Ljava/util/ArrayList;", "Lvn/ai/faceauth/sdk/domain/model/PhotoResultDomain;", "Lkotlin/collections/ArrayList;", "getRawImage", "()Ljava/util/ArrayList;", "setRawImage", "(Ljava/util/ArrayList;)V", "retrycount", "getRetrycount", "()I", "setRetrycount", "(I)V", "timeStart", "getTimeStart", "()J", "setTimeStart", "(J)V", "timerFirstStep", "Landroid/os/CountDownTimer;", "timerZoomIn", "toolbarText", "Landroid/widget/TextView;", "tvFailedText", "tvStatusText", "tvSuccessText", "viewFinder", "Landroidx/camera/view/PreviewView;", "actionFailedUpdate", "", "actionRetry", "activeProcess", "bitmapToBase64", "bitmap", "Landroid/graphics/Bitmap;", "calculateBoundingBoxCenter", "points", "calculateLandmarkMovement", "", "from", TypedValues.TransitionType.S_TO, "checkFirst", "it", "checkZoomIn", "clearImageProcessor", "compressBitmap", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "cropBitmapWithFace", "rectFace", "Landroid/graphics/Rect;", "debounceHandlePicture", Constant.PARAM_RESULT, "deleteAllPictureOnCache", "disableButton", "enableButton", "faceAlignment", "finalBitmap", "landmarkPoints", "forceCloseSDK", "forceShowError", "forceShowSuccess", "forceToRetryCapture", "forceToRetryStep", "getConfig", "Lvn/ai/faceauth/sdk/presentation/domain/configs/SDKConfig;", "handleCameraPermission", "granted", "parentView", "handleFinished", "handlePictureSuccess", "initFaceDetector", "initViews", "view", "isAutoProcess", "isBitmapBlurry", "threshold", "isCancelable", "isFaceStable", "isLivenessConfirmed", "jsonObjectToBase64", "rect", "jsonTrackingToBase64", "nextStep", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onPause", "onStop", "onViewCreated", "onZoomOutAnimationEnd", "onZoomOutAnimationStart", "permissionIsGranted", "scaleBitmapWithCanvas", "original", "newWidth", "newHeight", "setupActionFaceSDK", "setupConfig", "setupStatusView", "setupViewAfterDrawOval", "startCallApi", "filesPath", "startCamera", "startObservers", "timeoutSDK", "tryReloadAndDetectInImage", "updateLayoutSuccessScan", "updateUIFailed", "updateUILiveFailed", "updateUINetworkFailed", "updateUIToZoomOut", "validDataAndCallApi", "setMargin", CmcdData.Factory.STREAM_TYPE_LIVE, "t", "r", "b", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class CameraXFragment extends Fragment implements OnCallbackOverlayListener {
    private final String TAG;
    private Button btnAccept;
    private ImageView btnBack;
    private Button btnTryAgain;
    private Object buttonAcceptColor;
    private final String cameraManifest;
    private final ActivityResultLauncher<String> cameraPermission;

    /* renamed from: cameraSettings$delegate, reason: from kotlin metadata */
    private final Lazy cameraSettings;

    /* renamed from: cameraX$delegate, reason: from kotlin metadata */
    private final Lazy cameraX;
    private final CameraXCallback cameraXCallback;
    private View clRoot;
    private final long debounceDelay;
    private GraphicOverlay graphicOverlay;
    private VisionImageProcessor imageProcessor;
    private boolean isCountDownFinished;
    private boolean isCountDownRunning;
    private boolean isCountDownZoomInStepRunning;
    private boolean isEnableButtonProceed;
    private final List<List<Point>> landmarksHistory;
    private long lastHandledTime;
    private View layoutStatus;
    private View layoutSuccess;

    /* renamed from: livenessConfig$delegate, reason: from kotlin metadata */
    private final Lazy livenessConfig;

    /* renamed from: livenessViewModel$delegate, reason: from kotlin metadata */
    private final Lazy livenessViewModel;
    private final Map<String, String> mapDataUploadAPI;
    private final int maxFrames;
    private final int movementThreshold;
    private OverlayView overlayView;
    private ArrayList<PhotoResultDomain> rawImage;
    private int retrycount;
    private long timeStart;
    private CountDownTimer timerFirstStep;
    private CountDownTimer timerZoomIn;
    private TextView toolbarText;
    private TextView tvFailedText;
    private TextView tvStatusText;
    private TextView tvSuccessText;
    private PreviewView viewFinder;

    public CameraXFragment() {
        super(R.layout.facesdk_fragment_camerax);
        this.TAG = btj.tzend(TypedValues.CycleType.TYPE_CURVE_FIT);
        this.cameraSettings = LazyKt.lazy(new Function0<CameraSettings>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$cameraSettings$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CameraSettings invoke() {
                Intent intent;
                Bundle extras;
                FragmentActivity activity = CameraXFragment.this.getActivity();
                CameraSettings cameraSettings = (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) ? null : (CameraSettings) extras.getParcelable(btj.tzend(PsExtractor.PRIVATE_STREAM_1));
                return cameraSettings == null ? new CameraSettings(null, null, 3, null) : cameraSettings;
            }
        });
        this.livenessConfig = LazyKt.lazy(new Function0<LivenessConfig>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$livenessConfig$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LivenessConfig invoke() {
                Intent intent;
                Bundle extras;
                FragmentActivity activity = CameraXFragment.this.getActivity();
                LivenessConfig livenessConfig = (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) ? null : (LivenessConfig) extras.getParcelable(btj.tzend(104));
                return livenessConfig == null ? new LivenessConfig(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : livenessConfig;
            }
        });
        Function0 function0 = new Function0<ViewModelProvider.Factory>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$livenessViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return new LivenessViewModelFactory(null, null, null, 7, null);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.livenessViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LivenessViewModel.class), new Function0<ViewModelStore>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStoreOwner m368viewModels$lambda1;
                m368viewModels$lambda1 = FragmentViewModelLazyKt.m368viewModels$lambda1(Lazy.this);
                return m368viewModels$lambda1.getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                ViewModelStoreOwner m368viewModels$lambda1;
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                m368viewModels$lambda1 = FragmentViewModelLazyKt.m368viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = m368viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) m368viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, function0 == null ? new Function0<ViewModelProvider.Factory>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelStoreOwner m368viewModels$lambda1;
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                m368viewModels$lambda1 = FragmentViewModelLazyKt.m368viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = m368viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) m368viewModels$lambda1 : null;
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? Fragment.this.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        } : function0);
        CameraXCallbackFactory cameraXCallbackFactory = CameraXCallbackFactory.INSTANCE;
        cameraXCallbackFactory.setOnImageSavedAction(new Function1<PhotoResultDomain, Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$cameraXCallback$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PhotoResultDomain photoResultDomain) {
                invoke2(photoResultDomain);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PhotoResultDomain photoResultDomain) {
                String str;
                str = CameraXFragment.this.TAG;
                Log.e(str, btj.tzend(312));
                CameraXFragment.this.debounceHandlePicture(photoResultDomain);
            }
        });
        this.cameraXCallback = cameraXCallbackFactory.create();
        this.debounceDelay = 50L;
        this.cameraX = LazyKt.lazy(new Function0<CameraX>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$cameraX$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CameraX invoke() {
                CameraSettings cameraSettings;
                CameraXCallback cameraXCallback;
                CameraXNavigation cameraXNavigation = new CameraXNavigation(CameraXFragment.this);
                cameraSettings = CameraXFragment.this.getCameraSettings();
                CameraSettingsDomain domain = CameraSettingsKt.toDomain(cameraSettings);
                cameraXCallback = CameraXFragment.this.cameraXCallback;
                return cameraXNavigation.provideCameraXModule(domain, cameraXCallback);
            }
        });
        this.cameraManifest = btj.tzend(TypedValues.CycleType.TYPE_VISIBILITY);
        this.cameraPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda4
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CameraXFragment.m2558cameraPermission$lambda1(CameraXFragment.this, (Boolean) obj);
            }
        });
        this.mapDataUploadAPI = new LinkedHashMap();
        this.landmarksHistory = new ArrayList();
        this.maxFrames = 10;
        this.movementThreshold = 20;
        this.rawImage = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void actionFailedUpdate() {
        requireActivity().runOnUiThread(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2557actionFailedUpdate$lambda18(CameraXFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: actionFailedUpdate$lambda-18, reason: not valid java name */
    public static final void m2557actionFailedUpdate$lambda18(CameraXFragment cameraXFragment) {
        cameraXFragment.getLivenessViewModel().reset();
        Button button = cameraXFragment.btnTryAgain;
        OverlayView overlayView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(TypedValues.CycleType.TYPE_ALPHA));
            button = null;
        }
        button.setVisibility(0);
        OverlayView overlayView2 = cameraXFragment.overlayView;
        if (overlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(404));
        } else {
            overlayView = overlayView2;
        }
        overlayView.changeColorOvalFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void actionRetry() {
        Button button = this.btnAccept;
        TextView textView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(405));
            button = null;
        }
        button.setVisibility(0);
        TextView textView2 = this.toolbarText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(406));
            textView2 = null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.tvFailedText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(407));
            textView3 = null;
        }
        textView3.setVisibility(8);
        Button button2 = this.btnTryAgain;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(408));
            button2 = null;
        }
        button2.setVisibility(8);
        this.isCountDownZoomInStepRunning = false;
        TextView textView4 = this.tvStatusText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(409));
        } else {
            textView = textView4;
        }
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        UtilsKt.setTextByKey(textView, btj.tzend(410), authenticationID.getJsonLanguage$authenSDK_release());
        disableButton();
        getLivenessViewModel().reDraw();
        setupStatusView();
        getLivenessViewModel().setFinished(false);
        this.rawImage.clear();
        getCameraX().deleteAllPictures();
        getLivenessViewModel().resetState();
        getLivenessViewModel().getRequestedSteps().clear();
        getLivenessViewModel().setupSteps(getCameraSettings().getLivenessStepList());
        CountDownTimer countDownTimer = this.timerFirstStep;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        authenticationID.resetTimeOut$authenSDK_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void activeProcess() {
        TextView textView = this.tvStatusText;
        Button button = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(411));
            textView = null;
        }
        UtilsKt.setTextByKey(textView, btj.tzend(412), AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release());
        TextView textView2 = this.tvFailedText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(413));
            textView2 = null;
        }
        textView2.setVisibility(8);
        Button button2 = this.btnAccept;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(414));
            button2 = null;
        }
        button2.setVisibility(4);
        TextView textView3 = this.toolbarText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(415));
            textView3 = null;
        }
        textView3.setVisibility(4);
        Button button3 = this.btnTryAgain;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(TypedValues.CycleType.TYPE_PATH_ROTATE));
        } else {
            button = button3;
        }
        button.setVisibility(4);
        CountDownTimer countDownTimer = this.timerFirstStep;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        getLivenessViewModel().removeCurrentStep();
        this.rawImage.clear();
        getCameraX().deleteAllPictures();
        Iterator it = CollectionsKt.toList(this.mapDataUploadAPI.keySet()).iterator();
        while (it.hasNext()) {
            this.mapDataUploadAPI.remove((String) it.next());
        }
        getLivenessViewModel().reset();
    }

    private final Point calculateBoundingBoxCenter(List<? extends Point> points) {
        if (points.isEmpty()) {
            return null;
        }
        Iterator<T> it = points.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double d = ((Point) it.next()).x;
        while (it.hasNext()) {
            d = Math.min(d, ((Point) it.next()).x);
        }
        Iterator<T> it2 = points.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        double d2 = ((Point) it2.next()).x;
        while (it2.hasNext()) {
            d2 = Math.max(d2, ((Point) it2.next()).x);
        }
        Iterator<T> it3 = points.iterator();
        if (!it3.hasNext()) {
            throw new NoSuchElementException();
        }
        double d3 = ((Point) it3.next()).y;
        while (it3.hasNext()) {
            d3 = Math.min(d3, ((Point) it3.next()).y);
        }
        Iterator<T> it4 = points.iterator();
        if (!it4.hasNext()) {
            throw new NoSuchElementException();
        }
        double d4 = ((Point) it4.next()).y;
        while (it4.hasNext()) {
            d4 = Math.max(d4, ((Point) it4.next()).y);
        }
        double d5 = 2;
        Double.isNaN(d5);
        Double.isNaN(d5);
        return new Point((d + d2) / d5, (d3 + d4) / d5);
    }

    private final double calculateLandmarkMovement(List<? extends Point> from, List<? extends Point> to) {
        Point calculateBoundingBoxCenter = calculateBoundingBoxCenter(from);
        Point calculateBoundingBoxCenter2 = calculateBoundingBoxCenter(to);
        if (calculateBoundingBoxCenter == null || calculateBoundingBoxCenter2 == null) {
            return Double.MAX_VALUE;
        }
        return Math.hypot(calculateBoundingBoxCenter.x - calculateBoundingBoxCenter2.x, calculateBoundingBoxCenter.y - calculateBoundingBoxCenter2.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cameraPermission$lambda-1, reason: not valid java name */
    public static final void m2558cameraPermission$lambda1(CameraXFragment cameraXFragment, Boolean bool) {
        boolean orFalse = PrimitiveExtensionsKt.orFalse(bool);
        View view = cameraXFragment.clRoot;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(417));
            view = null;
        }
        cameraXFragment.handleCameraPermission(orFalse, view);
    }

    private final void checkFirst(boolean it) {
        JSONObject jsonLanguage$authenSDK_release;
        int i;
        if (isAutoProcess()) {
            activeProcess();
            return;
        }
        String tzend = btj.tzend(418);
        TextView textView = null;
        if (it) {
            this.isEnableButtonProceed = true;
            enableButton();
            TextView textView2 = this.tvStatusText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
            } else {
                textView = textView2;
            }
            jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
            i = 419;
        } else {
            if (this.isCountDownRunning) {
                return;
            }
            CountDownTimer countDownTimer = this.timerFirstStep;
            if (countDownTimer != null) {
                countDownTimer.start();
            }
            this.isCountDownRunning = true;
            if (this.isCountDownFinished) {
                return;
            }
            TextView textView3 = this.tvStatusText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
            } else {
                textView = textView3;
            }
            jsonLanguage$authenSDK_release = AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release();
            i = TypedValues.CycleType.TYPE_EASING;
        }
        UtilsKt.setTextByKey(textView, btj.tzend(i), jsonLanguage$authenSDK_release);
    }

    private final void checkZoomIn(boolean it) {
        if (!it) {
            if (this.isCountDownZoomInStepRunning) {
                this.isCountDownZoomInStepRunning = false;
                CountDownTimer countDownTimer = this.timerZoomIn;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    return;
                }
                return;
            }
            return;
        }
        if (this.isCountDownZoomInStepRunning) {
            return;
        }
        this.isCountDownZoomInStepRunning = true;
        CountDownTimer countDownTimer2 = this.timerZoomIn;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
        TextView textView = this.tvStatusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(TypedValues.CycleType.TYPE_WAVE_SHAPE));
            textView = null;
        }
        textView.setText("");
    }

    private final void clearImageProcessor() {
        VisionImageProcessor visionImageProcessor;
        if (getActivity() == null || (visionImageProcessor = this.imageProcessor) == null) {
            return;
        }
        visionImageProcessor.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap compressBitmap(Bitmap bitmap, Bitmap.CompressFormat format, int quality) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(format, quality, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void debounceHandlePicture(PhotoResultDomain result) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastHandledTime >= this.debounceDelay) {
            this.lastHandledTime = currentTimeMillis;
            handlePictureSuccess(result);
        }
    }

    private final void deleteAllPictureOnCache() {
        Log.e(this.TAG, btj.tzend(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE));
        getCameraX().deleteAllPictures();
    }

    private final void disableButton() {
        Button button = this.btnAccept;
        String tzend = btj.tzend(TypedValues.CycleType.TYPE_WAVE_PERIOD);
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            button = null;
        }
        button.setEnabled(false);
        Button button3 = this.btnAccept;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
        } else {
            button2 = button3;
        }
        ImageExtensionsKt.setColorFilter(-3355444, button2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableButton() {
        Button button = this.btnAccept;
        String tzend = btj.tzend(TypedValues.CycleType.TYPE_WAVE_OFFSET);
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            button = null;
        }
        button.setEnabled(true);
        try {
            Object obj = this.buttonAcceptColor;
            String tzend2 = btj.tzend(TypedValues.CycleType.TYPE_WAVE_PHASE);
            if (obj == null) {
                throw new NullPointerException(tzend2);
            }
            int parseColor = Color.parseColor((String) obj);
            Button button3 = this.btnAccept;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                button3 = null;
            }
            ImageExtensionsKt.setColorFilter(parseColor, button3);
            Object obj2 = this.buttonAcceptColor;
            if (obj2 == null) {
                throw new NullPointerException(tzend2);
            }
            int parseColor2 = Color.parseColor((String) obj2);
            Button button4 = this.btnTryAgain;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(426));
            } else {
                button2 = button4;
            }
            ImageExtensionsKt.setColorFilter(parseColor2, button2);
        } catch (Exception e) {
            System.out.println((Object) e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap faceAlignment(Bitmap finalBitmap, ArrayList<Point> landmarkPoints) {
        Bitmap createBitmap = Bitmap.createBitmap(112, 112, Bitmap.Config.ARGB_8888);
        Point point = new Point(38.2946d, 51.6963d);
        Point point2 = new Point(73.5318d, 51.5014d);
        Point point3 = new Point(56.0252d, 71.7366d);
        Point point4 = new Point(41.5493d, 92.3655d);
        Point point5 = new Point(70.7299d, 92.2041d);
        ArrayList arrayList = new ArrayList();
        for (Point point6 : landmarkPoints) {
            CollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf((float) point6.x), Float.valueOf((float) point6.y)}));
        }
        float[] floatArray = CollectionsKt.toFloatArray(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Point point7 = new Point[]{point, point2, point3, point4, point5}[i];
            CollectionsKt.addAll(arrayList2, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf((float) point7.x), Float.valueOf((float) point7.y)}));
        }
        VFaceLib.INSTANCE.faceAlignment(createBitmap, finalBitmap, floatArray, CollectionsKt.toFloatArray(arrayList2));
        Log.e(this.TAG, btj.tzend(427));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: forceShowSuccess$lambda-40, reason: not valid java name */
    public static final void m2560forceShowSuccess$lambda40(CameraXFragment cameraXFragment) {
        cameraXFragment.requireActivity().finish();
    }

    private final void forceToRetryCapture() {
        Log.e(this.TAG, btj.tzend(428));
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2561forceToRetryCapture$lambda33(CameraXFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: forceToRetryCapture$lambda-33, reason: not valid java name */
    public static final void m2561forceToRetryCapture$lambda33(CameraXFragment cameraXFragment) {
        if (cameraXFragment.rawImage.size() == 0) {
            Log.e(cameraXFragment.TAG, btj.tzend(429));
            CameraX.DefaultImpls.takePicture$default(cameraXFragment.getCameraX(), null, 1, null);
        } else if (cameraXFragment.rawImage.size() == 2) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CameraXFragment$forceToRetryCapture$1$1(cameraXFragment, null), 3, null);
        }
    }

    private final void forceToRetryStep() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraSettings getCameraSettings() {
        return (CameraSettings) this.cameraSettings.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraX getCameraX() {
        return (CameraX) this.cameraX.getValue();
    }

    private final SDKConfig getConfig() {
        return AuthenticationID.INSTANCE.getSdkConfig$authenSDK_release();
    }

    private final LivenessConfig getLivenessConfig() {
        return (LivenessConfig) this.livenessConfig.getValue();
    }

    private final LivenessViewModel getLivenessViewModel() {
        return (LivenessViewModel) this.livenessViewModel.getValue();
    }

    private final void handleCameraPermission(boolean granted, View parentView) {
        if (granted) {
            permissionIsGranted();
            return;
        }
        SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
        if (callbackResult$authenSDK_release != null) {
            SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 306, btj.tzend(430), null, null, null, null, 60, null);
        }
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFinished() {
        this.timeStart = System.currentTimeMillis();
        OverlayView overlayView = this.overlayView;
        TextView textView = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(431));
            overlayView = null;
        }
        overlayView.showProcess();
        TextView textView2 = this.tvStatusText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(432));
        } else {
            textView = textView2;
        }
        UtilsKt.setTextByKey(textView, btj.tzend(433), AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release());
    }

    private final void handlePictureSuccess(PhotoResultDomain it) {
        Log.e(this.TAG, btj.tzend(434));
        if ((it != null ? it.getBitMap() : null) == null || this.rawImage.size() >= 2) {
            return;
        }
        clearImageProcessor();
        initFaceDetector();
        tryReloadAndDetectInImage(it);
    }

    private final void initFaceDetector() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.imageProcessor = new FaceDetectorProcessor(activity);
        }
    }

    private final void initViews(View view) {
        this.btnAccept = (Button) view.findViewById(R.id.btnAccept);
        this.btnBack = (ImageView) view.findViewById(R.id.btnBack);
        this.btnTryAgain = (Button) view.findViewById(R.id.btnTryAgain);
        this.tvStatusText = (TextView) view.findViewById(R.id.tvStatusText);
        this.toolbarText = (TextView) view.findViewById(R.id.toolbarText);
        this.tvSuccessText = (TextView) view.findViewById(R.id.tvSuccessText);
        this.tvFailedText = (TextView) view.findViewById(R.id.tvFailedText);
        this.overlayView = (OverlayView) view.findViewById(R.id.overlayView);
        this.layoutSuccess = view.findViewById(R.id.layoutSuccess);
        this.layoutStatus = view.findViewById(R.id.layoutStatus);
        this.graphicOverlay = (GraphicOverlay) view.findViewById(R.id.graphicOverlay);
        this.viewFinder = (PreviewView) view.findViewById(R.id.viewFinder);
        this.clRoot = view.findViewById(R.id.clRoot);
        OverlayView overlayView = this.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(435));
            overlayView = null;
        }
        overlayView.setOnCallbackOverlayListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAutoProcess() {
        return getConfig().isAutoProcess();
    }

    public static /* synthetic */ boolean isBitmapBlurry$default(CameraXFragment cameraXFragment, Bitmap bitmap, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 15.0d;
        }
        return cameraXFragment.isBitmapBlurry(bitmap, d);
    }

    private final boolean isCancelable() {
        return getConfig().isCancelable();
    }

    private final boolean isFaceStable(ArrayList<Point> landmarkPoints) {
        Log.d(this.TAG, btj.tzend(436));
        if (this.landmarksHistory.size() >= this.maxFrames) {
            this.landmarksHistory.remove(0);
        }
        this.landmarksHistory.add(landmarkPoints);
        if (this.landmarksHistory.size() < this.maxFrames - 5) {
            return false;
        }
        int size = this.landmarksHistory.size();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (int i = 0; i < size; i++) {
            int size2 = this.landmarksHistory.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (i != i2) {
                    d = Math.max(d, calculateLandmarkMovement(this.landmarksHistory.get(i), this.landmarksHistory.get(i2)));
                }
            }
        }
        Log.d(this.TAG, btj.tzend(437) + d);
        return d <= ((double) this.movementThreshold);
    }

    private final boolean isLivenessConfirmed() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nextStep() {
        Log.e(this.TAG, btj.tzend(438) + this.rawImage.size());
        deleteAllPictureOnCache();
        if (this.rawImage.size() == 1) {
            updateUIToZoomOut();
        } else if (this.rawImage.size() == 2) {
            getLivenessViewModel().callFinish();
            validDataAndCallApi();
        }
    }

    private final void permissionIsGranted() {
        startCamera();
        startObservers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap scaleBitmapWithCanvas(Bitmap original, int newWidth, int newHeight) {
        Bitmap createBitmap = Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(original, new Rect(0, 0, original.getWidth(), original.getHeight()), new Rect(0, 0, newWidth, newHeight), (Paint) null);
        return createBitmap;
    }

    private final void setupConfig() {
        try {
            String closeColor = getConfig().getCloseColor();
            ImageView imageView = this.btnBack;
            String tzend = btj.tzend(439);
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                imageView = null;
            }
            imageView.setColorFilter(Color.parseColor(closeColor), PorterDuff.Mode.SRC_IN);
            String obj = EnumPosition.LEFT.toString();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (Intrinsics.areEqual(obj, EnumPosition.RIGHT.toString())) {
                layoutParams.addRule(11);
                ImageView imageView2 = this.btnBack;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(tzend);
                    imageView2 = null;
                }
                imageView2.setLayoutParams(layoutParams);
            }
            if (Intrinsics.areEqual(obj, EnumPosition.NONE.toString())) {
                ImageView imageView3 = this.btnBack;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(tzend);
                    imageView3 = null;
                }
                imageView3.setVisibility(4);
                ImageView imageView4 = this.btnBack;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(tzend);
                    imageView4 = null;
                }
                imageView4.setEnabled(false);
            }
            ImageView imageView5 = this.btnBack;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                imageView5 = null;
            }
            imageView5.setEnabled(isCancelable());
            ImageView imageView6 = this.btnBack;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                imageView6 = null;
            }
            imageView6.setVisibility(isCancelable() ? 0 : 4);
            this.buttonAcceptColor = getConfig().getPrimaryColor();
            String textButtonColor = getConfig().getTextButtonColor();
            Button button = this.btnAccept;
            String tzend2 = btj.tzend(440);
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend2);
                button = null;
            }
            button.setTextColor(Color.parseColor(textButtonColor));
            Button button2 = this.btnAccept;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend2);
                button2 = null;
            }
            UtilsKt.updateFont(button2, getConfig().getFontName(), getConfig().getTextSizeButton());
            Button button3 = this.btnAccept;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend2);
                button3 = null;
            }
            String tzend3 = btj.tzend(441);
            AuthenticationID authenticationID = AuthenticationID.INSTANCE;
            UtilsKt.setTextByKey(button3, tzend3, authenticationID.getJsonLanguage$authenSDK_release());
            Button button4 = this.btnTryAgain;
            String tzend4 = btj.tzend(442);
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend4);
                button4 = null;
            }
            UtilsKt.updateFont(button4, getConfig().getFontName(), getConfig().getTextSizeButton());
            Button button5 = this.btnTryAgain;
            if (button5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend4);
                button5 = null;
            }
            UtilsKt.setTextByKey(button5, btj.tzend(443), authenticationID.getJsonLanguage$authenSDK_release());
            View view = this.clRoot;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(444));
                view = null;
            }
            view.setBackgroundColor(Color.parseColor(getConfig().getBackgroundColor()));
            TextView textView2 = this.tvFailedText;
            String tzend5 = btj.tzend(445);
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend5);
                textView2 = null;
            }
            textView2.setTextColor(Color.parseColor(getConfig().getErrorColor()));
            TextView textView3 = this.tvFailedText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend5);
                textView3 = null;
            }
            UtilsKt.updateFont(textView3, getConfig().getFontName(), getConfig().getTextSize());
            TextView textView4 = this.tvSuccessText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(446));
                textView4 = null;
            }
            UtilsKt.updateFont(textView4, getConfig().getFontName(), getConfig().getTextSize());
            TextView textView5 = this.tvStatusText;
            String tzend6 = btj.tzend(447);
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend6);
                textView5 = null;
            }
            textView5.setTextColor(Color.parseColor(getConfig().getTextColor()));
            TextView textView6 = this.tvStatusText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend6);
                textView6 = null;
            }
            UtilsKt.updateFont(textView6, getConfig().getFontName(), getConfig().getTextSize());
            TextView textView7 = this.toolbarText;
            String tzend7 = btj.tzend(448);
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend7);
                textView7 = null;
            }
            textView7.setTextColor(Color.parseColor(getConfig().getTextColor()));
            TextView textView8 = this.toolbarText;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend7);
                textView8 = null;
            }
            UtilsKt.updateFont(textView8, getConfig().getFontName(), getConfig().getTextSizeTitle());
            TextView textView9 = this.toolbarText;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend7);
            } else {
                textView = textView9;
            }
            UtilsKt.setTextByKey(textView, btj.tzend(449), authenticationID.getJsonLanguage$authenSDK_release());
            if (isAutoProcess()) {
                activeProcess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void setupStatusView() {
        TextView textView = this.tvStatusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(450));
            textView = null;
        }
        textView.setVisibility(8);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2562setupStatusView$lambda38(CameraXFragment.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupStatusView$lambda-38, reason: not valid java name */
    public static final void m2562setupStatusView$lambda38(final CameraXFragment cameraXFragment) {
        OverlayView overlayView = cameraXFragment.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(451));
            overlayView = null;
        }
        overlayView.post(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2563setupStatusView$lambda38$lambda37(CameraXFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupStatusView$lambda-38$lambda-37, reason: not valid java name */
    public static final void m2563setupStatusView$lambda38$lambda37(CameraXFragment cameraXFragment) {
        Log.e(cameraXFragment.TAG, btj.tzend(452));
        OverlayView overlayView = cameraXFragment.overlayView;
        View view = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(453));
            overlayView = null;
        }
        if (overlayView.getRectZoomIn() != null) {
            int height = (int) (overlayView.getHeight() - overlayView.getRectZoomIn().top);
            View view2 = cameraXFragment.layoutStatus;
            String tzend = btj.tzend(454);
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                view2 = null;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException(btj.tzend(456));
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(0, 0, 0, height);
            View view3 = cameraXFragment.layoutStatus;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                view3 = null;
            }
            view3.setLayoutParams(marginLayoutParams);
            TextView textView = cameraXFragment.tvStatusText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(455));
                textView = null;
            }
            textView.setVisibility(0);
            View view4 = cameraXFragment.layoutStatus;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
            } else {
                view = view4;
            }
            view.invalidate();
        }
    }

    private final void setupViewAfterDrawOval() {
        TextView textView = this.tvStatusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(457));
            textView = null;
        }
        UtilsKt.setTextByKey(textView, btj.tzend(isAutoProcess() ? 458 : 459), AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release());
    }

    private final void startCallApi(List<String> filesPath) {
        if (isLivenessConfirmed()) {
            TextView textView = this.tvStatusText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(460));
                textView = null;
            }
            UtilsKt.setTextByKey(textView, btj.tzend(461), AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release());
            getLivenessViewModel().showLoading();
        }
        HashMap<String, String> shieldData = BShield.shieldData(filesPath, getConfig().getNonce());
        if (shieldData == null) {
            Log.e(this.TAG, btj.tzend(462));
            SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
            if (callbackResult$authenSDK_release != null) {
                SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 311, btj.tzend(463), null, null, null, null, 60, null);
                return;
            }
            return;
        }
        SDKCallback callbackResult$authenSDK_release2 = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
        if (callbackResult$authenSDK_release2 != null) {
            String tzend = btj.tzend(464);
            String fileBase64 = this.rawImage.get(0).getFileBase64();
            String fileBase642 = this.rawImage.get(1).getFileBase64();
            String str = shieldData.get(btj.tzend(465));
            String str2 = str == null ? "" : str;
            String str3 = shieldData.get(btj.tzend(466));
            callbackResult$authenSDK_release2.complete(1, tzend, fileBase64, fileBase642, str2, str3 == null ? "" : str3);
        }
    }

    private final void startCamera() {
        CameraX cameraX = getCameraX();
        PreviewView previewView = this.viewFinder;
        Button button = null;
        if (previewView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(467));
            previewView = null;
        }
        cameraX.startCamera(previewView);
        OverlayView overlayView = this.overlayView;
        String tzend = btj.tzend(468);
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            overlayView = null;
        }
        OverlayView.init$default(overlayView, 0, 0, 0, 0, 15, null);
        overlayView.setConfigColor();
        overlayView.invalidate();
        overlayView.setVisibility(0);
        setupStatusView();
        setupViewAfterDrawOval();
        View view = this.layoutStatus;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(469));
            view = null;
        }
        view.setVisibility(0);
        String backgroundColor = getConfig().getBackgroundColor();
        OverlayView overlayView2 = this.overlayView;
        if (overlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            overlayView2 = null;
        }
        overlayView2.updateBackgroundColor(backgroundColor.toString());
        ImageView imageView = this.btnBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(470));
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraXFragment.m2564startCamera$lambda23(CameraXFragment.this, view2);
            }
        });
        Button button2 = this.btnAccept;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(471));
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraXFragment.this.activeProcess();
            }
        });
        Button button3 = this.btnTryAgain;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(472));
        } else {
            button = button3;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CameraXFragment.this.actionRetry();
            }
        });
        disableButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startCamera$lambda-23, reason: not valid java name */
    public static final void m2564startCamera$lambda23(CameraXFragment cameraXFragment, View view) {
        SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
        if (callbackResult$authenSDK_release != null) {
            SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 0, btj.tzend(473), null, null, null, null, 60, null);
        }
        cameraXFragment.requireActivity().finish();
    }

    private final void startObservers() {
        getLifecycle().addObserver(getCameraX().getLifecycleObserver());
        getLivenessViewModel().getState().observe(getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2579startObservers$lambda3(CameraXFragment.this, (LivenessViewState) obj);
            }
        });
        LivenessViewModel livenessViewModel = getLivenessViewModel();
        CountDownTimer countDownTimer = this.timerFirstStep;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        livenessViewModel.observeFacesDetection(getCameraX().observeFaceList());
        ActivityExtensionsKt.observeOnce(livenessViewModel.getHasFistCheck(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda15
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2574startObservers$lambda16$lambda4(CameraXFragment.this, (Boolean) obj);
            }
        });
        ActivityExtensionsKt.observeOnce(livenessViewModel.getHasZoomIn(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2575startObservers$lambda16$lambda5(CameraXFragment.this, (Boolean) obj);
            }
        });
        ActivityExtensionsKt.observeOnce(livenessViewModel.getHasZoomOut(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2576startObservers$lambda16$lambda6(CameraXFragment.this, (Boolean) obj);
            }
        });
        ActivityExtensionsKt.observeOnce(livenessViewModel.getHasHeadMovedCenter(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2577startObservers$lambda16$lambda7((Boolean) obj);
            }
        });
        ActivityExtensionsKt.observeOnce(livenessViewModel.getCallBackCompleted(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2578startObservers$lambda16$lambda8(CameraXFragment.this, (String) obj);
            }
        });
        ActivityExtensionsKt.observeOnce(livenessViewModel.getHandleSuccessLiveness(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2567startObservers$lambda16$lambda11(CameraXFragment.this, (Map) obj);
            }
        });
        ActivityExtensionsKt.observeOnce(livenessViewModel.getHandleErrorLiveness(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2570startObservers$lambda16$lambda14(CameraXFragment.this, (String) obj);
            }
        });
        ActivityExtensionsKt.observeOnce(livenessViewModel.getUpdateStateStepLiveness(), getViewLifecycleOwner(), new Observer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda22
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraXFragment.m2573startObservers$lambda16$lambda15((StateFaceWithOval) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-11, reason: not valid java name */
    public static final void m2567startObservers$lambda16$lambda11(final CameraXFragment cameraXFragment, Map map) {
        Handler handler;
        Runnable runnable;
        long j;
        Map map2;
        if (cameraXFragment.isLivenessConfirmed()) {
            Double d = (Double) map.get(btj.tzend(474));
            String tzend = btj.tzend(475);
            if (map.containsKey(tzend)) {
                Object obj = map.get(tzend);
                if (obj == null) {
                    throw new NullPointerException(btj.tzend(476));
                }
                map2 = (Map) obj;
            } else {
                map2 = null;
            }
            if (d != null && ((int) d.doubleValue()) == 1 && map2 != null) {
                Object obj2 = map2.get(btj.tzend(477));
                if (obj2 == null) {
                    throw new NullPointerException(btj.tzend(478));
                }
                if (((int) ((Double) obj2).doubleValue()) == 1) {
                    cameraXFragment.updateLayoutSuccessScan();
                }
            }
            handler = new Handler(Looper.getMainLooper());
            runnable = new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    CameraXFragment.m2569startObservers$lambda16$lambda11$lambda9(CameraXFragment.this);
                }
            };
            j = 500;
        } else {
            handler = new Handler(Looper.getMainLooper());
            runnable = new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    CameraXFragment.m2568startObservers$lambda16$lambda11$lambda10(CameraXFragment.this);
                }
            };
            j = 50;
        }
        handler.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-11$lambda-10, reason: not valid java name */
    public static final void m2568startObservers$lambda16$lambda11$lambda10(CameraXFragment cameraXFragment) {
        cameraXFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-11$lambda-9, reason: not valid java name */
    public static final void m2569startObservers$lambda16$lambda11$lambda9(CameraXFragment cameraXFragment) {
        cameraXFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-14, reason: not valid java name */
    public static final void m2570startObservers$lambda16$lambda14(final CameraXFragment cameraXFragment, String str) {
        cameraXFragment.updateUIFailed();
        if (str != null && str.length() != 0) {
            if (StringsKt.startsWith$default(str, btj.tzend(479), false, 2, (Object) null)) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraXFragment.m2571startObservers$lambda16$lambda14$lambda12(CameraXFragment.this);
                    }
                }, 50L);
            } else if (StringsKt.startsWith$default(str, btj.tzend(480), false, 2, (Object) null)) {
                cameraXFragment.updateUINetworkFailed();
            } else {
                cameraXFragment.updateUILiveFailed();
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.this.actionFailedUpdate();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-14$lambda-12, reason: not valid java name */
    public static final void m2571startObservers$lambda16$lambda14$lambda12(CameraXFragment cameraXFragment) {
        cameraXFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-15, reason: not valid java name */
    public static final void m2573startObservers$lambda16$lambda15(StateFaceWithOval stateFaceWithOval) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-4, reason: not valid java name */
    public static final void m2574startObservers$lambda16$lambda4(CameraXFragment cameraXFragment, Boolean bool) {
        cameraXFragment.checkFirst(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-5, reason: not valid java name */
    public static final void m2575startObservers$lambda16$lambda5(CameraXFragment cameraXFragment, Boolean bool) {
        cameraXFragment.checkZoomIn(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-6, reason: not valid java name */
    public static final void m2576startObservers$lambda16$lambda6(CameraXFragment cameraXFragment, Boolean bool) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CameraXFragment$startObservers$2$3$1(cameraXFragment, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-7, reason: not valid java name */
    public static final void m2577startObservers$lambda16$lambda7(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-16$lambda-8, reason: not valid java name */
    public static final void m2578startObservers$lambda16$lambda8(CameraXFragment cameraXFragment, String str) {
        cameraXFragment.getCameraX().finishStep();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startObservers$lambda-3, reason: not valid java name */
    public static final void m2579startObservers$lambda3(CameraXFragment cameraXFragment, LivenessViewState livenessViewState) {
        if (livenessViewState.getMessageLiveness().length() == 0) {
            return;
        }
        if (livenessViewState.getStepLiveness() == StepLiveness.STEP_ZOOM_IN || livenessViewState.getStepLiveness() == StepLiveness.STEP_ZOOM_OUT) {
            TextView textView = cameraXFragment.tvStatusText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(481));
                textView = null;
            }
            UtilsKt.bindHtmlToString(textView, livenessViewState.getMessageLiveness());
        }
    }

    private final void tryReloadAndDetectInImage(PhotoResultDomain it) {
        if (it.getBitMap() != null) {
            Log.e(this.TAG, btj.tzend(482) + it.getCreatedAt());
            GraphicOverlay graphicOverlay = this.graphicOverlay;
            String tzend = btj.tzend(483);
            GraphicOverlay graphicOverlay2 = null;
            if (graphicOverlay == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
                graphicOverlay = null;
            }
            graphicOverlay.clear();
            GraphicOverlay graphicOverlay3 = this.graphicOverlay;
            if (graphicOverlay3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend);
            } else {
                graphicOverlay2 = graphicOverlay3;
            }
            graphicOverlay2.setImageSourceInfo(it.getBitMap().getWidth(), it.getBitMap().getHeight(), false);
            this.imageProcessor.processBitmap(it.getBitMap());
            this.imageProcessor.addProcessSuccees(new CameraXFragment$tryReloadAndDetectInImage$1(this, it));
        }
    }

    private final void updateLayoutSuccessScan() {
        requireActivity().runOnUiThread(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2580updateLayoutSuccessScan$lambda17(CameraXFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateLayoutSuccessScan$lambda-17, reason: not valid java name */
    public static final void m2580updateLayoutSuccessScan$lambda17(CameraXFragment cameraXFragment) {
        ImageView imageView = cameraXFragment.btnBack;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(484));
            imageView = null;
        }
        imageView.setVisibility(8);
        Button button = cameraXFragment.btnAccept;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(485));
            button = null;
        }
        button.setVisibility(8);
        Button button2 = cameraXFragment.btnTryAgain;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(486));
            button2 = null;
        }
        button2.setVisibility(8);
        OverlayView overlayView = cameraXFragment.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(487));
            overlayView = null;
        }
        overlayView.setVisibility(8);
        View view2 = cameraXFragment.layoutSuccess;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(488));
        } else {
            view = view2;
        }
        view.setVisibility(0);
    }

    private final void updateUIFailed() {
        requireActivity().runOnUiThread(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2581updateUIFailed$lambda20(CameraXFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUIFailed$lambda-20, reason: not valid java name */
    public static final void m2581updateUIFailed$lambda20(CameraXFragment cameraXFragment) {
        TextView textView = cameraXFragment.tvFailedText;
        String tzend = btj.tzend(489);
        OverlayView overlayView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView2 = cameraXFragment.tvFailedText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            textView2 = null;
        }
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        UtilsKt.setTextByKey(textView2, btj.tzend(490), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView3 = cameraXFragment.tvStatusText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(491));
            textView3 = null;
        }
        UtilsKt.setTextByKey(textView3, btj.tzend(492), authenticationID.getJsonLanguage$authenSDK_release());
        OverlayView overlayView2 = cameraXFragment.overlayView;
        if (overlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(493));
        } else {
            overlayView = overlayView2;
        }
        overlayView.hideTextCenter();
        overlayView.hideBlur();
    }

    private final void updateUILiveFailed() {
        TextView textView = this.tvFailedText;
        String tzend = btj.tzend(494);
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView3 = this.tvFailedText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            textView3 = null;
        }
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        UtilsKt.setTextByKey(textView3, btj.tzend(495), authenticationID.getJsonLanguage$authenSDK_release());
        TextView textView4 = this.tvStatusText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(496));
        } else {
            textView2 = textView4;
        }
        UtilsKt.setTextByKey(textView2, btj.tzend(497), authenticationID.getJsonLanguage$authenSDK_release());
    }

    private final void updateUINetworkFailed() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2582updateUINetworkFailed$lambda21(CameraXFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUINetworkFailed$lambda-21, reason: not valid java name */
    public static final void m2582updateUINetworkFailed$lambda21(CameraXFragment cameraXFragment) {
        cameraXFragment.requireActivity().finish();
    }

    private final void updateUIToZoomOut() {
        Log.e(this.TAG, btj.tzend(498));
        OverlayView overlayView = this.overlayView;
        String tzend = btj.tzend(499);
        OverlayView overlayView2 = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            overlayView = null;
        }
        overlayView.hideProcess();
        getLivenessViewModel();
        OverlayView overlayView3 = this.overlayView;
        if (overlayView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
        } else {
            overlayView2 = overlayView3;
        }
        overlayView2.zoomOut();
    }

    private final void validDataAndCallApi() {
        Log.e(this.TAG, btj.tzend(ServiceStarter.ERROR_UNKNOWN));
        if (this.mapDataUploadAPI.size() == 4 && this.rawImage.size() == 2) {
            String createdAt = this.rawImage.get(0).getCreatedAt();
            String createdAt2 = this.rawImage.get(1).getCreatedAt();
            String jsonTrackingToBase64 = jsonTrackingToBase64();
            Map<String, String> map = this.mapDataUploadAPI;
            String tzend = btj.tzend(TypedValues.PositionType.TYPE_TRANSITION_EASING);
            String str = map.get(tzend + createdAt);
            String str2 = this.mapDataUploadAPI.get(tzend + createdAt2);
            Map<String, String> map2 = this.mapDataUploadAPI;
            String tzend2 = btj.tzend(TypedValues.PositionType.TYPE_DRAWPATH);
            startCallApi(CollectionsKt.listOf((Object[]) new String[]{jsonTrackingToBase64, str, str2, map2.get(tzend2 + createdAt), this.mapDataUploadAPI.get(tzend2 + createdAt2)}));
        }
    }

    public final String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public final Bitmap cropBitmapWithFace(Bitmap bitmap, Rect rectFace) {
        return Bitmap.createBitmap(bitmap, rectFace.left, rectFace.top, rectFace.width(), rectFace.height());
    }

    public final void forceCloseSDK() {
        Log.e(this.TAG, btj.tzend(TypedValues.PositionType.TYPE_PERCENT_WIDTH));
        requireActivity().finish();
    }

    public final void forceShowError() {
        getLivenessViewModel().hideLoading();
        updateUIFailed();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.this.actionFailedUpdate();
            }
        }, 500L);
    }

    public final void forceShowSuccess() {
        updateLayoutSuccessScan();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                CameraXFragment.m2560forceShowSuccess$lambda40(CameraXFragment.this);
            }
        }, 100L);
    }

    public final Map<String, String> getMapDataUploadAPI() {
        return this.mapDataUploadAPI;
    }

    public final ArrayList<PhotoResultDomain> getRawImage() {
        return this.rawImage;
    }

    public final int getRetrycount() {
        return this.retrycount;
    }

    public final long getTimeStart() {
        return this.timeStart;
    }

    public final boolean isBitmapBlurry(Bitmap bitmap, double threshold) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        int i = 0;
        for (int i2 = 1; i2 < height - 1; i2++) {
            int i3 = 1;
            while (i3 < width - 1) {
                int i4 = iArr[((i2 - 1) * width) + i3];
                int i5 = iArr[((i2 + 1) * width) + i3];
                int i6 = i2 * width;
                int i7 = iArr[(i3 - 1) + i6];
                i3++;
                double d2 = (iArr[i6 + i3] & 255) - (i7 & 255);
                double d3 = (i5 & 255) - (i4 & 255);
                Double.isNaN(d2);
                Double.isNaN(d2);
                Double.isNaN(d3);
                Double.isNaN(d3);
                d += Math.sqrt((d3 * d3) + (d2 * d2));
                i++;
            }
        }
        double d4 = i;
        Double.isNaN(d4);
        return d / d4 < threshold;
    }

    public final String jsonObjectToBase64(Rect rect, Bitmap bitmap, ArrayList<Point> points) {
        byte[] bytes = new Gson().toJson(MapsKt.mapOf(TuplesKt.to(btj.tzend(TypedValues.PositionType.TYPE_PERCENT_HEIGHT), new Integer[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())}), TuplesKt.to(btj.tzend(TypedValues.PositionType.TYPE_SIZE_PERCENT), new Integer[][]{new Integer[]{Integer.valueOf((int) points.get(0).x), Integer.valueOf((int) points.get(0).y)}, new Integer[]{Integer.valueOf((int) points.get(1).x), Integer.valueOf((int) points.get(1).y)}, new Integer[]{Integer.valueOf((int) points.get(2).x), Integer.valueOf((int) points.get(2).y)}, new Integer[]{Integer.valueOf((int) points.get(3).x), Integer.valueOf((int) points.get(3).y)}, new Integer[]{Integer.valueOf((int) points.get(4).x), Integer.valueOf((int) points.get(4).y)}}), TuplesKt.to(btj.tzend(TypedValues.PositionType.TYPE_PERCENT_X), bitmapToBase64(bitmap)))).getBytes(Charsets.UTF_8);
        Log.e(this.TAG, btj.tzend(TypedValues.PositionType.TYPE_PERCENT_Y));
        return Base64.encodeToString(bytes, 2);
    }

    public final String jsonTrackingToBase64() {
        return Base64.encodeToString(new Gson().toJson(MapsKt.mapOf(TuplesKt.to(btj.tzend(TypedValues.PositionType.TYPE_CURVE_FIT), btj.tzend(509)), TuplesKt.to(btj.tzend(TypedValues.PositionType.TYPE_POSITION_TYPE), 2), TuplesKt.to(btj.tzend(FrameMetricsAggregator.EVERY_DURATION), Integer.valueOf(this.retrycount)), TuplesKt.to(btj.tzend(512), 0), TuplesKt.to(btj.tzend(InputDeviceCompat.SOURCE_DPAD), 0), TuplesKt.to(btj.tzend(514), Integer.valueOf((int) (System.currentTimeMillis() - this.timeStart))), TuplesKt.to(btj.tzend(515), Build.MANUFACTURER + '-' + Build.MODEL), TuplesKt.to(btj.tzend(516), btj.tzend(517)), TuplesKt.to(btj.tzend(518), String.valueOf(Build.VERSION.SDK_INT)))).getBytes(Charsets.UTF_8), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        VFaceLib.INSTANCE.initialize(requireActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.timerFirstStep = new CountDownTimer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$onCreate$1
            {
                super(1000L, 100L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView textView;
                boolean isAutoProcess;
                CameraXFragment.this.isEnableButtonProceed = true;
                CameraXFragment.this.enableButton();
                textView = CameraXFragment.this.tvStatusText;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(355));
                    textView = null;
                }
                isAutoProcess = CameraXFragment.this.isAutoProcess();
                UtilsKt.setTextByKey(textView, btj.tzend(isAutoProcess ? 356 : 357), AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release());
                CameraXFragment.this.isCountDownFinished = true;
                CameraXFragment.this.isCountDownRunning = false;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                CameraXFragment.this.isCountDownFinished = false;
            }
        };
        this.timerZoomIn = new CountDownTimer() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$onCreate$2
            {
                super(100L, 100L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                String str;
                str = CameraXFragment.this.TAG;
                Log.e(str, btj.tzend(373));
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CameraXFragment$onCreate$2$onFinish$1(CameraXFragment.this, null), 3, null);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                OverlayView overlayView;
                overlayView = CameraXFragment.this.overlayView;
                if (overlayView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(374));
                    overlayView = null;
                }
                overlayView.showProcess();
                CameraXFragment.this.isCountDownZoomInStepRunning = true;
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.facesdk_fragment_camerax, container, false);
        initViews(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        clearImageProcessor();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        VFaceLib.INSTANCE.nativeDestroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        clearImageProcessor();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (!requireActivity().isFinishing()) {
            SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
            if (callbackResult$authenSDK_release != null) {
                SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 304, btj.tzend(519), null, null, null, null, 60, null);
            }
            requireActivity().finish();
        }
        CountDownTimer countDownTimer = this.timerFirstStep;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.timerZoomIn;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLivenessViewModel().setupLivenessConfig(getLivenessConfig());
        getLivenessViewModel().setupSteps(getCameraSettings().getLivenessStepList());
        LivenessViewModel livenessViewModel = getLivenessViewModel();
        ImageView imageView = this.btnBack;
        OverlayView overlayView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(520));
            imageView = null;
        }
        OverlayView overlayView2 = this.overlayView;
        if (overlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(521));
        } else {
            overlayView = overlayView2;
        }
        livenessViewModel.setupView(imageView, overlayView);
        this.cameraPermission.launch(this.cameraManifest);
        setupConfig();
        setupActionFaceSDK();
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.widgets.OnCallbackOverlayListener
    public void onZoomOutAnimationEnd() {
        Log.e(this.TAG, btj.tzend(522));
        setupStatusView();
        getLivenessViewModel().removeCurrentStep();
        TextView textView = this.tvStatusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(523));
            textView = null;
        }
        textView.setText("");
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.widgets.OnCallbackOverlayListener
    public void onZoomOutAnimationStart() {
        TextView textView = this.tvStatusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(524));
            textView = null;
        }
        textView.setVisibility(4);
    }

    public final void setMargin(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException(btj.tzend(525));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(i, i2, i3, i4);
        view.setLayoutParams(marginLayoutParams);
    }

    public final void setRawImage(ArrayList<PhotoResultDomain> arrayList) {
        this.rawImage = arrayList;
    }

    public final void setRetrycount(int i) {
        this.retrycount = i;
    }

    public final void setTimeStart(long j) {
        this.timeStart = j;
    }

    public final void setupActionFaceSDK() {
        AuthenticationID authenticationID = AuthenticationID.INSTANCE;
        authenticationID.setShowSuccess$authenSDK_release(new Function0<Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$setupActionFaceSDK$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CameraXFragment.this.forceShowSuccess();
            }
        });
        authenticationID.setShowError$authenSDK_release(new Function1<String, Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$setupActionFaceSDK$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                CameraXFragment.this.forceShowError();
            }
        });
        authenticationID.setCloseSDK$authenSDK_release(new Function0<Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$setupActionFaceSDK$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CameraXFragment.this.forceCloseSDK();
            }
        });
        authenticationID.setTimeoutSDK$authenSDK_release(new Function0<Unit>() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$setupActionFaceSDK$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CameraXFragment.this.timeoutSDK();
            }
        });
        authenticationID.resetTimeOut$authenSDK_release();
    }

    public final void timeoutSDK() {
        Log.e(this.TAG, btj.tzend(526));
        SDKCallback callbackResult$authenSDK_release = AuthenticationID.INSTANCE.getCallbackResult$authenSDK_release();
        if (callbackResult$authenSDK_release != null) {
            SDKCallback.DefaultImpls.complete$default(callbackResult$authenSDK_release, 307, btj.tzend(527), null, null, null, null, 60, null);
        }
        requireActivity().finish();
    }
}
