package com.google.common.io;

import com.google.errorprone.annotations.DoNotMock;
import java.io.IOException;

@ElementTypesAreNonnullByDefault
@DoNotMock("Implement it normally")
/* loaded from: classes4.dex */
public interface ByteProcessor<T> {
    @ParametricNullness
    T getResult();

    boolean processBytes(byte[] buf, int off, int len) throws IOException;
}
