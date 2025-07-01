package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.workaround.ExtraSupportedSurfaceCombinationsContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraMode;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class SupportedSurfaceCombination {
    private static final String TAG = "SupportedSurfaceCombination";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final String mCameraId;
    private final CameraCharacteristicsCompat mCharacteristics;
    private final DisplayInfoManager mDisplayInfoManager;
    private final DynamicRangeResolver mDynamicRangeResolver;
    private final ExtraSupportedSurfaceCombinationsContainer mExtraSupportedSurfaceCombinationsContainer;
    private final int mHardwareLevel;
    private boolean mIsBurstCaptureSupported;
    private boolean mIsConcurrentCameraModeSupported;
    private boolean mIsRawSupported;
    private boolean mIsStreamUseCaseSupported;
    private boolean mIsUltraHighResolutionSensorSupported;
    SurfaceSizeDefinition mSurfaceSizeDefinition;
    private final List<SurfaceCombination> mSurfaceCombinations = new ArrayList();
    private final List<SurfaceCombination> mUltraHighSurfaceCombinations = new ArrayList();
    private final List<SurfaceCombination> mConcurrentSurfaceCombinations = new ArrayList();
    private final Map<FeatureSettings, List<SurfaceCombination>> mFeatureSettingsToSupportedCombinationsMap = new HashMap();
    private final List<SurfaceCombination> mSurfaceCombinations10Bit = new ArrayList();
    private final List<SurfaceCombination> mSurfaceCombinationsStreamUseCase = new ArrayList();
    List<Integer> mSurfaceSizeDefinitionFormats = new ArrayList();
    private final TargetAspectRatio mTargetAspectRatio = new TargetAspectRatio();
    private final ResolutionCorrector mResolutionCorrector = new ResolutionCorrector();

    private void checkCustomization() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportedSurfaceCombination(Context context, String str, CameraManagerCompat cameraManagerCompat, CamcorderProfileHelper camcorderProfileHelper) throws CameraUnavailableException {
        this.mIsRawSupported = false;
        this.mIsBurstCaptureSupported = false;
        this.mIsConcurrentCameraModeSupported = false;
        this.mIsStreamUseCaseSupported = false;
        this.mIsUltraHighResolutionSensorSupported = false;
        String str2 = (String) Preconditions.checkNotNull(str);
        this.mCameraId = str2;
        this.mCamcorderProfileHelper = (CamcorderProfileHelper) Preconditions.checkNotNull(camcorderProfileHelper);
        this.mExtraSupportedSurfaceCombinationsContainer = new ExtraSupportedSurfaceCombinationsContainer();
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(context);
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str2);
            this.mCharacteristics = cameraCharacteristicsCompat;
            Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.mHardwareLevel = num != null ? num.intValue() : 2;
            int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i : iArr) {
                    if (i == 3) {
                        this.mIsRawSupported = true;
                    } else if (i == 6) {
                        this.mIsBurstCaptureSupported = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i == 16) {
                        this.mIsUltraHighResolutionSensorSupported = true;
                    }
                }
            }
            DynamicRangeResolver dynamicRangeResolver = new DynamicRangeResolver(this.mCharacteristics);
            this.mDynamicRangeResolver = dynamicRangeResolver;
            generateSupportedCombinationList();
            if (this.mIsUltraHighResolutionSensorSupported) {
                generateUltraHighSupportedCombinationList();
            }
            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.mIsConcurrentCameraModeSupported = hasSystemFeature;
            if (hasSystemFeature) {
                generateConcurrentSupportedCombinationList();
            }
            if (dynamicRangeResolver.is10BitDynamicRangeSupported()) {
                generate10BitSupportedCombinationList();
            }
            boolean isStreamUseCaseSupported = StreamUseCaseUtil.isStreamUseCaseSupported(this.mCharacteristics);
            this.mIsStreamUseCaseSupported = isStreamUseCaseSupported;
            if (isStreamUseCaseSupported) {
                generateStreamUseCaseSupportedCombinationList();
            }
            generateSurfaceSizeDefinition();
            checkCustomization();
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    String getCameraId() {
        return this.mCameraId;
    }

    boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    boolean checkSupported(FeatureSettings featureSettings, List<SurfaceConfig> list) {
        Iterator<SurfaceCombination> it = getSurfaceCombinationsByFeatureSettings(featureSettings).iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().getOrderedSupportedSurfaceConfigList(list) != null;
            if (z) {
                break;
            }
        }
        return z;
    }

    List<SurfaceConfig> getOrderedSupportedStreamUseCaseSurfaceConfigList(FeatureSettings featureSettings, List<SurfaceConfig> list) {
        if (!StreamUseCaseUtil.shouldUseStreamUseCase(featureSettings)) {
            return null;
        }
        Iterator<SurfaceCombination> it = this.mSurfaceCombinationsStreamUseCase.iterator();
        while (it.hasNext()) {
            List<SurfaceConfig> orderedSupportedSurfaceConfigList = it.next().getOrderedSupportedSurfaceConfigList(list);
            if (orderedSupportedSurfaceConfigList != null) {
                return orderedSupportedSurfaceConfigList;
            }
        }
        return null;
    }

    private List<SurfaceCombination> getSurfaceCombinationsByFeatureSettings(FeatureSettings featureSettings) {
        if (this.mFeatureSettingsToSupportedCombinationsMap.containsKey(featureSettings)) {
            return this.mFeatureSettingsToSupportedCombinationsMap.get(featureSettings);
        }
        List<SurfaceCombination> arrayList = new ArrayList<>();
        if (featureSettings.getRequiredMaxBitDepth() == 8) {
            int cameraMode = featureSettings.getCameraMode();
            if (cameraMode == 1) {
                arrayList = this.mConcurrentSurfaceCombinations;
            } else if (cameraMode == 2) {
                arrayList.addAll(this.mUltraHighSurfaceCombinations);
                arrayList.addAll(this.mSurfaceCombinations);
            } else {
                arrayList.addAll(this.mSurfaceCombinations);
            }
        } else if (featureSettings.getRequiredMaxBitDepth() == 10 && featureSettings.getCameraMode() == 0) {
            arrayList.addAll(this.mSurfaceCombinations10Bit);
        }
        this.mFeatureSettingsToSupportedCombinationsMap.put(featureSettings, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceConfig transformSurfaceConfig(int i, int i2, Size size) {
        return SurfaceConfig.transformSurfaceConfig(i, i2, size, getUpdatedSurfaceSizeDefinitionByFormat(i2));
    }

    static int getMaxFrameRate(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i, Size size) {
        try {
            return (int) (1.0E9d / ((StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(i, size));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int getRangeLength(Range<Integer> range) {
        return (range.getUpper().intValue() - range.getLower().intValue()) + 1;
    }

    private static int getRangeDistance(Range<Integer> range, Range<Integer> range2) {
        Preconditions.checkState((range.contains((Range<Integer>) range2.getUpper()) || range.contains((Range<Integer>) range2.getLower())) ? false : true, "Ranges must not intersect");
        if (range.getLower().intValue() > range2.getUpper().intValue()) {
            return range.getLower().intValue() - range2.getUpper().intValue();
        }
        return range2.getLower().intValue() - range.getUpper().intValue();
    }

    private static Range<Integer> compareIntersectingRanges(Range<Integer> range, Range<Integer> range2, Range<Integer> range3) {
        double rangeLength = getRangeLength(range2.intersect(range));
        double rangeLength2 = getRangeLength(range3.intersect(range));
        double rangeLength3 = rangeLength2 / getRangeLength(range3);
        double rangeLength4 = rangeLength / getRangeLength(range2);
        if (rangeLength2 > rangeLength) {
            if (rangeLength3 >= 0.5d || rangeLength3 >= rangeLength4) {
                return range3;
            }
        } else if (rangeLength2 == rangeLength) {
            if (rangeLength3 > rangeLength4) {
                return range3;
            }
            if (rangeLength3 == rangeLength4 && range3.getLower().intValue() > range2.getLower().intValue()) {
                return range3;
            }
        } else if (rangeLength4 < 0.5d && rangeLength3 > rangeLength4) {
            return range3;
        }
        return range2;
    }

    private Range<Integer> getClosestSupportedDeviceFrameRate(Range<Integer> range, int i) {
        if (range == null || range.equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        }
        Range<Integer>[] rangeArr = (Range[]) this.mCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr == null) {
            return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        }
        Range<Integer> range2 = new Range<>(Integer.valueOf(Math.min(range.getLower().intValue(), i)), Integer.valueOf(Math.min(range.getUpper().intValue(), i)));
        Range<Integer> range3 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        int i2 = 0;
        for (Range<Integer> range4 : rangeArr) {
            if (i >= range4.getLower().intValue()) {
                if (range3.equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
                    range3 = range4;
                }
                if (range4.equals(range2)) {
                    return range4;
                }
                try {
                    int rangeLength = getRangeLength(range4.intersect(range2));
                    if (i2 == 0) {
                        i2 = rangeLength;
                    } else {
                        if (rangeLength >= i2) {
                            range3 = compareIntersectingRanges(range2, range3, range4);
                            i2 = getRangeLength(range2.intersect(range3));
                        }
                        range4 = range3;
                    }
                } catch (IllegalArgumentException unused) {
                    if (i2 == 0) {
                        if (getRangeDistance(range4, range2) >= getRangeDistance(range3, range2)) {
                            if (getRangeDistance(range4, range2) == getRangeDistance(range3, range2)) {
                                if (range4.getLower().intValue() <= range3.getUpper().intValue() && getRangeLength(range4) >= getRangeLength(range3)) {
                                }
                            }
                        }
                    }
                }
                range3 = range4;
            }
        }
        return range3;
    }

    private Range<Integer> getUpdatedTargetFramerate(Range<Integer> range, Range<Integer> range2) {
        if (range2 == null) {
            return range;
        }
        if (range != null) {
            try {
                return range2.intersect(range);
            } catch (IllegalArgumentException unused) {
            }
        }
        return range2;
    }

    private int getUpdatedMaximumFps(int i, int i2, Size size) {
        return Math.min(i, getMaxFrameRate(this.mCharacteristics, i2, size));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecifications(int i, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        Range<Integer> range;
        List<Integer> list2;
        Map<UseCaseConfig<?>, DynamicRange> map2;
        int i2;
        String str;
        String str2;
        HashMap hashMap4;
        List<SurfaceConfig> list3;
        String str3;
        String str4;
        HashMap hashMap5;
        HashMap hashMap6;
        List<Size> list4;
        List<Size> list5;
        HashMap hashMap7;
        int i3;
        int i4;
        int i5;
        String str5;
        refreshPreviewSize();
        ArrayList arrayList = new ArrayList(map.keySet());
        List<Integer> useCasesPriorityOrder = getUseCasesPriorityOrder(arrayList);
        Map<UseCaseConfig<?>, DynamicRange> resolveAndValidateDynamicRanges = this.mDynamicRangeResolver.resolveAndValidateDynamicRanges(list, arrayList, useCasesPriorityOrder);
        FeatureSettings createFeatureSettings = createFeatureSettings(i, resolveAndValidateDynamicRanges);
        boolean isUseCasesCombinationSupported = isUseCasesCombinationSupported(createFeatureSettings, list, map);
        String str6 = ".  May be attempting to bind too many use cases. Existing surfaces: ";
        String str7 = " New configs: ";
        String str8 = "No supported surface combination is found for camera device - Id : ";
        if (!isUseCasesCombinationSupported) {
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.mCameraId + ".  May be attempting to bind too many use cases. Existing surfaces: " + list + " New configs: " + arrayList);
        }
        Range<Integer> targetFpsRange = getTargetFpsRange(list, arrayList, useCasesPriorityOrder);
        Map<UseCaseConfig<?>, List<Size>> filterSupportedSizes = filterSupportedSizes(map, createFeatureSettings, targetFpsRange);
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it = useCasesPriorityOrder.iterator();
        while (it.hasNext()) {
            UseCaseConfig<?> useCaseConfig = arrayList.get(it.next().intValue());
            arrayList2.add(applyResolutionSelectionOrderRelatedWorkarounds(filterSupportedSizes.get(useCaseConfig), useCaseConfig.getInputFormat()));
        }
        List<List<Size>> allPossibleSizeArrangements = getAllPossibleSizeArrangements(arrayList2);
        HashMap hashMap8 = new HashMap();
        HashMap hashMap9 = new HashMap();
        HashMap hashMap10 = new HashMap();
        HashMap hashMap11 = new HashMap();
        boolean containsZslUseCase = StreamUseCaseUtil.containsZslUseCase(list, arrayList);
        int maxSupportedFpsFromAttachedSurfaces = getMaxSupportedFpsFromAttachedSurfaces(list);
        HashMap hashMap12 = hashMap11;
        if (!this.mIsStreamUseCaseSupported || containsZslUseCase) {
            hashMap = hashMap10;
            hashMap2 = hashMap9;
            hashMap3 = hashMap8;
            range = targetFpsRange;
            list2 = useCasesPriorityOrder;
            map2 = resolveAndValidateDynamicRanges;
            i2 = maxSupportedFpsFromAttachedSurfaces;
            str = "No supported surface combination is found for camera device - Id : ";
            str2 = " New configs: ";
            hashMap4 = hashMap12;
            list3 = null;
        } else {
            Iterator<List<Size>> it2 = allPossibleSizeArrangements.iterator();
            List<SurfaceConfig> list6 = null;
            while (true) {
                if (!it2.hasNext()) {
                    hashMap2 = hashMap9;
                    hashMap3 = hashMap8;
                    range = targetFpsRange;
                    list2 = useCasesPriorityOrder;
                    map2 = resolveAndValidateDynamicRanges;
                    i2 = maxSupportedFpsFromAttachedSurfaces;
                    str = str8;
                    str2 = str7;
                    str5 = str6;
                    hashMap4 = hashMap12;
                    hashMap = hashMap10;
                    break;
                }
                HashMap hashMap13 = hashMap12;
                HashMap hashMap14 = hashMap10;
                hashMap2 = hashMap9;
                hashMap3 = hashMap8;
                map2 = resolveAndValidateDynamicRanges;
                Range<Integer> range2 = targetFpsRange;
                List<Integer> list7 = useCasesPriorityOrder;
                range = range2;
                str = str8;
                int i6 = maxSupportedFpsFromAttachedSurfaces;
                i2 = maxSupportedFpsFromAttachedSurfaces;
                str2 = str7;
                list2 = useCasesPriorityOrder;
                str5 = str6;
                list6 = getOrderedSupportedStreamUseCaseSurfaceConfigList(createFeatureSettings, (List) getSurfaceConfigListAndFpsCeiling(i, list, it2.next(), arrayList, list7, i6, hashMap14, hashMap13).first);
                hashMap = hashMap14;
                hashMap4 = hashMap13;
                if (list6 != null && !StreamUseCaseUtil.areCaptureTypesEligible(hashMap, hashMap4, list6)) {
                    list6 = null;
                }
                if (list6 != null) {
                    if (StreamUseCaseUtil.areStreamUseCasesAvailableForSurfaceConfigs(this.mCharacteristics, list6)) {
                        break;
                    }
                    list6 = null;
                }
                hashMap.clear();
                hashMap4.clear();
                hashMap12 = hashMap4;
                hashMap10 = hashMap;
                str6 = str5;
                str8 = str;
                str7 = str2;
                resolveAndValidateDynamicRanges = map2;
                hashMap9 = hashMap2;
                hashMap8 = hashMap3;
                targetFpsRange = range;
                maxSupportedFpsFromAttachedSurfaces = i2;
                useCasesPriorityOrder = list2;
            }
            if (list6 == null && !isUseCasesCombinationSupported) {
                throw new IllegalArgumentException(str + this.mCameraId + str5 + list + str2 + arrayList);
            }
            list3 = list6;
        }
        Iterator<List<Size>> it3 = allPossibleSizeArrangements.iterator();
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MAX_VALUE;
        boolean z = false;
        boolean z2 = false;
        List<Size> list8 = null;
        List<Size> list9 = null;
        while (true) {
            if (!it3.hasNext()) {
                str3 = str;
                str4 = str2;
                hashMap5 = hashMap4;
                hashMap6 = hashMap;
                list4 = list8;
                list5 = list9;
                break;
            }
            List<Size> next = it3.next();
            int i9 = i7;
            int i10 = i8;
            str4 = str2;
            hashMap5 = hashMap4;
            str3 = str;
            hashMap6 = hashMap;
            Pair<List<SurfaceConfig>, Integer> surfaceConfigListAndFpsCeiling = getSurfaceConfigListAndFpsCeiling(i, list, next, arrayList, list2, i2, null, null);
            List<SurfaceConfig> list10 = (List) surfaceConfigListAndFpsCeiling.first;
            i8 = ((Integer) surfaceConfigListAndFpsCeiling.second).intValue();
            int i11 = i2;
            boolean z3 = range == null || i11 <= i8 || i8 >= range.getLower().intValue();
            if (z || !checkSupported(createFeatureSettings, list10)) {
                i3 = i10;
                i4 = Integer.MAX_VALUE;
            } else {
                i3 = i10;
                i4 = Integer.MAX_VALUE;
                if (i3 == Integer.MAX_VALUE || i3 < i8) {
                    i3 = i8;
                    list8 = next;
                }
                if (z3) {
                    if (z2) {
                        list5 = list9;
                        list4 = next;
                        i7 = i9;
                        break;
                    }
                    z = true;
                    i3 = i8;
                    list8 = next;
                }
            }
            if (list3 == null || z2 || getOrderedSupportedStreamUseCaseSurfaceConfigList(createFeatureSettings, list10) == null) {
                i5 = i9;
            } else {
                i5 = i9;
                if (i5 == i4 || i5 < i8) {
                    i5 = i8;
                    list9 = next;
                }
                if (!z3) {
                    continue;
                } else {
                    if (z) {
                        i7 = i8;
                        i8 = i3;
                        list4 = list8;
                        list5 = next;
                        break;
                    }
                    z2 = true;
                    i5 = i8;
                    list9 = next;
                }
            }
            i2 = i11;
            i8 = i3;
            hashMap = hashMap6;
            hashMap4 = hashMap5;
            str = str3;
            str2 = str4;
            i7 = i5;
        }
        if (list4 != null) {
            Range<Integer> closestSupportedDeviceFrameRate = range != null ? getClosestSupportedDeviceFrameRate(range, i8) : null;
            Iterator<UseCaseConfig<?>> it4 = arrayList.iterator();
            while (it4.hasNext()) {
                UseCaseConfig<?> next2 = it4.next();
                List<Integer> list11 = list2;
                Map<UseCaseConfig<?>, DynamicRange> map3 = map2;
                Iterator<UseCaseConfig<?>> it5 = it4;
                StreamSpec.Builder implementationOptions = StreamSpec.builder(list4.get(list11.indexOf(Integer.valueOf(arrayList.indexOf(next2))))).setDynamicRange((DynamicRange) Preconditions.checkNotNull(map3.get(next2))).setImplementationOptions(StreamUseCaseUtil.getStreamSpecImplementationOptions(next2));
                if (closestSupportedDeviceFrameRate != null) {
                    implementationOptions.setExpectedFrameRateRange(closestSupportedDeviceFrameRate);
                }
                hashMap2.put(next2, implementationOptions.build());
                it4 = it5;
                list2 = list11;
                map2 = map3;
            }
            HashMap hashMap15 = hashMap2;
            if (list3 != null && i8 == i7 && list4.size() == list5.size()) {
                for (int i12 = 0; i12 < list4.size(); i12++) {
                    if (list4.get(i12).equals(list5.get(i12))) {
                    }
                }
                hashMap7 = hashMap3;
                if (!StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithInteropOverride(this.mCharacteristics, list, hashMap15, hashMap7)) {
                    StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(hashMap15, hashMap7, hashMap6, hashMap5, list3);
                }
                return new Pair<>(hashMap15, hashMap7);
            }
            hashMap7 = hashMap3;
            return new Pair<>(hashMap15, hashMap7);
        }
        throw new IllegalArgumentException(str3 + this.mCameraId + " and Hardware level: " + this.mHardwareLevel + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list + str4 + arrayList);
    }

    private FeatureSettings createFeatureSettings(int i, Map<UseCaseConfig<?>, DynamicRange> map) {
        int requiredMaxBitDepth = getRequiredMaxBitDepth(map);
        if (i != 0 && requiredMaxBitDepth == 10) {
            throw new IllegalArgumentException(String.format("Camera device id is %s. 10 bit dynamic range is not currently supported in %s camera mode.", this.mCameraId, CameraMode.toLabelString(i)));
        }
        return FeatureSettings.of(i, requiredMaxBitDepth);
    }

    private boolean isUseCasesCombinationSupported(FeatureSettings featureSettings, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSurfaceConfig());
        }
        CompareSizesByArea compareSizesByArea = new CompareSizesByArea();
        for (UseCaseConfig<?> useCaseConfig : map.keySet()) {
            List<Size> list2 = map.get(useCaseConfig);
            Preconditions.checkArgument((list2 == null || list2.isEmpty()) ? false : true, "No available output size is found for " + useCaseConfig + ".");
            Size size = (Size) Collections.min(list2, compareSizesByArea);
            int inputFormat = useCaseConfig.getInputFormat();
            arrayList.add(SurfaceConfig.transformSurfaceConfig(featureSettings.getCameraMode(), inputFormat, size, getUpdatedSurfaceSizeDefinitionByFormat(inputFormat)));
        }
        return checkSupported(featureSettings, arrayList);
    }

    private Range<Integer> getTargetFpsRange(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2, List<Integer> list3) {
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        Range<Integer> range = null;
        while (it.hasNext()) {
            range = getUpdatedTargetFramerate(it.next().getTargetFrameRate(), range);
        }
        Iterator<Integer> it2 = list3.iterator();
        while (it2.hasNext()) {
            range = getUpdatedTargetFramerate(list2.get(it2.next().intValue()).getTargetFrameRate(null), range);
        }
        return range;
    }

    private int getMaxSupportedFpsFromAttachedSurfaces(List<AttachedSurfaceInfo> list) {
        int i = Integer.MAX_VALUE;
        for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
            i = getUpdatedMaximumFps(i, attachedSurfaceInfo.getImageFormat(), attachedSurfaceInfo.getSize());
        }
        return i;
    }

    private Map<UseCaseConfig<?>, List<Size>> filterSupportedSizes(Map<UseCaseConfig<?>, List<Size>> map, FeatureSettings featureSettings, Range<Integer> range) {
        HashMap hashMap = new HashMap();
        for (UseCaseConfig<?> useCaseConfig : map.keySet()) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap2 = new HashMap();
            for (Size size : map.get(useCaseConfig)) {
                int inputFormat = useCaseConfig.getInputFormat();
                SurfaceConfig.ConfigSize configSize = SurfaceConfig.transformSurfaceConfig(featureSettings.getCameraMode(), inputFormat, size, getUpdatedSurfaceSizeDefinitionByFormat(inputFormat)).getConfigSize();
                int maxFrameRate = range != null ? getMaxFrameRate(this.mCharacteristics, inputFormat, size) : Integer.MAX_VALUE;
                Set set = (Set) hashMap2.get(configSize);
                if (set == null) {
                    set = new HashSet();
                    hashMap2.put(configSize, set);
                }
                if (!set.contains(Integer.valueOf(maxFrameRate))) {
                    arrayList.add(size);
                    set.add(Integer.valueOf(maxFrameRate));
                }
            }
            hashMap.put(useCaseConfig, arrayList);
        }
        return hashMap;
    }

    private Pair<List<SurfaceConfig>, Integer> getSurfaceConfigListAndFpsCeiling(int i, List<AttachedSurfaceInfo> list, List<Size> list2, List<UseCaseConfig<?>> list3, List<Integer> list4, int i2, Map<Integer, AttachedSurfaceInfo> map, Map<Integer, UseCaseConfig<?>> map2) {
        ArrayList arrayList = new ArrayList();
        for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
            arrayList.add(attachedSurfaceInfo.getSurfaceConfig());
            if (map != null) {
                map.put(Integer.valueOf(arrayList.size() - 1), attachedSurfaceInfo);
            }
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            Size size = list2.get(i3);
            UseCaseConfig<?> useCaseConfig = list3.get(list4.get(i3).intValue());
            int inputFormat = useCaseConfig.getInputFormat();
            arrayList.add(SurfaceConfig.transformSurfaceConfig(i, inputFormat, size, getUpdatedSurfaceSizeDefinitionByFormat(inputFormat)));
            if (map2 != null) {
                map2.put(Integer.valueOf(arrayList.size() - 1), useCaseConfig);
            }
            i2 = getUpdatedMaximumFps(i2, useCaseConfig.getInputFormat(), size);
        }
        return new Pair<>(arrayList, Integer.valueOf(i2));
    }

    List<Size> applyResolutionSelectionOrderRelatedWorkarounds(List<Size> list, int i) {
        Rational rational;
        int i2 = this.mTargetAspectRatio.get(this.mCameraId, this.mCharacteristics);
        if (i2 == 0) {
            rational = AspectRatioUtil.ASPECT_RATIO_4_3;
        } else if (i2 == 1) {
            rational = AspectRatioUtil.ASPECT_RATIO_16_9;
        } else if (i2 != 2) {
            rational = null;
        } else {
            Size maximumSize = getUpdatedSurfaceSizeDefinitionByFormat(256).getMaximumSize(256);
            rational = new Rational(maximumSize.getWidth(), maximumSize.getHeight());
        }
        if (rational != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Size size : list) {
                if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                    arrayList.add(size);
                } else {
                    arrayList2.add(size);
                }
            }
            arrayList2.addAll(0, arrayList);
            list = arrayList2;
        }
        return this.mResolutionCorrector.insertOrPrioritize(SurfaceConfig.getConfigType(i), list);
    }

    private static int getRequiredMaxBitDepth(Map<UseCaseConfig<?>, DynamicRange> map) {
        Iterator<DynamicRange> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next().getBitDepth() == 10) {
                return 10;
            }
        }
        return 8;
    }

    private List<Integer> getUseCasesPriorityOrder(List<UseCaseConfig<?>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<UseCaseConfig<?>> it = list.iterator();
        while (it.hasNext()) {
            int surfaceOccupancyPriority = it.next().getSurfaceOccupancyPriority(0);
            if (!arrayList2.contains(Integer.valueOf(surfaceOccupancyPriority))) {
                arrayList2.add(Integer.valueOf(surfaceOccupancyPriority));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int intValue = ((Integer) it2.next()).intValue();
            for (UseCaseConfig<?> useCaseConfig : list) {
                if (intValue == useCaseConfig.getSurfaceOccupancyPriority(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(useCaseConfig)));
                }
            }
        }
        return arrayList;
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> list) {
        Iterator<List<Size>> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            i *= it.next().size();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new ArrayList());
        }
        int size = i / list.get(0).size();
        int i3 = i;
        for (int i4 = 0; i4 < list.size(); i4++) {
            List<Size> list2 = list.get(i4);
            for (int i5 = 0; i5 < i; i5++) {
                ((List) arrayList.get(i5)).add(list2.get((i5 % i3) / size));
            }
            if (i4 < list.size() - 1) {
                i3 = size;
                size /= list.get(i4 + 1).size();
            }
        }
        return arrayList;
    }

    private Size getMaxOutputSizeByFormat(StreamConfigurationMap streamConfigurationMap, int i, boolean z) {
        Size[] outputSizes;
        Size[] highResolutionOutputSizes;
        if (i == 34) {
            outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        } else {
            outputSizes = streamConfigurationMap.getOutputSizes(i);
        }
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        CompareSizesByArea compareSizesByArea = new CompareSizesByArea();
        Size size = (Size) Collections.max(Arrays.asList(outputSizes), compareSizesByArea);
        Size size2 = SizeUtil.RESOLUTION_ZERO;
        if (z && (highResolutionOutputSizes = Api23Impl.getHighResolutionOutputSizes(streamConfigurationMap, i)) != null && highResolutionOutputSizes.length > 0) {
            size2 = (Size) Collections.max(Arrays.asList(highResolutionOutputSizes), compareSizesByArea);
        }
        return (Size) Collections.max(Arrays.asList(size, size2), compareSizesByArea);
    }

    private void generateSupportedCombinationList() {
        this.mSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.generateSupportedCombinationList(this.mHardwareLevel, this.mIsRawSupported, this.mIsBurstCaptureSupported));
        this.mSurfaceCombinations.addAll(this.mExtraSupportedSurfaceCombinationsContainer.get(this.mCameraId, this.mHardwareLevel));
    }

    private void generateUltraHighSupportedCombinationList() {
        this.mUltraHighSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getUltraHighResolutionSupportedCombinationList());
    }

    private void generateConcurrentSupportedCombinationList() {
        this.mConcurrentSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getConcurrentSupportedCombinationList());
    }

    private void generate10BitSupportedCombinationList() {
        this.mSurfaceCombinations10Bit.addAll(GuaranteedConfigurationsUtil.get10BitSupportedCombinationList());
    }

    private void generateStreamUseCaseSupportedCombinationList() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.mSurfaceCombinationsStreamUseCase.addAll(GuaranteedConfigurationsUtil.getStreamUseCaseSupportedCombinationList());
        }
    }

    private void generateSurfaceSizeDefinition() {
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(SizeUtil.RESOLUTION_VGA, new HashMap(), this.mDisplayInfoManager.getPreviewSize(), new HashMap(), getRecordSize(), new HashMap(), new HashMap());
    }

    SurfaceSizeDefinition getUpdatedSurfaceSizeDefinitionByFormat(int i) {
        if (!this.mSurfaceSizeDefinitionFormats.contains(Integer.valueOf(i))) {
            updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS720pSizeMap(), SizeUtil.RESOLUTION_720P, i);
            updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS1440pSizeMap(), SizeUtil.RESOLUTION_1440P, i);
            updateMaximumSizeByFormat(this.mSurfaceSizeDefinition.getMaximumSizeMap(), i);
            updateUltraMaximumSizeByFormat(this.mSurfaceSizeDefinition.getUltraMaximumSizeMap(), i);
            this.mSurfaceSizeDefinitionFormats.add(Integer.valueOf(i));
        }
        return this.mSurfaceSizeDefinition;
    }

    private void updateS720pOrS1440pSizeByFormat(Map<Integer, Size> map, Size size, int i) {
        if (this.mIsConcurrentCameraModeSupported) {
            Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), i, false);
            Integer valueOf = Integer.valueOf(i);
            if (maxOutputSizeByFormat != null) {
                size = (Size) Collections.min(Arrays.asList(size, maxOutputSizeByFormat), new CompareSizesByArea());
            }
            map.put(valueOf, size);
        }
    }

    private void updateMaximumSizeByFormat(Map<Integer, Size> map, int i) {
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), i, true);
        if (maxOutputSizeByFormat != null) {
            map.put(Integer.valueOf(i), maxOutputSizeByFormat);
        }
    }

    private void updateUltraMaximumSizeByFormat(Map<Integer, Size> map, int i) {
        CameraCharacteristics.Key key;
        if (Build.VERSION.SDK_INT < 31 || !this.mIsUltraHighResolutionSensorSupported) {
            return;
        }
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCharacteristics;
        key = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(key);
        if (streamConfigurationMap == null) {
            return;
        }
        map.put(Integer.valueOf(i), getMaxOutputSizeByFormat(streamConfigurationMap, i, true));
    }

    private void refreshPreviewSize() {
        this.mDisplayInfoManager.refresh();
        if (this.mSurfaceSizeDefinition == null) {
            generateSurfaceSizeDefinition();
        } else {
            this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(this.mSurfaceSizeDefinition.getAnalysisSize(), this.mSurfaceSizeDefinition.getS720pSizeMap(), this.mDisplayInfoManager.getPreviewSize(), this.mSurfaceSizeDefinition.getS1440pSizeMap(), this.mSurfaceSizeDefinition.getRecordSize(), this.mSurfaceSizeDefinition.getMaximumSizeMap(), this.mSurfaceSizeDefinition.getUltraMaximumSizeMap());
        }
    }

    private Size getRecordSize() {
        try {
            int parseInt = Integer.parseInt(this.mCameraId);
            CamcorderProfile camcorderProfile = this.mCamcorderProfileHelper.hasProfile(parseInt, 1) ? this.mCamcorderProfileHelper.get(parseInt, 1) : null;
            if (camcorderProfile != null) {
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            }
            return getRecordSizeByHasProfile(parseInt);
        } catch (NumberFormatException unused) {
            return getRecordSizeFromStreamConfigurationMap();
        }
    }

    private Size getRecordSizeFromStreamConfigurationMap() {
        Size[] outputSizes = this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap().getOutputSizes(MediaRecorder.class);
        if (outputSizes == null) {
            return SizeUtil.RESOLUTION_480P;
        }
        Arrays.sort(outputSizes, new CompareSizesByArea(true));
        for (Size size : outputSizes) {
            if (size.getWidth() <= SizeUtil.RESOLUTION_1080P.getWidth() && size.getHeight() <= SizeUtil.RESOLUTION_1080P.getHeight()) {
                return size;
            }
        }
        return SizeUtil.RESOLUTION_480P;
    }

    private Size getRecordSizeByHasProfile(int i) {
        CamcorderProfile camcorderProfile;
        Size size = SizeUtil.RESOLUTION_480P;
        if (this.mCamcorderProfileHelper.hasProfile(i, 10)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i, 10);
        } else if (this.mCamcorderProfileHelper.hasProfile(i, 8)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i, 8);
        } else if (this.mCamcorderProfileHelper.hasProfile(i, 12)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i, 12);
        } else if (this.mCamcorderProfileHelper.hasProfile(i, 6)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i, 6);
        } else if (this.mCamcorderProfileHelper.hasProfile(i, 5)) {
            camcorderProfile = this.mCamcorderProfileHelper.get(i, 5);
        } else {
            camcorderProfile = this.mCamcorderProfileHelper.hasProfile(i, 4) ? this.mCamcorderProfileHelper.get(i, 4) : null;
        }
        return camcorderProfile != null ? new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) : size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static Size[] getHighResolutionOutputSizes(StreamConfigurationMap streamConfigurationMap, int i) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class FeatureSettings {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getCameraMode();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getRequiredMaxBitDepth();

        static FeatureSettings of(int i, int i2) {
            return new AutoValue_SupportedSurfaceCombination_FeatureSettings(i, i2);
        }
    }
}
