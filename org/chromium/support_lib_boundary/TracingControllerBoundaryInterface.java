package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public interface TracingControllerBoundaryInterface {
    boolean isTracing();

    void start(int i, Collection<String> collection, int i2) throws IllegalStateException, IllegalArgumentException;

    boolean stop(OutputStream outputStream, Executor executor);
}
