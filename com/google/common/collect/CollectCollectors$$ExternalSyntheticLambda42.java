package com.google.common.collect;

import com.google.common.collect.CollectCollectors;
import java.util.function.BinaryOperator;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda42 implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((CollectCollectors.EnumMapAccumulator) obj).combine((CollectCollectors.EnumMapAccumulator) obj2);
    }
}
