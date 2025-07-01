package androidx.media3.extractor.mp3;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.media3.common.C;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.metadata.id3.MlltFrame;

/* loaded from: classes3.dex */
final class MlltSeeker implements Seeker {
    private final long durationUs;
    private final long[] referencePositions;
    private final long[] referenceTimesMs;

    @Override // androidx.media3.extractor.mp3.Seeker
    public int getAverageBitrate() {
        return C.RATE_UNSET_INT;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public static MlltSeeker create(long j, MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.bytesDeviations.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3];
            j3 += mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new MlltSeeker(jArr, jArr2, j2);
    }

    private MlltSeeker(long[] jArr, long[] jArr2, long j) {
        this.referencePositions = jArr;
        this.referenceTimesMs = jArr2;
        this.durationUs = j == C.TIME_UNSET ? Util.msToUs(jArr2[jArr2.length - 1]) : j;
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        Pair<Long, Long> linearlyInterpolate = linearlyInterpolate(Util.usToMs(Util.constrainValue(j, 0L, this.durationUs)), this.referenceTimesMs, this.referencePositions);
        return new SeekMap.SeekPoints(new SeekPoint(Util.msToUs(((Long) linearlyInterpolate.first).longValue()), ((Long) linearlyInterpolate.second).longValue()));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return Util.msToUs(((Long) linearlyInterpolate(j, this.referencePositions, this.referenceTimesMs).second).longValue());
    }

    @Override // androidx.media3.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    private static Pair<Long, Long> linearlyInterpolate(long j, long[] jArr, long[] jArr2) {
        int binarySearchFloor = Util.binarySearchFloor(jArr, j, true, true);
        long j2 = jArr[binarySearchFloor];
        long j3 = jArr2[binarySearchFloor];
        int i = binarySearchFloor + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i] == j2 ? AudioStats.AUDIO_AMPLITUDE_NONE : (j - j2) / (r6 - j2)) * (jArr2[i] - j3))) + j3));
    }
}
