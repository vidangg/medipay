package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@DoNotMock("Use ImmutableClassToInstanceMap or MutableClassToInstanceMap")
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface ClassToInstanceMap<B> extends Map<Class<? extends B>, B> {
    @CheckForNull
    <T extends B> T getInstance(Class<T> type);

    @CheckForNull
    <T extends B> T putInstance(Class<T> type, @ParametricNullness T value);
}
