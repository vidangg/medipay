package com.google.common.math;

import androidx.camera.video.AudioStats;
import java.math.BigInteger;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class MathPreconditions {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkPositive(String role, int x) {
        if (x > 0) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long checkPositive(String role, long x) {
        if (x > 0) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger checkPositive(String role, BigInteger x) {
        if (x.signum() > 0) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkNonNegative(String role, int x) {
        if (x >= 0) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long checkNonNegative(String role, long x) {
        if (x >= 0) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger checkNonNegative(String role, BigInteger x) {
        if (x.signum() >= 0) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double checkNonNegative(String role, double x) {
        if (x >= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkRoundingUnnecessary(boolean condition) {
        if (!condition) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkInRangeForRoundingInputs(boolean condition, double input, RoundingMode mode) {
        if (condition) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + input + " and rounding mode " + mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNoOverflow(boolean condition, String methodName, int a, int b) {
        if (condition) {
            return;
        }
        throw new ArithmeticException("overflow: " + methodName + "(" + a + ", " + b + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNoOverflow(boolean condition, String methodName, long a, long b) {
        if (condition) {
            return;
        }
        throw new ArithmeticException("overflow: " + methodName + "(" + a + ", " + b + ")");
    }

    private MathPreconditions() {
    }
}
