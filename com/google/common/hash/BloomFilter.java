package com.google.common.hash;

import androidx.camera.video.AudioStats;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 912559;
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(@ParametricNullness T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.LockFreeBitArray bits);

        int ordinal();

        <T> boolean put(@ParametricNullness T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.LockFreeBitArray bits);
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray bits, int numHashFunctions, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.checkArgument(numHashFunctions > 0, "numHashFunctions (%s) must be > 0", numHashFunctions);
        Preconditions.checkArgument(numHashFunctions <= 255, "numHashFunctions (%s) must be <= 255", numHashFunctions);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(bits);
        this.numHashFunctions = numHashFunctions;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(@ParametricNullness T object) {
        return this.strategy.mightContain(object, this.funnel, this.numHashFunctions, this.bits);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(@ParametricNullness T input) {
        return mightContain(input);
    }

    public boolean put(@ParametricNullness T object) {
        return this.strategy.put(object, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
    }

    public long approximateElementCount() {
        double bitSize = this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(this.bits.bitCount() / bitSize))) * bitSize) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    long bitSize() {
        return this.bits.bitSize();
    }

    public boolean isCompatible(BloomFilter<T> that) {
        Preconditions.checkNotNull(that);
        return this != that && this.numHashFunctions == that.numHashFunctions && bitSize() == that.bitSize() && this.strategy.equals(that.strategy) && this.funnel.equals(that.funnel);
    }

    public void putAll(BloomFilter<T> that) {
        Preconditions.checkNotNull(that);
        Preconditions.checkArgument(this != that, "Cannot combine a BloomFilter with itself.");
        int i = this.numHashFunctions;
        int i2 = that.numHashFunctions;
        Preconditions.checkArgument(i == i2, "BloomFilters must have the same number of hash functions (%s != %s)", i, i2);
        Preconditions.checkArgument(bitSize() == that.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), that.bitSize());
        Preconditions.checkArgument(this.strategy.equals(that.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, that.strategy);
        Preconditions.checkArgument(this.funnel.equals(that.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, that.funnel);
        this.bits.putAll(that.bits);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) object;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int expectedInsertions, double fpp) {
        return create(funnel, expectedInsertions, fpp);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long expectedInsertions, double fpp) {
        return create(funnel, expectedInsertions, fpp, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    static <T> BloomFilter<T> create(Funnel<? super T> funnel, long expectedInsertions, double fpp, Strategy strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(expectedInsertions >= 0, "Expected insertions (%s) must be >= 0", expectedInsertions);
        Preconditions.checkArgument(fpp > AudioStats.AUDIO_AMPLITUDE_NONE, "False positive probability (%s) must be > 0.0", Double.valueOf(fpp));
        Preconditions.checkArgument(fpp < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(fpp));
        Preconditions.checkNotNull(strategy);
        if (expectedInsertions == 0) {
            expectedInsertions = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(expectedInsertions, fpp);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(expectedInsertions, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int expectedInsertions) {
        return create(funnel, expectedInsertions);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long expectedInsertions) {
        return create(funnel, expectedInsertions, 0.03d);
    }

    static int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((m / n) * Math.log(2.0d)));
    }

    static long optimalNumOfBits(long n, double p) {
        if (p == AudioStats.AUDIO_AMPLITUDE_NONE) {
            p = Double.MIN_VALUE;
        }
        return (long) (((-n) * Math.log(p)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* loaded from: classes4.dex */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bf) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(((BloomFilter) bf).bits.data);
            this.numHashFunctions = ((BloomFilter) bf).numHashFunctions;
            this.funnel = ((BloomFilter) bf).funnel;
            this.strategy = ((BloomFilter) bf).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public void writeTo(OutputStream out) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i = 0; i < this.bits.data.length(); i++) {
            dataOutputStream.writeLong(this.bits.data.get(i));
        }
    }

    public static <T> BloomFilter<T> readFrom(InputStream in, Funnel<? super T> funnel) throws IOException {
        int i;
        int i2;
        DataInputStream dataInputStream;
        byte readByte;
        Preconditions.checkNotNull(in, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        int i3 = -1;
        try {
            try {
                dataInputStream = new DataInputStream(in);
                readByte = dataInputStream.readByte();
                try {
                    i2 = UnsignedBytes.toInt(dataInputStream.readByte());
                } catch (Exception e) {
                    e = e;
                    i2 = -1;
                    i3 = readByte;
                    i = -1;
                }
            } catch (Exception e2) {
                e = e2;
                i = -1;
                i2 = -1;
            }
            try {
                i3 = dataInputStream.readInt();
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                BloomFilterStrategies.LockFreeBitArray lockFreeBitArray = new BloomFilterStrategies.LockFreeBitArray(LongMath.checkedMultiply(i3, 64L));
                for (int i4 = 0; i4 < i3; i4++) {
                    lockFreeBitArray.putData(i4, dataInputStream.readLong());
                }
                return new BloomFilter<>(lockFreeBitArray, i2, funnel, bloomFilterStrategies);
            } catch (Exception e3) {
                e = e3;
                int i5 = i3;
                i3 = readByte;
                i = i5;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + i3 + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
        } catch (IOException e4) {
            throw e4;
        }
    }
}
