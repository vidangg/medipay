package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Atomics {
    private Atomics() {
    }

    public static <V> AtomicReference<V> newReference() {
        return new AtomicReference<>();
    }

    public static <V> AtomicReference<V> newReference(@ParametricNullness V initialValue) {
        return new AtomicReference<>(initialValue);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(int length) {
        return new AtomicReferenceArray<>(length);
    }

    public static <E> AtomicReferenceArray<E> newReferenceArray(E[] array) {
        return new AtomicReferenceArray<>(array);
    }
}
