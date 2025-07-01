package kotlin.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

/* compiled from: UProgressionUtil.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", TtmlNode.START, TtmlNode.END, "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m2150differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int remainderUnsigned = Integer.remainderUnsigned(i, i3);
        int remainderUnsigned2 = Integer.remainderUnsigned(i2, i3);
        int compareUnsigned = Integer.compareUnsigned(remainderUnsigned, remainderUnsigned2);
        int m1039constructorimpl = UInt.m1039constructorimpl(remainderUnsigned - remainderUnsigned2);
        return compareUnsigned >= 0 ? m1039constructorimpl : UInt.m1039constructorimpl(m1039constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m2151differenceModulosambcqE(long j, long j2, long j3) {
        long remainderUnsigned = Long.remainderUnsigned(j, j3);
        long remainderUnsigned2 = Long.remainderUnsigned(j2, j3);
        int compareUnsigned = Long.compareUnsigned(remainderUnsigned, remainderUnsigned2);
        long m1118constructorimpl = ULong.m1118constructorimpl(remainderUnsigned - remainderUnsigned2);
        return compareUnsigned >= 0 ? m1118constructorimpl : ULong.m1118constructorimpl(m1118constructorimpl + j3);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m2153getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return Integer.compareUnsigned(i, i2) >= 0 ? i2 : UInt.m1039constructorimpl(i2 - m2150differenceModuloWZ9TVnA(i2, i, UInt.m1039constructorimpl(i3)));
        }
        if (i3 < 0) {
            return Integer.compareUnsigned(i, i2) <= 0 ? i2 : UInt.m1039constructorimpl(i2 + m2150differenceModuloWZ9TVnA(i, i2, UInt.m1039constructorimpl(-i3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m2152getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return Long.compareUnsigned(j, j2) >= 0 ? j2 : ULong.m1118constructorimpl(j2 - m2151differenceModulosambcqE(j2, j, ULong.m1118constructorimpl(j3)));
        }
        if (j3 < 0) {
            return Long.compareUnsigned(j, j2) <= 0 ? j2 : ULong.m1118constructorimpl(j2 + m2151differenceModulosambcqE(j, j2, ULong.m1118constructorimpl(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
