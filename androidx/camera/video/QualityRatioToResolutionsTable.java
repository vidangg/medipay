package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
class QualityRatioToResolutionsTable {
    private static final Map<Integer, Rational> sAspectRatioMap;
    private static final Map<Quality, Range<Integer>> sQualityRangeMap;
    private final Map<QualityRatio, List<Size>> mTable = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        sQualityRangeMap = hashMap;
        hashMap.put(Quality.UHD, Range.create(2160, 4319));
        hashMap.put(Quality.FHD, Range.create(1080, 1439));
        hashMap.put(Quality.HD, Range.create(720, 1079));
        hashMap.put(Quality.SD, Range.create(241, Integer.valueOf(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD)));
        HashMap hashMap2 = new HashMap();
        sAspectRatioMap = hashMap2;
        hashMap2.put(0, AspectRatioUtil.ASPECT_RATIO_4_3);
        hashMap2.put(1, AspectRatioUtil.ASPECT_RATIO_16_9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QualityRatioToResolutionsTable(List<Size> list, Map<Quality, Size> map) {
        for (Quality quality : sQualityRangeMap.keySet()) {
            this.mTable.put(QualityRatio.of(quality, -1), new ArrayList());
            Iterator<Integer> it = sAspectRatioMap.keySet().iterator();
            while (it.hasNext()) {
                this.mTable.put(QualityRatio.of(quality, it.next().intValue()), new ArrayList());
            }
        }
        addProfileSizesToTable(map);
        addResolutionsToTable(list);
        sortQualityRatioRow(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Size> getResolutions(Quality quality, int i) {
        List<Size> qualityRatioRow = getQualityRatioRow(quality, i);
        return qualityRatioRow != null ? new ArrayList(qualityRatioRow) : new ArrayList(0);
    }

    private void addProfileSizesToTable(Map<Quality, Size> map) {
        for (Map.Entry<Quality, Size> entry : map.entrySet()) {
            ((List) Objects.requireNonNull(getQualityRatioRow(entry.getKey(), -1))).add(entry.getValue());
        }
    }

    private void addResolutionsToTable(List<Size> list) {
        Integer findMappedAspectRatio;
        for (Size size : list) {
            Quality findMappedQuality = findMappedQuality(size);
            if (findMappedQuality != null && (findMappedAspectRatio = findMappedAspectRatio(size)) != null) {
                ((List) Objects.requireNonNull(getQualityRatioRow(findMappedQuality, findMappedAspectRatio.intValue()))).add(size);
            }
        }
    }

    private void sortQualityRatioRow(Map<Quality, Size> map) {
        for (Map.Entry<QualityRatio, List<Size>> entry : this.mTable.entrySet()) {
            Size size = map.get(entry.getKey().getQuality());
            if (size != null) {
                final int area = SizeUtil.getArea(size);
                Collections.sort(entry.getValue(), new Comparator() { // from class: androidx.camera.video.QualityRatioToResolutionsTable$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return QualityRatioToResolutionsTable.lambda$sortQualityRatioRow$0(area, (Size) obj, (Size) obj2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$sortQualityRatioRow$0(int i, Size size, Size size2) {
        return Math.abs(SizeUtil.getArea(size) - i) - Math.abs(SizeUtil.getArea(size2) - i);
    }

    private static Quality findMappedQuality(Size size) {
        for (Map.Entry<Quality, Range<Integer>> entry : sQualityRangeMap.entrySet()) {
            if (entry.getValue().contains((Range<Integer>) Integer.valueOf(size.getHeight()))) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static Integer findMappedAspectRatio(Size size) {
        for (Map.Entry<Integer, Rational> entry : sAspectRatioMap.entrySet()) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, entry.getValue(), SizeUtil.RESOLUTION_QVGA)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private List<Size> getQualityRatioRow(Quality quality, int i) {
        return this.mTable.get(QualityRatio.of(quality, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class QualityRatio {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int getAspectRatio();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Quality getQuality();

        static QualityRatio of(Quality quality, int i) {
            return new AutoValue_QualityRatioToResolutionsTable_QualityRatio(quality, i);
        }
    }
}
