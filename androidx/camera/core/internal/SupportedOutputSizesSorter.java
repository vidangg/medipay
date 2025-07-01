package androidx.camera.core.internal;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SupportedOutputSizesSorter {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final CameraInfoInternal mCameraInfoInternal;
    private final Rational mFullFovRatio;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final SupportedOutputSizesSorterLegacy mSupportedOutputSizesSorterLegacy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportedOutputSizesSorter(CameraInfoInternal cameraInfoInternal, Size size) {
        Rational calculateFullFovRatioFromSupportedOutputSizes;
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        if (size != null) {
            calculateFullFovRatioFromSupportedOutputSizes = calculateFullFovRatioFromActiveArraySize(size);
        } else {
            calculateFullFovRatioFromSupportedOutputSizes = calculateFullFovRatioFromSupportedOutputSizes(cameraInfoInternal);
        }
        this.mFullFovRatio = calculateFullFovRatioFromSupportedOutputSizes;
        boolean z = true;
        if (calculateFullFovRatioFromSupportedOutputSizes != null && calculateFullFovRatioFromSupportedOutputSizes.getNumerator() < calculateFullFovRatioFromSupportedOutputSizes.getDenominator()) {
            z = false;
        }
        this.mIsSensorLandscapeResolution = z;
        this.mSupportedOutputSizesSorterLegacy = new SupportedOutputSizesSorterLegacy(cameraInfoInternal, calculateFullFovRatioFromSupportedOutputSizes);
    }

    private Rational calculateFullFovRatioFromActiveArraySize(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational calculateFullFovRatioFromSupportedOutputSizes(CameraInfoInternal cameraInfoInternal) {
        List<Size> supportedResolutions = cameraInfoInternal.getSupportedResolutions(256);
        if (supportedResolutions.isEmpty()) {
            return null;
        }
        Size size = (Size) Collections.max(supportedResolutions, new CompareSizesByArea());
        return new Rational(size.getWidth(), size.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Size> getSortedSupportedOutputSizes(UseCaseConfig<?> useCaseConfig) {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        List<Size> customOrderedResolutions = imageOutputConfig.getCustomOrderedResolutions(null);
        if (customOrderedResolutions != null) {
            return customOrderedResolutions;
        }
        if (imageOutputConfig.getResolutionSelector(null) == null) {
            return this.mSupportedOutputSizesSorterLegacy.sortSupportedOutputSizes(getResolutionCandidateList(useCaseConfig), useCaseConfig);
        }
        return sortSupportedOutputSizesByResolutionSelector(useCaseConfig);
    }

    private List<Size> getCustomizedSupportedResolutionsFromConfig(int i, ImageOutputConfig imageOutputConfig) {
        Size[] sizeArr;
        List<Pair<Integer, Size[]>> supportedResolutions = imageOutputConfig.getSupportedResolutions(null);
        if (supportedResolutions != null) {
            for (Pair<Integer, Size[]> pair : supportedResolutions) {
                if (((Integer) pair.first).intValue() == i) {
                    sizeArr = (Size[]) pair.second;
                    break;
                }
            }
        }
        sizeArr = null;
        if (sizeArr == null) {
            return null;
        }
        return Arrays.asList(sizeArr);
    }

    private List<Size> sortSupportedOutputSizesByResolutionSelector(UseCaseConfig<?> useCaseConfig) {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        ResolutionSelector resolutionSelector = imageOutputConfig.getResolutionSelector();
        List<Size> resolutionCandidateList = getResolutionCandidateList(useCaseConfig);
        if (!useCaseConfig.isHigResolutionDisabled(false)) {
            resolutionCandidateList = applyHighResolutionSettings(resolutionCandidateList, resolutionSelector, useCaseConfig.getInputFormat());
        }
        LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy = applyAspectRatioStrategy(resolutionCandidateList, resolutionSelector.getAspectRatioStrategy());
        Size maxResolution = imageOutputConfig.getMaxResolution(null);
        if (maxResolution != null) {
            applyMaxResolutionRestriction(applyAspectRatioStrategy, maxResolution);
        }
        applyResolutionStrategy(applyAspectRatioStrategy, resolutionSelector.getResolutionStrategy());
        ArrayList arrayList = new ArrayList();
        Iterator<List<Size>> it = applyAspectRatioStrategy.values().iterator();
        while (it.hasNext()) {
            for (Size size : it.next()) {
                if (!arrayList.contains(size)) {
                    arrayList.add(size);
                }
            }
        }
        return applyResolutionFilter(arrayList, resolutionSelector.getResolutionFilter(), imageOutputConfig.getTargetRotation(0));
    }

    private List<Size> getResolutionCandidateList(UseCaseConfig<?> useCaseConfig) {
        int inputFormat = useCaseConfig.getInputFormat();
        List<Size> customizedSupportedResolutionsFromConfig = getCustomizedSupportedResolutionsFromConfig(inputFormat, (ImageOutputConfig) useCaseConfig);
        if (customizedSupportedResolutionsFromConfig == null) {
            customizedSupportedResolutionsFromConfig = this.mCameraInfoInternal.getSupportedResolutions(inputFormat);
        }
        ArrayList arrayList = new ArrayList(customizedSupportedResolutionsFromConfig);
        Collections.sort(arrayList, new CompareSizesByArea(true));
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "The retrieved supported resolutions from camera info internal is empty. Format is " + inputFormat + ".");
        }
        return arrayList;
    }

    private List<Size> applyHighResolutionSettings(List<Size> list, ResolutionSelector resolutionSelector, int i) {
        if (resolutionSelector.getAllowedResolutionMode() != 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.mCameraInfoInternal.getSupportedHighResolutions(i));
        Collections.sort(arrayList, new CompareSizesByArea(true));
        return arrayList;
    }

    private LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy(List<Size> list, AspectRatioStrategy aspectRatioStrategy) {
        return applyAspectRatioStrategyFallbackRule(groupSizesByAspectRatio(list), aspectRatioStrategy);
    }

    private LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategyFallbackRule(Map<Rational, List<Size>> map, AspectRatioStrategy aspectRatioStrategy) {
        Rational targetAspectRatioRationalValue = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), this.mIsSensorLandscapeResolution);
        if (aspectRatioStrategy.getFallbackRule() == 0) {
            Rational targetAspectRatioRationalValue2 = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), this.mIsSensorLandscapeResolution);
            Iterator it = new ArrayList(map.keySet()).iterator();
            while (it.hasNext()) {
                Rational rational = (Rational) it.next();
                if (!rational.equals(targetAspectRatioRationalValue2)) {
                    map.remove(rational);
                }
            }
        }
        ArrayList<Rational> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(targetAspectRatioRationalValue, this.mFullFovRatio));
        LinkedHashMap<Rational, List<Size>> linkedHashMap = new LinkedHashMap<>();
        for (Rational rational2 : arrayList) {
            linkedHashMap.put(rational2, map.get(rational2));
        }
        return linkedHashMap;
    }

    private static void applyResolutionStrategy(LinkedHashMap<Rational, List<Size>> linkedHashMap, ResolutionStrategy resolutionStrategy) {
        if (resolutionStrategy == null) {
            return;
        }
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            applyResolutionStrategyFallbackRule(linkedHashMap.get(it.next()), resolutionStrategy);
        }
    }

    private static void applyResolutionStrategyFallbackRule(List<Size> list, ResolutionStrategy resolutionStrategy) {
        if (list.isEmpty()) {
            return;
        }
        int fallbackRule = resolutionStrategy.getFallbackRule();
        Integer valueOf = Integer.valueOf(fallbackRule);
        if (resolutionStrategy.equals(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY)) {
            return;
        }
        Size boundSize = resolutionStrategy.getBoundSize();
        valueOf.getClass();
        if (fallbackRule == 0) {
            sortSupportedSizesByFallbackRuleNone(list, boundSize);
            return;
        }
        if (fallbackRule == 1) {
            sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, true);
            return;
        }
        if (fallbackRule == 2) {
            sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, false);
        } else if (fallbackRule == 3) {
            sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, true);
        } else {
            if (fallbackRule != 4) {
                return;
            }
            sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, false);
        }
    }

    private static void applyMaxResolutionRestriction(LinkedHashMap<Rational, List<Size>> linkedHashMap, Size size) {
        int area = SizeUtil.getArea(size);
        Iterator<Rational> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            List<Size> list = linkedHashMap.get(it.next());
            ArrayList arrayList = new ArrayList();
            for (Size size2 : list) {
                if (SizeUtil.getArea(size2) <= area) {
                    arrayList.add(size2);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
    }

    private List<Size> applyResolutionFilter(List<Size> list, ResolutionFilter resolutionFilter, int i) {
        if (resolutionFilter == null) {
            return list;
        }
        List<Size> filter = resolutionFilter.filter(new ArrayList(list), CameraOrientationUtil.getRelativeImageRotation(CameraOrientationUtil.surfaceRotationToDegrees(i), this.mSensorOrientation, this.mLensFacing == 1));
        if (list.containsAll(filter)) {
            return filter;
        }
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    private static void sortSupportedSizesByFallbackRuleNone(List<Size> list, Size size) {
        boolean contains = list.contains(size);
        list.clear();
        if (contains) {
            list.add(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sortSupportedSizesByFallbackRuleClosestHigherThenLower(List<Size> list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void sortSupportedSizesByFallbackRuleClosestLowerThenHigher(List<Size> list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Size size2 = list.get(i);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z) {
            list.addAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rational getTargetAspectRatioRationalValue(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    return AspectRatioUtil.ASPECT_RATIO_4_3;
                }
                return AspectRatioUtil.ASPECT_RATIO_3_4;
            }
            if (i == 1) {
                if (z) {
                    return AspectRatioUtil.ASPECT_RATIO_16_9;
                }
                return AspectRatioUtil.ASPECT_RATIO_9_16;
            }
            Logger.e(TAG, "Undefined target aspect ratio: " + i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Rational> getResolutionListGroupingAspectRatioKeys(List<Size> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        for (Size size : list) {
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList.contains(rational)) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (AspectRatioUtil.hasMatchingAspectRatio(size, (Rational) it.next())) {
                            break;
                        }
                    } else {
                        arrayList.add(rational);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> list) {
        HashMap hashMap = new HashMap();
        Iterator<Rational> it = getResolutionListGroupingAspectRatioKeys(list).iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), new ArrayList());
        }
        for (Size size : list) {
            for (Rational rational : hashMap.keySet()) {
                if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                    ((List) hashMap.get(rational)).add(size);
                }
            }
        }
        return hashMap;
    }
}
