package vn.ai.faceauth.sdk.presentation.presentation.viewmodel;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import paua.btj;
import vn.ai.faceauth.sdk.camera.domain.model.FaceResult;
import vn.ai.faceauth.sdk.core.extensions.PrimitiveExtensionsKt;
import vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider;
import vn.ai.faceauth.sdk.core.viewmodel.StateViewModel;
import vn.ai.faceauth.sdk.domain.model.StateFaceWithOval;
import vn.ai.faceauth.sdk.domain.repository.LivenessRepository;
import vn.ai.faceauth.sdk.presentation.domain.configs.LivenessConfig;
import vn.ai.faceauth.sdk.presentation.domain.model.Constants;
import vn.ai.faceauth.sdk.presentation.domain.model.StepLiveness;
import vn.ai.faceauth.sdk.presentation.domain.usecase.GetStatusMessageUseCase;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;
import vn.ai.faceauth.sdk.presentation.presentation.utils.Logger;
import vn.ai.faceauth.sdk.presentation.presentation.utils.UtilsKt;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.OverlayView;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020NH\u0002J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020NH\u0002J\u0006\u0010S\u001a\u00020TJ\u0010\u0010U\u001a\u00020&2\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010W\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010X\u001a\u00020&2\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010Y\u001a\u00020&2\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010Z\u001a\u00020&2\u0006\u0010V\u001a\u00020\u0007H\u0002J\"\u0010[\u001a\u00020&2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u001dH\u0002J\u001e\u0010_\u001a\u00020&2\u0006\u0010V\u001a\u00020]2\u0006\u0010`\u001a\u00020]2\u0006\u0010a\u001a\u00020bJ\u0010\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020\u0015H\u0002J\u0016\u0010e\u001a\u00020T2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00070$H\u0002J\u0006\u0010g\u001a\u00020TJ\u0018\u0010h\u001a\u00020&2\u0006\u0010V\u001a\u00020]2\u0006\u0010`\u001a\u00020]H\u0002J\u0010\u0010i\u001a\u00020&2\u0006\u0010j\u001a\u00020\"H\u0002J\u001a\u0010k\u001a\u00020T2\u0012\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070$0mJ\u0006\u0010n\u001a\u00020TJ\u0006\u0010o\u001a\u00020TJ\u0006\u0010p\u001a\u00020TJ\u0006\u0010q\u001a\u00020TJ \u0010r\u001a\u00020\"2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010s\u001a\u00020>2\u0006\u0010t\u001a\u00020>H\u0002J\u000e\u0010u\u001a\u00020T2\u0006\u0010;\u001a\u00020<J\u0014\u0010v\u001a\u00020T2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u001d0$J\u0016\u0010x\u001a\u00020T2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010B\u001a\u00020CJ\u000e\u0010y\u001a\u00020T2\u0006\u0010V\u001a\u00020]J\u0006\u0010z\u001a\u00020TJ\b\u0010{\u001a\u00020TH\u0002J\b\u0010|\u001a\u00020TH\u0002J\b\u0010}\u001a\u00020TH\u0002J\u0010\u0010~\u001a\u00020T2\u0006\u0010\u007f\u001a\u00020\fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00120\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00198F¢\u0006\u0006\u001a\u0004\b(\u0010\u001bR#\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00120\u00110\u00198F¢\u0006\u0006\u001a\u0004\b*\u0010\u001bR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u0019¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\u0019¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020&0\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020&0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020&0\u0019¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001bR\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020&0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020&0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020>X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001d0AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.¢\u0006\u0002\n\u0000R \u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d0AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00198F¢\u0006\u0006\u001a\u0004\bJ\u0010\u001b¨\u0006\u0080\u0001"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/presentation/viewmodel/LivenessViewModel;", "Lvn/ai/faceauth/sdk/core/viewmodel/StateViewModel;", "Lvn/ai/faceauth/sdk/presentation/presentation/viewmodel/LivenessViewState;", "resourcesProvider", "Lvn/ai/faceauth/sdk/core/resourceprovider/ResourcesProvider;", "livenessRepository", "Lvn/ai/faceauth/sdk/domain/repository/LivenessRepository;", "Lvn/ai/faceauth/sdk/camera/domain/model/FaceResult;", "getStatusMessageUseCase", "Lvn/ai/faceauth/sdk/presentation/domain/usecase/GetStatusMessageUseCase;", "(Lvn/ai/faceauth/sdk/core/resourceprovider/ResourcesProvider;Lvn/ai/faceauth/sdk/domain/repository/LivenessRepository;Lvn/ai/faceauth/sdk/presentation/domain/usecase/GetStatusMessageUseCase;)V", "TAG", "", "_callBackCompleted", "Landroidx/lifecycle/MutableLiveData;", "_handleErrorLivenessMutable", "_handleSuccessLivenessMutable", "", "", "_state", "_updateStateStepLivenessMutable", "Lvn/ai/faceauth/sdk/domain/model/StateFaceWithOval;", "btnBack", "Landroid/widget/ImageView;", "callBackCompleted", "Landroidx/lifecycle/LiveData;", "getCallBackCompleted", "()Landroidx/lifecycle/LiveData;", "currentStep", "Lvn/ai/faceauth/sdk/presentation/domain/model/StepLiveness;", "currentTime", "", "faceHistory", "", "Landroid/graphics/Rect;", "facesMutable", "", "firstCheckMutable", "", "handleErrorLiveness", "getHandleErrorLiveness", "handleSuccessLiveness", "getHandleSuccessLiveness", "hasFistCheck", "getHasFistCheck", "hasHeadMovedCenter", "getHasHeadMovedCenter", "hasZoomIn", "getHasZoomIn", "hasZoomInMutable", "hasZoomOut", "getHasZoomOut", "hasZoomOutMutable", "headMovementCenterMutable", "isFacesDetectedCorrect", "isFinished", "()Z", "setFinished", "(Z)V", "livenessConfig", "Lvn/ai/faceauth/sdk/presentation/domain/configs/LivenessConfig;", "maxFrames", "", "movementThreshold", "originalRequestedSteps", "Ljava/util/LinkedList;", "overlayView", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/OverlayView;", "requestedSteps", "getRequestedSteps", "()Ljava/util/LinkedList;", "setRequestedSteps", "(Ljava/util/LinkedList;)V", "updateStateStepLiveness", "getUpdateStateStepLiveness", "calculateFaceMovement", "", "from", "Lvn/ai/faceauth/sdk/domain/model/Rect;", TypedValues.TransitionType.S_TO, "calculateRectCenter", "Landroid/graphics/PointF;", "bounds", "callFinish", "", "checkEyesClosed", OptionalModuleUtils.FACE, "checkFaceLiveness", "checkLuminosity", "checkPose", "checkSmile", "checkStepWithRect", "rectF", "Landroid/graphics/RectF;", "stepZoom", "faceNotCenter", "oval", "percentage", "", "getStatusMessage", "stateFaceWithOval", "handleFaces", "listFaceResult", "hideLoading", "isFaceInOval", "isFaceStable", "currentBounds", "observeFacesDetection", "facesFlowable", "Lkotlinx/coroutines/flow/Flow;", "reDraw", "removeCurrentStep", "reset", "resetState", "scaleBoundingBox", "screenWidth", "screenHeight", "setupLivenessConfig", "setupSteps", "validateRequested", "setupView", "showFace", "showLoading", "showStateNoFace", "showSuccess", "stopBySystem", "updateCompleted", "newData", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class LivenessViewModel extends StateViewModel<LivenessViewState> {
    private final String TAG;
    private final MutableLiveData<String> _callBackCompleted;
    private final MutableLiveData<String> _handleErrorLivenessMutable;
    private final MutableLiveData<Map<String, Object>> _handleSuccessLivenessMutable;
    private final LivenessViewState _state;
    private final MutableLiveData<StateFaceWithOval> _updateStateStepLivenessMutable;
    private ImageView btnBack;
    private StepLiveness currentStep;
    private long currentTime;
    private final List<Rect> faceHistory;
    private List<FaceResult> facesMutable;
    private final MutableLiveData<Boolean> firstCheckMutable;
    private final GetStatusMessageUseCase getStatusMessageUseCase;
    private final LiveData<Boolean> hasFistCheck;
    private final LiveData<Boolean> hasHeadMovedCenter;
    private final LiveData<Boolean> hasZoomIn;
    private final MutableLiveData<Boolean> hasZoomInMutable;
    private final LiveData<Boolean> hasZoomOut;
    private final MutableLiveData<Boolean> hasZoomOutMutable;
    private final MutableLiveData<Boolean> headMovementCenterMutable;
    private boolean isFacesDetectedCorrect;
    private boolean isFinished;
    private LivenessConfig livenessConfig;
    private final LivenessRepository<FaceResult> livenessRepository;
    private final int maxFrames;
    private final int movementThreshold;
    private LinkedList<StepLiveness> originalRequestedSteps;
    private OverlayView overlayView;
    private LinkedList<StepLiveness> requestedSteps;
    private final ResourcesProvider resourcesProvider;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StepLiveness.values().length];
            iArr[StepLiveness.STEP_ZOOM_IN.ordinal()] = 1;
            iArr[StepLiveness.STEP_ZOOM_OUT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LivenessViewModel(ResourcesProvider resourcesProvider, LivenessRepository<FaceResult> livenessRepository, GetStatusMessageUseCase getStatusMessageUseCase) {
        super(new LivenessViewState(null, false, null, 7, null));
        this.resourcesProvider = resourcesProvider;
        this.livenessRepository = livenessRepository;
        this.getStatusMessageUseCase = getStatusMessageUseCase;
        this.TAG = btj.tzend(105);
        this.currentStep = StepLiveness.STEP_FIRST_CHECK;
        this._state = new LivenessViewState(null, false, null, 7, null);
        this.originalRequestedSteps = new LinkedList<>();
        this.requestedSteps = new LinkedList<>();
        this.facesMutable = CollectionsKt.emptyList();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.hasZoomInMutable = mutableLiveData;
        this.hasZoomIn = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.hasZoomOutMutable = mutableLiveData2;
        this.hasZoomOut = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this.headMovementCenterMutable = mutableLiveData3;
        this.hasHeadMovedCenter = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.firstCheckMutable = mutableLiveData4;
        this.hasFistCheck = mutableLiveData4;
        this._callBackCompleted = new MutableLiveData<>();
        this._handleSuccessLivenessMutable = new MutableLiveData<>();
        this._handleErrorLivenessMutable = new MutableLiveData<>();
        this._updateStateStepLivenessMutable = new MutableLiveData<>();
        this.faceHistory = new ArrayList();
        this.maxFrames = 10;
        this.movementThreshold = 25;
    }

    private final double calculateFaceMovement(vn.ai.faceauth.sdk.domain.model.Rect from, vn.ai.faceauth.sdk.domain.model.Rect to) {
        PointF calculateRectCenter = calculateRectCenter(from);
        PointF calculateRectCenter2 = calculateRectCenter(to);
        if (calculateRectCenter == null || calculateRectCenter2 == null) {
            return Double.MAX_VALUE;
        }
        return Math.hypot(calculateRectCenter.x - calculateRectCenter2.x, calculateRectCenter.y - calculateRectCenter2.y);
    }

    private final PointF calculateRectCenter(vn.ai.faceauth.sdk.domain.model.Rect bounds) {
        float f = 2;
        return new PointF((bounds.getRight() + bounds.getLeft()) / f, (bounds.getBottom() + bounds.getTop()) / f);
    }

    private final boolean checkEyesClosed(FaceResult face) {
        Float leftEyeOpenProbability = face.getLeftEyeOpenProbability();
        if (leftEyeOpenProbability == null) {
            return false;
        }
        float floatValue = leftEyeOpenProbability.floatValue();
        Float rightEyeOpenProbability = face.getRightEyeOpenProbability();
        if (rightEyeOpenProbability == null) {
            return false;
        }
        float floatValue2 = rightEyeOpenProbability.floatValue();
        Log.d(this.TAG, btj.tzend(106) + face.getLeftEyeOpenProbability());
        Log.d(this.TAG, btj.tzend(107) + face.getRightEyeOpenProbability());
        Constants.Companion companion = Constants.INSTANCE;
        return floatValue < companion.getEYE_OPENED_PROBABILITY() && floatValue2 < companion.getEYE_OPENED_PROBABILITY();
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x02e9, code lost:
    
        if (r8 == 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0197, code lost:
    
        if (r8 == 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02ef, code lost:
    
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02eb, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r8v55, types: [android.widget.ImageView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void checkFaceLiveness(FaceResult face) {
        OverlayView overlayView;
        if (PrimitiveExtensionsKt.orFalse(Boolean.valueOf(!this.requestedSteps.isEmpty()))) {
            Logger.INSTANCE.addStep(this.requestedSteps.getFirst());
            StepLiveness first = this.requestedSteps.getFirst();
            int i = first == null ? -1 : WhenMappings.$EnumSwitchMapping$0[first.ordinal()];
            if (i != -1) {
                String tzend = btj.tzend(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
                String tzend2 = btj.tzend(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                String tzend3 = btj.tzend(110);
                OverlayView overlayView2 = null;
                if (i == 1) {
                    Log.d(this.TAG, btj.tzend(AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID));
                    OverlayView overlayView3 = this.overlayView;
                    if (overlayView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        overlayView3 = null;
                    }
                    RectF rectZoomIn = overlayView3.getRectZoomIn();
                    StepLiveness stepLiveness = StepLiveness.STEP_ZOOM_IN;
                    if (!checkStepWithRect(rectZoomIn, face, stepLiveness)) {
                        Log.d(this.TAG, btj.tzend(117));
                        OverlayView overlayView4 = this.overlayView;
                        if (overlayView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView4;
                        }
                        overlayView2.hideProcess();
                        Unit unit = Unit.INSTANCE;
                        this.hasZoomInMutable.setValue(Boolean.FALSE);
                        return;
                    }
                    if (!checkPose(face)) {
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.FACE_NOT_ALIGN), stepLiveness));
                        Log.d(this.TAG, btj.tzend(118));
                        OverlayView overlayView5 = this.overlayView;
                        if (overlayView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView5;
                        }
                        overlayView2.hideProcess();
                        Unit unit2 = Unit.INSTANCE;
                        this.hasZoomInMutable.setValue(Boolean.FALSE);
                        return;
                    }
                    if (!checkSmile(face)) {
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.NO_SMILE), stepLiveness));
                        Log.d(this.TAG, btj.tzend(119));
                        OverlayView overlayView6 = this.overlayView;
                        if (overlayView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView6;
                        }
                        overlayView2.hideProcess();
                        Unit unit3 = Unit.INSTANCE;
                        this.hasZoomInMutable.setValue(Boolean.FALSE);
                        return;
                    }
                    if (checkEyesClosed(face)) {
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.EYES_CLOSED), stepLiveness));
                        OverlayView overlayView7 = this.overlayView;
                        if (overlayView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView7;
                        }
                        overlayView2.hideProcess();
                        Unit unit4 = Unit.INSTANCE;
                        this.hasZoomInMutable.setValue(Boolean.FALSE);
                        return;
                    }
                    if (!isFaceStable(face.getBounds())) {
                        Log.d(this.TAG, tzend);
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.KEEP_HOLD_ON), stepLiveness));
                        OverlayView overlayView8 = this.overlayView;
                        if (overlayView8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView8;
                        }
                        overlayView2.showProcess();
                        this.hasZoomInMutable.setValue(Boolean.FALSE);
                        return;
                    }
                    Log.d(this.TAG, btj.tzend(120) + this.hasZoomInMutable.getValue());
                    this.hasZoomInMutable.setValue(Boolean.TRUE);
                    if (this.isFinished) {
                        return;
                    }
                    OverlayView overlayView9 = this.overlayView;
                    if (overlayView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        overlayView9 = null;
                    }
                    overlayView9.scale(true);
                    Unit unit5 = Unit.INSTANCE;
                    ImageView imageView = this.btnBack;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(tzend2);
                        imageView = null;
                    }
                    if (!imageView.isEnabled()) {
                        return;
                    }
                    ?? r8 = this.btnBack;
                    overlayView = r8;
                } else {
                    if (i != 2) {
                        return;
                    }
                    Log.d(this.TAG, btj.tzend(111));
                    OverlayView overlayView10 = this.overlayView;
                    if (overlayView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        overlayView10 = null;
                    }
                    RectF rectZoomOut = overlayView10.getRectZoomOut();
                    StepLiveness stepLiveness2 = StepLiveness.STEP_ZOOM_OUT;
                    if (!checkStepWithRect(rectZoomOut, face, stepLiveness2)) {
                        Log.d(this.TAG, btj.tzend(112));
                        OverlayView overlayView11 = this.overlayView;
                        if (overlayView11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView11;
                        }
                        overlayView2.hideProcess();
                        Unit unit6 = Unit.INSTANCE;
                        return;
                    }
                    if (!checkPose(face)) {
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.FACE_NOT_ALIGN), StepLiveness.STEP_ZOOM_IN));
                        Log.d(this.TAG, btj.tzend(113));
                        OverlayView overlayView12 = this.overlayView;
                        if (overlayView12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView12;
                        }
                        overlayView2.hideProcess();
                        Unit unit7 = Unit.INSTANCE;
                        return;
                    }
                    if (!checkSmile(face)) {
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.NO_SMILE), StepLiveness.STEP_ZOOM_IN));
                        Log.d(this.TAG, btj.tzend(114));
                        OverlayView overlayView13 = this.overlayView;
                        if (overlayView13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView13;
                        }
                        overlayView2.hideProcess();
                        Unit unit8 = Unit.INSTANCE;
                        return;
                    }
                    if (checkEyesClosed(face)) {
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.EYES_CLOSED), StepLiveness.STEP_ZOOM_IN));
                        OverlayView overlayView14 = this.overlayView;
                        if (overlayView14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView14;
                        }
                        overlayView2.hideProcess();
                        Unit unit9 = Unit.INSTANCE;
                        return;
                    }
                    if (!checkLuminosity(face)) {
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.LUMINOSITY), StepLiveness.STEP_ZOOM_IN));
                        OverlayView overlayView15 = this.overlayView;
                        if (overlayView15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView15;
                        }
                        overlayView2.hideProcess();
                        Unit unit10 = Unit.INSTANCE;
                        return;
                    }
                    if (!isFaceStable(face.getBounds())) {
                        Log.d(this.TAG, tzend);
                        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.KEEP_HOLD_ON), stepLiveness2));
                        OverlayView overlayView16 = this.overlayView;
                        if (overlayView16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        } else {
                            overlayView2 = overlayView16;
                        }
                        overlayView2.showProcess();
                        Unit unit11 = Unit.INSTANCE;
                        return;
                    }
                    Log.d(this.TAG, btj.tzend(115));
                    this.hasZoomOutMutable.setValue(Boolean.TRUE);
                    if (this.isFinished) {
                        return;
                    }
                    OverlayView overlayView17 = this.overlayView;
                    if (overlayView17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(tzend3);
                        overlayView17 = null;
                    }
                    overlayView17.scale(true);
                    Unit unit12 = Unit.INSTANCE;
                    ImageView imageView2 = this.btnBack;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(tzend2);
                        imageView2 = null;
                    }
                    if (!imageView2.isEnabled()) {
                        return;
                    }
                    ?? r82 = this.btnBack;
                    overlayView = r82;
                }
                overlayView2.setVisibility(0);
                return;
            }
        }
        updateCompleted("");
    }

    private final boolean checkLuminosity(FaceResult face) {
        Float luminosity = face.getLuminosity();
        Boolean bool = null;
        LivenessConfig livenessConfig = null;
        if (luminosity != null) {
            float floatValue = luminosity.floatValue();
            LivenessConfig livenessConfig2 = this.livenessConfig;
            if (livenessConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(121));
            } else {
                livenessConfig = livenessConfig2;
            }
            bool = Boolean.valueOf(floatValue > livenessConfig.getLuminosityProbability() * ((float) 255));
        }
        return PrimitiveExtensionsKt.orFalse(bool);
    }

    private final boolean checkPose(FaceResult face) {
        float headEulerAngleX = face.getHeadEulerAngleX();
        if (-12.0f <= headEulerAngleX && headEulerAngleX <= 12.0f) {
            float headEulerAngleY = face.getHeadEulerAngleY();
            if (-8.0f <= headEulerAngleY && headEulerAngleY <= 5.0f) {
                float headEulerAngleZ = face.getHeadEulerAngleZ();
                if (-8.0f <= headEulerAngleZ && headEulerAngleZ <= 8.0f) {
                    return true;
                }
            }
        }
        Log.e(this.TAG, btj.tzend(122));
        Log.e(this.TAG, btj.tzend(123) + face.getHeadEulerAngleX());
        Log.e(this.TAG, btj.tzend(124) + face.getHeadEulerAngleY());
        Log.e(this.TAG, btj.tzend(125) + face.getHeadEulerAngleZ());
        return false;
    }

    private final boolean checkSmile(FaceResult face) {
        Float smilingProbability = face.getSmilingProbability();
        if (smilingProbability == null) {
            return true;
        }
        float floatValue = smilingProbability.floatValue();
        LivenessConfig livenessConfig = this.livenessConfig;
        String tzend = btj.tzend(126);
        LivenessConfig livenessConfig2 = null;
        if (livenessConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            livenessConfig = null;
        }
        if (livenessConfig.getSmileProbability() == 0.0f) {
            return true;
        }
        LivenessConfig livenessConfig3 = this.livenessConfig;
        if (livenessConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
        } else {
            livenessConfig2 = livenessConfig3;
        }
        if (floatValue <= livenessConfig2.getSmileProbability()) {
            return true;
        }
        Log.d(this.TAG, btj.tzend(WorkQueueKt.MASK));
        return false;
    }

    private final boolean checkStepWithRect(RectF rectF, FaceResult face, StepLiveness stepZoom) {
        this.currentStep = stepZoom;
        if (rectF == null) {
            Log.e(this.TAG, btj.tzend(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO));
            return false;
        }
        OverlayView overlayView = this.overlayView;
        String tzend = btj.tzend(128);
        OverlayView overlayView2 = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            overlayView = null;
        }
        int width = overlayView.getWidth();
        OverlayView overlayView3 = this.overlayView;
        if (overlayView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            overlayView3 = null;
        }
        Rect scaleBoundingBox = scaleBoundingBox(face, width, overlayView3.getHeight());
        showFace(new RectF(scaleBoundingBox));
        OverlayView overlayView4 = this.overlayView;
        if (overlayView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
        } else {
            overlayView2 = overlayView4;
        }
        RectF rectDetect = overlayView2.getRectDetect(rectF);
        float width2 = (scaleBoundingBox.width() * scaleBoundingBox.height()) / (rectF.width() * rectF.height());
        Log.d(this.TAG, btj.tzend(TsExtractor.TS_STREAM_TYPE_AC3) + width2);
        boolean isFaceInOval = isFaceInOval(new RectF(scaleBoundingBox), rectDetect);
        String tzend2 = btj.tzend(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        if (isFaceInOval) {
            double d = width2;
            if (d < 0.6d) {
                Log.d(this.TAG, btj.tzend(132));
                setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.MOVE_CLOSER), stepZoom));
                return false;
            }
            String str = this.TAG;
            if (d <= 1.05d) {
                Log.e(str, btj.tzend(133));
                return true;
            }
            Log.d(str, tzend2);
            setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.MOVE_AWAY), stepZoom));
            return false;
        }
        Rect rect = new Rect();
        rectDetect.roundOut(rect);
        if (!scaleBoundingBox.intersect(rect) || (width2 <= 1.05d && scaleBoundingBox.top >= rectDetect.top && scaleBoundingBox.bottom <= rectDetect.bottom)) {
            Log.d(this.TAG, btj.tzend(131));
            setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.FRAME_YOUR_FACE_IN_OVAL), stepZoom));
            return false;
        }
        Log.d(this.TAG, tzend2);
        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.MOVE_AWAY), stepZoom));
        return false;
    }

    private final String getStatusMessage(StateFaceWithOval stateFaceWithOval) {
        return this.getStatusMessageUseCase.invoke(stateFaceWithOval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFaces(List<FaceResult> listFaceResult) {
        this.facesMutable = listFaceResult;
        Log.d(this.TAG, btj.tzend(TsExtractor.TS_STREAM_TYPE_E_AC3) + this.facesMutable.size());
        if (System.currentTimeMillis() - this.currentTime > 200) {
            boolean isFacesDetectedCorrect = this.livenessRepository.isFacesDetectedCorrect(listFaceResult);
            this.isFacesDetectedCorrect = isFacesDetectedCorrect;
            if (isFacesDetectedCorrect || !(!listFaceResult.isEmpty())) {
                if (listFaceResult.isEmpty()) {
                    Log.d(this.TAG, btj.tzend(TsExtractor.TS_STREAM_TYPE_DTS_HD));
                    showStateNoFace();
                    return;
                }
                return;
            }
            FaceResult faceResult = (FaceResult) CollectionsKt.first((List) listFaceResult);
            for (FaceResult faceResult2 : listFaceResult) {
                if (faceResult2.getBounds().height() * faceResult2.getBounds().width() > faceResult.getBounds().height() * faceResult.getBounds().width()) {
                    faceResult = faceResult2;
                }
            }
            this.currentTime = System.currentTimeMillis();
            checkFaceLiveness(faceResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hideLoading$lambda-13, reason: not valid java name */
    public static final void m2590hideLoading$lambda13(LivenessViewModel livenessViewModel) {
        OverlayView overlayView = livenessViewModel.overlayView;
        String tzend = btj.tzend(137);
        ImageView imageView = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            overlayView = null;
        }
        overlayView.hideTextCenter();
        OverlayView overlayView2 = livenessViewModel.overlayView;
        if (overlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend);
            overlayView2 = null;
        }
        overlayView2.hideBlur();
        ImageView imageView2 = livenessViewModel.btnBack;
        String tzend2 = btj.tzend(TsExtractor.TS_STREAM_TYPE_DTS);
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(tzend2);
            imageView2 = null;
        }
        if (imageView2.isEnabled()) {
            ImageView imageView3 = livenessViewModel.btnBack;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(tzend2);
            } else {
                imageView = imageView3;
            }
            imageView.setVisibility(0);
        }
    }

    private final boolean isFaceInOval(RectF face, RectF oval) {
        return face.left >= oval.left && face.top >= oval.top && face.right <= oval.right && face.bottom <= oval.bottom;
    }

    private final boolean isFaceStable(Rect currentBounds) {
        Log.d(this.TAG, btj.tzend(TsExtractor.TS_STREAM_TYPE_DTS_UHD));
        if (this.faceHistory.size() >= this.maxFrames) {
            this.faceHistory.remove(0);
        }
        this.faceHistory.add(currentBounds);
        if (this.faceHistory.size() < this.maxFrames - 5) {
            return false;
        }
        int size = this.faceHistory.size();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (int i = 0; i < size; i++) {
            int size2 = this.faceHistory.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (i != i2) {
                    d = Math.max(d, calculateFaceMovement(UtilsKt.toDomainRect(this.faceHistory.get(i)), UtilsKt.toDomainRect(this.faceHistory.get(i2))));
                }
            }
        }
        Log.d(this.TAG, btj.tzend(140) + d);
        return d <= ((double) this.movementThreshold);
    }

    private final Rect scaleBoundingBox(FaceResult face, int screenWidth, int screenHeight) {
        float f = screenWidth;
        float intValue = (face.getImageRect() != null ? Integer.valueOf(r0.height()) : null).intValue() / f;
        float intValue2 = (face.getImageRect() != null ? Integer.valueOf(r2.width()) : null).intValue() / screenHeight;
        float f2 = f / 2;
        return new Rect((int) ((f2 - ((int) (face.getBounds().right / intValue))) + f2), (int) (face.getBounds().top / intValue2), (int) (f2 - (((int) (face.getBounds().left / intValue)) - f2)), (int) (face.getBounds().bottom / intValue2));
    }

    private final void showStateNoFace() {
        Log.d(this.TAG, btj.tzend(ModuleDescriptor.MODULE_VERSION));
        setState(this._state.livenessMessage(getStatusMessage(StateFaceWithOval.FRAME_YOUR_FACE_IN_OVAL), this.currentStep));
        OverlayView overlayView = this.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(142));
            overlayView = null;
        }
        overlayView.hideProcess();
    }

    private final void showSuccess() {
        OverlayView overlayView = this.overlayView;
        ImageView imageView = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(143));
            overlayView = null;
        }
        overlayView.setFinished();
        ImageView imageView2 = this.btnBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(144));
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    private final void stopBySystem() {
        OverlayView overlayView = this.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(145));
            overlayView = null;
        }
        overlayView.setSystemStop();
    }

    private final void updateCompleted(String newData) {
        this._callBackCompleted.setValue(newData);
    }

    public final void callFinish() {
        Log.e(this.TAG, btj.tzend(146) + this.isFinished);
        OverlayView overlayView = this.overlayView;
        ImageView imageView = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(147));
            overlayView = null;
        }
        overlayView.stopAnimation();
        overlayView.setFinished();
        this.isFinished = true;
        overlayView.showProcess();
        updateCompleted("");
        ImageView imageView2 = this.btnBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(148));
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    public final boolean faceNotCenter(RectF face, RectF oval, float percentage) {
        float width = oval.width() * percentage;
        float height = oval.height() * percentage;
        float f = face.left;
        float f2 = face.right;
        float f3 = oval.left;
        float f4 = oval.right;
        if (f - f3 < width || f4 - f2 < width) {
            return true;
        }
        return face.top - oval.top < height || oval.bottom - face.bottom < height;
    }

    public final LiveData<String> getCallBackCompleted() {
        return this._callBackCompleted;
    }

    public final LiveData<String> getHandleErrorLiveness() {
        return this._handleErrorLivenessMutable;
    }

    public final LiveData<Map<String, Object>> getHandleSuccessLiveness() {
        return this._handleSuccessLivenessMutable;
    }

    public final LiveData<Boolean> getHasFistCheck() {
        return this.hasFistCheck;
    }

    public final LiveData<Boolean> getHasHeadMovedCenter() {
        return this.hasHeadMovedCenter;
    }

    public final LiveData<Boolean> getHasZoomIn() {
        return this.hasZoomIn;
    }

    public final LiveData<Boolean> getHasZoomOut() {
        return this.hasZoomOut;
    }

    public final LinkedList<StepLiveness> getRequestedSteps() {
        return this.requestedSteps;
    }

    public final LiveData<StateFaceWithOval> getUpdateStateStepLiveness() {
        return this._updateStateStepLivenessMutable;
    }

    public final void hideLoading() {
        OverlayView overlayView = this.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(149));
            overlayView = null;
        }
        overlayView.post(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.viewmodel.LivenessViewModel$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LivenessViewModel.m2590hideLoading$lambda13(LivenessViewModel.this);
            }
        });
    }

    /* renamed from: isFinished, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    public final void observeFacesDetection(Flow<? extends List<FaceResult>> facesFlowable) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new LivenessViewModel$observeFacesDetection$1(facesFlowable, this, null), 3, null);
    }

    public final void reDraw() {
        OverlayView overlayView = this.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(150));
            overlayView = null;
        }
        overlayView.reset();
    }

    public final void removeCurrentStep() {
        this.requestedSteps.pop();
    }

    public final void reset() {
        OverlayView overlayView = this.overlayView;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(151));
            overlayView = null;
        }
        hideLoading();
        overlayView.scale(false);
    }

    public final void resetState() {
        Log.d(this.TAG, btj.tzend(152));
        LivenessViewState livenessViewState = this._state;
        String statusMessage = getStatusMessage(StateFaceWithOval.FRAME_YOUR_FACE_IN_OVAL);
        StepLiveness stepLiveness = StepLiveness.STEP_FIRST_CHECK;
        setState(livenessViewState.livenessMessage(statusMessage, stepLiveness));
        this.currentStep = stepLiveness;
    }

    public final void setFinished(boolean z) {
        this.isFinished = z;
    }

    public final void setRequestedSteps(LinkedList<StepLiveness> linkedList) {
        this.requestedSteps = linkedList;
    }

    public final void setupLivenessConfig(LivenessConfig livenessConfig) {
        this.livenessConfig = livenessConfig;
    }

    public final void setupSteps(List<? extends StepLiveness> validateRequested) {
        LinkedList<StepLiveness> linkedList = new LinkedList<>();
        linkedList.addAll(validateRequested);
        this.requestedSteps = linkedList;
        LinkedList<StepLiveness> linkedList2 = new LinkedList<>();
        linkedList2.addAll(validateRequested);
        this.originalRequestedSteps = linkedList2;
    }

    public final void setupView(ImageView btnBack, OverlayView overlayView) {
        this.btnBack = btnBack;
        this.overlayView = overlayView;
    }

    public final void showFace(RectF face) {
    }

    public final void showLoading() {
        OverlayView overlayView = this.overlayView;
        ImageView imageView = null;
        if (overlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(153));
            overlayView = null;
        }
        overlayView.drawTextCenter(UtilsKt.getTextByKey(overlayView.getContext(), btj.tzend(154), AuthenticationID.INSTANCE.getJsonLanguage$authenSDK_release()));
        ImageView imageView2 = this.btnBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(155));
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }
}
