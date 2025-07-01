package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class PairedStatsAccumulator {
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();
    private double sumOfProductsOfDeltas = AudioStats.AUDIO_AMPLITUDE_NONE;

    private double ensurePositive(double value) {
        if (value > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return value;
        }
        return Double.MIN_VALUE;
    }

    public void add(double x, double y) {
        this.xStats.add(x);
        if (!Doubles.isFinite(x) || !Doubles.isFinite(y)) {
            this.sumOfProductsOfDeltas = Double.NaN;
        } else if (this.xStats.count() > 1) {
            this.sumOfProductsOfDeltas += (x - this.xStats.mean()) * (y - this.yStats.mean());
        }
        this.yStats.add(y);
    }

    public void addAll(PairedStats values) {
        if (values.count() == 0) {
            return;
        }
        this.xStats.addAll(values.xStats());
        if (this.yStats.count() == 0) {
            this.sumOfProductsOfDeltas = values.sumOfProductsOfDeltas();
        } else {
            this.sumOfProductsOfDeltas += values.sumOfProductsOfDeltas() + ((values.xStats().mean() - this.xStats.mean()) * (values.yStats().mean() - this.yStats.mean()) * values.count());
        }
        this.yStats.addAll(values.yStats());
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public long count() {
        return this.xStats.count();
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }

    public double populationCovariance() {
        Preconditions.checkState(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public final double sampleCovariance() {
        Preconditions.checkState(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public final double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
        Preconditions.checkState(sumOfSquaresOfDeltas > AudioStats.AUDIO_AMPLITUDE_NONE);
        Preconditions.checkState(sumOfSquaresOfDeltas2 > AudioStats.AUDIO_AMPLITUDE_NONE);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public final LinearTransformation leastSquaresFit() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > AudioStats.AUDIO_AMPLITUDE_NONE);
            return LinearTransformation.vertical(this.xStats.mean());
        }
        if (this.yStats.sumOfSquaresOfDeltas() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
        }
        return LinearTransformation.horizontal(this.yStats.mean());
    }

    private static double ensureInUnitRange(double value) {
        return Doubles.constrainToRange(value, -1.0d, 1.0d);
    }
}
